package com.facebook.saved.common.protocol;

import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.common.util.JSONUtil;
import com.facebook.http.interfaces.RequestPriority;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: setDisableAttachToAlbum */
public class UpdateSavedStateMethod implements ApiMethod<UpdateSavedStateParams, Boolean> {
    private final String f4848a;

    public static UpdateSavedStateMethod m7657b(InjectorLike injectorLike) {
        return new UpdateSavedStateMethod(String_LoggedInUserIdMethodAutoProvider.b(injectorLike));
    }

    public final ApiRequest m7658a(Object obj) {
        UpdateSavedStateParams updateSavedStateParams = (UpdateSavedStateParams) obj;
        List a = Lists.a();
        if (updateSavedStateParams.f4857a.isPresent()) {
            a.add(new BasicNameValuePair("source_story_id", (String) updateSavedStateParams.f4857a.get()));
        } else if (updateSavedStateParams.f4858b.isPresent()) {
            a.add(new BasicNameValuePair("object_id", (String) updateSavedStateParams.f4858b.get()));
        } else if (updateSavedStateParams.f4859c.isPresent()) {
            a.add(new BasicNameValuePair("url", (String) updateSavedStateParams.f4859c.get()));
        }
        a.add(new BasicNameValuePair("action", updateSavedStateParams.f4861e.toString()));
        a.add(new BasicNameValuePair("surface", updateSavedStateParams.f4862f.toString()));
        a.add(new BasicNameValuePair("mechanism", updateSavedStateParams.f4863g.toString()));
        a.add(new BasicNameValuePair("tracking", (String) updateSavedStateParams.f4860d.orNull()));
        return new ApiRequest("updateSavedState", "POST", this.f4848a + "/saved", RequestPriority.INTERACTIVE, a, ApiResponseType.JSON);
    }

    @Inject
    public UpdateSavedStateMethod(String str) {
        this.f4848a = str;
    }

    public final Object m7659a(Object obj, ApiResponse apiResponse) {
        apiResponse.i();
        return Boolean.valueOf(JSONUtil.g(apiResponse.c()));
    }
}
