package com.facebook.tagging.adapter.filters;

import android.widget.Filter.FilterResults;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.util.TriState;
import com.facebook.qe.api.QeAccessor;
import com.facebook.tagging.abtest.ExperimentsForTaggingABTestModule;
import com.facebook.tagging.data.TagTypeaheadDataSource;
import com.facebook.tagging.data.UberbarDataSource;
import com.facebook.tagging.graphql.data.GraphQLTaggingDataSource;
import com.facebook.tagging.graphql.data.IsFofTaggingEnabledGk;
import com.facebook.tagging.model.TaggingProfile;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import java.util.Locale;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: device_orientation */
public class MentionsTagTypeaheadFilter extends MultiSourceTagTypeaheadFilter {
    private Provider<TagTypeaheadDataSource> f17351f;
    private QeAccessor f17352g;
    private Provider<UberbarDataSource> f17353h;
    @IsFofTaggingEnabledGk
    private Provider<TriState> f17354i;
    private Provider<GraphQLTaggingDataSource> f17355j;

    @Inject
    public MentionsTagTypeaheadFilter(AndroidThreadUtil androidThreadUtil, QeAccessor qeAccessor, Provider<TagTypeaheadDataSource> provider, Provider<UberbarDataSource> provider2, Provider<TriState> provider3, Provider<GraphQLTaggingDataSource> provider4) {
        super(androidThreadUtil, qeAccessor, provider);
        this.f17351f = provider;
        this.f17353h = provider2;
        this.f17352g = qeAccessor;
        this.f17354i = provider3;
        this.f17355j = provider4;
    }

    protected FilterResults performFiltering(@Nullable CharSequence charSequence) {
        if (this.f17350h) {
            m25183a((TagTypeaheadDataSource) this.f17351f.get(), false);
            if (this.f17352g.a(ExperimentsForTaggingABTestModule.f17310i, false)) {
                m25183a((TagTypeaheadDataSource) this.f17353h.get(), false);
            }
            if (TriState.YES.equals(this.f17354i.get())) {
                m25183a((TagTypeaheadDataSource) this.f17355j.get(), false);
            }
        }
        return super.performFiltering(charSequence);
    }

    protected final boolean mo1313a(TaggingProfile taggingProfile, String str) {
        Preconditions.checkNotNull(str);
        if (Strings.isNullOrEmpty(str)) {
            return true;
        }
        if (taggingProfile.f17538a == null || taggingProfile.f17538a.i().length() == 0) {
            return false;
        }
        for (String startsWith : taggingProfile.f17538a.i().toLowerCase(Locale.getDefault()).split(" ")) {
            if (startsWith.startsWith(str)) {
                return true;
            }
        }
        return false;
    }
}
