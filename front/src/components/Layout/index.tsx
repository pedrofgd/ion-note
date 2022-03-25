import { Grid } from "./styles";
import Header from "../Header";
import Configurations from "../Configurations";
import Editor from "../Editor";
import ListNotes from "../ListNotes";
import InfoBar from "../InfoBar";

import { useMenu } from "../../context/Menu";
import Calendar from "../Calendar";

const Layout: React.FC = () => {
   const { option } = useMenu();

   return (
      <Grid>
         <Header />
         <Configurations />

         {option === "editor" 
            ? <Editor />
            : <Calendar />
         }
         
         <ListNotes />
         <InfoBar />
      </Grid>
   );
}

export default Layout;