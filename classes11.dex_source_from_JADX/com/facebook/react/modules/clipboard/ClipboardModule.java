package com.facebook.react.modules.clipboard;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Build.VERSION;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

/* compiled from: SIZE_50 */
public class ClipboardModule extends ReactContextBaseJavaModule {
    private ClipboardManager m11735r() {
        return (ClipboardManager) this.a.getSystemService("clipboard");
    }

    public ClipboardModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public String getName() {
        return "Clipboard";
    }

    @ReactMethod
    public void getString(Promise promise) {
        try {
            ClipboardManager r = m11735r();
            ClipData primaryClip = r.getPrimaryClip();
            if (primaryClip == null) {
                promise.a("");
            } else if (primaryClip.getItemCount() > 0) {
                promise.a(r.getPrimaryClip().getItemAt(0).getText());
            } else {
                promise.a("");
            }
        } catch (Throwable e) {
            promise.a(e);
        }
    }

    @SuppressLint({"DeprecatedMethod"})
    @ReactMethod
    public void setString(String str) {
        if (VERSION.SDK_INT >= 11) {
            m11735r().setPrimaryClip(ClipData.newPlainText(null, str));
            return;
        }
        m11735r().setText(str);
    }
}
