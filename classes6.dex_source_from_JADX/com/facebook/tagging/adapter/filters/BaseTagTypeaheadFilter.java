package com.facebook.tagging.adapter.filters;

import android.widget.Filter;
import android.widget.Filter.FilterResults;
import com.facebook.tagging.model.TaggingProfile;
import java.util.List;

/* compiled from: dialtone_optin_screen */
public abstract class BaseTagTypeaheadFilter extends Filter {
    public FilterResultsListener f17335a = this;

    /* compiled from: dialtone_optin_screen */
    public interface FilterResultsListener {
        void mo1304a(CharSequence charSequence, List<TaggingProfile> list);
    }

    protected abstract FilterResults performFiltering(CharSequence charSequence);

    protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
        if (filterResults != null && this.f17335a != null) {
            this.f17335a.mo1304a(charSequence, (List) filterResults.values);
        }
    }
}
