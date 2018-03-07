package com.facebook.appirater.ratingdialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.facebook.appirater.InternalStarRatingController;
import com.facebook.appirater.api.AppRaterReport;
import com.facebook.appirater.api.AppRaterReport.Builder;
import com.facebook.appirater.api.AppRaterReport.LastEvent;
import com.facebook.appirater.api.FetchISRConfigResult;
import com.facebook.appirater.ratingdialog.screencontroller.AbstractAppiraterDialogScreenController;
import com.facebook.appirater.ratingdialog.screencontroller.ProvideFeedbackScreenController;
import com.facebook.appirater.ratingdialog.screencontroller.RateOnPlayStoreScreenController;
import com.facebook.appirater.ratingdialog.screencontroller.StarRatingScreenController;
import com.facebook.appirater.ratingdialog.screencontroller.ThanksForFeedbackScreenController;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.config.versioninfo.AppVersionInfo;
import com.facebook.config.versioninfo.module.AppVersionInfoMethodAutoProvider;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ui.dialogs.FbDialogFragment;
import com.google.common.base.Preconditions;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: csd- */
public class AppiraterRatingDialogFragment extends FbDialogFragment {
    @Inject
    DefaultAndroidThreadUtil am;
    @Inject
    AppVersionInfo an;
    @Inject
    InternalStarRatingController ao;
    @Inject
    @ForUiThread
    Handler ap;
    @Inject
    Lazy<StarRatingScreenController> aq;
    @Inject
    Lazy<ProvideFeedbackScreenController> ar;
    @Inject
    Lazy<ThanksForFeedbackScreenController> as;
    @Inject
    Lazy<RateOnPlayStoreScreenController> at;
    public boolean au = false;
    private boolean av = false;
    private Map<Screen, ScreenInfo> aw = new HashMap();

    /* compiled from: csd- */
    public class FadeOutAnimationListener implements AnimationListener {
        final /* synthetic */ AppiraterRatingDialogFragment f16489a;
        public ScreenInfo f16490b;

        /* compiled from: csd- */
        class C13031 implements Runnable {
            final /* synthetic */ FadeOutAnimationListener f16488a;

            C13031(FadeOutAnimationListener fadeOutAnimationListener) {
                this.f16488a = fadeOutAnimationListener;
            }

            public void run() {
                this.f16488a.f16490b.m20553c();
                this.f16488a.f16489a.au = false;
            }
        }

        public FadeOutAnimationListener(AppiraterRatingDialogFragment appiraterRatingDialogFragment, ScreenInfo screenInfo) {
            this.f16489a = appiraterRatingDialogFragment;
            this.f16490b = (ScreenInfo) Preconditions.checkNotNull(screenInfo);
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            View a = this.f16490b.m20551a();
            if (a != null) {
                a.setAnimation(null);
            }
            HandlerDetour.a(this.f16489a.ap, new C13031(this), 19802723);
        }

        public void onAnimationRepeat(Animation animation) {
        }
    }

    /* compiled from: csd- */
    public enum Screen {
        STAR_RATING,
        PROVIDE_FEEDBACK,
        THANKS_FOR_FEEDBACK,
        RATE_ON_PLAY_STORE;

        public static Screen fromInt(int i) {
            Screen[] values = values();
            if (i >= 0 && i < values.length) {
                return values[i];
            }
            throw new IllegalArgumentException("Unrecognized int value for Screen");
        }

        public final int toInt() {
            return ordinal();
        }
    }

    /* compiled from: csd- */
    public class ScreenInfo {
        final /* synthetic */ AppiraterRatingDialogFragment f16491a;
        private final Screen f16492b;
        public AbstractAppiraterDialogScreenController f16493c = null;
        private View f16494d = null;

        public ScreenInfo(AppiraterRatingDialogFragment appiraterRatingDialogFragment, Screen screen) {
            this.f16491a = appiraterRatingDialogFragment;
            this.f16492b = screen;
        }

