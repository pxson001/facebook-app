package com.facebook.sounds.fb4a;

import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.sounds.SoundResourceStore;
import com.facebook.sounds.configurator.AudioConfigData;
import com.google.common.collect.Maps;
import java.util.Map;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: event_invitable_contacts */
public class Fb4aSoundsModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @Singleton
    static SoundResourceStore m23668a() {
        Map c = Maps.c();
        c.put("like_main", Integer.valueOf(2131165241));
        c.put("comment", Integer.valueOf(2131165199));
        c.put("share", Integer.valueOf(2131165312));
        c.put("like_comment", Integer.valueOf(2131165240));
        c.put("post_main", Integer.valueOf(2131165283));
        c.put("post_comment", Integer.valueOf(2131165282));
        c.put("pull_to_refresh_fast", Integer.valueOf(2131165284));
        c.put("pull_to_refresh_medium", Integer.valueOf(2131165285));
        c.put("pull_to_refresh_slow", Integer.valueOf(2131165286));
        c.put("collapse_after_refresh", Integer.valueOf(2131165196));
        c.put("live_comment", Integer.valueOf(2131165242));
        c.put("reactions_cancel", Integer.valueOf(2131165288));
        c.put("reactions_dock_appear", Integer.valueOf(2131165289));
        c.put("reactions_dock_away", Integer.valueOf(2131165290));
        c.put("reactions_dock_select_1", Integer.valueOf(2131165291));
        c.put("reactions_dock_select_2", Integer.valueOf(2131165292));
        c.put("reactions_dock_select_3", Integer.valueOf(2131165293));
        c.put("reactions_dock_select_4", Integer.valueOf(2131165294));
        c.put("reactions_dock_select_5", Integer.valueOf(2131165295));
        c.put("reactions_dock_select_6", Integer.valueOf(2131165296));
        c.put("reactions_like_down", Integer.valueOf(2131165297));
        c.put("reactions_like_up", Integer.valueOf(2131165298));
        return new SoundResourceStore(c);
    }

    @ProviderMethod
    @Singleton
    static AudioConfigData m23669b() {
        return new Fb4aAudioConfigData();
    }
}
