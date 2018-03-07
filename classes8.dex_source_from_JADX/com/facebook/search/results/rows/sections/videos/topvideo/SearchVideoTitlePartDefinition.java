package com.facebook.search.results.rows.sections.videos.topvideo;

import android.content.Context;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.graphql.model.StoryTextHelper;
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
import com.facebook.search.results.model.unit.SearchResultsVideoUnit;
import com.facebook.search.results.rows.sections.common.SearchResultsCommonViewTypes;
import com.facebook.widget.text.BetterTextView;
import com.google.common.base.Strings;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PICKER_NUX_DISMISS */
public class SearchVideoTitlePartDefinition extends MultiRowSinglePartDefinition<SearchResultsVideoUnit, Void, HasPositionInformation, BetterTextView> {
    private static SearchVideoTitlePartDefinition f25308b;
    private static final Object f25309c = new Object();
    private final BackgroundPartDefinition f25310a;

    private static SearchVideoTitlePartDefinition m28553b(InjectorLike injectorLike) {
        return new SearchVideoTitlePartDefinition(BackgroundPartDefinition.a(injectorLike));
    }

    public final Object m28555a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f25310a, new StylingData(null, PaddingStyle.a, Position.MIDDLE));
        return null;
    }

    public final /* bridge */ /* synthetic */ void m28556a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -526937556);
        SearchResultsVideoUnit searchResultsVideoUnit = (SearchResultsVideoUnit) obj;
        BetterTextView betterTextView = (BetterTextView) view;
        betterTextView.setTextAppearance(betterTextView.getContext(), 2131626189);
        betterTextView.setMaxLines(2);
        betterTextView.setEllipsize(TruncateAt.END);
        betterTextView.setText(StoryTextHelper.a(searchResultsVideoUnit.f23550a));
        Logger.a(8, EntryType.MARK_POP, -1938074453, a);
    }

    public final boolean m28557a(Object obj) {
        return !Strings.isNullOrEmpty(StoryTextHelper.a(((SearchResultsVideoUnit) obj).f23550a));
    }

    @Inject
    public SearchVideoTitlePartDefinition(BackgroundPartDefinition backgroundPartDefinition) {
        this.f25310a = backgroundPartDefinition;
    }

    public final ViewType m28554a() {
        return SearchResultsCommonViewTypes.f24003a;
    }

    public static SearchVideoTitlePartDefinition m28552a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchVideoTitlePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f25309c) {
                SearchVideoTitlePartDefinition searchVideoTitlePartDefinition;
                if (a2 != null) {
                    searchVideoTitlePartDefinition = (SearchVideoTitlePartDefinition) a2.a(f25309c);
                } else {
                    searchVideoTitlePartDefinition = f25308b;
                }
                if (searchVideoTitlePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28553b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f25309c, b3);
                        } else {
                            f25308b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchVideoTitlePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
