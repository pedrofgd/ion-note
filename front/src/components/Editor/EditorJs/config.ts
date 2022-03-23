import { EditorTools, EditorTunes } from "./types";

import Header from "@editorjs/header";
import Paragraph from "@editorjs/paragraph";
import Checklist from "@editorjs/checklist";
import InlineCode from "@editorjs/inline-code";
import Delimiter from "@editorjs/delimiter";
import Alert from "editorjs-alert";
import Alignment from "editorjs-text-alignment-blocktune";
import NestedList from "@editorjs/nested-list";
import Image from "@editorjs/image";
import Link from "@editorjs/link";
import Attachment from "@editorjs/attaches";
import Embed from "@editorjs/embed";
import Table from "@editorjs/table";
import Marker from "@editorjs/marker";
import Underline from "@editorjs/underline";
import Hyperlink from "editorjs-hyperlink";
import ChangeCase from "editorjs-change-case";

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
  delimiter: {
    class: Delimiter,
    tunes: [],
  },
  alert: {
    class: Alert,
    inlineToolbar: true,
    shortcut: "CMD+SHIFT+A",
  },
  alignment: Alignment,
  list: {
    class: NestedList,
    inlineToolbar: true,
    tunes: [],
  },
  image: {
    class: Image,
    config: {
      endpoints: {
        // TODO: https://github.com/editor-js/image
        byFile: "http://localhost:8008/uploadFile", // Your backend file uploader endpoint
        byUrl: "http://localhost:8008/fetchUrl", // Your endpoint that provides uploading by Url
        captionPlaceholder: "describe your image",
      },
    },
  },
  link: {
    class: Link,
    config: {
      // TODO: https://github.com/editor-js/link
      endpoint: "http://localhost:8008/fetchUrl", // Your backend endpoint for url data fetching,
    },
    tunes: [],
  },
  attachment: {
    class: Attachment,
    config: {
      // TODO: https://github.com/editor-js/attaches
      endpoint: "http://localhost:8008/uploadFile",
    },
    tunes: [],
  },
  embed: Embed,
  table: {
    class: Table,
    inlineToolbar: true,
    config: {
      rows: 2,
      cols: 3,
    },
  },
  marker: {
    class: Marker,
    shortcut: "CMD+SHIFT+M",
  },
  underline: Underline,
  hyperlink: {
    class: Hyperlink,
    config: {
      shortcut: "CMD+L",
      target: "_blank",
      rel: "nofollow noreferrer",
      availableTargets: [],
      availableRels: [],
      validate: true,
    },
  },
  changeCase: {
    class: ChangeCase,
    config: {
      showLocaleOption: true, // enable locale case options
      locale: "br", // or ['tr', 'TR', 'tr-TR']
    },
  },
};

export const tunes: EditorTunes = ["alignment"];