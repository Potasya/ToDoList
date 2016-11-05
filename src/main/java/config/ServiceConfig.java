package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Marisha on 27/10/16.
 */

@Configuration
@ComponentScan({"dao", "service"})
public class ServiceConfig {
}
