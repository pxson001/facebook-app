package com.facebook.feedplugins.graphqlstory.stickers.ui;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.util.AttributeSet;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.BaseControllerListener;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.widget.CustomLinearLayout;
import javax.annotation.Nullable;

/* compiled from: ScaleAspectFit */
public class StickerPostView extends CustomLinearLayout {
    private static final CallerContext f23377a = CallerContext.a(StickerPostView.class);
    private final FbDraweeView f23378b;

    /* compiled from: ScaleAspectFit */
    class C20211 extends BaseControllerListener {
        final /* synthetic */ StickerPostView f23376a;

        C20211(StickerPostView stickerPostView) {
            this.f23376a = stickerPostView;
        }

        public final void m25702a(String str, @Nullable Object obj, @Nullable Animatable animatable) {
            if (animatable != null) {
                animatable.start();
            }
        }
    }

    public StickerPostView(Context context) {
        this(context, null, 2130904332);
    }

    private StickerPostView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        setContentView(i);
        this.f23378b = (FbDraweeView) a(2131561981);
        setGravity(17);
    }

    public final void m25703a(Uri uri, FbDraweeControllerBuilder fbDraweeControllerBuilder) {
        if (uri != null) {
            this.f23378b.setController(((FbDraweeControllerBuilder) ((FbDraweeControllerBuilder) fbDraweeControllerBuilder.a(f23377a).b(this.f23378b.getController())).b(uri).a(new C20211(this))).s());
        }
    }
}
