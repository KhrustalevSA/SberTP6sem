package Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import shell.ShellImpl;

@Configuration
public class AppConfig {
    @Bean
    ShellImpl getShell(){
        return new ShellImpl();
    }

}
