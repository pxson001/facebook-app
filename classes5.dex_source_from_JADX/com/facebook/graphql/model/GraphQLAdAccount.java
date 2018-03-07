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
import com.facebook.graphql.deserializers.GraphQLAdAccountDeserializer;
import com.facebook.graphql.enums.GraphQLAdAccountStatus;
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
import com.instagram.common.json.annotation.JsonType;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: last_update */
public final class GraphQLAdAccount extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLAdAccount> CREATOR = new C02571();
    @Nullable
    public String f3274d;
    public GraphQLAdAccountStatus f3275e;
    @Nullable
    public GraphQLCurrencyQuantity f3276f;
    @Nullable
    public GraphQLCurrencyQuantity f3277g;
    public boolean f3278h;
    @Nullable
    public String f3279i;
    @Nullable
    public String f3280j;
    @Nullable
    public FeedUnit f3281k;
    public boolean f3282l;
    @Nullable
    public String f3283m;
    @Nullable
    public String f3284n;
    @Nullable
    public GraphQLCurrencyQuantity f3285o;
    @Nullable
    public GraphQLCurrencyQuantity f3286p;
    @Nullable
    public String f3287q;
    @Nullable
    public String f3288r;
    @Nullable
    public GraphQLTimezoneInfo f3289s;
    @Nullable
    public String f3290t;
    @Nullable
    public GraphQLCurrencyQuantity f3291u;
    @Nullable
    public String f3292v;

    /* compiled from: last_update */
    final class C02571 implements Creator<GraphQLAdAccount> {
        C02571() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLAdAccount(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLAdAccount[i];
        }
    }

    /* compiled from: last_update */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLAdAccount.class, new Deserializer());
        }

        public Object m6400a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLAdAccountDeserializer.m4523a(jsonParser, (short) 6);
            Object graphQLAdAccount = new GraphQLAdAccount();
            ((BaseModel) graphQLAdAccount).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLAdAccount instanceof Postprocessable) {
                return ((Postprocessable) graphQLAdAccount).a();
            }
            return graphQLAdAccount;
        }
    }

    /* compiled from: last_update */
    public final class Serializer extends JsonSerializer<GraphQLAdAccount> {
        public final void m6401a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLAdAccount graphQLAdAccount = (GraphQLAdAccount) obj;
            GraphQLAdAccountDeserializer.m4524a(graphQLAdAccount.w_(), graphQLAdAccount.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLAdAccount.class, new Serializer());
            FbSerializerProvider.a(GraphQLAdAccount.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final String m6408j() {
        this.f3274d = super.a(this.f3274d, 0);
        return this.f3274d;
    }

    @FieldOffset
    public final GraphQLAdAccountStatus m6409k() {
        this.f3275e = (GraphQLAdAccountStatus) super.a(this.f3275e, 1, GraphQLAdAccountStatus.class, GraphQLAdAccountStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f3275e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLCurrencyQuantity m6410l() {
        this.f3276f = (GraphQLCurrencyQuantity) super.a(this.f3276f, 2, GraphQLCurrencyQuantity.class);
        return this.f3276f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLCurrencyQuantity m6411m() {
        this.f3277g = (GraphQLCurrencyQuantity) super.a(this.f3277g, 3, GraphQLCurrencyQuantity.class);
        return this.f3277g;
    }

    @FieldOffset
    public final boolean m6412n() {
        a(0, 4);
        return this.f3278h;
    }

    @FieldOffset
    @Nullable
    public final String m6413o() {
        this.f3279i = super.a(this.f3279i, 5);
        return this.f3279i;
    }

    @FieldOffset
    @Nullable
    public final String m6414p() {
        this.f3280j = super.a(this.f3280j, 6);
        return this.f3280j;
    }

    @FieldOffset
    @Nullable
    public final FeedUnit m6415q() {
        this.f3281k = (FeedUnit) super.a(this.f3281k, 7, VirtualFlattenableResolverImpl.a);
        return this.f3281k;
    }

    @FieldOffset
    public final boolean m6416r() {
        a(1, 0);
        return this.f3282l;
    }

    @FieldOffset
    @Nullable
    public final String m6417s() {
        this.f3283m = super.a(this.f3283m, 9);
        return this.f3283m;
    }

    @FieldOffset
    @Nullable
    public final String m6418t() {
        this.f3284n = super.a(this.f3284n, 10);
        return this.f3284n;
    }

    @FieldOffset
    @Nullable
    public final GraphQLCurrencyQuantity m6419u() {
        this.f3285o = (GraphQLCurrencyQuantity) super.a(this.f3285o, 11, GraphQLCurrencyQuantity.class);
        return this.f3285o;
    }

    @FieldOffset
    @Nullable
    public final GraphQLCurrencyQuantity m6420v() {
        this.f3286p = (GraphQLCurrencyQuantity) super.a(this.f3286p, 12, GraphQLCurrencyQuantity.class);
        return this.f3286p;
    }

    @FieldOffset
    @Nullable
    public final String m6421w() {
        this.f3287q = super.a(this.f3287q, 13);
        return this.f3287q;
    }

    @FieldOffset
    @Nullable
    public final String m6422x() {
        this.f3288r = super.a(this.f3288r, 14);
        return this.f3288r;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTimezoneInfo m6423y() {
        this.f3289s = (GraphQLTimezoneInfo) super.a(this.f3289s, 15, GraphQLTimezoneInfo.class);
        return this.f3289s;
    }

    @FieldOffset
    @Nullable
    public final String m6424z() {
        this.f3290t = super.a(this.f3290t, 16);
        return this.f3290t;
    }

    @FieldOffset
    @Nullable
    public final GraphQLCurrencyQuantity m6402A() {
        this.f3291u = (GraphQLCurrencyQuantity) super.a(this.f3291u, 17, GraphQLCurrencyQuantity.class);
        return this.f3291u;
    }

    @FieldOffset
    @Nullable
    public final String m6403B() {
        this.f3292v = super.a(this.f3292v, 18);
        return this.f3292v;
    }

    @Nullable
    public final String m6406a() {
        return m6417s();
    }

    public final int jK_() {
        return 1449252970;
    }

    public final GraphQLVisitableModel m6405a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLCurrencyQuantity graphQLCurrencyQuantity;
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m6410l() != null) {
            graphQLCurrencyQuantity = (GraphQLCurrencyQuantity) graphQLModelMutatingVisitor.b(m6410l());
            if (m6410l() != graphQLCurrencyQuantity) {
                graphQLVisitableModel = (GraphQLAdAccount) ModelHelper.a(null, this);
                graphQLVisitableModel.f3276f = graphQLCurrencyQuantity;
            }
        }
        if (m6411m() != null) {
            graphQLCurrencyQuantity = (GraphQLCurrencyQuantity) graphQLModelMutatingVisitor.b(m6411m());
            if (m6411m() != graphQLCurrencyQuantity) {
                graphQLVisitableModel = (GraphQLAdAccount) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3277g = graphQLCurrencyQuantity;
            }
        }
        if (m6415q() != null) {
            FeedUnit feedUnit = (FeedUnit) graphQLModelMutatingVisitor.b(m6415q());
            if (m6415q() != feedUnit) {
                graphQLVisitableModel = (GraphQLAdAccount) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3281k = feedUnit;
            }
        }
        if (m6419u() != null) {
            graphQLCurrencyQuantity = (GraphQLCurrencyQuantity) graphQLModelMutatingVisitor.b(m6419u());
            if (m6419u() != graphQLCurrencyQuantity) {
                graphQLVisitableModel = (GraphQLAdAccount) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3285o = graphQLCurrencyQuantity;
            }
        }
        if (m6420v() != null) {
            graphQLCurrencyQuantity = (GraphQLCurrencyQuantity) graphQLModelMutatingVisitor.b(m6420v());
            if (m6420v() != graphQLCurrencyQuantity) {
                graphQLVisitableModel = (GraphQLAdAccount) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3286p = graphQLCurrencyQuantity;
            }
        }
        if (m6402A() != null) {
            graphQLCurrencyQuantity = (GraphQLCurrencyQuantity) graphQLModelMutatingVisitor.b(m6402A());
            if (m6402A() != graphQLCurrencyQuantity) {
                graphQLVisitableModel = (GraphQLAdAccount) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3291u = graphQLCurrencyQuantity;
            }
        }
        if (m6423y() != null) {
            GraphQLTimezoneInfo graphQLTimezoneInfo = (GraphQLTimezoneInfo) graphQLModelMutatingVisitor.b(m6423y());
            if (m6423y() != graphQLTimezoneInfo) {
                graphQLVisitableModel = (GraphQLAdAccount) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3289s = graphQLTimezoneInfo;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLAdAccount() {
        super(20);
    }

    public final void m6407a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f3278h = mutableFlatBuffer.a(i, 4);
        this.f3282l = mutableFlatBuffer.a(i, 8);
    }

    public final int m6404a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m6408j());
        int a = ModelHelper.a(flatBufferBuilder, m6410l());
        int a2 = ModelHelper.a(flatBufferBuilder, m6411m());
        int b2 = flatBufferBuilder.b(m6413o());
        int b3 = flatBufferBuilder.b(m6414p());
        int a3 = flatBufferBuilder.a(m6415q(), VirtualFlattenableResolverImpl.a);
        int b4 = flatBufferBuilder.b(m6417s());
        int b5 = flatBufferBuilder.b(m6418t());
        int a4 = ModelHelper.a(flatBufferBuilder, m6419u());
        int a5 = ModelHelper.a(flatBufferBuilder, m6420v());
        int b6 = flatBufferBuilder.b(m6421w());
        int b7 = flatBufferBuilder.b(m6422x());
        int a6 = ModelHelper.a(flatBufferBuilder, m6423y());
        int b8 = flatBufferBuilder.b(m6424z());
        int a7 = ModelHelper.a(flatBufferBuilder, m6402A());
        int b9 = flatBufferBuilder.b(m6403B());
        flatBufferBuilder.c(19);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.a(1, m6409k() == GraphQLAdAccountStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m6409k());
        flatBufferBuilder.b(2, a);
        flatBufferBuilder.b(3, a2);
        flatBufferBuilder.a(4, m6412n());
        flatBufferBuilder.b(5, b2);
        flatBufferBuilder.b(6, b3);
        flatBufferBuilder.b(7, a3);
        flatBufferBuilder.a(8, m6416r());
        flatBufferBuilder.b(9, b4);
        flatBufferBuilder.b(10, b5);
        flatBufferBuilder.b(11, a4);
        flatBufferBuilder.b(12, a5);
        flatBufferBuilder.b(13, b6);
        flatBufferBuilder.b(14, b7);
        flatBufferBuilder.b(15, a6);
        flatBufferBuilder.b(16, b8);
        flatBufferBuilder.b(17, a7);
        flatBufferBuilder.b(18, b9);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLAdAccount(Parcel parcel) {
        boolean z = true;
        super(20);
        this.f3274d = parcel.readString();
        this.f3275e = GraphQLAdAccountStatus.fromString(parcel.readString());
        this.f3276f = (GraphQLCurrencyQuantity) parcel.readValue(GraphQLCurrencyQuantity.class.getClassLoader());
        this.f3277g = (GraphQLCurrencyQuantity) parcel.readValue(GraphQLCurrencyQuantity.class.getClassLoader());
        this.f3278h = parcel.readByte() == (byte) 1;
        this.f3279i = parcel.readString();
        this.f3280j = parcel.readString();
        this.f3281k = (FeedUnit) parcel.readValue(FeedUnit.class.getClassLoader());
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.f3282l = z;
        this.f3283m = parcel.readString();
        this.f3284n = parcel.readString();
        this.f3285o = (GraphQLCurrencyQuantity) parcel.readValue(GraphQLCurrencyQuantity.class.getClassLoader());
        this.f3286p = (GraphQLCurrencyQuantity) parcel.readValue(GraphQLCurrencyQuantity.class.getClassLoader());
        this.f3287q = parcel.readString();
        this.f3288r = parcel.readString();
        this.f3291u = (GraphQLCurrencyQuantity) parcel.readValue(GraphQLCurrencyQuantity.class.getClassLoader());
        this.f3292v = parcel.readString();
        this.f3289s = (GraphQLTimezoneInfo) parcel.readValue(GraphQLTimezoneInfo.class.getClassLoader());
        this.f3290t = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeString(m6408j());
        parcel.writeString(m6409k().name());
        parcel.writeValue(m6410l());
        parcel.writeValue(m6411m());
        parcel.writeByte((byte) (m6412n() ? 1 : 0));
        parcel.writeString(m6413o());
        parcel.writeString(m6414p());
        parcel.writeValue(m6415q());
        if (!m6416r()) {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeString(m6417s());
        parcel.writeString(m6418t());
        parcel.writeValue(m6419u());
        parcel.writeValue(m6420v());
        parcel.writeString(m6421w());
        parcel.writeString(m6422x());
        parcel.writeValue(m6402A());
        parcel.writeString(m6403B());
        parcel.writeValue(m6423y());
        parcel.writeString(m6424z());
    }
}
