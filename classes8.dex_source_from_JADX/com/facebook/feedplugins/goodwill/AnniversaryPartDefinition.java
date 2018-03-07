package com.facebook.feedplugins.goodwill;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLGoodwillAnniversaryCampaignFeedUnit;
import com.facebook.graphql.model.IsValidUtil;
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
/* compiled from: gravity_page_lookup_success */
public class AnniversaryPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLGoodwillAnniversaryCampaignFeedUnit>, Void, FeedEnvironment> {
    private static AnniversaryPartDefinition f12125e;
    private static final Object f12126f = new Object();
    private final AnniversaryFooterPartDefinition f12127a;
    private final ThrowbackUnifiedAttachmentPartDefinition f12128b;
    private final AnniversaryVideoAttachmentPartDefinition f12129c;
    private final AnniversaryHeaderPartDefinition f12130d;

    private static AnniversaryPartDefinition m14128b(InjectorLike injectorLike) {
        return new AnniversaryPartDefinition(AnniversaryHeaderPartDefinition.m14123a(injectorLike), ThrowbackUnifiedAttachmentPartDefinition.m14418a(injectorLike), AnniversaryVideoAttachmentPartDefinition.m14131a(injectorLike), AnniversaryFooterPartDefinition.m14115a(injectorLike));
    }

    public final Object m14129a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        baseMultiRowSubParts.a(this.f12130d, feedProps);
        SubPartsSelector.a(baseMultiRowSubParts, this.f12129c, feedProps).a(this.f12128b, AnniversaryCampaignFeedUnitToStoryConverter.m14114a(feedProps));
        baseMultiRowSubParts.a(this.f12127a, feedProps);
        return null;
    }

    public final boolean m14130a(Object obj) {
        return IsValidUtil.a((GraphQLGoodwillAnniversaryCampaignFeedUnit) ((FeedProps) obj).a);
    }

    @Inject
    public AnniversaryPartDefinition(AnniversaryHeaderPartDefinition anniversaryHeaderPartDefinition, ThrowbackUnifiedAttachmentPartDefinition throwbackUnifiedAttachmentPartDefinition, AnniversaryVideoAttachmentPartDefinition anniversaryVideoAttachmentPartDefinition, AnniversaryFooterPartDefinition anniversaryFooterPartDefinition) {
        this.f12127a = anniversaryFooterPartDefinition;
        this.f12128b = throwbackUnifiedAttachmentPartDefinition;
        this.f12130d = anniversaryHeaderPartDefinition;
        this.f12129c = anniversaryVideoAttachmentPartDefinition;
    }

    public static AnniversaryPartDefinition m14127a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            AnniversaryPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12126f) {
                AnniversaryPartDefinition anniversaryPartDefinition;
                if (a2 != null) {
                    anniversaryPartDefinition = (AnniversaryPartDefinition) a2.a(f12126f);
                } else {
                    anniversaryPartDefinition = f12125e;
                }
                if (anniversaryPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14128b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12126f, b3);
                        } else {
                            f12125e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = anniversaryPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
