package com.facebook.api.graphql.reactions;

import com.facebook.api.graphql.reactions.ReactionsGraphQLParsers.ReactionsCountFieldsParser.TopReactionsParser.EdgesParser;
import com.facebook.api.graphql.reactions.ReactionsGraphQLParsers.ReactionsCountFieldsParser.TopReactionsParser.EdgesParser.NodeParser;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

@JsonDeserialize(using = Deserializer.class)
@ModelWithFlatBufferFormatHash(a = -821342164)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: android_place_picker_long_press_report_duplicates */
public final class C0972x35cc8477 extends BaseModel implements GraphQLVisitableModel {
    @Nullable
    private NodeModel f9802d;
    private int f9803e;

    /* compiled from: android_place_picker_long_press_report_duplicates */
    public final class Builder {
        @Nullable
        public NodeModel f9798a;
        public int f9799b;
    }

    /* compiled from: android_place_picker_long_press_report_duplicates */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(C0972x35cc8477.class, new Deserializer());
        }

        public Object m17041a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(EdgesParser.m17157b(jsonParser, flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
            Object c0972x35cc8477 = new C0972x35cc8477();
            ((BaseModel) c0972x35cc8477).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
            if (c0972x35cc8477 instanceof Postprocessable) {
                return ((Postprocessable) c0972x35cc8477).a();
            }
            return c0972x35cc8477;
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 224127441)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: android_place_picker_long_press_report_duplicates */
    public final class NodeModel extends BaseModel implements GraphQLVisitableModel {
        private int f9801d;

        /* compiled from: android_place_picker_long_press_report_duplicates */
        public final class Builder {
            public int f9800a;
        }

        /* compiled from: android_place_picker_long_press_report_duplicates */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
            }

            public Object m17042a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(NodeParser.m17155a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object nodeModel = new NodeModel();
                ((BaseModel) nodeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (nodeModel instanceof Postprocessable) {
                    return ((Postprocessable) nodeModel).a();
                }
                return nodeModel;
            }
        }

        /* compiled from: android_place_picker_long_press_report_duplicates */
        public class Serializer extends JsonSerializer<NodeModel> {
            public final void m17043a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                NodeModel nodeModel = (NodeModel) obj;
                if (nodeModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(nodeModel.m17046a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                NodeParser.m17156a(nodeModel.w_(), nodeModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(NodeModel.class, new Serializer());
            }
        }

        public NodeModel() {
            super(1);
        }

        public NodeModel(MutableFlatBuffer mutableFlatBuffer) {
            super(1);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final int m17045a() {
            a(0, 0);
            return this.f9801d;
        }

        public static NodeModel m17044a(NodeModel nodeModel) {
            if (nodeModel == null) {
                return null;
            }
            if (nodeModel instanceof NodeModel) {
                return nodeModel;
            }
            Builder builder = new Builder();
            builder.f9800a = nodeModel.m17045a();
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.c(1);
            flatBufferBuilder.a(0, builder.f9800a, 0);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new NodeModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }

        public final int jK_() {
            return -1654469956;
        }

        public final GraphQLVisitableModel m17047a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m17046a(FlatBufferBuilder flatBufferBuilder) {
            h();
            flatBufferBuilder.c(1);
            flatBufferBuilder.a(0, this.f9801d, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m17048a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f9801d = mutableFlatBuffer.a(i, 0, 0);
        }
    }

    /* compiled from: android_place_picker_long_press_report_duplicates */
    public class Serializer extends JsonSerializer<C0972x35cc8477> {
        public final void m17049a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            C0972x35cc8477 c0972x35cc8477 = (C0972x35cc8477) obj;
            if (c0972x35cc8477.w_() == null) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(c0972x35cc8477.m17052a(flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                c0972x35cc8477.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }
            EdgesParser.m17158b(c0972x35cc8477.w_(), c0972x35cc8477.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(C0972x35cc8477.class, new Serializer());
        }
    }

    @Nullable
    public final /* synthetic */ NodeModel m17053a() {
        return m17051j();
    }

    public C0972x35cc8477() {
        super(2);
    }

    public C0972x35cc8477(MutableFlatBuffer mutableFlatBuffer) {
        super(2);
        a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
    }

    @Nullable
    private NodeModel m17051j() {
        this.f9802d = (NodeModel) super.a(this.f9802d, 0, NodeModel.class);
        return this.f9802d;
    }

    public final int m17056b() {
        a(0, 1);
        return this.f9803e;
    }

    public static C0972x35cc8477 m17050a(C0972x35cc8477 c0972x35cc8477) {
        if (c0972x35cc8477 == null) {
            return null;
        }
        if (c0972x35cc8477 instanceof C0972x35cc8477) {
            return c0972x35cc8477;
        }
        Builder builder = new Builder();
        builder.f9798a = NodeModel.m17044a(c0972x35cc8477.m17053a());
        builder.f9799b = c0972x35cc8477.m17056b();
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int a = ModelHelper.a(flatBufferBuilder, builder.f9798a);
        flatBufferBuilder.c(2);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.a(1, builder.f9799b, 0);
        flatBufferBuilder.d(flatBufferBuilder.d());
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        return new C0972x35cc8477(new MutableFlatBuffer(wrap, null, null, true, null));
    }

    public final int jK_() {
        return -1719612142;
    }

    public final GraphQLVisitableModel m17054a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m17051j() != null) {
            NodeModel nodeModel = (NodeModel) graphQLModelMutatingVisitor.b(m17051j());
            if (m17051j() != nodeModel) {
                graphQLVisitableModel = (C0972x35cc8477) ModelHelper.a(null, this);
                graphQLVisitableModel.f9802d = nodeModel;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final int m17052a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m17051j());
        flatBufferBuilder.c(2);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.a(1, this.f9803e, 0);
        i();
        return flatBufferBuilder.d();
    }

    public final void m17055a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f9803e = mutableFlatBuffer.a(i, 1, 0);
    }
}
