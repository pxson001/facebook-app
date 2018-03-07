package com.facebook.fbreact.pageserviceaddedit;

import android.content.Intent;
import com.facebook.bitmaps.BitmapUtils;
import com.facebook.bitmaps.Dimension;
import com.facebook.inject.Assisted;
import com.facebook.ipc.media.MediaItem;
import com.facebook.ipc.simplepicker.SimplePickerIntent;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration.Action;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration.Builder;
import com.facebook.ipc.simplepicker.SimplePickerSource;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.RCTNativeAppEventEmitter;
import java.util.ArrayList;
import javax.inject.Inject;

/* compiled from: extra_add_section_type */
public class PageServiceAddEditPickerNativeModule extends ReactContextBaseJavaModule implements ActivityEventListener {
    private final BitmapUtils f7396a;

    private void m8569a(String str, Object obj) {
        ((RCTNativeAppEventEmitter) this.a.a(RCTNativeAppEventEmitter.class)).emit(str, obj);
    }

    @ReactMethod
    public void openNativePhotoPicker() {
        if (this.a.i()) {
            this.a.a(SimplePickerIntent.a(this.a, new Builder(SimplePickerSource.PAGE_SERVICE).h().i().a(Action.NONE)), 10003, null);
        }
    }

    @Inject
    public PageServiceAddEditPickerNativeModule(BitmapUtils bitmapUtils, @Assisted ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.f7396a = bitmapUtils;
        reactApplicationContext.a(this);
    }

    public String getName() {
        return "PageServiceAddEditPickerNativeModule";
    }

    public final void m8570a(int i, int i2, Intent intent) {
        if (i2 == -1) {
            switch (i) {
                case 10003:
                    m8568a(intent);
                    return;
                default:
                    return;
            }
        }
    }

    private void m8568a(Intent intent) {
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra("extra_media_items");
        if (parcelableArrayListExtra != null && !parcelableArrayListExtra.isEmpty()) {
            MediaItem mediaItem = (MediaItem) parcelableArrayListExtra.get(0);
            Dimension a = BitmapUtils.a(mediaItem.f().getPath());
            PhotoPickedEvent photoPickedEvent = new PhotoPickedEvent(new PhotoData(mediaItem.f().getPath(), mediaItem.f().getPath(), a.b, a.a));
            WritableMap b = Arguments.b();
            b.putString("id", photoPickedEvent.f7401a.f7397a);
            b.putString("uri", photoPickedEvent.f7401a.f7398b);
            b.putInt("width", photoPickedEvent.f7401a.f7399c);
            b.putInt("height", photoPickedEvent.f7401a.f7400d);
            m8569a("serviceAddEditAndroidPhotoPicked", b);
        }
    }
}
