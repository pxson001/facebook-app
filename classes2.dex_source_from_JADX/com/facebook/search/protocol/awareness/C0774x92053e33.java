package com.facebook.search.protocol.awareness;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.search.protocol.awareness.SearchAwarenessModels$UserSearchAwarenessSuggestionSubscriptionModel.Deserializer;
import com.facebook.search.protocol.awareness.SearchAwarenessModels$UserSearchAwarenessSuggestionSubscriptionModel.Serializer;
import com.facebook.search.protocol.awareness.SearchAwarenessModels.SearchAwarenessRootSuggestionFieldsFragmentModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import javax.annotation.Nullable;

@JsonDeserialize(using = Deserializer.class)
@ModelWithFlatBufferFormatHash(a = -2059037551)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: internal_star_rating_fbandroid */
public final class C0774x92053e33 extends BaseModel implements GraphQLVisitableModel {
    @Nullable
    private SearchAwarenessRootSuggestionFieldsFragmentModel f19658d;

    public C0774x92053e33() {
        super(1);
    }

    @Nullable
    public final SearchAwarenessRootSuggestionFieldsFragmentModel m27390a() {
        this.f19658d = (SearchAwarenessRootSuggestionFieldsFragmentModel) super.m9947a(this.f19658d, 0, SearchAwarenessRootSuggestionFieldsFragmentModel.class);
        return this.f19658d;
    }

    public final int jK_() {
        return 1106036393;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m27390a() != null) {
            SearchAwarenessRootSuggestionFieldsFragmentModel searchAwarenessRootSuggestionFieldsFragmentModel = (SearchAwarenessRootSuggestionFieldsFragmentModel) graphQLModelMutatingVisitor.mo2928b(m27390a());
            if (m27390a() != searchAwarenessRootSuggestionFieldsFragmentModel) {
                graphQLVisitableModel = (C0774x92053e33) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f19658d = searchAwarenessRootSuggestionFieldsFragmentModel;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23093a(flatBufferBuilder, m27390a());
        flatBufferBuilder.m21510c(1);
        flatBufferBuilder.m21507b(0, a);
        m9959i();
        return flatBufferBuilder.m21511d();
    }
}
