package android.support.v4.app;

import android.view.View;
import android.view.ViewGroup;

/* compiled from: wakelock_details */
public class ViewGroupFragmentHost extends AbstractFragmentHost {
    private final ViewGroup f212a;

    public ViewGroupFragmentHost(ViewGroup viewGroup) {
        super(viewGroup.getContext());
        this.f212a = viewGroup;
    }

    public final View m220a(int i) {
        return this.f212a.findViewById(i);
    }

    public final boolean m221s() {
        return this.f212a != null;
    }
}
