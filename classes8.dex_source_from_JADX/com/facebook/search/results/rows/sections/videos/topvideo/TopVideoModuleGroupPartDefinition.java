package com.facebook.search.results.rows.sections.videos.topvideo;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.header.HeaderSelectorPartDefinition;
import com.facebook.feedplugins.graphqlstory.footer.BlingBarSelectorPartDefinition;
import com.facebook.feedplugins.graphqlstory.footer.TopLevelFooterPartSelector;
import com.facebook.feedplugins.graphqlstory.translation.SeeTranslationPartDefinition;
import com.facebook.feedplugins.graphqlstory.translation.TranslationOrContentSelectorPartDefinition;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.graphql.model.StoryAttachmentHelper;
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
import com.facebook.search.results.model.unit.SearchResultsVideoUnit;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PICKER_DESELECT */
public class TopVideoModuleGroupPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<SearchResultsVideoUnit>, Void, SearchResultsFeedEnvironment> {
    private static TopVideoModuleGroupPartDefinition f25311g;
    private static final Object f25312h = new Object();
    private final SearchVideoAttachmentSelectorPartDefinition f25313a;
    private final HeaderSelectorPartDefinition f25314b;
    private final TranslationOrContentSelectorPartDefinition f25315c;
    private final SeeTranslationPartDefinition<SearchResultsFeedEnvironment> f25316d;
    private final BlingBarSelectorPartDefinition f25317e;
    private final TopLevelFooterPartSelector f25318f;

    private static TopVideoModuleGroupPartDefinition m28559b(InjectorLike injectorLike) {
        return new TopVideoModuleGroupPartDefinition(SearchVideoAttachmentSelectorPartDefinition.m28542a(injectorLike), HeaderSelectorPartDefinition.a(injectorLike), TranslationOrContentSelectorPartDefinition.a(injectorLike), SeeTranslationPartDefinition.a(injectorLike), BlingBarSelectorPartDefinition.a(injectorLike), TopLevelFooterPartSelector.a(injectorLike));
    }

    public final Object m28560a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        Flattenable flattenable = ((SearchResultsVideoUnit) ((FeedProps) obj).a).f23550a;
        FeedProps c = FeedProps.c(flattenable);
        baseMultiRowSubParts.a(this.f25313a, StoryAttachmentHelper.o(flattenable));
        baseMultiRowSubParts.a(this.f25314b, c);
        baseMultiRowSubParts.a(this.f25315c, c);
        baseMultiRowSubParts.a(this.f25316d, c);
        baseMultiRowSubParts.a(this.f25317e, c);
        baseMultiRowSubParts.a(this.f25318f, c);
        return null;
    }

    public final boolean m28561a(Object obj) {
        SearchResultsVideoUnit searchResultsVideoUnit = (SearchResultsVideoUnit) ((FeedProps) obj).a;
        return (searchResultsVideoUnit.f23550a == null || StoryAttachmentHelper.o(searchResultsVideoUnit.f23550a) == null) ? false : true;
    }

    @Inject
    public TopVideoModuleGroupPartDefinition(SearchVideoAttachmentSelectorPartDefinition searchVideoAttachmentSelectorPartDefinition, HeaderSelectorPartDefinition headerSelectorPartDefinition, TranslationOrContentSelectorPartDefinition translationOrContentSelectorPartDefinition, SeeTranslationPartDefinition seeTranslationPartDefinition, BlingBarSelectorPartDefinition blingBarSelectorPartDefinition, TopLevelFooterPartSelector topLevelFooterPartSelector) {
        this.f25313a = searchVideoAttachmentSelectorPartDefinition;
        this.f25314b = headerSelectorPartDefinition;
        this.f25315c = translationOrContentSelectorPartDefinition;
        this.f25316d = seeTranslationPartDefinition;
        this.f25317e = blingBarSelectorPartDefinition;
        this.f25318f = topLevelFooterPartSelector;
    }

    public static TopVideoModuleGroupPartDefinition m28558a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TopVideoModuleGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f25312h) {
                TopVideoModuleGroupPartDefinition topVideoModuleGroupPartDefinition;
                if (a2 != null) {
                    topVideoModuleGroupPartDefinition = (TopVideoModuleGroupPartDefinition) a2.a(f25312h);
                } else {
                    topVideoModuleGroupPartDefinition = f25311g;
                }
                if (topVideoModuleGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28559b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f25312h, b3);
                        } else {
                            f25311g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = topVideoModuleGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
