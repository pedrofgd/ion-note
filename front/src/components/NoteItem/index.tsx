import React from 'react';
import { Container, CreationDate, Description, Title } from './styles';

export interface Props {
   title: string;
   description: string;
   date: string;
   isActive?: boolean;
}

const NoteItem: React.FC<Props> = ({
   title,
   description,
   date,
   isActive
}) => {
   return (
      <Container 
         title={title}
         description={description}
         date={date}
         isActive={isActive}>
         <Title href="">{title}</Title>
         <Description>{description}</Description>
         <CreationDate>{date}</CreationDate>
      </Container>
   )
}

export default NoteItem;