        private AbstractAppiraterDialogScreenController m20549e() {
            if (this.f16493c == null) {
                this.f16493c = m20550f();
                this.f16493c.f16496a = this.f16491a;
            }
            return this.f16493c;
        }

        private AbstractAppiraterDialogScreenController m20550f() {
            switch (this.f16492b) {
                case STAR_RATING:
                    return (AbstractAppiraterDialogScreenController) this.f16491a.aq.get();
                case PROVIDE_FEEDBACK:
                    return (AbstractAppiraterDialogScreenController) this.f16491a.ar.get();
                case THANKS_FOR_FEEDBACK:
                    return (AbstractAppiraterDialogScreenController) this.f16491a.as.get();
                case RATE_ON_PLAY_STORE:
                    return (AbstractAppiraterDialogScreenController) this.f16491a.at.get();
                default:
                    throw new IllegalArgumentException();
            }
        }

        public final View m20551a() {
            if (this.f16494d == null) {
                this.f16494d = m20549e().mo1284a(LayoutInflater.from(this.f16491a.getContext()));
            }
            return this.f16494d;
        }

        public final void m20552b() {
            m20549e().mo1286a(this.f16491a.getContext(), (AlertDialog) this.f16491a.f);
        }

        public final void m20553c() {
            if (this.f16493c != null) {
                this.f16493c.mo1285a();
            }
            this.f16494d = null;
        }
    }

