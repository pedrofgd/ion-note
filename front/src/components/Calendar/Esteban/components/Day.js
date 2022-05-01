import React, { useContext, useState, useEffect } from 'react';
import GlobalContext from "../context/GlobalContext";

import dayjs from "dayjs";

export default function Day({ day, rowIdx }) {
  const [dayEvents, setDayEvents] = useState([]);
  const {
    setDaySelected,
    setShowEventModal,
    filteredEvents,
    setSelectedEvent,
  } = useContext(GlobalContext);

  useEffect(() => {
    // TODO ajustar local storage
    const events = filteredEvents.filter(
      (evt) =>
        dayjs(evt.day).format("DD-MM-YY") === day.format("DD-MM-YY")
    );
    setDayEvents(events);
  }, [filteredEvents, day]);

  function getCurrentDayClass() {
    return day.format("DD-MM-YY") === dayjs().format("DD-MM-YY")
      ? "bg-blue-600 text-white rounded-full w-7"
      : "";
  }
  
  return (
    <div className="border border-gray-200 flex flex-col">
      <header className="flex flex-col items-center">
        {/* SUN, MON... no topo da primeira linha */}
        {rowIdx === 0 && (
          <p className="text-xs mt-1">
            {day.format("ddd").toUpperCase()}
          </p>
        )}

        {/* 01, 02, 03... dia do mes */}
        <p
          className={`text-xs p-1 my-1 text-center  
          ${getCurrentDayClass()}`}
        >
          {day.format("DD")}
        </p>
      </header>
      
      {/* Area dos eventos (separado do dia) */}
      <div
        className="flex-1 cursor-pointer"
        onClick={() => {
          setDaySelected(day);
          setShowEventModal(true);
        }}
      >
        {dayEvents.map((evt, idx) => (
          <div
            key={idx}
            onClick={() => setSelectedEvent(evt)}
            className={`bg-${evt.label}-200 p-1 mr-3 text-gray-600 text-sm rounded mb-1 truncate`}
          >
            {evt.title}
          </div>
        ))}
      </div>
    </div>
    
  );
}
