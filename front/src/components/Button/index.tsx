import React from 'react'
import { Container, Text } from './styles';

export interface Props {
   text: string;
}

const Button: React.FC<Props> = ({
   text
}) => {
   return (
      <Container>
         <Text>{text}</Text>  
      </Container>
   )
}

export default Button