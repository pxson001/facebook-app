package com.facebook.pages.common.surface.calltoaction;

import android.content.Context;
import android.os.Parcelable;
import android.view.View;
import com.facebook.fbui.popover.PopoverWindow;
import com.facebook.fbui.popover.PopoverWindow.Position;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.inject.InjectorLike;
import com.facebook.interstitial.manager.InterstitialController;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.google.common.collect.ImmutableList;

/* compiled from: relative_start_ms */
public class PageCallToActionButtonNuxController implements InterstitialController {
    private static PageCallToActionButtonNuxController m3812d() {
        return new PageCallToActionButtonNuxController();
    }

    public final String m3816b() {
        return "3795";
    }

    public static void m3811a(View view, View view2, Context context, String str) {
        PopoverWindow tooltip = new Tooltip(context, 2);
        tooltip.m6259b((CharSequence) str);
        tooltip.mo540a(Position.BELOW);
        tooltip.f5777t = -1;
        tooltip.m6279a(view, view2.getLeft(), view2.getTop(), view2.getWidth(), view2.getHeight());
        tooltip.mo541d();
    }

    public static PageCallToActionButtonNuxController m3810a(InjectorLike injectorLike) {
        return m3812d();
    }

    public final void m3815a(Parcelable parcelable) {
    }

    public final void m3814a(long j) {
    }

    public final InterstitialControllerState m3813a(InterstitialTrigger interstitialTrigger) {
        return InterstitialControllerState.ELIGIBLE;
    }

    public final ImmutableList<InterstitialTrigger> m3817c() {
        return ImmutableList.of(new InterstitialTrigger(Action.PAGE_CALL_TO_ACTION_BUTTON));
    }

    public final long hI_() {
        return 86400000;
    }
}
