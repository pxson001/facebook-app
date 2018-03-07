package com.facebook.ads.internal.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.facebook.ads.NativeAd.C18812;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

public class C2001o extends View {
    private C18812 f14384a;

    public C2001o(Context context, C18812 c18812) {
        super(context);
        this.f14384a = c18812;
        setLayoutParams(new LayoutParams(0, 0));
    }

    public void onWindowVisibilityChanged(int i) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1149342893);
        if (this.f14384a != null) {
            C18812 c18812 = this.f14384a;
            if (c18812.f13904a.f13933j != null) {
                c18812.f13904a.f13933j.mo711a(i);
            }
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 736485209, a);
    }
}
