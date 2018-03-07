package com.facebook.android.maps;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import java.util.LinkedList;
import java.util.Queue;

/* compiled from: away_toggle_expiration */
public class SupportMapFragment extends Fragment {
    private FacebookMapOptions f8253a;
    private MapView f8254b;
    private Queue<OnMapReadyCallback> f8255c;

    public static SupportMapFragment m14390a(FacebookMapOptions facebookMapOptions) {
        SupportMapFragment supportMapFragment = new SupportMapFragment();
        supportMapFragment.f8253a = facebookMapOptions;
        return supportMapFragment;
    }

    public final void m14394a(Context context, AttributeSet attributeSet, Bundle bundle) {
        super.a(context, attributeSet, bundle);
        this.f8253a = FacebookMapOptions.m14310a(context, attributeSet);
    }

    public final void m14395a(OnMapReadyCallback onMapReadyCallback) {
        if (this.f8254b != null) {
            this.f8254b.m14364a(onMapReadyCallback);
            return;
        }
        if (this.f8255c == null) {
            this.f8255c = new LinkedList();
        }
        this.f8255c.add(onMapReadyCallback);
    }

    public final View m14393a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1799527731);
        if (this.f8253a != null) {
            this.f8254b = new MapView(o(), this.f8253a);
        } else {
            this.f8254b = new MapView(o());
        }
        this.f8254b.setId(21377312);
        if (this.f8255c != null) {
            while (true) {
                OnMapReadyCallback onMapReadyCallback = (OnMapReadyCallback) this.f8255c.poll();
                if (onMapReadyCallback == null) {
                    break;
                }
                this.f8254b.m14364a(onMapReadyCallback);
            }
            this.f8255c = null;
        }
        this.f8254b.m14363a(bundle);
        View view = this.f8254b;
        LogUtils.f(1722592387, a);
        return view;
    }

    public final void m14391G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 814020616);
        super.G();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1598298614, a);
    }

    public final void m14392H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -75633605);
        super.H();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -701093541, a);
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1372935807);
        super.I();
        this.f8254b = null;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 638269169, a);
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.f8254b.m14366b();
    }
}
