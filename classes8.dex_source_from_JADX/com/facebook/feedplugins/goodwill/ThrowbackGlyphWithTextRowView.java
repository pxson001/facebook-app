package com.facebook.feedplugins.goodwill;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import com.facebook.fbui.widget.layout.SegmentedLinearLayout;
import com.facebook.fbui.widget.text.GlyphWithTextView;

/* compiled from: goodwill_dailydialogue_lightweight_header_tapped */
public class ThrowbackGlyphWithTextRowView extends SegmentedLinearLayout {
    public GlyphWithTextView[] f12425a = new GlyphWithTextView[2];

    public ThrowbackGlyphWithTextRowView(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(2130907411, this);
        setOrientation(1);
        setSegmentedDivider(new ColorDrawable(context.getResources().getColor(2131361939)));
        setSegmentedDividerThickness(1);
        setShowSegmentedDividers(1);
        this.f12425a[0] = (GlyphWithTextView) a(2131561834);
        this.f12425a[1] = (GlyphWithTextView) a(2131561833);
    }

    public final void m14333a(int i, CharSequence charSequence, CharSequence charSequence2, int i2, OnClickListener onClickListener) {
        GlyphWithTextView glyphWithTextView = this.f12425a[i];
        glyphWithTextView.setText(charSequence);
        glyphWithTextView.setContentDescription(charSequence2);
        glyphWithTextView.setImageResource(i2);
        glyphWithTextView.setOnClickListener(onClickListener);
        glyphWithTextView.setVisibility(0);
    }

    public void setNumButtons(int i) {
        while (i < 2) {
            this.f12425a[i].setVisibility(8);
            i++;
        }
    }
}
