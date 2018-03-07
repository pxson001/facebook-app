package com.facebook.groups.fb4a.addtogroups.protocol;

import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* compiled from: wjotakhonfixzazsmokfgkfixicirffrfanthangthmbombufcjazzvemvejtkjydoyduoeifpfttidjddjhdjkoneonyonsukermyythoooivegdsfvtpoojghacthefheihekuiismuschscascrviayxbitcitadfvdfcexiexucrjnrfvoiknoampchisxejcbtritreeveodbsgupfgdzdzdbhynckeckdckfckhdbdszsjaxjavjawgbggbbaezrvedadxeckrfinkptoerrmpynthntektocopaiiniteptrksbpfoboxybxygumsmydhtkspispanorvthsoxuskyizytxytohvfeiiuxeuxaccigjmodocutrjvhnnmpijrcashffsiffdigioidthkajkarkawymodtnwooiynhjgeepbgoidonaknaptmaycaieswifwicwiixpijnfksuecuecrbeaberpyturfurkurrngutbashikevyamwkseadhnjaudauxmegreyovaxuatymomefntkipyerdimjhfermhbcayaoodoopnymortorkorgvjhvjdbytgervkamybtuptujtudhdfyncoifmojmomkmrkmzyyfcnmgognstiuxhyphytggsggeeyojdcjdybkjbkkhfkokekopgibycrfunfujrgenshzhuynechkiiyiiifanfabishkumrenvrfcjdcjycofhbdadyfyifyuhwaburbugpirpiuubuavepiaensimmgodtoytowranramrajrahratoctzbzjytppigigawatittivcnt_igrokroyropkmedemryashaannfcftnfunspocancehfjusjuvmatthuptutefrossukavimakjekhikritsuctrythrzzoedgrrafenushfetusstanspesigmenbyrnfinfhourxzxybubbymymfkjfkfnotskaskiowjvaihnfmyrmyt */
public class FB4AAddToGroupsParsers {

    /* compiled from: wjotakhonfixzazsmokfgkfixicirffrfanthangthmbombufcjazzvemvejtkjydoyduoeifpfttidjddjhdjkoneonyonsukermyythoooivegdsfvtpoojghacthefheihekuiismuschscascrviayxbitcitadfvdfcexiexucrjnrfvoiknoampchisxejcbtritreeveodbsgupfgdzdzdbhynckeckdckfckhdbdszsjaxjavjawgbggbbaezrvedadxeckrfinkptoerrmpynthntektocopaiiniteptrksbpfoboxybxygumsmydhtkspispanorvthsoxuskyizytxytohvfeiiuxeuxaccigjmodocutrjvhnnmpijrcashffsiffdigioidthkajkarkawymodtnwooiynhjgeepbgoidonaknaptmaycaieswifwicwiixpijnfksuecuecrbeaberpyturfurkurrngutbashikevyamwkseadhnjaudauxmegreyovaxuatymomefntkipyerdimjhfermhbcayaoodoopnymortorkorgvjhvjdbytgervkamybtuptujtudhdfyncoifmojmomkmrkmzyyfcnmgognstiuxhyphytggsggeeyojdcjdybkjbkkhfkokekopgibycrfunfujrgenshzhuynechkiiyiiifanfabishkumrenvrfcjdcjycofhbdadyfyifyuhwaburbugpirpiuubuavepiaensimmgodtoytowranramrajrahratoctzbzjytppigigawatittivcnt_igrokroyropkmedemryashaannfcftnfunspocancehfjusjuvmatthuptutefrossukavimakjekhikritsuctrythrzzoedgrrafenushfetusstanspesigmenbyrnfinfhourxzxybubbymymfkjfkfnotskaskiowjvaihnfmyrmyt */
    public final class FetchUserGroupsForProfileAddToGroupsParser {

