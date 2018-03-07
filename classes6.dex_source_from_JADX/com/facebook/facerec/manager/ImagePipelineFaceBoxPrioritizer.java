package com.facebook.facerec.manager;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.net.Uri;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.facerec.model.LocalFaceRecImageData;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.module.ImagePipelineMethodAutoProvider;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.photos.base.analytics.PreFilledTagLogger;
import com.facebook.photos.base.photos.LocalPhoto;
import com.facebook.photos.base.tagging.LocalPhotoUtil;
import com.facebook.photos.data.method.FetchDefaultTagSuggestions;
import com.facebook.photos.tagging.store.FaceBoxStore;
import com.facebook.tagging.model.TaggingProfile;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

@UserScoped
/* compiled from: not_tagged_tab */
public class ImagePipelineFaceBoxPrioritizer extends FaceBoxPrioritizer {
    private static final CallerContext f9904e = CallerContext.a(FaceBoxPrioritizer.class);
    private static final Object f9905l = new Object();
    public final Lazy<FaceRecManager> f9906f;
    public final DefaultAndroidThreadUtil f9907g;
    public final Executor f9908h;
    private final ExecutorService f9909i;
    private ImagePipeline f9910j;
    private List<LocalFaceRecImageData> f9911k = new ArrayList();

    /* compiled from: not_tagged_tab */
    public class C06023 implements Runnable {
        final /* synthetic */ LocalFaceRecImageData f9901a;
        final /* synthetic */ List f9902b;
        final /* synthetic */ ImagePipelineFaceBoxPrioritizer f9903c;

        public C06023(ImagePipelineFaceBoxPrioritizer imagePipelineFaceBoxPrioritizer, LocalFaceRecImageData localFaceRecImageData, List list) {
            this.f9903c = imagePipelineFaceBoxPrioritizer;
            this.f9901a = localFaceRecImageData;
            this.f9902b = list;
        }

        public void run() {
            this.f9903c.f9907g.a();
            LocalFaceRecImageData e = this.f9903c.m15616e(this.f9901a);
            this.f9903c.m15609a(this.f9901a, !this.f9903c.m15615d(this.f9901a));
            if (!this.f9903c.f9858c) {
                LocalPhotoUtil.m20176a(this.f9902b, e.m15648c());
                e.m15645a(this.f9902b);
                this.f9903c.m15618f(e);
                this.f9903c.mo1023c(e);
            }
            this.f9903c.b = false;
            this.f9903c.m15619h();
        }
    }

