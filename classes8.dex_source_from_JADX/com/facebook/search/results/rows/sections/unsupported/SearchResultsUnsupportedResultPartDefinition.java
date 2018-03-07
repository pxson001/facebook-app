package com.facebook.search.results.rows.sections.unsupported;

import android.content.Context;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.PaddingPartDefinition;
import com.facebook.feed.rows.styling.PaddingPartDefinition.PaddingData;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
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
import com.facebook.widget.text.BetterTextView;
import java.util.Locale;
import javax.inject.Inject;

@ContextScoped
/* compiled from: POST */
public class SearchResultsUnsupportedResultPartDefinition extends MultiRowSinglePartDefinition<Props, Void, AnyEnvironment, BetterTextView> {
    public static final ViewType<BetterTextView> f25097a = ViewType.a(2130907605);
    private static final PaddingData f25098b = new PaddingData(null, PaddingStyle.a, Position.BOX, 0);
    private static SearchResultsUnsupportedResultPartDefinition f25099e;
    private static final Object f25100f = new Object();
    private final TextPartDefinition f25101c;
    private final PaddingPartDefinition f25102d;

    /* compiled from: POST */
    public class Props {
        public final GraphQLGraphSearchResultRole f25095a;
        public final GraphQLGraphSearchResultsDisplayStyle f25096b;

        public Props(GraphQLGraphSearchResultRole graphQLGraphSearchResultRole, GraphQLGraphSearchResultsDisplayStyle graphQLGraphSearchResultsDisplayStyle) {
            this.f25095a = graphQLGraphSearchResultRole;
            this.f25096b = graphQLGraphSearchResultsDisplayStyle;
        }

        public Props(GraphQLGraphSearchResultRole graphQLGraphSearchResultRole) {
            this.f25095a = graphQLGraphSearchResultRole;
            this.f25096b = GraphQLGraphSearchResultsDisplayStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
    }

    private static SearchResultsUnsupportedResultPartDefinition m28397b(InjectorLike injectorLike) {
        return new SearchResultsUnsupportedResultPartDefinition(TextPartDefinition.a(injectorLike), PaddingPartDefinition.a(injectorLike));
    }

    public final Object m28399a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        Props props = (Props) obj;
        subParts.a(this.f25101c, String.format(Locale.US, "[Employees Only] Unsupported Result\nType: %s\nDisplay Style: %s\nPlease rage shake and file a report.", new Object[]{props.f25095a, props.f25096b}));
        subParts.a(this.f25102d, f25098b);
        return null;
    }

    public static SearchResultsUnsupportedResultPartDefinition m28396a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsUnsupportedResultPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f25100f) {
                SearchResultsUnsupportedResultPartDefinition searchResultsUnsupportedResultPartDefinition;
                if (a2 != null) {
                    searchResultsUnsupportedResultPartDefinition = (SearchResultsUnsupportedResultPartDefinition) a2.a(f25100f);
                } else {
                    searchResultsUnsupportedResultPartDefinition = f25099e;
                }
                if (searchResultsUnsupportedResultPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28397b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f25100f, b3);
                        } else {
                            f25099e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsUnsupportedResultPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public SearchResultsUnsupportedResultPartDefinition(TextPartDefinition textPartDefinition, PaddingPartDefinition paddingPartDefinition) {
        this.f25101c = textPartDefinition;
        this.f25102d = paddingPartDefinition;
    }

    public final ViewType<BetterTextView> m28398a() {
        return f25097a;
    }

    public final boolean m28400a(Object obj) {
        return BuildConstants.i;
    }
}
