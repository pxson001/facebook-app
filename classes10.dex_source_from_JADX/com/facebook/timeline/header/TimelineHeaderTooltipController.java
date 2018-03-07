package com.facebook.timeline.header;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import android.view.View;
import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.common.util.ContextUtils;
import com.facebook.config.application.Boolean_IsWorkBuildMethodAutoProvider;
import com.facebook.fbui.drawable.NetworkDrawable.Prefetcher;
import com.facebook.fbui.drawable.NetworkDrawable.Prefetcher.OnPrefetchListener;
import com.facebook.fbui.popover.PopoverWindow.Position;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.inject.InjectorLike;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.ipc.profile.TimelineContext;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.timeline.delegate.ProfileControllerDelegate;
import com.facebook.timeline.header.data.TimelineHeaderProfilePictureData;
import com.facebook.timeline.header.data.TimelineHeaderUserData;
import com.facebook.timeline.header.ui.ProfileVideoNuxView;
import com.facebook.timeline.prefs.TimelinePreferencesKeys;
import com.facebook.timeline.profilevideo.logging.ProfileVideoEvent;
import com.facebook.timeline.profilevideo.logging.ProfileVideoSessionTracker;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: friend_list_recently_added_friends_seen */
public class TimelineHeaderTooltipController {
    public static final InterstitialTrigger f11417a = new InterstitialTrigger(Action.TIMELINE);
    public final Context f11418b;
    public final InterstitialManager f11419c;
    private final FbSharedPreferences f11420d;
    private final boolean f11421e;
    public final Handler f11422f;
    public final ProfileControllerDelegate f11423g;
    public final ProfileVideoSessionTracker f11424h;
    public int f11425i;
    public boolean f11426j = false;
    public boolean f11427k = false;
    private boolean f11428l = false;

    /* compiled from: friend_list_recently_added_friends_seen */
    public class C16492 implements OnClickListener {
        final /* synthetic */ TimelineHeaderTooltipController f11416a;

        public C16492(TimelineHeaderTooltipController timelineHeaderTooltipController) {
            this.f11416a = timelineHeaderTooltipController;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f11416a.f11424h.a(ProfileVideoEvent.NUX_MAIN_BUTTON_CLICKED, null);
            this.f11416a.f11423g.mo473l().mo549c();
        }
    }

