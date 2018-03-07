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
import com.facebook.graphql.deserializers.GraphQLLeadGenLegalContentCheckboxDeserializer;
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
/* compiled from: feed_promotion_favicon */
public final class GraphQLLeadGenLegalContentCheckbox extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLLeadGenLegalContentCheckbox> CREATOR = new C04241();
    @Nullable
    GraphQLTextWithEntities f4383d;
    @Nullable
    String f4384e;
    boolean f4385f;
    boolean f4386g;
    @Nullable
    String f4387h;
    @Nullable
    String f4388i;

    /* compiled from: feed_promotion_favicon */
    final class C04241 implements Creator<GraphQLLeadGenLegalContentCheckbox> {
        C04241() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLLeadGenLegalContentCheckbox(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLLeadGenLegalContentCheckbox[i];
        }
    }

    /* compiled from: feed_promotion_favicon */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLLeadGenLegalContentCheckbox.class, new Deserializer());
        }

        public Object m8862a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLLeadGenLegalContentCheckboxDeserializer.m5300a(jsonParser, (short) 28);
            Object graphQLLeadGenLegalContentCheckbox = new GraphQLLeadGenLegalContentCheckbox();
            ((BaseModel) graphQLLeadGenLegalContentCheckbox).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLLeadGenLegalContentCheckbox instanceof Postprocessable) {
                return ((Postprocessable) graphQLLeadGenLegalContentCheckbox).a();
            }
            return graphQLLeadGenLegalContentCheckbox;
        }
    }

    /* compiled from: feed_promotion_favicon */
    public final class Serializer extends JsonSerializer<GraphQLLeadGenLegalContentCheckbox> {
        public final void m8863a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLLeadGenLegalContentCheckbox graphQLLeadGenLegalContentCheckbox = (GraphQLLeadGenLegalContentCheckbox) obj;
            GraphQLLeadGenLegalContentCheckboxDeserializer.m5301b(graphQLLeadGenLegalContentCheckbox.w_(), graphQLLeadGenLegalContentCheckbox.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLLeadGenLegalContentCheckbox.class, new Serializer());
            FbSerializerProvider.a(GraphQLLeadGenLegalContentCheckbox.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m8868j() {
        this.f4383d = (GraphQLTextWithEntities) super.a(this.f4383d, 0, GraphQLTextWithEntities.class);
        return this.f4383d;
    }

    @FieldOffset
    @Nullable
    public final String m8869k() {
        this.f4384e = super.a(this.f4384e, 1);
        return this.f4384e;
    }

    @FieldOffset
    public final boolean m8870l() {
        a(0, 2);
        return this.f4385f;
    }

    @FieldOffset
    public final boolean m8871m() {
        a(0, 3);
        return this.f4386g;
    }

    @FieldOffset
    @Nullable
    public final String m8872n() {
        this.f4387h = super.a(this.f4387h, 4);
        return this.f4387h;
    }

    @FieldOffset
    @Nullable
    public final String m8873o() {
        this.f4388i = super.a(this.f4388i, 5);
        return this.f4388i;
    }

    @Nullable
    public final String m8866a() {
        return m8869k();
    }

    public final int jK_() {
        return -1082774601;
    }

    public final GraphQLVisitableModel m8865a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m8868j() != null) {
            GraphQLTextWithEntities graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m8868j());
            if (m8868j() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLLeadGenLegalContentCheckbox) ModelHelper.a(null, this);
                graphQLVisitableModel.f4383d = graphQLTextWithEntities;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLLeadGenLegalContentCheckbox() {
        super(7);
    }

    public final void m8867a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f4385f = mutableFlatBuffer.a(i, 2);
        this.f4386g = mutableFlatBuffer.a(i, 3);
    }

    public final int m8864a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m8868j());
        int b = flatBufferBuilder.b(m8869k());
        int b2 = flatBufferBuilder.b(m8872n());
        int b3 = flatBufferBuilder.b(m8873o());
        flatBufferBuilder.c(6);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, b);
        flatBufferBuilder.a(2, m8870l());
        flatBufferBuilder.a(3, m8871m());
        flatBufferBuilder.b(4, b2);
        flatBufferBuilder.b(5, b3);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLLeadGenLegalContentCheckbox(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        super(7);
        this.f4383d = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f4384e = parcel.readString();
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f4385f = z;
        if (parcel.readByte() != (byte) 1) {
            z2 = false;
        }
        this.f4386g = z2;
        this.f4387h = parcel.readString();
        this.f4388i = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeValue(m8868j());
        parcel.writeString(m8869k());
        if (m8870l()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (!m8871m()) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        parcel.writeString(m8872n());
        parcel.writeString(m8873o());
    }
}
