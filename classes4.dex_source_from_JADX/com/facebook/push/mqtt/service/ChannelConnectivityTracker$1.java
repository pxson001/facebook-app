package com.facebook.push.mqtt.service;

import com.facebook.push.mqtt.ipc.MqttChannelStateInfo.ConnectionState;

/* compiled from: gift_recipient */
/* synthetic */ class ChannelConnectivityTracker$1 {
    static final /* synthetic */ int[] f11050a = new int[ConnectionState.values().length];
    static final /* synthetic */ int[] f11051b = new int[ConnectionState.values().length];

    static {
        try {
            f11051b[ConnectionState.CONNECTED.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f11051b[ConnectionState.CONNECTING.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f11051b[ConnectionState.DISCONNECTED.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f11050a[ConnectionState.CONNECTING.ordinal()] = 1;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f11050a[ConnectionState.CONNECTED.ordinal()] = 2;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f11050a[ConnectionState.DISCONNECTED.ordinal()] = 3;
        } catch (NoSuchFieldError e6) {
        }
    }
}
