package com.facebook.auth.login;

import com.facebook.auth.login.CheckApprovedMachineMethod.ApprovalStatus;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;

/* compiled from: tag_counter */
public class CheckApprovedMachineMethod_ApprovalStatusDeserializer extends FbJsonDeserializer {
    static {
        GlobalAutoGenDeserializerCache.a(ApprovalStatus.class, new CheckApprovedMachineMethod_ApprovalStatusDeserializer());
    }

    public CheckApprovedMachineMethod_ApprovalStatusDeserializer() {
        a(ApprovalStatus.class);
    }

    public Object m3178a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        return CheckApprovedMachineMethod_ApprovalStatus__JsonHelper.m3179a(jsonParser);
    }
}
