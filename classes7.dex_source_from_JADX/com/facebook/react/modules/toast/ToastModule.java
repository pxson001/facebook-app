package com.facebook.react.modules.toast;

import android.widget.Toast;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.MapBuilder;
import java.util.Map;

/* compiled from: friendly_names */
public class ToastModule extends ReactContextBaseJavaModule {
    public ToastModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public String getName() {
        return "ToastAndroid";
    }

    public final Map<String, Object> m13779a() {
        Map<String, Object> a = MapBuilder.m13603a();
        a.put("SHORT", Integer.valueOf(0));
        a.put("LONG", Integer.valueOf(1));
        return a;
    }

    @ReactMethod
    public void show(final String str, final int i) {
        UiThreadUtil.m13552a(new Runnable(this) {
            final /* synthetic */ ToastModule f11704c;

            public void run() {
                Toast.makeText(this.f11704c.f1100a, str, i).show();
            }
        });
    }
}
