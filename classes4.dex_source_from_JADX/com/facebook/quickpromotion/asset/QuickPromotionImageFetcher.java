package com.facebook.quickpromotion.asset;

import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ImageDecodeOptionsBuilder;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.module.ImagePipelineMethodAutoProvider;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.NeedsApplicationInjector;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.Creative;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.ImageParameters;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.TemplateType;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.Map;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: qe_group_optin_variations */
public class QuickPromotionImageFetcher {
    public static final CallerContext f3943a = CallerContext.a(QuickPromotionImageFetcher.class, "quick_promotion_interstitial");
    private static volatile QuickPromotionImageFetcher f3944e;
    public final Resources f3945b;
    public final ImagePipeline f3946c;
    private final FbDraweeControllerBuilder f3947d;

    public static com.facebook.quickpromotion.asset.QuickPromotionImageFetcher m4405a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f3944e;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.quickpromotion.asset.QuickPromotionImageFetcher.class;
        monitor-enter(r1);
        r0 = f3944e;	 Catch:{ all -> 0x003a }
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
        r0 = m4407b(r0);	 Catch:{ all -> 0x0035 }
        f3944e = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f3944e;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.quickpromotion.asset.QuickPromotionImageFetcher.a(com.facebook.inject.InjectorLike):com.facebook.quickpromotion.asset.QuickPromotionImageFetcher");
    }

    private static QuickPromotionImageFetcher m4407b(InjectorLike injectorLike) {
        return new QuickPromotionImageFetcher(ImagePipelineMethodAutoProvider.a(injectorLike), FbDraweeControllerBuilder.b(injectorLike), ResourcesMethodAutoProvider.a(injectorLike.getApplicationInjector()));
    }

    @Inject
    public QuickPromotionImageFetcher(ImagePipeline imagePipeline, FbDraweeControllerBuilder fbDraweeControllerBuilder, @NeedsApplicationInjector Resources resources) {
        this.f3946c = imagePipeline;
        this.f3947d = fbDraweeControllerBuilder;
        this.f3945b = resources;
    }

    public final Map<Integer, ImageRequest> m4412a(QuickPromotionDefinition quickPromotionDefinition) {
        Builder builder = ImmutableMap.builder();
        ImmutableList b = quickPromotionDefinition.m3669b();
        for (int i = 0; i < b.size(); i++) {
            ImageRequest a = m4411a((Creative) b.get(i), ImageType.ANY);
            if (a != null) {
                builder.b(Integer.valueOf(i), a);
            }
        }
        return builder.b();
    }

    @Nullable
    public final ImageRequest m4411a(Creative creative, ImageType imageType) {
        int color;
        ImageRequestBuilder a;
        ImageParameters b = m4408b(creative, imageType);
        ImageDecodeOptionsBuilder newBuilder = ImageDecodeOptions.newBuilder();
        switch (2.a[creative.template.ordinal()]) {
            case 1:
                color = this.f3945b.getColor(2131361940);
                break;
            case 2:
                color = this.f3945b.getColor(2131362366);
                break;
            default:
                color = -1;
                break;
        }
        newBuilder.b = color;
        ImageDecodeOptions h = newBuilder.h();
        if (imageType != ImageType.STATIC && creative.animatedImageParams != null && !TextUtils.isEmpty(creative.animatedImageParams.uri)) {
            a = ImageRequestBuilder.a(Uri.parse(b.uri));
            a.e = h;
            a = a;
        } else if (imageType == ImageType.ANIMATED || creative.imageParams == null || TextUtils.isEmpty(creative.imageParams.uri)) {
            return null;
        } else {
            a = ImageRequestBuilder.a(Uri.parse(b.uri));
        }
        return a.m();
    }

    public static ImageParameters m4408b(Creative creative, ImageType imageType) {
        if (imageType != ImageType.STATIC && creative.animatedImageParams != null && !TextUtils.isEmpty(creative.animatedImageParams.uri)) {
            return creative.animatedImageParams;
        }
        if (imageType == ImageType.ANIMATED || creative.imageParams == null || TextUtils.isEmpty(creative.imageParams.uri)) {
            return null;
        }
        return creative.imageParams;
    }

    public final int m4409a(ImageParameters imageParameters, Creative creative) {
        int i = imageParameters.width;
        float f = Resources.getSystem().getDisplayMetrics().density;
        if (imageParameters.scale > 0.0f && f < imageParameters.scale) {
            i = (int) (((double) (((float) imageParameters.width) * (f / imageParameters.scale))) + 0.5d);
        }
        TemplateType templateType = creative.template;
        if (templateType == null || templateType == TemplateType.UNKNOWN) {
            return i;
        }
        int dimensionPixelSize;
        switch (2.a[templateType.ordinal()]) {
            case 1:
                dimensionPixelSize = this.f3945b.getDimensionPixelSize(2131430047);
                break;
            case 2:
                dimensionPixelSize = this.f3945b.getDimensionPixelSize(2131430045);
                break;
            case 3:
                dimensionPixelSize = this.f3945b.getDimensionPixelSize(2131430051);
                break;
            case 4:
                dimensionPixelSize = this.f3945b.getDimensionPixelSize(2131430052);
                break;
            case 5:
            case 6:
            case 7:
                dimensionPixelSize = this.f3945b.getDimensionPixelSize(2131430054);
                break;
            default:
                dimensionPixelSize = -1;
                break;
        }
        int i2 = dimensionPixelSize;
        if (i2 != -1) {
            return Math.min(i, i2);
        }
        return i;
    }

    public final int m4414b(ImageParameters imageParameters, Creative creative) {
        int i = imageParameters.height;
        float f = Resources.getSystem().getDisplayMetrics().density;
        if (imageParameters.scale > 0.0f && f < imageParameters.scale) {
            i = (int) (((double) (((float) imageParameters.height) * (f / imageParameters.scale))) + 0.5d);
        }
        TemplateType templateType = creative.template;
        if (templateType == null || templateType == TemplateType.UNKNOWN) {
            return i;
        }
        int dimensionPixelSize;
        switch (2.a[templateType.ordinal()]) {
            case 1:
                dimensionPixelSize = this.f3945b.getDimensionPixelSize(2131430048);
                break;
            case 2:
                dimensionPixelSize = this.f3945b.getDimensionPixelSize(2131430046);
                break;
            case 3:
            case 8:
            case 9:
            case 10:
                dimensionPixelSize = this.f3945b.getDimensionPixelSize(2131430049);
                break;
            case 5:
            case 6:
            case 7:
                dimensionPixelSize = this.f3945b.getDimensionPixelSize(2131430053);
                break;
            default:
                dimensionPixelSize = -1;
                break;
        }
        int i2 = dimensionPixelSize;
        if (i2 != -1) {
            return Math.min(i, i2);
        }
        return i;
    }

    public final boolean m4413a(FbDraweeView fbDraweeView, Creative creative, CallerContext callerContext, ControllerListener controllerListener) {
        ImageRequest a = m4411a(creative, ImageType.ANY);
        if (a == null) {
            return false;
        }
        fbDraweeView.setController(((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) this.f3947d.a(callerContext).b(fbDraweeView.getController())).c(a)).a(controllerListener)).s());
        return true;
    }

    public static void m4406a(Creative creative, FbDraweeView fbDraweeView) {
        ImageParameters imageParameters = creative.imageParams;
        if (imageParameters != null && !Strings.isNullOrEmpty(imageParameters.name)) {
            fbDraweeView.setContentDescription(imageParameters.name);
        }
    }

    public final ControllerListener m4410a() {
        return new 1(this);
    }
}
