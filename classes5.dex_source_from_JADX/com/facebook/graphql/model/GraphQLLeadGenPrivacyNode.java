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
import com.facebook.graphql.deserializers.GraphQLLeadGenPrivacyNodeDeserializer;
import com.facebook.graphql.enums.GraphQLLeadGenPrivacyType;
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
/* compiled from: feed_edit_comment */
public final class GraphQLLeadGenPrivacyNode extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLLeadGenPrivacyNode> CREATOR = new C04261();
    @Nullable
    public String f4391d;
    public GraphQLLeadGenPrivacyType f4392e;

    /* compiled from: feed_edit_comment */
    final class C04261 implements Creator<GraphQLLeadGenPrivacyNode> {
        C04261() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLLeadGenPrivacyNode(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLLeadGenPrivacyNode[i];
        }
    }

    /* compiled from: feed_edit_comment */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLLeadGenPrivacyNode.class, new Deserializer());
        }

        public Object m8894a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLLeadGenPrivacyNodeDeserializer.m5310a(jsonParser, (short) 171);
            Object graphQLLeadGenPrivacyNode = new GraphQLLeadGenPrivacyNode();
            ((BaseModel) graphQLLeadGenPrivacyNode).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLLeadGenPrivacyNode instanceof Postprocessable) {
                return ((Postprocessable) graphQLLeadGenPrivacyNode).a();
            }
            return graphQLLeadGenPrivacyNode;
        }
    }

    /* compiled from: feed_edit_comment */
    public final class Serializer extends JsonSerializer<GraphQLLeadGenPrivacyNode> {
        public final void m8895a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLLeadGenPrivacyNode graphQLLeadGenPrivacyNode = (GraphQLLeadGenPrivacyNode) obj;
            GraphQLLeadGenPrivacyNodeDeserializer.m5311a(graphQLLeadGenPrivacyNode.w_(), graphQLLeadGenPrivacyNode.u_(), jsonGenerator);
        }

        static {
            FbSerializerProvider.a(GraphQLLeadGenPrivacyNode.class, new Serializer());
            FbSerializerProvider.a(GraphQLLeadGenPrivacyNode.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final String m8898a() {
        this.f4391d = super.a(this.f4391d, 0);
        return this.f4391d;
    }

    @FieldOffset
    public final GraphQLLeadGenPrivacyType m8899j() {
        this.f4392e = (GraphQLLeadGenPrivacyType) super.a(this.f4392e, 1, GraphQLLeadGenPrivacyType.class, GraphQLLeadGenPrivacyType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f4392e;
    }

    public final int jK_() {
        return -1982153002;
    }

    public final GraphQLVisitableModel m8897a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public GraphQLLeadGenPrivacyNode() {
        super(3);
    }

    public final int m8896a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m8898a());
        flatBufferBuilder.c(2);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.a(1, m8899j() == GraphQLLeadGenPrivacyType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m8899j());
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLLeadGenPrivacyNode(Parcel parcel) {
        super(3);
        this.f4391d = parcel.readString();
        this.f4392e = GraphQLLeadGenPrivacyType.fromString(parcel.readString());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m8898a());
        parcel.writeString(m8899j().name());
    }
}
