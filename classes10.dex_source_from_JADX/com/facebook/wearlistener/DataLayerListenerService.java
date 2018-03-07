package com.facebook.wearlistener;

import android.os.Binder;
import com.facebook.debug.log.BLog;
import com.facebook.inject.FbInjector;
import com.facebook.orca.notify.MessagesWearNodeListener;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.WearableListenerService;
import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Set;

/* compiled from: extra_category_group */
public class DataLayerListenerService extends WearableListenerService {
    private static final Class f12972a = DataLayerListenerService.class;
    private Set<WearDataListener> f12973b;
    private Set<WearMessageListener> f12974c;
    private Set<WearNodeListener> f12975d;

    public final void mo134a(final DataEventBuffer dataEventBuffer) {
        FbInjector.a(DataLayerListenerService.class, this, this);
        Integer.valueOf(this.f12973b.size());
        this.f12973b.size();
        Integer.valueOf(dataEventBuffer.a());
        m13006a(Iterables.a(this.f12973b, new Function<WearDataListener, ListenableFuture<Void>>(this) {
            final /* synthetic */ DataLayerListenerService f12965b;

            public Object apply(Object obj) {
                return ((WearDataListener) obj).m13011a();
            }
        }));
    }

    public final void mo135a(final MessageEvent messageEvent) {
        FbInjector.a(DataLayerListenerService.class, this, this);
        Integer.valueOf(this.f12974c.size());
        this.f12974c.size();
        m13006a(Iterables.a(this.f12974c, new Function<WearMessageListener, ListenableFuture<Void>>(this) {
            final /* synthetic */ DataLayerListenerService f12967b;

            public Object apply(Object obj) {
                return ((WearMessageListener) obj).m13012a();
            }
        }));
    }

    public final void mo136a(final Node node) {
        FbInjector.a(DataLayerListenerService.class, this, this);
        Integer.valueOf(this.f12975d.size());
        this.f12975d.size();
        m13006a(Iterables.a(this.f12975d, new Function<WearNodeListener, ListenableFuture<Void>>(this) {
            final /* synthetic */ DataLayerListenerService f12969b;

            public Object apply(Object obj) {
                return ((MessagesWearNodeListener) obj).a(node);
            }
        }));
    }

    public final void mo137b(final Node node) {
        FbInjector.a(DataLayerListenerService.class, this, this);
        Integer.valueOf(this.f12975d.size());
        this.f12975d.size();
        m13006a(Iterables.a(this.f12975d, new Function<WearNodeListener, ListenableFuture<Void>>(this) {
            final /* synthetic */ DataLayerListenerService f12971b;

            public Object apply(Object obj) {
                return ((MessagesWearNodeListener) obj).b(node);
            }
        }));
    }

    private static void m13006a(Iterable<ListenableFuture<Void>> iterable) {
        long clearCallingIdentity = Binder.clearCallingIdentity();
        try {
            FutureDetour.a(Futures.b(iterable), -1437657509);
        } catch (Throwable e) {
            BLog.b(f12972a, e, "Operation failed", new Object[0]);
        } catch (Throwable e2) {
            BLog.b(f12972a, e2, "Operation interrupted", new Object[0]);
        } finally {
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
    }
}
