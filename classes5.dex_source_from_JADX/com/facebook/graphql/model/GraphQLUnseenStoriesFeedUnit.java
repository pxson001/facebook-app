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
import com.facebook.graphql.deserializers.GraphQLUnseenStoriesFeedUnitDeserializer;
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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: Total FB percent used is */
public final class GraphQLUnseenStoriesFeedUnit extends BaseModel implements FeedAttachable, FeedUnit, HasProperty, ScrollableItemListFeedUnit, CachedFeedTrackable, FollowUpFeedUnit, HasTracking, TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLUnseenStoriesFeedUnit> CREATOR = new C12661();
    public GraphQLObjectType f13380d = new GraphQLObjectType(-1080337823);
    @Nullable
    public String f13381e;
    @Nullable
    public String f13382f;
    public long f13383g;
    @Nullable
    public String f13384h;
    @Nullable
    public GraphQLActor f13385i;
    @Nullable
    public String f13386j;
    @Nullable
    public GraphQLTextWithEntities f13387k;
    @Nullable
    public GraphQLTextWithEntities f13388l;
    @Nullable
    public String f13389m;
    @Nullable
    public String f13390n;
    private UnseenStoriesFeedUnitExtra f13391o;
    @Nullable
    private PropertyBag f13392p = null;

    /* compiled from: Total FB percent used is */
    final class C12661 implements Creator<GraphQLUnseenStoriesFeedUnit> {
        C12661() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLUnseenStoriesFeedUnit(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLUnseenStoriesFeedUnit[i];
        }
    }

    /* compiled from: Total FB percent used is */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLUnseenStoriesFeedUnit.class, new Deserializer());
        }

        public Object m22358a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLUnseenStoriesFeedUnitDeserializer.m6146a(jsonParser, (short) 41);
            Object graphQLUnseenStoriesFeedUnit = new GraphQLUnseenStoriesFeedUnit();
            ((BaseModel) graphQLUnseenStoriesFeedUnit).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLUnseenStoriesFeedUnit instanceof Postprocessable) {
                return ((Postprocessable) graphQLUnseenStoriesFeedUnit).a();
            }
            return graphQLUnseenStoriesFeedUnit;
        }
    }

    /* compiled from: Total FB percent used is */
    public final class Serializer extends JsonSerializer<GraphQLUnseenStoriesFeedUnit> {
        public final void m22359a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLUnseenStoriesFeedUnit graphQLUnseenStoriesFeedUnit = (GraphQLUnseenStoriesFeedUnit) obj;
            GraphQLUnseenStoriesFeedUnitDeserializer.m6147a(graphQLUnseenStoriesFeedUnit.w_(), graphQLUnseenStoriesFeedUnit.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLUnseenStoriesFeedUnit.class, new Serializer());
            FbSerializerProvider.a(GraphQLUnseenStoriesFeedUnit.class, new Serializer());
        }
    }

    /* compiled from: Total FB percent used is */
    public class UnseenStoriesFeedUnitExtra extends FeedUnitExtra {
        public static final Creator<UnseenStoriesFeedUnitExtra> CREATOR = new C12671();

        /* compiled from: Total FB percent used is */
        final class C12671 implements Creator<UnseenStoriesFeedUnitExtra> {
            C12671() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new UnseenStoriesFeedUnitExtra(parcel);
            }

            public final Object[] newArray(int i) {
                return new UnseenStoriesFeedUnitExtra[i];
            }
        }

        protected UnseenStoriesFeedUnitExtra(Parcel parcel) {
            super(parcel);
        }
    }

    public final /* synthetic */ FeedUnitExtra m22368j() {
        return m22360x();
    }

    @Nullable
    public final ArrayNode R_() {
        return FeedTrackableUtil.a(this);
    }

    public final GraphQLObjectType getType() {
        return this.f13380d;
    }

    public final ImmutableList<String> m22366d() {
        if (m22367g() != null) {
            return ImmutableList.of(m22367g());
        }
        return RegularImmutableList.a;
    }

    public final List m22378w() {
        return ItemListFeedUnitImpl.a(this);
    }

    public final int ac_() {
        return VisibleItemHelper.a(this);
    }

    public final List m22377v() {
        return ItemListFeedUnitImpl.a(this);
    }

    @FieldOffset
    @Nullable
    public final String m22367g() {
        this.f13381e = super.a(this.f13381e, 0);
        return this.f13381e;
    }

    @FieldOffset
    @Nullable
    public final String S_() {
        this.f13382f = super.a(this.f13382f, 1);
        return this.f13382f;
    }

    @FieldOffset
    public final long T_() {
        a(0, 2);
        return this.f13383g;
    }

    public final void m22364a(long j) {
        this.f13383g = j;
    }

    @FieldOffset
    @Nullable
    public final String m22370l() {
        this.f13384h = super.a(this.f13384h, 3);
        return this.f13384h;
    }

    @FieldOffset
    @Nullable
    public final GraphQLActor m22372o() {
        this.f13385i = (GraphQLActor) super.a(this.f13385i, 4, GraphQLActor.class);
        return this.f13385i;
    }

    @FieldOffset
    @Nullable
    public final String m22373p() {
        this.f13386j = super.a(this.f13386j, 6);
        return this.f13386j;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m22374q() {
        this.f13387k = (GraphQLTextWithEntities) super.a(this.f13387k, 7, GraphQLTextWithEntities.class);
        return this.f13387k;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m22375r() {
        this.f13388l = (GraphQLTextWithEntities) super.a(this.f13388l, 8, GraphQLTextWithEntities.class);
        return this.f13388l;
    }

    @FieldOffset
    @Nullable
    public final String m22369k() {
        this.f13389m = super.a(this.f13389m, 9);
        return this.f13389m;
    }

    @FieldOffset
    @Nullable
    public final String m22376s() {
        this.f13390n = super.a(this.f13390n, 10);
        return this.f13390n;
    }

    @Nullable
    public final String m22363a() {
        return m22370l();
    }

    public final int jK_() {
        return -1080337823;
    }

    public final GraphQLVisitableModel m22362a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLTextWithEntities graphQLTextWithEntities;
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m22372o() != null) {
            GraphQLActor graphQLActor = (GraphQLActor) graphQLModelMutatingVisitor.b(m22372o());
            if (m22372o() != graphQLActor) {
                graphQLVisitableModel = (GraphQLUnseenStoriesFeedUnit) ModelHelper.a(null, this);
                graphQLVisitableModel.f13385i = graphQLActor;
            }
        }
        if (m22374q() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m22374q());
            if (m22374q() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLUnseenStoriesFeedUnit) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f13387k = graphQLTextWithEntities;
            }
        }
        if (m22375r() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m22375r());
            if (m22375r() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLUnseenStoriesFeedUnit) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f13388l = graphQLTextWithEntities;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLUnseenStoriesFeedUnit() {
        super(12);
    }

    public final void m22365a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f13383g = mutableFlatBuffer.a(i, 2, 0);
    }

    public final int m22361a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m22367g());
        int b2 = flatBufferBuilder.b(S_());
        int b3 = flatBufferBuilder.b(m22370l());
        int a = ModelHelper.a(flatBufferBuilder, m22372o());
        int b4 = flatBufferBuilder.b(m22373p());
        int a2 = ModelHelper.a(flatBufferBuilder, m22374q());
        int a3 = ModelHelper.a(flatBufferBuilder, m22375r());
        int b5 = flatBufferBuilder.b(m22369k());
        int b6 = flatBufferBuilder.b(m22376s());
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

    public GraphQLUnseenStoriesFeedUnit(Parcel parcel) {
        super(12);
        this.f13381e = parcel.readString();
        this.f13382f = parcel.readString();
        this.f13383g = parcel.readLong();
        this.f13384h = parcel.readString();
        this.f13385i = (GraphQLActor) parcel.readValue(GraphQLActor.class.getClassLoader());
        this.f13386j = parcel.readString();
        this.f13387k = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f13388l = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f13389m = parcel.readString();
        this.f13390n = parcel.readString();
        this.f13391o = (UnseenStoriesFeedUnitExtra) ParcelUtil.m3828b(parcel, UnseenStoriesFeedUnitExtra.class);
    }

    public final GraphQLTextWithEntities m22371m() {
        return m22371m();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m22367g());
        parcel.writeString(S_());
        parcel.writeLong(T_());
        parcel.writeString(m22370l());
        parcel.writeValue(m22372o());
        parcel.writeString(m22373p());
        parcel.writeValue(m22374q());
        parcel.writeValue(m22375r());
        parcel.writeString(m22369k());
        parcel.writeString(m22376s());
        parcel.writeParcelable(m22360x(), i);
    }

    private UnseenStoriesFeedUnitExtra m22360x() {
        if (this.f13391o == null) {
            if (this.b == null || !this.b.d) {
                this.f13391o = new UnseenStoriesFeedUnitExtra();
            } else {
                this.f13391o = (UnseenStoriesFeedUnitExtra) this.b.a(this.c, this, UnseenStoriesFeedUnitExtra.class);
            }
        }
        return this.f13391o;
    }

    public final PropertyBag U_() {
        if (this.f13392p == null) {
            this.f13392p = new PropertyBag();
        }
        return this.f13392p;
    }
}
