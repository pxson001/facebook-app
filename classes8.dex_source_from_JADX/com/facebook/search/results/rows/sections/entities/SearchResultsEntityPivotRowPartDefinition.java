package com.facebook.search.results.rows.sections.entities;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.debug.log.BLog;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.widget.contentview.ContentViewWithButton;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
import com.facebook.graphql.enums.GraphQLGraphSearchResultRole;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.multirow.parts.ContentViewTitlePartDefinition;
import com.facebook.multirow.parts.TextAppearancePartDefinition;
import com.facebook.multirow.parts.TextPartDefinition;
import com.facebook.search.logging.SearchResultsLogger;
import com.facebook.search.logging.SearchResultsLogger.Event;
import com.facebook.search.results.environment.HasFeedItemPosition;
import com.facebook.search.results.environment.HasSearchResultsContext;
import com.facebook.search.results.model.SearchResultsMutableContext;
import com.facebook.search.results.model.contract.SearchResultsSeeMoreFeedUnit;
import com.facebook.search.results.model.unit.SearchResultsEntityPivotUnit;
import com.facebook.search.results.rows.sections.common.SearchResultsSeeMoreClickListenerPartDefinition;
import com.facebook.search.results.rows.sections.common.SearchResultsSeeMoreClickListenerPartDefinition.SeeMoreData;
import com.facebook.search.results.rows.sections.common.SearchResultsSeeMoreLogger;
import com.facebook.search.results.rows.sections.header.SearchResultsTitlePartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: Quick Experiment */
public class SearchResultsEntityPivotRowPartDefinition<E extends HasContext & HasPositionInformation> extends MultiRowSinglePartDefinition<FeedProps<SearchResultsEntityPivotUnit>, Drawable, E, ContentViewWithButton> {
    public static final ViewType<ContentViewWithButton> f24192a = ViewType.a(2130907004);
    private static final PaddingStyle f24193b;
    private static final SearchResultsSeeMoreLogger f24194c = new C25751();
    private static SearchResultsEntityPivotRowPartDefinition f24195k;
    private static final Object f24196l = new Object();
    private final ContentViewTitlePartDefinition f24197d;
    private final TextPartDefinition f24198e;
    private final TextAppearancePartDefinition f24199f;
    private final GlyphColorizer f24200g;
    private final BackgroundPartDefinition f24201h;
    private final AllCapsTransformationMethod f24202i;
    private final Lazy<SearchResultsSeeMoreClickListenerPartDefinition> f24203j;

    /* compiled from: Quick Experiment */
    final class C25751 implements SearchResultsSeeMoreLogger {
        C25751() {
        }

        public final <N extends HasSearchResultsContext & HasFeedItemPosition> void mo1334a(SearchResultsLogger searchResultsLogger, N n, SearchResultsSeeMoreFeedUnit searchResultsSeeMoreFeedUnit) {
            SearchResultsMutableContext s = n.mo1248s();
            String str = (String) ((SearchResultsEntityPivotUnit) searchResultsSeeMoreFeedUnit).mo1322l().orNull();
            HoneyClientEvent a = SearchResultsLogger.m25459a(Event.SEE_MORE_ON_MODULE_TAPPED, s).a("results_module_role", GraphQLGraphSearchResultRole.ENTITY_PIVOTS).b("results_module_extra_logging", str).a("results_module_display_style", searchResultsSeeMoreFeedUnit.mo1331n());
            searchResultsLogger.f21958c.a(a);
            if (BLog.b(3)) {
                String str2 = a.d;
                a.u();
            }
        }
    }

    private static SearchResultsEntityPivotRowPartDefinition m27731b(InjectorLike injectorLike) {
        return new SearchResultsEntityPivotRowPartDefinition(ContentViewTitlePartDefinition.a(injectorLike), TextPartDefinition.a(injectorLike), TextAppearancePartDefinition.a(injectorLike), GlyphColorizer.a(injectorLike), IdBasedLazy.a(injectorLike, 10672), AllCapsTransformationMethod.b(injectorLike), BackgroundPartDefinition.a(injectorLike));
    }

