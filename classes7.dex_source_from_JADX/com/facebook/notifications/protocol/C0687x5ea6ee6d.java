package com.facebook.notifications.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithBridge;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLModels.NotificationsEdgeFieldsModel;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLParsers.FirstNotificationsQueryParser.NotificationStoriesParser;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLParsers.FirstNotificationsQueryParser.NotificationStoriesParser.PageInfoParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.nio.ByteBuffer;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@FragmentModelWithBridge
@JsonDeserialize(using = Deserializer.class)
@ModelWithFlatBufferFormatHash(a = 1634430376)
@JsonSerialize(using = Serializer.class)
/* compiled from: negativeFeedbackActionOnReportableEntity */
public final class C0687x5ea6ee6d extends BaseModel implements GraphQLVisitableModel {
    @Nullable
    private List<NotificationsEdgeFieldsModel> f8450d;
    @Nullable
    private PageInfoModel f8451e;

    /* compiled from: negativeFeedbackActionOnReportableEntity */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(C0687x5ea6ee6d.class, new Deserializer());
        }

        public Object m10055a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(NotificationStoriesParser.m10265a(jsonParser, flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
            Object c0687x5ea6ee6d = new C0687x5ea6ee6d();
            ((BaseModel) c0687x5ea6ee6d).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
            if (c0687x5ea6ee6d instanceof Postprocessable) {
                return ((Postprocessable) c0687x5ea6ee6d).a();
            }
            return c0687x5ea6ee6d;
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1947362733)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: negativeFeedbackActionOnReportableEntity */
    public final class PageInfoModel extends BaseModel implements GraphQLVisitableModel {
        private boolean f8449d;

        /* compiled from: negativeFeedbackActionOnReportableEntity */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PageInfoModel.class, new Deserializer());
            }

            public Object m10056a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PageInfoParser.m10263a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object pageInfoModel = new PageInfoModel();
                ((BaseModel) pageInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (pageInfoModel instanceof Postprocessable) {
                    return ((Postprocessable) pageInfoModel).a();
                }
                return pageInfoModel;
            }
        }

        /* compiled from: negativeFeedbackActionOnReportableEntity */
        public class Serializer extends JsonSerializer<PageInfoModel> {
            public final void m10057a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PageInfoModel pageInfoModel = (PageInfoModel) obj;
                if (pageInfoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pageInfoModel.m10058a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pageInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PageInfoParser.m10264a(pageInfoModel.w_(), pageInfoModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(PageInfoModel.class, new Serializer());
            }
        }

        public PageInfoModel() {
            super(1);
        }

        public final boolean m10061a() {
            a(0, 0);
            return this.f8449d;
        }

        public final int jK_() {
            return 923779069;
        }

        public final GraphQLVisitableModel m10059a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m10058a(FlatBufferBuilder flatBufferBuilder) {
            h();
            flatBufferBuilder.c(1);
            flatBufferBuilder.a(0, this.f8449d);
            i();
            return flatBufferBuilder.d();
        }

        public final void m10060a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f8449d = mutableFlatBuffer.a(i, 0);
        }
    }

    /* compiled from: negativeFeedbackActionOnReportableEntity */
    public class Serializer extends JsonSerializer<C0687x5ea6ee6d> {
        public final void m10062a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            C0687x5ea6ee6d c0687x5ea6ee6d = (C0687x5ea6ee6d) obj;
            if (c0687x5ea6ee6d.w_() == null) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(c0687x5ea6ee6d.m10063a(flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                c0687x5ea6ee6d.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }
            NotificationStoriesParser.m10266a(c0687x5ea6ee6d.w_(), c0687x5ea6ee6d.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(C0687x5ea6ee6d.class, new Serializer());
        }
    }

    public C0687x5ea6ee6d() {
        super(2);
    }

    @Nonnull
    public final ImmutableList<NotificationsEdgeFieldsModel> m10065a() {
        this.f8450d = super.a(this.f8450d, 0, NotificationsEdgeFieldsModel.class);
        return (ImmutableList) this.f8450d;
    }

    @Nullable
    public final PageInfoModel m10066j() {
        this.f8451e = (PageInfoModel) super.a(this.f8451e, 1, PageInfoModel.class);
        return this.f8451e;
    }

    public final int jK_() {
        return -1207080506;
    }

    public final GraphQLVisitableModel m10064a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel;
        PageInfoModel pageInfoModel;
        h();
        if (m10065a() != null) {
            Builder a = ModelHelper.a(m10065a(), graphQLModelMutatingVisitor);
            if (a != null) {
                C0687x5ea6ee6d c0687x5ea6ee6d = (C0687x5ea6ee6d) ModelHelper.a(null, this);
                c0687x5ea6ee6d.f8450d = a.b();
                graphQLVisitableModel = c0687x5ea6ee6d;
                if (m10066j() != null) {
                    pageInfoModel = (PageInfoModel) graphQLModelMutatingVisitor.b(m10066j());
                    if (m10066j() != pageInfoModel) {
                        graphQLVisitableModel = (C0687x5ea6ee6d) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f8451e = pageInfoModel;
                    }
                }
                i();
                return graphQLVisitableModel != null ? this : graphQLVisitableModel;
            }
        }
        graphQLVisitableModel = null;
        if (m10066j() != null) {
            pageInfoModel = (PageInfoModel) graphQLModelMutatingVisitor.b(m10066j());
            if (m10066j() != pageInfoModel) {
                graphQLVisitableModel = (C0687x5ea6ee6d) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f8451e = pageInfoModel;
            }
        }
        i();
        if (graphQLVisitableModel != null) {
        }
    }

    public final int m10063a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m10065a());
        int a2 = ModelHelper.a(flatBufferBuilder, m10066j());
        flatBufferBuilder.c(2);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, a2);
        i();
        return flatBufferBuilder.d();
    }
}
