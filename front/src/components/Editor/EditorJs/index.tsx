import { useEffect, useRef } from "react";
import EditorJS, { EditorConfig } from "@editorjs/editorjs";

import { EditorProps } from "./types";
import { tools, tunes } from "./config";

const EditorJs: React.FC<EditorProps> = ({
  data,
}) => {
  const $editorJS = useRef<EditorJS>(null);

  useEffect(() => {
    // mount
    if (!$editorJS.current) {
      initEditorJS();
    }

    // destroy
    return () => {
      $editorJS.current?.destroy();
      $editorJS.current = null;
    };
  }, []);

  function initEditorJS() {
    const editorJS = new EditorJS({
      holder: 'editorjs',
      tools,
      data
    });
  }

  return <div id={'editorjs'}></div>;
};

export default EditorJs;