import React from 'react'
import Head from 'next/head'

import { Container } from '../styles/pages/Home'
import MenuProvider from '../context/Menu'

import Layout from '../components/Layout'

const Home: React.FC = () => {
  return (
    <MenuProvider>
      <Container>
        <Head>
          <title>Homepage</title>
        </Head>

        <Layout />
      </Container>
    </MenuProvider>

  )
}

export default Home