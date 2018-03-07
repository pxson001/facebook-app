package com.facebook.composer.minutiae.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.composer.minutiae.MinutiaeTaggableVerbFragment;
import com.facebook.composer.minutiae.protocol.MinutiaeVerbModelEdge;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: testID */
public class MinutiaeTaggableVerbViewController {

    /* compiled from: testID */
    public class C01941 implements OnClickListener {
        final /* synthetic */ MinutiaeTaggableVerbFragment f1890a;
        final /* synthetic */ MinutiaeVerbModelEdge f1891b;
        final /* synthetic */ MinutiaeTaggableVerbViewController f1892c;

        public C01941(MinutiaeTaggableVerbViewController minutiaeTaggableVerbViewController, MinutiaeTaggableVerbFragment minutiaeTaggableVerbFragment, MinutiaeVerbModelEdge minutiaeVerbModelEdge) {
            this.f1892c = minutiaeTaggableVerbViewController;
            this.f1890a = minutiaeTaggableVerbFragment;
            this.f1891b = minutiaeVerbModelEdge;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 635845986);
            if (this.f1890a != null) {
                MinutiaeTaggableVerbFragment minutiaeTaggableVerbFragment = this.f1890a;
                MinutiaeVerbModelEdge minutiaeVerbModelEdge = this.f1891b;
                minutiaeTaggableVerbFragment.al.m1658a();
                minutiaeTaggableVerbFragment.f1443h.m1541a(minutiaeTaggableVerbFragment.ax.f1835a, minutiaeVerbModelEdge, minutiaeTaggableVerbFragment.aw.indexOf(minutiaeVerbModelEdge), minutiaeTaggableVerbFragment.aw.size(), String.valueOf(minutiaeTaggableVerbFragment.f1437b.f1732r));
                if (minutiaeTaggableVerbFragment.aA != null) {
                    minutiaeTaggableVerbFragment.aA.mo63a(minutiaeVerbModelEdge.f1703a);
                }
            }
            Logger.a(2, EntryType.UI_INPUT_END, 30837671, a);
        }
    }
}
