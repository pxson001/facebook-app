package com.facebook.redspace.fragment.controllercallbacks.controller;

import com.facebook.common.time.Clock;
import com.facebook.content.event.FbEvent;
import com.facebook.content.event.FbEventSubscriberListManager;
import com.facebook.controllercallbacks.api.BaseController;
import com.facebook.controllercallbacks.fragment.FragmentCreateDestroyCallbacks;
import com.facebook.controllercallbacks.fragment.ResumePauseCallbacks;
import com.facebook.feed.ui.controllers.SeeMoreController;
import com.facebook.feed.util.DeleteStoryHelper;
import com.facebook.feed.util.composer.OfflinePostLoader;
import com.facebook.feed.util.composer.OfflinePostLoader.Listener;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.HideEvents.StoryVisibilityEvent;
import com.facebook.feed.util.event.StoryEvents.FeedUnitMutatedEvent;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.mutator.FeedUnitMutator;
import com.facebook.inject.Assisted;
import com.facebook.ipc.profile.TimelineContext;
import com.facebook.photos.galleryutil.events.ConsumptionPhotoEventBus;
import com.facebook.redspace.data.RedSpaceWallCollection;
import com.facebook.redspace.ui.RedSpaceFeedVerticalScrollHelper.HasFeedScrollListener;
import com.facebook.timeline.event.StoryMenuEvents.DeleteStoryClickedEvent;
import com.facebook.timeline.event.StoryMenuEvents.DeleteStoryClickedEventSubscriber;
import com.facebook.timeline.event.TimelineStoryEventBus;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.Lazy;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.widget.listview.MultiAdapterListAdapter;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FutureCallback;
import javax.annotation.Nullable;

/* compiled from: PagesContactInboxGraphQL */
public class RedSpaceFeedEventController extends BaseController implements FragmentCreateDestroyCallbacks, ResumePauseCallbacks {
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<DeleteStoryHelper> f12050a = UltralightRuntime.b;
    @Inject
    @Lazy
    public com.facebook.inject.Lazy<Clock> f12051b = UltralightRuntime.b;
    @Inject
    private ConsumptionPhotoEventBus f12052c;
    @Inject
    private FeedEventBus f12053d;
    @Inject
    private TimelineStoryEventBus f12054e;
    @Inject
    public SeeMoreController f12055f;
    @Inject
    public OfflinePostLoader f12056g;
    public final RedSpaceWallCollection f12057h;
    public final HasFeedScrollListener f12058i;
    public final TimelineContext f12059j;
    public final FbEventSubscriberListManager f12060k = new FbEventSubscriberListManager();
    public final FbEventSubscriberListManager f12061l = new FbEventSubscriberListManager();
    private final DeletePhotoEventSubscriber f12062m = new DeletePhotoEventSubscriber(this);
    private final MultiAdapterListAdapter f12063n;

    /* compiled from: PagesContactInboxGraphQL */
    public class ChangeRendererEventSubscriber extends com.facebook.feed.util.event.HideEvents.ChangeRendererEventSubscriber {
        final /* synthetic */ RedSpaceFeedEventController f12043a;

        public ChangeRendererEventSubscriber(RedSpaceFeedEventController redSpaceFeedEventController) {
            this.f12043a = redSpaceFeedEventController;
        }

        public final void m12513b(FbEvent fbEvent) {
            RedSpaceFeedEventController.m12521f(this.f12043a);
        }
    }

    /* compiled from: PagesContactInboxGraphQL */
    class DeletePhotoEventSubscriber extends com.facebook.photos.galleryutil.events.ConsumptionPhotoEvents.DeletePhotoEventSubscriber {
        final /* synthetic */ RedSpaceFeedEventController f12044a;

