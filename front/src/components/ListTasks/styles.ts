import styled from 'styled-components'

export const Container = styled.div`
   position: absolute;
   top: 3.5px;
   right: 3.5px;
   z-index: 2;
   height: 75vh;
   width: 350px;

   display: flex;
   flex-direction: column;
   align-items: start;
   
   background-color: ${props => props.theme.colors.background};
   border: 1px solid;
   border-color: #D9D9D9;
   border-top-left-radius: 5px;
   border-top-right-radius: 5px;
   border-bottom-left-radius: 5px;
   border-bottom-right-radius: 5px;
   padding: 30px 20px;

   box-shadow: rgba(100, 100, 111, 0.2) 0px 7px 29px 0px;

   max-height: 100vh;

   overflow-y: scroll;
   ::-webkit-scrollbar {
      display: none;
   }
`

export const SessionTitle = styled.span`
   font-size: 18px;
   font-weight: 500;

   padding-bottom: 16px;
`

export const Separator = styled.div`
   padding-bottom: 50px;
`