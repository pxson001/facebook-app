package com.facebook.backstage.consumption.swipe;

import android.content.Context;
import android.view.ViewGroup;
import com.facebook.backstage.data.BackstageProfile.BackstageStory;
import com.facebook.pager.renderers.standard.PagerViewItem;

/* compiled from: return-data */
public abstract class BaseBackstageStoryPagerViewItem extends PagerViewItem<BackstageStory> {
    public abstract void mo180f();

    public abstract boolean mo181g();

    public abstract BackstageStoryCommonController getController();

    public BaseBackstageStoryPagerViewItem(Context context) {
        super(context);
    }

    public final void mo163a() {
        getController().m4875a();
    }

    public void mo179a(ViewGroup viewGroup, BackstageStory backstageStory, int i, float f, float f2, float f3, boolean z) {
        getController().m4876a(this, viewGroup, backstageStory, f, f2, f3, z);
        if (z) {
            backstageStory.m4893b();
        }
    }

    public final void mo165a(boolean z) {
        BackstageStoryCommonController controller = getController();
        if (z && controller.f5084g != null) {
            controller.f5084g.m4830a(controller.f5083f);
        }
    }

    public final void mo166b() {
        setVisibility(0);
    }

    public final void mo167e() {
        setVisibility(8);
    }
}
