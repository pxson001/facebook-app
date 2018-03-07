package com.facebook.composer.feedattachment;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.attachments.angora.ReshareAttachmentView;
import com.facebook.composer.feedattachment.ReshareButtonPopoverMenu.C08231;
import com.facebook.composer.feedattachment.ReshareButtonPopoverMenu.C08242;
import com.facebook.composer.feedattachment.ShareComposerAttachmentController.C08251;
import com.facebook.fbui.menu.MenuItemImpl;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: got_error */
public class ReshareButtonListener implements OnClickListener {
    ReshareButtonPopoverMenu f6489a;

    public ReshareButtonListener(ReshareAttachmentView reshareAttachmentView, C08251 c08251) {
        this.f6489a = new ReshareButtonPopoverMenu(reshareAttachmentView, c08251);
        ReshareButtonPopoverMenu reshareButtonPopoverMenu = this.f6489a;
        if (reshareButtonPopoverMenu.c().getCount() == 0) {
            MenuItemImpl a = reshareButtonPopoverMenu.c().a(2131242384);
            a.setIcon(2130840052);
            a.setOnMenuItemClickListener(new C08231(reshareButtonPopoverMenu));
            a = reshareButtonPopoverMenu.c().a(2131242385);
            a.setIcon(2130839954);
            a.setOnMenuItemClickListener(new C08242(reshareButtonPopoverMenu));
        }
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 595735003);
        this.f6489a.a(view);
        Logger.a(2, EntryType.UI_INPUT_END, -2026897199, a);
    }
}
