package com.facebook.http.common;

import java.util.ArrayList;

/* compiled from: is_tablet */
public class RequestProcessorSnapshot {
    public final ArrayList<FbHttpRequest<?>> f9816a;
    public final ArrayList<FbHttpRequest<?>> f9817b;

    public RequestProcessorSnapshot(ArrayList<FbHttpRequest<?>> arrayList, ArrayList<FbHttpRequest<?>> arrayList2) {
        this.f9816a = arrayList;
        this.f9817b = arrayList2;
    }

    public final ArrayList<FbHttpRequest<?>> m10217a() {
        return this.f9816a;
    }

    public final ArrayList<FbHttpRequest<?>> m10218b() {
        return this.f9817b;
    }
}
