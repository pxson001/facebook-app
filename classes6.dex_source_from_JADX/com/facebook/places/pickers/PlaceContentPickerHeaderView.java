package com.facebook.places.pickers;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.widget.CustomLinearLayout;

/* compiled from: flight_info */
public class PlaceContentPickerHeaderView extends CustomLinearLayout {
    public ImageView f14801a = ((ImageView) a(2131565960));
    public TextView f14802b = ((TextView) a(2131565961));
    public TextView f14803c = ((TextView) a(2131565962));
    public TextView f14804d = ((TextView) a(2131565963));

    public PlaceContentPickerHeaderView(Context context) {
        super(context);
        setContentView(2130906244);
        setOrientation(1);
    }

    public void setImage(int i) {
        this.f14801a.setImageResource(i);
    }

    public void setTitle(int i) {
        this.f14802b.setText(i);
    }

    public void setSubTitle(int i) {
        this.f14803c.setText(i);
    }

    public void setSectionTitle(int i) {
        this.f14804d.setText(i);
    }
}
