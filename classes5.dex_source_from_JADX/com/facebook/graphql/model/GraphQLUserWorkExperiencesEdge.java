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
import com.facebook.graphql.deserializers.GraphQLUserWorkExperiencesEdgeDeserializer;
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
/* compiled from: TimelineSectionUnitsEdge */
public final class GraphQLUserWorkExperiencesEdge extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLUserWorkExperiencesEdge> CREATOR = new C12691();
    @Nullable
    public GraphQLWorkExperience f13443d;

    /* compiled from: TimelineSectionUnitsEdge */
    final class C12691 implements Creator<GraphQLUserWorkExperiencesEdge> {
        C12691() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLUserWorkExperiencesEdge(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLUserWorkExperiencesEdge[i];
        }
    }

    /* compiled from: TimelineSectionUnitsEdge */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLUserWorkExperiencesEdge.class, new Deserializer());
        }

        public Object m22407a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLUserWorkExperiencesEdgeDeserializer.m6163a(jsonParser, (short) 338);
            Object graphQLUserWorkExperiencesEdge = new GraphQLUserWorkExperiencesEdge();
            ((BaseModel) graphQLUserWorkExperiencesEdge).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLUserWorkExperiencesEdge instanceof Postprocessable) {
                return ((Postprocessable) graphQLUserWorkExperiencesEdge).a();
            }
            return graphQLUserWorkExperiencesEdge;
        }
    }

    /* compiled from: TimelineSectionUnitsEdge */
    public final class Serializer extends JsonSerializer<GraphQLUserWorkExperiencesEdge> {
        public final void m22408a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLUserWorkExperiencesEdge graphQLUserWorkExperiencesEdge = (GraphQLUserWorkExperiencesEdge) obj;
            GraphQLUserWorkExperiencesEdgeDeserializer.m6164b(graphQLUserWorkExperiencesEdge.w_(), graphQLUserWorkExperiencesEdge.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLUserWorkExperiencesEdge.class, new Serializer());
            FbSerializerProvider.a(GraphQLUserWorkExperiencesEdge.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLWorkExperience m22410a() {
        this.f13443d = (GraphQLWorkExperience) super.a(this.f13443d, 0, GraphQLWorkExperience.class);
        return this.f13443d;
    }

    public final int jK_() {
        return -959641494;
    }

    public final GraphQLVisitableModel m22411a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m22410a() != null) {
            GraphQLWorkExperience graphQLWorkExperience = (GraphQLWorkExperience) graphQLModelMutatingVisitor.b(m22410a());
            if (m22410a() != graphQLWorkExperience) {
                graphQLVisitableModel = (GraphQLUserWorkExperiencesEdge) ModelHelper.a(null, this);
                graphQLVisitableModel.f13443d = graphQLWorkExperience;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLUserWorkExperiencesEdge() {
        super(2);
    }

    public final int m22409a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m22410a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLUserWorkExperiencesEdge(Parcel parcel) {
        super(2);
        this.f13443d = (GraphQLWorkExperience) parcel.readValue(GraphQLWorkExperience.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m22410a());
    }
}
