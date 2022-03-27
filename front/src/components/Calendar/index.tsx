import React from 'react'
import { Container } from './styles'
import EstebanCalendar from './Esteban'
const Calendar: React.FC = () => {
   return (
      <Container>
         <h2>Calendar</h2>
         <EstebanCalendar></EstebanCalendar>
      </Container>
   )
}

export default Calendar