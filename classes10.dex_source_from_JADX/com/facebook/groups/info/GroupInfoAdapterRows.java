package com.facebook.groups.info;

import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.GridLayout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.facebook.groups.info.view.GroupBasicInfoView;
import com.facebook.groups.staticadapter.StaticAdapter.InflatingViewType;
import com.facebook.groups.staticadapter.StaticAdapter.ViewType;
import com.facebook.groups.widget.groupeventrow.GroupEventRowView;
import com.facebook.groups.widget.infoview.InfoTitleRowView;
import com.facebook.groups.widget.preferenceview.GroupNotificationsSettingPreferenceView;
import com.facebook.widget.text.BetterTextView;
import com.google.common.collect.ImmutableList;

/* compiled from: ThreadItemView.updateTime */
public class GroupInfoAdapterRows {
    public static final ViewType<View> f22677a = new C32841();
    public static final ViewType<View> f22678b = new InflatingViewType(2130904663);
    public static final ViewType<View> f22679c = new InflatingViewType(2130904672);
    public static final ViewType<GridLayout> f22680d = new InflatingViewType(2130904670);
    public static final ViewType<View> f22681e = new InflatingViewType(2130904671);
    public static final ViewType<BetterTextView> f22682f = new InflatingViewType(2130904668);
    public static final ViewType<BetterTextView> f22683g = new InflatingViewType(2130904664);
    public static final ViewType<BetterTextView> f22684h = new InflatingViewType(2130904666);
    public static final ViewType<LinearLayout> f22685i = new InflatingViewType(2130904667);
    public static final ViewType<BetterTextView> f22686j = new InflatingViewType(2130904662);
    public static final ViewType<LinearLayout> f22687k = new C32852();
    public static final ViewType<View> f22688l = new C32863();
    public static final ViewType<GroupEventRowView> f22689m = new C32874();
    public static final ViewType<GroupNotificationsSettingPreferenceView> f22690n = new C32885();
    public static final ViewType<InfoTitleRowView> f22691o;
    public static final ImmutableList<ViewType<?>> f22692p;

    /* compiled from: ThreadItemView.updateTime */
    final class C32841 implements ViewType<View> {
        C32841() {
        }

        public final View mo12a(ViewGroup viewGroup) {
            return new GroupBasicInfoView(viewGroup.getContext());
        }
    }

    /* compiled from: ThreadItemView.updateTime */
    final class C32852 implements ViewType<LinearLayout> {
        C32852() {
        }

        public final View mo12a(ViewGroup viewGroup) {
            return new LinearLayout(viewGroup.getContext());
        }
    }

    /* compiled from: ThreadItemView.updateTime */
    final class C32863 implements ViewType<View> {
        C32863() {
        }

        public final View mo12a(ViewGroup viewGroup) {
            View linearLayout = new LinearLayout(viewGroup.getContext());
            linearLayout.setMinimumHeight(Math.round(viewGroup.getResources().getDimension(2131431927)));
            linearLayout.setBackgroundDrawable(new ColorDrawable(viewGroup.getResources().getColor(2131363505)));
            return linearLayout;
        }
    }

    /* compiled from: ThreadItemView.updateTime */
    final class C32874 implements ViewType<GroupEventRowView> {
        C32874() {
        }

        public final View mo12a(ViewGroup viewGroup) {
            return new GroupEventRowView(viewGroup.getContext());
        }
    }

    /* compiled from: ThreadItemView.updateTime */
    final class C32885 implements ViewType<GroupNotificationsSettingPreferenceView> {
        C32885() {
        }

        public final View mo12a(ViewGroup viewGroup) {
            return new GroupNotificationsSettingPreferenceView(viewGroup.getContext());
        }
    }

    /* compiled from: ThreadItemView.updateTime */
    final class C32896 implements ViewType<InfoTitleRowView> {
        C32896() {
        }

        public final View mo12a(ViewGroup viewGroup) {
            InfoTitleRowView infoTitleRowView = new InfoTitleRowView(viewGroup.getContext());
            infoTitleRowView.setPadding(0, Math.round(viewGroup.getResources().getDimension(2131434297)), 0, Math.round(viewGroup.getResources().getDimension(2131434297)));
            return infoTitleRowView;
        }
    }

    static {
        ViewType c32896 = new C32896();
        f22691o = c32896;
        f22692p = ImmutableList.of(c32896, f22688l, f22687k, f22690n, f22678b, f22679c, f22677a, f22689m, f22681e, f22682f, f22683g, f22684h, new ViewType[]{f22680d, f22685i, f22686j});
    }
}
