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
import com.facebook.graphql.deserializers.GraphQLReactionUnitDeserializer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLReactionUnitCollapseState;
import com.facebook.graphql.enums.GraphQLReactionUnitStyle;
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
/* compiled from: VIEW */
public final class GraphQLReactionUnit extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLReactionUnit> CREATOR = new C12031();
    @Nullable
    public GraphQLObjectType f12888d;
    public GraphQLReactionUnitCollapseState f12889e;
    public boolean f12890f;
    @Nullable
    public String f12891g;
    @Nullable
    public GraphQLPage f12892h;
    @Nullable
    public String f12893i;
    public int f12894j;
    public GraphQLReactionUnitStyle f12895k;
    @Nullable
    public String f12896l;
    @Nullable
    public GraphQLTextWithEntities f12897m;
    @Nullable
    public GraphQLMedia f12898n;

    /* compiled from: VIEW */
    final class C12031 implements Creator<GraphQLReactionUnit> {
        C12031() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLReactionUnit(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLReactionUnit[i];
        }
    }

    /* compiled from: VIEW */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLReactionUnit.class, new Deserializer());
        }

        public Object m21322a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLReactionUnitDeserializer.m5785a(jsonParser, (short) 388);
            Object graphQLReactionUnit = new GraphQLReactionUnit();
            ((BaseModel) graphQLReactionUnit).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLReactionUnit instanceof Postprocessable) {
                return ((Postprocessable) graphQLReactionUnit).a();
            }
            return graphQLReactionUnit;
        }
    }

    /* compiled from: VIEW */
    public final class Serializer extends JsonSerializer<GraphQLReactionUnit> {
        public final void m21323a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLReactionUnit graphQLReactionUnit = (GraphQLReactionUnit) obj;
            GraphQLReactionUnitDeserializer.m5786a(graphQLReactionUnit.w_(), graphQLReactionUnit.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLReactionUnit.class, new Serializer());
            FbSerializerProvider.a(GraphQLReactionUnit.class, new Serializer());
        }
    }

    @Nullable
    public final GraphQLObjectType m21328j() {
        if (this.b != null && this.f12888d == null) {
            this.f12888d = new GraphQLObjectType(this.b.b(this.c, 0));
        }
        if (this.f12888d == null || this.f12888d.g() != 0) {
            return this.f12888d;
        }
        return null;
    }

    @FieldOffset
    public final GraphQLReactionUnitCollapseState m21329k() {
        this.f12889e = (GraphQLReactionUnitCollapseState) super.a(this.f12889e, 1, GraphQLReactionUnitCollapseState.class, GraphQLReactionUnitCollapseState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f12889e;
    }

    @FieldOffset
    public final boolean m21330l() {
        a(0, 2);
        return this.f12890f;
    }

    @FieldOffset
    @Nullable
    public final String m21331m() {
        this.f12891g = super.a(this.f12891g, 3);
        return this.f12891g;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPage m21332n() {
        this.f12892h = (GraphQLPage) super.a(this.f12892h, 5, GraphQLPage.class);
        return this.f12892h;
    }

    @FieldOffset
    @Nullable
    public final String m21333o() {
        this.f12893i = super.a(this.f12893i, 6);
        return this.f12893i;
    }

    @FieldOffset
    public final int m21334p() {
        a(0, 7);
        return this.f12894j;
    }

    @FieldOffset
    public final GraphQLReactionUnitStyle m21335q() {
        this.f12895k = (GraphQLReactionUnitStyle) super.a(this.f12895k, 8, GraphQLReactionUnitStyle.class, GraphQLReactionUnitStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f12895k;
    }

    @FieldOffset
    @Nullable
    public final String m21336r() {
        this.f12896l = super.a(this.f12896l, 9);
        return this.f12896l;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m21337s() {
        this.f12897m = (GraphQLTextWithEntities) super.a(this.f12897m, 10, GraphQLTextWithEntities.class);
        return this.f12897m;
    }

    @FieldOffset
    @Nullable
    public final GraphQLMedia m21338t() {
        this.f12898n = (GraphQLMedia) super.a(this.f12898n, 11, GraphQLMedia.class);
        return this.f12898n;
    }

    @Nullable
    public final String m21326a() {
        return m21331m();
    }

    public final int jK_() {
        return -1551679635;
    }

    public final GraphQLVisitableModel m21325a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m21332n() != null) {
            GraphQLPage graphQLPage = (GraphQLPage) graphQLModelMutatingVisitor.b(m21332n());
            if (m21332n() != graphQLPage) {
                graphQLVisitableModel = (GraphQLReactionUnit) ModelHelper.a(null, this);
                graphQLVisitableModel.f12892h = graphQLPage;
            }
        }
        if (m21337s() != null) {
            GraphQLTextWithEntities graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m21337s());
            if (m21337s() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLReactionUnit) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f12897m = graphQLTextWithEntities;
            }
        }
        if (m21338t() != null) {
            GraphQLMedia graphQLMedia = (GraphQLMedia) graphQLModelMutatingVisitor.b(m21338t());
            if (m21338t() != graphQLMedia) {
                graphQLVisitableModel = (GraphQLReactionUnit) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f12898n = graphQLMedia;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLReactionUnit() {
        super(13);
    }

    public final void m21327a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f12890f = mutableFlatBuffer.a(i, 2);
        this.f12894j = mutableFlatBuffer.a(i, 7, 0);
    }

    public final int m21324a(FlatBufferBuilder flatBufferBuilder) {
        Enum enumR = null;
        h();
        int a = flatBufferBuilder.a(m21328j() != null ? m21328j().e() : null);
        int b = flatBufferBuilder.b(m21331m());
        int a2 = ModelHelper.a(flatBufferBuilder, m21332n());
        int b2 = flatBufferBuilder.b(m21333o());
        int b3 = flatBufferBuilder.b(m21336r());
        int a3 = ModelHelper.a(flatBufferBuilder, m21337s());
        int a4 = ModelHelper.a(flatBufferBuilder, m21338t());
        flatBufferBuilder.c(12);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.a(1, m21329k() == GraphQLReactionUnitCollapseState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m21329k());
        flatBufferBuilder.a(2, m21330l());
        flatBufferBuilder.b(3, b);
        flatBufferBuilder.b(5, a2);
        flatBufferBuilder.b(6, b2);
        flatBufferBuilder.a(7, m21334p(), 0);
        if (m21335q() != GraphQLReactionUnitStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) {
            enumR = m21335q();
        }
        flatBufferBuilder.a(8, enumR);
        flatBufferBuilder.b(9, b3);
        flatBufferBuilder.b(10, a3);
        flatBufferBuilder.b(11, a4);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLReactionUnit(Parcel parcel) {
        boolean z = true;
        super(13);
        this.f12889e = GraphQLReactionUnitCollapseState.fromString(parcel.readString());
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.f12890f = z;
        this.f12891g = parcel.readString();
        this.f12892h = (GraphQLPage) parcel.readValue(GraphQLPage.class.getClassLoader());
        this.f12893i = parcel.readString();
        this.f12894j = parcel.readInt();
        this.f12895k = GraphQLReactionUnitStyle.fromString(parcel.readString());
        this.f12896l = parcel.readString();
        this.f12897m = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f12898n = (GraphQLMedia) parcel.readValue(GraphQLMedia.class.getClassLoader());
        this.f12888d = (GraphQLObjectType) ParcelUtil.m3828b(parcel, GraphQLObjectType.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m21329k().name());
        parcel.writeByte((byte) (m21330l() ? 1 : 0));
        parcel.writeString(m21331m());
        parcel.writeValue(m21332n());
        parcel.writeString(m21333o());
        parcel.writeInt(m21334p());
        parcel.writeString(m21335q().name());
        parcel.writeString(m21336r());
        parcel.writeValue(m21337s());
        parcel.writeValue(m21338t());
        parcel.writeParcelable(this.f12888d, i);
    }
}
