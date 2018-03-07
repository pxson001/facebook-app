package com.facebook.groups.feed.ui;

import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.facebook.fbui.widget.megaphone.Megaphone;
import com.facebook.groups.staticadapter.StaticAdapter.InflatingViewType;
import com.facebook.groups.staticadapter.StaticAdapter.ViewType;
import com.facebook.megaphone.ui.QuickPromotionMegaphoneStoryView;
import com.facebook.uicontrib.contextitem.PlutoniumContextualItemView;
import com.google.common.collect.ImmutableList;

/* compiled from: ThreadViewMessagesFragment */
public class GroupsPlutoniumHeaderAdapterRows {
    static final ViewType<GroupsPlutoniumHeader> f22372a = new C32421();
    public static final ViewType<PlutoniumContextualItemView> f22373b = new C32432();
    static final ViewType<GroupsFeedYourPostBar> f22374c = new C32443();
    static final ViewType<GroupsFeedBrowseCategoriesBar> f22375d = new C32454();
    static final ViewType<GroupsFeedForSalePostsBar> f22376e = new C32465();
    static final ViewType<GroupsInlineComposer> f22377f = new C32476();
    static final ViewType<GroupsButtonSellComposer> f22378g = new C32487();
    static final ViewType<GroupsPlutoniumHeaderActionBar> f22379h = new C32498();
    static final ViewType<GroupsInMallGiantJoinButtonView> f22380i = new C32509();
    static final ViewType<GroupSuggestionCardView> f22381j = new ViewType<GroupSuggestionCardView>() {
        public final View mo12a(ViewGroup viewGroup) {
            return new GroupSuggestionCardView(viewGroup.getContext());
        }
    };
    static final InflatingViewType<View> f22382k = new InflatingViewType(2130904738);
    static final ViewType<Megaphone> f22383l = new ViewType<Megaphone>() {
        public final View mo12a(ViewGroup viewGroup) {
            return (Megaphone) LayoutInflater.from(viewGroup.getContext()).inflate(2130904675, viewGroup, false);
        }
    };
    static final ViewType<View> f22384m = new ViewType<View>() {
        public final View mo12a(ViewGroup viewGroup) {
            View linearLayout = new LinearLayout(viewGroup.getContext());
            linearLayout.setMinimumHeight(Math.round(viewGroup.getResources().getDimension(2131431927)));
            linearLayout.setBackgroundDrawable(new ColorDrawable(viewGroup.getResources().getColor(2131363505)));
            return linearLayout;
        }
    };
    static final ViewType<QuickPromotionMegaphoneStoryView> f22385n = new ViewType<QuickPromotionMegaphoneStoryView>() {
        public final View mo12a(ViewGroup viewGroup) {
            return new QuickPromotionMegaphoneStoryView(viewGroup.getContext());
        }
    };
    static final ImmutableList<ViewType<?>> f22386o = ImmutableList.of(f22372a, f22374c, f22375d, f22376e, f22377f, f22378g, f22379h, f22373b, f22382k, f22383l, f22385n, f22384m, new ViewType[]{f22380i, f22381j});

    /* compiled from: ThreadViewMessagesFragment */
    final class C32421 implements ViewType<GroupsPlutoniumHeader> {
        C32421() {
        }

        public final View mo12a(ViewGroup viewGroup) {
            return new GroupsPlutoniumHeader(viewGroup.getContext());
        }
    }

    /* compiled from: ThreadViewMessagesFragment */
    final class C32432 implements ViewType<PlutoniumContextualItemView> {
        C32432() {
        }

        public final View mo12a(ViewGroup viewGroup) {
            return new PlutoniumContextualItemView(viewGroup.getContext());
        }
    }

    /* compiled from: ThreadViewMessagesFragment */
    final class C32443 implements ViewType<GroupsFeedYourPostBar> {
        C32443() {
        }

        public final View mo12a(ViewGroup viewGroup) {
            return new GroupsFeedYourPostBar(viewGroup.getContext());
        }
    }

    /* compiled from: ThreadViewMessagesFragment */
    final class C32454 implements ViewType<GroupsFeedBrowseCategoriesBar> {
        C32454() {
        }

        public final View mo12a(ViewGroup viewGroup) {
            return new GroupsFeedBrowseCategoriesBar(viewGroup.getContext());
        }
    }

    /* compiled from: ThreadViewMessagesFragment */
    final class C32465 implements ViewType<GroupsFeedForSalePostsBar> {
        C32465() {
        }

        public final View mo12a(ViewGroup viewGroup) {
            return new GroupsFeedForSalePostsBar(viewGroup.getContext());
        }
    }

    /* compiled from: ThreadViewMessagesFragment */
    final class C32476 implements ViewType<GroupsInlineComposer> {
        C32476() {
        }

        public final View mo12a(ViewGroup viewGroup) {
            return new GroupsInlineComposer(viewGroup.getContext());
        }
    }

    /* compiled from: ThreadViewMessagesFragment */
    final class C32487 implements ViewType<GroupsButtonSellComposer> {
        C32487() {
        }

        public final View mo12a(ViewGroup viewGroup) {
            return new GroupsButtonSellComposer(viewGroup.getContext());
        }
    }

    /* compiled from: ThreadViewMessagesFragment */
    final class C32498 implements ViewType<GroupsPlutoniumHeaderActionBar> {
        C32498() {
        }

        public final View mo12a(ViewGroup viewGroup) {
            return new GroupsPlutoniumHeaderActionBar(viewGroup.getContext());
        }
    }

    /* compiled from: ThreadViewMessagesFragment */
    final class C32509 implements ViewType<GroupsInMallGiantJoinButtonView> {
        C32509() {
        }

        public final View mo12a(ViewGroup viewGroup) {
            return new GroupsInMallGiantJoinButtonView(viewGroup.getContext());
        }
    }
}
