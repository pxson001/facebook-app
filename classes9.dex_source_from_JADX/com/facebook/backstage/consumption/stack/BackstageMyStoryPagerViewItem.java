package com.facebook.backstage.consumption.stack;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.facebook.backstage.analytics.BackstageAnalyticsLogger;
import com.facebook.backstage.analytics.BackstageAnalyticsLogger.Event;
import com.facebook.backstage.consumption.swipe.BackstageStoryCommonController;
import com.facebook.backstage.consumption.swipe.BaseBackstageStoryPagerViewItem;
import com.facebook.backstage.data.BackstageProfile.BackstageStory;
import com.facebook.backstage.ui.LazyView;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.fbui.popover.PopoverListViewWindow;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;

/* compiled from: retry_index */
public class BackstageMyStoryPagerViewItem extends BaseBackstageStoryPagerViewItem {
    private final BackstageStoryCommonController<BackstageStory> f4982a;
    private final BackstageAnalyticsLogger f4983b;
    private final FbTextView f4984c;
    private final BackstagePopupWindowAdapter f4985d;
    private final PopoverListViewWindow f4986e;

    public BackstageMyStoryPagerViewItem(Context context, FbDraweeControllerBuilder fbDraweeControllerBuilder, BackstageAnalyticsLogger backstageAnalyticsLogger, FbTextView fbTextView) {
        super(context);
        this.f4983b = backstageAnalyticsLogger;
        this.f4984c = fbTextView;
        View inflate = LayoutInflater.from(getContext()).inflate(2130903374, this);
        this.f4982a = new BackstageStoryCommonController(getContext(), fbDraweeControllerBuilder, new LazyView((ViewStub) inflate.findViewById(2131559859)), new LazyView((ViewStub) inflate.findViewById(2131559880)), new LazyView((ViewStub) inflate.findViewById(2131559881)));
        fbTextView.setText(getResources().getQuantityString(2131689749, 0, new Object[]{Integer.valueOf(0)}));
        this.f4985d = new BackstagePopupWindowAdapter();
        this.f4986e = new PopoverListViewWindow(getContext());
        this.f4986e.e = true;
        this.f4986e.e(true);
        this.f4986e.c(false);
        this.f4986e.m = this.f4985d;
    }

    protected BackstageStoryCommonController getController() {
        return this.f4982a;
    }

    public final void mo180f() {
        AdapterDetour.a(this.f4985d, -1725571239);
        this.f4986e.a(this.f4984c);
    }

    public final boolean mo181g() {
        if (this.f4986e.r) {
            this.f4986e.l();
            return true;
        }
        this.f4983b.m4264a(Event.CLOSED_SELF_STACK);
        return false;
    }

    public final void mo179a(ViewGroup viewGroup, BackstageStory backstageStory, int i, float f, float f2, float f3, boolean z) {
        if (f == 0.0f && z) {
            this.f4984c.setText(getResources().getQuantityString(2131689749, backstageStory.f5105c.size(), new Object[]{Integer.valueOf(backstageStory.m4894e().size())}));
            this.f4985d.f4987a = backstageStory.m4894e();
        }
        super.mo179a(viewGroup, backstageStory, i, f, f2, f3, z);
    }
}
