import React from 'react'

import { Container } from "./styles"

import Button from "../Button"
import NoteItem from "../NoteItem"

const ListNotes: React.FC = () => {
   return (
      <Container>

         <Button text="+ new note" />
         {/* <Separator /> */}
         <NoteItem title="note 1" description="description about yesterday class, that was pretty difficult" date="22/03/2022" />
         <NoteItem title="TG 06N - grafos hamiltonianos" description="description 1" date="22/03/2022" />
         <NoteItem title="compiladores 06N - análise léxica" description="Aula 03 - Mini analisador léxico" date="22/03/2022" />
         <NoteItem title="compiladores 06N - análise léxica" description="Aula 03 - Mini analisador léxico" date="22/03/2022" />
         <NoteItem title="compiladores 06N - análise léxica" description="Aula 03 - Mini analisador léxico" date="22/03/2022" />
         <NoteItem title="compiladores 06N - análise léxica" description="Aula 03 - Mini analisador léxico" date="22/03/2022" />
         <NoteItem title="compiladores 06N - análise léxica" description="Aula 03 - Mini analisador léxico" date="22/03/2022" />
         <NoteItem title="compiladores 06N - análise léxica" description="Aula 03 - Mini analisador léxico" date="22/03/2022" />
         <NoteItem title="compiladores 06N - análise léxica" description="Aula 03 - Mini analisador léxico" date="22/03/2022" />
         
      </Container>
   );
}

export default ListNotes;