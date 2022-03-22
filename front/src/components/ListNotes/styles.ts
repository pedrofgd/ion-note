import styled from 'styled-components'

export const Container = styled.div`
   grid-area: SV;

   display: flex;
   flex-direction: column;
   align-items: center;
   
   background-color: ${props => props.theme.colors.backSecoundary};
   border-left: 1px solid;
   border-left-color: #D9D9D9;
   padding: 60px 15px;

   max-height: 100vh;
   overflow-y: scroll;

   ::-webkit-scrollbar {
      display: none;
   }
`