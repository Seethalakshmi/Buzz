import {useSelector} from "react-redux";
import Login from "./components/Login";

function App({_useSelector=useSelector, LoginC=Login}) {
  const token = _useSelector(state => state.user.token)

  if (!token)
    return <LoginC/>
  else
    return <>
      You shall not pass
    </>
}

export default App;
