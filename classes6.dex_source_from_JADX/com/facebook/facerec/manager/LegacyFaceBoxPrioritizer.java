package com.facebook.facerec.manager;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.facerec.model.LocalFaceRecImageData;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.photos.base.analytics.PreFilledTagLogger;
import com.facebook.photos.base.tagging.FaceBox;
import com.facebook.photos.base.tagging.LocalPhotoUtil;
import com.facebook.photos.data.method.FetchDefaultTagSuggestions;
import com.facebook.photos.tagging.store.FaceBoxStore;
import com.facebook.tagging.model.TaggingProfile;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import javax.inject.Inject;

@UserScoped
/* compiled from: not editable text */
public class LegacyFaceBoxPrioritizer extends FaceBoxPrioritizer {
    private static final Object f9917i = new Object();
    private final Lazy<FaceRecManager> f9918e;
    public final DefaultAndroidThreadUtil f9919f;
    private final Executor f9920g;
    private ListenableFuture<List<FaceBox>> f9921h;

    private static LegacyFaceBoxPrioritizer m15633b(InjectorLike injectorLike) {
        return new LegacyFaceBoxPrioritizer(DefaultAndroidThreadUtil.b(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), PreFilledTagLogger.m19990b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), IdBasedSingletonScopeProvider.b(injectorLike, 9318), IdBasedLazy.a(injectorLike, 5765), FaceBoxStore.m21127a(injectorLike));
    }

    @Inject
    public LegacyFaceBoxPrioritizer(AndroidThreadUtil androidThreadUtil, Executor executor, PreFilledTagLogger preFilledTagLogger, FbErrorReporter fbErrorReporter, Lazy<FetchDefaultTagSuggestions> lazy, Lazy<FaceRecManager> lazy2, FaceBoxStore faceBoxStore) {
        super(preFilledTagLogger, fbErrorReporter, lazy, lazy2, faceBoxStore);
        this.f9919f = androidThreadUtil;
        this.f9920g = executor;
        this.f9918e = lazy2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.facerec.manager.LegacyFaceBoxPrioritizer m15632a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f9917i;	 Catch:{ all -> 0x006c }
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
        r1 = m15633b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f9917i;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.facerec.manager.LegacyFaceBoxPrioritizer) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.facerec.manager.LegacyFaceBoxPrioritizer) r0;	 Catch:{  }
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
        r0 = f9917i;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.facerec.manager.LegacyFaceBoxPrioritizer) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.facerec.manager.LegacyFaceBoxPrioritizer.a(com.facebook.inject.InjectorLike):com.facebook.facerec.manager.LegacyFaceBoxPrioritizer");
    }

    protected final void mo1022b(final LocalFaceRecImageData localFaceRecImageData) {
        this.b = true;
        this.c = false;
        this.f9859d.add(localFaceRecImageData);
        this.f9921h = localFaceRecImageData.m15644a((FaceRecManager) this.f9918e.get());
        Futures.a(this.f9921h, new FutureCallback<List<FaceBox>>(this) {
            final /* synthetic */ LegacyFaceBoxPrioritizer f9914b;

            public void onSuccess(Object obj) {
                List list = (List) obj;
                this.f9914b.f9919f.a();
                LocalFaceRecImageData e = this.f9914b.m15616e(localFaceRecImageData);
                this.f9914b.m15609a(localFaceRecImageData, !this.f9914b.m15615d(localFaceRecImageData));
                if (!this.f9914b.f9858c) {
                    LocalPhotoUtil.m20176a(list, e.m15648c());
                    e.m15645a(list);
                    this.f9914b.m15618f(e);
                    this.f9914b.mo1023c(e);
                }
                this.f9914b.b = false;
                this.f9914b.m15619h();
            }

            public void onFailure(Throwable th) {
                this.f9914b.f9919f.a();
                this.f9914b.b = false;
                this.f9914b.m15609a(localFaceRecImageData, true);
            }
        }, this.f9920g);
    }

    protected final void mo1023c(final LocalFaceRecImageData localFaceRecImageData) {
        if (m15615d(localFaceRecImageData)) {
            this.f9859d.add(localFaceRecImageData);
            this.a = ((FaceRecManager) this.f9918e.get()).m15621a(localFaceRecImageData.m15647b(), localFaceRecImageData.m15652g(), localFaceRecImageData.f9937a);
            Futures.a(this.f9856a, new FutureCallback<List<List<TaggingProfile>>>(this) {
                final /* synthetic */ LegacyFaceBoxPrioritizer f9916b;

                public void onSuccess(Object obj) {
                    List list = (List) obj;
                    this.f9916b.f9919f.a();
                    this.f9916b.m15608a(this.f9916b.m15616e(localFaceRecImageData), list);
                    this.f9916b.m15609a(localFaceRecImageData, true);
                }

                public void onFailure(Throwable th) {
                    this.f9916b.f9919f.a();
                    LocalFaceRecImageData e = this.f9916b.m15616e(localFaceRecImageData);
                    this.f9916b.m15609a(localFaceRecImageData, true);
                    if (!(th instanceof CancellationException)) {
                        this.f9916b.m15608a(e, null);
                    }
                }
            }, this.f9920g);
        }
    }

    public final synchronized void mo1024b() {
        super.mo1024b();
        if (this.f9921h != null) {
            this.f9921h.cancel(false);
        }
    }
}
