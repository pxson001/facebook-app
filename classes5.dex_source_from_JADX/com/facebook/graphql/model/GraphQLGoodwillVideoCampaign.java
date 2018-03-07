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
import com.facebook.graphql.deserializers.GraphQLGoodwillVideoCampaignDeserializer;
import com.facebook.graphql.enums.GraphQLGoodwillVideoCampaignTypeEnum;
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
import com.google.common.collect.ImmutableList.Builder;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: getNumSpeedSteps */
public final class GraphQLGoodwillVideoCampaign extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLGoodwillVideoCampaign> CREATOR = new C03701();
    @Nullable
    public String f4038d;
    @Nullable
    public String f4039e;
    public List<GraphQLStoryAttachment> f4040f;
    public GraphQLGoodwillVideoCampaignTypeEnum f4041g;
    @Nullable
    public GraphQLImage f4042h;
    public List<GraphQLUser> f4043i;
    @Nullable
    public String f4044j;
    @Nullable
    public String f4045k;
    @Nullable
    public String f4046l;

    /* compiled from: getNumSpeedSteps */
    final class C03701 implements Creator<GraphQLGoodwillVideoCampaign> {
        C03701() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLGoodwillVideoCampaign(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLGoodwillVideoCampaign[i];
        }
    }

    /* compiled from: getNumSpeedSteps */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLGoodwillVideoCampaign.class, new Deserializer());
        }

        public Object m8119a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLGoodwillVideoCampaignDeserializer.m5072a(jsonParser, (short) 539);
            Object graphQLGoodwillVideoCampaign = new GraphQLGoodwillVideoCampaign();
            ((BaseModel) graphQLGoodwillVideoCampaign).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLGoodwillVideoCampaign instanceof Postprocessable) {
                return ((Postprocessable) graphQLGoodwillVideoCampaign).a();
            }
            return graphQLGoodwillVideoCampaign;
        }
    }

    /* compiled from: getNumSpeedSteps */
    public final class Serializer extends JsonSerializer<GraphQLGoodwillVideoCampaign> {
        public final void m8120a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLGoodwillVideoCampaign graphQLGoodwillVideoCampaign = (GraphQLGoodwillVideoCampaign) obj;
            GraphQLGoodwillVideoCampaignDeserializer.m5073a(graphQLGoodwillVideoCampaign.w_(), graphQLGoodwillVideoCampaign.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLGoodwillVideoCampaign.class, new Serializer());
            FbSerializerProvider.a(GraphQLGoodwillVideoCampaign.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final String m8124j() {
        this.f4038d = super.a(this.f4038d, 0);
        return this.f4038d;
    }

    @FieldOffset
    @Nullable
    public final String m8125k() {
        this.f4039e = super.a(this.f4039e, 1);
        return this.f4039e;
    }

    @FieldOffset
    public final ImmutableList<GraphQLStoryAttachment> m8126l() {
        this.f4040f = super.a(this.f4040f, 2, GraphQLStoryAttachment.class);
        return (ImmutableList) this.f4040f;
    }

    @FieldOffset
    public final GraphQLGoodwillVideoCampaignTypeEnum m8127m() {
        this.f4041g = (GraphQLGoodwillVideoCampaignTypeEnum) super.a(this.f4041g, 3, GraphQLGoodwillVideoCampaignTypeEnum.class, GraphQLGoodwillVideoCampaignTypeEnum.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f4041g;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m8128n() {
        this.f4042h = (GraphQLImage) super.a(this.f4042h, 5, GraphQLImage.class);
        return this.f4042h;
    }

    @FieldOffset
    public final ImmutableList<GraphQLUser> m8129o() {
        this.f4043i = super.a(this.f4043i, 6, GraphQLUser.class);
        return (ImmutableList) this.f4043i;
    }

    @FieldOffset
    @Nullable
    public final String m8130p() {
        this.f4044j = super.a(this.f4044j, 7);
        return this.f4044j;
    }

    @FieldOffset
    @Nullable
    public final String m8131q() {
        this.f4045k = super.a(this.f4045k, 8);
        return this.f4045k;
    }

    @FieldOffset
    @Nullable
    public final String m8132r() {
        this.f4046l = super.a(this.f4046l, 9);
        return this.f4046l;
    }

    @Nullable
    public final String m8123a() {
        return m8124j();
    }

    public final int jK_() {
        return 817943740;
    }

    public final GraphQLVisitableModel m8122a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        Builder a;
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m8128n() != null) {
            GraphQLImage graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m8128n());
            if (m8128n() != graphQLImage) {
                graphQLVisitableModel = (GraphQLGoodwillVideoCampaign) ModelHelper.a(null, this);
                graphQLVisitableModel.f4042h = graphQLImage;
            }
        }
        if (m8129o() != null) {
            a = ModelHelper.a(m8129o(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLGoodwillVideoCampaign graphQLGoodwillVideoCampaign = (GraphQLGoodwillVideoCampaign) ModelHelper.a(graphQLVisitableModel, this);
                graphQLGoodwillVideoCampaign.f4043i = a.b();
                graphQLVisitableModel = graphQLGoodwillVideoCampaign;
            }
        }
        if (m8126l() != null) {
            a = ModelHelper.a(m8126l(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLGoodwillVideoCampaign = (GraphQLGoodwillVideoCampaign) ModelHelper.a(graphQLVisitableModel, this);
                graphQLGoodwillVideoCampaign.f4040f = a.b();
                graphQLVisitableModel = graphQLGoodwillVideoCampaign;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLGoodwillVideoCampaign() {
        super(11);
    }

    public final int m8121a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m8124j());
        int b2 = flatBufferBuilder.b(m8125k());
        int a = ModelHelper.a(flatBufferBuilder, m8126l());
        int a2 = ModelHelper.a(flatBufferBuilder, m8128n());
        int a3 = ModelHelper.a(flatBufferBuilder, m8129o());
        int b3 = flatBufferBuilder.b(m8130p());
        int b4 = flatBufferBuilder.b(m8131q());
        int b5 = flatBufferBuilder.b(m8132r());
        flatBufferBuilder.c(10);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, b2);
        flatBufferBuilder.b(2, a);
        flatBufferBuilder.a(3, m8127m() == GraphQLGoodwillVideoCampaignTypeEnum.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m8127m());
        flatBufferBuilder.b(5, a2);
        flatBufferBuilder.b(6, a3);
        flatBufferBuilder.b(7, b3);
        flatBufferBuilder.b(8, b4);
        flatBufferBuilder.b(9, b5);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLGoodwillVideoCampaign(Parcel parcel) {
        super(11);
        this.f4041g = GraphQLGoodwillVideoCampaignTypeEnum.fromString(parcel.readString());
        this.f4042h = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f4038d = parcel.readString();
        this.f4043i = ImmutableListHelper.a(parcel.readArrayList(GraphQLUser.class.getClassLoader()));
        this.f4039e = parcel.readString();
        this.f4040f = ImmutableListHelper.a(parcel.readArrayList(GraphQLStoryAttachment.class.getClassLoader()));
        this.f4044j = parcel.readString();
        this.f4046l = parcel.readString();
        this.f4045k = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m8127m().name());
        parcel.writeValue(m8128n());
        parcel.writeString(m8124j());
        parcel.writeList(m8129o());
        parcel.writeString(m8125k());
        parcel.writeList(m8126l());
        parcel.writeString(m8130p());
        parcel.writeString(m8132r());
        parcel.writeString(m8131q());
    }
}
