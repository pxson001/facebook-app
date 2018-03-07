package com.facebook.bugreporter;

import android.content.Context;
import android.graphics.Bitmap;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.RegularImmutableSet;
import java.util.ArrayList;
import java.util.List;

/* compiled from: android.permission.VIBRATE */
public class BugReportFlowStartParams {
    public final Context f10469a;
    public final BugReportSource f10470b;
    final ImmutableSet<BugReportExtraFileMapProvider> f10471c;
    final Optional<Long> f10472d;
    final List<Bitmap> f10473e;

    /* compiled from: android.permission.VIBRATE */
    public class BugReportFlowStartParamsBuilder {
        public Context f10464a;
        public BugReportSource f10465b = BugReportSource.DEFAULT;
        public ImmutableSet<BugReportExtraFileMapProvider> f10466c = RegularImmutableSet.a;
        public Optional<Long> f10467d = Absent.INSTANCE;
        public List<Bitmap> f10468e = new ArrayList();

        public final BugReportFlowStartParamsBuilder m18545a(Context context) {
            this.f10464a = (Context) Preconditions.checkNotNull(context);
            return this;
        }

        public final BugReportFlowStartParamsBuilder m18546a(BugReportSource bugReportSource) {
            this.f10465b = (BugReportSource) Preconditions.checkNotNull(bugReportSource);
            return this;
        }

        public final BugReportFlowStartParamsBuilder m18547a(ImmutableSet<BugReportExtraFileMapProvider> immutableSet) {
            this.f10466c = (ImmutableSet) Preconditions.checkNotNull(immutableSet);
            return this;
        }

        public final BugReportFlowStartParamsBuilder m18548a(Long l) {
            this.f10467d = Optional.of(l);
            return this;
        }

        public final BugReportFlowStartParams m18549a() {
            return new BugReportFlowStartParams(this);
        }
    }

    public BugReportFlowStartParams(BugReportFlowStartParamsBuilder bugReportFlowStartParamsBuilder) {
        this.f10469a = bugReportFlowStartParamsBuilder.f10464a;
        this.f10470b = bugReportFlowStartParamsBuilder.f10465b;
        this.f10471c = bugReportFlowStartParamsBuilder.f10466c;
        this.f10473e = bugReportFlowStartParamsBuilder.f10468e;
        this.f10472d = bugReportFlowStartParamsBuilder.f10467d;
    }

    public static BugReportFlowStartParamsBuilder newBuilder() {
        return new BugReportFlowStartParamsBuilder();
    }
}
