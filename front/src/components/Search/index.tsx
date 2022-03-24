import React from 'react'
import { Container, SearchBar, Text, SearchIcon } from './styles'

const Search: React.FC = () => {
   return (
      <Container>
         <SearchBar>
            <Text>Search</Text>
            <SearchIcon />
         </SearchBar>
      </Container>
   )
}

export default Search