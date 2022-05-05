import React from 'react'
import { Container, Text } from './styles';

export interface Props {
   text: string;
   onClick: React.MouseEventHandler;
}

const Button: React.FC<Props> = ({
   text,
   onClick
}) => {
   return (
      <Container
         onClick={onClick}
      >
         <Text>{text}</Text>  
      </Container>
   )
}

export default Button