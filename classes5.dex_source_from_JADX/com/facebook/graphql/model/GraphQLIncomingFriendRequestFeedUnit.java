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
import com.facebook.graphql.deserializers.GraphQLIncomingFriendRequestFeedUnitDeserializer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.model.PropertyBag.HasProperty;
import com.facebook.graphql.model.extras.FeedUnitExtra;
import com.facebook.graphql.model.interfaces.CachedFeedTrackable;
import com.facebook.graphql.model.interfaces.HasTracking;
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
import com.fasterxml.jackson.databind.node.ArrayNode;
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
/* compiled from: flexibility */
public final class GraphQLIncomingFriendRequestFeedUnit extends BaseModel implements FeedUnit, HasProperty, ScrollableItemListFeedUnit, CachedFeedTrackable, HasTracking, TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLIncomingFriendRequestFeedUnit> CREATOR = new C04131();
    public GraphQLObjectType f4285d = new GraphQLObjectType(2034328781);
    @Nullable
    public String f4286e;
    @Nullable
    public String f4287f;
    public long f4288g;
    @Nullable
    public String f4289h;
    public List<GraphQLIncomingFriendRequestFeedUnitItem> f4290i;
    @Nullable
    public String f4291j;
    @Nullable
    public GraphQLTextWithEntities f4292k;
    @Nullable
    public GraphQLTextWithEntities f4293l;
    @Nullable
    public String f4294m;
    @Nullable
    public String f4295n;
    private IncomingFriendRequestFeedUnitExtra f4296o;
    @Nullable
    private PropertyBag f4297p = null;

    /* compiled from: flexibility */
    final class C04131 implements Creator<GraphQLIncomingFriendRequestFeedUnit> {
        C04131() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLIncomingFriendRequestFeedUnit(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLIncomingFriendRequestFeedUnit[i];
        }
    }

    /* compiled from: flexibility */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLIncomingFriendRequestFeedUnit.class, new Deserializer());
        }

        public Object m8639a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLIncomingFriendRequestFeedUnitDeserializer.m5235a(jsonParser, (short) 580);
            Object graphQLIncomingFriendRequestFeedUnit = new GraphQLIncomingFriendRequestFeedUnit();
            ((BaseModel) graphQLIncomingFriendRequestFeedUnit).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLIncomingFriendRequestFeedUnit instanceof Postprocessable) {
                return ((Postprocessable) graphQLIncomingFriendRequestFeedUnit).a();
            }
            return graphQLIncomingFriendRequestFeedUnit;
        }
    }

    /* compiled from: flexibility */
    public class IncomingFriendRequestFeedUnitExtra extends FeedUnitExtra {
        public static final Creator<IncomingFriendRequestFeedUnitExtra> CREATOR = new C04141();

        /* compiled from: flexibility */
        final class C04141 implements Creator<IncomingFriendRequestFeedUnitExtra> {
            C04141() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new IncomingFriendRequestFeedUnitExtra(parcel);
            }

            public final Object[] newArray(int i) {
                return new IncomingFriendRequestFeedUnitExtra[i];
            }
        }

        protected IncomingFriendRequestFeedUnitExtra(Parcel parcel) {
            super(parcel);
        }
    }

    /* compiled from: flexibility */
    public final class Serializer extends JsonSerializer<GraphQLIncomingFriendRequestFeedUnit> {
        public final void m8640a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLIncomingFriendRequestFeedUnit graphQLIncomingFriendRequestFeedUnit = (GraphQLIncomingFriendRequestFeedUnit) obj;
            GraphQLIncomingFriendRequestFeedUnitDeserializer.m5236a(graphQLIncomingFriendRequestFeedUnit.w_(), graphQLIncomingFriendRequestFeedUnit.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLIncomingFriendRequestFeedUnit.class, new Serializer());
            FbSerializerProvider.a(GraphQLIncomingFriendRequestFeedUnit.class, new Serializer());
        }
    }

    public final /* synthetic */ FeedUnitExtra m8649j() {
        return m8641x();
    }

    @Nullable
    public final ArrayNode R_() {
        return FeedTrackableUtil.a(this);
    }

    public final GraphQLObjectType getType() {
        return this.f4285d;
    }

    public final ImmutableList<String> m8647d() {
        if (m8648g() != null) {
            return ImmutableList.of(m8648g());
        }
        return RegularImmutableList.a;
    }

    public final List m8659w() {
        return ItemListFeedUnitImpl.a(this);
    }

    public final int ac_() {
        return VisibleItemHelper.a(this);
    }

    public final List m8658v() {
        return ItemListFeedUnitImpl.a(this);
    }

    @FieldOffset
    @Nullable
    public final String m8648g() {
        this.f4286e = super.a(this.f4286e, 0);
        return this.f4286e;
    }

    @FieldOffset
    @Nullable
    public final String S_() {
        this.f4287f = super.a(this.f4287f, 1);
        return this.f4287f;
    }

    @FieldOffset
    public final long T_() {
        a(0, 2);
        return this.f4288g;
    }

    public final void m8645a(long j) {
        this.f4288g = j;
    }

    @FieldOffset
    @Nullable
    public final String m8651l() {
        this.f4289h = super.a(this.f4289h, 3);
        return this.f4289h;
    }

    @FieldOffset
    public final ImmutableList<GraphQLIncomingFriendRequestFeedUnitItem> m8653o() {
        this.f4290i = super.a(this.f4290i, 4, GraphQLIncomingFriendRequestFeedUnitItem.class);
        return (ImmutableList) this.f4290i;
    }

    @FieldOffset
    @Nullable
    public final String m8654p() {
        this.f4291j = super.a(this.f4291j, 6);
        return this.f4291j;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m8655q() {
        this.f4292k = (GraphQLTextWithEntities) super.a(this.f4292k, 7, GraphQLTextWithEntities.class);
        return this.f4292k;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m8656r() {
        this.f4293l = (GraphQLTextWithEntities) super.a(this.f4293l, 8, GraphQLTextWithEntities.class);
        return this.f4293l;
    }

    @FieldOffset
    @Nullable
    public final String m8650k() {
        this.f4294m = super.a(this.f4294m, 9);
        return this.f4294m;
    }

    @FieldOffset
    @Nullable
    public final String m8657s() {
        this.f4295n = super.a(this.f4295n, 10);
        return this.f4295n;
    }

    @Nullable
    public final String m8644a() {
        return m8651l();
    }

    public final int jK_() {
        return 2034328781;
    }

    public final GraphQLVisitableModel m8643a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel;
        GraphQLTextWithEntities graphQLTextWithEntities;
        h();
        if (m8653o() != null) {
            Builder a = ModelHelper.a(m8653o(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLIncomingFriendRequestFeedUnit graphQLIncomingFriendRequestFeedUnit = (GraphQLIncomingFriendRequestFeedUnit) ModelHelper.a(null, this);
                graphQLIncomingFriendRequestFeedUnit.f4290i = a.b();
                graphQLVisitableModel = graphQLIncomingFriendRequestFeedUnit;
                if (m8655q() != null) {
                    graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m8655q());
                    if (m8655q() != graphQLTextWithEntities) {
                        graphQLVisitableModel = (GraphQLIncomingFriendRequestFeedUnit) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f4292k = graphQLTextWithEntities;
                    }
                }
                if (m8656r() != null) {
                    graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m8656r());
                    if (m8656r() != graphQLTextWithEntities) {
                        graphQLVisitableModel = (GraphQLIncomingFriendRequestFeedUnit) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f4293l = graphQLTextWithEntities;
                    }
                }
                i();
                return graphQLVisitableModel != null ? this : graphQLVisitableModel;
            }
        }
        graphQLVisitableModel = null;
        if (m8655q() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m8655q());
            if (m8655q() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLIncomingFriendRequestFeedUnit) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4292k = graphQLTextWithEntities;
            }
        }
        if (m8656r() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m8656r());
            if (m8656r() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLIncomingFriendRequestFeedUnit) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4293l = graphQLTextWithEntities;
            }
        }
        i();
        if (graphQLVisitableModel != null) {
        }
    }

    public GraphQLIncomingFriendRequestFeedUnit() {
        super(12);
    }

    public final void m8646a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f4288g = mutableFlatBuffer.a(i, 2, 0);
    }

    public final int m8642a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m8648g());
        int b2 = flatBufferBuilder.b(S_());
        int b3 = flatBufferBuilder.b(m8651l());
        int a = ModelHelper.a(flatBufferBuilder, m8653o());
        int b4 = flatBufferBuilder.b(m8654p());
        int a2 = ModelHelper.a(flatBufferBuilder, m8655q());
        int a3 = ModelHelper.a(flatBufferBuilder, m8656r());
        int b5 = flatBufferBuilder.b(m8650k());
        int b6 = flatBufferBuilder.b(m8657s());
        flatBufferBuilder.c(11);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, b2);
        flatBufferBuilder.a(2, T_(), 0);
        flatBufferBuilder.b(3, b3);
        flatBufferBuilder.b(4, a);
        flatBufferBuilder.b(6, b4);
        flatBufferBuilder.b(7, a2);
        flatBufferBuilder.b(8, a3);
        flatBufferBuilder.b(9, b5);
        flatBufferBuilder.b(10, b6);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLIncomingFriendRequestFeedUnit(Parcel parcel) {
        super(12);
        this.f4286e = parcel.readString();
        this.f4287f = parcel.readString();
        this.f4288g = parcel.readLong();
        this.f4289h = parcel.readString();
        this.f4290i = ImmutableListHelper.a(parcel.readArrayList(GraphQLIncomingFriendRequestFeedUnitItem.class.getClassLoader()));
        this.f4291j = parcel.readString();
        this.f4292k = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f4293l = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f4294m = parcel.readString();
        this.f4295n = parcel.readString();
        this.f4296o = (IncomingFriendRequestFeedUnitExtra) ParcelUtil.m3828b(parcel, IncomingFriendRequestFeedUnitExtra.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m8648g());
        parcel.writeString(S_());
        parcel.writeLong(T_());
        parcel.writeString(m8651l());
        parcel.writeList(m8653o());
        parcel.writeString(m8654p());
        parcel.writeValue(m8655q());
        parcel.writeValue(m8656r());
        parcel.writeString(m8650k());
        parcel.writeString(m8657s());
        parcel.writeParcelable(m8641x(), i);
    }

    public final GraphQLTextWithEntities m8652m() {
        return null;
    }

    private IncomingFriendRequestFeedUnitExtra m8641x() {
        if (this.f4296o == null) {
            if (this.b == null || !this.b.d) {
                this.f4296o = new IncomingFriendRequestFeedUnitExtra();
            } else {
                this.f4296o = (IncomingFriendRequestFeedUnitExtra) this.b.a(this.c, this, IncomingFriendRequestFeedUnitExtra.class);
            }
        }
        return this.f4296o;
    }

    public final PropertyBag U_() {
        if (this.f4297p == null) {
            this.f4297p = new PropertyBag();
        }
        return this.f4297p;
    }
}
