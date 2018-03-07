package com.facebook.feedplugins.links;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: optimistic_model */
class ThirdPartyNativeAttachmentPartDefinition$1 implements OnClickListener {
    final /* synthetic */ ThirdPartyNativeAttachmentPartDefinition$Props f6037a;
    final /* synthetic */ HasInvalidate f6038b;
    final /* synthetic */ ThirdPartyNativeAttachmentPartDefinition f6039c;

    ThirdPartyNativeAttachmentPartDefinition$1(ThirdPartyNativeAttachmentPartDefinition thirdPartyNativeAttachmentPartDefinition, ThirdPartyNativeAttachmentPartDefinition$Props thirdPartyNativeAttachmentPartDefinition$Props, HasInvalidate hasInvalidate) {
        this.f6039c = thirdPartyNativeAttachmentPartDefinition;
        this.f6037a = thirdPartyNativeAttachmentPartDefinition$Props;
        this.f6038b = hasInvalidate;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 602308695);
        this.f6039c.d.a(view, this.f6037a.f6032a, this.f6037a.f6036e, this.f6037a.f6034c, this.f6038b);
        Logger.a(2, EntryType.UI_INPUT_END, 833207293, a);
    }
}