    public static void m20555a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((AppiraterRatingDialogFragment) obj).m20554a(DefaultAndroidThreadUtil.b(fbInjector), AppVersionInfoMethodAutoProvider.a(fbInjector), InternalStarRatingController.a(fbInjector), Handler_ForUiThreadMethodAutoProvider.b(fbInjector), IdBasedLazy.a(fbInjector, 4866), IdBasedLazy.a(fbInjector, 4864), IdBasedLazy.a(fbInjector, 4867), IdBasedLazy.a(fbInjector, 4865));
    }

    private void m20554a(AndroidThreadUtil androidThreadUtil, AppVersionInfo appVersionInfo, InternalStarRatingController internalStarRatingController, Handler handler, Lazy<StarRatingScreenController> lazy, Lazy<ProvideFeedbackScreenController> lazy2, Lazy<ThanksForFeedbackScreenController> lazy3, Lazy<RateOnPlayStoreScreenController> lazy4) {
        this.am = androidThreadUtil;
        this.an = appVersionInfo;
        this.ao = internalStarRatingController;
        this.ap = handler;
        this.aq = lazy;
        this.ar = lazy2;
        this.as = lazy3;
        this.at = lazy4;
    }

    public void onCancel(DialogInterface dialogInterface) {
        this.av = true;
        super.onCancel(dialogInterface);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        Screen at = at();
        int ar = ar();
        String as = as();
        int b = this.an.b();
        boolean z = this.av;
        Builder builder = new Builder();
        builder.f16474a = ar;
        builder = builder;
        builder.f16475b = as;
        Builder builder2 = builder;
        builder2.f16477d = (long) b;
        builder2 = builder2;
        builder2.f16478e = System.currentTimeMillis();
        builder2 = builder2;
        switch (at) {
            case STAR_RATING:
                builder2.m20537a(z ? LastEvent.STARS_DISMISS : LastEvent.STARS_BACKGROUND);
                break;
            case PROVIDE_FEEDBACK:
                builder2.m20537a(z ? LastEvent.STARS_LOWRATING_CANCEL : LastEvent.STARS_LOWRATING_SUBMIT);
                break;
            case THANKS_FOR_FEEDBACK:
                FetchISRConfigResult d = this.ao.d();
                if (d != null && d.m20544a()) {
                    if (ar > d.maxStarsForFeedback) {
                        builder2.m20537a(LastEvent.STARS_STARCHOSEN);
                        break;
                    } else {
                        builder2.m20537a(LastEvent.STARS_LOWRATING_SUBMIT);
                        break;
                    }
                }
                builder2.m20537a(LastEvent.STARS_STARCHOSEN);
                break;
                break;
            case RATE_ON_PLAY_STORE:
                builder2.m20537a(z ? LastEvent.STARS_HIGHRATING_NOTHANKS : LastEvent.STARS_HIGHRATING_GOTOSTORE);
                break;
        }
        this.ao.a(new AppRaterReport(builder2));
        super.onDismiss(dialogInterface);
    }

    public final void m20562e(Bundle bundle) {
        this.ao.a(new RatingDialogSaveState(ar(), as(), at().toString()));
        super.e(bundle);
    }

    public static ScreenInfo m20556c(AppiraterRatingDialogFragment appiraterRatingDialogFragment, Screen screen) {
        ScreenInfo screenInfo = (ScreenInfo) appiraterRatingDialogFragment.aw.get(screen);
        if (screenInfo != null) {
            return screenInfo;
        }
        screenInfo = new ScreenInfo(appiraterRatingDialogFragment, screen);
        appiraterRatingDialogFragment.aw.put(screen, screenInfo);
        return screenInfo;
    }

    private ScreenInfo au() {
        return m20556c(this, at());
    }

    public final void m20558a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 544845309);
        super.a(bundle);
        Class cls = AppiraterRatingDialogFragment.class;
        m20555a((Object) this, getContext());
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -697261350, a);
    }

    public final void m20559a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.au = true;
    }

    public final Dialog m20561c(Bundle bundle) {
        ScreenInfo au = au();
        View a = au.m20551a();
        au.m20552b();
        return new AlertDialog.Builder(getContext()).a(false).b(a).a();
    }

    public final void m20560a(final Screen screen) {
        if (this.am == null) {
            throw new IllegalStateException("Called go to screen before Fragment.onCreate was called");
        }
        this.am.a();
        if (this.au) {
            final Screen at = at();
            if (at != screen) {
                this.au = false;
                HandlerDetour.a(this.ap, new Runnable(this) {
                    final /* synthetic */ AppiraterRatingDialogFragment f16486c;

                    public void run() {
                        this.f16486c.s.putInt("current_screen", screen.toInt());
                        ScreenInfo c = AppiraterRatingDialogFragment.m20556c(this.f16486c, at);
                        View a = c.m20551a();
                        ScreenInfo c2 = AppiraterRatingDialogFragment.m20556c(this.f16486c, screen);
                        View a2 = c2.m20551a();
                        AppiraterRatingDialogFragment appiraterRatingDialogFragment = this.f16486c;
                        Animation alphaAnimation = new AlphaAnimation(10.0f, 0.0f);
                        alphaAnimation.setDuration((long) (appiraterRatingDialogFragment.getContext().getResources().getInteger(2131492944) / 2));
                        alphaAnimation.setAnimationListener(new FadeOutAnimationListener(appiraterRatingDialogFragment, c));
                        a.setAnimation(alphaAnimation);
                        AppiraterRatingDialogFragment appiraterRatingDialogFragment2 = this.f16486c;
                        alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                        alphaAnimation.setDuration((long) appiraterRatingDialogFragment2.getContext().getResources().getInteger(2131492944));
                        a2.setAnimation(alphaAnimation);
                        c2.m20552b();
                        a.setVisibility(4);
                        ((AlertDialog) this.f16486c.f).a(a2);
                    }
                }, -1546697073);
            }
        }
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1047957377);
        this.au = false;
        au().m20553c();
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1737729967, a);
    }

    public final void m20557I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 80044100);
        for (ScreenInfo screenInfo : this.aw.values()) {
            if (screenInfo.f16493c != null) {
                screenInfo.f16493c.f16496a = null;
            }
            screenInfo.f16493c = null;
        }
        super.I();
        LogUtils.f(-756407499, a);
    }

    private int ar() {
        return this.s.getInt("rating", 0);
    }

    private String as() {
        return this.s.getString("rating_comment");
    }

    private Screen at() {
        return Screen.fromInt(this.s.getInt("current_screen", Screen.STAR_RATING.toInt()));
    }
}
