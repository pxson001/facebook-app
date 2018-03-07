package com.facebook.rtc.voicemail.api;

import android.net.Uri;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.http.entity.mime.apache.FormBodyPart;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.ApiRequest;
import com.facebook.http.protocol.ApiRequestBuilder;
import com.facebook.http.protocol.ApiResponse;
import com.facebook.http.protocol.ApiResponseType;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResource.Source;
import com.facebook.ui.media.attachments.MediaResource.Type;
import com.facebook.ui.media.attachments.MediaResourceBody;
import com.facebook.ui.media.attachments.MediaResourceBodyFactory;
import com.facebook.ui.media.attachments.MediaResourceBuilder;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import java.util.List;
import javax.annotation.concurrent.Immutable;
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: apn=? */
public class VoicemailPromptUpdateMethod implements ApiMethod<Params, Boolean> {
    private final Clock f20387a;
    private final MediaResourceBodyFactory f20388b;

    @Immutable
    /* compiled from: apn=? */
    public class Params {
        public final Uri f20385a;
        public final String f20386b;
    }

    private static VoicemailPromptUpdateMethod m19948b(InjectorLike injectorLike) {
        return new VoicemailPromptUpdateMethod((Clock) SystemClockMethodAutoProvider.a(injectorLike), MediaResourceBodyFactory.a(injectorLike));
    }

    public final ApiRequest m19949a(Object obj) {
        Params params = (Params) obj;
        MediaResourceBuilder a = MediaResource.a();
        a.a = params.f20385a;
        a = a;
        a.b = Type.AUDIO;
        a = a;
        a.c = Source.AUDIO;
        MediaResourceBody a2 = this.f20388b.a(a.C());
        List a3 = Lists.a();
        Builder builder = ImmutableList.builder();
        builder.c(new BasicNameValuePair("extension", "mp4"));
        a3.add(new FormBodyPart(String.valueOf(this.f20387a.a()), a2));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "custom_voicemail_update";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = params.f20386b;
        newBuilder = newBuilder;
        newBuilder.g = builder.b();
        newBuilder = newBuilder;
        newBuilder.k = ApiResponseType.JSON;
        newBuilder = newBuilder;
        newBuilder.l = a3;
        return newBuilder.C();
    }

    @Inject
    public VoicemailPromptUpdateMethod(Clock clock, MediaResourceBodyFactory mediaResourceBodyFactory) {
        this.f20387a = clock;
        this.f20388b = mediaResourceBodyFactory;
    }

    public final Object m19950a(Object obj, ApiResponse apiResponse) {
        return Boolean.valueOf(Boolean.parseBoolean(apiResponse.c().toString()));
    }
}
