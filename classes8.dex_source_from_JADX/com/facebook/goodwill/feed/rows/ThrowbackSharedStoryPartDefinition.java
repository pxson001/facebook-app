package com.facebook.goodwill.feed.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.header.ExplanationSelectorPartDefinition;
import com.facebook.feed.rows.sections.header.HeaderSelectorPartDefinition;
import com.facebook.feed.rows.sections.text.ContentTextPartDefinition;
import com.facebook.feedplugins.attachments.AttachmentsPartDefinition;
import com.facebook.feedplugins.goodwill.throwback.ThrowbackFeedFooterPartDefinition;
import com.facebook.feedplugins.graphqlstory.footer.BlingBarSelectorPartDefinition;
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
/* compiled from: favorite_page */
public class ThrowbackSharedStoryPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, FeedEnvironment> {
    private static ThrowbackSharedStoryPartDefinition f13797h;
    private static final Object f13798i = new Object();
    private final ThrowbackFeedFooterPartDefinition f13799a;
    private final BlingBarSelectorPartDefinition f13800b;
    private final ThrowbackAttachedStoryPartDefinition f13801c;
    private final AttachmentsPartDefinition f13802d;
    private final ContentTextPartDefinition f13803e;
    private final HeaderSelectorPartDefinition f13804f;
    private final ExplanationSelectorPartDefinition f13805g;

    private static ThrowbackSharedStoryPartDefinition m15451b(InjectorLike injectorLike) {
        return new ThrowbackSharedStoryPartDefinition(ExplanationSelectorPartDefinition.a(injectorLike), HeaderSelectorPartDefinition.a(injectorLike), ContentTextPartDefinition.a(injectorLike), AttachmentsPartDefinition.a(injectorLike), ThrowbackAttachedStoryPartDefinition.m15300a(injectorLike), BlingBarSelectorPartDefinition.a(injectorLike), ThrowbackFeedFooterPartDefinition.a(injectorLike));
    }

    public final Object m15452a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        baseMultiRowSubParts.a(this.f13805g, feedProps);
        baseMultiRowSubParts.a(this.f13804f, feedProps);
        baseMultiRowSubParts.a(this.f13803e, feedProps);
        baseMultiRowSubParts.a(this.f13802d, feedProps);
        baseMultiRowSubParts.a(this.f13801c, feedProps);
        baseMultiRowSubParts.a(this.f13800b, feedProps);
        baseMultiRowSubParts.a(this.f13799a, feedProps);
        return null;
    }

    public final boolean m15453a(Object obj) {
        GraphQLStory graphQLStory = (GraphQLStory) ((FeedProps) obj).a;
        return graphQLStory.L() != null && graphQLStory.aD() == 0;
    }

    @Inject
    public ThrowbackSharedStoryPartDefinition(ExplanationSelectorPartDefinition explanationSelectorPartDefinition, HeaderSelectorPartDefinition headerSelectorPartDefinition, ContentTextPartDefinition contentTextPartDefinition, AttachmentsPartDefinition attachmentsPartDefinition, ThrowbackAttachedStoryPartDefinition throwbackAttachedStoryPartDefinition, BlingBarSelectorPartDefinition blingBarSelectorPartDefinition, ThrowbackFeedFooterPartDefinition throwbackFeedFooterPartDefinition) {
        this.f13799a = throwbackFeedFooterPartDefinition;
        this.f13800b = blingBarSelectorPartDefinition;
        this.f13801c = throwbackAttachedStoryPartDefinition;
        this.f13802d = attachmentsPartDefinition;
        this.f13803e = contentTextPartDefinition;
        this.f13804f = headerSelectorPartDefinition;
        this.f13805g = explanationSelectorPartDefinition;
    }

    public static ThrowbackSharedStoryPartDefinition m15450a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThrowbackSharedStoryPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f13798i) {
                ThrowbackSharedStoryPartDefinition throwbackSharedStoryPartDefinition;
                if (a2 != null) {
                    throwbackSharedStoryPartDefinition = (ThrowbackSharedStoryPartDefinition) a2.a(f13798i);
                } else {
                    throwbackSharedStoryPartDefinition = f13797h;
                }
                if (throwbackSharedStoryPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m15451b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f13798i, b3);
                        } else {
                            f13797h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = throwbackSharedStoryPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
