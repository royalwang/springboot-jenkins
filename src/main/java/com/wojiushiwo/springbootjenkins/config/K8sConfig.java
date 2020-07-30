package com.wojiushiwo.springbootjenkins.config;

import io.kubernetes.client.openapi.ApiClient;
import io.kubernetes.client.util.ClientBuilder;
import io.kubernetes.client.util.KubeConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileReader;
import java.io.IOException;

/**
 * Created by myk
 * 2020/7/30 下午4:26
 */
@Configuration
public class K8sConfig {

    private static String filePath = "/root/.kube/config";

    @Bean
    public ApiClient apiClient() {
        try {
            return ClientBuilder.kubeconfig(KubeConfig.loadKubeConfig(new FileReader(filePath))).build();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
