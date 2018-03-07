package com.facebook.fbreact.marketplace;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.composer.publish.ComposerPublishServiceHelper;
import com.facebook.composer.publish.common.EditPostParams;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbreact.fb4a.Fb4aReactInstanceManager;
import com.facebook.fbreact.marketplace.MarketplacePostUploadReceiver.C09351;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.model.ComposerSourceType;
import com.facebook.ipc.composer.model.MinutiaeTag;
import com.facebook.ipc.composer.model.ProductItemAttachment;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.ipc.media.MediaItem;
import com.facebook.ipc.simplepicker.SimplePickerIntent;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration.Action;
import com.facebook.ipc.simplepicker.SimplePickerLauncherConfiguration.Builder;
import com.facebook.ipc.simplepicker.SimplePickerSource;
import com.facebook.photos.upload.manager.UploadManager;
import com.facebook.photos.upload.operation.UploadOperation;
import com.facebook.photos.upload.operation.UploadOperationFactory;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.modules.core.RCTNativeAppEventEmitter;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.Futures;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: extra_go_to_section_type */
public class FBMarketplaceComposerBridgeModule extends ReactContextBaseJavaModule implements ActivityEventListener {
    private final SecureContextHelper f7352a;
    private final ComposerPublishServiceHelper f7353b;
    private final UriIntentMapper f7354c;
    private final UploadOperationFactory f7355d;
    public final UploadManager f7356e;
    private final ExecutorService f7357f;
    private final MarketplacePostUploadReceiver f7358g;
    private final Fb4aReactInstanceManager f7359h;
    private ReadableMap f7360i;
    private ArrayList<MediaItem> f7361j;
    private long f7362k;
    public ProductItemAttachment f7363l;
    private String f7364m;

    /* compiled from: extra_go_to_section_type */
    public class C09281 {
        public final /* synthetic */ FBMarketplaceComposerBridgeModule f7349a;

        C09281(FBMarketplaceComposerBridgeModule fBMarketplaceComposerBridgeModule) {
            this.f7349a = fBMarketplaceComposerBridgeModule;
        }
    }

    /* compiled from: extra_go_to_section_type */
    class C09292 implements Runnable {
        final /* synthetic */ FBMarketplaceComposerBridgeModule f7350a;

        C09292(FBMarketplaceComposerBridgeModule fBMarketplaceComposerBridgeModule) {
            this.f7350a = fBMarketplaceComposerBridgeModule;
        }

        public void run() {
            this.f7350a.f7356e.a(this.f7350a.m8539a(this.f7350a.f7363l));
        }
    }

    /* compiled from: extra_go_to_section_type */
    class C09303 extends AbstractDisposableFutureCallback<OperationResult> {
        final /* synthetic */ FBMarketplaceComposerBridgeModule f7351a;

        C09303(FBMarketplaceComposerBridgeModule fBMarketplaceComposerBridgeModule) {
            this.f7351a = fBMarketplaceComposerBridgeModule;
        }

        public final void m8536a(@Nullable Object obj) {
            FBMarketplaceComposerBridgeModule.m8548t(this.f7351a);
        }

        public final void m8537a(Throwable th) {
            FBMarketplaceComposerBridgeModule.m8549u(this.f7351a);
        }
    }

    private void m8542a(String str, Object obj) {
        ((RCTNativeAppEventEmitter) this.a.a(RCTNativeAppEventEmitter.class)).emit(str, obj);
    }

    private void m8546r() {
        ImmutableList copyOf;
        Context context = this.a;
        Builder b = new Builder(SimplePickerSource.MARKETPLACE).k().n().d().i().a().a(Action.NONE).b(1, 10);
        if (this.f7361j != null) {
            copyOf = ImmutableList.copyOf(this.f7361j);
        } else {
            copyOf = RegularImmutableList.a;
        }
        this.a.a(SimplePickerIntent.a(context, b.a(copyOf)), 10004, null);
    }

