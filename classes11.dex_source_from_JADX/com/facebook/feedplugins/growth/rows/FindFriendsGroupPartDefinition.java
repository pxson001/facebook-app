package com.facebook.feedplugins.growth.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLFindFriendsFeedUnit;
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
/* compiled from: debugId */
public class FindFriendsGroupPartDefinition<E extends HasPositionInformation & HasPersistentState> extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLFindFriendsFeedUnit>, Void, E> {
    private static FindFriendsGroupPartDefinition f7750b;
    private static final Object f7751c = new Object();
    private final FindFriendsPartDefinition<E> f7752a;

    private static FindFriendsGroupPartDefinition m8925b(InjectorLike injectorLike) {
        return new FindFriendsGroupPartDefinition(FindFriendsPartDefinition.m8931a(injectorLike));
    }

    public final Object m8926a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        baseMultiRowSubParts.a(this.f7752a, (GraphQLFindFriendsFeedUnit) ((FeedProps) obj).a);
        return null;
    }

    @Inject
    public FindFriendsGroupPartDefinition(FindFriendsPartDefinition findFriendsPartDefinition) {
        this.f7752a = findFriendsPartDefinition;
    }

    public final boolean m8927a(Object obj) {
        return true;
    }

    public static FindFriendsGroupPartDefinition m8924a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FindFriendsGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f7751c) {
                FindFriendsGroupPartDefinition findFriendsGroupPartDefinition;
                if (a2 != null) {
                    findFriendsGroupPartDefinition = (FindFriendsGroupPartDefinition) a2.a(f7751c);
                } else {
                    findFriendsGroupPartDefinition = f7750b;
                }
                if (findFriendsGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m8925b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f7751c, b3);
                        } else {
                            f7750b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = findFriendsGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
