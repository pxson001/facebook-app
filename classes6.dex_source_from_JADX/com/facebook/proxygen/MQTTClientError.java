package com.facebook.proxygen;

/* compiled from: springConfig is required */
public class MQTTClientError {
    public int mConnAckCode;
    public String mErrMsg;
    public MQTTErrorType mErrType;

    /* compiled from: springConfig is required */
    public enum MQTTErrorType {
        PARSE_ERROR,
        TRANSPORT_CONNECT_ERROR,
        MQTT_CONNECT_ERROR,
        CONNECTION_CLOSED,
        READ_ERROR,
        WRITE_ERROR,
        EOF,
        PING_TIMEOUT,
        DISCONNECT,
        COMPRESSION_ERROR,
        STOPPED_BEFORE_MQTT_CONNECT,
        UNKNOWN
    }

    public MQTTClientError(MQTTErrorType mQTTErrorType, String str) {
        this.mErrType = mQTTErrorType;
        this.mErrMsg = str;
    }

    public void setConnAckCode(int i) {
        this.mConnAckCode = i;
    }

    public String getMessage() {
        return this.mErrMsg;
    }

    public MQTTErrorType getType() {
        return this.mErrType;
    }

    public int getConnAckCode() {
        return this.mConnAckCode;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.mConnAckCode != 0) {
            stringBuilder.append("conAckCode=").append(this.mConnAckCode);
        }
        stringBuilder.append("errType=").append(this.mErrType.name());
        stringBuilder.append("errMsg=").append(this.mErrMsg);
        return stringBuilder.toString();
    }
}
