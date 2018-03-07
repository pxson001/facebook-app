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
import com.facebook.graphql.deserializers.GraphQLGoodwillThrowbackOriginalPostActionLinkDeserializer;
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
/* compiled from: getUid */
public final class GraphQLGoodwillThrowbackOriginalPostActionLink extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLGoodwillThrowbackOriginalPostActionLink> CREATOR = new C03621();
    @Nullable
    public String f4027d;
    @Nullable
    public String f4028e;

    /* compiled from: getUid */
    final class C03621 implements Creator<GraphQLGoodwillThrowbackOriginalPostActionLink> {
        C03621() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLGoodwillThrowbackOriginalPostActionLink(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLGoodwillThrowbackOriginalPostActionLink[i];
        }
    }

    /* compiled from: getUid */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLGoodwillThrowbackOriginalPostActionLink.class, new Deserializer());
        }

        public Object m8052a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLGoodwillThrowbackOriginalPostActionLinkDeserializer.m5051a(jsonParser, (short) 576);
            Object graphQLGoodwillThrowbackOriginalPostActionLink = new GraphQLGoodwillThrowbackOriginalPostActionLink();
            ((BaseModel) graphQLGoodwillThrowbackOriginalPostActionLink).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLGoodwillThrowbackOriginalPostActionLink instanceof Postprocessable) {
                return ((Postprocessable) graphQLGoodwillThrowbackOriginalPostActionLink).a();
            }
            return graphQLGoodwillThrowbackOriginalPostActionLink;
        }
    }

    /* compiled from: getUid */
    public final class Serializer extends JsonSerializer<GraphQLGoodwillThrowbackOriginalPostActionLink> {
        public final void m8053a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLGoodwillThrowbackOriginalPostActionLink graphQLGoodwillThrowbackOriginalPostActionLink = (GraphQLGoodwillThrowbackOriginalPostActionLink) obj;
            GraphQLGoodwillThrowbackOriginalPostActionLinkDeserializer.m5052a(graphQLGoodwillThrowbackOriginalPostActionLink.w_(), graphQLGoodwillThrowbackOriginalPostActionLink.u_(), jsonGenerator);
        }

        static {
            FbSerializerProvider.a(GraphQLGoodwillThrowbackOriginalPostActionLink.class, new Serializer());
            FbSerializerProvider.a(GraphQLGoodwillThrowbackOriginalPostActionLink.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final String m8056a() {
        this.f4027d = super.a(this.f4027d, 0);
        return this.f4027d;
    }

    @FieldOffset
    @Nullable
    public final String m8057j() {
        this.f4028e = super.a(this.f4028e, 1);
        return this.f4028e;
    }

    public final int jK_() {
        return -2102769345;
    }

    public final GraphQLVisitableModel m8055a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public GraphQLGoodwillThrowbackOriginalPostActionLink() {
        super(3);
    }

    public final int m8054a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m8056a());
        int b2 = flatBufferBuilder.b(m8057j());
        flatBufferBuilder.c(2);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, b2);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLGoodwillThrowbackOriginalPostActionLink(Parcel parcel) {
        super(3);
        this.f4027d = parcel.readString();
        this.f4028e = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m8056a());
        parcel.writeString(m8057j());
    }
}
