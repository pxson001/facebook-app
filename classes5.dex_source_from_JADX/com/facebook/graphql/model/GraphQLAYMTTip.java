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
import com.facebook.graphql.deserializers.GraphQLAYMTTipDeserializer;
import com.facebook.graphql.enums.GraphQLAYMTNativeAction;
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
/* compiled from: launching_composer_for_video */
public final class GraphQLAYMTTip extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLAYMTTip> CREATOR = new C02561();
    @Nullable
    public String f3261d;
    @Nullable
    public String f3262e;
    @Nullable
    public String f3263f;
    @Nullable
    public GraphQLImage f3264g;
    public GraphQLAYMTNativeAction f3265h;
    @Nullable
    public String f3266i;
    @Nullable
    public String f3267j;
    @Nullable
    public String f3268k;
    public boolean f3269l;
    @Nullable
    public String f3270m;
    @Nullable
    public String f3271n;

    /* compiled from: launching_composer_for_video */
    final class C02561 implements Creator<GraphQLAYMTTip> {
        C02561() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLAYMTTip(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLAYMTTip[i];
        }
    }

    /* compiled from: launching_composer_for_video */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLAYMTTip.class, new Deserializer());
        }

        public Object m6368a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLAYMTTipDeserializer.m4512a(jsonParser, (short) 373);
            Object graphQLAYMTTip = new GraphQLAYMTTip();
            ((BaseModel) graphQLAYMTTip).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLAYMTTip instanceof Postprocessable) {
                return ((Postprocessable) graphQLAYMTTip).a();
            }
            return graphQLAYMTTip;
        }
    }

    /* compiled from: launching_composer_for_video */
    public final class Serializer extends JsonSerializer<GraphQLAYMTTip> {
        public final void m6369a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLAYMTTip graphQLAYMTTip = (GraphQLAYMTTip) obj;
            GraphQLAYMTTipDeserializer.m4513b(graphQLAYMTTip.w_(), graphQLAYMTTip.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLAYMTTip.class, new Serializer());
            FbSerializerProvider.a(GraphQLAYMTTip.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final String m6374j() {
        this.f3261d = super.a(this.f3261d, 0);
        return this.f3261d;
    }

    @FieldOffset
    @Nullable
    public final String m6375k() {
        this.f3262e = super.a(this.f3262e, 1);
        return this.f3262e;
    }

    @FieldOffset
    @Nullable
    public final String m6376l() {
        this.f3263f = super.a(this.f3263f, 2);
        return this.f3263f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m6377m() {
        this.f3264g = (GraphQLImage) super.a(this.f3264g, 3, GraphQLImage.class);
        return this.f3264g;
    }

    @FieldOffset
    public final GraphQLAYMTNativeAction m6378n() {
        this.f3265h = (GraphQLAYMTNativeAction) super.a(this.f3265h, 4, GraphQLAYMTNativeAction.class, GraphQLAYMTNativeAction.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f3265h;
    }

    @FieldOffset
    @Nullable
    public final String m6379o() {
        this.f3266i = super.a(this.f3266i, 5);
        return this.f3266i;
    }

    @FieldOffset
    @Nullable
    public final String m6380p() {
        this.f3267j = super.a(this.f3267j, 6);
        return this.f3267j;
    }

    @FieldOffset
    @Nullable
    public final String m6381q() {
        this.f3268k = super.a(this.f3268k, 7);
        return this.f3268k;
    }

    @FieldOffset
    public final boolean m6382r() {
        a(1, 0);
        return this.f3269l;
    }

    @FieldOffset
    @Nullable
    public final String m6383s() {
        this.f3270m = super.a(this.f3270m, 9);
        return this.f3270m;
    }

    @FieldOffset
    @Nullable
    public final String m6384t() {
        this.f3271n = super.a(this.f3271n, 10);
        return this.f3271n;
    }

    @Nullable
    public final String m6372a() {
        return m6379o();
    }

    public final int jK_() {
        return 179889212;
    }

    public final GraphQLVisitableModel m6371a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m6377m() != null) {
            GraphQLImage graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m6377m());
            if (m6377m() != graphQLImage) {
                graphQLVisitableModel = (GraphQLAYMTTip) ModelHelper.a(null, this);
                graphQLVisitableModel.f3264g = graphQLImage;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLAYMTTip() {
        super(12);
    }

    public final void m6373a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f3269l = mutableFlatBuffer.a(i, 8);
    }

    public final int m6370a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m6374j());
        int b2 = flatBufferBuilder.b(m6375k());
        int b3 = flatBufferBuilder.b(m6376l());
        int a = ModelHelper.a(flatBufferBuilder, m6377m());
        int b4 = flatBufferBuilder.b(m6379o());
        int b5 = flatBufferBuilder.b(m6380p());
        int b6 = flatBufferBuilder.b(m6381q());
        int b7 = flatBufferBuilder.b(m6383s());
        int b8 = flatBufferBuilder.b(m6384t());
        flatBufferBuilder.c(11);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, b2);
        flatBufferBuilder.b(2, b3);
        flatBufferBuilder.b(3, a);
        flatBufferBuilder.a(4, m6378n() == GraphQLAYMTNativeAction.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m6378n());
        flatBufferBuilder.b(5, b4);
        flatBufferBuilder.b(6, b5);
        flatBufferBuilder.b(7, b6);
        flatBufferBuilder.a(8, m6382r());
        flatBufferBuilder.b(9, b7);
        flatBufferBuilder.b(10, b8);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLAYMTTip(Parcel parcel) {
        super(12);
        this.f3261d = parcel.readString();
        this.f3262e = parcel.readString();
        this.f3263f = parcel.readString();
        this.f3266i = parcel.readString();
        this.f3264g = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f3268k = parcel.readString();
        this.f3269l = parcel.readByte() == (byte) 1;
        this.f3265h = GraphQLAYMTNativeAction.fromString(parcel.readString());
        this.f3270m = parcel.readString();
        this.f3271n = parcel.readString();
        this.f3267j = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m6374j());
        parcel.writeString(m6375k());
        parcel.writeString(m6376l());
        parcel.writeString(m6379o());
        parcel.writeValue(m6377m());
        parcel.writeString(m6381q());
        parcel.writeByte((byte) (m6382r() ? 1 : 0));
        parcel.writeString(m6378n().name());
        parcel.writeString(m6383s());
        parcel.writeString(m6384t());
        parcel.writeString(m6380p());
    }
}
