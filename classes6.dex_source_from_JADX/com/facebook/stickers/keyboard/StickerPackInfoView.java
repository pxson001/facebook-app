package com.facebook.stickers.keyboard;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.resources.ui.FbTextView;
import com.facebook.stickers.model.StickerPack;
import com.facebook.widget.CustomFrameLayout;

/* compiled from: edit_story_privacy_fragment_no_selectable_privacy */
public class StickerPackInfoView extends CustomFrameLayout {
    private static final CallerContext f16706a = CallerContext.a(StickerKeyboardTabView.class, "sticker_keyboard");
    private FbDraweeView f16707b;
    private FbTextView f16708c;
    private FbTextView f16709d;
    private FbTextView f16710e;

    public StickerPackInfoView(Context context) {
        super(context);
        m24512a();
    }

    public StickerPackInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24512a();
    }

    public StickerPackInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m24512a();
    }

    private void m24512a() {
        setContentView(2130905857);
        this.f16707b = (FbDraweeView) c(2131562910);
        this.f16708c = (FbTextView) c(2131560124);
        this.f16709d = (FbTextView) c(2131565135);
        this.f16710e = (FbTextView) c(2131559627);
    }

    public final void m24513a(StickerPack stickerPack) {
        this.f16707b.a(stickerPack.f4959e, f16706a);
        this.f16708c.setText(stickerPack.f4956b);
        this.f16709d.setText(stickerPack.f4957c);
        this.f16710e.setText(stickerPack.f4958d);
    }
}
