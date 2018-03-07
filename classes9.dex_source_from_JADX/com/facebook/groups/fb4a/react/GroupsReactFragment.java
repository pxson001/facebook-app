package com.facebook.groups.fb4a.react;

import android.content.Context;
import android.os.Bundle;
import com.facebook.fbreact.fragment.ImmersiveReactFragment;
import com.facebook.fbreact.instance.FbReactInstanceHolder;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.quicklog.QuickPerformanceLogger;
import com.facebook.quicklog.module.QuickPerformanceLoggerMethodAutoProvider;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarker.MarkerListener;
import javax.inject.Inject;

/* compiled from: payments_android_initiate_ads_payments_flow */
public class GroupsReactFragment extends ImmersiveReactFragment {
    @Inject
    public FbReactInstanceHolder f6922f;
    @Inject
    public QuickPerformanceLogger f6923g;

    /* compiled from: payments_android_initiate_ads_payments_flow */
    public class Builder {
        public Bundle f6921a = new Bundle();

        public final Builder m7201a(Bundle bundle) {
            this.f6921a.putAll(bundle);
            return this;
        }

        public final ImmersiveReactFragment m7200a() {
            GroupsReactFragment groupsReactFragment = new GroupsReactFragment();
            groupsReactFragment.g(this.f6921a);
            return groupsReactFragment;
        }
    }

    public static void m7202a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        GroupsReactFragment groupsReactFragment = (GroupsReactFragment) obj;
        FbReactInstanceHolder a = FbReactInstanceHolder.a(fbInjector);
        QuickPerformanceLogger a2 = QuickPerformanceLoggerMethodAutoProvider.a(fbInjector);
        groupsReactFragment.f6922f = a;
        groupsReactFragment.f6923g = a2;
    }

    public static Builder av() {
        return new Builder();
    }

    public final void m7204d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -51249941);
        super.d(bundle);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -2058973548, a);
    }

    public final void m7203c(Bundle bundle) {
        Class cls = GroupsReactFragment.class;
        m7202a(this, getContext());
        super.c(bundle);
        Bundle bundle2 = this.s;
        final int i = bundle2.getInt("warm_perf_marker");
        final int i2 = bundle2.getInt("react_context_perf_marker");
        ReactMarker.a = new MarkerListener(this) {
            final /* synthetic */ GroupsReactFragment f6920c;

            public final void m7199a(String str) {
                if (str.equals("CREATE_REACT_CONTEXT_START")) {
                    if (i2 != 0) {
                        this.f6920c.f6923g.b(i2);
                    }
                } else if (str.equals("CREATE_REACT_CONTEXT_END")) {
                    if (i2 != 0) {
                        this.f6920c.f6923g.b(i2, (short) 2);
                    }
                    if (i != 0) {
                        this.f6920c.f6923g.b(i);
                    }
                }
            }
        };
    }

    protected final void aq() {
        super.aq();
        int i = this.s.getInt("cold_perf_marker");
        if (i != 0) {
            this.f6923g.b(i);
        }
    }

    protected final void ar() {
        super.ar();
        int i = this.s.getInt("cold_perf_marker");
        if (i != 0 && this.f6922f.a()) {
            this.f6923g.d(i);
        }
    }
}
