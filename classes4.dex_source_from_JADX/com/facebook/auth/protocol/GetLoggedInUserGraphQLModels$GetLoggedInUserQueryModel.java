package com.facebook.auth.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import javax.annotation.Nullable;

@JsonDeserialize(using = Deserializer.class)
@ModelWithFlatBufferFormatHash(a = 9164158)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: south */
public final class GetLoggedInUserGraphQLModels$GetLoggedInUserQueryModel extends BaseModel implements GraphQLVisitableModel {
    @Nullable
    private LoggedInUserQueryFragmentModels$LoggedInUserQueryFragmentModel f1963d;
    private boolean f1964e;

    /* compiled from: south */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GetLoggedInUserGraphQLModels$GetLoggedInUserQueryModel.class, new Deserializer());
        }

        public Object m2029a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GetLoggedInUserGraphQLParsers$GetLoggedInUserQueryParser.m2030a(jsonParser);
            Object getLoggedInUserGraphQLModels$GetLoggedInUserQueryModel = new GetLoggedInUserGraphQLModels$GetLoggedInUserQueryModel();
            ((BaseModel) getLoggedInUserGraphQLModels$GetLoggedInUserQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
            if (getLoggedInUserGraphQLModels$GetLoggedInUserQueryModel instanceof Postprocessable) {
                return ((Postprocessable) getLoggedInUserGraphQLModels$GetLoggedInUserQueryModel).a();
            }
            return getLoggedInUserGraphQLModels$GetLoggedInUserQueryModel;
        }
    }

    public GetLoggedInUserGraphQLModels$GetLoggedInUserQueryModel() {
        super(2);
    }

    @Nullable
    public final LoggedInUserQueryFragmentModels$LoggedInUserQueryFragmentModel m2023a() {
        this.f1963d = (LoggedInUserQueryFragmentModels$LoggedInUserQueryFragmentModel) super.a(this.f1963d, 0, LoggedInUserQueryFragmentModels$LoggedInUserQueryFragmentModel.class);
        return this.f1963d;
    }

    public final boolean m2026j() {
        a(0, 1);
        return this.f1964e;
    }

    public final int jK_() {
        return -1732764110;
    }

    public final GraphQLVisitableModel m2024a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m2023a() != null) {
            LoggedInUserQueryFragmentModels$LoggedInUserQueryFragmentModel loggedInUserQueryFragmentModels$LoggedInUserQueryFragmentModel = (LoggedInUserQueryFragmentModels$LoggedInUserQueryFragmentModel) graphQLModelMutatingVisitor.b(m2023a());
            if (m2023a() != loggedInUserQueryFragmentModels$LoggedInUserQueryFragmentModel) {
                graphQLVisitableModel = (GetLoggedInUserGraphQLModels$GetLoggedInUserQueryModel) ModelHelper.a(null, this);
                graphQLVisitableModel.f1963d = loggedInUserQueryFragmentModels$LoggedInUserQueryFragmentModel;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final int m2022a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m2023a());
        flatBufferBuilder.c(2);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.a(1, this.f1964e);
        i();
        return flatBufferBuilder.d();
    }

    public final void m2025a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f1964e = mutableFlatBuffer.a(i, 1);
    }
}
