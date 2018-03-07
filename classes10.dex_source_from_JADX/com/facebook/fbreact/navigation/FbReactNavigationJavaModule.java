package com.facebook.fbreact.navigation;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbreact.fragment.ImmersiveReactFragmentHooks;
import com.facebook.fbreact.fragment.ImmersiveReactFragmentHooks.1;
import com.facebook.fbreact.search.ReactSearchEventBus;
import com.facebook.fbreact.search.ReactSearchEvents.LaunchReachSearchResultEvent;
import com.facebook.inject.Assisted;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: anveun */
public class FbReactNavigationJavaModule extends ReactContextBaseJavaModule implements LifecycleEventListener {
    private final SecureContextHelper f19637a;
    private final FbReactNavigationUriIntentBuilder f19638b;
    private final ImmersiveReactFragmentHooks f19639c;
    private final FbUriIntentHandler f19640d;
    public final ReactSearchEventBus f19641e;
    private final Executor f19642f;
    private boolean f19643g = true;

    @Inject
    public FbReactNavigationJavaModule(@Assisted ReactApplicationContext reactApplicationContext, SecureContextHelper secureContextHelper, FbReactNavigationUriIntentBuilder fbReactNavigationUriIntentBuilder, ImmersiveReactFragmentHooks immersiveReactFragmentHooks, FbUriIntentHandler fbUriIntentHandler, ReactSearchEventBus reactSearchEventBus, Executor executor) {
        super(reactApplicationContext);
        this.f19637a = secureContextHelper;
        this.f19638b = fbReactNavigationUriIntentBuilder;
        this.f19639c = immersiveReactFragmentHooks;
        this.f19640d = fbUriIntentHandler;
        this.a.a(this);
        this.f19641e = reactSearchEventBus;
        this.f19642f = executor;
    }

    @ReactMethod
    public void openURL(int i, String str) {
        m19918a(Uri.parse("fb:/" + str));
    }

    @ReactMethod
    public void openTarget(int i, String str, String str2) {
        if ("URL".equals(str2)) {
            this.f19640d.a(q(), str);
            return;
        }
        Uri a = m19916a(str, str2);
        if (a != null) {
            m19918a(a);
        }
    }

    @ReactMethod
    public void openSearchURL(final int i, final String str, final String str2) {
        ExecutorDetour.a(this.f19642f, new Runnable(this) {
            final /* synthetic */ FbReactNavigationJavaModule f19636d;

            public void run() {
                this.f19636d.f19641e.a(new LaunchReachSearchResultEvent(i, str, str2));
            }
        }, -435409177);
    }

    public final void hh_() {
        this.f19643g = false;
    }

    public final void hg_() {
        this.f19643g = false;
    }

    public final void hf_() {
        this.f19643g = true;
    }

    @Nullable
    private static Uri m19916a(String str, String str2) {
        String str3;
        Object obj = -1;
        switch (str2.hashCode()) {
            case 2479791:
                if (str2.equals("Page")) {
                    obj = 1;
                    break;
                }
                break;
            case 2645995:
                if (str2.equals("User")) {
                    obj = null;
                    break;
                }
                break;
            case 69076575:
                if (str2.equals("Group")) {
                    obj = 2;
                    break;
                }
                break;
            case 77090322:
                if (str2.equals("Photo")) {
                    obj = 3;
                    break;
                }
                break;
            case 80218325:
                if (str2.equals("Story")) {
                    obj = 4;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                str3 = FBLinks.aX;
                break;
            case 1:
                str3 = FBLinks.af;
                break;
            case 2:
                str3 = FBLinks.u;
                break;
            case 3:
                str3 = FBLinks.bk;
                break;
            case 4:
                str3 = FBLinks.aQ;
                break;
            default:
                throw new JSApplicationIllegalArgumentException("Attempted to build Uri with an unsupported type");
        }
        if (str3.isEmpty()) {
            return null;
        }
        return Uri.parse(StringFormatUtil.formatStrLocaleSafe(str3, str));
    }

    public final void m19918a(Uri uri) {
        if (this.f19643g) {
            this.f19643g = false;
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            Context q = q();
            if (q == null) {
                q = this.a;
                intent.addFlags(268435456);
            }
            this.f19637a.a(intent, q);
        }
    }

    @ReactMethod
    public void dismiss(int i) {
        this.f19639c.a();
    }

    @ReactMethod
    public void registerRoutes(ReadableArray readableArray) {
    }

    @ReactMethod
    public void setCurrentImmersiveReactFragmentTitle(int i, String str) {
        ImmersiveReactFragmentHooks immersiveReactFragmentHooks = this.f19639c;
        immersiveReactFragmentHooks.a.a(new 1(immersiveReactFragmentHooks, str));
    }

    @ReactMethod
    public void getSavedInstanceState(int i, Callback callback) {
        if (this.f19639c.b() != null) {
            callback.a(new Object[]{Arguments.a(this.f19639c.b())});
            return;
        }
        callback.a(new Object[]{Integer.valueOf(0)});
    }

    @ReactMethod
    public void setInstanceStateToSave(int i, ReadableMap readableMap) {
        Bundle a = Arguments.a(readableMap);
        if (a != null) {
            this.f19639c.a(a);
        }
    }

    public String getName() {
        return "FBFacebookReactNavigator";
    }
}
