import { Grid } from "./styles";
import Header from "../Header";
import Configurations from "../Configurations";
import Editor from "../Editor";
import ListNotes from "../ListNotes";
import InfoBar from "../InfoBar";

const Layout: React.FC = () => {
   return (
      <Grid>
         <Header />
         <Configurations />
         <Editor />
         <ListNotes />
         <InfoBar />
      </Grid>
   );
}

export default Layout;