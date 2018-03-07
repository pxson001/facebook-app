package com.facebook.messaging.payment.pin;

import android.content.res.Resources;
import android.graphics.drawable.LayerDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;
import com.facebook.inject.Assisted;
import javax.inject.Inject;

/* compiled from: has_seen_today_nux_animation */
public class DrawPinDotsTextWatcher implements TextWatcher {
    public final Resources f13489a;
    public final ImageView f13490b;

    @Inject
    public DrawPinDotsTextWatcher(@Assisted ImageView imageView, Resources resources) {
        this.f13490b = imageView;
        this.f13489a = resources;
    }

    public void afterTextChanged(Editable editable) {
        int length = editable.length();
        LayerDrawable layerDrawable = (LayerDrawable) this.f13489a.getDrawable(2130842547);
        layerDrawable.mutate();
        for (int i = 0; i < length; i++) {
            layerDrawable.setDrawableByLayerId(layerDrawable.getId(i), this.f13489a.getDrawable(2130842658));
        }
        this.f13490b.setImageDrawable(layerDrawable);
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
