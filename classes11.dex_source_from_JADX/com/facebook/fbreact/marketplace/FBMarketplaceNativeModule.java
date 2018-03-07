package com.facebook.fbreact.marketplace;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.view.View;
import android.widget.EditText;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.inject.Assisted;
import com.facebook.notifications.common.JewelCounters;
import com.facebook.notifications.common.JewelCounters.Jewel;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.modules.core.RCTNativeAppEventEmitter;
import javax.inject.Inject;

/* compiled from: extra_creativecam_launch_configuration */
public class FBMarketplaceNativeModule extends ReactContextBaseJavaModule implements ActivityEventListener {
    private final JewelCounters f7375a;
    private final SecureContextHelper f7376b;
    private final UriIntentMapper f7377c;

    /* compiled from: extra_creativecam_launch_configuration */
    class C09322 implements OnClickListener {
        final /* synthetic */ FBMarketplaceNativeModule f7374a;

        C09322(FBMarketplaceNativeModule fBMarketplaceNativeModule) {
            this.f7374a = fBMarketplaceNativeModule;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            ((RCTNativeAppEventEmitter) this.f7374a.a.a(RCTNativeAppEventEmitter.class)).emit("MarketplaceLocationDialogCancelled", null);
        }
    }

    @Inject
    public FBMarketplaceNativeModule(@Assisted ReactApplicationContext reactApplicationContext, JewelCounters jewelCounters, SecureContextHelper secureContextHelper, UriIntentMapper uriIntentMapper) {
        super(reactApplicationContext);
        this.f7375a = jewelCounters;
        this.f7376b = secureContextHelper;
        this.f7377c = uriIntentMapper;
        reactApplicationContext.a(this);
    }

    public String getName() {
        return "FBMarketplaceNativeModule";
    }

    public final void m8558a(int i, int i2, Intent intent) {
        if (i2 == -1) {
        }
    }

    @ReactMethod
    public void clearMarketplaceJewelBadgeCount() {
        this.f7375a.a(Jewel.MARKETPLACE, 0);
    }

    @ReactMethod
    public void launchLocationEditDialog(String str) {
        Context q = q();
        if (q != null) {
            final View editText = new EditText(q);
            editText.setInputType(2);
            editText.append(str);
            editText.setHint(2131241956);
            editText.setPadding(50, 10, 0, 10);
            editText.setFilters(new InputFilter[]{new LengthFilter(5)});
            AlertDialog a = new Builder(q).a(2131241954).b(2131241955).b(editText).c(2131230727, new C09322(this)).a(2131241957, new OnClickListener(this) {
                final /* synthetic */ FBMarketplaceNativeModule f7373b;

                public void onClick(DialogInterface dialogInterface, int i) {
                    WritableNativeMap writableNativeMap = new WritableNativeMap();
                    writableNativeMap.putString("zipcode", editText.getText().toString());
                    ((RCTNativeAppEventEmitter) this.f7373b.a.a(RCTNativeAppEventEmitter.class)).emit("MarketplaceLocationUpdated", writableNativeMap);
                }
            }).a();
            a.getWindow().setSoftInputMode(4);
            a.show();
        }
    }

    @ReactMethod
    public void reportStoryURL(ReadableMap readableMap, int i) {
        String string = readableMap.getString("storyGraphQLID");
        String string2 = readableMap.getString("actionType");
        String string3 = readableMap.getString("storyRenderLocation");
        if (string != null && string2 != null && string3 != null) {
            Intent a = this.f7377c.a(this.a, StringFormatUtil.formatStrLocaleSafe(FBLinks.cC, string, string2, string3));
            a.setFlags(268435456);
            this.f7376b.a(a, this.a);
        }
    }

    @ReactMethod
    public void saveLocalPreferredMarketplaceID(String str) {
    }

    @ReactMethod
    public void clearLocalPreferredMarketplaceID() {
    }
}
