package com.facebook.controller.mutation.util;

import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.GraphQLStorySaveInfo;
import com.facebook.graphql.model.GraphQLStorySaveInfo$Builder;
import com.facebook.graphql.modelutil.BaseModel.Builder;
import com.facebook.inject.InjectorLike;

/* compiled from: accepted_notification */
public class StorySaveInfoMutator {
    public static StorySaveInfoMutator m19787a(InjectorLike injectorLike) {
        return new StorySaveInfoMutator();
    }

    public static GraphQLStorySaveInfo m19788a(GraphQLStorySaveInfo graphQLStorySaveInfo, GraphQLSavedState graphQLSavedState) {
        if (!GraphQLHelper.a(graphQLStorySaveInfo)) {
            return graphQLStorySaveInfo;
        }
        GraphQLStorySaveInfo$Builder graphQLStorySaveInfo$Builder = new GraphQLStorySaveInfo$Builder();
        graphQLStorySaveInfo.h();
        graphQLStorySaveInfo$Builder.f13168d = graphQLStorySaveInfo.a();
        graphQLStorySaveInfo$Builder.f13169e = graphQLStorySaveInfo.j();
        graphQLStorySaveInfo$Builder.f13170f = graphQLStorySaveInfo.k();
        graphQLStorySaveInfo$Builder.f13171g = graphQLStorySaveInfo.l();
        graphQLStorySaveInfo$Builder.f13172h = graphQLStorySaveInfo.m();
        Builder.a(graphQLStorySaveInfo$Builder, graphQLStorySaveInfo);
        GraphQLStorySaveInfo$Builder graphQLStorySaveInfo$Builder2 = graphQLStorySaveInfo$Builder;
        graphQLStorySaveInfo$Builder2.f13172h = graphQLSavedState;
        if (graphQLStorySaveInfo$Builder2.a != null && graphQLStorySaveInfo$Builder2.a.d) {
            graphQLStorySaveInfo$Builder2.a.a(graphQLStorySaveInfo$Builder2.b, 4, graphQLSavedState);
        }
        return new GraphQLStorySaveInfo(graphQLStorySaveInfo$Builder2);
    }
}
