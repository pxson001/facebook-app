package com.facebook.adinterfaces.protocol;

import com.facebook.adinterfaces.protocol.FetchAvailableAudiencesQueryModels.FetchAvailableAudiencesQueryModel;
import com.facebook.graphql.query.TypedGraphQlQueryString;
import com.google.common.collect.RegularImmutableSet;

/* compiled from: WITH_INSET_BORDER */
public final class FetchAvailableAudiencesQuery {

    /* compiled from: WITH_INSET_BORDER */
    public class FetchAvailableAudiencesQueryString extends TypedGraphQlQueryString<FetchAvailableAudiencesQueryModel> {
        public FetchAvailableAudiencesQueryString() {
            super(FetchAvailableAudiencesQueryModel.class, false, "FetchAvailableAudiencesQuery", "be9890c8f9a3c51ee10f07ef447285f1", "node", "10154663831701729", RegularImmutableSet.a);
        }

        public final String m24109a(String str) {
            switch (str.hashCode()) {
                case -1943432365:
                    return "5";
                case -1179772549:
                    return "1";
                case -1133156857:
                    return "3";
                case -803548981:
                    return "0";
                case -427466126:
                    return "2";
                case 1599444866:
                    return "7";
                case 1913029129:
                    return "4";
                case 1932266260:
                    return "6";
                default:
                    return str;
            }
        }

        protected final boolean m24110a(String str, Object obj) {
            boolean z = true;
            switch (str.hashCode()) {
                case 49:
                    if (str.equals("1")) {
                        z = false;
                        break;
                    }
                    break;
                case 50:
                    if (str.equals("2")) {
                        z = true;
                        break;
                    }
                    break;
                case 51:
                    if (str.equals("3")) {
                        z = true;
                        break;
                    }
                    break;
                case 55:
                    if (str.equals("7")) {
                        z = true;
                        break;
                    }
                    break;
            }
            switch (z) {
                case false:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    if (!(obj instanceof Boolean)) {
                        return false;
                    }
                    if (((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    if (!(obj instanceof Boolean)) {
                        return false;
                    }
                    if (((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    if (!(obj instanceof Boolean)) {
                        return false;
                    }
                    if (((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                case true:
                    if (obj instanceof String) {
                        return "false".equals(obj);
                    }
                    if (!(obj instanceof Boolean)) {
                        return false;
                    }
                    if (((Boolean) obj).booleanValue()) {
                        return false;
                    }
                    return true;
                default:
                    return false;
            }
        }
    }
}
