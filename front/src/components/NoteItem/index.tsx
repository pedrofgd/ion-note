import React from 'react';
import { Container, CreationDate, Description, Title } from './styles';

export interface Props {
   title: string;
   description: string;
   date: string;
}

const NoteItem: React.FC<Props> = ({
   title,
   description,
   date
}) => {
   return (
      <Container>
         <Title>{title}</Title>
         <Description>{description}</Description>
         <CreationDate>{date}</CreationDate>
      </Container>
   )
}

export default NoteItem;