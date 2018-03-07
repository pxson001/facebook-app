package com.facebook.fbreact.marketplace;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbreact.fb4a.Fb4aReactInstanceManager;
import com.facebook.inject.Assisted;
import com.facebook.ipc.media.MediaItem;
import com.facebook.ipc.media.data.MediaData;
import com.facebook.ipc.simplepicker.SimplePickerIntent;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration.Action;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration.Builder;
import com.facebook.ipc.simplepicker.SimplePickerSource;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.ArrayList;
import javax.inject.Inject;

/* compiled from: extra_field */
public class FBMarketplaceImagePickerModule extends ReactContextBaseJavaModule implements ActivityEventListener {
    private final SecureContextHelper f7365a;
    private final UriIntentMapper f7366b;
    private final Fb4aReactInstanceManager f7367c;
    private String f7368d;
    private Callback f7369e;
    private Callback f7370f;
    private ArrayList<MediaItem> f7371g;

    @ReactMethod
    public void openSelectDialog(ReadableMap readableMap, String str, Callback callback, Callback callback2) {
        if (this.a.i()) {
            this.f7368d = str;
            this.f7369e = callback;
            this.f7370f = callback2;
            this.f7367c.m = true;
            m8554r();
        }
    }

    @Inject
    public FBMarketplaceImagePickerModule(@Assisted ReactApplicationContext reactApplicationContext, UriIntentMapper uriIntentMapper, SecureContextHelper secureContextHelper, Fb4aReactInstanceManager fb4aReactInstanceManager) {
        super(reactApplicationContext);
        this.f7366b = uriIntentMapper;
        this.f7365a = secureContextHelper;
        this.f7367c = fb4aReactInstanceManager;
        reactApplicationContext.a(this);
    }

    public String getName() {
        return "FBMarketplaceImagePickerModule";
    }

    public final void m8555a(int i, int i2, Intent intent) {
        if (i2 != -1) {
            this.f7367c.m = false;
            if (this.f7370f != null) {
                this.f7370f.a(new Object[0]);
                return;
            }
            return;
        }
        switch (i) {
            case 10005:
                m8553a(intent);
                return;
            default:
                return;
        }
    }

    private void m8553a(Intent intent) {
        this.f7371g = intent.getParcelableArrayListExtra("extra_media_items");
        if (this.f7371g == null || this.f7371g.isEmpty()) {
            if (this.f7370f != null) {
                this.f7370f.a(new Object[0]);
            }
        } else if (this.f7369e != null) {
            MediaData b = ((MediaItem) this.f7371g.get(0)).b();
            this.f7369e.a(new Object[]{r0.f().toString(), Integer.valueOf(b.mHeight), Integer.valueOf(b.mWidth)});
        }
    }

    private void m8554r() {
        ImmutableList copyOf;
        Context context = this.a;
        Builder b = new Builder(SimplePickerSource.MARKETPLACE).k().n().d().i().a().a(Action.NONE).b(1, 1);
        if (this.f7371g != null) {
            copyOf = ImmutableList.copyOf(this.f7371g);
        } else {
            copyOf = RegularImmutableList.a;
        }
        this.a.a(SimplePickerIntent.a(context, b.a(copyOf)), 10005, null);
    }
}
