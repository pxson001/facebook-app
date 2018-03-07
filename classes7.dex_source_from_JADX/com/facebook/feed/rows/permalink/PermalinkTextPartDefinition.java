package com.facebook.feed.rows.permalink;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.util.story.FeedStoryUtil;
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
/* compiled from: activity_picker_tapped_back */
public class PermalinkTextPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, FeedEnvironment> {
    private static PermalinkTextPartDefinition f19977d;
    private static final Object f19978e = new Object();
    private final FeedStoryUtil f19979a;
    private final Lazy<DefaultPermalinkTextPartDefinition> f19980b;
    private final Lazy<PermalinkTextComponentPartDefinition<FeedEnvironment>> f19981c;

    private static PermalinkTextPartDefinition m23179b(InjectorLike injectorLike) {
        return new PermalinkTextPartDefinition(FeedStoryUtil.a(injectorLike), IdBasedLazy.a(injectorLike, 5905), IdBasedLazy.a(injectorLike, 5918));
    }

    public final Object m23180a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        SubPartsSelector.a(baseMultiRowSubParts, this.f19981c, feedProps).a(this.f19980b, feedProps);
        return null;
    }

    public final boolean m23181a(Object obj) {
        return FeedStoryUtil.b((GraphQLStory) ((FeedProps) obj).a);
    }

    @Inject
    public PermalinkTextPartDefinition(FeedStoryUtil feedStoryUtil, Lazy<DefaultPermalinkTextPartDefinition> lazy, Lazy<PermalinkTextComponentPartDefinition> lazy2) {
        this.f19979a = feedStoryUtil;
        this.f19980b = lazy;
        this.f19981c = lazy2;
    }

    public static PermalinkTextPartDefinition m23178a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PermalinkTextPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19978e) {
                PermalinkTextPartDefinition permalinkTextPartDefinition;
                if (a2 != null) {
                    permalinkTextPartDefinition = (PermalinkTextPartDefinition) a2.a(f19978e);
                } else {
                    permalinkTextPartDefinition = f19977d;
                }
                if (permalinkTextPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23179b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19978e, b3);
                        } else {
                            f19977d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = permalinkTextPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
