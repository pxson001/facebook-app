package com.facebook.stickers.ui;

import android.content.Context;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.inject.FbInjector;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomLinearLayout;
import javax.inject.Inject;

/* compiled from: dset_longitude */
public class StickerTagItemView extends CustomLinearLayout {
    public static final CallerContext f17074b = CallerContext.a(StickerTagItemView.class, "stickers_in_composer");
    @Inject
    public FbDraweeControllerBuilder f17075a;
    public FbTextView f17076c = ((FbTextView) findViewById(2131565170));
    public FbDraweeView f17077d = ((FbDraweeView) findViewById(2131565169));

    public static void m24765a(Object obj, Context context) {
        ((StickerTagItemView) obj).f17075a = FbDraweeControllerBuilder.b(FbInjector.get(context));
    }

    public StickerTagItemView(Context context) {
        super(context);
        Class cls = StickerTagItemView.class;
        m24765a(this, getContext());
        setBackgroundResource(2130842308);
        setGravity(16);
        setContentView(2130905869);
    }
}
