package com.facebook.feed.goodfriends.composer;

import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.intent.JsonPluginConfigSerializer;
import javax.inject.Inject;

/* compiled from: network_info_network_changed */
public class GoodFriendsComposerPluginHelper {
    public final JsonPluginConfigSerializer f12552a;

    public static GoodFriendsComposerPluginHelper m18627a(InjectorLike injectorLike) {
        return new GoodFriendsComposerPluginHelper(JsonPluginConfigSerializer.m18629b(injectorLike));
    }

    @Inject
    public GoodFriendsComposerPluginHelper(JsonPluginConfigSerializer jsonPluginConfigSerializer) {
        this.f12552a = jsonPluginConfigSerializer;
    }
}
