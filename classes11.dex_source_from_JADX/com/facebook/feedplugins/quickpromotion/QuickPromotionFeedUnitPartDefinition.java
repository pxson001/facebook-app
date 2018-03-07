package com.facebook.feedplugins.quickpromotion;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLQuickPromotionFeedUnit;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: cell_tower */
public class QuickPromotionFeedUnitPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLQuickPromotionFeedUnit>, Void, FeedEnvironment> {
    private static QuickPromotionFeedUnitPartDefinition f8868g;
    private static final Object f8869h = new Object();
    private final QuickPromotionFooterSelector f8870a;
    private final Lazy<QuickPromotionSocialContextPartDefinition> f8871b;
    private final Lazy<QuickPromotionSocialContextComponentPartDefinition<FeedEnvironment>> f8872c;
    private final QuickPromotionContentStyleSelector f8873d;
    private final QuickPromotionHeaderPartDefinition f8874e;
    private final QuickPromotionVideoAttachmentPartDefinition f8875f;

    private static QuickPromotionFeedUnitPartDefinition m9619b(InjectorLike injectorLike) {
        return new QuickPromotionFeedUnitPartDefinition(QuickPromotionHeaderPartDefinition.m9637a(injectorLike), QuickPromotionContentStyleSelector.m9601a(injectorLike), IdBasedLazy.a(injectorLike, 6510), IdBasedLazy.a(injectorLike, 6508), QuickPromotionFooterSelector.m9633a(injectorLike), QuickPromotionVideoAttachmentPartDefinition.m9708a(injectorLike));
    }

