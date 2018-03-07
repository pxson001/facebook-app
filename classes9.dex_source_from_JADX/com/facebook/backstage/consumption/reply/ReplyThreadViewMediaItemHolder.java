package com.facebook.backstage.consumption.reply;

import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import com.facebook.backstage.ui.LazyView;
import com.facebook.backstage.ui.LazyView.OnInflateRunner;
import com.facebook.common.locale.Locales;
import com.facebook.drawee.drawable.AutoRotateDrawable;
import com.facebook.drawee.drawable.ScalingUtils.ScaleType;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.inject.Assisted;
import com.facebook.resources.ui.FbTextView;
import javax.inject.Inject;

/* compiled from: reverse_geocode_data */
public class ReplyThreadViewMediaItemHolder extends ReplyThreadViewBaseItemHolder {
    public final BackstageReplyThreadItemController f4973l;

    /* compiled from: reverse_geocode_data */
    class C05241 implements OnInflateRunner<GenericDraweeView> {
        final /* synthetic */ ReplyThreadViewMediaItemHolder f4972a;

        C05241(ReplyThreadViewMediaItemHolder replyThreadViewMediaItemHolder) {
            this.f4972a = replyThreadViewMediaItemHolder;
        }

        public final void mo137a(View view) {
            GenericDraweeView genericDraweeView = (GenericDraweeView) view;
            BackstageReplyThreadItemController backstageReplyThreadItemController = this.f4972a.f4973l;
            AutoRotateDrawable autoRotateDrawable = new AutoRotateDrawable(backstageReplyThreadItemController.f4865a.getResources().getDrawable(2130844043), 1000);
            GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder = new GenericDraweeHierarchyBuilder(backstageReplyThreadItemController.f4865a.getResources());
            genericDraweeHierarchyBuilder.f = autoRotateDrawable;
            genericDraweeView.setHierarchy(genericDraweeHierarchyBuilder.e(ScaleType.c).u());
        }
    }

    @Inject
    public ReplyThreadViewMediaItemHolder(@Assisted FrameLayout frameLayout, @Assisted Context context, Locales locales, FbDraweeControllerBuilder fbDraweeControllerBuilder) {
        super(frameLayout);
        this.f4973l = new BackstageReplyThreadItemController(context, locales, fbDraweeControllerBuilder, new LazyView((ViewStub) frameLayout.findViewById(2131559859), new C05241(this)), new LazyView((ViewStub) frameLayout.findViewById(2131559880)), new LazyView((ViewStub) frameLayout.findViewById(2131559881)), (GenericDraweeView) frameLayout.findViewById(2131559888), (FbTextView) frameLayout.findViewById(2131559889));
    }
}
