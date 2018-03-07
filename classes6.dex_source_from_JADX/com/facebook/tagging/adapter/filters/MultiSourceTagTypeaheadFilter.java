package com.facebook.tagging.adapter.filters;

import android.widget.Filter.FilterResults;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.qe.api.QeAccessor;
import com.facebook.tagging.data.TagTypeaheadDataSource;
import com.facebook.tagging.data.TagTypeaheadDataSource.SourceResultsListener;
import com.facebook.tagging.model.TaggingProfile;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: device_time */
public class MultiSourceTagTypeaheadFilter extends TagTypeaheadFilter implements SourceResultsListener {
    private final ArrayList<TagTypeaheadDataSource> f17348f = Lists.a();
    private final DefaultAndroidThreadUtil f17349g;
    public boolean f17350h = true;

    @Inject
    public MultiSourceTagTypeaheadFilter(AndroidThreadUtil androidThreadUtil, QeAccessor qeAccessor, Provider<TagTypeaheadDataSource> provider) {
        super(androidThreadUtil, qeAccessor, provider);
        this.f17349g = androidThreadUtil;
    }

    public final void mo1121a(CharSequence charSequence, List<TaggingProfile> list) {
        m25182c(charSequence, m25181b(charSequence, list));
    }

    protected FilterResults performFiltering(@Nullable CharSequence charSequence) {
        this.f17349g.b();
        Builder builder = new Builder();
        int size = this.f17348f.size();
        for (int i = 0; i < size; i++) {
            TagTypeaheadDataSource tagTypeaheadDataSource = (TagTypeaheadDataSource) this.f17348f.get(i);
            if (tagTypeaheadDataSource.mo1315a()) {
                tagTypeaheadDataSource.mo1314a(charSequence, this.f17347l, this.f17336a, this.f17337b, this.f17338c, this.f17339d, this.f17340e, this);
            } else {
                builder.b(m25179a(charSequence, tagTypeaheadDataSource));
            }
        }
        m25182c(charSequence, builder.b());
        return null;
    }

    private void m25182c(@Nullable final CharSequence charSequence, List<TaggingProfile> list) {
        this.f17349g.b();
        final FilterResults filterResults = new FilterResults();
        filterResults.values = list;
        filterResults.count = list.size();
        this.f17349g.b(new Runnable(this) {
            final /* synthetic */ MultiSourceTagTypeaheadFilter f17358c;

            public void run() {
                this.f17358c.publishResults(charSequence, filterResults);
            }
        });
    }

    protected void publishResults(@Nullable CharSequence charSequence, @Nullable FilterResults filterResults) {
        this.f17349g.a();
        if (filterResults != null) {
            super.publishResults(charSequence, filterResults);
        }
    }

    public final void m25183a(TagTypeaheadDataSource tagTypeaheadDataSource, boolean z) {
        if (!this.f17348f.contains(tagTypeaheadDataSource)) {
            this.f17350h = z;
            this.f17348f.add(tagTypeaheadDataSource);
        }
    }
}
