package com.facebook.photos.simplepicker;

import com.facebook.common.executors.ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.photos.local.MediaCursorUtil;
import com.facebook.photos.simplepicker.controller.SimplePickerDataLoadUtil;
import com.facebook.photos.simplepicker.logging.MediaStatsLoggingManager;
import com.facebook.photos.simplepicker.nux.SimplePickerNuxManager;
import com.facebook.photos.tagging.store.TaggableLocalMediaUtil;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* compiled from: similarPlaces */
public class SimplePickerBackgroundTasksControllerProvider extends AbstractAssistedProvider<SimplePickerBackgroundTasksController> {
    public final SimplePickerBackgroundTasksController m2930a(SimplePickerNuxManager simplePickerNuxManager) {
        return new SimplePickerBackgroundTasksController((ExecutorService) ListeningExecutorService_BackgroundExecutorServiceMethodAutoProvider.a(this), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(this), simplePickerNuxManager, TaggableLocalMediaUtil.a(this), SimplePickerDataLoadUtil.m3140b(this), GatekeeperStoreImplMethodAutoProvider.a(this), (FbSharedPreferences) FbSharedPreferencesImpl.a(this), MediaCursorUtil.b(this), MediaStatsLoggingManager.m3164b(this), (Clock) SystemClockMethodAutoProvider.a(this));
    }
}
