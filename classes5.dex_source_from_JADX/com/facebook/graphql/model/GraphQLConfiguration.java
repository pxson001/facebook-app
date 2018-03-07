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
import com.facebook.graphql.deserializers.GraphQLConfigurationDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
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
/* compiled from: isSentryWarningWithUserConfirmationRequired */
public final class GraphQLConfiguration extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLConfiguration> CREATOR = new C02881();
    public boolean f3491d;
    @Nullable
    public String f3492e;
    public boolean f3493f;
    @Nullable
    public String f3494g;
    @Nullable
    public String f3495h;
    @Nullable
    public String f3496i;
    public int f3497j;

    /* compiled from: isSentryWarningWithUserConfirmationRequired */
    final class C02881 implements Creator<GraphQLConfiguration> {
        C02881() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLConfiguration(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLConfiguration[i];
        }
    }

    /* compiled from: isSentryWarningWithUserConfirmationRequired */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLConfiguration.class, new Deserializer());
        }

        public Object m6845a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLConfigurationDeserializer.m4675a(jsonParser, (short) 544);
            Object graphQLConfiguration = new GraphQLConfiguration();
            ((BaseModel) graphQLConfiguration).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLConfiguration instanceof Postprocessable) {
                return ((Postprocessable) graphQLConfiguration).a();
            }
            return graphQLConfiguration;
        }
    }

    /* compiled from: isSentryWarningWithUserConfirmationRequired */
    public final class Serializer extends JsonSerializer<GraphQLConfiguration> {
        public final void m6846a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLConfiguration graphQLConfiguration = (GraphQLConfiguration) obj;
            GraphQLConfigurationDeserializer.m4676a(graphQLConfiguration.w_(), graphQLConfiguration.u_(), jsonGenerator);
        }

        static {
            FbSerializerProvider.a(GraphQLConfiguration.class, new Serializer());
            FbSerializerProvider.a(GraphQLConfiguration.class, new Serializer());
        }
    }

    @FieldOffset
    public final boolean m6850a() {
        a(0, 0);
        return this.f3491d;
    }

    @FieldOffset
    @Nullable
    public final String m6851j() {
        this.f3492e = super.a(this.f3492e, 1);
        return this.f3492e;
    }

    @FieldOffset
    public final boolean m6852k() {
        a(0, 2);
        return this.f3493f;
    }

    @FieldOffset
    @Nullable
    public final String m6853l() {
        this.f3494g = super.a(this.f3494g, 3);
        return this.f3494g;
    }

    @FieldOffset
    @Nullable
    public final String m6854m() {
        this.f3495h = super.a(this.f3495h, 4);
        return this.f3495h;
    }

    @FieldOffset
    @Nullable
    public final String m6855n() {
        this.f3496i = super.a(this.f3496i, 5);
        return this.f3496i;
    }

    @FieldOffset
    public final int m6856o() {
        a(0, 6);
        return this.f3497j;
    }

    public final int jK_() {
        return -1563253546;
    }

    public final GraphQLVisitableModel m6848a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public GraphQLConfiguration() {
        super(8);
    }

    public final void m6849a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f3491d = mutableFlatBuffer.a(i, 0);
        this.f3493f = mutableFlatBuffer.a(i, 2);
        this.f3497j = mutableFlatBuffer.a(i, 6, 0);
    }

    public final int m6847a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m6851j());
        int b2 = flatBufferBuilder.b(m6853l());
        int b3 = flatBufferBuilder.b(m6854m());
        int b4 = flatBufferBuilder.b(m6855n());
        flatBufferBuilder.c(7);
        flatBufferBuilder.a(0, m6850a());
        flatBufferBuilder.b(1, b);
        flatBufferBuilder.a(2, m6852k());
        flatBufferBuilder.b(3, b2);
        flatBufferBuilder.b(4, b3);
        flatBufferBuilder.b(5, b4);
        flatBufferBuilder.a(6, m6856o(), 0);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLConfiguration(Parcel parcel) {
        boolean z = true;
        super(8);
        this.f3491d = parcel.readByte() == (byte) 1;
        this.f3492e = parcel.readString();
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.f3493f = z;
        this.f3494g = parcel.readString();
        this.f3495h = parcel.readString();
        this.f3496i = parcel.readString();
        this.f3497j = parcel.readInt();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeByte((byte) (m6850a() ? 1 : 0));
        parcel.writeString(m6851j());
        if (!m6852k()) {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeString(m6853l());
        parcel.writeString(m6854m());
        parcel.writeString(m6855n());
        parcel.writeInt(m6856o());
    }
}
