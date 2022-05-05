import { useEffect } from 'react';
import EditorJS from '@editorjs/editorjs';

import { tools } from './config';
import { useNote } from "../../../context/Note";

const EditorJs: React.FC = () => {
  const { data } = useNote();

  const initEditor = () => {
    new EditorJS({
      holder: "editor",
      tools,
      // autofocus: true,
      data: data ?? {
        blocks: [
          {
            "id" : "871FOkhg8e",
            "type" : "header",
            "data" : {
                "level" : 1
            }
          },
          {
            "id" : "871FOkhg8e",
            "type" : "header",
            "data" : {
                "level" : 2
            }
          },
          {
            "id" : "871FOkhg8e",
            "type" : "paragraph",
            "data" : {
                "text": ""
            }
          },
        ]
      }
    });
  }

  useEffect(() => {
    var content = document.getElementById('editor');
    if (content !== null)
      content.innerHTML = "";
    
    initEditor();
  }, [data]);

  return <div id={"editor"}></div>;
};

export default EditorJs;