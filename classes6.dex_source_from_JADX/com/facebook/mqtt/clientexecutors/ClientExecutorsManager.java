package com.facebook.mqtt.clientexecutors;

import android.content.Context;
import com.facebook.common.executors.BackgroundWorkLogger;
import com.facebook.common.executors.BaseBackgroundWorkLogger;
import com.facebook.common.executors.ConstrainedExecutorsStatusController;
import com.facebook.common.executors.ExecutorsModule;
import com.facebook.common.executors.ScheduledExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ScheduledExecutorService_SingleThreadedExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ThreadPoolFactory;
import com.facebook.inject.ForAppContext;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: top_right */
public class ClientExecutorsManager {
    private final boolean f2844a;
    private final ExecutorService f2845b;
    private final ExecutorService f2846c;
    private final ScheduledExecutorService f2847d;
    private final ScheduledExecutorService f2848e;

    /* compiled from: top_right */
    class GkStoringTask implements Runnable {
        private final File f2842a;
        private final Provider<Boolean> f2843b;

        public GkStoringTask(File file, Provider<Boolean> provider) {
            this.f2842a = file;
            this.f2843b = provider;
        }

        public void run() {
            boolean booleanValue = ((Boolean) this.f2843b.get()).booleanValue();
            if (booleanValue == this.f2842a.exists()) {
                return;
            }
            if (booleanValue) {
                try {
                    this.f2842a.createNewFile();
                    return;
                } catch (IOException e) {
                    return;
                }
            }
            this.f2842a.delete();
        }
    }

    private static ClientExecutorsManager m3955b(InjectorLike injectorLike) {
        return new ClientExecutorsManager((Context) injectorLike.getInstance(Context.class, ForAppContext.class), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), IdBasedProvider.a(injectorLike, 4224), ScheduledExecutorService_SingleThreadedExecutorServiceMethodAutoProvider.b(injectorLike), (ExecutorService) ExecutorsModule.e(ThreadPoolFactory.a(injectorLike), (BackgroundWorkLogger) BaseBackgroundWorkLogger.a(injectorLike), IdBasedProvider.a(injectorLike, 375), ConstrainedExecutorsStatusController.a(injectorLike)), ScheduledExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), ExecutorsModule.f(ThreadPoolFactory.a(injectorLike), IdBasedProvider.a(injectorLike, 375)));
    }

    @Inject
    public ClientExecutorsManager(@ForAppContext Context context, FbSharedPreferences fbSharedPreferences, Provider<Boolean> provider, ExecutorService executorService, ExecutorService executorService2, ScheduledExecutorService scheduledExecutorService, ScheduledExecutorService scheduledExecutorService2) {
        File file = new File(context.getFilesDir(), "android_mqtt_executor_service");
        this.f2844a = file.exists();
        this.f2845b = executorService;
        this.f2846c = executorService2;
        this.f2847d = scheduledExecutorService;
        this.f2848e = scheduledExecutorService2;
        fbSharedPreferences.a(new GkStoringTask(file, provider));
    }
}
