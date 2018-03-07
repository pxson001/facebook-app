package com.facebook.saved.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.fbui.menu.PopoverMenu;

/* compiled from: instant_shopping_num_blocks_fetched */
public class SavedDashboardFilterMenu extends PopoverMenu {
    public SavedDashboardFilterMenu(Context context) {
        super(context);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = new SavedDashboardFilterMenuItemView(viewGroup.getContext());
        } else {
            SavedDashboardFilterMenuItemView savedDashboardFilterMenuItemView = (SavedDashboardFilterMenuItemView) view;
        }
        MenuItem item = getItem(i);
        if (item != null) {
            if (TextUtils.isEmpty(item.getTitle())) {
                view.f9342k.setVisibility(8);
            } else {
                view.f9342k.setVisibility(0);
                view.f9342k.setText(item.getTitle());
            }
            Drawable icon = item.getIcon();
            if (icon == null) {
                view.f9341j.setVisibility(8);
            } else {
                view.f9341j.setVisibility(0);
                view.f9341j.setImageDrawable(icon);
            }
            view.f9343l = item.isCheckable();
            view.setChecked(item.isChecked());
            view.setEnabled(item.isEnabled());
        }
        return view;
    }
}
