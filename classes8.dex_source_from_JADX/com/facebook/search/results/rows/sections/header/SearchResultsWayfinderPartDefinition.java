package com.facebook.search.results.rows.sections.header;

import android.content.Context;
import android.text.Html;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
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
import com.facebook.multirow.parts.TextIconPartDefinition;
import com.facebook.multirow.parts.TextIconPartDefinition.IconData;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.search.api.GraphSearchQuery.ScopedEntityType;
import com.facebook.search.results.model.unit.SearchResultsWayfinderUnit;
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PostsByOthersCardQuery */
public class SearchResultsWayfinderPartDefinition<E extends HasContext & HasPositionInformation> extends MultiRowSinglePartDefinition<FeedProps<SearchResultsWayfinderUnit>, Void, E, BetterTextView> {
    public static ViewType<BetterTextView> f24427a = ViewType.a(2130907017);
    private static SearchResultsWayfinderPartDefinition f24428e;
    private static final Object f24429f = new Object();
    private final TextPartDefinition f24430b;
    private final TextIconPartDefinition f24431c;
    private final BackgroundPartDefinition f24432d;

    private static SearchResultsWayfinderPartDefinition m27901b(InjectorLike injectorLike) {
        return new SearchResultsWayfinderPartDefinition(TextPartDefinition.a(injectorLike), TextIconPartDefinition.a(injectorLike), BackgroundPartDefinition.a(injectorLike));
    }

    public final Object m27903a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        int i;
        FeedProps feedProps = (FeedProps) obj;
        HasContext hasContext = (HasContext) anyEnvironment;
        if (ScopedEntityType.GROUP.equals(((SearchResultsWayfinderUnit) feedProps.a).f23553b)) {
            i = 2131239048;
        } else {
            i = 2131239047;
        }
        subParts.a(2131567297, this.f24430b, Html.fromHtml(hasContext.getContext().getString(i, new Object[]{((SearchResultsWayfinderUnit) feedProps.a).f23552a})));
        subParts.a(this.f24431c, new IconData(2130843295, Integer.valueOf(-12887656), Integer.valueOf(2131427421)));
        subParts.a(this.f24432d, new StylingData(feedProps, PaddingStyle.e, Position.BOTTOM));
        return null;
    }

    @Inject
    public SearchResultsWayfinderPartDefinition(TextPartDefinition textPartDefinition, TextIconPartDefinition textIconPartDefinition, BackgroundPartDefinition backgroundPartDefinition) {
        this.f24430b = textPartDefinition;
        this.f24431c = textIconPartDefinition;
        this.f24432d = backgroundPartDefinition;
    }

    public final boolean m27904a(Object obj) {
        return true;
    }

    public final ViewType<BetterTextView> m27902a() {
        return f24427a;
    }

    public static SearchResultsWayfinderPartDefinition m27900a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsWayfinderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24429f) {
                SearchResultsWayfinderPartDefinition searchResultsWayfinderPartDefinition;
                if (a2 != null) {
                    searchResultsWayfinderPartDefinition = (SearchResultsWayfinderPartDefinition) a2.a(f24429f);
                } else {
                    searchResultsWayfinderPartDefinition = f24428e;
                }
                if (searchResultsWayfinderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27901b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24429f, b3);
                        } else {
                            f24428e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsWayfinderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
