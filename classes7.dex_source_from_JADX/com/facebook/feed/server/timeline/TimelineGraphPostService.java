package com.facebook.feed.server.timeline;

import android.os.Bundle;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.InjectorLike;
import com.facebook.offlinemode.executor.OfflineObliviousOperationsExecutor;
import com.facebook.story.UpdateTimelineAppCollectionParams;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.util.concurrent.ListenableFuture;
import javax.inject.Inject;

/* compiled from: should_upsell_location */
public class TimelineGraphPostService {
    private final DefaultBlueServiceOperationFactory f3760a;
    private final OfflineObliviousOperationsExecutor f3761b;

    public static TimelineGraphPostService m4428b(InjectorLike injectorLike) {
        return new TimelineGraphPostService(DefaultBlueServiceOperationFactory.b(injectorLike), OfflineObliviousOperationsExecutor.a(injectorLike));
    }

    @Inject
    public TimelineGraphPostService(DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, OfflineObliviousOperationsExecutor offlineObliviousOperationsExecutor) {
        this.f3760a = defaultBlueServiceOperationFactory;
        this.f3761b = offlineObliviousOperationsExecutor;
    }

    public final ListenableFuture<OperationResult> m4429a(UpdateTimelineAppCollectionParams updateTimelineAppCollectionParams) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("timelineAppCollectionParamsKey", updateTimelineAppCollectionParams);
        return this.f3761b.a(BlueServiceOperationFactoryDetour.a(this.f3760a, "update_timeline_app_collection_in_newsfeed", bundle, -157181290));
    }
}
