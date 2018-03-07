package com.facebook.messaging.photoreminders;

import android.content.Context;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: reloadCurrent */
public class PhotoRemindersDebugUtil {
    private final Context f3528a;
    private final FbSharedPreferences f3529b;
    private final Executor f3530c;

    private static PhotoRemindersDebugUtil m3388b(InjectorLike injectorLike) {
        return new PhotoRemindersDebugUtil((Context) injectorLike.getInstance(Context.class), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public PhotoRemindersDebugUtil(Context context, FbSharedPreferences fbSharedPreferences, ExecutorService executorService) {
        this.f3528a = context;
        this.f3529b = fbSharedPreferences;
        this.f3530c = executorService;
    }
}
