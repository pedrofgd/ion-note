import styled from 'styled-components'

import { Sync } from 'styled-icons/material'

export const Container = styled.div`
   grid-area: SV;

   display: flex;
   justify-content: start;
   align-items: center;

`

export const Text = styled.span`
   font-size: 16px;
   color: ${props => props.theme.colors.grey};
   padding-left: 11px;
`

export const SyncIcon = styled(Sync)`
   width: 24px;
   height: 24px;
   color: ${props => props.theme.colors.grey}
`