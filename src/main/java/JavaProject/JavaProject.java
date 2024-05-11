package shippingService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication

public class ShippingService {
    public static void main(final String[] args) {
        SpringApplication.run(ShippingService.class, args);
    }
}
