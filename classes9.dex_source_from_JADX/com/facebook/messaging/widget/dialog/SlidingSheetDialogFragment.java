package com.facebook.messaging.widget.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Window;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.dialogs.FbDialogFragment;
import javax.annotation.Nullable;

/* compiled from: change_card */
public class SlidingSheetDialogFragment extends FbDialogFragment {
    public void m18364a(@Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 2003553143);
        super.a(bundle);
        a(2, 2131624609);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 592575010, a);
    }

    public final Dialog m18365c(Bundle bundle) {
        Dialog c = super.c(bundle);
        Window window = c.getWindow();
        window.setGravity(87);
        window.setLayout(-1, -2);
        return c;
    }
}
