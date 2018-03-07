package com.facebook.feedplugins.goodwill;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.goodwill.components.ThrowbackPromotedStoryHeaderComponentPartDefinition;
import com.facebook.graphql.model.GraphQLStory;
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
/* compiled from: goodwillLifeEventsPost */
public class ThrowbackPromotedStoryHeaderPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, FeedEnvironment> {
    private static ThrowbackPromotedStoryHeaderPartDefinition f12489c;
    private static final Object f12490d = new Object();
    private final DefaultThrowbackPromotedStoryHeaderPartDefinition<FeedEnvironment> f12491a;
    private final ThrowbackPromotedStoryHeaderComponentPartDefinition<FeedEnvironment> f12492b;

    private static ThrowbackPromotedStoryHeaderPartDefinition m14381b(InjectorLike injectorLike) {
        return new ThrowbackPromotedStoryHeaderPartDefinition(DefaultThrowbackPromotedStoryHeaderPartDefinition.m14179a(injectorLike), ThrowbackPromotedStoryHeaderComponentPartDefinition.m14485a(injectorLike));
    }

    public final Object m14382a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        SubPartsSelector.a(baseMultiRowSubParts, this.f12492b, feedProps).a(this.f12491a, feedProps);
        return null;
    }

    @Inject
    public ThrowbackPromotedStoryHeaderPartDefinition(DefaultThrowbackPromotedStoryHeaderPartDefinition defaultThrowbackPromotedStoryHeaderPartDefinition, ThrowbackPromotedStoryHeaderComponentPartDefinition throwbackPromotedStoryHeaderComponentPartDefinition) {
        this.f12491a = defaultThrowbackPromotedStoryHeaderPartDefinition;
        this.f12492b = throwbackPromotedStoryHeaderComponentPartDefinition;
    }

    public final boolean m14383a(Object obj) {
        return true;
    }

    public static ThrowbackPromotedStoryHeaderPartDefinition m14380a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThrowbackPromotedStoryHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12490d) {
                ThrowbackPromotedStoryHeaderPartDefinition throwbackPromotedStoryHeaderPartDefinition;
                if (a2 != null) {
                    throwbackPromotedStoryHeaderPartDefinition = (ThrowbackPromotedStoryHeaderPartDefinition) a2.a(f12490d);
                } else {
                    throwbackPromotedStoryHeaderPartDefinition = f12489c;
                }
                if (throwbackPromotedStoryHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14381b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12490d, b3);
                        } else {
                            f12489c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = throwbackPromotedStoryHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
