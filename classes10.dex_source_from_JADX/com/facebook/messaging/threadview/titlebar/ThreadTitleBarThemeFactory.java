package com.facebook.messaging.threadview.titlebar;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.ContextThemeWrapper;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.util.ColorUtil;
import com.facebook.common.util.ContextUtils;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.chatheads.detect.ChatHeadsContextDetector;
import com.facebook.messaging.ephemeral.gating.EphemeralGatingUtil;
import com.facebook.messaging.material.abtest.MaterialDesignExperimentHelper;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.threadview.theming.ThreadViewFragmentTheming;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: places_ids */
public class ThreadTitleBarThemeFactory {
    private final EphemeralGatingUtil f4834a;
    private final Provider<Boolean> f4835b;
    public final MaterialDesignExperimentHelper f4836c;
    public final Resources f4837d;
    public final ThreadTitleBarGatekeepers f4838e;
    public final ThreadViewFragmentTheming f4839f;

    public static ThreadTitleBarThemeFactory m4370a(InjectorLike injectorLike) {
        return new ThreadTitleBarThemeFactory(EphemeralGatingUtil.b(injectorLike), IdBasedProvider.a(injectorLike, 4073), MaterialDesignExperimentHelper.b(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), new ThreadTitleBarGatekeepers(GatekeeperStoreImplMethodAutoProvider.a(injectorLike)), ThreadViewFragmentTheming.m4336b(injectorLike));
    }

    @Inject
    public ThreadTitleBarThemeFactory(EphemeralGatingUtil ephemeralGatingUtil, Provider<Boolean> provider, MaterialDesignExperimentHelper materialDesignExperimentHelper, Resources resources, ThreadTitleBarGatekeepers threadTitleBarGatekeepers, ThreadViewFragmentTheming threadViewFragmentTheming) {
        this.f4837d = resources;
        this.f4835b = provider;
        this.f4836c = materialDesignExperimentHelper;
        this.f4834a = ephemeralGatingUtil;
        this.f4839f = threadViewFragmentTheming;
        this.f4838e = threadTitleBarGatekeepers;
    }

    public final ThreadTitleBarTheme m4379a(Context context, @Nullable ThreadKey threadKey) {
        ThreadTitleBarThemeBuilder newBuilder = ThreadTitleBarTheme.newBuilder();
        m4371a(context, m4374b(context, threadKey), newBuilder);
        return newBuilder.m4367a();
    }

    public final ThreadTitleBarTheme m4380a(Context context, @Nullable ThreadSummary threadSummary) {
        Object obj;
        ThreadTitleBarThemeBuilder newBuilder = ThreadTitleBarTheme.newBuilder();
        m4371a(context, m4376c(context, threadSummary), newBuilder);
        if (ChatHeadsContextDetector.a(context) || !this.f4836c.b() || !this.f4838e.f4817a.a(199, false) || this.f4839f.m4341a(threadSummary) == 0) {
            obj = null;
        } else {
            obj = 1;
        }
        int a;
        if (obj != null) {
            a = this.f4839f.m4341a(threadSummary);
            newBuilder.f4826a = new ColorDrawable(a);
            ThreadTitleBarThemeBuilder threadTitleBarThemeBuilder = newBuilder;
            threadTitleBarThemeBuilder.f4832g = m4369a(a);
            threadTitleBarThemeBuilder.f4833h = m4373b(a);
        } else {
            a = this.f4839f.m4342b(threadSummary);
            if (a != 0) {
                newBuilder.m4368a(m4375c(context), a, a);
            }
        }
        return newBuilder.m4367a();
    }

    private void m4371a(Context context, Optional<Integer> optional, ThreadTitleBarThemeBuilder threadTitleBarThemeBuilder) {
        if (optional.isPresent()) {
            context = new ContextThemeWrapper(context, ((Integer) optional.get()).intValue());
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(ContextUtils.b(context, 2130772024, 2131625037), new int[]{16842964});
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        Drawable drawable2 = drawable;
        int i = 0;
        if (drawable2 instanceof ColorDrawable) {
            i = m4373b(((ColorDrawable) drawable2).getColor());
        }
        threadTitleBarThemeBuilder.f4826a = drawable2;
        ThreadTitleBarThemeBuilder threadTitleBarThemeBuilder2 = threadTitleBarThemeBuilder;
        threadTitleBarThemeBuilder2.f4832g = m4378g(context);
        threadTitleBarThemeBuilder2 = threadTitleBarThemeBuilder2;
        threadTitleBarThemeBuilder2.f4833h = i;
        ThreadTitleBarThemeBuilder threadTitleBarThemeBuilder3 = threadTitleBarThemeBuilder2;
        threadTitleBarThemeBuilder3.f4830e = m4377e(context);
        threadTitleBarThemeBuilder3 = threadTitleBarThemeBuilder3;
        threadTitleBarThemeBuilder3.f4831f = ContextUtils.b(context, 2130773057, 2131625189);
        threadTitleBarThemeBuilder3.m4368a(m4375c(context), ContextUtils.c(context, 2130773227, this.f4837d.getColor(2131362308)), ContextUtils.c(context, 2130773228, -1));
    }

    private Optional<Integer> m4374b(Context context, @Nullable ThreadKey threadKey) {
        if (ChatHeadsContextDetector.a(context) || !ThreadKey.d(threadKey)) {
            return Absent.INSTANCE;
        }
        return Optional.of(Integer.valueOf(((Boolean) this.f4835b.get()).booleanValue() ? 2131625208 : 2131625167));
    }

    private Optional<Integer> m4376c(Context context, @Nullable ThreadSummary threadSummary) {
        if (threadSummary == null) {
            return Absent.INSTANCE;
        }
        if (!this.f4834a.a(threadSummary)) {
            return m4374b(context, threadSummary.a);
        }
        return Optional.of(Integer.valueOf(((Boolean) this.f4835b.get()).booleanValue() ? 2131625206 : 2131625164));
    }

    private int m4375c(Context context) {
        return ContextUtils.c(context, 2130773226, this.f4837d.getColor(2131362294));
    }

    private int m4377e(Context context) {
        Optional a = ContextUtils.a(context, 2130771986);
        if (a.isPresent()) {
            context = new ContextThemeWrapper(context, ((Integer) a.get()).intValue());
        }
        return ContextUtils.c(context, 2130772051, this.f4837d.getColor(2131362308));
    }

    private int m4378g(Context context) {
        if (m4372a()) {
            return ContextUtils.c(context, 16843857, this.f4837d.getColor(2131362444));
        }
        return -16777216;
    }

    private int m4369a(int i) {
        if (m4372a()) {
            return ColorUtil.a(i, 0.8f);
        }
        return -16777216;
    }

    private boolean m4372a() {
        return VERSION.SDK_INT >= 21 && ((Boolean) this.f4835b.get()).booleanValue();
    }

    private int m4373b(int i) {
        if (((Boolean) this.f4835b.get()).booleanValue()) {
            return ColorUtil.a(i, 0.8f);
        }
        return 0;
    }
}
