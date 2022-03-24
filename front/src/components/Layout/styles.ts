import styled from 'styled-components'

// H - Header
// CF - Conigurations
// MV - Main view
// SV - Secoundary view
// IF - Informations

export const Grid = styled.div`
  display: grid;
  
  grid-template-columns: auto 350px;
  grid-template-rows: 60px auto 30px;

  grid-template-areas:
    'H  CF'
    'MV SV'
    'IF SV';

  height: 100vh;
`