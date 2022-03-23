import { EditorTools, EditorTunes } from "./types";

import Header from "@editorjs/header";
import Checklist from "@editorjs/checklist";
import InlineCode from "@editorjs/inline-code";

export const tools: EditorTools = {
  header: {
    class: Header,
    shortcut: "CMD+SHIFT+H",
    config: {
      defaultLevel: 1,
    },
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