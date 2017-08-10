package xyz.casualcookie.ponyslayer.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import xyz.casualcookie.ponyslayer.services.AdventureService;
import xyz.casualcookie.ponyslayer.services.AdventureServiceImpl;

@Configuration
@ComponentScan("xyz.casualcookie.ponyslayer.services")
public class ServicesConfig {}
