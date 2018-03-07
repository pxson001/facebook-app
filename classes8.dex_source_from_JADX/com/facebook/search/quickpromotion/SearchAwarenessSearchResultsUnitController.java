package com.facebook.search.quickpromotion;

import com.facebook.inject.Assisted;
import com.facebook.qe.api.QeAccessor;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.facebook.search.logging.SearchAwarenessLogger;
import com.facebook.search.model.SearchAwarenessUnitProperties;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import javax.inject.Inject;

/* compiled from: TEXT_BODY */
public class SearchAwarenessSearchResultsUnitController implements AwarenessUnitController {
    public final SearchAwarenessUnitProperties f22415a;
    private final SearchAwarenessLogger f22416b;
    private final SearchAwarenessOptOutController f22417c;
    public final QeAccessor f22418d;
    private boolean f22419e = false;

    @Inject
    public SearchAwarenessSearchResultsUnitController(@Assisted SearchAwarenessUnitProperties searchAwarenessUnitProperties, SearchAwarenessLogger searchAwarenessLogger, SearchAwarenessOptOutController searchAwarenessOptOutController, QeAccessor qeAccessor) {
        Preconditions.checkNotNull(searchAwarenessUnitProperties);
        this.f22415a = searchAwarenessUnitProperties;
        this.f22416b = searchAwarenessLogger;
        this.f22417c = searchAwarenessOptOutController;
        this.f22418d = qeAccessor;
    }

    public final boolean mo1236c() {
        if (!this.f22417c.m25894a(AwarenessType.LEARNING_NUX)) {
            boolean z = false;
            if (this.f22418d.a(ExperimentsForSearchAbTestModule.au, false) || this.f22418d.a(ExperimentsForSearchAbTestModule.av, false)) {
                z = true;
            }
            if (z && this.f22415a.f22256f) {
                return true;
            }
        }
        return false;
    }

    public final void mo1235a(ImmutableMap<String, ?> immutableMap) {
        this.f22416b.a(this.f22415a, immutableMap);
    }

    public final void mo1238e() {
        if (!this.f22419e) {
            this.f22416b.b(this.f22415a);
            this.f22419e = true;
        }
    }

    public final void mo1237d() {
        this.f22415a.f22256f = false;
    }
}
