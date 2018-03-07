package com.facebook.video.channelfeed;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.autoplay.HasVideoAutoplay;
import com.facebook.feed.environment.CanFeedback;
import com.facebook.feed.environment.CanShowVideoInFullScreen;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.hidden.HiddenUnitGroupPartDefinition;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.HideableUnit;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: sync_change_type */
public class ChannelFeedRootPartDefinition<E extends HasContext & HasFeedListType & HasFullscreenPlayer & HasInvalidate & HasMenuButtonProvider & HasPersistentState & HasPlayerOrigin & HasPositionInformation & HasPrefetcher & HasRowKey & HasVideoAutoplay<ChannelFeedVideoAttachmentView> & CanFeedback & CanReusePlayer & CanShowVideoInFullScreen & HasSinglePublisherChannelInfo> extends BaseMultiRowGroupPartDefinition<FeedProps<? extends FeedUnit>, Void, E> {
    private static ChannelFeedRootPartDefinition f2399f;
    private static final Object f2400g = new Object();
    private final ChannelFeedGroupPartDefinition<E> f2401a;
    private final HiddenUnitGroupPartDefinition f2402b;
    private final ChannelFeedVideoSectionHeaderPartDefinition f2403c;
    private final ChannelFeedVideoSectionSeeMorePartDefinition f2404d;
    private final MultiShareChannelFeedPartDefinition f2405e;

    private static ChannelFeedRootPartDefinition m2349b(InjectorLike injectorLike) {
        return new ChannelFeedRootPartDefinition(ChannelFeedGroupPartDefinition.m2247a(injectorLike), HiddenUnitGroupPartDefinition.a(injectorLike), ChannelFeedVideoSectionHeaderPartDefinition.m2500a(injectorLike), ChannelFeedVideoSectionSeeMorePartDefinition.m2509a(injectorLike), MultiShareChannelFeedPartDefinition.m2535a(injectorLike));
    }

    public final Object m2350a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        FeedUnit feedUnit = (FeedUnit) feedProps.a;
        if ((feedUnit instanceof GraphQLStory) && (feedUnit instanceof HideableUnit) && !HiddenUnitGroupPartDefinition.a(feedProps)) {
            baseMultiRowSubParts.a(this.f2401a, feedProps);
        } else if (feedUnit instanceof MultiShareChannelStoryUnit) {
            baseMultiRowSubParts.a(this.f2405e, feedProps);
        } else {
            if (feedUnit instanceof HideableUnit) {
                baseMultiRowSubParts.a(this.f2402b, feedProps);
            }
            if (feedUnit instanceof ChannelFeedVideoSectionHeader) {
                baseMultiRowSubParts.a(this.f2403c, FeedProps.c((ChannelFeedVideoSectionHeader) feedUnit));
            }
            if (feedUnit instanceof ChannelFeedVideoSectionSeeMore) {
                baseMultiRowSubParts.a(this.f2404d, FeedProps.c((ChannelFeedVideoSectionSeeMore) feedUnit));
            }
        }
        return null;
    }

    @Inject
    public ChannelFeedRootPartDefinition(ChannelFeedGroupPartDefinition channelFeedGroupPartDefinition, HiddenUnitGroupPartDefinition hiddenUnitGroupPartDefinition, ChannelFeedVideoSectionHeaderPartDefinition channelFeedVideoSectionHeaderPartDefinition, ChannelFeedVideoSectionSeeMorePartDefinition channelFeedVideoSectionSeeMorePartDefinition, MultiShareChannelFeedPartDefinition multiShareChannelFeedPartDefinition) {
        this.f2401a = channelFeedGroupPartDefinition;
        this.f2402b = hiddenUnitGroupPartDefinition;
        this.f2403c = channelFeedVideoSectionHeaderPartDefinition;
        this.f2404d = channelFeedVideoSectionSeeMorePartDefinition;
        this.f2405e = multiShareChannelFeedPartDefinition;
    }

    public static ChannelFeedRootPartDefinition m2348a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ChannelFeedRootPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f2400g) {
                ChannelFeedRootPartDefinition channelFeedRootPartDefinition;
                if (a2 != null) {
                    channelFeedRootPartDefinition = (ChannelFeedRootPartDefinition) a2.a(f2400g);
                } else {
                    channelFeedRootPartDefinition = f2399f;
                }
                if (channelFeedRootPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2349b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f2400g, b3);
                        } else {
                            f2399f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = channelFeedRootPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final boolean m2351a(Object obj) {
        return true;
    }
}
