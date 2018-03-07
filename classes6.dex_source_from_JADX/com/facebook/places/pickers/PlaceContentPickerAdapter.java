package com.facebook.places.pickers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.widget.listview.FbBaseAdapter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;

/* compiled from: flight_infos */
public class PlaceContentPickerAdapter<T> extends FbBaseAdapter {
    public ImmutableList<PlaceContentPickerRow<T>> f14797a = RegularImmutableList.a;

    public /* synthetic */ Object getItem(int i) {
        return m22451a(i);
    }

    public int getCount() {
        return this.f14797a.size();
    }

    private PlaceContentPickerRow<T> m22451a(int i) {
        return (PlaceContentPickerRow) this.f14797a.get(i);
    }

    public long getItemId(int i) {
        return m22451a(i).f14812b;
    }

    public boolean hasStableIds() {
        return true;
    }

    public final View m22452a(int i, ViewGroup viewGroup) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(2130906245, null);
    }

    public final void m22453a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        ContentView contentView = (ContentView) view;
        PlaceContentPickerRow placeContentPickerRow = (PlaceContentPickerRow) obj;
        contentView.setTitleText(placeContentPickerRow.f14813c);
        contentView.setTitleTextAppearance(placeContentPickerRow.f14815e);
        contentView.setSubtitleText((CharSequence) placeContentPickerRow.f14814d.orNull());
        ((ImageView) view.findViewById(2131565964)).setImageResource(placeContentPickerRow.f14816f);
        contentView.setShowThumbnail(placeContentPickerRow.f14816f != 0);
        contentView.setMinimumHeight((contentView.getPaddingTop() + contentView.f.getLayoutParams().height) + contentView.getPaddingBottom());
    }
}
