package com.lazydash.vpn.web.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by valiuv on 5/8/2017.
 */
@Component
@ConfigurationProperties
public class AppConfig {
    private String openvpnStatusFile;

    public String getOpenvpnStatusFile() {
        return openvpnStatusFile;
    }

    public void setOpenvpnStatusFile(String openvpnStatusFile) {
        this.openvpnStatusFile = openvpnStatusFile;
    }
}