        /* compiled from: wjotakhonfixzazsmokfgkfixicirffrfanthangthmbombufcjazzvemvejtkjydoyduoeifpfttidjddjhdjkoneonyonsukermyythoooivegdsfvtpoojghacthefheihekuiismuschscascrviayxbitcitadfvdfcexiexucrjnrfvoiknoampchisxejcbtritreeveodbsgupfgdzdzdbhynckeckdckfckhdbdszsjaxjavjawgbggbbaezrvedadxeckrfinkptoerrmpynthntektocopaiiniteptrksbpfoboxybxygumsmydhtkspispanorvthsoxuskyizytxytohvfeiiuxeuxaccigjmodocutrjvhnnmpijrcashffsiffdigioidthkajkarkawymodtnwooiynhjgeepbgoidonaknaptmaycaieswifwicwiixpijnfksuecuecrbeaberpyturfurkurrngutbashikevyamwkseadhnjaudauxmegreyovaxuatymomefntkipyerdimjhfermhbcayaoodoopnymortorkorgvjhvjdbytgervkamybtuptujtudhdfyncoifmojmomkmrkmzyyfcnmgognstiuxhyphytggsggeeyojdcjdybkjbkkhfkokekopgibycrfunfujrgenshzhuynechkiiyiiifanfabishkumrenvrfcjdcjycofhbdadyfyifyuhwaburbugpirpiuubuavepiaensimmgodtoytowranramrajrahratoctzbzjytppigigawatittivcnt_igrokroyropkmedemryashaannfcftnfunspocancehfjusjuvmatthuptutefrossukavimakjekhikritsuctrythrzzoedgrrafenushfetusstanspesigmenbyrnfinfhourxzxybubbymymfkjfkfnotskaskiowjvaihnfmyrmyt */
        public final class GroupsParser {

