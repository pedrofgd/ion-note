import dayjs from "dayjs";
import React, { useContext } from "react";
import GlobalContext from "../context/GlobalContext";

export default function CalendarHeader() {
  const { monthIndex, setMonthIndex } = useContext(GlobalContext);

  function handlePrevMonth() {
    setMonthIndex(monthIndex - 1);
  }

  function handleNextMonth() {
    setMonthIndex(monthIndex + 1);
  }

  function handleReset() {
    setMonthIndex(
      monthIndex === dayjs().month()
        ? monthIndex + Math.random()
        : dayjs().month()
    );
  }

  return (
    <header className="py-2 flex items-center justify-end">
       {/* Botao "Hoje" */}
      <button
        onClick={handleReset}
        className="border rounded py-2 px-4 mr-5"
      >
        Hoje
      </button>

      {/* Navegacao no calendario */}
      <div className="flex items-center">
         <button onClick={handlePrevMonth}>
         <span className="material-icons-outlined cursor-pointer text-gray-600 mx-2">
            chevron_left
         </span>

         </button>
         <button onClick={handleNextMonth}>
         <span className="material-icons-outlined cursor-pointer text-gray-600">
            chevron_right
         </span>

         </button>
         <h2 className="ml-2 text-lg py-0 text-black-500 font-bold">
         {dayjs(new Date(dayjs().year(), monthIndex)).format(
            "MMMM YYYY"
         )}
         </h2>
      </div>

    </header>
  );
}