import styled from 'styled-components'

// H - Header
// MV - Main view
// SV - Secoundary view

export const Grid = styled.div`
  display: grid;

  grid-template-columns: auto 400px;
  grid-template-rows: 60px auto;

  grid-template-areas:
    'H SV'
    'MV SV';

  height: 100vh;
`