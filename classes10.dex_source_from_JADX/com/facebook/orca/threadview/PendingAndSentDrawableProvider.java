package com.facebook.orca.threadview;

import android.graphics.drawable.Drawable;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: messages_sync_groups_only_threadlist_fetch_error */
public class PendingAndSentDrawableProvider extends AbstractAssistedProvider<PendingAndSentDrawable> {
    public final PendingAndSentDrawable m6981a(Drawable drawable, Drawable drawable2) {
        return new PendingAndSentDrawable(drawable, drawable2, (AbstractFbErrorReporter) FbErrorReporterImpl.a(this));
    }
}
