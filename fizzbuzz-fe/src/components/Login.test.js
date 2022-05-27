import {render, screen} from "@testing-library/react";
import Login from "./Login";
import userEvent from "@testing-library/user-event";
import {LOGIN_START, UPDATE_CREDENTIALS} from "../modules/user";

it('should show username and password field', () => {
    render(<Login _useSelector={() => {}} _useDispatch={() => {}}/>)
    expect(screen.getByPlaceholderText('Username')).toBeInTheDocument()
    expect(screen.getByPlaceholderText('Password')).toBeInTheDocument()
})

it('should update username when user types in username box', () => {
    const dispatch = jest.fn()
    const password = 'some password'
    const state = {credentials: {username: '', password}}
    render(<Login _useSelector={fn => fn(state)} _useDispatch={()=>dispatch}/>)
    const usernameElement = screen.getByPlaceholderText('Username')
    const username = 'some username'
    userEvent.type(usernameElement, username)
    expect(dispatch).toHaveBeenCalledWith({type: UPDATE_CREDENTIALS, payload: {username, password}})
})

it('should update password when user types in password box', () => {
    const dispatch = jest.fn()
    const username = 'some username'
    const state = {credentials: {username, password: ''}}
    render(<Login _useSelector={fn => fn(state)} _useDispatch={()=>dispatch}/>)
    const passwordElement = screen.getByPlaceholderText('Password')
    const password = 'some password'
    userEvent.type(passwordElement, password)
    expect(dispatch).toHaveBeenCalledWith({type: UPDATE_CREDENTIALS, payload: {username, password}})
})

it('should dispatch LOGIN_START when user clicks login', () => {
    const dispatch = jest.fn()
    render(<Login _useSelector={() => {}} _useDispatch={() => dispatch}/>)
    userEvent.click(screen.getByText('Login'))
    expect(dispatch).toHaveBeenCalledWith({type: LOGIN_START})
})