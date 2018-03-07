package com.facebook.react.modules.dialog;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: SIZE */
public class DialogModule extends ReactContextBaseJavaModule implements LifecycleEventListener {
    static final Map<String, Object> f11404a = MapBuilder.a("buttonClicked", "buttonClicked", "dismissed", "dismissed", "buttonPositive", Integer.valueOf(-1), "buttonNegative", Integer.valueOf(-2), "buttonNeutral", Integer.valueOf(-3));
    private boolean f11405b;

    /* compiled from: SIZE */
    class AlertFragmentListener implements OnClickListener, OnDismissListener {
        final /* synthetic */ DialogModule f11397a;
        private final Callback f11398b;
        private boolean f11399c = false;

        public AlertFragmentListener(DialogModule dialogModule, Callback callback) {
            this.f11397a = dialogModule;
            this.f11398b = callback;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            if (!this.f11399c && this.f11397a.a.b()) {
                this.f11398b.a(new Object[]{"buttonClicked", Integer.valueOf(i)});
                this.f11399c = true;
            }
        }

        public void onDismiss(DialogInterface dialogInterface) {
            if (!this.f11399c && this.f11397a.a.b()) {
                this.f11398b.a(new Object[]{"dismissed"});
                this.f11399c = true;
            }
        }
    }

    /* compiled from: SIZE */
    class FragmentManagerHelper {
        final /* synthetic */ DialogModule f11400a;
        @Nullable
        private final FragmentManager f11401b;
        @Nullable
        private final android.support.v4.app.FragmentManager f11402c;
        @Nullable
        private Object f11403d;

        private boolean m11737b() {
            return this.f11402c != null;
        }

        public FragmentManagerHelper(DialogModule dialogModule, android.support.v4.app.FragmentManager fragmentManager) {
            this.f11400a = dialogModule;
            this.f11401b = null;
            this.f11402c = fragmentManager;
        }

        public FragmentManagerHelper(DialogModule dialogModule, FragmentManager fragmentManager) {
            this.f11400a = dialogModule;
            this.f11401b = fragmentManager;
            this.f11402c = null;
        }

        public final void m11739a() {
            if (this.f11403d != null) {
                if (m11737b()) {
                    ((SupportAlertFragment) this.f11403d).a(this.f11402c, "com.facebook.catalyst.react.dialog.DialogModule");
                } else {
                    ((AlertFragment) this.f11403d).show(this.f11401b, "com.facebook.catalyst.react.dialog.DialogModule");
                }
                this.f11403d = null;
            }
        }

        private void m11738c() {
            if (m11737b()) {
                SupportAlertFragment supportAlertFragment = (SupportAlertFragment) this.f11402c.a("com.facebook.catalyst.react.dialog.DialogModule");
                if (supportAlertFragment != null) {
                    supportAlertFragment.a();
                    return;
                }
                return;
            }
            AlertFragment alertFragment = (AlertFragment) this.f11401b.findFragmentByTag("com.facebook.catalyst.react.dialog.DialogModule");
            if (alertFragment != null) {
                alertFragment.dismiss();
            }
        }

        public final void m11740a(boolean z, Bundle bundle, Callback callback) {
            m11738c();
            AlertFragmentListener alertFragmentListener = callback != null ? new AlertFragmentListener(this.f11400a, callback) : null;
            if (m11737b()) {
                SupportAlertFragment supportAlertFragment = new SupportAlertFragment(alertFragmentListener, bundle);
                if (z) {
                    supportAlertFragment.a(this.f11402c, "com.facebook.catalyst.react.dialog.DialogModule");
                    return;
                } else {
                    this.f11403d = supportAlertFragment;
                    return;
                }
            }
            AlertFragment alertFragment = new AlertFragment(alertFragmentListener, bundle);
            if (z) {
                alertFragment.show(this.f11401b, "com.facebook.catalyst.react.dialog.DialogModule");
            } else {
                this.f11403d = alertFragment;
            }
        }
    }

    public final void m11745c() {
        this.a.a(this);
    }

    public DialogModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public String getName() {
        return "DialogManagerAndroid";
    }

    public final Map<String, Object> m11744a() {
        return f11404a;
    }

    public final void hg_() {
        this.f11405b = false;
    }

    public final void hh_() {
    }

    public final void hf_() {
        this.f11405b = true;
        FragmentManagerHelper r = m11743r();
        Assertions.a(r, "Attached DialogModule to host with pending alert but no FragmentManager (not attached to an Activity).");
        r.m11739a();
    }

    @ReactMethod
    public void showAlert(ReadableMap readableMap, Callback callback, Callback callback2) {
        int i = 0;
        FragmentManagerHelper r = m11743r();
        if (r == null) {
            callback.a(new Object[]{"Tried to show an alert while not attached to an Activity"});
            return;
        }
        Bundle bundle = new Bundle();
        if (readableMap.hasKey("title")) {
            bundle.putString("title", readableMap.getString("title"));
        }
        if (readableMap.hasKey("message")) {
            bundle.putString("message", readableMap.getString("message"));
        }
        if (readableMap.hasKey("buttonPositive")) {
            bundle.putString("button_positive", readableMap.getString("buttonPositive"));
        }
        if (readableMap.hasKey("buttonNegative")) {
            bundle.putString("button_negative", readableMap.getString("buttonNegative"));
        }
        if (readableMap.hasKey("buttonNeutral")) {
            bundle.putString("button_neutral", readableMap.getString("buttonNeutral"));
        }
        if (readableMap.hasKey("items")) {
            ReadableArray a = readableMap.a("items");
            CharSequence[] charSequenceArr = new CharSequence[a.size()];
            while (i < a.size()) {
                charSequenceArr[i] = a.getString(i);
                i++;
            }
            bundle.putCharSequenceArray("items", charSequenceArr);
        }
        r.m11740a(this.f11405b, bundle, callback2);
    }

    @Nullable
    private FragmentManagerHelper m11743r() {
        Activity q = q();
        if (q == null) {
            return null;
        }
        if (q instanceof FragmentActivity) {
            return new FragmentManagerHelper(this, ((FragmentActivity) q).kO_());
        }
        return new FragmentManagerHelper(this, q.getFragmentManager());
    }
}
