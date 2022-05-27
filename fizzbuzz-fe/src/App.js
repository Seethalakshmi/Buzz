import {useSelector} from "react-redux";
import Login from "./components/Login";
import FizzBuzz from "./components/FizzBuzz";

function App({_useSelector=useSelector, LoginC=Login, FizzBuzzC=FizzBuzz}) {
  const token = _useSelector(state => state.user.token)

  if (!token)
    return <LoginC/>
  else
    return <FizzBuzzC/>
}

export default App;
