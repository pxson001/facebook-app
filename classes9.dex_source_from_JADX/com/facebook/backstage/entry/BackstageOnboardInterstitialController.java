package com.facebook.backstage.entry;

import android.content.Context;
import android.os.Parcelable;
import com.facebook.backstage.StacksConstants;
import com.facebook.backstage.abtest.BackstageGatekeepers;
import com.facebook.common.util.TriState;
import com.facebook.fbui.popover.PopoverWindow;
import com.facebook.fbui.popover.PopoverWindow.OnDismissListener;
import com.facebook.inject.InjectorLike;
import com.facebook.interstitial.manager.InterstitialController;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: resized_ */
public class BackstageOnboardInterstitialController implements InterstitialController {
    public static final InterstitialTrigger f5173a = new InterstitialTrigger(Action.BACKSTAGE_NUX);
    public final FbSharedPreferences f5174b;
    public final Context f5175c;
    private final BackstageGatekeepers f5176d;

    /* compiled from: resized_ */
    public class C05511 implements OnDismissListener {
        final /* synthetic */ BackstageOnboardInterstitialController f5172a;

        public C05511(BackstageOnboardInterstitialController backstageOnboardInterstitialController) {
            this.f5172a = backstageOnboardInterstitialController;
        }

        public final boolean m4948a(PopoverWindow popoverWindow) {
            this.f5172a.f5174b.edit().putBoolean(StacksConstants.f4263m, false).commit();
            return true;
        }
    }

    public static BackstageOnboardInterstitialController m4949b(InjectorLike injectorLike) {
        return new BackstageOnboardInterstitialController((Context) injectorLike.getInstance(Context.class), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), BackstageGatekeepers.m4256b(injectorLike));
    }

    @Inject
    public BackstageOnboardInterstitialController(Context context, FbSharedPreferences fbSharedPreferences, BackstageGatekeepers backstageGatekeepers) {
        this.f5175c = context;
        this.f5174b = fbSharedPreferences;
        this.f5176d = backstageGatekeepers;
    }

    public final String m4953b() {
        return "4063";
    }

    public final void m4952a(Parcelable parcelable) {
    }

    public final void m4951a(long j) {
    }

    public final boolean m4955e() {
        return this.f5174b.a(StacksConstants.f4262l, true);
    }

    public final InterstitialControllerState m4950a(InterstitialTrigger interstitialTrigger) {
        if (TriState.YES.equals(this.f5176d.f4264a.a(990))) {
            return InterstitialControllerState.ELIGIBLE;
        }
        return InterstitialControllerState.INELIGIBLE;
    }

    public final ImmutableList<InterstitialTrigger> m4954c() {
        return ImmutableList.of(f5173a);
    }

    public final long hI_() {
        return 0;
    }
}
