package com.facebook.messaging.connectivity;

/* compiled from: overflow_fix */
public interface ConnectionStatusMonitor {

    /* compiled from: overflow_fix */
    public enum ConnectionType {
        MQTT,
        HTTP
    }

    /* compiled from: overflow_fix */
    public enum State {
        CONNECTED,
        CONNECTED_CAPTIVE_PORTAL,
        CONNECTING,
        WAITING_TO_CONNECT,
        NO_INTERNET
    }

    State mo684a();

    boolean mo685a(ConnectionType connectionType);

    boolean mo686b();

    boolean mo687b(ConnectionType connectionType);

    boolean mo688c();

    boolean mo689d();

    void mo690e();
}
