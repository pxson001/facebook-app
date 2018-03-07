package com.facebook.feedplugins.video.components;

import android.content.Context;
import android.view.View;
import com.facebook.components.fallback.FallbackViewCreator;
import com.facebook.feedplugins.video.RichVideoAttachmentView;

/* compiled from: font_family */
class RichVideoRowComponentPartDefinition$1 extends FallbackViewCreator<RichVideoAttachmentView> {
    final /* synthetic */ RichVideoRowComponentPartDefinition f13108a;

    RichVideoRowComponentPartDefinition$1(RichVideoRowComponentPartDefinition richVideoRowComponentPartDefinition) {
        this.f13108a = richVideoRowComponentPartDefinition;
    }

    public final View m14772a(Context context) {
        return (RichVideoAttachmentView) this.f13108a.c.a().a(context);
    }
}
