import React, { createContext, ReactNode, useState, useContext } from 'react';

const NoteContext = createContext(undefined);

export type Props = {
   children: ReactNode;
}

export default function NoteProvider(props: Props) {
   const { children } = props;
   const [data, setData] = useState(null);
   const [notesList, setNotesList] = useState({});
   const [saveNote, setSaveNote] = useState(false);
   const [noteContent, setNoteContent] = useState({});

   return (
      <NoteContext.Provider value={{
         data,
         setData,
         notesList,
         setNotesList,
         saveNote, 
         setSaveNote,
         noteContent, 
         setNoteContent
      }}>
         {children}
      </NoteContext.Provider>
   )
}

export function useNote() {
   const context = useContext(NoteContext);
   const { 
      data, 
      setData,
      notesList,
      setNotesList,
      saveNote, 
      setSaveNote,
      noteContent, 
      setNoteContent
   } = context;

   return { 
      data, 
      setData,
      notesList,
      setNotesList,
      saveNote, 
      setSaveNote,
      noteContent, 
      setNoteContent
   };
}
