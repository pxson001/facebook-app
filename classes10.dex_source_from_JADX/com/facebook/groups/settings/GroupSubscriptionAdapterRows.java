package com.facebook.groups.settings;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.groups.staticadapter.StaticAdapter.InflatingViewType;
import com.facebook.groups.staticadapter.StaticAdapter.ViewType;
import com.facebook.groups.widget.preferencecategoryheading.PreferenceCategoryHeadingView;
import com.facebook.groups.widget.preferenceview.CheckablePreferenceView;
import com.facebook.groups.widget.preferenceview.SwitchWithDescriptionView;
import com.facebook.widget.text.BetterTextView;
import com.google.common.collect.ImmutableList;

/* compiled from: THRIFT */
public class GroupSubscriptionAdapterRows {
    public static final ViewType<PreferenceCategoryHeadingView> f23155a = new C33431();
    public static final ViewType<CheckablePreferenceView> f23156b = new C33442();
    static final ViewType<BetterTextView> f23157c = new InflatingViewType(2130906522);
    public static final ViewType<SwitchWithDescriptionView> f23158d = new C33453();
    static final ViewType<View> f23159e = new InflatingViewType(2130904745);
    static final ImmutableList<ViewType<?>> f23160f = ImmutableList.of(f23155a, f23156b, f23157c, f23158d, f23159e);

    /* compiled from: THRIFT */
    final class C33431 implements ViewType<PreferenceCategoryHeadingView> {
        C33431() {
        }

        public final View mo12a(ViewGroup viewGroup) {
            return new PreferenceCategoryHeadingView(viewGroup.getContext());
        }
    }

    /* compiled from: THRIFT */
    final class C33442 implements ViewType<CheckablePreferenceView> {
        C33442() {
        }

        public final View mo12a(ViewGroup viewGroup) {
            return new CheckablePreferenceView(viewGroup.getContext());
        }
    }

    /* compiled from: THRIFT */
    final class C33453 implements ViewType<SwitchWithDescriptionView> {
        C33453() {
        }

        public final View mo12a(ViewGroup viewGroup) {
            return new SwitchWithDescriptionView(viewGroup.getContext());
        }
    }
}
