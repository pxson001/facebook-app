package com.facebook.search.quickpromotion;

import android.content.Context;
import android.view.View;
import com.facebook.common.time.Clock;
import com.facebook.fbui.popover.PopoverWindow;
import com.facebook.fbui.popover.PopoverWindow.OnDismissListener;
import com.facebook.fbui.popover.PopoverWindow.Position;
import com.facebook.inject.Assisted;
import com.facebook.qe.api.QeAccessor;
import com.facebook.search.abtest.ExperimentsForSearchAbTestModule;
import com.facebook.search.logging.SearchAwarenessLogger;
import com.facebook.search.model.SearchAwarenessUnitProperties;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import javax.inject.Inject;

/* compiled from: TEXT_BYLINE */
public class SearchAwarenessNullStateController implements AwarenessUnitController {
    private final Context f22391a;
    public final SearchAwarenessUnitProperties f22392b;
    public final boolean f22393c;
    public final SearchAwarenessLogger f22394d;
    private final SearchAwarenessOptOutController f22395e;
    public final QeAccessor f22396f;
    private final Clock f22397g;
    public boolean f22398h = false;
    public boolean f22399i = false;

    /* compiled from: TEXT_BYLINE */
    class C23821 implements OnDismissListener {
        final /* synthetic */ SearchAwarenessNullStateController f22390a;

        C23821(SearchAwarenessNullStateController searchAwarenessNullStateController) {
            this.f22390a = searchAwarenessNullStateController;
        }

        public final boolean m25878a(PopoverWindow popoverWindow) {
            this.f22390a.f22394d.c(this.f22390a.f22392b);
            return true;
        }
    }

    @Inject
    public SearchAwarenessNullStateController(Context context, @Assisted SearchAwarenessUnitProperties searchAwarenessUnitProperties, @Assisted boolean z, SearchAwarenessLogger searchAwarenessLogger, SearchAwarenessOptOutController searchAwarenessOptOutController, QeAccessor qeAccessor, Clock clock) {
        Preconditions.checkNotNull(searchAwarenessUnitProperties);
        this.f22391a = context;
        this.f22392b = searchAwarenessUnitProperties;
        this.f22393c = z;
        this.f22394d = searchAwarenessLogger;
        this.f22395e = searchAwarenessOptOutController;
        this.f22396f = qeAccessor;
        this.f22397g = clock;
    }

    public final void mo1235a(ImmutableMap<String, ?> immutableMap) {
        boolean z;
        this.f22394d.a(this.f22392b, immutableMap);
        boolean z2 = false;
        if (this.f22393c && this.f22396f.a(ExperimentsForSearchAbTestModule.au, false) && this.f22396f.a(ExperimentsForSearchAbTestModule.az, false)) {
            z2 = true;
        }
        if (!z2) {
            z2 = false;
            if (!this.f22393c && this.f22396f.a(ExperimentsForSearchAbTestModule.av, false) && this.f22396f.a(ExperimentsForSearchAbTestModule.aw, false)) {
                z2 = true;
            }
            if (!z2) {
                z = false;
                this.f22398h = z;
                this.f22399i = true;
            }
        }
        z = true;
        this.f22398h = z;
        this.f22399i = true;
    }

    public final void mo1237d() {
        if (this.f22392b.f22256f) {
            this.f22392b.f22256f = false;
            m25882l();
        }
    }

    public final void mo1238e() {
        if (this.f22399i) {
            this.f22394d.b(this.f22392b, ImmutableBiMap.b("dismissed_by_user", Boolean.valueOf(false)));
            this.f22399i = false;
        }
    }

    public final boolean mo1236c() {
        boolean z = false;
        if (this.f22395e.m25894a(AwarenessType.LEARNING_NUX)) {
            return false;
        }
        if (this.f22392b.f22255e == 0) {
            this.f22392b.f22255e = this.f22397g.a();
        }
        SearchAwarenessUnitProperties searchAwarenessUnitProperties = this.f22392b;
        boolean z2 = false;
        if (this.f22396f.a(ExperimentsForSearchAbTestModule.au, false) || this.f22396f.a(ExperimentsForSearchAbTestModule.av, false)) {
            z2 = true;
        }
        if (z2 && m25881g() && m25880f()) {
            z = true;
        }
        searchAwarenessUnitProperties.f22256f = z;
        return m25881g();
    }

    private boolean m25880f() {
        if (this.f22396f.a(ExperimentsForSearchAbTestModule.av, false)) {
            return true;
        }
        long j = this.f22392b.f22254d;
        if (this.f22392b.f22255e - j > ((long) (this.f22396f.a(ExperimentsForSearchAbTestModule.at, 0) * 1000))) {
            return false;
        }
        return true;
    }

    private boolean m25881g() {
        return this.f22392b.f22256f;
    }

    private void m25882l() {
        this.f22398h = false;
    }

    public final void m25883a(View view) {
        SearchAwarenessTypeaheadTooltip searchAwarenessTypeaheadTooltip = new SearchAwarenessTypeaheadTooltip(this.f22391a);
        searchAwarenessTypeaheadTooltip.a(this.f22396f.a(ExperimentsForSearchAbTestModule.aA, ""));
        searchAwarenessTypeaheadTooltip.b(this.f22396f.a(ExperimentsForSearchAbTestModule.ay, ""));
        searchAwarenessTypeaheadTooltip.a(Position.BELOW);
        searchAwarenessTypeaheadTooltip.t = -1;
        searchAwarenessTypeaheadTooltip.f(view);
        searchAwarenessTypeaheadTooltip.H = new C23821(this);
        if (searchAwarenessTypeaheadTooltip.f22479p) {
            this.f22394d.a(this.f22392b);
        }
        m25882l();
    }

    public static String m25879a(ImmutableList<String> immutableList, int i) {
        return i < immutableList.size() ? (String) immutableList.get(i) : "";
    }
}
