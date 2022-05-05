import React, { createContext, ReactNode, useState, useContext } from 'react';

const NoteContext = createContext(undefined);

export type Props = {
   children: ReactNode;
}

export default function NoteProvider(props: Props) {
   const { children } = props;
   const [data, setData] = useState(null);

   return (
      <NoteContext.Provider value={{
         data,
         setData
      }}>
         {children}
      </NoteContext.Provider>
   )
}

export function useNote() {
   const context = useContext(NoteContext);
   const { data, setData } = context;
   return { data, setData };
}
