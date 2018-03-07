package com.facebook.vault.momentsupsell.ui;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.fbui.popover.PopoverWindow;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: thread_list_ids */
public class MomentsAppPopoverWindow {
    public Context f1808a;
    public PopoverWindow f1809b;

    /* compiled from: thread_list_ids */
    public class C01741 implements OnClickListener {
        final /* synthetic */ MomentsAppPopoverWindow f1807a;

        public C01741(MomentsAppPopoverWindow momentsAppPopoverWindow) {
            this.f1807a = momentsAppPopoverWindow;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 121575879);
            this.f1807a.f1809b.l();
            Logger.a(2, EntryType.UI_INPUT_END, 697269819, a);
        }
    }

    public MomentsAppPopoverWindow(Context context) {
        this.f1808a = context;
        this.f1809b = new PopoverWindow(context);
    }
}
