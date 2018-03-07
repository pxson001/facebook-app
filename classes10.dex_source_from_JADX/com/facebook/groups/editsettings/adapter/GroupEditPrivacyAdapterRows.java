package com.facebook.groups.editsettings.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.groups.staticadapter.StaticAdapter.InflatingViewType;
import com.facebook.groups.staticadapter.StaticAdapter.ViewType;
import com.facebook.groups.widget.preferenceview.CheckablePreferenceView;
import com.google.common.collect.ImmutableList;

/* compiled from: Unexpected value for FriendListType */
public class GroupEditPrivacyAdapterRows {
    public static final ViewType<CheckablePreferenceView> f21551a = new C30711();
    static final ViewType<View> f21552b = new InflatingViewType(2130904687);
    public static final ViewType<TextView> f21553c;
    static final ImmutableList<ViewType<?>> f21554d;

    /* compiled from: Unexpected value for FriendListType */
    final class C30711 implements ViewType<CheckablePreferenceView> {
        C30711() {
        }

        public final View mo12a(ViewGroup viewGroup) {
            return new CheckablePreferenceView(viewGroup.getContext());
        }
    }

    static {
        ViewType inflatingViewType = new InflatingViewType(2130906391);
        f21553c = inflatingViewType;
        f21554d = ImmutableList.of(inflatingViewType, f21551a, f21552b);
    }
}
