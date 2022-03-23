import Header from "../Header";
import Editor from "../Editor";
import Configurations from "../Configurations";
import ListNotes from "../ListNotes";
import { Grid } from "./styles";

const Layout: React.FC = () => {
   return (
      <Grid>
         <Header />
         <Configurations />
         <Editor />
         <ListNotes />
      </Grid>
   );
}

export default Layout;