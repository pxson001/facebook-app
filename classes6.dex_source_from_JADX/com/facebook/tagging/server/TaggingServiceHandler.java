package com.facebook.tagging.server;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.http.protocol.ApiMethodRunnerImpl;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.tagging.graphql.protocol.GraphQLTagSearchMethod;
import com.facebook.tagging.graphql.protocol.GraphQLTagSearchParams;
import com.facebook.tagging.graphql.protocol.TagSearchGraphQLModels.TagSearchModel.ResultsModel;
import com.facebook.tagging.protocol.FetchGroupMembersMethod;
import com.facebook.tagging.protocol.FetchGroupMembersParams;
import java.util.ArrayList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: deltaNotificationSettings */
public class TaggingServiceHandler implements BlueServiceHandler {
    private static TaggingServiceHandler f17569d;
    private static final Object f17570e = new Object();
    public final ApiMethodRunnerImpl f17571a;
    public final FetchGroupMembersMethod f17572b;
    public final GraphQLTagSearchMethod f17573c;

    private static TaggingServiceHandler m25564b(InjectorLike injectorLike) {
        return new TaggingServiceHandler(ApiMethodRunnerImpl.a(injectorLike), new FetchGroupMembersMethod(), new GraphQLTagSearchMethod(GraphQLProtocolHelper.a(injectorLike)));
    }

    @Inject
    public TaggingServiceHandler(ApiMethodRunnerImpl apiMethodRunnerImpl, FetchGroupMembersMethod fetchGroupMembersMethod, GraphQLTagSearchMethod graphQLTagSearchMethod) {
        this.f17571a = apiMethodRunnerImpl;
        this.f17572b = fetchGroupMembersMethod;
        this.f17573c = graphQLTagSearchMethod;
    }

    public final OperationResult m25565a(OperationParams operationParams) {
        String str = operationParams.b;
        if ("fetch_group_members".equals(str)) {
            return OperationResult.a((ArrayList) this.f17571a.a(this.f17572b, (FetchGroupMembersParams) operationParams.c.getParcelable("fetch_group_members_params")));
        } else if ("graphql_tags_search".equals(str)) {
            return OperationResult.a((ResultsModel) this.f17571a.a(this.f17573c, (GraphQLTagSearchParams) operationParams.c.getParcelable("graphql_tags_search_params")));
        } else {
            throw new IllegalArgumentException("Unknown operation type: " + str);
        }
    }

    public static TaggingServiceHandler m25563a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TaggingServiceHandler b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f17570e) {
                TaggingServiceHandler taggingServiceHandler;
                if (a2 != null) {
                    taggingServiceHandler = (TaggingServiceHandler) a2.a(f17570e);
                } else {
                    taggingServiceHandler = f17569d;
                }
                if (taggingServiceHandler == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m25564b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f17570e, b3);
                        } else {
                            f17569d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = taggingServiceHandler;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}
