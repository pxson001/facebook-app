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
import com.facebook.graphql.deserializers.GraphQLClientBumpingPlaceHolderFeedUnitDeserializer;
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
/* compiled from: is_compulsory */
public final class GraphQLClientBumpingPlaceHolderFeedUnit extends BaseModel implements FeedUnit, HasProperty, TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLClientBumpingPlaceHolderFeedUnit> CREATOR = new C02841();
    public GraphQLObjectType f3438d = new GraphQLObjectType(391633076);
    @Nullable
    public String f3439e;
    @Nullable
    public String f3440f;
    @Nullable
    public String f3441g;
    public long f3442h;
    @Nullable
    public String f3443i;
    @Nullable
    public String f3444j;
    private ClientBumpingPlaceHolderFeedUnitExtra f3445k;
    @Nullable
    private PropertyBag f3446l = null;

    /* compiled from: is_compulsory */
    final class C02841 implements Creator<GraphQLClientBumpingPlaceHolderFeedUnit> {
        C02841() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLClientBumpingPlaceHolderFeedUnit(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLClientBumpingPlaceHolderFeedUnit[i];
        }
    }

    /* compiled from: is_compulsory */
    public class ClientBumpingPlaceHolderFeedUnitExtra extends FeedUnitExtra {
        public static final Creator<ClientBumpingPlaceHolderFeedUnitExtra> CREATOR = new C02851();

        /* compiled from: is_compulsory */
        final class C02851 implements Creator<ClientBumpingPlaceHolderFeedUnitExtra> {
            C02851() {
            }

            public final Object createFromParcel(Parcel parcel) {
                return new ClientBumpingPlaceHolderFeedUnitExtra(parcel);
            }

            public final Object[] newArray(int i) {
                return new ClientBumpingPlaceHolderFeedUnitExtra[i];
            }
        }

        protected ClientBumpingPlaceHolderFeedUnitExtra(Parcel parcel) {
            super(parcel);
        }
    }

    /* compiled from: is_compulsory */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLClientBumpingPlaceHolderFeedUnit.class, new Deserializer());
        }

        public Object m6774a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLClientBumpingPlaceHolderFeedUnitDeserializer.m4652a(jsonParser, (short) 131);
            Object graphQLClientBumpingPlaceHolderFeedUnit = new GraphQLClientBumpingPlaceHolderFeedUnit();
            ((BaseModel) graphQLClientBumpingPlaceHolderFeedUnit).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLClientBumpingPlaceHolderFeedUnit instanceof Postprocessable) {
                return ((Postprocessable) graphQLClientBumpingPlaceHolderFeedUnit).a();
            }
            return graphQLClientBumpingPlaceHolderFeedUnit;
        }
    }

    /* compiled from: is_compulsory */
    public final class Serializer extends JsonSerializer<GraphQLClientBumpingPlaceHolderFeedUnit> {
        public final void m6775a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLClientBumpingPlaceHolderFeedUnit graphQLClientBumpingPlaceHolderFeedUnit = (GraphQLClientBumpingPlaceHolderFeedUnit) obj;
            GraphQLClientBumpingPlaceHolderFeedUnitDeserializer.m4653a(graphQLClientBumpingPlaceHolderFeedUnit.w_(), graphQLClientBumpingPlaceHolderFeedUnit.u_(), jsonGenerator);
        }

        static {
            FbSerializerProvider.a(GraphQLClientBumpingPlaceHolderFeedUnit.class, new Serializer());
            FbSerializerProvider.a(GraphQLClientBumpingPlaceHolderFeedUnit.class, new Serializer());
        }
    }

    public final /* synthetic */ FeedUnitExtra m6784j() {
        return m6776n();
    }

    public final GraphQLObjectType getType() {
        return this.f3438d;
    }

    public final ImmutableList<String> m6782d() {
        if (m6783g() != null) {
            return ImmutableList.of(m6783g());
        }
        return RegularImmutableList.a;
    }

    @FieldOffset
    @Nullable
    public final String m6785k() {
        this.f3439e = super.a(this.f3439e, 0);
        return this.f3439e;
    }

    @FieldOffset
    @Nullable
    public final String m6783g() {
        this.f3440f = super.a(this.f3440f, 1);
        return this.f3440f;
    }

    @FieldOffset
    @Nullable
    public final String S_() {
        this.f3441g = super.a(this.f3441g, 2);
        return this.f3441g;
    }

    @FieldOffset
    public final long T_() {
        a(0, 3);
        return this.f3442h;
    }

    public final void m6780a(long j) {
        this.f3442h = j;
    }

    @FieldOffset
    @Nullable
    public final String m6786l() {
        this.f3443i = super.a(this.f3443i, 4);
        return this.f3443i;
    }

    @FieldOffset
    @Nullable
    public final String m6787m() {
        this.f3444j = super.a(this.f3444j, 5);
        return this.f3444j;
    }

    @Nullable
    public final String m6779a() {
        return m6783g();
    }

    public final int jK_() {
        return 391633076;
    }

    public final GraphQLVisitableModel m6778a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public GraphQLClientBumpingPlaceHolderFeedUnit() {
        super(7);
    }

    public final void m6781a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f3442h = mutableFlatBuffer.a(i, 3, 0);
    }

    public final int m6777a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m6785k());
        int b2 = flatBufferBuilder.b(m6783g());
        int b3 = flatBufferBuilder.b(S_());
        int b4 = flatBufferBuilder.b(m6786l());
        int b5 = flatBufferBuilder.b(m6787m());
        flatBufferBuilder.c(6);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, b2);
        flatBufferBuilder.b(2, b3);
        flatBufferBuilder.a(3, T_(), 0);
        flatBufferBuilder.b(4, b4);
        flatBufferBuilder.b(5, b5);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLClientBumpingPlaceHolderFeedUnit(Parcel parcel) {
        super(7);
        this.f3439e = parcel.readString();
        this.f3440f = parcel.readString();
        this.f3441g = parcel.readString();
        this.f3442h = parcel.readLong();
        this.f3443i = parcel.readString();
        this.f3444j = parcel.readString();
        this.f3445k = (ClientBumpingPlaceHolderFeedUnitExtra) ParcelUtil.m3828b(parcel, ClientBumpingPlaceHolderFeedUnitExtra.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m6785k());
        parcel.writeString(m6783g());
        parcel.writeString(S_());
        parcel.writeLong(T_());
        parcel.writeString(m6786l());
        parcel.writeString(m6787m());
        parcel.writeParcelable(m6776n(), i);
    }

    private ClientBumpingPlaceHolderFeedUnitExtra m6776n() {
        if (this.f3445k == null) {
            if (this.b == null || !this.b.d) {
                this.f3445k = new ClientBumpingPlaceHolderFeedUnitExtra();
            } else {
                this.f3445k = (ClientBumpingPlaceHolderFeedUnitExtra) this.b.a(this.c, this, ClientBumpingPlaceHolderFeedUnitExtra.class);
            }
        }
        return this.f3445k;
    }

    public final PropertyBag U_() {
        if (this.f3446l == null) {
            this.f3446l = new PropertyBag();
        }
        return this.f3446l;
    }
}
