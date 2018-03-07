package com.facebook.groups.editsettings.adapter;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.facebook.groups.staticadapter.StaticAdapter.InflatingViewType;
import com.facebook.groups.staticadapter.StaticAdapter.ViewType;
import com.facebook.groups.widget.preferenceview.CheckablePreferenceView;
import com.facebook.groups.widget.preferenceview.GeneralPreferenceView;
import com.facebook.groups.widget.preferenceview.SwitchPreferenceView;
import com.facebook.groups.widget.preferenceview.SwitchWithDescriptionView;
import com.facebook.widget.text.BetterTextView;
import com.google.common.collect.ImmutableList;

/* compiled from: Unexpected request code received  */
public class GroupEditSettingsAdapterRows {
    public static final ViewType<BetterTextView> f21609a = new InflatingViewType(2130903957);
    public static final ViewType<SwitchPreferenceView> f21610b = new C30841();
    public static final ViewType<SwitchWithDescriptionView> f21611c = new C30852();
    public static final ViewType<CheckablePreferenceView> f21612d = new C30863();
    public static final ViewType<GeneralPreferenceView> f21613e = new C30874();
    public static final ViewType<LinearLayout> f21614f = new InflatingViewType(2130904688);
    public static final ViewType<LinearLayout> f21615g = new InflatingViewType(2130904690);
    public static final ViewType<View> f21616h = new C30885();
    public static final ImmutableList<ViewType<?>> f21617i = ImmutableList.of(f21612d, f21613e, f21615g, f21614f, f21609a, f21610b, f21611c, f21616h);

    /* compiled from: Unexpected request code received  */
    final class C30841 implements ViewType<SwitchPreferenceView> {
        C30841() {
        }

        public final View mo12a(ViewGroup viewGroup) {
            SwitchPreferenceView switchPreferenceView = new SwitchPreferenceView(viewGroup.getContext());
            switchPreferenceView.setDelegate(null);
            return switchPreferenceView;
        }
    }

    /* compiled from: Unexpected request code received  */
    final class C30852 implements ViewType<SwitchWithDescriptionView> {
        C30852() {
        }

        public final View mo12a(ViewGroup viewGroup) {
            SwitchWithDescriptionView switchWithDescriptionView = new SwitchWithDescriptionView(viewGroup.getContext());
            switchWithDescriptionView.setDelegate(null);
            return switchWithDescriptionView;
        }
    }

    /* compiled from: Unexpected request code received  */
    final class C30863 implements ViewType<CheckablePreferenceView> {
        C30863() {
        }

        public final View mo12a(ViewGroup viewGroup) {
            return new CheckablePreferenceView(viewGroup.getContext());
        }
    }

    /* compiled from: Unexpected request code received  */
    final class C30874 implements ViewType<GeneralPreferenceView> {
        C30874() {
        }

        public final View mo12a(ViewGroup viewGroup) {
            return new GeneralPreferenceView(viewGroup.getContext());
        }
    }

    /* compiled from: Unexpected request code received  */
    final class C30885 implements ViewType<View> {
        C30885() {
        }

        public final View mo12a(ViewGroup viewGroup) {
            View linearLayout = new LinearLayout(viewGroup.getContext());
            linearLayout.setMinimumHeight(Math.round(viewGroup.getResources().getDimension(2131431927)));
            linearLayout.setBackgroundDrawable(new ColorDrawable(viewGroup.getResources().getColor(2131363505)));
            return linearLayout;
        }
    }
}
