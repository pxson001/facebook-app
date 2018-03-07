package com.facebook.api.feed.xconfig;

import com.facebook.common.network.FbDataConnectionManager;
import com.facebook.inject.InjectorLike;
import com.facebook.xconfig.core.XConfigReader;
import com.facebook.xconfig.core.XConfigSetting;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.json.JSONException;
import org.json.JSONObject;

@Singleton
/* compiled from: sms_upsell/ */
public class NewsFeedXConfigReader {
    private static volatile NewsFeedXConfigReader f4484G;
    private volatile JSONObject f4485A;
    private volatile JSONObject f4486B;
    private volatile boolean f4487C = true;
    private volatile JSONObject f4488D;
    private volatile boolean f4489E = true;
    public volatile int f4490F = -1;
    public final XConfigReader f4491a;
    private final FbDataConnectionManager f4492b;
    public volatile int f4493c = -1;
    public volatile int f4494d = -1;
    public volatile int f4495e = -1;
    private volatile int f4496f = -1;
    private volatile int f4497g = -1;
    private volatile int f4498h = -1;
    private volatile int f4499i = -1;
    private volatile int f4500j = -1;
    private volatile int f4501k = -1;
    private volatile int f4502l = -1;
    private volatile int f4503m = -1;
    public volatile int f4504n = -1;
    public volatile int f4505o = -1;
    public volatile int f4506p = -1;
    public volatile int f4507q = -1;
    public volatile int f4508r = -1;
    public volatile int f4509s = -1;
    private volatile boolean f4510t = true;
    private volatile JSONObject f4511u = null;
    private volatile boolean f4512v = true;
    private volatile JSONObject f4513w = null;
    private volatile boolean f4514x = true;
    private volatile JSONObject f4515y = null;
    private volatile boolean f4516z = true;

    public static com.facebook.api.feed.xconfig.NewsFeedXConfigReader m8187a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4484G;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.api.feed.xconfig.NewsFeedXConfigReader.class;
        monitor-enter(r1);
        r0 = f4484G;	 Catch:{ all -> 0x003a }
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
        r0 = m8189b(r0);	 Catch:{ all -> 0x0035 }
        f4484G = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4484G;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.api.feed.xconfig.NewsFeedXConfigReader.a(com.facebook.inject.InjectorLike):com.facebook.api.feed.xconfig.NewsFeedXConfigReader");
    }

    private static NewsFeedXConfigReader m8189b(InjectorLike injectorLike) {
        return new NewsFeedXConfigReader(XConfigReader.m2681a(injectorLike), FbDataConnectionManager.m3787a(injectorLike));
    }

    @Inject
    public NewsFeedXConfigReader(XConfigReader xConfigReader, FbDataConnectionManager fbDataConnectionManager) {
        this.f4491a = xConfigReader;
        this.f4492b = fbDataConnectionManager;
    }

    public final int m8193e() {
        if (this.f4496f == -1) {
            this.f4496f = this.f4491a.m2683a(NewsFeedXConfig.f5001g, 10);
        }
        return this.f4496f;
    }

    private int m8190w() {
        if (this.f4497g == -1) {
            this.f4497g = this.f4491a.m2683a(NewsFeedXConfig.f5002h, 10);
        }
        return this.f4497g;
    }

    public final int m8194f() {
        if (this.f4498h == -1) {
            this.f4498h = this.f4491a.m2683a(NewsFeedXConfig.f5003i, 20);
        }
        return this.f4498h;
    }

    public final int m8195g() {
        if (this.f4499i == -1) {
            this.f4499i = this.f4491a.m2683a(NewsFeedXConfig.f5004j, 10);
        }
        return this.f4499i;
    }

    public final int m8196h() {
        if (this.f4500j == -1) {
            this.f4500j = this.f4491a.m2683a(NewsFeedXConfig.f5005k, 540000);
        }
        return this.f4500j;
    }

    private int m8191x() {
        if (this.f4501k == -1) {
            this.f4501k = this.f4491a.m2683a(NewsFeedXConfig.f5006l, 2);
        }
        return this.f4501k;
    }

    private int m8192y() {
        if (this.f4502l == -1) {
            this.f4502l = this.f4491a.m2683a(NewsFeedXConfig.f5007m, 5);
        }
        return this.f4502l;
    }

    public final int m8197i() {
        if (this.f4503m == -1) {
            this.f4503m = this.f4491a.m2683a(NewsFeedXConfig.f5013s, 72);
        }
        return this.f4503m;
    }

    public final int m8198m() {
        if (!this.f4510t) {
            return m8190w();
        }
        try {
            if (this.f4511u == null) {
                this.f4511u = m8188a(NewsFeedXConfig.f5008n);
            }
            return m8186a(this.f4511u);
        } catch (JSONException e) {
            this.f4510t = false;
            return m8190w();
        }
    }

    public final int m8199n() {
        if (!this.f4512v) {
            return m8191x();
        }
        try {
            if (this.f4513w == null) {
                this.f4513w = m8188a(NewsFeedXConfig.f5009o);
            }
            return m8186a(this.f4513w);
        } catch (JSONException e) {
            this.f4512v = false;
            return m8191x();
        }
    }

    public final int m8200o() {
        if (!this.f4514x) {
            return m8192y();
        }
        try {
            if (this.f4515y == null) {
                this.f4515y = m8188a(NewsFeedXConfig.f5010p);
            }
            return m8186a(this.f4515y);
        } catch (JSONException e) {
            this.f4514x = false;
            return m8192y();
        }
    }

    public final int m8201p() {
        if (!this.f4516z) {
            return m8199n();
        }
        try {
            if (this.f4485A == null) {
                this.f4485A = m8188a(NewsFeedXConfig.f5011q);
            }
            return m8186a(this.f4485A);
        } catch (JSONException e) {
            this.f4516z = false;
            return m8199n();
        }
    }

    public final int m8202q() {
        if (!this.f4487C) {
            return m8200o();
        }
        try {
            if (this.f4486B == null) {
                this.f4486B = m8188a(NewsFeedXConfig.f5012r);
            }
            return m8186a(this.f4486B);
        } catch (JSONException e) {
            this.f4487C = false;
            return m8200o();
        }
    }

    public final boolean m8203r() {
        if (!this.f4489E) {
            return true;
        }
        try {
            if (this.f4488D == null) {
                this.f4488D = m8188a(NewsFeedXConfig.f5017w);
            }
            if (m8186a(this.f4488D) == 1) {
                return true;
            }
            return false;
        } catch (JSONException e) {
            this.f4489E = false;
            return true;
        }
    }

    private JSONObject m8188a(XConfigSetting xConfigSetting) {
        return new JSONObject(this.f4491a.m2685a(xConfigSetting, ""));
    }

    private int m8186a(JSONObject jSONObject) {
        return jSONObject.getInt(this.f4492b.m3801c().name().toLowerCase());
    }

    public final boolean m8204u() {
        return this.f4491a.m2686a(NewsFeedXConfig.f5016v, false);
    }
}
