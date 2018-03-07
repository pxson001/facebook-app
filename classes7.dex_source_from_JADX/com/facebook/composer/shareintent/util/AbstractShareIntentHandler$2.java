package com.facebook.composer.shareintent.util;

import com.google.common.util.concurrent.FutureCallback;
import javax.annotation.Nullable;

/* compiled from: contacts_upload */
class AbstractShareIntentHandler$2 implements FutureCallback<Void> {
    final /* synthetic */ Runnable f16871a;
    final /* synthetic */ AbstractShareIntentHandler f16872b;

    AbstractShareIntentHandler$2(AbstractShareIntentHandler abstractShareIntentHandler, Runnable runnable) {
        this.f16872b = abstractShareIntentHandler;
        this.f16871a = runnable;
    }

    public void onSuccess(@Nullable Object obj) {
        this.f16872b.a(this.f16871a);
    }

    public void onFailure(Throwable th) {
        this.f16872b.finish();
    }
}
