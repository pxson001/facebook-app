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
import com.facebook.graphql.deserializers.GraphQLSouvenirDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
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
/* compiled from: Use FbHttpRequest and FbHttpRequestProcessor instead */
public final class GraphQLSouvenir extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLSouvenir> CREATOR = new C12281();
    @Nullable
    GraphQLStory f13026d;
    @Nullable
    String f13027e;
    @Nullable
    String f13028f;
    @Nullable
    GraphQLSouvenirMediaConnection f13029g;
    @Nullable
    GraphQLPhoto f13030h;
    @Nullable
    GraphQLTextWithEntities f13031i;
    @Nullable
    GraphQLTextWithEntities f13032j;
    @Nullable
    String f13033k;

    /* compiled from: Use FbHttpRequest and FbHttpRequestProcessor instead */
    final class C12281 implements Creator<GraphQLSouvenir> {
        C12281() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLSouvenir(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLSouvenir[i];
        }
    }

    /* compiled from: Use FbHttpRequest and FbHttpRequestProcessor instead */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLSouvenir.class, new Deserializer());
        }

        public Object m21688a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLSouvenirDeserializer.m5904a(jsonParser, (short) 100);
            Object graphQLSouvenir = new GraphQLSouvenir();
            ((BaseModel) graphQLSouvenir).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLSouvenir instanceof Postprocessable) {
                return ((Postprocessable) graphQLSouvenir).a();
            }
            return graphQLSouvenir;
        }
    }

    /* compiled from: Use FbHttpRequest and FbHttpRequestProcessor instead */
    public final class Serializer extends JsonSerializer<GraphQLSouvenir> {
        public final void m21689a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLSouvenir graphQLSouvenir = (GraphQLSouvenir) obj;
            GraphQLSouvenirDeserializer.m5905a(graphQLSouvenir.w_(), graphQLSouvenir.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLSouvenir.class, new Serializer());
            FbSerializerProvider.a(GraphQLSouvenir.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLStory m21693j() {
        this.f13026d = (GraphQLStory) super.a(this.f13026d, 0, GraphQLStory.class);
        return this.f13026d;
    }

    @FieldOffset
    @Nullable
    public final String m21694k() {
        this.f13027e = super.a(this.f13027e, 1);
        return this.f13027e;
    }

    @FieldOffset
    @Nullable
    public final String m21695l() {
        this.f13028f = super.a(this.f13028f, 2);
        return this.f13028f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLSouvenirMediaConnection m21696m() {
        this.f13029g = (GraphQLSouvenirMediaConnection) super.a(this.f13029g, 3, GraphQLSouvenirMediaConnection.class);
        return this.f13029g;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPhoto m21697n() {
        this.f13030h = (GraphQLPhoto) super.a(this.f13030h, 5, GraphQLPhoto.class);
        return this.f13030h;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m21698o() {
        this.f13031i = (GraphQLTextWithEntities) super.a(this.f13031i, 6, GraphQLTextWithEntities.class);
        return this.f13031i;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m21699p() {
        this.f13032j = (GraphQLTextWithEntities) super.a(this.f13032j, 7, GraphQLTextWithEntities.class);
        return this.f13032j;
    }

    @FieldOffset
    @Nullable
    public final String m21700q() {
        this.f13033k = super.a(this.f13033k, 8);
        return this.f13033k;
    }

    @Nullable
    public final String m21692a() {
        return m21695l();
    }

    public final int jK_() {
        return 1814734639;
    }

    public final GraphQLVisitableModel m21691a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLTextWithEntities graphQLTextWithEntities;
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m21693j() != null) {
            GraphQLStory graphQLStory = (GraphQLStory) graphQLModelMutatingVisitor.b(m21693j());
            if (m21693j() != graphQLStory) {
                graphQLVisitableModel = (GraphQLSouvenir) ModelHelper.a(null, this);
                graphQLVisitableModel.f13026d = graphQLStory;
            }
        }
        if (m21696m() != null) {
            GraphQLSouvenirMediaConnection graphQLSouvenirMediaConnection = (GraphQLSouvenirMediaConnection) graphQLModelMutatingVisitor.b(m21696m());
            if (m21696m() != graphQLSouvenirMediaConnection) {
                graphQLVisitableModel = (GraphQLSouvenir) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f13029g = graphQLSouvenirMediaConnection;
            }
        }
        if (m21697n() != null) {
            GraphQLPhoto graphQLPhoto = (GraphQLPhoto) graphQLModelMutatingVisitor.b(m21697n());
            if (m21697n() != graphQLPhoto) {
                graphQLVisitableModel = (GraphQLSouvenir) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f13030h = graphQLPhoto;
            }
        }
        if (m21698o() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m21698o());
            if (m21698o() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLSouvenir) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f13031i = graphQLTextWithEntities;
            }
        }
        if (m21699p() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m21699p());
            if (m21699p() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLSouvenir) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f13032j = graphQLTextWithEntities;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLSouvenir() {
        super(10);
    }

    public final int m21690a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m21693j());
        int b = flatBufferBuilder.b(m21694k());
        int b2 = flatBufferBuilder.b(m21695l());
        int a2 = ModelHelper.a(flatBufferBuilder, m21696m());
        int a3 = ModelHelper.a(flatBufferBuilder, m21697n());
        int a4 = ModelHelper.a(flatBufferBuilder, m21698o());
        int a5 = ModelHelper.a(flatBufferBuilder, m21699p());
        int b3 = flatBufferBuilder.b(m21700q());
        flatBufferBuilder.c(9);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, b);
        flatBufferBuilder.b(2, b2);
        flatBufferBuilder.b(3, a2);
        flatBufferBuilder.b(5, a3);
        flatBufferBuilder.b(6, a4);
        flatBufferBuilder.b(7, a5);
        flatBufferBuilder.b(8, b3);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLSouvenir(Parcel parcel) {
        super(10);
        this.f13026d = (GraphQLStory) parcel.readValue(GraphQLStory.class.getClassLoader());
        this.f13027e = parcel.readString();
        this.f13028f = parcel.readString();
        this.f13029g = (GraphQLSouvenirMediaConnection) parcel.readValue(GraphQLSouvenirMediaConnection.class.getClassLoader());
        this.f13030h = (GraphQLPhoto) parcel.readValue(GraphQLPhoto.class.getClassLoader());
        this.f13031i = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f13032j = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f13033k = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m21693j());
        parcel.writeString(m21694k());
        parcel.writeString(m21695l());
        parcel.writeValue(m21696m());
        parcel.writeValue(m21697n());
        parcel.writeValue(m21698o());
        parcel.writeValue(m21699p());
        parcel.writeString(m21700q());
    }
}
