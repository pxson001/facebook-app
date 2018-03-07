package com.facebook.resources.impl;

import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.analytics.DataUsageCounters;
import com.facebook.common.executors.C0093x5209d3a;
import com.facebook.common.util.TriState;
import com.facebook.fbui.drawable.DrawableLoader;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.resources.FbResources;
import com.facebook.resources.FbResourcesUsageLogger;
import com.facebook.resources.Resources_BaseResourcesMethodAutoProvider;
import com.facebook.resources.impl.model.PluralCategory;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.reflect.Field;
import java.util.Locale;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
@ThreadSafe
/* compiled from: vi_VN */
public class DownloadedFbResources extends FbResources {
    private static volatile DownloadedFbResources f1276g;
    private final StringResourcesDelegate f1277a;
    private final DataUsageCounters f1278b;
    private final Provider<TriState> f1279c;
    private final DrawableLoader f1280d;
    private final int f1281e;
    private final int f1282f;

    /* compiled from: vi_VN */
    class OverridenDrawablesLoader {
        private static final String[] f1353a;
        private static int[] f1354b;

        static {
            int i = 0;
            String[] strArr = new String[]{"overscroll_glow", "overscroll_edge"};
            f1353a = strArr;
            f1354b = new int[strArr.length];
            try {
                Class cls = Class.forName("com.android.internal.R$drawable");
                String[] strArr2 = f1353a;
                int length = strArr2.length;
                int i2 = 0;
                while (i < length) {
                    f1354b[i2] = cls.getDeclaredField(strArr2[i]).getInt(null);
                    i2++;
                    i++;
                }
            } catch (Exception e) {
            }
        }

        public static Drawable m2602a(int i) {
            for (int i2 : f1354b) {
                if (i2 == i) {
                    return new ColorDrawable(0);
                }
            }
            return null;
        }
    }

    public static com.facebook.resources.impl.DownloadedFbResources m2490a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f1276g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.resources.impl.DownloadedFbResources.class;
        monitor-enter(r1);
        r0 = f1276g;	 Catch:{ all -> 0x003a }
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
        r0 = m2492b(r0);	 Catch:{ all -> 0x0035 }
        f1276g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f1276g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.resources.impl.DownloadedFbResources.a(com.facebook.inject.InjectorLike):com.facebook.resources.impl.DownloadedFbResources");
    }

    private static DownloadedFbResources m2492b(InjectorLike injectorLike) {
        return new DownloadedFbResources(Resources_BaseResourcesMethodAutoProvider.m2599b(injectorLike), FbResourcesUsageLogger.m2557a(injectorLike), StringResourcesDelegate.m2562a(injectorLike), IdBasedProvider.m1811a(injectorLike, 756), DataUsageCounters.m2584a(injectorLike), new DrawableLoader(IdBasedSingletonScopeProvider.m1809a(injectorLike, 2309), C0093x5209d3a.m2600a(injectorLike), IdBasedSingletonScopeProvider.m1810b(injectorLike, 494)));
    }

    @Inject
    public DownloadedFbResources(Resources resources, FbResourcesUsageLogger fbResourcesUsageLogger, StringResourcesDelegate stringResourcesDelegate, Provider<TriState> provider, DataUsageCounters dataUsageCounters, DrawableLoader drawableLoader) {
        int i;
        int i2 = 0;
        super(resources, fbResourcesUsageLogger);
        this.f1277a = stringResourcesDelegate;
        this.f1279c = provider;
        this.f1278b = dataUsageCounters;
        this.f1280d = drawableLoader;
        drawableLoader.m2597a((Resources) this);
        try {
            Field[] declaredFields = Class.forName("com.facebook.R$xml").getDeclaredFields();
            if (declaredFields.length > 0) {
                i = declaredFields[0].getInt(null);
                int i3 = 1;
                i2 = i;
                while (i3 < declaredFields.length) {
                    try {
                        int i4 = declaredFields[i3].getInt(null);
                        i = Math.min(i, i4);
                        i3++;
                        i2 = Math.max(i2, i4);
                    } catch (Exception e) {
                    }
                }
            } else {
                i = 0;
            }
        } catch (Exception e2) {
            i = 0;
        }
        this.f1281e = i;
        this.f1282f = i2;
    }

    public final void mo354a(Locale locale) {
        super.mo354a(locale);
        this.f1277a.m2582f();
    }

    public String getString(int i) {
        return getText(i).toString();
    }

    public String getString(int i, Object... objArr) {
        return String.format(this.f1277a.m2578b(), getString(i), objArr);
    }

    public String getQuantityString(int i, int i2) {
        return getQuantityText(i, i2).toString();
    }

    public String getQuantityString(int i, int i2, Object... objArr) {
        return String.format(this.f1277a.m2578b(), getQuantityString(i, i2), objArr);
    }

    public String[] getStringArray(int i) {
        m2491a(i);
        m2554a((long) i);
        return this.f1277a.m2579b(i);
    }

    public CharSequence getQuantityText(int i, int i2) {
        m2491a(i);
        return this.f1277a.m2576a(i, i2, PluralCategory.fromFakeText(super.getQuantityText(2131689479, i2)));
    }

    public CharSequence getText(int i) {
        m2491a(i);
        m2554a((long) i);
        return this.f1277a.m2575a(i);
    }

    public CharSequence getText(int i, CharSequence charSequence) {
        m2554a((long) i);
        CharSequence a = i != 0 ? this.f1277a.m2575a(i) : null;
        return a != null ? a : charSequence;
    }

    public CharSequence[] getTextArray(int i) {
        return getStringArray(i);
    }

    public Drawable getDrawable(int i) {
        if (this.f1279c.get() == TriState.YES) {
            this.f1278b.m2591a("resource_usage_drawable_" + getResourceName(i), 1);
        }
        if (i >= this.f1281e && i <= this.f1282f) {
            return this.f1280d.m2596a(i, this);
        }
        Drawable a = OverridenDrawablesLoader.m2602a(i);
        if (a != null) {
            return a;
        }
        if (this.f1280d.m2598a(i)) {
            return this.f1280d.m2596a(i, this);
        }
        return super.getDrawable(i);
    }

    public Drawable getDrawable(int i, Theme theme) {
        if (this.f1279c.get() == TriState.YES) {
            this.f1278b.m2591a("resource_usage_drawable_" + getResourceName(i), 1);
        }
        if (i >= this.f1281e && i <= this.f1282f) {
            return this.f1280d.m2596a(i, this);
        }
        Drawable a = OverridenDrawablesLoader.m2602a(i);
        if (a != null) {
            return a;
        }
        if (this.f1280d.m2598a(i)) {
            return this.f1280d.m2596a(i, this);
        }
        return super.getDrawable(i, theme);
    }

    public XmlResourceParser getLayout(int i) {
        if (this.f1279c.get() == TriState.YES) {
            this.f1278b.m2591a("resource_usage_layout_" + getResourceName(i), 1);
        }
        return super.getLayout(i);
    }

    public final ListenableFuture<Void> mo355b() {
        return this.f1277a.f1337s;
    }

    private static void m2491a(int i) {
        if (i == 0) {
            throw new NotFoundException("Resource id 0x0 requested, this probably means a string resource is missing");
        }
    }
}
