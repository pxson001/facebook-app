package com.facebook.search.typeahead.rows;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.CollectionUtil;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.fbui.widget.contentview.ContentView.ThumbnailSize;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.enums.GraphQLGraphSearchResultsDisplayStyle;
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
import com.facebook.search.model.NullStateSuggestionTypeaheadUnit;
import com.facebook.search.module.GraphSearchGatekeepers;
import com.facebook.search.suggestions.environment.SearchSuggestionsEnvironment;
import com.facebook.search.suggestions.viewbinder.KeywordSuggestionViewBinder;
import javax.inject.Inject;

@ContextScoped
/* compiled from: vault_sync_job_processor */
public class SearchTypeaheadNullStateSuggestionPartDefinition extends MultiRowSinglePartDefinition<NullStateSuggestionTypeaheadUnit, State, SearchSuggestionsEnvironment, ContentView> {
    public static final ViewType<ContentView> f588a = ViewType.a(2130906749);
    private static SearchTypeaheadNullStateSuggestionPartDefinition f589e;
    private static final Object f590f = new Object();
    private final Resources f591b;
    public final GatekeeperStoreImpl f592c;
    private final KeywordSuggestionViewBinder f593d;

    /* compiled from: vault_sync_job_processor */
    public final class State {
        public final String f586a;
        public final Drawable f587b;

        public State(String str, Drawable drawable) {
            this.f586a = str;
            this.f587b = drawable;
        }
    }

    private static SearchTypeaheadNullStateSuggestionPartDefinition m675b(InjectorLike injectorLike) {
        return new SearchTypeaheadNullStateSuggestionPartDefinition(ResourcesMethodAutoProvider.a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike), KeywordSuggestionViewBinder.m493a(injectorLike));
    }

    public final Object m677a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        NullStateSuggestionTypeaheadUnit nullStateSuggestionTypeaheadUnit = (NullStateSuggestionTypeaheadUnit) obj;
        return new State(StringFormatUtil.formatStrLocaleSafe(this.f591b.getQuantityString(2131689689, nullStateSuggestionTypeaheadUnit.i), Integer.valueOf(nullStateSuggestionTypeaheadUnit.i)), this.f593d.m501a(((SearchSuggestionsEnvironment) anyEnvironment).getContext(), nullStateSuggestionTypeaheadUnit.h, false));
    }

    public final /* bridge */ /* synthetic */ void m678a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -1359397871);
        NullStateSuggestionTypeaheadUnit nullStateSuggestionTypeaheadUnit = (NullStateSuggestionTypeaheadUnit) obj;
        State state = (State) obj2;
        ContentView contentView = (ContentView) view;
        contentView.setThumbnailSize(ThumbnailSize.SMALL);
        if (CollectionUtil.b(nullStateSuggestionTypeaheadUnit.k) && nullStateSuggestionTypeaheadUnit.k.get(0) == GraphQLGraphSearchResultsDisplayStyle.BLENDED_VIDEOS) {
            contentView.setShowThumbnail(false);
        } else if (nullStateSuggestionTypeaheadUnit.z()) {
            contentView.setThumbnailView(null);
            contentView.setThumbnailDrawable(state.f587b);
        } else if (Uri.EMPTY.equals(nullStateSuggestionTypeaheadUnit.e)) {
            contentView.setThumbnailUri(null);
        } else {
            contentView.setThumbnailUri(nullStateSuggestionTypeaheadUnit.e);
        }
        contentView.setTitleText(nullStateSuggestionTypeaheadUnit.b);
        contentView.setTitleTextAppearance(2131625907);
        contentView.setTitleGravity(contentView.getLocaleGravity());
        if (!this.f592c.a(GraphSearchGatekeepers.a, false) || nullStateSuggestionTypeaheadUnit.i <= 0) {
            contentView.nF_();
            contentView.setMaxLinesFromThumbnailSize(true);
            contentView.setSubtitleText(null);
        } else {
            contentView.setSubtitleGravity(contentView.getLocaleGravity());
            contentView.setSubtitleTextAppearance(2131625918);
            contentView.setSubtitleText(state.f586a);
            contentView.setMaxLinesFromThumbnailSize(false);
            contentView.e(1, 1);
        }
        contentView.setThumbnailGravity(16);
        Logger.a(8, EntryType.MARK_POP, -760249529, a);
    }

    @Inject
    public SearchTypeaheadNullStateSuggestionPartDefinition(Resources resources, GatekeeperStoreImpl gatekeeperStoreImpl, KeywordSuggestionViewBinder keywordSuggestionViewBinder) {
        this.f591b = resources;
        this.f592c = gatekeeperStoreImpl;
        this.f593d = keywordSuggestionViewBinder;
    }

    public final ViewType<ContentView> m676a() {
        return f588a;
    }

    public static SearchTypeaheadNullStateSuggestionPartDefinition m674a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SearchTypeaheadNullStateSuggestionPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f590f) {
                SearchTypeaheadNullStateSuggestionPartDefinition searchTypeaheadNullStateSuggestionPartDefinition;
                if (a2 != null) {
                    searchTypeaheadNullStateSuggestionPartDefinition = (SearchTypeaheadNullStateSuggestionPartDefinition) a2.a(f590f);
                } else {
                    searchTypeaheadNullStateSuggestionPartDefinition = f589e;
                }
                if (searchTypeaheadNullStateSuggestionPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m675b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f590f, b3);
                        } else {
                            f589e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = searchTypeaheadNullStateSuggestionPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final boolean m679a(Object obj) {
        return true;
    }
}