    private static ImagePipelineFaceBoxPrioritizer m15626b(InjectorLike injectorLike) {
        return new ImagePipelineFaceBoxPrioritizer(DefaultAndroidThreadUtil.b(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), (ExecutorService) ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(injectorLike), PreFilledTagLogger.m19990b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 9318), IdBasedLazy.a(injectorLike, 5765), FaceBoxStore.m21127a(injectorLike), ImagePipelineMethodAutoProvider.a(injectorLike));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.facerec.manager.ImagePipelineFaceBoxPrioritizer m15625a(com.facebook.inject.InjectorLike r7) {
        /*
        r2 = com.facebook.inject.ScopeSet.a();
        r0 = com.facebook.auth.userscope.UserScope.class;
        r0 = r7.getInstance(r0);
        r0 = (com.facebook.auth.userscope.UserScope) r0;
        r1 = r7.getScopeAwareInjector();
        r1 = r1.b();
        if (r1 != 0) goto L_0x001e;
    L_0x0016:
        r0 = new com.facebook.inject.ProvisioningException;
        r1 = "Called user scoped provider outside of context scope";
        r0.<init>(r1);
        throw r0;
    L_0x001e:
        r3 = r0.a(r1);
        r4 = r3.b();	 Catch:{ all -> 0x006c }
        r1 = f9905l;	 Catch:{ all -> 0x006c }
        r1 = r4.get(r1);	 Catch:{ all -> 0x006c }
        r5 = com.facebook.auth.userscope.UserScope.a;	 Catch:{ all -> 0x006c }
        if (r1 != r5) goto L_0x0035;
    L_0x0030:
        r3.c();
        r0 = 0;
    L_0x0034:
        return r0;
    L_0x0035:
        if (r1 != 0) goto L_0x007c;
    L_0x0037:
        r1 = 4;
        r5 = r2.b(r1);	 Catch:{  }
        r6 = r0.a(r3);	 Catch:{ all -> 0x0067 }
        r0 = r6.e();	 Catch:{ all -> 0x0062 }
        r1 = m15626b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f9905l;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.facerec.manager.ImagePipelineFaceBoxPrioritizer) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.facerec.manager.ImagePipelineFaceBoxPrioritizer) r0;	 Catch:{  }
        r3.c();
        goto L_0x0034;
    L_0x0062:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0067:
        r0 = move-exception;
        r2.c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006c:
        r0 = move-exception;
        r3.c();
        throw r0;
    L_0x0071:
        r0 = f9905l;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.facerec.manager.ImagePipelineFaceBoxPrioritizer) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.facerec.manager.ImagePipelineFaceBoxPrioritizer.a(com.facebook.inject.InjectorLike):com.facebook.facerec.manager.ImagePipelineFaceBoxPrioritizer");
    }

    @Inject
    public ImagePipelineFaceBoxPrioritizer(AndroidThreadUtil androidThreadUtil, Executor executor, ExecutorService executorService, PreFilledTagLogger preFilledTagLogger, FbErrorReporter fbErrorReporter, Lazy<FetchDefaultTagSuggestions> lazy, Lazy<FaceRecManager> lazy2, FaceBoxStore faceBoxStore, ImagePipeline imagePipeline) {
        super(preFilledTagLogger, fbErrorReporter, lazy, lazy2, faceBoxStore);
        this.f9907g = androidThreadUtil;
        this.f9908h = executor;
        this.f9909i = executorService;
        this.f9906f = lazy2;
        this.f9910j = imagePipeline;
    }

    @SuppressLint({"EmptyGenericType"})
    protected final void mo1022b(final LocalFaceRecImageData localFaceRecImageData) {
        this.b = true;
        this.c = false;
        final LocalPhoto localPhoto = localFaceRecImageData.f9939c.f12739f;
        ImagePipeline imagePipeline = this.f9910j;
        ImageRequestBuilder a = ImageRequestBuilder.a(Uri.parse("file://" + localPhoto.f12748d));
        a.d = ((FaceRecManager) this.f9906f.get()).f9891i;
        imagePipeline.c(a.m(), f9904e).a(new BaseBitmapDataSubscriber(this) {
            final /* synthetic */ ImagePipelineFaceBoxPrioritizer f9898c;

            protected final void m15623a(@Nullable Bitmap bitmap) {
                if (bitmap != null) {
                    this.f9898c.f9907g.b();
                    List a = ((ImagePipelineFaceRecManager) this.f9898c.f9906f.get()).m15631a(bitmap, localPhoto.f12749e, true);
                    ImagePipelineFaceBoxPrioritizer imagePipelineFaceBoxPrioritizer = this.f9898c;
                    ExecutorDetour.a(imagePipelineFaceBoxPrioritizer.f9908h, new C06023(imagePipelineFaceBoxPrioritizer, localFaceRecImageData, a), 1561279772);
                }
            }

            protected final void m15624f(DataSource<CloseableReference<CloseableImage>> dataSource) {
                this.f9898c.f9907g.b();
                this.f9898c.b = false;
                this.f9898c.m15609a(localFaceRecImageData, true);
            }
        }, this.f9909i);
    }

    protected final void mo1023c(final LocalFaceRecImageData localFaceRecImageData) {
        if (m15615d(localFaceRecImageData)) {
            this.f9911k.add(localFaceRecImageData);
            this.a = ((FaceRecManager) this.f9906f.get()).m15621a(localFaceRecImageData.m15647b(), localFaceRecImageData.m15652g(), localFaceRecImageData.f9937a);
            Futures.a(this.f9856a, new FutureCallback<List<List<TaggingProfile>>>(this) {
                final /* synthetic */ ImagePipelineFaceBoxPrioritizer f9900b;

                public void onSuccess(Object obj) {
                    List list = (List) obj;
                    this.f9900b.f9907g.a();
                    this.f9900b.m15608a(this.f9900b.m15616e(localFaceRecImageData), list);
                    this.f9900b.m15609a(localFaceRecImageData, true);
                }

                public void onFailure(Throwable th) {
                    this.f9900b.f9907g.a();
                    LocalFaceRecImageData e = this.f9900b.m15616e(localFaceRecImageData);
                    this.f9900b.m15609a(localFaceRecImageData, true);
                    if (!(th instanceof CancellationException)) {
                        this.f9900b.m15608a(e, null);
                    }
                }
            }, this.f9908h);
        }
    }
}
