package com.facebook.common.collect;

import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: mqtt_notifications_sync_full */
public class WeakHashSets {
    public static <T> Set<T> m7798a() {
        return Collections.newSetFromMap(new WeakHashMap());
    }
}
