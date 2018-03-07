package com.facebook.feedplugins.quickpromotion;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.base.footer.EmptyFooterPartDefinition;
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
/* compiled from: cc_legal_accepted */
public class QuickPromotionFooterSelector extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLQuickPromotionFeedUnit>, Void, FeedEnvironment> {
    private static QuickPromotionFooterSelector f8877f;
    private static final Object f8878g = new Object();
    private final EmptyFooterPartDefinition f8879a;
    private final QuickPromotionOneButtonWithDrawableFooterPartDefinition f8880b;
    private final QuickPromotionOneButtonFooterPartDefinition f8881c;
    private final QuickPromotionTwoButtonFooterPartDefinition f8882d;
    private final QuickPromotionTwoButtonWithDrawableFooterPartDefinition f8883e;

    private static QuickPromotionFooterSelector m9634b(InjectorLike injectorLike) {
        return new QuickPromotionFooterSelector(QuickPromotionTwoButtonWithDrawableFooterPartDefinition.m9701a(injectorLike), QuickPromotionTwoButtonFooterPartDefinition.m9692a(injectorLike), QuickPromotionOneButtonFooterPartDefinition.m9655a(injectorLike), QuickPromotionOneButtonWithDrawableFooterPartDefinition.m9661a(injectorLike), EmptyFooterPartDefinition.a(injectorLike));
    }

    public final Object m9635a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        GraphQLQuickPromotionFeedUnit graphQLQuickPromotionFeedUnit = (GraphQLQuickPromotionFeedUnit) feedProps.a;
        SubPartsSelector.a(baseMultiRowSubParts, this.f8883e, graphQLQuickPromotionFeedUnit).a(this.f8882d, graphQLQuickPromotionFeedUnit).a(this.f8880b, graphQLQuickPromotionFeedUnit).a(this.f8881c, graphQLQuickPromotionFeedUnit).a(this.f8879a, feedProps);
        return null;
    }

    @Inject
    public QuickPromotionFooterSelector(QuickPromotionTwoButtonWithDrawableFooterPartDefinition quickPromotionTwoButtonWithDrawableFooterPartDefinition, QuickPromotionTwoButtonFooterPartDefinition quickPromotionTwoButtonFooterPartDefinition, QuickPromotionOneButtonFooterPartDefinition quickPromotionOneButtonFooterPartDefinition, QuickPromotionOneButtonWithDrawableFooterPartDefinition quickPromotionOneButtonWithDrawableFooterPartDefinition, EmptyFooterPartDefinition emptyFooterPartDefinition) {
        this.f8879a = emptyFooterPartDefinition;
        this.f8880b = quickPromotionOneButtonWithDrawableFooterPartDefinition;
        this.f8881c = quickPromotionOneButtonFooterPartDefinition;
        this.f8882d = quickPromotionTwoButtonFooterPartDefinition;
        this.f8883e = quickPromotionTwoButtonWithDrawableFooterPartDefinition;
    }

    public final boolean m9636a(Object obj) {
        return true;
    }

    public static QuickPromotionFooterSelector m9633a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            QuickPromotionFooterSelector b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8878g) {
                QuickPromotionFooterSelector quickPromotionFooterSelector;
                if (a2 != null) {
                    quickPromotionFooterSelector = (QuickPromotionFooterSelector) a2.a(f8878g);
                } else {
                    quickPromotionFooterSelector = f8877f;
                }
                if (quickPromotionFooterSelector == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9634b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8878g, b3);
                        } else {
                            f8877f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = quickPromotionFooterSelector;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
