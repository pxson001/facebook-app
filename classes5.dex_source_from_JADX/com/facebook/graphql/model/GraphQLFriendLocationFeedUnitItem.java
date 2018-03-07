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
import com.facebook.graphql.deserializers.GraphQLFriendLocationFeedUnitItemDeserializer;
import com.facebook.graphql.enums.GraphQLFriendLocationCategory;
import com.facebook.graphql.model.PropertyBag.HasProperty;
import com.facebook.graphql.model.interfaces.HasTracking;
import com.facebook.graphql.model.interfaces.ItemListFeedUnitItem;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
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
/* compiled from: hc */
public final class GraphQLFriendLocationFeedUnitItem extends BaseModel implements HasProperty, HasTracking, ItemListFeedUnitItem, TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLFriendLocationFeedUnitItem> CREATOR = new C03291();
    @Nullable
    GraphQLLocation f3779d;
    @Nullable
    String f3780e;
    GraphQLFriendLocationCategory f3781f;
    @Nullable
    GraphQLTextWithEntities f3782g;
    @Nullable
    GraphQLUser f3783h;
    double f3784i;
    @Nullable
    String f3785j;
    @Nullable
    String f3786k;
    List<GraphQLFriendsLocationsCluster> f3787l;
    @Nullable
    GraphQLTextWithEntities f3788m;
    @Nullable
    private PropertyBag f3789n = null;

    /* compiled from: hc */
    final class C03291 implements Creator<GraphQLFriendLocationFeedUnitItem> {
        C03291() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLFriendLocationFeedUnitItem(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLFriendLocationFeedUnitItem[i];
        }
    }

    /* compiled from: hc */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLFriendLocationFeedUnitItem.class, new Deserializer());
        }

        public Object m7563a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLFriendLocationFeedUnitItemDeserializer.m4935a(jsonParser, (short) 360);
            Object graphQLFriendLocationFeedUnitItem = new GraphQLFriendLocationFeedUnitItem();
            ((BaseModel) graphQLFriendLocationFeedUnitItem).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLFriendLocationFeedUnitItem instanceof Postprocessable) {
                return ((Postprocessable) graphQLFriendLocationFeedUnitItem).a();
            }
            return graphQLFriendLocationFeedUnitItem;
        }
    }

    /* compiled from: hc */
    public final class Serializer extends JsonSerializer<GraphQLFriendLocationFeedUnitItem> {
        public final void m7564a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLFriendLocationFeedUnitItem graphQLFriendLocationFeedUnitItem = (GraphQLFriendLocationFeedUnitItem) obj;
            GraphQLFriendLocationFeedUnitItemDeserializer.m4938b(graphQLFriendLocationFeedUnitItem.w_(), graphQLFriendLocationFeedUnitItem.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLFriendLocationFeedUnitItem.class, new Serializer());
            FbSerializerProvider.a(GraphQLFriendLocationFeedUnitItem.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLLocation m7568j() {
        this.f3779d = (GraphQLLocation) super.a(this.f3779d, 0, GraphQLLocation.class);
        return this.f3779d;
    }

    @FieldOffset
    @Nullable
    public final String m7570l() {
        this.f3780e = super.a(this.f3780e, 1);
        return this.f3780e;
    }

    @FieldOffset
    public final GraphQLFriendLocationCategory m7571m() {
        this.f3781f = (GraphQLFriendLocationCategory) super.a(this.f3781f, 2, GraphQLFriendLocationCategory.class, GraphQLFriendLocationCategory.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f3781f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m7572n() {
        this.f3782g = (GraphQLTextWithEntities) super.a(this.f3782g, 3, GraphQLTextWithEntities.class);
        return this.f3782g;
    }

    @FieldOffset
    @Nullable
    public final GraphQLUser m7573o() {
        this.f3783h = (GraphQLUser) super.a(this.f3783h, 4, GraphQLUser.class);
        return this.f3783h;
    }

    @FieldOffset
    public final double m7574p() {
        a(0, 5);
        return this.f3784i;
    }

    @FieldOffset
    @Nullable
    public final String m7569k() {
        this.f3785j = super.a(this.f3785j, 6);
        return this.f3785j;
    }

    @FieldOffset
    @Nullable
    public final String m7575q() {
        this.f3786k = super.a(this.f3786k, 7);
        return this.f3786k;
    }

    @FieldOffset
    public final ImmutableList<GraphQLFriendsLocationsCluster> m7576r() {
        this.f3787l = super.a(this.f3787l, 8, GraphQLFriendsLocationsCluster.class);
        return (ImmutableList) this.f3787l;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m7577s() {
        this.f3788m = (GraphQLTextWithEntities) super.a(this.f3788m, 9, GraphQLTextWithEntities.class);
        return this.f3788m;
    }

    public final int jK_() {
        return -746414424;
    }

    public final GraphQLVisitableModel m7566a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLTextWithEntities graphQLTextWithEntities;
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m7568j() != null) {
            GraphQLLocation graphQLLocation = (GraphQLLocation) graphQLModelMutatingVisitor.b(m7568j());
            if (m7568j() != graphQLLocation) {
                graphQLVisitableModel = (GraphQLFriendLocationFeedUnitItem) ModelHelper.a(null, this);
                graphQLVisitableModel.f3779d = graphQLLocation;
            }
        }
        if (m7576r() != null) {
            Builder a = ModelHelper.a(m7576r(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLFriendLocationFeedUnitItem graphQLFriendLocationFeedUnitItem = (GraphQLFriendLocationFeedUnitItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLFriendLocationFeedUnitItem.f3787l = a.b();
                graphQLVisitableModel = graphQLFriendLocationFeedUnitItem;
            }
        }
        if (m7572n() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m7572n());
            if (m7572n() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLFriendLocationFeedUnitItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3782g = graphQLTextWithEntities;
            }
        }
        if (m7573o() != null) {
            GraphQLUser graphQLUser = (GraphQLUser) graphQLModelMutatingVisitor.b(m7573o());
            if (m7573o() != graphQLUser) {
                graphQLVisitableModel = (GraphQLFriendLocationFeedUnitItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3783h = graphQLUser;
            }
        }
        if (m7577s() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m7577s());
            if (m7577s() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLFriendLocationFeedUnitItem) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3788m = graphQLTextWithEntities;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLFriendLocationFeedUnitItem() {
        super(11);
    }

    public final void m7567a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f3784i = mutableFlatBuffer.a(i, 5, 0.0d);
    }

    public final int m7565a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m7568j());
        int b = flatBufferBuilder.b(m7570l());
        int a2 = ModelHelper.a(flatBufferBuilder, m7572n());
        int a3 = ModelHelper.a(flatBufferBuilder, m7573o());
        int b2 = flatBufferBuilder.b(m7569k());
        int b3 = flatBufferBuilder.b(m7575q());
        int a4 = ModelHelper.a(flatBufferBuilder, m7576r());
        int a5 = ModelHelper.a(flatBufferBuilder, m7577s());
        flatBufferBuilder.c(10);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, b);
        flatBufferBuilder.a(2, m7571m() == GraphQLFriendLocationCategory.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m7571m());
        flatBufferBuilder.b(3, a2);
        flatBufferBuilder.b(4, a3);
        flatBufferBuilder.a(5, m7574p(), 0.0d);
        flatBufferBuilder.b(6, b2);
        flatBufferBuilder.b(7, b3);
        flatBufferBuilder.b(8, a4);
        flatBufferBuilder.b(9, a5);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLFriendLocationFeedUnitItem(Parcel parcel) {
        super(11);
        this.f3779d = (GraphQLLocation) parcel.readValue(GraphQLLocation.class.getClassLoader());
        this.f3787l = ImmutableListHelper.a(parcel.readArrayList(GraphQLFriendsLocationsCluster.class.getClassLoader()));
        this.f3780e = parcel.readString();
        this.f3781f = GraphQLFriendLocationCategory.fromString(parcel.readString());
        this.f3782g = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f3783h = (GraphQLUser) parcel.readValue(GraphQLUser.class.getClassLoader());
        this.f3784i = parcel.readDouble();
        this.f3786k = parcel.readString();
        this.f3788m = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f3785j = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m7568j());
        parcel.writeList(m7576r());
        parcel.writeString(m7570l());
        parcel.writeString(m7571m().name());
        parcel.writeValue(m7572n());
        parcel.writeValue(m7573o());
        parcel.writeDouble(m7574p());
        parcel.writeString(m7575q());
        parcel.writeValue(m7577s());
        parcel.writeString(m7569k());
    }

    public final PropertyBag U_() {
        if (this.f3789n == null) {
            this.f3789n = new PropertyBag();
        }
        return this.f3789n;
    }
}
