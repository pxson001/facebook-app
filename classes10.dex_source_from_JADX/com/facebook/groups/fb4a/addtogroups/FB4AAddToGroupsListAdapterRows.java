package com.facebook.groups.fb4a.addtogroups;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.facebook.groups.staticadapter.StaticAdapter.InflatingViewType;
import com.facebook.groups.staticadapter.StaticAdapter.ViewType;
import com.google.common.collect.ImmutableList;

/* compiled from: write_privacy_setting_progress */
public class FB4AAddToGroupsListAdapterRows {
    static final ViewType<View> f282a = new C00541();
    public static final ViewType<FrameLayout> f283b = new InflatingViewType(2130905108);
    public static final ViewType<LinearLayout> f284c = new InflatingViewType(2130904698);
    public static final ViewType<FrameLayout> f285d = new InflatingViewType(2130903170);
    static final ImmutableList<ViewType<?>> f286e = ImmutableList.of(f282a, f283b, f284c, f285d);

    /* compiled from: write_privacy_setting_progress */
    final class C00541 implements ViewType<View> {
        C00541() {
        }

        public final View mo12a(ViewGroup viewGroup) {
            View linearLayout = new LinearLayout(viewGroup.getContext());
            linearLayout.setMinimumHeight(viewGroup.getResources().getDimensionPixelSize(2131431930));
            return linearLayout;
        }
    }
}
