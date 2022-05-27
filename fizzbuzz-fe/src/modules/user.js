// Actions
export const LOGIN_START = 'fizzbuzz/user/LOGIN_START'
export const LOGIN_SUCCESS = 'fizzbuzz/user/LOGIN_SUCCESS'
export const LOGIN_FAILURE = 'fizzbuzz/user/LOGIN_FAILURE'
export const UPDATE_CREDENTIALS = 'fizzbuzz/user/UPDATE_CREDENTIALS'
export const LOGOUT = 'fizzbuzz/user/LOGOUT'

// InitialState
const initialState = {
    isLoggedIn: false,
    loginPending: false,
    credentials: {username: '', password: ''}
}

// Reducer
export default function reducer(state = initialState, action) {
    switch (action?.type) {
        case LOGIN_START:
            return {
                ...state,
                loginPending: true
            }

        case LOGIN_SUCCESS:
            return {
                ...state,
                isLoggedIn: true,
                loginPending: false
            }

        case LOGIN_FAILURE:
            return {
                ...state,
                loginPending: false
            }

        case UPDATE_CREDENTIALS:
            return {
                ...state,
                credentials: {
                    username: action.payload.username,
                    password: action.payload.password
                }
            }

        case LOGOUT:
            return {
                ...state,
                isLoggedIn: false,
                credentials: {
                    username: '',
                    password: ''
                }
            }

        default:
            return {...state}
    }
}

// Side Effects
export function initiateLogin(_fetch=fetch) {
    return async function sideEffect(dispatch, getState) {
        dispatch({type: LOGIN_START})
        const {username, password} = getState().credentials
        const url = `http://localhost:8081/login?username=${username}&password=${password}`
        const response = await _fetch(url)

        if (response.ok) {}
            // do nothing
        else
            dispatch({type: LOGIN_FAILURE})
    }
}