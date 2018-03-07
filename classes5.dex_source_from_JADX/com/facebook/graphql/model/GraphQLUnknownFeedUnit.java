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
import com.facebook.graphql.deserializers.GraphQLUnknownFeedUnitDeserializer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.model.PropertyBag.HasProperty;
import com.facebook.graphql.model.extras.FeedUnitExtra;
import com.facebook.graphql.modelutil.BaseModel;
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
import com.google.common.collect.RegularImmutableList;
import com.instagram.common.json.annotation.JsonType;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: Total screen power  */
public final class GraphQLUnknownFeedUnit extends BaseModel implements FeedUnit, HasProperty, TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLUnknownFeedUnit> CREATOR = new C12641();
    public GraphQLObjectType f13374d = new GraphQLObjectType(-1386278260);
    @Nullable
    public String f13375e;
    @Nullable
    public String f13376f;
    public long f13377g;
    private UnknownFeedUnitExtra f13378h;
    @Nullable
    private PropertyBag f13379i = null;

    /* compiled from: Total screen power  */
    final class C12641 implements Creator<GraphQLUnknownFeedUnit> {
        C12641() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLUnknownFeedUnit(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLUnknownFeedUnit[i];
        }
    }

    /* compiled from: Total screen power  */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLUnknownFeedUnit.class, new Deserializer());
        }

        public Object m22339a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLUnknownFeedUnitDeserializer.m6140a(jsonParser, (short) 415);
            Object graphQLUnknownFeedUnit = new GraphQLUnknownFeedUnit();
            ((BaseModel) graphQLUnknownFeedUnit).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLUnknownFeedUnit instanceof Postprocessable) {
                return ((Postprocessable) graphQLUnknownFeedUnit).a();
            }
            return graphQLUnknownFeedUnit;
        }
    }

    /* compiled from: Total screen power  */
    public final class Serializer extends JsonSerializer<GraphQLUnknownFeedUnit> {
        public final void m22340a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLUnknownFeedUnit graphQLUnknownFeedUnit = (GraphQLUnknownFeedUnit) obj;
            GraphQLUnknownFeedUnitDeserializer.m6141a(graphQLUnknownFeedUnit.w_(), graphQLUnknownFeedUnit.u_(), jsonGenerator);
        }

        static {
            FbSerializerProvider.a(GraphQLUnknownFeedUnit.class, new Serializer());
            FbSerializerProvider.a(GraphQLUnknownFeedUnit.class, new Serializer());
        }
    }

    /* compiled from: Total screen power  */
    public class UnknownFeedUnitExtra extends FeedUnitExtra {
        public static final Creator<UnknownFeedUnitExtra> CREATOR = new C12651();

        /* compiled from: Total screen power  */
        final class C12651 implements Creator<UnknownFeedUnitExtra> {
            C12651() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new UnknownFeedUnitExtra(parcel);
            }

            public final Object[] newArray(int i) {
                return new UnknownFeedUnitExtra[i];
            }
        }

        protected UnknownFeedUnitExtra(Parcel parcel) {
            super(parcel);
        }
    }

    public final /* synthetic */ FeedUnitExtra m22349j() {
        return m22341k();
    }

    public final GraphQLObjectType getType() {
        return this.f13374d;
    }

    public final ImmutableList<String> m22347d() {
        if (m22348g() != null) {
            return ImmutableList.of(m22348g());
        }
        return RegularImmutableList.a;
    }

    @FieldOffset
    @Nullable
    public final String m22348g() {
        this.f13375e = super.a(this.f13375e, 0);
        return this.f13375e;
    }

    @FieldOffset
    @Nullable
    public final String S_() {
        this.f13376f = super.a(this.f13376f, 1);
        return this.f13376f;
    }

    @FieldOffset
    public final long T_() {
        a(0, 2);
        return this.f13377g;
    }

    public final void m22345a(long j) {
        this.f13377g = j;
    }

    @Nullable
    public final String m22344a() {
        return m22348g();
    }

    public final int jK_() {
        return -1386278260;
    }

    public final GraphQLVisitableModel m22343a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public GraphQLUnknownFeedUnit() {
        super(4);
    }

    public final void m22346a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f13377g = mutableFlatBuffer.a(i, 2, 0);
    }

    public final int m22342a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m22348g());
        int b2 = flatBufferBuilder.b(S_());
        flatBufferBuilder.c(3);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, b2);
        flatBufferBuilder.a(2, T_(), 0);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLUnknownFeedUnit(Parcel parcel) {
        super(4);
        this.f13375e = parcel.readString();
        this.f13376f = parcel.readString();
        this.f13377g = parcel.readLong();
        this.f13378h = (UnknownFeedUnitExtra) ParcelUtil.m3828b(parcel, UnknownFeedUnitExtra.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m22348g());
        parcel.writeString(S_());
        parcel.writeLong(T_());
        parcel.writeParcelable(m22341k(), i);
    }

    private UnknownFeedUnitExtra m22341k() {
        if (this.f13378h == null) {
            if (this.b == null || !this.b.d) {
                this.f13378h = new UnknownFeedUnitExtra();
            } else {
                this.f13378h = (UnknownFeedUnitExtra) this.b.a(this.c, this, UnknownFeedUnitExtra.class);
            }
        }
        return this.f13378h;
    }

    public final PropertyBag U_() {
        if (this.f13379i == null) {
            this.f13379i = new PropertyBag();
        }
        return this.f13379i;
    }
}
