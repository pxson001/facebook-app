package com.facebook.rtc.campon;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.init.INeedInit;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.rtc.prefs.InternalVoipPrefKeys;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.Executor;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: location_sharing */
public class RtcCamperStore implements INeedInit {
    private static final String f9105b = RtcCamperStore.class.getName();
    private static volatile RtcCamperStore f9106k;
    public final int f9107a = 1;
    private final Clock f9108c;
    private final FbSharedPreferences f9109d;
    private final Provider<RtcCampOnManager> f9110e;
    private final Lazy<ObjectMapper> f9111f;
    private final Lazy<Executor> f9112g;
    private final AbstractFbErrorReporter f9113h;
    private boolean f9114i;
    private boolean f9115j;

    public static com.facebook.rtc.campon.RtcCamperStore m9441a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f9106k;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.rtc.campon.RtcCamperStore.class;
        monitor-enter(r1);
        r0 = f9106k;	 Catch:{ all -> 0x003a }
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
        r0 = m9445b(r0);	 Catch:{ all -> 0x0035 }
        f9106k = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f9106k;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.rtc.campon.RtcCamperStore.a(com.facebook.inject.InjectorLike):com.facebook.rtc.campon.RtcCamperStore");
    }

    private static RtcCamperStore m9445b(InjectorLike injectorLike) {
        return new RtcCamperStore((Clock) SystemClockMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 10367), IdBasedSingletonScopeProvider.b(injectorLike, 572), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 3863), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public RtcCamperStore(Clock clock, Provider<RtcCampOnManager> provider, Lazy<ObjectMapper> lazy, FbSharedPreferences fbSharedPreferences, Lazy<Executor> lazy2, FbErrorReporter fbErrorReporter) {
        this.f9108c = clock;
        this.f9110e = provider;
        this.f9111f = lazy;
        this.f9109d = fbSharedPreferences;
        this.f9112g = lazy2;
        this.f9113h = fbErrorReporter;
    }

    public synchronized void init() {
        Editor edit;
        Editor editor;
        Throwable e;
        if (!this.f9114i) {
            this.f9114i = true;
            List arrayList = new ArrayList();
            long a = this.f9108c.a();
            Editor editor2 = null;
            for (Entry entry : this.f9109d.e(InternalVoipPrefKeys.f11367T).entrySet()) {
                try {
                    RtcCamperModel rtcCamperModel = (RtcCamperModel) ((ObjectMapper) this.f9111f.get()).a((String) entry.getValue(), RtcCamperModel.class);
                    if (m9442a(rtcCamperModel, a)) {
                        arrayList.add(rtcCamperModel);
                        Long.valueOf(rtcCamperModel.mPeerId);
                    } else {
                        if (editor2 == null) {
                            edit = this.f9109d.edit();
                        } else {
                            edit = editor2;
                        }
                        try {
                            edit.a((PrefKey) entry.getKey());
                            editor = edit;
                        } catch (IOException e2) {
                            e = e2;
                            this.f9113h.a("RtcCamperStore", "Error encountered in reading the RtcCamperModel from FbSharedPreferences", e);
                            if (edit == null) {
                                edit = this.f9109d.edit();
                            }
                            edit.a((PrefKey) entry.getKey());
                            editor = edit;
                            editor2 = editor;
                        }
                        editor2 = editor;
                    }
                } catch (IOException e3) {
                    e = e3;
                    edit = editor2;
                    this.f9113h.a("RtcCamperStore", "Error encountered in reading the RtcCamperModel from FbSharedPreferences", e);
                    if (edit == null) {
                        edit = this.f9109d.edit();
                    }
                    edit.a((PrefKey) entry.getKey());
                    editor = edit;
                    editor2 = editor;
                }
            }
            if (editor2 != null) {
                editor2.commit();
            }
            if (arrayList.isEmpty()) {
                this.f9115j = true;
            } else {
                ExecutorDetour.a((Executor) this.f9112g.get(), new 1(this, arrayList), 427213934);
            }
        }
    }

    public final synchronized boolean m9449a() {
        return this.f9115j;
    }

    public static boolean m9443a(RtcCamperStore rtcCamperStore, RtcCamperModel rtcCamperModel) {
        if (rtcCamperModel.mCampType == 3) {
            return ((RtcCampOnManager) rtcCamperStore.f9110e.get()).a(rtcCamperModel.mPeerId, rtcCamperModel.mPeerFirstName, rtcCamperModel.mPeerName, false, rtcCamperModel.mStartTimeMs, 30000, rtcCamperModel.mWaitTimeMs);
        }
        if (rtcCamperModel.mCampType == 4) {
            return ((RtcCampOnManager) rtcCamperStore.f9110e.get()).a(rtcCamperModel.mPeerId, rtcCamperModel.mPeerFirstName, rtcCamperModel.mPeerName, true, rtcCamperModel.mStartTimeMs, 30000, rtcCamperModel.mWaitTimeMs);
        }
        return false;
    }

    private boolean m9442a(RtcCamperModel rtcCamperModel, long j) {
        if (rtcCamperModel == null) {
            return false;
        }
        Object obj;
        int i = rtcCamperModel.mCampType;
        if (i == 3 || i == 4) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null || rtcCamperModel.mPeerId == 0 || rtcCamperModel.mStartTimeMs == 0 || rtcCamperModel.mWaitTimeMs == 0 || rtcCamperModel.mStartTimeMs + rtcCamperModel.mWaitTimeMs < j || rtcCamperModel.mWaitTimeMs + j < rtcCamperModel.mStartTimeMs) {
            return false;
        }
        return true;
    }

    public final void m9448a(long j) {
        PrefKey prefKey = (PrefKey) InternalVoipPrefKeys.f11367T.a(Long.toString(j));
        Editor edit = this.f9109d.edit();
        edit.a(prefKey);
        edit.commit();
        Long.valueOf(j);
    }

    public final void m9447a(int i, long j, String str, String str2, long j2, long j3) {
        m9446b(new RtcCamperModel(i, j, str, str2, j2, j3));
    }

    private void m9446b(RtcCamperModel rtcCamperModel) {
        try {
            this.f9109d.edit().a((PrefKey) InternalVoipPrefKeys.f11367T.a(Long.toString(rtcCamperModel.mPeerId)), ((ObjectMapper) this.f9111f.get()).a(rtcCamperModel)).commit();
            Long.valueOf(rtcCamperModel.mPeerId);
        } catch (Throwable e) {
            this.f9113h.a("RtcCamperStore", "Error encountered in writing the RtcCamperModel from FbSharedPreferences", e);
        }
    }
}
