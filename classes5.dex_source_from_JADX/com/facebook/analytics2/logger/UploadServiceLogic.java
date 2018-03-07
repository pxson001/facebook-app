package com.facebook.analytics2.logger;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.analytics2.logger.UploadJobHandler.InvocationParams;
import com.facebook.analytics2.logger.UploadJobHandler.UploadJobHandlerCallback;
import com.facebook.debug.log.BLog;
import com.facebook.infer.annotation.Assertions;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* compiled from: theme_image */
class UploadServiceLogic {
    public static final long f2091a = TimeUnit.SECONDS.toMillis(60);
    private final Context f2092b;
    private final UploadJobHandlerManager f2093c;

    /* compiled from: theme_image */
    public interface JobFinishedNotifier {
        void mo500a(boolean z);
    }

    /* compiled from: theme_image */
    class ForwardingJobHandlerCallback implements UploadJobHandlerCallback {
        private final JobFinishedNotifier f2082a;

        public ForwardingJobHandlerCallback(JobFinishedNotifier jobFinishedNotifier) {
            this.f2082a = jobFinishedNotifier;
        }

        public final void mo504a(boolean z) {
            this.f2082a.mo500a(z);
        }

        public final void mo503a() {
        }
    }

    /* compiled from: theme_image */
    public class LogoutJobParams {
        @Nullable
        public final String f2083a;

        public LogoutJobParams(@Nullable String str) {
            this.f2083a = str;
        }

        public LogoutJobParams(Bundle bundle) {
            this.f2083a = bundle.getString("user_id");
        }

        public final Bundle m2785a() {
            Bundle bundle = new Bundle();
            bundle.putString("user_id", this.f2083a);
            return bundle;
        }
    }

    /* compiled from: theme_image */
    public class StopServiceCallback {
        private final Service f2087a;
        private final int f2088b;

        public StopServiceCallback(Service service, int i) {
            this.f2087a = service;
            this.f2088b = i;
        }

        public final void m2788a() {
            this.f2087a.stopSelf(this.f2088b);
        }
    }

    /* compiled from: theme_image */
    class StopServiceJobHandlerCallback implements UploadJobHandlerCallback {
        private final UploadJobHandlerCallback f2089a;
        private final StopServiceCallback f2090b;

        public StopServiceJobHandlerCallback(UploadJobHandlerCallback uploadJobHandlerCallback, StopServiceCallback stopServiceCallback) {
            this.f2089a = uploadJobHandlerCallback;
            this.f2090b = stopServiceCallback;
        }

        public final void mo504a(boolean z) {
            this.f2089a.mo504a(z);
        }

        public final void mo503a() {
            this.f2089a.mo503a();
            this.f2090b.m2788a();
        }
    }

    public UploadServiceLogic(Context context) {
        this.f2092b = context;
        this.f2093c = new UploadJobHandlerManager(context);
    }

    public final void m2794a(int i, UploadJobConfig uploadJobConfig, JobFinishedNotifier jobFinishedNotifier) {
        Integer.valueOf(i);
        if (!((UploadJobHandlerManager) Assertions.b(this.f2093c)).m2773a(new InvocationParams(i, uploadJobConfig, null, null), new ForwardingJobHandlerCallback(jobFinishedNotifier))) {
            jobFinishedNotifier.mo500a(true);
        }
    }

    public final void m2793a(int i) {
        Integer.valueOf(i);
        ((UploadJobHandlerManager) Assertions.b(this.f2093c)).m2772a(i);
    }

    public final int m2792a(Intent intent, StopServiceCallback stopServiceCallback) {
        try {
            return m2791b(intent, stopServiceCallback);
        } catch (Throwable e) {
            BLog.a("UploadServiceLogic", "Misunderstood service intent: %s", e);
            stopServiceCallback.m2788a();
            return 2;
        }
    }

    private int m2791b(Intent intent, StopServiceCallback stopServiceCallback) {
        if (intent == null) {
            throw new IllegalRemoteArgumentException("Received a null intent in runJobFromService, did you ever return START_STICKY?");
        }
        StartServiceParams a = StartServiceParams.a(intent.getExtras(), this.f2092b);
        a.a(intent);
        String action = intent.getAction();
        if ("com.facebook.analytics2.logger.UPLOAD_NOW".equals(action)) {
            ((UploadJobHandlerManager) Assertions.b(this.f2093c)).m2774b(new InvocationParams(a.f, a.d, a.e, null), new StopServiceJobHandlerCallback(a.b(), stopServiceCallback));
        } else if ("com.facebook.analytics2.logger.USER_LOGOUT".equals(action)) {
            ((UploadJobHandlerManager) Assertions.b(this.f2093c)).m2774b(InvocationParams.m2746a(a.f, a.d, a.e, new LogoutJobParams(a.c).f2083a), new StopServiceJobHandlerCallback(a.b(), stopServiceCallback));
        } else {
            throw new IllegalRemoteArgumentException("Unknown action=" + intent.getAction());
        }
        return 3;
    }
}
