package com.facebook.video.player.plugins;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.graphql.model.GraphQLStorySet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.video.player.RichVideoPlayerParams;

/* compiled from: commerce_store_update */
class VolumeIconPlugin$1 implements OnClickListener {
    final /* synthetic */ RichVideoPlayerParams f19427a;
    final /* synthetic */ GraphQLStorySet f19428b;
    final /* synthetic */ VolumeIconPlugin f19429c;

    VolumeIconPlugin$1(VolumeIconPlugin volumeIconPlugin, RichVideoPlayerParams richVideoPlayerParams, GraphQLStorySet graphQLStorySet) {
        this.f19429c = volumeIconPlugin;
        this.f19427a = richVideoPlayerParams;
        this.f19428b = graphQLStorySet;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 327974251);
        VolumeIconPlugin.e(this.f19429c);
        VolumeIconPlugin.b(this.f19429c, this.f19427a);
        VolumeIconPlugin.a(this.f19429c, this.f19428b, 4);
        Logger.a(2, EntryType.UI_INPUT_END, -802061992, a);
    }
}
