package com.facebook.proxygen;

/* compiled from: profile_pic_square */
public enum NetworkType$ConnectivityType {
    NOCONN(0),
    WIFI(1),
    CELLULAR(2),
    OTHER(3);
    
    public int value;

    private NetworkType$ConnectivityType(int i) {
        this.value = i;
    }
}
