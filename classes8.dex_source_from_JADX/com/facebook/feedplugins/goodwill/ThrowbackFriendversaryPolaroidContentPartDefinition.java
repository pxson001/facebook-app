package com.facebook.feedplugins.goodwill;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.graphql.model.GoodwillFeedUnitHelper;
import com.facebook.graphql.model.GraphQLGoodwillCampaign;
import com.facebook.graphql.model.GraphQLGoodwillThrowbackPromotionFeedUnit;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: goodwill_throwback_notification_subscription_change */
public class ThrowbackFriendversaryPolaroidContentPartDefinition<E extends HasPositionInformation & HasPrefetcher> extends DualPhotoBasePartDefinition<GraphQLGoodwillThrowbackPromotionFeedUnit, E> {
    private static ThrowbackFriendversaryPolaroidContentPartDefinition f12415c;
    private static final Object f12416d = new Object();
    private final BackgroundPartDefinition f12417b;

    private static ThrowbackFriendversaryPolaroidContentPartDefinition m14326b(InjectorLike injectorLike) {
        return new ThrowbackFriendversaryPolaroidContentPartDefinition(BackgroundPartDefinition.a(injectorLike), FbDraweeControllerBuilder.b(injectorLike));
    }

    public final Object m14327a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        HasPositionInformation hasPositionInformation = (HasPositionInformation) anyEnvironment;
        subParts.a(this.f12417b, new StylingData(feedProps, PaddingStyle.a));
        ImmutableList u = GoodwillFeedUnitHelper.g((GraphQLGoodwillThrowbackPromotionFeedUnit) feedProps.a).u();
        DualPhotoViewConfig dualPhotoViewConfig = new DualPhotoViewConfig();
        dualPhotoViewConfig.f12223h = 18;
        return m14186a(hasPositionInformation, ((GraphQLStoryAttachment) u.get(0)).r().S().b(), ((GraphQLStoryAttachment) u.get(1)).r().S().b(), dualPhotoViewConfig);
    }

    public final boolean m14328a(Object obj) {
        FeedProps feedProps = (FeedProps) obj;
        if (feedProps == null || feedProps.a == null) {
            return false;
        }
        GraphQLGoodwillCampaign g = GoodwillFeedUnitHelper.g((GraphQLGoodwillThrowbackPromotionFeedUnit) feedProps.a);
        if (g == null || g.u() == null) {
            return false;
        }
        ImmutableList u = g.u();
        if (u == null || u.size() < 2) {
            return false;
        }
        for (int i = 0; i < 2; i++) {
            GraphQLMedia r = ((GraphQLStoryAttachment) u.get(i)).r();
            if (r == null || r.S() == null || r.S().b() == null) {
                return false;
            }
        }
        return true;
    }

    @Inject
    public ThrowbackFriendversaryPolaroidContentPartDefinition(BackgroundPartDefinition backgroundPartDefinition, FbDraweeControllerBuilder fbDraweeControllerBuilder) {
        super(fbDraweeControllerBuilder);
        this.f12417b = backgroundPartDefinition;
    }

    public static ThrowbackFriendversaryPolaroidContentPartDefinition m14325a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThrowbackFriendversaryPolaroidContentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12416d) {
                ThrowbackFriendversaryPolaroidContentPartDefinition throwbackFriendversaryPolaroidContentPartDefinition;
                if (a2 != null) {
                    throwbackFriendversaryPolaroidContentPartDefinition = (ThrowbackFriendversaryPolaroidContentPartDefinition) a2.a(f12416d);
                } else {
                    throwbackFriendversaryPolaroidContentPartDefinition = f12415c;
                }
                if (throwbackFriendversaryPolaroidContentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14326b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12416d, b3);
                        } else {
                            f12415c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = throwbackFriendversaryPolaroidContentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
