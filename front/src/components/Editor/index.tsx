import React from 'react'
import dynamic from 'next/dynamic'

import QuillEditor from './QuillEditor'
import ListTasks from "../ListTasks";

import { Area, Container } from './styles'
import { useMenu } from '../../context/Menu';

const EditorJs = dynamic(() => import("./EditorJs"),{ ssr: false });

const Editor: React.FC = () => {
   const { showTasks } = useMenu();

   return (
      <Container>
         <Area>
            <EditorJs />
            {/* <QuillEditor /> */}
         </Area>

         {/* TODO Repassar isso para o layout e posicionar o elemento corretamente com CSS */}
         {showTasks == true ? <ListTasks /> : <></>}
      </Container>
   )
}

export default Editor