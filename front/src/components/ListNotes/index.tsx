import React, { useEffect, useState } from 'react'

import { Container } from "./styles"

import Button from "../Button"
import NoteItem from "../NoteItem"

import { notes } from '../../utils/notes'

const ListNotes: React.FC = () => {
   const [notes, setNotes] = useState([{
      id: 1,
      title: 'note 1',
      description: 'bla bla bla lba bla',
      content: {
         blocks: [
           {
             "id" : "871FOkhg8e",
             "type" : "header",
             "data" : {
                 "level" : 1
             }
           },
           {
             "id" : "871FOkhg8e",
             "type" : "header",
             "data" : {
                 "level" : 2
             }
           },
           {
             "id" : "871FOkhg8e",
             "type" : "paragraph",
             "data" : {
                 "text": ""
             }
           },
         ]
      }
   },
   {
      id: 1,
      title: 'note 1',
      description: 'bla bla bla lba bla',
      content: {
         blocks: [
           {
             "id" : "871FOkhg8e",
             "type" : "header",
             "data" : {
                 "level" : 1
             }
           },
           {
             "id" : "871FOkhg8e",
             "type" : "header",
             "data" : {
                 "level" : 2
             }
           },
           {
             "id" : "871FOkhg8e",
             "type" : "paragraph",
             "data" : {
                 "text": ""
             }
           },
         ]
      }
   }]);

   return (
      <Container>

         {/* TODO criar nota (esse botão deve salvar o que estiver lá e setar o EditorJs com os dados vazios) */}
         <Button text="+ criar nota" />

         {/* TODO navegação das notas (atualizar o EditorJs com os dados da nota e marcar como isActive) */}
         {notes.map(note => (
            <NoteItem
               key={note.title} 
               title="note 1" 
               description="description" 
               date="22/03/2022" 
            />
         ))}
         
      </Container>
   );
}

export default ListNotes;