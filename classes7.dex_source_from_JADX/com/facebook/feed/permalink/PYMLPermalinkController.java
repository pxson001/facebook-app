package com.facebook.feed.permalink;

import com.facebook.graphql.model.GraphQLPYMLWithLargeImageFeedUnit;
import com.facebook.ui.futures.TasksManager;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.util.concurrent.FutureCallback;
import javax.inject.Inject;

/* compiled from: album_creator_cancelled */
public class PYMLPermalinkController {
    private final ObjectMapper f19549a;
    public final TasksManager f19550b;

    @Inject
    public PYMLPermalinkController(ObjectMapper objectMapper, TasksManager tasksManager) {
        this.f19549a = objectMapper;
        this.f19550b = tasksManager;
    }

    public final void m22863a(PermalinkParams permalinkParams, FutureCallback<GraphQLPYMLWithLargeImageFeedUnit> futureCallback) {
        try {
            futureCallback.onSuccess((GraphQLPYMLWithLargeImageFeedUnit) this.f19549a.a(permalinkParams.m22902d(), GraphQLPYMLWithLargeImageFeedUnit.class));
        } catch (Throwable e) {
            futureCallback.onFailure(e);
        }
    }
}
