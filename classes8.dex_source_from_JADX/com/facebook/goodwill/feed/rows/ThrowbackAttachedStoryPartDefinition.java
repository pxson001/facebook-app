package com.facebook.goodwill.feed.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.AttachedStorySectionHelper;
import com.facebook.feed.rows.sections.LimitedAttachedStoryPartDefinition;
import com.facebook.feed.rows.sections.header.ExplanationSelectorPartDefinition;
import com.facebook.feed.rows.sections.header.HeaderSelectorPartDefinition;
import com.facebook.feedplugins.attachments.AttachmentsPartDefinition;
import com.facebook.feedplugins.graphqlstory.footer.BlingBarSelectorPartDefinition;
import com.facebook.feedplugins.graphqlstory.translation.SeeTranslationPartDefinition;
import com.facebook.feedplugins.graphqlstory.translation.TranslationOrContentSelectorPartDefinition;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.story.util.GraphQLStoryUtil;
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
/* compiled from: fetchAlbumMediaSet_%s */
public class ThrowbackAttachedStoryPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, FeedEnvironment> {
    private static ThrowbackAttachedStoryPartDefinition f13528i;
    private static final Object f13529j = new Object();
    private final AttachedStorySectionHelper f13530a;
    private final HeaderSelectorPartDefinition f13531b;
    private final ExplanationSelectorPartDefinition f13532c;
    private final TranslationOrContentSelectorPartDefinition f13533d;
    private final SeeTranslationPartDefinition<FeedEnvironment> f13534e;
    private final AttachmentsPartDefinition f13535f;
    private final LimitedAttachedStoryPartDefinition f13536g;
    private final BlingBarSelectorPartDefinition f13537h;

    private static ThrowbackAttachedStoryPartDefinition m15301b(InjectorLike injectorLike) {
        return new ThrowbackAttachedStoryPartDefinition(HeaderSelectorPartDefinition.a(injectorLike), ExplanationSelectorPartDefinition.a(injectorLike), TranslationOrContentSelectorPartDefinition.a(injectorLike), SeeTranslationPartDefinition.a(injectorLike), AttachmentsPartDefinition.a(injectorLike), LimitedAttachedStoryPartDefinition.a(injectorLike), BlingBarSelectorPartDefinition.a(injectorLike), GraphQLStoryUtil.a(injectorLike));
    }

    public final Object m15302a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        FeedProps a = feedProps.a(((GraphQLStory) feedProps.a).L());
        baseMultiRowSubParts.a(this.f13532c, a);
        baseMultiRowSubParts.a(this.f13531b, a);
        baseMultiRowSubParts.a(this.f13533d, a);
        baseMultiRowSubParts.a(this.f13534e, a);
        baseMultiRowSubParts.a(this.f13535f, a);
        baseMultiRowSubParts.a(this.f13536g, a);
        baseMultiRowSubParts.a(this.f13537h, a);
        return null;
    }

    public final boolean m15303a(Object obj) {
        return this.f13530a.a((FeedProps) obj);
    }

    @Inject
    public ThrowbackAttachedStoryPartDefinition(HeaderSelectorPartDefinition headerSelectorPartDefinition, ExplanationSelectorPartDefinition explanationSelectorPartDefinition, TranslationOrContentSelectorPartDefinition translationOrContentSelectorPartDefinition, SeeTranslationPartDefinition seeTranslationPartDefinition, AttachmentsPartDefinition attachmentsPartDefinition, LimitedAttachedStoryPartDefinition limitedAttachedStoryPartDefinition, BlingBarSelectorPartDefinition blingBarSelectorPartDefinition, GraphQLStoryUtil graphQLStoryUtil) {
        this.f13531b = headerSelectorPartDefinition;
        this.f13532c = explanationSelectorPartDefinition;
        this.f13533d = translationOrContentSelectorPartDefinition;
        this.f13534e = seeTranslationPartDefinition;
        this.f13535f = attachmentsPartDefinition;
        this.f13536g = limitedAttachedStoryPartDefinition;
        this.f13537h = blingBarSelectorPartDefinition;
        this.f13530a = new AttachedStorySectionHelper(graphQLStoryUtil);
    }

    public static ThrowbackAttachedStoryPartDefinition m15300a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ThrowbackAttachedStoryPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f13529j) {
                ThrowbackAttachedStoryPartDefinition throwbackAttachedStoryPartDefinition;
                if (a2 != null) {
                    throwbackAttachedStoryPartDefinition = (ThrowbackAttachedStoryPartDefinition) a2.a(f13529j);
                } else {
                    throwbackAttachedStoryPartDefinition = f13528i;
                }
                if (throwbackAttachedStoryPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m15301b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f13529j, b3);
                        } else {
                            f13528i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = throwbackAttachedStoryPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
