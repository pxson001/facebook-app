package com.facebook.composer.tip;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.composer.event.ComposerEvent;
import com.facebook.composer.prefs.ComposerPrefKeys;
import com.facebook.fbui.popover.PopoverWindow;
import com.facebook.fbui.popover.PopoverWindow.OnDismissListener;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.inject.Assisted;
import com.facebook.uicontrib.tipseentracker.TipSeenTracker;
import javax.inject.Inject;

/* compiled from: composer_stickers_enter_flow */
public class ComposerStickerIconTipController implements ComposerTip {
    private final ViewGroup f16975a;
    public final TipSeenTracker f16976b;
    private final Context f16977c;
    private Tooltip f16978d;

    /* compiled from: composer_stickers_enter_flow */
    class C13671 implements OnDismissListener {
        final /* synthetic */ ComposerStickerIconTipController f16974a;

        C13671(ComposerStickerIconTipController composerStickerIconTipController) {
            this.f16974a = composerStickerIconTipController;
        }

        public final boolean m20933a(PopoverWindow popoverWindow) {
            this.f16974a.f16976b.a();
            return true;
        }
    }

    @Inject
    public ComposerStickerIconTipController(@Assisted ViewGroup viewGroup, TipSeenTracker tipSeenTracker, Context context) {
        this.f16975a = viewGroup;
        this.f16976b = tipSeenTracker;
        this.f16977c = context;
        this.f16976b.a(ComposerPrefKeys.o);
    }

    public final void m20935a() {
    }

    public final void hG_() {
        if (this.f16975a != null) {
            View findViewById = this.f16975a.findViewById(2131560656);
            if (findViewById != null) {
                if (this.f16978d == null) {
                    this.f16978d = new Tooltip(this.f16977c, 2);
                    this.f16978d.H = new C13671(this);
                    this.f16978d.b(2131234770);
                }
                this.f16978d.f(findViewById);
            }
        }
    }

    public final void m20936a(boolean z) {
        if (this.f16978d != null) {
            this.f16978d.l();
        }
    }

    public final boolean hH_() {
        if (this.f16978d == null) {
            return false;
        }
        return this.f16978d.r;
    }

    public final ComposerTip$Action m20934a(ComposerEvent composerEvent) {
        if (composerEvent == ComposerEvent.ON_FIRST_DRAW && this.f16976b.c() && this.f16975a.findViewById(2131560656) != null) {
            return ComposerTip$Action.SHOW;
        }
        return ComposerTip$Action.NONE;
    }
}
