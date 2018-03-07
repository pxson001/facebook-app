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
import com.facebook.graphql.deserializers.GraphQLPhrasesAnalysisItemsConnectionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: WHEN %1$s THEN ? */
public final class GraphQLPhrasesAnalysisItemsConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLPhrasesAnalysisItemsConnection> CREATOR = new C11751();
    public List<GraphQLPhrasesAnalysisItemsEdge> f12589d;

    /* compiled from: WHEN %1$s THEN ? */
    final class C11751 implements Creator<GraphQLPhrasesAnalysisItemsConnection> {
        C11751() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLPhrasesAnalysisItemsConnection(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLPhrasesAnalysisItemsConnection[i];
        }
    }

    /* compiled from: WHEN %1$s THEN ? */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLPhrasesAnalysisItemsConnection.class, new Deserializer());
        }

        public Object m20809a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLPhrasesAnalysisItemsConnectionDeserializer.m5633a(jsonParser, (short) 483);
            Object graphQLPhrasesAnalysisItemsConnection = new GraphQLPhrasesAnalysisItemsConnection();
            ((BaseModel) graphQLPhrasesAnalysisItemsConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLPhrasesAnalysisItemsConnection instanceof Postprocessable) {
                return ((Postprocessable) graphQLPhrasesAnalysisItemsConnection).a();
            }
            return graphQLPhrasesAnalysisItemsConnection;
        }
    }

    /* compiled from: WHEN %1$s THEN ? */
    public final class Serializer extends JsonSerializer<GraphQLPhrasesAnalysisItemsConnection> {
        public final void m20810a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLPhrasesAnalysisItemsConnection graphQLPhrasesAnalysisItemsConnection = (GraphQLPhrasesAnalysisItemsConnection) obj;
            GraphQLPhrasesAnalysisItemsConnectionDeserializer.m5634a(graphQLPhrasesAnalysisItemsConnection.w_(), graphQLPhrasesAnalysisItemsConnection.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLPhrasesAnalysisItemsConnection.class, new Serializer());
            FbSerializerProvider.a(GraphQLPhrasesAnalysisItemsConnection.class, new Serializer());
        }
    }

    @FieldOffset
    public final ImmutableList<GraphQLPhrasesAnalysisItemsEdge> m20813a() {
        this.f12589d = super.a(this.f12589d, 0, GraphQLPhrasesAnalysisItemsEdge.class);
        return (ImmutableList) this.f12589d;
    }

    public final int jK_() {
        return -1226941912;
    }

    public final GraphQLVisitableModel m20812a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m20813a() != null) {
            Builder a = ModelHelper.a(m20813a(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLPhrasesAnalysisItemsConnection) ModelHelper.a(null, this);
                graphQLVisitableModel.f12589d = a.b();
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLPhrasesAnalysisItemsConnection() {
        super(2);
    }

    public final int m20811a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m20813a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLPhrasesAnalysisItemsConnection(Parcel parcel) {
        super(2);
        this.f12589d = ImmutableListHelper.a(parcel.readArrayList(GraphQLPhrasesAnalysisItemsEdge.class.getClassLoader()));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m20813a());
    }
}
