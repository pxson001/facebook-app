package com.facebook.composer.tip;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.facebook.composer.event.ComposerEvent;
import com.facebook.composer.prefs.ComposerPrefKeys;
import com.facebook.fbui.popover.PopoverWindow;
import com.facebook.fbui.popover.PopoverWindow.OnDismissListener;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.inject.Assisted;
import com.facebook.uicontrib.tipseentracker.TipSeenTracker;
import com.google.common.base.Preconditions;
import java.lang.ref.WeakReference;
import javax.inject.Inject;

/* compiled from: composer_stickers_removed_sticker */
public class AudienceTagExpansionTipController implements ComposerTip {
    public final Context f16967a;
    public final TipSeenTracker f16968b;
    public final WeakReference<ViewGroup> f16969c;
    public RelativeLayout f16970d;
    public Tooltip f16971e;

    /* compiled from: composer_stickers_removed_sticker */
    public class C13631 implements OnDismissListener {
        final /* synthetic */ AudienceTagExpansionTipController f16965a;

        public C13631(AudienceTagExpansionTipController audienceTagExpansionTipController) {
            this.f16965a = audienceTagExpansionTipController;
        }

        public final boolean m20928a(PopoverWindow popoverWindow) {
            this.f16965a.f16968b.a();
            return false;
        }
    }

    /* compiled from: composer_stickers_removed_sticker */
    /* synthetic */ class C13642 {
        static final /* synthetic */ int[] f16966a = new int[ComposerEvent.values().length];

        static {
            try {
                f16966a[ComposerEvent.ON_TAG_EXPANSION_DISABLED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
        }
    }

    @Inject
    public AudienceTagExpansionTipController(Context context, TipSeenTracker tipSeenTracker, @Assisted ViewGroup viewGroup) {
        this.f16967a = context;
        this.f16968b = tipSeenTracker;
        this.f16969c = new WeakReference(Preconditions.checkNotNull(viewGroup));
        this.f16968b.a(ComposerPrefKeys.d);
    }

    public final void m20930a() {
        this.f16970d = null;
    }

    public final void hG_() {
        if ((this.f16971e == null || !this.f16971e.r) && this.f16968b.c()) {
            this.f16970d = (RelativeLayout) ((ViewGroup) this.f16969c.get()).findViewWithTag("TAG_EXPANSION_VIEW").findViewById(2131561315);
            if (this.f16970d != null) {
                if (this.f16971e == null) {
                    this.f16971e = new Tooltip(this.f16967a, 2);
                    this.f16971e.b(this.f16967a.getResources().getString(2131234221));
                    this.f16971e.t = -1;
                    this.f16971e.H = new C13631(this);
                }
                this.f16971e.c(this.f16970d);
            }
            if (this.f16970d != null) {
                this.f16971e.d();
            }
        }
    }

    public final void m20931a(boolean z) {
    }

    public final boolean hH_() {
        if (this.f16971e == null) {
            return false;
        }
        return this.f16971e.r;
    }

    public final ComposerTip$Action m20929a(ComposerEvent composerEvent) {
        switch (C13642.f16966a[composerEvent.ordinal()]) {
            case 1:
                return ComposerTip$Action.SHOW;
            default:
                return ComposerTip$Action.NONE;
        }
    }
}
