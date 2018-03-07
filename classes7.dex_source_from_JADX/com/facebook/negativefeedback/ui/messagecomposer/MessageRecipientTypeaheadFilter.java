package com.facebook.negativefeedback.ui.messagecomposer;

import android.widget.Filter;
import android.widget.Filter.FilterResults;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.tagging.model.TaggingProfile;
import com.google.common.base.Preconditions;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: no_enter_crop_view */
public class MessageRecipientTypeaheadFilter extends Filter {
    private DefaultAndroidThreadUtil f8119a;
    private ContactsDbMessageRecipientDataSource f8120b;
    public FilterResultsListener f8121c = this;

    /* compiled from: no_enter_crop_view */
    public interface FilterResultsListener {
        void mo448a(List<TaggingProfile> list);
    }

    @Inject
    public MessageRecipientTypeaheadFilter(DefaultAndroidThreadUtil defaultAndroidThreadUtil, ContactsDbMessageRecipientDataSource contactsDbMessageRecipientDataSource) {
        this.f8119a = defaultAndroidThreadUtil;
        this.f8120b = contactsDbMessageRecipientDataSource;
    }

    protected FilterResults performFiltering(CharSequence charSequence) {
        this.f8119a.b();
        Preconditions.checkNotNull(charSequence);
        List a = TaggingProfile.a(this.f8120b.m9766a(charSequence));
        FilterResults filterResults = new FilterResults();
        filterResults.values = a;
        filterResults.count = a.size();
        return filterResults;
    }

    protected void publishResults(@Nullable CharSequence charSequence, FilterResults filterResults) {
        if (filterResults != null && this.f8121c != null) {
            this.f8121c.mo448a((List) filterResults.values);
        }
    }
}
