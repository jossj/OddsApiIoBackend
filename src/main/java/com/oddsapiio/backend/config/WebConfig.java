package com.oddsapiio.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestClient;

import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;

@Configuration
public class WebConfig {

    @Bean
    public RestClient restClient(OddsApiProperties props) {
        String proxyHost = System.getProperty("https.proxyHost");
        String proxyPortStr = System.getProperty("https.proxyPort");
        String proxyUser = System.getProperty("https.proxyUser");
        String proxyPass = System.getProperty("https.proxyPassword");

        RestClient.Builder builder = RestClient.builder().baseUrl(props.getBaseUrl());

        if (proxyHost != null && proxyPortStr != null) {
            int proxyPort = Integer.parseInt(proxyPortStr);
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, proxyPort));

            if (proxyUser != null && proxyPass != null) {
                String user = proxyUser;
                String pass = proxyPass;
                Authenticator.setDefault(new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        if (getRequestorType() == RequestorType.PROXY) {
                            return new PasswordAuthentication(user, pass.toCharArray());
                        }
                        return null;
                    }
                });
            }

            SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
            factory.setProxy(proxy);
            builder.requestFactory(factory);
        }

        return builder.build();
    }
}
