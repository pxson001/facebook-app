package com.facebook.search.results.rows.sections.spellcorrection;

import android.content.Context;
import android.text.Html;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.graphql.enums.GraphQLGraphSearchSpellerConfidence;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.search.results.model.unit.SearchResultsSpellCorrectionUnit;
import com.facebook.search.results.rows.sections.common.SearchResultsCommonViewTypes;
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PRELIMINARY_DATA */
public class SearchResultsSpellCorrectionTitlePartDefinition extends MultiRowSinglePartDefinition<FeedProps<SearchResultsSpellCorrectionUnit>, Integer, HasPositionInformation, BetterTextView> {
    private static SearchResultsSpellCorrectionTitlePartDefinition f25025b;
    private static final Object f25026c = new Object();
    private final BackgroundPartDefinition f25027a;

    private static SearchResultsSpellCorrectionTitlePartDefinition m28355b(InjectorLike injectorLike) {
        return new SearchResultsSpellCorrectionTitlePartDefinition(BackgroundPartDefinition.a(injectorLike));
    }

    public final Object m28357a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        int i;
        FeedProps feedProps = (FeedProps) obj;
        SearchResultsSpellCorrectionUnit searchResultsSpellCorrectionUnit = (SearchResultsSpellCorrectionUnit) feedProps.a;
        float f = searchResultsSpellCorrectionUnit.f23517a == GraphQLGraphSearchSpellerConfidence.INCLUDING ? 0.0f : 4.0f;
        Builder a = Builder.a();
        a.c = f;
        subParts.a(this.f25027a, new StylingData(feedProps, a.i(), searchResultsSpellCorrectionUnit.f23517a == GraphQLGraphSearchSpellerConfidence.INCLUDING ? Position.MIDDLE : Position.DIVIDER_BOTTOM_NON_TOP));
        if (searchResultsSpellCorrectionUnit.f23517a == GraphQLGraphSearchSpellerConfidence.SHOWING) {
            i = 2131239049;
        } else {
            i = 2131239050;
        }
        return Integer.valueOf(i);
    }

    public final /* bridge */ /* synthetic */ void m28358a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 93003874);
        Integer num = (Integer) obj2;
        BetterTextView betterTextView = (BetterTextView) view;
        SearchResultsSpellCorrectionUnit searchResultsSpellCorrectionUnit = (SearchResultsSpellCorrectionUnit) ((FeedProps) obj).a;
        String string = betterTextView.getContext().getString(num.intValue(), new Object[]{searchResultsSpellCorrectionUnit.f23520d});
        betterTextView.setTextAppearance(betterTextView.getContext(), 2131625901);
        betterTextView.setText(Html.fromHtml(string));
        Logger.a(8, EntryType.MARK_POP, -1685104473, a);
    }

    public final boolean m28359a(Object obj) {
        SearchResultsSpellCorrectionUnit searchResultsSpellCorrectionUnit = (SearchResultsSpellCorrectionUnit) ((FeedProps) obj).a;
        return searchResultsSpellCorrectionUnit.f23517a == GraphQLGraphSearchSpellerConfidence.SHOWING || searchResultsSpellCorrectionUnit.f23517a == GraphQLGraphSearchSpellerConfidence.INCLUDING;
    }

    @Inject
    public SearchResultsSpellCorrectionTitlePartDefinition(BackgroundPartDefinition backgroundPartDefinition) {
        this.f25027a = backgroundPartDefinition;
    }

    public final ViewType m28356a() {
        return SearchResultsCommonViewTypes.f24003a;
    }

    public static SearchResultsSpellCorrectionTitlePartDefinition m28354a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsSpellCorrectionTitlePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f25026c) {
                SearchResultsSpellCorrectionTitlePartDefinition searchResultsSpellCorrectionTitlePartDefinition;
                if (a2 != null) {
                    searchResultsSpellCorrectionTitlePartDefinition = (SearchResultsSpellCorrectionTitlePartDefinition) a2.a(f25026c);
                } else {
                    searchResultsSpellCorrectionTitlePartDefinition = f25025b;
                }
                if (searchResultsSpellCorrectionTitlePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28355b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f25026c, b3);
                        } else {
                            f25025b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsSpellCorrectionTitlePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
