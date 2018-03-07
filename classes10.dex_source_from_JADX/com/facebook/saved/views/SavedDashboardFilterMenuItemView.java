package com.facebook.saved.views;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.Checkable;
import android.widget.ImageView;
import com.facebook.fbui.widget.layout.ImageBlockLayout;
import com.facebook.fbui.widget.text.BadgeTextView;

/* compiled from: instant_shopping_graphql_first_fetch */
public class SavedDashboardFilterMenuItemView extends ImageBlockLayout implements Checkable {
    private static final int[] f9339h = new int[]{16842911, 16842912};
    private static final int[] f9340i = new int[]{16842911};
    public ImageView f9341j;
    public BadgeTextView f9342k;
    public boolean f9343l = false;
    private boolean f9344m = false;

    public SavedDashboardFilterMenuItemView(Context context) {
        super(context);
        Resources resources = getResources();
        setMinimumHeight(resources.getDimensionPixelSize(2131432265));
        int dimensionPixelSize = resources.getDimensionPixelSize(2131428376);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(2131428377);
        setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2);
        setGravity(16);
        setContentView(2130904269);
        this.f9342k = (BadgeTextView) getView(2131561849);
        this.f9341j = (ImageView) getView(2131561848);
        getView(2131561850).setVisibility(8);
    }

    protected int[] onCreateDrawableState(int i) {
        if (!this.f9343l) {
            return super.onCreateDrawableState(i);
        }
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 2);
        View.mergeDrawableStates(onCreateDrawableState, this.f9344m ? f9339h : f9340i);
        return onCreateDrawableState;
    }

    public void setChecked(boolean z) {
        this.f9344m = z;
        refreshDrawableState();
    }

    public boolean isChecked() {
        return this.f9344m;
    }

    public void toggle() {
        this.f9344m = !this.f9344m;
        refreshDrawableState();
    }
}
