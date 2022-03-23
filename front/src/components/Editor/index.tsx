import React, { useRef } from 'react'
import dynamic from 'next/dynamic'

import QuillEditor from './QuillEditor'

import { Container } from './styles'
import { EditorData } from './EditorJs/types';

const EditorJs = dynamic(
   () => import("./EditorJs").then((i) => i.default),
   // { ssr: false }
 );

const Editor: React.FC = () => {
   const data = useRef<EditorData>(null);

   return (
      <Container>
         <EditorJs data={data.current} />
         {/* <QuillEditor /> */}
      </Container>
   )
}

export default Editor