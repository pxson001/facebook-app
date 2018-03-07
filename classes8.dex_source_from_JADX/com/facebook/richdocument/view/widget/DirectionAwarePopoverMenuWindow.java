package com.facebook.richdocument.view.widget;

import android.content.Context;
import com.facebook.fbui.popover.PopoverListView;
import com.facebook.fbui.popover.PopoverMenuWindow;
import com.facebook.richdocument.view.util.RichDocumentLayoutDirection;

/* compiled from: open_map_tap */
public class DirectionAwarePopoverMenuWindow extends PopoverMenuWindow {
    private RichDocumentLayoutDirection f7161l;

    public DirectionAwarePopoverMenuWindow(RichDocumentLayoutDirection richDocumentLayoutDirection, Context context) {
        super(context);
        this.f7161l = richDocumentLayoutDirection;
    }

    protected final PopoverListView m7437b() {
        PopoverListView b = super.b();
        if (RichDocumentLayoutDirection.m7368c()) {
            if (this.f7161l.m7370b()) {
                b.setLayoutDirection(1);
            } else {
                b.setLayoutDirection(0);
            }
        }
        return b;
    }
}
