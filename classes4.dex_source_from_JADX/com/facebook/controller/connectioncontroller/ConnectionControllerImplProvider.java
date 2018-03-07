package com.facebook.controller.connectioncontroller;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.controller.connectioncontroller.common.ConnectionCacheRetainingPolicy;
import com.facebook.controller.connectioncontroller.common.ConnectionConfiguration;
import com.facebook.controller.connectioncontroller.common.ConnectionInitialFetchPolicy;
import com.facebook.controller.connectioncontroller.common.ConnectionStore;
import com.facebook.controller.connectioncontroller.common.MutationControllerManager;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.cache.GraphQLCacheManager;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: method/user.registerPushCallback */
public class ConnectionControllerImplProvider extends AbstractAssistedProvider<ConnectionControllerImpl> {
    public final <TEdge, TUserInfo, TRequestModel, TResponseModel> ConnectionControllerImpl<TEdge, TUserInfo, TRequestModel, TResponseModel> m8071a(ConnectionConfiguration<TEdge, TUserInfo, TRequestModel, TResponseModel> connectionConfiguration, ConnectionStore<TEdge> connectionStore, MutationControllerManager mutationControllerManager, ConnectionInitialFetchPolicy connectionInitialFetchPolicy, ConnectionCacheRetainingPolicy connectionCacheRetainingPolicy, boolean z, String str) {
        return new ConnectionControllerImpl(connectionConfiguration, connectionStore, mutationControllerManager, connectionInitialFetchPolicy, connectionCacheRetainingPolicy, z, str, Handler_ForUiThreadMethodAutoProvider.b(this), GraphQLQueryExecutor.a(this), GraphQLCacheManager.a(this), DefaultAndroidThreadUtil.b(this), (AbstractFbErrorReporter) FbErrorReporterImpl.a(this));
    }
}
