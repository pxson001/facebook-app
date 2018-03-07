package com.facebook.composer.publish.cache.db;

import com.facebook.composer.publish.common.PendingStoryPersistentData;
import com.facebook.composer.publish.common.PostParamsWrapper;
import com.facebook.graphql.model.GraphQLStory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Preconditions;

/* compiled from: photos_of_user */
public class DbComposerHandler$SerializedPendingStoryPersistentData {
    public final String f8023a;
    public final String f8024b;
    public final String f8025c;

    public DbComposerHandler$SerializedPendingStoryPersistentData(String str, String str2, String str3) {
        this.f8023a = (String) Preconditions.checkNotNull(str);
        this.f8024b = (String) Preconditions.checkNotNull(str2);
        this.f8025c = (String) Preconditions.checkNotNull(str3);
    }

    public final PendingStoryPersistentData m11578a(ObjectMapper objectMapper) {
        return new PendingStoryPersistentData((GraphQLStory) objectMapper.a(this.f8024b, GraphQLStory.class), (PostParamsWrapper) objectMapper.a(this.f8025c, PostParamsWrapper.class));
    }
}
