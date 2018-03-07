package com.facebook.photos.upload.serverprocessing;

import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.photos.upload.serverprocessing.VideoStatusChecker.Listener;
import com.facebook.ui.futures.TasksManager;
import com.google.common.collect.ImmutableList;

/* compiled from: full_interstitial_cool_animations */
public class VideoStatusCheckerProvider extends AbstractAssistedProvider<VideoStatusChecker> {
    public final VideoStatusChecker m21921a(ImmutableList<String> immutableList, Listener listener) {
        return new VideoStatusChecker(GraphQLQueryExecutor.a(this), TasksManager.b(this), immutableList, listener);
    }
}
