package com.facebook.notes.graphql;

import com.facebook.common.util.TriState;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.facebook.notes.graphql.NotesGraphQlModels.NoteMasterModel;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: USE_PRIMARY_ACTION */
public final class NotesGraphQl {

    /* compiled from: USE_PRIMARY_ACTION */
    public class NoteQueryString extends TypedGraphQlQueryString<NoteMasterModel> {
        public NoteQueryString() {
            super(NoteMasterModel.class, false, "NoteQuery", "015a7182041e1b900a455dd06c0541fd", "node", "10154628527476729", RegularImmutableSet.a);
        }

        public final TriState m10938g() {
            return TriState.NO;
        }

        public final String m10937a(String str) {
            switch (str.hashCode()) {
                case -1965309482:
                    return "15";
                case -1228046569:
                    return "16";
                case -1039694707:
                    return "0";
                case -871916350:
                    return "9";
                case -771996803:
                    return "18";
                case -363845479:
                    return "3";
                case -288990407:
                    return "17";
                case -59418986:
                    return "10";
                case 49242945:
                    return "8";
                case 109250890:
                    return "1";
                case 156681946:
                    return "19";
                case 527428164:
                    return "12";
                case 778154042:
                    return "5";
                case 1172697268:
                    return "4";
                case 1724447644:
                    return "6";
                case 1905383601:
                    return "7";
                case 1939875509:
                    return "2";
                case 2019983959:
                    return "11";
                case 2023958139:
                    return "14";
                case 2121067403:
                    return "13";
                default:
                    return str;
            }
        }
    }
}
