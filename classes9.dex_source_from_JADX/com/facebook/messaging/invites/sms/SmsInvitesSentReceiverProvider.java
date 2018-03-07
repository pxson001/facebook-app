package com.facebook.messaging.invites.sms;

import android.content.Context;
import android.net.Uri;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.google.common.util.concurrent.ListeningExecutorService;
import javax.inject.Inject;

/* compiled from: mPeerId */
public class SmsInvitesSentReceiverProvider {
    private static final Uri f11355a = Uri.parse("content://sms/sent");
    private static final Uri f11356b = Uri.parse("content://sms/failed");
    private final Context f11357c;
    private final AnalyticsLogger f11358d;
    private final ListeningExecutorService f11359e;

    private static SmsInvitesSentReceiverProvider m11955b(InjectorLike injectorLike) {
        return new SmsInvitesSentReceiverProvider((Context) injectorLike.getInstance(Context.class), AnalyticsLoggerMethodAutoProvider.a(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public SmsInvitesSentReceiverProvider(Context context, AnalyticsLogger analyticsLogger, ListeningExecutorService listeningExecutorService) {
        this.f11357c = context;
        this.f11358d = analyticsLogger;
        this.f11359e = listeningExecutorService;
    }
}
