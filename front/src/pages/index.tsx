import React from 'react'
import Head from 'next/head'

import { Container } from '../styles/pages/Home'
import MenuProvider from '../context/Menu'
import ContextWrapper from '../components/Calendar/Esteban/context/ContextWrapper'

import Layout from '../components/Layout'

const Home: React.FC = () => {
  return (
    <MenuProvider>
      <ContextWrapper> {/* TODO Calendario - mudar nome */}
        <Container>
          <Head>
            <title>Homepage</title>
          </Head>

          <Layout />
        </Container>
      </ContextWrapper>
    </MenuProvider>

  )
}

export default Home