    public final Object m27733a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        int i;
        int i2;
        FeedProps feedProps = (FeedProps) obj;
        HasContext hasContext = (HasContext) anyEnvironment;
        subParts.a(this.f24201h, new StylingData(null, f24193b, Position.DIVIDER_BOTTOM_NON_TOP));
        SearchResultsEntityPivotUnit searchResultsEntityPivotUnit = (SearchResultsEntityPivotUnit) feedProps.a;
        subParts.a(this.f24197d, searchResultsEntityPivotUnit.f23480b);
        if (searchResultsEntityPivotUnit.f23482d > 0) {
            subParts.a((SinglePartDefinition) this.f24203j.get(), new SeeMoreData(searchResultsEntityPivotUnit, f24194c, 2131239063, false));
            i = 2131239063;
            i2 = 2131624532;
        } else {
            i = 2131239064;
            i2 = 2131624528;
        }
        CharSequence string = hasContext.getContext().getString(i);
        subParts.a(2131567293, this.f24198e, string == null ? "" : this.f24202i.getTransformation(string, null).toString());
        subParts.a(2131567293, this.f24199f, Integer.valueOf(i2));
        Integer a = SearchResultsTitlePartDefinition.m27891a(searchResultsEntityPivotUnit.mo1321k(), searchResultsEntityPivotUnit.mo1331n());
        return this.f24200g.a(a.intValue(), ((Integer) SearchResultsTitlePartDefinition.f24412b.get(a)).intValue());
    }

    public final /* bridge */ /* synthetic */ void m27734a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 2031074891);
        ((ContentViewWithButton) view).setThumbnailDrawable((Drawable) obj2);
        Logger.a(8, EntryType.MARK_POP, -482117963, a);
    }

    public final boolean m27735a(Object obj) {
        SearchResultsEntityPivotUnit searchResultsEntityPivotUnit = (SearchResultsEntityPivotUnit) ((FeedProps) obj).a;
        return (searchResultsEntityPivotUnit.f23480b == null || searchResultsEntityPivotUnit.mo1321k() == null || searchResultsEntityPivotUnit.mo1321k() == GraphQLGraphSearchResultRole.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) ? false : true;
    }

    static {
        Builder a = Builder.a();
        a.b = 2.0f;
        a = a;
        a.c = 4.0f;
        f24193b = a.i();
    }

    public static SearchResultsEntityPivotRowPartDefinition m27730a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsEntityPivotRowPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f24196l) {
                SearchResultsEntityPivotRowPartDefinition searchResultsEntityPivotRowPartDefinition;
                if (a2 != null) {
                    searchResultsEntityPivotRowPartDefinition = (SearchResultsEntityPivotRowPartDefinition) a2.a(f24196l);
                } else {
                    searchResultsEntityPivotRowPartDefinition = f24195k;
                }
                if (searchResultsEntityPivotRowPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27731b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f24196l, b3);
                        } else {
                            f24195k = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsEntityPivotRowPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public SearchResultsEntityPivotRowPartDefinition(ContentViewTitlePartDefinition contentViewTitlePartDefinition, TextPartDefinition textPartDefinition, TextAppearancePartDefinition textAppearancePartDefinition, GlyphColorizer glyphColorizer, Lazy<SearchResultsSeeMoreClickListenerPartDefinition> lazy, AllCapsTransformationMethod allCapsTransformationMethod, BackgroundPartDefinition backgroundPartDefinition) {
        this.f24197d = contentViewTitlePartDefinition;
        this.f24198e = textPartDefinition;
        this.f24199f = textAppearancePartDefinition;
        this.f24200g = glyphColorizer;
        this.f24203j = lazy;
        this.f24202i = allCapsTransformationMethod;
        this.f24201h = backgroundPartDefinition;
    }

    public final ViewType<ContentViewWithButton> m27732a() {
        return f24192a;
    }
}