    private void m8550v() {
        if (this.a.i()) {
            q().finish();
        }
        this.f7359h.m = false;
        m8547s();
    }

    @ReactMethod
    public void launchComposerWithMarketplace(String str, int i, boolean z) {
        if (this.a.i()) {
            m8547s();
            this.f7364m = SafeUUIDGenerator.a().toString();
            this.f7362k = Long.parseLong(str);
            this.f7359h.m = true;
            m8546r();
        }
    }

    @Inject
    public FBMarketplaceComposerBridgeModule(@Assisted ReactApplicationContext reactApplicationContext, ExecutorService executorService, UriIntentMapper uriIntentMapper, SecureContextHelper secureContextHelper, UploadManager uploadManager, UploadOperationFactory uploadOperationFactory, ComposerPublishServiceHelper composerPublishServiceHelper, MarketplacePostUploadReceiver marketplacePostUploadReceiver, Fb4aReactInstanceManager fb4aReactInstanceManager) {
        super(reactApplicationContext);
        this.f7352a = secureContextHelper;
        this.f7353b = composerPublishServiceHelper;
        this.f7354c = uriIntentMapper;
        this.f7355d = uploadOperationFactory;
        this.f7356e = uploadManager;
        this.f7357f = executorService;
        this.f7358g = marketplacePostUploadReceiver;
        this.f7359h = fb4aReactInstanceManager;
        reactApplicationContext.a(this);
    }

    public String getName() {
        return "FBMarketplaceComposerBridgeModule";
    }

    public final void m8551a(int i, int i2, Intent intent) {
        if (i2 != -1) {
            this.f7359h.m = false;
            return;
        }
        switch (i) {
            case 10004:
                m8540a(intent);
                return;
            default:
                return;
        }
    }

    @ReactMethod
    public void returnToMediaPicker(ReadableMap readableMap) {
        this.f7360i = readableMap;
        if (this.a.i()) {
            m8546r();
        }
    }

    @ReactMethod
    public void launchEditComposerForPost(String str, int i, String str2) {
        this.f7364m = SafeUUIDGenerator.a().toString();
        Intent a = this.f7354c.a(this.a, StringFormatUtil.formatStrLocaleSafe(FBLinks.fI, str, str2));
        a.setFlags(335544320);
        this.f7352a.a(a, this.a);
    }

    private UploadOperation m8539a(ProductItemAttachment productItemAttachment) {
        ImmutableList.Builder builder = ImmutableList.builder();
        int size = this.f7361j.size();
        for (int i = 0; i < size; i++) {
            builder.c((MediaItem) this.f7361j.get(i));
        }
        return this.f7355d.a(builder.b(), null, this.f7362k, TargetType.MARKETPLACE.toString(), productItemAttachment.title, MinutiaeTag.a, new ImmutableList.Builder().b(), -1, false, null, false, null, false, null, this.f7364m, productItemAttachment, this.f7362k, ComposerSourceType.MARKETPLACE.toString(), false, null);
    }

    private void m8540a(Intent intent) {
        this.f7361j = intent.getParcelableArrayListExtra("extra_media_items");
        if (this.f7361j != null && !this.f7361j.isEmpty()) {
            Iterable arrayList = new ArrayList();
            int size = this.f7361j.size();
            for (int i = 0; i < size; i++) {
                arrayList.add(((MediaItem) this.f7361j.get(i)).f().toString());
            }
            Intent a = this.f7354c.a(this.a, StringFormatUtil.formatStrLocaleSafe(FBLinks.fH, TextUtils.join(",", arrayList)));
            a.setFlags(335544320);
            this.f7352a.a(a, this.a);
        }
    }

