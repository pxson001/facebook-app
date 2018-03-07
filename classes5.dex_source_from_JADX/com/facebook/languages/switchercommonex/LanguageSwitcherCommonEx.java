package com.facebook.languages.switchercommonex;

import android.content.Context;
import com.facebook.common.init.INeedInit;
import com.facebook.common.locale.Locales;
import com.facebook.common.util.LocaleUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.languages.switchercommon.LanguageSwitcherCommon;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.OnSharedPreferenceChangeListener;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.prefs.shared.PrefKey;
import com.facebook.resources.FbResources;
import com.facebook.resources.impl.DownloadedFbResources;
import com.google.common.annotations.VisibleForTesting;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: TERMS_NOT_AGREED */
public class LanguageSwitcherCommonEx extends LanguageSwitcherCommon implements INeedInit, OnSharedPreferenceChangeListener {
    private static volatile LanguageSwitcherCommonEx f14215c;
    private final FbResources f14216b;

    public static com.facebook.languages.switchercommonex.LanguageSwitcherCommonEx m23551b(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f14215c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.languages.switchercommonex.LanguageSwitcherCommonEx.class;
        monitor-enter(r1);
        r0 = f14215c;	 Catch:{ all -> 0x003a }
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
        r0 = m23552c(r0);	 Catch:{ all -> 0x0035 }
        f14215c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f14215c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.languages.switchercommonex.LanguageSwitcherCommonEx.b(com.facebook.inject.InjectorLike):com.facebook.languages.switchercommonex.LanguageSwitcherCommonEx");
    }

    private static LanguageSwitcherCommonEx m23552c(InjectorLike injectorLike) {
        return new LanguageSwitcherCommonEx((Context) injectorLike.getInstance(Context.class), Locales.a(injectorLike), (FbResources) DownloadedFbResources.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike));
    }

    @Inject
    public LanguageSwitcherCommonEx(Context context, Locales locales, FbResources fbResources, FbSharedPreferences fbSharedPreferences) {
        super(context, locales);
        this.f14216b = fbResources;
        fbSharedPreferences.a(LanguageSwitcherCommonExPrefKeys.b, this);
    }

    public void init() {
        m23553d();
    }

    public final void m23554a(FbSharedPreferences fbSharedPreferences, PrefKey prefKey) {
        m23553d();
    }

    @VisibleForTesting
    private void m23553d() {
        Object locale = this.a.a().toString();
        if (!StringUtil.a(locale)) {
            this.f14216b.a(LocaleUtil.a(locale));
            if (!StringUtil.a(locale)) {
                a(LocaleUtil.a(locale));
            }
        }
    }
}
