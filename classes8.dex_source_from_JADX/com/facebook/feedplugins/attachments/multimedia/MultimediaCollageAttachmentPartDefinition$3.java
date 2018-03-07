package com.facebook.feedplugins.attachments.multimedia;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.feed.collage.ui.CollageAttachmentView;
import com.facebook.feedplugins.attachments.multimedia.ui.MultimediaAttachmentView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: group_add_admin */
class MultimediaCollageAttachmentPartDefinition$3 implements OnClickListener {
    final /* synthetic */ MultimediaCollageAttachmentPartDefinition$State f11989a;
    final /* synthetic */ MultimediaCollageAttachmentPartDefinition f11990b;

    MultimediaCollageAttachmentPartDefinition$3(MultimediaCollageAttachmentPartDefinition multimediaCollageAttachmentPartDefinition, MultimediaCollageAttachmentPartDefinition$State multimediaCollageAttachmentPartDefinition$State) {
        this.f11990b = multimediaCollageAttachmentPartDefinition;
        this.f11989a = multimediaCollageAttachmentPartDefinition$State;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1779844641);
        ((CollageAttachmentView) ((MultimediaAttachmentView) view.getParent()).findViewById(2131564005)).a(this.f11989a.f11991a);
        Logger.a(2, EntryType.UI_INPUT_END, 2063866481, a);
    }
}
