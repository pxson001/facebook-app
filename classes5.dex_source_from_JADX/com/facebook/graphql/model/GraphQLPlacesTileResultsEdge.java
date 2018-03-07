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
import com.facebook.graphql.deserializers.GraphQLPlacesTileResultsEdgeDeserializer;
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
/* compiled from: WAREHOUSE */
public final class GraphQLPlacesTileResultsEdge extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLPlacesTileResultsEdge> CREATOR = new C11831();
    @Nullable
    GraphQLPage f12671d;
    @Nullable
    GraphQLGraphSearchResultDecoration f12672e;
    double f12673f;
    @Nullable
    GraphQLTextWithEntities f12674g;

    /* compiled from: WAREHOUSE */
    final class C11831 implements Creator<GraphQLPlacesTileResultsEdge> {
        C11831() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLPlacesTileResultsEdge(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLPlacesTileResultsEdge[i];
        }
    }

    /* compiled from: WAREHOUSE */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLPlacesTileResultsEdge.class, new Deserializer());
        }

        public Object m20931a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLPlacesTileResultsEdgeDeserializer.m5677a(jsonParser, (short) 441);
            Object graphQLPlacesTileResultsEdge = new GraphQLPlacesTileResultsEdge();
            ((BaseModel) graphQLPlacesTileResultsEdge).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLPlacesTileResultsEdge instanceof Postprocessable) {
                return ((Postprocessable) graphQLPlacesTileResultsEdge).a();
            }
            return graphQLPlacesTileResultsEdge;
        }
    }

    /* compiled from: WAREHOUSE */
    public final class Serializer extends JsonSerializer<GraphQLPlacesTileResultsEdge> {
        public final void m20932a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLPlacesTileResultsEdge graphQLPlacesTileResultsEdge = (GraphQLPlacesTileResultsEdge) obj;
            GraphQLPlacesTileResultsEdgeDeserializer.m5678b(graphQLPlacesTileResultsEdge.w_(), graphQLPlacesTileResultsEdge.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLPlacesTileResultsEdge.class, new Serializer());
            FbSerializerProvider.a(GraphQLPlacesTileResultsEdge.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLPage m20934a() {
        this.f12671d = (GraphQLPage) super.a(this.f12671d, 0, GraphQLPage.class);
        return this.f12671d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLGraphSearchResultDecoration m20937j() {
        this.f12672e = (GraphQLGraphSearchResultDecoration) super.a(this.f12672e, 1, GraphQLGraphSearchResultDecoration.class);
        return this.f12672e;
    }

    @FieldOffset
    public final double m20938k() {
        a(0, 2);
        return this.f12673f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m20939l() {
        this.f12674g = (GraphQLTextWithEntities) super.a(this.f12674g, 3, GraphQLTextWithEntities.class);
        return this.f12674g;
    }

    public final int jK_() {
        return -833204935;
    }

    public final GraphQLVisitableModel m20935a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m20934a() != null) {
            GraphQLPage graphQLPage = (GraphQLPage) graphQLModelMutatingVisitor.b(m20934a());
            if (m20934a() != graphQLPage) {
                graphQLVisitableModel = (GraphQLPlacesTileResultsEdge) ModelHelper.a(null, this);
                graphQLVisitableModel.f12671d = graphQLPage;
            }
        }
        if (m20937j() != null) {
            GraphQLGraphSearchResultDecoration graphQLGraphSearchResultDecoration = (GraphQLGraphSearchResultDecoration) graphQLModelMutatingVisitor.b(m20937j());
            if (m20937j() != graphQLGraphSearchResultDecoration) {
                graphQLVisitableModel = (GraphQLPlacesTileResultsEdge) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f12672e = graphQLGraphSearchResultDecoration;
            }
        }
        if (m20939l() != null) {
            GraphQLTextWithEntities graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m20939l());
            if (m20939l() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLPlacesTileResultsEdge) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f12674g = graphQLTextWithEntities;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLPlacesTileResultsEdge() {
        super(5);
    }

    public final void m20936a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f12673f = mutableFlatBuffer.a(i, 2, 0.0d);
    }

    public final int m20933a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m20934a());
        int a2 = ModelHelper.a(flatBufferBuilder, m20937j());
        int a3 = ModelHelper.a(flatBufferBuilder, m20939l());
        flatBufferBuilder.c(4);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, a2);
        flatBufferBuilder.a(2, m20938k(), 0.0d);
        flatBufferBuilder.b(3, a3);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLPlacesTileResultsEdge(Parcel parcel) {
        super(5);
        this.f12671d = (GraphQLPage) parcel.readValue(GraphQLPage.class.getClassLoader());
        this.f12672e = (GraphQLGraphSearchResultDecoration) parcel.readValue(GraphQLGraphSearchResultDecoration.class.getClassLoader());
        this.f12673f = parcel.readDouble();
        this.f12674g = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m20934a());
        parcel.writeValue(m20937j());
        parcel.writeDouble(m20938k());
        parcel.writeValue(m20939l());
    }
}
