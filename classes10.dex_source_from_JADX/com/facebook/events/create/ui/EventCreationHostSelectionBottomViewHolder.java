package com.facebook.events.create.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.style.TextAppearanceSpan;
import android.view.View;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.StyledStringBuilder;
import com.facebook.resources.ui.FbTextView;

/* compiled from: confirm_text */
public class EventCreationHostSelectionBottomViewHolder extends ViewHolder {
    private FbTextView f16350l;
    private String f16351m;
    private String f16352n;
    private String f16353o;

    public EventCreationHostSelectionBottomViewHolder(View view) {
        super(view);
        Context context = view.getContext();
        this.f16350l = (FbTextView) view.findViewById(2131561268);
        this.f16351m = context.getResources().getString(2131236935);
        this.f16352n = context.getResources().getString(2131236936);
        this.f16353o = context.getResources().getString(2131236937);
        this.f16350l.setText(new StyledStringBuilder(context.getResources()).a(StringFormatUtil.a(context.getResources().getString(2131236934), new Object[]{"[[ticketing_information]]", "[[promotion_tools]]", "[[easier_to_find]]"})).a("[[ticketing_information]]", this.f16351m, new TextAppearanceSpan(context, 2131625740), 33).a("[[promotion_tools]]", this.f16352n, new TextAppearanceSpan(context, 2131625740), 33).a("[[easier_to_find]]", this.f16353o, new TextAppearanceSpan(context, 2131625740), 33).b());
    }
}
