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
import com.facebook.graphql.deserializers.GraphQLTopicFeedOptionDeserializer;
import com.facebook.graphql.enums.GraphQLObjectType;
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
import com.instagram.common.json.annotation.JsonType;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: UAN */
public final class GraphQLTopicFeedOption extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLTopicFeedOption> CREATOR = new C12591();
    @Nullable
    public GraphQLObjectType f13359d;
    @Nullable
    public String f13360e;
    @Nullable
    public String f13361f;

    /* compiled from: UAN */
    final class C12591 implements Creator<GraphQLTopicFeedOption> {
        C12591() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLTopicFeedOption(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLTopicFeedOption[i];
        }
    }

    /* compiled from: UAN */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLTopicFeedOption.class, new Deserializer());
        }

        public Object m22265a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLTopicFeedOptionDeserializer.m6119a(jsonParser, (short) 534);
            Object graphQLTopicFeedOption = new GraphQLTopicFeedOption();
            ((BaseModel) graphQLTopicFeedOption).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLTopicFeedOption instanceof Postprocessable) {
                return ((Postprocessable) graphQLTopicFeedOption).a();
            }
            return graphQLTopicFeedOption;
        }
    }

    /* compiled from: UAN */
    public final class Serializer extends JsonSerializer<GraphQLTopicFeedOption> {
        public final void m22266a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLTopicFeedOption graphQLTopicFeedOption = (GraphQLTopicFeedOption) obj;
            GraphQLTopicFeedOptionDeserializer.m6120a(graphQLTopicFeedOption.w_(), graphQLTopicFeedOption.u_(), jsonGenerator);
        }

        static {
            FbSerializerProvider.a(GraphQLTopicFeedOption.class, new Serializer());
            FbSerializerProvider.a(GraphQLTopicFeedOption.class, new Serializer());
        }
    }

    @Nullable
    public final GraphQLObjectType m22270j() {
        if (this.b != null && this.f13359d == null) {
            this.f13359d = new GraphQLObjectType(this.b.b(this.c, 0));
        }
        if (this.f13359d == null || this.f13359d.g() != 0) {
            return this.f13359d;
        }
        return null;
    }

    @FieldOffset
    @Nullable
    public final String m22271k() {
        this.f13360e = super.a(this.f13360e, 1);
        return this.f13360e;
    }

    @FieldOffset
    @Nullable
    public final String m22272l() {
        this.f13361f = super.a(this.f13361f, 2);
        return this.f13361f;
    }

    @Nullable
    public final String m22269a() {
        return m22271k();
    }

    public final int jK_() {
        return -19653086;
    }

    public final GraphQLVisitableModel m22268a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public GraphQLTopicFeedOption() {
        super(4);
    }

    public final int m22267a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = flatBufferBuilder.a(m22270j() != null ? m22270j().e() : null);
        int b = flatBufferBuilder.b(m22271k());
        int b2 = flatBufferBuilder.b(m22272l());
        flatBufferBuilder.c(3);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, b);
        flatBufferBuilder.b(2, b2);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLTopicFeedOption(Parcel parcel) {
        super(4);
        this.f13360e = parcel.readString();
        this.f13361f = parcel.readString();
        this.f13359d = (GraphQLObjectType) ParcelUtil.m3828b(parcel, GraphQLObjectType.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m22271k());
        parcel.writeString(m22272l());
        parcel.writeParcelable(this.f13359d, i);
    }
}