    @ReactMethod
    public void submitMarketplacePost(ReadableMap readableMap) {
        ProductItemAttachment.Builder builder = new ProductItemAttachment.Builder();
        builder.a = readableMap.getString("title");
        builder = builder;
        builder.d = readableMap.getString("description");
        builder = builder;
        builder.e = Long.valueOf(Integer.valueOf(readableMap.getInt("price")).longValue());
        builder = builder;
        builder.f = readableMap.getString("currency");
        builder = builder;
        builder.g = readableMap.getString("categoryID");
        builder = builder;
        builder.b = readableMap.getString("zipcode");
        builder = builder;
        builder.h = true;
        builder = builder;
        builder.i = true;
        builder = builder;
        builder.j = true;
        this.f7363l = builder.a();
        MarketplacePostUploadReceiver marketplacePostUploadReceiver = this.f7358g;
        String str = this.f7364m;
        C09281 c09281 = new C09281(this);
        marketplacePostUploadReceiver.f7392d.a(marketplacePostUploadReceiver.f7390b);
        marketplacePostUploadReceiver.f7392d.a(marketplacePostUploadReceiver.f7391c);
        marketplacePostUploadReceiver.f7394f = str;
        marketplacePostUploadReceiver.f7389a = c09281;
        if (marketplacePostUploadReceiver.f7395g != null) {
            HandlerDetour.a(marketplacePostUploadReceiver.f7393e, marketplacePostUploadReceiver.f7395g);
        }
        marketplacePostUploadReceiver.f7395g = new C09351(marketplacePostUploadReceiver);
        HandlerDetour.b(marketplacePostUploadReceiver.f7393e, marketplacePostUploadReceiver.f7395g, 3600000, -245266768);
        ExecutorDetour.a(this.f7357f, new C09292(this), -2045838522);
    }

    @ReactMethod
    public void editMarketplacePost(ReadableMap readableMap) {
        ProductItemAttachment.Builder builder = new ProductItemAttachment.Builder();
        builder.a = readableMap.getString("title");
        builder = builder;
        builder.d = readableMap.getString("description");
        builder = builder;
        builder.e = Long.valueOf(Integer.valueOf(readableMap.getInt("price")).longValue());
        builder = builder;
        builder.f = readableMap.getString("currency");
        builder = builder;
        builder.g = readableMap.getString("categoryID");
        builder = builder;
        builder.b = readableMap.getString("zipcode");
        builder = builder;
        builder.h = true;
        builder = builder;
        builder.i = true;
        builder = builder;
        builder.j = true;
        ProductItemAttachment a = builder.a();
        EditPostParams.Builder builder2 = new EditPostParams.Builder();
        builder2.a = this.f7364m;
        builder2 = builder2;
        builder2.j = a;
        EditPostParams.Builder builder3 = builder2;
        builder3.d = readableMap.getString("storyID");
        builder3 = builder3;
        builder3.b = readableMap.getString("storyID");
        EditPostParams a2 = builder3.a();
        Intent intent = new Intent();
        intent.putExtra("publishEditPostParamsKey", a2);
        Futures.a(this.f7353b.c(intent), new C09303(this));
    }

    @ReactMethod
    public void maybePrefillComposerData() {
        if (this.f7360i != null) {
            Object writableNativeMap = new WritableNativeMap();
            writableNativeMap.a(this.f7360i);
            m8542a("PrefillMarketplaceComposerData", writableNativeMap);
        }
    }

    @ReactMethod
    public void exitComposer() {
        m8542a("MarketplaceComposerCancel", null);
        m8550v();
    }

    private void m8547s() {
        this.f7362k = 0;
        this.f7361j = null;
        this.f7363l = null;
        this.f7364m = null;
        this.f7360i = null;
    }

    public static void m8548t(FBMarketplaceComposerBridgeModule fBMarketplaceComposerBridgeModule) {
        fBMarketplaceComposerBridgeModule.m8542a("MarketplacePostPublished", null);
        fBMarketplaceComposerBridgeModule.m8550v();
    }

    public static void m8549u(FBMarketplaceComposerBridgeModule fBMarketplaceComposerBridgeModule) {
        fBMarketplaceComposerBridgeModule.m8542a("MarketplacePostFailed", null);
    }
}
