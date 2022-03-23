import React from 'react'
import dynamic from 'next/dynamic'

import QuillEditor from './QuillEditor'

import { Container } from './styles'

const EditorJs = dynamic(() => import("./EditorJs"),{ ssr: false });

const Editor: React.FC = () => {
   return (
      <Container>
         <EditorJs />
         {/* <QuillEditor /> */}
      </Container>
   )
}

export default Editor