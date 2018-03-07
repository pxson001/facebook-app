package com.facebook.zero;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.facebook.common.build.BuildConstants;
import com.facebook.common.util.FacebookUriUtil;
import com.facebook.common.util.TriState;
import com.facebook.content.ExternalIntentHandler;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBinderSet;
import com.facebook.zero.activity.ZeroIntentInterstitialActivity;
import com.facebook.zero.common.intent.ExternalIntentWhitelistItem;
import com.facebook.zero.common.intent.STATICDI_MULTIBIND_PROVIDER$ExternalIntentWhitelistItem;
import com.facebook.zero.rewrite.FbZeroUrlRewriter;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import com.facebook.zero.sdk.rewrite.ZeroUrlRewriter;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: com.facebook.platform.APPLINK_TAP_TIME_UTC */
public class ZeroAwareExternalIntentHandler implements ExternalIntentHandler {
    private final Context f20267a;
    private final ZeroUrlRewriter f20268b;
    private final Provider<Boolean> f20269c;
    private final Set<ExternalIntentWhitelistItem> f20270d;
    private final FbZeroFeatureVisibilityHelper f20271e;

    @VisibleForTesting
    /* compiled from: com.facebook.platform.APPLINK_TAP_TIME_UTC */
    enum HandleMode {
        HANDLE_AFTER_REWRITE,
        HANDLE_BEHIND_DIALOG,
        DONT_HANDLE
    }

