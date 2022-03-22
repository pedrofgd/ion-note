import React from 'react'
import Head from 'next/head'

import { Container } from '../styles/pages/Home'

import Layout from '../components/Layout'

const Home: React.FC = () => {
  return (
    <Container>
      <Head>
        <title>Homepage</title>
      </Head>

      <Layout />
    </Container>
  )
}

export default Home