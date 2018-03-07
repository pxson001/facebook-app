package com.facebook.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ui.animations.EntryAnimationListener;
import javax.annotation.Nullable;

/* compiled from: com.google.common.base.internal.Finalizer */
public class AnimatedNotificationBanner extends CustomLinearLayout {
    protected final NotificationTextSwitcher f5544a = ((NotificationTextSwitcher) a(2131562519));
    protected final View f5545b = a(2131562518);
    public final Handler f5546c = new Handler();
    private ObjectAnimator f5547d;

    /* compiled from: com.google.common.base.internal.Finalizer */
    class C05151 implements OnClickListener {
        final /* synthetic */ AnimatedNotificationBanner f5535a;

        C05151(AnimatedNotificationBanner animatedNotificationBanner) {
            this.f5535a = animatedNotificationBanner;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1593305612);
            this.f5535a.m10377a();
            Logger.a(2, EntryType.UI_INPUT_END, 1462141945, a);
        }
    }

    public AnimatedNotificationBanner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setContentView(2130904586);
        setClickable(true);
        setBackgroundResource(2130840286);
        setGravity(17);
        setVisibility(4);
        setOnClickListener(new C05151(this));
    }

    public void m10378a(String str, boolean z) {
        m10379a(str, z, null);
    }

    public final void m10377a() {
        this.f5544a.m10467a();
        m10376b(null, false);
    }

    private void m10376b(@Nullable final String str, final boolean z) {
        final boolean z2 = str != null;
        float f = 0.0f;
        if (this.f5547d != null && this.f5547d.isRunning()) {
            f = ((Float) this.f5547d.getAnimatedValue()).floatValue();
            this.f5547d.cancel();
        }
        m10375a(f, (float) (getHeight() * -1), new AnimatorListenerAdapter(this) {
            final /* synthetic */ AnimatedNotificationBanner f5543d;

            public void onAnimationEnd(Animator animator) {
                this.f5543d.setVisibility(8);
                this.f5543d.clearAnimation();
                if (z2) {
                    this.f5543d.m10378a(str, z);
                } else {
                    this.f5543d.f5545b.setVisibility(0);
                }
            }
        });
    }

    public final void m10379a(String str, final boolean z, final EntryAnimationListener entryAnimationListener) {
        Object obj;
        if (getVisibility() == 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            this.f5544a.setText(str);
            m10375a((float) (getHeight() * -1), 0.0f, new AnimatorListenerAdapter(this) {
                final /* synthetic */ AnimatedNotificationBanner f5539c;

                /* compiled from: com.google.common.base.internal.Finalizer */
                class C05161 implements Runnable {
                    final /* synthetic */ C05172 f5536a;

                    C05161(C05172 c05172) {
                        this.f5536a = c05172;
                    }

                    public void run() {
                        this.f5536a.f5539c.m10377a();
                    }
                }

                public void onAnimationStart(Animator animator) {
                    this.f5539c.setVisibility(0);
                }

                public void onAnimationEnd(Animator animator) {
                    if (z) {
                        HandlerDetour.b(this.f5539c.f5546c, new C05161(this), 2000, 1327054669);
                    }
                }
            });
        } else if (!this.f5544a.getText().equals(str)) {
            m10376b(str, z);
        }
    }

    private void m10375a(float f, float f2, AnimatorListener animatorListener) {
        this.f5547d = ObjectAnimator.ofFloat(this, "translationY", new float[]{f, f2});
        this.f5547d.setDuration(200);
        this.f5547d.addListener(animatorListener);
        this.f5547d.start();
    }
}
