package com.facebook.feed.platformads;

import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: admin_click_new_likes */
public class AppInstallTracker {
    private static final Class<?> f19805a = AppInstallTracker.class;
    private static volatile AppInstallTracker f19806h;
    private final Clock f19807b;
    public final GatekeeperStoreImpl f19808c;
    private final FbSharedPreferences f19809d;
    private final ObjectMapper f19810e;
    private final Map<String, TrackedPackage> f19811f;
    private boolean f19812g = false;

    public static com.facebook.feed.platformads.AppInstallTracker m23070a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f19806h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.feed.platformads.AppInstallTracker.class;
        monitor-enter(r1);
        r0 = f19806h;	 Catch:{ all -> 0x003a }
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
        r0 = m23073b(r0);	 Catch:{ all -> 0x0035 }
        f19806h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f19806h;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feed.platformads.AppInstallTracker.a(com.facebook.inject.InjectorLike):com.facebook.feed.platformads.AppInstallTracker");
    }

    private static AppInstallTracker m23073b(InjectorLike injectorLike) {
        return new AppInstallTracker((Clock) SystemClockMethodAutoProvider.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), (ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public AppInstallTracker(Clock clock, GatekeeperStoreImpl gatekeeperStoreImpl, FbSharedPreferences fbSharedPreferences, ObjectMapper objectMapper) {
        this.f19807b = clock;
        this.f19808c = gatekeeperStoreImpl;
        this.f19809d = fbSharedPreferences;
        this.f19810e = objectMapper;
        this.f19811f = Collections.synchronizedMap(new HashMap());
    }

    public final boolean m23081a() {
        return this.f19808c.a(1004, false);
    }

    public final void m23080a(String str, long j, ArrayNode arrayNode, String str2) {
        m23071a(str, j, arrayNode, str2, 2419200000L);
    }

    private void m23071a(String str, long j, ArrayNode arrayNode, String str2, long j2) {
        if (m23081a()) {
            TrackedPackage trackedPackage = new TrackedPackage();
            trackedPackage.detectionStrings = Arrays.asList(new String[]{str});
            trackedPackage.fbid = String.valueOf(j);
            trackedPackage.trackingCodes = arrayNode;
            trackedPackage.appLaunchUrl = str2;
            trackedPackage.trackUntil = new Date(this.f19807b.a() + j2);
            m23075d();
            if (this.f19811f.containsKey(str)) {
                this.f19811f.remove(str);
                m23079a(trackedPackage);
            }
            this.f19811f.put(str, trackedPackage);
            m23077f();
        }
    }

    private boolean m23074c() {
        try {
            this.f19809d.c();
            return true;
        } catch (InterruptedException e) {
            return false;
        }
    }

    @Nullable
    public final TrackedPackage m23078a(String str) {
        m23075d();
        if (!m23074c()) {
            return null;
        }
        Date date = new Date();
        if (this.f19811f.containsKey(str)) {
            TrackedPackage trackedPackage = (TrackedPackage) this.f19811f.get(str);
            if (!trackedPackage.trackUntil.before(date)) {
                return trackedPackage;
            }
        }
        return null;
    }

    private synchronized void m23075d() {
        if (!this.f19812g) {
            m23076e();
            this.f19812g = true;
        }
    }

    private void m23076e() {
        if (m23074c()) {
            List arrayList = new ArrayList();
            Set<PrefKey> d = this.f19809d.d(PlatformAdPrefKeys.f19819c);
            Date date = new Date();
            for (PrefKey a : d) {
                try {
                    String a2 = this.f19809d.a(a, null);
                    if (a2 != null) {
                        TrackedPackage a3 = TrackedPackage.m23082a(a2, this.f19810e);
                        if (a3 != null) {
                            if (a3.trackUntil.before(date) || a3.detectionStrings.isEmpty()) {
                                arrayList.add(a3);
                            } else {
                                this.f19811f.put(a3.detectionStrings.get(0), a3);
                            }
                        }
                    }
                } catch (Exception e) {
                }
            }
            m23072a(arrayList);
        }
    }

    private void m23077f() {
        if (m23074c()) {
            Editor edit = this.f19809d.edit();
            for (TrackedPackage trackedPackage : this.f19811f.values()) {
                edit.a((PrefKey) PlatformAdPrefKeys.f19819c.a(trackedPackage.fbid), trackedPackage.m23083a(this.f19810e));
            }
            edit.commit();
        }
    }

    public final void m23079a(TrackedPackage trackedPackage) {
        m23072a(Arrays.asList(new TrackedPackage[]{trackedPackage}));
    }

    private void m23072a(List<TrackedPackage> list) {
        if (m23074c()) {
            Editor edit = this.f19809d.edit();
            for (TrackedPackage trackedPackage : list) {
                edit.a((PrefKey) PlatformAdPrefKeys.f19818b.a(trackedPackage.fbid));
                this.f19811f.remove(trackedPackage.detectionStrings.get(0));
            }
            edit.commit();
        }
    }
}
