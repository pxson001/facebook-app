package com.facebook.feed.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.platformads.listener.AppInstalledListener.InstalledAppInfo;
import com.facebook.inject.FbInjector;
import com.facebook.intent.thirdparty.NativeThirdPartyUriHelper;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.widget.CustomFrameLayout;
import javax.inject.Inject;

/* compiled from: Trying to display an invalid ComposerPrivacyData in SelectablePrivacyView */
public class InstallNotificationBeeper extends CustomFrameLayout {
    private static final CallerContext f21759d = CallerContext.a(InstallNotificationBeeper.class);
    @Inject
    SecureContextHelper f21760a;
    @Inject
    NewsFeedAnalyticsEventBuilder f21761b;
    @Inject
    AnalyticsLogger f21762c;
    public final Handler f21763e;
    private final View f21764f = c(2131563224);
    private final TextView f21765g = ((TextView) c(2131563226));
    private final TextView f21766h = ((TextView) c(2131563227));
    private final FbDraweeView f21767i = ((FbDraweeView) c(2131563225));
    private ObjectAnimator f21768j;
    public InstalledAppInfo f21769k;

    private static <T extends View> void m24338a(Class<T> cls, T t) {
        m24339a((Object) t, t.getContext());
    }

    private static void m24339a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((InstallNotificationBeeper) obj).m24336a((SecureContextHelper) DefaultSecureContextHelper.a(fbInjector), NewsFeedAnalyticsEventBuilder.a(fbInjector), AnalyticsLoggerMethodAutoProvider.a(fbInjector));
    }

    private void m24336a(SecureContextHelper secureContextHelper, NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder, AnalyticsLogger analyticsLogger) {
        this.f21760a = secureContextHelper;
        this.f21761b = newsFeedAnalyticsEventBuilder;
        this.f21762c = analyticsLogger;
    }

    public InstallNotificationBeeper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24338a(InstallNotificationBeeper.class, (View) this);
        setVisibility(4);
        setContentView(2130904939);
        this.f21767i.setVisibility(8);
        this.f21769k = null;
        this.f21763e = new Handler();
    }

    public final void m24347a(InstalledAppInfo installedAppInfo) {
        if (m24343b()) {
            if (this.f21769k != null) {
                this.f21762c.a(NewsFeedAnalyticsEventBuilder.a("store_conversion_notification_replaced", this.f21769k.f, this.f21769k.g));
            }
            m24345d(installedAppInfo);
            return;
        }
        m24344c(this, installedAppInfo);
    }

    public static void m24344c(InstallNotificationBeeper installNotificationBeeper, InstalledAppInfo installedAppInfo) {
        if (installedAppInfo != null) {
            installNotificationBeeper.f21769k = installedAppInfo;
            installNotificationBeeper.f21765g.setText(installNotificationBeeper.getContext().getString(2131231955, new Object[]{installedAppInfo.b}));
            installNotificationBeeper.f21766h.setText(2131231956);
            if (installNotificationBeeper.f21767i.getVisibility() == 0 && installedAppInfo.c != null) {
                installNotificationBeeper.f21767i.setImageDrawable(installedAppInfo.c);
            } else if (installedAppInfo.d != null) {
                installNotificationBeeper.f21767i.a(Uri.parse(installedAppInfo.d), f21759d);
            }
            Uri b = NativeThirdPartyUriHelper.b(installedAppInfo.e);
            Intent intent = null;
            if (NativeThirdPartyUriHelper.a(b)) {
                intent = NativeThirdPartyUriHelper.d(installNotificationBeeper.getContext(), b);
            }
            if (intent == null) {
                intent = installNotificationBeeper.m24331a(installedAppInfo.a, b);
            }
            if (intent != null) {
                installNotificationBeeper.f21769k = installedAppInfo;
                final InstalledAppInfo installedAppInfo2 = installNotificationBeeper.f21769k;
                installNotificationBeeper.f21764f.setOnClickListener(new OnClickListener(installNotificationBeeper) {
                    final /* synthetic */ InstallNotificationBeeper f21749c;

                    public void onClick(View view) {
                        int a = Logger.a(2, EntryType.UI_INPUT_START, -1994591744);
                        this.f21749c.m24335a(intent, installedAppInfo2);
                        Logger.a(2, EntryType.UI_INPUT_END, 1722613029, a);
                    }
                });
                installNotificationBeeper.f21766h.setOnClickListener(new OnClickListener(installNotificationBeeper) {
                    final /* synthetic */ InstallNotificationBeeper f21752c;

                    public void onClick(View view) {
                        int a = Logger.a(2, EntryType.UI_INPUT_START, 1258542510);
                        this.f21752c.m24335a(intent, installedAppInfo2);
                        Logger.a(2, EntryType.UI_INPUT_END, -1984689296, a);
                    }
                });
                installNotificationBeeper.requestLayout();
                installNotificationBeeper.f21762c.a(NewsFeedAnalyticsEventBuilder.a("store_conversion_notification_shown", installedAppInfo2.f, installedAppInfo2.g));
                installNotificationBeeper.m24334a((float) installNotificationBeeper.getHeight(), 0.0f, new AnimatorListenerAdapter(installNotificationBeeper) {
                    final /* synthetic */ InstallNotificationBeeper f21755b;

                    /* compiled from: Trying to display an invalid ComposerPrivacyData in SelectablePrivacyView */
                    class C18261 implements Runnable {
                        final /* synthetic */ C18273 f21753a;

                        C18261(C18273 c18273) {
                            this.f21753a = c18273;
                        }

                        public void run() {
                            if (this.f21753a.f21755b.f21769k == installedAppInfo2) {
                                NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder = this.f21753a.f21755b.f21761b;
                                this.f21753a.f21755b.f21762c.a(NewsFeedAnalyticsEventBuilder.a("store_conversion_notification_ignored", installedAppInfo2.f, installedAppInfo2.g));
                            }
                            this.f21753a.f21755b.m24346a();
                        }
                    }

                    public void onAnimationStart(Animator animator) {
                        this.f21755b.setVisibility(0);
                    }

                    public void onAnimationEnd(Animator animator) {
                        HandlerDetour.b(this.f21755b.f21763e, new C18261(this), 15000, 1633571037);
                    }
                });
            }
        }
    }

    private void m24335a(Intent intent, InstalledAppInfo installedAppInfo) {
        m24346a();
        if (getContext().getPackageManager().resolveActivity(intent, 65536) != null && this.f21760a != null) {
            this.f21762c.a(NewsFeedAnalyticsEventBuilder.a("store_conversion_notification_tapped", installedAppInfo.f, installedAppInfo.g));
            this.f21760a.b(intent, getContext());
        }
    }

    public final void m24346a() {
        m24345d(null);
    }

    public final boolean m24348b(InstalledAppInfo installedAppInfo) {
        return (installedAppInfo == null || this.f21769k == null || this.f21769k.a == null || !this.f21769k.a.equals(installedAppInfo.a)) ? false : true;
    }

    private boolean m24343b() {
        return getVisibility() == 0;
    }

    private void m24345d(final InstalledAppInfo installedAppInfo) {
        final boolean z = installedAppInfo != null;
        float f = 0.0f;
        if (this.f21768j != null && this.f21768j.isRunning()) {
            f = ((Float) this.f21768j.getAnimatedValue()).floatValue();
            this.f21768j.cancel();
        }
        m24334a(f, ((float) getHeight()) + f, new AnimatorListenerAdapter(this) {
            final /* synthetic */ InstallNotificationBeeper f21758c;

            public void onAnimationEnd(Animator animator) {
                this.f21758c.setVisibility(8);
                this.f21758c.clearAnimation();
                this.f21758c.f21769k = installedAppInfo;
                if (z) {
                    InstallNotificationBeeper.m24344c(this.f21758c, installedAppInfo);
                }
            }
        });
    }

    private void m24334a(float f, float f2, AnimatorListener animatorListener) {
        this.f21768j = ObjectAnimator.ofFloat(this, "translationY", new float[]{f, f2});
        this.f21768j.setDuration(400);
        this.f21768j.addListener(animatorListener);
        this.f21768j.start();
    }

    private Intent m24330a(Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435456);
        intent.setData(uri);
        return getContext().getPackageManager().resolveActivity(intent, 65536) != null ? intent : null;
    }

    private Intent m24331a(String str, Uri uri) {
        Intent intent = null;
        if (!m24340a(str)) {
            return null;
        }
        if (uri != null) {
            intent = m24330a(uri);
        }
        if (intent == null) {
            return getContext().getPackageManager().getLaunchIntentForPackage(str);
        }
        return intent;
    }

    private boolean m24340a(String str) {
        PackageInfo packageInfo = null;
        if (str != null) {
            try {
                packageInfo = getContext().getPackageManager().getPackageInfo(str, 0);
            } catch (NameNotFoundException e) {
                return false;
            }
        }
        if (packageInfo != null) {
            return true;
        }
        return false;
    }
}
