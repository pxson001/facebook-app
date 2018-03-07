package com.facebook.fbreact.goodwill;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.bitmaps.BitmapUtils;
import com.facebook.bitmaps.Dimension;
import com.facebook.composer.publish.common.PublishPostParams;
import com.facebook.fbreact.fragment.ImmersiveReactFragmentHooks;
import com.facebook.fbreact.goodwill.GoodwillVideoState.PhotoData;
import com.facebook.goodwill.analytics.GoodwillAnalyticsLogger;
import com.facebook.goodwill.composer.GoodwillVideoComposerLauncher;
import com.facebook.goodwill.publish.GoodwillPublishNotificationConfig;
import com.facebook.goodwill.publish.GoodwillPublishPhoto;
import com.facebook.goodwill.publish.GoodwillPublishUploadHandler;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.intent.JsonPluginConfigSerializer;
import com.facebook.ipc.composer.launch.ComposerLaunchActivity;
import com.facebook.ipc.composer.model.ComposerTaggedUser;
import com.facebook.ipc.media.MediaItem;
import com.facebook.ipc.simplepicker.SimplePickerIntent;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration.Action;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration.Builder;
import com.facebook.ipc.simplepicker.SimplePickerSource;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.modules.core.RCTNativeAppEventEmitter;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: extra_size */
public class GoodwillVideoNativeModule extends ReactContextBaseJavaModule implements ActivityEventListener {
    private final ImmersiveReactFragmentHooks f7320a;
    private final GoodwillPublishUploadHandler f7321b;
    private final ViewerContext f7322c;
    private final JsonPluginConfigSerializer f7323d;
    private final BitmapUtils f7324e;
    private final GoodwillAnalyticsLogger f7325f;

    private void m8517a(String str, Object obj) {
        ((RCTNativeAppEventEmitter) this.a.a(RCTNativeAppEventEmitter.class)).emit(str, obj);
    }

    @ReactMethod
    public void openNativePhotoPicker(int i) {
        if (this.a.i()) {
            this.a.a(SimplePickerIntent.a(this.a, new Builder(SimplePickerSource.GOODWILL_COMPOSER).i().k().a(Action.NONE)), 10002, null);
        }
    }

    @Inject
    public GoodwillVideoNativeModule(ImmersiveReactFragmentHooks immersiveReactFragmentHooks, GoodwillPublishUploadHandler goodwillPublishUploadHandler, ViewerContext viewerContext, JsonPluginConfigSerializer jsonPluginConfigSerializer, BitmapUtils bitmapUtils, GoodwillAnalyticsLogger goodwillAnalyticsLogger, @Assisted ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.f7320a = immersiveReactFragmentHooks;
        this.f7321b = goodwillPublishUploadHandler;
        this.f7322c = viewerContext;
        this.f7323d = jsonPluginConfigSerializer;
        this.f7324e = bitmapUtils;
        this.f7325f = goodwillAnalyticsLogger;
        reactApplicationContext.a(this);
    }

    public String getName() {
        return "GoodwillVideoNativeModule";
    }

