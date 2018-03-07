package com.facebook.platform.webdialogs;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.init.INeedInit;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.locale.Locales;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.time.SystemClock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.config.server.NetworkLogUrl;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.BlueServiceOperationFactory;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.platform.webdialogs.PlatformWebDialogsFragment.2;
import com.facebook.platform.webdialogs.PlatformWebViewActionManifest.FetchState;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;
import org.json.JSONException;
import org.json.JSONObject;

@Singleton
/* compiled from: lockscreen_show_messenger */
public class PlatformWebDialogsManifest implements INeedInit {
    private static volatile PlatformWebDialogsManifest f9031v;
    public final AtomicBoolean f9032a = new AtomicBoolean();
    public final AtomicBoolean f9033b = new AtomicBoolean();
    public final AtomicBoolean f9034c = new AtomicBoolean();
    public long f9035d = 0;
    private String f9036e;
    private HashMap<String, PlatformWebViewActionManifest> f9037f;
    private HashMap<String, PlatformWebViewActionManifest> f9038g;
    public HashMap<RefreshCallback, String> f9039h;
    private List<PlatformWebViewActionManifest> f9040i;
    public ListenableFuture<OperationResult> f9041j;
    public ListenableFuture<OperationResult> f9042k;
    private final Context f9043l;
    public final DefaultBlueServiceOperationFactory f9044m;
    public final Executor f9045n;
    private final Provider<String> f9046o;
    public final PlatformWebDialogsCache f9047p;
    private final SystemClock f9048q;
    public final AbstractFbErrorReporter f9049r;
    public final FbSharedPreferences f9050s;
    public final DefaultAndroidThreadUtil f9051t;
    private final Locales f9052u;

    /* compiled from: lockscreen_show_messenger */
    public class C05412 implements FutureCallback<OperationResult> {
        final /* synthetic */ PlatformWebDialogsManifest f11229a;

        public C05412(PlatformWebDialogsManifest platformWebDialogsManifest) {
            this.f11229a = platformWebDialogsManifest;
        }

        public void onSuccess(Object obj) {
            PlatformWebDialogsManifest.m9377a(this.f11229a, (ManifestWrapper) ((OperationResult) obj).k());
        }

        public void onFailure(Throwable th) {
            PlatformWebDialogsManifest.m9377a(this.f11229a, null);
        }
    }

    @AutoGenJsonDeserializer
    @JsonDeserialize(using = PlatformWebDialogsManifest_ManifestWrapperDeserializer.class)
    /* compiled from: lockscreen_show_messenger */
    public class ManifestWrapper implements Parcelable {
        public static final Creator<ManifestWrapper> CREATOR = new C06451();
        @JsonProperty("actionManifests")
        private List<PlatformWebViewActionManifest> mActionManifests;
        @JsonProperty("manifestUrl")
        private String mLastManifestUrl;
        @JsonProperty("timestamp")
        private long mLastRefreshTimestamp;

        /* compiled from: lockscreen_show_messenger */
        final class C06451 implements Creator<ManifestWrapper> {
            C06451() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new ManifestWrapper(parcel);
            }

            public final Object[] newArray(int i) {
                return new ManifestWrapper[i];
            }
        }

