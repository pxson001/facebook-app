package com.facebook.iorg.common.upsell.ui;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.common.util.SizeUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.iorg.common.upsell.model.UpsellListViewModel;
import com.facebook.iorg.common.upsell.model.UpsellListViewModel.UpsellRowViewModel;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.List;

/* compiled from: mAnalyticsTag */
public class UpsellDialogActionList extends UpsellDialogList {
    public final List<UpsellDialogActionRow> f11357a = Lists.a();
    public OnClickListener f11358b;

    /* compiled from: mAnalyticsTag */
    public class UpsellDialogActionRow extends RelativeLayout {
        public TextView f11353a;
        public TextView f11354b;
        public TextView f11355c;
        public ImageButton f11356d;

        public UpsellDialogActionRow(Context context) {
            super(context);
            View inflate = LayoutInflater.from(getContext()).inflate(2130907615, this);
            this.f11353a = (TextView) inflate.findViewById(2131568213);
            this.f11354b = (TextView) inflate.findViewById(2131568215);
            this.f11355c = (TextView) inflate.findViewById(2131560248);
            this.f11356d = (ImageButton) inflate.findViewById(2131561062);
            setPadding(0, getResources().getDimensionPixelSize(2131428353), 0, getResources().getDimensionPixelSize(2131428353));
            setVisibility(8);
        }

        public final void m18147a(UpsellRowViewModel upsellRowViewModel) {
            if (!StringUtil.a(upsellRowViewModel.f11273b)) {
                this.f11353a.setText(upsellRowViewModel.f11273b);
                this.f11353a.setContentDescription(upsellRowViewModel.f11273b);
                this.f11353a.setVisibility(0);
            }
            if (!StringUtil.a(upsellRowViewModel.f11274c)) {
                this.f11354b.setText(upsellRowViewModel.f11274c);
                this.f11354b.setContentDescription(upsellRowViewModel.f11274c);
                this.f11354b.setVisibility(0);
            }
            this.f11355c.setTag(upsellRowViewModel.f11276e);
            this.f11356d.setTag(upsellRowViewModel.f11276e);
            if (upsellRowViewModel.f11277f) {
                this.f11356d.setVisibility(0);
            } else {
                this.f11355c.setText(upsellRowViewModel.f11275d);
                this.f11355c.setContentDescription(upsellRowViewModel.f11275d);
                this.f11355c.setVisibility(0);
            }
            setVisibility(0);
        }
    }

    public UpsellDialogActionList(Context context) {
        super(context);
    }

    public final void mo1070a(UpsellListViewModel upsellListViewModel) {
        this.f11357a.clear();
        removeAllViews();
        UpsellDialogActionRow upsellDialogActionRow = null;
        ImmutableList a = upsellListViewModel.m18133a();
        int size = a.size();
        int i = 0;
        while (i < size) {
            UpsellRowViewModel upsellRowViewModel = (UpsellRowViewModel) a.get(i);
            if (!StringUtil.a(upsellRowViewModel.f11272a)) {
                String str = upsellRowViewModel.f11272a;
                View textView = new TextView(getContext());
                textView.setText(str);
                textView.setLayoutParams(new LayoutParams(-1, SizeUtil.a(getContext(), 48.0f)));
                int dimensionPixelSize = getResources().getDimensionPixelSize(2131428350);
                textView.setPadding(dimensionPixelSize, 0, dimensionPixelSize, SizeUtil.a(getContext(), 4.0f));
                textView.setTypeface(Typeface.DEFAULT_BOLD);
                textView.setTextColor(getResources().getColor(2131364105));
                textView.setGravity(80);
                addView(textView);
            }
            addView(m18148a());
            View upsellDialogActionRow2 = new UpsellDialogActionRow(getContext());
            upsellDialogActionRow2.m18147a(upsellRowViewModel);
            OnClickListener onClickListener = this.f11358b;
            upsellDialogActionRow2.f11355c.setOnClickListener(onClickListener);
            upsellDialogActionRow2.f11356d.setOnClickListener(onClickListener);
            this.f11357a.add(upsellDialogActionRow2);
            addView(upsellDialogActionRow2);
            i++;
            View view = upsellDialogActionRow2;
        }
        if (upsellDialogActionRow != null) {
            if (upsellListViewModel.f11279b != null) {
                upsellDialogActionRow.setPadding(0, getResources().getDimensionPixelSize(2131428353), 0, getResources().getDimensionPixelSize(2131428371));
                view = new UpsellDontShowAgainCheckbox(getContext());
                view.setCheckListener(upsellListViewModel.f11279b);
                addView(view);
            }
            addView(m18148a());
        }
        setVisibility(0);
    }
}
