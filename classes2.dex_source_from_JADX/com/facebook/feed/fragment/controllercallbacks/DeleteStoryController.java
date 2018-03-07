package com.facebook.feed.fragment.controllercallbacks;

import com.facebook.api.feed.DeleteStoryMethod.Params.DeleteMode;
import com.facebook.api.feed.data.LegacyFeedUnitUpdater;
import com.facebook.content.event.FbEvent;
import com.facebook.controller.mutation.util.FeedStoryMutator;
import com.facebook.controllercallbacks.api.BaseController;
import com.facebook.controllercallbacks.api.Holder;
import com.facebook.controllercallbacks.fragment.ResumePauseCallbacks;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.rows.adapter.api.HasMultiRow;
import com.facebook.feed.rows.controllercallbacks.AdapterCreatedCallback;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.StoryProps;
import com.facebook.feed.util.DeleteStoryHelper;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.HideEvents$StoryDeleteEvent;
import com.facebook.feed.util.event.HideEvents$StoryDeleteEventSubscriber;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.graphql.enums.StoryVisibility;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.photos.galleryutil.events.ConsumptionPhotoEventBus;
import com.facebook.photos.galleryutil.events.ConsumptionPhotoEvents$DeletePhotoEvent;
import com.facebook.photos.galleryutil.events.ConsumptionPhotoEvents$DeletePhotoEventSubscriber;
import com.facebook.ultralight.Inject;
import com.facebook.widget.listview.ScrollingViewProxy;
import com.google.common.base.Strings;

/* compiled from: place tips feed unit click w/ null presence description */
public class DeleteStoryController extends BaseController implements ResumePauseCallbacks, AdapterCreatedCallback {
    private final FeedEventBus f9832a;
    private final ConsumptionPhotoEventBus f9833b;
    public final Lazy<DeleteStoryHelper> f9834c;
    private final FeedStoryMutator f9835d;
    private final DeletePhotoEventSubscriber f9836e = new DeletePhotoEventSubscriber(this);
    private final StoryDeleteSubscriber f9837f = new StoryDeleteSubscriber(this);
    public HasInvalidate f9838g;
    public Holder<LegacyFeedUnitUpdater> f9839h;

    /* compiled from: place tips feed unit click w/ null presence description */
    class DeletePhotoEventSubscriber extends ConsumptionPhotoEvents$DeletePhotoEventSubscriber {
        final /* synthetic */ DeleteStoryController f9841a;

        public DeletePhotoEventSubscriber(DeleteStoryController deleteStoryController) {
            this.f9841a = deleteStoryController;
        }

        public final void mo650b(FbEvent fbEvent) {
            Object a;
            ConsumptionPhotoEvents$DeletePhotoEvent consumptionPhotoEvents$DeletePhotoEvent = (ConsumptionPhotoEvents$DeletePhotoEvent) fbEvent;
            if (consumptionPhotoEvents$DeletePhotoEvent.f14028a != null) {
                a = DeleteStoryController.m14859a(this.f9841a, consumptionPhotoEvents$DeletePhotoEvent.f14028a);
            } else if (consumptionPhotoEvents$DeletePhotoEvent.f14029b != null) {
                GraphQLStory b = ((LegacyFeedUnitUpdater) this.f9841a.f9839h.f10429a).mo1382b(consumptionPhotoEvents$DeletePhotoEvent.f14029b);
            } else {
                a = null;
            }
            if (a != null) {
                DeleteStoryController.m14860a(this.f9841a, FeedProps.m19802c(a));
                ((DeleteStoryHelper) this.f9841a.f9834c.get()).a(a, consumptionPhotoEvents$DeletePhotoEvent.f14031d ? DeleteMode.LOCAL_AND_SERVER : DeleteMode.LOCAL_ONLY);
                this.f9841a.f9838g.hL_();
            }
        }
    }

