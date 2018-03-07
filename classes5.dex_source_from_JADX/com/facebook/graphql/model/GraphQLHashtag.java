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
import com.facebook.graphql.deserializers.GraphQLHashtagDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ImmutableListHelper;
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
import com.google.common.collect.ImmutableList;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: formatted */
public final class GraphQLHashtag extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLHashtag> CREATOR = new C04101();
    @Nullable
    GraphQLImage f4245A;
    @Nullable
    GraphQLTrendingTopicData f4246B;
    @Nullable
    String f4247C;
    @Nullable
    String f4248D;
    List<String> f4249d;
    @Nullable
    GraphQLImage f4250e;
    @Nullable
    GraphQLHashtagFeedConnection f4251f;
    @Nullable
    String f4252g;
    @Nullable
    GraphQLImage f4253h;
    @Nullable
    GraphQLImage f4254i;
    @Deprecated
    @Nullable
    GraphQLInlineActivitiesConnection f4255j;
    @Nullable
    String f4256k;
    List<String> f4257l;
    @Nullable
    GraphQLImage f4258m;
    @Nullable
    GraphQLImage f4259n;
    @Nullable
    GraphQLImage f4260o;
    @Nullable
    GraphQLImage f4261p;
    @Nullable
    GraphQLImage f4262q;
    @Nullable
    GraphQLPhoto f4263r;
    @Nullable
    GraphQLImage f4264s;
    boolean f4265t;
    @Nullable
    String f4266u;
    @Nullable
    GraphQLTextWithEntities f4267v;
    @Nullable
    GraphQLStreamingImage f4268w;
    @Nullable
    String f4269x;
    @Nullable
    GraphQLImage f4270y;
    @Nullable
    GraphQLNode f4271z;

    /* compiled from: formatted */
    final class C04101 implements Creator<GraphQLHashtag> {
        C04101() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLHashtag(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLHashtag[i];
        }
    }

    /* compiled from: formatted */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLHashtag.class, new Deserializer());
        }

        public Object m8560a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLHashtagDeserializer.m5211a(jsonParser, (short) 59);
            Object graphQLHashtag = new GraphQLHashtag();
            ((BaseModel) graphQLHashtag).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLHashtag instanceof Postprocessable) {
                return ((Postprocessable) graphQLHashtag).a();
            }
            return graphQLHashtag;
        }
    }

    /* compiled from: formatted */
    public final class Serializer extends JsonSerializer<GraphQLHashtag> {
        public final void m8561a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLHashtag graphQLHashtag = (GraphQLHashtag) obj;
            GraphQLHashtagDeserializer.m5212a(graphQLHashtag.w_(), graphQLHashtag.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLHashtag.class, new Serializer());
            FbSerializerProvider.a(GraphQLHashtag.class, new Serializer());
        }
    }

    @FieldOffset
    public final ImmutableList<String> m8576j() {
        this.f4249d = super.a(this.f4249d, 0);
        return (ImmutableList) this.f4249d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m8577k() {
        this.f4250e = (GraphQLImage) super.a(this.f4250e, 1, GraphQLImage.class);
        return this.f4250e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLHashtagFeedConnection m8578l() {
        this.f4251f = (GraphQLHashtagFeedConnection) super.a(this.f4251f, 2, GraphQLHashtagFeedConnection.class);
        return this.f4251f;
    }

    @FieldOffset
    @Nullable
    public final String m8579m() {
        this.f4252g = super.a(this.f4252g, 3);
        return this.f4252g;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m8580n() {
        this.f4253h = (GraphQLImage) super.a(this.f4253h, 4, GraphQLImage.class);
        return this.f4253h;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m8581o() {
        this.f4254i = (GraphQLImage) super.a(this.f4254i, 5, GraphQLImage.class);
        return this.f4254i;
    }

    @FieldOffset
    @Nullable
    public final GraphQLInlineActivitiesConnection m8582p() {
        this.f4255j = (GraphQLInlineActivitiesConnection) super.a(this.f4255j, 6, GraphQLInlineActivitiesConnection.class);
        return this.f4255j;
    }

    @FieldOffset
    @Nullable
    public final String m8583q() {
        this.f4256k = super.a(this.f4256k, 7);
        return this.f4256k;
    }

    @FieldOffset
    public final ImmutableList<String> m8584r() {
        this.f4257l = super.a(this.f4257l, 8);
        return (ImmutableList) this.f4257l;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m8585s() {
        this.f4258m = (GraphQLImage) super.a(this.f4258m, 9, GraphQLImage.class);
        return this.f4258m;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m8586t() {
        this.f4259n = (GraphQLImage) super.a(this.f4259n, 10, GraphQLImage.class);
        return this.f4259n;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m8587u() {
        this.f4260o = (GraphQLImage) super.a(this.f4260o, 11, GraphQLImage.class);
        return this.f4260o;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m8588v() {
        this.f4261p = (GraphQLImage) super.a(this.f4261p, 12, GraphQLImage.class);
        return this.f4261p;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m8589w() {
        this.f4262q = (GraphQLImage) super.a(this.f4262q, 13, GraphQLImage.class);
        return this.f4262q;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPhoto m8590x() {
        this.f4263r = (GraphQLPhoto) super.a(this.f4263r, 14, GraphQLPhoto.class);
        return this.f4263r;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m8591y() {
        this.f4264s = (GraphQLImage) super.a(this.f4264s, 15, GraphQLImage.class);
        return this.f4264s;
    }

    @FieldOffset
    public final boolean m8592z() {
        a(2, 0);
        return this.f4265t;
    }

    @FieldOffset
    @Nullable
    public final String m8562A() {
        this.f4266u = super.a(this.f4266u, 17);
        return this.f4266u;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m8563B() {
        this.f4267v = (GraphQLTextWithEntities) super.a(this.f4267v, 18, GraphQLTextWithEntities.class);
        return this.f4267v;
    }

    @FieldOffset
    @Nullable
    public final GraphQLStreamingImage m8564C() {
        this.f4268w = (GraphQLStreamingImage) super.a(this.f4268w, 19, GraphQLStreamingImage.class);
        return this.f4268w;
    }

    @FieldOffset
    @Nullable
    public final String m8565D() {
        this.f4269x = super.a(this.f4269x, 20);
        return this.f4269x;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m8566E() {
        this.f4270y = (GraphQLImage) super.a(this.f4270y, 21, GraphQLImage.class);
        return this.f4270y;
    }

    @FieldOffset
    @Nullable
    public final GraphQLNode m8567F() {
        this.f4271z = (GraphQLNode) super.a(this.f4271z, 22, GraphQLNode.class);
        return this.f4271z;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m8568G() {
        this.f4245A = (GraphQLImage) super.a(this.f4245A, 23, GraphQLImage.class);
        return this.f4245A;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTrendingTopicData m8569H() {
        this.f4246B = (GraphQLTrendingTopicData) super.a(this.f4246B, 24, GraphQLTrendingTopicData.class);
        return this.f4246B;
    }

    @FieldOffset
    @Nullable
    public final String m8570I() {
        this.f4247C = super.a(this.f4247C, 25);
        return this.f4247C;
    }

    @FieldOffset
    @Nullable
    public final String m8571J() {
        this.f4248D = super.a(this.f4248D, 26);
        return this.f4248D;
    }

    @Nullable
    public final String m8574a() {
        return m8579m();
    }

    public final int jK_() {
        return -1932766292;
    }

    public final GraphQLVisitableModel m8573a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLImage graphQLImage;
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m8577k() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m8577k());
            if (m8577k() != graphQLImage) {
                graphQLVisitableModel = (GraphQLHashtag) ModelHelper.a(null, this);
                graphQLVisitableModel.f4250e = graphQLImage;
            }
        }
        if (m8578l() != null) {
            GraphQLHashtagFeedConnection graphQLHashtagFeedConnection = (GraphQLHashtagFeedConnection) graphQLModelMutatingVisitor.b(m8578l());
            if (m8578l() != graphQLHashtagFeedConnection) {
                graphQLVisitableModel = (GraphQLHashtag) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4251f = graphQLHashtagFeedConnection;
            }
        }
        if (m8580n() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m8580n());
            if (m8580n() != graphQLImage) {
                graphQLVisitableModel = (GraphQLHashtag) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4253h = graphQLImage;
            }
        }
        if (m8581o() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m8581o());
            if (m8581o() != graphQLImage) {
                graphQLVisitableModel = (GraphQLHashtag) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4254i = graphQLImage;
            }
        }
        if (m8582p() != null) {
            GraphQLInlineActivitiesConnection graphQLInlineActivitiesConnection = (GraphQLInlineActivitiesConnection) graphQLModelMutatingVisitor.b(m8582p());
            if (m8582p() != graphQLInlineActivitiesConnection) {
                graphQLVisitableModel = (GraphQLHashtag) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4255j = graphQLInlineActivitiesConnection;
            }
        }
        if (m8585s() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m8585s());
            if (m8585s() != graphQLImage) {
                graphQLVisitableModel = (GraphQLHashtag) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4258m = graphQLImage;
            }
        }
        if (m8586t() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m8586t());
            if (m8586t() != graphQLImage) {
                graphQLVisitableModel = (GraphQLHashtag) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4259n = graphQLImage;
            }
        }
        if (m8587u() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m8587u());
            if (m8587u() != graphQLImage) {
                graphQLVisitableModel = (GraphQLHashtag) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4260o = graphQLImage;
            }
        }
        if (m8588v() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m8588v());
            if (m8588v() != graphQLImage) {
                graphQLVisitableModel = (GraphQLHashtag) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4261p = graphQLImage;
            }
        }
        if (m8589w() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m8589w());
            if (m8589w() != graphQLImage) {
                graphQLVisitableModel = (GraphQLHashtag) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4262q = graphQLImage;
            }
        }
        if (m8590x() != null) {
            GraphQLPhoto graphQLPhoto = (GraphQLPhoto) graphQLModelMutatingVisitor.b(m8590x());
            if (m8590x() != graphQLPhoto) {
                graphQLVisitableModel = (GraphQLHashtag) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4263r = graphQLPhoto;
            }
        }
        if (m8591y() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m8591y());
            if (m8591y() != graphQLImage) {
                graphQLVisitableModel = (GraphQLHashtag) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4264s = graphQLImage;
            }
        }
        if (m8563B() != null) {
            GraphQLTextWithEntities graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m8563B());
            if (m8563B() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLHashtag) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4267v = graphQLTextWithEntities;
            }
        }
        if (m8564C() != null) {
            GraphQLStreamingImage graphQLStreamingImage = (GraphQLStreamingImage) graphQLModelMutatingVisitor.b(m8564C());
            if (m8564C() != graphQLStreamingImage) {
                graphQLVisitableModel = (GraphQLHashtag) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4268w = graphQLStreamingImage;
            }
        }
        if (m8566E() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m8566E());
            if (m8566E() != graphQLImage) {
                graphQLVisitableModel = (GraphQLHashtag) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4270y = graphQLImage;
            }
        }
        if (m8567F() != null) {
            GraphQLNode graphQLNode = (GraphQLNode) graphQLModelMutatingVisitor.b(m8567F());
            if (m8567F() != graphQLNode) {
                graphQLVisitableModel = (GraphQLHashtag) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4271z = graphQLNode;
            }
        }
        if (m8568G() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m8568G());
            if (m8568G() != graphQLImage) {
                graphQLVisitableModel = (GraphQLHashtag) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4245A = graphQLImage;
            }
        }
        if (m8569H() != null) {
            GraphQLTrendingTopicData graphQLTrendingTopicData = (GraphQLTrendingTopicData) graphQLModelMutatingVisitor.b(m8569H());
            if (m8569H() != graphQLTrendingTopicData) {
                graphQLVisitableModel = (GraphQLHashtag) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4246B = graphQLTrendingTopicData;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLHashtag() {
        super(28);
    }

    public final void m8575a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f4265t = mutableFlatBuffer.a(i, 16);
    }

    public final int m8572a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int c = flatBufferBuilder.c(m8576j());
        int a = ModelHelper.a(flatBufferBuilder, m8577k());
        int a2 = ModelHelper.a(flatBufferBuilder, m8578l());
        int b = flatBufferBuilder.b(m8579m());
        int a3 = ModelHelper.a(flatBufferBuilder, m8580n());
        int a4 = ModelHelper.a(flatBufferBuilder, m8581o());
        int a5 = ModelHelper.a(flatBufferBuilder, m8582p());
        int b2 = flatBufferBuilder.b(m8583q());
        int c2 = flatBufferBuilder.c(m8584r());
        int a6 = ModelHelper.a(flatBufferBuilder, m8585s());
        int a7 = ModelHelper.a(flatBufferBuilder, m8586t());
        int a8 = ModelHelper.a(flatBufferBuilder, m8587u());
        int a9 = ModelHelper.a(flatBufferBuilder, m8588v());
        int a10 = ModelHelper.a(flatBufferBuilder, m8589w());
        int a11 = ModelHelper.a(flatBufferBuilder, m8590x());
        int a12 = ModelHelper.a(flatBufferBuilder, m8591y());
        int b3 = flatBufferBuilder.b(m8562A());
        int a13 = ModelHelper.a(flatBufferBuilder, m8563B());
        int a14 = ModelHelper.a(flatBufferBuilder, m8564C());
        int b4 = flatBufferBuilder.b(m8565D());
        int a15 = ModelHelper.a(flatBufferBuilder, m8566E());
        int a16 = ModelHelper.a(flatBufferBuilder, m8567F());
        int a17 = ModelHelper.a(flatBufferBuilder, m8568G());
        int a18 = ModelHelper.a(flatBufferBuilder, m8569H());
        int b5 = flatBufferBuilder.b(m8570I());
        int b6 = flatBufferBuilder.b(m8571J());
        flatBufferBuilder.c(27);
        flatBufferBuilder.b(0, c);
        flatBufferBuilder.b(1, a);
        flatBufferBuilder.b(2, a2);
        flatBufferBuilder.b(3, b);
        flatBufferBuilder.b(4, a3);
        flatBufferBuilder.b(5, a4);
        flatBufferBuilder.b(6, a5);
        flatBufferBuilder.b(7, b2);
        flatBufferBuilder.b(8, c2);
        flatBufferBuilder.b(9, a6);
        flatBufferBuilder.b(10, a7);
        flatBufferBuilder.b(11, a8);
        flatBufferBuilder.b(12, a9);
        flatBufferBuilder.b(13, a10);
        flatBufferBuilder.b(14, a11);
        flatBufferBuilder.b(15, a12);
        flatBufferBuilder.a(16, m8592z());
        flatBufferBuilder.b(17, b3);
        flatBufferBuilder.b(18, a13);
        flatBufferBuilder.b(19, a14);
        flatBufferBuilder.b(20, b4);
        flatBufferBuilder.b(21, a15);
        flatBufferBuilder.b(22, a16);
        flatBufferBuilder.b(23, a17);
        flatBufferBuilder.b(24, a18);
        flatBufferBuilder.b(25, b5);
        flatBufferBuilder.b(26, b6);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLHashtag(Parcel parcel) {
        super(28);
        this.f4249d = ImmutableListHelper.a(parcel.readArrayList(String.class.getClassLoader()));
        this.f4250e = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f4251f = (GraphQLHashtagFeedConnection) parcel.readValue(GraphQLHashtagFeedConnection.class.getClassLoader());
        this.f4252g = parcel.readString();
        this.f4253h = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f4254i = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f4255j = (GraphQLInlineActivitiesConnection) parcel.readValue(GraphQLInlineActivitiesConnection.class.getClassLoader());
        this.f4256k = parcel.readString();
        this.f4257l = ImmutableListHelper.a(parcel.readArrayList(String.class.getClassLoader()));
        this.f4258m = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f4259n = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f4260o = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f4261p = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f4262q = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f4263r = (GraphQLPhoto) parcel.readValue(GraphQLPhoto.class.getClassLoader());
        this.f4264s = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f4265t = parcel.readByte() == (byte) 1;
        this.f4266u = parcel.readString();
        this.f4267v = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f4268w = (GraphQLStreamingImage) parcel.readValue(GraphQLStreamingImage.class.getClassLoader());
        this.f4269x = parcel.readString();
        this.f4270y = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f4271z = (GraphQLNode) parcel.readValue(GraphQLNode.class.getClassLoader());
        this.f4245A = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f4246B = (GraphQLTrendingTopicData) parcel.readValue(GraphQLTrendingTopicData.class.getClassLoader());
        this.f4247C = parcel.readString();
        this.f4248D = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m8576j());
        parcel.writeValue(m8577k());
        parcel.writeValue(m8578l());
        parcel.writeString(m8579m());
        parcel.writeValue(m8580n());
        parcel.writeValue(m8581o());
        parcel.writeValue(m8582p());
        parcel.writeString(m8583q());
        parcel.writeList(m8584r());
        parcel.writeValue(m8585s());
        parcel.writeValue(m8586t());
        parcel.writeValue(m8587u());
        parcel.writeValue(m8588v());
        parcel.writeValue(m8589w());
        parcel.writeValue(m8590x());
        parcel.writeValue(m8591y());
        parcel.writeByte((byte) (m8592z() ? 1 : 0));
        parcel.writeString(m8562A());
        parcel.writeValue(m8563B());
        parcel.writeValue(m8564C());
        parcel.writeString(m8565D());
        parcel.writeValue(m8566E());
        parcel.writeValue(m8567F());
        parcel.writeValue(m8568G());
        parcel.writeValue(m8569H());
        parcel.writeString(m8570I());
        parcel.writeString(m8571J());
    }
}
