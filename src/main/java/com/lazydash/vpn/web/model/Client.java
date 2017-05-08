package com.lazydash.vpn.web.model;

/**
 * Created by valiuv on 5/8/2017.
 */
public class Client {
    private String commonName;
    private String realAddress;
    private String virtualAddress;

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getRealAddress() {
        return realAddress;
    }

    public void setRealAddress(String realAddress) {
        this.realAddress = realAddress;
    }

    public String getVirtualAddress() {
        return virtualAddress;
    }

    public void setVirtualAddress(String virtualAddress) {
        this.virtualAddress = virtualAddress;
    }

    @Override
    public String toString() {
        return "Client{" +
                "commonName='" + commonName + '\'' +
                ", realAddress='" + realAddress + '\'' +
                ", virtualAddress='" + virtualAddress + '\'' +
                '}';
    }
}
