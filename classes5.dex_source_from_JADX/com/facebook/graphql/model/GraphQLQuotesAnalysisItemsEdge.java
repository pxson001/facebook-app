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
import com.facebook.graphql.deserializers.GraphQLQuotesAnalysisItemsEdgeDeserializer;
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
/* compiled from: VIEW_EVENTS_DASHBOARD */
public final class GraphQLQuotesAnalysisItemsEdge extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLQuotesAnalysisItemsEdge> CREATOR = new C12011();
    @Nullable
    public GraphQLQuotesAnalysisItem f12880d;

    /* compiled from: VIEW_EVENTS_DASHBOARD */
    final class C12011 implements Creator<GraphQLQuotesAnalysisItemsEdge> {
        C12011() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLQuotesAnalysisItemsEdge(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLQuotesAnalysisItemsEdge[i];
        }
    }

    /* compiled from: VIEW_EVENTS_DASHBOARD */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLQuotesAnalysisItemsEdge.class, new Deserializer());
        }

        public Object m21292a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLQuotesAnalysisItemsEdgeDeserializer.m5776a(jsonParser, (short) 487);
            Object graphQLQuotesAnalysisItemsEdge = new GraphQLQuotesAnalysisItemsEdge();
            ((BaseModel) graphQLQuotesAnalysisItemsEdge).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLQuotesAnalysisItemsEdge instanceof Postprocessable) {
                return ((Postprocessable) graphQLQuotesAnalysisItemsEdge).a();
            }
            return graphQLQuotesAnalysisItemsEdge;
        }
    }

    /* compiled from: VIEW_EVENTS_DASHBOARD */
    public final class Serializer extends JsonSerializer<GraphQLQuotesAnalysisItemsEdge> {
        public final void m21293a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLQuotesAnalysisItemsEdge graphQLQuotesAnalysisItemsEdge = (GraphQLQuotesAnalysisItemsEdge) obj;
            GraphQLQuotesAnalysisItemsEdgeDeserializer.m5777b(graphQLQuotesAnalysisItemsEdge.w_(), graphQLQuotesAnalysisItemsEdge.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLQuotesAnalysisItemsEdge.class, new Serializer());
            FbSerializerProvider.a(GraphQLQuotesAnalysisItemsEdge.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLQuotesAnalysisItem m21295a() {
        this.f12880d = (GraphQLQuotesAnalysisItem) super.a(this.f12880d, 0, GraphQLQuotesAnalysisItem.class);
        return this.f12880d;
    }

    public final int jK_() {
        return -2011623094;
    }

    public final GraphQLVisitableModel m21296a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m21295a() != null) {
            GraphQLQuotesAnalysisItem graphQLQuotesAnalysisItem = (GraphQLQuotesAnalysisItem) graphQLModelMutatingVisitor.b(m21295a());
            if (m21295a() != graphQLQuotesAnalysisItem) {
                graphQLVisitableModel = (GraphQLQuotesAnalysisItemsEdge) ModelHelper.a(null, this);
                graphQLVisitableModel.f12880d = graphQLQuotesAnalysisItem;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLQuotesAnalysisItemsEdge() {
        super(2);
    }

    public final int m21294a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m21295a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLQuotesAnalysisItemsEdge(Parcel parcel) {
        super(2);
        this.f12880d = (GraphQLQuotesAnalysisItem) parcel.readValue(GraphQLQuotesAnalysisItem.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m21295a());
    }
}
