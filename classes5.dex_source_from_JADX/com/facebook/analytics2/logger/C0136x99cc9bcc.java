package com.facebook.analytics2.logger;

import com.facebook.analytics2.logger.UploadJobHandler.UploadJobHandlerCallback;
import com.facebook.analytics2.logger.UploadServiceLogic.StartServiceParams;

/* compiled from: theme_image */
class C0136x99cc9bcc implements UploadJobHandlerCallback {
    final /* synthetic */ StartServiceParams f2084a;
    private final UploadScheduler f2085b;

    public C0136x99cc9bcc(StartServiceParams startServiceParams, UploadScheduler uploadScheduler) {
        this.f2084a = startServiceParams;
        this.f2085b = uploadScheduler;
    }

    public final void mo504a(boolean z) {
        if (z && this.f2084a.g != null) {
            this.f2085b.a(this.f2084a.f, this.f2084a.d, this.f2084a.g.a, this.f2084a.g.b);
        }
    }

    public final void mo503a() {
        if (this.f2084a.j != null) {
            this.f2084a.j.release();
        }
    }
}
