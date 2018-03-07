package com.facebook.messaging.media.upload;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.http.protocol.ApiMethodProgressListener;
import com.facebook.http.protocol.ApiMethodRunnerImpl;
import com.facebook.http.protocol.ApiMethodRunnerParams;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.media.upload.ResumableUploaderFactory.OffsetProgressListener;
import com.facebook.messaging.media.upload.StartResumableUploadMethod.Response;
import com.facebook.ui.media.attachments.MediaResource;
import java.io.File;
import java.util.concurrent.Callable;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.ThreadSafe;
import javax.inject.Inject;
import org.apache.http.client.HttpResponseException;

@UserScoped
@ThreadSafe
/* compiled from: lifetime_budget */
public class ResumableUploadCallableFactory {
    private static final String f12016a = ResumableUploadCallableFactory.class.getName();
    private static final Object f12017e = new Object();
    public final ApiMethodRunnerImpl f12018b;
    public final GetResumableUploadStatusMethod f12019c;
    public final StartResumableUploadMethod f12020d;

    @Immutable
    /* compiled from: lifetime_budget */
    public class Params {
        public final String f12008a;
        public final ApiMethodRunnerParams f12009b;
        public final File f12010c;
        public final MediaResource f12011d;
        public final String f12012e;
        public final ResumableUploadMetricsBuilder f12013f;

        public Params(String str, ApiMethodRunnerParams apiMethodRunnerParams, File file, MediaResource mediaResource, String str2, ResumableUploadMetricsBuilder resumableUploadMetricsBuilder) {
            this.f12008a = str;
            this.f12009b = apiMethodRunnerParams;
            this.f12010c = file;
            this.f12011d = mediaResource;
            this.f12012e = str2;
            this.f12013f = resumableUploadMetricsBuilder;
        }
    }

    /* compiled from: lifetime_budget */
    public class ResumableUploadCallable implements Callable<Response> {
        final /* synthetic */ ResumableUploadCallableFactory f12014a;
        private final Params f12015b;

        public ResumableUploadCallable(ResumableUploadCallableFactory resumableUploadCallableFactory, Params params) {
            this.f12014a = resumableUploadCallableFactory;
            this.f12015b = params;
        }

        public Object call() {
            try {
                String str = this.f12015b.f12008a;
                int intValue = ((Integer) this.f12014a.f12018b.a(this.f12014a.f12019c, new com.facebook.messaging.media.upload.GetResumableUploadStatusMethod.Params(str), this.f12015b.f12009b)).intValue();
                if (this.f12015b.f12013f != null) {
                    this.f12015b.f12013f.m12561a();
                }
                ResumableUploadCallableFactory.f12016a;
                Integer.valueOf(intValue);
                this.f12015b.f12010c.getName();
                if (this.f12015b.f12009b != null) {
                    ApiMethodProgressListener a = this.f12015b.f12009b.a();
                    if (a != null && (a instanceof OffsetProgressListener)) {
                        ((OffsetProgressListener) a).m12571b((long) intValue);
                    }
                }
                try {
                    Response response = (Response) this.f12014a.f12018b.a(this.f12014a.f12020d, new com.facebook.messaging.media.upload.StartResumableUploadMethod.Params(this.f12015b.f12010c, str, this.f12015b.f12011d, this.f12015b.f12012e, intValue), this.f12015b.f12009b);
                    ResumableUploadCallableFactory.f12016a;
                    return response;
                } finally {
                    if (this.f12015b.f12013f != null) {
                        this.f12015b.f12013f.m12565b();
                    }
                }
            } catch (HttpResponseException e) {
                ResumableUploadException.m12560a(e);
                throw e;
            }
        }
    }

    private static ResumableUploadCallableFactory m12559b(InjectorLike injectorLike) {
        return new ResumableUploadCallableFactory(ApiMethodRunnerImpl.a(injectorLike), GetResumableUploadStatusMethod.m12451a(injectorLike), StartResumableUploadMethod.m12580a(injectorLike));
    }

    @Inject
    public ResumableUploadCallableFactory(ApiMethodRunnerImpl apiMethodRunnerImpl, GetResumableUploadStatusMethod getResumableUploadStatusMethod, StartResumableUploadMethod startResumableUploadMethod) {
        this.f12018b = apiMethodRunnerImpl;
        this.f12019c = getResumableUploadStatusMethod;
        this.f12020d = startResumableUploadMethod;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.messaging.media.upload.ResumableUploadCallableFactory m12557a(com.facebook.inject.InjectorLike r7) {
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
        r1 = f12017e;	 Catch:{ all -> 0x006c }
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
        r1 = m12559b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f12017e;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.messaging.media.upload.ResumableUploadCallableFactory) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.messaging.media.upload.ResumableUploadCallableFactory) r0;	 Catch:{  }
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
        r0 = f12017e;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.messaging.media.upload.ResumableUploadCallableFactory) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.messaging.media.upload.ResumableUploadCallableFactory.a(com.facebook.inject.InjectorLike):com.facebook.messaging.media.upload.ResumableUploadCallableFactory");
    }
}
