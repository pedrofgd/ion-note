import React from 'react'

import { Container, Separator, SessionTitle } from "./styles"

import Button from "../Button"
import TaskItem from "../TaskItem"
import CreateTask from '../CreateTask'

const ListTasks: React.FC = () => {
   return (
      <Container>
         <Button text="+ criar tarefa" />
         <CreateTask />

         <SessionTitle>Pendentes</SessionTitle>
         <TaskItem task="finalizar o front" date="25/03/22" completed={false} />
         <TaskItem task="analisador léxico (finalizar até sábado)" date="25/03/22" completed={false} />
         <TaskItem task="trabalho grafos" date="25/03/22" completed={false} />

         <Separator />

         <SessionTitle>Completadas</SessionTitle>
         <TaskItem task="Trabalho metodologia de pesquisa" date="25/03/22" completed={true} />
         <TaskItem task="Trabalho metodologia de pesquisa" date="25/03/22" completed={true} />
         <TaskItem task="Trabalho metodologia de pesquisa" date="25/03/22" completed={true} />
         <TaskItem task="Trabalho metodologia de pesquisa" date="25/03/22" completed={true} />
         <TaskItem task="Trabalho metodologia de pesquisa" date="25/03/22" completed={true} />
         
      </Container>
   );
}

export default ListTasks;