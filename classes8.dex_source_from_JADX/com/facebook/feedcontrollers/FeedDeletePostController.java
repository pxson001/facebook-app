package com.facebook.feedcontrollers;

import com.facebook.api.feed.DeleteStoryMethod.Params.DeleteMode;
import com.facebook.api.feed.data.LegacyFeedUnitUpdater;
import com.facebook.content.event.FbEvent;
import com.facebook.controller.mutation.util.FeedStoryMutator;
import com.facebook.feed.loader.FeedOnDataChangeListener;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.util.DeleteStoryHelper;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.HideEvents.ChangeRendererEvent;
import com.facebook.feed.util.event.HideEvents.StoryDeleteEvent;
import com.facebook.feed.util.event.HideEvents.StoryDeleteEventSubscriber;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.graphql.enums.StoryVisibility;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.galleryutil.events.ConsumptionPhotoEventBus;
import com.facebook.photos.galleryutil.events.ConsumptionPhotoEvents.DeletePhotoEvent;
import com.facebook.photos.galleryutil.events.ConsumptionPhotoEvents.DeletePhotoEventSubscriber;
import com.google.common.base.Strings;
import javax.inject.Inject;

/* compiled from: group_ignore_reported_story */
public class FeedDeletePostController {
    public final FeedEventBus f11931a;
    private final FeedStoryMutator f11932b;
    public final DeleteStoryHelper f11933c;
    private final ConsumptionPhotoEventBus f11934d;
    private StoryDeleteEventSubscriber f11935e;
    public LegacyFeedUnitUpdater f11936f;
    private FeedOnDataChangeListener f11937g;
    private PhotoDeleteSubscriber f11938h;

    /* compiled from: group_ignore_reported_story */
    class PhotoDeleteSubscriber extends DeletePhotoEventSubscriber {
        final /* synthetic */ FeedDeletePostController f11929a;

        public PhotoDeleteSubscriber(FeedDeletePostController feedDeletePostController) {
            this.f11929a = feedDeletePostController;
        }

        public final void m14021b(FbEvent fbEvent) {
            Flattenable a;
            DeletePhotoEvent deletePhotoEvent = (DeletePhotoEvent) fbEvent;
            if (deletePhotoEvent.a != null) {
                a = FeedDeletePostController.m14024a(this.f11929a, deletePhotoEvent.a);
            } else if (deletePhotoEvent.b != null) {
                a = this.f11929a.f11936f.b(deletePhotoEvent.b);
            } else {
                a = null;
            }
            if (a != null) {
                FeedDeletePostController.m14025a(this.f11929a, FeedProps.c(a));
                this.f11929a.f11933c.a(a, deletePhotoEvent.d ? DeleteMode.LOCAL_AND_SERVER : DeleteMode.LOCAL_ONLY);
                this.f11929a.f11931a.a(new ChangeRendererEvent());
            }
        }
    }

    /* compiled from: group_ignore_reported_story */
    class StoryDeleteSubscriber extends StoryDeleteEventSubscriber {
        final /* synthetic */ FeedDeletePostController f11930a;

        public StoryDeleteSubscriber(FeedDeletePostController feedDeletePostController) {
            this.f11930a = feedDeletePostController;
        }

        public final void m14022b(FbEvent fbEvent) {
            Flattenable b;
            StoryDeleteEvent storyDeleteEvent = (StoryDeleteEvent) fbEvent;
            String a = storyDeleteEvent.a();
            String b2 = storyDeleteEvent.b();
            if (a == null && b2 != null) {
                b = this.f11930a.f11936f.b(b2);
            } else if (a != null) {
                b = FeedDeletePostController.m14024a(this.f11930a, a);
            } else {
                b = null;
            }
            if (b != null) {
                FeedDeletePostController.m14025a(this.f11930a, FeedProps.c(b));
            }
        }
    }

    public static FeedDeletePostController m14026b(InjectorLike injectorLike) {
        return new FeedDeletePostController(FeedEventBus.a(injectorLike), FeedStoryMutator.b(injectorLike), DeleteStoryHelper.b(injectorLike), ConsumptionPhotoEventBus.a(injectorLike));
    }

    @Inject
    public FeedDeletePostController(FeedEventBus feedEventBus, FeedStoryMutator feedStoryMutator, DeleteStoryHelper deleteStoryHelper, ConsumptionPhotoEventBus consumptionPhotoEventBus) {
        this.f11931a = feedEventBus;
        this.f11932b = feedStoryMutator;
        this.f11933c = deleteStoryHelper;
        this.f11934d = consumptionPhotoEventBus;
    }

    public static FeedDeletePostController m14023a(InjectorLike injectorLike) {
        return m14026b(injectorLike);
    }

    public final void m14028a(LegacyFeedUnitUpdater legacyFeedUnitUpdater, FeedOnDataChangeListener feedOnDataChangeListener) {
        this.f11935e = new StoryDeleteSubscriber(this);
        this.f11938h = new PhotoDeleteSubscriber(this);
        this.f11931a.a(this.f11935e);
        this.f11934d.a(this.f11938h);
        this.f11936f = legacyFeedUnitUpdater;
        this.f11937g = feedOnDataChangeListener;
    }

    public final void m14027a() {
        this.f11931a.b(this.f11935e);
        this.f11934d.b(this.f11938h);
    }

    public static void m14025a(FeedDeletePostController feedDeletePostController, FeedProps feedProps) {
        feedDeletePostController.f11936f.a((GraphQLStory) feedDeletePostController.f11932b.a(feedProps, StoryVisibility.GONE).a);
        feedDeletePostController.f11937g.c();
    }

    public static GraphQLStory m14024a(FeedDeletePostController feedDeletePostController, String str) {
        if (Strings.isNullOrEmpty(str)) {
            return null;
        }
        for (GraphQLFeedUnitEdge c : feedDeletePostController.f11936f.d(str)) {
            FeedUnit c2 = c.c();
            if (c2 instanceof GraphQLStory) {
                return (GraphQLStory) c2;
            }
        }
        return null;
    }
}
