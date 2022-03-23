import styled from 'styled-components'

import { Props } from '.'

// TL - note title
// DE - note description
// DT - note date

export const Container = styled.div<Props>`
   display: grid; 
   position: relative;

   grid-template-columns: 250px auto;
   grid-template-rows: auto auto;

   grid-template-areas:
      'TL TL'
      'DE DT';

   padding-bottom: 60px;

   &::before {
      width: 9px;
      height: 9px;

      position: absolute;
      left: -35px;
      top: calc(50% - 30px);

      background-color: ${props => props.theme.colors.grey};
      border-radius: 50%;

      content: '';
      display: ${(props) => (props.isActive ? 'inline' : 'none')};
   }
`

export const Title = styled.a`
   grid-area: TL;
   
   font-size: 26px;
   font-weight: 700;

   max-width: 250px;
   padding-bottom: 11px;
   text-decoration: none;
   color: ${props => props.theme.colors.text};
   transition: 0.2s;

   :hover {
      opacity: 0.8;
   }
`

export const Description = styled.span`
   grid-area: DE;

   font-size: 16px;
   color: ${props => props.theme.colors.grey};

   max-width: 250px;
`

export const CreationDate = styled.span`
   grid-area: DT;

   font-size: 14px;
   color: ${props => props.theme.colors.grey};

   padding-left: 11px;
`