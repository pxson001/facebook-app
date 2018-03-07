package com.facebook.goodwill.feed.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.goodwill.feed.rows.ThrowbackFeedStorySectionHeaderPartDefinition.Props;
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
/* compiled from: fb_linkshim_single_link_attempt */
public class ThrowbackFriendversaryCampaignGroupPartDefinition extends BaseMultiRowGroupPartDefinition<GraphQLGoodwillThrowbackFriendversaryPromotionStory, Void, FeedEnvironment> {
    private static ThrowbackFriendversaryCampaignGroupPartDefinition f13676e;
    private static final Object f13677f = new Object();
    private final ThrowbackFeedStorySectionHeaderPartDefinition f13678a;
    private final ThrowbackFriendversaryCampaignFooterPartDefinition f13679b;
    private final ThrowbackFriendversaryCampaignFriendViewPartDefinition f13680c;
    private final ThrowbackFriendversaryAttachmentPartDefinition f13681d;

    private static ThrowbackFriendversaryCampaignGroupPartDefinition m15380b(InjectorLike injectorLike) {
        return new ThrowbackFriendversaryCampaignGroupPartDefinition(ThrowbackFeedStorySectionHeaderPartDefinition.m15323a(injectorLike), ThrowbackFriendversaryAttachmentPartDefinition.m15358a(injectorLike), ThrowbackFriendversaryCampaignFriendViewPartDefinition.m15372a(injectorLike), ThrowbackFriendversaryCampaignFooterPartDefinition.m15364a(injectorLike));
    }

    public final Object m15381a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        GraphQLGoodwillThrowbackFriendversaryPromotionStory graphQLGoodwillThrowbackFriendversaryPromotionStory = (GraphQLGoodwillThrowbackFriendversaryPromotionStory) obj;
        GraphQLGoodwillFriendversaryCampaign l = graphQLGoodwillThrowbackFriendversaryPromotionStory.l();
        FeedProps c = FeedProps.c(graphQLGoodwillThrowbackFriendversaryPromotionStory);
        baseMultiRowSubParts.a(this.f13678a, new Props(c, graphQLGoodwillThrowbackFriendversaryPromotionStory.m(), true));
        baseMultiRowSubParts.a(this.f13680c, c);
        baseMultiRowSubParts.a(this.f13681d, l);
        baseMultiRowSubParts.a(this.f13679b, c);
        return null;
    }

    @Inject
    public ThrowbackFriendversaryCampaignGroupPartDefinition(ThrowbackFeedStorySectionHeaderPartDefinition throwbackFeedStorySectionHeaderPartDefinition, ThrowbackFriendversaryAttachmentPartDefinition throwbackFriendversaryAttachmentPartDefinition, ThrowbackFriendversaryCampaignFriendViewPartDefinition throwbackFriendversaryCampaignFriendViewPartDefinition, ThrowbackFriendversaryCampaignFooterPartDefinition throwbackFriendversaryCampaignFooterPartDefinition) {
        this.f13678a = throwbackFeedStorySectionHeaderPartDefinition;
        this.f13679b = throwbackFriendversaryCampaignFooterPartDefinition;
        this.f13680c = throwbackFriendversaryCampaignFriendViewPartDefinition;
        this.f13681d = throwbackFriendversaryAttachmentPartDefinition;
    }

    public static ThrowbackFriendversaryCampaignGroupPartDefinition m15379a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThrowbackFriendversaryCampaignGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f13677f) {
                ThrowbackFriendversaryCampaignGroupPartDefinition throwbackFriendversaryCampaignGroupPartDefinition;
                if (a2 != null) {
                    throwbackFriendversaryCampaignGroupPartDefinition = (ThrowbackFriendversaryCampaignGroupPartDefinition) a2.a(f13677f);
                } else {
                    throwbackFriendversaryCampaignGroupPartDefinition = f13676e;
                }
                if (throwbackFriendversaryCampaignGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m15380b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f13677f, b3);
                        } else {
                            f13676e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = throwbackFriendversaryCampaignGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final boolean m15382a(Object obj) {
        return true;
    }
}
