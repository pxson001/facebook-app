package com.facebook.zero;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.content.InternalIntentHandler;
import com.facebook.zero.activity.ZeroIntentInterstitialActivity;
import com.facebook.zero.common.intent.InternalIntentBlacklistItem;
import com.facebook.zero.sdk.common.ZeroFeatureKey;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: fresco_impl */
public class ZeroAwareInternalIntentHandler implements InternalIntentHandler {
    private final Provider<Boolean> f23252a;
    private final ImmutableSet<InternalIntentBlacklistItem> f23253b;
    private final AbstractFbErrorReporter f23254c;

    @Inject
    public ZeroAwareInternalIntentHandler(Provider<Boolean> provider, Set<InternalIntentBlacklistItem> set, FbErrorReporter fbErrorReporter) {
        this.f23252a = provider;
        this.f23253b = ImmutableSet.copyOf((Collection) set);
        this.f23254c = fbErrorReporter;
    }

    public final boolean mo3407a(Intent intent, Context context) {
        if (!((Boolean) this.f23252a.get()).booleanValue()) {
            return false;
        }
        Iterator it = this.f23253b.iterator();
        while (it.hasNext()) {
            InternalIntentBlacklistItem internalIntentBlacklistItem = (InternalIntentBlacklistItem) it.next();
            if (internalIntentBlacklistItem.mo3410a(intent)) {
                ZeroFeatureKey a = internalIntentBlacklistItem.mo3409a();
                if (!(context instanceof Activity)) {
                    this.f23254c.m2340a(ZeroAwareInternalIntentHandler.class.getName(), "blacklistItem: " + internalIntentBlacklistItem.toString() + ", context: " + context.toString() + ", intent: " + intent.toString());
                    intent.setFlags(268435456);
                }
                context.startActivity(m31365a(context, intent, a, 0, false));
                return true;
            }
        }
        return false;
    }

    public final boolean mo3405a(Intent intent, int i, Activity activity) {
        if (!((Boolean) this.f23252a.get()).booleanValue()) {
            return false;
        }
        Iterator it = this.f23253b.iterator();
        while (it.hasNext()) {
            InternalIntentBlacklistItem internalIntentBlacklistItem = (InternalIntentBlacklistItem) it.next();
            if (internalIntentBlacklistItem.mo3410a(intent)) {
                activity.startActivityForResult(m31365a(activity, intent, internalIntentBlacklistItem.mo3409a(), 0, true), i);
                return true;
            }
        }
        return false;
    }

    public final boolean mo3406a(Intent intent, int i, Fragment fragment) {
        if (!((Boolean) this.f23252a.get()).booleanValue()) {
            return false;
        }
        Iterator it = this.f23253b.iterator();
        while (it.hasNext()) {
            InternalIntentBlacklistItem internalIntentBlacklistItem = (InternalIntentBlacklistItem) it.next();
            if (internalIntentBlacklistItem.mo3410a(intent)) {
                fragment.m248a(m31365a(fragment.getContext(), intent, internalIntentBlacklistItem.mo3409a(), 0, true), i);
                return true;
            }
        }
        return false;
    }

    @Nullable
    public final ComponentName mo3408b(Intent intent, Context context) {
        return null;
    }

    private static Intent m31365a(Context context, Intent intent, ZeroFeatureKey zeroFeatureKey, int i, boolean z) {
        Intent intent2 = new Intent();
        intent2.setClass(context, ZeroIntentInterstitialActivity.class);
        intent2.putExtra("destination_intent", intent);
        intent2.putExtra("request_code", i);
        intent2.putExtra("start_for_result", z);
        Preconditions.checkNotNull(intent.getComponent());
        Preconditions.checkNotNull(intent.getComponent().getClassName());
        intent2.putExtra("zero_feature_key_string", zeroFeatureKey.prefString);
        intent2.addFlags(65536);
        if (!(context instanceof Activity)) {
            intent2.addFlags(268435456);
        }
        return intent2;
    }
}
