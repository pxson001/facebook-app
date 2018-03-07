package com.facebook.fbreact.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.fbreact.fragment.ImmersiveReactFragment.Builder;

/* compiled from: staging_ground_tap_make_temporary */
public class ImmersiveReactFragmentFactory implements IFragmentFactory {
    public final Fragment m4187a(Intent intent) {
        Bundle extras = intent.getExtras();
        String string = extras.getString("uri");
        String string2 = extras.getString("route_name");
        String string3 = extras.getString("module_name");
        Bundle bundle = extras.getBundle("init_props");
        int i = extras.getInt("title_res");
        boolean z = extras.getBoolean("show_search");
        int i2 = extras.getInt("button_res");
        String string4 = extras.getString("button_event");
        int i3 = extras.getInt("requested_orientation", -1);
        if (string != null) {
            Builder newBuilder = ImmersiveReactFragment.newBuilder();
            newBuilder.f3466a = string;
            Builder builder = newBuilder;
            builder.f3467b = string2;
            builder = builder;
            builder.f3469d = i;
            builder = builder;
            builder.f3470e = z;
            builder = builder;
            builder.f3473h = i3;
            Builder builder2 = builder;
            builder2.f3471f = bundle;
            builder2 = builder2;
            builder2.f3474i = string4;
            builder2 = builder2;
            builder2.f3475j = i2;
            return builder2.m4169b();
        }
        builder = ImmersiveReactFragment.newBuilder();
        builder.f3468c = string3;
        builder = builder;
        builder.f3469d = i;
        builder = builder;
        builder.f3470e = z;
        builder = builder;
        builder.f3473h = i3;
        builder2 = builder;
        builder2.f3474i = string4;
        builder2 = builder2;
        builder2.f3475j = i2;
        builder2 = builder2;
        builder2.f3471f = bundle;
        return builder2.m4169b();
    }
}
