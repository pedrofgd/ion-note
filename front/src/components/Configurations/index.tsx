import React from 'react'
import { Actions, ConfigurationIcon, Container, Profile } from './styles'

const Configurations: React.FC = () => {
   return (
      <Container>
         <Actions>
            <ConfigurationIcon />
            <Profile />
         </Actions>
      </Container>
   )
}

export default Configurations