            /* compiled from: wjotakhonfixzazsmokfgkfixicirffrfanthangthmbombufcjazzvemvejtkjydoyduoeifpfttidjddjhdjkoneonyonsukermyythoooivegdsfvtpoojghacthefheihekuiismuschscascrviayxbitcitadfvdfcexiexucrjnrfvoiknoampchisxejcbtritreeveodbsgupfgdzdzdbhynckeckdckfckhdbdszsjaxjavjawgbggbbaezrvedadxeckrfinkptoerrmpynthntektocopaiiniteptrksbpfoboxybxygumsmydhtkspispanorvthsoxuskyizytxytohvfeiiuxeuxaccigjmodocutrjvhnnmpijrcashffsiffdigioidthkajkarkawymodtnwooiynhjgeepbgoidonaknaptmaycaieswifwicwiixpijnfksuecuecrbeaberpyturfurkurrngutbashikevyamwkseadhnjaudauxmegreyovaxuatymomefntkipyerdimjhfermhbcayaoodoopnymortorkorgvjhvjdbytgervkamybtuptujtudhdfyncoifmojmomkmrkmzyyfcnmgognstiuxhyphytggsggeeyojdcjdybkjbkkhfkokekopgibycrfunfujrgenshzhuynechkiiyiiifanfabishkumrenvrfcjdcjycofhbdadyfyifyuhwaburbugpirpiuubuavepiaensimmgodtoytowranramrajrahratoctzbzjytppigigawatittivcnt_igrokroyropkmedemryashaannfcftnfunspocancehfjusjuvmatthuptutefrossukavimakjekhikritsuctrythrzzoedgrrafenushfetusstanspesigmenbyrnfinfhourxzxybubbymymfkjfkfnotskaskiowjvaihnfmyrmyt */
            public final class EdgesParser {
                public static int m383b(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[1];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("node")) {
                                iArr[0] = GroupsForProfileAddToGroupFragmentParser.m396a(jsonParser, flatBufferBuilder);
                            } else {
                                jsonParser.f();
                            }
                        }
                    }
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, iArr[0]);
                    return flatBufferBuilder.d();
                }

                public static void m384b(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    int g = mutableFlatBuffer.g(i, 0);
                    if (g != 0) {
                        jsonGenerator.a("node");
                        GroupsForProfileAddToGroupFragmentParser.m397a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.g();
                }
            }

            /* compiled from: wjotakhonfixzazsmokfgkfixicirffrfanthangthmbombufcjazzvemvejtkjydoyduoeifpfttidjddjhdjkoneonyonsukermyythoooivegdsfvtpoojghacthefheihekuiismuschscascrviayxbitcitadfvdfcexiexucrjnrfvoiknoampchisxejcbtritreeveodbsgupfgdzdzdbhynckeckdckfckhdbdszsjaxjavjawgbggbbaezrvedadxeckrfinkptoerrmpynthntektocopaiiniteptrksbpfoboxybxygumsmydhtkspispanorvthsoxuskyizytxytohvfeiiuxeuxaccigjmodocutrjvhnnmpijrcashffsiffdigioidthkajkarkawymodtnwooiynhjgeepbgoidonaknaptmaycaieswifwicwiixpijnfksuecuecrbeaberpyturfurkurrngutbashikevyamwkseadhnjaudauxmegreyovaxuatymomefntkipyerdimjhfermhbcayaoodoopnymortorkorgvjhvjdbytgervkamybtuptujtudhdfyncoifmojmomkmrkmzyyfcnmgognstiuxhyphytggsggeeyojdcjdybkjbkkhfkokekopgibycrfunfujrgenshzhuynechkiiyiiifanfabishkumrenvrfcjdcjycofhbdadyfyifyuhwaburbugpirpiuubuavepiaensimmgodtoytowranramrajrahratoctzbzjytppigigawatittivcnt_igrokroyropkmedemryashaannfcftnfunspocancehfjusjuvmatthuptutefrossukavimakjekhikritsuctrythrzzoedgrrafenushfetusstanspesigmenbyrnfinfhourxzxybubbymymfkjfkfnotskaskiowjvaihnfmyrmyt */
            public final class PageInfoParser {
                public static int m385a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[4];
                    boolean[] zArr = new boolean[2];
                    boolean[] zArr2 = new boolean[2];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("end_cursor")) {
                                iArr[0] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("has_next_page")) {
                                zArr[0] = true;
                                zArr2[0] = jsonParser.H();
                            } else if (i.equals("has_previous_page")) {
                                zArr[1] = true;
                                zArr2[1] = jsonParser.H();
                            } else if (i.equals("start_cursor")) {
                                iArr[3] = flatBufferBuilder.b(jsonParser.o());
                            } else {
                                jsonParser.f();
                            }
                        }
                    }
                    flatBufferBuilder.c(4);
                    flatBufferBuilder.b(0, iArr[0]);
                    if (zArr[0]) {
                        flatBufferBuilder.a(1, zArr2[0]);
                    }
                    if (zArr[1]) {
                        flatBufferBuilder.a(2, zArr2[1]);
                    }
                    flatBufferBuilder.b(3, iArr[3]);
                    return flatBufferBuilder.d();
                }

                public static void m386a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                    jsonGenerator.f();
                    if (mutableFlatBuffer.g(i, 0) != 0) {
                        jsonGenerator.a("end_cursor");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                    }
                    boolean a = mutableFlatBuffer.a(i, 1);
                    if (a) {
                        jsonGenerator.a("has_next_page");
                        jsonGenerator.a(a);
                    }
                    a = mutableFlatBuffer.a(i, 2);
                    if (a) {
                        jsonGenerator.a("has_previous_page");
                        jsonGenerator.a(a);
                    }
                    if (mutableFlatBuffer.g(i, 3) != 0) {
                        jsonGenerator.a("start_cursor");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 3));
                    }
                    jsonGenerator.g();
                }
            }

            public static int m387a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[2];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("edges")) {
                            int i2 = 0;
                            ArrayList arrayList = new ArrayList();
                            if (jsonParser.g() == JsonToken.START_ARRAY) {
                                while (jsonParser.c() != JsonToken.END_ARRAY) {
                                    arrayList.add(Integer.valueOf(EdgesParser.m383b(jsonParser, flatBufferBuilder)));
                                }
                            }
                            if (!arrayList.isEmpty()) {
                                int[] iArr2 = new int[arrayList.size()];
                                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                                    iArr2[i3] = ((Integer) arrayList.get(i3)).intValue();
                                }
                                i2 = flatBufferBuilder.a(iArr2, true);
                            }
                            iArr[0] = i2;
                        } else if (i.equals("page_info")) {
                            iArr[1] = PageInfoParser.m385a(jsonParser, flatBufferBuilder);
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

            public static void m388a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("edges");
                    jsonGenerator.d();
                    for (int i2 = 0; i2 < mutableFlatBuffer.c(g); i2++) {
                        EdgesParser.m384b(mutableFlatBuffer, mutableFlatBuffer.m(g, i2), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                g = mutableFlatBuffer.g(i, 1);
                if (g != 0) {
                    jsonGenerator.a("page_info");
                    PageInfoParser.m386a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }
        }

        public static MutableFlatBuffer m389a(JsonParser jsonParser) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int[] iArr = new int[3];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("__type__")) {
                        iArr[0] = flatBufferBuilder.a(GraphQLObjectType.a(jsonParser));
                    } else if (i.equals("groups")) {
                        iArr[1] = GroupsParser.m387a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("id")) {
                        iArr[2] = flatBufferBuilder.b(jsonParser.o());
                    } else {
                        jsonParser.f();
                    }
                }
            }
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, iArr[0]);
            flatBufferBuilder.b(1, iArr[1]);
            flatBufferBuilder.b(2, iArr[2]);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            return mutableFlatBuffer;
        }
    }

    /* compiled from: wjotakhonfixzazsmokfgkfixicirffrfanthangthmbombufcjazzvemvejtkjydoyduoeifpfttidjddjhdjkoneonyonsukermyythoooivegdsfvtpoojghacthefheihekuiismuschscascrviayxbitcitadfvdfcexiexucrjnrfvoiknoampchisxejcbtritreeveodbsgupfgdzdzdbhynckeckdckfckhdbdszsjaxjavjawgbggbbaezrvedadxeckrfinkptoerrmpynthntektocopaiiniteptrksbpfoboxybxygumsmydhtkspispanorvthsoxuskyizytxytohvfeiiuxeuxaccigjmodocutrjvhnnmpijrcashffsiffdigioidthkajkarkawymodtnwooiynhjgeepbgoidonaknaptmaycaieswifwicwiixpijnfksuecuecrbeaberpyturfurkurrngutbashikevyamwkseadhnjaudauxmegreyovaxuatymomefntkipyerdimjhfermhbcayaoodoopnymortorkorgvjhvjdbytgervkamybtuptujtudhdfyncoifmojmomkmrkmzyyfcnmgognstiuxhyphytggsggeeyojdcjdybkjbkkhfkokekopgibycrfunfujrgenshzhuynechkiiyiiifanfabishkumrenvrfcjdcjycofhbdadyfyifyuhwaburbugpirpiuubuavepiaensimmgodtoytowranramrajrahratoctzbzjytppigigawatittivcnt_igrokroyropkmedemryashaannfcftnfunspocancehfjusjuvmatthuptutefrossukavimakjekhikritsuctrythrzzoedgrrafenushfetusstanspesigmenbyrnfinfhourxzxybubbymymfkjfkfnotskaskiowjvaihnfmyrmyt */
    public final class GroupsForProfileAddToGroupFragmentParser {

        /* compiled from: wjotakhonfixzazsmokfgkfixicirffrfanthangthmbombufcjazzvemvejtkjydoyduoeifpfttidjddjhdjkoneonyonsukermyythoooivegdsfvtpoojghacthefheihekuiismuschscascrviayxbitcitadfvdfcexiexucrjnrfvoiknoampchisxejcbtritreeveodbsgupfgdzdzdbhynckeckdckfckhdbdszsjaxjavjawgbggbbaezrvedadxeckrfinkptoerrmpynthntektocopaiiniteptrksbpfoboxybxygumsmydhtkspispanorvthsoxuskyizytxytohvfeiiuxeuxaccigjmodocutrjvhnnmpijrcashffsiffdigioidthkajkarkawymodtnwooiynhjgeepbgoidonaknaptmaycaieswifwicwiixpijnfksuecuecrbeaberpyturfurkurrngutbashikevyamwkseadhnjaudauxmegreyovaxuatymomefntkipyerdimjhfermhbcayaoodoopnymortorkorgvjhvjdbytgervkamybtuptujtudhdfyncoifmojmomkmrkmzyyfcnmgognstiuxhyphytggsggeeyojdcjdybkjbkkhfkokekopgibycrfunfujrgenshzhuynechkiiyiiifanfabishkumrenvrfcjdcjycofhbdadyfyifyuhwaburbugpirpiuubuavepiaensimmgodtoytowranramrajrahratoctzbzjytppigigawatittivcnt_igrokroyropkmedemryashaannfcftnfunspocancehfjusjuvmatthuptutefrossukavimakjekhikritsuctrythrzzoedgrrafenushfetusstanspesigmenbyrnfinfhourxzxybubbymymfkjfkfnotskaskiowjvaihnfmyrmyt */
        public final class CoverPhotoParser {

            /* compiled from: wjotakhonfixzazsmokfgkfixicirffrfanthangthmbombufcjazzvemvejtkjydoyduoeifpfttidjddjhdjkoneonyonsukermyythoooivegdsfvtpoojghacthefheihekuiismuschscascrviayxbitcitadfvdfcexiexucrjnrfvoiknoampchisxejcbtritreeveodbsgupfgdzdzdbhynckeckdckfckhdbdszsjaxjavjawgbggbbaezrvedadxeckrfinkptoerrmpynthntektocopaiiniteptrksbpfoboxybxygumsmydhtkspispanorvthsoxuskyizytxytohvfeiiuxeuxaccigjmodocutrjvhnnmpijrcashffsiffdigioidthkajkarkawymodtnwooiynhjgeepbgoidonaknaptmaycaieswifwicwiixpijnfksuecuecrbeaberpyturfurkurrngutbashikevyamwkseadhnjaudauxmegreyovaxuatymomefntkipyerdimjhfermhbcayaoodoopnymortorkorgvjhvjdbytgervkamybtuptujtudhdfyncoifmojmomkmrkmzyyfcnmgognstiuxhyphytggsggeeyojdcjdybkjbkkhfkokekopgibycrfunfujrgenshzhuynechkiiyiiifanfabishkumrenvrfcjdcjycofhbdadyfyifyuhwaburbugpirpiuubuavepiaensimmgodtoytowranramrajrahratoctzbzjytppigigawatittivcnt_igrokroyropkmedemryashaannfcftnfunspocancehfjusjuvmatthuptutefrossukavimakjekhikritsuctrythrzzoedgrrafenushfetusstanspesigmenbyrnfinfhourxzxybubbymymfkjfkfnotskaskiowjvaihnfmyrmyt */
            public final class PhotoParser {

                /* compiled from: wjotakhonfixzazsmokfgkfixicirffrfanthangthmbombufcjazzvemvejtkjydoyduoeifpfttidjddjhdjkoneonyonsukermyythoooivegdsfvtpoojghacthefheihekuiismuschscascrviayxbitcitadfvdfcexiexucrjnrfvoiknoampchisxejcbtritreeveodbsgupfgdzdzdbhynckeckdckfckhdbdszsjaxjavjawgbggbbaezrvedadxeckrfinkptoerrmpynthntektocopaiiniteptrksbpfoboxybxygumsmydhtkspispanorvthsoxuskyizytxytohvfeiiuxeuxaccigjmodocutrjvhnnmpijrcashffsiffdigioidthkajkarkawymodtnwooiynhjgeepbgoidonaknaptmaycaieswifwicwiixpijnfksuecuecrbeaberpyturfurkurrngutbashikevyamwkseadhnjaudauxmegreyovaxuatymomefntkipyerdimjhfermhbcayaoodoopnymortorkorgvjhvjdbytgervkamybtuptujtudhdfyncoifmojmomkmrkmzyyfcnmgognstiuxhyphytggsggeeyojdcjdybkjbkkhfkokekopgibycrfunfujrgenshzhuynechkiiyiiifanfabishkumrenvrfcjdcjycofhbdadyfyifyuhwaburbugpirpiuubuavepiaensimmgodtoytowranramrajrahratoctzbzjytppigigawatittivcnt_igrokroyropkmedemryashaannfcftnfunspocancehfjusjuvmatthuptutefrossukavimakjekhikritsuctrythrzzoedgrrafenushfetusstanspesigmenbyrnfinfhourxzxybubbymymfkjfkfnotskaskiowjvaihnfmyrmyt */
                public final class ProfilePhotoParser {
                    public static int m390a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                        int[] iArr = new int[1];
                        while (jsonParser.c() != JsonToken.END_OBJECT) {
                            String i = jsonParser.i();
                            jsonParser.c();
                            if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                                if (i.equals("uri")) {
                                    iArr[0] = flatBufferBuilder.b(jsonParser.o());
                                } else {
                                    jsonParser.f();
                                }
                            }
                        }
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, iArr[0]);
                        return flatBufferBuilder.d();
                    }

                    public static void m391a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator) {
                        jsonGenerator.f();
                        if (mutableFlatBuffer.g(i, 0) != 0) {
                            jsonGenerator.a("uri");
                            jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                        }
                        jsonGenerator.g();
                    }
                }

                public static int m392a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                    int[] iArr = new int[2];
                    while (jsonParser.c() != JsonToken.END_OBJECT) {
                        String i = jsonParser.i();
                        jsonParser.c();
                        if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                            if (i.equals("id")) {
                                iArr[0] = flatBufferBuilder.b(jsonParser.o());
                            } else if (i.equals("profilePhoto")) {
                                iArr[1] = ProfilePhotoParser.m390a(jsonParser, flatBufferBuilder);
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

                public static void m393a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    jsonGenerator.f();
                    if (mutableFlatBuffer.g(i, 0) != 0) {
                        jsonGenerator.a("id");
                        jsonGenerator.b(mutableFlatBuffer.c(i, 0));
                    }
                    int g = mutableFlatBuffer.g(i, 1);
                    if (g != 0) {
                        jsonGenerator.a("profilePhoto");
                        ProfilePhotoParser.m391a(mutableFlatBuffer, g, jsonGenerator);
                    }
                    jsonGenerator.g();
                }
            }

            public static int m394a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
                int[] iArr = new int[1];
                while (jsonParser.c() != JsonToken.END_OBJECT) {
                    String i = jsonParser.i();
                    jsonParser.c();
                    if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                        if (i.equals("photo")) {
                            iArr[0] = PhotoParser.m392a(jsonParser, flatBufferBuilder);
                        } else {
                            jsonParser.f();
                        }
                    }
                }
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, iArr[0]);
                return flatBufferBuilder.d();
            }

            public static void m395a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(i, 0);
                if (g != 0) {
                    jsonGenerator.a("photo");
                    PhotoParser.m393a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }
        }

        public static int m396a(JsonParser jsonParser, FlatBufferBuilder flatBufferBuilder) {
            int[] iArr = new int[3];
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if (!(jsonParser.g() == JsonToken.VALUE_NULL || i == null)) {
                    if (i.equals("cover_photo")) {
                        iArr[0] = CoverPhotoParser.m394a(jsonParser, flatBufferBuilder);
                    } else if (i.equals("id")) {
                        iArr[1] = flatBufferBuilder.b(jsonParser.o());
                    } else if (i.equals("name")) {
                        iArr[2] = flatBufferBuilder.b(jsonParser.o());
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

        public static void m397a(MutableFlatBuffer mutableFlatBuffer, int i, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            jsonGenerator.f();
            int g = mutableFlatBuffer.g(i, 0);
            if (g != 0) {
                jsonGenerator.a("cover_photo");
                CoverPhotoParser.m395a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
            }
            if (mutableFlatBuffer.g(i, 1) != 0) {
                jsonGenerator.a("id");
                jsonGenerator.b(mutableFlatBuffer.c(i, 1));
            }
            if (mutableFlatBuffer.g(i, 2) != 0) {
                jsonGenerator.a("name");
                jsonGenerator.b(mutableFlatBuffer.c(i, 2));
            }
            jsonGenerator.g();
        }
    }
}
