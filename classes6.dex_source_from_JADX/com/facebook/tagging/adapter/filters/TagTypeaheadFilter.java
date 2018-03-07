package com.facebook.tagging.adapter.filters;

import android.widget.Filter.FilterResults;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.qe.api.QeAccessor;
import com.facebook.tagging.abtest.ExperimentsForTaggingABTestModule;
import com.facebook.tagging.data.TagTypeaheadDataSource;
import com.facebook.tagging.model.TaggingProfile;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Locale;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: df358c99a9484cfc8f758d51f6e31f33 */
public class TagTypeaheadFilter extends BaseTagTypeaheadFilter {
    public boolean f17336a = true;
    public boolean f17337b = true;
    public boolean f17338c = true;
    public boolean f17339d = true;
    public boolean f17340e = true;
    public TagTypeaheadDataSource f17341f;
    private QeAccessor f17342g;
    public TagTypeaheadDataSource f17343h;
    private DefaultAndroidThreadUtil f17344i;
    private Provider<TagTypeaheadDataSource> f17345j;
    public CharSequence f17346k;
    public String f17347l;

    @Inject
    public TagTypeaheadFilter(AndroidThreadUtil androidThreadUtil, QeAccessor qeAccessor, Provider<TagTypeaheadDataSource> provider) {
        this.f17342g = qeAccessor;
        this.f17344i = androidThreadUtil;
        this.f17345j = provider;
    }

    protected boolean mo1313a(TaggingProfile taggingProfile, String str) {
        return true;
    }

    protected final List<TaggingProfile> m25181b(@Nullable CharSequence charSequence, List<TaggingProfile> list) {
        String toLowerCase;
        if (charSequence != null) {
            toLowerCase = charSequence.toString().toLowerCase(Locale.getDefault());
        } else {
            toLowerCase = null;
        }
        int a = this.f17342g.a(ExperimentsForTaggingABTestModule.f17307f, 1000);
        List<TaggingProfile> a2 = Lists.a();
        for (TaggingProfile taggingProfile : list) {
            if (mo1313a(taggingProfile, toLowerCase)) {
                a2.add(taggingProfile);
                if (a >= 0 && a2.size() >= a) {
                    break;
                }
            }
        }
        return a2;
    }

    protected final List<TaggingProfile> m25179a(@Nullable CharSequence charSequence, TagTypeaheadDataSource tagTypeaheadDataSource) {
        return m25181b(charSequence, tagTypeaheadDataSource.mo1318a(charSequence, this.f17336a, this.f17337b, this.f17338c, this.f17339d));
    }

    protected FilterResults performFiltering(CharSequence charSequence) {
        this.f17344i.b();
        Preconditions.checkNotNull(charSequence);
        if (this.f17341f == null) {
            this.f17341f = (TagTypeaheadDataSource) this.f17345j.get();
        }
        List a = m25179a(charSequence, this.f17341f);
        if (this.f17343h != null) {
            a.addAll(m25179a(charSequence, this.f17343h));
        }
        a = TaggingProfile.m25528a(a);
        FilterResults filterResults = new FilterResults();
        filterResults.values = a;
        filterResults.count = a.size();
        return filterResults;
    }

    protected void publishResults(@Nullable CharSequence charSequence, FilterResults filterResults) {
        if (this.f17346k != null && this.f17346k.toString().equals(charSequence)) {
            super.publishResults(charSequence, filterResults);
        }
    }
}
