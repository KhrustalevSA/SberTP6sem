package shell;

import java.io.IOException;
import java.util.concurrent.Executors;

public class ShellImpl implements Shell {

    Process process;
    String homeDirectory = System.getProperty("user.home");

    @Override
    public void  getTime() throws IOException {

        process = Runtime.getRuntime().exec(String.format("cmd.exe /c time", homeDirectory));
        StreamGobbler streamGobbler = new StreamGobbler(process.getInputStream(), System.out::println);
        Executors.newSingleThreadExecutor().submit(streamGobbler);
    }

    @Override
    public void getDate() throws IOException {

        process = Runtime.getRuntime().exec(String.format("cmd.exe /c date", homeDirectory));
        StreamGobbler streamGobbler = new StreamGobbler(process.getInputStream(), System.out::println);
        Executors.newSingleThreadExecutor().submit(streamGobbler);
    }

    @Override
    public void exitProgram() throws IOException {

        process = Runtime.getRuntime().exec(String.format("cmd.exe /c exit", homeDirectory));
        StreamGobbler streamGobbler = new StreamGobbler(process.getInputStream(), System.out::println);
        Executors.newSingleThreadExecutor().submit(streamGobbler);
        System.exit(0);
    }
}
