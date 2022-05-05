import React from 'react';
import { Container, CreateButton, Input } from './styles';

const CreateNote: React.FC = () => {
   return (
      <Container>
         {/* TODO implementar criação de tarefas (remover o botão e deixar esse comp direto) */}
         <span>implementar criação de notas</span>
         {/* <Input>Tarefa</Input> */}
         <CreateButton />

      </Container>
   )
}

export default CreateNote;