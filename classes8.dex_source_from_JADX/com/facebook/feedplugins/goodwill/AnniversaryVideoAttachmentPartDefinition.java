package com.facebook.feedplugins.goodwill;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.video.VideoAttachmentsSelectorPartDefinition;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.graphql.model.GraphQLGoodwillAnniversaryCampaignFeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.StoryAttachmentHelper;
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
/* compiled from: gravity_page_lookup_fail */
public class AnniversaryVideoAttachmentPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLGoodwillAnniversaryCampaignFeedUnit>, Void, FeedEnvironment> {
    private static AnniversaryVideoAttachmentPartDefinition f12131c;
    private static final Object f12132d = new Object();
    private final AnniversaryVideoPlaceholderPartDefinition f12133a;
    private final VideoAttachmentsSelectorPartDefinition f12134b;

    private static AnniversaryVideoAttachmentPartDefinition m14132b(InjectorLike injectorLike) {
        return new AnniversaryVideoAttachmentPartDefinition(AnniversaryVideoPlaceholderPartDefinition.m14142a(injectorLike), VideoAttachmentsSelectorPartDefinition.a(injectorLike));
    }

    public final Object m14133a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLGoodwillAnniversaryCampaignFeedUnit graphQLGoodwillAnniversaryCampaignFeedUnit = (GraphQLGoodwillAnniversaryCampaignFeedUnit) feedProps.a;
        FeedProps a = AnniversaryCampaignFeedUnitToStoryConverter.m14114a(feedProps);
        GraphQLStoryAttachment o = StoryAttachmentHelper.o((GraphQLStory) a.a);
        FeedProps a2 = a.a(o).a((Flattenable) o.x().get(0));
        if (graphQLGoodwillAnniversaryCampaignFeedUnit.l().j() == null || graphQLGoodwillAnniversaryCampaignFeedUnit.l().j().isEmpty()) {
            baseMultiRowSubParts.a(this.f12133a, a2);
        } else {
            baseMultiRowSubParts.a(this.f12134b, a2);
        }
        return null;
    }

    public final boolean m14134a(Object obj) {
        GraphQLGoodwillAnniversaryCampaignFeedUnit graphQLGoodwillAnniversaryCampaignFeedUnit = (GraphQLGoodwillAnniversaryCampaignFeedUnit) ((FeedProps) obj).a;
        return graphQLGoodwillAnniversaryCampaignFeedUnit.n() != null && graphQLGoodwillAnniversaryCampaignFeedUnit.n().equals("anniversary_video");
    }

    @Inject
    public AnniversaryVideoAttachmentPartDefinition(AnniversaryVideoPlaceholderPartDefinition anniversaryVideoPlaceholderPartDefinition, VideoAttachmentsSelectorPartDefinition videoAttachmentsSelectorPartDefinition) {
        this.f12133a = anniversaryVideoPlaceholderPartDefinition;
        this.f12134b = videoAttachmentsSelectorPartDefinition;
    }

    public static AnniversaryVideoAttachmentPartDefinition m14131a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            AnniversaryVideoAttachmentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12132d) {
                AnniversaryVideoAttachmentPartDefinition anniversaryVideoAttachmentPartDefinition;
                if (a2 != null) {
                    anniversaryVideoAttachmentPartDefinition = (AnniversaryVideoAttachmentPartDefinition) a2.a(f12132d);
                } else {
                    anniversaryVideoAttachmentPartDefinition = f12131c;
                }
                if (anniversaryVideoAttachmentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14132b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12132d, b3);
                        } else {
                            f12131c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = anniversaryVideoAttachmentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
