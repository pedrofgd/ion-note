import React from 'react';

import { Container } from './styles'

import Menu from '../Menu';

const Header: React.FC = () => {
   return (
      <Container>
         <h2>ION</h2>
         
         <Menu />
      </Container>
   )
}

export default Header;