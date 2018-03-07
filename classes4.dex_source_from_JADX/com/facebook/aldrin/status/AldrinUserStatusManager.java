package com.facebook.aldrin.status;

import com.facebook.aldrin.status.prefs.AldrinStatusPrefKeys;
import com.facebook.common.init.INeedInit;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.debug.log.BLog;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.user.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: messenger_instrumented_drawable */
public class AldrinUserStatusManager implements INeedInit {
    private static volatile AldrinUserStatusManager f7972h;
    private final Provider<User> f7973a;
    private final Clock f7974b;
    private final FbSharedPreferences f7975c;
    private final ObjectMapper f7976d;
    private final Map<String, AldrinUserStatus> f7977e = new HashMap();
    @Nullable
    private AldrinUserStatus f7978f = null;
    private boolean f7979g = false;

    public static com.facebook.aldrin.status.AldrinUserStatusManager m8301a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7972h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.aldrin.status.AldrinUserStatusManager.class;
        monitor-enter(r1);
        r0 = f7972h;	 Catch:{ all -> 0x003a }
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
        r0 = m8302b(r0);	 Catch:{ all -> 0x0035 }
        f7972h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7972h;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.aldrin.status.AldrinUserStatusManager.a(com.facebook.inject.InjectorLike):com.facebook.aldrin.status.AldrinUserStatusManager");
    }

    private static AldrinUserStatusManager m8302b(InjectorLike injectorLike) {
        return new AldrinUserStatusManager(IdBasedProvider.a(injectorLike, 3595), (Clock) SystemClockMethodAutoProvider.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), (ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public AldrinUserStatusManager(Provider<User> provider, Clock clock, FbSharedPreferences fbSharedPreferences, ObjectMapper objectMapper) {
        this.f7973a = provider;
        this.f7974b = clock;
        this.f7975c = fbSharedPreferences;
        this.f7976d = objectMapper;
    }

    public final synchronized void m8307a(AldrinUserStatus aldrinUserStatus) {
        this.f7979g = true;
        if (!(aldrinUserStatus == null || m8303b(aldrinUserStatus))) {
            CharSequence charSequence = aldrinUserStatus.userId;
            if (!StringUtil.a(charSequence)) {
                AldrinUserStatus aldrinUserStatus2 = (AldrinUserStatus) this.f7977e.get(charSequence);
                if (aldrinUserStatus2 == null || aldrinUserStatus2.fetchTime < aldrinUserStatus.fetchTime) {
                    this.f7977e.put(charSequence, aldrinUserStatus);
                }
            } else if (this.f7978f == null || this.f7978f.fetchTime < aldrinUserStatus.fetchTime) {
                this.f7978f = aldrinUserStatus;
            }
            m8306g();
        }
    }

    public void init() {
        if (!this.f7979g) {
            m8304e();
        }
    }

    public final void m8308c() {
        try {
            this.f7975c.edit().a(AldrinStatusPrefKeys.f9755a, this.f7976d.a(m8305f())).commit();
        } catch (Throwable e) {
            BLog.b(AldrinUserStatusManager.class, "Cannot persist status data", e);
        }
    }

    @Nullable
    public final AldrinUserStatus m8309d() {
        return m8300a((User) this.f7973a.get(), false);
    }

    @Nullable
    private synchronized AldrinUserStatus m8300a(User user, boolean z) {
        AldrinUserStatus aldrinUserStatus;
        aldrinUserStatus = user == null ? this.f7978f : (AldrinUserStatus) this.f7977e.get(user.d());
        if (!(aldrinUserStatus == null || z || !m8303b(aldrinUserStatus))) {
            aldrinUserStatus = null;
        }
        return aldrinUserStatus;
    }

    private void m8304e() {
        this.f7979g = true;
        Object a = this.f7975c.a(AldrinStatusPrefKeys.f9755a, null);
        if (!StringUtil.a(a)) {
            try {
                for (AldrinUserStatus a2 : (List) this.f7976d.a(a, this.f7976d.c().a(List.class, AldrinUserStatus.class))) {
                    m8307a(a2);
                }
            } catch (Throwable e) {
                BLog.b(AldrinUserStatusManager.class, "Cannot restore status data", e);
            }
        }
    }

    private boolean m8303b(AldrinUserStatus aldrinUserStatus) {
        return this.f7974b.a() - aldrinUserStatus.fetchTime > 86400000;
    }

    private synchronized List<AldrinUserStatus> m8305f() {
        List<AldrinUserStatus> arrayList;
        arrayList = new ArrayList();
        if (!(this.f7978f == null || m8303b(this.f7978f))) {
            arrayList.add(this.f7978f);
        }
        for (AldrinUserStatus aldrinUserStatus : this.f7977e.values()) {
            if (!(aldrinUserStatus == null || m8303b(aldrinUserStatus))) {
                arrayList.add(aldrinUserStatus);
            }
        }
        return arrayList;
    }

    private void m8306g() {
        User user = (User) this.f7973a.get();
        if (user == null) {
            Object obj = null;
        } else {
            String str = user.a;
        }
        for (String str2 : this.f7977e.keySet()) {
            AldrinUserStatus aldrinUserStatus = (AldrinUserStatus) this.f7977e.get(str2);
            if (aldrinUserStatus == null || (!str2.equals(r2) && m8303b(aldrinUserStatus))) {
                this.f7977e.remove(str2);
            }
        }
    }
}
