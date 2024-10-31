package br.com.beautique.configurations;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQTopicConfig {

    public final String exchangeName = "beautiqueExchange";

    @Bean
    TopicExchange exchange() {
        return new TopicExchange(exchangeName);
    }

    @Bean
    public Queue customerQueue() {
        return new Queue("CustomerQueue", true);
    }

    @Bean
    Binding bindingCustomer(Queue customerQueue, TopicExchange exchange) {
        return BindingBuilder.bind(customerQueue).to(exchange).with("customer.#");
    }

    @Bean
    public Queue beautyProcedureQueue() {
        return new Queue("beautyProcedureQueue", true);
    }

    @Bean
    public Binding bindingBeautyProcedure(Queue beautyProcedureQueue, TopicExchange exchange) {
        return BindingBuilder.bind(beautyProcedureQueue).to(exchange).with("beautyProcedures.#");
    }

    @Bean
    public Queue appointmentQueue() {
        return new Queue("appointmentQueue", true);
    }

    @Bean
    public Binding bindingAppointment(Queue appointmentQueue, TopicExchange exchange) {
        return BindingBuilder.bind(appointmentQueue).to(exchange).with("appointments.#");
    }
}