package com.facebook.proxygen;

/* compiled from: springLooper is required */
public class MQTTClient extends NativeHandleImpl {
    public ByteEventLogger mByteEventLogger;
    private final MQTTClientCallback mCallback;
    private final MQTTClientFactory mFactory;
    public AnalyticsLogger mLogger;
    private final ConnectionParams mParams;

    private native void init(MQTTClientFactory mQTTClientFactory, MQTTClientCallback mQTTClientCallback, String str, int i, int i2, boolean z, AnalyticsLogger analyticsLogger, ByteEventLogger byteEventLogger);

    public native void close();

    public native void connect(String str, int i, byte[] bArr, int i2, int i3, boolean z);

    public native void connectWithPassword(String str, int i, String str2, String str3, boolean z);

    public native void disconnect();

    public native void publish(String str, byte[] bArr, int i, int i2, int i3, int i4);

    public native void sendKeepAliveOnce();

    public native void setForeground(boolean z);

    public native void stopConnectingIfConnectNotSent();

    public native void subscribe(String[] strArr, int[] iArr);

    public native void unSubscribe(String[] strArr, int i);

    public MQTTClient(MQTTClientFactory mQTTClientFactory, MQTTClientCallback mQTTClientCallback, ConnectionParams connectionParams) {
        this.mFactory = mQTTClientFactory;
        this.mCallback = mQTTClientCallback;
        this.mParams = connectionParams;
    }

    public MQTTClient setAnalyticsLogger(AnalyticsLogger analyticsLogger) {
        this.mLogger = analyticsLogger;
        return this;
    }

    public MQTTClient setByteEventLogger(ByteEventLogger byteEventLogger) {
        this.mByteEventLogger = byteEventLogger;
        return this;
    }

    public void init() {
        init(this.mFactory, this.mCallback, this.mParams.clientId, this.mParams.publishFormat.getValue(), this.mParams.keepaliveSecs, this.mParams.enableTopicEncoding, this.mLogger, this.mByteEventLogger);
    }

    public void connect(String str, int i, String str2, String str3, boolean z) {
        connectWithPassword(str, i, str2, str3, z);
    }

    public void publish(String str, byte[] bArr, int i, int i2) {
        publish(str, bArr, 0, bArr.length, i, i2);
    }
}
