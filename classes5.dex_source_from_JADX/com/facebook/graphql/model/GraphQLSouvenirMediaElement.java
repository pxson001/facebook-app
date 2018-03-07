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
import com.facebook.graphql.deserializers.GraphQLSouvenirMediaElementDeserializer;
import com.facebook.graphql.enums.GraphQLSouvenirMediaFieldType;
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
/* compiled from: Unsupported params type  */
public final class GraphQLSouvenirMediaElement extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLSouvenirMediaElement> CREATOR = new C12301();
    @Nullable
    public String f13035d;
    public boolean f13036e;
    @Nullable
    public GraphQLSouvenirMediaElementMediaConnection f13037f;
    public GraphQLSouvenirMediaFieldType f13038g;
    @Nullable
    public String f13039h;

    /* compiled from: Unsupported params type  */
    final class C12301 implements Creator<GraphQLSouvenirMediaElement> {
        C12301() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLSouvenirMediaElement(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLSouvenirMediaElement[i];
        }
    }

    /* compiled from: Unsupported params type  */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLSouvenirMediaElement.class, new Deserializer());
        }

        public Object m21717a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLSouvenirMediaElementDeserializer.m5913a(jsonParser, (short) 101);
            Object graphQLSouvenirMediaElement = new GraphQLSouvenirMediaElement();
            ((BaseModel) graphQLSouvenirMediaElement).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLSouvenirMediaElement instanceof Postprocessable) {
                return ((Postprocessable) graphQLSouvenirMediaElement).a();
            }
            return graphQLSouvenirMediaElement;
        }
    }

    /* compiled from: Unsupported params type  */
    public final class Serializer extends JsonSerializer<GraphQLSouvenirMediaElement> {
        public final void m21718a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLSouvenirMediaElement graphQLSouvenirMediaElement = (GraphQLSouvenirMediaElement) obj;
            GraphQLSouvenirMediaElementDeserializer.m5914a(graphQLSouvenirMediaElement.w_(), graphQLSouvenirMediaElement.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLSouvenirMediaElement.class, new Serializer());
            FbSerializerProvider.a(GraphQLSouvenirMediaElement.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final String m21723j() {
        this.f13035d = super.a(this.f13035d, 0);
        return this.f13035d;
    }

    @FieldOffset
    public final boolean m21724k() {
        a(0, 1);
        return this.f13036e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLSouvenirMediaElementMediaConnection m21725l() {
        this.f13037f = (GraphQLSouvenirMediaElementMediaConnection) super.a(this.f13037f, 2, GraphQLSouvenirMediaElementMediaConnection.class);
        return this.f13037f;
    }

    @FieldOffset
    public final GraphQLSouvenirMediaFieldType m21726m() {
        this.f13038g = (GraphQLSouvenirMediaFieldType) super.a(this.f13038g, 3, GraphQLSouvenirMediaFieldType.class, GraphQLSouvenirMediaFieldType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f13038g;
    }

    @FieldOffset
    @Nullable
    public final String m21727n() {
        this.f13039h = super.a(this.f13039h, 4);
        return this.f13039h;
    }

    @Nullable
    public final String m21721a() {
        return m21723j();
    }

    public final int jK_() {
        return 1750010695;
    }

    public final GraphQLVisitableModel m21720a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m21725l() != null) {
            GraphQLSouvenirMediaElementMediaConnection graphQLSouvenirMediaElementMediaConnection = (GraphQLSouvenirMediaElementMediaConnection) graphQLModelMutatingVisitor.b(m21725l());
            if (m21725l() != graphQLSouvenirMediaElementMediaConnection) {
                graphQLVisitableModel = (GraphQLSouvenirMediaElement) ModelHelper.a(null, this);
                graphQLVisitableModel.f13037f = graphQLSouvenirMediaElementMediaConnection;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLSouvenirMediaElement() {
        super(6);
    }

    public final void m21722a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f13036e = mutableFlatBuffer.a(i, 1);
    }

    public final int m21719a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m21723j());
        int a = ModelHelper.a(flatBufferBuilder, m21725l());
        int b2 = flatBufferBuilder.b(m21727n());
        flatBufferBuilder.c(5);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.a(1, m21724k());
        flatBufferBuilder.b(2, a);
        flatBufferBuilder.a(3, m21726m() == GraphQLSouvenirMediaFieldType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m21726m());
        flatBufferBuilder.b(4, b2);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLSouvenirMediaElement(Parcel parcel) {
        boolean z = true;
        super(6);
        this.f13035d = parcel.readString();
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.f13036e = z;
        this.f13037f = (GraphQLSouvenirMediaElementMediaConnection) parcel.readValue(GraphQLSouvenirMediaElementMediaConnection.class.getClassLoader());
        this.f13038g = GraphQLSouvenirMediaFieldType.fromString(parcel.readString());
        this.f13039h = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m21723j());
        parcel.writeByte((byte) (m21724k() ? 1 : 0));
        parcel.writeValue(m21725l());
        parcel.writeString(m21726m().name());
        parcel.writeString(m21727n());
    }
}
