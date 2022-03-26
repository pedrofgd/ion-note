import React, { ReactNode, createContext, useState, useContext } from 'react'

const MenuContext = createContext(undefined)

export type Props = {
   children: ReactNode;
}

export default function MenuProvider(props: Props) {
   const { children } = props;
   const [option, setOption] = useState("editor");
   const [showTasks, setShowTasks] = useState(false);

   return (
      <MenuContext.Provider value={{
         option, 
         setOption,
         showTasks,
         setShowTasks
      }}>
         {children}
      </MenuContext.Provider>
   )
}

export function useMenu() {
   const context = useContext(MenuContext);
   const { option, setOption, showTasks, setShowTasks } = context;
   return { option, setOption, showTasks, setShowTasks };
}