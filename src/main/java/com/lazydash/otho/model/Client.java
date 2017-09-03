package com.lazydash.otho.model;

/**
 * Created by valiuv on 5/8/2017.
 */
public class Client {
    private String commonName;
    private String realAddress;
    private String bytesReceived;
    private String bytesSent;
    private String connectedSince;
    private String lastRef;
    private String virtualAddress;
    private boolean connected;

    public Client(String commonName) {
        this.commonName = commonName;
    }

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

    public String getBytesReceived() {
        return bytesReceived;
    }

    public void setBytesReceived(String bytesReceived) {
        this.bytesReceived = bytesReceived;
    }

    public String getBytesSent() {
        return bytesSent;
    }

    public void setBytesSent(String bytesSent) {
        this.bytesSent = bytesSent;
    }

    public String getConnectedSince() {
        return connectedSince;
    }

    public void setConnectedSince(String connectedSince) {
        this.connectedSince = connectedSince;
    }

    public String getLastRef() {
        return lastRef;
    }

    public void setLastRef(String lastRef) {
        this.lastRef = lastRef;
    }

    public boolean isConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (connected != client.connected) return false;
        if (commonName != null ? !commonName.equals(client.commonName) : client.commonName != null) return false;
        if (realAddress != null ? !realAddress.equals(client.realAddress) : client.realAddress != null) return false;
        if (bytesReceived != null ? !bytesReceived.equals(client.bytesReceived) : client.bytesReceived != null)
            return false;
        if (bytesSent != null ? !bytesSent.equals(client.bytesSent) : client.bytesSent != null) return false;
        if (connectedSince != null ? !connectedSince.equals(client.connectedSince) : client.connectedSince != null)
            return false;
        if (lastRef != null ? !lastRef.equals(client.lastRef) : client.lastRef != null) return false;
        return virtualAddress != null ? virtualAddress.equals(client.virtualAddress) : client.virtualAddress == null;
    }

    @Override
    public int hashCode() {
        int result = commonName != null ? commonName.hashCode() : 0;
        result = 31 * result + (realAddress != null ? realAddress.hashCode() : 0);
        result = 31 * result + (bytesReceived != null ? bytesReceived.hashCode() : 0);
        result = 31 * result + (bytesSent != null ? bytesSent.hashCode() : 0);
        result = 31 * result + (connectedSince != null ? connectedSince.hashCode() : 0);
        result = 31 * result + (lastRef != null ? lastRef.hashCode() : 0);
        result = 31 * result + (virtualAddress != null ? virtualAddress.hashCode() : 0);
        result = 31 * result + (connected ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Client{" +
                "commonName='" + commonName + '\'' +
                ", realAddress='" + realAddress + '\'' +
                ", bytesReceived='" + bytesReceived + '\'' +
                ", bytesSent='" + bytesSent + '\'' +
                ", connectedSince='" + connectedSince + '\'' +
                ", lastRef='" + lastRef + '\'' +
                ", virtualAddress='" + virtualAddress + '\'' +
                ", connected=" + connected +
                '}';
    }
}
