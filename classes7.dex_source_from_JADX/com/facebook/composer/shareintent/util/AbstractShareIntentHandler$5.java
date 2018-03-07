package com.facebook.composer.shareintent.util;

import android.content.Intent;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;

/* compiled from: contacts_upload */
public class AbstractShareIntentHandler$5 implements Callable<Runnable> {
    final /* synthetic */ Intent f16878a;
    final /* synthetic */ int f16879b;
    final /* synthetic */ AbstractShareIntentHandler f16880c;

    public AbstractShareIntentHandler$5(AbstractShareIntentHandler abstractShareIntentHandler, Intent intent, int i) {
        this.f16880c = abstractShareIntentHandler;
        this.f16878a = intent;
        this.f16879b = i;
    }

    @Nullable
    public Object call() {
        return this.f16880c.a(this.f16878a, this.f16879b);
    }
}
