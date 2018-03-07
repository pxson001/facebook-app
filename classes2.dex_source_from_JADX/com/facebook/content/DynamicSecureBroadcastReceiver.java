package com.facebook.content;

import android.content.Context;
import android.content.Intent;
import com.facebook.backgroundworklog.observer.MultiplexBackgroundWorkObserver;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.Preconditions;
import com.facebook.inject.Lazy;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: upload_card */
public class DynamicSecureBroadcastReceiver extends SecureBroadcastReceiver {
    private final ImmutableMap<String, ActionReceiver> f1648a;

    public DynamicSecureBroadcastReceiver(Map<String, ? extends ActionReceiver> map) {
        this((Map) map, null);
    }

    public DynamicSecureBroadcastReceiver(Map<String, ? extends ActionReceiver> map, @Nullable Lazy<MultiplexBackgroundWorkObserver> lazy) {
        super(lazy);
        Preconditions.a(map);
        Preconditions.b(!map.isEmpty(), "Must include an entry for at least one action");
        this.f1648a = ImmutableMap.m3305a(map);
    }

    public DynamicSecureBroadcastReceiver(String str, ActionReceiver actionReceiver) {
        this(ImmutableMap.m3306a(str, actionReceiver));
    }

    public final Iterable<String> m3300a() {
        return this.f1648a.keySet();
    }

    @Nullable
    protected final ActionReceiver mo509a(Context context, Intent intent) {
        String action = intent.getAction();
        if (action != null) {
            return (ActionReceiver) this.f1648a.get(action);
        }
        return null;
    }
}
