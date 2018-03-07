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
import com.facebook.graphql.deserializers.GraphQLAppAdStoriesSideFeedEdgeDeserializer;
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
/* compiled from: iterable must not be null */
public final class GraphQLAppAdStoriesSideFeedEdge extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLAppAdStoriesSideFeedEdge> CREATOR = new C02661();
    @Nullable
    public GraphQLStory f3347d;

    /* compiled from: iterable must not be null */
    final class C02661 implements Creator<GraphQLAppAdStoriesSideFeedEdge> {
        C02661() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLAppAdStoriesSideFeedEdge(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLAppAdStoriesSideFeedEdge[i];
        }
    }

    /* compiled from: iterable must not be null */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLAppAdStoriesSideFeedEdge.class, new Deserializer());
        }

        public Object m6551a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLAppAdStoriesSideFeedEdgeDeserializer.m4568a(jsonParser, (short) 495);
            Object graphQLAppAdStoriesSideFeedEdge = new GraphQLAppAdStoriesSideFeedEdge();
            ((BaseModel) graphQLAppAdStoriesSideFeedEdge).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLAppAdStoriesSideFeedEdge instanceof Postprocessable) {
                return ((Postprocessable) graphQLAppAdStoriesSideFeedEdge).a();
            }
            return graphQLAppAdStoriesSideFeedEdge;
        }
    }

    /* compiled from: iterable must not be null */
    public final class Serializer extends JsonSerializer<GraphQLAppAdStoriesSideFeedEdge> {
        public final void m6552a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLAppAdStoriesSideFeedEdge graphQLAppAdStoriesSideFeedEdge = (GraphQLAppAdStoriesSideFeedEdge) obj;
            GraphQLAppAdStoriesSideFeedEdgeDeserializer.m4569b(graphQLAppAdStoriesSideFeedEdge.w_(), graphQLAppAdStoriesSideFeedEdge.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLAppAdStoriesSideFeedEdge.class, new Serializer());
            FbSerializerProvider.a(GraphQLAppAdStoriesSideFeedEdge.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLStory m6554a() {
        this.f3347d = (GraphQLStory) super.a(this.f3347d, 0, GraphQLStory.class);
        return this.f3347d;
    }

    public final int jK_() {
        return -1200593343;
    }

    public final GraphQLVisitableModel m6555a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m6554a() != null) {
            GraphQLStory graphQLStory = (GraphQLStory) graphQLModelMutatingVisitor.b(m6554a());
            if (m6554a() != graphQLStory) {
                graphQLVisitableModel = (GraphQLAppAdStoriesSideFeedEdge) ModelHelper.a(null, this);
                graphQLVisitableModel.f3347d = graphQLStory;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLAppAdStoriesSideFeedEdge() {
        super(2);
    }

    public final int m6553a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m6554a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLAppAdStoriesSideFeedEdge(Parcel parcel) {
        super(2);
        this.f3347d = (GraphQLStory) parcel.readValue(GraphQLStory.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m6554a());
    }
}
