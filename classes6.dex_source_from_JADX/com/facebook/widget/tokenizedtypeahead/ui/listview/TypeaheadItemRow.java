package com.facebook.widget.tokenizedtypeahead.ui.listview;

import android.content.Context;
import android.support.v4.view.MarginLayoutParamsCompat;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.ToggleButton;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.SizeUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomViewGroup;
import com.facebook.widget.tokenizedtypeahead.model.BaseToken;

/* compiled from: com.facebook.platform.protocol.PROTOCOL_VALIDATE */
public class TypeaheadItemRow extends CustomViewGroup {
    public static final CallerContext f20142a = CallerContext.a(TypeaheadItemRow.class);
    public final TextView f20143b = ((TextView) getView(2131560883));
    public final GlyphView f20144c = ((GlyphView) getView(2131558934));
    public final FbDraweeView f20145d = ((FbDraweeView) getView(2131561317));
    public final ToggleButton f20146e = ((ToggleButton) getView(2131561316));
    public final ImageView f20147f = ((ImageView) getView(2131568150));
    public final ImageView f20148g = ((ImageView) getView(2131568151));
    public final View f20149h = getView(2131563233);

    /* compiled from: com.facebook.platform.protocol.PROTOCOL_VALIDATE */
    public class C15161 implements OnClickListener {
        final /* synthetic */ BaseToken f20138a;
        final /* synthetic */ TypeaheadItemRow f20139b;

        public C15161(TypeaheadItemRow typeaheadItemRow, BaseToken baseToken) {
            this.f20139b = typeaheadItemRow;
            this.f20138a = baseToken;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 815172111);
            this.f20138a.mo1522a(false);
            Logger.a(2, EntryType.UI_INPUT_END, -1197711944, a);
        }
    }

    /* compiled from: com.facebook.platform.protocol.PROTOCOL_VALIDATE */
    public class C15172 implements OnClickListener {
        final /* synthetic */ BaseToken f20140a;
        final /* synthetic */ TypeaheadItemRow f20141b;

        public C15172(TypeaheadItemRow typeaheadItemRow, BaseToken baseToken) {
            this.f20141b = typeaheadItemRow;
            this.f20140a = baseToken;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -269159927);
            this.f20140a.mo1522a(false);
            Logger.a(2, EntryType.UI_INPUT_END, 1031995713, a);
        }
    }

    public TypeaheadItemRow(Context context) {
        super(context);
        setContentView(2130907576);
    }

    public final TypeaheadItemRow m28795a() {
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(2130772549, typedValue, true);
        setCheckboxBackground(2130838045);
        LayoutParams layoutParams = (LayoutParams) this.f20146e.getLayoutParams();
        layoutParams.setMargins(getResources().getDimensionPixelSize(2131427795), getResources().getDimensionPixelSize(2131427797), getResources().getDimensionPixelSize(2131427796), getResources().getDimensionPixelSize(2131427797));
        MarginLayoutParamsCompat.a(layoutParams, getResources().getDimensionPixelSize(2131427795));
        MarginLayoutParamsCompat.b(layoutParams, getResources().getDimensionPixelSize(2131427796));
        layoutParams.width = getResources().getDimensionPixelSize(2131427799);
        layoutParams.height = getResources().getDimensionPixelSize(2131427799);
        this.f20146e.setLayoutParams(layoutParams);
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131427792);
        this.f20145d.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        this.f20144c.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        ((LayoutParams) this.f20143b.getLayoutParams()).setMargins(0, 0, getResources().getDimensionPixelSize(2131427793), 0);
        this.f20143b.setTextSize((float) SizeUtil.c(getResources(), 2131427402));
        this.f20143b.setTextColor(typedValue.data);
        findViewById(2131560055).setVisibility(8);
        findViewById(2131560955).setVisibility(0);
        return this;
    }

    public void setCheckboxBackground(int i) {
        this.f20146e.setBackgroundResource(i);
    }

    public final void m28796b() {
        this.f20148g.setVisibility(0);
        MarginLayoutParamsCompat.b((LayoutParams) this.f20143b.getLayoutParams(), getResources().getDimensionPixelSize(2131427794));
    }
}
