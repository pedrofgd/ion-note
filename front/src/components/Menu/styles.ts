import styled from 'styled-components'
import { Notes, Event } from 'styled-icons/material'
import { Checklist } from 'styled-icons/octicons'

import { Props } from '.'

export const Container = styled.div`
   grid-area: MN;

   display: flex;
   justify-content: center;
   align-items: center;

   padding: 11px;
`

export const MenuOption = styled.a`
   font-size: 16px;
   padding: 0 12px;

   cursor: pointer;
`

export const NotesIcon = styled(Notes)<Props>`
   width: 22px;
   height: 22px;

   color: ${(props) => (props.isActive ? props.theme.colors.grey : props.theme.colors.black)};

   transition: 10ms;

   :hover {
      opacity: 0.5;
   }
`

export const CalendarIcon = styled(Event)<Props>`
   width: 22px;
   height: 22px;

   color: ${(props) => (props.isActive ? props.theme.colors.grey : props.theme.colors.black)};

   transition: 10ms;

   :hover {
      opacity: 0.5;
   }
`

export const TasksIcon = styled(Checklist)<Props>`
   width: 20px;
   height: 20px;

   color: ${(props) => (props.isActive ? props.theme.colors.grey : props.theme.colors.black)};

   transition: 10ms;

   :hover {
      opacity: 0.5;
   }
`