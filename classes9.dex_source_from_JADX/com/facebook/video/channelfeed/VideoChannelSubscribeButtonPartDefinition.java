package com.facebook.video.channelfeed;

import android.content.Context;
import android.view.View;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.calls.VideoChannelFollowInputData.Surface;
import com.facebook.graphql.calls.VideoChannelSubscribeInputData;
import com.facebook.graphql.calls.VideoChannelUnfollowInputData;
import com.facebook.graphql.calls.VideoChannelUnsubscribeInputData;
import com.facebook.graphql.model.GraphQLActor;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.nux.NuxBubbleManager.Nux;
import com.facebook.nux.interstitial.FollowVideosNuxBubbleDelegate;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.video.followvideos.VideoHomeFollowVideosButton;
import com.facebook.video.followvideos.VideoHomeFollowVideosButton.SubscribeStateChangedListener;
import com.facebook.video.followvideos.nux.FollowVideosNuxBubbleController;
import com.facebook.video.followvideos.qe.ExperimentsForFollowVideosQeModule;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.annotation.concurrent.Immutable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: submit_type */
public class VideoChannelSubscribeButtonPartDefinition<E extends HasPersistentState & HasContext> extends BaseSinglePartDefinition<Props, State, E, VideoHomeFollowVideosButton> {
    private static VideoChannelSubscribeButtonPartDefinition f2676d;
    private static final Object f2677e = new Object();
    private final QeAccessor f2678a;
    private final FollowVideosNuxBubbleDelegate f2679b;
    private final FollowVideosNuxBubbleController f2680c;

    @Immutable
    /* compiled from: submit_type */
    public final class Props {
        FeedProps<GraphQLStoryAttachment> f2669a;
        GraphQLStoryAttachment f2670b;
        Surface f2671c;
        VideoChannelUnfollowInputData.Surface f2672d;
        boolean f2673e;

        public Props(FeedProps<GraphQLStoryAttachment> feedProps, Surface surface, VideoChannelUnfollowInputData.Surface surface2, boolean z) {
            this.f2669a = feedProps;
            this.f2670b = (GraphQLStoryAttachment) feedProps.a;
            this.f2671c = surface;
            this.f2672d = surface2;
            this.f2673e = z;
        }
    }

    /* compiled from: submit_type */
    public final class State {
        public final VideoChannelPersistentState f2674a;
        public final String f2675b;

        public State(VideoChannelPersistentState videoChannelPersistentState, String str) {
            this.f2674a = videoChannelPersistentState;
            this.f2675b = str;
        }
    }

    private static VideoChannelSubscribeButtonPartDefinition m2579b(InjectorLike injectorLike) {
        return new VideoChannelSubscribeButtonPartDefinition((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), new FollowVideosNuxBubbleDelegate((ObjectMapper) FbObjectMapperMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), InterstitialManager.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike)), FollowVideosNuxBubbleController.m2632a(injectorLike));
    }

    public final Object m2580a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        HasPersistentState hasPersistentState = (HasPersistentState) anyEnvironment;
        final VideoChannelPersistentState videoChannelPersistentState = (VideoChannelPersistentState) hasPersistentState.a(new VideoChannelKey(StoryAttachmentHelper.a(props.f2670b).H()), AttachmentProps.c(props.f2669a));
        videoChannelPersistentState.f2665a = new SubscribeStateChangedListener(this) {
            final /* synthetic */ VideoChannelSubscribeButtonPartDefinition f2668b;

            public final void m2576a(boolean z) {
                videoChannelPersistentState.f2666b = true;
            }
        };
        return new State(videoChannelPersistentState, this.f2678a.a(ExperimentsForFollowVideosQeModule.b, ((HasContext) hasPersistentState).getContext().getResources().getString(2131235673)));
    }

    public final /* bridge */ /* synthetic */ void m2581a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1457172877);
        m2578a((Props) obj, (State) obj2, (VideoHomeFollowVideosButton) view);
        Logger.a(8, EntryType.MARK_POP, -1873315561, a);
    }

    public static VideoChannelSubscribeButtonPartDefinition m2577a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            VideoChannelSubscribeButtonPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f2677e) {
                VideoChannelSubscribeButtonPartDefinition videoChannelSubscribeButtonPartDefinition;
                if (a2 != null) {
                    videoChannelSubscribeButtonPartDefinition = (VideoChannelSubscribeButtonPartDefinition) a2.a(f2677e);
                } else {
                    videoChannelSubscribeButtonPartDefinition = f2676d;
                }
                if (videoChannelSubscribeButtonPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2579b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f2677e, b3);
                        } else {
                            f2676d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = videoChannelSubscribeButtonPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public VideoChannelSubscribeButtonPartDefinition(QeAccessor qeAccessor, FollowVideosNuxBubbleDelegate followVideosNuxBubbleDelegate, FollowVideosNuxBubbleController followVideosNuxBubbleController) {
        this.f2679b = followVideosNuxBubbleDelegate;
        this.f2680c = followVideosNuxBubbleController;
        this.f2678a = qeAccessor;
    }

    private void m2578a(Props props, State state, VideoHomeFollowVideosButton videoHomeFollowVideosButton) {
        int i;
        GraphQLMedia r = props.f2670b.r();
        GraphQLActor aF = r.aF();
        boolean aB = aF.aB();
        if (!props.f2673e) {
            i = 0;
        } else if (state.f2674a.f2666b) {
            r0 = true;
        } else if (!aF.ay() || aB) {
            i = 0;
        } else {
            r0 = true;
        }
        if (i != 0) {
            videoHomeFollowVideosButton.a(aB, aF.H(), props.f2671c, props.f2672d);
            videoHomeFollowVideosButton.g = state.f2674a.f2665a;
            if (aF.aJ() && !aF.aI() && r.bs()) {
                videoHomeFollowVideosButton.a(aF.aI(), aF.aa(), VideoChannelSubscribeInputData.Surface.UNKNOWN, VideoChannelUnsubscribeInputData.Surface.UNKNOWN);
            }
            FollowVideosNuxBubbleController followVideosNuxBubbleController = this.f2680c;
            followVideosNuxBubbleController.f2743b.a(new Nux(2130907676, state.f2675b, videoHomeFollowVideosButton, this.f2679b, true, 0));
            videoHomeFollowVideosButton.setVisibility(0);
            return;
        }
        videoHomeFollowVideosButton.setVisibility(8);
    }
}
