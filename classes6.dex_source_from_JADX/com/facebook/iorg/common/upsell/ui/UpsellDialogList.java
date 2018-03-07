package com.facebook.iorg.common.upsell.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.facebook.iorg.common.upsell.model.UpsellListViewModel;

/* compiled from: mAlbumId */
public abstract class UpsellDialogList extends LinearLayout {
    public abstract void mo1070a(UpsellListViewModel upsellListViewModel);

    public UpsellDialogList(Context context) {
        super(context);
        setLayoutParams(new LayoutParams(-1, -2));
        setOrientation(1);
        setVisibility(8);
    }

    protected final View m18148a() {
        View view = new View(getContext());
        Resources resources = getResources();
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, resources.getDimensionPixelSize(2131427380));
        layoutParams.setMargins(resources.getDimensionPixelSize(2131428350), 0, resources.getDimensionPixelSize(2131428350), 0);
        view.setLayoutParams(layoutParams);
        view.setBackgroundDrawable(new ColorDrawable(resources.getColor(2131362661)));
        return view;
    }
}