    /* compiled from: place tips feed unit click w/ null presence description */
    class StoryDeleteSubscriber extends HideEvents$StoryDeleteEventSubscriber {
        final /* synthetic */ DeleteStoryController f9842a;

        public StoryDeleteSubscriber(DeleteStoryController deleteStoryController) {
            this.f9842a = deleteStoryController;
        }

        public final void mo650b(FbEvent fbEvent) {
            String str;
            HideEvents$StoryDeleteEvent hideEvents$StoryDeleteEvent = (HideEvents$StoryDeleteEvent) fbEvent;
            String a = hideEvents$StoryDeleteEvent.m20348a();
            String b = hideEvents$StoryDeleteEvent.m20349b();
            GraphQLStory d = StoryProps.m27457d(hideEvents$StoryDeleteEvent.f14027a);
            if (d == null) {
                str = null;
            } else {
                str = d.mo2507g();
            }
            String str2 = str;
            if (a != null || b == null) {
                DeleteStoryController.m14861a(this.f9842a, a, str2);
                return;
            }
            Flattenable b2 = ((LegacyFeedUnitUpdater) this.f9842a.f9839h.f10429a).mo1382b(b);
            if (b2 != null) {
                DeleteStoryController.m14860a(this.f9842a, FeedProps.m19802c(b2));
            }
        }
    }

    public static DeleteStoryController m14858a(InjectorLike injectorLike) {
        return new DeleteStoryController(FeedStoryMutator.m10586b(injectorLike), IdBasedLazy.m1808a(injectorLike, 6089), FeedEventBus.m4573a(injectorLike), ConsumptionPhotoEventBus.m14866a(injectorLike));
    }

    @Inject
    public DeleteStoryController(FeedStoryMutator feedStoryMutator, Lazy<DeleteStoryHelper> lazy, FeedEventBus feedEventBus, ConsumptionPhotoEventBus consumptionPhotoEventBus) {
        this.f9832a = feedEventBus;
        this.f9833b = consumptionPhotoEventBus;
        this.f9834c = lazy;
        this.f9835d = feedStoryMutator;
    }

    public final void mo1889a(HasMultiRow hasMultiRow, ScrollingViewProxy scrollingViewProxy, FeedEnvironment feedEnvironment) {
        this.f9838g = feedEnvironment;
    }

    public final void kF_() {
        this.f9838g = null;
    }

    public final void mo1264c() {
        this.f9832a.m4568a(this.f9837f);
        this.f9833b.m4568a(this.f9836e);
    }

    public final void mo1265d() {
        this.f9832a.m4569b(this.f9837f);
        this.f9833b.m4569b(this.f9836e);
    }

    public static void m14861a(DeleteStoryController deleteStoryController, String str, String str2) {
        if (!Strings.isNullOrEmpty(str)) {
            if (str2 == null) {
                str2 = str;
            }
            Flattenable a = m14859a(deleteStoryController, str2);
            if (a != null) {
                FeedProps a2 = StoryProps.m27453a(FeedProps.m19802c(a), str);
                if (a2 != null) {
                    m14860a(deleteStoryController, a2);
                }
            }
        }
    }

    public static void m14860a(DeleteStoryController deleteStoryController, FeedProps feedProps) {
        ((LegacyFeedUnitUpdater) deleteStoryController.f9839h.f10429a).mo1379a(StoryProps.m27457d(deleteStoryController.f9835d.m10593a(feedProps, StoryVisibility.GONE)));
    }

    public static GraphQLStory m14859a(DeleteStoryController deleteStoryController, String str) {
        if (Strings.isNullOrEmpty(str)) {
            return null;
        }
        for (GraphQLFeedUnitEdge c : ((LegacyFeedUnitUpdater) deleteStoryController.f9839h.f10429a).mo1384d(str)) {
            FeedUnit c2 = c.mo2540c();
            if (c2 instanceof GraphQLStory) {
                return (GraphQLStory) c2;
            }
        }
        return null;
    }
}
