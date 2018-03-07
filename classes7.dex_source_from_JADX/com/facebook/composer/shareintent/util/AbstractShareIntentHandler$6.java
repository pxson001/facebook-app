package com.facebook.composer.shareintent.util;

import android.support.v4.app.DialogFragment;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import javax.annotation.Nullable;

/* compiled from: contacts_upload */
public class AbstractShareIntentHandler$6 extends AbstractDisposableFutureCallback<Runnable> {
    final /* synthetic */ DialogFragment f16881a;
    final /* synthetic */ AbstractShareIntentHandler f16882b;

    public AbstractShareIntentHandler$6(AbstractShareIntentHandler abstractShareIntentHandler, DialogFragment dialogFragment) {
        this.f16882b = abstractShareIntentHandler;
        this.f16881a = dialogFragment;
    }

    protected final void m20851a(@Nullable Object obj) {
        Runnable runnable = (Runnable) obj;
        if (runnable != null) {
            this.f16882b.a(runnable);
        }
    }

    protected final void m20852a(Throwable th) {
        this.f16882b.u.c();
        this.f16882b.finish();
    }

    public final void jc_() {
        super.jc_();
        this.f16881a.a();
        this.f16882b.finish();
    }
}
