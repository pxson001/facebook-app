package com.facebook.search.results.rows.sections.noresults;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.search.results.environment.HasSearchResultsContext;
import com.facebook.search.results.model.unit.SearchResultsEmptyUnit;
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PYMK cards should have a present friending location */
public class SearchResultsEmptyUnitPartDefinition<E extends HasPositionInformation & HasSearchResultsContext> extends MultiRowSinglePartDefinition<FeedProps<SearchResultsEmptyUnit>, Void, E, BetterTextView> {
    public static final ViewType f24696a = new C26061();
    private static final PaddingStyle f24697b;
    private static SearchResultsEmptyUnitPartDefinition f24698e;
    private static final Object f24699f = new Object();
    private final TextPartDefinition f24700c;
    private final BackgroundPartDefinition f24701d;

    /* compiled from: PYMK cards should have a present friending location */
    final class C26061 extends ViewType {
        C26061() {
        }

        public final View m28112a(Context context) {
            BetterTextView betterTextView = new BetterTextView(context);
            betterTextView.setTextAppearance(betterTextView.getContext(), 2131625898);
            betterTextView.setGravity(17);
            betterTextView.setLineSpacing(0.0f, 1.2f);
            return betterTextView;
        }
    }

    private static SearchResultsEmptyUnitPartDefinition m28114b(InjectorLike injectorLike) {
        return new SearchResultsEmptyUnitPartDefinition(TextPartDefinition.a(injectorLike), BackgroundPartDefinition.a(injectorLike));
    }

    public final Object m28116a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        HasPositionInformation hasPositionInformation = (HasPositionInformation) anyEnvironment;
        SearchResultsEmptyUnit searchResultsEmptyUnit = (SearchResultsEmptyUnit) feedProps.a;
        subParts.a(this.f24701d, new StylingData(feedProps, f24697b));
        Object a = ((HasSearchResultsContext) hasPositionInformation).mo1248s().mo1211a();
        if (StringUtil.c(a) || a == null || !searchResultsEmptyUnit.f23478a.contains(a)) {
            subParts.a(this.f24700c, searchResultsEmptyUnit.f23478a);
        } else {
            int lastIndexOf = searchResultsEmptyUnit.f23478a.lastIndexOf(a);
            Spannable spannableString = new SpannableString(searchResultsEmptyUnit.f23478a);
            spannableString.setSpan(new StyleSpan(1), lastIndexOf, spannableString.length(), 17);
            subParts.a(this.f24700c, spannableString);
        }
        return null;
    }

    static {
        Builder b = Builder.b();
        b.b = 4.0f;
        b = b;
        b.c = 4.0f;
        f24697b = b.i();
    }

    public static SearchResultsEmptyUnitPartDefinition m28113a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsEmptyUnitPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24699f) {
                SearchResultsEmptyUnitPartDefinition searchResultsEmptyUnitPartDefinition;
                if (a2 != null) {
                    searchResultsEmptyUnitPartDefinition = (SearchResultsEmptyUnitPartDefinition) a2.a(f24699f);
                } else {
                    searchResultsEmptyUnitPartDefinition = f24698e;
                }
                if (searchResultsEmptyUnitPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28114b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24699f, b3);
                        } else {
                            f24698e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsEmptyUnitPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public SearchResultsEmptyUnitPartDefinition(TextPartDefinition textPartDefinition, BackgroundPartDefinition backgroundPartDefinition) {
        this.f24700c = textPartDefinition;
        this.f24701d = backgroundPartDefinition;
    }

    public final ViewType m28115a() {
        return f24696a;
    }

    public final boolean m28117a(Object obj) {
        return true;
    }
}
