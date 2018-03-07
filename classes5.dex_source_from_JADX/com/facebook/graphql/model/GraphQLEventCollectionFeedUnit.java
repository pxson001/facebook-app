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
import com.facebook.graphql.deserializers.GraphQLEventCollectionFeedUnitDeserializer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.model.PropertyBag.HasProperty;
import com.facebook.graphql.model.extras.FeedUnitExtra;
import com.facebook.graphql.model.interfaces.CachedFeedTrackable;
import com.facebook.graphql.model.interfaces.FollowUpFeedUnit;
import com.facebook.graphql.model.interfaces.HasTracking;
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
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: install_id */
public final class GraphQLEventCollectionFeedUnit extends BaseModel implements FeedAttachable, FeedUnit, HasProperty, ScrollableItemListFeedUnit, CachedFeedTrackable, FollowUpFeedUnit, HasTracking, TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLEventCollectionFeedUnit> CREATOR = new C03051();
    public GraphQLObjectType f3613d = new GraphQLObjectType(-1322509030);
    @Nullable
    public String f3614e;
    @Nullable
    public String f3615f;
    @Nullable
    public GraphQLTextWithEntities f3616g;
    public long f3617h;
    @Nullable
    public String f3618i;
    @Nullable
    public GraphQLEventCollectionToItemConnection f3619j;
    @Nullable
    public GraphQLTextWithEntities f3620k;
    @Nullable
    public String f3621l;
    private EventCollectionFeedUnitExtra f3622m;
    @Nullable
    private PropertyBag f3623n = null;

    /* compiled from: install_id */
    final class C03051 implements Creator<GraphQLEventCollectionFeedUnit> {
        C03051() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLEventCollectionFeedUnit(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLEventCollectionFeedUnit[i];
        }
    }

    /* compiled from: install_id */
    public class Builder extends com.facebook.graphql.modelutil.BaseModel.Builder {
        @Nullable
        public String f3604d;
        @Nullable
        public String f3605e;
        @Nullable
        public GraphQLTextWithEntities f3606f;
        public long f3607g;
        @Nullable
        public String f3608h;
        @Nullable
        public GraphQLEventCollectionToItemConnection f3609i;
        @Nullable
        public GraphQLTextWithEntities f3610j;
        @Nullable
        public String f3611k;
        @Nullable
        public PropertyBag f3612l = null;

        public Builder() {
            Preconditions.checkState(this instanceof Builder);
        }
    }

    /* compiled from: install_id */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLEventCollectionFeedUnit.class, new Deserializer());
        }

        public Object m7124a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLEventCollectionFeedUnitDeserializer.m4777a(jsonParser, (short) 132);
            Object graphQLEventCollectionFeedUnit = new GraphQLEventCollectionFeedUnit();
            ((BaseModel) graphQLEventCollectionFeedUnit).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLEventCollectionFeedUnit instanceof Postprocessable) {
                return ((Postprocessable) graphQLEventCollectionFeedUnit).a();
            }
            return graphQLEventCollectionFeedUnit;
        }
    }

    /* compiled from: install_id */
    public class EventCollectionFeedUnitExtra extends FeedUnitExtra {
        public static final Creator<EventCollectionFeedUnitExtra> CREATOR = new C03061();

        /* compiled from: install_id */
        final class C03061 implements Creator<EventCollectionFeedUnitExtra> {
            C03061() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new EventCollectionFeedUnitExtra(parcel);
            }

            public final Object[] newArray(int i) {
                return new EventCollectionFeedUnitExtra[i];
            }
        }

        protected EventCollectionFeedUnitExtra(Parcel parcel) {
            super(parcel);
        }
    }

    /* compiled from: install_id */
    public final class Serializer extends JsonSerializer<GraphQLEventCollectionFeedUnit> {
        public final void m7125a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLEventCollectionFeedUnit graphQLEventCollectionFeedUnit = (GraphQLEventCollectionFeedUnit) obj;
            GraphQLEventCollectionFeedUnitDeserializer.m4778a(graphQLEventCollectionFeedUnit.w_(), graphQLEventCollectionFeedUnit.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLEventCollectionFeedUnit.class, new Serializer());
            FbSerializerProvider.a(GraphQLEventCollectionFeedUnit.class, new Serializer());
        }
    }

    public final /* synthetic */ FeedUnitExtra m7134j() {
        return m7126t();
    }

    public final /* synthetic */ List m7142v() {
        return m7136l();
    }

    @Nullable
    public final ArrayNode R_() {
        return FeedTrackableUtil.a(this);
    }

    public final GraphQLObjectType getType() {
        return this.f3613d;
    }

    public final ImmutableList<String> m7132d() {
        if (m7133g() != null) {
            return ImmutableList.of(m7133g());
        }
        return RegularImmutableList.a;
    }

    public final List m7143w() {
        return ItemListFeedUnitImpl.a(this);
    }

    public final int ac_() {
        return VisibleItemHelper.a(this);
    }

    public final ImmutableList m7136l() {
        return ItemListFeedUnitImpl.a(this);
    }

    @FieldOffset
    @Nullable
    public final String m7133g() {
        this.f3614e = super.a(this.f3614e, 0);
        return this.f3614e;
    }

    @FieldOffset
    @Nullable
    public final String S_() {
        this.f3615f = super.a(this.f3615f, 1);
        return this.f3615f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m7138o() {
        this.f3616g = (GraphQLTextWithEntities) super.a(this.f3616g, 2, GraphQLTextWithEntities.class);
        return this.f3616g;
    }

    @FieldOffset
    public final long T_() {
        a(0, 3);
        return this.f3617h;
    }

    public final void m7130a(long j) {
        this.f3617h = j;
    }

    @FieldOffset
    @Nullable
    public final String m7139p() {
        this.f3618i = super.a(this.f3618i, 4);
        return this.f3618i;
    }

    @FieldOffset
    @Nullable
    public final GraphQLEventCollectionToItemConnection m7140q() {
        this.f3619j = (GraphQLEventCollectionToItemConnection) super.a(this.f3619j, 5, GraphQLEventCollectionToItemConnection.class);
        return this.f3619j;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m7141r() {
        this.f3620k = (GraphQLTextWithEntities) super.a(this.f3620k, 6, GraphQLTextWithEntities.class);
        return this.f3620k;
    }

    @FieldOffset
    @Nullable
    public final String m7135k() {
        this.f3621l = super.a(this.f3621l, 7);
        return this.f3621l;
    }

    @Nullable
    public final String m7129a() {
        return m7133g();
    }

    public final int jK_() {
        return -1322509030;
    }

    public final GraphQLVisitableModel m7128a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLTextWithEntities graphQLTextWithEntities;
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m7138o() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m7138o());
            if (m7138o() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLEventCollectionFeedUnit) ModelHelper.a(null, this);
                graphQLVisitableModel.f3616g = graphQLTextWithEntities;
            }
        }
        if (m7140q() != null) {
            GraphQLEventCollectionToItemConnection graphQLEventCollectionToItemConnection = (GraphQLEventCollectionToItemConnection) graphQLModelMutatingVisitor.b(m7140q());
            if (m7140q() != graphQLEventCollectionToItemConnection) {
                graphQLVisitableModel = (GraphQLEventCollectionFeedUnit) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3619j = graphQLEventCollectionToItemConnection;
            }
        }
        if (m7141r() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m7141r());
            if (m7141r() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLEventCollectionFeedUnit) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3620k = graphQLTextWithEntities;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLEventCollectionFeedUnit() {
        super(9);
    }

    public final void m7131a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f3617h = mutableFlatBuffer.a(i, 3, 0);
    }

    public final int m7127a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m7133g());
        int b2 = flatBufferBuilder.b(S_());
        int a = ModelHelper.a(flatBufferBuilder, m7138o());
        int b3 = flatBufferBuilder.b(m7139p());
        int a2 = ModelHelper.a(flatBufferBuilder, m7140q());
        int a3 = ModelHelper.a(flatBufferBuilder, m7141r());
        int b4 = flatBufferBuilder.b(m7135k());
        flatBufferBuilder.c(8);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, b2);
        flatBufferBuilder.b(2, a);
        flatBufferBuilder.a(3, T_(), 0);
        flatBufferBuilder.b(4, b3);
        flatBufferBuilder.b(5, a2);
        flatBufferBuilder.b(6, a3);
        flatBufferBuilder.b(7, b4);
        i();
        return flatBufferBuilder.d();
    }

    public final GraphQLTextWithEntities m7137m() {
        return m7138o();
    }

    public GraphQLEventCollectionFeedUnit(Parcel parcel) {
        super(9);
        this.f3614e = parcel.readString();
        this.f3615f = parcel.readString();
        this.f3616g = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f3617h = parcel.readLong();
        this.f3618i = parcel.readString();
        this.f3619j = (GraphQLEventCollectionToItemConnection) parcel.readValue(GraphQLEventCollectionToItemConnection.class.getClassLoader());
        this.f3620k = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f3621l = parcel.readString();
        this.f3622m = (EventCollectionFeedUnitExtra) ParcelUtil.m3828b(parcel, EventCollectionFeedUnitExtra.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m7133g());
        parcel.writeString(S_());
        parcel.writeValue(m7138o());
        parcel.writeLong(T_());
        parcel.writeString(m7139p());
        parcel.writeValue(m7140q());
        parcel.writeValue(m7141r());
        parcel.writeString(m7135k());
        parcel.writeParcelable(m7126t(), i);
    }

    public GraphQLEventCollectionFeedUnit(Builder builder) {
        super(9);
        this.b = builder.a;
        this.c = builder.b;
        this.f3614e = builder.f3604d;
        this.f3615f = builder.f3605e;
        this.f3616g = builder.f3606f;
        this.f3617h = builder.f3607g;
        this.f3618i = builder.f3608h;
        this.f3619j = builder.f3609i;
        this.f3620k = builder.f3610j;
        this.f3621l = builder.f3611k;
        this.f3623n = builder.f3612l;
    }

    private EventCollectionFeedUnitExtra m7126t() {
        if (this.f3622m == null) {
            if (this.b == null || !this.b.d) {
                this.f3622m = new EventCollectionFeedUnitExtra();
            } else {
                this.f3622m = (EventCollectionFeedUnitExtra) this.b.a(this.c, this, EventCollectionFeedUnitExtra.class);
            }
        }
        return this.f3622m;
    }

    public final PropertyBag U_() {
        if (this.f3623n == null) {
            this.f3623n = new PropertyBag();
        }
        return this.f3623n;
    }
}
