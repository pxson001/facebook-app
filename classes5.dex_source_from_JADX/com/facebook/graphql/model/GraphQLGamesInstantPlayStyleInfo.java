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
import com.facebook.graphql.deserializers.GraphQLGamesInstantPlayStyleInfoDeserializer;
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
/* compiled from: group_mall */
public final class GraphQLGamesInstantPlayStyleInfo extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLGamesInstantPlayStyleInfo> CREATOR = new C03371();
    @Nullable
    public String f3843d;
    @Nullable
    public String f3844e;
    @Nullable
    public String f3845f;
    @Nullable
    public String f3846g;
    @Nullable
    public String f3847h;

    /* compiled from: group_mall */
    final class C03371 implements Creator<GraphQLGamesInstantPlayStyleInfo> {
        C03371() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLGamesInstantPlayStyleInfo(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLGamesInstantPlayStyleInfo[i];
        }
    }

    /* compiled from: group_mall */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLGamesInstantPlayStyleInfo.class, new Deserializer());
        }

        public Object m7751a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLGamesInstantPlayStyleInfoDeserializer.m4991a(jsonParser, (short) 567);
            Object graphQLGamesInstantPlayStyleInfo = new GraphQLGamesInstantPlayStyleInfo();
            ((BaseModel) graphQLGamesInstantPlayStyleInfo).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLGamesInstantPlayStyleInfo instanceof Postprocessable) {
                return ((Postprocessable) graphQLGamesInstantPlayStyleInfo).a();
            }
            return graphQLGamesInstantPlayStyleInfo;
        }
    }

    /* compiled from: group_mall */
    public final class Serializer extends JsonSerializer<GraphQLGamesInstantPlayStyleInfo> {
        public final void m7752a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLGamesInstantPlayStyleInfo graphQLGamesInstantPlayStyleInfo = (GraphQLGamesInstantPlayStyleInfo) obj;
            GraphQLGamesInstantPlayStyleInfoDeserializer.m4992a(graphQLGamesInstantPlayStyleInfo.w_(), graphQLGamesInstantPlayStyleInfo.u_(), jsonGenerator);
        }

        static {
            FbSerializerProvider.a(GraphQLGamesInstantPlayStyleInfo.class, new Serializer());
            FbSerializerProvider.a(GraphQLGamesInstantPlayStyleInfo.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final String m7755a() {
        this.f3843d = super.a(this.f3843d, 0);
        return this.f3843d;
    }

    @FieldOffset
    @Nullable
    public final String m7756j() {
        this.f3844e = super.a(this.f3844e, 1);
        return this.f3844e;
    }

    @FieldOffset
    @Nullable
    public final String m7757k() {
        this.f3845f = super.a(this.f3845f, 2);
        return this.f3845f;
    }

    @FieldOffset
    @Nullable
    public final String m7758l() {
        this.f3846g = super.a(this.f3846g, 3);
        return this.f3846g;
    }

    @FieldOffset
    @Nullable
    public final String m7759m() {
        this.f3847h = super.a(this.f3847h, 4);
        return this.f3847h;
    }

    public final int jK_() {
        return -1194925813;
    }

    public final GraphQLVisitableModel m7754a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public GraphQLGamesInstantPlayStyleInfo() {
        super(6);
    }

    public final int m7753a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m7755a());
        int b2 = flatBufferBuilder.b(m7756j());
        int b3 = flatBufferBuilder.b(m7757k());
        int b4 = flatBufferBuilder.b(m7758l());
        int b5 = flatBufferBuilder.b(m7759m());
        flatBufferBuilder.c(5);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, b2);
        flatBufferBuilder.b(2, b3);
        flatBufferBuilder.b(3, b4);
        flatBufferBuilder.b(4, b5);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLGamesInstantPlayStyleInfo(Parcel parcel) {
        super(6);
        this.f3843d = parcel.readString();
        this.f3844e = parcel.readString();
        this.f3845f = parcel.readString();
        this.f3846g = parcel.readString();
        this.f3847h = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m7755a());
        parcel.writeString(m7756j());
        parcel.writeString(m7757k());
        parcel.writeString(m7758l());
        parcel.writeString(m7759m());
    }
}
