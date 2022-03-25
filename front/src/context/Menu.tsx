import React, { ReactNode, createContext, useState, useContext } from 'react'

const MenuContext = createContext(undefined)

export type Props = {
   children: ReactNode;
}

export default function MenuProvider(props: Props) {
   const { children } = props;
   const [option, setOption] = useState("editor");

   return (
      <MenuContext.Provider value={{
         option, 
         setOption
      }}>
         {children}
      </MenuContext.Provider>
   )
}

export function useMenu() {
   const context = useContext(MenuContext);
   const { option, setOption } = context;
   return { option, setOption };
}