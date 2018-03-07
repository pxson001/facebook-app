package com.facebook.device_id;

import com.facebook.content.DynamicSecureBroadcastReceiver;

/* compiled from: switchPlayableUri */
public class UniqueIdSupplier extends DynamicSecureBroadcastReceiver {
    public UniqueIdSupplier() {
        super("com.facebook.GET_UNIQUE_ID", new UniqueIdRequestAction());
    }
}
