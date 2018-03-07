package com.facebook.fbui.glyph;

import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.v4.util.LruCache;
import android.support.v4.util.Pools$SimplePool;
import android.support.v4.util.SparseArrayCompat;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: resultSize */
public class GlyphColorizer {
    private static volatile GlyphColorizer f6849d;
    private final Resources f6850a;
    private final LruCache<Key, ConstantState> f6851b = new LruCache(50);
    private final SparseArrayCompat<ColorFilter> f6852c = new SparseArrayCompat();

    /* compiled from: resultSize */
    class Key {
        private static final Pools$SimplePool<Key> f21916a = new Pools$SimplePool(4);
        private int f21917b;
        private int f21918c;

        private Key() {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Key key = (Key) obj;
            if (this.f21917b == key.f21917b && this.f21918c == key.f21918c) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.f21917b * 31) + this.f21918c;
        }

        final void m29727a() {
            f21916a.mo741a(this);
        }

        static Key m29726a(int i, int i2) {
            Key key = (Key) f21916a.mo740a();
            if (key == null) {
                key = new Key();
            }
            key.f21917b = i;
            key.f21918c = i2;
            return key;
        }
    }

    public static com.facebook.fbui.glyph.GlyphColorizer m11486a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f6849d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.fbui.glyph.GlyphColorizer.class;
        monitor-enter(r1);
        r0 = f6849d;	 Catch:{ all -> 0x003a }
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
        r0 = m11487b(r0);	 Catch:{ all -> 0x0035 }
        f6849d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f6849d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.fbui.glyph.GlyphColorizer.a(com.facebook.inject.InjectorLike):com.facebook.fbui.glyph.GlyphColorizer");
    }

    private static GlyphColorizer m11487b(InjectorLike injectorLike) {
        return new GlyphColorizer(ResourcesMethodAutoProvider.m6510a(injectorLike));
    }

    @Inject
    public GlyphColorizer(Resources resources) {
        this.f6850a = resources;
    }

    public final synchronized ColorFilter m11488a(int i) {
        ColorFilter colorFilter;
        colorFilter = (ColorFilter) this.f6852c.m6350a(i);
        if (colorFilter == null) {
            colorFilter = new PorterDuffColorFilter(i, Mode.SRC_IN);
            this.f6852c.m6351a(i, colorFilter);
        }
        return colorFilter;
    }

    public final synchronized Drawable m11489a(int i, int i2) {
        return m11490a(i, i2, true);
    }

    public final synchronized Drawable m11490a(int i, int i2, boolean z) {
        Drawable mutate;
        ConstantState constantState = null;
        synchronized (this) {
            if (i != 0) {
                Object a;
                if (z) {
                    a = Key.m29726a(i, i2);
                    constantState = (ConstantState) this.f6851b.m4432a(a);
                } else {
                    Key key = null;
                }
                if (constantState == null) {
                    mutate = this.f6850a.getDrawable(i).mutate();
                    mutate.setColorFilter(m11488a(i2));
                    Object constantState2 = mutate.getConstantState();
                    if (z && constantState2 != null) {
                        this.f6851b.m4433a(a, constantState2);
                        z = false;
                    }
                } else {
                    mutate = constantState.newDrawable(this.f6850a);
                }
                if (z) {
                    a.m29727a();
                }
            }
        }
        return mutate;
    }

    public final synchronized Drawable m11491a(Drawable drawable, int i) {
        Drawable drawable2;
        if (drawable == null) {
            drawable2 = null;
        } else {
            ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                drawable2 = constantState.newDrawable();
            } else {
                drawable2 = drawable;
            }
            drawable2.setColorFilter(m11488a(i));
        }
        return drawable2;
    }
}
