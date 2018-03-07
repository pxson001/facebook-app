package com.facebook.search.results.rows.sections.answer;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
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
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.search.results.model.unit.answer.SearchResultsTimeUnit;
import javax.inject.Inject;

@ContextScoped
/* compiled from: REVIEW_WITH_NO_ATTACHMENT */
public class SearchResultsTimeHeaderPartDefinition<E extends HasPositionInformation> extends MultiRowSinglePartDefinition<FeedProps<SearchResultsTimeUnit>, Void, E, SearchResultsTimeHeaderView> {
    private static final ViewType<SearchResultsTimeHeaderView> f23609a = new C25261();
    private static SearchResultsTimeHeaderPartDefinition f23610c;
    private static final Object f23611d = new Object();
    private final BackgroundPartDefinition f23612b;

    /* compiled from: REVIEW_WITH_NO_ATTACHMENT */
    final class C25261 extends ViewType<SearchResultsTimeHeaderView> {
        C25261() {
        }

        public final View m27272a(Context context) {
            return new SearchResultsTimeHeaderView(context);
        }
    }

    private static SearchResultsTimeHeaderPartDefinition m27274b(InjectorLike injectorLike) {
        return new SearchResultsTimeHeaderPartDefinition(BackgroundPartDefinition.a(injectorLike));
    }

    public final Object m27276a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        subParts.a(this.f23612b, new StylingData((FeedProps) obj, PaddingStyle.p, Position.MIDDLE));
        return null;
    }

    public final /* bridge */ /* synthetic */ void m27277a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 951408143);
        SearchResultsTimeHeaderView searchResultsTimeHeaderView = (SearchResultsTimeHeaderView) view;
        Uri uri = ((SearchResultsTimeUnit) ((FeedProps) obj).a).f23556c;
        if (uri != null) {
            searchResultsTimeHeaderView.f23614b.a(uri, SearchResultsTimeHeaderView.f23613a);
        }
        Logger.a(8, EntryType.MARK_POP, 738661395, a);
    }

    @Inject
    public SearchResultsTimeHeaderPartDefinition(BackgroundPartDefinition backgroundPartDefinition) {
        this.f23612b = backgroundPartDefinition;
    }

    public final ViewType<SearchResultsTimeHeaderView> m27275a() {
        return f23609a;
    }

    public final boolean m27278a(Object obj) {
        return true;
    }

    public static SearchResultsTimeHeaderPartDefinition m27273a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsTimeHeaderPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23611d) {
                SearchResultsTimeHeaderPartDefinition searchResultsTimeHeaderPartDefinition;
                if (a2 != null) {
                    searchResultsTimeHeaderPartDefinition = (SearchResultsTimeHeaderPartDefinition) a2.a(f23611d);
                } else {
                    searchResultsTimeHeaderPartDefinition = f23610c;
                }
                if (searchResultsTimeHeaderPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27274b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23611d, b3);
                        } else {
                            f23610c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsTimeHeaderPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
