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
         <ListTasks />
      </Container>
   )
}

export default Editor