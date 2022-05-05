import React, { createContext, ReactNode, useState, useContext } from 'react';

const TaskContext = createContext(undefined);

export type Props = {
   children: ReactNode;
}

export default function TaskProvider(props: Props) {
   const { children } = props;
   const [createTaskActive, setCreateTaskActive] = useState(false);

   return (
      <TaskContext.Provider value={{
         createTaskActive,
         setCreateTaskActive
      }}>
         {children}
      </TaskContext.Provider>
   )
}

export function useTask() {
   const context = useContext(TaskContext);
   const { createTaskActive, setCreateTaskActive } = context;
   return { createTaskActive, setCreateTaskActive };
}
