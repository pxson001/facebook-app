package com.facebook.qe.store;

import com.facebook.abtest.qe.bootstrap.data.QuickExperimentInfo;
import com.facebook.abtest.qe.bootstrap.db.DataSource;
import com.facebook.qe.api.manager.Authority;
import com.facebook.qe.module.QeMigratedExperimentProvider;

/* compiled from: unsubscribeTopics */
public class StoreUpgradeIndexVisitor implements Index$Visitor {
    private final Index f528a;
    private final View f529b;
    private final ViewBuilder f530c;
    private final QeMigratedExperimentProvider f531d;
    private String f532e;
    private int f533f;
    private boolean f534g;
    private QuickExperimentInfo f535h;

    public StoreUpgradeIndexVisitor(Index index, View view, ViewBuilder viewBuilder, QeMigratedExperimentProvider qeMigratedExperimentProvider) {
        this.f528a = index;
        this.f529b = view;
        this.f530c = viewBuilder;
        this.f531d = qeMigratedExperimentProvider;
    }

    public final void mo55a(String str, int i) {
        this.f532e = str;
        this.f533f = i;
        if (this.f528a.b(str)) {
            this.f534g = false;
            this.f535h = null;
            return;
        }
        this.f534g = true;
        this.f535h = this.f531d.a.a(str, DataSource.FROM_SERVER);
        if (this.f535h != null) {
            Utils.m1393a(this.f535h, this.f530c, i, Authority.ASSIGNED);
        }
    }

    public final void mo56a(String str, int i, int i2, boolean z) {
        if (this.f535h == null) {
            int a = this.f528a.a(this.f532e, str);
            if (a != -1) {
                Utils.m1392a(a, i, i2, this.f529b, this.f530c, Authority.OVERRIDE);
                Utils.m1392a(a, i, i2, this.f529b, this.f530c, Authority.ASSIGNED);
            } else if (!this.f534g) {
                this.f530c.m819a(Authority.ASSIGNED, this.f533f + 3);
            }
        } else if (!z) {
            String str2 = (String) this.f535h.f().get(str);
            if (str2 != null) {
                this.f530c.m825a(Authority.ASSIGNED, this.f535h.a(), str, i, i2, str2);
            }
        }
    }
}
