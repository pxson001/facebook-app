package com.facebook.photos.prefetch;

import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.photos.prefetch.BackgroundHandoffHelper.BackgroundHandoffConsumer;
import java.util.concurrent.ExecutorService;

/* compiled from: value_hash */
public class BackgroundHandoffHelperProvider extends AbstractAssistedProvider<BackgroundHandoffHelper> {
    public final BackgroundHandoffHelper m644a(ExecutorService executorService, BackgroundHandoffConsumer backgroundHandoffConsumer) {
        return new BackgroundHandoffHelper(DefaultAndroidThreadUtil.b(this), executorService, backgroundHandoffConsumer);
    }
}
