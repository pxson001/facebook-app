package com.facebook.analytics2.logger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.RemoteException;
import com.facebook.analytics2.logger.UploadJobHandler.UploadJobHandlerCallback;
import com.facebook.analytics2.logger.UploadSchedulerNoDelayHack.WakeLockReleaseHandler;
import com.facebook.debug.log.BLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: wifi_enabled */
public class UploadServiceLogic$StartServiceParams {
    @GuardedBy("StartServiceParams.this")
    private static List<Handler> f93a;
    @Nullable
    private final Messenger f94b;
    @Nullable
    public final Bundle f95c;
    public final UploadJobConfig f96d;
    @Nullable
    public final String f97e;
    public final int f98f;
    @Nullable
    public final UploadServiceLogic$FallbackConfig f99g;
    private final Context f100h;
    @Nullable
    private UploadJobHandlerCallback f101i;
    public WakeLock f102j;

    public static List<Handler> m103h() {
        List<Handler> list;
        synchronized (UploadServiceLogic$StartServiceParams.class) {
            if (f93a == null) {
                f93a = Collections.synchronizedList(new ArrayList(1));
            }
            list = f93a;
        }
        return list;
    }

    private UploadServiceLogic$StartServiceParams(@Nullable Messenger messenger, @Nullable Bundle bundle, @Nullable String str, UploadJobConfig uploadJobConfig, int i, @Nullable UploadServiceLogic$FallbackConfig uploadServiceLogic$FallbackConfig, Context context) {
        this.f94b = messenger;
        this.f95c = bundle;
        this.f97e = str;
        this.f96d = uploadJobConfig;
        this.f98f = i;
        this.f100h = context;
        this.f99g = uploadServiceLogic$FallbackConfig;
    }

    public static UploadServiceLogic$StartServiceParams m102a(@Nullable WakeLockReleaseHandler wakeLockReleaseHandler, @Nullable Bundle bundle, @Nullable String str, UploadJobConfig uploadJobConfig, int i, @Nullable UploadServiceLogic$FallbackConfig uploadServiceLogic$FallbackConfig) {
        Messenger messenger;
        if (wakeLockReleaseHandler != null) {
            ServiceCallbackHandler serviceCallbackHandler = new ServiceCallbackHandler(wakeLockReleaseHandler);
            messenger = new Messenger(serviceCallbackHandler);
            m103h().add(serviceCallbackHandler);
        } else {
            messenger = null;
        }
        return new UploadServiceLogic$StartServiceParams(messenger, bundle, str, uploadJobConfig, i, uploadServiceLogic$FallbackConfig, null);
    }

    public static UploadServiceLogic$StartServiceParams m101a(Bundle bundle, Context context) {
        Messenger messenger = (Messenger) bundle.getParcelable("_messenger");
        Bundle bundle2 = bundle.getBundle("_extras");
        String string = bundle.getString("_hack_action");
        int i = bundle.getInt("_job_id", -1);
        if (i == -1) {
            throw new IllegalRemoteArgumentException("_job_id is " + bundle.get("_job_id"));
        }
        Bundle bundle3 = bundle.getBundle("_fallback_config");
        return new UploadServiceLogic$StartServiceParams(messenger, bundle2, string, new UploadJobConfig(bundle.getBundle("_upload_job_config")), i, bundle3 != null ? new UploadServiceLogic$FallbackConfig(bundle3) : null, context);
    }

    public final Bundle m104a() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("_messenger", this.f94b);
        bundle.putBundle("_extras", this.f95c);
        bundle.putString("_hack_action", this.f97e);
        bundle.putBundle("_upload_job_config", new Bundle((Bundle) this.f96d.a(new UploadJobConfig$BundlePrimitiveMapper(new Bundle()))));
        bundle.putInt("_job_id", this.f98f);
        if (this.f99g != null) {
            UploadServiceLogic$FallbackConfig uploadServiceLogic$FallbackConfig = this.f99g;
            Bundle bundle2 = new Bundle();
            bundle2.putLong("min_delay_ms", uploadServiceLogic$FallbackConfig.f91a);
            bundle2.putLong("max_delay_ms", uploadServiceLogic$FallbackConfig.f92b);
            bundle.putBundle("_fallback_config", bundle2);
        }
        return bundle;
    }

    public final UploadJobHandlerCallback m106b() {
        if (this.f101i == null) {
            this.f101i = new ReSchedulingWakeLockCallback(this, UploadScheduler.a(this.f100h));
        }
        return this.f101i;
    }

    public final void m105a(Intent intent) {
        this.f102j = ((PowerManager) this.f100h.getApplicationContext().getSystemService("power")).newWakeLock(1, "UploadServiceLogic-" + intent.getComponent().getShortClassName() + "-service-" + this.f98f);
        this.f102j.setReferenceCounted(false);
        this.f102j.acquire(UploadServiceLogic.a);
        if (this.f94b != null) {
            try {
                this.f94b.send(Message.obtain());
            } catch (RemoteException e) {
                BLog.a("UploadServiceLogic", "The peer died unexpectedly, possible wakelock gap detected.");
            }
        }
    }
}
