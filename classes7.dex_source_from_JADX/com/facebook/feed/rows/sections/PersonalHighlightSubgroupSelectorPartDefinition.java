package com.facebook.feed.rows.sections;

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
/* compiled from: ^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8}) */
public class PersonalHighlightSubgroupSelectorPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, FeedEnvironment> {
    private static PersonalHighlightSubgroupSelectorPartDefinition f20383c;
    private static final Object f20384d = new Object();
    private final Lazy<BasicGroupPartDefinition> f20385a;
    private final Lazy<SharedStoryPartDefinition> f20386b;

    private static PersonalHighlightSubgroupSelectorPartDefinition m23507b(InjectorLike injectorLike) {
        return new PersonalHighlightSubgroupSelectorPartDefinition(IdBasedLazy.a(injectorLike, 1510), IdBasedLazy.a(injectorLike, 1502));
    }

    public final Object m23508a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        SubPartsSelector.a(baseMultiRowSubParts, this.f20386b, feedProps).a(this.f20385a, feedProps);
        return null;
    }

    @Inject
    public PersonalHighlightSubgroupSelectorPartDefinition(Lazy<SharedStoryPartDefinition> lazy, Lazy<BasicGroupPartDefinition> lazy2) {
        this.f20385a = lazy2;
        this.f20386b = lazy;
    }

    public final boolean m23509a(Object obj) {
        return true;
    }

    public static PersonalHighlightSubgroupSelectorPartDefinition m23506a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PersonalHighlightSubgroupSelectorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20384d) {
                PersonalHighlightSubgroupSelectorPartDefinition personalHighlightSubgroupSelectorPartDefinition;
                if (a2 != null) {
                    personalHighlightSubgroupSelectorPartDefinition = (PersonalHighlightSubgroupSelectorPartDefinition) a2.a(f20384d);
                } else {
                    personalHighlightSubgroupSelectorPartDefinition = f20383c;
                }
                if (personalHighlightSubgroupSelectorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23507b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20384d, b3);
                        } else {
                            f20383c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = personalHighlightSubgroupSelectorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
