package com.facebook.api.growth.contactimporter;

import com.facebook.common.util.StringUtil;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.ipc.katana.findfriends.CIFlow;
import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: send_confirm_dialog */
public class UsersInviteMethod implements ApiMethod<UsersInviteParams, ArrayList<UsersInviteResult>> {
    private static final TypeReference<ArrayList<UsersInviteResult>> f4035a = new C03651();

    /* compiled from: send_confirm_dialog */
    final class C03651 extends TypeReference<ArrayList<UsersInviteResult>> {
        C03651() {
        }
    }

    public final ApiRequest m3922a(Object obj) {
        UsersInviteParams usersInviteParams = (UsersInviteParams) obj;
        List a = Lists.a();
        StringBuilder stringBuilder = new StringBuilder();
        Object obj2 = 1;
        for (String str : usersInviteParams.f4036a) {
            if (obj2 != null) {
                obj2 = null;
            } else {
                stringBuilder.append(",");
            }
            stringBuilder.append(str.replace(",", ""));
        }
        a.add(new BasicNameValuePair("emails", stringBuilder.toString()));
        String str2 = usersInviteParams.f4037b;
        if (!StringUtil.a(str2)) {
            a.add(new BasicNameValuePair("country_code", str2));
        }
        a.add(new BasicNameValuePair("ci_how_found", usersInviteParams.f4038c));
        CIFlow cIFlow = usersInviteParams.f4039d;
        if (!(cIFlow == null || cIFlow.equals(CIFlow.UNKNOWN))) {
            a.add(new BasicNameValuePair("ci_flow", cIFlow.value));
        }
        a.add(new BasicNameValuePair("is_invite_all", String.valueOf(usersInviteParams.f4040e)));
        a.add(new BasicNameValuePair("is_invite_all_only", String.valueOf(usersInviteParams.f4041f)));
        a.add(new BasicNameValuePair("format", "json"));
        return new ApiRequest("UsersInvite", "POST", "method/users.invite", a, ApiResponseType.JSONPARSER);
    }

    public final Object m3923a(Object obj, ApiResponse apiResponse) {
        return (ArrayList) apiResponse.d().a(f4035a);
    }
}
