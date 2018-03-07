package com.facebook.text.imagerange;

import android.content.Context;
import android.net.Uri;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.unicode.UTF16Range;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbPipelineDraweeController;
import com.facebook.drawee.fbpipeline.GenericDraweeHierarchyBuilderMethodAutoProvider;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.inject.InjectorLike;
import java.util.Comparator;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: deltaMessageDelete */
public class FrescoTextWithImageFetcher {
    public static final Comparator<DraweeSpanSpec> f17602a = new C12851();
    private static volatile FrescoTextWithImageFetcher f17603e;
    private final FbDraweeControllerBuilder f17604b;
    private final GenericDraweeHierarchyBuilder f17605c;
    private final Context f17606d;

    /* compiled from: deltaMessageDelete */
    final class C12851 implements Comparator<DraweeSpanSpec> {
        C12851() {
        }

        public final int compare(Object obj, Object obj2) {
            return ((DraweeSpanSpec) obj2).f17601b.a - ((DraweeSpanSpec) obj).f17601b.a;
        }
    }

    /* compiled from: deltaMessageDelete */
    public class DraweeSpanSpec {
        public final Uri f17600a;
        public final UTF16Range f17601b;

        public DraweeSpanSpec(Uri uri, UTF16Range uTF16Range) {
            this.f17600a = uri;
            this.f17601b = uTF16Range;
        }
    }

    public static com.facebook.text.imagerange.FrescoTextWithImageFetcher m25584a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f17603e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.text.imagerange.FrescoTextWithImageFetcher.class;
        monitor-enter(r1);
        r0 = f17603e;	 Catch:{ all -> 0x003a }
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
        r0 = m25585b(r0);	 Catch:{ all -> 0x0035 }
        f17603e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f17603e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.text.imagerange.FrescoTextWithImageFetcher.a(com.facebook.inject.InjectorLike):com.facebook.text.imagerange.FrescoTextWithImageFetcher");
    }

    private static FrescoTextWithImageFetcher m25585b(InjectorLike injectorLike) {
        return new FrescoTextWithImageFetcher(FbDraweeControllerBuilder.b(injectorLike), GenericDraweeHierarchyBuilderMethodAutoProvider.b(injectorLike), (Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public FrescoTextWithImageFetcher(FbDraweeControllerBuilder fbDraweeControllerBuilder, GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder, Context context) {
        this.f17604b = fbDraweeControllerBuilder;
        this.f17605c = genericDraweeHierarchyBuilder;
        this.f17606d = context;
    }

    public final DraweeSpanStringBuilder m25586a(DraweeSpanStringBuilder draweeSpanStringBuilder, Uri uri, int i, int i2, UTF16Range uTF16Range, int i3, CallerContext callerContext) {
        boolean z = false;
        FbPipelineDraweeController s = this.f17604b.p().a(callerContext).b(uri).s();
        GenericDraweeHierarchyBuilder e = this.f17605c.e(ScaleType.f);
        e.d = 0;
        DraweeHolder a = DraweeHolder.a(e.u(), this.f17606d);
        a.a(s);
        draweeSpanStringBuilder.insert(uTF16Range.a(), " ");
        draweeSpanStringBuilder.insert(uTF16Range.a(), "‌");
        int a2 = uTF16Range.a();
        int c = uTF16Range.c();
        int i4 = i != -1 ? i : i2;
        if (i2 != -1) {
            z = true;
        }
        draweeSpanStringBuilder.m12685a(a, a2, c, i4, i2, z, i3);
        return draweeSpanStringBuilder;
    }
}
