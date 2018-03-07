package com.facebook.search.typeahead.rows;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
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
import com.facebook.multirow.parts.ClickListenerPartDefinition;
import com.facebook.search.model.NullStateSuggestionTypeaheadUnit;
import com.facebook.search.suggestions.environment.CanVisitTypeaheadSuggestion;
import com.facebook.search.suggestions.environment.SearchSuggestionsEnvironment;
import com.facebook.search.typeahead.ui.HorizontalRecentSearchView;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: video_chat_head_nux_fragment_tag */
public class HScrollRecentSearchPagePartDefinition<E extends HasContext & HasPersistentState & CanVisitTypeaheadSuggestion> extends MultiRowSinglePartDefinition<NullStateSuggestionTypeaheadUnit, State, E, HorizontalRecentSearchView> {
    public static ViewType<HorizontalRecentSearchView> f428a = new C00381();
    public static final CallerContext f429b = CallerContext.a(SearchTypeaheadHorizontalRecentPartDefinition.class, "search");
    private static HScrollRecentSearchPagePartDefinition f430d;
    private static final Object f431e = new Object();
    private final ClickListenerPartDefinition f432c;

    /* compiled from: video_chat_head_nux_fragment_tag */
    final class C00381 extends ViewType<HorizontalRecentSearchView> {
        C00381() {
        }

        public final View m530a(Context context) {
            return (HorizontalRecentSearchView) LayoutInflater.from(context).inflate(2130904791, null, false);
        }
    }

    /* compiled from: video_chat_head_nux_fragment_tag */
    public class State {
        @Nullable
        public final Uri f426a;
        public final Drawable f427b;

        public State(@Nullable Uri uri, Drawable drawable) {
            this.f426a = uri;
            this.f427b = drawable;
        }
    }

    private static HScrollRecentSearchPagePartDefinition m532b(InjectorLike injectorLike) {
        return new HScrollRecentSearchPagePartDefinition(ClickListenerPartDefinition.a(injectorLike));
    }

    public final Object m534a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final NullStateSuggestionTypeaheadUnit nullStateSuggestionTypeaheadUnit = (NullStateSuggestionTypeaheadUnit) obj;
        final HasContext hasContext = (HasContext) anyEnvironment;
        subParts.a(this.f432c, new OnClickListener(this) {
            final /* synthetic */ HScrollRecentSearchPagePartDefinition f425c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 699789407);
                ((SearchSuggestionsEnvironment) hasContext).m206a(nullStateSuggestionTypeaheadUnit);
                Logger.a(2, EntryType.UI_INPUT_END, -2026221755, a);
            }
        });
        return new State(nullStateSuggestionTypeaheadUnit.e, hasContext.getContext().getResources().getDrawable(2130841021));
    }

    public final /* bridge */ /* synthetic */ void m535a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1556550394);
        NullStateSuggestionTypeaheadUnit nullStateSuggestionTypeaheadUnit = (NullStateSuggestionTypeaheadUnit) obj;
        State state = (State) obj2;
        HorizontalRecentSearchView horizontalRecentSearchView = (HorizontalRecentSearchView) view;
        horizontalRecentSearchView.m785a(state.f426a, state.f427b, f429b);
        horizontalRecentSearchView.setTitle(nullStateSuggestionTypeaheadUnit.b);
        horizontalRecentSearchView.setBadgeCount(nullStateSuggestionTypeaheadUnit.i);
        Logger.a(8, EntryType.MARK_POP, 608622076, a);
    }

    public static HScrollRecentSearchPagePartDefinition m531a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            HScrollRecentSearchPagePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f431e) {
                HScrollRecentSearchPagePartDefinition hScrollRecentSearchPagePartDefinition;
                if (a2 != null) {
                    hScrollRecentSearchPagePartDefinition = (HScrollRecentSearchPagePartDefinition) a2.a(f431e);
                } else {
                    hScrollRecentSearchPagePartDefinition = f430d;
                }
                if (hScrollRecentSearchPagePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m532b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f431e, b3);
                        } else {
                            f430d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = hScrollRecentSearchPagePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public HScrollRecentSearchPagePartDefinition(ClickListenerPartDefinition clickListenerPartDefinition) {
        this.f432c = clickListenerPartDefinition;
    }

    public final ViewType<HorizontalRecentSearchView> m533a() {
        return f428a;
    }

    public final boolean m536a(Object obj) {
        return true;
    }
}
