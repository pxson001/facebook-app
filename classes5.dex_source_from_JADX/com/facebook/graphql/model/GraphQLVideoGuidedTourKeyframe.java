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
import com.facebook.graphql.deserializers.GraphQLVideoGuidedTourKeyframeDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.google.common.base.Preconditions;
import com.instagram.common.json.annotation.JsonType;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: This class doesn't perform any security checks. Please create an InternalIntentSigner for your app if you want to sign intents. */
public final class GraphQLVideoGuidedTourKeyframe extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLVideoGuidedTourKeyframe> CREATOR = new C12721();
    public int f13451d;
    public long f13452e;
    public int f13453f;

    /* compiled from: This class doesn't perform any security checks. Please create an InternalIntentSigner for your app if you want to sign intents. */
    final class C12721 implements Creator<GraphQLVideoGuidedTourKeyframe> {
        C12721() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLVideoGuidedTourKeyframe(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLVideoGuidedTourKeyframe[i];
        }
    }

    /* compiled from: This class doesn't perform any security checks. Please create an InternalIntentSigner for your app if you want to sign intents. */
    public class Builder extends com.facebook.graphql.modelutil.BaseModel.Builder {
        public int f13448d;
        public long f13449e;
        public int f13450f;

        public Builder() {
            Preconditions.checkState(this instanceof Builder);
        }
    }

    /* compiled from: This class doesn't perform any security checks. Please create an InternalIntentSigner for your app if you want to sign intents. */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLVideoGuidedTourKeyframe.class, new Deserializer());
        }

        public Object m22452a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLVideoGuidedTourKeyframeDeserializer.m6191a(jsonParser, (short) 244);
            Object graphQLVideoGuidedTourKeyframe = new GraphQLVideoGuidedTourKeyframe();
            ((BaseModel) graphQLVideoGuidedTourKeyframe).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLVideoGuidedTourKeyframe instanceof Postprocessable) {
                return ((Postprocessable) graphQLVideoGuidedTourKeyframe).a();
            }
            return graphQLVideoGuidedTourKeyframe;
        }
    }

    /* compiled from: This class doesn't perform any security checks. Please create an InternalIntentSigner for your app if you want to sign intents. */
    public final class Serializer extends JsonSerializer<GraphQLVideoGuidedTourKeyframe> {
        public final void m22453a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLVideoGuidedTourKeyframe graphQLVideoGuidedTourKeyframe = (GraphQLVideoGuidedTourKeyframe) obj;
            GraphQLVideoGuidedTourKeyframeDeserializer.m6192a(graphQLVideoGuidedTourKeyframe.w_(), graphQLVideoGuidedTourKeyframe.u_(), jsonGenerator);
        }

        static {
            FbSerializerProvider.a(GraphQLVideoGuidedTourKeyframe.class, new Serializer());
            FbSerializerProvider.a(GraphQLVideoGuidedTourKeyframe.class, new Serializer());
        }
    }

    @FieldOffset
    public final int m22454a() {
        a(0, 0);
        return this.f13451d;
    }

    @FieldOffset
    public final long m22458j() {
        a(0, 1);
        return this.f13452e;
    }

    @FieldOffset
    public final int m22459k() {
        a(0, 2);
        return this.f13453f;
    }

    public final int jK_() {
        return -1058659927;
    }

    public final GraphQLVisitableModel m22456a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public GraphQLVideoGuidedTourKeyframe() {
        super(4);
    }

    public final void m22457a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f13451d = mutableFlatBuffer.a(i, 0, 0);
        this.f13452e = mutableFlatBuffer.a(i, 1, 0);
        this.f13453f = mutableFlatBuffer.a(i, 2, 0);
    }

    public final int m22455a(FlatBufferBuilder flatBufferBuilder) {
        h();
        flatBufferBuilder.c(3);
        flatBufferBuilder.a(0, m22454a(), 0);
        flatBufferBuilder.a(1, m22458j(), 0);
        flatBufferBuilder.a(2, m22459k(), 0);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLVideoGuidedTourKeyframe(Parcel parcel) {
        super(4);
        this.f13451d = parcel.readInt();
        this.f13452e = parcel.readLong();
        this.f13453f = parcel.readInt();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(m22454a());
        parcel.writeLong(m22458j());
        parcel.writeInt(m22459k());
    }

    public GraphQLVideoGuidedTourKeyframe(Builder builder) {
        super(4);
        this.b = builder.a;
        this.c = builder.b;
        this.f13451d = builder.f13448d;
        this.f13452e = builder.f13449e;
        this.f13453f = builder.f13450f;
    }
}
