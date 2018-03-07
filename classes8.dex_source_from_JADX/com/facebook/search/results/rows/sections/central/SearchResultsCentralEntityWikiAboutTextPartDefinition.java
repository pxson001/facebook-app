package com.facebook.search.results.rows.sections.central;

import android.content.Context;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
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
import com.facebook.search.results.model.unit.SearchResultsCentralWikiUnit;
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;

@ContextScoped
@Deprecated
/* compiled from: RESULTS_SEE_MORE */
public class SearchResultsCentralEntityWikiAboutTextPartDefinition<E extends HasPersistentState & HasPositionInformation> extends MultiRowSinglePartDefinition<FeedProps<SearchResultsCentralWikiUnit>, Void, E, BetterTextView> {
    private static SearchResultsCentralEntityWikiAboutTextPartDefinition f23650c;
    private static final Object f23651d = new Object();
    private final BackgroundPartDefinition f23652a;
    private final SearchResultsCentralEntityWikiClickBinderPartDefinition f23653b;

    private static SearchResultsCentralEntityWikiAboutTextPartDefinition m27307b(InjectorLike injectorLike) {
        return new SearchResultsCentralEntityWikiAboutTextPartDefinition(SearchResultsCentralEntityWikiClickBinderPartDefinition.m27318a(injectorLike), BackgroundPartDefinition.a(injectorLike));
    }

    public final Object m27309a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        SearchResultsCentralWikiUnit searchResultsCentralWikiUnit = (SearchResultsCentralWikiUnit) ((FeedProps) obj).a;
        SearchResultsCentralEntityWikiState searchResultsCentralEntityWikiState = (SearchResultsCentralEntityWikiState) ((HasPersistentState) anyEnvironment).a(SearchResultsCentralEntityWikiState.m27346a(searchResultsCentralWikiUnit), searchResultsCentralWikiUnit);
        if (searchResultsCentralEntityWikiState.f23694b) {
            subParts.a(this.f23653b, searchResultsCentralWikiUnit);
        }
        subParts.a(this.f23652a, new StylingData(null, searchResultsCentralEntityWikiState.m27348a() ? SearchResultsCentralEntityWikiAboutTextConvertedPartDefinition.f23644b : SearchResultsCentralEntityWikiAboutTextConvertedPartDefinition.f23645c, searchResultsCentralEntityWikiState.m27348a() ? Position.MIDDLE : Position.DIVIDER_BOTTOM_NON_TOP));
        return null;
    }

    public final /* bridge */ /* synthetic */ void m27310a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 633983886);
        BetterTextView betterTextView = (BetterTextView) view;
        SearchResultsCentralWikiUnit searchResultsCentralWikiUnit = (SearchResultsCentralWikiUnit) ((FeedProps) obj).a;
        SearchResultsCentralEntityWikiAboutTextConvertedPartDefinition.m27300a(betterTextView, (SearchResultsCentralEntityWikiState) ((HasPersistentState) anyEnvironment).a(SearchResultsCentralEntityWikiState.m27346a(searchResultsCentralWikiUnit), searchResultsCentralWikiUnit), searchResultsCentralWikiUnit.m27145m());
        Logger.a(8, EntryType.MARK_POP, 1935755117, a);
    }

    public final boolean m27311a(Object obj) {
        return ((SearchResultsCentralWikiUnit) ((FeedProps) obj).a).m27145m() != null;
    }

    @Inject
    public SearchResultsCentralEntityWikiAboutTextPartDefinition(SearchResultsCentralEntityWikiClickBinderPartDefinition searchResultsCentralEntityWikiClickBinderPartDefinition, BackgroundPartDefinition backgroundPartDefinition) {
        this.f23653b = searchResultsCentralEntityWikiClickBinderPartDefinition;
        this.f23652a = backgroundPartDefinition;
    }

    public final ViewType<BetterTextView> m27308a() {
        return SearchResultsCentralEntityWikiAboutTextConvertedPartDefinition.f23643a;
    }

    public static SearchResultsCentralEntityWikiAboutTextPartDefinition m27306a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsCentralEntityWikiAboutTextPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23651d) {
                SearchResultsCentralEntityWikiAboutTextPartDefinition searchResultsCentralEntityWikiAboutTextPartDefinition;
                if (a2 != null) {
                    searchResultsCentralEntityWikiAboutTextPartDefinition = (SearchResultsCentralEntityWikiAboutTextPartDefinition) a2.a(f23651d);
                } else {
                    searchResultsCentralEntityWikiAboutTextPartDefinition = f23650c;
                }
                if (searchResultsCentralEntityWikiAboutTextPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27307b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23651d, b3);
                        } else {
                            f23650c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsCentralEntityWikiAboutTextPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
