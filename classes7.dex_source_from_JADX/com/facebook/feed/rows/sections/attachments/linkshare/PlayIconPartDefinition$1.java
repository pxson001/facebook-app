package com.facebook.feed.rows.sections.attachments.linkshare;

import android.view.View;
import com.facebook.attachments.angora.AttachmentHasPlayIcon;
import com.facebook.dialtone.common.DialtoneStateChangedListener;

/* compiled from: VideoHomeVisitMutation */
class PlayIconPartDefinition$1 implements DialtoneStateChangedListener {
    final /* synthetic */ View f20999a;
    final /* synthetic */ PlayIconPartDefinition f21000b;

    PlayIconPartDefinition$1(PlayIconPartDefinition playIconPartDefinition, View view) {
        this.f21000b = playIconPartDefinition;
        this.f20999a = view;
    }

    public final void iw_() {
    }

    public final void b_(boolean z) {
        ((AttachmentHasPlayIcon) this.f20999a).setCoverPhotoPlayIconVisibility(z ? 8 : 0);
    }
}
