package com.facebook.richdocument.view.widget.media.plugins;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.FbInjector;
import com.facebook.richdocument.view.transition.state.MediaStateMachine.Event;
import com.facebook.richdocument.view.widget.media.MediaFrame;
import javax.inject.Inject;

/* compiled from: num_page_profiles */
public class ExternalClickPlugin extends BaseMediaFramePlugin<Void> {
    @Inject
    public SecureContextHelper f7628a;
    public Uri f7629b;

    public static void m7908a(Object obj, Context context) {
        ((ExternalClickPlugin) obj).f7628a = (SecureContextHelper) DefaultSecureContextHelper.a(FbInjector.get(context));
    }

    public ExternalClickPlugin(MediaFrame mediaFrame) {
        super(mediaFrame);
        Class cls = ExternalClickPlugin.class;
        m7908a(this, getContext());
    }

    public final void mo508c() {
        super.mo508c();
        this.f7629b = null;
    }

    public final boolean mo447a(Event event) {
        if (event == Event.CLICK_MEDIA) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(this.f7629b);
            this.f7628a.b(intent, getContext());
        }
        return super.mo447a(event);
    }

    public final boolean mo507b() {
        return this.f7629b != null;
    }
}
