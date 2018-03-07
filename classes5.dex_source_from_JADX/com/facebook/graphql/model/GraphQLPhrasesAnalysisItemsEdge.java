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
import com.facebook.graphql.deserializers.GraphQLPhrasesAnalysisItemsEdgeDeserializer;
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
/* compiled from: WELCOME_FEED_OUTGOING_UNIT */
public final class GraphQLPhrasesAnalysisItemsEdge extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLPhrasesAnalysisItemsEdge> CREATOR = new C11761();
    @Nullable
    public GraphQLPhrasesAnalysisItem f12590d;

    /* compiled from: WELCOME_FEED_OUTGOING_UNIT */
    final class C11761 implements Creator<GraphQLPhrasesAnalysisItemsEdge> {
        C11761() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLPhrasesAnalysisItemsEdge(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLPhrasesAnalysisItemsEdge[i];
        }
    }

    /* compiled from: WELCOME_FEED_OUTGOING_UNIT */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLPhrasesAnalysisItemsEdge.class, new Deserializer());
        }

        public Object m20818a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLPhrasesAnalysisItemsEdgeDeserializer.m5636a(jsonParser, (short) 484);
            Object graphQLPhrasesAnalysisItemsEdge = new GraphQLPhrasesAnalysisItemsEdge();
            ((BaseModel) graphQLPhrasesAnalysisItemsEdge).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLPhrasesAnalysisItemsEdge instanceof Postprocessable) {
                return ((Postprocessable) graphQLPhrasesAnalysisItemsEdge).a();
            }
            return graphQLPhrasesAnalysisItemsEdge;
        }
    }

    /* compiled from: WELCOME_FEED_OUTGOING_UNIT */
    public final class Serializer extends JsonSerializer<GraphQLPhrasesAnalysisItemsEdge> {
        public final void m20819a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLPhrasesAnalysisItemsEdge graphQLPhrasesAnalysisItemsEdge = (GraphQLPhrasesAnalysisItemsEdge) obj;
            GraphQLPhrasesAnalysisItemsEdgeDeserializer.m5637b(graphQLPhrasesAnalysisItemsEdge.w_(), graphQLPhrasesAnalysisItemsEdge.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLPhrasesAnalysisItemsEdge.class, new Serializer());
            FbSerializerProvider.a(GraphQLPhrasesAnalysisItemsEdge.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLPhrasesAnalysisItem m20821a() {
        this.f12590d = (GraphQLPhrasesAnalysisItem) super.a(this.f12590d, 0, GraphQLPhrasesAnalysisItem.class);
        return this.f12590d;
    }

    public final int jK_() {
        return -948303737;
    }

    public final GraphQLVisitableModel m20822a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m20821a() != null) {
            GraphQLPhrasesAnalysisItem graphQLPhrasesAnalysisItem = (GraphQLPhrasesAnalysisItem) graphQLModelMutatingVisitor.b(m20821a());
            if (m20821a() != graphQLPhrasesAnalysisItem) {
                graphQLVisitableModel = (GraphQLPhrasesAnalysisItemsEdge) ModelHelper.a(null, this);
                graphQLVisitableModel.f12590d = graphQLPhrasesAnalysisItem;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLPhrasesAnalysisItemsEdge() {
        super(2);
    }

    public final int m20820a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m20821a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLPhrasesAnalysisItemsEdge(Parcel parcel) {
        super(2);
        this.f12590d = (GraphQLPhrasesAnalysisItem) parcel.readValue(GraphQLPhrasesAnalysisItem.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m20821a());
    }
}
