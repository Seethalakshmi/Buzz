import {Button, Form} from "react-bootstrap";
import {useDispatch, useSelector} from "react-redux";
import {LOGIN_START, UPDATE_CREDENTIALS} from "../modules/user";

export default function Login({_useSelector=useSelector, _useDispatch=useDispatch}) {
    const credentials = _useSelector(state => state.credentials)
    const dispatch = _useDispatch()

    function updateUsername(username) {
        dispatch({type: UPDATE_CREDENTIALS, payload: {...credentials, username}})
    }

    function updatePassword(password) {
        dispatch({type: UPDATE_CREDENTIALS, payload: {...credentials, password}})
    }

    function handleSubmit(event) {
        event.preventDefault()
        dispatch({type: LOGIN_START})
    }

    return <Form onSubmit={handleSubmit}>
        <Form.Control placeholder='Username' onChange={e => updateUsername(e.target.value)}/>
        <Form.Control placeholder='Password' onChange={e => updatePassword(e.target.value)}/>
        <Button type='submit'>Login</Button>
    </Form>
}