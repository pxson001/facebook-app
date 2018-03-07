package com.facebook.search.typeahead.rows;

import android.content.Context;
import android.text.Html;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.text.style.TextAppearanceSpan;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
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
import com.facebook.search.model.KeywordTypeaheadUnit;
import com.facebook.search.model.KeywordTypeaheadUnit.KeywordType;
import com.facebook.search.searchbox.GraphSearchTitleSearchBoxSupplier;
import com.facebook.search.util.keyword.KeywordSpanFactory;
import com.facebook.search.util.keyword.KeywordSuggestionHighlightingUtil;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.text.BetterTextView;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: vaultImageDelete */
public class SearchTypeaheadSimpleKeywordPartDefinition<E extends HasContext> extends MultiRowSinglePartDefinition<KeywordTypeaheadUnit, CharSequence, E, CustomFrameLayout> {
    public static final ViewType<CustomFrameLayout> f622a = ViewType.a(2130907105);
    private static final KeywordSpanFactory f623b = new C00561();
    private static SearchTypeaheadSimpleKeywordPartDefinition f624e;
    private static final Object f625f = new Object();
    private final GraphSearchTitleSearchBoxSupplier f626c;
    private final KeywordSuggestionHighlightingUtil f627d;

    /* compiled from: vaultImageDelete */
    final class C00561 implements KeywordSpanFactory {
        C00561() {
        }

        public final Object m716a() {
            return new StyleSpan(1);
        }
    }

    private static SearchTypeaheadSimpleKeywordPartDefinition m718b(InjectorLike injectorLike) {
        return new SearchTypeaheadSimpleKeywordPartDefinition(GraphSearchTitleSearchBoxSupplier.a(injectorLike), KeywordSuggestionHighlightingUtil.a(injectorLike));
    }

    public final Object m720a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        KeywordTypeaheadUnit keywordTypeaheadUnit = (KeywordTypeaheadUnit) obj;
        HasContext hasContext = (HasContext) anyEnvironment;
        if (!keywordTypeaheadUnit.g.equals(KeywordType.escape)) {
            return this.f627d.a(keywordTypeaheadUnit.a(), this.f626c.c(), RegularImmutableList.a, ImmutableList.of(f623b));
        }
        SpannableString spannableString = new SpannableString(Html.fromHtml(StringFormatUtil.formatStrLocaleSafe(hasContext.getContext().getResources().getString(2131237438), keywordTypeaheadUnit.a())));
        spannableString.setSpan(new TextAppearanceSpan(hasContext.getContext(), 2131625967), 0, spannableString.length(), 17);
        return spannableString;
    }

    public final /* bridge */ /* synthetic */ void m721a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -885843515);
        ((BetterTextView) ((CustomFrameLayout) view).findViewById(2131567452)).setText((CharSequence) obj2);
        Logger.a(8, EntryType.MARK_POP, -1108748080, a);
    }

    @Inject
    public SearchTypeaheadSimpleKeywordPartDefinition(GraphSearchTitleSearchBoxSupplier graphSearchTitleSearchBoxSupplier, KeywordSuggestionHighlightingUtil keywordSuggestionHighlightingUtil) {
        this.f626c = graphSearchTitleSearchBoxSupplier;
        this.f627d = keywordSuggestionHighlightingUtil;
    }

    public final ViewType<CustomFrameLayout> m719a() {
        return f622a;
    }

    public static SearchTypeaheadSimpleKeywordPartDefinition m717a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchTypeaheadSimpleKeywordPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f625f) {
                SearchTypeaheadSimpleKeywordPartDefinition searchTypeaheadSimpleKeywordPartDefinition;
                if (a2 != null) {
                    searchTypeaheadSimpleKeywordPartDefinition = (SearchTypeaheadSimpleKeywordPartDefinition) a2.a(f625f);
                } else {
                    searchTypeaheadSimpleKeywordPartDefinition = f624e;
                }
                if (searchTypeaheadSimpleKeywordPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m718b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f625f, b3);
                        } else {
                            f624e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchTypeaheadSimpleKeywordPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final boolean m722a(Object obj) {
        return true;
    }
}
