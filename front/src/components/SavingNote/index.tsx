import React from 'react'
import { Container, SyncIcon, SaveIcon, ClickButton, Text } from './styles'

import { useNote } from '../../context/Note'

import api from '../../services/api'

const SavingNote: React.FC = () => {
   const { setData, noteContent, setNotesList } = useNote();
   
   
   function save() {
      const title = noteContent.blocks[0].data.text
      const subtitle = noteContent.blocks[1].data.text
      const description = noteContent.blocks[1].data.text;
      const content = noteContent;

      api.post('note/create', {
         title,
         subtitle,
         description,
         content
      }).then(() => {
         alert('Nota salva com sucesso')
         setData(content)
         setNotesList(null) // TODO: recurso temporario para atualizar a lista de notas
      })
   }

   return (
      <Container>
         {/* TODO Impl botão para salvar nota (não vai ser automatico por enquanto) */}
         {/* <SyncIcon /> */}
         {/* <Text>Saving note</Text> */}

         <ClickButton onClick={() => {
            save()
         }}>
            <SaveIcon />
            <Text>Save note</Text>
         </ClickButton>

      </Container>
   )
}

export default SavingNote