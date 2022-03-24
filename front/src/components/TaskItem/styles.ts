import styled from 'styled-components'
import { CheckBoxOutlineBlank } from 'styled-icons/material'

import { Props } from '.'

// TL - note title
// DE - note description
// DT - note date

export const Container = styled.div<Props>`
   display: flex;
   justify-content: start;
   align-items: center;

   padding-bottom: 12px;
`

export const CheckItem = styled(CheckBoxOutlineBlank)`
   width: 28px;
   height: 28px;
   padding-right: 5px;
   color: ${props => props.theme.colors.grey};
   transition: 20ms;

   cursor: pointer;
   :hover {
      opacity: 0.6
   }
`

export const TaskArea = styled.div`

`

export const Title = styled.span<Props>`
   font-size: 17px;
   font-weight: 400;

   max-width: 200px;
   text-decoration: ${props => props.completed ? 'line-through' : 'none'};
   color: ${props => props.completed ? props.theme.colors.grey : props.theme.colors.text};
`