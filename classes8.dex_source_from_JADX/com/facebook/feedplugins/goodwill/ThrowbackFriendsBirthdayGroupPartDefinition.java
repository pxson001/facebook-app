package com.facebook.feedplugins.goodwill;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GoodwillFeedUnitHelper;
import com.facebook.graphql.model.GraphQLGoodwillThrowbackPromotionFeedUnit;
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
/* compiled from: goodwill_throwback_permalink_view_more */
public class ThrowbackFriendsBirthdayGroupPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLGoodwillThrowbackPromotionFeedUnit>, Void, FeedEnvironment> {
    private static ThrowbackFriendsBirthdayGroupPartDefinition f12392d;
    private static final Object f12393e = new Object();
    private final ThrowbackUnifiedHeaderPartDefinition<FeedEnvironment> f12394a;
    private final ThrowbackUnifiedInProductBrandingHeaderPartDefinition<FeedEnvironment> f12395b;
    private final MessageAndPostPartDefinition f12396c;

    private static ThrowbackFriendsBirthdayGroupPartDefinition m14314b(InjectorLike injectorLike) {
        return new ThrowbackFriendsBirthdayGroupPartDefinition(ThrowbackUnifiedHeaderPartDefinition.m14424a(injectorLike), ThrowbackUnifiedInProductBrandingHeaderPartDefinition.m14432a(injectorLike), MessageAndPostPartDefinition.m14264a(injectorLike));
    }

    public final Object m14315a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        if ("friend_birthday_ipb".equals(((GraphQLGoodwillThrowbackPromotionFeedUnit) feedProps.a).F())) {
            baseMultiRowSubParts.a(this.f12395b, feedProps);
        } else {
            baseMultiRowSubParts.a(this.f12394a, feedProps);
        }
        baseMultiRowSubParts.a(this.f12396c, feedProps);
        return null;
    }

    public final boolean m14316a(Object obj) {
        GraphQLGoodwillThrowbackPromotionFeedUnit graphQLGoodwillThrowbackPromotionFeedUnit = (GraphQLGoodwillThrowbackPromotionFeedUnit) ((FeedProps) obj).a;
        return GoodwillFeedUnitHelper.f(graphQLGoodwillThrowbackPromotionFeedUnit) && graphQLGoodwillThrowbackPromotionFeedUnit.v().a().get(0) != null && graphQLGoodwillThrowbackPromotionFeedUnit.F() != null && ("friend_birthday".equals(graphQLGoodwillThrowbackPromotionFeedUnit.F()) || "friend_birthday_ipb".equals(graphQLGoodwillThrowbackPromotionFeedUnit.F()));
    }

    @Inject
    public ThrowbackFriendsBirthdayGroupPartDefinition(ThrowbackUnifiedHeaderPartDefinition throwbackUnifiedHeaderPartDefinition, ThrowbackUnifiedInProductBrandingHeaderPartDefinition throwbackUnifiedInProductBrandingHeaderPartDefinition, MessageAndPostPartDefinition messageAndPostPartDefinition) {
        this.f12394a = throwbackUnifiedHeaderPartDefinition;
        this.f12395b = throwbackUnifiedInProductBrandingHeaderPartDefinition;
        this.f12396c = messageAndPostPartDefinition;
    }

    public static ThrowbackFriendsBirthdayGroupPartDefinition m14313a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThrowbackFriendsBirthdayGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12393e) {
                ThrowbackFriendsBirthdayGroupPartDefinition throwbackFriendsBirthdayGroupPartDefinition;
                if (a2 != null) {
                    throwbackFriendsBirthdayGroupPartDefinition = (ThrowbackFriendsBirthdayGroupPartDefinition) a2.a(f12393e);
                } else {
                    throwbackFriendsBirthdayGroupPartDefinition = f12392d;
                }
                if (throwbackFriendsBirthdayGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14314b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12393e, b3);
                        } else {
                            f12392d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = throwbackFriendsBirthdayGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
