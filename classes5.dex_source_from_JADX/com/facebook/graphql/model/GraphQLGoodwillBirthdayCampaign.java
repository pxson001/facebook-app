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
import com.facebook.graphql.deserializers.GraphQLGoodwillBirthdayCampaignDeserializer;
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
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: group_commerce_item_description */
public final class GraphQLGoodwillBirthdayCampaign extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLGoodwillBirthdayCampaign> CREATOR = new C03411();
    @Nullable
    GraphQLProfile f3872d;
    @Nullable
    String f3873e;
    @Nullable
    GraphQLGoodwillBirthdayCampaignPostingActorsConnection f3874f;
    @Nullable
    GraphQLTextWithEntities f3875g;
    @Nullable
    String f3876h;
    List<GraphQLImageOverlay> f3877i;

    /* compiled from: group_commerce_item_description */
    final class C03411 implements Creator<GraphQLGoodwillBirthdayCampaign> {
        C03411() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLGoodwillBirthdayCampaign(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLGoodwillBirthdayCampaign[i];
        }
    }

    /* compiled from: group_commerce_item_description */
    public class Builder extends com.facebook.graphql.modelutil.BaseModel.Builder {
        @Nullable
        public GraphQLProfile f3866d;
        @Nullable
        public String f3867e;
        public ImmutableList<GraphQLImageOverlay> f3868f;
        @Nullable
        public GraphQLGoodwillBirthdayCampaignPostingActorsConnection f3869g;
        @Nullable
        public GraphQLTextWithEntities f3870h;
        @Nullable
        public String f3871i;

        public Builder() {
            Preconditions.checkState(this instanceof Builder);
        }
    }

    /* compiled from: group_commerce_item_description */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLGoodwillBirthdayCampaign.class, new Deserializer());
        }

        public Object m7797a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLGoodwillBirthdayCampaignDeserializer.m5003a(jsonParser, (short) 48);
            Object graphQLGoodwillBirthdayCampaign = new GraphQLGoodwillBirthdayCampaign();
            ((BaseModel) graphQLGoodwillBirthdayCampaign).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLGoodwillBirthdayCampaign instanceof Postprocessable) {
                return ((Postprocessable) graphQLGoodwillBirthdayCampaign).a();
            }
            return graphQLGoodwillBirthdayCampaign;
        }
    }

    /* compiled from: group_commerce_item_description */
    public final class Serializer extends JsonSerializer<GraphQLGoodwillBirthdayCampaign> {
        public final void m7798a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLGoodwillBirthdayCampaign graphQLGoodwillBirthdayCampaign = (GraphQLGoodwillBirthdayCampaign) obj;
            GraphQLGoodwillBirthdayCampaignDeserializer.m5004a(graphQLGoodwillBirthdayCampaign.w_(), graphQLGoodwillBirthdayCampaign.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLGoodwillBirthdayCampaign.class, new Serializer());
            FbSerializerProvider.a(GraphQLGoodwillBirthdayCampaign.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLProfile m7802j() {
        this.f3872d = (GraphQLProfile) super.a(this.f3872d, 0, GraphQLProfile.class);
        return this.f3872d;
    }

    @FieldOffset
    @Nullable
    public final String m7803k() {
        this.f3873e = super.a(this.f3873e, 1);
        return this.f3873e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLGoodwillBirthdayCampaignPostingActorsConnection m7804l() {
        this.f3874f = (GraphQLGoodwillBirthdayCampaignPostingActorsConnection) super.a(this.f3874f, 2, GraphQLGoodwillBirthdayCampaignPostingActorsConnection.class);
        return this.f3874f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m7805m() {
        this.f3875g = (GraphQLTextWithEntities) super.a(this.f3875g, 3, GraphQLTextWithEntities.class);
        return this.f3875g;
    }

    @FieldOffset
    @Nullable
    public final String m7806n() {
        this.f3876h = super.a(this.f3876h, 4);
        return this.f3876h;
    }

    @FieldOffset
    public final ImmutableList<GraphQLImageOverlay> m7807o() {
        this.f3877i = super.a(this.f3877i, 5, GraphQLImageOverlay.class);
        return (ImmutableList) this.f3877i;
    }

    @Nullable
    public final String m7801a() {
        return m7803k();
    }

    public final int jK_() {
        return -538251524;
    }

    public final GraphQLVisitableModel m7800a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m7802j() != null) {
            GraphQLProfile graphQLProfile = (GraphQLProfile) graphQLModelMutatingVisitor.b(m7802j());
            if (m7802j() != graphQLProfile) {
                graphQLVisitableModel = (GraphQLGoodwillBirthdayCampaign) ModelHelper.a(null, this);
                graphQLVisitableModel.f3872d = graphQLProfile;
            }
        }
        if (m7807o() != null) {
            com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m7807o(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLGoodwillBirthdayCampaign graphQLGoodwillBirthdayCampaign = (GraphQLGoodwillBirthdayCampaign) ModelHelper.a(graphQLVisitableModel, this);
                graphQLGoodwillBirthdayCampaign.f3877i = a.b();
                graphQLVisitableModel = graphQLGoodwillBirthdayCampaign;
            }
        }
        if (m7804l() != null) {
            GraphQLGoodwillBirthdayCampaignPostingActorsConnection graphQLGoodwillBirthdayCampaignPostingActorsConnection = (GraphQLGoodwillBirthdayCampaignPostingActorsConnection) graphQLModelMutatingVisitor.b(m7804l());
            if (m7804l() != graphQLGoodwillBirthdayCampaignPostingActorsConnection) {
                graphQLVisitableModel = (GraphQLGoodwillBirthdayCampaign) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3874f = graphQLGoodwillBirthdayCampaignPostingActorsConnection;
            }
        }
        if (m7805m() != null) {
            GraphQLTextWithEntities graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m7805m());
            if (m7805m() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLGoodwillBirthdayCampaign) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3875g = graphQLTextWithEntities;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLGoodwillBirthdayCampaign() {
        super(7);
    }

    public final int m7799a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m7802j());
        int b = flatBufferBuilder.b(m7803k());
        int a2 = ModelHelper.a(flatBufferBuilder, m7804l());
        int a3 = ModelHelper.a(flatBufferBuilder, m7805m());
        int b2 = flatBufferBuilder.b(m7806n());
        int a4 = ModelHelper.a(flatBufferBuilder, m7807o());
        flatBufferBuilder.c(6);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, b);
        flatBufferBuilder.b(2, a2);
        flatBufferBuilder.b(3, a3);
        flatBufferBuilder.b(4, b2);
        flatBufferBuilder.b(5, a4);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLGoodwillBirthdayCampaign(Parcel parcel) {
        super(7);
        this.f3872d = (GraphQLProfile) parcel.readValue(GraphQLProfile.class.getClassLoader());
        this.f3873e = parcel.readString();
        this.f3877i = ImmutableListHelper.a(parcel.readArrayList(GraphQLImageOverlay.class.getClassLoader()));
        this.f3874f = (GraphQLGoodwillBirthdayCampaignPostingActorsConnection) parcel.readValue(GraphQLGoodwillBirthdayCampaignPostingActorsConnection.class.getClassLoader());
        this.f3875g = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f3876h = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m7802j());
        parcel.writeString(m7803k());
        parcel.writeList(m7807o());
        parcel.writeValue(m7804l());
        parcel.writeValue(m7805m());
        parcel.writeString(m7806n());
    }

    public GraphQLGoodwillBirthdayCampaign(Builder builder) {
        super(7);
        this.b = builder.a;
        this.c = builder.b;
        this.f3872d = builder.f3866d;
        this.f3873e = builder.f3867e;
        this.f3877i = builder.f3868f;
        this.f3874f = builder.f3869g;
        this.f3875g = builder.f3870h;
        this.f3876h = builder.f3871i;
    }
}
