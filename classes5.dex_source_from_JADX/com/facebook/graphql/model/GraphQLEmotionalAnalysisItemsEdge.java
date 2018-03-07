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
import com.facebook.graphql.deserializers.GraphQLEmotionalAnalysisItemsEdgeDeserializer;
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
/* compiled from: invite_details */
public final class GraphQLEmotionalAnalysisItemsEdge extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLEmotionalAnalysisItemsEdge> CREATOR = new C02991();
    @Nullable
    public GraphQLEmotionalAnalysisItem f3529d;

    /* compiled from: invite_details */
    final class C02991 implements Creator<GraphQLEmotionalAnalysisItemsEdge> {
        C02991() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLEmotionalAnalysisItemsEdge(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLEmotionalAnalysisItemsEdge[i];
        }
    }

    /* compiled from: invite_details */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLEmotionalAnalysisItemsEdge.class, new Deserializer());
        }

        public Object m7025a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLEmotionalAnalysisItemsEdgeDeserializer.m4744a(jsonParser, (short) 480);
            Object graphQLEmotionalAnalysisItemsEdge = new GraphQLEmotionalAnalysisItemsEdge();
            ((BaseModel) graphQLEmotionalAnalysisItemsEdge).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLEmotionalAnalysisItemsEdge instanceof Postprocessable) {
                return ((Postprocessable) graphQLEmotionalAnalysisItemsEdge).a();
            }
            return graphQLEmotionalAnalysisItemsEdge;
        }
    }

    /* compiled from: invite_details */
    public final class Serializer extends JsonSerializer<GraphQLEmotionalAnalysisItemsEdge> {
        public final void m7026a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLEmotionalAnalysisItemsEdge graphQLEmotionalAnalysisItemsEdge = (GraphQLEmotionalAnalysisItemsEdge) obj;
            GraphQLEmotionalAnalysisItemsEdgeDeserializer.m4745b(graphQLEmotionalAnalysisItemsEdge.w_(), graphQLEmotionalAnalysisItemsEdge.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLEmotionalAnalysisItemsEdge.class, new Serializer());
            FbSerializerProvider.a(GraphQLEmotionalAnalysisItemsEdge.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLEmotionalAnalysisItem m7028a() {
        this.f3529d = (GraphQLEmotionalAnalysisItem) super.a(this.f3529d, 0, GraphQLEmotionalAnalysisItem.class);
        return this.f3529d;
    }

    public final int jK_() {
        return 1727769883;
    }

    public final GraphQLVisitableModel m7029a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m7028a() != null) {
            GraphQLEmotionalAnalysisItem graphQLEmotionalAnalysisItem = (GraphQLEmotionalAnalysisItem) graphQLModelMutatingVisitor.b(m7028a());
            if (m7028a() != graphQLEmotionalAnalysisItem) {
                graphQLVisitableModel = (GraphQLEmotionalAnalysisItemsEdge) ModelHelper.a(null, this);
                graphQLVisitableModel.f3529d = graphQLEmotionalAnalysisItem;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLEmotionalAnalysisItemsEdge() {
        super(2);
    }

    public final int m7027a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m7028a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLEmotionalAnalysisItemsEdge(Parcel parcel) {
        super(2);
        this.f3529d = (GraphQLEmotionalAnalysisItem) parcel.readValue(GraphQLEmotionalAnalysisItem.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m7028a());
    }
}
