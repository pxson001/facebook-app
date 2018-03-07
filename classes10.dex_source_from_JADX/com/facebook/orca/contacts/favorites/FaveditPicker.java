package com.facebook.orca.contacts.favorites;

import android.view.View;
import com.facebook.contacts.picker.ContactPickerRow;
import com.facebook.orca.common.ui.widgets.FavoritesDragSortListView;
import com.facebook.orca.contacts.favorites.DivebarEditFavoritesFragment.C08761;
import com.google.common.collect.ImmutableList;

/* compiled from: onEntityUpdate */
public interface FaveditPicker {
    void m5633a();

    void mo219a(ImmutableList<ContactPickerRow> immutableList);

    void m5635a(String str);

    FavoritesDragSortListView getDraggableList();

    View getThisView();

    void setOnButtonClickedListener(C08761 c08761);

    void setSearchHint(String str);
}
