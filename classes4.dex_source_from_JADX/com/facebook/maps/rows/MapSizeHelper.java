package com.facebook.maps.rows;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.facebook.common.util.SizeUtil;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BasePaddingStyleResolver;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: new_active_time_ms */
public class MapSizeHelper {
    private static volatile MapSizeHelper f7161c;
    private final Lazy<Resources> f7162a;
    private final Lazy<BasePaddingStyleResolver> f7163b;

    public static com.facebook.maps.rows.MapSizeHelper m7484a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f7161c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.maps.rows.MapSizeHelper.class;
        monitor-enter(r1);
        r0 = f7161c;	 Catch:{ all -> 0x003a }
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
        r0 = m7485b(r0);	 Catch:{ all -> 0x0035 }
        f7161c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f7161c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.maps.rows.MapSizeHelper.a(com.facebook.inject.InjectorLike):com.facebook.maps.rows.MapSizeHelper");
    }

    private static MapSizeHelper m7485b(InjectorLike injectorLike) {
        return new MapSizeHelper(IdBasedLazy.a(injectorLike, 1704), IdBasedSingletonScopeProvider.b(injectorLike, 30));
    }

    @Inject
    public MapSizeHelper(Lazy<BasePaddingStyleResolver> lazy, Lazy<Resources> lazy2) {
        this.f7163b = lazy;
        this.f7162a = lazy2;
    }

    public final int m7487a(FeedProps<GraphQLStory> feedProps) {
        DisplayMetrics displayMetrics = ((Resources) this.f7162a.get()).getDisplayMetrics();
        return displayMetrics.widthPixels - (((BasePaddingStyleResolver) this.f7163b.get()).a(PaddingStyle.a, feedProps, displayMetrics.density) * 2);
    }

    public final int m7486a() {
        return SizeUtil.a((Resources) this.f7162a.get(), 133.0f);
    }

    public static int m7483a(int i, float f) {
        return (int) (((float) i) / f);
    }
}
