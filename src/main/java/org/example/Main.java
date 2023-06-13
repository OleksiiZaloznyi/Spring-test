package org.example;

import org.example.config.AppConfig;
import org.example.model.Product;
import org.example.service.ProductService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        /*
            Steps to implement:
            1. Add spring-context maven dependency
            2. Create AppConfig class and mark it with @Configuration annotation
            3. Replace @Dao and @Service annotations with corresponding from Spring Framework
            4. Replace @Inject annotation with @Autowired in ProductDaoImpl
            5. Replace creating of Injector instance with AnnotationConfigApplicationContext
        */

        /*
            Steps to implement:
            1. Add spring-orm and commons-dbcp2 maven dependency
            2. Create DataSource and LocalSessionFactoryBean beans in AppConfig class
            3. Mark them with @Bean annotation
        */

        /*
        1. Add <packaging>war</packaging> to pom.xml
        2. Add spring-webmvc dependency to pom.xml
        3. Add javax.servlet-api dependency to pom.xml
        4. Add maven-war-plugin plugin to pom.xml
        5. Create WebConfig class @EnableWebMvc, @Configuration and @ComponentScan annotations
        6. Create WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer class
        7. Create controller
        8. Create add jsp page to src/main/webapp/WEB-INF/views/index.jsp
        9. Implement WebMvcConfigurer interface in the WebConfig class
        10. Configure InternalResourceViewResolver bean in the WebConfig class
        11. Add javax.servlet.jsp-api dependency to pom.xml
        12. Add javax.servlet.jsp.jstl-api dependency to pom.xml
        13. Add taglibs standard dependency to pom.xml
        14. Configure Tomcat and run app
        */


        Product iPhone = new Product();
        iPhone.setName("iPhone 7");
        iPhone.setPrice(BigDecimal.valueOf(499));

        Product samsung = new Product();
        samsung.setName("Samsung S20");
        samsung.setPrice(BigDecimal.valueOf(695));

        Product samsungS10 = new Product();
        samsungS10.setName("Samsung S10");
        samsungS10.setPrice(BigDecimal.valueOf(600));

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        ProductService productService = context.getBean(ProductService.class);

        productService.save(iPhone);
        productService.save(samsung);
        productService.save(samsungS10);

        System.out.println(productService.findAll());
        context.close();
    }
}