package com.facebook.messaging.graphql.threads;

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
import com.facebook.messaging.graphql.threads.BotMessageQueriesParsers.MovieActionLinkFragmentParser;
import com.facebook.messaging.graphql.threads.BotMessageQueriesParsers.MovieAddressFragmentParser;
import com.facebook.messaging.graphql.threads.BotMessageQueriesParsers.MovieButtonFragmentParser;
import com.facebook.messaging.graphql.threads.BotMessageQueriesParsers.MovieDateFragmentParser;
import com.facebook.messaging.graphql.threads.BotMessageQueriesParsers.MovieDetailsFragmentParser;
import com.facebook.messaging.graphql.threads.BotMessageQueriesParsers.MovieImageFragmentParser;
import com.facebook.messaging.graphql.threads.BotMessageQueriesParsers.MovieShowtimeFragmentParser;
import com.facebook.messaging.graphql.threads.BotMessageQueriesParsers.MovieTheaterFragmentParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: video_download_deleted */
public class BotMessageQueriesModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 2144446797)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: video_download_deleted */
    public final class MovieActionLinkFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f778d;

        /* compiled from: video_download_deleted */
        public final class Builder {
            @Nullable
            public String f777a;
        }

        /* compiled from: video_download_deleted */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MovieActionLinkFragmentModel.class, new Deserializer());
            }

            public Object m870a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(MovieActionLinkFragmentParser.m934b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object movieActionLinkFragmentModel = new MovieActionLinkFragmentModel();
                ((BaseModel) movieActionLinkFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (movieActionLinkFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) movieActionLinkFragmentModel).a();
                }
                return movieActionLinkFragmentModel;
            }
        }

        /* compiled from: video_download_deleted */
        public class Serializer extends JsonSerializer<MovieActionLinkFragmentModel> {
            public final void m871a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MovieActionLinkFragmentModel movieActionLinkFragmentModel = (MovieActionLinkFragmentModel) obj;
                if (movieActionLinkFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(movieActionLinkFragmentModel.m873a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    movieActionLinkFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                MovieActionLinkFragmentParser.m932a(movieActionLinkFragmentModel.w_(), movieActionLinkFragmentModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(MovieActionLinkFragmentModel.class, new Serializer());
            }
        }

        public MovieActionLinkFragmentModel() {
            super(1);
        }

        public MovieActionLinkFragmentModel(MutableFlatBuffer mutableFlatBuffer) {
            super(1);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final String m875a() {
            this.f778d = super.a(this.f778d, 0);
            return this.f778d;
        }

        public static MovieActionLinkFragmentModel m872a(MovieActionLinkFragmentModel movieActionLinkFragmentModel) {
            if (movieActionLinkFragmentModel == null) {
                return null;
            }
            if (movieActionLinkFragmentModel instanceof MovieActionLinkFragmentModel) {
                return movieActionLinkFragmentModel;
            }
            Builder builder = new Builder();
            builder.f777a = movieActionLinkFragmentModel.m875a();
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int b = flatBufferBuilder.b(builder.f777a);
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new MovieActionLinkFragmentModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }

        public final int jK_() {
            return 987922247;
        }

        public final GraphQLVisitableModel m874a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m873a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m875a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2110849367)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: video_download_deleted */
    public final class MovieAddressFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f780d;

        /* compiled from: video_download_deleted */
        public final class Builder {
            @Nullable
            public String f779a;
        }

        /* compiled from: video_download_deleted */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MovieAddressFragmentModel.class, new Deserializer());
            }

            public Object m876a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(MovieAddressFragmentParser.m935a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object movieAddressFragmentModel = new MovieAddressFragmentModel();
                ((BaseModel) movieAddressFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (movieAddressFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) movieAddressFragmentModel).a();
                }
                return movieAddressFragmentModel;
            }
        }

        /* compiled from: video_download_deleted */
        public class Serializer extends JsonSerializer<MovieAddressFragmentModel> {
            public final void m877a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MovieAddressFragmentModel movieAddressFragmentModel = (MovieAddressFragmentModel) obj;
                if (movieAddressFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(movieAddressFragmentModel.m879a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    movieAddressFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                MovieAddressFragmentParser.m936a(movieAddressFragmentModel.w_(), movieAddressFragmentModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(MovieAddressFragmentModel.class, new Serializer());
            }
        }

        public MovieAddressFragmentModel() {
            super(1);
        }

        public MovieAddressFragmentModel(MutableFlatBuffer mutableFlatBuffer) {
            super(1);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final String m881a() {
            this.f780d = super.a(this.f780d, 0);
            return this.f780d;
        }

        public static MovieAddressFragmentModel m878a(MovieAddressFragmentModel movieAddressFragmentModel) {
            if (movieAddressFragmentModel == null) {
                return null;
            }
            if (movieAddressFragmentModel instanceof MovieAddressFragmentModel) {
                return movieAddressFragmentModel;
            }
            Builder builder = new Builder();
            builder.f779a = movieAddressFragmentModel.m881a();
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int b = flatBufferBuilder.b(builder.f779a);
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new MovieAddressFragmentModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }

        public final int jK_() {
            return 799251025;
        }

        public final GraphQLVisitableModel m880a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m879a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m881a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1197801610)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: video_download_deleted */
    public final class MovieButtonFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<MovieActionLinkFragmentModel> f783d;
        @Nullable
        private String f784e;

        /* compiled from: video_download_deleted */
        public final class Builder {
            @Nullable
            public ImmutableList<MovieActionLinkFragmentModel> f781a;
            @Nullable
            public String f782b;
        }

        /* compiled from: video_download_deleted */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MovieButtonFragmentModel.class, new Deserializer());
            }

            public Object m882a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(MovieButtonFragmentParser.m939b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object movieButtonFragmentModel = new MovieButtonFragmentModel();
                ((BaseModel) movieButtonFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (movieButtonFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) movieButtonFragmentModel).a();
                }
                return movieButtonFragmentModel;
            }
        }

        /* compiled from: video_download_deleted */
        public class Serializer extends JsonSerializer<MovieButtonFragmentModel> {
            public final void m883a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MovieButtonFragmentModel movieButtonFragmentModel = (MovieButtonFragmentModel) obj;
                if (movieButtonFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(movieButtonFragmentModel.m885a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    movieButtonFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                MovieButtonFragmentParser.m940b(movieButtonFragmentModel.w_(), movieButtonFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(MovieButtonFragmentModel.class, new Serializer());
            }
        }

        public MovieButtonFragmentModel() {
            super(2);
        }

        public MovieButtonFragmentModel(MutableFlatBuffer mutableFlatBuffer) {
            super(2);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nonnull
        public final ImmutableList<MovieActionLinkFragmentModel> m887a() {
            this.f783d = super.a(this.f783d, 0, MovieActionLinkFragmentModel.class);
            return (ImmutableList) this.f783d;
        }

        @Nullable
        public final String m888b() {
            this.f784e = super.a(this.f784e, 1);
            return this.f784e;
        }

        public static MovieButtonFragmentModel m884a(MovieButtonFragmentModel movieButtonFragmentModel) {
            if (movieButtonFragmentModel == null) {
                return null;
            }
            if (movieButtonFragmentModel instanceof MovieButtonFragmentModel) {
                return movieButtonFragmentModel;
            }
            Builder builder = new Builder();
            com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i = 0; i < movieButtonFragmentModel.m887a().size(); i++) {
                builder2.c(MovieActionLinkFragmentModel.m872a((MovieActionLinkFragmentModel) movieButtonFragmentModel.m887a().get(i)));
            }
            builder.f781a = builder2.b();
            builder.f782b = movieButtonFragmentModel.m888b();
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int a = ModelHelper.a(flatBufferBuilder, builder.f781a);
            int b = flatBufferBuilder.b(builder.f782b);
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new MovieButtonFragmentModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }

        public final int jK_() {
            return 219128489;
        }

        public final GraphQLVisitableModel m886a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m887a() != null) {
                com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m887a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (MovieButtonFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f783d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m885a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m887a());
            int b = flatBufferBuilder.b(m888b());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1352864475)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: video_download_deleted */
    public final class MovieDateFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f786d;

        /* compiled from: video_download_deleted */
        public final class Builder {
            @Nullable
            public String f785a;
        }

        /* compiled from: video_download_deleted */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MovieDateFragmentModel.class, new Deserializer());
            }

            public Object m889a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(MovieDateFragmentParser.m941a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object movieDateFragmentModel = new MovieDateFragmentModel();
                ((BaseModel) movieDateFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (movieDateFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) movieDateFragmentModel).a();
                }
                return movieDateFragmentModel;
            }
        }

        /* compiled from: video_download_deleted */
        public class Serializer extends JsonSerializer<MovieDateFragmentModel> {
            public final void m890a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MovieDateFragmentModel movieDateFragmentModel = (MovieDateFragmentModel) obj;
                if (movieDateFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(movieDateFragmentModel.m892a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    movieDateFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                MovieDateFragmentParser.m942a(movieDateFragmentModel.w_(), movieDateFragmentModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(MovieDateFragmentModel.class, new Serializer());
            }
        }

        public MovieDateFragmentModel() {
            super(1);
        }

        public MovieDateFragmentModel(MutableFlatBuffer mutableFlatBuffer) {
            super(1);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final String m894a() {
            this.f786d = super.a(this.f786d, 0);
            return this.f786d;
        }

        public static MovieDateFragmentModel m891a(MovieDateFragmentModel movieDateFragmentModel) {
            if (movieDateFragmentModel == null) {
                return null;
            }
            if (movieDateFragmentModel instanceof MovieDateFragmentModel) {
                return movieDateFragmentModel;
            }
            Builder builder = new Builder();
            builder.f785a = movieDateFragmentModel.m894a();
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int b = flatBufferBuilder.b(builder.f785a);
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new MovieDateFragmentModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }

        public final int jK_() {
            return -888397508;
        }

        public final GraphQLVisitableModel m893a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m892a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m894a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -113912984)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: video_download_deleted */
    public final class MovieDetailsFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<MovieActionLinkFragmentModel> f794d;
        @Nullable
        private List<String> f795e;
        @Nullable
        private List<String> f796f;
        @Nullable
        private MovieImageFragmentModel f797g;
        @Nullable
        private String f798h;
        @Nullable
        private String f799i;
        private int f800j;

        /* compiled from: video_download_deleted */
        public final class Builder {
            @Nullable
            public ImmutableList<MovieActionLinkFragmentModel> f787a;
            @Nullable
            public ImmutableList<String> f788b;
            @Nullable
            public ImmutableList<String> f789c;
            @Nullable
            public MovieImageFragmentModel f790d;
            @Nullable
            public String f791e;
            @Nullable
            public String f792f;
            public int f793g;

            public final MovieDetailsFragmentModel m895a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, this.f787a);
                int c = flatBufferBuilder.c(this.f788b);
                int c2 = flatBufferBuilder.c(this.f789c);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f790d);
                int b = flatBufferBuilder.b(this.f791e);
                int b2 = flatBufferBuilder.b(this.f792f);
                flatBufferBuilder.c(7);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, c);
                flatBufferBuilder.b(2, c2);
                flatBufferBuilder.b(3, a2);
                flatBufferBuilder.b(4, b);
                flatBufferBuilder.b(5, b2);
                flatBufferBuilder.a(6, this.f793g, 0);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new MovieDetailsFragmentModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: video_download_deleted */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MovieDetailsFragmentModel.class, new Deserializer());
            }

            public Object m896a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(MovieDetailsFragmentParser.m943a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object movieDetailsFragmentModel = new MovieDetailsFragmentModel();
                ((BaseModel) movieDetailsFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (movieDetailsFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) movieDetailsFragmentModel).a();
                }
                return movieDetailsFragmentModel;
            }
        }

        /* compiled from: video_download_deleted */
        public class Serializer extends JsonSerializer<MovieDetailsFragmentModel> {
            public final void m897a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MovieDetailsFragmentModel movieDetailsFragmentModel = (MovieDetailsFragmentModel) obj;
                if (movieDetailsFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(movieDetailsFragmentModel.m900a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    movieDetailsFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                MovieDetailsFragmentParser.m946b(movieDetailsFragmentModel.w_(), movieDetailsFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(MovieDetailsFragmentModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ MovieImageFragmentModel m906d() {
            return m899j();
        }

        public MovieDetailsFragmentModel() {
            super(7);
        }

        public MovieDetailsFragmentModel(MutableFlatBuffer mutableFlatBuffer) {
            super(7);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nonnull
        public final ImmutableList<MovieActionLinkFragmentModel> m902a() {
            this.f794d = super.a(this.f794d, 0, MovieActionLinkFragmentModel.class);
            return (ImmutableList) this.f794d;
        }

        @Nonnull
        public final ImmutableList<String> m904b() {
            this.f795e = super.a(this.f795e, 1);
            return (ImmutableList) this.f795e;
        }

        @Nonnull
        public final ImmutableList<String> m905c() {
            this.f796f = super.a(this.f796f, 2);
            return (ImmutableList) this.f796f;
        }

        @Nullable
        private MovieImageFragmentModel m899j() {
            this.f797g = (MovieImageFragmentModel) super.a(this.f797g, 3, MovieImageFragmentModel.class);
            return this.f797g;
        }

        @Nullable
        public final String ap_() {
            this.f798h = super.a(this.f798h, 4);
            return this.f798h;
        }

        @Nullable
        public final String m907g() {
            this.f799i = super.a(this.f799i, 5);
            return this.f799i;
        }

        public final int aq_() {
            a(0, 6);
            return this.f800j;
        }

        public static MovieDetailsFragmentModel m898a(MovieDetailsFragmentModel movieDetailsFragmentModel) {
            int i = 0;
            if (movieDetailsFragmentModel == null) {
                return null;
            }
            if (movieDetailsFragmentModel instanceof MovieDetailsFragmentModel) {
                return movieDetailsFragmentModel;
            }
            Builder builder = new Builder();
            com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i2 = 0; i2 < movieDetailsFragmentModel.m902a().size(); i2++) {
                builder2.c(MovieActionLinkFragmentModel.m872a((MovieActionLinkFragmentModel) movieDetailsFragmentModel.m902a().get(i2)));
            }
            builder.f787a = builder2.b();
            com.google.common.collect.ImmutableList.Builder builder3 = ImmutableList.builder();
            for (int i3 = 0; i3 < movieDetailsFragmentModel.m904b().size(); i3++) {
                builder3.c(movieDetailsFragmentModel.m904b().get(i3));
            }
            builder.f788b = builder3.b();
            com.google.common.collect.ImmutableList.Builder builder4 = ImmutableList.builder();
            while (i < movieDetailsFragmentModel.m905c().size()) {
                builder4.c(movieDetailsFragmentModel.m905c().get(i));
                i++;
            }
            builder.f789c = builder4.b();
            builder.f790d = MovieImageFragmentModel.m910a(movieDetailsFragmentModel.m906d());
            builder.f791e = movieDetailsFragmentModel.ap_();
            builder.f792f = movieDetailsFragmentModel.m907g();
            builder.f793g = movieDetailsFragmentModel.aq_();
            return builder.m895a();
        }

        public final int jK_() {
            return -398591783;
        }

        public final GraphQLVisitableModel m901a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel;
            MovieImageFragmentModel movieImageFragmentModel;
            h();
            if (m902a() != null) {
                com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m902a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    MovieDetailsFragmentModel movieDetailsFragmentModel = (MovieDetailsFragmentModel) ModelHelper.a(null, this);
                    movieDetailsFragmentModel.f794d = a.b();
                    graphQLVisitableModel = movieDetailsFragmentModel;
                    if (m899j() != null) {
                        movieImageFragmentModel = (MovieImageFragmentModel) graphQLModelMutatingVisitor.b(m899j());
                        if (m899j() != movieImageFragmentModel) {
                            graphQLVisitableModel = (MovieDetailsFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f797g = movieImageFragmentModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                }
            }
            graphQLVisitableModel = null;
            if (m899j() != null) {
                movieImageFragmentModel = (MovieImageFragmentModel) graphQLModelMutatingVisitor.b(m899j());
                if (m899j() != movieImageFragmentModel) {
                    graphQLVisitableModel = (MovieDetailsFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f797g = movieImageFragmentModel;
                }
            }
            i();
            if (graphQLVisitableModel != null) {
            }
        }

        public final int m900a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m902a());
            int c = flatBufferBuilder.c(m904b());
            int c2 = flatBufferBuilder.c(m905c());
            int a2 = ModelHelper.a(flatBufferBuilder, m899j());
            int b = flatBufferBuilder.b(ap_());
            int b2 = flatBufferBuilder.b(m907g());
            flatBufferBuilder.c(7);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, c);
            flatBufferBuilder.b(2, c2);
            flatBufferBuilder.b(3, a2);
            flatBufferBuilder.b(4, b);
            flatBufferBuilder.b(5, b2);
            flatBufferBuilder.a(6, this.f800j, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m903a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f800j = mutableFlatBuffer.a(i, 6, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 842551240)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: video_download_deleted */
    public final class MovieImageFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f802d;

        /* compiled from: video_download_deleted */
        public final class Builder {
            @Nullable
            public String f801a;
        }

        /* compiled from: video_download_deleted */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MovieImageFragmentModel.class, new Deserializer());
            }

            public Object m908a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(MovieImageFragmentParser.m947a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object movieImageFragmentModel = new MovieImageFragmentModel();
                ((BaseModel) movieImageFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (movieImageFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) movieImageFragmentModel).a();
                }
                return movieImageFragmentModel;
            }
        }

        /* compiled from: video_download_deleted */
        public class Serializer extends JsonSerializer<MovieImageFragmentModel> {
            public final void m909a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MovieImageFragmentModel movieImageFragmentModel = (MovieImageFragmentModel) obj;
                if (movieImageFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(movieImageFragmentModel.m911a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    movieImageFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                MovieImageFragmentParser.m948a(movieImageFragmentModel.w_(), movieImageFragmentModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(MovieImageFragmentModel.class, new Serializer());
            }
        }

        public MovieImageFragmentModel() {
            super(1);
        }

        public MovieImageFragmentModel(MutableFlatBuffer mutableFlatBuffer) {
            super(1);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final String m913a() {
            this.f802d = super.a(this.f802d, 0);
            return this.f802d;
        }

        public static MovieImageFragmentModel m910a(MovieImageFragmentModel movieImageFragmentModel) {
            if (movieImageFragmentModel == null) {
                return null;
            }
            if (movieImageFragmentModel instanceof MovieImageFragmentModel) {
                return movieImageFragmentModel;
            }
            Builder builder = new Builder();
            builder.f801a = movieImageFragmentModel.m913a();
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int b = flatBufferBuilder.b(builder.f801a);
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new MovieImageFragmentModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }

        public final int jK_() {
            return 70760763;
        }

        public final GraphQLVisitableModel m912a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m911a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m913a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1318471070)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: video_download_deleted */
    public final class MovieShowtimeFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<MovieActionLinkFragmentModel> f805d;
        @Nullable
        private MovieDateFragmentModel f806e;

        /* compiled from: video_download_deleted */
        public final class Builder {
            @Nullable
            public ImmutableList<MovieActionLinkFragmentModel> f803a;
            @Nullable
            public MovieDateFragmentModel f804b;
        }

        /* compiled from: video_download_deleted */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MovieShowtimeFragmentModel.class, new Deserializer());
            }

            public Object m914a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(MovieShowtimeFragmentParser.m949b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object movieShowtimeFragmentModel = new MovieShowtimeFragmentModel();
                ((BaseModel) movieShowtimeFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (movieShowtimeFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) movieShowtimeFragmentModel).a();
                }
                return movieShowtimeFragmentModel;
            }
        }

        /* compiled from: video_download_deleted */
        public class Serializer extends JsonSerializer<MovieShowtimeFragmentModel> {
            public final void m915a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MovieShowtimeFragmentModel movieShowtimeFragmentModel = (MovieShowtimeFragmentModel) obj;
                if (movieShowtimeFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(movieShowtimeFragmentModel.m918a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    movieShowtimeFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                MovieShowtimeFragmentParser.m950b(movieShowtimeFragmentModel.w_(), movieShowtimeFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(MovieShowtimeFragmentModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ MovieDateFragmentModel m921b() {
            return m917j();
        }

        public MovieShowtimeFragmentModel() {
            super(2);
        }

        public MovieShowtimeFragmentModel(MutableFlatBuffer mutableFlatBuffer) {
            super(2);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nonnull
        public final ImmutableList<MovieActionLinkFragmentModel> m920a() {
            this.f805d = super.a(this.f805d, 0, MovieActionLinkFragmentModel.class);
            return (ImmutableList) this.f805d;
        }

        @Nullable
        private MovieDateFragmentModel m917j() {
            this.f806e = (MovieDateFragmentModel) super.a(this.f806e, 1, MovieDateFragmentModel.class);
            return this.f806e;
        }

        public static MovieShowtimeFragmentModel m916a(MovieShowtimeFragmentModel movieShowtimeFragmentModel) {
            if (movieShowtimeFragmentModel == null) {
                return null;
            }
            if (movieShowtimeFragmentModel instanceof MovieShowtimeFragmentModel) {
                return movieShowtimeFragmentModel;
            }
            Builder builder = new Builder();
            com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i = 0; i < movieShowtimeFragmentModel.m920a().size(); i++) {
                builder2.c(MovieActionLinkFragmentModel.m872a((MovieActionLinkFragmentModel) movieShowtimeFragmentModel.m920a().get(i)));
            }
            builder.f803a = builder2.b();
            builder.f804b = MovieDateFragmentModel.m891a(movieShowtimeFragmentModel.m921b());
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int a = ModelHelper.a(flatBufferBuilder, builder.f803a);
            int a2 = ModelHelper.a(flatBufferBuilder, builder.f804b);
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new MovieShowtimeFragmentModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }

        public final int jK_() {
            return 1149164355;
        }

        public final GraphQLVisitableModel m919a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel;
            MovieDateFragmentModel movieDateFragmentModel;
            h();
            if (m920a() != null) {
                com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m920a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    MovieShowtimeFragmentModel movieShowtimeFragmentModel = (MovieShowtimeFragmentModel) ModelHelper.a(null, this);
                    movieShowtimeFragmentModel.f805d = a.b();
                    graphQLVisitableModel = movieShowtimeFragmentModel;
                    if (m917j() != null) {
                        movieDateFragmentModel = (MovieDateFragmentModel) graphQLModelMutatingVisitor.b(m917j());
                        if (m917j() != movieDateFragmentModel) {
                            graphQLVisitableModel = (MovieShowtimeFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f806e = movieDateFragmentModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                }
            }
            graphQLVisitableModel = null;
            if (m917j() != null) {
                movieDateFragmentModel = (MovieDateFragmentModel) graphQLModelMutatingVisitor.b(m917j());
                if (m917j() != movieDateFragmentModel) {
                    graphQLVisitableModel = (MovieShowtimeFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f806e = movieDateFragmentModel;
                }
            }
            i();
            if (graphQLVisitableModel != null) {
            }
        }

        public final int m918a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m920a());
            int a2 = ModelHelper.a(flatBufferBuilder, m917j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 392352763)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: video_download_deleted */
    public final class MovieTheaterFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private MovieAddressFragmentModel f810d;
        @Nullable
        private String f811e;
        @Nullable
        private List<MovieShowtimeFragmentModel> f812f;

        /* compiled from: video_download_deleted */
        public final class Builder {
            @Nullable
            public MovieAddressFragmentModel f807a;
            @Nullable
            public String f808b;
            @Nullable
            public ImmutableList<MovieShowtimeFragmentModel> f809c;
        }

        /* compiled from: video_download_deleted */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MovieTheaterFragmentModel.class, new Deserializer());
            }

            public Object m922a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(MovieTheaterFragmentParser.m953b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object movieTheaterFragmentModel = new MovieTheaterFragmentModel();
                ((BaseModel) movieTheaterFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (movieTheaterFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) movieTheaterFragmentModel).a();
                }
                return movieTheaterFragmentModel;
            }
        }

        /* compiled from: video_download_deleted */
        public class Serializer extends JsonSerializer<MovieTheaterFragmentModel> {
            public final void m923a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MovieTheaterFragmentModel movieTheaterFragmentModel = (MovieTheaterFragmentModel) obj;
                if (movieTheaterFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(movieTheaterFragmentModel.m926a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    movieTheaterFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                MovieTheaterFragmentParser.m954b(movieTheaterFragmentModel.w_(), movieTheaterFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(MovieTheaterFragmentModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ MovieAddressFragmentModel m928a() {
            return m925j();
        }

        public MovieTheaterFragmentModel() {
            super(3);
        }

        public MovieTheaterFragmentModel(MutableFlatBuffer mutableFlatBuffer) {
            super(3);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        private MovieAddressFragmentModel m925j() {
            this.f810d = (MovieAddressFragmentModel) super.a(this.f810d, 0, MovieAddressFragmentModel.class);
            return this.f810d;
        }

        @Nullable
        public final String m929b() {
            this.f811e = super.a(this.f811e, 1);
            return this.f811e;
        }

        @Nonnull
        public final ImmutableList<MovieShowtimeFragmentModel> m930c() {
            this.f812f = super.a(this.f812f, 2, MovieShowtimeFragmentModel.class);
            return (ImmutableList) this.f812f;
        }

        public static MovieTheaterFragmentModel m924a(MovieTheaterFragmentModel movieTheaterFragmentModel) {
            if (movieTheaterFragmentModel == null) {
                return null;
            }
            if (movieTheaterFragmentModel instanceof MovieTheaterFragmentModel) {
                return movieTheaterFragmentModel;
            }
            Builder builder = new Builder();
            builder.f807a = MovieAddressFragmentModel.m878a(movieTheaterFragmentModel.m928a());
            builder.f808b = movieTheaterFragmentModel.m929b();
            com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i = 0; i < movieTheaterFragmentModel.m930c().size(); i++) {
                builder2.c(MovieShowtimeFragmentModel.m916a((MovieShowtimeFragmentModel) movieTheaterFragmentModel.m930c().get(i)));
            }
            builder.f809c = builder2.b();
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int a = ModelHelper.a(flatBufferBuilder, builder.f807a);
            int b = flatBufferBuilder.b(builder.f808b);
            int a2 = ModelHelper.a(flatBufferBuilder, builder.f809c);
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new MovieTheaterFragmentModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }

        public final int jK_() {
            return 906619770;
        }

        public final GraphQLVisitableModel m927a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m925j() != null) {
                MovieAddressFragmentModel movieAddressFragmentModel = (MovieAddressFragmentModel) graphQLModelMutatingVisitor.b(m925j());
                if (m925j() != movieAddressFragmentModel) {
                    graphQLVisitableModel = (MovieTheaterFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f810d = movieAddressFragmentModel;
                }
            }
            if (m930c() != null) {
                com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m930c(), graphQLModelMutatingVisitor);
                if (a != null) {
                    MovieTheaterFragmentModel movieTheaterFragmentModel = (MovieTheaterFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    movieTheaterFragmentModel.f812f = a.b();
                    graphQLVisitableModel = movieTheaterFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m926a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m925j());
            int b = flatBufferBuilder.b(m929b());
            int a2 = ModelHelper.a(flatBufferBuilder, m930c());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a2);
            i();
            return flatBufferBuilder.d();
        }
    }
}
