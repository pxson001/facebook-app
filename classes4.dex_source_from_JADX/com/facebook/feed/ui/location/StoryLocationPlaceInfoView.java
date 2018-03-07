package com.facebook.feed.ui.location;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import com.facebook.analytics.CurationMechanism;
import com.facebook.analytics.CurationSurface;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.analytics.view.tracking.TrackingNodes;
import com.facebook.analytics.view.tracking.TrackingNodes.TrackingNode;
import com.facebook.api.feedcache.memory.optimisticstory.OptimisticStoryStateCache;
import com.facebook.attachments.angora.actionbutton.SaveButtonUtils;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.composer.publish.cache.pendingstory.PendingStoryStore;
import com.facebook.composer.publish.common.PendingStory;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.crowdsourcing.logging.CrowdEntryPoint;
import com.facebook.crowdsourcing.logging.SuggestEditsAnalyticsLogger;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.feed.nux.FeedNuxBubbleManager;
import com.facebook.feed.renderer.DefaultFeedUnitRenderer;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.core.props.TrackableFeedProps;
import com.facebook.graphql.enums.GraphQLFeedOptimisticPublishState;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.model.GraphQLPlace;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.graphql.model.StoryActionLinkHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.Lazy;
import com.facebook.ipc.composer.model.ComposerSourceType;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.linkify.LinkifyTargetBuilder;
import com.facebook.linkify.LinkifyTargetGraphQLInterfaces.LinkifyTargetGraphQL;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.nux.NuxBubbleManager$Nux;
import com.facebook.nux.interstitial.SaveNuxBubbleDelegate;
import com.facebook.reviews.util.intent.ReviewComposerLauncherAndHandler;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.base.Optional;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: progress_stage */
public class StoryLocationPlaceInfoView extends CustomLinearLayout {
    private ImageView f13604a;
    private View f13605b;
    private FbDraweeView f13606c;
    private View f13607d;
    private View f13608e;
    public FeedProps<GraphQLStory> f13609f;
    public GraphQLPlace f13610g;
    private DefaultFeedUnitRenderer f13611h;
    private FeedNuxBubbleManager f13612i;
    private Provider<SaveNuxBubbleDelegate> f13613j;
    private SaveButtonUtils f13614k;
    public AbstractFbErrorReporter f13615l;
    private PendingStoryStore f13616m;
    public UriIntentMapper f13617n;
    public SecureContextHelper f13618o;
    private OptimisticStoryStateCache f13619p;
    private SuggestEditsAnalyticsLogger f13620q;
    private Lazy<ReviewComposerLauncherAndHandler> f13621r;
    private Resources f13622s;

    /* compiled from: progress_stage */
    class C01932 implements OnClickListener {
        final /* synthetic */ StoryLocationPlaceInfoView f4092a;

