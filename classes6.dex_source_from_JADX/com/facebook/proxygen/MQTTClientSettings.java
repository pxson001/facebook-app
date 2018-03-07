package com.facebook.proxygen;

/* compiled from: spring is already registered */
public class MQTTClientSettings {
    public int connectTimeout;
    public int pingRespTimeout;
    public boolean veryfyCertificates;
    public boolean zlibCompression;

    public MQTTClientSettings setPingRespTimeout(int i) {
        this.pingRespTimeout = i;
        return this;
    }

    public MQTTClientSettings setConnectTimeout(int i) {
        this.connectTimeout = i;
        return this;
    }

    public MQTTClientSettings setVerifyCertificates(boolean z) {
        this.veryfyCertificates = z;
        return this;
    }

    public MQTTClientSettings setZlibCompression(boolean z) {
        this.zlibCompression = z;
        return this;
    }
}
