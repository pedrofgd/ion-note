import styled from 'styled-components'
import { Settings } from 'styled-icons/material'

export const Container = styled.div`
   grid-area: CF;

   display: flex;
   justify-content: end;
   align-items: center;

   border-left: 1px solid;
   border-left-color: #D9D9D9;
   border-bottom: 1px solid;
   border-bottom-color: #D9D9D9;

   padding: 0 24px;
`

export const Actions = styled.div`
   display: flex;
   justify-content: space-between;
   align-items: center;

   width: 70px;
`

export const ConfigurationIcon = styled(Settings)`
   width: 24px;
   height: 24px;
   transition: 10ms;

   :hover {
      opacity: 0.7;
   }
`

export const Profile = styled.div`
   display: flex;
   width: 30px;
   height: 30px;
   border-radius: 11px;
   background-color: blue;
`