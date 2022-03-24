import styled from 'styled-components'

// LG - Logo
// SC - Search field
// SV - Saving button
// MN - Menu

export const Container = styled.div`
   grid-area: H;

   display: grid;
   grid-template-columns: auto 2fr 1.5fr auto;
   grid-template-rows: auto;
   grid-gap: 7px;

   grid-template-areas: 
      'LG SC SV MN';

   align-items: center;
   justify-content: space-between;
   text-align: center;

   padding: 0 24px;
   border-bottom: 1px solid;
   border-bottom-color: #D9D9D9;
`