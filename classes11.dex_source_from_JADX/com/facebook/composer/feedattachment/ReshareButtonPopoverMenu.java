package com.facebook.composer.feedattachment;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.facebook.attachments.angora.ReshareAttachmentView;
import com.facebook.composer.feedattachment.ShareComposerAttachmentController.C08251;
import com.facebook.fbui.popover.PopoverMenuWindow;

/* compiled from: got_eom */
public class ReshareButtonPopoverMenu extends PopoverMenuWindow {
    public final ReshareAttachmentView f6492l;
    public final C08251 f6493m;

    /* compiled from: got_eom */
    public class C08231 implements OnMenuItemClickListener {
        final /* synthetic */ ReshareButtonPopoverMenu f6490a;

        public C08231(ReshareButtonPopoverMenu reshareButtonPopoverMenu) {
            this.f6490a = reshareButtonPopoverMenu;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            this.f6490a.f6492l.e.setVisibility(0);
            this.f6490a.f6493m.m7925a(true);
            return true;
        }
    }

    /* compiled from: got_eom */
    public class C08242 implements OnMenuItemClickListener {
        final /* synthetic */ ReshareButtonPopoverMenu f6491a;

        public C08242(ReshareButtonPopoverMenu reshareButtonPopoverMenu) {
            this.f6491a = reshareButtonPopoverMenu;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            this.f6491a.f6492l.e.setVisibility(8);
            this.f6491a.f6493m.m7925a(false);
            return true;
        }
    }

    public ReshareButtonPopoverMenu(ReshareAttachmentView reshareAttachmentView, C08251 c08251) {
        super(reshareAttachmentView.getContext());
        this.f6492l = reshareAttachmentView;
        this.f6493m = c08251;
    }
}
