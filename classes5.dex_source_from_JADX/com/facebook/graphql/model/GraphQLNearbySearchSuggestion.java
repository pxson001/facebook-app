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
import com.facebook.graphql.deserializers.GraphQLNearbySearchSuggestionDeserializer;
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
/* compiled from: experimentName */
public final class GraphQLNearbySearchSuggestion extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLNearbySearchSuggestion> CREATOR = new C04451();
    @Nullable
    public GraphQLGeoRectangle f4543d;
    @Nullable
    public GraphQLTextWithEntities f4544e;
    @Nullable
    public GraphQLTextWithEntities f4545f;
    @Nullable
    public GraphQLPage f4546g;

    /* compiled from: experimentName */
    final class C04451 implements Creator<GraphQLNearbySearchSuggestion> {
        C04451() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLNearbySearchSuggestion(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLNearbySearchSuggestion[i];
        }
    }

    /* compiled from: experimentName */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLNearbySearchSuggestion.class, new Deserializer());
        }

        public Object m9221a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLNearbySearchSuggestionDeserializer.m5410a(jsonParser, (short) 444);
            Object graphQLNearbySearchSuggestion = new GraphQLNearbySearchSuggestion();
            ((BaseModel) graphQLNearbySearchSuggestion).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLNearbySearchSuggestion instanceof Postprocessable) {
                return ((Postprocessable) graphQLNearbySearchSuggestion).a();
            }
            return graphQLNearbySearchSuggestion;
        }
    }

    /* compiled from: experimentName */
    public final class Serializer extends JsonSerializer<GraphQLNearbySearchSuggestion> {
        public final void m9222a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLNearbySearchSuggestion graphQLNearbySearchSuggestion = (GraphQLNearbySearchSuggestion) obj;
            GraphQLNearbySearchSuggestionDeserializer.m5411a(graphQLNearbySearchSuggestion.w_(), graphQLNearbySearchSuggestion.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLNearbySearchSuggestion.class, new Serializer());
            FbSerializerProvider.a(GraphQLNearbySearchSuggestion.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLGeoRectangle m9224a() {
        this.f4543d = (GraphQLGeoRectangle) super.a(this.f4543d, 0, GraphQLGeoRectangle.class);
        return this.f4543d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m9226j() {
        this.f4544e = (GraphQLTextWithEntities) super.a(this.f4544e, 1, GraphQLTextWithEntities.class);
        return this.f4544e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m9227k() {
        this.f4545f = (GraphQLTextWithEntities) super.a(this.f4545f, 2, GraphQLTextWithEntities.class);
        return this.f4545f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPage m9228l() {
        this.f4546g = (GraphQLPage) super.a(this.f4546g, 3, GraphQLPage.class);
        return this.f4546g;
    }

    public final int jK_() {
        return 1165710987;
    }

    public final GraphQLVisitableModel m9225a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLTextWithEntities graphQLTextWithEntities;
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m9224a() != null) {
            GraphQLGeoRectangle graphQLGeoRectangle = (GraphQLGeoRectangle) graphQLModelMutatingVisitor.b(m9224a());
            if (m9224a() != graphQLGeoRectangle) {
                graphQLVisitableModel = (GraphQLNearbySearchSuggestion) ModelHelper.a(null, this);
                graphQLVisitableModel.f4543d = graphQLGeoRectangle;
            }
        }
        if (m9226j() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m9226j());
            if (m9226j() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLNearbySearchSuggestion) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4544e = graphQLTextWithEntities;
            }
        }
        if (m9227k() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m9227k());
            if (m9227k() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLNearbySearchSuggestion) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4545f = graphQLTextWithEntities;
            }
        }
        if (m9228l() != null) {
            GraphQLPage graphQLPage = (GraphQLPage) graphQLModelMutatingVisitor.b(m9228l());
            if (m9228l() != graphQLPage) {
                graphQLVisitableModel = (GraphQLNearbySearchSuggestion) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4546g = graphQLPage;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLNearbySearchSuggestion() {
        super(5);
    }

    public final int m9223a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m9224a());
        int a2 = ModelHelper.a(flatBufferBuilder, m9226j());
        int a3 = ModelHelper.a(flatBufferBuilder, m9227k());
        int a4 = ModelHelper.a(flatBufferBuilder, m9228l());
        flatBufferBuilder.c(4);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, a2);
        flatBufferBuilder.b(2, a3);
        flatBufferBuilder.b(3, a4);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLNearbySearchSuggestion(Parcel parcel) {
        super(5);
        this.f4543d = (GraphQLGeoRectangle) parcel.readValue(GraphQLGeoRectangle.class.getClassLoader());
        this.f4544e = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f4545f = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f4546g = (GraphQLPage) parcel.readValue(GraphQLPage.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m9224a());
        parcel.writeValue(m9226j());
        parcel.writeValue(m9227k());
        parcel.writeValue(m9228l());
    }
}
