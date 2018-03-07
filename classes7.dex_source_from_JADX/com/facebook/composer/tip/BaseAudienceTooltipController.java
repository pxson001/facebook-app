package com.facebook.composer.tip;

import android.view.ViewGroup;
import com.facebook.common.util.StringUtil;
import com.facebook.composer.activity.ComposerDataProviderImpl;
import com.facebook.composer.audienceeducator.ComposerAudienceEducatorData.ProvidesAudienceEducatorData;
import com.facebook.fbui.popover.PopoverWindow;
import com.facebook.fbui.popover.PopoverWindow.OnDismissListener;
import com.facebook.fbui.tooltip.Tooltip;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsPrivacyPillSupported;
import com.google.common.base.Preconditions;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;

/* compiled from: composer_text */
public abstract class BaseAudienceTooltipController<DataProvider extends ProvidesAudienceEducatorData & ProvidesIsPrivacyPillSupported> implements ComposerTip {
    public final WeakReference<DataProvider> f16960a;
    public final WeakReference<ViewGroup> f16961b;
    public final WeakReference<ViewGroup> f16962c;
    public Tooltip f16963d = null;
    public boolean f16964e = false;

    /* compiled from: composer_text */
    class C13651 implements OnDismissListener {
        final /* synthetic */ BaseAudienceTooltipController f16972a;

        C13651(BaseAudienceTooltipController baseAudienceTooltipController) {
            this.f16972a = baseAudienceTooltipController;
        }

        public final boolean m20932a(PopoverWindow popoverWindow) {
            this.f16972a.f16964e = false;
            return false;
        }
    }

    /* compiled from: composer_text */
    class C13662 implements Runnable {
        final /* synthetic */ BaseAudienceTooltipController f16973a;

        C13662(BaseAudienceTooltipController baseAudienceTooltipController) {
            this.f16973a = baseAudienceTooltipController;
        }

        public void run() {
            this.f16973a.f16963d.d();
        }
    }

    public BaseAudienceTooltipController(ViewGroup viewGroup, ViewGroup viewGroup2, DataProvider dataProvider) {
        WeakReference weakReference = null;
        this.f16961b = new WeakReference(viewGroup);
        if (viewGroup2 != null) {
            weakReference = new WeakReference(viewGroup2);
        }
        this.f16962c = weakReference;
        this.f16960a = new WeakReference(dataProvider);
    }

    public int hF_() {
        return 1;
    }

    public final void m20923a() {
        if (this.f16963d != null) {
            this.f16963d.l();
        }
    }

    public final void hG_() {
        ViewGroup viewGroup;
        boolean z = false;
        if (this.f16962c != null) {
            viewGroup = (ViewGroup) this.f16962c.get();
        } else {
            viewGroup = (ViewGroup) this.f16961b.get();
        }
        ViewGroup viewGroup2 = viewGroup;
        if (viewGroup2 != null) {
            String str;
            if (this.f16963d == null) {
                Tooltip tooltip = new Tooltip(viewGroup2.getContext(), hF_());
                tooltip.t = -1;
                if (this.f16962c != null) {
                    tooltip.c(viewGroup2.findViewById(2131566185));
                } else if (((ComposerDataProviderImpl) Preconditions.checkNotNull(this.f16960a.get())).O()) {
                    tooltip.c(viewGroup2.findViewById(2131560596));
                } else {
                    tooltip.c(viewGroup2.findViewById(2131560617));
                }
                this.f16963d = tooltip;
            }
            ComposerDataProviderImpl composerDataProviderImpl = (ComposerDataProviderImpl) Preconditions.checkNotNull(this.f16960a.get());
            if (composerDataProviderImpl == null) {
                str = null;
            } else {
                str = composerDataProviderImpl.az().f16676a;
            }
            String str2 = str;
            CharSequence d = mo1336d();
            boolean z2 = !StringUtil.a(str2);
            if (!StringUtil.a(d)) {
                z = true;
            }
            if (z2 || z) {
                this.f16964e = true;
                this.f16963d.H = new C13651(this);
                if (z2) {
                    this.f16963d.a(str2);
                }
                if (z) {
                    this.f16963d.b(d);
                }
                viewGroup2.post(new C13662(this));
            }
        }
    }

    public final void m20924a(boolean z) {
        if (this.f16963d != null) {
            this.f16963d.l();
        }
    }

    public final boolean hH_() {
        return this.f16964e;
    }

    @Nullable
    protected CharSequence mo1336d() {
        ComposerDataProviderImpl composerDataProviderImpl = (ComposerDataProviderImpl) Preconditions.checkNotNull(this.f16960a.get());
        if (composerDataProviderImpl == null) {
            return null;
        }
        return composerDataProviderImpl.az().f16677b;
    }
}
