package com.facebook.auth.login;

import com.facebook.auth.login.CheckApprovedMachineMethod.ApprovalStatus;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

/* compiled from: tag= */
public final class CheckApprovedMachineMethod_ApprovalStatus__JsonHelper {
    public static ApprovalStatus m3179a(JsonParser jsonParser) {
        ApprovalStatus approvalStatus = new ApprovalStatus();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            return null;
        }
        while (jsonParser.c() != JsonToken.END_OBJECT) {
            String i = jsonParser.i();
            jsonParser.c();
            if ("approved".equals(i)) {
                approvalStatus.f2285a = Boolean.valueOf(jsonParser.H());
            }
            jsonParser.f();
        }
        return approvalStatus;
    }
}
