package com.facebook.greetingcards.create;

import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationCompat.Builder;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.fbservice.ops.BlueServiceOperation.OnCompletedListener;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.inject.Assisted;
import javax.inject.Inject;

/* compiled from: {direct_source} */
public class GreetingCardUploadNotificationListener extends OnCompletedListener {
    private Context f113a;
    private NotificationManager f114b;
    private AbstractFbErrorReporter f115c;
    private Builder f116d;

    @Inject
    public GreetingCardUploadNotificationListener(Context context, NotificationManager notificationManager, AbstractFbErrorReporter abstractFbErrorReporter, @Assisted Builder builder) {
        this.f113a = context;
        this.f114b = notificationManager;
        this.f115c = abstractFbErrorReporter;
        this.f116d = builder;
    }

    public final void m126a(OperationResult operationResult) {
        this.f116d.b(this.f113a.getResources().getString(2131241465)).a(false).a(2130843528).a(0, 0, false);
        this.f114b.notify(9, this.f116d.c());
    }

    public final void m127a(ServiceException serviceException) {
        this.f116d.b(this.f113a.getResources().getString(2131241464)).a(false).a(0, 0, false);
        this.f114b.notify(9, this.f116d.c());
        this.f115c.a("greeting_card_upload_failed", "Upload failed.", serviceException);
    }
}
