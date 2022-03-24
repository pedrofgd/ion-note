import React from 'react';

import { Container } from './styles'

import Menu from '../Menu';
import Search from '../Search';
import SavingNote from '../SavingNote';

const Header: React.FC = () => {
   return (
      <Container>
         <h2>ION</h2>
         
         <Search />
         <SavingNote />
         <Menu />
      </Container>
   )
}

export default Header;