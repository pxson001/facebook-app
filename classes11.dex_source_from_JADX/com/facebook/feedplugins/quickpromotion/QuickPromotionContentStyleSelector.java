package com.facebook.feedplugins.quickpromotion;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLQuickPromotionFeedUnit;
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
/* compiled from: chained_story_item_click */
public class QuickPromotionContentStyleSelector extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLQuickPromotionFeedUnit>, Void, FeedEnvironment> {
    private static QuickPromotionContentStyleSelector f8854d;
    private static final Object f8855e = new Object();
    private final QuickPromotionLargeImageCreativeContentPartDefinition f8856a;
    private final QuickPromotionCreativeContentPartDefinition f8857b;
    private final QuickPromotionBrandedVideoCreativeContentPartDefinition f8858c;

    private static QuickPromotionContentStyleSelector m9602b(InjectorLike injectorLike) {
        return new QuickPromotionContentStyleSelector(QuickPromotionCreativeContentPartDefinition.m9609a(injectorLike), QuickPromotionLargeImageCreativeContentPartDefinition.m9647a(injectorLike), QuickPromotionBrandedVideoCreativeContentPartDefinition.m9594a(injectorLike));
    }

    public final Object m9603a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        SubPartsSelector.a(baseMultiRowSubParts, this.f8858c, feedProps).a(this.f8856a, feedProps).a(this.f8857b, feedProps);
        return null;
    }

    @Inject
    public QuickPromotionContentStyleSelector(QuickPromotionCreativeContentPartDefinition quickPromotionCreativeContentPartDefinition, QuickPromotionLargeImageCreativeContentPartDefinition quickPromotionLargeImageCreativeContentPartDefinition, QuickPromotionBrandedVideoCreativeContentPartDefinition quickPromotionBrandedVideoCreativeContentPartDefinition) {
        this.f8858c = quickPromotionBrandedVideoCreativeContentPartDefinition;
        this.f8856a = quickPromotionLargeImageCreativeContentPartDefinition;
        this.f8857b = quickPromotionCreativeContentPartDefinition;
    }

    public final boolean m9604a(Object obj) {
        return true;
    }

    public static QuickPromotionContentStyleSelector m9601a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            QuickPromotionContentStyleSelector b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8855e) {
                QuickPromotionContentStyleSelector quickPromotionContentStyleSelector;
                if (a2 != null) {
                    quickPromotionContentStyleSelector = (QuickPromotionContentStyleSelector) a2.a(f8855e);
                } else {
                    quickPromotionContentStyleSelector = f8854d;
                }
                if (quickPromotionContentStyleSelector == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9602b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8855e, b3);
                        } else {
                            f8854d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = quickPromotionContentStyleSelector;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
