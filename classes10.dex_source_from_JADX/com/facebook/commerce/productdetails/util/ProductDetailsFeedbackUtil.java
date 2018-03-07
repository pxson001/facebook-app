package com.facebook.commerce.productdetails.util;

import android.content.res.Resources;
import com.facebook.commerce.productdetails.graphql.FetchProductGroupQueryModels.ProductGroupFeedbackModel;
import com.facebook.commerce.productdetails.graphql.FetchProductGroupQueryModels.ProductGroupFeedbackModel.Builder;
import com.facebook.commerce.productdetails.graphql.FetchProductGroupQueryModels.ProductGroupFeedbackModel.LikersModel;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.util.SeparatedSpannableStringBuilder;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Optional;
import java.nio.ByteBuffer;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: db607d3a9631a9078a1a1ea19fd57cfd */
public class ProductDetailsFeedbackUtil {
    private static volatile ProductDetailsFeedbackUtil f15438b;
    private final Resources f15439a;

    public static com.facebook.commerce.productdetails.util.ProductDetailsFeedbackUtil m15972a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f15438b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.commerce.productdetails.util.ProductDetailsFeedbackUtil.class;
        monitor-enter(r1);
        r0 = f15438b;	 Catch:{ all -> 0x003a }
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
        r0 = m15973b(r0);	 Catch:{ all -> 0x0035 }
        f15438b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f15438b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.commerce.productdetails.util.ProductDetailsFeedbackUtil.a(com.facebook.inject.InjectorLike):com.facebook.commerce.productdetails.util.ProductDetailsFeedbackUtil");
    }

    private static ProductDetailsFeedbackUtil m15973b(InjectorLike injectorLike) {
        return new ProductDetailsFeedbackUtil(ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ProductDetailsFeedbackUtil(Resources resources) {
        this.f15439a = resources;
    }

    public final String m15974a(Optional<Integer> optional, Optional<Integer> optional2) {
        SeparatedSpannableStringBuilder separatedSpannableStringBuilder = new SeparatedSpannableStringBuilder(" ");
        if (optional.isPresent() && ((Integer) optional.get()).intValue() > 0) {
            separatedSpannableStringBuilder.a(this.f15439a.getQuantityString(2131689522, ((Integer) optional.get()).intValue(), new Object[]{optional.get()}));
        }
        if (optional2.isPresent() && ((Integer) optional2.get()).intValue() > 0) {
            separatedSpannableStringBuilder.a(this.f15439a.getQuantityString(2131689524, ((Integer) optional2.get()).intValue(), new Object[]{optional2.get()}));
        }
        return separatedSpannableStringBuilder.toString();
    }

    public static ProductGroupFeedbackModel m15971a(ProductGroupFeedbackModel productGroupFeedbackModel, boolean z) {
        int i;
        int a = productGroupFeedbackModel.m15861n() != null ? productGroupFeedbackModel.m15861n().m15829a() : 0;
        Builder builder = new Builder();
        builder.f15229a = productGroupFeedbackModel.m15853b();
        builder.f15230b = productGroupFeedbackModel.m15854c();
        builder.f15231c = productGroupFeedbackModel.m15855d();
        builder.f15232d = productGroupFeedbackModel.nj_();
        builder.f15233e = productGroupFeedbackModel.m15856g();
        builder.f15234f = productGroupFeedbackModel.nk_();
        builder.f15235g = productGroupFeedbackModel.nl_();
        builder.f15236h = productGroupFeedbackModel.m15857j();
        builder.f15237i = productGroupFeedbackModel.m15861n();
        builder.f15238j = productGroupFeedbackModel.m15862o();
        builder.f15239k = productGroupFeedbackModel.m15860m();
        Builder builder2 = builder;
        LikersModel.Builder builder3 = new LikersModel.Builder();
        if (z) {
            i = 1;
        } else {
            i = -1;
        }
        builder3.f15240a = a + i;
        LikersModel.Builder builder4 = builder3;
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        flatBufferBuilder.c(1);
        flatBufferBuilder.a(0, builder4.f15240a, 0);
        flatBufferBuilder.d(flatBufferBuilder.d());
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        builder2.f15237i = new LikersModel(new MutableFlatBuffer(wrap, null, null, true, null));
        Builder builder5 = builder2;
        builder5.f15234f = z;
        return builder5.m15825a();
    }
}
