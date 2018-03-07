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
import com.facebook.graphql.deserializers.GraphQLGoodwillThrowbackAnniversaryCampaignStoryDeserializer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.model.PropertyBag.HasProperty;
import com.facebook.graphql.model.extras.FeedUnitExtra;
import com.facebook.graphql.model.interfaces.CacheableEntity;
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
/* compiled from: granularity */
public final class GraphQLGoodwillThrowbackAnniversaryCampaignStory extends BaseModel implements FeedUnit, HasProperty, CacheableEntity, TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLGoodwillThrowbackAnniversaryCampaignStory> CREATOR = new C03501();
    GraphQLObjectType f3930d = new GraphQLObjectType(1815651731);
    @Nullable
    GraphQLGoodwillAnniversaryCampaign f3931e;
    @Nullable
    GraphQLGoodwillThrowbackPermalinkColorPalette f3932f;
    long f3933g;
    @Nullable
    GraphQLTextWithEntities f3934h;
    @Nullable
    GraphQLTextWithEntities f3935i;
    private GoodwillThrowbackAnniversaryCampaignStoryExtra f3936j;
    @Nullable
    private PropertyBag f3937k = null;

    /* compiled from: granularity */
    final class C03501 implements Creator<GraphQLGoodwillThrowbackAnniversaryCampaignStory> {
        C03501() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLGoodwillThrowbackAnniversaryCampaignStory(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLGoodwillThrowbackAnniversaryCampaignStory[i];
        }
    }

    /* compiled from: granularity */
    public class Builder extends com.facebook.graphql.modelutil.BaseModel.Builder {
        @Nullable
        public GraphQLGoodwillAnniversaryCampaign f3924d;
        @Nullable
        public GraphQLGoodwillThrowbackPermalinkColorPalette f3925e;
        public long f3926f;
        @Nullable
        public GraphQLTextWithEntities f3927g;
        @Nullable
        public GraphQLTextWithEntities f3928h;
        @Nullable
        PropertyBag f3929i = null;

        public Builder() {
            Preconditions.checkState(this instanceof Builder);
        }
    }

    /* compiled from: granularity */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLGoodwillThrowbackAnniversaryCampaignStory.class, new Deserializer());
        }

        public Object m7909a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLGoodwillThrowbackAnniversaryCampaignStoryDeserializer.m5024a(jsonParser, (short) 402);
            Object graphQLGoodwillThrowbackAnniversaryCampaignStory = new GraphQLGoodwillThrowbackAnniversaryCampaignStory();
            ((BaseModel) graphQLGoodwillThrowbackAnniversaryCampaignStory).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLGoodwillThrowbackAnniversaryCampaignStory instanceof Postprocessable) {
                return ((Postprocessable) graphQLGoodwillThrowbackAnniversaryCampaignStory).a();
            }
            return graphQLGoodwillThrowbackAnniversaryCampaignStory;
        }
    }

    /* compiled from: granularity */
    public class GoodwillThrowbackAnniversaryCampaignStoryExtra extends FeedUnitExtra {
        public static final Creator<GoodwillThrowbackAnniversaryCampaignStoryExtra> CREATOR = new C03511();

        /* compiled from: granularity */
        final class C03511 implements Creator<GoodwillThrowbackAnniversaryCampaignStoryExtra> {
            C03511() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new GoodwillThrowbackAnniversaryCampaignStoryExtra(parcel);
            }

            public final Object[] newArray(int i) {
                return new GoodwillThrowbackAnniversaryCampaignStoryExtra[i];
            }
        }

        protected GoodwillThrowbackAnniversaryCampaignStoryExtra(Parcel parcel) {
            super(parcel);
        }
    }

    /* compiled from: granularity */
    public final class Serializer extends JsonSerializer<GraphQLGoodwillThrowbackAnniversaryCampaignStory> {
        public final void m7910a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLGoodwillThrowbackAnniversaryCampaignStory graphQLGoodwillThrowbackAnniversaryCampaignStory = (GraphQLGoodwillThrowbackAnniversaryCampaignStory) obj;
            GraphQLGoodwillThrowbackAnniversaryCampaignStoryDeserializer.m5025a(graphQLGoodwillThrowbackAnniversaryCampaignStory.w_(), graphQLGoodwillThrowbackAnniversaryCampaignStory.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLGoodwillThrowbackAnniversaryCampaignStory.class, new Serializer());
            FbSerializerProvider.a(GraphQLGoodwillThrowbackAnniversaryCampaignStory.class, new Serializer());
        }
    }

    public final String m7917g() {
        return null;
    }

    public final /* synthetic */ FeedUnitExtra m7918j() {
        return m7911o();
    }

    public final GraphQLObjectType getType() {
        return this.f3930d;
    }

    public final String S_() {
        return null;
    }

    public final ImmutableList<String> m7916d() {
        if (m7917g() != null) {
            return ImmutableList.of(m7917g());
        }
        return RegularImmutableList.a;
    }

    @FieldOffset
    @Nullable
    public final GraphQLGoodwillAnniversaryCampaign m7919k() {
        this.f3931e = (GraphQLGoodwillAnniversaryCampaign) super.a(this.f3931e, 0, GraphQLGoodwillAnniversaryCampaign.class);
        return this.f3931e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLGoodwillThrowbackPermalinkColorPalette m7920l() {
        this.f3932f = (GraphQLGoodwillThrowbackPermalinkColorPalette) super.a(this.f3932f, 1, GraphQLGoodwillThrowbackPermalinkColorPalette.class);
        return this.f3932f;
    }

    @FieldOffset
    public final long T_() {
        a(0, 2);
        return this.f3933g;
    }

    public final void m7914a(long j) {
        this.f3933g = j;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m7921m() {
        this.f3934h = (GraphQLTextWithEntities) super.a(this.f3934h, 3, GraphQLTextWithEntities.class);
        return this.f3934h;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m7922n() {
        this.f3935i = (GraphQLTextWithEntities) super.a(this.f3935i, 4, GraphQLTextWithEntities.class);
        return this.f3935i;
    }

    public final int jK_() {
        return 1815651731;
    }

    public final GraphQLVisitableModel m7913a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLTextWithEntities graphQLTextWithEntities;
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m7919k() != null) {
            GraphQLGoodwillAnniversaryCampaign graphQLGoodwillAnniversaryCampaign = (GraphQLGoodwillAnniversaryCampaign) graphQLModelMutatingVisitor.b(m7919k());
            if (m7919k() != graphQLGoodwillAnniversaryCampaign) {
                graphQLVisitableModel = (GraphQLGoodwillThrowbackAnniversaryCampaignStory) ModelHelper.a(null, this);
                graphQLVisitableModel.f3931e = graphQLGoodwillAnniversaryCampaign;
            }
        }
        if (m7920l() != null) {
            GraphQLGoodwillThrowbackPermalinkColorPalette graphQLGoodwillThrowbackPermalinkColorPalette = (GraphQLGoodwillThrowbackPermalinkColorPalette) graphQLModelMutatingVisitor.b(m7920l());
            if (m7920l() != graphQLGoodwillThrowbackPermalinkColorPalette) {
                graphQLVisitableModel = (GraphQLGoodwillThrowbackAnniversaryCampaignStory) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3932f = graphQLGoodwillThrowbackPermalinkColorPalette;
            }
        }
        if (m7921m() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m7921m());
            if (m7921m() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLGoodwillThrowbackAnniversaryCampaignStory) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3934h = graphQLTextWithEntities;
            }
        }
        if (m7922n() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m7922n());
            if (m7922n() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLGoodwillThrowbackAnniversaryCampaignStory) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3935i = graphQLTextWithEntities;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLGoodwillThrowbackAnniversaryCampaignStory() {
        super(6);
    }

    public final void m7915a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f3933g = mutableFlatBuffer.a(i, 2, 0);
    }

    public final int m7912a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m7919k());
        int a2 = ModelHelper.a(flatBufferBuilder, m7920l());
        int a3 = ModelHelper.a(flatBufferBuilder, m7921m());
        int a4 = ModelHelper.a(flatBufferBuilder, m7922n());
        flatBufferBuilder.c(5);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, a2);
        flatBufferBuilder.a(2, T_(), 0);
        flatBufferBuilder.b(3, a3);
        flatBufferBuilder.b(4, a4);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLGoodwillThrowbackAnniversaryCampaignStory(Parcel parcel) {
        super(6);
        this.f3931e = (GraphQLGoodwillAnniversaryCampaign) parcel.readValue(GraphQLGoodwillAnniversaryCampaign.class.getClassLoader());
        this.f3932f = (GraphQLGoodwillThrowbackPermalinkColorPalette) parcel.readValue(GraphQLGoodwillThrowbackPermalinkColorPalette.class.getClassLoader());
        this.f3933g = parcel.readLong();
        this.f3934h = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f3935i = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f3936j = (GoodwillThrowbackAnniversaryCampaignStoryExtra) ParcelUtil.m3828b(parcel, GoodwillThrowbackAnniversaryCampaignStoryExtra.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m7919k());
        parcel.writeValue(m7920l());
        parcel.writeLong(T_());
        parcel.writeValue(m7921m());
        parcel.writeValue(m7922n());
        parcel.writeParcelable(m7911o(), i);
    }

    public GraphQLGoodwillThrowbackAnniversaryCampaignStory(Builder builder) {
        super(6);
        this.b = builder.a;
        this.c = builder.b;
        this.f3931e = builder.f3924d;
        this.f3932f = builder.f3925e;
        this.f3933g = builder.f3926f;
        this.f3934h = builder.f3927g;
        this.f3935i = builder.f3928h;
        this.f3937k = builder.f3929i;
    }

    private GoodwillThrowbackAnniversaryCampaignStoryExtra m7911o() {
        if (this.f3936j == null) {
            if (this.b == null || !this.b.d) {
                this.f3936j = new GoodwillThrowbackAnniversaryCampaignStoryExtra();
            } else {
                this.f3936j = (GoodwillThrowbackAnniversaryCampaignStoryExtra) this.b.a(this.c, this, GoodwillThrowbackAnniversaryCampaignStoryExtra.class);
            }
        }
        return this.f3936j;
    }

    public final PropertyBag U_() {
        if (this.f3937k == null) {
            this.f3937k = new PropertyBag();
        }
        return this.f3937k;
    }
}
