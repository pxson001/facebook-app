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
/* compiled from: goodwill_campaign_viewed_preview */
public class ThrowbackHeaderSelectorPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLGoodwillThrowbackPromotionFeedUnit>, Void, FeedEnvironment> {
    private static ThrowbackHeaderSelectorPartDefinition f12437d;
    private static final Object f12438e = new Object();
    private final ThrowbackUnifiedHeaderPartDefinition f12439a;
    private final DailyDialogueBrandedHeaderPartDefinition f12440b;
    private final ThrowbackUnifiedInProductBrandingHeaderPartDefinition f12441c;

    private static ThrowbackHeaderSelectorPartDefinition m14339b(InjectorLike injectorLike) {
        return new ThrowbackHeaderSelectorPartDefinition(ThrowbackUnifiedHeaderPartDefinition.m14424a(injectorLike), DailyDialogueBrandedHeaderPartDefinition.m14166a(injectorLike), ThrowbackUnifiedInProductBrandingHeaderPartDefinition.m14432a(injectorLike));
    }

    public final Object m14340a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        SubPartsSelector.a(baseMultiRowSubParts, this.f12440b, feedProps).a(this.f12441c, feedProps).a(this.f12439a, feedProps);
        return null;
    }

    @Inject
    public ThrowbackHeaderSelectorPartDefinition(ThrowbackUnifiedHeaderPartDefinition throwbackUnifiedHeaderPartDefinition, DailyDialogueBrandedHeaderPartDefinition dailyDialogueBrandedHeaderPartDefinition, ThrowbackUnifiedInProductBrandingHeaderPartDefinition throwbackUnifiedInProductBrandingHeaderPartDefinition) {
        this.f12439a = throwbackUnifiedHeaderPartDefinition;
        this.f12440b = dailyDialogueBrandedHeaderPartDefinition;
        this.f12441c = throwbackUnifiedInProductBrandingHeaderPartDefinition;
    }

    public final boolean m14341a(Object obj) {
        return true;
    }

    public static ThrowbackHeaderSelectorPartDefinition m14338a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThrowbackHeaderSelectorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12438e) {
                ThrowbackHeaderSelectorPartDefinition throwbackHeaderSelectorPartDefinition;
                if (a2 != null) {
                    throwbackHeaderSelectorPartDefinition = (ThrowbackHeaderSelectorPartDefinition) a2.a(f12438e);
                } else {
                    throwbackHeaderSelectorPartDefinition = f12437d;
                }
                if (throwbackHeaderSelectorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14339b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12438e, b3);
                        } else {
                            f12437d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = throwbackHeaderSelectorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
