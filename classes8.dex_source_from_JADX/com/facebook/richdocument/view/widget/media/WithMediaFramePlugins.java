package com.facebook.richdocument.view.widget.media;

import com.facebook.richdocument.view.widget.media.plugins.MediaFramePlugin;
import java.util.Collection;

/* compiled from: offer_claim_enable_notifications */
public interface WithMediaFramePlugins {
    <T extends MediaFramePlugin> void mo492a(T t);

    void mo493a(MediaFramePlugin mediaFramePlugin, Object obj);

    <T extends MediaFramePlugin> boolean mo494a(Class<T> cls);

    <T extends MediaFramePlugin> T mo495b(Class<T> cls);

    <T extends MediaFramePlugin> void mo497c(Class<T> cls);

    Collection<MediaFramePlugin> getPlugins();
}
