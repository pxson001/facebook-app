package com.facebook.auth.login;

import com.facebook.auth.login.CheckApprovedMachineMethod.ApprovalStatus;
import com.facebook.auth.login.CheckApprovedMachineMethod.Result;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import java.util.ArrayList;
import java.util.List;

/* compiled from: tableImage */
public class CheckApprovedMachineMethod_ResultDeserializer extends FbJsonDeserializer {
    public Object m3180a(JsonParser jsonParser, DeserializationContext deserializationContext) {
        Result result = new Result();
        if (jsonParser.g() != JsonToken.START_OBJECT) {
            jsonParser.f();
            result = null;
        } else {
            while (jsonParser.c() != JsonToken.END_OBJECT) {
                String i = jsonParser.i();
                jsonParser.c();
                if ("data".equals(i)) {
                    List list = null;
                    if (jsonParser.g() == JsonToken.START_ARRAY) {
                        list = new ArrayList();
                        while (jsonParser.c() != JsonToken.END_ARRAY) {
                            ApprovalStatus a = CheckApprovedMachineMethod_ApprovalStatus__JsonHelper.m3179a(jsonParser);
                            if (a != null) {
                                list.add(a);
                            }
                        }
                    }
                    result.f2286a = list;
                }
                jsonParser.f();
            }
        }
        return result;
    }

    static {
        GlobalAutoGenDeserializerCache.a(Result.class, new CheckApprovedMachineMethod_ResultDeserializer());
    }

    public CheckApprovedMachineMethod_ResultDeserializer() {
        a(Result.class);
    }
}
