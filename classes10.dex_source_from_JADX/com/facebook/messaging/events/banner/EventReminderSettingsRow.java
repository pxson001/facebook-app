package com.facebook.messaging.events.banner;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterTextView;
import javax.annotation.Nullable;

/* compiled from: snapshot_compress_quality */
public class EventReminderSettingsRow extends CustomLinearLayout {
    private GlyphView f2371a;
    private BetterTextView f2372b;

    public EventReminderSettingsRow(Context context) {
        super(context);
        m2206a();
    }

    public EventReminderSettingsRow(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m2206a();
    }

    public EventReminderSettingsRow(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2206a();
    }

    private void m2206a() {
        setContentView(2130904095);
        this.f2371a = (GlyphView) a(2131561390);
        this.f2372b = (BetterTextView) a(2131561391);
    }

    public void setGlyphImageResId(int i) {
        this.f2371a.setImageResource(i);
    }

    public void setText(CharSequence charSequence) {
        this.f2372b.setText(charSequence);
        this.f2372b.setTextColor(ContextCompat.b(getContext(), 2131361972));
    }

    public void setPlaceholderText(String str) {
        this.f2372b.setText(str);
        this.f2372b.setTextColor(ContextCompat.b(getContext(), 2131361974));
    }
}
