import styled from 'styled-components'

export const Container = styled.button`
   display: flex;
   align-items: center;
   justify-content: center;
   flex-shrink: 0;

   width: 100%;
   height: 45px;
   border-radius: 5px;
   background-color: ${props => props.theme.colors.button};
   border: none;

   position: relative;
   cursor: pointer;
   transition: 0.3s;

   margin-bottom: 40px;

   :hover {
      background-color: ${props => props.theme.colors.buttonOpacity}; 
      color: ${props => props.theme.colors.black}

   }
`

export const Text = styled.span`
   font-size: 16px;
   font-weight: bold;
`