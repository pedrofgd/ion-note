import React from 'react'

import { CalendarIcon, Container, MenuOption, NotesIcon, TasksIcon } from './styles'

import { useMenu } from '../../context/Menu'

export interface Props {
   isActive?: boolean;
}

const Menu: React.FC<Props> = ({
   isActive
}) => {
   const { option, setOption } = useMenu();

   return (
      <Container>
         <MenuOption onClick={() => {setOption("editor")}}>
            <NotesIcon isActive={option === "editor" ? true : false} />
         </MenuOption>
         
         <MenuOption onClick={() => {setOption("calendar")}}>
            <CalendarIcon isActive={option === "calendar" ? true : false} />
         </MenuOption>

         {/* TODO toggle do botão de tarefas */}
         <MenuOption href=""><TasksIcon /></MenuOption>
      </Container>
   )
}

export default Menu