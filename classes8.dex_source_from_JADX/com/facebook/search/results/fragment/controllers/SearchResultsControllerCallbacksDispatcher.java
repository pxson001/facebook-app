package com.facebook.search.results.fragment.controllers;

import com.facebook.controllercallbacks.api.BaseDispatcher;
import com.facebook.controllercallbacks.api.SetUp;
import com.facebook.controllercallbacks.api.TearDown;
import com.facebook.controllercallbacks.fragment.ResumePauseCallbacks;
import com.facebook.search.results.environment.SearchResultsEnvironment;

/* compiled from: SHOW_PASSWORD_CHECKED */
public class SearchResultsControllerCallbacksDispatcher extends BaseDispatcher implements ResumePauseCallbacks {
    public SearchResultsMutationsController f22994a;

    public SearchResultsControllerCallbacksDispatcher(SearchResultsMutationsController searchResultsMutationsController) {
        this.f22994a = searchResultsMutationsController;
    }

    @SetUp
    public final void m26626c() {
        if (this.f22994a != null) {
            this.f22994a.m26630c();
        }
    }

    @TearDown
    public final void m26627d() {
        if (this.f22994a != null) {
            this.f22994a.m26631d();
        }
    }

    public final void m26625a(SearchResultsEnvironment searchResultsEnvironment) {
        if (this.f22994a != null) {
            this.f22994a.f22998b = searchResultsEnvironment;
        }
    }

    public final void m26624a() {
        this.f22994a = null;
        super.a();
    }
}
