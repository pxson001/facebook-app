package com.facebook.controller.connectioncontroller.common;

/* compiled from: organization */
public class ConnectionFetchOperation<TUserInfo> {
    public final ConnectionLocation f8592a;
    public final ConnectionOrder f8593b;
    public final String f8594c;
    public final String f8595d;
    public final int f8596e;
    public final TUserInfo f8597f;

    public ConnectionFetchOperation(ConnectionLocation connectionLocation, ConnectionOrder connectionOrder, String str, String str2, int i, TUserInfo tUserInfo) {
        this.f8592a = connectionLocation;
        this.f8593b = connectionOrder;
        this.f8594c = str;
        this.f8595d = str2;
        this.f8596e = i;
        this.f8597f = tUserInfo;
    }
}
