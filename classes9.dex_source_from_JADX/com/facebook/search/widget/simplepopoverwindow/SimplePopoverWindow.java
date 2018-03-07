package com.facebook.search.widget.simplepopoverwindow;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.fbui.popover.PopoverWindow;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: user_entered_pin */
public class SimplePopoverWindow extends PopoverWindow {
    public TextView f761a;
    public TextView f762l;

    /* compiled from: user_entered_pin */
    public class C00691 implements OnClickListener {
        final /* synthetic */ SimplePopoverWindow f760a;

        public C00691(SimplePopoverWindow simplePopoverWindow) {
            this.f760a = simplePopoverWindow;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1929706267);
            this.f760a.l();
            Logger.a(2, EntryType.UI_INPUT_END, -1400954017, a);
        }
    }

    public SimplePopoverWindow(Context context) {
        super(context);
        View inflate = LayoutInflater.from(getContext()).inflate(2130907007, null, false);
        d(inflate);
        this.f761a = (TextView) inflate.findViewById(2131558927);
        this.f762l = (TextView) inflate.findViewById(2131558966);
        inflate.findViewById(2131567295).setOnClickListener(new C00691(this));
    }
}
