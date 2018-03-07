package com.facebook.feed.fragment.controllercallbacks;

import android.content.Context;
import com.facebook.api.feed.data.LegacyFeedUnitUpdater;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.content.event.FbEvent;
import com.facebook.content.event.FbEventSubscriberListManager;
import com.facebook.controllercallbacks.api.BaseController;
import com.facebook.controllercallbacks.api.Holder;
import com.facebook.controllercallbacks.fragment.ResumePauseCallbacks;
import com.facebook.feed.data.followup.FollowUpActionDecider;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.sponsored.AdsOffsiteExperienceSurveyController;
import com.facebook.feed.tooltip.PhotoReturnDetector;
import com.facebook.feed.util.event.FeedEventBus;
import com.facebook.feed.util.event.StoryEvents$FetchFollowUpUnitEvent;
import com.facebook.feed.util.event.StoryEvents$FetchFollowUpUnitSubscriber;
import com.facebook.feed.util.event.StoryEvents$OutboundClickedEvent;
import com.facebook.feed.util.event.StoryEvents$OutboundClickedEventSubscriber;
import com.facebook.feed.util.event.StoryEvents$PhotoClickedEvent;
import com.facebook.feed.util.event.StoryEvents$PhotoClickedEventSubscriber;
import com.facebook.feed.util.event.StoryEvents$VideoClickedEvent;
import com.facebook.feed.util.event.StoryEvents$VideoClickedEventSubscriber;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.graphql.enums.GraphQLFollowUpFeedUnitActionType;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLFeedUnitEdge;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.InjectorLike;
import com.facebook.ufiservices.event.UfiEvents$CommentButtonClickedEvent;
import com.facebook.ufiservices.event.UfiEvents$CommentButtonClickedEventSubscriber;
import com.facebook.ufiservices.event.UfiEvents$ReactionUpdatedEvent;
import com.facebook.ufiservices.event.UfiEvents$ReactionUpdatedEventSubscriber;
import com.facebook.ufiservices.event.UfiEvents$ShareStoryPublishEvent;
import com.facebook.ufiservices.event.UfiEvents$ShareStoryPublishEventSubscriber;
import com.facebook.ultralight.Inject;
import com.google.common.base.Strings;
import javax.annotation.Nullable;

/* compiled from: photo_upload_progress */
public class FollowUpUnitController extends BaseController implements ResumePauseCallbacks {
    private static final CallerContext f9936a = CallerContext.m9061a(FollowUpUnitController.class, "native_newsfeed");
    private final FollowUpActionDecider f9937b;
    public final AdsOffsiteExperienceSurveyController f9938c;
    public final PhotoReturnDetector f9939d;
    private final FeedEventBus f9940e;
    private final FbEventSubscriberListManager f9941f;
    public Context f9942g;
    public Holder<LegacyFeedUnitUpdater> f9943h;

    /* compiled from: photo_upload_progress */
    class CommentButtonClickSubscriber extends UfiEvents$CommentButtonClickedEventSubscriber {
        final /* synthetic */ FollowUpUnitController f10028a;

        public CommentButtonClickSubscriber(FollowUpUnitController followUpUnitController) {
            this.f10028a = followUpUnitController;
        }

        public final void mo650b(FbEvent fbEvent) {
            UfiEvents$CommentButtonClickedEvent ufiEvents$CommentButtonClickedEvent = (UfiEvents$CommentButtonClickedEvent) fbEvent;
            FollowUpUnitController.m14969a(this.f10028a, ufiEvents$CommentButtonClickedEvent.f14033b == null ? ufiEvents$CommentButtonClickedEvent.f14032a : ufiEvents$CommentButtonClickedEvent.f14033b, GraphQLFollowUpFeedUnitActionType.COMMENT);
        }
    }

    /* compiled from: photo_upload_progress */
    class OutboundClickSubscriber extends StoryEvents$OutboundClickedEventSubscriber {
        final /* synthetic */ FollowUpUnitController f10029a;

        public OutboundClickSubscriber(FollowUpUnitController followUpUnitController) {
            this.f10029a = followUpUnitController;
        }

