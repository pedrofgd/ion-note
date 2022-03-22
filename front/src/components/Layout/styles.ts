import styled from 'styled-components'

// MV - Main view
// SV - Secoundary view

export const Grid = styled.div`
  display: grid;

  grid-template-columns: auto 400px;
  grid-template-rows: auto;

  grid-template-areas:
    'MV SV';

  height: 100vh;
`