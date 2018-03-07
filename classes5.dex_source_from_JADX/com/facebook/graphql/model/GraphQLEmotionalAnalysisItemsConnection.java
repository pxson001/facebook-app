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
import com.facebook.graphql.deserializers.GraphQLEmotionalAnalysisItemsConnectionDeserializer;
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
/* compiled from: invite_link_join_bar */
public final class GraphQLEmotionalAnalysisItemsConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLEmotionalAnalysisItemsConnection> CREATOR = new C02981();
    public List<GraphQLEmotionalAnalysisItemsEdge> f3528d;

    /* compiled from: invite_link_join_bar */
    final class C02981 implements Creator<GraphQLEmotionalAnalysisItemsConnection> {
        C02981() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLEmotionalAnalysisItemsConnection(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLEmotionalAnalysisItemsConnection[i];
        }
    }

    /* compiled from: invite_link_join_bar */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLEmotionalAnalysisItemsConnection.class, new Deserializer());
        }

        public Object m7016a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLEmotionalAnalysisItemsConnectionDeserializer.m4741a(jsonParser, (short) 479);
            Object graphQLEmotionalAnalysisItemsConnection = new GraphQLEmotionalAnalysisItemsConnection();
            ((BaseModel) graphQLEmotionalAnalysisItemsConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLEmotionalAnalysisItemsConnection instanceof Postprocessable) {
                return ((Postprocessable) graphQLEmotionalAnalysisItemsConnection).a();
            }
            return graphQLEmotionalAnalysisItemsConnection;
        }
    }

    /* compiled from: invite_link_join_bar */
    public final class Serializer extends JsonSerializer<GraphQLEmotionalAnalysisItemsConnection> {
        public final void m7017a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLEmotionalAnalysisItemsConnection graphQLEmotionalAnalysisItemsConnection = (GraphQLEmotionalAnalysisItemsConnection) obj;
            GraphQLEmotionalAnalysisItemsConnectionDeserializer.m4742a(graphQLEmotionalAnalysisItemsConnection.w_(), graphQLEmotionalAnalysisItemsConnection.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLEmotionalAnalysisItemsConnection.class, new Serializer());
            FbSerializerProvider.a(GraphQLEmotionalAnalysisItemsConnection.class, new Serializer());
        }
    }

    @FieldOffset
    public final ImmutableList<GraphQLEmotionalAnalysisItemsEdge> m7020a() {
        this.f3528d = super.a(this.f3528d, 0, GraphQLEmotionalAnalysisItemsEdge.class);
        return (ImmutableList) this.f3528d;
    }

    public final int jK_() {
        return 78593980;
    }

    public final GraphQLVisitableModel m7019a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m7020a() != null) {
            Builder a = ModelHelper.a(m7020a(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLEmotionalAnalysisItemsConnection) ModelHelper.a(null, this);
                graphQLVisitableModel.f3528d = a.b();
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLEmotionalAnalysisItemsConnection() {
        super(2);
    }

    public final int m7018a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m7020a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLEmotionalAnalysisItemsConnection(Parcel parcel) {
        super(2);
        this.f3528d = ImmutableListHelper.a(parcel.readArrayList(GraphQLEmotionalAnalysisItemsEdge.class.getClassLoader()));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m7020a());
    }
}
