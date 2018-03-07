package com.facebook.search.results.rows.sections.common;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.PaddingPartDefinition;
import com.facebook.feed.rows.styling.PaddingPartDefinition.PaddingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
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
import com.facebook.search.results.model.unit.SearchResultsPostHeaderUnit;
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;

@ContextScoped
/* compiled from: REACTION_OVERLAY_DISPLAY_ATTEMPTED */
public class SearchResultsPostsHeaderPartDefinition extends MultiRowSinglePartDefinition<FeedProps<SearchResultsPostHeaderUnit>, Void, AnyEnvironment, BetterTextView> {
    private static final PaddingStyle f24008a;
    private static SearchResultsPostsHeaderPartDefinition f24009e;
    private static final Object f24010f = new Object();
    private final Context f24011b;
    private final PaddingPartDefinition f24012c;
    private final TextPartDefinition f24013d;

    private static SearchResultsPostsHeaderPartDefinition m27588b(InjectorLike injectorLike) {
        return new SearchResultsPostsHeaderPartDefinition((Context) injectorLike.getInstance(Context.class), PaddingPartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike));
    }

    public final Object m27590a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        int i;
        SearchResultsPostHeaderUnit searchResultsPostHeaderUnit = (SearchResultsPostHeaderUnit) ((FeedProps) obj).a;
        if (searchResultsPostHeaderUnit.f23493a.equals(GraphQLGraphSearchResultRole.FEED_POSTS)) {
            i = 2131239044;
        } else {
            i = 2131239043;
        }
        subParts.a(this.f24013d, this.f24011b.getResources().getString(i));
        subParts.a(this.f24012c, new PaddingData(searchResultsPostHeaderUnit, f24008a, Position.TOP, 0));
        return null;
    }

    static {
        Builder a = Builder.a();
        a.b = 6.0f;
        a = a;
        a.c = -4.0f;
        f24008a = a.i();
    }

    @Inject
    public SearchResultsPostsHeaderPartDefinition(Context context, PaddingPartDefinition paddingPartDefinition, TextPartDefinition textPartDefinition) {
        this.f24011b = context;
        this.f24012c = paddingPartDefinition;
        this.f24013d = textPartDefinition;
    }

    public final ViewType m27589a() {
        return SearchResultsAnnotationPartDefinition.f23986a;
    }

    public final boolean m27591a(Object obj) {
        return true;
    }

    public static SearchResultsPostsHeaderPartDefinition m27587a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsPostsHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24010f) {
                SearchResultsPostsHeaderPartDefinition searchResultsPostsHeaderPartDefinition;
                if (a2 != null) {
                    searchResultsPostsHeaderPartDefinition = (SearchResultsPostsHeaderPartDefinition) a2.a(f24010f);
                } else {
                    searchResultsPostsHeaderPartDefinition = f24009e;
                }
                if (searchResultsPostsHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27588b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24010f, b3);
                        } else {
                            f24009e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsPostsHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
