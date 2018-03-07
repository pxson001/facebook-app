package com.facebook.contacts.picker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;

/* compiled from: post_insights_dialog_open */
public class DivebarSearchBarView extends ContactPickerSearchBarView {
    private ViewGroup f6457a;

    public DivebarSearchBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected final void mo259b() {
        setContentView(2130905686);
        this.f6457a = (ViewGroup) a(2131564836);
    }

    public final void mo260a(OnClickListener onClickListener) {
        if (this.f6457a.getChildCount() <= 0) {
            Drawable drawable;
            int i = -2;
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(2130772759, typedValue, true)) {
                i = (int) typedValue.getDimension(getResources().getDisplayMetrics());
            }
            this.f6457a.removeAllViews();
            View imageButton = new ImageButton(getContext());
            imageButton.setLayoutParams(new LayoutParams(i, i));
            Resources resources = getResources();
            if (VERSION.SDK_INT >= 21) {
                drawable = resources.getDrawable(2130841988, null);
            } else {
                drawable = resources.getDrawable(2130841988);
            }
            imageButton.setImageDrawable(drawable);
            imageButton.setBackgroundDrawable(null);
            this.f6457a.addView(imageButton);
            this.f6457a.setVisibility(0);
            imageButton.setOnClickListener(onClickListener);
        }
    }
}
