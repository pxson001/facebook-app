package com.facebook.groups.widget.preferenceview;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.widget.ImageView;
import com.facebook.widget.CustomFrameLayout;
import com.facebook.widget.text.BetterTextView;
import javax.annotation.Nullable;

/* compiled from: price_range */
public class CheckablePreferenceView extends CustomFrameLayout {
    public BetterTextView f6056a = ((BetterTextView) c(2131560307));
    public BetterTextView f6057b = ((BetterTextView) c(2131560308));
    public ImageView f6058c = ((ImageView) c(2131560309));
    public String f6059d;

    public CheckablePreferenceView(Context context) {
        super(context);
        setContentView(2130903561);
        this.f6058c.setColorFilter(new PorterDuffColorFilter(getResources().getColor(2131363508), Mode.SRC_ATOP));
    }

    public final void m7848a(String str, @Nullable String str2, boolean z, String str3) {
        int i = 0;
        this.f6056a.setText(str);
        if (str2 != null) {
            this.f6057b.setText(str2);
            this.f6057b.setVisibility(0);
        } else {
            this.f6057b.setVisibility(8);
        }
        ImageView imageView = this.f6058c;
        if (!z) {
            i = 8;
        }
        imageView.setVisibility(i);
        this.f6059d = str3;
    }

    public String getTitleText() {
        return (this.f6056a == null || this.f6056a.getText() == null) ? null : this.f6056a.getText().toString();
    }
}
