package com.facebook.graphql.util;

import android.view.WindowManager;
import com.facebook.common.android.WindowManagerMethodAutoProvider;
import com.facebook.graphql.calls.MediaTypeInputMimeType;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.tablet.Boolean_IsTabletMethodAutoProvider;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
/* compiled from: school_list */
public class GraphQLImageHelper {
    private static volatile GraphQLImageHelper f6005g;
    private final float f6006a = 0.8f;
    private final int f6007b = 1080;
    private final Provider<Boolean> f6008c;
    private final Provider<Boolean> f6009d;
    private final Boolean f6010e;
    private final WindowManager f6011f;

    /* compiled from: school_list */
    public enum SIZING_STYLE {
        CONTAIN_FIT("contain-fit"),
        COVER_FILL("cover-fill"),
        COVER_FILL_CROPPED("cover-fill-cropped");
        
        String sizeStyle;

        private SIZING_STYLE(String str) {
            this.sizeStyle = str;
        }

        public final String styleString() {
            return this.sizeStyle;
        }
    }

    public static com.facebook.graphql.util.GraphQLImageHelper m10139a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f6005g;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.graphql.util.GraphQLImageHelper.class;
        monitor-enter(r1);
        r0 = f6005g;	 Catch:{ all -> 0x003a }
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
        r0 = m10141b(r0);	 Catch:{ all -> 0x0035 }
        f6005g = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.m1338a(r4);
        r2.m1505c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f6005g;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.graphql.util.GraphQLImageHelper.a(com.facebook.inject.InjectorLike):com.facebook.graphql.util.GraphQLImageHelper");
    }

    private static GraphQLImageHelper m10141b(InjectorLike injectorLike) {
        return new GraphQLImageHelper(WindowManagerMethodAutoProvider.m8708b(injectorLike), IdBasedProvider.m1811a(injectorLike, 4371), IdBasedProvider.m1811a(injectorLike, 4372), Boolean_IsTabletMethodAutoProvider.m7864a(injectorLike));
    }

    @Inject
    public GraphQLImageHelper(WindowManager windowManager, Provider<Boolean> provider, Provider<Boolean> provider2, Boolean bool) {
        this.f6011f = windowManager;
        this.f6008c = provider;
        this.f6009d = provider2;
        this.f6010e = bool;
    }

    private static MediaTypeInputMimeType m10138a(boolean z) {
        return z ? MediaTypeInputMimeType.IMAGEWEBP : MediaTypeInputMimeType.IMAGEXAUTO;
    }

    public final MediaTypeInputMimeType m10143a() {
        return m10138a(((Boolean) this.f6008c.get()).booleanValue());
    }

    public final MediaTypeInputMimeType m10145b() {
        return m10138a(((Boolean) this.f6009d.get()).booleanValue());
    }

    public final MediaTypeInputMimeType m10146c() {
        if (((Boolean) this.f6008c.get()).booleanValue()) {
            return MediaTypeInputMimeType.IMAGEWEBP;
        }
        return MediaTypeInputMimeType.IMAGEJPEG;
    }

    public static Integer m10140a(int i) {
        return Integer.valueOf(Math.min(i, 1080));
    }

    public final Integer m10144a(int i, int i2) {
        return Integer.valueOf((int) (((double) m10140a(i).intValue()) / ((double) (((float) i) / ((float) i2)))));
    }

    private int m10142i() {
        int e = m10147e();
        if (this.f6010e.booleanValue()) {
            return Math.min(e, (int) (((float) this.f6011f.getDefaultDisplay().getHeight()) * 0.8f));
        }
        return e;
    }

    public final int m10147e() {
        return this.f6011f.getDefaultDisplay().getWidth();
    }

    public final Integer m10148f() {
        return m10140a(m10142i());
    }

    public final Integer m10149g() {
        return m10140a(m10140a(m10142i()).intValue() / 2);
    }

    public final Integer m10150h() {
        return m10140a(m10140a(m10142i()).intValue() / 10);
    }
}
