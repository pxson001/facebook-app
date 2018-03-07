package com.facebook.widget.compositeadapter;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.base.Preconditions;

/* compiled from: shipment_tracking_id */
class CompositeAdapter$1 implements OnClickListener {
    final /* synthetic */ CompositeAdapter f3527a;

    CompositeAdapter$1(CompositeAdapter compositeAdapter) {
        this.f3527a = compositeAdapter;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -966342983);
        this.f3527a.b.a(this.f3527a.a, Preconditions.checkNotNull(view.getTag(2131558779)));
        Logger.a(2, EntryType.UI_INPUT_END, -69190228, a);
    }
}
