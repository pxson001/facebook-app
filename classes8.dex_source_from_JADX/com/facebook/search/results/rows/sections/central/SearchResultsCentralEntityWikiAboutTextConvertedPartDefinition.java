package com.facebook.search.results.rows.sections.central;

import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Shader.TileMode;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.graphql.model.interfaces.CacheableEntity;
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
import com.facebook.search.results.model.SearchResultsProps;
import com.facebook.search.results.protocol.wiki.SearchResultsWikiModuleInterfaces.SearchResultsWikiModulePage;
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;

@ContextScoped
/* compiled from: RESULTS_TEXT */
public class SearchResultsCentralEntityWikiAboutTextConvertedPartDefinition<E extends HasPersistentState & HasPositionInformation> extends MultiRowSinglePartDefinition<SearchResultsProps<SearchResultsWikiModulePage>, Void, E, BetterTextView> {
    public static final ViewType<BetterTextView> f23643a = ViewType.a(2130903531);
    public static final PaddingStyle f23644b;
    public static final PaddingStyle f23645c;
    private static SearchResultsCentralEntityWikiAboutTextConvertedPartDefinition f23646f;
    private static final Object f23647g = new Object();
    private final BackgroundPartDefinition f23648d;
    private final SearchResultsCentralEntityWikiClickBinderConvertedPartDefinition f23649e;

    /* compiled from: RESULTS_TEXT */
    class C25281 implements CacheableEntity {
        final /* synthetic */ SearchResultsCentralEntityWikiAboutTextConvertedPartDefinition f23641a;

        C25281(SearchResultsCentralEntityWikiAboutTextConvertedPartDefinition searchResultsCentralEntityWikiAboutTextConvertedPartDefinition) {
            this.f23641a = searchResultsCentralEntityWikiAboutTextConvertedPartDefinition;
        }

        public final String m27297g() {
            return null;
        }
    }

    /* compiled from: RESULTS_TEXT */
    public class C25292 implements CacheableEntity {
        final /* synthetic */ SearchResultsCentralEntityWikiAboutTextConvertedPartDefinition f23642a;

        public C25292(SearchResultsCentralEntityWikiAboutTextConvertedPartDefinition searchResultsCentralEntityWikiAboutTextConvertedPartDefinition) {
            this.f23642a = searchResultsCentralEntityWikiAboutTextConvertedPartDefinition;
        }

        public final String m27298g() {
            return null;
        }
    }

    private static SearchResultsCentralEntityWikiAboutTextConvertedPartDefinition m27301b(InjectorLike injectorLike) {
        return new SearchResultsCentralEntityWikiAboutTextConvertedPartDefinition(SearchResultsCentralEntityWikiClickBinderConvertedPartDefinition.m27313a(injectorLike), BackgroundPartDefinition.a(injectorLike));
    }

    public final Object m27303a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        SearchResultsProps searchResultsProps = (SearchResultsProps) obj;
        SearchResultsCentralEntityWikiState searchResultsCentralEntityWikiState = (SearchResultsCentralEntityWikiState) ((HasPersistentState) anyEnvironment).a(SearchResultsCentralEntityWikiState.m27347a((SearchResultsWikiModulePage) searchResultsProps.f23388a), new C25281(this));
        if (searchResultsCentralEntityWikiState.f23694b) {
            subParts.a(this.f23649e, searchResultsProps);
        }
        subParts.a(this.f23648d, new StylingData(null, searchResultsCentralEntityWikiState.m27348a() ? f23644b : f23645c, searchResultsCentralEntityWikiState.m27348a() ? Position.MIDDLE : Position.DIVIDER_BOTTOM_NON_TOP));
        return null;
    }

    public final /* bridge */ /* synthetic */ void m27304a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1651118551);
        SearchResultsProps searchResultsProps = (SearchResultsProps) obj;
        m27300a((BetterTextView) view, (SearchResultsCentralEntityWikiState) ((HasPersistentState) anyEnvironment).a(SearchResultsCentralEntityWikiState.m27347a((SearchResultsWikiModulePage) searchResultsProps.f23388a), new C25292(this)), ((SearchResultsWikiModulePage) searchResultsProps.f23388a).jl_().m10625a());
        Logger.a(8, EntryType.MARK_POP, -1469222971, a);
    }

    public final boolean m27305a(Object obj) {
        return ((SearchResultsWikiModulePage) ((SearchResultsProps) obj).f23388a).jl_() != null;
    }

    static {
        Builder a = Builder.a();
        a.b = -6.0f;
        a = a;
        a.c = -6.0f;
        f23644b = a.i();
        a = Builder.a();
        a.b = -6.0f;
        f23645c = a.i();
    }

    @Inject
    public SearchResultsCentralEntityWikiAboutTextConvertedPartDefinition(SearchResultsCentralEntityWikiClickBinderConvertedPartDefinition searchResultsCentralEntityWikiClickBinderConvertedPartDefinition, BackgroundPartDefinition backgroundPartDefinition) {
        this.f23649e = searchResultsCentralEntityWikiClickBinderConvertedPartDefinition;
        this.f23648d = backgroundPartDefinition;
    }

    public static SearchResultsCentralEntityWikiAboutTextConvertedPartDefinition m27299a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsCentralEntityWikiAboutTextConvertedPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23647g) {
                SearchResultsCentralEntityWikiAboutTextConvertedPartDefinition searchResultsCentralEntityWikiAboutTextConvertedPartDefinition;
                if (a2 != null) {
                    searchResultsCentralEntityWikiAboutTextConvertedPartDefinition = (SearchResultsCentralEntityWikiAboutTextConvertedPartDefinition) a2.a(f23647g);
                } else {
                    searchResultsCentralEntityWikiAboutTextConvertedPartDefinition = f23646f;
                }
                if (searchResultsCentralEntityWikiAboutTextConvertedPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27301b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23647g, b3);
                        } else {
                            f23646f = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsCentralEntityWikiAboutTextConvertedPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType<BetterTextView> m27302a() {
        return f23643a;
    }

    public static void m27300a(BetterTextView betterTextView, SearchResultsCentralEntityWikiState searchResultsCentralEntityWikiState, String str) {
        betterTextView.setText(str);
        if (searchResultsCentralEntityWikiState.m27348a()) {
            int dimension = (int) betterTextView.getResources().getDimension(2131432605);
            int dimension2 = (int) betterTextView.getResources().getDimension(2131432604);
            int color = betterTextView.getResources().getColor(2131361973);
            betterTextView.setMaxHeight(dimension2);
            float f = 0.0f;
            betterTextView.getPaint().setShader(new LinearGradient(0.0f, (float) (dimension2 - dimension), f, (float) dimension2, new int[]{color, -1}, null, TileMode.CLAMP));
            return;
        }
        betterTextView.setMaxHeight(Integer.MAX_VALUE);
        betterTextView.getPaint().setShader(null);
    }
}
