import React from 'react';
import { Container, CreationDate, Description, Title } from './styles';

import { useNote } from "../../context/Note";

export interface Props {
   title: string;
   description: string;
   date: string;
   isActive?: boolean;
   content?: any;
}

const NoteItem: React.FC<Props> = ({
   title,
   description,
   date,
   isActive,
   content
}) => {
   // TODO alterar nome para setNoteContent (ou algo melhor)
   const { data, setData } = useNote();

   function selectNote(content: any) {
      setData(content);
   }

   return (
      <Container 
         title={title}
         description={description}
         date={date}
         isActive={isActive}
      >      
         <Title onClick={() => selectNote(content)}>
            {title}
         </Title>
         <Description>{description}</Description>
         <CreationDate>{date}</CreationDate>
      </Container>
   )
}

export default NoteItem;