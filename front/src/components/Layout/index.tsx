import Editor from "../Editor";
import ListNotes from "../ListNotes";
import { Grid } from "./styles";

const Layout: React.FC = () => {
   return (
      <Grid>
         <Editor />
         <ListNotes />
      </Grid>
   );
}

export default Layout;