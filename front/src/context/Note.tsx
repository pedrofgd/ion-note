import React, { createContext, ReactNode, useState, useContext } from 'react';

const NoteContext = createContext(undefined);

export type Props = {
   children: ReactNode;
}

export default function NoteProvider(props: Props) {
   const { children } = props;
   const [data, setData] = useState(null);
   const [createNoteActive, setCreateNoteActive] = useState(false);

   return (
      <NoteContext.Provider value={{
         data,
         setData,
         createNoteActive,
         setCreateNoteActive
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
      createNoteActive,
      setCreateNoteActive
   } = context;

   return { 
      data, 
      setData,
      createNoteActive,
      setCreateNoteActive
   };
}
