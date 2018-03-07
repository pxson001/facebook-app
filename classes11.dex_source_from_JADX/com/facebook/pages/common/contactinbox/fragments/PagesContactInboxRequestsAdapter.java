package com.facebook.pages.common.contactinbox.fragments;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.common.timeformat.TimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil.TimeFormatStyle;
import com.facebook.graphql.enums.GraphQLPageLeadGenInfoState;
import com.facebook.inject.Assisted;
import com.facebook.pages.common.contactinbox.graphql.PagesContactInboxGraphQLModels.PageContactUsLeadFieldsModel;
import com.facebook.pages.common.contactinbox.ui.PagesContactInboxRequestViewHolder;
import com.facebook.pages.common.contactinbox.util.PagesContactInboxCache;
import com.facebook.pages.common.contactinbox.util.PagesContactInboxTimeUtils;
import com.facebook.pages.common.contactinbox.util.PagesContactInboxTimeUtils.AlertType;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: stepIndex */
public class PagesContactInboxRequestsAdapter extends Adapter<ViewHolder> {
    private final TimeFormatUtil f1421a;
    private final PagesContactInboxTimeUtils f1422b;
    public final List<PageContactUsLeadFieldsModel> f1423c = new ArrayList();
    private Context f1424d;
    private OnClickListener f1425e;
    private PagesContactInboxCache f1426f;
    private boolean f1427g = false;

    /* compiled from: stepIndex */
    class CustomViewHolder extends ViewHolder {
        public CustomViewHolder(View view) {
            super(view);
        }
    }

    /* compiled from: stepIndex */
    enum VIEW_TYPE {
        REQUEST,
        SPINNER,
        UNKNOWN
    }

    @Inject
    public PagesContactInboxRequestsAdapter(PagesContactInboxTimeUtils pagesContactInboxTimeUtils, TimeFormatUtil timeFormatUtil, Context context, PagesContactInboxCache pagesContactInboxCache, @Assisted OnClickListener onClickListener) {
        this.f1422b = pagesContactInboxTimeUtils;
        this.f1421a = timeFormatUtil;
        this.f1424d = context;
        this.f1426f = pagesContactInboxCache;
        this.f1425e = onClickListener;
    }

    public final void m2049b(boolean z) {
        this.f1427g = z;
        notifyDataSetChanged();
    }

    @Nullable
    public final PageContactUsLeadFieldsModel m2050e(int i) {
        return (i < 0 || i >= this.f1423c.size()) ? null : (PageContactUsLeadFieldsModel) this.f1423c.get(i);
    }

    public final ViewHolder m2047a(ViewGroup viewGroup, int i) {
        if (i == VIEW_TYPE.REQUEST.ordinal()) {
            return new PagesContactInboxRequestViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(2130906110, viewGroup, false));
        }
        if (i == VIEW_TYPE.SPINNER.ordinal()) {
            return new CustomViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(2130906112, viewGroup, false));
        }
        Preconditions.checkState(false);
        return null;
    }

    public final void m2048a(ViewHolder viewHolder, int i) {
        PageContactUsLeadFieldsModel e = m2050e(i);
        if (e != null && (viewHolder instanceof PagesContactInboxRequestViewHolder)) {
            PagesContactInboxRequestViewHolder pagesContactInboxRequestViewHolder = (PagesContactInboxRequestViewHolder) viewHolder;
            pagesContactInboxRequestViewHolder.f1452n.setText(e.m2069n());
            pagesContactInboxRequestViewHolder.f1455q.setText(this.f1421a.a(TimeFormatStyle.SHORT_DATE_STYLE, e.m2066k() * 1000));
            GraphQLPageLeadGenInfoState a = this.f1426f.m2131a(e.m2070o());
            if (a == null) {
                a = e.m2071p();
            }
            pagesContactInboxRequestViewHolder.m2127a(a);
            pagesContactInboxRequestViewHolder.f1454p.setText(e.m2065j());
            if (this.f1422b.m2138b(e.m2068m() * 1000)) {
                PagesContactInboxTimeUtils pagesContactInboxTimeUtils = this.f1422b;
                Context context = this.f1424d;
                long m = e.m2068m() * 1000;
                AlertType alertType = AlertType.TITLE;
                pagesContactInboxRequestViewHolder.m2128a(pagesContactInboxTimeUtils.m2137b(context, m), this.f1422b.m2135a(this.f1424d, e.m2068m() * 1000));
            } else {
                pagesContactInboxRequestViewHolder.f1453o.setVisibility(8);
            }
            if (this.f1425e != null) {
                viewHolder.a.setOnClickListener(this.f1425e);
            }
        }
    }

    public final int aZ_() {
        return (this.f1427g ? 1 : 0) + this.f1423c.size();
    }

    public int getItemViewType(int i) {
        if (i >= 0 && i < this.f1423c.size()) {
            return VIEW_TYPE.REQUEST.ordinal();
        }
        if (this.f1427g && i == this.f1423c.size()) {
            return VIEW_TYPE.SPINNER.ordinal();
        }
        return VIEW_TYPE.UNKNOWN.ordinal();
    }
}
