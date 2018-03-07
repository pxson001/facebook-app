package com.facebook.qe.store;

import com.facebook.abtest.qe.bootstrap.data.QuickExperimentInfo;
import com.facebook.qe.api.manager.Authority;
import com.facebook.qe.api.manager.SyncedExperimentData;
import java.util.Map;

/* compiled from: thread_presence_local_duration_instance */
public class ExperimentDataSyncIndexVisitor implements Index$Visitor {
    private static final Class<ExperimentDataSyncIndexVisitor> f1124a = ExperimentDataSyncIndexVisitor.class;
    private final Map<String, SyncedExperimentData> f1125b;
    private final View f1126c;
    private final ViewBuilder f1127d;
    private QuickExperimentInfo f1128e;

    public ExperimentDataSyncIndexVisitor(Map<String, SyncedExperimentData> map, View view, ViewBuilder viewBuilder) {
        this.f1125b = map;
        this.f1126c = view;
        this.f1127d = viewBuilder;
    }

    public final void mo55a(String str, int i) {
        int i2 = i + 0;
        int i3 = i + 1;
        int i4 = i + 2;
        int i5 = i + 3;
        this.f1128e = (QuickExperimentInfo) this.f1125b.get(str);
        if (this.f1128e == null) {
            m1389a(i2, 101, Authority.ASSIGNED);
            m1389a(i3, 101, Authority.ASSIGNED);
            m1389a(i4, 100, Authority.ASSIGNED);
            m1389a(i5, 100, Authority.ASSIGNED);
            return;
        }
        Utils.m1393a(this.f1128e, this.f1127d, i, Authority.ASSIGNED);
    }

    private void m1389a(int i, int i2, Authority authority) {
        Utils.m1392a(i, i, i2, this.f1126c, this.f1127d, authority);
    }

    public final void mo56a(String str, int i, int i2, boolean z) {
        Utils.m1392a(i, i, i2, this.f1126c, this.f1127d, Authority.OVERRIDE);
        if (!z) {
            if (this.f1128e == null) {
                m1389a(i, i2, Authority.ASSIGNED);
                return;
            }
            String str2 = (String) this.f1128e.f().get(str);
            if (str2 != null) {
                this.f1127d.m825a(Authority.ASSIGNED, this.f1128e.a(), str, i, i2, str2);
            }
        }
    }
}
