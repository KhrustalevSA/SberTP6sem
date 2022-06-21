package shell;

import java.io.IOException;

public interface Shell {
    void getTime() throws IOException;
    void getDate() throws IOException;
    void exitProgram() throws IOException, InterruptedException;
}
