export const FIZZ_START = 'fizzbuzz/fizzbuzz/FIZZ_START'
export const FIZZ_SUCCESS = 'fizzbuzz/fizzbuzz/FIZZ_SUCCESS'
export const FIZZ_FAILURE = 'fizzbuzz/fizzbuzz/FIZZ_FAILURE'

const initialState = {
    result: '',
    pending: false
}

export default function reducer(state = initialState, action) {
    switch (action?.type) {
        case FIZZ_START:
            return {
                ...state,
                pending: true
            }

        case FIZZ_SUCCESS:
            return {
                ...state,
                pending: false,
                result: action.payload
            }

        case FIZZ_FAILURE:
            return {
                ...state,
                pending: false
            }

        default:
            return {...state}
    }
}

export function initiateFizz(token, input, _fetch=fetch) {
    return async function sideEffect(dispatch) {
        dispatch({type: FIZZ_START})
        const url = `http://localhost:8080/fizzbuzz?token=${token}&input=${input}`
        const response = await _fetch(url)

        if (response.ok) {
            const result = await response.json()
            dispatch({type: FIZZ_SUCCESS, payload: result})
        }
    }
}