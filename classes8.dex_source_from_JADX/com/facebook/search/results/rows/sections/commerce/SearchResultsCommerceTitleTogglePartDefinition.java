package com.facebook.search.results.rows.sections.commerce;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.styling.BackgroundPartDefinition;
import com.facebook.feed.rows.styling.BackgroundPartDefinition.StylingData;
import com.facebook.feed.rows.styling.BackgroundStyler.Position;
import com.facebook.feed.rows.styling.PaddingStyle;
import com.facebook.feed.rows.styling.PaddingStyle.Builder;
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
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.search.results.environment.SearchResultsFeedEnvironment;
import com.facebook.search.results.environment.SearchResultsFeedEnvironmentGenerated;
import com.facebook.search.results.model.unit.SearchResultsCollectionUnit;
import com.facebook.search.results.model.unit.SearchResultsProductItemUnit;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.CustomLinearLayout;
import javax.inject.Inject;

@ContextScoped
/* compiled from: REACT_NATIVE */
public class SearchResultsCommerceTitleTogglePartDefinition extends MultiRowSinglePartDefinition<FeedProps<SearchResultsCollectionUnit<SearchResultsProductItemUnit>>, State, SearchResultsFeedEnvironment, ContentView> {
    public static final ViewType<ContentView> f23976a = ViewType.a(2130906993);
    private static final PaddingStyle f23977b;
    private static SearchResultsCommerceTitleTogglePartDefinition f23978e;
    private static final Object f23979f = new Object();
    private final QeAccessor f23980c;
    private final BackgroundPartDefinition f23981d;

    /* compiled from: REACT_NATIVE */
    public class GridViewToggleStatusKey implements ContextStateKey<String, Boolean> {
        private final String f23971a = "grid_view_toggle_status_key";
        private final Boolean f23972b;

        public GridViewToggleStatusKey(Boolean bool) {
            this.f23972b = bool;
        }

        public final Object m27548a() {
            return this.f23972b;
        }

        public final Object m27549b() {
            return this.f23971a;
        }
    }

    /* compiled from: REACT_NATIVE */
    public class State {
        public final OnClickListener f23973a;
        public final OnClickListener f23974b;
        public final Boolean f23975c;

        public State(OnClickListener onClickListener, OnClickListener onClickListener2, Boolean bool) {
            this.f23973a = onClickListener;
            this.f23974b = onClickListener2;
            this.f23975c = bool;
        }
    }

    private static SearchResultsCommerceTitleTogglePartDefinition m27551b(InjectorLike injectorLike) {
        return new SearchResultsCommerceTitleTogglePartDefinition((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), BackgroundPartDefinition.a(injectorLike));
    }

    public final Object m27553a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final SearchResultsFeedEnvironmentGenerated searchResultsFeedEnvironmentGenerated = (SearchResultsFeedEnvironmentGenerated) anyEnvironment;
        subParts.a(this.f23981d, new StylingData(null, f23977b, Position.TOP));
        return new State(new OnClickListener(this) {
            final /* synthetic */ SearchResultsCommerceTitleTogglePartDefinition f23968b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 2109767689);
                if (view.isSelected()) {
                    Logger.a(2, EntryType.UI_INPUT_END, 1233078542, a);
                    return;
                }
                searchResultsFeedEnvironmentGenerated.a(new GridViewToggleStatusKey(Boolean.valueOf(false)), Boolean.valueOf(false));
                searchResultsFeedEnvironmentGenerated.hL_();
                LogUtils.a(788992256, a);
            }
        }, new OnClickListener(this) {
            final /* synthetic */ SearchResultsCommerceTitleTogglePartDefinition f23970b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1698619743);
                if (view.isSelected()) {
                    Logger.a(2, EntryType.UI_INPUT_END, 442479133, a);
                    return;
                }
                searchResultsFeedEnvironmentGenerated.a(new GridViewToggleStatusKey(Boolean.valueOf(true)), Boolean.valueOf(true));
                searchResultsFeedEnvironmentGenerated.hL_();
                LogUtils.a(655051288, a);
            }
        }, (Boolean) searchResultsFeedEnvironmentGenerated.a(new GridViewToggleStatusKey(Boolean.valueOf(false))));
    }

    public final /* bridge */ /* synthetic */ void m27554a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1124866136);
        FeedProps feedProps = (FeedProps) obj;
        State state = (State) obj2;
        ContentView contentView = (ContentView) view;
        CustomLinearLayout customLinearLayout = (CustomLinearLayout) contentView.a;
        GlyphView glyphView = (GlyphView) customLinearLayout.findViewById(2131567283);
        GlyphView glyphView2 = (GlyphView) customLinearLayout.findViewById(2131567284);
        glyphView.setOnClickListener(state.f23973a);
        glyphView2.setOnClickListener(state.f23974b);
        glyphView.setSelected(!state.f23975c.booleanValue());
        glyphView2.setSelected(state.f23975c.booleanValue());
        contentView.setTitleText((CharSequence) ((SearchResultsCollectionUnit) feedProps.a).f23462c.orNull());
        Logger.a(8, EntryType.MARK_POP, 758967774, a);
    }

    public final void m27556b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        CustomLinearLayout customLinearLayout = (CustomLinearLayout) ((ContentView) view).a;
        customLinearLayout.findViewById(2131567283).setOnClickListener(null);
        customLinearLayout.findViewById(2131567284).setOnClickListener(null);
    }

    public static SearchResultsCommerceTitleTogglePartDefinition m27550a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchResultsCommerceTitleTogglePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23979f) {
                SearchResultsCommerceTitleTogglePartDefinition searchResultsCommerceTitleTogglePartDefinition;
                if (a2 != null) {
                    searchResultsCommerceTitleTogglePartDefinition = (SearchResultsCommerceTitleTogglePartDefinition) a2.a(f23979f);
                } else {
                    searchResultsCommerceTitleTogglePartDefinition = f23978e;
                }
                if (searchResultsCommerceTitleTogglePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27551b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23979f, b3);
                        } else {
                            f23978e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchResultsCommerceTitleTogglePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    static {
        Builder a = Builder.a();
        a.b = 2.0f;
        f23977b = a.i();
    }

    @Inject
    public SearchResultsCommerceTitleTogglePartDefinition(QeAccessor qeAccessor, BackgroundPartDefinition backgroundPartDefinition) {
        this.f23980c = qeAccessor;
        this.f23981d = backgroundPartDefinition;
    }

    public final ViewType<ContentView> m27552a() {
        return f23976a;
    }

    public final boolean m27555a(Object obj) {
        return true;
    }
}
