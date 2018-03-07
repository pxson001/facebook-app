package com.facebook.feed.rows.permalink;

import android.content.Context;
import com.facebook.api.feed.data.FeedUnitDataController;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.StoryPostFooterSelectorPartDefinition;
import com.facebook.graphql.model.FeedUnit;
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
import com.facebook.permalink.rows.LikesDescriptionPartDefinition;
import com.facebook.permalink.rows.PermalinkTopLevelFooterPartSelector;
import javax.inject.Inject;

@ContextScoped
/* compiled from: add_photo_tag */
public class PermalinkFooterGroupPartSelector extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, FeedEnvironment> {
    private static PermalinkFooterGroupPartSelector f19901f;
    private static final Object f19902g = new Object();
    private final PermalinkTopLevelFooterPartSelector f19903a;
    private final LikesDescriptionPartDefinition f19904b;
    private final ShareCountPartDefinition f19905c;
    private final StoryPostFooterSelectorPartDefinition f19906d;
    private final FeedUnitDataController f19907e;

    private static PermalinkFooterGroupPartSelector m23120b(InjectorLike injectorLike) {
        return new PermalinkFooterGroupPartSelector(PermalinkTopLevelFooterPartSelector.a(injectorLike), LikesDescriptionPartDefinition.a(injectorLike), ShareCountPartDefinition.m23187a(injectorLike), StoryPostFooterSelectorPartDefinition.a(injectorLike), FeedUnitDataController.a(injectorLike));
    }

    public final Object m23121a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        if (this.f19907e.a((FeedUnit) feedProps.a).s) {
            baseMultiRowSubParts.a(this.f19904b, feedProps);
            baseMultiRowSubParts.a(this.f19905c, feedProps);
            baseMultiRowSubParts.a(this.f19903a, feedProps);
            baseMultiRowSubParts.a(this.f19906d, feedProps);
        } else {
            baseMultiRowSubParts.a(this.f19905c, feedProps);
            baseMultiRowSubParts.a(this.f19903a, feedProps);
            baseMultiRowSubParts.a(this.f19906d, feedProps);
            baseMultiRowSubParts.a(this.f19904b, feedProps);
        }
        return null;
    }

    @Inject
    public PermalinkFooterGroupPartSelector(PermalinkTopLevelFooterPartSelector permalinkTopLevelFooterPartSelector, LikesDescriptionPartDefinition likesDescriptionPartDefinition, ShareCountPartDefinition shareCountPartDefinition, StoryPostFooterSelectorPartDefinition storyPostFooterSelectorPartDefinition, FeedUnitDataController feedUnitDataController) {
        this.f19903a = permalinkTopLevelFooterPartSelector;
        this.f19904b = likesDescriptionPartDefinition;
        this.f19905c = shareCountPartDefinition;
        this.f19906d = storyPostFooterSelectorPartDefinition;
        this.f19907e = feedUnitDataController;
    }

    public final boolean m23122a(Object obj) {
        return true;
    }

    public static PermalinkFooterGroupPartSelector m23119a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PermalinkFooterGroupPartSelector b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19902g) {
                PermalinkFooterGroupPartSelector permalinkFooterGroupPartSelector;
                if (a2 != null) {
                    permalinkFooterGroupPartSelector = (PermalinkFooterGroupPartSelector) a2.a(f19902g);
                } else {
                    permalinkFooterGroupPartSelector = f19901f;
                }
                if (permalinkFooterGroupPartSelector == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23120b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19902g, b3);
                        } else {
                            f19901f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = permalinkFooterGroupPartSelector;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
