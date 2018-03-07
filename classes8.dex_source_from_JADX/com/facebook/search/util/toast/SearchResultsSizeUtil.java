package com.facebook.search.util.toast;

import android.content.res.Resources;
import android.graphics.Point;
import android.util.TypedValue;
import android.view.WindowManager;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.android.WindowManagerMethodAutoProvider;
import com.facebook.graphql.util.GraphQLImageHelper;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: megaphone_button_accept */
public class SearchResultsSizeUtil {
    private static volatile SearchResultsSizeUtil f8958h;
    public final Resources f8959a;
    private final GraphQLImageHelper f8960b;
    public final WindowManager f8961c;
    public int f8962d = 0;
    public int f8963e = 0;
    public int f8964f = 0;
    public Point f8965g = new Point();

    public static com.facebook.search.util.toast.SearchResultsSizeUtil m10684a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f8958h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.search.util.toast.SearchResultsSizeUtil.class;
        monitor-enter(r1);
        r0 = f8958h;	 Catch:{ all -> 0x003a }
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
        r0 = m10685b(r0);	 Catch:{ all -> 0x0035 }
        f8958h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f8958h;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.search.util.toast.SearchResultsSizeUtil.a(com.facebook.inject.InjectorLike):com.facebook.search.util.toast.SearchResultsSizeUtil");
    }

    private static SearchResultsSizeUtil m10685b(InjectorLike injectorLike) {
        return new SearchResultsSizeUtil(ResourcesMethodAutoProvider.a(injectorLike), GraphQLImageHelper.a(injectorLike), WindowManagerMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public SearchResultsSizeUtil(Resources resources, GraphQLImageHelper graphQLImageHelper, WindowManager windowManager) {
        this.f8959a = resources;
        this.f8960b = graphQLImageHelper;
        this.f8961c = windowManager;
        this.f8964f = this.f8959a.getDimensionPixelSize(2131427473);
        int dimensionPixelSize = this.f8959a.getDimensionPixelSize(2131431576);
        this.f8962d = this.f8959a.getDimensionPixelSize(2131427472);
        this.f8963e = (this.f8959a.getDimensionPixelSize(2131427474) / 3) - (dimensionPixelSize * 2);
        this.f8961c.getDefaultDisplay().getSize(this.f8965g);
    }

    public final int m10686a() {
        return this.f8964f;
    }

    public final int m10687b() {
        return this.f8959a.getDimensionPixelSize(2131431577);
    }

    public final int m10688c() {
        return this.f8962d;
    }

    public final float m10689e() {
        TypedValue typedValue = new TypedValue();
        this.f8959a.getValue(2131431575, typedValue, true);
        return typedValue.getFloat();
    }

    public final Integer m10690f() {
        return Integer.valueOf((int) (((float) this.f8960b.f().intValue()) / m10689e()));
    }

    public final Integer m10691g() {
        return Integer.valueOf(this.f8965g.x > this.f8965g.y ? this.f8965g.x : this.f8965g.y);
    }

    public final Integer m10692h() {
        return Integer.valueOf(this.f8965g.x > this.f8965g.y ? this.f8965g.y : this.f8965g.x);
    }
}
