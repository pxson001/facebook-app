package com.facebook.feedplugins.attachments.multimedia;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.feed.collage.ui.CollageAttachmentView;
import com.facebook.feedplugins.attachments.multimedia.ui.MultimediaSinglePlayerAttachmentView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: group/members/search/{%s} */
class MultimediaSinglePlayerAttachmentPartDefinition$2 implements OnClickListener {
    final /* synthetic */ MultimediaSinglePlayerAttachmentPartDefinition$State f11992a;
    final /* synthetic */ MultimediaSinglePlayerAttachmentPartDefinition f11993b;

    MultimediaSinglePlayerAttachmentPartDefinition$2(MultimediaSinglePlayerAttachmentPartDefinition multimediaSinglePlayerAttachmentPartDefinition, MultimediaSinglePlayerAttachmentPartDefinition$State multimediaSinglePlayerAttachmentPartDefinition$State) {
        this.f11993b = multimediaSinglePlayerAttachmentPartDefinition;
        this.f11992a = multimediaSinglePlayerAttachmentPartDefinition$State;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -599275166);
        ((CollageAttachmentView) ((MultimediaSinglePlayerAttachmentView) view.getParent()).findViewById(2131564005)).a(this.f11992a.f11994a);
        Logger.a(2, EntryType.UI_INPUT_END, -89585237, a);
    }
}
