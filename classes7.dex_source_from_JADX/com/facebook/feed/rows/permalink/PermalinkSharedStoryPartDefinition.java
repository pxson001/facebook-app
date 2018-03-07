package com.facebook.feed.rows.permalink;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.header.DefaultHeaderSelectorPartDefinition;
import com.facebook.feed.rows.sections.header.ExplanationSelectorPartDefinition;
import com.facebook.feedplugins.attachments.AttachmentsPartDefinition;
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
import com.facebook.permalink.rows.SeenByPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ad id is null */
public class PermalinkSharedStoryPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, FeedEnvironment> {
    private static PermalinkSharedStoryPartDefinition f19939i;
    private static final Object f19940j = new Object();
    private final PermalinkTopLevelFooterPartSelector f19941a;
    private final SeenByPartDefinition f19942b;
    private final LikesDescriptionPartDefinition f19943c;
    private final PermalinkAttachedStoryPartDefinition f19944d;
    private final AttachmentsPartDefinition f19945e;
    private final PermalinkTextPartDefinition f19946f;
    private final DefaultHeaderSelectorPartDefinition f19947g;
    private final ExplanationSelectorPartDefinition f19948h;

    private static PermalinkSharedStoryPartDefinition m23146b(InjectorLike injectorLike) {
        return new PermalinkSharedStoryPartDefinition(ExplanationSelectorPartDefinition.a(injectorLike), DefaultHeaderSelectorPartDefinition.a(injectorLike), PermalinkTextPartDefinition.m23178a(injectorLike), AttachmentsPartDefinition.a(injectorLike), PermalinkAttachedStoryPartDefinition.m23106a(injectorLike), LikesDescriptionPartDefinition.a(injectorLike), SeenByPartDefinition.a(injectorLike), PermalinkTopLevelFooterPartSelector.a(injectorLike));
    }

    public final Object m23147a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        baseMultiRowSubParts.a(this.f19948h, feedProps);
        baseMultiRowSubParts.a(this.f19947g, feedProps);
        baseMultiRowSubParts.a(this.f19946f, feedProps);
        baseMultiRowSubParts.a(this.f19945e, feedProps);
        baseMultiRowSubParts.a(this.f19944d, feedProps);
        baseMultiRowSubParts.a(this.f19941a, feedProps);
        baseMultiRowSubParts.a(this.f19943c, feedProps);
        baseMultiRowSubParts.a(this.f19942b, feedProps);
        return null;
    }

    public final boolean m23148a(Object obj) {
        GraphQLStory graphQLStory = (GraphQLStory) ((FeedProps) obj).a;
        return graphQLStory.L() != null && graphQLStory.aD() == 0;
    }

    @Inject
    public PermalinkSharedStoryPartDefinition(ExplanationSelectorPartDefinition explanationSelectorPartDefinition, DefaultHeaderSelectorPartDefinition defaultHeaderSelectorPartDefinition, PermalinkTextPartDefinition permalinkTextPartDefinition, AttachmentsPartDefinition attachmentsPartDefinition, PermalinkAttachedStoryPartDefinition permalinkAttachedStoryPartDefinition, LikesDescriptionPartDefinition likesDescriptionPartDefinition, SeenByPartDefinition seenByPartDefinition, PermalinkTopLevelFooterPartSelector permalinkTopLevelFooterPartSelector) {
        this.f19941a = permalinkTopLevelFooterPartSelector;
        this.f19942b = seenByPartDefinition;
        this.f19943c = likesDescriptionPartDefinition;
        this.f19944d = permalinkAttachedStoryPartDefinition;
        this.f19945e = attachmentsPartDefinition;
        this.f19946f = permalinkTextPartDefinition;
        this.f19947g = defaultHeaderSelectorPartDefinition;
        this.f19948h = explanationSelectorPartDefinition;
    }

    public static PermalinkSharedStoryPartDefinition m23145a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PermalinkSharedStoryPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19940j) {
                PermalinkSharedStoryPartDefinition permalinkSharedStoryPartDefinition;
                if (a2 != null) {
                    permalinkSharedStoryPartDefinition = (PermalinkSharedStoryPartDefinition) a2.a(f19940j);
                } else {
                    permalinkSharedStoryPartDefinition = f19939i;
                }
                if (permalinkSharedStoryPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23146b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19940j, b3);
                        } else {
                            f19939i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = permalinkSharedStoryPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
