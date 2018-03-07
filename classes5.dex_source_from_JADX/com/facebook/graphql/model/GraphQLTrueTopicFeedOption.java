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
import com.facebook.graphql.deserializers.GraphQLTrueTopicFeedOptionDeserializer;
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
import com.instagram.common.json.annotation.JsonType;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: Transform returned null */
public final class GraphQLTrueTopicFeedOption extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableConsistentModel {
    public static final Creator<GraphQLTrueTopicFeedOption> CREATOR = new C12611();
    @Nullable
    public String f13366d;
    @Nullable
    public String f13367e;
    public boolean f13368f;
    @Nullable
    public GraphQLImage f13369g;
    @Nullable
    public GraphQLTopicFeedOption f13370h;
    @Nullable
    public String f13371i;

    /* compiled from: Transform returned null */
    final class C12611 implements Creator<GraphQLTrueTopicFeedOption> {
        C12611() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLTrueTopicFeedOption(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLTrueTopicFeedOption[i];
        }
    }

    /* compiled from: Transform returned null */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLTrueTopicFeedOption.class, new Deserializer());
        }

        public Object m22303a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLTrueTopicFeedOptionDeserializer.m6131a(jsonParser, (short) 530);
            Object graphQLTrueTopicFeedOption = new GraphQLTrueTopicFeedOption();
            ((BaseModel) graphQLTrueTopicFeedOption).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLTrueTopicFeedOption instanceof Postprocessable) {
                return ((Postprocessable) graphQLTrueTopicFeedOption).a();
            }
            return graphQLTrueTopicFeedOption;
        }
    }

    /* compiled from: Transform returned null */
    public final class Serializer extends JsonSerializer<GraphQLTrueTopicFeedOption> {
        public final void m22304a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLTrueTopicFeedOption graphQLTrueTopicFeedOption = (GraphQLTrueTopicFeedOption) obj;
            GraphQLTrueTopicFeedOptionDeserializer.m6132a(graphQLTrueTopicFeedOption.w_(), graphQLTrueTopicFeedOption.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLTrueTopicFeedOption.class, new Serializer());
            FbSerializerProvider.a(GraphQLTrueTopicFeedOption.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final String m22311j() {
        this.f13366d = super.a(this.f13366d, 0);
        return this.f13366d;
    }

    @FieldOffset
    @Nullable
    public final String m22312k() {
        this.f13367e = super.a(this.f13367e, 1);
        return this.f13367e;
    }

    @FieldOffset
    public final boolean m22313l() {
        a(0, 2);
        return this.f13368f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m22314m() {
        this.f13369g = (GraphQLImage) super.a(this.f13369g, 3, GraphQLImage.class);
        return this.f13369g;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTopicFeedOption m22315n() {
        this.f13370h = (GraphQLTopicFeedOption) super.a(this.f13370h, 4, GraphQLTopicFeedOption.class);
        return this.f13370h;
    }

    @FieldOffset
    @Nullable
    public final String m22316o() {
        this.f13371i = super.a(this.f13371i, 5);
        return this.f13371i;
    }

    @Nullable
    public final String m22307a() {
        return m22312k();
    }

    public final int jK_() {
        return -538844492;
    }

    public final GraphQLVisitableModel m22306a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m22314m() != null) {
            GraphQLImage graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m22314m());
            if (m22314m() != graphQLImage) {
                graphQLVisitableModel = (GraphQLTrueTopicFeedOption) ModelHelper.a(null, this);
                graphQLVisitableModel.f13369g = graphQLImage;
            }
        }
        if (m22315n() != null) {
            GraphQLTopicFeedOption graphQLTopicFeedOption = (GraphQLTopicFeedOption) graphQLModelMutatingVisitor.b(m22315n());
            if (m22315n() != graphQLTopicFeedOption) {
                graphQLVisitableModel = (GraphQLTrueTopicFeedOption) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f13370h = graphQLTopicFeedOption;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final void m22309a(String str, ConsistencyTuple consistencyTuple) {
        if ("is_checked".equals(str)) {
            consistencyTuple.a = Boolean.valueOf(m22313l());
            consistencyTuple.b = u_();
            consistencyTuple.c = 2;
            return;
        }
        consistencyTuple.a();
    }

    public final void m22310a(String str, Object obj, boolean z) {
        if ("is_checked".equals(str)) {
            boolean booleanValue = ((Boolean) obj).booleanValue();
            this.f13368f = booleanValue;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 2, booleanValue);
            }
        }
    }

    public GraphQLTrueTopicFeedOption() {
        super(7);
    }

    public final void m22308a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f13368f = mutableFlatBuffer.a(i, 2);
    }

    public final int m22305a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m22311j());
        int b2 = flatBufferBuilder.b(m22312k());
        int a = ModelHelper.a(flatBufferBuilder, m22314m());
        int a2 = ModelHelper.a(flatBufferBuilder, m22315n());
        int b3 = flatBufferBuilder.b(m22316o());
        flatBufferBuilder.c(6);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, b2);
        flatBufferBuilder.a(2, m22313l());
        flatBufferBuilder.b(3, a);
        flatBufferBuilder.b(4, a2);
        flatBufferBuilder.b(5, b3);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLTrueTopicFeedOption(Parcel parcel) {
        boolean z = true;
        super(7);
        this.f13366d = parcel.readString();
        this.f13367e = parcel.readString();
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.f13368f = z;
        this.f13369g = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f13370h = (GraphQLTopicFeedOption) parcel.readValue(GraphQLTopicFeedOption.class.getClassLoader());
        this.f13371i = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m22311j());
        parcel.writeString(m22312k());
        parcel.writeByte((byte) (m22313l() ? 1 : 0));
        parcel.writeValue(m22314m());
        parcel.writeValue(m22315n());
        parcel.writeString(m22316o());
    }
}
