package com.wojiushiwo.springbootjenkins.controller;

import io.kubernetes.client.openapi.ApiClient;
import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.openapi.Configuration;
import io.kubernetes.client.openapi.apis.CoreV1Api;
import io.kubernetes.client.openapi.models.V1Pod;
import io.kubernetes.client.openapi.models.V1PodList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by myk
 * 2020/7/30 下午4:24
 */
@RequestMapping("/k8s")
public class K8sController {


    @Autowired
    private ApiClient apiClient;

    @GetMapping("/getPods")
    public String getPods() {

        Configuration.setDefaultApiClient(apiClient);
        CoreV1Api api = new CoreV1Api();
        try {
            V1PodList list = api.listPodForAllNamespaces(null, null, null, null, null, null, null, null, null);
            StringBuilder str = new StringBuilder();
            for (V1Pod item : list.getItems()) {
                str.append(item.toString());
                str.append("\n");
            }
            return str.toString();
        } catch (ApiException e) {
            return "Error:" + e.getMessage();
        }
    }

}
