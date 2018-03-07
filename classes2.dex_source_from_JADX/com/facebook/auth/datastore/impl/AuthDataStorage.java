package com.facebook.auth.datastore.impl;

import android.text.TextUtils;
import com.facebook.auth.credentials.FacebookCredentials;
import com.facebook.auth.prefs.AuthPrefKeys;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.auth.viewercontext.ViewerContext.ViewerContextBuilder;
import com.facebook.crudolib.prefs.LightSharedPreferences$Editor;
import com.facebook.crudolib.prefs.LightSharedPreferencesFactory;
import com.facebook.crudolib.prefs.LightSharedPreferencesImpl;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.prefs.light.LightSharedPreferencesFactoryMethodAutoProvider;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: verify_payment */
public class AuthDataStorage {
    private static volatile AuthDataStorage f1296c;
    public final LightSharedPreferencesImpl f1297a;
    private final Lazy<FbSharedPreferences> f1298b;

    public static com.facebook.auth.datastore.impl.AuthDataStorage m2534a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1296c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.auth.datastore.impl.AuthDataStorage.class;
        monitor-enter(r1);
        r0 = f1296c;	 Catch:{ all -> 0x003a }
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
        r0 = m2536b(r0);	 Catch:{ all -> 0x0035 }
        f1296c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1296c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.auth.datastore.impl.AuthDataStorage.a(com.facebook.inject.InjectorLike):com.facebook.auth.datastore.impl.AuthDataStorage");
    }

    private static AuthDataStorage m2536b(InjectorLike injectorLike) {
        return new AuthDataStorage(LightSharedPreferencesFactoryMethodAutoProvider.m2543a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 3078));
    }

    @Inject
    public AuthDataStorage(LightSharedPreferencesFactory lightSharedPreferencesFactory, Lazy<FbSharedPreferences> lazy) {
        this.f1297a = lightSharedPreferencesFactory.m2550a("authentication");
        this.f1298b = lazy;
    }

    @Nullable
    final ViewerContext m2539a() {
        if (!this.f1297a.m2647a("is_imported", false)) {
            return m2537d();
        }
        String str = null;
        Object a = this.f1297a.m2643a("uid", null);
        Object a2 = this.f1297a.m2643a("access_token", null);
        if (!(TextUtils.isEmpty(a) || TextUtils.isEmpty(a2))) {
            ViewerContextBuilder newBuilder = ViewerContext.newBuilder();
            newBuilder.f764a = a;
            ViewerContextBuilder viewerContextBuilder = newBuilder;
            viewerContextBuilder.f765b = a2;
            viewerContextBuilder = viewerContextBuilder;
            viewerContextBuilder.f766c = this.f1297a.m2643a("session_cookies_string", null);
            viewerContextBuilder = viewerContextBuilder;
            viewerContextBuilder.f768e = this.f1297a.m2643a("secret", null);
            viewerContextBuilder = viewerContextBuilder;
            viewerContextBuilder.f769f = this.f1297a.m2643a("session_key", null);
            viewerContextBuilder = viewerContextBuilder;
            viewerContextBuilder.f770g = this.f1297a.m2643a("username", null);
            str = viewerContextBuilder.m1532h();
        }
        return str;
    }

    final void m2540a(FacebookCredentials facebookCredentials) {
        if (!this.f1297a.m2647a("is_imported", false)) {
            FbSharedPreferences fbSharedPreferences = (FbSharedPreferences) this.f1298b.get();
            if (fbSharedPreferences.mo285a(AuthPrefKeys.f2948c) || fbSharedPreferences.mo285a(AuthPrefKeys.f2949d)) {
                m2538e();
            }
        }
        LightSharedPreferences$Editor b = this.f1297a.m2648b();
        m2535a(facebookCredentials.a, facebookCredentials.b, facebookCredentials.c, facebookCredentials.d, facebookCredentials.e, facebookCredentials.f, b);
        b.mo3285a("is_imported", true);
        b.mo3286b();
    }

    final void m2541a(String str, String str2) {
        if (this.f1297a.m2643a("access_token", "").equals(str)) {
            LightSharedPreferences$Editor b = this.f1297a.m2648b();
            b.mo3283a("access_token", str2);
            b.mo3286b();
        }
    }

    final void m2542b() {
        this.f1297a.m2648b().mo3279a("uid").mo3279a("access_token").mo3279a("session_cookies_string").mo3279a("secret").mo3279a("session_key").mo3279a("username").mo3286b();
    }

    private ViewerContext m2537d() {
        ViewerContext viewerContext = null;
        FbSharedPreferences fbSharedPreferences = (FbSharedPreferences) this.f1298b.get();
        if (fbSharedPreferences.mo284a()) {
            LightSharedPreferences$Editor b = this.f1297a.m2648b();
            if (fbSharedPreferences.mo285a(AuthPrefKeys.f2948c) || fbSharedPreferences.mo285a(AuthPrefKeys.f2949d)) {
                ViewerContext viewerContext2;
                Object a = fbSharedPreferences.mo278a(AuthPrefKeys.f2948c, null);
                Object a2 = fbSharedPreferences.mo278a(AuthPrefKeys.f2949d, null);
                if (TextUtils.isEmpty(a) || TextUtils.isEmpty(a2)) {
                    viewerContext2 = null;
                } else {
                    ViewerContextBuilder newBuilder = ViewerContext.newBuilder();
                    newBuilder.f764a = a;
                    ViewerContextBuilder viewerContextBuilder = newBuilder;
                    viewerContextBuilder.f765b = a2;
                    viewerContextBuilder = viewerContextBuilder;
                    viewerContextBuilder.f766c = fbSharedPreferences.mo278a(AuthPrefKeys.f2950e, null);
                    viewerContextBuilder = viewerContextBuilder;
                    viewerContextBuilder.f768e = fbSharedPreferences.mo278a(AuthPrefKeys.f2952g, null);
                    viewerContextBuilder = viewerContextBuilder;
                    viewerContextBuilder.f769f = fbSharedPreferences.mo278a(AuthPrefKeys.f2953h, null);
                    viewerContextBuilder = viewerContextBuilder;
                    viewerContextBuilder.f770g = fbSharedPreferences.mo278a(AuthPrefKeys.f2954i, null);
                    ViewerContext h = viewerContextBuilder.m1532h();
                    m2535a(h.mUserId, h.mAuthToken, h.mSessionCookiesString, h.mSessionSecret, h.mSessionKey, h.mUsername, b);
                    viewerContext2 = h;
                }
                m2538e();
                viewerContext = viewerContext2;
            }
            b.mo3285a("is_imported", true);
            b.mo3286b();
        }
        return viewerContext;
    }

    private static void m2535a(String str, String str2, String str3, String str4, String str5, String str6, LightSharedPreferences$Editor lightSharedPreferences$Editor) {
        boolean z = true;
        Preconditions.checkArgument(!TextUtils.isEmpty(str), "No user ID in credentials");
        if (TextUtils.isEmpty(str2)) {
            z = false;
        }
        Preconditions.checkArgument(z, "No token in credentials");
        lightSharedPreferences$Editor.mo3278a();
        lightSharedPreferences$Editor.mo3283a("uid", str);
        lightSharedPreferences$Editor.mo3283a("access_token", str2);
        lightSharedPreferences$Editor.mo3283a("session_cookies_string", str3);
        lightSharedPreferences$Editor.mo3283a("secret", str4);
        lightSharedPreferences$Editor.mo3283a("session_key", str5);
        lightSharedPreferences$Editor.mo3283a("username", str6);
    }

    private void m2538e() {
        ((FbSharedPreferences) this.f1298b.get()).edit().mo1271a(AuthPrefKeys.f2948c).mo1271a(AuthPrefKeys.f2949d).mo1271a(AuthPrefKeys.f2950e).mo1271a(AuthPrefKeys.f2952g).mo1271a(AuthPrefKeys.f2953h).mo1271a(AuthPrefKeys.f2954i).commit();
    }
}
