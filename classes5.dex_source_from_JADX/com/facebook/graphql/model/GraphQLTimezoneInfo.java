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
import com.facebook.graphql.deserializers.GraphQLTimezoneInfoDeserializer;
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
/* compiled from: UNCONNECTED_SUBSTORY */
public final class GraphQLTimezoneInfo extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLTimezoneInfo> CREATOR = new C12571();
    @Nullable
    public String f13352d;

    /* compiled from: UNCONNECTED_SUBSTORY */
    final class C12571 implements Creator<GraphQLTimezoneInfo> {
        C12571() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLTimezoneInfo(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLTimezoneInfo[i];
        }
    }

    /* compiled from: UNCONNECTED_SUBSTORY */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLTimezoneInfo.class, new Deserializer());
        }

        public Object m22231a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLTimezoneInfoDeserializer.m6099a(jsonParser, (short) 255);
            Object graphQLTimezoneInfo = new GraphQLTimezoneInfo();
            ((BaseModel) graphQLTimezoneInfo).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLTimezoneInfo instanceof Postprocessable) {
                return ((Postprocessable) graphQLTimezoneInfo).a();
            }
            return graphQLTimezoneInfo;
        }
    }

    /* compiled from: UNCONNECTED_SUBSTORY */
    public final class Serializer extends JsonSerializer<GraphQLTimezoneInfo> {
        public final void m22232a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLTimezoneInfo graphQLTimezoneInfo = (GraphQLTimezoneInfo) obj;
            GraphQLTimezoneInfoDeserializer.m6100a(graphQLTimezoneInfo.w_(), graphQLTimezoneInfo.u_(), jsonGenerator);
        }

        static {
            FbSerializerProvider.a(GraphQLTimezoneInfo.class, new Serializer());
            FbSerializerProvider.a(GraphQLTimezoneInfo.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final String m22235a() {
        this.f13352d = super.a(this.f13352d, 0);
        return this.f13352d;
    }

    public final int jK_() {
        return 1290195047;
    }

    public final GraphQLVisitableModel m22234a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public GraphQLTimezoneInfo() {
        super(2);
    }

    public final int m22233a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m22235a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, b);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLTimezoneInfo(Parcel parcel) {
        super(2);
        this.f13352d = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m22235a());
    }
}
