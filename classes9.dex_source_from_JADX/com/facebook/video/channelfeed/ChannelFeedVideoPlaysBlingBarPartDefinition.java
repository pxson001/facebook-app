package com.facebook.video.channelfeed;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.CanShowVideoInFullScreen;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.ChannelFeedBackgroundPartDefinition;
import com.facebook.feed.rows.styling.ChannelFeedBackgroundPartDefinition.StylingData;
import com.facebook.feedplugins.base.blingbar.BlingBarRootPartDefinition;
import com.facebook.feedplugins.graphqlstory.footer.BaseVideoPlaysBlingBarPartDefinition;
import com.facebook.feedplugins.graphqlstory.footer.util.CrosspostedVideoViewCountTooltipUtil;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
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
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: supportVideo */
public class ChannelFeedVideoPlaysBlingBarPartDefinition<E extends CanShowVideoInFullScreen & HasPositionInformation & HasPersistentState> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, OnClickListener, E, ChannelFeedVideoPlaysBlingBarView> {
    public static final ViewType f2536a = new C02331();
    private static ChannelFeedVideoPlaysBlingBarPartDefinition f2537e;
    private static final Object f2538f = new Object();
    private final BaseVideoPlaysBlingBarPartDefinition<E> f2539b;
    private final ChannelFeedBackgroundPartDefinition f2540c;
    private final CrosspostedVideoViewCountTooltipUtil f2541d;

    /* compiled from: supportVideo */
    final class C02331 extends ViewType {
        C02331() {
        }

        public final View m2468a(Context context) {
            return new ChannelFeedVideoPlaysBlingBarView(context);
        }
    }

    private static ChannelFeedVideoPlaysBlingBarPartDefinition m2470b(InjectorLike injectorLike) {
        return new ChannelFeedVideoPlaysBlingBarPartDefinition(BaseVideoPlaysBlingBarPartDefinition.a(injectorLike), ChannelFeedBackgroundPartDefinition.a(injectorLike), CrosspostedVideoViewCountTooltipUtil.a(injectorLike));
    }

    public final Object m2472a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        GraphQLStoryAttachment graphQLStoryAttachment;
        FeedProps feedProps = (FeedProps) obj;
        subParts.a(this.f2539b, feedProps);
        subParts.a(this.f2540c, new StylingData(feedProps, BlingBarRootPartDefinition.a));
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        if (StoryAttachmentHelper.a(graphQLStory)) {
            ImmutableList M = graphQLStory.M();
            int size = M.size();
            for (int i = 0; i < size; i++) {
                graphQLStoryAttachment = (GraphQLStoryAttachment) M.get(i);
                if (GraphQLStoryAttachmentUtil.d(graphQLStoryAttachment)) {
                    break;
                }
            }
            graphQLStoryAttachment = null;
        } else {
            graphQLStoryAttachment = null;
        }
        return this.f2541d.a(graphQLStoryAttachment);
    }

    public final /* bridge */ /* synthetic */ void m2473a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -304875512);
        OnClickListener onClickListener = (OnClickListener) obj2;
        ChannelFeedVideoPlaysBlingBarView channelFeedVideoPlaysBlingBarView = (ChannelFeedVideoPlaysBlingBarView) view;
        if (!(onClickListener == null || channelFeedVideoPlaysBlingBarView.f2547c == null)) {
            channelFeedVideoPlaysBlingBarView.f2547c.setOnClickListener(onClickListener);
        }
        Logger.a(8, EntryType.MARK_POP, 1579362458, a);
    }

    public final boolean m2474a(Object obj) {
        return BaseVideoPlaysBlingBarPartDefinition.a((FeedProps) obj);
    }

    public final void m2475b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ChannelFeedVideoPlaysBlingBarView channelFeedVideoPlaysBlingBarView = (ChannelFeedVideoPlaysBlingBarView) view;
        if (((OnClickListener) obj2) != null && channelFeedVideoPlaysBlingBarView.f2547c != null) {
            channelFeedVideoPlaysBlingBarView.f2547c.setOnClickListener(null);
        }
    }

    @Inject
    public ChannelFeedVideoPlaysBlingBarPartDefinition(BaseVideoPlaysBlingBarPartDefinition baseVideoPlaysBlingBarPartDefinition, ChannelFeedBackgroundPartDefinition channelFeedBackgroundPartDefinition, CrosspostedVideoViewCountTooltipUtil crosspostedVideoViewCountTooltipUtil) {
        this.f2539b = baseVideoPlaysBlingBarPartDefinition;
        this.f2540c = channelFeedBackgroundPartDefinition;
        this.f2541d = crosspostedVideoViewCountTooltipUtil;
    }

    public final ViewType m2471a() {
        return f2536a;
    }

    public static ChannelFeedVideoPlaysBlingBarPartDefinition m2469a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ChannelFeedVideoPlaysBlingBarPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f2538f) {
                ChannelFeedVideoPlaysBlingBarPartDefinition channelFeedVideoPlaysBlingBarPartDefinition;
                if (a2 != null) {
                    channelFeedVideoPlaysBlingBarPartDefinition = (ChannelFeedVideoPlaysBlingBarPartDefinition) a2.a(f2538f);
                } else {
                    channelFeedVideoPlaysBlingBarPartDefinition = f2537e;
                }
                if (channelFeedVideoPlaysBlingBarPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m2470b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f2538f, b3);
                        } else {
                            f2537e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = channelFeedVideoPlaysBlingBarPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
