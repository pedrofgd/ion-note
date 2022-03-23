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

export const MenuOption = styled.a<Props>`
   font-size: 16px;
   padding: 0 12px;

   text-decoration: ${(props) => (props.isActive ? 'underline' : 'none')};
   color: ${props => props.theme.colors.black};
`

export const NotesIcon = styled(Notes)`
   width: 22px;
   height: 22px;

   color: ${props => props.theme.colors.black};

   transition: 10ms;

   :hover {
      opacity: 0.7;
   }
`

export const CalendarIcon = styled(Event)`
   width: 22px;
   height: 22px;

   color: ${props => props.theme.colors.black};

   transition: 10ms;

   :hover {
      opacity: 0.7;
   }
`

export const TasksIcon = styled(Checklist)`
   width: 20px;
   height: 20px;

   color: ${props => props.theme.colors.black};

   transition: 10ms;

   :hover {
      opacity: 0.7;
   }
`