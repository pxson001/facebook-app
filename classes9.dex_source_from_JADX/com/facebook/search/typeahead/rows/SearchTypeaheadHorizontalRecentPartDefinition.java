package com.facebook.search.typeahead.rows;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.HorizontalScrollView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
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
import com.facebook.search.model.HorizontalRecentSearchesUnit;
import com.facebook.search.model.NullStateSuggestionTypeaheadUnit;
import com.facebook.search.model.TypeaheadUnit;
import com.facebook.search.suggestions.environment.SearchSuggestionsEnvironment;
import com.facebook.search.typeahead.ui.HorizontalRecentSearchView;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: verification_follow_up_action */
public class SearchTypeaheadHorizontalRecentPartDefinition extends MultiRowSinglePartDefinition<HorizontalRecentSearchesUnit, ImmutableList<State>, SearchSuggestionsEnvironment, HorizontalScrollView> {
    public static final ViewType f551a = new C00501();
    private static final CallerContext f552b = CallerContext.a(SearchTypeaheadHorizontalRecentPartDefinition.class, "search");
    private static SearchTypeaheadHorizontalRecentPartDefinition f553d;
    private static final Object f554e = new Object();
    private final Context f555c;

    /* compiled from: verification_follow_up_action */
    final class C00501 extends ViewType {
        C00501() {
        }

        public final View m639a(Context context) {
            View horizontalScrollView = new HorizontalScrollView(context);
            horizontalScrollView.setVerticalFadingEdgeEnabled(false);
            horizontalScrollView.setHorizontalScrollBarEnabled(false);
            horizontalScrollView.setOverScrollMode(2);
            horizontalScrollView.setClipToPadding(false);
            return horizontalScrollView;
        }
    }

    /* compiled from: verification_follow_up_action */
    public class State {
        public final HorizontalRecentSearchView f546a;
        @Nullable
        public final Uri f547b;
        public final Drawable f548c;
        public final CharSequence f549d;
        public final int f550e;

        public State(HorizontalRecentSearchView horizontalRecentSearchView, @Nullable Uri uri, Drawable drawable, CharSequence charSequence, int i) {
            this.f546a = horizontalRecentSearchView;
            this.f547b = uri;
            this.f548c = drawable;
            this.f549d = charSequence;
            this.f550e = i;
        }
    }

    private static SearchTypeaheadHorizontalRecentPartDefinition m643b(InjectorLike injectorLike) {
        return new SearchTypeaheadHorizontalRecentPartDefinition((Context) injectorLike.getInstance(Context.class));
    }

    public final /* bridge */ /* synthetic */ Object m645a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        return m641a((HorizontalRecentSearchesUnit) obj, (SearchSuggestionsEnvironment) anyEnvironment);
    }

    public final /* bridge */ /* synthetic */ void m646a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 774042962);
        m642a((ImmutableList) obj2, (HorizontalScrollView) view);
        Logger.a(8, EntryType.MARK_POP, 203878864, a);
    }

    public final boolean m647a(Object obj) {
        return !((HorizontalRecentSearchesUnit) obj).f().isEmpty();
    }

    public final void m648b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        HorizontalScrollView horizontalScrollView = (HorizontalScrollView) view;
        ((CustomLinearLayout) horizontalScrollView.getChildAt(0)).removeAllViews();
        horizontalScrollView.removeAllViews();
    }

    public static SearchTypeaheadHorizontalRecentPartDefinition m640a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchTypeaheadHorizontalRecentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f554e) {
                SearchTypeaheadHorizontalRecentPartDefinition searchTypeaheadHorizontalRecentPartDefinition;
                if (a2 != null) {
                    searchTypeaheadHorizontalRecentPartDefinition = (SearchTypeaheadHorizontalRecentPartDefinition) a2.a(f554e);
                } else {
                    searchTypeaheadHorizontalRecentPartDefinition = f553d;
                }
                if (searchTypeaheadHorizontalRecentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m643b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f554e, b3);
                        } else {
                            f553d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchTypeaheadHorizontalRecentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public SearchTypeaheadHorizontalRecentPartDefinition(Context context) {
        this.f555c = context;
    }

    public final ViewType<HorizontalScrollView> m644a() {
        return f551a;
    }

    private ImmutableList<State> m641a(final HorizontalRecentSearchesUnit horizontalRecentSearchesUnit, final SearchSuggestionsEnvironment searchSuggestionsEnvironment) {
        OnClickListener c00512 = new OnClickListener(this) {
            final /* synthetic */ SearchTypeaheadHorizontalRecentPartDefinition f545c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 663907286);
                searchSuggestionsEnvironment.m206a((TypeaheadUnit) horizontalRecentSearchesUnit.f().get(((Integer) view.getTag()).intValue()));
                Logger.a(2, EntryType.UI_INPUT_END, 745214562, a);
            }
        };
        Builder builder = new Builder();
        ImmutableList f = horizontalRecentSearchesUnit.f();
        int size = f.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            NullStateSuggestionTypeaheadUnit nullStateSuggestionTypeaheadUnit = (NullStateSuggestionTypeaheadUnit) ((TypeaheadUnit) f.get(i));
            HorizontalRecentSearchView horizontalRecentSearchView = (HorizontalRecentSearchView) LayoutInflater.from(this.f555c).inflate(2130904791, null);
            horizontalRecentSearchView.setTag(Integer.valueOf(i2));
            horizontalRecentSearchView.setOnClickListener(c00512);
            int i3 = i2 + 1;
            builder.c(new State(horizontalRecentSearchView, nullStateSuggestionTypeaheadUnit.e, this.f555c.getResources().getDrawable(2130841021), nullStateSuggestionTypeaheadUnit.m(), nullStateSuggestionTypeaheadUnit.v()));
            i++;
            i2 = i3;
        }
        return builder.b();
    }

    private void m642a(ImmutableList<State> immutableList, HorizontalScrollView horizontalScrollView) {
        horizontalScrollView.setPadding(this.f555c.getResources().getDimensionPixelSize(2131431691), horizontalScrollView.getPaddingTop(), horizontalScrollView.getPaddingRight(), this.f555c.getResources().getDimensionPixelSize(2131431692));
        CustomLinearLayout customLinearLayout = new CustomLinearLayout(horizontalScrollView.getContext());
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            State state = (State) immutableList.get(i);
            state.f546a.m785a(state.f547b, state.f548c, f552b);
            state.f546a.setTitle(state.f549d);
            state.f546a.setBadgeCount(state.f550e);
            customLinearLayout.addView(state.f546a);
        }
        horizontalScrollView.addView(customLinearLayout);
    }
}