        public final void mo650b(FbEvent fbEvent) {
            StoryEvents$OutboundClickedEvent storyEvents$OutboundClickedEvent = (StoryEvents$OutboundClickedEvent) fbEvent;
            String str = storyEvents$OutboundClickedEvent.f13914b == null ? storyEvents$OutboundClickedEvent.f13913a : storyEvents$OutboundClickedEvent.f13914b;
            GraphQLStory a = FollowUpUnitController.m14968a(this.f10029a, str);
            AdsOffsiteExperienceSurveyController adsOffsiteExperienceSurveyController = this.f10029a.f9938c;
            if (!(a == null || !adsOffsiteExperienceSurveyController.f9951c.f10015a || a.ab_() == null)) {
                adsOffsiteExperienceSurveyController.f9954f = adsOffsiteExperienceSurveyController.f9953e.now();
            }
            FollowUpUnitController.m14969a(this.f10029a, str, GraphQLFollowUpFeedUnitActionType.OUTBOUND_CLICK);
        }
    }

    /* compiled from: photo_upload_progress */
    class PhotoClickSubscriber extends StoryEvents$PhotoClickedEventSubscriber {
        final /* synthetic */ FollowUpUnitController f10030a;

        public PhotoClickSubscriber(FollowUpUnitController followUpUnitController) {
            this.f10030a = followUpUnitController;
        }

        public final void mo650b(FbEvent fbEvent) {
            StoryEvents$PhotoClickedEvent storyEvents$PhotoClickedEvent = (StoryEvents$PhotoClickedEvent) fbEvent;
            FollowUpUnitController.m14969a(this.f10030a, storyEvents$PhotoClickedEvent.f14035b == null ? storyEvents$PhotoClickedEvent.f14034a : storyEvents$PhotoClickedEvent.f14035b, GraphQLFollowUpFeedUnitActionType.PHOTO_CLICK);
            PhotoReturnDetector photoReturnDetector = this.f10030a.f9939d;
            photoReturnDetector.f10024e = storyEvents$PhotoClickedEvent;
            photoReturnDetector.f10025f = photoReturnDetector.f10023d.now();
        }
    }

    /* compiled from: photo_upload_progress */
    class VideoClickSubscriber extends StoryEvents$VideoClickedEventSubscriber {
        final /* synthetic */ FollowUpUnitController f10031a;

        public VideoClickSubscriber(FollowUpUnitController followUpUnitController) {
            this.f10031a = followUpUnitController;
        }

        public final void mo650b(FbEvent fbEvent) {
            StoryEvents$VideoClickedEvent storyEvents$VideoClickedEvent = (StoryEvents$VideoClickedEvent) fbEvent;
            FollowUpUnitController.m14969a(this.f10031a, storyEvents$VideoClickedEvent.f14037b == null ? storyEvents$VideoClickedEvent.f14036a : storyEvents$VideoClickedEvent.f14037b, GraphQLFollowUpFeedUnitActionType.VIDEO_PLAY);
        }
    }

    /* compiled from: photo_upload_progress */
    class ShareClickSubscriber extends UfiEvents$ShareStoryPublishEventSubscriber {
        final /* synthetic */ FollowUpUnitController f10032a;

        public ShareClickSubscriber(FollowUpUnitController followUpUnitController) {
            this.f10032a = followUpUnitController;
        }

        public final void mo650b(FbEvent fbEvent) {
            UfiEvents$ShareStoryPublishEvent ufiEvents$ShareStoryPublishEvent = (UfiEvents$ShareStoryPublishEvent) fbEvent;
            FollowUpUnitController.m14969a(this.f10032a, ufiEvents$ShareStoryPublishEvent.f14040c == null ? ufiEvents$ShareStoryPublishEvent.f14038a : ufiEvents$ShareStoryPublishEvent.f14040c, GraphQLFollowUpFeedUnitActionType.SHARE);
        }
    }

    /* compiled from: photo_upload_progress */
    class ReactionUpdatedEventSubscriber extends UfiEvents$ReactionUpdatedEventSubscriber {
        final /* synthetic */ FollowUpUnitController f10033a;

        public ReactionUpdatedEventSubscriber(FollowUpUnitController followUpUnitController) {
            this.f10033a = followUpUnitController;
        }

        public final void mo650b(FbEvent fbEvent) {
            UfiEvents$ReactionUpdatedEvent ufiEvents$ReactionUpdatedEvent = (UfiEvents$ReactionUpdatedEvent) fbEvent;
            if (!ufiEvents$ReactionUpdatedEvent.f14044d) {
                FollowUpUnitController.m14969a(this.f10033a, ufiEvents$ReactionUpdatedEvent.f14042b, GraphQLFollowUpFeedUnitActionType.COMMENT);
            }
        }
    }

