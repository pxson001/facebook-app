package com.facebook.redspace.fragment.controllercallbacks.controller;

import com.facebook.feed.ui.controllers.SeeMoreController;
import com.facebook.feed.util.composer.OfflinePostLoader;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.ipc.profile.TimelineContext;
import com.facebook.photos.galleryutil.events.ConsumptionPhotoEventBus;
import com.facebook.redspace.data.RedSpaceWallCollection;
import com.facebook.redspace.ui.RedSpaceFeedVerticalScrollHelper.HasFeedScrollListener;
import com.facebook.timeline.event.TimelineStoryEventBus;
import com.facebook.widget.listview.MultiAdapterListAdapter;

/* compiled from: PageViewerContext */
public class RedSpaceFeedEventControllerProvider extends AbstractAssistedProvider<RedSpaceFeedEventController> {
    public final RedSpaceFeedEventController m12526a(TimelineContext timelineContext, RedSpaceWallCollection redSpaceWallCollection, MultiAdapterListAdapter multiAdapterListAdapter, HasFeedScrollListener hasFeedScrollListener) {
        RedSpaceFeedEventController redSpaceFeedEventController = new RedSpaceFeedEventController(timelineContext, redSpaceWallCollection, multiAdapterListAdapter, hasFeedScrollListener);
        redSpaceFeedEventController.m12522a(IdBasedLazy.a(this, 6089), IdBasedSingletonScopeProvider.b(this, 609), ConsumptionPhotoEventBus.a(this), FeedEventBus.a(this), TimelineStoryEventBus.a(this), SeeMoreController.a(this), OfflinePostLoader.b(this));
        return redSpaceFeedEventController;
    }
}
