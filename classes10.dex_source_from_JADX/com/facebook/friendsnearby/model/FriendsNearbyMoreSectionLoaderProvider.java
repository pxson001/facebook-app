package com.facebook.friendsnearby.model;

import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.ui.futures.TasksManager;

/* compiled from: a2ce3b4d50f168415f08a35c28e2264c */
public class FriendsNearbyMoreSectionLoaderProvider extends AbstractAssistedProvider<FriendsNearbyMoreSectionLoader> {
    public final FriendsNearbyMoreSectionLoader m20860a(String str, String str2, TasksManager tasksManager) {
        return new FriendsNearbyMoreSectionLoader(str, str2, tasksManager, ResourcesMethodAutoProvider.a(this), GraphQLQueryExecutor.a(this), (AbstractFbErrorReporter) FbErrorReporterImpl.a(this), (FriendsNearbyNewListRowProvider) getOnDemandAssistedProviderForStaticDi(FriendsNearbyNewListRowProvider.class));
    }
}
