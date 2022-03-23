import styled from 'styled-components'
import { Search } from 'styled-icons/material'

export const Container = styled.div`
   grid-area: SC;

   display: flex;
   justify-content: center;
   align-items: center;
   text-align: center;
`

export const SearchBar = styled.div`
   width: 70%;
   height: 40px;

   display: flex;
   justify-content: space-between;

   border-radius: 7px;
   background-color: ${props => props.theme.colors.button};
   padding: 11px;
`

export const Text = styled.span`
   display: flex;
   justify-content: center;
   align-items: center;

   font-size: 16px;
   color: ${props => props.theme.colors.grey};
   line-height: 0;
`

export const SearchIcon = styled(Search)`
   width: 20px;
   height: 20px;
`