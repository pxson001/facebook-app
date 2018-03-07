package com.facebook.widget.friendselector;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.StringUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.widget.CustomViewGroup;
import com.facebook.widget.tokenizedtypeahead.model.BaseToken;
import com.facebook.widget.tokenizedtypeahead.model.BaseToken.Type;
import com.google.common.base.Optional;
import com.google.common.base.Strings;

/* compiled from: decoration_icon */
public class CaspianFriendSelectorItemRow extends CustomViewGroup {
    private static final CallerContext f16024a = CallerContext.a(CaspianFriendSelectorItemRow.class);
    private final Optional<TextView> f16025b = getOptionalView(2131562284);
    private final TextView f16026c = ((TextView) getView(2131560883));
    private final Optional<TextView> f16027d = getOptionalView(2131560318);
    private final GlyphView f16028e = ((GlyphView) getView(2131558934));
    private final FbDraweeView f16029f = ((FbDraweeView) getView(2131561317));
    private final CheckBox f16030g = ((CheckBox) getView(2131561316));

    public CaspianFriendSelectorItemRow(Context context) {
        super(context);
        setContentView(2130904493);
    }

    public final void m20003a() {
        Resources resources = getContext().getResources();
        ((FrameLayout) getView(2131562274)).setVisibility(8);
        FrameLayout frameLayout = (FrameLayout) getView(2131562275);
        LayoutParams layoutParams = (LayoutParams) frameLayout.getLayoutParams();
        layoutParams.setMargins(resources.getDimensionPixelOffset(2131427416), 0, 0, 0);
        if (VERSION.SDK_INT >= 17) {
            layoutParams.setMarginStart(resources.getDimensionPixelOffset(2131427416));
        }
        frameLayout.setLayoutParams(layoutParams);
    }

    public final void m20004a(BaseToken baseToken, boolean z) {
        setEnabled(baseToken.a());
        if (this.f16025b.isPresent() && !StringUtil.a(baseToken.b())) {
            ((TextView) this.f16025b.get()).setText(new String(Character.toChars(baseToken.b().codePointAt(0))));
        }
        this.f16026c.setText(baseToken.b());
        if (baseToken.k()) {
            CheckBox checkBox = this.f16030g;
            boolean z2 = z || !baseToken.a();
            checkBox.setChecked(z2);
        } else {
            this.f16030g.setVisibility(8);
        }
        if (baseToken.f() > 0) {
            this.f16028e.setImageDrawable(getResources().getDrawable(baseToken.f()));
            this.f16028e.setVisibility(0);
            this.f16029f.setVisibility(8);
        } else if (baseToken.h() > 0 || baseToken.i() == null) {
            if (baseToken.h() > 0) {
                this.f16028e.setImageResource(baseToken.h());
            } else {
                this.f16028e.setBackgroundDrawable(new BitmapDrawable(getResources(), baseToken.j()));
            }
            this.f16029f.setVisibility(8);
            this.f16028e.setVisibility(0);
        } else {
            this.f16029f.a(Uri.parse(baseToken.i()), f16024a);
            this.f16029f.setVisibility(0);
            this.f16028e.setVisibility(8);
        }
        if (baseToken.g() > 0 && this.f16028e.getVisibility() == 0) {
            this.f16028e.setGlyphColor(getResources().getColor(baseToken.g()));
        }
        if (baseToken.a == Type.TAG_EXPANSION) {
            setTag("TAG_EXPANSION_VIEW");
        } else {
            setTag("");
        }
        if (this.f16027d.isPresent() && baseToken.m() && !Strings.isNullOrEmpty(baseToken.l())) {
            ((TextView) this.f16027d.get()).setVisibility(0);
            ((TextView) this.f16027d.get()).setText(baseToken.l());
        } else if (this.f16027d.isPresent()) {
            ((TextView) this.f16027d.get()).setVisibility(8);
        }
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.f16030g.setEnabled(z);
        float f = z ? 1.0f : 0.26f;
        this.f16028e.setAlpha(f);
        this.f16029f.setAlpha(f);
        this.f16026c.setAlpha(f);
        if (this.f16027d.isPresent()) {
            ((TextView) this.f16027d.get()).setAlpha(f);
            ((TextView) this.f16027d.get()).setVisibility(z ? 8 : 0);
        }
    }

    public void setAsHeaderItem(boolean z) {
        if (this.f16025b.isPresent()) {
            ((TextView) this.f16025b.get()).setVisibility(z ? 0 : 8);
        }
    }
}
