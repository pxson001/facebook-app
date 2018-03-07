package com.facebook.feed.rows.sections.header;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.LazyResources;
import com.facebook.feed.environment.CanFriendPerson;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasMenuButtonProvider;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.header.HeaderTitleWithLayoutPartDefinition.Props;
import com.facebook.feed.rows.sections.header.ui.FriendableHeaderView;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feedplugins.base.TextLinkPartDefinition;
import com.facebook.graphql.model.GraphQLStory;
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
/* compiled from: Unsupported media rate. */
public class DefaultFriendableHeaderPartDefinition<E extends CanFriendPerson & HasContext & HasFeedListType & HasInvalidate & HasMenuButtonProvider & HasPositionInformation & HasPrefetcher & HasPersistentState & HasRowKey> extends MultiRowSinglePartDefinition<FeedProps<GraphQLStory>, Void, E, FriendableHeaderView> {
    public static final ViewType f21127a = new C17931();
    private static DefaultFriendableHeaderPartDefinition f21128l;
    private static final Object f21129m = new Object();
    private final TextLinkPartDefinition f21130b;
    private final BackgroundPartDefinition f21131c;
    private final ProfilePhotoPartDefinition<E> f21132d;
    private final HeaderTitleWithLayoutPartDefinition<E> f21133e;
    private final DefaultHeaderSubtitleWithLayoutPartDefinition<E> f21134f;
    private final FriendingButtonPartDefinition<E> f21135g;
    private final GraphQLStoryUtil f21136h;
    private final StoryHeaderUtil f21137i;
    private final Context f21138j;
    private final Lazy<Drawable> f21139k;

    /* compiled from: Unsupported media rate. */
    final class C17931 extends ViewType {
        C17931() {
        }

        public final View m23991a(Context context) {
            return new FriendableHeaderView(context);
        }
    }

    private static DefaultFriendableHeaderPartDefinition m23993b(InjectorLike injectorLike) {
        return new DefaultFriendableHeaderPartDefinition(GraphQLStoryUtil.a(injectorLike), BackgroundPartDefinition.a(injectorLike), TextLinkPartDefinition.a(injectorLike), ProfilePhotoPartDefinition.a(injectorLike), HeaderTitleWithLayoutPartDefinition.a(injectorLike), DefaultHeaderSubtitleWithLayoutPartDefinition.a(injectorLike), FriendingButtonPartDefinition.m24002a(injectorLike), StoryHeaderUtil.a(injectorLike), (Context) injectorLike.getInstance(Context.class));
    }

    public final Object m23996a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        subParts.a(this.f21130b, feedProps);
        subParts.a(this.f21131c, this.f21137i.a(feedProps));
        subParts.a(2131562765, this.f21133e, new Props(feedProps, true, m23994c()));
        int c = this.f21137i.c(feedProps);
        subParts.a(2131562764, this.f21132d, new ProfilePhotoPartDefinition.Props(feedProps, this.f21137i.b(feedProps), c));
        subParts.a(2131562766, this.f21134f, new DefaultHeaderSubtitleWithLayoutPartDefinition.Props(feedProps, m23994c()));
        subParts.a(2131562871, this.f21135g, feedProps);
        return null;
    }

    public static DefaultFriendableHeaderPartDefinition m23992a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            DefaultFriendableHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f21129m) {
                DefaultFriendableHeaderPartDefinition defaultFriendableHeaderPartDefinition;
                if (a2 != null) {
                    defaultFriendableHeaderPartDefinition = (DefaultFriendableHeaderPartDefinition) a2.a(f21129m);
                } else {
                    defaultFriendableHeaderPartDefinition = f21128l;
                }
                if (defaultFriendableHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23993b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f21129m, b3);
                        } else {
                            f21128l = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = defaultFriendableHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public DefaultFriendableHeaderPartDefinition(GraphQLStoryUtil graphQLStoryUtil, BackgroundPartDefinition backgroundPartDefinition, TextLinkPartDefinition textLinkPartDefinition, ProfilePhotoPartDefinition profilePhotoPartDefinition, HeaderTitleWithLayoutPartDefinition headerTitleWithLayoutPartDefinition, DefaultHeaderSubtitleWithLayoutPartDefinition defaultHeaderSubtitleWithLayoutPartDefinition, FriendingButtonPartDefinition friendingButtonPartDefinition, StoryHeaderUtil storyHeaderUtil, Context context) {
        this.f21136h = graphQLStoryUtil;
        this.f21130b = textLinkPartDefinition;
        this.f21131c = backgroundPartDefinition;
        this.f21132d = profilePhotoPartDefinition;
        this.f21133e = headerTitleWithLayoutPartDefinition;
        this.f21134f = defaultHeaderSubtitleWithLayoutPartDefinition;
        this.f21135g = friendingButtonPartDefinition;
        this.f21137i = storyHeaderUtil;
        this.f21138j = context;
        this.f21139k = LazyResources.b(context, 2130840456);
    }

    public final ViewType m23995a() {
        return f21127a;
    }

    public final boolean m23997a(Object obj) {
        return true;
    }

    private int m23994c() {
        return ((Drawable) this.f21139k.get()).getIntrinsicWidth() + (this.f21138j.getResources().getDimensionPixelSize(2131427612) * 2);
    }
}
