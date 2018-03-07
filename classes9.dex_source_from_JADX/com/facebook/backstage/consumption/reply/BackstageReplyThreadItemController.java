package com.facebook.backstage.consumption.reply;

import android.content.Context;
import com.facebook.backstage.data.BackstageProfile.Reply;
import com.facebook.backstage.ui.BackstageRichVideoView;
import com.facebook.backstage.ui.LazyView;
import com.facebook.common.locale.Locales;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.resources.ui.FbTextView;

/* compiled from: ride_request */
public class BackstageReplyThreadItemController {
    public final Context f4865a;
    public final FbDraweeControllerBuilder f4866b;
    public final LazyView<GenericDraweeView> f4867c;
    public final LazyView<BackstageRichVideoView> f4868d;
    public final LazyView<FbTextView> f4869e;
    public final GenericDraweeView f4870f;
    public final FbTextView f4871g;
    public final RoundingParams f4872h = RoundingParams.e();
    public final Locales f4873i;
    public Reply f4874j;

    public BackstageReplyThreadItemController(Context context, Locales locales, FbDraweeControllerBuilder fbDraweeControllerBuilder, LazyView<GenericDraweeView> lazyView, LazyView<BackstageRichVideoView> lazyView2, LazyView<FbTextView> lazyView3, GenericDraweeView genericDraweeView, FbTextView fbTextView) {
        this.f4865a = context;
        this.f4866b = fbDraweeControllerBuilder;
        this.f4867c = lazyView;
        this.f4868d = lazyView2;
        this.f4869e = lazyView3;
        this.f4870f = genericDraweeView;
        this.f4871g = fbTextView;
        this.f4873i = locales;
    }
}
