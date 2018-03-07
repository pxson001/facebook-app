package com.facebook.timeline.editfeaturedcontainers.rows.environments;

import android.content.Context;
import com.facebook.feed.rows.adapter.api.MultiRowRecyclerViewAdapter;
import com.facebook.graphql.calls.SectionTypesInputFeaturedPageSuggestionsSectionType;
import com.facebook.multirow.api.AnyEnvironment;
import com.google.common.collect.ImmutableList;

/* compiled from: getAppPermission */
public interface HasMorePageSuggestionsFetcher extends AnyEnvironment {
    void mo516a();

    void mo517a(int i, int i2, ImmutableList<SectionTypesInputFeaturedPageSuggestionsSectionType> immutableList, Context context);

    void mo518a(MultiRowRecyclerViewAdapter multiRowRecyclerViewAdapter);
}
