import React, { useState, useContext, useEffect } from "react";
//import "./styles";
import { getMonth } from "./../../../utils/calendar";
import CalendarHeader from "./components/CalendarHeader";
import Sidebar from "./components/Sidebar";
import Month from "./components/Month";
import GlobalContext from "./../../../context/GlobalContext";
import EventModal from "./components/EventModal";
function EstebanCalendar() {
  const [currenMonth, setCurrentMonth] = useState([new Date(2022, 0o3, 27)]);
  const { monthIndex, showEventModal } = useContext(GlobalContext);

  useEffect(() => {
    setCurrentMonth(getMonth(monthIndex));
  }, [monthIndex]);

  return (
    <React.Fragment>
      {showEventModal && <EventModal />}

      <div className="h-screen flex flex-col">
        <CalendarHeader />
        <div className="flex flex-1">
          <Sidebar />
          <Month month={currenMonth} />
        </div>
      </div>
    </React.Fragment>
  );
}

export default EstebanCalendar;