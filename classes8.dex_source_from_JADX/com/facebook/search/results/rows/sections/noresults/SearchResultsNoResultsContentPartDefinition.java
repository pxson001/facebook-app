package com.facebook.search.results.rows.sections.noresults;

import android.content.Context;
import android.view.View;
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
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.search.results.model.unit.SearchResultsResultsNoUnit;
import javax.inject.Inject;

@ContextScoped
/* compiled from: PYMK */
public class SearchResultsNoResultsContentPartDefinition extends MultiRowSinglePartDefinition<FeedProps<SearchResultsResultsNoUnit>, Void, HasPositionInformation, SearchResultsNoResultsTipsView> {
    public static final ViewType f24702a = new C26071();
    private static SearchResultsNoResultsContentPartDefinition f24703c;
    private static final Object f24704d = new Object();
    private final BackgroundPartDefinition f24705b;

    /* compiled from: PYMK */
    final class C26071 extends ViewType {
        C26071() {
        }

        public final View m28118a(Context context) {
            return new SearchResultsNoResultsTipsView(context);
        }
    }

    private static SearchResultsNoResultsContentPartDefinition m28120b(InjectorLike injectorLike) {
        return new SearchResultsNoResultsContentPartDefinition(BackgroundPartDefinition.a(injectorLike));
    }

    public final Object m28122a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f24705b, new StylingData((FeedProps) obj, PaddingStyle.a));
        return null;
    }

    public final /* bridge */ /* synthetic */ void m28123a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1388751246);
        SearchResultsNoResultsTipsView searchResultsNoResultsTipsView = (SearchResultsNoResultsTipsView) view;
        searchResultsNoResultsTipsView.f24712b.setText(((SearchResultsResultsNoUnit) ((FeedProps) obj).a).f23507a);
        Logger.a(8, EntryType.MARK_POP, -825565745, a);
    }

    @Inject
    public SearchResultsNoResultsContentPartDefinition(BackgroundPartDefinition backgroundPartDefinition) {
        this.f24705b = backgroundPartDefinition;
    }

    public final ViewType m28121a() {
        return f24702a;
    }

    public final boolean m28124a(Object obj) {
        return true;
    }

    public static SearchResultsNoResultsContentPartDefinition m28119a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsNoResultsContentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24704d) {
                SearchResultsNoResultsContentPartDefinition searchResultsNoResultsContentPartDefinition;
                if (a2 != null) {
                    searchResultsNoResultsContentPartDefinition = (SearchResultsNoResultsContentPartDefinition) a2.a(f24704d);
                } else {
                    searchResultsNoResultsContentPartDefinition = f24703c;
                }
                if (searchResultsNoResultsContentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m28120b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24704d, b3);
                        } else {
                            f24703c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsNoResultsContentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
