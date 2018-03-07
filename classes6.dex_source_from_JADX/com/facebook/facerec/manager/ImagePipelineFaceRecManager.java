package com.facebook.facerec.manager;

import android.graphics.Bitmap;
import android.graphics.RectF;
import android.os.Handler;
import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.FbHandlerThreadFactory;
import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.facedetection.Tracker;
import com.facebook.facedetection.model.TagDescriptor;
import com.facebook.http.protocol.ApiMethodRunnerImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.performancelogger.DelegatingPerformanceLogger;
import com.facebook.performancelogger.PerformanceLogger;
import com.facebook.photos.base.tagging.FaceBox;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

@UserScoped
/* compiled from: not_public */
public class ImagePipelineFaceRecManager extends FaceRecManager {
    private static final Object f9912f = new Object();

    private static ImagePipelineFaceRecManager m15630b(InjectorLike injectorLike) {
        return new ImagePipelineFaceRecManager(Handler_ForUiThreadMethodAutoProvider.b(injectorLike), DefaultAndroidThreadUtil.b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), ApiMethodRunnerImpl.a(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), Tracker.m15542a(injectorLike), (PerformanceLogger) DelegatingPerformanceLogger.a(injectorLike), LocalSuggestionsStore.m15642b(injectorLike), FbHandlerThreadFactory.a(injectorLike));
    }

    @Inject
    public ImagePipelineFaceRecManager(Handler handler, DefaultAndroidThreadUtil defaultAndroidThreadUtil, AbstractFbErrorReporter abstractFbErrorReporter, ApiMethodRunnerImpl apiMethodRunnerImpl, ListeningExecutorService listeningExecutorService, Tracker tracker, PerformanceLogger performanceLogger, LocalSuggestionsStore localSuggestionsStore, FbHandlerThreadFactory fbHandlerThreadFactory) {
        super(handler, defaultAndroidThreadUtil, abstractFbErrorReporter, apiMethodRunnerImpl, listeningExecutorService, tracker, performanceLogger, localSuggestionsStore, fbHandlerThreadFactory);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.facerec.manager.ImagePipelineFaceRecManager m15629a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f9912f;	 Catch:{ all -> 0x006c }
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
        r1 = m15630b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f9912f;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.facerec.manager.ImagePipelineFaceRecManager) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.facerec.manager.ImagePipelineFaceRecManager) r0;	 Catch:{  }
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
        r0 = f9912f;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.facerec.manager.ImagePipelineFaceRecManager) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.facerec.manager.ImagePipelineFaceRecManager.a(com.facebook.inject.InjectorLike):com.facebook.facerec.manager.ImagePipelineFaceRecManager");
    }

    public final List<FaceBox> m15631a(Bitmap bitmap, int i, boolean z) {
        this.f9884b.b();
        Preconditions.checkNotNull(bitmap);
        List<FaceBox> arrayList = new ArrayList();
        if (!this.f9883a || !this.f9886d.m15545a()) {
            return arrayList;
        }
        for (TagDescriptor tagDescriptor : this.f9886d.m15544a(bitmap, i, z)) {
            RectF rectF = tagDescriptor.f9826c;
            if (rectF.height() < 0.0f) {
                float f = rectF.top;
                rectF.top = rectF.bottom;
                rectF.bottom = f;
            }
            rectF.toString();
            FaceBox faceBox = new FaceBox(rectF, null, false);
            faceBox.m20154a(tagDescriptor.f9831h, tagDescriptor.f9832i);
            faceBox.f12774j = tagDescriptor.f9830g;
            arrayList.add(faceBox);
        }
        Integer.valueOf(arrayList.size());
        return arrayList;
    }
}
