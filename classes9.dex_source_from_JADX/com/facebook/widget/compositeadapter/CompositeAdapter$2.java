package com.facebook.widget.compositeadapter;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.google.common.base.Preconditions;

/* compiled from: shipment_tracking_id */
class CompositeAdapter$2 implements OnLongClickListener {
    final /* synthetic */ CompositeAdapter f3528a;

    CompositeAdapter$2(CompositeAdapter compositeAdapter) {
        this.f3528a = compositeAdapter;
    }

    public boolean onLongClick(View view) {
        Preconditions.checkNotNull(view.getTag(2131558779));
        return true;
    }
}
