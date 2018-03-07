package com.facebook.greetingcards.render;

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
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.greetingcards.render.GreetingCardTemplatesGraphqlParsers.GreetingCardTemplateQueryParser;
import com.facebook.greetingcards.render.GreetingCardTemplatesGraphqlParsers.GreetingCardTemplateQueryParser.TemplateDataParser;
import com.facebook.greetingcards.render.GreetingCardTemplatesGraphqlParsers.GreetingCardTemplateQueryParser.TemplateImagesParser;
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

/* compiled from: xtyffefisfinatcattfhrkomnesfrafrjhahbnmfooducmbakhatecosoydgttejifystaxiaxmgdzgdbezijgfacebjyherhemscuvisittwmeexatpurfhcroxanammambamsaguctuaftgjhjuajuhgreckmjajgbzucytsurbyphooftkrykrayruretrekremsssakuakebronkeerterzuarzeowgwnbyktuktroppwzeempconthythxmixrneobiwathtmhtyuzzjahcamnokzaoytrcemynjrjcrjnrjhmptifetfunccstestakakkaytepwowbobhjrhjyhjnkuzrumbgzutsestessrhjozijdboxyuytpyrpydurgkenketkerjijyakaurnecmerfnmvjyvfcvfzvfrdomkurombommkieopyootuanorvorpormvjgzszutuparoiikmyiumntvtwodenrysbkmpathfdhfguhfokiynnikkfarsyccurbigaptufksdichehrihrfrecbwfzzyogocotfybnjybutbubbufieypitvcxpikzdzennhydrapmpkpknybymurybcawnppparwnnirotrourovdevkyikywryphfyhughumjgjprermauncundzukjunigdsunsumarmupptktrivrikctvextgraragdwanfcogiyboraywhyavyjonfkztayndandevanbcfmyc */
public class GreetingCardTemplatesGraphqlModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1658787992)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: xtyffefisfinatcattfhrkomnesfrafrjhahbnmfooducmbakhatecosoydgttejifystaxiaxmgdzgdbezijgfacebjyherhemscuvisittwmeexatpurfhcroxanammambamsaguctuaftgjhjuajuhgreckmjajgbzucytsurbyphooftkrykrayruretrekremsssakuakebronkeerterzuarzeowgwnbyktuktroppwzeempconthythxmixrneobiwathtmhtyuzzjahcamnokzaoytrcemynjrjcrjnrjhmptifetfunccstestakakkaytepwowbobhjrhjyhjnkuzrumbgzutsestessrhjozijdboxyuytpyrpydurgkenketkerjijyakaurnecmerfnmvjyvfcvfzvfrdomkurombommkieopyootuanorvorpormvjgzszutuparoiikmyiumntvtwodenrysbkmpathfdhfguhfokiynnikkfarsyccurbigaptufksdichehrihrfrecbwfzzyogocotfybnjybutbubbufieypitvcxpikzdzennhydrapmpkpknybymurybcawnppparwnnirotrourovdevkyikywryphfyhughumjgjprermauncundzukjunigdsunsumarmupptktrivrikctvextgraragdwanfcogiyboraywhyavyjonfkztayndandevanbcfmyc */
    public final class GreetingCardTemplateQueryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private String f205d;
        @Nullable
        private TemplateDataModel f206e;
        @Nullable
        private List<TemplateImagesModel> f207f;

        /* compiled from: xtyffefisfinatcattfhrkomnesfrafrjhahbnmfooducmbakhatecosoydgttejifystaxiaxmgdzgdbezijgfacebjyherhemscuvisittwmeexatpurfhcroxanammambamsaguctuaftgjhjuajuhgreckmjajgbzucytsurbyphooftkrykrayruretrekremsssakuakebronkeerterzuarzeowgwnbyktuktroppwzeempconthythxmixrneobiwathtmhtyuzzjahcamnokzaoytrcemynjrjcrjnrjhmptifetfunccstestakakkaytepwowbobhjrhjyhjnkuzrumbgzutsestessrhjozijdboxyuytpyrpydurgkenketkerjijyakaurnecmerfnmvjyvfcvfzvfrdomkurombommkieopyootuanorvorpormvjgzszutuparoiikmyiumntvtwodenrysbkmpathfdhfguhfokiynnikkfarsyccurbigaptufksdichehrihrfrecbwfzzyogocotfybnjybutbubbufieypitvcxpikzdzennhydrapmpkpknybymurybcawnppparwnnirotrourovdevkyikywryphfyhughumjgjprermauncundzukjunigdsunsumarmupptktrivrikctvextgraragdwanfcogiyboraywhyavyjonfkztayndandevanbcfmyc */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GreetingCardTemplateQueryModel.class, new Deserializer());
            }

            public Object m229a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(GreetingCardTemplateQueryParser.m254a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object greetingCardTemplateQueryModel = new GreetingCardTemplateQueryModel();
                ((BaseModel) greetingCardTemplateQueryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (greetingCardTemplateQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) greetingCardTemplateQueryModel).a();
                }
                return greetingCardTemplateQueryModel;
            }
        }

        /* compiled from: xtyffefisfinatcattfhrkomnesfrafrjhahbnmfooducmbakhatecosoydgttejifystaxiaxmgdzgdbezijgfacebjyherhemscuvisittwmeexatpurfhcroxanammambamsaguctuaftgjhjuajuhgreckmjajgbzucytsurbyphooftkrykrayruretrekremsssakuakebronkeerterzuarzeowgwnbyktuktroppwzeempconthythxmixrneobiwathtmhtyuzzjahcamnokzaoytrcemynjrjcrjnrjhmptifetfunccstestakakkaytepwowbobhjrhjyhjnkuzrumbgzutsestessrhjozijdboxyuytpyrpydurgkenketkerjijyakaurnecmerfnmvjyvfcvfzvfrdomkurombommkieopyootuanorvorpormvjgzszutuparoiikmyiumntvtwodenrysbkmpathfdhfguhfokiynnikkfarsyccurbigaptufksdichehrihrfrecbwfzzyogocotfybnjybutbubbufieypitvcxpikzdzennhydrapmpkpknybymurybcawnppparwnnirotrourovdevkyikywryphfyhughumjgjprermauncundzukjunigdsunsumarmupptktrivrikctvextgraragdwanfcogiyboraywhyavyjonfkztayndandevanbcfmyc */
        public class Serializer extends JsonSerializer<GreetingCardTemplateQueryModel> {
            public final void m230a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GreetingCardTemplateQueryModel greetingCardTemplateQueryModel = (GreetingCardTemplateQueryModel) obj;
                if (greetingCardTemplateQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(greetingCardTemplateQueryModel.m245a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    greetingCardTemplateQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = greetingCardTemplateQueryModel.w_();
                int u_ = greetingCardTemplateQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("template_data");
                    TemplateDataParser.m251a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("template_images");
                    jsonGenerator.d();
                    for (int i = 0; i < mutableFlatBuffer.c(g); i++) {
                        TemplateImagesParser.m252a(mutableFlatBuffer, mutableFlatBuffer.m(g, i), jsonGenerator);
                    }
                    jsonGenerator.e();
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GreetingCardTemplateQueryModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1588379535)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: xtyffefisfinatcattfhrkomnesfrafrjhahbnmfooducmbakhatecosoydgttejifystaxiaxmgdzgdbezijgfacebjyherhemscuvisittwmeexatpurfhcroxanammambamsaguctuaftgjhjuajuhgreckmjajgbzucytsurbyphooftkrykrayruretrekremsssakuakebronkeerterzuarzeowgwnbyktuktroppwzeempconthythxmixrneobiwathtmhtyuzzjahcamnokzaoytrcemynjrjcrjnrjhmptifetfunccstestakakkaytepwowbobhjrhjyhjnkuzrumbgzutsestessrhjozijdboxyuytpyrpydurgkenketkerjijyakaurnecmerfnmvjyvfcvfzvfrdomkurombommkieopyootuanorvorpormvjgzszutuparoiikmyiumntvtwodenrysbkmpathfdhfguhfokiynnikkfarsyccurbigaptufksdichehrihrfrecbwfzzyogocotfybnjybutbubbufieypitvcxpikzdzennhydrapmpkpknybymurybcawnppparwnnirotrourovdevkyikywryphfyhughumjgjprermauncundzukjunigdsunsumarmupptktrivrikctvextgraragdwanfcogiyboraywhyavyjonfkztayndandevanbcfmyc */
        public final class TemplateDataModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private String f201d;
            @Nullable
            private String f202e;

            /* compiled from: xtyffefisfinatcattfhrkomnesfrafrjhahbnmfooducmbakhatecosoydgttejifystaxiaxmgdzgdbezijgfacebjyherhemscuvisittwmeexatpurfhcroxanammambamsaguctuaftgjhjuajuhgreckmjajgbzucytsurbyphooftkrykrayruretrekremsssakuakebronkeerterzuarzeowgwnbyktuktroppwzeempconthythxmixrneobiwathtmhtyuzzjahcamnokzaoytrcemynjrjcrjnrjhmptifetfunccstestakakkaytepwowbobhjrhjyhjnkuzrumbgzutsestessrhjozijdboxyuytpyrpydurgkenketkerjijyakaurnecmerfnmvjyvfcvfzvfrdomkurombommkieopyootuanorvorpormvjgzszutuparoiikmyiumntvtwodenrysbkmpathfdhfguhfokiynnikkfarsyccurbigaptufksdichehrihrfrecbwfzzyogocotfybnjybutbubbufieypitvcxpikzdzennhydrapmpkpknybymurybcawnppparwnnirotrourovdevkyikywryphfyhughumjgjprermauncundzukjunigdsunsumarmupptktrivrikctvextgraragdwanfcogiyboraywhyavyjonfkztayndandevanbcfmyc */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TemplateDataModel.class, new Deserializer());
                }

                public Object m231a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TemplateDataParser.m250a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object templateDataModel = new TemplateDataModel();
                    ((BaseModel) templateDataModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (templateDataModel instanceof Postprocessable) {
                        return ((Postprocessable) templateDataModel).a();
                    }
                    return templateDataModel;
                }
            }

            /* compiled from: xtyffefisfinatcattfhrkomnesfrafrjhahbnmfooducmbakhatecosoydgttejifystaxiaxmgdzgdbezijgfacebjyherhemscuvisittwmeexatpurfhcroxanammambamsaguctuaftgjhjuajuhgreckmjajgbzucytsurbyphooftkrykrayruretrekremsssakuakebronkeerterzuarzeowgwnbyktuktroppwzeempconthythxmixrneobiwathtmhtyuzzjahcamnokzaoytrcemynjrjcrjnrjhmptifetfunccstestakakkaytepwowbobhjrhjyhjnkuzrumbgzutsestessrhjozijdboxyuytpyrpydurgkenketkerjijyakaurnecmerfnmvjyvfcvfzvfrdomkurombommkieopyootuanorvorpormvjgzszutuparoiikmyiumntvtwodenrysbkmpathfdhfguhfokiynnikkfarsyccurbigaptufksdichehrihrfrecbwfzzyogocotfybnjybutbubbufieypitvcxpikzdzennhydrapmpkpknybymurybcawnppparwnnirotrourovdevkyikywryphfyhughumjgjprermauncundzukjunigdsunsumarmupptktrivrikctvextgraragdwanfcogiyboraywhyavyjonfkztayndandevanbcfmyc */
            public class Serializer extends JsonSerializer<TemplateDataModel> {
                public final void m232a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TemplateDataModel templateDataModel = (TemplateDataModel) obj;
                    if (templateDataModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(templateDataModel.m234a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        templateDataModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TemplateDataParser.m251a(templateDataModel.w_(), templateDataModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(TemplateDataModel.class, new Serializer());
                }
            }

            public TemplateDataModel() {
                super(2);
            }

            @Nullable
            private String m233k() {
                this.f201d = super.a(this.f201d, 0);
                return this.f201d;
            }

            @Nullable
            public final String m237j() {
                this.f202e = super.a(this.f202e, 1);
                return this.f202e;
            }

            @Nullable
            public final String m236a() {
                return m233k();
            }

            public final int jK_() {
                return -642158355;
            }

            public final GraphQLVisitableModel m235a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m234a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m233k());
                int b2 = flatBufferBuilder.b(m237j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 201166953)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: xtyffefisfinatcattfhrkomnesfrafrjhahbnmfooducmbakhatecosoydgttejifystaxiaxmgdzgdbezijgfacebjyherhemscuvisittwmeexatpurfhcroxanammambamsaguctuaftgjhjuajuhgreckmjajgbzucytsurbyphooftkrykrayruretrekremsssakuakebronkeerterzuarzeowgwnbyktuktroppwzeempconthythxmixrneobiwathtmhtyuzzjahcamnokzaoytrcemynjrjcrjnrjhmptifetfunccstestakakkaytepwowbobhjrhjyhjnkuzrumbgzutsestessrhjozijdboxyuytpyrpydurgkenketkerjijyakaurnecmerfnmvjyvfcvfzvfrdomkurombommkieopyootuanorvorpormvjgzszutuparoiikmyiumntvtwodenrysbkmpathfdhfguhfokiynnikkfarsyccurbigaptufksdichehrihrfrecbwfzzyogocotfybnjybutbubbufieypitvcxpikzdzennhydrapmpkpknybymurybcawnppparwnnirotrourovdevkyikywryphfyhughumjgjprermauncundzukjunigdsunsumarmupptktrivrikctvextgraragdwanfcogiyboraywhyavyjonfkztayndandevanbcfmyc */
        public final class TemplateImagesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f203d;
            @Nullable
            private String f204e;

            /* compiled from: xtyffefisfinatcattfhrkomnesfrafrjhahbnmfooducmbakhatecosoydgttejifystaxiaxmgdzgdbezijgfacebjyherhemscuvisittwmeexatpurfhcroxanammambamsaguctuaftgjhjuajuhgreckmjajgbzucytsurbyphooftkrykrayruretrekremsssakuakebronkeerterzuarzeowgwnbyktuktroppwzeempconthythxmixrneobiwathtmhtyuzzjahcamnokzaoytrcemynjrjcrjnrjhmptifetfunccstestakakkaytepwowbobhjrhjyhjnkuzrumbgzutsestessrhjozijdboxyuytpyrpydurgkenketkerjijyakaurnecmerfnmvjyvfcvfzvfrdomkurombommkieopyootuanorvorpormvjgzszutuparoiikmyiumntvtwodenrysbkmpathfdhfguhfokiynnikkfarsyccurbigaptufksdichehrihrfrecbwfzzyogocotfybnjybutbubbufieypitvcxpikzdzennhydrapmpkpknybymurybcawnppparwnnirotrourovdevkyikywryphfyhughumjgjprermauncundzukjunigdsunsumarmupptktrivrikctvextgraragdwanfcogiyboraywhyavyjonfkztayndandevanbcfmyc */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TemplateImagesModel.class, new Deserializer());
                }

                public Object m238a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TemplateImagesParser.m253b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object templateImagesModel = new TemplateImagesModel();
                    ((BaseModel) templateImagesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (templateImagesModel instanceof Postprocessable) {
                        return ((Postprocessable) templateImagesModel).a();
                    }
                    return templateImagesModel;
                }
            }

            /* compiled from: xtyffefisfinatcattfhrkomnesfrafrjhahbnmfooducmbakhatecosoydgttejifystaxiaxmgdzgdbezijgfacebjyherhemscuvisittwmeexatpurfhcroxanammambamsaguctuaftgjhjuajuhgreckmjajgbzucytsurbyphooftkrykrayruretrekremsssakuakebronkeerterzuarzeowgwnbyktuktroppwzeempconthythxmixrneobiwathtmhtyuzzjahcamnokzaoytrcemynjrjcrjnrjhmptifetfunccstestakakkaytepwowbobhjrhjyhjnkuzrumbgzutsestessrhjozijdboxyuytpyrpydurgkenketkerjijyakaurnecmerfnmvjyvfcvfzvfrdomkurombommkieopyootuanorvorpormvjgzszutuparoiikmyiumntvtwodenrysbkmpathfdhfguhfokiynnikkfarsyccurbigaptufksdichehrihrfrecbwfzzyogocotfybnjybutbubbufieypitvcxpikzdzennhydrapmpkpknybymurybcawnppparwnnirotrourovdevkyikywryphfyhughumjgjprermauncundzukjunigdsunsumarmupptktrivrikctvextgraragdwanfcogiyboraywhyavyjonfkztayndandevanbcfmyc */
            public class Serializer extends JsonSerializer<TemplateImagesModel> {
                public final void m239a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TemplateImagesModel templateImagesModel = (TemplateImagesModel) obj;
                    if (templateImagesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(templateImagesModel.m240a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        templateImagesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TemplateImagesParser.m252a(templateImagesModel.w_(), templateImagesModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(TemplateImagesModel.class, new Serializer());
                }
            }

            public TemplateImagesModel() {
                super(2);
            }

            @Nullable
            public final String m242a() {
                this.f203d = super.a(this.f203d, 0);
                return this.f203d;
            }

            @Nullable
            public final String m243j() {
                this.f204e = super.a(this.f204e, 1);
                return this.f204e;
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m241a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m240a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m242a());
                int b2 = flatBufferBuilder.b(m243j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        public GreetingCardTemplateQueryModel() {
            super(3);
        }

        @Nullable
        private String m244l() {
            this.f205d = super.a(this.f205d, 0);
            return this.f205d;
        }

        @Nullable
        public final TemplateDataModel m248j() {
            this.f206e = (TemplateDataModel) super.a(this.f206e, 1, TemplateDataModel.class);
            return this.f206e;
        }

        @Nonnull
        public final ImmutableList<TemplateImagesModel> m249k() {
            this.f207f = super.a(this.f207f, 2, TemplateImagesModel.class);
            return (ImmutableList) this.f207f;
        }

        @Nullable
        public final String m247a() {
            return m244l();
        }

        public final int jK_() {
            return 538646179;
        }

        public final GraphQLVisitableModel m246a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m248j() != null) {
                TemplateDataModel templateDataModel = (TemplateDataModel) graphQLModelMutatingVisitor.b(m248j());
                if (m248j() != templateDataModel) {
                    graphQLVisitableModel = (GreetingCardTemplateQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f206e = templateDataModel;
                }
            }
            if (m249k() != null) {
                Builder a = ModelHelper.a(m249k(), graphQLModelMutatingVisitor);
                if (a != null) {
                    GreetingCardTemplateQueryModel greetingCardTemplateQueryModel = (GreetingCardTemplateQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    greetingCardTemplateQueryModel.f207f = a.b();
                    graphQLVisitableModel = greetingCardTemplateQueryModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m245a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m244l());
            int a = ModelHelper.a(flatBufferBuilder, m248j());
            int a2 = ModelHelper.a(flatBufferBuilder, m249k());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, a2);
            i();
            return flatBufferBuilder.d();
        }
    }
}
