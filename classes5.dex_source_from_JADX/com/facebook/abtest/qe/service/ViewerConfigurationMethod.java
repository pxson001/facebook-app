package com.facebook.abtest.qe.service;

import com.facebook.abtest.qe.protocol.sync.full.ViewerConfigurationQuery.ViewerConfigurationQueryString;
import com.facebook.abtest.qe.protocol.sync.full.ViewerConfigurationQueryModels.ConfigurationEdgeModel;
import com.facebook.abtest.qe.protocol.sync.full.ViewerConfigurationQueryModels.ViewerConfigsModel.ConfigsModel;
import com.facebook.graphql.protocol.AbstractPersistedGraphQlApiMethod;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.http.protocol.ApiResponse;
import com.fasterxml.jackson.core.JsonParser;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

/* compiled from: topic_feeds */
public class ViewerConfigurationMethod extends AbstractPersistedGraphQlApiMethod<ImmutableList<String>, ImmutableList<ConfigurationEdgeModel>> {
    public final GraphQlQueryString m2459f(Object obj) {
        return new ViewerConfigurationQueryString().a("config_names", (ImmutableList) obj);
    }

    @Inject
    public ViewerConfigurationMethod(GraphQLProtocolHelper graphQLProtocolHelper) {
        super(graphQLProtocolHelper);
    }

    public final Object m2457a(Object obj, ApiResponse apiResponse, JsonParser jsonParser) {
        Builder builder = new Builder();
        ConfigsModel configsModel = (ConfigsModel) jsonParser.a(ConfigsModel.class);
        if (configsModel == null) {
            return builder.b();
        }
        ImmutableList a = configsModel.m2435a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            builder.c(a.get(i));
        }
        return builder.b();
    }

    public final int m2458b(Object obj, ApiResponse apiResponse) {
        return 2;
    }
}
