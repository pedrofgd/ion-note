import Header from "../Header";
import Editor from "../Editor";
import ListNotes from "../ListNotes";
import { Grid } from "./styles";

const Layout: React.FC = () => {
   return (
      <Grid>
         <Header />
         <Editor />
         <ListNotes />
      </Grid>
   );
}

export default Layout;