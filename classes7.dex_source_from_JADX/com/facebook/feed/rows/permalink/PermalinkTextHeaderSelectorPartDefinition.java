package com.facebook.feed.rows.permalink;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;
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
/* compiled from: activity_picker_tapped_cancel */
public class PermalinkTextHeaderSelectorPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, FeedEnvironment> {
    private static PermalinkTextHeaderSelectorPartDefinition f19973c;
    private static final Object f19974d = new Object();
    private final Lazy<PermalinkTextHeaderPartDefinition<FeedEnvironment>> f19975a;
    private final Lazy<PermalinkSeeFirstTextHeaderPartDefinition<FeedEnvironment>> f19976b;

    private static PermalinkTextHeaderSelectorPartDefinition m23175b(InjectorLike injectorLike) {
        return new PermalinkTextHeaderSelectorPartDefinition(IdBasedLazy.a(injectorLike, 5919), IdBasedLazy.a(injectorLike, 5914));
    }

    public final Object m23176a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        SubPartsSelector.a(baseMultiRowSubParts, this.f19976b, feedProps).a(this.f19975a, feedProps);
        return null;
    }

    @Inject
    public PermalinkTextHeaderSelectorPartDefinition(Lazy<PermalinkTextHeaderPartDefinition> lazy, Lazy<PermalinkSeeFirstTextHeaderPartDefinition> lazy2) {
        this.f19975a = lazy;
        this.f19976b = lazy2;
    }

    public final boolean m23177a(Object obj) {
        return true;
    }

    public static PermalinkTextHeaderSelectorPartDefinition m23174a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PermalinkTextHeaderSelectorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19974d) {
                PermalinkTextHeaderSelectorPartDefinition permalinkTextHeaderSelectorPartDefinition;
                if (a2 != null) {
                    permalinkTextHeaderSelectorPartDefinition = (PermalinkTextHeaderSelectorPartDefinition) a2.a(f19974d);
                } else {
                    permalinkTextHeaderSelectorPartDefinition = f19973c;
                }
                if (permalinkTextHeaderSelectorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23175b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19974d, b3);
                        } else {
                            f19973c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = permalinkTextHeaderSelectorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
