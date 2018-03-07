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
import com.facebook.graphql.deserializers.GraphQLSearchShortcutDeserializer;
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
/* compiled from: VERTEX_PROFILE_PICTURE_DIALOG */
public final class GraphQLSearchShortcut extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLSearchShortcut> CREATOR = new C12191();
    @Nullable
    public String f12996d;
    @Nullable
    public String f12997e;
    @Nullable
    public String f12998f;
    @Nullable
    public String f12999g;
    public List<String> f13000h;
    @Deprecated
    @Nullable
    public String f13001i;
    @Nullable
    public String f13002j;
    @Nullable
    public String f13003k;

    /* compiled from: VERTEX_PROFILE_PICTURE_DIALOG */
    final class C12191 implements Creator<GraphQLSearchShortcut> {
        C12191() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLSearchShortcut(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLSearchShortcut[i];
        }
    }

    /* compiled from: VERTEX_PROFILE_PICTURE_DIALOG */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLSearchShortcut.class, new Deserializer());
        }

        public Object m21573a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLSearchShortcutDeserializer.m5866a(jsonParser, (short) 96);
            Object graphQLSearchShortcut = new GraphQLSearchShortcut();
            ((BaseModel) graphQLSearchShortcut).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLSearchShortcut instanceof Postprocessable) {
                return ((Postprocessable) graphQLSearchShortcut).a();
            }
            return graphQLSearchShortcut;
        }
    }

    /* compiled from: VERTEX_PROFILE_PICTURE_DIALOG */
    public final class Serializer extends JsonSerializer<GraphQLSearchShortcut> {
        public final void m21574a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLSearchShortcut graphQLSearchShortcut = (GraphQLSearchShortcut) obj;
            GraphQLSearchShortcutDeserializer.m5867a(graphQLSearchShortcut.w_(), graphQLSearchShortcut.u_(), jsonGenerator);
        }

        static {
            FbSerializerProvider.a(GraphQLSearchShortcut.class, new Serializer());
            FbSerializerProvider.a(GraphQLSearchShortcut.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final String m21578j() {
        this.f12996d = super.a(this.f12996d, 0);
        return this.f12996d;
    }

    @FieldOffset
    @Nullable
    public final String m21579k() {
        this.f12997e = super.a(this.f12997e, 1);
        return this.f12997e;
    }

    @FieldOffset
    @Nullable
    public final String m21580l() {
        this.f12998f = super.a(this.f12998f, 2);
        return this.f12998f;
    }

    @FieldOffset
    @Nullable
    public final String m21581m() {
        this.f12999g = super.a(this.f12999g, 3);
        return this.f12999g;
    }

    @FieldOffset
    public final ImmutableList<String> m21582n() {
        this.f13000h = super.a(this.f13000h, 4);
        return (ImmutableList) this.f13000h;
    }

    @FieldOffset
    @Nullable
    public final String m21583o() {
        this.f13001i = super.a(this.f13001i, 5);
        return this.f13001i;
    }

    @FieldOffset
    @Nullable
    public final String m21584p() {
        this.f13002j = super.a(this.f13002j, 6);
        return this.f13002j;
    }

    @FieldOffset
    @Nullable
    public final String m21585q() {
        this.f13003k = super.a(this.f13003k, 7);
        return this.f13003k;
    }

    @Nullable
    public final String m21577a() {
        return m21580l();
    }

    public final int jK_() {
        return 811944494;
    }

    public final GraphQLVisitableModel m21576a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public GraphQLSearchShortcut() {
        super(9);
    }

    public final int m21575a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m21578j());
        int b2 = flatBufferBuilder.b(m21579k());
        int b3 = flatBufferBuilder.b(m21580l());
        int b4 = flatBufferBuilder.b(m21581m());
        int c = flatBufferBuilder.c(m21582n());
        int b5 = flatBufferBuilder.b(m21583o());
        int b6 = flatBufferBuilder.b(m21584p());
        int b7 = flatBufferBuilder.b(m21585q());
        flatBufferBuilder.c(8);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, b2);
        flatBufferBuilder.b(2, b3);
        flatBufferBuilder.b(3, b4);
        flatBufferBuilder.b(4, c);
        flatBufferBuilder.b(5, b5);
        flatBufferBuilder.b(6, b6);
        flatBufferBuilder.b(7, b7);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLSearchShortcut(Parcel parcel) {
        super(9);
        this.f12996d = parcel.readString();
        this.f12997e = parcel.readString();
        this.f12998f = parcel.readString();
        this.f12999g = parcel.readString();
        this.f13000h = ImmutableListHelper.a(parcel.readArrayList(String.class.getClassLoader()));
        this.f13001i = parcel.readString();
        this.f13002j = parcel.readString();
        this.f13003k = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m21578j());
        parcel.writeString(m21579k());
        parcel.writeString(m21580l());
        parcel.writeString(m21581m());
        parcel.writeList(m21582n());
        parcel.writeString(m21583o());
        parcel.writeString(m21584p());
        parcel.writeString(m21585q());
    }
}
