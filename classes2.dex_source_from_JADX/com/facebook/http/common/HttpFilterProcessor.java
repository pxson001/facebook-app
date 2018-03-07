package com.facebook.http.common;

import com.facebook.http.common.executorimpl.apache.AbortForwardingEntityEnclosingRequestWrapper;
import com.facebook.http.common.executorimpl.apache.AbortForwardingRequestWrapper;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBinderSet;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.client.methods.AbortableHttpRequest;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.EntityEnclosingRequestWrapper;
import org.apache.http.impl.client.RequestWrapper;

@Singleton
/* compiled from: registration_status */
public class HttpFilterProcessor {
    private static volatile HttpFilterProcessor f7775c;
    private final ImmutableList<HttpRequestFilter> f7776a;
    private final QeAccessor f7777b;

    /* compiled from: registration_status */
    class FilterComparator implements Comparator<HttpRequestFilter> {
        public int compare(Object obj, Object obj2) {
            HttpRequestFilter httpRequestFilter = (HttpRequestFilter) obj2;
            int a = ((HttpRequestFilter) obj).mo1679a();
            int a2 = httpRequestFilter.mo1679a();
            if (a < a2) {
                return -1;
            }
            return a == a2 ? 0 : 1;
        }
    }

    public static com.facebook.http.common.HttpFilterProcessor m12312a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7775c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.http.common.HttpFilterProcessor.class;
        monitor-enter(r1);
        r0 = f7775c;	 Catch:{ all -> 0x003a }
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
        r0 = m12314b(r0);	 Catch:{ all -> 0x0035 }
        f7775c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7775c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.http.common.HttpFilterProcessor.a(com.facebook.inject.InjectorLike):com.facebook.http.common.HttpFilterProcessor");
    }

    @javax.annotation.Nullable
    public final org.apache.http.impl.client.RequestWrapper m12315a(com.facebook.http.common.FbHttpRequest r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r6 = this;
        r0 = r7.m12228a();
        r2 = m12313a(r0);
        r0 = r6.f7776a;
        r3 = r0.size();
        r0 = 0;
        r1 = r0;
    L_0x0010:
        if (r1 >= r3) goto L_0x003d;
    L_0x0012:
        r0 = r6.f7776a;
        r0 = r0.get(r1);
        r0 = (com.facebook.http.common.HttpRequestFilter) r0;
        r4 = r0.getClass();
        r4 = r4.getSimpleName();
        r5 = -2134870887; // 0xffffffff80c07499 float:-1.7674243E-38 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r4, r5);
        r0.mo1680a(r2, r7);	 Catch:{ all -> 0x0035 }
        r0 = -1150475651; // 0xffffffffbb6d227d float:-0.0036183887 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r0);
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x0010;
    L_0x0035:
        r0 = move-exception;
        r1 = -1112899426; // 0xffffffffbdaa809e float:-0.08325313 double:NaN;
        com.facebook.tools.dextr.runtime.detour.TracerDetour.a(r1);
        throw r0;
    L_0x003d:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.http.common.HttpFilterProcessor.a(com.facebook.http.common.FbHttpRequest):org.apache.http.impl.client.RequestWrapper");
    }

    private static HttpFilterProcessor m12314b(InjectorLike injectorLike) {
        return new HttpFilterProcessor(new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$HttpRequestFilter(injectorLike)), QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    @Inject
    public HttpFilterProcessor(Set<HttpRequestFilter> set, QeAccessor qeAccessor) {
        Collection a = Lists.m1298a((Iterable) set);
        Collections.sort(a, new FilterComparator());
        this.f7776a = ImmutableList.copyOf(a);
        this.f7777b = qeAccessor;
    }

    private static RequestWrapper m12313a(HttpUriRequest httpUriRequest) {
        try {
            RequestWrapper abortForwardingEntityEnclosingRequestWrapper;
            if (httpUriRequest instanceof HttpEntityEnclosingRequest) {
                if (httpUriRequest instanceof AbortableHttpRequest) {
                    abortForwardingEntityEnclosingRequestWrapper = new AbortForwardingEntityEnclosingRequestWrapper((AbortableHttpRequest) httpUriRequest, (HttpEntityEnclosingRequest) httpUriRequest);
                } else {
                    abortForwardingEntityEnclosingRequestWrapper = new EntityEnclosingRequestWrapper((HttpEntityEnclosingRequest) httpUriRequest);
                }
            } else if (httpUriRequest instanceof AbortableHttpRequest) {
                abortForwardingEntityEnclosingRequestWrapper = new AbortForwardingRequestWrapper((AbortableHttpRequest) httpUriRequest, httpUriRequest);
            } else {
                abortForwardingEntityEnclosingRequestWrapper = new RequestWrapper(httpUriRequest);
            }
            abortForwardingEntityEnclosingRequestWrapper.resetHeaders();
            return abortForwardingEntityEnclosingRequestWrapper;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
