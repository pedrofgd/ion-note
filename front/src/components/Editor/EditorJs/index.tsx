import { useEffect } from 'react';
import EditorJS from '@editorjs/editorjs';

import { tools } from './config';

const EditorJs: React.FC = () => {
  const initEditor = () => {
    new EditorJS({
      holder: "editor",
      tools,
      // autofocus: true,
      data: {
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
    initEditor();
  }, []);


  return <div id={"editor"}></div>;
};

export default EditorJs;