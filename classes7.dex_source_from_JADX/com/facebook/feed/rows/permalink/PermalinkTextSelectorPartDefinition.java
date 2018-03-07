package com.facebook.feed.rows.permalink;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.graphqlstory.translation.AutoTranslateSelectorPartDefinition;
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
/* compiled from: activity_picker_suggestion_tapped */
public class PermalinkTextSelectorPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, FeedEnvironment> {
    private static PermalinkTextSelectorPartDefinition f19982c;
    private static final Object f19983d = new Object();
    private final Lazy<PermalinkTextPartDefinition> f19984a;
    private final Lazy<AutoTranslateSelectorPartDefinition<FeedEnvironment>> f19985b;

    private static PermalinkTextSelectorPartDefinition m23183b(InjectorLike injectorLike) {
        return new PermalinkTextSelectorPartDefinition(IdBasedLazy.a(injectorLike, 1896), IdBasedLazy.a(injectorLike, 5921));
    }

    public final Object m23184a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        SubPartsSelector.a(baseMultiRowSubParts, this.f19985b, feedProps).a(this.f19984a, feedProps);
        return null;
    }

    @Inject
    public PermalinkTextSelectorPartDefinition(Lazy<AutoTranslateSelectorPartDefinition> lazy, Lazy<PermalinkTextPartDefinition> lazy2) {
        this.f19984a = lazy2;
        this.f19985b = lazy;
    }

    public final boolean m23185a(Object obj) {
        return true;
    }

    public static PermalinkTextSelectorPartDefinition m23182a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PermalinkTextSelectorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19983d) {
                PermalinkTextSelectorPartDefinition permalinkTextSelectorPartDefinition;
                if (a2 != null) {
                    permalinkTextSelectorPartDefinition = (PermalinkTextSelectorPartDefinition) a2.a(f19983d);
                } else {
                    permalinkTextSelectorPartDefinition = f19982c;
                }
                if (permalinkTextSelectorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23183b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19983d, b3);
                        } else {
                            f19982c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = permalinkTextSelectorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
