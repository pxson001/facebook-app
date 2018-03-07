package com.facebook.zero.carrier;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import com.facebook.bitmaps.FbBitmapFactory;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.shortcuts.InstallShortcutHelper;
import com.facebook.http.common.FbHttpRequest;
import com.facebook.http.common.FbHttpRequest.Builder;
import com.facebook.http.common.FbHttpRequestProcessor;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.zero.common.constants.ZeroPrefKeys;
import com.google.common.base.Function;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListeningExecutorService;
import javax.inject.Inject;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;

/* compiled from: music_preview_exception */
public class CarrierManagerUtil {
    private final ListeningExecutorService f5291a;
    public final InstallShortcutHelper f5292b;
    public final FbSharedPreferences f5293c;
    private final FbHttpRequestProcessor f5294d;

    /* compiled from: music_preview_exception */
    class C06871 implements ResponseHandler<Bitmap> {
        final /* synthetic */ CarrierManagerUtil f5288a;

        C06871(CarrierManagerUtil carrierManagerUtil) {
            this.f5288a = carrierManagerUtil;
        }

        public Object handleResponse(HttpResponse httpResponse) {
            return FbBitmapFactory.a(httpResponse.getEntity().getContent(), null, null);
        }
    }

    public static CarrierManagerUtil m6548b(InjectorLike injectorLike) {
        return new CarrierManagerUtil(ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), InstallShortcutHelper.b(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), FbHttpRequestProcessor.a(injectorLike));
    }

    @Inject
    public CarrierManagerUtil(ListeningExecutorService listeningExecutorService, InstallShortcutHelper installShortcutHelper, FbSharedPreferences fbSharedPreferences, FbHttpRequestProcessor fbHttpRequestProcessor) {
        this.f5291a = listeningExecutorService;
        this.f5292b = installShortcutHelper;
        this.f5293c = fbSharedPreferences;
        this.f5294d = fbHttpRequestProcessor;
    }

    public final void m6549a(final String str, String str2, FutureCallback<Boolean> futureCallback) {
        if (this.f5293c.a(ZeroPrefKeys.X, true)) {
            Builder newBuilder = FbHttpRequest.newBuilder();
            newBuilder.b = new HttpGet(str2);
            newBuilder = newBuilder;
            newBuilder.g = new C06871(this);
            Futures.a(Futures.a(this.f5294d.b(newBuilder.a()).b, new Function<Bitmap, Boolean>(this) {
                final /* synthetic */ CarrierManagerUtil f5290b;

                public Object apply(Object obj) {
                    Bitmap bitmap = (Bitmap) obj;
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse("carrier_manager?ref={%s}"));
                    this.f5290b.f5292b.a(intent, str, bitmap, null, false);
                    this.f5290b.f5293c.edit().putBoolean(ZeroPrefKeys.X, false).commit();
                    return Boolean.valueOf(true);
                }
            }, this.f5291a), futureCallback, this.f5291a);
        }
    }
}
