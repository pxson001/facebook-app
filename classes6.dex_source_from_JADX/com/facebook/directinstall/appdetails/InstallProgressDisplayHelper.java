package com.facebook.directinstall.appdetails;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import com.facebook.common.time.MonotonicClock;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: onFinishTemporaryDetach */
public class InstallProgressDisplayHelper {
    public MonotonicClock f8701a;
    public ScheduledExecutorService f8702b;
    private final Context f8703c;
    public ProgressBar f8704d;
    public FbTextView f8705e;
    public FbTextView f8706f;
    public ImageButton f8707g;
    @Nullable
    public Future<?> f8708h;
    public final Interpolator f8709i;
    public long f8710j;
    public int f8711k = 0;
    public final Runnable f8712l = new C05792(this);

    /* compiled from: onFinishTemporaryDetach */
    public class C05781 implements OnClickListener {
        final /* synthetic */ InstallProgressDisplayHelper f8699a;

        public C05781(InstallProgressDisplayHelper installProgressDisplayHelper) {
            this.f8699a = installProgressDisplayHelper;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 869614655);
            this.f8699a.m12496a();
            Logger.a(2, EntryType.UI_INPUT_END, 133582714, a);
        }
    }

    /* compiled from: onFinishTemporaryDetach */
    class C05792 implements Runnable {
        final /* synthetic */ InstallProgressDisplayHelper f8700a;

        C05792(InstallProgressDisplayHelper installProgressDisplayHelper) {
            this.f8700a = installProgressDisplayHelper;
        }

        public void run() {
            ProgressBar progressBar = this.f8700a.f8704d;
            int progress = progressBar.getProgress();
            if (progress > this.f8700a.f8711k) {
                progress = this.f8700a.f8711k;
                this.f8700a.f8704d.setProgress(this.f8700a.f8711k);
            }
            if (progress < this.f8700a.f8711k) {
                float now = ((float) (this.f8700a.f8701a.now() - this.f8700a.f8710j)) / 200.0f;
                if (now > 0.0f && now <= 1.0f) {
                    progressBar.setProgress(progress + ((int) (this.f8700a.f8709i.getInterpolation(now) * ((float) (this.f8700a.f8711k - progress)))));
                    InstallProgressDisplayHelper installProgressDisplayHelper = this.f8700a;
                    if (installProgressDisplayHelper.f8708h != null) {
                        installProgressDisplayHelper.f8708h.cancel(false);
                        installProgressDisplayHelper.f8708h = null;
                    }
                    installProgressDisplayHelper.f8708h = installProgressDisplayHelper.f8702b.schedule(installProgressDisplayHelper.f8712l, (long) 10, TimeUnit.MILLISECONDS);
                }
            }
        }
    }

    @Inject
    public InstallProgressDisplayHelper(Context context, MonotonicClock monotonicClock, ScheduledExecutorService scheduledExecutorService) {
        this.f8703c = context;
        this.f8709i = new AccelerateDecelerateInterpolator();
        this.f8701a = monotonicClock;
        this.f8702b = scheduledExecutorService;
    }

    public final void m12496a() {
        this.f8704d.setProgress(0);
        if (8 == 8) {
            this.f8706f.setText("");
        }
        this.f8706f.setVisibility(8);
        this.f8711k = 0;
    }
}
