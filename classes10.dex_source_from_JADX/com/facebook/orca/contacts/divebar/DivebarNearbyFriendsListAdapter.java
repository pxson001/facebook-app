package com.facebook.orca.contacts.divebar;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.contacts.picker.BaseContactPickerListAdapter;
import com.facebook.contacts.picker.ContactPickerRow;
import com.facebook.contacts.picker.ContactPickerUserRow;
import com.facebook.messaging.contacts.picker.ContactPickerListItem;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;

/* compiled from: onStart */
public class DivebarNearbyFriendsListAdapter extends BaseContactPickerListAdapter {
    private final Context f5860a;
    private ImmutableList<ContactPickerRow> f5861b = RegularImmutableList.a;

    public /* synthetic */ Object getItem(int i) {
        return m5532a(i);
    }

    public DivebarNearbyFriendsListAdapter(Context context) {
        this.f5860a = context;
    }

    public final void m5533a(ImmutableList<ContactPickerRow> immutableList) {
        this.f5861b = immutableList;
        AdapterDetour.a(this, -525421603);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        view = (ContactPickerListItem) view;
        if (view == null) {
            view = new ContactPickerListItem(this.f5860a);
        }
        view.setContactRow(m5532a(i));
        return view;
    }

    public int getCount() {
        return this.f5861b.size();
    }

    private ContactPickerUserRow m5532a(int i) {
        return (ContactPickerUserRow) this.f5861b.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }
}
