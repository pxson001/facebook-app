package com.facebook.composer.publish;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import com.facebook.composer.analytics.ComposerAnalyticsLogger;
import com.facebook.composer.analytics.ComposerAnalyticsLogger.Events;
import com.facebook.composer.publish.ComposerPublishServiceHelper.C04712;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.inject.Assisted;
import javax.inject.Inject;

/* compiled from: photos_taken_of */
public class SentryWarningDialogController {
    public final Context f8020a;
    public final Handler f8021b;
    public final ComposerAnalyticsLogger f8022c;

    /* compiled from: photos_taken_of */
    public class C04801 implements OnClickListener {
        final /* synthetic */ C04712 f8014a;
        final /* synthetic */ SentryWarningDialogController f8015b;

        public C04801(SentryWarningDialogController sentryWarningDialogController, C04712 c04712) {
            this.f8015b = sentryWarningDialogController;
            this.f8014a = c04712;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f8014a.m11522b();
            this.f8015b.f8022c.m11142a(Events.MEME_BUSTING_SENTRY_WARNING_CANCEL);
        }
    }

    /* compiled from: photos_taken_of */
    public class C04812 implements OnClickListener {
        final /* synthetic */ C04712 f8016a;
        final /* synthetic */ SentryWarningDialogController f8017b;

        public C04812(SentryWarningDialogController sentryWarningDialogController, C04712 c04712) {
            this.f8017b = sentryWarningDialogController;
            this.f8016a = c04712;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f8016a.m11521a();
            this.f8017b.f8022c.m11142a(Events.MEME_BUSTING_SENTRY_WARNING_ACK);
        }
    }

    /* compiled from: photos_taken_of */
    public class C04823 implements Runnable {
        final /* synthetic */ Builder f8018a;
        final /* synthetic */ SentryWarningDialogController f8019b;

        public C04823(SentryWarningDialogController sentryWarningDialogController, Builder builder) {
            this.f8019b = sentryWarningDialogController;
            this.f8018a = builder;
        }

        public void run() {
            this.f8018a.b();
        }
    }

    @Inject
    public SentryWarningDialogController(@Assisted Context context, Handler handler, ComposerAnalyticsLogger composerAnalyticsLogger) {
        this.f8020a = context;
        this.f8021b = handler;
        this.f8022c = composerAnalyticsLogger;
    }
}
