package com.facebook.photos.mediagallery.ui.tagging;

import android.graphics.RectF;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.FaceBoxInfo;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.FaceBoxInfoModel;
import com.google.common.base.Preconditions;
import java.util.Comparator;
import javax.inject.Singleton;

@Singleton
/* compiled from: slideshow_preview_seen */
public class FaceBoxInfoUtils {
    private static volatile FaceBoxInfoUtils f2488a;

    /* compiled from: slideshow_preview_seen */
    public class C02951 implements Comparator<FaceBoxInfo> {
        final /* synthetic */ FaceBoxInfoUtils f2487a;

        public C02951(FaceBoxInfoUtils faceBoxInfoUtils) {
            this.f2487a = faceBoxInfoUtils;
        }

        public int compare(Object obj, Object obj2) {
            FaceBoxInfoModel faceBoxInfoModel = (FaceBoxInfoModel) obj2;
            RectF a = FaceBoxInfoUtils.m2616a((FaceBoxInfoModel) obj);
            RectF a2 = FaceBoxInfoUtils.m2616a(faceBoxInfoModel);
            int compare = Float.compare(a.left, a2.left);
            return compare != 0 ? compare : Float.compare(a.top, a2.top);
        }
    }

    public static com.facebook.photos.mediagallery.ui.tagging.FaceBoxInfoUtils m2618a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
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
        r0 = f2488a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.photos.mediagallery.ui.tagging.FaceBoxInfoUtils.class;
        monitor-enter(r1);
        r0 = f2488a;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x0039 }
        r3 = r2.b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m2617a();	 Catch:{ all -> 0x0034 }
        f2488a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f2488a;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.mediagallery.ui.tagging.FaceBoxInfoUtils.a(com.facebook.inject.InjectorLike):com.facebook.photos.mediagallery.ui.tagging.FaceBoxInfoUtils");
    }

    private static FaceBoxInfoUtils m2617a() {
        return new FaceBoxInfoUtils();
    }

    public static RectF m2616a(FaceBoxInfoModel faceBoxInfoModel) {
        Preconditions.checkNotNull(faceBoxInfoModel);
        Preconditions.checkNotNull(faceBoxInfoModel.b());
        Preconditions.checkNotNull(faceBoxInfoModel.c());
        return new RectF((float) (faceBoxInfoModel.b().a() - (faceBoxInfoModel.c().a() / 2.0d)), (float) (faceBoxInfoModel.b().b() - (faceBoxInfoModel.c().b() / 2.0d)), (float) (faceBoxInfoModel.b().a() + (faceBoxInfoModel.c().a() / 2.0d)), (float) (faceBoxInfoModel.b().b() + (faceBoxInfoModel.c().b() / 2.0d)));
    }
}
