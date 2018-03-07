package com.facebook.search.typeahead.rows;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.widget.contentview.ContentView;
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
import com.facebook.search.model.SeeMoreTypeaheadUnit;
import com.facebook.search.searchbox.GraphSearchTitleSearchBoxSupplier;
import com.facebook.search.suggestions.viewbinder.KeywordSuggestionViewBinder;
import javax.inject.Inject;

@ContextScoped
/* compiled from: verification_url */
public class SearchTypeaheadFindMorePartDefinition extends MultiRowSinglePartDefinition<SeeMoreTypeaheadUnit, State, AnyEnvironment, ContentView> {
    public static final ViewType f521a = ViewType.a(2130904633);
    private static SearchTypeaheadFindMorePartDefinition f522e;
    private static final Object f523f = new Object();
    private final Context f524b;
    private final GraphSearchTitleSearchBoxSupplier f525c;
    public final KeywordSuggestionViewBinder f526d;

    /* compiled from: verification_url */
    public class State {
        public Spanned f519a;
        public Drawable f520b;

        public State(Spanned spanned, Drawable drawable) {
            this.f519a = spanned;
            this.f520b = drawable;
        }
    }

    private static SearchTypeaheadFindMorePartDefinition m620b(InjectorLike injectorLike) {
        return new SearchTypeaheadFindMorePartDefinition((Context) injectorLike.getInstance(Context.class), GraphSearchTitleSearchBoxSupplier.a(injectorLike), KeywordSuggestionViewBinder.m493a(injectorLike));
    }

    public final Object m622a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Drawable drawable = this.f524b.getResources().getDrawable(2130843295);
        int color = this.f524b.getResources().getColor(2131361916);
        drawable.mutate().setColorFilter(new PorterDuffColorFilter(color, Mode.SRC_IN));
        Spanned spannableString = new SpannableString("");
        if (!(this.f525c.a == null || this.f525c.a.e == null)) {
            spannableString = new SpannableString(Html.fromHtml(this.f524b.getResources().getString(2131237439, new Object[]{this.f525c.a.e.getText()})));
            spannableString.setSpan(new ForegroundColorSpan(color), 0, spannableString.length(), 17);
        }
        return new State(spannableString, drawable);
    }

    public final /* bridge */ /* synthetic */ void m623a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1652092462);
        State state = (State) obj2;
        this.f526d.m502a((ContentView) view, state.f519a, state.f520b);
        Logger.a(8, EntryType.MARK_POP, 515697563, a);
    }

    public static SearchTypeaheadFindMorePartDefinition m619a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchTypeaheadFindMorePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f523f) {
                SearchTypeaheadFindMorePartDefinition searchTypeaheadFindMorePartDefinition;
                if (a2 != null) {
                    searchTypeaheadFindMorePartDefinition = (SearchTypeaheadFindMorePartDefinition) a2.a(f523f);
                } else {
                    searchTypeaheadFindMorePartDefinition = f522e;
                }
                if (searchTypeaheadFindMorePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m620b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f523f, b3);
                        } else {
                            f522e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchTypeaheadFindMorePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public SearchTypeaheadFindMorePartDefinition(Context context, GraphSearchTitleSearchBoxSupplier graphSearchTitleSearchBoxSupplier, KeywordSuggestionViewBinder keywordSuggestionViewBinder) {
        this.f524b = context;
        this.f525c = graphSearchTitleSearchBoxSupplier;
        this.f526d = keywordSuggestionViewBinder;
    }

    public final ViewType m621a() {
        return f521a;
    }

    public final boolean m624a(Object obj) {
        return true;
    }
}
