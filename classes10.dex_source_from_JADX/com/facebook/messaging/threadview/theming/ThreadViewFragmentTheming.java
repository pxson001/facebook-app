package com.facebook.messaging.threadview.theming;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.graphics.ColorUtils;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.chatheads.detect.ChatHeadsContextDetector;
import com.facebook.messaging.ephemeral.gating.EphemeralGatingUtil;
import com.facebook.messaging.material.abtest.MaterialDesignExperimentHelper;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadSummary;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: platform_share_failed_with_error */
public class ThreadViewFragmentTheming {
    private final Context f4779a;
    private final Provider<Boolean> f4780b;
    private final EphemeralGatingUtil f4781c;
    private final MaterialDesignExperimentHelper f4782d;
    private final Resources f4783e;

    public static ThreadViewFragmentTheming m4336b(InjectorLike injectorLike) {
        return new ThreadViewFragmentTheming((Context) injectorLike.getInstance(Context.class), IdBasedProvider.a(injectorLike, 4144), EphemeralGatingUtil.b(injectorLike), MaterialDesignExperimentHelper.b(injectorLike), ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ThreadViewFragmentTheming(Context context, Provider<Boolean> provider, EphemeralGatingUtil ephemeralGatingUtil, MaterialDesignExperimentHelper materialDesignExperimentHelper, Resources resources) {
        this.f4779a = context;
        this.f4780b = provider;
        this.f4781c = ephemeralGatingUtil;
        this.f4782d = materialDesignExperimentHelper;
        this.f4783e = resources;
    }

    public static ThreadViewFragmentTheming m4335a(InjectorLike injectorLike) {
        return m4336b(injectorLike);
    }

    public final int m4341a(@Nullable ThreadSummary threadSummary) {
        if (this.f4781c.a(threadSummary)) {
            return this.f4783e.getColor(2131362453);
        }
        if (m4338d(threadSummary)) {
            return this.f4783e.getColor(2131362305);
        }
        if (m4339e(threadSummary)) {
            return this.f4783e.getColor(2131362549);
        }
        if (m4340f(threadSummary)) {
            return 0;
        }
        return m4337c(threadSummary);
    }

    public final int m4342b(@Nullable ThreadSummary threadSummary) {
        if (m4340f(threadSummary) || (this.f4782d.b() && !ChatHeadsContextDetector.a(this.f4779a))) {
            return 0;
        }
        if (m4339e(threadSummary)) {
            return this.f4783e.getColor(2131362549);
        }
        if (m4338d(threadSummary)) {
            return this.f4783e.getColor(2131362305);
        }
        return m4337c(threadSummary);
    }

    private static int m4337c(@Nullable ThreadSummary threadSummary) {
        int i = threadSummary.D.b;
        int i2 = threadSummary.D.c;
        return (i == 0 || (ColorUtils.a(i) >= ColorUtils.a(i2) && i2 != 0)) ? i2 : i;
    }

    private static boolean m4338d(@Nullable ThreadSummary threadSummary) {
        return threadSummary != null && ThreadKey.d(threadSummary.a);
    }

    private static boolean m4339e(@Nullable ThreadSummary threadSummary) {
        return threadSummary != null && ThreadKey.g(threadSummary.a);
    }

    private boolean m4340f(@Nullable ThreadSummary threadSummary) {
        return !((Boolean) this.f4780b.get()).booleanValue() || threadSummary == null || threadSummary.D == null || this.f4781c.a(threadSummary);
    }
}
