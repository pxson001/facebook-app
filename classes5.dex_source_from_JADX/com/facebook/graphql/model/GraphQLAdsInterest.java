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
import com.facebook.graphql.deserializers.GraphQLAdsInterestDeserializer;
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
/* compiled from: katana */
public final class GraphQLAdsInterest extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLAdsInterest> CREATOR = new C02631();
    @Nullable
    public String f3311d;
    @Nullable
    public String f3312e;
    @Nullable
    public String f3313f;

    /* compiled from: katana */
    final class C02631 implements Creator<GraphQLAdsInterest> {
        C02631() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLAdsInterest(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLAdsInterest[i];
        }
    }

    /* compiled from: katana */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLAdsInterest.class, new Deserializer());
        }

        public Object m6487a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLAdsInterestDeserializer.m4544a(jsonParser, (short) 7);
            Object graphQLAdsInterest = new GraphQLAdsInterest();
            ((BaseModel) graphQLAdsInterest).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLAdsInterest instanceof Postprocessable) {
                return ((Postprocessable) graphQLAdsInterest).a();
            }
            return graphQLAdsInterest;
        }
    }

    /* compiled from: katana */
    public final class Serializer extends JsonSerializer<GraphQLAdsInterest> {
        public final void m6488a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLAdsInterest graphQLAdsInterest = (GraphQLAdsInterest) obj;
            GraphQLAdsInterestDeserializer.m4545a(graphQLAdsInterest.w_(), graphQLAdsInterest.u_(), jsonGenerator);
        }

        static {
            FbSerializerProvider.a(GraphQLAdsInterest.class, new Serializer());
            FbSerializerProvider.a(GraphQLAdsInterest.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final String m6492j() {
        this.f3311d = super.a(this.f3311d, 0);
        return this.f3311d;
    }

    @FieldOffset
    @Nullable
    public final String m6493k() {
        this.f3312e = super.a(this.f3312e, 1);
        return this.f3312e;
    }

    @FieldOffset
    @Nullable
    public final String m6494l() {
        this.f3313f = super.a(this.f3313f, 2);
        return this.f3313f;
    }

    @Nullable
    public final String m6491a() {
        return m6492j();
    }

    public final int jK_() {
        return -78021670;
    }

    public final GraphQLVisitableModel m6490a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public GraphQLAdsInterest() {
        super(4);
    }

    public final int m6489a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m6492j());
        int b2 = flatBufferBuilder.b(m6493k());
        int b3 = flatBufferBuilder.b(m6494l());
        flatBufferBuilder.c(3);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, b2);
        flatBufferBuilder.b(2, b3);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLAdsInterest(Parcel parcel) {
        super(4);
        this.f3311d = parcel.readString();
        this.f3312e = parcel.readString();
        this.f3313f = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m6492j());
        parcel.writeString(m6493k());
        parcel.writeString(m6494l());
    }
}
