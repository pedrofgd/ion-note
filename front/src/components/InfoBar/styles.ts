import styled from 'styled-components'

export const Container = styled.div`
   grid-area: IF;

   display: flex;
   justify-content: start;
   align-items: center;
   
   border-top: 1px solid;
   border-top-color: #d9d9d9;

   font-size: 13px;
   color: ${props => props.theme.colors.grey};

   padding-left: 11px;
`