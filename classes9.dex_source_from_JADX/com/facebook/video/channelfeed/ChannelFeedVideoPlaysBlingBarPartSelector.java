package com.facebook.video.channelfeed;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.CanFeedback;
import com.facebook.feed.environment.CanShowVideoInFullScreen;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryAttachmentHelper;
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
/* compiled from: supportMmsContentDisposition */
public class ChannelFeedVideoPlaysBlingBarPartSelector<E extends CanFeedback & CanShowVideoInFullScreen & HasPersistentState & HasPositionInformation> extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, E> {
    private static ChannelFeedVideoPlaysBlingBarPartSelector f2542c;
    private static final Object f2543d = new Object();
    private final ChannelFeedVideoPlaysBlingBarPartDefinition<E> f2544a;
    private final ChannelFeedVideoPlaysPillsBlingBarPartDefinition<E> f2545b;

    private static ChannelFeedVideoPlaysBlingBarPartSelector m2477b(InjectorLike injectorLike) {
        return new ChannelFeedVideoPlaysBlingBarPartSelector(ChannelFeedVideoPlaysBlingBarPartDefinition.m2469a(injectorLike), ChannelFeedVideoPlaysPillsBlingBarPartDefinition.m2481a(injectorLike));
    }

    public final Object m2478a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        SubPartsSelector.a(baseMultiRowSubParts, this.f2545b, feedProps).a(this.f2544a, feedProps);
        return null;
    }

    public final boolean m2479a(Object obj) {
        return StoryAttachmentHelper.j((GraphQLStory) ((FeedProps) obj).a);
    }

    @Inject
    public ChannelFeedVideoPlaysBlingBarPartSelector(ChannelFeedVideoPlaysBlingBarPartDefinition channelFeedVideoPlaysBlingBarPartDefinition, ChannelFeedVideoPlaysPillsBlingBarPartDefinition channelFeedVideoPlaysPillsBlingBarPartDefinition) {
        this.f2544a = channelFeedVideoPlaysBlingBarPartDefinition;
        this.f2545b = channelFeedVideoPlaysPillsBlingBarPartDefinition;
    }

    public static ChannelFeedVideoPlaysBlingBarPartSelector m2476a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ChannelFeedVideoPlaysBlingBarPartSelector b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f2543d) {
                ChannelFeedVideoPlaysBlingBarPartSelector channelFeedVideoPlaysBlingBarPartSelector;
                if (a2 != null) {
                    channelFeedVideoPlaysBlingBarPartSelector = (ChannelFeedVideoPlaysBlingBarPartSelector) a2.a(f2543d);
                } else {
                    channelFeedVideoPlaysBlingBarPartSelector = f2542c;
                }
                if (channelFeedVideoPlaysBlingBarPartSelector == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2477b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f2543d, b3);
                        } else {
                            f2542c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = channelFeedVideoPlaysBlingBarPartSelector;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
