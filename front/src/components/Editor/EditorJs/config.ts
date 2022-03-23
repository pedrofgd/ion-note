import { EditorTools, EditorTunes } from "./types";

import Header from "@editorjs/header";
import Paragraph from "@editorjs/paragraph";
import Checklist from "@editorjs/checklist";
import InlineCode from "@editorjs/inline-code";

export const tools: EditorTools = {
  paragraph: {
    class: Paragraph,
    inlineToolbar: true,
    config: {
      preserveBlank: true, /* save lines with only white space */
      placeholder: 'Your note goes here'
    }
  },
  header: {
    class: Header,
    shortcut: "CMD+SHIFT+H",
    config: {
      placeholder: 'Enter your text here',
      levels: [1, 2, 3, 4],
      defaultLevel: 1
    }
  },
  checklist: {
    class: Checklist,
    inlineToolbar: true,
    tunes: [],
  },
  inlineCode: {
    class: InlineCode,
    shortcut: "CMD+SHIFT+M",
  },
};

export const tunes: EditorTunes = ["alignment"];