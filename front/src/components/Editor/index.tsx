import React from 'react'
import dynamic from 'next/dynamic'

import QuillEditor from './QuillEditor'
import ListTasks from "../ListTasks";

import { Area, Container } from './styles'

const EditorJs = dynamic(() => import("./EditorJs"),{ ssr: false });

const Editor: React.FC = () => {
   return (
      <Container>
         <Area>
            <EditorJs />
            {/* <QuillEditor /> */}
         </Area>

         {/* TODO passar ListTasks para o Layout e ajustar CSS para ficar na mesma posicao */}
         {/* <ListTasks />  */}
      </Container>
   )
}

export default Editor