    public final void m8522a(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case 10001:
                    m8516a(intent);
                    return;
                case 10002:
                    m8521b(intent);
                    return;
                default:
                    return;
            }
        }
    }

    @ReactMethod
    public void openAnniversaryShareComposer(int i, String str, String str2, ReadableArray readableArray, String str3, ReadableMap readableMap, String str4) {
        if (p().i()) {
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.a(readableMap);
            WritableNativeArray writableNativeArray = new WritableNativeArray();
            writableNativeArray.a(writableNativeMap);
            m8518a(str, str2, readableArray, "");
            m8519a(str2, str4, str3, null, null, false, writableNativeArray, p().getString(2131239215));
        }
    }

    @ReactMethod
    public void openGenericShareComposer(int i, String str, String str2, ReadableArray readableArray, String str3, String str4, String str5) {
        if (p().i()) {
            m8518a(str, str2, readableArray, "");
            m8519a(str2, str4, str3, str5, null, true, null, null);
        }
    }

    @ReactMethod
    public void openShareComposer(int i, String str, String str2, String str3, String str4, String str5, ReadableMap readableMap, ReadableArray readableArray) {
        if (p().i()) {
            m8518a(str, str2, null, str3);
            m8519a(str2, str4, readableMap.getString("uri"), str4, str5, true, readableArray, null);
        }
    }

    private void m8518a(String str, String str2, @Nullable ReadableArray readableArray, @Nullable String str3) {
        ImmutableList.Builder builder = new ImmutableList.Builder();
        if (readableArray != null) {
            for (int i = 0; i < readableArray.size(); i++) {
                ReadableMap b = readableArray.b(i);
                builder.c(new PhotoData(b.getString("id"), b.getString("uri"), b.getInt("width"), b.getInt("height")));
            }
        }
        Parcelable goodwillVideoState = new GoodwillVideoState(str, str2, builder.b(), str3);
        Bundle b2 = this.f7320a.b();
        if (b2 == null) {
            b2 = new Bundle();
        }
        b2.putParcelable("anniversary_video_state", goodwillVideoState);
        this.f7320a.a(b2);
    }

    private void m8519a(String str, String str2, String str3, @Nullable String str4, @Nullable String str5, boolean z, ReadableArray readableArray, @Nullable String str6) {
        ImmutableList immutableList = null;
        if (readableArray != null) {
            immutableList = m8515a(readableArray);
        }
        ComposerConfiguration a = GoodwillVideoComposerLauncher.a(str, str2, str3, str4, str5, z, immutableList, str6, this.f7323d);
        this.f7325f.b(str, "promotion", "editor");
        p().a(ComposerLaunchActivity.a(p(), null, a), 10001, null);
    }

    private void m8516a(Intent intent) {
        Bundle b = this.f7320a.b();
        if (b == null) {
            throw new RuntimeException("Cannot load bundle from activity");
        }
        GoodwillVideoState goodwillVideoState = (GoodwillVideoState) b.getParcelable("anniversary_video_state");
        if (goodwillVideoState == null) {
            throw new RuntimeException("Cannot load anniversary video state.");
        }
        PublishPostParams publishPostParams = (PublishPostParams) intent.getParcelableExtra("publishPostParams");
        if (publishPostParams == null) {
            throw new RuntimeException("Composer did not return parameters even though it succeeded!");
        }
        this.f7321b.a(p(), this.f7322c.a(), goodwillVideoState.f7330a, goodwillVideoState.f7331b, "promotion", "editor", publishPostParams.privacy, publishPostParams.rawMessage, publishPostParams.composerSessionId, publishPostParams.taggedIds, m8514a(goodwillVideoState), goodwillVideoState.f7333d, new GoodwillPublishNotificationConfig(p().getString(2131239210), m8520b(goodwillVideoState), p().getString(2131239214)), null);
        this.f7320a.a();
    }

    private static ImmutableList<GoodwillPublishPhoto> m8514a(GoodwillVideoState goodwillVideoState) {
        ImmutableList.Builder builder = new ImmutableList.Builder();
        ImmutableList immutableList = goodwillVideoState.f7332c;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            PhotoData photoData = (PhotoData) immutableList.get(i);
            if (TextUtils.isEmpty(photoData.f7326a)) {
                builder.c(new GoodwillPublishPhoto("0", photoData.f7327b));
            } else {
                builder.c(new GoodwillPublishPhoto(photoData.f7326a, photoData.f7327b));
            }
        }
        return builder.b();
    }

    private String m8520b(GoodwillVideoState goodwillVideoState) {
        if ((goodwillVideoState.f7332c == null || goodwillVideoState.f7332c.isEmpty()) && TextUtils.isEmpty(goodwillVideoState.f7333d)) {
            return this.a.getString(2131239213);
        }
        return this.a.getString(2131239212);
    }

    private static ImmutableList<ComposerTaggedUser> m8515a(@Nullable ReadableArray readableArray) {
        ImmutableList.Builder builder = new ImmutableList.Builder();
        if (readableArray == null) {
            return builder.b();
        }
        for (int i = 0; i < readableArray.size(); i++) {
            ReadableMap b = readableArray.b(i);
            if (b.hasKey("id") && b.hasKey("full_name")) {
                long parseLong = Long.parseLong(b.getString("id"));
                if (parseLong > 0) {
                    String str;
                    ComposerTaggedUser.Builder a = ComposerTaggedUser.a(parseLong);
                    a.b = b.getString("full_name");
                    a = a;
                    if (!b.hasKey("uri") || b.getString("uri") == null) {
                        str = null;
                    } else {
                        str = b.getString("uri");
                    }
                    a.c = str;
                    builder.c(a.a());
                }
            }
        }
        return builder.b();
    }

    private void m8521b(Intent intent) {
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("extra_media_items");
        if (parcelableArrayListExtra != null) {
            ArrayList arrayList = new ArrayList();
            int size = parcelableArrayListExtra.size();
            for (int i = 0; i < size; i++) {
                MediaItem mediaItem = (MediaItem) parcelableArrayListExtra.get(i);
                Dimension a = BitmapUtils.a(mediaItem.f().getPath());
                arrayList.add(new PhotoData(mediaItem.f().toString(), mediaItem.f().toString(), a.b, a.a));
            }
            m8517a("carmeraRollPhotoUploaded", new PhotosPickedEvent(arrayList).m8524a());
        }
    }
}
