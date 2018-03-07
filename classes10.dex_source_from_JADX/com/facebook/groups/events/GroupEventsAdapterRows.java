package com.facebook.groups.events;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.groups.staticadapter.StaticAdapter.InflatingViewType;
import com.facebook.groups.staticadapter.StaticAdapter.ViewType;
import com.facebook.groups.widget.groupeventrow.GroupEventRowView;
import com.google.common.collect.ImmutableList;

/* compiled from: UPLOADING_FAILED_SHOW_RETRY */
public class GroupEventsAdapterRows {
    static final ViewType<GroupEventRowView> f21809a = new C31141();
    static final ViewType<GroupEventTimeStickyHeaderView> f21810b = new C31152();
    static final ViewType<View> f21811c = new InflatingViewType(2130904657);
    static final ImmutableList<ViewType<?>> f21812d = ImmutableList.of(f21809a, f21810b, f21811c);

    /* compiled from: UPLOADING_FAILED_SHOW_RETRY */
    final class C31141 implements ViewType<GroupEventRowView> {
        C31141() {
        }

        public final View mo12a(ViewGroup viewGroup) {
            return new GroupEventRowView(viewGroup.getContext());
        }
    }

    /* compiled from: UPLOADING_FAILED_SHOW_RETRY */
    final class C31152 implements ViewType<GroupEventTimeStickyHeaderView> {
        C31152() {
        }

        public final View mo12a(ViewGroup viewGroup) {
            return new GroupEventTimeStickyHeaderView(viewGroup.getContext());
        }
    }
}
