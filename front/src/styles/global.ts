import { createGlobalStyle } from 'styled-components'

export default createGlobalStyle`
  * {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
  }

  body {
    background: ${props => props.theme.colors.background};
    color: ${props => props.theme.colors.text};
    font: 400 16px Roboto, sans-serif;
  }

  h1 {
    font-size: 54px;
    color: ${props => props.theme.colors.primary};
    margin-top: 40px;
  }

  ::-webkit-scrollbar {
    display: none;
  }
`
