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
import javax.inject.Inject;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: appRequest required */
public class VoicemailPromptCreateMethod implements ApiMethod<Uri, Boolean> {
    private final Clock f20380a;
    private final MediaResourceBodyFactory f20381b;

    private static VoicemailPromptCreateMethod m19939b(InjectorLike injectorLike) {
        return new VoicemailPromptCreateMethod((Clock) SystemClockMethodAutoProvider.a(injectorLike), MediaResourceBodyFactory.a(injectorLike));
    }

    public final ApiRequest m19940a(Object obj) {
        Uri uri = (Uri) obj;
        MediaResourceBuilder a = MediaResource.a();
        a.a = uri;
        a = a;
        a.b = Type.AUDIO;
        a = a;
        a.c = Source.AUDIO;
        MediaResourceBody a2 = this.f20381b.a(a.C());
        List a3 = Lists.a();
        Builder builder = ImmutableList.builder();
        builder.c(new BasicNameValuePair("extension", "mp4"));
        a3.add(new FormBodyPart(String.valueOf(this.f20380a.a()), a2));
        ApiRequestBuilder newBuilder = ApiRequest.newBuilder();
        newBuilder.b = "custom_voicemail_create";
        newBuilder = newBuilder;
        newBuilder.c = "POST";
        newBuilder = newBuilder;
        newBuilder.d = "me/custom_voicemails";
        newBuilder = newBuilder;
        newBuilder.g = builder.b();
        newBuilder = newBuilder;
        newBuilder.k = ApiResponseType.JSON;
        newBuilder = newBuilder;
        newBuilder.l = a3;
        return newBuilder.C();
    }

    @Inject
    public VoicemailPromptCreateMethod(Clock clock, MediaResourceBodyFactory mediaResourceBodyFactory) {
        this.f20380a = clock;
        this.f20381b = mediaResourceBodyFactory;
    }

    public final Object m19941a(Object obj, ApiResponse apiResponse) {
        return Boolean.valueOf(apiResponse.c().d("id"));
    }
}
