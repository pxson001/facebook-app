package com.facebook.places.future;

import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadImmediateMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.futures.TasksManager;
import java.util.concurrent.ScheduledExecutorService;
import javax.inject.Inject;

/* compiled from: former_participant_ids */
public class PlacesTasksManager<Key> extends TasksManager<Key> {
    public static PlacesTasksManager m22270c(InjectorLike injectorLike) {
        return new PlacesTasksManager(DefaultAndroidThreadUtil.b(injectorLike), (ScheduledExecutorService) ListeningScheduledExecutorService_ForUiThreadImmediateMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public PlacesTasksManager(DefaultAndroidThreadUtil defaultAndroidThreadUtil, ScheduledExecutorService scheduledExecutorService) {
        super(defaultAndroidThreadUtil, scheduledExecutorService);
    }
}
