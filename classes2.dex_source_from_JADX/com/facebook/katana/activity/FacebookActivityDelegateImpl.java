package com.facebook.katana.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.res.Configuration;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import com.facebook.analytics.InteractionLogger;
import com.facebook.analytics.activityidentifier.ActivityNameFormatter;
import com.facebook.analytics.useractions.UserActionsRecorder;
import com.facebook.auth.datastore.impl.LoggedInUserSessionManager;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.base.activity.UsesSimpleStringTitle;
import com.facebook.common.activitylistener.annotations.AuthNotRequiredHelper;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.intent.ActivityLaunchIntentUtil;
import com.facebook.common.ui.util.DisplayUtils;
import com.facebook.debug.asserts.Assert;
import com.facebook.divebar.DivebarController$DivebarAnimationListener;
import com.facebook.divebar.DivebarController.DivebarState;
import com.facebook.divebar.DrawerBasedDivebarControllerImpl;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.Lazy;
import com.facebook.katana.activity.apps.MobileCanvasDialogUrlHolder;
import com.facebook.katana.activity.apps.PlatformWebViewDialog;
import com.facebook.katana.activity.faceweb.FacewebAssassin;
import com.facebook.katana.activity.faceweb.FacewebAssassin.BookmarksMenuAssassin;
import com.facebook.messaging.activity.DivebarEnabledActivity;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ui.titlebar.Fb4aTitleBar;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.player.PlayerActivityManager;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.RegularImmutableBiMap;

/* compiled from: subscription */
public class FacebookActivityDelegateImpl extends FacebookActivityDelegate {
    private static final Class<?> f3889a = FacebookActivityDelegateImpl.class;
    public final LoggedInUserSessionManager f3890b;
    public final Lazy<PlayerActivityManager> f3891c;
    private String f3892d;
    public final Activity f3893e;
    private final FbInjector f3894f;
    private FacewebAssassin f3895g;
    public String f3896h = null;
    public final InteractionLogger f3897i;
    public final AbstractFbErrorReporter f3898j;
    public DrawerBasedDivebarControllerImpl f3899k;
    private final ActivityNameFormatter f3900l;

    /* compiled from: subscription */
    class C03683 implements DivebarController$DivebarAnimationListener {
        final /* synthetic */ FacebookActivityDelegateImpl f8419a;

        C03683(FacebookActivityDelegateImpl facebookActivityDelegateImpl) {
            this.f8419a = facebookActivityDelegateImpl;
        }

        public final void mo1747a(DivebarState divebarState) {
        }

        public final void mo1748b(DivebarState divebarState) {
            if (divebarState == DivebarState.OPENED && this.f8419a.f3891c != null) {
                ((PlayerActivityManager) this.f8419a.f3891c.get()).m12998a(EventTriggerType.BY_DIVEBAR);
            } else if (divebarState == DivebarState.CLOSED && this.f8419a.f3891c != null) {
                ((PlayerActivityManager) this.f8419a.f3891c.get()).m13002b(EventTriggerType.BY_DIVEBAR);
            }
        }
    }

    public final ImmutableMap<String, String> mo900g() {
        return RegularImmutableBiMap.f695a;
    }

    public FacebookActivityDelegateImpl(Activity activity) {
        Preconditions.checkNotNull(activity);
        this.f3893e = activity;
        this.f3894f = FbInjector.get(this.f3893e);
        this.f3897i = InteractionLogger.m6498a(this.f3894f);
        this.f3898j = FbErrorReporterImpl.m2317a(this.f3894f);
        this.f3890b = LoggedInUserSessionManager.m2511a(this.f3894f);
        this.f3900l = ActivityNameFormatter.m6512a(this.f3894f);
        this.f3891c = IdBasedLazy.m1808a(this.f3894f, 3685);
    }

    public final boolean mo896c() {
        return this.f3896h != null;
    }

    public final void mo895a(TitleBarButtonSpec titleBarButtonSpec) {
        Fb4aTitleBar fb4aTitleBar = (Fb4aTitleBar) this.f3893e.findViewById(2131558563);
        if (fb4aTitleBar != null) {
            fb4aTitleBar.setPrimaryButton(titleBarButtonSpec);
        }
    }

