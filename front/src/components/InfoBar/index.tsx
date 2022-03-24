import React from 'react'
import { Container } from './styles'

const InfoBar: React.FC = () => {
   return (
      <Container>
         <span>{"TAB: see options | ARROWS: navigate in options | CTRL+ LeftArrow/RightArrow: select a word and see options"}</span>
      </Container>
   )
}
export default InfoBar