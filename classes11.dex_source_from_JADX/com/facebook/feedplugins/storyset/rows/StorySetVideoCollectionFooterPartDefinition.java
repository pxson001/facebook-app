package com.facebook.feedplugins.storyset.rows;

import android.content.Context;
import com.facebook.attachments.videos.ui.BaseChannelFeedLauncherInfo;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.autoplay.AutoplayStateManager;
import com.facebook.feed.autoplay.AutoplayStateManagerProvider;
import com.facebook.feed.autoplay.VideoStoryPersistentState;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.attachments.video.FullscreenTransitionListener;
import com.facebook.feedplugins.attachments.video.InlineVideoStoryKey;
import com.facebook.feedplugins.base.footer.OneButtonFooterStylerPartDefinition;
import com.facebook.feedplugins.base.footer.ui.OneButtonFooterView;
import com.facebook.feedplugins.storyset.rows.VideoSetsChannelFeedLauncherPartDefinition.Props;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStorySet;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.graphql.model.StorySetHelper;
import com.facebook.graphql.model.conversion.GraphQLMediaConversionHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ResourceIdTextPartDefinition;
import com.facebook.video.engine.ExitFullScreenResult;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Inject;

@ContextScoped
/* compiled from: audience_educator_manager_activity_launch */
public class StorySetVideoCollectionFooterPartDefinition extends MultiRowSinglePartDefinition<FeedProps<GraphQLStorySet>, Void, HasPersistentState, OneButtonFooterView> {
    private static StorySetVideoCollectionFooterPartDefinition f9778e;
    private static final Object f9779f = new Object();
    private final ResourceIdTextPartDefinition f9780a;
    private final OneButtonFooterStylerPartDefinition f9781b;
    private final VideoSetsChannelFeedLauncherPartDefinition f9782c;
    private final AutoplayStateManagerProvider f9783d;

    private static StorySetVideoCollectionFooterPartDefinition m10211b(InjectorLike injectorLike) {
        return new StorySetVideoCollectionFooterPartDefinition(ResourceIdTextPartDefinition.a(injectorLike), OneButtonFooterStylerPartDefinition.a(injectorLike), VideoSetsChannelFeedLauncherPartDefinition.m10224a(injectorLike), (AutoplayStateManagerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(AutoplayStateManagerProvider.class));
    }

    public final Object m10213a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        HasPersistentState hasPersistentState = (HasPersistentState) anyEnvironment;
        subParts.a(this.f9781b, null);
        subParts.a(2131559974, this.f9780a, Integer.valueOf(2131235566));
        final VideoStoryPersistentState a = m10209a(feedProps, hasPersistentState);
        subParts.a(this.f9782c, new Props(new StorySetPageProps(feedProps, ((GraphQLStorySet) feedProps.a).ac_(), 0, false), new AtomicReference(new FullscreenTransitionListener(this) {
            final /* synthetic */ StorySetVideoCollectionFooterPartDefinition f9776b;

            public final void m10208a(ExitFullScreenResult exitFullScreenResult) {
                AutoplayStateManager b = a.b();
                if (b != null) {
                    b.a(exitFullScreenResult.b, exitFullScreenResult.a);
                }
            }
        }), 2, new BaseChannelFeedLauncherInfo(this, a) {
            final /* synthetic */ StorySetVideoCollectionFooterPartDefinition f9777a;

            public int getSeekPosition() {
                return 0;
            }
        }));
        return null;
    }

    public final boolean m10214a(Object obj) {
        return StorySetHelper.d((GraphQLStorySet) ((FeedProps) obj).a);
    }

    @Inject
    public StorySetVideoCollectionFooterPartDefinition(ResourceIdTextPartDefinition resourceIdTextPartDefinition, OneButtonFooterStylerPartDefinition oneButtonFooterStylerPartDefinition, VideoSetsChannelFeedLauncherPartDefinition videoSetsChannelFeedLauncherPartDefinition, AutoplayStateManagerProvider autoplayStateManagerProvider) {
        this.f9780a = resourceIdTextPartDefinition;
        this.f9781b = oneButtonFooterStylerPartDefinition;
        this.f9782c = videoSetsChannelFeedLauncherPartDefinition;
        this.f9783d = autoplayStateManagerProvider;
    }

    public static StorySetVideoCollectionFooterPartDefinition m10210a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            StorySetVideoCollectionFooterPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9779f) {
                StorySetVideoCollectionFooterPartDefinition storySetVideoCollectionFooterPartDefinition;
                if (a2 != null) {
                    storySetVideoCollectionFooterPartDefinition = (StorySetVideoCollectionFooterPartDefinition) a2.a(f9779f);
                } else {
                    storySetVideoCollectionFooterPartDefinition = f9778e;
                }
                if (storySetVideoCollectionFooterPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10211b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9779f, b3);
                        } else {
                            f9778e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = storySetVideoCollectionFooterPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType<OneButtonFooterView> m10212a() {
        return OneButtonFooterView.a;
    }

    private VideoStoryPersistentState m10209a(FeedProps<GraphQLStorySet> feedProps, HasPersistentState hasPersistentState) {
        GraphQLStory graphQLStory = (GraphQLStory) StorySetHelper.b((GraphQLStorySet) feedProps.a).get(0);
        return (VideoStoryPersistentState) hasPersistentState.a(new InlineVideoStoryKey(feedProps.a(graphQLStory), GraphQLMediaConversionHelper.b(StoryAttachmentHelper.o(graphQLStory).r()), this.f9783d), graphQLStory);
    }
}
