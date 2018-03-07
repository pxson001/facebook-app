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
import com.facebook.graphql.deserializers.GraphQLPlaceFlowInfoDeserializer;
import com.facebook.graphql.enums.GraphQLCheckinPlaceResultsContext;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.google.common.collect.ImmutableList;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: WEB_DEVELOPMENT */
public final class GraphQLPlaceFlowInfo extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLPlaceFlowInfo> CREATOR = new C11771();
    public List<String> f12638d;
    public List<String> f12639e;
    public GraphQLCheckinPlaceResultsContext f12640f;
    @Nullable
    public String f12641g;

    /* compiled from: WEB_DEVELOPMENT */
    final class C11771 implements Creator<GraphQLPlaceFlowInfo> {
        C11771() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLPlaceFlowInfo(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLPlaceFlowInfo[i];
        }
    }

    /* compiled from: WEB_DEVELOPMENT */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLPlaceFlowInfo.class, new Deserializer());
        }

        public Object m20837a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLPlaceFlowInfoDeserializer.m5642a(jsonParser, (short) 292);
            Object graphQLPlaceFlowInfo = new GraphQLPlaceFlowInfo();
            ((BaseModel) graphQLPlaceFlowInfo).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLPlaceFlowInfo instanceof Postprocessable) {
                return ((Postprocessable) graphQLPlaceFlowInfo).a();
            }
            return graphQLPlaceFlowInfo;
        }
    }

    /* compiled from: WEB_DEVELOPMENT */
    public final class Serializer extends JsonSerializer<GraphQLPlaceFlowInfo> {
        public final void m20838a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLPlaceFlowInfo graphQLPlaceFlowInfo = (GraphQLPlaceFlowInfo) obj;
            GraphQLPlaceFlowInfoDeserializer.m5643a(graphQLPlaceFlowInfo.w_(), graphQLPlaceFlowInfo.u_(), jsonGenerator);
        }

        static {
            FbSerializerProvider.a(GraphQLPlaceFlowInfo.class, new Serializer());
            FbSerializerProvider.a(GraphQLPlaceFlowInfo.class, new Serializer());
        }
    }

    @FieldOffset
    public final ImmutableList<String> m20841a() {
        this.f12638d = super.a(this.f12638d, 0);
        return (ImmutableList) this.f12638d;
    }

    @FieldOffset
    public final ImmutableList<String> m20842j() {
        this.f12639e = super.a(this.f12639e, 1);
        return (ImmutableList) this.f12639e;
    }

    @FieldOffset
    public final GraphQLCheckinPlaceResultsContext m20843k() {
        this.f12640f = (GraphQLCheckinPlaceResultsContext) super.a(this.f12640f, 2, GraphQLCheckinPlaceResultsContext.class, GraphQLCheckinPlaceResultsContext.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f12640f;
    }

    @FieldOffset
    @Nullable
    public final String m20844l() {
        this.f12641g = super.a(this.f12641g, 3);
        return this.f12641g;
    }

    public final int jK_() {
        return -1497429757;
    }

    public final GraphQLVisitableModel m20840a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public GraphQLPlaceFlowInfo() {
        super(5);
    }

    public final int m20839a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int c = flatBufferBuilder.c(m20841a());
        int c2 = flatBufferBuilder.c(m20842j());
        int b = flatBufferBuilder.b(m20844l());
        flatBufferBuilder.c(4);
        flatBufferBuilder.b(0, c);
        flatBufferBuilder.b(1, c2);
        flatBufferBuilder.a(2, m20843k() == GraphQLCheckinPlaceResultsContext.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m20843k());
        flatBufferBuilder.b(3, b);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLPlaceFlowInfo(Parcel parcel) {
        super(5);
        this.f12638d = ImmutableListHelper.a(parcel.readArrayList(String.class.getClassLoader()));
        this.f12639e = ImmutableListHelper.a(parcel.readArrayList(String.class.getClassLoader()));
        this.f12640f = GraphQLCheckinPlaceResultsContext.fromString(parcel.readString());
        this.f12641g = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m20841a());
        parcel.writeList(m20842j());
        parcel.writeString(m20843k().name());
        parcel.writeString(m20844l());
    }
}