    public final Optional<Boolean> mo254b(Activity activity, int i, KeyEvent keyEvent) {
        if (i == 4) {
            Object obj;
            if (BuildConstants.i) {
                UserActionsRecorder.a(this.f3894f).a();
            }
            if (!keyEvent.isTracking() || keyEvent.isCanceled()) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                if (this.f3899k == null || !this.f3899k.kX_()) {
                    this.f3897i.m6509b("back_button", "android_button", null);
                    obj = null;
                } else {
                    this.f3899k.kY_();
                    obj = 1;
                }
                if (obj == null) {
                    activity.onBackPressed();
                }
                return Optional.of(Boolean.valueOf(true));
            }
        }
        return Absent.INSTANCE;
    }

    public final void mo263c(Activity activity) {
        if (this.f3895g != null) {
            FacewebAssassin facewebAssassin = this.f3895g;
            HandlerDetour.a(facewebAssassin.b, facewebAssassin);
            this.f3895g = null;
        }
        if (!AuthNotRequiredHelper.m6539a(this.f3893e)) {
            Object obj = null;
            ViewerContext a = this.f3890b.m2517a();
            if (a != null) {
                String str = a.mUserId;
                if (str != null) {
                    if (this.f3896h == null) {
                        this.f3896h = str;
                    }
                    if (!this.f3896h.equals(str)) {
                        obj = 1;
                    }
                }
            }
            if (obj != null) {
                this.f3893e.finish();
                return;
            }
        }
        m6477l();
        this.f3898j.mo346d(ActivityNameFormatter.m6513a(this.f3893e));
    }

    public final Dialog mo243a(int i) {
        switch (i) {
            case 684737812:
                return new PlatformWebViewDialog(this.f3893e, 2131625691);
            default:
                return null;
        }
    }

    public final boolean mo252a(int i, Dialog dialog) {
        switch (i) {
            case 684737812:
                if (MobileCanvasDialogUrlHolder.a == null) {
                    this.f3898j.m2350b("MobileCanvas", "Trying to open a Mobile Canvas Dialog with a null URL");
                }
                this.f3898j.m2350b("MobileCanvas", "Trying to open a Mobile Canvas Dialog on a non-faceweb view.");
                break;
        }
        return false;
    }

    public final String mo897d() {
        if (this.f3892d == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.f3893e.getClass().getSimpleName());
            String a = ActivityLaunchIntentUtil.a(this.f3893e.getIntent());
            if (a != null) {
                stringBuilder.append('@');
                stringBuilder.append(a);
            }
            this.f3892d = stringBuilder.toString();
        }
        return this.f3892d;
    }

    public final void mo261a(Activity activity) {
        View findViewById = this.f3893e.findViewById(2131558563);
        Fb4aTitleBar fb4aTitleBar = findViewById == null ? null : (Fb4aTitleBar) findViewById;
        if (fb4aTitleBar != null) {
            if (this.f3893e instanceof BookmarksMenuHost) {
                fb4aTitleBar.setActionButtonOnClickListener(new 1(this));
            }
            if (this.f3893e instanceof UsesSimpleStringTitle) {
                fb4aTitleBar.setTitle(((UsesSimpleStringTitle) this.f3893e).m12882a());
                fb4aTitleBar.mo1617a(new 2(this));
                fb4aTitleBar.setHasBackButton(false);
            }
        }
        if (activity instanceof DivebarEnabledActivity) {
            m6476a(((DivebarEnabledActivity) activity).mo794f());
        }
    }

    public final void mo248a(Activity activity, Configuration configuration) {
        m6477l();
    }

    public final void mo898e() {
        Assert.m9537b(this.f3895g);
        this.f3895g = FacewebAssassin.a(new Handler(), new BookmarksMenuAssassin(), 35000);
    }

    private void m6477l() {
        Activity activity = this.f3893e;
        DisplayUtils.m13107a(activity.findViewById(2131562149), activity.getResources().getDimensionPixelSize(2131430871));
    }

    private void m6476a(DrawerBasedDivebarControllerImpl drawerBasedDivebarControllerImpl) {
        drawerBasedDivebarControllerImpl.f8374k = new C03683(this);
    }

    public final void mo899f() {
        DrawerBasedDivebarControllerImpl n = m6479n();
        if (n == null) {
            n = DrawerBasedDivebarControllerImpl.m12883a(this.f3894f);
            m6476a(n);
            this.f3899k = n;
        }
        n.m12887a(this.f3893e);
        n.m12895i();
        m6478m();
    }

    private void m6478m() {
        DrawerBasedDivebarControllerImpl n = m6479n();
        if (n != null) {
            n.kZ_();
        }
    }

    private DrawerBasedDivebarControllerImpl m6479n() {
        if (this.f3893e instanceof DivebarEnabledActivity) {
            return ((DivebarEnabledActivity) this.f3893e).mo794f();
        }
        return this.f3899k;
    }
}
