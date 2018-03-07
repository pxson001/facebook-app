package com.facebook.katana.app.module.common;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Parcelable;
import com.facebook.apptab.state.TabTag;
import com.facebook.base.activity.FragmentChromeActivity;
import com.facebook.base.activity.ReactFragmentActivity;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.process.ProcessName;
import com.facebook.feed.NewsFeedIntentUriBuilder;
import com.facebook.feed.annotations.OpenAppToFeedIntent;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.intent.internal.InternalIntentSigner;
import com.facebook.katana.activity.FbMainTabActivity;
import com.facebook.katana.activity.ImmersiveActivity;
import com.facebook.katana.activity.react.ImmersiveReactActivity;
import com.facebook.katana.annotations.ForUserAgentOptions;
import com.facebook.katana.net.Fb4aUserAgentOptionsProvider;
import com.facebook.widget.titlebar.TitleBarResourceId;
import javax.inject.Provider;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: send_zero_header_request */
public class CommonProcessModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @TitleBarResourceId
    public static Integer m9539a() {
        return Integer.valueOf(2130904257);
    }

    @ProviderMethod
    @OpenAppToFeedIntent
    @Singleton
    static Intent m9538a(Context context, Provider<ComponentName> provider, NewsFeedIntentUriBuilder newsFeedIntentUriBuilder, InternalIntentSigner internalIntentSigner) {
        Parcelable a = newsFeedIntentUriBuilder.a(context, FBLinks.bT);
        a.putExtra("target_tab_name", TabTag.Feed.name());
        Intent intent = new Intent();
        intent.putExtra("tabbar_target_intent", a);
        intent.setFlags(67108864);
        intent.setComponent((ComponentName) provider.get());
        internalIntentSigner.mo1178a(intent);
        return intent;
    }

    @ProviderMethod
    @ForUserAgentOptions
    public static String m9540a(Context context, ProcessName processName, ApplicationInfo applicationInfo) {
        return new Fb4aUserAgentOptionsProvider(processName, FbandroidProcessName.DASH.getProcessName(), applicationInfo, context).m9545a();
    }

    public static ComponentName m9543e(Context context) {
        return new ComponentName(context, FbMainTabActivity.class);
    }

    @ProviderMethod
    @FragmentChromeActivity
    static ComponentName m9541c(Context context) {
        return new ComponentName(context, ImmersiveActivity.class);
    }

    @ProviderMethod
    @ReactFragmentActivity
    static ComponentName m9542d(Context context) {
        return new ComponentName(context, ImmersiveReactActivity.class);
    }
}
