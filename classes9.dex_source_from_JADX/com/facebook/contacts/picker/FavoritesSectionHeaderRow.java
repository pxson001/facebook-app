package com.facebook.contacts.picker;

import android.view.View.OnClickListener;

/* compiled from: post_fbid */
public class FavoritesSectionHeaderRow implements ContactIndexablePickerRow {
    public final String f6475a;
    public final String f6476b;
    public final OnClickListener f6477c;
    private final String f6478d;

    public FavoritesSectionHeaderRow(String str, String str2, OnClickListener onClickListener, String str3) {
        this.f6475a = str;
        this.f6476b = str2;
        this.f6477c = onClickListener;
        this.f6478d = str3;
    }

    public final String mo258a() {
        return this.f6478d;
    }
}
