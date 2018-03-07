package com.facebook.contacts.picker;

import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.Filterable;
import com.facebook.widget.filter.CustomFilter;
import com.facebook.widget.filter.CustomFilterable;

/* compiled from: preview_url */
public abstract class BaseSearchableContactPickerListAdapter extends BaseContactPickerListAdapter implements Filterable, ContactPickerListFilterReceiver, CustomFilterable {

    /* compiled from: preview_url */
    class C06471 extends Filter {
        final /* synthetic */ BaseSearchableContactPickerListAdapter f6293a;

        C06471(BaseSearchableContactPickerListAdapter baseSearchableContactPickerListAdapter) {
            this.f6293a = baseSearchableContactPickerListAdapter;
        }

        protected FilterResults performFiltering(CharSequence charSequence) {
            throw new UnsupportedOperationException();
        }

        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
        }
    }

    public abstract ContactPickerListFilter m6711d();

    public abstract void m6712e();

    public /* synthetic */ CustomFilter m6710a() {
        return m6711d();
    }

    public Filter getFilter() {
        return new C06471(this);
    }
}
