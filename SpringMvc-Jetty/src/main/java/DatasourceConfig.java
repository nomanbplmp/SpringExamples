import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource; 
 
@Configuration 
@ComponentScan 
@PropertySource("datasource.properties")
public class DatasourceConfig { 
 
    /**
     * Main data source containing the credentials. 
     * In this is example this is the DB from the resource server. 
     */ 
    @Bean 
    @Primary 
   
    @ConfigurationProperties(prefix = "spring.datasource") 
    public DataSource mainDataSource() { 
        return DataSourceBuilder.create().build(); 
    } 
    
 
}
