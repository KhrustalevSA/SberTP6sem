import Config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import shell.Shell;
import shell.ShellImpl;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

/**
 * Ввод: date, time или exit
 * */

public class main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        String value;
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();

        Shell shell = context.getBean(ShellImpl.class);
        while(flag){
            value = scanner.nextLine();
            if (Objects.equals(value, "time")){
                shell.getTime();
            }
            if (Objects.equals(value, "date")){
                shell.getDate();
            }
            if (Objects.equals(value, "exit")){
                shell.exitProgram();
                flag = false;
            }

        }

    }
}
