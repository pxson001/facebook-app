package com.facebook.timeline;

import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.places.checkin.launcher.PlacePickerResultHandler;
import com.facebook.timeline.context.TimelineUserContext;
import com.facebook.timeline.coverphoto.activity.CoverPhotoRepositionActivityLauncherProvider;
import com.facebook.timeline.datafetcher.TimelineDataFetcher;
import com.facebook.timeline.header.data.TimelineHeaderUserData;
import com.facebook.timeline.header.editphotohelper.TimelineEditPhotoHelper;
import com.facebook.timeline.units.model.TimelineAllSectionsData;
import com.google.common.base.Supplier;

/* compiled from: groups_seeds_composer_write_post */
public class TimelineActivityResultHandlerProvider extends AbstractAssistedProvider<TimelineActivityResultHandler> {
    public final TimelineActivityResultHandler m10266a(TimelineFragment timelineFragment, TimelineUserContext timelineUserContext, TimelineHeaderUserData timelineHeaderUserData, Supplier<TimelineEditPhotoHelper> supplier, TimelineDataFetcher timelineDataFetcher) {
        return new TimelineActivityResultHandler(timelineFragment, timelineUserContext, timelineHeaderUserData, supplier, timelineDataFetcher, IdBasedSingletonScopeProvider.a(this, 2179), (CoverPhotoRepositionActivityLauncherProvider) getOnDemandAssistedProviderForStaticDi(CoverPhotoRepositionActivityLauncherProvider.class), IdBasedSingletonScopeProvider.a(this, 3065), IdBasedLazy.a(this, 9686), IdBasedLazy.a(this, 10287), IdBasedSingletonScopeProvider.a(this, 9836), PlacePickerResultHandler.a(this), IdBasedSingletonScopeProvider.a(this, 3863), IdBasedSingletonScopeProvider.a(this, 11217), TimelineAllSectionsData.m12706a((InjectorLike) this));
    }
}
