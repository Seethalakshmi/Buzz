import { render, screen } from '@testing-library/react';
import App from './App';

it('should show the login compoenent when not logged in', () => {
  const state = {isLoggedIn: false}
  const expectedText = 'some text here'
  const mock = () => <>{expectedText}</>
  render(<App _useSelector={fn => fn(state)} LoginC={mock}/>)
  expect(screen.getByText(expectedText)).toBeInTheDocument()
})

it('should not show the login compoenent when logged in', () => {
  const state = {isLoggedIn: true}
  const expectedText = 'some text here'
  const mock = () => <>{expectedText}</>
  render(<App _useSelector={fn => fn(state)} LoginC={mock}/>)
  expect(screen.queryByText(expectedText)).not.toBeInTheDocument()
})
