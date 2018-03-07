package com.facebook.search.titlebar;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.search.titlebar.GraphSearchTitleSearchBox.1;
import com.facebook.search.titlebar.GraphSearchTitleSearchBox.OnClearClickedListener;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: }& */
class GraphSearchTitleSearchBox$1$1 implements OnClickListener {
    final /* synthetic */ 1 f410a;

    GraphSearchTitleSearchBox$1$1(1 1) {
        this.f410a = 1;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -24318959);
        for (OnClearClickedListener aq : this.f410a.a.d) {
            aq.aq();
        }
        this.f410a.a.e.a();
        this.f410a.a.e.b();
        LogUtils.a(-765779154, a);
    }
}
