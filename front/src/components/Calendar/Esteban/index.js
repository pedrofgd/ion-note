import React, { useState, useContext, useEffect } from 'react';

import { getMonth } from "./util";

import Month from "./components/Month";
import GlobalContext from "./context/GlobalContext";
import EventModal from "./components/EventModal";

function EstebanCalendar() {
  const [currentMonth, setCurrentMonth] = useState(getMonth());
  const { monthIndex, showEventModal } = useContext(GlobalContext);

  useEffect(() => {
    setCurrentMonth(getMonth(monthIndex));
  }, [monthIndex]);

  return (
    <React.Fragment className="App">
      {showEventModal && <EventModal />}

      <div className="h-screen flex flex-col">
        <div className="flex flex-1">
          <Month month={currentMonth} />
        </div>
      </div>
    </React.Fragment>
  );
}

export default EstebanCalendar;