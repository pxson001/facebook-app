package com.facebook.feedplugins.hpp.ui;

import android.content.Context;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.LinearLayout;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.SizeUtil;
import com.facebook.common.util.Tuple;
import com.facebook.entitycards.contextitems.ui.ContextItemsUiUtil;
import com.facebook.fbui.widget.layout.SegmentedLinearLayout;
import com.facebook.graphql.enums.GraphQLEntityCardContextItemType;
import com.facebook.graphql.model.GraphQLEntityCardContextItem;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.RecyclableView;
import com.facebook.widget.pageritemwrapper.PagerItemWrapperLayout;
import com.facebook.widget.text.BetterTextView;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: current_page_id */
public class MobilePageAdminPanelBodyView extends PagerItemWrapperLayout implements RecyclableView {
    private static final CallerContext f7808a = CallerContext.a(MobilePageAdminPanelBodyView.class, "pages_public_view", "hpp_body");
    private boolean f7809b;
    public MobilePageAdminPanelBodyCoverHeaderView f7810c = ((MobilePageAdminPanelBodyCoverHeaderView) c(2131562953));
    public SegmentedLinearLayout f7811d = ((SegmentedLinearLayout) c(2131562954));

    /* compiled from: current_page_id */
    public /* synthetic */ class C09891 {
        public static final /* synthetic */ int[] f7807a = new int[GraphQLEntityCardContextItemType.values().length];

        static {
            try {
                f7807a[GraphQLEntityCardContextItemType.ADMIN_MESSAGE_ACTIVE_TROPHY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f7807a[GraphQLEntityCardContextItemType.PAGE_MESSAGE_RESPONSE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public MobilePageAdminPanelBodyView(Context context) {
        super(context);
        setContentView(2130904805);
    }

    public void setHeaderOnClickListener(OnClickListener onClickListener) {
        this.f7810c.setOnClickListener(onClickListener);
    }

    public final void m8973a(@Nullable List<Tuple<GraphQLEntityCardContextItem, OnClickListener>> list, boolean z) {
        this.f7811d.removeAllViews();
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                boolean z2;
                SegmentedLinearLayout segmentedLinearLayout = this.f7811d;
                GraphQLEntityCardContextItem graphQLEntityCardContextItem = (GraphQLEntityCardContextItem) ((Tuple) list.get(i)).a;
                OnClickListener onClickListener = (OnClickListener) ((Tuple) list.get(i)).b;
                if (i == list.size() - 1 && z) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                segmentedLinearLayout.addView(m8971a(graphQLEntityCardContextItem, onClickListener, z2));
            }
        }
    }

    public final void m8972a(String str, String str2, OnClickListener onClickListener) {
        ViewStub viewStub = (ViewStub) findViewById(2131562955);
        if (viewStub != null) {
            viewStub.inflate();
        }
        ((BetterTextView) findViewById(2131562944)).setText(str2);
        ((FbTextView) findViewById(2131562946)).setText(str);
        ((LinearLayout) findViewById(2131562945)).setOnClickListener(onClickListener);
    }

    private MobilePageAdminPanelBodyContextRowsItemView m8971a(GraphQLEntityCardContextItem graphQLEntityCardContextItem, OnClickListener onClickListener, boolean z) {
        MobilePageAdminPanelBodyContextRowsItemView mobilePageAdminPanelBodyContextRowsItemView = new MobilePageAdminPanelBodyContextRowsItemView(getContext());
        if (graphQLEntityCardContextItem != null) {
            Context context = getContext();
            int c = SizeUtil.c(context.getResources(), 2131427402);
            if (graphQLEntityCardContextItem.o() != null) {
                switch (C09891.f7807a[graphQLEntityCardContextItem.l().ordinal()]) {
                    case 1:
                    case 2:
                        int color = context.getResources().getColor(2131361938);
                        CharSequence a = ContextItemsUiUtil.a(graphQLEntityCardContextItem, context);
                        mobilePageAdminPanelBodyContextRowsItemView.f7799a.a(color);
                        mobilePageAdminPanelBodyContextRowsItemView.m8967a(a, 2, c);
                        break;
                    default:
                        mobilePageAdminPanelBodyContextRowsItemView.m8967a(ContextItemsUiUtil.a(graphQLEntityCardContextItem, context), 2, c);
                        break;
                }
            }
        }
        if (z) {
            if (1 != 0) {
                mobilePageAdminPanelBodyContextRowsItemView.f7800b = 2130840797;
            } else {
                mobilePageAdminPanelBodyContextRowsItemView.f7800b = 2130842709;
            }
            mobilePageAdminPanelBodyContextRowsItemView.setBackgroundResource(mobilePageAdminPanelBodyContextRowsItemView.f7800b);
        }
        mobilePageAdminPanelBodyContextRowsItemView.setBackgroundResource(mobilePageAdminPanelBodyContextRowsItemView.f7800b);
        mobilePageAdminPanelBodyContextRowsItemView.setClickable(onClickListener != null);
        mobilePageAdminPanelBodyContextRowsItemView.setOnClickListener(onClickListener);
        return mobilePageAdminPanelBodyContextRowsItemView;
    }

    public void setHasBeenAttached(boolean z) {
        this.f7809b = z;
    }

    public final boolean m8974a() {
        return this.f7809b;
    }
}
