package com.facebook.redspace.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.inject.Assisted;
import com.facebook.redspace.data.RedSpaceWallCollection;
import com.facebook.redspace.protocol.RedSpaceFeedFragmentsModels.RedSpaceFeedProfileFragmentModel;
import com.facebook.redspace.ui.RedSpaceFeedEmptyView;
import com.facebook.ultralight.Inject;
import com.facebook.widget.listview.FbBaseAdapter;
import com.facebook.widget.loadingindicator.LoadingIndicator;

/* compiled from: RCTModalHostView */
public class RedSpaceFeedStateAdapter extends FbBaseAdapter implements LoadingIndicator {
    public final RedSpaceWallCollection f11714a;
    private final RedSpaceFeedProfileFragmentModel f11715b;
    public boolean f11716c;

    @Inject
    public RedSpaceFeedStateAdapter(@Assisted RedSpaceWallCollection redSpaceWallCollection, @Assisted RedSpaceFeedProfileFragmentModel redSpaceFeedProfileFragmentModel) {
        this.f11714a = redSpaceWallCollection;
        this.f11715b = redSpaceFeedProfileFragmentModel;
    }

    public final View m12148a(int i, ViewGroup viewGroup) {
        return new RedSpaceFeedEmptyView(viewGroup.getContext());
    }

    public final void m12149a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        RedSpaceFeedEmptyView redSpaceFeedEmptyView = (RedSpaceFeedEmptyView) view;
        redSpaceFeedEmptyView.f12297g = viewGroup;
        RedSpaceFeedProfileFragmentModel redSpaceFeedProfileFragmentModel = this.f11715b;
        redSpaceFeedEmptyView.f12293c = redSpaceFeedProfileFragmentModel;
        redSpaceFeedEmptyView.f12292b.m12779a(redSpaceFeedProfileFragmentModel);
        if (StringUtil.a(redSpaceFeedEmptyView.f12295e, redSpaceFeedEmptyView.f12293c.k())) {
            redSpaceFeedEmptyView.f12291a.setText(2131235769);
            return;
        }
        String a = GraphQLHelper.a(redSpaceFeedProfileFragmentModel.n());
        redSpaceFeedEmptyView.f12291a.setText(redSpaceFeedEmptyView.f12296f.getString(2131235770, new Object[]{a}));
    }

    public Object getItem(int i) {
        return null;
    }

    public long getItemId(int i) {
        return 0;
    }

    public int getCount() {
        Object obj = (this.f11716c && this.f11714a.m12349e() == 0) ? 1 : null;
        return obj != null ? 1 : 0;
    }

    public final void m12150b() {
        this.f11716c = true;
    }
}
