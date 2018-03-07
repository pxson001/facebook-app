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
import com.facebook.graphql.deserializers.GraphQLSearchAwarenessSuggestionDeserializer;
import com.facebook.graphql.enums.GraphQLSearchAwarenessTemplatesEnum;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
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
/* compiled from: VERTICAL_ACTION_WITH_COMPONENTS_LIST */
public final class GraphQLSearchAwarenessSuggestion extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLSearchAwarenessSuggestion> CREATOR = new C12181();
    @Nullable
    public String f12989d;
    public List<String> f12990e;
    @Nullable
    public String f12991f;
    public GraphQLSearchAwarenessTemplatesEnum f12992g;
    @Nullable
    public String f12993h;
    @Nullable
    public String f12994i;
    @Nullable
    public String f12995j;

    /* compiled from: VERTICAL_ACTION_WITH_COMPONENTS_LIST */
    final class C12181 implements Creator<GraphQLSearchAwarenessSuggestion> {
        C12181() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLSearchAwarenessSuggestion(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLSearchAwarenessSuggestion[i];
        }
    }

    /* compiled from: VERTICAL_ACTION_WITH_COMPONENTS_LIST */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLSearchAwarenessSuggestion.class, new Deserializer());
        }

        public Object m21559a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLSearchAwarenessSuggestionDeserializer.m5863a(jsonParser, (short) 92);
            Object graphQLSearchAwarenessSuggestion = new GraphQLSearchAwarenessSuggestion();
            ((BaseModel) graphQLSearchAwarenessSuggestion).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLSearchAwarenessSuggestion instanceof Postprocessable) {
                return ((Postprocessable) graphQLSearchAwarenessSuggestion).a();
            }
            return graphQLSearchAwarenessSuggestion;
        }
    }

    /* compiled from: VERTICAL_ACTION_WITH_COMPONENTS_LIST */
    public final class Serializer extends JsonSerializer<GraphQLSearchAwarenessSuggestion> {
        public final void m21560a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLSearchAwarenessSuggestion graphQLSearchAwarenessSuggestion = (GraphQLSearchAwarenessSuggestion) obj;
            GraphQLSearchAwarenessSuggestionDeserializer.m5864a(graphQLSearchAwarenessSuggestion.w_(), graphQLSearchAwarenessSuggestion.u_(), jsonGenerator);
        }

        static {
            FbSerializerProvider.a(GraphQLSearchAwarenessSuggestion.class, new Serializer());
            FbSerializerProvider.a(GraphQLSearchAwarenessSuggestion.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final String m21564j() {
        this.f12989d = super.a(this.f12989d, 0);
        return this.f12989d;
    }

    @FieldOffset
    public final ImmutableList<String> m21565k() {
        this.f12990e = super.a(this.f12990e, 1);
        return (ImmutableList) this.f12990e;
    }

    @FieldOffset
    @Nullable
    public final String m21566l() {
        this.f12991f = super.a(this.f12991f, 2);
        return this.f12991f;
    }

    @FieldOffset
    public final GraphQLSearchAwarenessTemplatesEnum m21567m() {
        this.f12992g = (GraphQLSearchAwarenessTemplatesEnum) super.a(this.f12992g, 3, GraphQLSearchAwarenessTemplatesEnum.class, GraphQLSearchAwarenessTemplatesEnum.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f12992g;
    }

    @FieldOffset
    @Nullable
    public final String m21568n() {
        this.f12993h = super.a(this.f12993h, 4);
        return this.f12993h;
    }

    @FieldOffset
    @Nullable
    public final String m21569o() {
        this.f12994i = super.a(this.f12994i, 5);
        return this.f12994i;
    }

    @FieldOffset
    @Nullable
    public final String m21570p() {
        this.f12995j = super.a(this.f12995j, 6);
        return this.f12995j;
    }

    @Nullable
    public final String m21563a() {
        return m21564j();
    }

    public final int jK_() {
        return -1858617679;
    }

    public final GraphQLVisitableModel m21562a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public GraphQLSearchAwarenessSuggestion() {
        super(8);
    }

    public final int m21561a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m21564j());
        int c = flatBufferBuilder.c(m21565k());
        int b2 = flatBufferBuilder.b(m21566l());
        int b3 = flatBufferBuilder.b(m21568n());
        int b4 = flatBufferBuilder.b(m21569o());
        int b5 = flatBufferBuilder.b(m21570p());
        flatBufferBuilder.c(7);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, c);
        flatBufferBuilder.b(2, b2);
        flatBufferBuilder.a(3, m21567m() == GraphQLSearchAwarenessTemplatesEnum.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m21567m());
        flatBufferBuilder.b(4, b3);
        flatBufferBuilder.b(5, b4);
        flatBufferBuilder.b(6, b5);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLSearchAwarenessSuggestion(Parcel parcel) {
        super(8);
        this.f12989d = parcel.readString();
        this.f12990e = ImmutableListHelper.a(parcel.readArrayList(String.class.getClassLoader()));
        this.f12991f = parcel.readString();
        this.f12992g = GraphQLSearchAwarenessTemplatesEnum.fromString(parcel.readString());
        this.f12993h = parcel.readString();
        this.f12994i = parcel.readString();
        this.f12995j = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m21564j());
        parcel.writeList(m21565k());
        parcel.writeString(m21566l());
        parcel.writeString(m21567m().name());
        parcel.writeString(m21568n());
        parcel.writeString(m21569o());
        parcel.writeString(m21570p());
    }
}
