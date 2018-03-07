package com.facebook.tablet.sideshow.nux;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferences.Editor;
import com.facebook.tablet.sideshow.SideshowHost;
import com.facebook.tablet.sideshow.SideshowHost.HostInterfaceImpl;
import com.facebook.tablet.sideshow.SideshowUnit;
import com.facebook.tablet.sideshow.SideshowUnitWrapper;
import com.facebook.tablet.sideshow.loader.LoadResult;
import com.facebook.tablet.sideshow.loader.SideshowLoader.1;
import com.facebook.widget.text.BetterButton;

/* compiled from: onPlayerError */
public class NuxSideshowUnit implements SideshowUnit {
    public HostInterfaceImpl f4698a;
    public FbSharedPreferences f4699b;

    /* compiled from: onPlayerError */
    class C06391 implements OnClickListener {
        final /* synthetic */ NuxSideshowUnit f4697a;

        C06391(NuxSideshowUnit nuxSideshowUnit) {
            this.f4697a = nuxSideshowUnit;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1684102070);
            HostInterfaceImpl hostInterfaceImpl = this.f4697a.f4698a;
            SideshowHost sideshowHost = hostInterfaceImpl.b;
            SideshowUnitWrapper sideshowUnitWrapper = hostInterfaceImpl.a;
            sideshowHost.f.removeView(sideshowUnitWrapper.c);
            sideshowUnitWrapper.c();
            if (sideshowUnitWrapper.d == 3 || sideshowUnitWrapper.d == 1) {
                sideshowUnitWrapper.d = 4;
                sideshowUnitWrapper.a.c();
            }
            Editor edit = this.f4697a.f4699b.edit();
            edit.putBoolean(NuxSideshowUnitType.f4700a, true);
            edit.commit();
            Logger.a(2, EntryType.UI_INPUT_END, -1432368004, a);
        }
    }

    public NuxSideshowUnit(HostInterfaceImpl hostInterfaceImpl, FbSharedPreferences fbSharedPreferences) {
        this.f4698a = hostInterfaceImpl;
        this.f4699b = fbSharedPreferences;
    }

    public final View m5879a(Context context, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(2130907098, viewGroup);
        ((BetterButton) inflate.findViewById(2131567447)).setOnClickListener(new C06391(this));
        return inflate;
    }

    public final void m5880a() {
    }

    public final void m5882b() {
    }

    public final void m5883c() {
    }

    public final void m5881a(Context context, 1 1) {
        1.a(LoadResult.SUCCESS);
    }

    public final String m5884d() {
        return "nux";
    }
}
