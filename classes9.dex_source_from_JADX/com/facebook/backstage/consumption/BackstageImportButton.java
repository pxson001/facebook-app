package com.facebook.backstage.consumption;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.facebook.fbui.glyph.GlyphView;

/* compiled from: scaleUpIfNeeded */
public class BackstageImportButton extends FrameLayout {
    private final GlyphView f4511a;
    private final TextView f4512b;

    public BackstageImportButton(Context context) {
        this(context, null);
    }

    public BackstageImportButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BackstageImportButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        View.inflate(context, 2130904848, this);
        this.f4511a = (GlyphView) findViewById(2131563066);
        this.f4511a.setGlyphColor(context.getResources().getColor(2131361859));
        this.f4512b = (TextView) findViewById(2131563067);
    }

    public void setBadgeCount(int i) {
        if (i == 0) {
            this.f4512b.setVisibility(8);
            return;
        }
        this.f4512b.setVisibility(0);
        this.f4512b.setText(getContext().getString(2131239899, new Object[]{Integer.valueOf(i)}));
    }
}
