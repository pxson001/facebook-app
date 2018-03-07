package com.facebook.content;

import android.content.Context;
import android.content.Intent;
import com.facebook.backgroundworklog.observer.MultiplexBackgroundWorkObserver;
import com.facebook.common.internal.ImmutableSet;
import com.facebook.common.internal.Sets;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectableComponentWithoutContext;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import java.util.Iterator;
import javax.annotation.Nullable;

/* compiled from: feedback/reactions/large_images/ */
public abstract class FacebookOnlySecureBroadcastReceiver extends SecureBroadcastReceiver implements InjectableComponentWithoutContext {
    private final ImmutableSet<String> f24452a;

    protected abstract void mo3518a(Context context, Intent intent, String str);

    protected FacebookOnlySecureBroadcastReceiver(String str) {
        this(ImmutableSet.m32768a(str));
    }

    protected FacebookOnlySecureBroadcastReceiver(Iterable<String> iterable) {
        this(iterable, null);
    }

    protected FacebookOnlySecureBroadcastReceiver(Iterable<String> iterable, @Nullable Lazy<MultiplexBackgroundWorkObserver> lazy) {
        super(lazy);
        this.f24452a = ImmutableSet.m32767a(Sets.m32765a((Iterable) iterable));
    }

    @Nullable
    protected final ActionReceiver mo509a(Context context, Intent intent) {
        FacebookOnlyIntentActionFactory a = FacebookOnlyIntentActionFactory.m4495a(FbInjector.get(context));
        String action = intent.getAction();
        Iterator it = this.f24452a.iterator();
        while (it.hasNext()) {
            final String str = (String) it.next();
            if (a.m4497a(str).equals(action)) {
                return new ActionReceiver(this) {
                    final /* synthetic */ FacebookOnlySecureBroadcastReceiver f24454b;

                    public void onReceive(Context context, Intent intent, BroadcastReceiverLike broadcastReceiverLike) {
                        int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 1506428371);
                        this.f24454b.mo3518a(context, intent, str);
                        Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_END, 604154894, a);
                    }
                };
            }
        }
        return null;
    }
}
