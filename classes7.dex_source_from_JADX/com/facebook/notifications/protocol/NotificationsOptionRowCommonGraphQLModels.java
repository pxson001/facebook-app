package com.facebook.notifications.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLNotifOptionRowSetDisplayStyle;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.notifications.protocol.NotificationsOptionRowCommonGraphQLInterfaces.StyleOnlyNotifOptionSetDisplayFragment;
import com.facebook.notifications.protocol.NotificationsOptionRowCommonGraphQLParsers.StyleOnlyNotifOptionSetDisplayFragmentParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: music_sprout_shown_with_song */
public class NotificationsOptionRowCommonGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 2116840472)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: music_sprout_shown_with_song */
    public final class StyleOnlyNotifOptionSetDisplayFragmentModel extends BaseModel implements GraphQLVisitableModel, StyleOnlyNotifOptionSetDisplayFragment {
        @Nullable
        private GraphQLNotifOptionRowSetDisplayStyle f8668d;

        /* compiled from: music_sprout_shown_with_song */
        public final class Builder {
            @Nullable
            public GraphQLNotifOptionRowSetDisplayStyle f8667a;

            public final StyleOnlyNotifOptionSetDisplayFragmentModel m10647a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = flatBufferBuilder.a(this.f8667a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new StyleOnlyNotifOptionSetDisplayFragmentModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: music_sprout_shown_with_song */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(StyleOnlyNotifOptionSetDisplayFragmentModel.class, new Deserializer());
            }

            public Object m10648a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(StyleOnlyNotifOptionSetDisplayFragmentParser.m10654a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object styleOnlyNotifOptionSetDisplayFragmentModel = new StyleOnlyNotifOptionSetDisplayFragmentModel();
                ((BaseModel) styleOnlyNotifOptionSetDisplayFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (styleOnlyNotifOptionSetDisplayFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) styleOnlyNotifOptionSetDisplayFragmentModel).a();
                }
                return styleOnlyNotifOptionSetDisplayFragmentModel;
            }
        }

        /* compiled from: music_sprout_shown_with_song */
        public class Serializer extends JsonSerializer<StyleOnlyNotifOptionSetDisplayFragmentModel> {
            public final void m10649a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                StyleOnlyNotifOptionSetDisplayFragmentModel styleOnlyNotifOptionSetDisplayFragmentModel = (StyleOnlyNotifOptionSetDisplayFragmentModel) obj;
                if (styleOnlyNotifOptionSetDisplayFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(styleOnlyNotifOptionSetDisplayFragmentModel.m10651a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    styleOnlyNotifOptionSetDisplayFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                StyleOnlyNotifOptionSetDisplayFragmentParser.m10655a(styleOnlyNotifOptionSetDisplayFragmentModel.w_(), styleOnlyNotifOptionSetDisplayFragmentModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(StyleOnlyNotifOptionSetDisplayFragmentModel.class, new Serializer());
            }
        }

        public StyleOnlyNotifOptionSetDisplayFragmentModel() {
            super(1);
        }

        public StyleOnlyNotifOptionSetDisplayFragmentModel(MutableFlatBuffer mutableFlatBuffer) {
            super(1);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final GraphQLNotifOptionRowSetDisplayStyle mo465c() {
            this.f8668d = (GraphQLNotifOptionRowSetDisplayStyle) super.b(this.f8668d, 0, GraphQLNotifOptionRowSetDisplayStyle.class, GraphQLNotifOptionRowSetDisplayStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f8668d;
        }

        public static StyleOnlyNotifOptionSetDisplayFragmentModel m10650a(StyleOnlyNotifOptionSetDisplayFragment styleOnlyNotifOptionSetDisplayFragment) {
            if (styleOnlyNotifOptionSetDisplayFragment == null) {
                return null;
            }
            if (styleOnlyNotifOptionSetDisplayFragment instanceof StyleOnlyNotifOptionSetDisplayFragmentModel) {
                return (StyleOnlyNotifOptionSetDisplayFragmentModel) styleOnlyNotifOptionSetDisplayFragment;
            }
            Builder builder = new Builder();
            builder.f8667a = styleOnlyNotifOptionSetDisplayFragment.mo465c();
            return builder.m10647a();
        }

        public final int jK_() {
            return -1770031694;
        }

        public final GraphQLVisitableModel m10652a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m10651a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = flatBufferBuilder.a(mo465c());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}
