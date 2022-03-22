import styled from 'styled-components'

export const Container = styled.button`
   display: flex;
   align-items: center;
   justify-content: center;
   flex-shrink: 0;

   width: 100%;
   height: 40px;
   border-radius: 5px;
   background-color: ${props => props.theme.colors.button};
   border: 1px solid;

   position: relative;
   cursor: pointer;

   margin-bottom: 40px;
`

export const Text = styled.span`
   font-size: 16px;
   font-weight: bold;
`