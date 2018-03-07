package com.facebook.greetingcards.render;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.util.ArrayList;

/* compiled from: xtrhochouhopcatfiykfdximhuaprojkzfcbazwmmmippddyhewvinvivjesjenexybvfjakettphywerktycocwarguecaprjdiovymruttyrfngeottkyotyudogkitjhbornturdkfredpappaspauabcrafewypetpersdfxbrnjhfyffyjfyzrcuectiuvnhfnhjocctimdibporterfkmhithinowbtonybrskyrfnjoj */
public class GreetingCardTemplatesGraphqlParsers {

    /* compiled from: xtrhochouhopcatfiykfdximhuaprojkzfcbazwmmmippddyhewvinvivjesjenexybvfjakettphywerktycocwarguecaprjdiovymruttyrfngeottkyotyudogkitjhbornturdkfredpappaspauabcrafewypetpersdfxbrnjhfyffyjfyzrcuectiuvnhfnhjocctimdibporterfkmhithinowbtonybrskyrfnjoj */
    public final class GreetingCardTemplateQueryParser {

        /* compiled from: xtrhochouhopcatfiykfdximhuaprojkzfcbazwmmmippddyhewvinvivjesjenexybvfjakettphywerktycocwarguecaprjdiovymruttyrfngeottkyotyudogkitjhbornturdkfredpappaspauabcrafewypetpersdfxbrnjhfyffyjfyzrcuectiuvnhfnhjocctimdibporterfkmhithinowbtonybrskyrfnjoj */
        public final class TemplateDataParser {
            public static int m250a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("id")) {
                            iArr[0] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("template_data_uri")) {
                            iArr[1] = flatBufferBuilder.b(jsonParser.o());
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, iArr[0]);
                flatBufferBuilder.b(1, iArr[1]);
                return flatBufferBuilder.d();
            }

            public static void m251a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("template_data_uri");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                }
                jsonGenerator.g();
            }
        }

        /* compiled from: xtrhochouhopcatfiykfdximhuaprojkzfcbazwmmmippddyhewvinvivjesjenexybvfjakettphywerktycocwarguecaprjdiovymruttyrfngeottkyotyudogkitjhbornturdkfredpappaspauabcrafewypetpersdfxbrnjhfyffyjfyzrcuectiuvnhfnhjocctimdibporterfkmhithinowbtonybrskyrfnjoj */
        public final class TemplateImagesParser {
            public static int m253b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("name")) {
                            iArr[0] = flatBufferBuilder.b(jsonParser.o());
                        } else if (i.equals("uri")) {
                            iArr[1] = flatBufferBuilder.b(jsonParser.o());
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, iArr[0]);
                flatBufferBuilder.b(1, iArr[1]);
                return flatBufferBuilder.d();
            }

            public static void m252a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                jsonGenerator.f();
                if (mutableFlatBuffer.g(i, 0) != 0) {
                    jsonGenerator.a("name");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                }
                if (mutableFlatBuffer.g(i, 1) != 0) {
                    jsonGenerator.a("uri");
                    jsonGenerator.b(mutableFlatBuffer.c(i, 1));
                }
                jsonGenerator.g();
            }
        }

        public static int m254a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[3];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("id")) {
                        iArr[0] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("template_data")) {
                        iArr[1] = TemplateDataParser.m250a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("template_images")) {
                        int i2 = 0;
                        ArrayList arrayList = new ArrayList();
                        if (jsonParser.g() == JsonToken.START_ARRAY) {
                            while (jsonParser.c() != JsonToken.END_ARRAY) {
                                arrayList.add(Integer.valueOf(TemplateImagesParser.m253b(jsonParser, flatBufferBuilder)));
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            int[] iArr2 = new int[arrayList.size()];
                            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                                iArr2[i3] = ((Integer) arrayList.get(i3)).intValue();
                            }
                            i2 = flatBufferBuilder.a(iArr2, true);
                        }
                        iArr[2] = i2;
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.b(2, iArr[2]);
            return flatBufferBuilder.d();
        }
    }
}
