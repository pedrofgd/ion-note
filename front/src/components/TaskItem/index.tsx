import React from 'react';
import { CheckItem, Container, TaskArea, Title } from './styles';

export interface Props {
   task: string;
   date: string;
   completed: boolean;
}

const TaskItem: React.FC<Props> = ({
   task,
   date,
   completed
}) => {
   return (
      <Container 
         task={task}
         date={date}
         completed={completed}
      >
         <CheckItem />

         <TaskArea>
            {/* TODO marcar tarefa como completed, alterar o ícone e enviar para a outra lista */}
            <Title task={task} date={date} completed={completed}>{task}</Title>
         </TaskArea>
      </Container>
   )
}

export default TaskItem;