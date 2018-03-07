package com.facebook.feed.environment.impl;

import android.content.Context;
import com.facebook.feed.environment.HasContext;
import com.facebook.inject.Assisted;
import com.google.common.base.Preconditions;
import java.lang.ref.WeakReference;
import javax.inject.Inject;

/* compiled from: new_payment_shipping_option_picker */
public class HasContextImpl implements HasContext {
    private final WeakReference<Context> f12306a;

    @Inject
    public HasContextImpl(@Assisted Context context) {
        this.f12306a = new WeakReference(context);
    }

    public Context getContext() {
        return (Context) Preconditions.checkNotNull(this.f12306a.get());
    }
}