    /* compiled from: photo_upload_progress */
    class FetchFollowUpUnitSubscriber extends StoryEvents$FetchFollowUpUnitSubscriber {
        final /* synthetic */ FollowUpUnitController f10034a;

        public FetchFollowUpUnitSubscriber(FollowUpUnitController followUpUnitController) {
            this.f10034a = followUpUnitController;
        }

        public final void mo650b(FbEvent fbEvent) {
            StoryEvents$FetchFollowUpUnitEvent storyEvents$FetchFollowUpUnitEvent = (StoryEvents$FetchFollowUpUnitEvent) fbEvent;
            FollowUpUnitController.m14969a(this.f10034a, storyEvents$FetchFollowUpUnitEvent.f14045a, storyEvents$FetchFollowUpUnitEvent.f14046b);
        }
    }

    public static FollowUpUnitController m14967a(InjectorLike injectorLike) {
        return new FollowUpUnitController(FbEventSubscriberListManager.m14130a(injectorLike), FollowUpActionDecider.m14972a(injectorLike), AdsOffsiteExperienceSurveyController.m14975a(injectorLike), PhotoReturnDetector.m15064a(injectorLike), FeedEventBus.m4573a(injectorLike));
    }

    @Inject
    public FollowUpUnitController(FbEventSubscriberListManager fbEventSubscriberListManager, FollowUpActionDecider followUpActionDecider, AdsOffsiteExperienceSurveyController adsOffsiteExperienceSurveyController, PhotoReturnDetector photoReturnDetector, FeedEventBus feedEventBus) {
        this.f9937b = followUpActionDecider;
        this.f9938c = adsOffsiteExperienceSurveyController;
        this.f9939d = photoReturnDetector;
        this.f9940e = feedEventBus;
        this.f9941f = fbEventSubscriberListManager;
        this.f9941f.m14133a(new CommentButtonClickSubscriber(this));
        this.f9941f.m14133a(new OutboundClickSubscriber(this));
        this.f9941f.m14133a(new PhotoClickSubscriber(this));
        this.f9941f.m14133a(new VideoClickSubscriber(this));
        this.f9941f.m14133a(new ShareClickSubscriber(this));
        this.f9941f.m14133a(new ReactionUpdatedEventSubscriber(this));
        this.f9941f.m14133a(new FetchFollowUpUnitSubscriber(this));
    }

    public final void mo1264c() {
        this.f9941f.m14131a(this.f9940e);
        this.f9939d.m15067a();
        AdsOffsiteExperienceSurveyController adsOffsiteExperienceSurveyController = this.f9938c;
        Context context = this.f9942g;
        if (adsOffsiteExperienceSurveyController.f9954f != 0) {
            if (adsOffsiteExperienceSurveyController.f9951c.f10015a) {
                if ((adsOffsiteExperienceSurveyController.f9953e.now() - adsOffsiteExperienceSurveyController.f9954f) / 1000 <= ((long) adsOffsiteExperienceSurveyController.f9951c.f10017c)) {
                    String str = adsOffsiteExperienceSurveyController.f9951c.f10016b;
                    adsOffsiteExperienceSurveyController.f9949a.mo1437b(adsOffsiteExperienceSurveyController.f9950b);
                    adsOffsiteExperienceSurveyController.f9952d.m14997a(str, context);
                }
            }
            adsOffsiteExperienceSurveyController.f9954f = 0;
        }
    }

    public final void mo1265d() {
        this.f9941f.m14134b(this.f9940e);
        this.f9939d.m15068b();
    }

    public static void m14969a(@Nullable FollowUpUnitController followUpUnitController, String str, GraphQLFollowUpFeedUnitActionType graphQLFollowUpFeedUnitActionType) {
        Flattenable a = m14968a(followUpUnitController, str);
        if (a != null) {
            followUpUnitController.f9937b.m14974a(FeedProps.m19802c(a), graphQLFollowUpFeedUnitActionType, f9936a);
        }
    }

    public static GraphQLStory m14968a(FollowUpUnitController followUpUnitController, String str) {
        if (Strings.isNullOrEmpty(str)) {
            return null;
        }
        for (GraphQLFeedUnitEdge c : ((LegacyFeedUnitUpdater) followUpUnitController.f9943h.f10429a).mo1384d(str)) {
            FeedUnit c2 = c.mo2540c();
            if (c2 instanceof GraphQLStory) {
                return (GraphQLStory) c2;
            }
        }
        return null;
    }
}
