import styled from 'styled-components'

export const Container = styled.div`
   grid-area: MV;

   position: relative;

   /* display: flex; */
   /* align-items: center; */
   /* justify-content: center; */
   max-height: 100vh;

   overflow-y: scroll;
   overflow-x: hidden;
   ::-webkit-scrollbar {
      display: none;
   }
`

export const Area = styled.div`
   /* max-width: 400px; */
   /* position: absolute;
   background-color: green;
   margin-left: 60px; */
`