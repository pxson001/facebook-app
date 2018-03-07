package com.facebook.search.results.rows.sections.pulse;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.TextOrTranslationSelectorPartDefinition;
import com.facebook.feed.rows.sections.header.DefaultHeaderSelectorPartDefinition;
import com.facebook.feed.rows.sections.header.ExplanationSelectorPartDefinition;
import com.facebook.feedplugins.graphqlstory.footer.BlingBarSelectorPartDefinition;
import com.facebook.feedplugins.graphqlstory.footer.TopLevelFooterPartSelector;
import com.facebook.feedplugins.graphqlstory.inlinecomments.FeedCommentsPartDefinition;
import com.facebook.feedplugins.graphqlstory.inlinecomments.InlineCommentComposerPartDefinition;
import com.facebook.feedplugins.graphqlstory.translation.SeeTranslationPartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.search.results.environment.SearchResultsFeedEnvironment;
import com.facebook.search.results.model.unit.SearchResultsPulseStoryUnit;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PRE_INSTALLED_FONT_SERIF_ITALIC */
public class PulseStoriesGroupPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<SearchResultsPulseStoryUnit>, Void, SearchResultsFeedEnvironment> {
    private static PulseStoriesGroupPartDefinition f24921i;
    private static final Object f24922j = new Object();
    private final InlineCommentComposerPartDefinition<SearchResultsFeedEnvironment> f24923a;
    private final FeedCommentsPartDefinition<SearchResultsFeedEnvironment> f24924b;
    private final TopLevelFooterPartSelector f24925c;
    private final BlingBarSelectorPartDefinition f24926d;
    private final SeeTranslationPartDefinition<SearchResultsFeedEnvironment> f24927e;
    private final TextOrTranslationSelectorPartDefinition f24928f;
    private final DefaultHeaderSelectorPartDefinition f24929g;
    private final ExplanationSelectorPartDefinition f24930h;

    private static PulseStoriesGroupPartDefinition m28283b(InjectorLike injectorLike) {
        return new PulseStoriesGroupPartDefinition(ExplanationSelectorPartDefinition.a(injectorLike), DefaultHeaderSelectorPartDefinition.a(injectorLike), TextOrTranslationSelectorPartDefinition.a(injectorLike), SeeTranslationPartDefinition.a(injectorLike), BlingBarSelectorPartDefinition.a(injectorLike), TopLevelFooterPartSelector.a(injectorLike), FeedCommentsPartDefinition.a(injectorLike), InlineCommentComposerPartDefinition.a(injectorLike));
    }

    public final Object m28284a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        FeedProps a = feedProps.a(((SearchResultsPulseStoryUnit) feedProps.a).mo1333f());
        baseMultiRowSubParts.a(this.f24930h, a);
        baseMultiRowSubParts.a(this.f24929g, a);
        baseMultiRowSubParts.a(this.f24928f, a);
        baseMultiRowSubParts.a(this.f24927e, a);
        baseMultiRowSubParts.a(this.f24926d, a);
        baseMultiRowSubParts.a(this.f24925c, a);
        baseMultiRowSubParts.a(this.f24924b, a);
        baseMultiRowSubParts.a(this.f24923a, a);
        return null;
    }

    @Inject
    public PulseStoriesGroupPartDefinition(ExplanationSelectorPartDefinition explanationSelectorPartDefinition, DefaultHeaderSelectorPartDefinition defaultHeaderSelectorPartDefinition, TextOrTranslationSelectorPartDefinition textOrTranslationSelectorPartDefinition, SeeTranslationPartDefinition seeTranslationPartDefinition, BlingBarSelectorPartDefinition blingBarSelectorPartDefinition, TopLevelFooterPartSelector topLevelFooterPartSelector, FeedCommentsPartDefinition feedCommentsPartDefinition, InlineCommentComposerPartDefinition inlineCommentComposerPartDefinition) {
        this.f24923a = inlineCommentComposerPartDefinition;
        this.f24924b = feedCommentsPartDefinition;
        this.f24925c = topLevelFooterPartSelector;
        this.f24926d = blingBarSelectorPartDefinition;
        this.f24927e = seeTranslationPartDefinition;
        this.f24928f = textOrTranslationSelectorPartDefinition;
        this.f24929g = defaultHeaderSelectorPartDefinition;
        this.f24930h = explanationSelectorPartDefinition;
    }

    public static PulseStoriesGroupPartDefinition m28282a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PulseStoriesGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24922j) {
                PulseStoriesGroupPartDefinition pulseStoriesGroupPartDefinition;
                if (a2 != null) {
                    pulseStoriesGroupPartDefinition = (PulseStoriesGroupPartDefinition) a2.a(f24922j);
                } else {
                    pulseStoriesGroupPartDefinition = f24921i;
                }
                if (pulseStoriesGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28283b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24922j, b3);
                        } else {
                            f24921i = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pulseStoriesGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final boolean m28285a(Object obj) {
        return true;
    }
}
