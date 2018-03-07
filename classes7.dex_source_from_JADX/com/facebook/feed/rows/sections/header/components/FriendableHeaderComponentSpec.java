package com.facebook.feed.rows.sections.header.components;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.annotations.LayoutSpec;
import com.facebook.feed.environment.CanFriendPerson;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.header.FriendingButtonPartDefinition.FriendshipStatusKey;
import com.facebook.friends.ui.FriendingButtonModel;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.conversion.FeedUnitItemProfileHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@LayoutSpec
@ContextScoped
/* compiled from: UniversalFeedbackDialogFragment */
public class FriendableHeaderComponentSpec<E extends CanFriendPerson & HasFeedListType & HasInvalidate & HasPersistentState & HasPrefetcher & HasRowKey & HasContext> {
    private static FriendableHeaderComponentSpec f21288c;
    private static final Object f21289d = new Object();
    public final HeaderComponentLayouts<E> f21290a;
    public final FriendingButtonComponent<E> f21291b;

    private static FriendableHeaderComponentSpec m24067b(InjectorLike injectorLike) {
        return new FriendableHeaderComponentSpec(HeaderComponentLayouts.b(injectorLike), FriendingButtonComponent.m24071a(injectorLike));
    }

    @Inject
    public FriendableHeaderComponentSpec(HeaderComponentLayouts headerComponentLayouts, FriendingButtonComponent friendingButtonComponent) {
        this.f21290a = headerComponentLayouts;
        this.f21291b = friendingButtonComponent;
    }

    public static FriendableHeaderComponentSpec m24065a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FriendableHeaderComponentSpec b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f21289d) {
                FriendableHeaderComponentSpec friendableHeaderComponentSpec;
                if (a2 != null) {
                    friendableHeaderComponentSpec = (FriendableHeaderComponentSpec) a2.a(f21289d);
                } else {
                    friendableHeaderComponentSpec = f21288c;
                }
                if (friendableHeaderComponentSpec == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m24067b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f21289d, b3);
                        } else {
                            f21288c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = friendableHeaderComponentSpec;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public static FriendingButtonModel m24066a(FeedProps<GraphQLStory> feedProps, E e) {
        FriendingButtonModel friendingButtonModel = new FriendingButtonModel();
        friendingButtonModel.e = 2130840456;
        friendingButtonModel.d = 2130840457;
        GraphQLStory graphQLStory = (GraphQLStory) feedProps.a;
        friendingButtonModel.a((GraphQLFriendshipStatus) ((HasPersistentState) e).a(new FriendshipStatusKey(FeedUnitItemProfileHelper.a(graphQLStory)), graphQLStory));
        return friendingButtonModel;
    }
}
