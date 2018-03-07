package com.facebook.feedplugins.goodwill;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
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
/* compiled from: goodwill_dailydialogue_goodmorning_dismiss */
public class ThrowbackGroupPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLGoodwillThrowbackPromotionFeedUnit>, Void, FeedEnvironment> {
    private static ThrowbackGroupPartDefinition f12426j;
    private static final Object f12427k = new Object();
    private final ThrowbackPartDefinition f12428a;
    private final ThrowbackCompactGroupPartDefinition f12429b;
    private final ThrowbackCampaignGroupPartDefinition f12430c;
    private final ThrowbackBirthdayGroupPartDefinition f12431d;
    private final ThrowbackFriendsBirthdayGroupPartDefinition f12432e;
    private final ThrowbackFriendversaryPolaroidGroupPartDefinition f12433f;
    private final ThrowbackFriendversaryCollageGroupPartDefinition f12434g;
    private final ThrowbackFriendversaryDataCardGroupPartDefinition f12435h;
    private final ThrowbackVideoCampaignGroupPartDefinition f12436i;

    private static ThrowbackGroupPartDefinition m14335b(InjectorLike injectorLike) {
        return new ThrowbackGroupPartDefinition(ThrowbackFriendsBirthdayGroupPartDefinition.m14313a(injectorLike), ThrowbackBirthdayGroupPartDefinition.m14283a(injectorLike), ThrowbackFriendversaryPolaroidGroupPartDefinition.m14329a(injectorLike), ThrowbackCampaignGroupPartDefinition.m14290a(injectorLike), ThrowbackCompactGroupPartDefinition.m14306a(injectorLike), ThrowbackFriendversaryCollageGroupPartDefinition.m14317a(injectorLike), ThrowbackFriendversaryDataCardGroupPartDefinition.m14321a(injectorLike), ThrowbackVideoCampaignGroupPartDefinition.m14456a(injectorLike), ThrowbackPartDefinition.m14342a(injectorLike));
    }

    public final Object m14336a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        SubPartsSelector.a(baseMultiRowSubParts, this.f12432e, feedProps).a(this.f12436i, feedProps).a(this.f12434g, feedProps).a(this.f12431d, feedProps).a(this.f12435h, feedProps).a(this.f12433f, feedProps).a(this.f12430c, feedProps).a(this.f12429b, feedProps).a(this.f12428a, feedProps);
        return null;
    }

    @Inject
    public ThrowbackGroupPartDefinition(ThrowbackFriendsBirthdayGroupPartDefinition throwbackFriendsBirthdayGroupPartDefinition, ThrowbackBirthdayGroupPartDefinition throwbackBirthdayGroupPartDefinition, ThrowbackFriendversaryPolaroidGroupPartDefinition throwbackFriendversaryPolaroidGroupPartDefinition, ThrowbackCampaignGroupPartDefinition throwbackCampaignGroupPartDefinition, ThrowbackCompactGroupPartDefinition throwbackCompactGroupPartDefinition, ThrowbackFriendversaryCollageGroupPartDefinition throwbackFriendversaryCollageGroupPartDefinition, ThrowbackFriendversaryDataCardGroupPartDefinition throwbackFriendversaryDataCardGroupPartDefinition, ThrowbackVideoCampaignGroupPartDefinition throwbackVideoCampaignGroupPartDefinition, ThrowbackPartDefinition throwbackPartDefinition) {
        this.f12433f = throwbackFriendversaryPolaroidGroupPartDefinition;
        this.f12429b = throwbackCompactGroupPartDefinition;
        this.f12430c = throwbackCampaignGroupPartDefinition;
        this.f12431d = throwbackBirthdayGroupPartDefinition;
        this.f12432e = throwbackFriendsBirthdayGroupPartDefinition;
        this.f12434g = throwbackFriendversaryCollageGroupPartDefinition;
        this.f12435h = throwbackFriendversaryDataCardGroupPartDefinition;
        this.f12436i = throwbackVideoCampaignGroupPartDefinition;
        this.f12428a = throwbackPartDefinition;
    }

    public static ThrowbackGroupPartDefinition m14334a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThrowbackGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12427k) {
                ThrowbackGroupPartDefinition throwbackGroupPartDefinition;
                if (a2 != null) {
                    throwbackGroupPartDefinition = (ThrowbackGroupPartDefinition) a2.a(f12427k);
                } else {
                    throwbackGroupPartDefinition = f12426j;
                }
                if (throwbackGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14335b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12427k, b3);
                        } else {
                            f12426j = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = throwbackGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final boolean m14337a(Object obj) {
        return true;
    }
}
