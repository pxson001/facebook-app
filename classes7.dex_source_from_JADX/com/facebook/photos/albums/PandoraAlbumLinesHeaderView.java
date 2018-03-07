package com.facebook.photos.albums;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.facebook.widget.CustomLinearLayout;

/* compiled from: mall_visits_count/ */
public class PandoraAlbumLinesHeaderView extends CustomLinearLayout {
    public PandoraAlbumLinesHeaderView(Context context) {
        super(context);
        m11351a();
    }

    public PandoraAlbumLinesHeaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m11351a();
    }

    public PandoraAlbumLinesHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m11351a();
    }

    private void m11351a() {
        setContentView(2130903231);
        View findViewById = findViewById(2131559546);
        int dimensionPixelSize = ((getResources().getDisplayMetrics().widthPixels - (getResources().getDimensionPixelSize(2131429451) * 3)) - (getResources().getDimensionPixelSize(2131429450) * 4)) / 2;
        LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize - (getResources().getDimensionPixelSize(2131429450) * 2), 1);
        layoutParams.leftMargin = getResources().getDimensionPixelSize(2131429450) * 2;
        layoutParams.topMargin = getResources().getDimensionPixelSize(2131429448);
        findViewById.setLayoutParams(layoutParams);
        findViewById = findViewById(2131559547);
        LayoutParams layoutParams2 = new LinearLayout.LayoutParams(dimensionPixelSize, 1);
        layoutParams2.topMargin = getResources().getDimensionPixelSize(2131429447);
        layoutParams2.leftMargin = getResources().getDimensionPixelSize(2131429450);
        layoutParams2.bottomMargin = getResources().getDimensionPixelSize(2131429447);
        findViewById.setLayoutParams(layoutParams2);
    }

    public void setUploadButtonLines(boolean z) {
        View findViewById = findViewById(2131559546);
        if (z) {
            findViewById.setBackgroundColor(getResources().getColor(2131362900));
        } else {
            findViewById.setBackgroundColor(getResources().getColor(2131362901));
        }
        findViewById = findViewById(2131559547);
        if (z) {
            findViewById.setBackgroundColor(getResources().getColor(2131362900));
        } else {
            findViewById.setBackgroundColor(getResources().getColor(2131362901));
        }
    }
}
