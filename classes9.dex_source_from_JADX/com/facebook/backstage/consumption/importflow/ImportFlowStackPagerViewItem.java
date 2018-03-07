package com.facebook.backstage.consumption.importflow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.facebook.backstage.consumption.importflow.ImportFlowStackViewController.C04941;
import com.facebook.backstage.consumption.swipe.BackstageStoryCommonController;
import com.facebook.backstage.ui.LazyView;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.pager.renderers.standard.PagerViewItem;

/* compiled from: risk_failure_fragment_tag */
public class ImportFlowStackPagerViewItem extends PagerViewItem<ImportMedia> {
    public BackstageStoryCommonController f4780a;
    public C04941 f4781b;

    public ImportFlowStackPagerViewItem(Context context, FbDraweeControllerBuilder fbDraweeControllerBuilder) {
        super(context);
        View inflate = LayoutInflater.from(getContext()).inflate(2130903374, this);
        this.f4780a = new BackstageStoryCommonController(getContext(), fbDraweeControllerBuilder, new LazyView((ViewStub) inflate.findViewById(2131559859)), new LazyView((ViewStub) inflate.findViewById(2131559880)), new LazyView((ViewStub) inflate.findViewById(2131559881)));
    }

    public final void mo163a() {
        this.f4780a.m4875a();
    }

    private void m4655a(ViewGroup viewGroup, ImportMedia importMedia, int i, float f, float f2, float f3, boolean z) {
        this.f4780a.m4876a(this, viewGroup, importMedia, f, f2, f3, z);
        if (z && f == 0.0f && this.f4781b != null) {
            this.f4781b.m4678a();
        }
    }

    public final void mo165a(boolean z) {
        if (z && this.f4781b != null) {
            this.f4781b.m4678a();
        }
    }

    public final void mo166b() {
    }

    public final void mo167e() {
    }
}
