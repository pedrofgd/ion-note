import React from 'react'

import { Container } from "./styles"

import Button from "../Button"
import NoteItem from "../NoteItem"

const ListNotes: React.FC = () => {
   return (
      <Container>

         {/* TODO criar nota (esse botão deve só setar o EditorJs com os dados vazios) */}
         <Button text="+ criar nota" />

         {/* TODO navegação das notas (atualizar o EditorJs com os dados da nota e marcar como isActive) */}
         <NoteItem isActive={true} title="note 1" description="description about yesterday class, that was pretty difficult" date="22/03/2022" />
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