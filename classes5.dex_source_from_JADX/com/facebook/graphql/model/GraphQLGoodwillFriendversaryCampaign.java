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
import com.facebook.graphql.deserializers.GraphQLGoodwillFriendversaryCampaignDeserializer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.model.PropertyBag.HasProperty;
import com.facebook.graphql.model.extras.FeedUnitExtra;
import com.facebook.graphql.model.interfaces.CacheableEntity;
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
import com.google.common.collect.RegularImmutableList;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: graph_suggestion_api */
public final class GraphQLGoodwillFriendversaryCampaign extends BaseModel implements FeedUnit, HasProperty, CacheableEntity, TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLGoodwillFriendversaryCampaign> CREATOR = new C03461();
    GraphQLObjectType f3903d = new GraphQLObjectType(194164507);
    @Nullable
    GraphQLGoodwillThrowbackDataPointsConnection f3904e;
    long f3905f;
    @Nullable
    GraphQLUser f3906g;
    @Nullable
    String f3907h;
    @Nullable
    GraphQLMediaSet f3908i;
    List<GraphQLStoryAttachment> f3909j;
    @Nullable
    GraphQLTextWithEntities f3910k;
    @Nullable
    GraphQLTextWithEntities f3911l;
    @Nullable
    GraphQLTextWithEntities f3912m;
    @Nullable
    String f3913n;
    @Nullable
    GraphQLImage f3914o;
    @Nullable
    GraphQLTextWithEntities f3915p;
    @Nullable
    GraphQLTextWithEntities f3916q;
    @Nullable
    String f3917r;
    @Nullable
    GraphQLGoodwillVideoCampaign f3918s;
    private GoodwillFriendversaryCampaignExtra f3919t;
    @Nullable
    private PropertyBag f3920u = null;

    /* compiled from: graph_suggestion_api */
    final class C03461 implements Creator<GraphQLGoodwillFriendversaryCampaign> {
        C03461() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLGoodwillFriendversaryCampaign(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLGoodwillFriendversaryCampaign[i];
        }
    }

    /* compiled from: graph_suggestion_api */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLGoodwillFriendversaryCampaign.class, new Deserializer());
        }

        public Object m7854a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLGoodwillFriendversaryCampaignDeserializer.m5012a(jsonParser, (short) 49);
            Object graphQLGoodwillFriendversaryCampaign = new GraphQLGoodwillFriendversaryCampaign();
            ((BaseModel) graphQLGoodwillFriendversaryCampaign).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLGoodwillFriendversaryCampaign instanceof Postprocessable) {
                return ((Postprocessable) graphQLGoodwillFriendversaryCampaign).a();
            }
            return graphQLGoodwillFriendversaryCampaign;
        }
    }

    /* compiled from: graph_suggestion_api */
    public class GoodwillFriendversaryCampaignExtra extends FeedUnitExtra {
        public static final Creator<GoodwillFriendversaryCampaignExtra> CREATOR = new C03471();

        /* compiled from: graph_suggestion_api */
        final class C03471 implements Creator<GoodwillFriendversaryCampaignExtra> {
            C03471() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new GoodwillFriendversaryCampaignExtra(parcel);
            }

            public final Object[] newArray(int i) {
                return new GoodwillFriendversaryCampaignExtra[i];
            }
        }

        protected GoodwillFriendversaryCampaignExtra(Parcel parcel) {
            super(parcel);
        }
    }

    /* compiled from: graph_suggestion_api */
    public final class Serializer extends JsonSerializer<GraphQLGoodwillFriendversaryCampaign> {
        public final void m7855a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLGoodwillFriendversaryCampaign graphQLGoodwillFriendversaryCampaign = (GraphQLGoodwillFriendversaryCampaign) obj;
            GraphQLGoodwillFriendversaryCampaignDeserializer.m5013a(graphQLGoodwillFriendversaryCampaign.w_(), graphQLGoodwillFriendversaryCampaign.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLGoodwillFriendversaryCampaign.class, new Serializer());
            FbSerializerProvider.a(GraphQLGoodwillFriendversaryCampaign.class, new Serializer());
        }
    }

    public final String m7863g() {
        return null;
    }

    public final /* synthetic */ FeedUnitExtra m7864j() {
        return m7856y();
    }

    public final GraphQLObjectType getType() {
        return this.f3903d;
    }

    public final String S_() {
        return null;
    }

    public final ImmutableList<String> m7862d() {
        if (m7863g() != null) {
            return ImmutableList.of(m7863g());
        }
        return RegularImmutableList.a;
    }

    @FieldOffset
    @Nullable
    public final GraphQLGoodwillThrowbackDataPointsConnection m7865k() {
        this.f3904e = (GraphQLGoodwillThrowbackDataPointsConnection) super.a(this.f3904e, 0, GraphQLGoodwillThrowbackDataPointsConnection.class);
        return this.f3904e;
    }

    @FieldOffset
    public final long T_() {
        a(0, 1);
        return this.f3905f;
    }

    public final void m7860a(long j) {
        this.f3905f = j;
    }

    @FieldOffset
    @Nullable
    public final GraphQLUser m7866l() {
        this.f3906g = (GraphQLUser) super.a(this.f3906g, 2, GraphQLUser.class);
        return this.f3906g;
    }

    @FieldOffset
    @Nullable
    public final String m7867m() {
        this.f3907h = super.a(this.f3907h, 3);
        return this.f3907h;
    }

    @FieldOffset
    @Nullable
    public final GraphQLMediaSet m7868n() {
        this.f3908i = (GraphQLMediaSet) super.a(this.f3908i, 4, GraphQLMediaSet.class);
        return this.f3908i;
    }

    @FieldOffset
    public final ImmutableList<GraphQLStoryAttachment> m7869o() {
        this.f3909j = super.a(this.f3909j, 5, GraphQLStoryAttachment.class);
        return (ImmutableList) this.f3909j;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m7870p() {
        this.f3910k = (GraphQLTextWithEntities) super.a(this.f3910k, 6, GraphQLTextWithEntities.class);
        return this.f3910k;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m7871q() {
        this.f3911l = (GraphQLTextWithEntities) super.a(this.f3911l, 7, GraphQLTextWithEntities.class);
        return this.f3911l;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m7872r() {
        this.f3912m = (GraphQLTextWithEntities) super.a(this.f3912m, 8, GraphQLTextWithEntities.class);
        return this.f3912m;
    }

    @FieldOffset
    @Nullable
    public final String m7873s() {
        this.f3913n = super.a(this.f3913n, 9);
        return this.f3913n;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m7874t() {
        this.f3914o = (GraphQLImage) super.a(this.f3914o, 10, GraphQLImage.class);
        return this.f3914o;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m7875u() {
        this.f3915p = (GraphQLTextWithEntities) super.a(this.f3915p, 11, GraphQLTextWithEntities.class);
        return this.f3915p;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m7876v() {
        this.f3916q = (GraphQLTextWithEntities) super.a(this.f3916q, 12, GraphQLTextWithEntities.class);
        return this.f3916q;
    }

    @FieldOffset
    @Nullable
    public final String m7877w() {
        this.f3917r = super.a(this.f3917r, 13);
        return this.f3917r;
    }

    @FieldOffset
    @Nullable
    public final GraphQLGoodwillVideoCampaign m7878x() {
        this.f3918s = (GraphQLGoodwillVideoCampaign) super.a(this.f3918s, 14, GraphQLGoodwillVideoCampaign.class);
        return this.f3918s;
    }

    @Nullable
    public final String m7859a() {
        return m7867m();
    }

    public final int jK_() {
        return 194164507;
    }

    public final GraphQLVisitableModel m7858a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLTextWithEntities graphQLTextWithEntities;
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m7865k() != null) {
            GraphQLGoodwillThrowbackDataPointsConnection graphQLGoodwillThrowbackDataPointsConnection = (GraphQLGoodwillThrowbackDataPointsConnection) graphQLModelMutatingVisitor.b(m7865k());
            if (m7865k() != graphQLGoodwillThrowbackDataPointsConnection) {
                graphQLVisitableModel = (GraphQLGoodwillFriendversaryCampaign) ModelHelper.a(null, this);
                graphQLVisitableModel.f3904e = graphQLGoodwillThrowbackDataPointsConnection;
            }
        }
        if (m7866l() != null) {
            GraphQLUser graphQLUser = (GraphQLUser) graphQLModelMutatingVisitor.b(m7866l());
            if (m7866l() != graphQLUser) {
                graphQLVisitableModel = (GraphQLGoodwillFriendversaryCampaign) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3906g = graphQLUser;
            }
        }
        if (m7868n() != null) {
            GraphQLMediaSet graphQLMediaSet = (GraphQLMediaSet) graphQLModelMutatingVisitor.b(m7868n());
            if (m7868n() != graphQLMediaSet) {
                graphQLVisitableModel = (GraphQLGoodwillFriendversaryCampaign) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3908i = graphQLMediaSet;
            }
        }
        if (m7869o() != null) {
            Builder a = ModelHelper.a(m7869o(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLGoodwillFriendversaryCampaign graphQLGoodwillFriendversaryCampaign = (GraphQLGoodwillFriendversaryCampaign) ModelHelper.a(graphQLVisitableModel, this);
                graphQLGoodwillFriendversaryCampaign.f3909j = a.b();
                graphQLVisitableModel = graphQLGoodwillFriendversaryCampaign;
            }
        }
        if (m7870p() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m7870p());
            if (m7870p() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLGoodwillFriendversaryCampaign) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3910k = graphQLTextWithEntities;
            }
        }
        if (m7871q() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m7871q());
            if (m7871q() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLGoodwillFriendversaryCampaign) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3911l = graphQLTextWithEntities;
            }
        }
        if (m7872r() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m7872r());
            if (m7872r() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLGoodwillFriendversaryCampaign) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3912m = graphQLTextWithEntities;
            }
        }
        if (m7874t() != null) {
            GraphQLImage graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m7874t());
            if (m7874t() != graphQLImage) {
                graphQLVisitableModel = (GraphQLGoodwillFriendversaryCampaign) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3914o = graphQLImage;
            }
        }
        if (m7875u() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m7875u());
            if (m7875u() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLGoodwillFriendversaryCampaign) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3915p = graphQLTextWithEntities;
            }
        }
        if (m7876v() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m7876v());
            if (m7876v() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLGoodwillFriendversaryCampaign) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3916q = graphQLTextWithEntities;
            }
        }
        if (m7878x() != null) {
            GraphQLGoodwillVideoCampaign graphQLGoodwillVideoCampaign = (GraphQLGoodwillVideoCampaign) graphQLModelMutatingVisitor.b(m7878x());
            if (m7878x() != graphQLGoodwillVideoCampaign) {
                graphQLVisitableModel = (GraphQLGoodwillFriendversaryCampaign) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3918s = graphQLGoodwillVideoCampaign;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLGoodwillFriendversaryCampaign() {
        super(16);
    }

    public final void m7861a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f3905f = mutableFlatBuffer.a(i, 1, 0);
    }

    public final int m7857a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m7865k());
        int a2 = ModelHelper.a(flatBufferBuilder, m7866l());
        int b = flatBufferBuilder.b(m7867m());
        int a3 = ModelHelper.a(flatBufferBuilder, m7868n());
        int a4 = ModelHelper.a(flatBufferBuilder, m7869o());
        int a5 = ModelHelper.a(flatBufferBuilder, m7870p());
        int a6 = ModelHelper.a(flatBufferBuilder, m7871q());
        int a7 = ModelHelper.a(flatBufferBuilder, m7872r());
        int b2 = flatBufferBuilder.b(m7873s());
        int a8 = ModelHelper.a(flatBufferBuilder, m7874t());
        int a9 = ModelHelper.a(flatBufferBuilder, m7875u());
        int a10 = ModelHelper.a(flatBufferBuilder, m7876v());
        int b3 = flatBufferBuilder.b(m7877w());
        int a11 = ModelHelper.a(flatBufferBuilder, m7878x());
        flatBufferBuilder.c(15);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.a(1, T_(), 0);
        flatBufferBuilder.b(2, a2);
        flatBufferBuilder.b(3, b);
        flatBufferBuilder.b(4, a3);
        flatBufferBuilder.b(5, a4);
        flatBufferBuilder.b(6, a5);
        flatBufferBuilder.b(7, a6);
        flatBufferBuilder.b(8, a7);
        flatBufferBuilder.b(9, b2);
        flatBufferBuilder.b(10, a8);
        flatBufferBuilder.b(11, a9);
        flatBufferBuilder.b(12, a10);
        flatBufferBuilder.b(13, b3);
        flatBufferBuilder.b(14, a11);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLGoodwillFriendversaryCampaign(Parcel parcel) {
        super(16);
        this.f3904e = (GraphQLGoodwillThrowbackDataPointsConnection) parcel.readValue(GraphQLGoodwillThrowbackDataPointsConnection.class.getClassLoader());
        this.f3905f = parcel.readLong();
        this.f3906g = (GraphQLUser) parcel.readValue(GraphQLUser.class.getClassLoader());
        this.f3907h = parcel.readString();
        this.f3908i = (GraphQLMediaSet) parcel.readValue(GraphQLMediaSet.class.getClassLoader());
        this.f3909j = ImmutableListHelper.a(parcel.readArrayList(GraphQLStoryAttachment.class.getClassLoader()));
        this.f3910k = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f3911l = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f3912m = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f3913n = parcel.readString();
        this.f3914o = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f3915p = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f3916q = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f3917r = parcel.readString();
        this.f3918s = (GraphQLGoodwillVideoCampaign) parcel.readValue(GraphQLGoodwillVideoCampaign.class.getClassLoader());
        this.f3919t = (GoodwillFriendversaryCampaignExtra) ParcelUtil.m3828b(parcel, GoodwillFriendversaryCampaignExtra.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m7865k());
        parcel.writeLong(T_());
        parcel.writeValue(m7866l());
        parcel.writeString(m7867m());
        parcel.writeValue(m7868n());
        parcel.writeList(m7869o());
        parcel.writeValue(m7870p());
        parcel.writeValue(m7871q());
        parcel.writeValue(m7872r());
        parcel.writeString(m7873s());
        parcel.writeValue(m7874t());
        parcel.writeValue(m7875u());
        parcel.writeValue(m7876v());
        parcel.writeString(m7877w());
        parcel.writeValue(m7878x());
        parcel.writeParcelable(m7856y(), i);
    }

    private GoodwillFriendversaryCampaignExtra m7856y() {
        if (this.f3919t == null) {
            if (this.b == null || !this.b.d) {
                this.f3919t = new GoodwillFriendversaryCampaignExtra();
            } else {
                this.f3919t = (GoodwillFriendversaryCampaignExtra) this.b.a(this.c, this, GoodwillFriendversaryCampaignExtra.class);
            }
        }
        return this.f3919t;
    }

    public final PropertyBag U_() {
        if (this.f3920u == null) {
            this.f3920u = new PropertyBag();
        }
        return this.f3920u;
    }
}
