import styled from 'styled-components'

// H - Header
// CF - Conigurations
// MV - Main view
// SV - Secoundary view

export const Grid = styled.div`
  display: grid;

  grid-template-columns: auto 380px;
  grid-template-rows: 60px auto;

  grid-template-areas:
    'H CF'
    'MV SV';

  height: 100vh;
`