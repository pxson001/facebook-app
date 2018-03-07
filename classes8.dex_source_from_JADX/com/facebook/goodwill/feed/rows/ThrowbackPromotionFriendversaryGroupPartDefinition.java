package com.facebook.goodwill.feed.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.goodwill.ThrowbackVideoSharePartDefinition;
import com.facebook.goodwill.feed.rows.ThrowbackPromotionFeedUnitEdge.ThrowbackPromotionFeedUnit;
import com.facebook.graphql.model.GraphQLGoodwillFriendversaryCampaign;
import com.facebook.graphql.model.GraphQLGoodwillThrowbackFriendversaryPromotionStory;
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
/* compiled from: fb4a_account_recovery */
public class ThrowbackPromotionFriendversaryGroupPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<ThrowbackPromotionFeedUnit>, Void, FeedEnvironment> {
    private static ThrowbackPromotionFriendversaryGroupPartDefinition f13779f;
    private static final Object f13780g = new Object();
    private final ThrowbackFeedPromotionHeaderPartDefinition f13781a;
    private final ThrowbackFriendversaryAttachmentPartDefinition f13782b;
    private final ThrowbackFriendversaryCampaignFooterPartDefinition f13783c;
    private final ThrowbackVideoSharePartDefinition f13784d;
    private final ThrowbackPromotionMoreFooterPartDefinition f13785e;

    private static ThrowbackPromotionFriendversaryGroupPartDefinition m15439b(InjectorLike injectorLike) {
        return new ThrowbackPromotionFriendversaryGroupPartDefinition(ThrowbackFeedPromotionHeaderPartDefinition.m15308a(injectorLike), ThrowbackFriendversaryAttachmentPartDefinition.m15358a(injectorLike), ThrowbackFriendversaryCampaignFooterPartDefinition.m15364a(injectorLike), ThrowbackVideoSharePartDefinition.m14464a(injectorLike), ThrowbackPromotionMoreFooterPartDefinition.m15442a(injectorLike));
    }

    public final Object m15440a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLGoodwillThrowbackFriendversaryPromotionStory graphQLGoodwillThrowbackFriendversaryPromotionStory = (GraphQLGoodwillThrowbackFriendversaryPromotionStory) ((ThrowbackPromotionFeedUnit) feedProps.a).m15437c();
        GraphQLGoodwillFriendversaryCampaign l = graphQLGoodwillThrowbackFriendversaryPromotionStory.l();
        FeedProps c = FeedProps.c(graphQLGoodwillThrowbackFriendversaryPromotionStory);
        baseMultiRowSubParts.a(this.f13781a, feedProps);
        baseMultiRowSubParts.a(this.f13782b, l);
        if (ThrowbackFeedUtils.m15330a(l)) {
            baseMultiRowSubParts.a(this.f13784d, c);
        } else {
            baseMultiRowSubParts.a(this.f13783c, c);
        }
        baseMultiRowSubParts.a(this.f13785e, feedProps);
        return null;
    }

    public final boolean m15441a(Object obj) {
        FeedProps feedProps = (FeedProps) obj;
        return feedProps.a != null && (((ThrowbackPromotionFeedUnit) feedProps.a).f13777c instanceof GraphQLGoodwillThrowbackFriendversaryPromotionStory);
    }

    @Inject
    public ThrowbackPromotionFriendversaryGroupPartDefinition(ThrowbackFeedPromotionHeaderPartDefinition throwbackFeedPromotionHeaderPartDefinition, ThrowbackFriendversaryAttachmentPartDefinition throwbackFriendversaryAttachmentPartDefinition, ThrowbackFriendversaryCampaignFooterPartDefinition throwbackFriendversaryCampaignFooterPartDefinition, ThrowbackVideoSharePartDefinition throwbackVideoSharePartDefinition, ThrowbackPromotionMoreFooterPartDefinition throwbackPromotionMoreFooterPartDefinition) {
        this.f13781a = throwbackFeedPromotionHeaderPartDefinition;
        this.f13782b = throwbackFriendversaryAttachmentPartDefinition;
        this.f13783c = throwbackFriendversaryCampaignFooterPartDefinition;
        this.f13784d = throwbackVideoSharePartDefinition;
        this.f13785e = throwbackPromotionMoreFooterPartDefinition;
    }

    public static ThrowbackPromotionFriendversaryGroupPartDefinition m15438a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThrowbackPromotionFriendversaryGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f13780g) {
                ThrowbackPromotionFriendversaryGroupPartDefinition throwbackPromotionFriendversaryGroupPartDefinition;
                if (a2 != null) {
                    throwbackPromotionFriendversaryGroupPartDefinition = (ThrowbackPromotionFriendversaryGroupPartDefinition) a2.a(f13780g);
                } else {
                    throwbackPromotionFriendversaryGroupPartDefinition = f13779f;
                }
                if (throwbackPromotionFriendversaryGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m15439b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f13780g, b3);
                        } else {
                            f13779f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = throwbackPromotionFriendversaryGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
