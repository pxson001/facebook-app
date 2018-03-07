package com.facebook.search.results.rows.sections.central;

import com.facebook.feed.rows.core.persistence.ContextStateKey;
import com.facebook.search.results.model.unit.SearchResultsCentralWikiUnit;
import com.facebook.search.results.protocol.wiki.SearchResultsWikiModuleInterfaces.SearchResultsWikiModulePage;

/* compiled from: RESPOND_TO_FRIEND_SUGGEST_TASK */
public class SearchResultsCentralEntityWikiState {
    public boolean f23693a;
    public boolean f23694b;

    /* compiled from: RESPOND_TO_FRIEND_SUGGEST_TASK */
    final class C25341 implements ContextStateKey<String, SearchResultsCentralEntityWikiState> {
        final /* synthetic */ SearchResultsCentralWikiUnit f23691a;

        C25341(SearchResultsCentralWikiUnit searchResultsCentralWikiUnit) {
            this.f23691a = searchResultsCentralWikiUnit;
        }

        public final Object m27342a() {
            return new SearchResultsCentralEntityWikiState(true, true);
        }

        public final Object m27343b() {
            return this.f23691a.f23457a.eP() + this.f23691a.m27145m();
        }
    }

    /* compiled from: RESPOND_TO_FRIEND_SUGGEST_TASK */
    final class C25352 implements ContextStateKey<String, SearchResultsCentralEntityWikiState> {
        final /* synthetic */ SearchResultsWikiModulePage f23692a;

        C25352(SearchResultsWikiModulePage searchResultsWikiModulePage) {
            this.f23692a = searchResultsWikiModulePage;
        }

        public final Object m27344a() {
            return new SearchResultsCentralEntityWikiState(true, true);
        }

        public final Object m27345b() {
            return this.f23692a.mo573D() + (this.f23692a.jl_() != null ? this.f23692a.jl_().m10625a() : "");
        }
    }

    public SearchResultsCentralEntityWikiState(boolean z, boolean z2) {
        this.f23693a = z;
        this.f23694b = z2;
    }

    public final boolean m27348a() {
        return this.f23694b && this.f23693a;
    }

    public static ContextStateKey<String, SearchResultsCentralEntityWikiState> m27346a(SearchResultsCentralWikiUnit searchResultsCentralWikiUnit) {
        return new C25341(searchResultsCentralWikiUnit);
    }

    public static ContextStateKey<String, SearchResultsCentralEntityWikiState> m27347a(SearchResultsWikiModulePage searchResultsWikiModulePage) {
        return new C25352(searchResultsWikiModulePage);
    }
}