        public DeletePhotoEventSubscriber(RedSpaceFeedEventController redSpaceFeedEventController) {
            this.f12044a = redSpaceFeedEventController;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void m12514b(com.facebook.content.event.FbEvent r11) {
            /*
            r10 = this;
            r11 = (com.facebook.photos.galleryutil.events.ConsumptionPhotoEvents.DeletePhotoEvent) r11;
            r4 = 0;
            r0 = r10.f12044a;
            r0 = r0.f12057h;
            r1 = r11.a;
            r2 = r11.b;
            if (r1 == 0) goto L_0x0050;
        L_0x000d:
            r8 = 0;
            if (r1 == 0) goto L_0x0014;
        L_0x0010:
            r6 = r0.f11890c;
            if (r6 != 0) goto L_0x0065;
        L_0x0014:
            r6 = r8;
        L_0x0015:
            r5 = r6;
            if (r5 == 0) goto L_0x0050;
        L_0x0018:
            r2 = r5;
            if (r2 != 0) goto L_0x001c;
        L_0x001b:
            return;
        L_0x001c:
            r0 = r10.f12044a;
            r0 = r0.f12057h;
            r1 = r11.a;
            r3 = r11.b;
            r0.m12347b(r1, r4, r3);
            r0 = r10.f12044a;
            r0 = r0.f12050a;
            r0 = r0.get();
            r0 = (com.facebook.feed.util.DeleteStoryHelper) r0;
            r1 = r11.d;
            if (r1 == 0) goto L_0x004d;
        L_0x0035:
            r1 = com.facebook.api.feed.DeleteStoryMethod.Params.DeleteMode.LOCAL_AND_SERVER;
        L_0x0037:
            r0.a(r2, r1);
            r0 = r10.f12044a;
            com.facebook.redspace.fragment.controllercallbacks.controller.RedSpaceFeedEventController.m12521f(r0);
            r0 = r10.f12044a;
            r0 = r0.f12058i;
            if (r0 == 0) goto L_0x001b;
        L_0x0045:
            r0 = r10.f12044a;
            r0 = r0.f12058i;
            r0.mo349d();
            goto L_0x001b;
        L_0x004d:
            r1 = com.facebook.api.feed.DeleteStoryMethod.Params.DeleteMode.LOCAL_ONLY;
            goto L_0x0037;
        L_0x0050:
            if (r4 == 0) goto L_0x0058;
        L_0x0052:
            r5 = r0.m12340a(r4);
            if (r5 != 0) goto L_0x0018;
        L_0x0058:
            if (r2 == 0) goto L_0x0063;
        L_0x005a:
            r6 = r0.f11893f;
            r6 = r6.e(r2);
            r5 = r6;
            if (r5 != 0) goto L_0x0018;
        L_0x0063:
            r5 = 0;
            goto L_0x0018;
        L_0x0065:
            r6 = 0;
            r7 = r6;
        L_0x0067:
            r6 = r0.m12339a();
            if (r7 >= r6) goto L_0x008f;
        L_0x006d:
            r6 = r0.m12341a(r7);
            r9 = r6 instanceof com.facebook.graphql.model.GraphQLStory;
            if (r9 == 0) goto L_0x008b;
        L_0x0075:
            r6 = (com.facebook.graphql.model.GraphQLStory) r6;
            r9 = com.facebook.feed.rows.core.props.FeedProps.c(r6);
            r9 = com.facebook.feed.rows.core.props.StoryProps.a(r9, r1);
            if (r9 != 0) goto L_0x0015;
        L_0x0081:
            r9 = r6.g();
            r9 = r1.equals(r9);
            if (r9 != 0) goto L_0x0015;
        L_0x008b:
            r6 = r7 + 1;
            r7 = r6;
            goto L_0x0067;
        L_0x008f:
            r6 = r8;
            goto L_0x0015;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.redspace.fragment.controllercallbacks.controller.RedSpaceFeedEventController.DeletePhotoEventSubscriber.b(com.facebook.content.event.FbEvent):void");
        }
    }

    /* compiled from: PagesContactInboxGraphQL */
    public class FeedUnitMutatedEventSubscriber extends com.facebook.feed.util.event.StoryEvents.FeedUnitMutatedEventSubscriber {
        final /* synthetic */ RedSpaceFeedEventController f12045a;

        public FeedUnitMutatedEventSubscriber(RedSpaceFeedEventController redSpaceFeedEventController) {
            this.f12045a = redSpaceFeedEventController;
        }

        public final void m12515b(FbEvent fbEvent) {
            FeedUnitMutatedEvent feedUnitMutatedEvent = (FeedUnitMutatedEvent) fbEvent;
            if (feedUnitMutatedEvent.a instanceof GraphQLStory) {
                this.f12045a.f12057h.m12344a((GraphQLStory) feedUnitMutatedEvent.a);
                RedSpaceFeedEventController.m12521f(this.f12045a);
            }
        }
    }

    /* compiled from: PagesContactInboxGraphQL */
    public class OfflinePostLoaderListener implements Listener {
        final /* synthetic */ RedSpaceFeedEventController f12046a;

        public OfflinePostLoaderListener(RedSpaceFeedEventController redSpaceFeedEventController) {
            this.f12046a = redSpaceFeedEventController;
        }

        public final void m12516a() {
        }

        public final void m12518b() {
        }

        public final boolean m12517a(long j, GraphQLStory graphQLStory) {
            return j == this.f12046a.f12059j.b;
        }
    }

    /* compiled from: PagesContactInboxGraphQL */
    public class SeeMoreControllerSubscriber implements FutureCallback<GraphQLStory> {
        final /* synthetic */ RedSpaceFeedEventController f12047a;

        public SeeMoreControllerSubscriber(RedSpaceFeedEventController redSpaceFeedEventController) {
            this.f12047a = redSpaceFeedEventController;
        }

        public void onSuccess(@Nullable Object obj) {
            RedSpaceFeedEventController.m12521f(this.f12047a);
        }

        public void onFailure(Throwable th) {
        }
    }

    /* compiled from: PagesContactInboxGraphQL */
    public class StoryDeleteSubscriber extends DeleteStoryClickedEventSubscriber {
        final /* synthetic */ RedSpaceFeedEventController f12048a;

        public final void m12519b(FbEvent fbEvent) {
            DeleteStoryClickedEvent deleteStoryClickedEvent = (DeleteStoryClickedEvent) fbEvent;
            this.f12048a.f12057h.m12347b(deleteStoryClickedEvent.b, null, deleteStoryClickedEvent.a);
            RedSpaceFeedEventController.m12521f(this.f12048a);
            if (this.f12048a.f12058i != null) {
                this.f12048a.f12058i.mo349d();
            }
        }

        public StoryDeleteSubscriber(RedSpaceFeedEventController redSpaceFeedEventController) {
            this.f12048a = redSpaceFeedEventController;
            super(redSpaceFeedEventController.f12059j.d);
        }
    }

    /* compiled from: PagesContactInboxGraphQL */
    public class StoryVisibilityEventSubscriber extends com.facebook.feed.util.event.HideEvents.StoryVisibilityEventSubscriber {
        final /* synthetic */ RedSpaceFeedEventController f12049a;

        public StoryVisibilityEventSubscriber(RedSpaceFeedEventController redSpaceFeedEventController) {
            this.f12049a = redSpaceFeedEventController;
        }

        public final void m12520b(FbEvent fbEvent) {
            StoryVisibilityEvent storyVisibilityEvent = (StoryVisibilityEvent) fbEvent;
            GraphQLStory a = this.f12049a.f12057h.m12340a(storyVisibilityEvent.c);
            if (a != null) {
                this.f12049a.f12057h.m12344a((GraphQLStory) FeedUnitMutator.a(a).a(((Clock) this.f12049a.f12051b.get()).a(), storyVisibilityEvent.d, storyVisibilityEvent.e).a());
                if (this.f12049a.f12058i != null) {
                    this.f12049a.f12058i.mo349d();
                }
            }
        }
    }

    final void m12522a(com.facebook.inject.Lazy<DeleteStoryHelper> lazy, com.facebook.inject.Lazy<Clock> lazy2, ConsumptionPhotoEventBus consumptionPhotoEventBus, FeedEventBus feedEventBus, TimelineStoryEventBus timelineStoryEventBus, SeeMoreController seeMoreController, OfflinePostLoader offlinePostLoader) {
        this.f12050a = lazy;
        this.f12051b = lazy2;
        this.f12052c = consumptionPhotoEventBus;
        this.f12053d = feedEventBus;
        this.f12054e = timelineStoryEventBus;
        this.f12055f = seeMoreController;
        this.f12056g = offlinePostLoader;
    }

    @Inject
    public RedSpaceFeedEventController(@Assisted TimelineContext timelineContext, @Assisted RedSpaceWallCollection redSpaceWallCollection, @Assisted MultiAdapterListAdapter multiAdapterListAdapter, @Assisted HasFeedScrollListener hasFeedScrollListener) {
        this.f12059j = (TimelineContext) Preconditions.checkNotNull(timelineContext, "timeline context must be set");
        this.f12057h = (RedSpaceWallCollection) Preconditions.checkNotNull(redSpaceWallCollection, "wall collection must be set");
        this.f12063n = (MultiAdapterListAdapter) Preconditions.checkNotNull(multiAdapterListAdapter, "adapter must be set");
        this.f12058i = (HasFeedScrollListener) Preconditions.checkNotNull(hasFeedScrollListener, "feed scroll listener must be set");
    }

    public final void m12524c() {
        this.f12060k.a(this.f12053d);
        this.f12061l.a(this.f12054e);
        this.f12052c.a(this.f12062m);
    }

    public final void m12525d() {
        this.f12060k.b(this.f12053d);
        this.f12061l.b(this.f12054e);
        this.f12052c.b(this.f12062m);
    }

    public final void m12523b() {
        this.f12055f.b();
    }

    public static void m12521f(RedSpaceFeedEventController redSpaceFeedEventController) {
        AdapterDetour.a(redSpaceFeedEventController.f12063n, -1466714572);
    }
}
