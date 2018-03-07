package com.facebook.feed.util.composer.sprout;

import android.content.Context;
import android.graphics.ColorFilter;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.fbui.widget.layout.ImageBlockLayout;

/* compiled from: TWO_IMAGE_WIDTH_HEIGHT */
public class InlineComposerForSproutsView extends ImageBlockLayout {
    private TextView f22397h;
    private ImageView f22398i;

    public InlineComposerForSproutsView(Context context) {
        super(context);
        m24976a();
    }

    public InlineComposerForSproutsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m24976a();
    }

    public InlineComposerForSproutsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m24976a();
    }

    private void m24976a() {
        setContentView(2130904901);
        this.f22397h = (TextView) getView(2131563143);
        this.f22398i = (ImageView) getView(2131563144);
    }

    public void setText(CharSequence charSequence) {
        this.f22397h.setText(charSequence);
    }

    public void setAuxImageResource(int i) {
        this.f22398i.setImageResource(i);
    }

    public void setAuxOnClickListener(OnClickListener onClickListener) {
        this.f22398i.setOnClickListener(onClickListener);
    }

    public void setAuxContentDescription(CharSequence charSequence) {
        this.f22398i.setContentDescription(charSequence);
    }

    public void setAuxColorFilter(ColorFilter colorFilter) {
        this.f22398i.setColorFilter(colorFilter);
    }

    public void setAuxAlpha(float f) {
        this.f22398i.setAlpha(f);
    }

    public void setAuxRotation(float f) {
        this.f22398i.setRotation(f);
    }
}
