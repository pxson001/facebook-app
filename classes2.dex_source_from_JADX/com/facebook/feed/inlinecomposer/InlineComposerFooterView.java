package com.facebook.feed.inlinecomposer;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import com.facebook.fbui.widget.layout.SegmentedLinearLayout;
import com.facebook.fbui.widget.text.GlyphWithTextView;
import com.facebook.fbui.widget.text.ImageWithTextView;

/* compiled from: media_get_fbid */
public class InlineComposerFooterView extends SegmentedLinearLayout {
    private ImageWithTextView f14542a;
    private GlyphWithTextView f14543b;
    private ImageWithTextView f14544c;
    private ImageWithTextView[] f14545d;

    public InlineComposerFooterView(Context context) {
        super(context, null);
        m20977a();
    }

    public InlineComposerFooterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m20977a();
    }

    private void m20977a() {
        setContentView(2130904310);
        setOrientation(1);
        this.f14542a = (ImageWithTextView) m8506a(2131561933);
        this.f14543b = (GlyphWithTextView) m8506a(2131561934);
        this.f14544c = (ImageWithTextView) m8506a(2131561935);
        this.f14545d = new ImageWithTextView[]{this.f14542a, this.f14543b, this.f14544c};
        m20978b();
    }

    public void setCheckinButtonVisibility(int i) {
        this.f14544c.setVisibility(i);
    }

    public void setCheckinButtonDrawable(Drawable drawable) {
        this.f14544c.setImageDrawable(drawable);
    }

    public final void m20979a(String str, String str2, String str3) {
        this.f14542a.setText(str);
        this.f14543b.setText(str2);
        this.f14544c.setText(str3);
    }

    public void setStatusButtonOnClickListener(OnClickListener onClickListener) {
        this.f14542a.setOnClickListener(onClickListener);
    }

    public void setPhotoButtonOnClickListener(OnClickListener onClickListener) {
        this.f14543b.setOnClickListener(onClickListener);
    }

    public void setCheckinButtonOnClickListener(OnClickListener onClickListener) {
        this.f14544c.setOnClickListener(onClickListener);
    }

    private void m20978b() {
        for (ImageWithTextView imageScale : this.f14545d) {
            imageScale.setImageScale(0.8f);
        }
    }
}