        public ManifestWrapper(Parcel parcel) {
            this.mLastRefreshTimestamp = parcel.readLong();
            this.mLastManifestUrl = parcel.readString();
            this.mActionManifests = Lists.a();
            parcel.readList(this.mActionManifests, PlatformWebDialogsManifest.class.getClassLoader());
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.mLastRefreshTimestamp);
            parcel.writeString(this.mLastManifestUrl);
            parcel.writeList(this.mActionManifests);
        }

        public int describeContents() {
            return 0;
        }

        public final void m11789a(ArrayList<PlatformWebViewActionManifest> arrayList) {
            this.mActionManifests = arrayList;
        }

        public final void m11787a(long j) {
            this.mLastRefreshTimestamp = j;
        }

        public final void m11788a(String str) {
            this.mLastManifestUrl = str;
        }

        public final Iterable<PlatformWebViewActionManifest> m11786a() {
            return this.mActionManifests == null ? null : Iterables.a(this.mActionManifests);
        }

        public final long m11790b() {
            return this.mLastRefreshTimestamp;
        }

        public final String m11791c() {
            return this.mLastManifestUrl;
        }
    }

    public static com.facebook.platform.webdialogs.PlatformWebDialogsManifest m9372a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9031v;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.platform.webdialogs.PlatformWebDialogsManifest.class;
        monitor-enter(r1);
        r0 = f9031v;	 Catch:{ all -> 0x003a }
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
        r0 = m9381b(r0);	 Catch:{ all -> 0x0035 }
        f9031v = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9031v;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.platform.webdialogs.PlatformWebDialogsManifest.a(com.facebook.inject.InjectorLike):com.facebook.platform.webdialogs.PlatformWebDialogsManifest");
    }

    private static PlatformWebDialogsManifest m9381b(InjectorLike injectorLike) {
        return new PlatformWebDialogsManifest((Context) injectorLike.getInstance(Context.class), DefaultBlueServiceOperationFactory.b(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), PlatformWebDialogsCache.m9392a(injectorLike), SystemClockMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), IdBasedProvider.a(injectorLike, 4442), DefaultAndroidThreadUtil.b(injectorLike), Locales.a(injectorLike));
    }

    @Inject
    public PlatformWebDialogsManifest(Context context, BlueServiceOperationFactory blueServiceOperationFactory, Executor executor, PlatformWebDialogsCache platformWebDialogsCache, SystemClock systemClock, FbErrorReporter fbErrorReporter, FbSharedPreferences fbSharedPreferences, Provider<String> provider, AndroidThreadUtil androidThreadUtil, Locales locales) {
        this.f9043l = context;
        this.f9044m = blueServiceOperationFactory;
        this.f9045n = executor;
        this.f9047p = platformWebDialogsCache;
        this.f9037f = Maps.c();
        this.f9038g = Maps.c();
        this.f9039h = Maps.c();
        this.f9040i = Lists.b();
        this.f9048q = systemClock;
        this.f9049r = fbErrorReporter;
        this.f9050s = fbSharedPreferences;
        this.f9046o = provider;
        this.f9051t = androidThreadUtil;
        this.f9052u = locales;
    }

    public void init() {
        m9379a(false);
    }

    private void m9379a(final boolean z) {
        this.f9050s.a(new Runnable(this) {
            final /* synthetic */ PlatformWebDialogsManifest f11162b;

            /* compiled from: lockscreen_show_messenger */
            class C05401 implements Runnable {
                final /* synthetic */ C05391 f11173a;

                C05401(C05391 c05391) {
                    this.f11173a = c05391;
                }

                public void run() {
                    this.f11173a.f11162b.m9389a();
                }
            }

            public void run() {
                if (this.f11162b.f9032a.compareAndSet(false, true)) {
                    this.f11162b.f9035d = this.f11162b.f9050s.a(PlatformWebDialogsPrefKeys.f11172j, 0);
                }
                if (z) {
                    PlatformWebDialogsManifest platformWebDialogsManifest = this.f11162b;
                    platformWebDialogsManifest.f9051t.b();
                    if (!platformWebDialogsManifest.f9034c.compareAndSet(false, true)) {
                        return;
                    }
                    if (platformWebDialogsManifest.f9033b.get()) {
                        platformWebDialogsManifest.f9034c.set(false);
                        return;
                    } else {
                        Futures.a(BlueServiceOperationFactoryDetour.a(platformWebDialogsManifest.f9044m, "platform_webdialogs_load_manifest", new Bundle(), 72007298).a(), new C05412(platformWebDialogsManifest), platformWebDialogsManifest.f9045n);
                        return;
                    }
                }
                ExecutorDetour.a(this.f11162b.f9045n, new C05401(this), 1363398615);
            }
        });
    }

    public static void m9377a(PlatformWebDialogsManifest platformWebDialogsManifest, ManifestWrapper manifestWrapper) {
        platformWebDialogsManifest.f9051t.a();
        platformWebDialogsManifest.f9033b.set(true);
        platformWebDialogsManifest.f9034c.set(false);
        if (manifestWrapper != null) {
            platformWebDialogsManifest.f9035d = manifestWrapper.m11790b();
            platformWebDialogsManifest.f9036e = manifestWrapper.m11791c();
            Iterable<PlatformWebViewActionManifest> a = manifestWrapper.m11786a();
            if (a != null) {
                for (PlatformWebViewActionManifest platformWebViewActionManifest : a) {
                    platformWebDialogsManifest.f9037f.put(platformWebViewActionManifest.m12487a(), platformWebViewActionManifest);
                }
            }
            platformWebDialogsManifest.m9385g();
        }
        if (!platformWebDialogsManifest.f9039h.isEmpty()) {
            HashMap c = Maps.c();
            String str = null;
            for (Entry entry : platformWebDialogsManifest.f9039h.entrySet()) {
                PlatformWebViewActionManifest a2;
                2 2 = (2) entry.getKey();
                String str2 = (String) entry.getValue();
                if (str2 != null) {
                    a2 = platformWebDialogsManifest.m9388a(str2);
                } else {
                    a2 = null;
                }
                if (a2 == null) {
                    c.put(2, str2);
                    str = str2;
                } else {
                    2.a(a2, false);
                    2.a();
                }
            }
            platformWebDialogsManifest.f9039h = c;
            if (str != null) {
                platformWebDialogsManifest.m9380a(platformWebDialogsManifest.m9386h(), str);
            }
        }
        if (platformWebDialogsManifest.f9039h.isEmpty()) {
            platformWebDialogsManifest.m9389a();
            platformWebDialogsManifest.m9375a(null, true);
        }
    }

    public final PlatformWebViewActionManifest m9388a(String str) {
        this.f9051t.a("Must check the manifest on the UI thread. This is avoid race conditions");
        m9386h();
        PlatformWebViewActionManifest platformWebViewActionManifest = (PlatformWebViewActionManifest) this.f9037f.get(str);
        if (platformWebViewActionManifest == null || platformWebViewActionManifest.m12494d() == FetchState.FETCHED) {
            return platformWebViewActionManifest;
        }
        return null;
    }

    public final void m9389a() {
        this.f9051t.a("Cannot refresh the manifest off the UI thread.");
        if (this.f9032a.get() && !this.f9050s.a(PlatformWebDialogsPrefKeys.f11166d, false) && !this.f9047p.m9411c()) {
            String h = m9386h();
            if (this.f9048q.a() - this.f9035d >= 86400000) {
                m9380a(h, null);
            }
        }
    }

    public final boolean m9390a(String str, 2 2) {
        this.f9051t.a("Cannot refresh the manifest off the UI thread.");
        String h = m9386h();
        if (2 != null) {
            this.f9039h.put(2, str);
        }
        return m9380a(h, str);
    }

    private boolean m9380a(String str, @Nullable final String str2) {
        this.f9051t.a("Cannot kick off refreshes on non-UI threads.");
        if (this.f9033b.get()) {
            if (this.f9041j != null) {
                if (!this.f9041j.isDone() && !this.f9041j.isCancelled()) {
                    return true;
                }
                this.f9041j = null;
            }
            if (str2 == null && !this.f9047p.m9409b()) {
                return false;
            }
            if (Strings.isNullOrEmpty((String) this.f9046o.get())) {
                return false;
            }
            this.f9035d = this.f9048q.a();
            Bundle bundle = new Bundle();
            bundle.putString("platform_webdialogs_manifest_fetch_URL", str);
            this.f9041j = m9373a(bundle, "platform_webdialogs_manifest_fetch");
            Futures.a(this.f9041j, new FutureCallback<OperationResult>(this) {
                final /* synthetic */ PlatformWebDialogsManifest f11396b;

                public void onSuccess(Object obj) {
                    JSONObject jSONObject;
                    OperationResult operationResult = (OperationResult) obj;
                    this.f11396b.f9041j = null;
                    String f = operationResult.f();
                    if (!Strings.isNullOrEmpty(f)) {
                        try {
                            jSONObject = new JSONObject(f);
                        } catch (Throwable e) {
                            BLog.b("PlatformWebDialogsManifest", e, "Unable to parse JSON response: %s", new Object[]{f});
                        }
                        if (jSONObject != null) {
                            onFailure(null);
                        }
                        PlatformWebDialogsManifest.m9378a(this.f11396b, jSONObject);
                        PlatformWebDialogsManifest.m9382b(this.f11396b, str2);
                        return;
                    }
                    jSONObject = null;
                    if (jSONObject != null) {
                        PlatformWebDialogsManifest.m9378a(this.f11396b, jSONObject);
                        PlatformWebDialogsManifest.m9382b(this.f11396b, str2);
                        return;
                    }
                    onFailure(null);
                }

                public void onFailure(Throwable th) {
                    if (!(th instanceof CancellationException)) {
                        this.f11396b.f9041j = null;
                        BLog.b("PlatformWebDialogsManifest", th, "Error when trying to download the manifest", new Object[0]);
                        for (2 2 : this.f11396b.f9039h.keySet()) {
                            PlatformWebDialogsFragment.a(2.b, "platform_webview_manifest_refresh_failed");
                            PlatformWebDialogsFragment.aw(2.b);
                        }
                        this.f11396b.f9039h = Maps.c();
                    }
                }
            }, this.f9045n);
            return true;
        }
        m9379a(true);
        return true;
    }

    public static void m9382b(@Nullable PlatformWebDialogsManifest platformWebDialogsManifest, String str) {
        platformWebDialogsManifest.m9383e();
        for (PlatformWebViewActionManifest platformWebViewActionManifest : platformWebDialogsManifest.f9037f.values()) {
            if (!platformWebDialogsManifest.f9047p.m9409b()) {
                for (2 a : platformWebDialogsManifest.f9039h.keySet()) {
                    a.a(platformWebViewActionManifest, false);
                }
            } else if (Strings.isNullOrEmpty(str) || !platformWebViewActionManifest.m12487a().equalsIgnoreCase(str)) {
                platformWebDialogsManifest.f9040i.add(platformWebViewActionManifest);
            } else {
                platformWebDialogsManifest.f9040i.add(0, platformWebViewActionManifest);
            }
        }
        m9384f(platformWebDialogsManifest);
    }

    private void m9383e() {
        this.f9040i.clear();
        if (this.f9042k != null) {
            this.f9042k.cancel(true);
            this.f9042k = null;
        }
    }

    public static void m9384f(PlatformWebDialogsManifest platformWebDialogsManifest) {
        if (platformWebDialogsManifest.f9040i.isEmpty()) {
            for (2 a : platformWebDialogsManifest.f9039h.keySet()) {
                a.a();
            }
            platformWebDialogsManifest.f9039h = Maps.c();
            platformWebDialogsManifest.m9387j();
            return;
        }
        final PlatformWebViewActionManifest platformWebViewActionManifest = (PlatformWebViewActionManifest) platformWebDialogsManifest.f9040i.remove(0);
        platformWebViewActionManifest.m12488a(FetchState.FETCHING);
        Bundle bundle = new Bundle();
        bundle.putParcelable("platform_webview_actionmanifest", platformWebViewActionManifest);
        platformWebDialogsManifest.f9042k = platformWebDialogsManifest.m9373a(bundle, "platform_webdialog_fetch");
        Futures.a(platformWebDialogsManifest.f9042k, new FutureCallback<OperationResult>(platformWebDialogsManifest) {
            final /* synthetic */ PlatformWebDialogsManifest f11884b;

            public void onSuccess(Object obj) {
                this.f11884b.f9042k = null;
                platformWebViewActionManifest.m12488a(FetchState.FETCHED);
                for (2 a : this.f11884b.f9039h.keySet()) {
                    a.a(platformWebViewActionManifest, true);
                }
                PlatformWebDialogsManifest.m9384f(this.f11884b);
            }

            public void onFailure(Throwable th) {
                if (!(th instanceof CancellationException)) {
                    this.f11884b.f9042k = null;
                    platformWebViewActionManifest.m12488a(FetchState.NOT_FETCHED);
                    BLog.b("PlatformWebDialogsManifest", th, "Error when trying to download the dialog for : %s", new Object[]{platformWebViewActionManifest.m12487a()});
                    for (2 2 : this.f11884b.f9039h.keySet()) {
                        if (platformWebViewActionManifest.m12487a().equalsIgnoreCase(2.a)) {
                            PlatformWebDialogsFragment.a(2.b, "platform_webview_method_refresh_failed");
                            PlatformWebDialogsFragment.aw(2.b);
                        }
                    }
                    PlatformWebDialogsManifest.m9384f(this.f11884b);
                }
            }
        }, platformWebDialogsManifest.f9045n);
    }

    public static void m9378a(PlatformWebDialogsManifest platformWebDialogsManifest, JSONObject jSONObject) {
        JSONObject jSONObject2 = null;
        if (jSONObject != null) {
            JSONObject jSONObject3;
            HashMap c = Maps.c();
            HashMap c2 = Maps.c();
            c2.putAll(platformWebDialogsManifest.f9037f);
            try {
                jSONObject3 = jSONObject.getJSONObject("actions");
            } catch (JSONException e) {
                jSONObject3 = jSONObject2;
            }
            if (jSONObject3 != null) {
                Iterator keys = jSONObject3.keys();
                while (keys.hasNext()) {
                    String str = (String) keys.next();
                    try {
                        JSONObject jSONObject4 = jSONObject3.getJSONObject(str);
                        String string = jSONObject4.getString("result_action");
                        String string2 = jSONObject4.getString("version");
                        String string3 = jSONObject4.getString("url");
                        if (!Strings.isNullOrEmpty(string3)) {
                            PlatformWebViewActionManifest platformWebViewActionManifest;
                            PlatformWebViewActionManifest platformWebViewActionManifest2 = (PlatformWebViewActionManifest) c2.remove(str);
                            if (platformWebViewActionManifest2 == null) {
                                platformWebViewActionManifest = new PlatformWebViewActionManifest();
                            } else {
                                platformWebViewActionManifest = platformWebViewActionManifest2;
                            }
                            c.put(str, platformWebViewActionManifest);
                            String b = platformWebViewActionManifest.m12490b();
                            platformWebViewActionManifest.m12491b(string);
                            platformWebViewActionManifest.m12493c(string2);
                            platformWebViewActionManifest.m12489a(str);
                            Uri parse = Uri.parse(string3);
                            if (Strings.isNullOrEmpty(parse.getScheme())) {
                                Object obj = string3.codePointAt(0) != 47 ? 1 : null;
                                StringBuilder stringBuilder = new StringBuilder(NetworkLogUrl.a(platformWebDialogsManifest.f9043l, "https://m.%s"));
                                if (obj != null) {
                                    stringBuilder.append('/');
                                }
                                stringBuilder.append(string3);
                                parse = Uri.parse(stringBuilder.toString());
                            }
                            String a = m9376a(parse, string2, platformWebDialogsManifest.f9052u.c());
                            if (!Strings.isNullOrEmpty(b) && b.equals(string2)) {
                                platformWebDialogsManifest.f9047p.m9408a(platformWebViewActionManifest.m12492c(), a);
                            }
                            platformWebViewActionManifest.m12495d(a);
                        }
                    } catch (Throwable e2) {
                        platformWebDialogsManifest.f9049r.a("PlatformWebDialogsManifest", StringFormatUtil.formatStrLocaleSafe("Manifest for '%s' was missing required keys or was badly formed", str), e2);
                    }
                }
            }
            platformWebDialogsManifest.f9037f = c;
            platformWebDialogsManifest.m9385g();
        }
    }

    private void m9385g() {
        HashMap hashMap = this.f9038g;
        this.f9038g = Maps.c();
        for (PlatformWebViewActionManifest platformWebViewActionManifest : this.f9037f.values()) {
            String c = platformWebViewActionManifest.m12492c();
            this.f9038g.put(c, platformWebViewActionManifest);
            hashMap.remove(c);
        }
        Iterable<String> keySet = hashMap.keySet();
        for (String str : keySet) {
            ((PlatformWebViewActionManifest) hashMap.get(str)).m12488a(FetchState.NOT_FETCHED);
        }
        m9375a(Lists.a(keySet), false);
    }

    private String m9386h() {
        String str = NetworkLogUrl.a(this.f9043l, "https://m.%s/js_dialog_resources/dialog_descriptions_android.json") + StringFormatUtil.formatStrLocaleSafe("#locale=%s", this.f9052u.c());
        if (!(Strings.isNullOrEmpty(this.f9036e) || str.compareTo(this.f9036e) == 0)) {
            m9391b();
        }
        this.f9036e = str;
        return this.f9036e;
    }

    public final void m9391b() {
        if (this.f9041j != null) {
            this.f9041j.cancel(true);
            this.f9041j = null;
        }
        m9383e();
        this.f9035d = 0;
        this.f9037f = Maps.c();
        m9385g();
        m9387j();
    }

    private ListenableFuture<OperationResult> m9373a(Bundle bundle, String str) {
        return BlueServiceOperationFactoryDetour.a(this.f9044m, str, bundle, -431513511).a();
    }

    private ListenableFuture<OperationResult> m9375a(@Nullable ArrayList<String> arrayList, boolean z) {
        Object obj = 1;
        Object obj2 = null;
        Bundle bundle = new Bundle();
        if (!(arrayList == null || arrayList.isEmpty())) {
            bundle.putStringArrayList("platform_urls_to_delete", arrayList);
            obj2 = 1;
        }
        if (z) {
            bundle.putBoolean("delete_orphaned_files_flag", z);
        } else {
            obj = obj2;
        }
        if (obj == null) {
            return Futures.a(OperationResult.a(ErrorCode.CANCELLED));
        }
        return BlueServiceOperationFactoryDetour.a(this.f9044m, "platform_cleanup_cached_webdialogs", bundle, 447802529).a();
    }

    private ListenableFuture<OperationResult> m9387j() {
        Parcelable manifestWrapper = new ManifestWrapper();
        manifestWrapper.m11787a(this.f9035d);
        manifestWrapper.m11788a(this.f9036e);
        manifestWrapper.m11789a(Lists.a(this.f9037f.values()));
        Bundle bundle = new Bundle();
        bundle.putParcelable("platform_webdialogs_save_parcel", manifestWrapper);
        return BlueServiceOperationFactoryDetour.a(this.f9044m, "platform_webdialogs_save_manifest", bundle, -1612332178).a();
    }

    private static String m9376a(Uri uri, String str, String str2) {
        Object obj = 1;
        Object fragment = uri.getFragment();
        Object obj2 = !Strings.isNullOrEmpty(fragment) ? 1 : null;
        String str3 = "%1$s%2$s%3$s=%4$s";
        if (obj2 == null) {
            fragment = "";
        }
        String formatStrLocaleSafe = StringFormatUtil.formatStrLocaleSafe(str3, fragment, obj2 != null ? "&" : "", "platformurlversion", str);
        obj2 = uri.getQuery();
        if (Strings.isNullOrEmpty(uri.getQueryParameter("locale"))) {
            Object obj3;
            if (Strings.isNullOrEmpty(obj2)) {
                obj = null;
            }
            str3 = "%1$s%2$s%3$s=%4$s";
            if (obj != null) {
                obj3 = obj2;
            } else {
                String str4 = "";
            }
            obj2 = StringFormatUtil.formatStrLocaleSafe(str3, obj3, obj != null ? "&" : "", "locale", str2);
        }
        return StringFormatUtil.formatStrLocaleSafe("%1$s?%2$s#%3$s", Iterables.a(Splitter.on(CharMatcher.anyOf("?#")).split(uri.toString()), ""), obj2, formatStrLocaleSafe);
    }
}