        C01932(StoryLocationPlaceInfoView storyLocationPlaceInfoView) {
            this.f4092a = storyLocationPlaceInfoView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 2035800782);
            this.f4092a.m14434a(this.f4092a.f13609f, this.f4092a.f13610g);
            Logger.a(2, EntryType.UI_INPUT_END, 1411749730, a);
        }
    }

    private static <T extends View> void m14438a(Class<T> cls, T t) {
        m14439a((Object) t, t.getContext());
    }

    private static void m14439a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((StoryLocationPlaceInfoView) obj).m14433a(DefaultFeedUnitRenderer.a(fbInjector), (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector), SaveButtonUtils.a(fbInjector), FeedNuxBubbleManager.a(fbInjector), IdBasedProvider.a(fbInjector, 2848), PendingStoryStore.a(fbInjector), (UriIntentMapper) Fb4aUriIntentMapper.a(fbInjector), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), OptimisticStoryStateCache.a(fbInjector), SuggestEditsAnalyticsLogger.a(fbInjector), IdBasedLazy.a(fbInjector, 10287));
    }

    public StoryLocationPlaceInfoView(Context context) {
        super(context);
        m14430a();
    }

    public StoryLocationPlaceInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m14430a();
    }

    private void m14430a() {
        setContentView(2130904344);
        this.f13605b = a(2131562022);
        this.f13604a = (ImageView) a(2131562023);
        this.f13606c = (FbDraweeView) a(2131562016);
        this.f13607d = a(2131562015);
        m14438a(StoryLocationPlaceInfoView.class, (View) this);
        this.f13622s = getResources();
        setOrientation(0);
        TrackingNodes.a(this.f13605b, TrackingNode.SAVE_ACTION);
        TrackingNodes.a(this.f13608e, TrackingNode.PLACE_WRITE_REVIEW_ACTION);
        TrackingNodes.a(this.f13606c, TrackingNode.ACTOR_PHOTO);
        TrackingNodes.a(this.f13607d, TrackingNode.STORY_LOCATION);
    }

    @Inject
    private void m14433a(DefaultFeedUnitRenderer defaultFeedUnitRenderer, FbErrorReporter fbErrorReporter, SaveButtonUtils saveButtonUtils, FeedNuxBubbleManager feedNuxBubbleManager, Provider<SaveNuxBubbleDelegate> provider, PendingStoryStore pendingStoryStore, UriIntentMapper uriIntentMapper, SecureContextHelper secureContextHelper, OptimisticStoryStateCache optimisticStoryStateCache, SuggestEditsAnalyticsLogger suggestEditsAnalyticsLogger, Lazy<ReviewComposerLauncherAndHandler> lazy) {
        this.f13611h = defaultFeedUnitRenderer;
        this.f13615l = fbErrorReporter;
        this.f13614k = saveButtonUtils;
        this.f13612i = feedNuxBubbleManager;
        this.f13613j = provider;
        this.f13616m = pendingStoryStore;
        this.f13617n = uriIntentMapper;
        this.f13618o = secureContextHelper;
        this.f13619p = optimisticStoryStateCache;
        this.f13620q = suggestEditsAnalyticsLogger;
        this.f13621r = lazy;
    }

    public final void m14450a(FeedProps<GraphQLStory> feedProps, GraphQLPlace graphQLPlace, @Nullable HoneyClientEvent honeyClientEvent) {
        this.f13609f = feedProps;
        this.f13610g = graphQLPlace;
        LinkifyTargetGraphQL a = LinkifyTargetBuilder.a(graphQLPlace);
        GraphQLStory graphQLStory = (GraphQLStory) this.f13609f.a;
        String arrayNode = TrackableFeedProps.a(this.f13609f).toString();
        this.f13607d.setOnClickListener(this.f13611h.a(this.f13607d, a, honeyClientEvent, null, "tap_story_attachment", arrayNode));
        this.f13606c.setOnClickListener(this.f13611h.a(this.f13606c, a, honeyClientEvent, null, "tap_story_attachment", arrayNode));
        if (m14441a(graphQLPlace, (GraphQLStory) this.f13609f.a)) {
            m14437a(graphQLPlace);
        }
        GraphQLStoryActionLink a2 = StoryActionLinkHelper.a(graphQLStory, 1994746535);
        if (a2 != null) {
            m14432a(a2.aT(), graphQLStory, graphQLPlace);
        } else if (!m14442a(graphQLStory, graphQLPlace)) {
            this.f13605b.setVisibility(8);
            if (this.f13608e != null) {
                this.f13608e.setVisibility(8);
            }
        }
    }

    private static boolean m14441a(GraphQLPlace graphQLPlace, GraphQLStory graphQLStory) {
        return graphQLPlace.O() && !graphQLPlace.y() && graphQLStory.P();
    }

    private void m14437a(GraphQLPlace graphQLPlace) {
        this.f13606c.setOnClickListener(new 1(this, graphQLPlace));
        SuggestEditsAnalyticsLogger suggestEditsAnalyticsLogger = this.f13620q;
        CrowdEntryPoint crowdEntryPoint = CrowdEntryPoint.ADD_INFO_BUTTON;
        suggestEditsAnalyticsLogger.a(CrowdEntryPoint.FEED_ADD_PHOTO_BUTTON, Optional.of(String.valueOf(graphQLPlace.x())));
    }

    private void m14444b(GraphQLPlace graphQLPlace) {
        GraphQLStory graphQLStory = (GraphQLStory) this.f13609f.a;
        Optional d = this.f13616m.d(graphQLStory.T());
        GraphQLFeedOptimisticPublishState a = this.f13619p.a(graphQLStory);
        if (a == GraphQLFeedOptimisticPublishState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) {
            m14448d(graphQLPlace);
        } else if (a != GraphQLFeedOptimisticPublishState.SUCCESS || (d.isPresent() && ((PendingStory) d.get()).f())) {
            this.f13612i.a(this.f13604a);
        } else {
            m14448d(graphQLPlace);
        }
    }

    private boolean m14442a(GraphQLStory graphQLStory, GraphQLPlace graphQLPlace) {
        if (!SaveButtonUtils.a(graphQLStory, graphQLPlace)) {
            return false;
        }
        m14446c(graphQLPlace);
        return true;
    }

    private void m14446c(GraphQLPlace graphQLPlace) {
        boolean z = false;
        this.f13605b.setVisibility(0);
        if (this.f13608e != null) {
            this.f13608e.setVisibility(8);
        }
        this.f13605b.setOnClickListener(new C01932(this));
        if (this.f13610g.Z() == GraphQLSavedState.SAVED) {
            z = true;
        }
        m14440a(z);
        m14444b(graphQLPlace);
    }

    private void m14432a(int i, GraphQLStory graphQLStory, GraphQLPlace graphQLPlace) {
        try {
            Long.parseLong(graphQLPlace.x());
            if (this.f13608e == null) {
                this.f13608e = ((ViewStub) a(2131562024)).inflate();
            }
            this.f13608e.setVisibility(0);
            this.f13605b.setVisibility(8);
            this.f13608e.setOnClickListener(new 3(this, i, graphQLPlace));
        } catch (NumberFormatException e) {
            this.f13615l.a(getClass().getSimpleName(), "Trying to display review button with invalid page id. Page id: " + graphQLPlace.x());
            m14442a(graphQLStory, graphQLPlace);
        }
    }

    private void m14431a(int i, GraphQLPlace graphQLPlace) {
        int i2 = i;
        ((ReviewComposerLauncherAndHandler) this.f13621r.get()).a(1759, (Activity) getContext(), ComposerSourceType.CHECKIN_STORY, CurationSurface.NATIVE_STORY, CurationMechanism.REVIEW_BUTTON, i2, Long.parseLong(graphQLPlace.x()), graphQLPlace.B(), null, null, null);
    }

    private void m14448d(GraphQLPlace graphQLPlace) {
        if (graphQLPlace != null && graphQLPlace.S() != null) {
            SaveNuxBubbleDelegate saveNuxBubbleDelegate = (SaveNuxBubbleDelegate) this.f13613j.get();
            saveNuxBubbleDelegate.f4094b = new SaveNuxPlaceInfo(graphQLPlace);
            this.f13612i.a(new NuxBubbleManager$Nux(2130904333, graphQLPlace.S().n(), this.f13604a, saveNuxBubbleDelegate, true, 35));
        }
    }

    private void m14440a(boolean z) {
        this.f13605b.setVisibility(0);
        if (z) {
            this.f13604a.setImageResource(2130843225);
            this.f13605b.setContentDescription(this.f13622s.getString(2131233593));
            return;
        }
        this.f13604a.setImageResource(2130843224);
        this.f13605b.setContentDescription(this.f13622s.getString(2131233592));
    }

    private void m14434a(FeedProps<GraphQLStory> feedProps, GraphQLPlace graphQLPlace) {
        boolean z = true;
        if (graphQLPlace != null && graphQLPlace.Z() != null) {
            boolean z2 = graphQLPlace.Z() == GraphQLSavedState.SAVED;
            if (z2) {
                this.f13614k.a();
                this.f13614k.b(feedProps, CurationMechanism.TOGGLE_BUTTON, CurationSurface.NATIVE_STORY);
            } else {
                this.f13614k.a(getContext());
                this.f13614k.a(feedProps, CurationMechanism.TOGGLE_BUTTON, CurationSurface.NATIVE_STORY);
                this.f13614k.a(this.f13605b);
            }
            this.f13612i.a();
            if (z2) {
                z = false;
            }
            m14440a(z);
        }
    }
}
