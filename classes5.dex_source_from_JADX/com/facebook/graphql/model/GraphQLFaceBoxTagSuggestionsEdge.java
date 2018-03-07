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
import com.facebook.graphql.deserializers.GraphQLFaceBoxTagSuggestionsEdgeDeserializer;
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
import com.google.common.base.Preconditions;
import com.instagram.common.json.annotation.JsonType;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: http.cookie-store */
public final class GraphQLFaceBoxTagSuggestionsEdge extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLFaceBoxTagSuggestionsEdge> CREATOR = new C03221();
    @Nullable
    public String f3754d;
    @Nullable
    public GraphQLProfile f3755e;

    /* compiled from: http.cookie-store */
    final class C03221 implements Creator<GraphQLFaceBoxTagSuggestionsEdge> {
        C03221() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLFaceBoxTagSuggestionsEdge(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLFaceBoxTagSuggestionsEdge[i];
        }
    }

    /* compiled from: http.cookie-store */
    public class Builder extends com.facebook.graphql.modelutil.BaseModel.Builder {
        @Nullable
        public String f3752d;
        @Nullable
        public GraphQLProfile f3753e;

        public Builder() {
            Preconditions.checkState(this instanceof Builder);
        }
    }

    /* compiled from: http.cookie-store */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLFaceBoxTagSuggestionsEdge.class, new Deserializer());
        }

        public Object m7442a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLFaceBoxTagSuggestionsEdgeDeserializer.m4877a(jsonParser, (short) 456);
            Object graphQLFaceBoxTagSuggestionsEdge = new GraphQLFaceBoxTagSuggestionsEdge();
            ((BaseModel) graphQLFaceBoxTagSuggestionsEdge).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLFaceBoxTagSuggestionsEdge instanceof Postprocessable) {
                return ((Postprocessable) graphQLFaceBoxTagSuggestionsEdge).a();
            }
            return graphQLFaceBoxTagSuggestionsEdge;
        }
    }

    /* compiled from: http.cookie-store */
    public final class Serializer extends JsonSerializer<GraphQLFaceBoxTagSuggestionsEdge> {
        public final void m7443a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLFaceBoxTagSuggestionsEdge graphQLFaceBoxTagSuggestionsEdge = (GraphQLFaceBoxTagSuggestionsEdge) obj;
            GraphQLFaceBoxTagSuggestionsEdgeDeserializer.m4878b(graphQLFaceBoxTagSuggestionsEdge.w_(), graphQLFaceBoxTagSuggestionsEdge.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLFaceBoxTagSuggestionsEdge.class, new Serializer());
            FbSerializerProvider.a(GraphQLFaceBoxTagSuggestionsEdge.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final String m7446a() {
        this.f3754d = super.a(this.f3754d, 0);
        return this.f3754d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLProfile m7447j() {
        this.f3755e = (GraphQLProfile) super.a(this.f3755e, 1, GraphQLProfile.class);
        return this.f3755e;
    }

    public final int jK_() {
        return -1318601472;
    }

    public final GraphQLVisitableModel m7445a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m7447j() != null) {
            GraphQLProfile graphQLProfile = (GraphQLProfile) graphQLModelMutatingVisitor.b(m7447j());
            if (m7447j() != graphQLProfile) {
                graphQLVisitableModel = (GraphQLFaceBoxTagSuggestionsEdge) ModelHelper.a(null, this);
                graphQLVisitableModel.f3755e = graphQLProfile;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLFaceBoxTagSuggestionsEdge() {
        super(3);
    }

    public final int m7444a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m7446a());
        int a = ModelHelper.a(flatBufferBuilder, m7447j());
        flatBufferBuilder.c(2);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLFaceBoxTagSuggestionsEdge(Parcel parcel) {
        super(3);
        this.f3754d = parcel.readString();
        this.f3755e = (GraphQLProfile) parcel.readValue(GraphQLProfile.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m7446a());
        parcel.writeValue(m7447j());
    }

    public GraphQLFaceBoxTagSuggestionsEdge(Builder builder) {
        super(3);
        this.b = builder.a;
        this.c = builder.b;
        this.f3754d = builder.f3752d;
        this.f3755e = builder.f3753e;
    }
}
