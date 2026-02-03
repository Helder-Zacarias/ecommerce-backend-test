package com.example.ecommerce_backend_test.config;

import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
import org.apache.hc.client5.http.socket.ConnectionSocketFactory;
import org.apache.hc.client5.http.ssl.NoopHostnameVerifier;
import org.apache.hc.client5.http.ssl.SSLConnectionSocketFactory;
import org.apache.hc.core5.http.config.RegistryBuilder;
import org.apache.hc.core5.ssl.SSLContextBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestClient;

import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

@Configuration
public class RestClientConfig {

    private final String CONSUMER_KEY = "ck_aef2a641dd39c0f271ece3dfda58ee50f2d225ff";
    private final String CONSUMER_SECRET = "cs_2d56d87c8e919b87c71669491e9a3d4f38e0a264";

    private final String WP_USER = "admin";
    private final String MEDIA_API_PASSWORD = "MRKC IjOB WkRk LVZg F44P 4GLa";

    @Bean
    @Qualifier("wooClient")
    public RestClient woocommerceRestClient() throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        String BASE_URL = "https://localhost/ecommerce-rede-software/wp-json/wc/v3";

        return RestClient
                .builder()
                .requestFactory(buildFactory())
                .baseUrl(BASE_URL)
                .defaultHeaders(headers -> headers.setBasicAuth(
                        CONSUMER_KEY, CONSUMER_SECRET
                ))
                .defaultHeader(HttpHeaders.ACCEPT, "application/json")
                .build();
    }

    @Bean
    @Qualifier("wpClient")
    public RestClient wordpressRestClient() throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        String BASE_URL = "https://localhost/ecommerce-rede-software/wp-json/wp/v2/media";

        return RestClient
                .builder()
                .requestFactory(buildFactory())
                .baseUrl(BASE_URL)
                .defaultHeaders(headers -> headers.setBasicAuth(
                        WP_USER, MEDIA_API_PASSWORD
                ))
                .build();
    }

    public HttpComponentsClientHttpRequestFactory buildFactory() throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        SSLContext sslContext = SSLContextBuilder
                .create()
                .loadTrustMaterial((chain, authType) -> true)
                .build();

        SSLConnectionSocketFactory sslSocketFactory = new SSLConnectionSocketFactory(sslContext, NoopHostnameVerifier.INSTANCE);

        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(
                RegistryBuilder.<ConnectionSocketFactory>create()
                        .register("https", sslSocketFactory)
                        .build()
        );

        CloseableHttpClient httpClient = HttpClients
                .custom()
                .setConnectionManager(connectionManager)
                .build();

        return  new HttpComponentsClientHttpRequestFactory(httpClient);
    }
}
