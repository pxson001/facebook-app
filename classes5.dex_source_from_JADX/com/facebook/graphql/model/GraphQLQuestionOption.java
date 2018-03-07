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
import com.facebook.graphql.deserializers.GraphQLQuestionOptionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
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
import com.google.common.base.Preconditions;
import com.instagram.common.json.annotation.JsonType;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: VIEW_TIMELINE_POSTS */
public final class GraphQLQuestionOption extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
    public static final Creator<GraphQLQuestionOption> CREATOR = new C11891();
    @Nullable
    String f12831d;
    @Nullable
    GraphQLTextWithEntities f12832e;
    @Nullable
    String f12833f;
    public boolean f12834g;
    @Nullable
    GraphQLQuestionOptionVotersConnection f12835h;

    /* compiled from: VIEW_TIMELINE_POSTS */
    final class C11891 implements Creator<GraphQLQuestionOption> {
        C11891() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLQuestionOption(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLQuestionOption[i];
        }
    }

    /* compiled from: VIEW_TIMELINE_POSTS */
    public class Builder extends com.facebook.graphql.modelutil.BaseModel.Builder {
        @Nullable
        public String f12826d;
        @Nullable
        public GraphQLTextWithEntities f12827e;
        @Nullable
        public String f12828f;
        public boolean f12829g;
        @Nullable
        public GraphQLQuestionOptionVotersConnection f12830h;

        public Builder() {
            Preconditions.checkState(this instanceof Builder);
        }

        public final Builder m21150a(boolean z) {
            this.f12829g = z;
            if (this.a != null && this.a.d) {
                this.a.a(this.b, 3, z);
            }
            return this;
        }

        public final GraphQLQuestionOption m21151a() {
            return new GraphQLQuestionOption(this);
        }
    }

    /* compiled from: VIEW_TIMELINE_POSTS */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLQuestionOption.class, new Deserializer());
        }

        public Object m21152a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLQuestionOptionDeserializer.m5735a(jsonParser, (short) 90);
            Object graphQLQuestionOption = new GraphQLQuestionOption();
            ((BaseModel) graphQLQuestionOption).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLQuestionOption instanceof Postprocessable) {
                return ((Postprocessable) graphQLQuestionOption).a();
            }
            return graphQLQuestionOption;
        }
    }

    /* compiled from: VIEW_TIMELINE_POSTS */
    public final class Serializer extends JsonSerializer<GraphQLQuestionOption> {
        public final void m21153a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLQuestionOption graphQLQuestionOption = (GraphQLQuestionOption) obj;
            GraphQLQuestionOptionDeserializer.m5736b(graphQLQuestionOption.w_(), graphQLQuestionOption.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLQuestionOption.class, new Serializer());
            FbSerializerProvider.a(GraphQLQuestionOption.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final String m21160j() {
        this.f12831d = super.a(this.f12831d, 0);
        return this.f12831d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m21161k() {
        this.f12832e = (GraphQLTextWithEntities) super.a(this.f12832e, 1, GraphQLTextWithEntities.class);
        return this.f12832e;
    }

    @FieldOffset
    @Nullable
    public final String m21162l() {
        this.f12833f = super.a(this.f12833f, 2);
        return this.f12833f;
    }

    @FieldOffset
    public final boolean m21163m() {
        a(0, 3);
        return this.f12834g;
    }

    @FieldOffset
    @Nullable
    public final GraphQLQuestionOptionVotersConnection m21164n() {
        this.f12835h = (GraphQLQuestionOptionVotersConnection) super.a(this.f12835h, 4, GraphQLQuestionOptionVotersConnection.class);
        return this.f12835h;
    }

    @Nullable
    public final String m21156a() {
        return m21160j();
    }

    public final int jK_() {
        return 955873307;
    }

    public final GraphQLVisitableModel m21155a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m21161k() != null) {
            GraphQLTextWithEntities graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m21161k());
            if (m21161k() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLQuestionOption) ModelHelper.a(null, this);
                graphQLVisitableModel.f12832e = graphQLTextWithEntities;
            }
        }
        if (m21164n() != null) {
            GraphQLQuestionOptionVotersConnection graphQLQuestionOptionVotersConnection = (GraphQLQuestionOptionVotersConnection) graphQLModelMutatingVisitor.b(m21164n());
            if (m21164n() != graphQLQuestionOptionVotersConnection) {
                graphQLVisitableModel = (GraphQLQuestionOption) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f12835h = graphQLQuestionOptionVotersConnection;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final void m21158a(String str, ConsistencyTuple consistencyTuple) {
        if ("viewer_has_voted".equals(str)) {
            consistencyTuple.a = Boolean.valueOf(m21163m());
            consistencyTuple.b = u_();
            consistencyTuple.c = 3;
            return;
        }
        if ("voters.count".equals(str)) {
            GraphQLQuestionOptionVotersConnection n = m21164n();
            if (n != null) {
                consistencyTuple.a = Integer.valueOf(n.m21171a());
                consistencyTuple.b = n.u_();
                consistencyTuple.c = 0;
                return;
            }
        }
        consistencyTuple.a();
    }

    public final void m21159a(String str, Object obj, boolean z) {
        if ("viewer_has_voted".equals(str)) {
            boolean booleanValue = ((Boolean) obj).booleanValue();
            this.f12834g = booleanValue;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 3, booleanValue);
            }
        } else if ("voters.count".equals(str)) {
            GraphQLQuestionOptionVotersConnection n = m21164n();
            if (n == null) {
                return;
            }
            if (z) {
                n = (GraphQLQuestionOptionVotersConnection) n.clone();
                n.m21174a(((Integer) obj).intValue());
                this.f12835h = n;
                return;
            }
            n.m21174a(((Integer) obj).intValue());
        }
    }

    public GraphQLQuestionOption() {
        super(6);
    }

    public final void m21157a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f12834g = mutableFlatBuffer.a(i, 3);
    }

    public final int m21154a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m21160j());
        int a = ModelHelper.a(flatBufferBuilder, m21161k());
        int b2 = flatBufferBuilder.b(m21162l());
        int a2 = ModelHelper.a(flatBufferBuilder, m21164n());
        flatBufferBuilder.c(5);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, a);
        flatBufferBuilder.b(2, b2);
        flatBufferBuilder.a(3, m21163m());
        flatBufferBuilder.b(4, a2);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLQuestionOption(Parcel parcel) {
        super(6);
        this.f12831d = parcel.readString();
        this.f12832e = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f12833f = parcel.readString();
        this.f12834g = parcel.readByte() == (byte) 1;
        this.f12835h = (GraphQLQuestionOptionVotersConnection) parcel.readValue(GraphQLQuestionOptionVotersConnection.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m21160j());
        parcel.writeValue(m21161k());
        parcel.writeString(m21162l());
        parcel.writeByte((byte) (m21163m() ? 1 : 0));
        parcel.writeValue(m21164n());
    }

    public GraphQLQuestionOption(Builder builder) {
        super(6);
        this.b = builder.a;
        this.c = builder.b;
        this.f12831d = builder.f12826d;
        this.f12832e = builder.f12827e;
        this.f12833f = builder.f12828f;
        this.f12834g = builder.f12829g;
        this.f12835h = builder.f12830h;
    }
}
