package com.facebook.goodwill.feed.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.header.ExplanationSelectorPartDefinition;
import com.facebook.feed.rows.sections.header.HeaderSelectorPartDefinition;
import com.facebook.feedplugins.attachments.AttachmentsPartDefinition;
import com.facebook.feedplugins.goodwill.throwback.ThrowbackFeedFooterPartDefinition;
import com.facebook.feedplugins.graphqlstory.footer.BlingBarSelectorPartDefinition;
import com.facebook.feedplugins.graphqlstory.translation.SeeTranslationPartDefinition;
import com.facebook.feedplugins.graphqlstory.translation.TranslationOrContentSelectorPartDefinition;
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
/* compiled from: fetchGroups */
public class BasicThrowbackFeedStoryGroupPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, FeedEnvironment> {
    private static BasicThrowbackFeedStoryGroupPartDefinition f13495h;
    private static final Object f13496i = new Object();
    private final ThrowbackFeedFooterPartDefinition f13497a;
    private final BlingBarSelectorPartDefinition f13498b;
    private final AttachmentsPartDefinition f13499c;
    private final SeeTranslationPartDefinition<FeedEnvironment> f13500d;
    private final TranslationOrContentSelectorPartDefinition f13501e;
    private final HeaderSelectorPartDefinition f13502f;
    private final ExplanationSelectorPartDefinition f13503g;

    private static BasicThrowbackFeedStoryGroupPartDefinition m15279b(InjectorLike injectorLike) {
        return new BasicThrowbackFeedStoryGroupPartDefinition(ExplanationSelectorPartDefinition.a(injectorLike), HeaderSelectorPartDefinition.a(injectorLike), TranslationOrContentSelectorPartDefinition.a(injectorLike), SeeTranslationPartDefinition.a(injectorLike), AttachmentsPartDefinition.a(injectorLike), BlingBarSelectorPartDefinition.a(injectorLike), ThrowbackFeedFooterPartDefinition.a(injectorLike));
    }

    public final Object m15280a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        baseMultiRowSubParts.a(this.f13503g, feedProps);
        baseMultiRowSubParts.a(this.f13502f, feedProps);
        baseMultiRowSubParts.a(this.f13501e, feedProps);
        baseMultiRowSubParts.a(this.f13500d, feedProps);
        baseMultiRowSubParts.a(this.f13499c, feedProps);
        baseMultiRowSubParts.a(this.f13498b, feedProps);
        baseMultiRowSubParts.a(this.f13497a, feedProps);
        return null;
    }

    @Inject
    public BasicThrowbackFeedStoryGroupPartDefinition(ExplanationSelectorPartDefinition explanationSelectorPartDefinition, HeaderSelectorPartDefinition headerSelectorPartDefinition, TranslationOrContentSelectorPartDefinition translationOrContentSelectorPartDefinition, SeeTranslationPartDefinition seeTranslationPartDefinition, AttachmentsPartDefinition attachmentsPartDefinition, BlingBarSelectorPartDefinition blingBarSelectorPartDefinition, ThrowbackFeedFooterPartDefinition throwbackFeedFooterPartDefinition) {
        this.f13497a = throwbackFeedFooterPartDefinition;
        this.f13498b = blingBarSelectorPartDefinition;
        this.f13499c = attachmentsPartDefinition;
        this.f13500d = seeTranslationPartDefinition;
        this.f13501e = translationOrContentSelectorPartDefinition;
        this.f13502f = headerSelectorPartDefinition;
        this.f13503g = explanationSelectorPartDefinition;
    }

    public final boolean m15281a(Object obj) {
        return true;
    }

    public static BasicThrowbackFeedStoryGroupPartDefinition m15278a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            BasicThrowbackFeedStoryGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f13496i) {
                BasicThrowbackFeedStoryGroupPartDefinition basicThrowbackFeedStoryGroupPartDefinition;
                if (a2 != null) {
                    basicThrowbackFeedStoryGroupPartDefinition = (BasicThrowbackFeedStoryGroupPartDefinition) a2.a(f13496i);
                } else {
                    basicThrowbackFeedStoryGroupPartDefinition = f13495h;
                }
                if (basicThrowbackFeedStoryGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m15279b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f13496i, b3);
                        } else {
                            f13495h = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = basicThrowbackFeedStoryGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
