package com.facebook.events.dashboard;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.earlyfetch.EarlyFetchResult;
import com.facebook.earlyfetch.EarlyFetcher;
import com.facebook.events.dashboard.EventsPager.EventsPagerEarlyFetchFutureHolder;
import com.facebook.events.dashboard.EventsPager.EventsPagerEarlyFetchFutureHolder.C23741;
import com.facebook.events.data.EventsCommonContract;
import com.facebook.events.gating.ExperimentsForEventsGatingModule;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: commerce_product_edit_images_adapter */
public class EventsDashboardEarlyFetcher extends EarlyFetcher<Object, EventsPagerEarlyFetchFutureHolder> {
    public static final Object f16575a = new Object();
    private static volatile EventsDashboardEarlyFetcher f16576g;
    public final ListeningExecutorService f16577b;
    public final EventsCommonContract f16578c;
    private final GatekeeperStoreImpl f16579d;
    private final Provider<EventsPager> f16580e;
    public final QeAccessor f16581f;

    public static com.facebook.events.dashboard.EventsDashboardEarlyFetcher m16980a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f16576g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.events.dashboard.EventsDashboardEarlyFetcher.class;
        monitor-enter(r1);
        r0 = f16576g;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m16981b(r0);	 Catch:{ all -> 0x0035 }
        f16576g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f16576g;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.events.dashboard.EventsDashboardEarlyFetcher.a(com.facebook.inject.InjectorLike):com.facebook.events.dashboard.EventsDashboardEarlyFetcher");
    }

    private static EventsDashboardEarlyFetcher m16981b(InjectorLike injectorLike) {
        return new EventsDashboardEarlyFetcher(ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), EventsCommonContract.b(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 5559), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    public final void m16983a(Object obj) {
        EventsPagerEarlyFetchFutureHolder eventsPagerEarlyFetchFutureHolder = (EventsPagerEarlyFetchFutureHolder) obj;
        if (eventsPagerEarlyFetchFutureHolder != null) {
            if (eventsPagerEarlyFetchFutureHolder.f16908a != null) {
                eventsPagerEarlyFetchFutureHolder.f16908a.a(new C23741(eventsPagerEarlyFetchFutureHolder), eventsPagerEarlyFetchFutureHolder.f16913f);
            }
            if (eventsPagerEarlyFetchFutureHolder.f16911d != null) {
                eventsPagerEarlyFetchFutureHolder.f16911d.cancel(false);
            }
        }
    }

    @Inject
    public EventsDashboardEarlyFetcher(ListeningExecutorService listeningExecutorService, EventsCommonContract eventsCommonContract, GatekeeperStore gatekeeperStore, Provider<EventsPager> provider, QeAccessor qeAccessor) {
        this.f16577b = listeningExecutorService;
        this.f16578c = eventsCommonContract;
        this.f16579d = gatekeeperStore;
        this.f16580e = provider;
        this.f16581f = qeAccessor;
    }

    protected final boolean m16984b() {
        return this.f16579d.a(642, false);
    }

    protected final EarlyFetchResult<Object, EventsPagerEarlyFetchFutureHolder> m16982a(final Context context, Intent intent) {
        Object obj;
        String stringExtra = intent.getStringExtra("extra_dashboard_filter_type");
        if (stringExtra == null || DashboardFilterType.UPCOMING.toString().equals(stringExtra)) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            return null;
        }
        ListenableFuture a;
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(2131431107);
        Object obj2 = f16575a;
        EventsPager eventsPager = (EventsPager) this.f16580e.get();
        if (this.f16581f.a(ExperimentsForEventsGatingModule.v, false)) {
            a = this.f16577b.a(new Callable<Cursor>(this) {
                final /* synthetic */ EventsDashboardEarlyFetcher f16574b;

                public Object call() {
                    Cursor query = context.getContentResolver().query(this.f16574b.f16578c.d, null, null, null, null);
                    if (query != null) {
                        query.getCount();
                    }
                    return query;
                }
            });
        } else {
            a = null;
        }
        return new EarlyFetchResult(obj2, eventsPager.m17275a(a, dimensionPixelSize));
    }
}
