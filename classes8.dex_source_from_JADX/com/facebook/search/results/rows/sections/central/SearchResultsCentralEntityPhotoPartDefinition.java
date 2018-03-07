package com.facebook.search.results.rows.sections.central;

import android.content.Context;
import android.widget.RelativeLayout;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.PaddingPartDefinition;
import com.facebook.feed.rows.styling.PaddingPartDefinition.PaddingData;
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
import com.facebook.multirow.parts.FbDraweeImageUriPartDefinition;
import com.facebook.multirow.parts.FbDraweeImageUriPartDefinition.UriContextData;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.search.results.model.unit.SearchResultsEntityWithCoverPhotoFeedUnit;
import javax.inject.Inject;

@ContextScoped
/* compiled from: RESULT_LIST_REQUEST */
public class SearchResultsCentralEntityPhotoPartDefinition<T extends SearchResultsEntityWithCoverPhotoFeedUnit> extends MultiRowSinglePartDefinition<FeedProps<T>, Void, HasPositionInformation, RelativeLayout> {
    public static final ViewType f23633a = ViewType.a(2130903532);
    private static final CallerContext f23634b = CallerContext.a(SearchResultsCentralEntityPhotoPartDefinition.class, "graph_search_results_page");
    private static final PaddingStyle f23635c;
    private static SearchResultsCentralEntityPhotoPartDefinition f23636g;
    private static final Object f23637h = new Object();
    private final PaddingPartDefinition f23638d;
    private final FbDraweeImageUriPartDefinition f23639e;
    private final TextPartDefinition f23640f;

    private static SearchResultsCentralEntityPhotoPartDefinition m27293b(InjectorLike injectorLike) {
        return new SearchResultsCentralEntityPhotoPartDefinition(PaddingPartDefinition.a(injectorLike), FbDraweeImageUriPartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike));
    }

    public final Object m27295a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        SearchResultsEntityWithCoverPhotoFeedUnit searchResultsEntityWithCoverPhotoFeedUnit = (SearchResultsEntityWithCoverPhotoFeedUnit) ((FeedProps) obj).a;
        subParts.a(this.f23638d, new PaddingData(searchResultsEntityWithCoverPhotoFeedUnit, f23635c, Position.MIDDLE, 0));
        String o = searchResultsEntityWithCoverPhotoFeedUnit.mo1327o();
        if (o != null) {
            subParts.a(2131560273, this.f23639e, new UriContextData(o, f23634b));
        }
        subParts.a(2131560274, this.f23640f, searchResultsEntityWithCoverPhotoFeedUnit.mo1324f());
        if (searchResultsEntityWithCoverPhotoFeedUnit.mo1325m() != null) {
            subParts.a(2131560275, this.f23640f, searchResultsEntityWithCoverPhotoFeedUnit.mo1325m());
        }
        return null;
    }

    public final boolean m27296a(Object obj) {
        return ((SearchResultsEntityWithCoverPhotoFeedUnit) ((FeedProps) obj).a).mo1326n().eP() != null;
    }

    static {
        Builder a = Builder.a();
        a.b = -6.0f;
        a = a;
        a.c = -6.0f;
        a = a;
        a.d = -12.0f;
        f23635c = a.i();
    }

    @Inject
    public SearchResultsCentralEntityPhotoPartDefinition(PaddingPartDefinition paddingPartDefinition, FbDraweeImageUriPartDefinition fbDraweeImageUriPartDefinition, TextPartDefinition textPartDefinition) {
        this.f23638d = paddingPartDefinition;
        this.f23639e = fbDraweeImageUriPartDefinition;
        this.f23640f = textPartDefinition;
    }

    public static SearchResultsCentralEntityPhotoPartDefinition m27292a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsCentralEntityPhotoPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23637h) {
                SearchResultsCentralEntityPhotoPartDefinition searchResultsCentralEntityPhotoPartDefinition;
                if (a2 != null) {
                    searchResultsCentralEntityPhotoPartDefinition = (SearchResultsCentralEntityPhotoPartDefinition) a2.a(f23637h);
                } else {
                    searchResultsCentralEntityPhotoPartDefinition = f23636g;
                }
                if (searchResultsCentralEntityPhotoPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27293b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23637h, b3);
                        } else {
                            f23636g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsCentralEntityPhotoPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType<RelativeLayout> m27294a() {
        return f23633a;
    }
}
