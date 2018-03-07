package com.facebook.feed.rows.sections.header;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.LazyResources;
import com.facebook.feed.environment.CanFollowUser;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.header.BaseHeaderPartDefinitionWithoutMenuButton.Props;
import com.facebook.feed.rows.sections.header.ui.BaseHeaderViewWithTextLayout;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.graphql.calls.ActorSubscribeInputData.SubscribeLocation;
import com.facebook.graphql.calls.ActorUnsubscribeInputData;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryActionLinkHelper;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import javax.inject.Inject;

@ContextScoped
/* compiled from: http_error */
public class FollowableHeaderPartDefinition<E extends CanFollowUser & HasContext & HasInvalidate & HasRowKey & HasPositionInformation & HasPrefetcher & HasPersistentState & HasMenuButtonProvider> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, BaseHeaderViewWithTextLayout> {
    public static final ViewType f20726a = new C08291();
    private static FollowableHeaderPartDefinition f20727i;
    private static final Object f20728j = new Object();
    private final FollowUserButtonPartDefinition<E> f20729b;
    private final GraphQLStoryUtil f20730c;
    private final BaseHeaderPartDefinitionWithoutMenuButton<E> f20731d;
    private final BackgroundPartDefinition f20732e;
    private final StoryHeaderUtil f20733f;
    public final Context f20734g;
    public final Lazy<Drawable> f20735h;

    /* compiled from: http_error */
    final class C08291 extends ViewType {
        C08291() {
        }

        public final View mo1995a(Context context) {
            return new BaseHeaderViewWithTextLayout(context, null, 2130904399);
        }
    }

    private static FollowableHeaderPartDefinition m28450b(InjectorLike injectorLike) {
        return new FollowableHeaderPartDefinition(GraphQLStoryUtil.m9565a(injectorLike), FollowUserButtonPartDefinition.m28456a(injectorLike), BaseHeaderPartDefinitionWithoutMenuButton.m28465a(injectorLike), BackgroundPartDefinition.m19135a(injectorLike), StoryHeaderUtil.m28330a(injectorLike), (Context) injectorLike.getInstance(Context.class));
    }

    public final Object mo2541a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.f13444a;
        subParts.mo2756a(this.f20732e, this.f20733f.m28334a(feedProps));
        subParts.mo2756a(this.f20731d, new Props(feedProps, ((Drawable) this.f20735h.get()).getIntrinsicWidth() + (this.f20734g.getResources().getDimensionPixelSize(2131428828) * 2)));
        GraphQLProfile ah = StoryActionLinkHelper.m28072a(graphQLStory, -2052107768).ah();
        subParts.mo2755a(2131562115, this.f20729b, new FollowUserButtonPartDefinition.Props(graphQLStory, ah.ar(), ah.m22999b(), SubscribeLocation.FEED_UNCONNECTED_STORY, ActorUnsubscribeInputData.SubscribeLocation.FEED_UNCONNECTED_STORY, 2130839874, 2130839875));
        return null;
    }

    public final boolean m28453a(Object obj) {
        return GraphQLStoryUtil.m9576d((GraphQLStory) ((FeedProps) obj).f13444a);
    }

    public static FollowableHeaderPartDefinition m28449a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FollowableHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20728j) {
                FollowableHeaderPartDefinition followableHeaderPartDefinition;
                if (a2 != null) {
                    followableHeaderPartDefinition = (FollowableHeaderPartDefinition) a2.mo818a(f20728j);
                } else {
                    followableHeaderPartDefinition = f20727i;
                }
                if (followableHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28450b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20728j, b3);
                        } else {
                            f20727i = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = followableHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    @Inject
    public FollowableHeaderPartDefinition(GraphQLStoryUtil graphQLStoryUtil, FollowUserButtonPartDefinition followUserButtonPartDefinition, BaseHeaderPartDefinitionWithoutMenuButton baseHeaderPartDefinitionWithoutMenuButton, BackgroundPartDefinition backgroundPartDefinition, StoryHeaderUtil storyHeaderUtil, Context context) {
        this.f20730c = graphQLStoryUtil;
        this.f20729b = followUserButtonPartDefinition;
        this.f20731d = baseHeaderPartDefinitionWithoutMenuButton;
        this.f20732e = backgroundPartDefinition;
        this.f20733f = storyHeaderUtil;
        this.f20734g = context;
        this.f20735h = LazyResources.m28241b(context, 2130839874);
    }

    public final ViewType mo2547a() {
        return f20726a;
    }
}
