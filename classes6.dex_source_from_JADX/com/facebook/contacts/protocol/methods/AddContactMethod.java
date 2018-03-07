package com.facebook.contacts.protocol.methods;

import com.facebook.common.util.JSONUtil;
import com.facebook.contacts.server.AddContactParams;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.user.util.UserPhoneNumberUtil;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: page_profile_pic */
public class AddContactMethod implements ApiMethod<AddContactParams, String> {
    private final UserPhoneNumberUtil f8378a;
    private final Provider<String> f8379b;

    private static AddContactMethod m12229b(InjectorLike injectorLike) {
        return new AddContactMethod(UserPhoneNumberUtil.a(injectorLike), IdBasedProvider.a(injectorLike, 4446));
    }

    public final ApiRequest m12230a(Object obj) {
        AddContactParams addContactParams = (AddContactParams) obj;
        List a = Lists.a();
        if (addContactParams.f8425a != null) {
            a.add(new BasicNameValuePair("profile_id", addContactParams.f8425a));
        } else if (addContactParams.f8426b != null) {
            a.add(new BasicNameValuePair("phone", this.f8378a.c(addContactParams.f8426b)));
            a.add(new BasicNameValuePair("country_code", (String) this.f8379b.get()));
        }
        return new ApiRequest("addUserToRolodexMethod", "POST", "me/contacts", a, ApiResponseType.JSON);
    }

    @Inject
    public AddContactMethod(UserPhoneNumberUtil userPhoneNumberUtil, Provider<String> provider) {
        this.f8378a = userPhoneNumberUtil;
        this.f8379b = provider;
    }

    public final Object m12231a(Object obj, ApiResponse apiResponse) {
        return JSONUtil.b(apiResponse.c().b("id"));
    }
}
