package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLFundraiserToCharityDeserializer;
import com.facebook.graphql.enums.GraphQLObjectType;
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
/* compiled from: group_member */
public final class GraphQLFundraiserToCharity extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLFundraiserToCharity> CREATOR = new C03361();
    @Nullable
    public GraphQLObjectType f3832d;
    @Nullable
    public String f3833e;
    @Nullable
    public GraphQLTextWithEntities f3834f;
    @Nullable
    public String f3835g;
    @Nullable
    public GraphQLImage f3836h;
    @Nullable
    public String f3837i;
    @Nullable
    public GraphQLFundraiserCharity f3838j;
    public boolean f3839k;
    @Nullable
    public GraphQLTextWithEntities f3840l;
    @Nullable
    public GraphQLActor f3841m;
    @Nullable
    public GraphQLTextWithEntities f3842n;

    /* compiled from: group_member */
    final class C03361 implements Creator<GraphQLFundraiserToCharity> {
        C03361() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLFundraiserToCharity(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLFundraiserToCharity[i];
        }
    }

    /* compiled from: group_member */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLFundraiserToCharity.class, new Deserializer());
        }

        public Object m7732a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLFundraiserToCharityDeserializer.m4988a(jsonParser, (short) 521);
            Object graphQLFundraiserToCharity = new GraphQLFundraiserToCharity();
            ((BaseModel) graphQLFundraiserToCharity).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLFundraiserToCharity instanceof Postprocessable) {
                return ((Postprocessable) graphQLFundraiserToCharity).a();
            }
            return graphQLFundraiserToCharity;
        }
    }

    /* compiled from: group_member */
    public final class Serializer extends JsonSerializer<GraphQLFundraiserToCharity> {
        public final void m7733a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLFundraiserToCharity graphQLFundraiserToCharity = (GraphQLFundraiserToCharity) obj;
            GraphQLFundraiserToCharityDeserializer.m4989a(graphQLFundraiserToCharity.w_(), graphQLFundraiserToCharity.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLFundraiserToCharity.class, new Serializer());
            FbSerializerProvider.a(GraphQLFundraiserToCharity.class, new Serializer());
        }
    }

    @Nullable
    public final GraphQLObjectType m7738j() {
        if (this.b != null && this.f3832d == null) {
            this.f3832d = new GraphQLObjectType(this.b.b(this.c, 0));
        }
        if (this.f3832d == null || this.f3832d.g() != 0) {
            return this.f3832d;
        }
        return null;
    }

    @FieldOffset
    @Nullable
    public final String m7739k() {
        this.f3833e = super.a(this.f3833e, 1);
        return this.f3833e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m7740l() {
        this.f3834f = (GraphQLTextWithEntities) super.a(this.f3834f, 2, GraphQLTextWithEntities.class);
        return this.f3834f;
    }

    @FieldOffset
    @Nullable
    public final String m7741m() {
        this.f3835g = super.a(this.f3835g, 3);
        return this.f3835g;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m7742n() {
        this.f3836h = (GraphQLImage) super.a(this.f3836h, 4, GraphQLImage.class);
        return this.f3836h;
    }

    @FieldOffset
    @Nullable
    public final String m7743o() {
        this.f3837i = super.a(this.f3837i, 5);
        return this.f3837i;
    }

    @FieldOffset
    @Nullable
    public final GraphQLFundraiserCharity m7744p() {
        this.f3838j = (GraphQLFundraiserCharity) super.a(this.f3838j, 6, GraphQLFundraiserCharity.class);
        return this.f3838j;
    }

    @FieldOffset
    public final boolean m7745q() {
        a(0, 7);
        return this.f3839k;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m7746r() {
        this.f3840l = (GraphQLTextWithEntities) super.a(this.f3840l, 8, GraphQLTextWithEntities.class);
        return this.f3840l;
    }

    @FieldOffset
    @Nullable
    public final GraphQLActor m7747s() {
        this.f3841m = (GraphQLActor) super.a(this.f3841m, 13, GraphQLActor.class);
        return this.f3841m;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m7748t() {
        this.f3842n = (GraphQLTextWithEntities) super.a(this.f3842n, 14, GraphQLTextWithEntities.class);
        return this.f3842n;
    }

    @Nullable
    public final String m7736a() {
        return m7741m();
    }

    public final int jK_() {
        return -2117047886;
    }

    public final GraphQLVisitableModel m7735a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLTextWithEntities graphQLTextWithEntities;
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m7744p() != null) {
            GraphQLFundraiserCharity graphQLFundraiserCharity = (GraphQLFundraiserCharity) graphQLModelMutatingVisitor.b(m7744p());
            if (m7744p() != graphQLFundraiserCharity) {
                graphQLVisitableModel = (GraphQLFundraiserToCharity) ModelHelper.a(null, this);
                graphQLVisitableModel.f3838j = graphQLFundraiserCharity;
            }
        }
        if (m7748t() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m7748t());
            if (m7748t() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLFundraiserToCharity) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3842n = graphQLTextWithEntities;
            }
        }
        if (m7740l() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m7740l());
            if (m7740l() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLFundraiserToCharity) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3834f = graphQLTextWithEntities;
            }
        }
        if (m7746r() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m7746r());
            if (m7746r() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLFundraiserToCharity) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3840l = graphQLTextWithEntities;
            }
        }
        if (m7742n() != null) {
            GraphQLImage graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m7742n());
            if (m7742n() != graphQLImage) {
                graphQLVisitableModel = (GraphQLFundraiserToCharity) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3836h = graphQLImage;
            }
        }
        if (m7747s() != null) {
            GraphQLActor graphQLActor = (GraphQLActor) graphQLModelMutatingVisitor.b(m7747s());
            if (m7747s() != graphQLActor) {
                graphQLVisitableModel = (GraphQLFundraiserToCharity) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3841m = graphQLActor;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLFundraiserToCharity() {
        super(16);
    }

    public final void m7737a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f3839k = mutableFlatBuffer.a(i, 7);
    }

    public final int m7734a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = flatBufferBuilder.a(m7738j() != null ? m7738j().e() : null);
        int b = flatBufferBuilder.b(m7739k());
        int a2 = ModelHelper.a(flatBufferBuilder, m7740l());
        int b2 = flatBufferBuilder.b(m7741m());
        int a3 = ModelHelper.a(flatBufferBuilder, m7742n());
        int b3 = flatBufferBuilder.b(m7743o());
        int a4 = ModelHelper.a(flatBufferBuilder, m7744p());
        int a5 = ModelHelper.a(flatBufferBuilder, m7746r());
        int a6 = ModelHelper.a(flatBufferBuilder, m7747s());
        int a7 = ModelHelper.a(flatBufferBuilder, m7748t());
        flatBufferBuilder.c(15);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, b);
        flatBufferBuilder.b(2, a2);
        flatBufferBuilder.b(3, b2);
        flatBufferBuilder.b(4, a3);
        flatBufferBuilder.b(5, b3);
        flatBufferBuilder.b(6, a4);
        flatBufferBuilder.a(7, m7745q());
        flatBufferBuilder.b(8, a5);
        flatBufferBuilder.b(13, a6);
        flatBufferBuilder.b(14, a7);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLFundraiserToCharity(Parcel parcel) {
        boolean z = true;
        super(16);
        this.f3833e = parcel.readString();
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.f3839k = z;
        this.f3838j = (GraphQLFundraiserCharity) parcel.readValue(GraphQLFundraiserCharity.class.getClassLoader());
        this.f3842n = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f3834f = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f3840l = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f3835g = parcel.readString();
        this.f3836h = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f3837i = parcel.readString();
        this.f3841m = (GraphQLActor) parcel.readValue(GraphQLActor.class.getClassLoader());
        this.f3832d = (GraphQLObjectType) ParcelUtil.m3828b(parcel, GraphQLObjectType.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m7739k());
        parcel.writeByte((byte) (m7745q() ? 1 : 0));
        parcel.writeValue(m7744p());
        parcel.writeValue(m7748t());
        parcel.writeValue(m7740l());
        parcel.writeValue(m7746r());
        parcel.writeString(m7741m());
        parcel.writeValue(m7742n());
        parcel.writeString(m7743o());
        parcel.writeValue(m7747s());
        parcel.writeParcelable(this.f3832d, i);
    }
}
