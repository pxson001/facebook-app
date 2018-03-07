package com.facebook.composer.tip;

import android.content.Context;
import android.os.Parcelable;
import android.view.ViewGroup;
import com.facebook.composer.attachments.AttachmentUtils;
import com.facebook.composer.attachments.ComposerAttachment.ProvidesAttachments;
import com.facebook.composer.event.ComposerEvent;
import com.facebook.fbui.popover.PopoverWindow;
import com.facebook.fbui.popover.PopoverWindow.Position;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.interstitial.manager.InterstitialController.InterstitialControllerState;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesTargetAlbum;
import com.facebook.ipc.composer.intent.ComposerConfigurationSpec.ProvidesConfiguration;
import com.facebook.ipc.composer.intent.ComposerTargetData.ProvidesTargetData;
import com.facebook.ipc.composer.model.ComposerType;
import com.facebook.ipc.composer.model.PublishMode;
import com.facebook.ipc.composer.model.PublishMode.ProvidesPublishMode;
import com.facebook.uicontrib.tipseentracker.TipSeenTracker;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: replaceEdge not implemented yet. */
public class PublishModeSelectorNuxBubbleInterstitialController<DataProvider extends ProvidesAttachments & ProvidesTargetAlbum & ProvidesConfiguration & ProvidesTargetData & ProvidesPublishMode> implements ComposerInterstitialTip {
    public final TipSeenTracker f3469a;
    public Context f3470b;
    private Tooltip f3471c;
    public ViewGroup f3472d;
    public DataProvider f3473e;

    @Inject
    public PublishModeSelectorNuxBubbleInterstitialController(TipSeenTracker tipSeenTracker) {
        this.f3469a = tipSeenTracker;
    }

    public final void mo274a() {
        this.f3470b = null;
        this.f3473e = null;
        this.f3472d = null;
        this.f3471c = null;
    }

    public final void hG_() {
        Preconditions.checkState(m3719d());
        PopoverWindow tooltip = new Tooltip(this.f3470b, 2);
        tooltip.f5777t = -1;
        tooltip.mo540a(Position.ABOVE);
        tooltip.m6259b(this.f3470b.getResources().getString(2131234653));
        tooltip.mo540a(Position.ABOVE);
        tooltip.m6287c(this.f3472d.findViewById(2131560524));
        this.f3471c = tooltip;
        this.f3471c.mo541d();
    }

    public final void mo275a(boolean z) {
        Preconditions.checkState(m3719d());
        this.f3471c.mo542l();
        if (z) {
            this.f3469a.m3733a();
        }
    }

    public final boolean hH_() {
        if (this.f3471c == null) {
            return false;
        }
        return this.f3471c.f5809r;
    }

    public final String m3726b() {
        return "2752";
    }

    public final void m3724a(@Nullable Parcelable parcelable) {
    }

    public final void m3723a(long j) {
    }

    public final InterstitialControllerState m3721a(InterstitialTrigger interstitialTrigger) {
        if (!m3719d()) {
            return InterstitialControllerState.INELIGIBLE;
        }
        if (this.f3472d.getWindowToken() == null) {
            return InterstitialControllerState.INELIGIBLE;
        }
        if (!this.f3469a.m3736c()) {
            return InterstitialControllerState.INELIGIBLE;
        }
        Object obj = (((ProvidesTargetData) this.f3473e).s().a() && !AttachmentUtils.i(this.f3473e.m()) && ((ProvidesConfiguration) this.f3473e).o().getComposerType() != ComposerType.SHARE && ((ProvidesTargetAlbum) this.f3473e).ad() == null && ((ProvidesPublishMode) this.f3473e).j() == PublishMode.NORMAL) ? 1 : null;
        if (obj != null) {
            return InterstitialControllerState.ELIGIBLE;
        }
        return InterstitialControllerState.INELIGIBLE;
    }

    public final ImmutableList<InterstitialTrigger> m3727c() {
        return ImmutableList.of(new InterstitialTrigger(Action.COMPOSER));
    }

    public final long hI_() {
        return 0;
    }

    public final ComposerTip.Action mo273a(ComposerEvent composerEvent) {
        return ComposerTip.Action.SHOW;
    }

    private boolean m3719d() {
        return this.f3470b != null;
    }
}
