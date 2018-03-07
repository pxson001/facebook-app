package com.facebook.zero.iptest;

import com.facebook.inject.Lazy;
import com.facebook.zero.connectiontest.ConnectionTester;
import com.google.common.base.Function;
import java.util.List;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: events_interested_connection_nux */
public class ZeroIPTestPlanRunner {
    public Lazy<ExecutorService> f13078a;
    public final Function<ZeroIPTestPlan, ZeroIPTestPlan> f13079b = new C18241(this);

    /* compiled from: events_interested_connection_nux */
    class C18241 implements Function<ZeroIPTestPlan, ZeroIPTestPlan> {
        final /* synthetic */ ZeroIPTestPlanRunner f13077a;

        C18241(ZeroIPTestPlanRunner zeroIPTestPlanRunner) {
            this.f13077a = zeroIPTestPlanRunner;
        }

        public Object apply(@Nullable Object obj) {
            ZeroIPTestPlan zeroIPTestPlan = (ZeroIPTestPlan) obj;
            if (zeroIPTestPlan == null) {
                return null;
            }
            List<ConnectionTester> a = zeroIPTestPlan.m13140a();
            if (a.isEmpty()) {
                return null;
            }
            Integer.valueOf(a.size());
            for (ConnectionTester d : a) {
                d.m13124d();
            }
            return zeroIPTestPlan;
        }
    }

    @Inject
    public ZeroIPTestPlanRunner(Lazy<ExecutorService> lazy) {
        this.f13078a = lazy;
    }
}
