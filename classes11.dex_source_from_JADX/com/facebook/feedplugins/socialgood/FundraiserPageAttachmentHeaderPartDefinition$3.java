package com.facebook.feedplugins.socialgood;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.content.SecureContextHelper;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: bridgeStartupType */
class FundraiserPageAttachmentHeaderPartDefinition$3 implements OnClickListener {
    final /* synthetic */ HasPositionInformation f9454a;
    final /* synthetic */ String f9455b;
    final /* synthetic */ FundraiserPageAttachmentHeaderPartDefinition f9456c;

    FundraiserPageAttachmentHeaderPartDefinition$3(FundraiserPageAttachmentHeaderPartDefinition fundraiserPageAttachmentHeaderPartDefinition, HasPositionInformation hasPositionInformation, String str) {
        this.f9456c = fundraiserPageAttachmentHeaderPartDefinition;
        this.f9454a = hasPositionInformation;
        this.f9455b = str;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 435165180);
        ((SecureContextHelper) this.f9456c.i.get()).a(((IFeedIntentBuilder) this.f9456c.j.get()).b(((HasContext) this.f9454a).getContext(), this.f9455b), ((HasContext) this.f9454a).getContext());
        Logger.a(2, EntryType.UI_INPUT_END, -1455190441, a);
    }
}
