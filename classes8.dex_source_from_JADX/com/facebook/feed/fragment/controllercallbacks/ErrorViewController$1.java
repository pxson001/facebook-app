package com.facebook.feed.fragment.controllercallbacks;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: group_request_to_join */
public class ErrorViewController$1 implements OnClickListener {
    final /* synthetic */ ErrorViewController f11880a;

    public ErrorViewController$1(ErrorViewController errorViewController) {
        this.f11880a = errorViewController;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -109784919);
        if (this.f11880a.a.d()) {
            this.f11880a.b.setVisibility(8);
            this.f11880a.e.au();
        } else {
            Toast.makeText(view.getContext(), view.getResources().getString(2131230763), 0).show();
        }
        LogUtils.a(-1237967667, a);
    }
}
