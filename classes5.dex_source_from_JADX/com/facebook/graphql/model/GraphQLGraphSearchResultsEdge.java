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
import com.facebook.graphql.deserializers.GraphQLGraphSearchResultsEdgeDeserializer;
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
/* compiled from: full_suggestion */
public final class GraphQLGraphSearchResultsEdge extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLGraphSearchResultsEdge> CREATOR = new C03811();
    @Nullable
    String f4118d;
    @Nullable
    GraphQLNode f4119e;
    @Nullable
    GraphQLGraphSearchResultDecoration f4120f;
    @Nullable
    String f4121g;

    /* compiled from: full_suggestion */
    final class C03811 implements Creator<GraphQLGraphSearchResultsEdge> {
        C03811() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLGraphSearchResultsEdge(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLGraphSearchResultsEdge[i];
        }
    }

    /* compiled from: full_suggestion */
    public class Builder extends com.facebook.graphql.modelutil.BaseModel.Builder {
        @Nullable
        public String f4114d;
        @Nullable
        public GraphQLNode f4115e;
        @Nullable
        public GraphQLGraphSearchResultDecoration f4116f;
        @Nullable
        public String f4117g;

        public Builder() {
            Preconditions.checkState(this instanceof Builder);
        }
    }

    /* compiled from: full_suggestion */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLGraphSearchResultsEdge.class, new Deserializer());
        }

        public Object m8299a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLGraphSearchResultsEdgeDeserializer.m5113a(jsonParser, (short) 468);
            Object graphQLGraphSearchResultsEdge = new GraphQLGraphSearchResultsEdge();
            ((BaseModel) graphQLGraphSearchResultsEdge).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLGraphSearchResultsEdge instanceof Postprocessable) {
                return ((Postprocessable) graphQLGraphSearchResultsEdge).a();
            }
            return graphQLGraphSearchResultsEdge;
        }
    }

    /* compiled from: full_suggestion */
    public final class Serializer extends JsonSerializer<GraphQLGraphSearchResultsEdge> {
        public final void m8300a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLGraphSearchResultsEdge graphQLGraphSearchResultsEdge = (GraphQLGraphSearchResultsEdge) obj;
            GraphQLGraphSearchResultsEdgeDeserializer.m5115b(graphQLGraphSearchResultsEdge.w_(), graphQLGraphSearchResultsEdge.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLGraphSearchResultsEdge.class, new Serializer());
            FbSerializerProvider.a(GraphQLGraphSearchResultsEdge.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final String m8303a() {
        this.f4118d = super.a(this.f4118d, 0);
        return this.f4118d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLNode m8304j() {
        this.f4119e = (GraphQLNode) super.a(this.f4119e, 1, GraphQLNode.class);
        return this.f4119e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLGraphSearchResultDecoration m8305k() {
        this.f4120f = (GraphQLGraphSearchResultDecoration) super.a(this.f4120f, 2, GraphQLGraphSearchResultDecoration.class);
        return this.f4120f;
    }

    @FieldOffset
    @Nullable
    public final String m8306l() {
        this.f4121g = super.a(this.f4121g, 3);
        return this.f4121g;
    }

    public final int jK_() {
        return -316863363;
    }

    public final GraphQLVisitableModel m8302a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m8304j() != null) {
            GraphQLNode graphQLNode = (GraphQLNode) graphQLModelMutatingVisitor.b(m8304j());
            if (m8304j() != graphQLNode) {
                graphQLVisitableModel = (GraphQLGraphSearchResultsEdge) ModelHelper.a(null, this);
                graphQLVisitableModel.f4119e = graphQLNode;
            }
        }
        if (m8305k() != null) {
            GraphQLGraphSearchResultDecoration graphQLGraphSearchResultDecoration = (GraphQLGraphSearchResultDecoration) graphQLModelMutatingVisitor.b(m8305k());
            if (m8305k() != graphQLGraphSearchResultDecoration) {
                graphQLVisitableModel = (GraphQLGraphSearchResultsEdge) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4120f = graphQLGraphSearchResultDecoration;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLGraphSearchResultsEdge() {
        super(5);
    }

    public final int m8301a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m8303a());
        int a = ModelHelper.a(flatBufferBuilder, m8304j());
        int a2 = ModelHelper.a(flatBufferBuilder, m8305k());
        int b2 = flatBufferBuilder.b(m8306l());
        flatBufferBuilder.c(4);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, a);
        flatBufferBuilder.b(2, a2);
        flatBufferBuilder.b(3, b2);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLGraphSearchResultsEdge(Parcel parcel) {
        super(5);
        this.f4118d = parcel.readString();
        this.f4119e = (GraphQLNode) parcel.readValue(GraphQLNode.class.getClassLoader());
        this.f4120f = (GraphQLGraphSearchResultDecoration) parcel.readValue(GraphQLGraphSearchResultDecoration.class.getClassLoader());
        this.f4121g = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m8303a());
        parcel.writeValue(m8304j());
        parcel.writeValue(m8305k());
        parcel.writeString(m8306l());
    }

    public GraphQLGraphSearchResultsEdge(Builder builder) {
        super(5);
        this.b = builder.a;
        this.c = builder.b;
        this.f4118d = builder.f4114d;
        this.f4119e = builder.f4115e;
        this.f4120f = builder.f4116f;
        this.f4121g = builder.f4117g;
    }
}
