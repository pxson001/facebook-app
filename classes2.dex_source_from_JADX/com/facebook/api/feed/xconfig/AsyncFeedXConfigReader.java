package com.facebook.api.feed.xconfig;

import com.facebook.common.network.FbDataConnectionManager;
import com.facebook.inject.InjectorLike;
import com.facebook.xconfig.core.XConfigReader;
import com.facebook.xconfig.core.XConfigSetting;
import java.util.Locale;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.json.JSONException;
import org.json.JSONObject;

@Singleton
/* compiled from: session_scan_success_count */
public class AsyncFeedXConfigReader {
    private static volatile AsyncFeedXConfigReader f5418k;
    private final XConfigReader f5419a;
    private final FbDataConnectionManager f5420b;
    private final int[] f5421c = new int[AsyncFeedXConfig.f5437I.size()];
    private final boolean[] f5422d = new boolean[AsyncFeedXConfig.f5437I.size()];
    private final boolean[] f5423e = new boolean[AsyncFeedXConfig.f5438J.size()];
    private final boolean[] f5424f = new boolean[AsyncFeedXConfig.f5438J.size()];
    private final JSONObject[] f5425g = new JSONObject[AsyncFeedXConfig.f5439K.size()];
    private final boolean[] f5426h = new boolean[AsyncFeedXConfig.f5439K.size()];
    private final String[] f5427i = new String[AsyncFeedXConfig.f5440L.size()];
    private final boolean[] f5428j = new boolean[AsyncFeedXConfig.f5440L.size()];

    public static com.facebook.api.feed.xconfig.AsyncFeedXConfigReader m9332a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f5418k;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.api.feed.xconfig.AsyncFeedXConfigReader.class;
        monitor-enter(r1);
        r0 = f5418k;	 Catch:{ all -> 0x003a }
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
        r0 = m9337b(r0);	 Catch:{ all -> 0x0035 }
        f5418k = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f5418k;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.api.feed.xconfig.AsyncFeedXConfigReader.a(com.facebook.inject.InjectorLike):com.facebook.api.feed.xconfig.AsyncFeedXConfigReader");
    }

    private static AsyncFeedXConfigReader m9337b(InjectorLike injectorLike) {
        return new AsyncFeedXConfigReader(XConfigReader.m2681a(injectorLike), FbDataConnectionManager.m3787a(injectorLike));
    }

    @Inject
    public AsyncFeedXConfigReader(XConfigReader xConfigReader, FbDataConnectionManager fbDataConnectionManager) {
        this.f5419a = xConfigReader;
        this.f5420b = fbDataConnectionManager;
    }

    public final int m9338a(int i) {
        return m9331a(AsyncFeedXConfig.f5443d, 0, i);
    }

    public final int m9342b(int i) {
        return m9331a(AsyncFeedXConfig.f5444e, 1, i);
    }

    public final int m9345c(int i) {
        return m9331a(AsyncFeedXConfig.f5445f, 2, i);
    }

    public final int m9347d(int i) {
        return m9331a(AsyncFeedXConfig.f5451l, 7, i);
    }

    public final int m9349e(int i) {
        return m9331a(AsyncFeedXConfig.f5433E, 15, i);
    }

    public final int m9351f(int i) {
        return m9331a(AsyncFeedXConfig.f5460u, 12, i);
    }

    public final int m9353g(int i) {
        return m9331a(AsyncFeedXConfig.f5461v, 13, i);
    }

    public final int m9355h(int i) {
        return m9331a(AsyncFeedXConfig.f5462w, 14, i);
    }

    public final int m9357i(int i) {
        return m9331a(AsyncFeedXConfig.f5436H, 16, i);
    }

    public final boolean m9341a(boolean z) {
        return m9335a(AsyncFeedXConfig.f5465z, 2, z);
    }

    public final boolean m9344b(boolean z) {
        return m9335a(AsyncFeedXConfig.f5454o, 4, z);
    }

    public final boolean m9346c(boolean z) {
        return m9335a(AsyncFeedXConfig.f5455p, 5, z);
    }

    public final boolean m9348d(boolean z) {
        return m9335a(AsyncFeedXConfig.f5456q, 6, z);
    }

    public final boolean m9350e(boolean z) {
        return m9335a(AsyncFeedXConfig.f5457r, 7, z);
    }

    public final boolean m9352f(boolean z) {
        return m9335a(AsyncFeedXConfig.f5458s, 9, z);
    }

    public final boolean m9354g(boolean z) {
        return m9335a(AsyncFeedXConfig.f5435G, 8, z);
    }

    @Nullable
    public final JSONObject m9340a(JSONObject jSONObject) {
        return m9334a(AsyncFeedXConfig.f5430B, 0, jSONObject);
    }

    public final boolean m9356h(boolean z) {
        JSONObject a = m9334a(AsyncFeedXConfig.f5434F, 1, null);
        if (a == null) {
            return z;
        }
        try {
            return m9336b(a) == 1;
        } catch (JSONException e) {
            return z;
        }
    }

    public final String m9339a(String str) {
        return m9333a(AsyncFeedXConfig.f5431C, 0, str);
    }

    public final String m9343b(String str) {
        return m9333a(AsyncFeedXConfig.f5432D, 1, str);
    }

    private int m9331a(XConfigSetting xConfigSetting, int i, int i2) {
        if (!this.f5422d[i]) {
            this.f5421c[i] = this.f5419a.m2683a(xConfigSetting, i2);
            this.f5422d[i] = true;
        }
        return this.f5421c[i];
    }

    private boolean m9335a(XConfigSetting xConfigSetting, int i, boolean z) {
        if (!this.f5424f[i]) {
            this.f5423e[i] = this.f5419a.m2686a(xConfigSetting, z);
            this.f5424f[i] = true;
        }
        return this.f5423e[i];
    }

    @Nullable
    private JSONObject m9334a(XConfigSetting xConfigSetting, int i, JSONObject jSONObject) {
        if (!this.f5426h[i]) {
            try {
                this.f5425g[i] = new JSONObject(this.f5419a.m2685a(xConfigSetting, null));
                if (this.f5425g[i] == null) {
                    return jSONObject;
                }
                this.f5426h[i] = true;
            } catch (JSONException e) {
                return jSONObject;
            } catch (NullPointerException e2) {
                return jSONObject;
            }
        }
        return this.f5425g[i];
    }

    private String m9333a(XConfigSetting xConfigSetting, int i, String str) {
        if (!this.f5428j[i]) {
            this.f5427i[i] = this.f5419a.m2685a(xConfigSetting, str);
            this.f5428j[i] = true;
        }
        return this.f5427i[i];
    }

    private int m9336b(JSONObject jSONObject) {
        return jSONObject.getInt(this.f5420b.m3801c().name().toLowerCase(Locale.US));
    }
}
