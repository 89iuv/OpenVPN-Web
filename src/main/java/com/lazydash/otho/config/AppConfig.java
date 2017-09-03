package com.lazydash.otho.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by valiuv on 5/8/2017.
 */
@Component
@ConfigurationProperties
public class AppConfig {
    private String openvpnStatusFile;
    private String openvpnIndexFile;
    private String openvpnIppFile;

    public String getOpenvpnStatusFile() {
        return openvpnStatusFile;
    }

    public void setOpenvpnStatusFile(String openvpnStatusFile) {
        this.openvpnStatusFile = openvpnStatusFile;
    }

    public String getOpenvpnIndexFile() {
        return openvpnIndexFile;
    }

    public void setOpenvpnIndexFile(String openvpnIndexFile) {
        this.openvpnIndexFile = openvpnIndexFile;
    }

    public String getOpenvpnIppFile() {
        return openvpnIppFile;
    }

    public void setOpenvpnIppFile(String openvpnIppFile) {
        this.openvpnIppFile = openvpnIppFile;
    }
}
