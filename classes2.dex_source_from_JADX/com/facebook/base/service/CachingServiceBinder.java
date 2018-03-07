package com.facebook.base.service;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: mLastConnectionMs */
public class CachingServiceBinder {
    private static volatile CachingServiceBinder f15538c;
    private final DefaultContextServiceBinder f15539a;
    @GuardedBy("this")
    private Map<ComponentName, BindingRecord> f15540b = Maps.m838c();

    public static com.facebook.base.service.CachingServiceBinder m22154a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f15538c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.base.service.CachingServiceBinder.class;
        monitor-enter(r1);
        r0 = f15538c;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.m1499a();	 Catch:{ all -> 0x003a }
        r3 = r2.m1503b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m22157b(r0);	 Catch:{ all -> 0x0035 }
        f15538c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f15538c;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.m1338a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.m1505c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.base.service.CachingServiceBinder.a(com.facebook.inject.InjectorLike):com.facebook.base.service.CachingServiceBinder");
    }

    private static CachingServiceBinder m22157b(InjectorLike injectorLike) {
        return new CachingServiceBinder(DefaultContextServiceBinder.m22161b(injectorLike));
    }

    @Inject
    public CachingServiceBinder(DefaultContextServiceBinder defaultContextServiceBinder) {
        this.f15539a = defaultContextServiceBinder;
    }

    public final synchronized CachedBindServiceResult m22159a(Intent intent, ServiceConnection serviceConnection, int i) {
        CachedBindServiceResult cachedBindServiceResult;
        boolean z = true;
        synchronized (this) {
            BindingRecord bindingRecord;
            Preconditions.checkNotNull(intent);
            Preconditions.checkNotNull(serviceConnection);
            ComponentName component = intent.getComponent();
            Preconditions.checkArgument(component != null, "Bindings are cached by specific service components but none was specified");
            BindingRecord bindingRecord2 = (BindingRecord) this.f15540b.get(component);
            if (bindingRecord2 == null) {
                bindingRecord2 = new BindingRecord(component, new InternalServiceConnection(this), i);
                this.f15540b.put(component, bindingRecord2);
                bindingRecord = bindingRecord2;
            } else {
                if (bindingRecord2.d != i) {
                    z = false;
                }
                Preconditions.checkArgument(z, "Inconsistent binding flags provided: got %d, expected %d", Integer.valueOf(i), Integer.valueOf(bindingRecord2.d));
                bindingRecord = bindingRecord2;
            }
            bindingRecord.c.add(serviceConnection);
            if (bindingRecord.e) {
                cachedBindServiceResult = new CachedBindServiceResult(true, bindingRecord.f);
            } else {
                boolean a = this.f15539a.m22163a(intent, bindingRecord.b, bindingRecord.d);
                bindingRecord.e = true;
                if (!a) {
                    this.f15540b.remove(component);
                }
                cachedBindServiceResult = new CachedBindServiceResult(a, null);
            }
        }
        return cachedBindServiceResult;
    }

    public final synchronized void m22160a(ServiceConnection serviceConnection) {
        Iterator it = this.f15540b.values().iterator();
        while (it.hasNext()) {
            BindingRecord bindingRecord = (BindingRecord) it.next();
            if (bindingRecord.c.remove(serviceConnection) && bindingRecord.c.isEmpty()) {
                it.remove();
                this.f15539a.m22162a(bindingRecord.b);
            }
        }
    }

    public static void m22158b(CachingServiceBinder cachingServiceBinder, @Nullable ComponentName componentName, IBinder iBinder) {
        Set set = null;
        synchronized (cachingServiceBinder) {
            BindingRecord b = cachingServiceBinder.m22156b(componentName);
            if (b != null) {
                b.f = iBinder;
                set = ImmutableSet.copyOf(b.c);
            }
        }
        if (r0 != null) {
            for (ServiceConnection serviceConnection : r0) {
                if (cachingServiceBinder.m22155a(b, serviceConnection)) {
                    if (iBinder != null) {
                        serviceConnection.onServiceConnected(componentName, iBinder);
                    } else {
                        serviceConnection.onServiceDisconnected(componentName);
                    }
                }
            }
        }
    }

    private synchronized boolean m22155a(BindingRecord bindingRecord, ServiceConnection serviceConnection) {
        return bindingRecord.c.contains(serviceConnection);
    }

    @Nullable
    private synchronized BindingRecord m22156b(ComponentName componentName) {
        return (BindingRecord) this.f15540b.get(componentName);
    }
}
