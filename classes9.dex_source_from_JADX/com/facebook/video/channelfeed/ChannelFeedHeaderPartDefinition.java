package com.facebook.video.channelfeed;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.header.ProfilePhotoPartDefinition;
import com.facebook.feed.rows.sections.header.StoryHeaderUtil;
import com.facebook.feed.rows.styling.ChannelFeedBackgroundPartDefinition;
import com.facebook.feed.rows.styling.ChannelFeedBackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.graphql.calls.VideoChannelFollowInputData.Surface;
import com.facebook.graphql.calls.VideoChannelUnfollowInputData;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.VisibilityPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: tap_search_result */
public class ChannelFeedHeaderPartDefinition<E extends HasContext & HasFeedListType & HasMenuButtonProvider & HasPositionInformation & HasPrefetcher & HasRowKey & HasPersistentState & HasSinglePublisherChannelInfo> extends MultiRowSinglePartDefinition<Props, Void, E, View> {
    public static final ViewType<View> f2287a = ViewType.a(2130903537);
    private static ChannelFeedHeaderPartDefinition f2288i;
    private static final Object f2289j = new Object();
    private final ProfilePhotoPartDefinition<E> f2290b;
    private final ChannelFeedHeaderTitlePartDefinition<E> f2291c;
    private final ChannelFeedHeaderSubtitleWithLayoutPartDefinition<E> f2292d;
    private final VideoChannelSubscribeButtonPartDefinition<E> f2293e;
    private final VisibilityPartDefinition f2294f;
    private final ChannelFeedBackgroundPartDefinition f2295g;
    private final StoryHeaderUtil f2296h;

    /* compiled from: tap_search_result */
    public class Props {
        public final FeedProps<GraphQLStory> f2285a;
        public final boolean f2286b;

        public Props(FeedProps<GraphQLStory> feedProps, boolean z) {
            this.f2285a = feedProps;
            this.f2286b = z;
        }
    }

    private static ChannelFeedHeaderPartDefinition m2270b(InjectorLike injectorLike) {
        return new ChannelFeedHeaderPartDefinition(ProfilePhotoPartDefinition.a(injectorLike), ChannelFeedHeaderTitlePartDefinition.m2287a(injectorLike), ChannelFeedHeaderSubtitleWithLayoutPartDefinition.m2274a(injectorLike), VideoChannelSubscribeButtonPartDefinition.m2577a(injectorLike), VisibilityPartDefinition.a(injectorLike), ChannelFeedBackgroundPartDefinition.a(injectorLike), StoryHeaderUtil.a(injectorLike));
    }

    public final Object m2272a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        HasContext hasContext = (HasContext) anyEnvironment;
        Object obj2 = 1;
        int c = this.f2296h.c(props.f2285a);
        subParts.a(2131562764, this.f2290b, new com.facebook.feed.rows.sections.header.ProfilePhotoPartDefinition.Props(props.f2285a, this.f2296h.b(props.f2285a), c));
        subParts.a(2131562765, this.f2291c, new com.facebook.video.channelfeed.ChannelFeedHeaderTitlePartDefinition.Props(props.f2285a, props.f2286b));
        subParts.a(2131562766, this.f2292d, new com.facebook.video.channelfeed.ChannelFeedHeaderSubtitleWithLayoutPartDefinition.Props(props.f2285a, -1));
        subParts.a(this.f2295g, new StylingData(props.f2285a, PaddingStyle.i));
        GraphQLStory graphQLStory = (GraphQLStory) props.f2285a.a;
        if (!(StoryAttachmentHelper.o(graphQLStory) == null || StoryAttachmentHelper.r(graphQLStory) == null)) {
            boolean z;
            VideoChannelSubscribeButtonPartDefinition videoChannelSubscribeButtonPartDefinition = this.f2293e;
            FeedProps a = AttachmentProps.a(graphQLStory);
            Surface surface = Surface.RECOMMENDED_VIDEO_CHANNEL;
            VideoChannelUnfollowInputData.Surface surface2 = VideoChannelUnfollowInputData.Surface.RECOMMENDED_VIDEO_CHANNEL;
            if (((ChannelFeedEnvironment) hasContext).f2140t) {
                z = false;
            } else {
                z = true;
            }
            subParts.a(2131560277, videoChannelSubscribeButtonPartDefinition, new com.facebook.video.channelfeed.VideoChannelSubscribeButtonPartDefinition.Props(a, surface, surface2, z));
            obj2 = null;
        }
        if (obj2 != null) {
            subParts.a(2131560277, this.f2294f, Integer.valueOf(8));
        }
        return null;
    }

    public static ChannelFeedHeaderPartDefinition m2269a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ChannelFeedHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f2289j) {
                ChannelFeedHeaderPartDefinition channelFeedHeaderPartDefinition;
                if (a2 != null) {
                    channelFeedHeaderPartDefinition = (ChannelFeedHeaderPartDefinition) a2.a(f2289j);
                } else {
                    channelFeedHeaderPartDefinition = f2288i;
                }
                if (channelFeedHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2270b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f2289j, b3);
                        } else {
                            f2288i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = channelFeedHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public ChannelFeedHeaderPartDefinition(ProfilePhotoPartDefinition profilePhotoPartDefinition, ChannelFeedHeaderTitlePartDefinition channelFeedHeaderTitlePartDefinition, ChannelFeedHeaderSubtitleWithLayoutPartDefinition channelFeedHeaderSubtitleWithLayoutPartDefinition, VideoChannelSubscribeButtonPartDefinition videoChannelSubscribeButtonPartDefinition, VisibilityPartDefinition visibilityPartDefinition, ChannelFeedBackgroundPartDefinition channelFeedBackgroundPartDefinition, StoryHeaderUtil storyHeaderUtil) {
        this.f2291c = channelFeedHeaderTitlePartDefinition;
        this.f2292d = channelFeedHeaderSubtitleWithLayoutPartDefinition;
        this.f2290b = profilePhotoPartDefinition;
        this.f2293e = videoChannelSubscribeButtonPartDefinition;
        this.f2294f = visibilityPartDefinition;
        this.f2295g = channelFeedBackgroundPartDefinition;
        this.f2296h = storyHeaderUtil;
    }

    public final ViewType m2271a() {
        return f2287a;
    }

    public final boolean m2273a(Object obj) {
        return true;
    }
}
