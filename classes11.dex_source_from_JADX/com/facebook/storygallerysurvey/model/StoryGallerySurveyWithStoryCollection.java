package com.facebook.storygallerysurvey.model;

import com.facebook.api.feed.data.collections.ListItemCollection;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.storygallerysurvey.protocol.FetchStoryGallerySurveyWithStoryGraphQLModels.FetchStoryGallerySurveyWithStoryQueryModel.StoryGallerySurveyModel.NodesModel;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Not Modified */
public class StoryGallerySurveyWithStoryCollection implements ListItemCollection<GraphQLStory> {
    public List<GraphQLStory> f12959a = new ArrayList();
    public List<String> f12960b = new ArrayList();

    public final /* synthetic */ Object m13668a(int i) {
        return m13669b(i);
    }

    public StoryGallerySurveyWithStoryCollection(ImmutableList<NodesModel> immutableList) {
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            NodesModel nodesModel = (NodesModel) immutableList.get(i);
            this.f12959a.add(nodesModel.m13681a());
            this.f12960b.add(nodesModel.m13683j());
        }
    }

    public final int m13667a() {
        return this.f12959a.size();
    }

    public final GraphQLStory m13669b(int i) {
        return (GraphQLStory) this.f12959a.get(i);
    }
}