    public static TimelineHeaderTooltipController m11471a(InjectorLike injectorLike) {
        return new TimelineHeaderTooltipController((Context) injectorLike.getInstance(Context.class), InterstitialManager.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), Boolean_IsWorkBuildMethodAutoProvider.a(injectorLike), Handler_ForUiThreadMethodAutoProvider.b(injectorLike), ProfileControllerDelegate.m10751a(injectorLike), ProfileVideoSessionTracker.a(injectorLike));
    }

    @Inject
    public TimelineHeaderTooltipController(Context context, InterstitialManager interstitialManager, FbSharedPreferences fbSharedPreferences, Boolean bool, Handler handler, ProfileControllerDelegate profileControllerDelegate, ProfileVideoSessionTracker profileVideoSessionTracker) {
        this.f11418b = context;
        this.f11419c = interstitialManager;
        this.f11420d = fbSharedPreferences;
        this.f11421e = bool.booleanValue();
        this.f11422f = handler;
        this.f11423g = profileControllerDelegate;
        this.f11424h = profileVideoSessionTracker;
    }

    public final void m11474a(TimelineContext timelineContext, TimelineHeaderUserData timelineHeaderUserData, View view) {
        if (!this.f11427k && !this.f11428l && this.f11420d.a(TimelinePreferencesKeys.b, true) && timelineContext.i() && !timelineHeaderUserData.j()) {
            ProfileVideoNuxInterstitialController profileVideoNuxInterstitialController = (ProfileVideoNuxInterstitialController) this.f11419c.a("3972", ProfileVideoNuxInterstitialController.class);
            profileVideoNuxInterstitialController.b = true;
            ProfileVideoNuxInterstitialController profileVideoNuxInterstitialController2 = (ProfileVideoNuxInterstitialController) this.f11419c.a(f11417a, ProfileVideoNuxInterstitialController.class);
            profileVideoNuxInterstitialController.b = false;
            ProfileVideoNuxInterstitialController profileVideoNuxInterstitialController3 = profileVideoNuxInterstitialController2;
            if (profileVideoNuxInterstitialController3 != null) {
                m11473a(profileVideoNuxInterstitialController3.b());
            } else if (!timelineHeaderUserData.v() || (timelineHeaderUserData.l != null && timelineHeaderUserData.l.b())) {
                ProfileVideoTrimmerNuxInterstitialController profileVideoTrimmerNuxInterstitialController = (ProfileVideoTrimmerNuxInterstitialController) this.f11419c.a("4101", ProfileVideoTrimmerNuxInterstitialController.class);
                profileVideoTrimmerNuxInterstitialController.f11313a = true;
                ProfileVideoTrimmerNuxInterstitialController profileVideoTrimmerNuxInterstitialController2 = (ProfileVideoTrimmerNuxInterstitialController) this.f11419c.a(f11417a, ProfileVideoTrimmerNuxInterstitialController.class);
                profileVideoTrimmerNuxInterstitialController.f11313a = false;
                ProfileVideoTrimmerNuxInterstitialController profileVideoTrimmerNuxInterstitialController3 = profileVideoTrimmerNuxInterstitialController2;
                if (profileVideoTrimmerNuxInterstitialController3 != null) {
                    m11472a(2131234999, view, profileVideoTrimmerNuxInterstitialController3.m11403b());
                    return;
                }
                TempProfilePicNuxInterstitialController tempProfilePicNuxInterstitialController = (TempProfilePicNuxInterstitialController) this.f11419c.a("3876", TempProfilePicNuxInterstitialController.class);
                tempProfilePicNuxInterstitialController.a = true;
                TempProfilePicNuxInterstitialController tempProfilePicNuxInterstitialController2 = (TempProfilePicNuxInterstitialController) this.f11419c.a(f11417a, TempProfilePicNuxInterstitialController.class);
                tempProfilePicNuxInterstitialController.a = false;
                TempProfilePicNuxInterstitialController tempProfilePicNuxInterstitialController3 = tempProfilePicNuxInterstitialController2;
                if (tempProfilePicNuxInterstitialController3 != null) {
                    m11472a(2131235056, view, tempProfilePicNuxInterstitialController3.b());
                    return;
                }
                ProfilePicUnifiedEditingNuxInterstitialController profilePicUnifiedEditingNuxInterstitialController = (ProfilePicUnifiedEditingNuxInterstitialController) this.f11419c.a("3887", ProfilePicUnifiedEditingNuxInterstitialController.class);
                profilePicUnifiedEditingNuxInterstitialController.a = true;
                ProfilePicUnifiedEditingNuxInterstitialController profilePicUnifiedEditingNuxInterstitialController2 = (ProfilePicUnifiedEditingNuxInterstitialController) this.f11419c.a(f11417a, ProfilePicUnifiedEditingNuxInterstitialController.class);
                profilePicUnifiedEditingNuxInterstitialController.a = false;
                ProfilePicUnifiedEditingNuxInterstitialController profilePicUnifiedEditingNuxInterstitialController3 = profilePicUnifiedEditingNuxInterstitialController2;
                if (profilePicUnifiedEditingNuxInterstitialController3 != null) {
                    m11472a(2131235058, view, profilePicUnifiedEditingNuxInterstitialController3.b());
                    return;
                }
                ProfilePictureNuxBubbleInterstitialController a = m11470a(timelineHeaderUserData);
                if (a != null) {
                    m11472a(2131234896, view, a.b());
                }
            } else {
                m11472a(this.f11421e ? 2131234895 : 2131234894, view, null);
            }
        }
    }

    private void m11473a(final String str) {
        int i = 0;
        this.f11428l = true;
        int[] iArr = new int[]{2130842785, 2130842784};
        this.f11425i = 2;
        C16481 c16481 = new OnPrefetchListener(this) {
            final /* synthetic */ TimelineHeaderTooltipController f11415b;

            /* compiled from: friend_list_recently_added_friends_seen */
            class C16471 implements Runnable {
                final /* synthetic */ C16481 f11413a;

                C16471(C16481 c16481) {
                    this.f11413a = c16481;
                }

                public void run() {
                    TimelineHeaderTooltipController timelineHeaderTooltipController = this.f11413a.f11415b;
                    timelineHeaderTooltipController.f11425i--;
                    if (!this.f11413a.f11415b.f11426j && this.f11413a.f11415b.f11425i == 0) {
                        timelineHeaderTooltipController = this.f11413a.f11415b;
                        String str = str;
                        Activity activity = (Activity) ContextUtils.a(timelineHeaderTooltipController.f11418b, Activity.class);
                        if (activity != null) {
                            new FbAlertDialogBuilder(activity).a(new ProfileVideoNuxView(timelineHeaderTooltipController.f11418b), 0, 0, 0, 0).a(2131234998, new C16492(timelineHeaderTooltipController)).b(2131230737, null).a().show();
                            timelineHeaderTooltipController.f11427k = true;
                            timelineHeaderTooltipController.f11419c.a().a(str);
                        }
                    }
                }
            }

            public final void m11469a() {
                HandlerDetour.a(this.f11415b.f11422f, new C16471(this), 286697413);
            }
        };
        while (i < 2) {
            Prefetcher.a(this.f11418b.getResources(), iArr[i], c16481);
            i++;
        }
    }

    private void m11472a(int i, View view, @Nullable String str) {
        Tooltip tooltip = new Tooltip(this.f11418b, 2);
        tooltip.a(Position.ABOVE);
        tooltip.t = -1;
        tooltip.a(view);
        tooltip.a(i);
        tooltip.d();
        this.f11427k = true;
        if (str != null) {
            this.f11419c.a().a(str);
        }
    }

    @Nullable
    private ProfilePictureNuxBubbleInterstitialController m11470a(TimelineHeaderUserData timelineHeaderUserData) {
        long d;
        ProfilePictureNuxBubbleInterstitialController profilePictureNuxBubbleInterstitialController = (ProfilePictureNuxBubbleInterstitialController) this.f11419c.a("3336", ProfilePictureNuxBubbleInterstitialController.class);
        TimelineHeaderProfilePictureData timelineHeaderProfilePictureData = timelineHeaderUserData.f;
        if (timelineHeaderProfilePictureData.b != null) {
            d = timelineHeaderProfilePictureData.b.d();
        } else {
            d = 0;
        }
        profilePictureNuxBubbleInterstitialController.a = d;
        profilePictureNuxBubbleInterstitialController.c = true;
        ProfilePictureNuxBubbleInterstitialController profilePictureNuxBubbleInterstitialController2 = (ProfilePictureNuxBubbleInterstitialController) this.f11419c.a(f11417a, ProfilePictureNuxBubbleInterstitialController.class);
        profilePictureNuxBubbleInterstitialController.c = false;
        profilePictureNuxBubbleInterstitialController.a = 0;
        return profilePictureNuxBubbleInterstitialController2;
    }
}
