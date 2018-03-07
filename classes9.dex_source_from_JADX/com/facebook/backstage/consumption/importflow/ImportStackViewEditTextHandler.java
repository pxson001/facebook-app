package com.facebook.backstage.consumption.importflow;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.facebook.backstage.consumption.swipe.BackstageStoryCommonController;
import com.facebook.backstage.consumption.swipe.BackstageSwipeController;
import com.facebook.backstage.consumption.swipe.BackstageSwipeController.GestureEventListener;
import com.facebook.backstage.ui.ToggleableEditText;
import com.facebook.backstage.ui.ToggleableEditText.ToggleEventListener;
import com.facebook.pager.PagerViewController;
import com.facebook.resources.ui.FbTextView;

/* compiled from: ride_service_promotion */
public class ImportStackViewEditTextHandler implements GestureEventListener, ToggleEventListener {
    public ImportFlowTitleView f4824a;
    public ViewGroup f4825b;
    public ToggleableEditText f4826c;
    public BackstageSwipeController<ImportMedia, ImportFlowStackPagerViewItem> f4827d;

    public final void mo175a() {
        this.f4824a.m4700b();
        ImportMedia importMedia = (ImportMedia) this.f4827d.f5097f.f18378C;
        this.f4826c.setText("");
        this.f4826c.getText().append(importMedia.mo173h());
        importMedia.f4817a = "";
        BackstageStoryCommonController backstageStoryCommonController = ((ImportFlowStackPagerViewItem) this.f4827d.m4890c()).f4780a;
        if (backstageStoryCommonController.f5082e.m5716b()) {
            ((FbTextView) backstageStoryCommonController.f5082e.m5715a()).setText("");
        }
    }

    public final void mo176b() {
        this.f4824a.m4701c();
        this.f4825b.removeView(this.f4826c);
        ((ImportMedia) this.f4827d.f5097f.f18378C).f4817a = this.f4826c.getText().toString();
        PagerViewController pagerViewController = this.f4827d.f5097f;
        PagerViewController.m18375a(pagerViewController, pagerViewController.f18409y ? pagerViewController.f18391g : Math.max(pagerViewController.f18391g, 0.0f), true);
    }

    public final void mo178d() {
    }

    public final void mo177c() {
        if (this.f4826c == null) {
            this.f4826c = (ToggleableEditText) LayoutInflater.from(this.f4825b.getContext()).inflate(2130903379, this.f4825b, false);
            this.f4826c.m5733a();
            this.f4826c.f5505d = this;
            this.f4825b.addView(this.f4826c);
        } else {
            this.f4826c.setText("");
            this.f4825b.addView(this.f4826c);
        }
        this.f4826c.m5735b();
    }
}
