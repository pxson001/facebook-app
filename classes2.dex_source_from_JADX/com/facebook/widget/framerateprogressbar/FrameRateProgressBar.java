package com.facebook.widget.framerateprogressbar;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import com.facebook.common.cpu.ProcessorInfoUtil;
import com.facebook.common.cpu.ProcessorInfoUtilMethodAutoProvider;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: intermediate_result */
public class FrameRateProgressBar extends ProgressBar {
    @Inject
    FrameRateProgressBarXConfigReader f19733a;
    @Inject
    ProcessorInfoUtil f19734b;
    private long f19735c;
    private boolean f19736d;
    private final Runnable f19737e;

    /* compiled from: intermediate_result */
    class C07751 implements Runnable {
        final /* synthetic */ FrameRateProgressBar f19738a;

        C07751(FrameRateProgressBar frameRateProgressBar) {
            this.f19738a = frameRateProgressBar;
        }

        public void run() {
            FrameRateProgressBar.m27426b(this.f19738a);
        }
    }

    private static <T extends View> void m27424a(Class<T> cls, T t) {
        m27425a((Object) t, t.getContext());
    }

    private static void m27425a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((FrameRateProgressBar) obj).m27423a(FrameRateProgressBarXConfigReader.m14665a(injectorLike), ProcessorInfoUtilMethodAutoProvider.m1898a(injectorLike));
    }

    private void m27423a(FrameRateProgressBarXConfigReader frameRateProgressBarXConfigReader, ProcessorInfoUtil processorInfoUtil) {
        this.f19733a = frameRateProgressBarXConfigReader;
        this.f19734b = processorInfoUtil;
    }

    public FrameRateProgressBar(Context context) {
        this(context, null);
    }

    public FrameRateProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrameRateProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f19735c = 150;
        this.f19736d = false;
        this.f19737e = new C07751(this);
        m27424a(FrameRateProgressBar.class, (View) this);
        if (this.f19734b.m1903b() == 1) {
            m27421a();
        }
    }

    private void m27421a() {
        int a = this.f19733a.m14667a();
        if (a != 60 && a > 0) {
            this.f19736d = true;
            this.f19735c = 1000 / ((long) a);
        }
    }

    @TargetApi(16)
    public void postInvalidateOnAnimation() {
        if (this.f19736d) {
            removeCallbacks(this.f19737e);
            postDelayed(this.f19737e, this.f19735c);
            return;
        }
        super.postInvalidateOnAnimation();
    }

    @TargetApi(16)
    public static void m27426b(FrameRateProgressBar frameRateProgressBar) {
        super.postInvalidateOnAnimation();
    }
}
