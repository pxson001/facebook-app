package com.facebook.search.results.rows.sections.collection;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ImageWithTextViewDrawablePartDefinition;
import com.facebook.multirow.parts.ImageWithTextViewDrawablePartDefinition.IconData;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.search.results.model.unit.SearchResultsAwarenessUnit;
import com.facebook.widget.CustomLinearLayout;
import javax.inject.Inject;

@ContextScoped
/* compiled from: RESEND_CODE_FAILURE */
public class SearchResultsAwarenessNodePartDefinition extends MultiRowSinglePartDefinition<FeedProps<SearchResultsAwarenessUnit>, Void, HasPositionInformation, CustomLinearLayout> {
    public static ViewType<CustomLinearLayout> f23730a = ViewType.a(2130906999);
    private static SearchResultsAwarenessNodePartDefinition f23731e;
    private static final Object f23732f = new Object();
    private final ImageWithTextViewDrawablePartDefinition f23733b;
    private final TextPartDefinition f23734c;
    private final BackgroundPartDefinition f23735d;

    private static SearchResultsAwarenessNodePartDefinition m27375b(InjectorLike injectorLike) {
        return new SearchResultsAwarenessNodePartDefinition(ImageWithTextViewDrawablePartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike), BackgroundPartDefinition.a(injectorLike));
    }

    public final Object m27377a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        SearchResultsAwarenessUnit searchResultsAwarenessUnit = (SearchResultsAwarenessUnit) feedProps.a;
        subParts.a(2131567286, this.f23733b, new IconData(2130843274, Integer.valueOf(-12887656)));
        subParts.a(2131567286, this.f23734c, searchResultsAwarenessUnit.f23452a);
        subParts.a(2131567287, this.f23734c, searchResultsAwarenessUnit.f23453b);
        subParts.a(this.f23735d, new StylingData(feedProps, PaddingStyle.a));
        return null;
    }

    @Inject
    public SearchResultsAwarenessNodePartDefinition(ImageWithTextViewDrawablePartDefinition imageWithTextViewDrawablePartDefinition, TextPartDefinition textPartDefinition, BackgroundPartDefinition backgroundPartDefinition) {
        this.f23733b = imageWithTextViewDrawablePartDefinition;
        this.f23734c = textPartDefinition;
        this.f23735d = backgroundPartDefinition;
    }

    public final ViewType<CustomLinearLayout> m27376a() {
        return f23730a;
    }

    public final boolean m27378a(Object obj) {
        return true;
    }

    public static SearchResultsAwarenessNodePartDefinition m27374a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsAwarenessNodePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23732f) {
                SearchResultsAwarenessNodePartDefinition searchResultsAwarenessNodePartDefinition;
                if (a2 != null) {
                    searchResultsAwarenessNodePartDefinition = (SearchResultsAwarenessNodePartDefinition) a2.a(f23732f);
                } else {
                    searchResultsAwarenessNodePartDefinition = f23731e;
                }
                if (searchResultsAwarenessNodePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27375b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23732f, b3);
                        } else {
                            f23731e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsAwarenessNodePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
