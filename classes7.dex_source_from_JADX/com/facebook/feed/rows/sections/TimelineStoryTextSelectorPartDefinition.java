package com.facebook.feed.rows.sections;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.text.ContentTextLayoutClickablePartDefinition;
import com.facebook.feed.rows.sections.text.InstantArticleTextComponentPartDefinition;
import com.facebook.feed.rows.sections.text.InstantArticleTextLayoutClickablePartDefinition;
import com.facebook.feed.rows.sections.text.VariableTextSizeClickablePartDefinition;
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
/* compiled from: [createLinkStoryAttachmentFromComposerShareParams] linkForShare empty */
public class TimelineStoryTextSelectorPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, FeedEnvironment> {
    private static TimelineStoryTextSelectorPartDefinition f20472f;
    private static final Object f20473g = new Object();
    private final Lazy<ContentTextLayoutClickablePartDefinition> f20474a;
    private final Lazy<AutoTranslateSelectorPartDefinition<FeedEnvironment>> f20475b;
    private final Lazy<InstantArticleTextLayoutClickablePartDefinition> f20476c;
    private final Lazy<InstantArticleTextComponentPartDefinition<FeedEnvironment>> f20477d;
    private final Lazy<VariableTextSizeClickablePartDefinition> f20478e;

    private static TimelineStoryTextSelectorPartDefinition m23562b(InjectorLike injectorLike) {
        return new TimelineStoryTextSelectorPartDefinition(IdBasedLazy.a(injectorLike, 1896), IdBasedLazy.a(injectorLike, 1684), IdBasedLazy.a(injectorLike, 1693), IdBasedLazy.a(injectorLike, 1691), IdBasedLazy.a(injectorLike, 1698));
    }

    public final Object m23563a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        SubPartsSelector.a(baseMultiRowSubParts, this.f20475b, feedProps).a(this.f20477d, feedProps).a(this.f20476c, feedProps).a(this.f20478e, feedProps).a(this.f20474a, feedProps);
        return null;
    }

    @Inject
    public TimelineStoryTextSelectorPartDefinition(Lazy<AutoTranslateSelectorPartDefinition> lazy, Lazy<ContentTextLayoutClickablePartDefinition> lazy2, Lazy<InstantArticleTextLayoutClickablePartDefinition> lazy3, Lazy<InstantArticleTextComponentPartDefinition> lazy4, Lazy<VariableTextSizeClickablePartDefinition> lazy5) {
        this.f20474a = lazy2;
        this.f20475b = lazy;
        this.f20476c = lazy3;
        this.f20477d = lazy4;
        this.f20478e = lazy5;
    }

    public final boolean m23564a(Object obj) {
        return true;
    }

    public static TimelineStoryTextSelectorPartDefinition m23561a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TimelineStoryTextSelectorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20473g) {
                TimelineStoryTextSelectorPartDefinition timelineStoryTextSelectorPartDefinition;
                if (a2 != null) {
                    timelineStoryTextSelectorPartDefinition = (TimelineStoryTextSelectorPartDefinition) a2.a(f20473g);
                } else {
                    timelineStoryTextSelectorPartDefinition = f20472f;
                }
                if (timelineStoryTextSelectorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23562b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20473g, b3);
                        } else {
                            f20472f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = timelineStoryTextSelectorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
