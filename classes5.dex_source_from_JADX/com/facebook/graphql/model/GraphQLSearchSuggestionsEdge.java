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
import com.facebook.graphql.deserializers.GraphQLSearchSuggestionsEdgeDeserializer;
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
/* compiled from: VERTEX_INLINE_CARD */
public final class GraphQLSearchSuggestionsEdge extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLSearchSuggestionsEdge> CREATOR = new C12221();
    @Nullable
    String f13017d;
    @Nullable
    GraphQLSearchSuggestionUnit f13018e;
    @Nullable
    String f13019f;

    /* compiled from: VERTEX_INLINE_CARD */
    final class C12221 implements Creator<GraphQLSearchSuggestionsEdge> {
        C12221() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLSearchSuggestionsEdge(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLSearchSuggestionsEdge[i];
        }
    }

    /* compiled from: VERTEX_INLINE_CARD */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLSearchSuggestionsEdge.class, new Deserializer());
        }

        public Object m21617a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLSearchSuggestionsEdgeDeserializer.m5875a(jsonParser, (short) 491);
            Object graphQLSearchSuggestionsEdge = new GraphQLSearchSuggestionsEdge();
            ((BaseModel) graphQLSearchSuggestionsEdge).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLSearchSuggestionsEdge instanceof Postprocessable) {
                return ((Postprocessable) graphQLSearchSuggestionsEdge).a();
            }
            return graphQLSearchSuggestionsEdge;
        }
    }

    /* compiled from: VERTEX_INLINE_CARD */
    public final class Serializer extends JsonSerializer<GraphQLSearchSuggestionsEdge> {
        public final void m21618a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLSearchSuggestionsEdge graphQLSearchSuggestionsEdge = (GraphQLSearchSuggestionsEdge) obj;
            GraphQLSearchSuggestionsEdgeDeserializer.m5876b(graphQLSearchSuggestionsEdge.w_(), graphQLSearchSuggestionsEdge.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLSearchSuggestionsEdge.class, new Serializer());
            FbSerializerProvider.a(GraphQLSearchSuggestionsEdge.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final String m21621a() {
        this.f13017d = super.a(this.f13017d, 0);
        return this.f13017d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLSearchSuggestionUnit m21622j() {
        this.f13018e = (GraphQLSearchSuggestionUnit) super.a(this.f13018e, 1, GraphQLSearchSuggestionUnit.class);
        return this.f13018e;
    }

    @FieldOffset
    @Nullable
    public final String m21623k() {
        this.f13019f = super.a(this.f13019f, 2);
        return this.f13019f;
    }

    public final int jK_() {
        return 657450596;
    }

    public final GraphQLVisitableModel m21620a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m21622j() != null) {
            GraphQLSearchSuggestionUnit graphQLSearchSuggestionUnit = (GraphQLSearchSuggestionUnit) graphQLModelMutatingVisitor.b(m21622j());
            if (m21622j() != graphQLSearchSuggestionUnit) {
                graphQLVisitableModel = (GraphQLSearchSuggestionsEdge) ModelHelper.a(null, this);
                graphQLVisitableModel.f13018e = graphQLSearchSuggestionUnit;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLSearchSuggestionsEdge() {
        super(4);
    }

    public final int m21619a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m21621a());
        int a = ModelHelper.a(flatBufferBuilder, m21622j());
        int b2 = flatBufferBuilder.b(m21623k());
        flatBufferBuilder.c(3);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, a);
        flatBufferBuilder.b(2, b2);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLSearchSuggestionsEdge(Parcel parcel) {
        super(4);
        this.f13017d = parcel.readString();
        this.f13018e = (GraphQLSearchSuggestionUnit) parcel.readValue(GraphQLSearchSuggestionUnit.class.getClassLoader());
        this.f13019f = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m21621a());
        parcel.writeValue(m21622j());
        parcel.writeString(m21623k());
    }
}
