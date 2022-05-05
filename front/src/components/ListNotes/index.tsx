import React, { useEffect, useState } from 'react'

import { Container } from "./styles"

import Button from "../Button"
import NoteItem from "../NoteItem"

import { notes } from '../../utils/notes'

import api from '../../services/api'

const ListNotes: React.FC = () => {
   const [notes, setNotes] = useState([]);

   useEffect(() => {
      api.get('note', {}).then(response => {
            setNotes(response.data.data);
         });
   }, [])

   return (
      <Container>

         {/* TODO criar nota (esse botão deve salvar o que estiver lá e setar o EditorJs com os dados vazios) */}
         <Button text="+ criar nota" />

         {/* TODO navegação das notas (atualizar o EditorJs com os dados da nota e marcar como isActive) */}
         {notes.map(note => (
            <NoteItem
               key={note.title} 
               title={note.title}
               description={note.description}
               date="22/03/2022" // TODO utilizar data do objeto
               content={note.content}
            />
         ))}
         
      </Container>
   );
}

export default ListNotes;