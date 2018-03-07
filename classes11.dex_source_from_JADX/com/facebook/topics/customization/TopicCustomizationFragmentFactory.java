package com.facebook.topics.customization;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.facebook.common.fragmentfactory.IFragmentFactory;
import com.facebook.fbreact.fragment.ImmersiveReactFragment;
import com.facebook.fbreact.fragment.ImmersiveReactFragment.Builder;

/* compiled from: Ljava/lang/Comparable */
public class TopicCustomizationFragmentFactory implements IFragmentFactory {
    public final Fragment m15113a(Intent intent) {
        Bundle bundle = new Bundle();
        String string = intent.getExtras().getString("topic_id");
        String string2 = intent.getExtras().getString("topic_name");
        boolean z = intent.getExtras().getBoolean("topic_searchable");
        bundle.putString("topicId", string);
        bundle.putString("topicName", string2);
        bundle.putBoolean("searchable", z);
        Builder newBuilder = ImmersiveReactFragment.newBuilder();
        newBuilder.a = "/topic_feeds_customization";
        newBuilder = newBuilder;
        newBuilder.b = "TopicCustomizationRoute";
        newBuilder = newBuilder;
        newBuilder.f = bundle;
        Builder builder = newBuilder;
        builder.g = "topic_feeds_customization";
        return builder.b();
    }
}