    public final Object m9620a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        baseMultiRowSubParts.a(this.f8874e, feedProps);
        baseMultiRowSubParts.a(this.f8873d, feedProps);
        baseMultiRowSubParts.a(this.f8875f, feedProps);
        SubPartsSelector.a(baseMultiRowSubParts, this.f8872c, feedProps).a(this.f8871b, feedProps);
        baseMultiRowSubParts.a(this.f8870a, feedProps);
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean m9621a(java.lang.Object r12) {
        /*
        r11 = this;
        r12 = (com.facebook.feed.rows.core.props.FeedProps) r12;
        r3 = r12.a;
        r0 = r3;
        r0 = (com.facebook.graphql.model.GraphQLQuickPromotionFeedUnit) r0;
        r1 = com.facebook.graphql.model.QuickPromotionFeedUnitHelper.b(r0);
        r0 = com.facebook.graphql.model.QuickPromotionFeedUnitHelper.c(r0);
        if (r0 == 0) goto L_0x003b;
    L_0x0011:
        if (r1 == 0) goto L_0x003b;
    L_0x0013:
        r0 = r1.l();
        if (r0 == 0) goto L_0x003b;
    L_0x0019:
        r0 = com.facebook.feedplugins.quickpromotion.QuickPromotionTemplate.UNKNOWN;
        r2 = r1.l();
        r2 = r2.a();
        r2 = com.facebook.feedplugins.quickpromotion.QuickPromotionTemplate.fromString(r2);
        r0 = r0.equals(r2);
        if (r0 != 0) goto L_0x003b;
    L_0x002d:
        r0 = r1.l();
        r4 = 0;
        r5 = 1;
        if (r0 != 0) goto L_0x003d;
    L_0x0035:
        r3 = r4;
    L_0x0036:
        r0 = r3;
        if (r0 != 0) goto L_0x003b;
    L_0x0039:
        r0 = 1;
    L_0x003a:
        return r0;
    L_0x003b:
        r0 = 0;
        goto L_0x003a;
    L_0x003d:
        r7 = r0.j();
        if (r7 == 0) goto L_0x0049;
    L_0x0043:
        r3 = r7.isEmpty();
        if (r3 == 0) goto L_0x004b;
    L_0x0049:
        r3 = r4;
        goto L_0x0036;
    L_0x004b:
        r8 = r7.size();
        r6 = r4;
    L_0x0050:
        if (r6 >= r8) goto L_0x010d;
    L_0x0052:
        r3 = r7.get(r6);
        r3 = (com.facebook.graphql.model.GraphQLQPTemplateParameter) r3;
        r9 = r3.k();
        if (r9 == 0) goto L_0x0108;
    L_0x005e:
        r9 = r3.j();
        r9 = com.facebook.feedplugins.quickpromotion.QuickPromotionTemplateParameter.Type.fromString(r9);
        r10 = com.facebook.feedplugins.quickpromotion.QuickPromotionFeedUnitUtils.C10791.f8876a;
        r9 = r9.ordinal();
        r9 = r10[r9];
        switch(r9) {
            case 1: goto L_0x0073;
            case 2: goto L_0x0085;
            case 3: goto L_0x0097;
            case 4: goto L_0x00a9;
            case 5: goto L_0x00bc;
            case 6: goto L_0x00cf;
            case 7: goto L_0x00e2;
            case 8: goto L_0x00f5;
            default: goto L_0x0071;
        };
    L_0x0071:
        r3 = r5;
        goto L_0x0036;
    L_0x0073:
        r3 = r3.l();
        r3 = com.facebook.feedplugins.quickpromotion.QuickPromotionTemplateParameter.ImageOverlay.fromString(r3);
        r9 = com.facebook.feedplugins.quickpromotion.QuickPromotionTemplateParameter.ImageOverlay.UNKNOWN;
        r3 = r3.equals(r9);
        if (r3 == 0) goto L_0x0108;
    L_0x0083:
        r3 = r5;
        goto L_0x0036;
    L_0x0085:
        r3 = r3.l();
        r3 = com.facebook.feedplugins.quickpromotion.QuickPromotionTemplateParameter.PrimaryActionButtonGlyph.fromString(r3);
        r9 = com.facebook.feedplugins.quickpromotion.QuickPromotionTemplateParameter.PrimaryActionButtonGlyph.UNKNOWN;
        r3 = r3.equals(r9);
        if (r3 == 0) goto L_0x0108;
    L_0x0095:
        r3 = r5;
        goto L_0x0036;
    L_0x0097:
        r3 = r3.l();
        r3 = com.facebook.feedplugins.quickpromotion.QuickPromotionTemplateParameter.LargeImageLocation.fromString(r3);
        r9 = com.facebook.feedplugins.quickpromotion.QuickPromotionTemplateParameter.LargeImageLocation.UNKNOWN;
        r3 = r3.equals(r9);
        if (r3 == 0) goto L_0x0108;
    L_0x00a7:
        r3 = r5;
        goto L_0x0036;
    L_0x00a9:
        r3 = r3.l();
        r3 = com.facebook.feedplugins.quickpromotion.QuickPromotionTemplateParameter.FeedTapAction.fromString(r3);
        r9 = com.facebook.feedplugins.quickpromotion.QuickPromotionTemplateParameter.FeedTapAction.UNKNOWN;
        r3 = r3.equals(r9);
        if (r3 == 0) goto L_0x0108;
    L_0x00b9:
        r3 = r5;
        goto L_0x0036;
    L_0x00bc:
        r9 = r3.l();
        r9 = com.facebook.feedplugins.quickpromotion.QuickPromotionTemplateParameter.BrandingStyle.fromString(r9);
        r10 = com.facebook.feedplugins.quickpromotion.QuickPromotionTemplateParameter.BrandingStyle.UNKNOWN;
        r9 = r9.equals(r10);
        if (r9 == 0) goto L_0x00cf;
    L_0x00cc:
        r3 = r5;
        goto L_0x0036;
    L_0x00cf:
        r3 = r3.l();
        r3 = com.facebook.feedplugins.quickpromotion.QuickPromotionTemplateParameter.SecondaryActionButtonGlyph.fromString(r3);
        r9 = com.facebook.feedplugins.quickpromotion.QuickPromotionTemplateParameter.SecondaryActionButtonGlyph.UNKNOWN;
        r3 = r3.equals(r9);
        if (r3 == 0) goto L_0x0108;
    L_0x00df:
        r3 = r5;
        goto L_0x0036;
    L_0x00e2:
        r4 = r3.l();
        r4 = com.facebook.feedplugins.quickpromotion.QuickPromotionTemplateParameter.TitleSize.fromString(r4);
        r6 = com.facebook.feedplugins.quickpromotion.QuickPromotionTemplateParameter.TitleSize.UNKNOWN;
        r4 = r4.equals(r6);
        if (r4 == 0) goto L_0x00f5;
    L_0x00f2:
        r3 = r5;
        goto L_0x0036;
    L_0x00f5:
        r3 = r3.l();
        r3 = com.facebook.feedplugins.quickpromotion.QuickPromotionTemplateParameter.PrimaryActionButtonStyle.fromString(r3);
        r4 = com.facebook.feedplugins.quickpromotion.QuickPromotionTemplateParameter.PrimaryActionButtonStyle.UNKNOWN;
        r3 = r3.equals(r4);
        if (r3 == 0) goto L_0x0071;
    L_0x0105:
        r3 = r5;
        goto L_0x0036;
    L_0x0108:
        r3 = r6 + 1;
        r6 = r3;
        goto L_0x0050;
    L_0x010d:
        r3 = r4;
        goto L_0x0036;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.feedplugins.quickpromotion.QuickPromotionFeedUnitPartDefinition.a(java.lang.Object):boolean");
    }

    @Inject
    public QuickPromotionFeedUnitPartDefinition(QuickPromotionHeaderPartDefinition quickPromotionHeaderPartDefinition, QuickPromotionContentStyleSelector quickPromotionContentStyleSelector, Lazy<QuickPromotionSocialContextPartDefinition> lazy, Lazy<QuickPromotionSocialContextComponentPartDefinition> lazy2, QuickPromotionFooterSelector quickPromotionFooterSelector, QuickPromotionVideoAttachmentPartDefinition quickPromotionVideoAttachmentPartDefinition) {
        this.f8870a = quickPromotionFooterSelector;
        this.f8871b = lazy;
        this.f8872c = lazy2;
        this.f8873d = quickPromotionContentStyleSelector;
        this.f8874e = quickPromotionHeaderPartDefinition;
        this.f8875f = quickPromotionVideoAttachmentPartDefinition;
    }

    public static QuickPromotionFeedUnitPartDefinition m9618a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            QuickPromotionFeedUnitPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8869h) {
                QuickPromotionFeedUnitPartDefinition quickPromotionFeedUnitPartDefinition;
                if (a2 != null) {
                    quickPromotionFeedUnitPartDefinition = (QuickPromotionFeedUnitPartDefinition) a2.a(f8869h);
                } else {
                    quickPromotionFeedUnitPartDefinition = f8868g;
                }
                if (quickPromotionFeedUnitPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9619b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8869h, b3);
                        } else {
                            f8868g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = quickPromotionFeedUnitPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
