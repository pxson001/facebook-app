package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLUserEducationExperiencesEdgeDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.instagram.common.json.annotation.JsonType;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: TopLevelCommentsConnection */
public final class GraphQLUserEducationExperiencesEdge extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLUserEducationExperiencesEdge> CREATOR = new C12681();
    @Nullable
    public GraphQLEducationExperience f13442d;

    /* compiled from: TopLevelCommentsConnection */
    final class C12681 implements Creator<GraphQLUserEducationExperiencesEdge> {
        C12681() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLUserEducationExperiencesEdge(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLUserEducationExperiencesEdge[i];
        }
    }

    /* compiled from: TopLevelCommentsConnection */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLUserEducationExperiencesEdge.class, new Deserializer());
        }

        public Object m22391a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLUserEducationExperiencesEdgeDeserializer.m6157a(jsonParser, (short) 340);
            Object graphQLUserEducationExperiencesEdge = new GraphQLUserEducationExperiencesEdge();
            ((BaseModel) graphQLUserEducationExperiencesEdge).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLUserEducationExperiencesEdge instanceof Postprocessable) {
                return ((Postprocessable) graphQLUserEducationExperiencesEdge).a();
            }
            return graphQLUserEducationExperiencesEdge;
        }
    }

    /* compiled from: TopLevelCommentsConnection */
    public final class Serializer extends JsonSerializer<GraphQLUserEducationExperiencesEdge> {
        public final void m22392a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLUserEducationExperiencesEdge graphQLUserEducationExperiencesEdge = (GraphQLUserEducationExperiencesEdge) obj;
            GraphQLUserEducationExperiencesEdgeDeserializer.m6158b(graphQLUserEducationExperiencesEdge.w_(), graphQLUserEducationExperiencesEdge.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLUserEducationExperiencesEdge.class, new Serializer());
            FbSerializerProvider.a(GraphQLUserEducationExperiencesEdge.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLEducationExperience m22394a() {
        this.f13442d = (GraphQLEducationExperience) super.a(this.f13442d, 0, GraphQLEducationExperience.class);
        return this.f13442d;
    }

    public final int jK_() {
        return 1323739113;
    }

    public final GraphQLVisitableModel m22395a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m22394a() != null) {
            GraphQLEducationExperience graphQLEducationExperience = (GraphQLEducationExperience) graphQLModelMutatingVisitor.b(m22394a());
            if (m22394a() != graphQLEducationExperience) {
                graphQLVisitableModel = (GraphQLUserEducationExperiencesEdge) ModelHelper.a(null, this);
                graphQLVisitableModel.f13442d = graphQLEducationExperience;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLUserEducationExperiencesEdge() {
        super(2);
    }

    public final int m22393a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m22394a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLUserEducationExperiencesEdge(Parcel parcel) {
        super(2);
        this.f13442d = (GraphQLEducationExperience) parcel.readValue(GraphQLEducationExperience.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m22394a());
    }
}
