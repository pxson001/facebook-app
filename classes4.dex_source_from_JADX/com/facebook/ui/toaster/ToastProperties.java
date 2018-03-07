package com.facebook.ui.toaster;

import android.widget.Toast;
import com.google.common.base.Preconditions;
import javax.annotation.Nonnull;

/* compiled from: tracking_event_location */
public class ToastProperties {
    public Toast f774a;

    public ToastProperties(@Nonnull Toast toast) {
        Preconditions.checkNotNull(toast);
        this.f774a = toast;
    }
}