    public static ZeroAwareExternalIntentHandler m28862b(InjectorLike injectorLike) {
        return new ZeroAwareExternalIntentHandler((Context) injectorLike.getInstance(Context.class), (ZeroUrlRewriter) FbZeroUrlRewriter.b(injectorLike), IdBasedProvider.a(injectorLike, 4034), new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$ExternalIntentWhitelistItem(injectorLike)), FbZeroFeatureVisibilityHelper.a(injectorLike));
    }

    @Inject
    public ZeroAwareExternalIntentHandler(Context context, ZeroUrlRewriter zeroUrlRewriter, Provider<Boolean> provider, Set<ExternalIntentWhitelistItem> set, FbZeroFeatureVisibilityHelper fbZeroFeatureVisibilityHelper) {
        this.f20267a = context;
        this.f20268b = zeroUrlRewriter;
        this.f20269c = provider;
        this.f20270d = set;
        this.f20271e = fbZeroFeatureVisibilityHelper;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean m28865a(android.content.Intent r6, android.content.Context r7) {
        /*
        r5 = this;
        r0 = 1;
        r1 = 0;
        r2 = r6.getComponent();
        r3 = com.facebook.zero.ZeroAwareExternalIntentHandler.C15391.f20266a;	 Catch:{ all -> 0x004a }
        r4 = r5.m28860a(r6);	 Catch:{ all -> 0x004a }
        r4 = r4.ordinal();	 Catch:{ all -> 0x004a }
        r3 = r3[r4];	 Catch:{ all -> 0x004a }
        switch(r3) {
            case 1: goto L_0x0022;
            case 2: goto L_0x0035;
            default: goto L_0x0015;
        };
    L_0x0015:
        r0 = r6.getComponent();
        r0 = com.google.common.base.Objects.equal(r2, r0);
        com.google.common.base.Preconditions.checkState(r0);
        r0 = r1;
    L_0x0021:
        return r0;
    L_0x0022:
        r6 = r5.m28861b(r6);	 Catch:{  }
        r7.startActivity(r6);	 Catch:{  }
        r1 = r6.getComponent();
        r1 = com.google.common.base.Objects.equal(r2, r1);
        com.google.common.base.Preconditions.checkState(r1);
        goto L_0x0021;
    L_0x0035:
        r1 = 0;
        r3 = 0;
        r1 = m28859a(r7, r6, r1, r3);	 Catch:{  }
        r7.startActivity(r1);	 Catch:{  }
        r1 = r6.getComponent();
        r1 = com.google.common.base.Objects.equal(r2, r1);
        com.google.common.base.Preconditions.checkState(r1);
        goto L_0x0021;
    L_0x004a:
        r0 = move-exception;
        r1 = r6.getComponent();
        r1 = com.google.common.base.Objects.equal(r2, r1);
        com.google.common.base.Preconditions.checkState(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.zero.ZeroAwareExternalIntentHandler.a(android.content.Intent, android.content.Context):boolean");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean m28863a(android.content.Intent r5, int r6, android.app.Activity r7) {
        /*
        r4 = this;
        r0 = 1;
        r1 = r5.getComponent();
        r2 = com.facebook.zero.ZeroAwareExternalIntentHandler.C15391.f20266a;	 Catch:{ all -> 0x0048 }
        r3 = r4.m28860a(r5);	 Catch:{ all -> 0x0048 }
        r3 = r3.ordinal();	 Catch:{ all -> 0x0048 }
        r2 = r2[r3];	 Catch:{ all -> 0x0048 }
        switch(r2) {
            case 1: goto L_0x0021;
            case 2: goto L_0x0034;
            default: goto L_0x0014;
        };
    L_0x0014:
        r0 = r5.getComponent();
        r0 = com.google.common.base.Objects.equal(r1, r0);
        com.google.common.base.Preconditions.checkState(r0);
        r0 = 0;
    L_0x0020:
        return r0;
    L_0x0021:
        r5 = r4.m28861b(r5);	 Catch:{  }
        r7.startActivityForResult(r5, r6);	 Catch:{  }
        r2 = r5.getComponent();
        r1 = com.google.common.base.Objects.equal(r1, r2);
        com.google.common.base.Preconditions.checkState(r1);
        goto L_0x0020;
    L_0x0034:
        r2 = 1;
        r2 = m28859a(r7, r5, r6, r2);	 Catch:{  }
        r7.startActivityForResult(r2, r6);	 Catch:{  }
        r2 = r5.getComponent();
        r1 = com.google.common.base.Objects.equal(r1, r2);
        com.google.common.base.Preconditions.checkState(r1);
        goto L_0x0020;
    L_0x0048:
        r0 = move-exception;
        r2 = r5.getComponent();
        r1 = com.google.common.base.Objects.equal(r1, r2);
        com.google.common.base.Preconditions.checkState(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.zero.ZeroAwareExternalIntentHandler.a(android.content.Intent, int, android.app.Activity):boolean");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean m28864a(android.content.Intent r5, int r6, android.support.v4.app.Fragment r7) {
        /*
        r4 = this;
        r0 = 1;
        r1 = r5.getComponent();
        r2 = com.facebook.zero.ZeroAwareExternalIntentHandler.C15391.f20266a;	 Catch:{ all -> 0x004c }
        r3 = r4.m28860a(r5);	 Catch:{ all -> 0x004c }
        r3 = r3.ordinal();	 Catch:{ all -> 0x004c }
        r2 = r2[r3];	 Catch:{ all -> 0x004c }
        switch(r2) {
            case 1: goto L_0x0021;
            case 2: goto L_0x0034;
            default: goto L_0x0014;
        };
    L_0x0014:
        r0 = r5.getComponent();
        r0 = com.google.common.base.Objects.equal(r1, r0);
        com.google.common.base.Preconditions.checkState(r0);
        r0 = 0;
    L_0x0020:
        return r0;
    L_0x0021:
        r5 = r4.m28861b(r5);	 Catch:{  }
        r7.a(r5, r6);	 Catch:{  }
        r2 = r5.getComponent();
        r1 = com.google.common.base.Objects.equal(r1, r2);
        com.google.common.base.Preconditions.checkState(r1);
        goto L_0x0020;
    L_0x0034:
        r2 = r7.getContext();	 Catch:{  }
        r3 = 1;
        r2 = m28859a(r2, r5, r6, r3);	 Catch:{  }
        r7.a(r2, r6);	 Catch:{  }
        r2 = r5.getComponent();
        r1 = com.google.common.base.Objects.equal(r1, r2);
        com.google.common.base.Preconditions.checkState(r1);
        goto L_0x0020;
    L_0x004c:
        r0 = move-exception;
        r2 = r5.getComponent();
        r1 = com.google.common.base.Objects.equal(r1, r2);
        com.google.common.base.Preconditions.checkState(r1);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.zero.ZeroAwareExternalIntentHandler.a(android.content.Intent, int, android.support.v4.app.Fragment):boolean");
    }

    @VisibleForTesting
    private HandleMode m28860a(Intent intent) {
        if (!((Boolean) this.f20269c.get()).booleanValue()) {
            return HandleMode.DONT_HANDLE;
        }
        for (ExternalIntentWhitelistItem a : this.f20270d) {
            TriState a2 = a.m8827a(intent);
            if (a2 == TriState.YES) {
                return HandleMode.DONT_HANDLE;
            }
            if (a2 == TriState.NO) {
                return HandleMode.HANDLE_BEHIND_DIALOG;
            }
        }
        if (intent.getComponent() != null && !BuildConstants.n().equals(intent.getComponent().getPackageName())) {
            return HandleMode.HANDLE_BEHIND_DIALOG;
        }
        if (intent.getData() != null && FacebookUriUtil.a(intent.getData())) {
            Uri b = FacebookUriUtil.b(intent.getData());
            if (!this.f20268b.b(b)) {
                return HandleMode.HANDLE_BEHIND_DIALOG;
            }
            b = this.f20268b.a(b);
            Uri data = intent.getData();
            Preconditions.checkArgument(FacebookUriUtil.a(data));
            intent.setData(FacebookUriUtil.a(data, "u", b.toString()));
            return HandleMode.HANDLE_AFTER_REWRITE;
        } else if (intent.getData() != null && intent.getComponent() == null && this.f20271e.a(ZeroFeatureKey.LEAVING_APP_INTERSTITIAL)) {
            return HandleMode.HANDLE_BEHIND_DIALOG;
        } else {
            if (intent.getData() == null || !this.f20268b.b(intent.getData())) {
                return HandleMode.HANDLE_BEHIND_DIALOG;
            }
            return HandleMode.HANDLE_AFTER_REWRITE;
        }
    }

    private Intent m28861b(Intent intent) {
        if (intent.getData() != null) {
            intent.setDataAndType(this.f20268b.a(intent.getData()), intent.getType());
        }
        return intent;
    }

    private static Intent m28859a(Context context, Intent intent, int i, boolean z) {
        Intent intent2 = new Intent();
        intent2.setClass(context, ZeroIntentInterstitialActivity.class);
        intent2.putExtra("destination_intent", intent);
        intent2.putExtra("request_code", i);
        intent2.putExtra("start_for_result", z);
        intent2.putExtra("zero_feature_key_string", ZeroFeatureKey.EXTERNAL_URLS_INTERSTITIAL.prefString);
        intent2.addFlags(intent.getFlags());
        intent2.addFlags(65536);
        return intent2;
    }
}
