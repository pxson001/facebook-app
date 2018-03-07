package com.facebook.timeline.profilevideo.store;

import com.facebook.auth.module.ViewerContextMethodAutoProvider;
import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.common.executors.ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.timeline.profilevideo.store.OptimisticProfileVideoModel.Builder;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.io.File;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

@UserScoped
/* compiled from: mIteratorLock */
public class OptimisticProfileVideoStore implements IHaveUserData {
    public static final Class<?> f9415a = OptimisticProfileVideoStore.class;
    private static final Object f9416h = new Object();
    private final ExecutorService f9417b;
    private final Clock f9418c;
    private FbSharedPreferences f9419d;
    private ViewerContext f9420e;
    private boolean f9421f = false;
    @Nullable
    private OptimisticProfileVideoModel f9422g;

    private static OptimisticProfileVideoStore m11171b(InjectorLike injectorLike) {
        return new OptimisticProfileVideoStore((ExecutorService) ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), ViewerContextMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public OptimisticProfileVideoStore(ExecutorService executorService, Clock clock, FbSharedPreferences fbSharedPreferences, ViewerContext viewerContext) {
        this.f9417b = executorService;
        this.f9418c = clock;
        this.f9419d = fbSharedPreferences;
        this.f9420e = viewerContext;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.timeline.profilevideo.store.OptimisticProfileVideoStore m11170a(com.facebook.inject.InjectorLike r7) {
        /*
        r2 = com.facebook.inject.ScopeSet.a();
        r0 = com.facebook.auth.userscope.UserScope.class;
        r0 = r7.getInstance(r0);
        r0 = (com.facebook.auth.userscope.UserScope) r0;
        r1 = r7.getScopeAwareInjector();
        r1 = r1.b();
        if (r1 != 0) goto L_0x001e;
    L_0x0016:
        r0 = new com.facebook.inject.ProvisioningException;
        r1 = "Called user scoped provider outside of context scope";
        r0.<init>(r1);
        throw r0;
    L_0x001e:
        r3 = r0.a(r1);
        r4 = r3.b();	 Catch:{ all -> 0x006c }
        r1 = f9416h;	 Catch:{ all -> 0x006c }
        r1 = r4.get(r1);	 Catch:{ all -> 0x006c }
        r5 = com.facebook.auth.userscope.UserScope.a;	 Catch:{ all -> 0x006c }
        if (r1 != r5) goto L_0x0035;
    L_0x0030:
        r3.c();
        r0 = 0;
    L_0x0034:
        return r0;
    L_0x0035:
        if (r1 != 0) goto L_0x007c;
    L_0x0037:
        r1 = 4;
        r5 = r2.b(r1);	 Catch:{  }
        r6 = r0.a(r3);	 Catch:{ all -> 0x0067 }
        r0 = r6.e();	 Catch:{ all -> 0x0062 }
        r1 = m11171b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f9416h;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.timeline.profilevideo.store.OptimisticProfileVideoStore) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.timeline.profilevideo.store.OptimisticProfileVideoStore) r0;	 Catch:{  }
        r3.c();
        goto L_0x0034;
    L_0x0062:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0067:
        r0 = move-exception;
        r2.c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006c:
        r0 = move-exception;
        r3.c();
        throw r0;
    L_0x0071:
        r0 = f9416h;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.timeline.profilevideo.store.OptimisticProfileVideoStore) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.profilevideo.store.OptimisticProfileVideoStore.a(com.facebook.inject.InjectorLike):com.facebook.timeline.profilevideo.store.OptimisticProfileVideoStore");
    }

    @Nullable
    public final OptimisticProfileVideoModel m11181a(String str) {
        m11177f();
        m11173d();
        if (m11178f(str)) {
            return this.f9422g;
        }
        if (!("uploading".equals(str) || str == null || this.f9422g == null)) {
            this.f9422g.m11167b();
            m11172c();
        }
        return null;
    }

    public final void m11182a(OptimisticProfileVideoModel optimisticProfileVideoModel) {
        optimisticProfileVideoModel.toString();
        m11177f();
        m11172c();
        this.f9422g = optimisticProfileVideoModel;
        m11179g();
    }

    public void clearUserData() {
        if (this.f9422g != null && !"uploading".equals(this.f9422g.m11167b())) {
            m11172c();
        }
    }

    public final void m11183a(String str, String str2) {
        if (m11176e(str)) {
            this.f9422g = new Builder(this.f9422g).m11165b(str2).m11164a();
            m11179g();
        }
    }

    public final void m11184b(String str) {
        if (m11176e(str)) {
            m11172c();
        }
    }

    public final void m11185c(String str) {
        if (m11178f(str)) {
            m11172c();
        }
    }

    private void m11172c() {
        m11180h();
        m11175e();
        this.f9422g = null;
    }

    private void m11173d() {
        if (this.f9422g != null && this.f9418c.a() - this.f9422g.f9410c > 86400000) {
            m11172c();
        }
    }

    private void m11175e() {
        if (this.f9422g != null && this.f9422g.m11168c() != null) {
            m11174d(this.f9422g.m11168c());
        }
    }

    private void m11174d(final String str) {
        ExecutorDetour.a(this.f9417b, new Runnable(this) {
            final /* synthetic */ OptimisticProfileVideoStore f9414b;

            public void run() {
                Class cls = OptimisticProfileVideoStore.f9415a;
                new File(str).delete();
            }
        }, 589950086);
    }

    private boolean m11176e(String str) {
        if (this.f9422g == null) {
            return false;
        }
        return this.f9422g.f9408a.equals(str);
    }

    private boolean m11178f(String str) {
        if (this.f9422g == null || this.f9422g.m11167b() == null) {
            return false;
        }
        return this.f9422g.m11167b().equals(str);
    }

    private void m11177f() {
        if (!this.f9421f) {
            String a = this.f9419d.a(m11169a(ProfileVideoStorePreferencesKeys.f9423a), null);
            if (a != null) {
                m11174d(a);
            }
            m11180h();
            this.f9421f = true;
        }
    }

    private void m11179g() {
        if (this.f9422g != null) {
            Editor edit = this.f9419d.edit();
            edit.a(m11169a(ProfileVideoStorePreferencesKeys.f9423a), this.f9422g.m11168c());
            edit.commit();
        }
    }

    private void m11180h() {
        Editor edit = this.f9419d.edit();
        edit.a(m11169a(ProfileVideoStorePreferencesKeys.f9423a));
        edit.commit();
    }

    private PrefKey m11169a(PrefKey prefKey) {
        return (PrefKey) prefKey.a(this.f9420e.mUserId);
    }
}
