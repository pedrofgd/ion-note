import styled from 'styled-components'

// TL - note title
// DE - note description
// DT - note date

export const Container = styled.div`
   display: grid;

   grid-template-columns: 250px auto;
   grid-template-rows: auto auto;

   grid-template-areas:
      'TL TL'
      'DE DT';

   padding-bottom: 30px;
`

export const Title = styled.span`
   grid-area: TL;
   
   font-size: 26px;
   font-weight: 700;

   max-width: 250px;
   padding-bottom: 11px;
`

export const Description = styled.span`
   grid-area: DE;

   font-size: 16px;

   max-width: 250px;
`

export const CreationDate = styled.span`
   grid-area: DT;

   font-size: 14px;

   padding-left: 11px;
`