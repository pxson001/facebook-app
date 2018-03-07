package com.facebook.video.player.plugins;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.graphql.model.GraphQLStorySet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.video.player.RichVideoPlayerParams;

/* compiled from: commerce_store_update */
class VolumeIconPlugin$2 implements OnClickListener {
    final /* synthetic */ RichVideoPlayerParams f19430a;
    final /* synthetic */ GraphQLStorySet f19431b;
    final /* synthetic */ VolumeIconPlugin f19432c;

    VolumeIconPlugin$2(VolumeIconPlugin volumeIconPlugin, RichVideoPlayerParams richVideoPlayerParams, GraphQLStorySet graphQLStorySet) {
        this.f19432c = volumeIconPlugin;
        this.f19430a = richVideoPlayerParams;
        this.f19431b = graphQLStorySet;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 192484234);
        VolumeIconPlugin.e(this.f19432c);
        VolumeIconPlugin.c(this.f19432c, this.f19430a);
        VolumeIconPlugin.a(this.f19432c, this.f19431b, 5);
        Logger.a(2, EntryType.UI_INPUT_END, -901427643, a);
    }
}
