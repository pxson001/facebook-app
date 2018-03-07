package com.facebook.video.channelfeed.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.graphql.calls.EntryPointInputVideoChannelEntryPoint;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.video.analytics.VideoAnalytics.EventTriggerType;
import com.facebook.video.analytics.VideoAnalytics.PlayerOrigin;
import com.facebook.video.channelfeed.ChannelFeedHeaderParams;
import com.facebook.video.channelfeed.ChannelFeedInflater;
import com.facebook.video.channelfeed.ChannelFeedParams.Builder;
import com.facebook.video.channelfeed.ChannelFeedRootView;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: sub_id */
public class ChannelFeedActivity extends FbFragmentActivity {
    @Inject
    public ChannelFeedInflater f2711p;
    private ChannelFeedRootView f2712q;

    private static <T extends Context> void m2596a(Class<T> cls, T t) {
        m2597a((Object) t, (Context) t);
    }

    public static void m2597a(Object obj, Context context) {
        ((ChannelFeedActivity) obj).f2711p = ChannelFeedInflater.m2306a(FbInjector.get(context));
    }

    private void m2595a(ChannelFeedInflater channelFeedInflater) {
        this.f2711p = channelFeedInflater;
    }

    public static Intent m2592a(Context context, String str) {
        return m2593a(context, str, false);
    }

    public static Intent m2593a(Context context, String str, boolean z) {
        return m2594a(context, str, z, null, null, null);
    }

    public static Intent m2594a(Context context, String str, boolean z, String str2, String str3, String str4) {
        Intent intent = new Intent(context, ChannelFeedActivity.class);
        intent.putExtra("videoChannelId", str);
        intent.putExtra("disableCache", z);
        intent.putExtra("headerTitle", str2);
        intent.putExtra("headerSubtitle", str3);
        intent.putExtra("headerProfilePicUri", str4);
        return intent;
    }

    public final void m2599b(Bundle bundle) {
        super.b(bundle);
        Class cls = ChannelFeedActivity.class;
        m2597a((Object) this, (Context) this);
        this.f2712q = (ChannelFeedRootView) this.f2711p.m2307a((Activity) this);
        Builder builder = new Builder();
        builder.k = m2598i();
        builder = builder.a(getIntent().getStringExtra("videoChannelId"));
        builder.d = EntryPointInputVideoChannelEntryPoint.UNKNOWN;
        builder = builder;
        builder.g = PlayerOrigin.UNKNOWN;
        builder = builder;
        builder.h = EventTriggerType.BY_USER;
        builder = builder;
        builder.j = getIntent().getBooleanExtra("disableCache", false);
        this.f2712q.m2403a(builder.a());
    }

    @Nullable
    private ChannelFeedHeaderParams m2598i() {
        String stringExtra = getIntent().getStringExtra("headerProfilePicUri");
        String stringExtra2 = getIntent().getStringExtra("headerTitle");
        String stringExtra3 = getIntent().getStringExtra("headerSubtitle");
        if (stringExtra == null || stringExtra2 == null) {
            return null;
        }
        ChannelFeedHeaderParams.Builder builder = new ChannelFeedHeaderParams.Builder();
        builder.f2248b = stringExtra2;
        ChannelFeedHeaderParams.Builder builder2 = builder;
        builder2.f2249c = stringExtra3;
        builder2 = builder2;
        builder2.f2251e = stringExtra;
        return builder2.m2260a();
    }

    protected void onStart() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -1034067793);
        super.onStart();
        this.f2712q.m2406c();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 1980129910, a);
    }

    public void onResume() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 743362696);
        super.onResume();
        this.f2712q.m2407d();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 541871323, a);
    }

    public void onPause() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -630221461);
        super.onPause();
        this.f2712q.m2408e();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -1024832813, a);
    }

    public void onStop() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, 113637983);
        super.onStop();
        this.f2712q.m2409f();
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, -809907504, a);
    }

    public void onDestroy() {
        int a = Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_START, -1926598623);
        super.onDestroy();
        this.f2712q = null;
        if (this.f2711p != null) {
            this.f2711p.m2308a();
            this.f2711p = null;
        }
        Logger.a(2, EntryType.LIFECYCLE_ACTIVITY_END, 1025570558, a);
    }

    public void onBackPressed() {
        this.f2712q.m2405b();
        if (!this.f2712q.m2404a()) {
            super.onBackPressed();
            finish();
        }
    }
}
