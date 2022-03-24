import { EditorConfig } from "@editorjs/editorjs";

export type EditorData = EditorConfig["data"];

export type EditorTools = EditorConfig["tools"];

export type EditorTunes = EditorConfig["tunes"];

export interface EditorProps {
  data: EditorData;
}