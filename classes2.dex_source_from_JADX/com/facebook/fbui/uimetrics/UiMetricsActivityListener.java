package com.facebook.fbui.uimetrics;

import android.app.Activity;
import android.support.v4.util.Pools$SimplePool;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.tagging.CurrentModuleHolder;
import com.facebook.analytics.tagging.ModuleInfo;
import com.facebook.common.util.TriState;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import java.lang.ref.WeakReference;
import javax.inject.Inject;
import javax.inject.Singleton;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Singleton
/* compiled from: qp/%s?data=%s&fallback_url=%s */
public class UiMetricsActivityListener {
    private static volatile UiMetricsActivityListener f8522g;
    public AnalyticsLogger f8523a;
    public CurrentModuleHolder f8524b;
    private GatekeeperStoreImpl f8525c;
    public WeakReference<View> f8526d;
    private Pools$SimplePool<JSONObject> f8527e = null;
    public final Runnable f8528f = new C03741(this);

    /* compiled from: qp/%s?data=%s&fallback_url=%s */
    class C03741 implements Runnable {
        final /* synthetic */ UiMetricsActivityListener f8529a;

        C03741(UiMetricsActivityListener uiMetricsActivityListener) {
            this.f8529a = uiMetricsActivityListener;
        }

        public void run() {
            View view = this.f8529a.f8526d != null ? (View) this.f8529a.f8526d.get() : null;
            if (view != null && UiMetricsActivityListener.m13073b(this.f8529a)) {
                JSONObject a = UiMetricsActivityListener.m13067a(this.f8529a, view);
                ModuleInfo c = this.f8529a.f8524b.m5555c();
                String str = "null";
                String str2 = "none";
                if (c != null) {
                    str = c.f8471b;
                    str2 = c.f8470a;
                    if (str2 == null || "unknown".equals(str2)) {
                        str2 = "none";
                    }
                }
                HoneyAnalyticsEvent honeyClientEvent = new HoneyClientEvent("ui_metrics_views_hierarchy");
                honeyClientEvent.f3099c = "ui_metrics";
                honeyClientEvent.m5090b("views", a.toString());
                honeyClientEvent.m5090b("module", str2);
                honeyClientEvent.m5090b("screen", str);
                honeyClientEvent.m5090b("os_type", "android");
                this.f8529a.f8523a.mo526a(honeyClientEvent);
                UiMetricsActivityListener.m13068a(this.f8529a, a);
                view.postDelayed(this, 5000);
            }
        }
    }

    public static com.facebook.fbui.uimetrics.UiMetricsActivityListener m13066a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8522g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.fbui.uimetrics.UiMetricsActivityListener.class;
        monitor-enter(r1);
        r0 = f8522g;	 Catch:{ all -> 0x003a }
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
        r0 = m13071b(r0);	 Catch:{ all -> 0x0035 }
        f8522g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8522g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.fbui.uimetrics.UiMetricsActivityListener.a(com.facebook.inject.InjectorLike):com.facebook.fbui.uimetrics.UiMetricsActivityListener");
    }

    private static UiMetricsActivityListener m13071b(InjectorLike injectorLike) {
        return new UiMetricsActivityListener(AnalyticsLoggerMethodAutoProvider.m3509a(injectorLike), CurrentModuleHolder.m5545a(injectorLike), GatekeeperStoreImplMethodAutoProvider.m2131a(injectorLike));
    }

    @Inject
    public UiMetricsActivityListener(AnalyticsLogger analyticsLogger, CurrentModuleHolder currentModuleHolder, GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f8523a = analyticsLogger;
        this.f8524b = currentModuleHolder;
        this.f8525c = gatekeeperStoreImpl;
    }

    public final void m13075a(Activity activity) {
        if (m13073b(this)) {
            if (this.f8527e == null) {
                this.f8527e = new Pools$SimplePool(512);
            }
            View decorView = activity.getWindow().getDecorView();
            this.f8526d = new WeakReference(decorView);
            decorView.postDelayed(this.f8528f, 5000);
        }
    }

    public static JSONObject m13067a(UiMetricsActivityListener uiMetricsActivityListener, View view) {
        JSONObject c = uiMetricsActivityListener.m13074c();
        try {
            JSONObject b = uiMetricsActivityListener.m13072b(view);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(b);
            c.put("children", jSONArray);
        } catch (JSONException e) {
        }
        return c;
    }

    private JSONObject m13072b(View view) {
        if (view == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        if (view instanceof ViewGroup) {
            int childCount = ((ViewGroup) view).getChildCount();
            for (int i = 0; i < childCount; i++) {
                jSONArray.put(m13072b(((ViewGroup) view).getChildAt(i)));
            }
        }
        JSONObject c = m13074c();
        try {
            JSONObject c2 = m13074c();
            c2.put("x", view.getTop());
            c2.put("y", view.getLeft());
            c2.put("width", view.getWidth());
            c2.put("height", view.getHeight());
            JSONObject c3 = m13074c();
            c3.put("type", "view");
            c3.put("class", view.getClass().getName());
            c3.put("rectangle", c2);
            c.put("node", c3);
            c.put("children", jSONArray);
            return c;
        } catch (JSONException e) {
            return c;
        }
    }

    public static boolean m13073b(UiMetricsActivityListener uiMetricsActivityListener) {
        return uiMetricsActivityListener.f8525c.m2185a(1162) == TriState.YES;
    }

    private void m13069a(Object obj) {
        if (obj instanceof JSONObject) {
            m13068a(this, (JSONObject) obj);
        } else if (obj instanceof JSONArray) {
            m13070a((JSONArray) obj);
        }
    }

    private JSONObject m13074c() {
        JSONObject jSONObject = (JSONObject) this.f8527e.mo740a();
        if (jSONObject == null) {
            return new JSONObject();
        }
        return jSONObject;
    }

    public static void m13068a(UiMetricsActivityListener uiMetricsActivityListener, JSONObject jSONObject) {
        JSONArray names = jSONObject.names();
        int length = names.length();
        for (int i = 0; i < length; i++) {
            try {
                String str = (String) names.get(i);
                Object obj = jSONObject.get(str);
                jSONObject.remove(str);
                uiMetricsActivityListener.m13069a(obj);
            } catch (JSONException e) {
            }
        }
        uiMetricsActivityListener.f8527e.mo741a(jSONObject);
    }

    private void m13070a(JSONArray jSONArray) {
        if (jSONArray.length() > 0) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                try {
                    m13069a(jSONArray.get(i));
                    jSONArray.put(i, null);
                } catch (JSONException e) {
                }
            }
        }
    }
}
