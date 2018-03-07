package com.facebook.search.quickpromotion;

import android.text.TextUtils;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.graphql.enums.GraphQLSearchAwarenessTemplatesEnum;
import com.facebook.proxygen.HTTPTransportCallback;
import com.facebook.qe.api.QeAccessor;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.facebook.search.protocol.awareness.SearchAwarenessInterfaces.SearchAwarenessSuggestionFieldsFragment;
import com.facebook.search.protocol.awareness.SearchAwarenessModels.SearchAwarenessRootSuggestionFieldsFragmentModel;
import com.facebook.search.protocol.awareness.SearchAwarenessModels.SearchAwarenessSuggestionFieldsFragmentModel;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: show_beeper */
public class SearchAwarenessUnitValidator {
    private final AbstractFbErrorReporter f4894a;
    private final QeAccessor f4895b;
    private StringBuilder f4896c = new StringBuilder();
    private Set<GraphQLSearchAwarenessTemplatesEnum> f4897d = new HashSet();

    @Inject
    public SearchAwarenessUnitValidator(AbstractFbErrorReporter abstractFbErrorReporter, QeAccessor qeAccessor) {
        this.f4894a = abstractFbErrorReporter;
        this.f4895b = qeAccessor;
    }

    public final boolean m8773a(SearchAwarenessRootSuggestionFieldsFragmentModel searchAwarenessRootSuggestionFieldsFragmentModel) {
        boolean z = true;
        boolean z2 = m8769b(searchAwarenessRootSuggestionFieldsFragmentModel) && m8765a((SearchAwarenessSuggestionFieldsFragment) searchAwarenessRootSuggestionFieldsFragmentModel);
        if (!z2) {
            m8763a();
            m8767b();
        }
        this.f4897d.add(searchAwarenessRootSuggestionFieldsFragmentModel.jF_());
        ImmutableList a;
        if (searchAwarenessRootSuggestionFieldsFragmentModel.j() != null) {
            a = searchAwarenessRootSuggestionFieldsFragmentModel.j().a();
        } else {
            a = RegularImmutableList.f535a;
        }
        if (!(z2 && m8766a(r2))) {
            z = false;
        }
        if (!z) {
            m8763a();
        }
        m8767b();
        return z;
    }

    private boolean m8766a(ImmutableList<SearchAwarenessSuggestionFieldsFragmentModel> immutableList) {
        boolean z = true;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            SearchAwarenessSuggestionFieldsFragment searchAwarenessSuggestionFieldsFragment = (SearchAwarenessSuggestionFieldsFragment) immutableList.get(i);
            z = m8765a(searchAwarenessSuggestionFieldsFragment);
            if (this.f4897d.contains(searchAwarenessSuggestionFieldsFragment.jF_())) {
                m8764a("Duplicate configuration for template: " + searchAwarenessSuggestionFieldsFragment.jF_());
                z = false;
            }
            this.f4897d.add(searchAwarenessSuggestionFieldsFragment.jF_());
        }
        return z;
    }

    private boolean m8765a(SearchAwarenessSuggestionFieldsFragment searchAwarenessSuggestionFieldsFragment) {
        switch (1.a[searchAwarenessSuggestionFieldsFragment.jF_().ordinal()]) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
                return m8768b(searchAwarenessSuggestionFieldsFragment);
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                return m8770c(searchAwarenessSuggestionFieldsFragment);
            case 3:
                return m8771d(searchAwarenessSuggestionFieldsFragment);
            case HTTPTransportCallback.LAST_BODY_BYTE_FLUSHED /*4*/:
                return m8772e(searchAwarenessSuggestionFieldsFragment);
            default:
                m8764a("Unsupported template.\n");
                return false;
        }
    }

    private boolean m8768b(SearchAwarenessSuggestionFieldsFragment searchAwarenessSuggestionFieldsFragment) {
        if (!TextUtils.isEmpty(searchAwarenessSuggestionFieldsFragment.g()) || !TextUtils.isEmpty(searchAwarenessSuggestionFieldsFragment.d())) {
            return true;
        }
        m8764a("Both title and description are empty for tooltip unit.\n");
        return false;
    }

    private boolean m8770c(SearchAwarenessSuggestionFieldsFragment searchAwarenessSuggestionFieldsFragment) {
        if (!TextUtils.isEmpty(searchAwarenessSuggestionFieldsFragment.g()) || !TextUtils.isEmpty(searchAwarenessSuggestionFieldsFragment.d())) {
            return true;
        }
        m8764a("Both title and description are empty for tooltip unit.\n");
        return false;
    }

    private boolean m8771d(SearchAwarenessSuggestionFieldsFragment searchAwarenessSuggestionFieldsFragment) {
        boolean z = true;
        if (TextUtils.isEmpty(searchAwarenessSuggestionFieldsFragment.g())) {
            m8764a("Missing title for null state interstitial unit.\n");
            z = false;
        }
        if (searchAwarenessSuggestionFieldsFragment.c() == null || searchAwarenessSuggestionFieldsFragment.c().size() > 3) {
            m8764a("Invalid number of keyword suggestions for null state interstitial unit.\n");
            z = false;
        }
        CharSequence a = this.f4895b.mo581a(ExperimentsForSearchAbTestModule.aA, "");
        CharSequence a2 = this.f4895b.mo581a(ExperimentsForSearchAbTestModule.ay, "");
        if (!this.f4895b.mo596a(ExperimentsForSearchAbTestModule.az, false) || !TextUtils.isEmpty(a) || !TextUtils.isEmpty(a2)) {
            return z;
        }
        m8764a("Both title and description are empty for typeahead tooltip unit.\n");
        return false;
    }

    private boolean m8772e(SearchAwarenessSuggestionFieldsFragment searchAwarenessSuggestionFieldsFragment) {
        if (!TextUtils.isEmpty(searchAwarenessSuggestionFieldsFragment.g())) {
            return true;
        }
        m8764a("Missing title for search results awareness unit.\n");
        return false;
    }

    private boolean m8769b(SearchAwarenessRootSuggestionFieldsFragmentModel searchAwarenessRootSuggestionFieldsFragmentModel) {
        if (!TextUtils.isEmpty(searchAwarenessRootSuggestionFieldsFragmentModel.k())) {
            return true;
        }
        m8764a("Missing test name.\n");
        return false;
    }

    private void m8764a(String str) {
        this.f4896c.append(str);
    }

    private void m8763a() {
        this.f4894a.m2340a("SearchAwareness", this.f4896c.toString());
    }

    private void m8767b() {
        this.f4896c = new StringBuilder();
        this.f4897d.clear();
    }
}
