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
import com.facebook.graphql.deserializers.GraphQLMediaQuestionOptionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
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
/* compiled from: fb4a_groups_tab */
public final class GraphQLMediaQuestionOption extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
    public static final Creator<GraphQLMediaQuestionOption> CREATOR = new C04331();
    @Nullable
    public String f4481d;
    @Nullable
    public String f4482e;
    @Nullable
    public String f4483f;
    public boolean f4484g;
    public int f4485h;

    /* compiled from: fb4a_groups_tab */
    final class C04331 implements Creator<GraphQLMediaQuestionOption> {
        C04331() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLMediaQuestionOption(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLMediaQuestionOption[i];
        }
    }

    /* compiled from: fb4a_groups_tab */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLMediaQuestionOption.class, new Deserializer());
        }

        public Object m9028a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLMediaQuestionOptionDeserializer.m5347a(jsonParser, (short) 63);
            Object graphQLMediaQuestionOption = new GraphQLMediaQuestionOption();
            ((BaseModel) graphQLMediaQuestionOption).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLMediaQuestionOption instanceof Postprocessable) {
                return ((Postprocessable) graphQLMediaQuestionOption).a();
            }
            return graphQLMediaQuestionOption;
        }
    }

    /* compiled from: fb4a_groups_tab */
    public final class Serializer extends JsonSerializer<GraphQLMediaQuestionOption> {
        public final void m9029a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLMediaQuestionOption graphQLMediaQuestionOption = (GraphQLMediaQuestionOption) obj;
            GraphQLMediaQuestionOptionDeserializer.m5348a(graphQLMediaQuestionOption.w_(), graphQLMediaQuestionOption.u_(), jsonGenerator);
        }

        static {
            FbSerializerProvider.a(GraphQLMediaQuestionOption.class, new Serializer());
            FbSerializerProvider.a(GraphQLMediaQuestionOption.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final String m9036j() {
        this.f4481d = super.a(this.f4481d, 0);
        return this.f4481d;
    }

    @FieldOffset
    @Nullable
    public final String m9037k() {
        this.f4482e = super.a(this.f4482e, 1);
        return this.f4482e;
    }

    @FieldOffset
    @Nullable
    public final String m9038l() {
        this.f4483f = super.a(this.f4483f, 2);
        return this.f4483f;
    }

    @FieldOffset
    public final boolean m9039m() {
        a(0, 3);
        return this.f4484g;
    }

    @FieldOffset
    public final int m9040n() {
        a(0, 4);
        return this.f4485h;
    }

    @Nullable
    public final String m9032a() {
        return m9036j();
    }

    public final int jK_() {
        return -1239871265;
    }

    public final GraphQLVisitableModel m9031a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public final void m9034a(String str, ConsistencyTuple consistencyTuple) {
        if ("viewer_has_chosen".equals(str)) {
            consistencyTuple.a = Boolean.valueOf(m9039m());
            consistencyTuple.b = u_();
            consistencyTuple.c = 3;
        } else if ("vote_count".equals(str)) {
            consistencyTuple.a = Integer.valueOf(m9040n());
            consistencyTuple.b = u_();
            consistencyTuple.c = 4;
        } else {
            consistencyTuple.a();
        }
    }

    public final void m9035a(String str, Object obj, boolean z) {
        if ("viewer_has_chosen".equals(str)) {
            boolean booleanValue = ((Boolean) obj).booleanValue();
            this.f4484g = booleanValue;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 3, booleanValue);
            }
        } else if ("vote_count".equals(str)) {
            int intValue = ((Integer) obj).intValue();
            this.f4485h = intValue;
            if (this.b != null && this.b.d) {
                this.b.b(this.c, 4, intValue);
            }
        }
    }

    public GraphQLMediaQuestionOption() {
        super(6);
    }

    public final void m9033a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f4484g = mutableFlatBuffer.a(i, 3);
        this.f4485h = mutableFlatBuffer.a(i, 4, 0);
    }

    public final int m9030a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m9036j());
        int b2 = flatBufferBuilder.b(m9037k());
        int b3 = flatBufferBuilder.b(m9038l());
        flatBufferBuilder.c(5);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, b2);
        flatBufferBuilder.b(2, b3);
        flatBufferBuilder.a(3, m9039m());
        flatBufferBuilder.a(4, m9040n(), 0);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLMediaQuestionOption(Parcel parcel) {
        boolean z = true;
        super(6);
        this.f4481d = parcel.readString();
        this.f4482e = parcel.readString();
        this.f4483f = parcel.readString();
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.f4484g = z;
        this.f4485h = parcel.readInt();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m9036j());
        parcel.writeString(m9037k());
        parcel.writeString(m9038l());
        parcel.writeByte((byte) (m9039m() ? 1 : 0));
        parcel.writeInt(m9040n());
    }
}
