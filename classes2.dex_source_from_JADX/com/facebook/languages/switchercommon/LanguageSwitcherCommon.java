package com.facebook.languages.switchercommon;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import com.facebook.common.locale.Locales;
import com.facebook.common.util.LocaleUtil;
import com.facebook.inject.InjectorLike;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: timeline_friend_request_ref */
public class LanguageSwitcherCommon {
    private static volatile LanguageSwitcherCommon f2778c;
    public final Locales f2779a;
    private final Context f2780b;

    public static com.facebook.languages.switchercommon.LanguageSwitcherCommon m4758a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f2778c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.languages.switchercommon.LanguageSwitcherCommon.class;
        monitor-enter(r1);
        r0 = f2778c;	 Catch:{ all -> 0x003a }
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
        r0 = m4762b(r0);	 Catch:{ all -> 0x0035 }
        f2778c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f2778c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.languages.switchercommon.LanguageSwitcherCommon.a(com.facebook.inject.InjectorLike):com.facebook.languages.switchercommon.LanguageSwitcherCommon");
    }

    private static LanguageSwitcherCommon m4762b(InjectorLike injectorLike) {
        return new LanguageSwitcherCommon((Context) injectorLike.getInstance(Context.class), Locales.m2604a(injectorLike));
    }

    @Inject
    public LanguageSwitcherCommon(Context context, Locales locales) {
        this.f2780b = context;
        this.f2779a = locales;
    }

    @Nullable
    public static String m4761a(ImmutableCollection<Locale> immutableCollection, String str) {
        Locale a = LocaleUtil.m31239a(str);
        if (immutableCollection.contains(a)) {
            return a.toString();
        }
        Locale locale = new Locale(a.getLanguage());
        if (immutableCollection.contains(locale)) {
            return locale.toString();
        }
        return null;
    }

    @VisibleForTesting
    private static ImmutableCollection<Locale> m4759a(ImmutableSet<String> immutableSet, ImmutableSet<String> immutableSet2) {
        Map f = Maps.m844f();
        Iterator it = immutableSet2.iterator();
        while (it.hasNext()) {
            Locale a = LocaleUtil.m31239a((String) it.next());
            if (immutableSet.contains(a.toString())) {
                f.put(a.toString(), a);
            } else if (!a.getLanguage().equals("zh") && immutableSet.contains(a.getLanguage())) {
                f.put(a.getLanguage(), new Locale(a.getLanguage()));
            } else if (a.getLanguage().equals("fb")) {
                f.put(a.toString(), a);
            }
        }
        return ImmutableMap.copyOf(f).values();
    }

    public final ImmutableCollection<Locale> m4765c() {
        return m4759a(m4760a(Locale.getAvailableLocales(), Resources.getSystem().getAssets().getLocales()), this.f2779a.m2615f());
    }

    @VisibleForTesting
    public static ImmutableSet<String> m4760a(Locale[] localeArr, String[] strArr) {
        int i = 0;
        Builder builder = ImmutableSet.builder();
        for (Locale locale : localeArr) {
            if (!(locale.getLanguage().equals("gu") || locale.getLanguage().equals("pa"))) {
                builder.m4813c(locale.toString());
                builder.m4813c(locale.getLanguage());
            }
        }
        int length = strArr.length;
        while (i < length) {
            Locale a = LocaleUtil.m31239a(strArr[i]);
            builder.m4813c(a.toString());
            builder.m4813c(a.getLanguage());
            i++;
        }
        return builder.m4812b();
    }

    public final void m4764a(Locale locale) {
        Resources resources = this.f2780b.getResources();
        Configuration configuration = resources.getConfiguration();
        if (!locale.equals(configuration.locale)) {
            configuration.locale = locale;
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        }
        m4763b(locale);
        Locale.setDefault(locale);
    }

    private Locale m4763b(Locale locale) {
        ApplicationInfo applicationInfo = this.f2780b.getApplicationInfo();
        if (!(this.f2779a.m2615f().contains(locale.getLanguage()) || this.f2779a.m2615f().contains(locale.toString())) || (applicationInfo.flags & 4194304) == 0) {
            locale = Locale.US;
        }
        if (VERSION.SDK_INT >= 17) {
            Resources resources = this.f2780b.getResources();
            Configuration configuration = resources.getConfiguration();
            configuration.setLayoutDirection(locale);
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        }
        return locale;
    }
}
