package com.facebook.drawee.instrumentation;

import android.os.Bundle;
import com.facebook.drawee.view.DraweeView;
import com.facebook.fbui.viewdescriptionbuilder.ViewDescriptionBuilderSpec;

/* compiled from: fb4a_auto_update_notification_enabled */
public class DraweeViewDescriptionBuilderSpec implements ViewDescriptionBuilderSpec<DraweeView> {
    public final void m8445a(Object obj, Bundle bundle) {
        DraweeView draweeView = (DraweeView) obj;
        bundle.putString("drawee_view_info", String.valueOf(draweeView));
        bundle.putString("drawee_controller", String.valueOf(draweeView.getController()));
    }

    public final Class<DraweeView> m8444a() {
        return DraweeView.class;
    }
}
