package com.facebook.backstage.consumption.swipe;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.backstage.consumption.BackstageFragment;
import com.facebook.backstage.consumption.swipe.BaseBackstageStoryPagerViewItem.CenterStateListener;
import com.facebook.backstage.data.MediaItem;
import com.facebook.backstage.ui.BackstageRichVideoView;
import com.facebook.backstage.ui.LazyView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.drawable.AutoRotateDrawable;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.imagepipeline.request.ImageRequest.ImageType;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.resources.ui.FbTextView;
import com.google.common.base.Strings;

/* compiled from: results_discarded */
public class BackstageStoryCommonController<Item extends MediaItem> {
    public final FbDraweeControllerBuilder f5078a;
    public final Context f5079b;
    public final LazyView<GenericDraweeView> f5080c;
    private final LazyView<BackstageRichVideoView> f5081d;
    public final LazyView<FbTextView> f5082e;
    public Item f5083f;
    public CenterStateListener<Item> f5084g;

    public BackstageStoryCommonController(Context context, FbDraweeControllerBuilder fbDraweeControllerBuilder, LazyView<GenericDraweeView> lazyView, LazyView<BackstageRichVideoView> lazyView2, LazyView<FbTextView> lazyView3) {
        this.f5079b = context;
        this.f5078a = fbDraweeControllerBuilder;
        this.f5080c = lazyView;
        this.f5081d = lazyView2;
        this.f5082e = lazyView3;
    }

    public final void m4875a() {
        if (this.f5080c.m5716b()) {
            ((GenericDraweeView) this.f5080c.m5715a()).setController(null);
            ((GenericDraweeView) this.f5080c.m5715a()).setVisibility(8);
        }
        if (this.f5082e.m5716b()) {
            ((FbTextView) this.f5082e.m5715a()).setText("");
            ((FbTextView) this.f5082e.m5715a()).setVisibility(8);
        }
        if (this.f5081d.m5716b()) {
            ((BackstageRichVideoView) this.f5081d.m5715a()).m5709a();
            ((BackstageRichVideoView) this.f5081d.m5715a()).setVisibility(8);
        }
        this.f5083f = null;
    }

    public final void m4876a(View view, ViewGroup viewGroup, Item item, float f, float f2, float f3, boolean z) {
        Item item2 = this.f5083f;
        this.f5083f = item;
        if (view.getParent() != viewGroup) {
            if (!item.mo172g()) {
                AutoRotateDrawable autoRotateDrawable = new AutoRotateDrawable(this.f5079b.getResources().getDrawable(2130844043), 1000);
                GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(this.f5079b.getResources());
                genericDraweeHierarchyBuilder.f = autoRotateDrawable;
                ((GenericDraweeView) this.f5080c.m5715a()).setHierarchy(genericDraweeHierarchyBuilder.e(ScaleType.c).u());
            }
            view.getLayoutParams().width = (int) f2;
            view.getLayoutParams().height = (int) f3;
            viewGroup.addView(view);
        }
        if (item.mo172g()) {
            m4874a(item, f, z);
        } else {
            if (z) {
                ((GenericDraweeView) this.f5080c.m5715a()).setVisibility(0);
            }
            if (item2 != item) {
                ImageRequestBuilder a = ImageRequestBuilder.a(Uri.parse(item.mo171f()));
                a.f = ImageType.DEFAULT;
                ((GenericDraweeView) this.f5080c.m5715a()).setController(((FbDraweeControllerBuilder) this.f5078a.c(a.m())).a(CallerContext.a(BackstageFragment.class)).s());
            }
        }
        if (z && !Strings.isNullOrEmpty(item.mo173h())) {
            ((FbTextView) this.f5082e.m5715a()).setVisibility(0);
            ((FbTextView) this.f5082e.m5715a()).setText(item.mo173h());
        }
        view.setTranslationX(f);
    }

    private void m4874a(Item item, float f, boolean z) {
        Object obj;
        if (z) {
            ((BackstageRichVideoView) this.f5081d.m5715a()).setVisibility(0);
        }
        ((BackstageRichVideoView) this.f5081d.m5715a()).m5711b(item.mo174i(), item.mo171f());
        if (!z || Math.abs(f) > 10.0f) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            m4878b(z);
        } else {
            m4877b();
        }
    }

    public final void m4878b(boolean z) {
        if (!this.f5081d.m5716b()) {
            return;
        }
        if (!z) {
            ((BackstageRichVideoView) this.f5081d.m5715a()).m5709a();
        } else if (((BackstageRichVideoView) this.f5081d.m5715a()).f5480j && !((BackstageRichVideoView) this.f5081d.m5715a()).f5479i) {
            ((BackstageRichVideoView) this.f5081d.m5715a()).m5710b();
        }
    }

    public final void m4877b() {
        if (this.f5081d.m5716b() && ((BackstageRichVideoView) this.f5081d.m5715a()).f5480j && ((BackstageRichVideoView) this.f5081d.m5715a()).f5479i) {
            ((BackstageRichVideoView) this.f5081d.m5715a()).m5712t();
        }
    }
}
