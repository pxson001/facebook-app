package com.facebook.video.channelfeed;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.CanShowVideoInFullScreen;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.ChannelFeedBackgroundPartDefinition;
import com.facebook.feed.rows.styling.ChannelFeedBackgroundPartDefinition.StylingData;
import com.facebook.feedback.reactions.abtest.ReactionsExperimentUtil;
import com.facebook.feedback.reactions.ui.PillsBlingBarView;
import com.facebook.feedplugins.base.blingbar.BlingBarRootPartDefinition;
import com.facebook.feedplugins.pillsblingbar.ui.PillsBlingBarWithoutBackgroundPartDefinition;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import javax.inject.Inject;

@ContextScoped
/* compiled from: suggestionName */
public class ChannelFeedVideoPlaysPillsBlingBarPartDefinition<E extends CanShowVideoInFullScreen & HasPositionInformation & HasPersistentState> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, PillsBlingBarView> {
    private static ChannelFeedVideoPlaysPillsBlingBarPartDefinition f2548d;
    private static final Object f2549e = new Object();
    private final PillsBlingBarWithoutBackgroundPartDefinition<E> f2550a;
    private final ChannelFeedBackgroundPartDefinition f2551b;
    private final ReactionsExperimentUtil f2552c;

    private static ChannelFeedVideoPlaysPillsBlingBarPartDefinition m2482b(InjectorLike injectorLike) {
        return new ChannelFeedVideoPlaysPillsBlingBarPartDefinition(PillsBlingBarWithoutBackgroundPartDefinition.b(injectorLike), ChannelFeedBackgroundPartDefinition.a(injectorLike), ReactionsExperimentUtil.a(injectorLike));
    }

    public final Object m2484a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        subParts.a(this.f2550a, feedProps);
        subParts.a(this.f2551b, new StylingData(feedProps, BlingBarRootPartDefinition.a));
        return null;
    }

    public final /* bridge */ /* synthetic */ void m2485a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 579827944);
        ((PillsBlingBarView) view).q = true;
        Logger.a(8, EntryType.MARK_POP, 105327243, a);
    }

    public final boolean m2486a(Object obj) {
        return StoryAttachmentHelper.j((GraphQLStory) ((FeedProps) obj).a) && this.f2552c.i();
    }

    @Inject
    public ChannelFeedVideoPlaysPillsBlingBarPartDefinition(PillsBlingBarWithoutBackgroundPartDefinition pillsBlingBarWithoutBackgroundPartDefinition, ChannelFeedBackgroundPartDefinition channelFeedBackgroundPartDefinition, ReactionsExperimentUtil reactionsExperimentUtil) {
        this.f2550a = pillsBlingBarWithoutBackgroundPartDefinition;
        this.f2551b = channelFeedBackgroundPartDefinition;
        this.f2552c = reactionsExperimentUtil;
    }

    public final ViewType m2483a() {
        return PillsBlingBarView.a;
    }

    public static ChannelFeedVideoPlaysPillsBlingBarPartDefinition m2481a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ChannelFeedVideoPlaysPillsBlingBarPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f2549e) {
                ChannelFeedVideoPlaysPillsBlingBarPartDefinition channelFeedVideoPlaysPillsBlingBarPartDefinition;
                if (a2 != null) {
                    channelFeedVideoPlaysPillsBlingBarPartDefinition = (ChannelFeedVideoPlaysPillsBlingBarPartDefinition) a2.a(f2549e);
                } else {
                    channelFeedVideoPlaysPillsBlingBarPartDefinition = f2548d;
                }
                if (channelFeedVideoPlaysPillsBlingBarPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2482b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f2549e, b3);
                        } else {
                            f2548d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = channelFeedVideoPlaysPillsBlingBarPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
