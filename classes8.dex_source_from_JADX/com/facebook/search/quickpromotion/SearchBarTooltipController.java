package com.facebook.search.quickpromotion;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.fbui.popover.PopoverWindow;
import com.facebook.fbui.popover.PopoverWindow.OnDismissListener;
import com.facebook.fbui.popover.PopoverWindow.Position;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.inject.Assisted;
import com.facebook.search.logging.SearchAwarenessLogger;
import com.facebook.search.model.SearchAwarenessUnitProperties;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import javax.inject.Inject;

/* compiled from: TARGET_PRIVACY */
public class SearchBarTooltipController implements AwarenessUnitController {
    public final Context f22500a;
    private final SearchAwarenessLogger f22501b;
    public final AbstractFbErrorReporter f22502c;
    private final SearchAwarenessUnitProperties f22503d;
    public final View f22504e;
    private SearchAwarenessOptOutController f22505f;

    /* compiled from: TARGET_PRIVACY */
    class C24021 implements OnDismissListener {
        final /* synthetic */ SearchBarTooltipController f22499a;

        C24021(SearchBarTooltipController searchBarTooltipController) {
            this.f22499a = searchBarTooltipController;
        }

        public final boolean m25970a(PopoverWindow popoverWindow) {
            this.f22499a.mo1237d();
            this.f22499a.mo1238e();
            return true;
        }
    }

    @Inject
    public SearchBarTooltipController(Context context, @Assisted View view, @Assisted SearchAwarenessUnitProperties searchAwarenessUnitProperties, SearchAwarenessOptOutController searchAwarenessOptOutController, SearchAwarenessLogger searchAwarenessLogger, AbstractFbErrorReporter abstractFbErrorReporter) {
        Preconditions.checkNotNull(view);
        Preconditions.checkNotNull(searchAwarenessUnitProperties);
        this.f22500a = context;
        this.f22505f = searchAwarenessOptOutController;
        this.f22501b = searchAwarenessLogger;
        this.f22503d = searchAwarenessUnitProperties;
        this.f22504e = view;
        this.f22502c = abstractFbErrorReporter;
    }

    public final void mo1235a(ImmutableMap<String, ?> immutableMap) {
        Tooltip tooltip;
        CharSequence g = this.f22503d.f22251a.mo560g();
        CharSequence d = this.f22503d.f22251a.mo559d();
        if (TextUtils.isEmpty(g) && TextUtils.isEmpty(d)) {
            this.f22502c.a("SearchAwareness", "title and description are empty for tooltip.");
            tooltip = null;
        } else {
            tooltip = new Tooltip(this.f22500a, 2);
            tooltip.a(g);
            tooltip.b(d);
            tooltip.a(Position.BELOW);
            tooltip.t = -1;
            tooltip.f(this.f22504e);
        }
        PopoverWindow popoverWindow = tooltip;
        if (popoverWindow != null) {
            popoverWindow.H = new C24021(this);
        }
        this.f22501b.a(this.f22503d, immutableMap);
    }

    public final void mo1237d() {
        this.f22503d.f22256f = false;
    }

    public final void mo1238e() {
        this.f22501b.b(this.f22503d);
    }

    public final boolean mo1236c() {
        return !this.f22505f.m25894a(AwarenessType.LEARNING_NUX) && this.f22503d.f22256f;
    }
}
