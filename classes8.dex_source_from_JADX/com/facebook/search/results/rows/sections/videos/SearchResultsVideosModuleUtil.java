package com.facebook.search.results.rows.sections.videos;

import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.search.results.model.SearchResultsProps;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel;
import com.facebook.search.results.protocol.SearchResultsEdgeModels.SearchResultsEdgeModel.NodeModel.ModuleResultsModel.EdgesModel;
import com.facebook.search.results.protocol.video.SearchResultsVideosModuleInterfaces.SearchResultsVideosModule;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

/* compiled from: PLACES */
public class SearchResultsVideosModuleUtil {
    public static ImmutableList<SearchResultsProps<FeedProps<GraphQLStoryAttachment>>> m28507a(SearchResultsProps<? extends SearchResultsVideosModule> searchResultsProps) {
        int i = 0;
        ModuleResultsModel moduleResultsModel = (ModuleResultsModel) Preconditions.checkNotNull(((NodeModel) searchResultsProps.f23388a).bd());
        Builder builder = new Builder();
        ImmutableList a = moduleResultsModel.m9710a();
        int size = a.size();
        int i2 = 0;
        while (i2 < size) {
            GraphQLStory p;
            GraphQLStoryAttachment o;
            int i3;
            EdgesModel edgesModel = (EdgesModel) a.get(i2);
            if (edgesModel.m9703l() != null) {
                p = edgesModel.m9703l().mo591p();
            } else {
                p = null;
            }
            if (p != null) {
                o = StoryAttachmentHelper.o(p);
            } else {
                o = null;
            }
            if (o == null || !GraphQLStoryAttachmentUtil.d(o)) {
                i3 = i;
            } else {
                builder.c(searchResultsProps.m27105a(FeedProps.a(o, ImmutableList.of(p)), i));
                i3 = i + 1;
            }
            i2++;
            i = i3;
        }
        return builder.b();
    }
}
