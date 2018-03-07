package com.facebook.http.onion.impl;

import com.facebook.debug.log.BLog;
import com.facebook.http.onion.OnionRewriteRule;
import com.facebook.http.onion.OnionRewriter$RuleChangeListener;
import com.facebook.http.onion.prefs.OnionRewriteXConfig;
import com.facebook.http.onion.prefs.OnionUtils;
import com.facebook.inject.InjectorLike;
import com.facebook.xconfig.core.XConfigReader;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.RequestWrapper;

@Singleton
/* compiled from: prompt_session_id */
public class FbOnionRewriter {
    private static final Class<FbOnionRewriter> f8750a = FbOnionRewriter.class;
    private static volatile FbOnionRewriter f8751h;
    public boolean f8752b;
    private OnionUtils f8753c;
    private ImmutableList<OnionRewriteRule> f8754d;
    private ImmutableList<String> f8755e;
    private ImmutableList<Pattern> f8756f;
    public final List<OnionRewriter$RuleChangeListener> f8757g = new ArrayList();

    public static com.facebook.http.onion.impl.FbOnionRewriter m13596a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8751h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.http.onion.impl.FbOnionRewriter.class;
        monitor-enter(r1);
        r0 = f8751h;	 Catch:{ all -> 0x003a }
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
        r0 = m13597b(r0);	 Catch:{ all -> 0x0035 }
        f8751h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8751h;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.http.onion.impl.FbOnionRewriter.a(com.facebook.inject.InjectorLike):com.facebook.http.onion.impl.FbOnionRewriter");
    }

    private static FbOnionRewriter m13597b(InjectorLike injectorLike) {
        return new FbOnionRewriter(OnionUtils.m9473a(injectorLike));
    }

    @Inject
    public FbOnionRewriter(OnionUtils onionUtils) {
        this.f8753c = onionUtils;
    }

    private boolean m13599c() {
        return this.f8752b;
    }

    public final ImmutableList<OnionRewriteRule> m13603a() {
        if (this.f8752b) {
            return m13600e();
        }
        return RegularImmutableList.f535a;
    }

    public final String m13604a(String str) {
        if (this.f8752b && !m13598b(str)) {
            ImmutableList e = m13600e();
            int size = e.size();
            for (int i = 0; i < size; i++) {
                str = ((OnionRewriteRule) e.get(i)).a(str);
            }
        }
        return str;
    }

    public final ImmutableList<String> m13607b() {
        if (this.f8752b) {
            return m13601f();
        }
        return RegularImmutableList.f535a;
    }

    public final HttpUriRequest m13605a(HttpUriRequest httpUriRequest) {
        if (!m13599c()) {
            return httpUriRequest;
        }
        String uri = httpUriRequest.getURI().toString();
        if (m13598b(uri)) {
            return httpUriRequest;
        }
        ImmutableList e = m13600e();
        int size = e.size();
        String str = uri;
        for (int i = 0; i < size; i++) {
            str = ((OnionRewriteRule) e.get(i)).a(str);
        }
        try {
            RequestWrapper requestWrapper = new RequestWrapper(httpUriRequest);
            requestWrapper.setURI(new URI(str));
            return requestWrapper;
        } catch (Throwable e2) {
            BLog.b(f8750a, "Failed to parse rewritten URI", e2);
            return httpUriRequest;
        } catch (Throwable e22) {
            BLog.b(f8750a, "Failed to create wrapped request", e22);
            return httpUriRequest;
        }
    }

    private boolean m13598b(String str) {
        ImmutableList g = m13602g();
        int size = g.size();
        for (int i = 0; i < size; i++) {
            if (((Pattern) g.get(i)).matcher(str).matches()) {
                return true;
            }
        }
        return false;
    }

    private ImmutableList<OnionRewriteRule> m13600e() {
        if (this.f8754d == null || this.f8754d.isEmpty()) {
            this.f8754d = ImmutableList.copyOf((Collection) OnionRewriteXConfig.a(((XConfigReader) this.f8753c.f5566d.get()).m2685a(OnionRewriteXConfig.c, "[]")));
        }
        return this.f8754d;
    }

    private ImmutableList<String> m13601f() {
        if (this.f8755e == null) {
            this.f8755e = ImmutableList.copyOf((Collection) OnionRewriteXConfig.b(((XConfigReader) this.f8753c.f5566d.get()).m2685a(OnionRewriteXConfig.d, "[]")));
        }
        return this.f8755e;
    }

    private ImmutableList<Pattern> m13602g() {
        if (this.f8756f == null) {
            Builder builder = ImmutableList.builder();
            ImmutableList f = m13601f();
            int size = f.size();
            for (int i = 0; i < size; i++) {
                builder.m1069c(Pattern.compile((String) f.get(i)));
            }
            this.f8756f = builder.m1068b();
        }
        return this.f8756f;
    }

    public final void m13606a(OnionRewriter$RuleChangeListener onionRewriter$RuleChangeListener) {
        if (onionRewriter$RuleChangeListener != null) {
            this.f8757g.add(onionRewriter$RuleChangeListener);
        }
    }
}
