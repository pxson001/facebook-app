package com.facebook.orca.contacts.favorites;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.contacts.picker.BaseSearchableContactPickerListAdapter;
import com.facebook.contacts.picker.ContactPickerRow;
import com.facebook.contacts.picker.ContactPickerSearchBarView;
import com.facebook.contacts.picker.ContactPickerViewFilterState;
import com.facebook.contacts.picker.DivebarFaveditSearchBarView;
import com.facebook.contacts.picker.DivebarFaveditSearchBarView.ButtonListener;
import com.facebook.contacts.picker.DivebarSearchableContactPickerView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.orca.common.ui.widgets.FavoritesDragSortListView;
import com.facebook.orca.contacts.favorites.DivebarEditFavoritesFragment.C08761;
import com.google.common.collect.ImmutableList;

/* compiled from: onBackPressed is called before onFragmentCreate */
public class FavoritesEditPickerView extends DivebarSearchableContactPickerView implements FaveditPicker {
    public C08761 f6007i;
    public DivebarFaveditSearchBarView f6008j;

    /* compiled from: onBackPressed is called before onFragmentCreate */
    public class C08941 implements ButtonListener {
        final /* synthetic */ FavoritesEditPickerView f6004a;

        public C08941(FavoritesEditPickerView favoritesEditPickerView) {
            this.f6004a = favoritesEditPickerView;
        }

        public final void m5646a() {
            if (this.f6004a.f6007i != null) {
                this.f6004a.f6007i.m5575a();
            }
        }

        public final void m5647b() {
            if (this.f6004a.f6007i != null) {
                this.f6004a.a();
            }
        }
    }

    /* compiled from: onBackPressed is called before onFragmentCreate */
    public class C08952 implements OnClickListener {
        final /* synthetic */ FavoritesEditPickerView f6005a;

        public C08952(FavoritesEditPickerView favoritesEditPickerView) {
            this.f6005a = favoritesEditPickerView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1855715138);
            if (this.f6005a.f6007i != null) {
                this.f6005a.f6007i.m5575a();
            }
            Logger.a(2, EntryType.UI_INPUT_END, 898741888, a);
        }
    }

    /* compiled from: onBackPressed is called before onFragmentCreate */
    public class C08963 implements OnClickListener {
        final /* synthetic */ FavoritesEditPickerView f6006a;

        public C08963(FavoritesEditPickerView favoritesEditPickerView) {
            this.f6006a = favoritesEditPickerView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 528563812);
            if (this.f6006a.f6007i != null) {
                this.f6006a.f6007i.m5576b();
            }
            Logger.a(2, EntryType.UI_INPUT_END, 1523823972, a);
        }
    }

    public FavoritesEditPickerView(Context context, BaseSearchableContactPickerListAdapter baseSearchableContactPickerListAdapter) {
        super(context, baseSearchableContactPickerListAdapter, 2130905673);
        this.f6008j = (DivebarFaveditSearchBarView) this.a;
        this.f6008j.a = new C08941(this);
        getView(2131564805).setOnClickListener(new C08952(this));
        getView(2131564804).setOnClickListener(new C08963(this));
    }

    protected final void m5648a(ContactPickerViewFilterState contactPickerViewFilterState) {
        super.a(contactPickerViewFilterState);
        if (contactPickerViewFilterState == ContactPickerViewFilterState.NONE || contactPickerViewFilterState == ContactPickerViewFilterState.UNFILTERED) {
            this.f6008j.g();
        } else {
            this.f6008j.h();
        }
    }

    protected ContactPickerSearchBarView getSearchBar() {
        return this.f6008j;
    }

    public void setOnButtonClickedListener(C08761 c08761) {
        this.f6007i = c08761;
    }

    public final void mo219a(ImmutableList<ContactPickerRow> immutableList) {
        super.a(immutableList);
    }

    public View getThisView() {
        return this;
    }

    public FavoritesDragSortListView getDraggableList() {
        return (FavoritesDragSortListView) this.g.a;
    }
}
