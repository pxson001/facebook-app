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
import com.facebook.graphql.deserializers.GraphQLGoodwillThrowbackFriendversaryPromotionStoryDeserializer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.model.PropertyBag.HasProperty;
import com.facebook.graphql.model.extras.FeedUnitExtra;
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
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import com.instagram.common.json.annotation.JsonType;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: global_brand_v2_child_switch */
public final class GraphQLGoodwillThrowbackFriendversaryPromotionStory extends BaseModel implements FeedUnit, HasProperty, TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLGoodwillThrowbackFriendversaryPromotionStory> CREATOR = new C03561();
    GraphQLObjectType f3998d = new GraphQLObjectType(-614701746);
    long f3999e;
    @Nullable
    GraphQLTextWithEntities f4000f;
    @Nullable
    GraphQLGoodwillFriendversaryCampaign f4001g;
    @Nullable
    GraphQLGoodwillThrowbackSection f4002h;
    @Nullable
    String f4003i;
    private GoodwillThrowbackFriendversaryPromotionStoryExtra f4004j;
    @Nullable
    private PropertyBag f4005k = null;

    /* compiled from: global_brand_v2_child_switch */
    final class C03561 implements Creator<GraphQLGoodwillThrowbackFriendversaryPromotionStory> {
        C03561() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLGoodwillThrowbackFriendversaryPromotionStory(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLGoodwillThrowbackFriendversaryPromotionStory[i];
        }
    }

    /* compiled from: global_brand_v2_child_switch */
    public class Builder extends com.facebook.graphql.modelutil.BaseModel.Builder {
        public long f3992d;
        @Nullable
        public GraphQLTextWithEntities f3993e;
        @Nullable
        public GraphQLGoodwillFriendversaryCampaign f3994f;
        @Nullable
        public String f3995g;
        @Nullable
        public GraphQLGoodwillThrowbackSection f3996h;
        @Nullable
        PropertyBag f3997i = null;

        public Builder() {
            Preconditions.checkState(this instanceof Builder);
        }
    }

    /* compiled from: global_brand_v2_child_switch */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLGoodwillThrowbackFriendversaryPromotionStory.class, new Deserializer());
        }

        public Object m8013a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLGoodwillThrowbackFriendversaryPromotionStoryDeserializer.m5042a(jsonParser, (short) 401);
            Object graphQLGoodwillThrowbackFriendversaryPromotionStory = new GraphQLGoodwillThrowbackFriendversaryPromotionStory();
            ((BaseModel) graphQLGoodwillThrowbackFriendversaryPromotionStory).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLGoodwillThrowbackFriendversaryPromotionStory instanceof Postprocessable) {
                return ((Postprocessable) graphQLGoodwillThrowbackFriendversaryPromotionStory).a();
            }
            return graphQLGoodwillThrowbackFriendversaryPromotionStory;
        }
    }

    /* compiled from: global_brand_v2_child_switch */
    public class GoodwillThrowbackFriendversaryPromotionStoryExtra extends FeedUnitExtra {
        public static final Creator<GoodwillThrowbackFriendversaryPromotionStoryExtra> CREATOR = new C03571();

        /* compiled from: global_brand_v2_child_switch */
        final class C03571 implements Creator<GoodwillThrowbackFriendversaryPromotionStoryExtra> {
            C03571() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new GoodwillThrowbackFriendversaryPromotionStoryExtra(parcel);
            }

            public final Object[] newArray(int i) {
                return new GoodwillThrowbackFriendversaryPromotionStoryExtra[i];
            }
        }

        protected GoodwillThrowbackFriendversaryPromotionStoryExtra(Parcel parcel) {
            super(parcel);
        }
    }

    /* compiled from: global_brand_v2_child_switch */
    public final class Serializer extends JsonSerializer<GraphQLGoodwillThrowbackFriendversaryPromotionStory> {
        public final void m8014a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLGoodwillThrowbackFriendversaryPromotionStory graphQLGoodwillThrowbackFriendversaryPromotionStory = (GraphQLGoodwillThrowbackFriendversaryPromotionStory) obj;
            GraphQLGoodwillThrowbackFriendversaryPromotionStoryDeserializer.m5043a(graphQLGoodwillThrowbackFriendversaryPromotionStory.w_(), graphQLGoodwillThrowbackFriendversaryPromotionStory.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLGoodwillThrowbackFriendversaryPromotionStory.class, new Serializer());
            FbSerializerProvider.a(GraphQLGoodwillThrowbackFriendversaryPromotionStory.class, new Serializer());
        }
    }

    public final String m8021g() {
        return null;
    }

    public final /* synthetic */ FeedUnitExtra m8022j() {
        return m8015o();
    }

    public final GraphQLObjectType getType() {
        return this.f3998d;
    }

    public final String S_() {
        return null;
    }

    public final ImmutableList<String> m8020d() {
        if (m8021g() != null) {
            return ImmutableList.of(m8021g());
        }
        return RegularImmutableList.a;
    }

    @FieldOffset
    public final long T_() {
        a(0, 0);
        return this.f3999e;
    }

    public final void m8018a(long j) {
        this.f3999e = j;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m8023k() {
        this.f4000f = (GraphQLTextWithEntities) super.a(this.f4000f, 1, GraphQLTextWithEntities.class);
        return this.f4000f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLGoodwillFriendversaryCampaign m8024l() {
        this.f4001g = (GraphQLGoodwillFriendversaryCampaign) super.a(this.f4001g, 2, GraphQLGoodwillFriendversaryCampaign.class);
        return this.f4001g;
    }

    @FieldOffset
    @Nullable
    public final GraphQLGoodwillThrowbackSection m8025m() {
        this.f4002h = (GraphQLGoodwillThrowbackSection) super.a(this.f4002h, 3, GraphQLGoodwillThrowbackSection.class);
        return this.f4002h;
    }

    @FieldOffset
    @Nullable
    public final String m8026n() {
        this.f4003i = super.a(this.f4003i, 4);
        return this.f4003i;
    }

    public final int jK_() {
        return -614701746;
    }

    public final GraphQLVisitableModel m8017a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m8023k() != null) {
            GraphQLTextWithEntities graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m8023k());
            if (m8023k() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLGoodwillThrowbackFriendversaryPromotionStory) ModelHelper.a(null, this);
                graphQLVisitableModel.f4000f = graphQLTextWithEntities;
            }
        }
        if (m8024l() != null) {
            GraphQLGoodwillFriendversaryCampaign graphQLGoodwillFriendversaryCampaign = (GraphQLGoodwillFriendversaryCampaign) graphQLModelMutatingVisitor.b(m8024l());
            if (m8024l() != graphQLGoodwillFriendversaryCampaign) {
                graphQLVisitableModel = (GraphQLGoodwillThrowbackFriendversaryPromotionStory) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4001g = graphQLGoodwillFriendversaryCampaign;
            }
        }
        if (m8025m() != null) {
            GraphQLGoodwillThrowbackSection graphQLGoodwillThrowbackSection = (GraphQLGoodwillThrowbackSection) graphQLModelMutatingVisitor.b(m8025m());
            if (m8025m() != graphQLGoodwillThrowbackSection) {
                graphQLVisitableModel = (GraphQLGoodwillThrowbackFriendversaryPromotionStory) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4002h = graphQLGoodwillThrowbackSection;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLGoodwillThrowbackFriendversaryPromotionStory() {
        super(6);
    }

    public final void m8019a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f3999e = mutableFlatBuffer.a(i, 0, 0);
    }

    public final int m8016a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m8023k());
        int a2 = ModelHelper.a(flatBufferBuilder, m8024l());
        int a3 = ModelHelper.a(flatBufferBuilder, m8025m());
        int b = flatBufferBuilder.b(m8026n());
        flatBufferBuilder.c(5);
        flatBufferBuilder.a(0, T_(), 0);
        flatBufferBuilder.b(1, a);
        flatBufferBuilder.b(2, a2);
        flatBufferBuilder.b(3, a3);
        flatBufferBuilder.b(4, b);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLGoodwillThrowbackFriendversaryPromotionStory(Parcel parcel) {
        super(6);
        this.f3999e = parcel.readLong();
        this.f4000f = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f4001g = (GraphQLGoodwillFriendversaryCampaign) parcel.readValue(GraphQLGoodwillFriendversaryCampaign.class.getClassLoader());
        this.f4003i = parcel.readString();
        this.f4002h = (GraphQLGoodwillThrowbackSection) parcel.readValue(GraphQLGoodwillThrowbackSection.class.getClassLoader());
        this.f4004j = (GoodwillThrowbackFriendversaryPromotionStoryExtra) ParcelUtil.m3828b(parcel, GoodwillThrowbackFriendversaryPromotionStoryExtra.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(T_());
        parcel.writeValue(m8023k());
        parcel.writeValue(m8024l());
        parcel.writeString(m8026n());
        parcel.writeValue(m8025m());
        parcel.writeParcelable(m8015o(), i);
    }

    public GraphQLGoodwillThrowbackFriendversaryPromotionStory(Builder builder) {
        super(6);
        this.b = builder.a;
        this.c = builder.b;
        this.f3999e = builder.f3992d;
        this.f4000f = builder.f3993e;
        this.f4001g = builder.f3994f;
        this.f4003i = builder.f3995g;
        this.f4002h = builder.f3996h;
        this.f4005k = builder.f3997i;
    }

    private GoodwillThrowbackFriendversaryPromotionStoryExtra m8015o() {
        if (this.f4004j == null) {
            if (this.b == null || !this.b.d) {
                this.f4004j = new GoodwillThrowbackFriendversaryPromotionStoryExtra();
            } else {
                this.f4004j = (GoodwillThrowbackFriendversaryPromotionStoryExtra) this.b.a(this.c, this, GoodwillThrowbackFriendversaryPromotionStoryExtra.class);
            }
        }
        return this.f4004j;
    }

    public final PropertyBag U_() {
        if (this.f4005k == null) {
            this.f4005k = new PropertyBag();
        }
        return this.f4005k;
    }
}
