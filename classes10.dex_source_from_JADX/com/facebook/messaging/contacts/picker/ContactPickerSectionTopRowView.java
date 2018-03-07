package com.facebook.messaging.contacts.picker;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.widget.CustomRelativeLayout;

/* compiled from: tap_montage_composer */
public class ContactPickerSectionTopRowView extends CustomRelativeLayout {
    private final TextView f1989a;
    private final ImageView f1990b;

    public ContactPickerSectionTopRowView(Context context) {
        this(context, null, 2130772985);
    }

    public ContactPickerSectionTopRowView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 2130772985);
    }

    public ContactPickerSectionTopRowView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setContentView(2130905669);
        this.f1989a = (TextView) findViewById(2131564791);
        this.f1990b = (ImageView) findViewById(2131564790);
    }

    public void setTextResource(int i) {
        this.f1989a.setText(getResources().getString(i));
    }

    public void setText(String str) {
        this.f1989a.setText(str);
    }

    public void setIconResource(int i) {
        this.f1990b.setImageResource(i);
    }
}
