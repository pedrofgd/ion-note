import React from 'react'
import { Container, SyncIcon, SaveIcon, ClickButton, Text } from './styles'

import { useNote } from '../../context/Note'

const SavingNote: React.FC = () => {
   const { setSaveNote } = useNote();

   return (
      <Container>
         {/* TODO Impl botão para salvar nota (não vai ser automatico por enquanto) */}
         {/* <SyncIcon /> */}
         {/* <Text>Saving note</Text> */}

         <ClickButton onClick={() => {
            alert("Ok");
            setSaveNote(true);
         }}>
            <SaveIcon />
            <Text>Save note</Text>
         </ClickButton>

      </Container>
   )
}

export default SavingNote