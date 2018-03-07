package com.facebook.messaging.searchnullstate;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ultralight.Inject;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

/* compiled from: referrer_uri */
public class ContactPickerHScrollViewAdapter extends Adapter<ContactPickerHScrollViewHolder> {
    private final OnClickListener f3829a = new C05891(this);
    private final LayoutInflater f3830b;
    public boolean f3831c = true;
    public ContactPickerHScrollViewListener f3832d;
    @Nullable
    public ImmutableList<ContactPickerHScrollItemData> f3833e;

    /* compiled from: referrer_uri */
    class C05891 implements OnClickListener {
        final /* synthetic */ ContactPickerHScrollViewAdapter f3828a;

        C05891(ContactPickerHScrollViewAdapter contactPickerHScrollViewAdapter) {
            this.f3828a = contactPickerHScrollViewAdapter;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1784684853);
            ContactPickerHScrollViewAdapter.m3607a(this.f3828a, view);
            Logger.a(2, EntryType.UI_INPUT_END, 1301572473, a);
        }
    }

    /* compiled from: referrer_uri */
    public class ContactPickerHScrollViewHolder extends ViewHolder {
        public ContactPickerHScrollViewHolder(View view) {
            super(view);
        }
    }

    public final void m3609a(ViewHolder viewHolder, int i) {
        ContactPickerHScrollItemView contactPickerHScrollItemView = (ContactPickerHScrollItemView) ((ContactPickerHScrollViewHolder) viewHolder).a;
        if (this.f3833e != null) {
            ContactPickerHScrollItemData contactPickerHScrollItemData = (ContactPickerHScrollItemData) this.f3833e.get(i);
            if (contactPickerHScrollItemData.f3816a != null) {
                contactPickerHScrollItemView.setUser(contactPickerHScrollItemData.f3816a);
            } else if (contactPickerHScrollItemData.f3817b != null) {
                contactPickerHScrollItemView.setThreadSummary(contactPickerHScrollItemData.f3817b);
            }
            contactPickerHScrollItemView.setTag(contactPickerHScrollItemData);
            contactPickerHScrollItemView.f3824f = i;
            contactPickerHScrollItemView.setOnClickListener(this.f3829a);
            contactPickerHScrollItemView.setSingleLine(this.f3831c);
        }
    }

    @Inject
    public ContactPickerHScrollViewAdapter(LayoutInflater layoutInflater) {
        this.f3830b = layoutInflater;
    }

    public final ViewHolder m3608a(ViewGroup viewGroup, int i) {
        return new ContactPickerHScrollViewHolder(this.f3830b.inflate(2130905651, viewGroup, false));
    }

    public final int aZ_() {
        return this.f3833e == null ? 0 : this.f3833e.size();
    }

    public static void m3607a(ContactPickerHScrollViewAdapter contactPickerHScrollViewAdapter, View view) {
        if (((ContactPickerHScrollItemData) view.getTag()) != null && contactPickerHScrollViewAdapter.f3832d != null) {
            int i = ((ContactPickerHScrollItemView) view).f3824f;
        }
    }
}
