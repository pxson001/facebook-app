package com.facebook.payments.confirmation;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.payments.ui.PaymentsComponentAction;
import com.facebook.payments.ui.PaymentsComponentAction.Action;
import com.facebook.payments.ui.PaymentsComponentLinearLayout;
import com.facebook.widget.text.BetterTextView;
import com.facebook.widget.text.CustomFontHelper;
import com.facebook.widget.text.CustomFontHelper.FontFamily;
import com.facebook.widget.text.CustomFontHelper.FontWeight;
import javax.annotation.Nullable;

/* compiled from: call_quick_action */
public class PostPurchaseActionRowView extends PaymentsComponentLinearLayout implements OnClickListener {
    private BetterTextView f18620a;
    private GlyphView f18621b;
    private SimplePostPurchaseAction f18622c;

    public PostPurchaseActionRowView(Context context) {
        super(context);
        m18640a();
    }

    public PostPurchaseActionRowView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m18640a();
    }

    public PostPurchaseActionRowView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m18640a();
    }

    private void m18640a() {
        setContentView(2130906353);
        m18641b();
        this.f18620a = (BetterTextView) a(2131566196);
        this.f18621b = (GlyphView) a(2131560317);
    }

    private void m18641b() {
        setOrientation(0);
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131433721);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(2131433722);
        setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2);
    }

    public final void m18642a(PostPurchaseActionRow postPurchaseActionRow) {
        boolean z;
        int i = 0;
        this.f18622c = postPurchaseActionRow.f18617a;
        this.f18620a.setText(this.f18622c.f18624a);
        if (postPurchaseActionRow.f18618b) {
            CustomFontHelper.a(this.f18620a, FontFamily.fromIndex(FontFamily.ROBOTO.ordinal()), FontWeight.fromIndex(FontWeight.MEDIUM.ordinal()), this.f18620a.getTypeface());
        }
        setOnClickListener(this);
        if (postPurchaseActionRow.f18619c) {
            z = false;
        } else {
            z = true;
        }
        setEnabled(z);
        GlyphView glyphView = this.f18621b;
        if (!postPurchaseActionRow.f18619c) {
            i = 8;
        }
        glyphView.setVisibility(i);
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -66152476);
        Bundle bundle = new Bundle();
        bundle.putSerializable("extra_user_action", this.f18622c.f18625b);
        a(new PaymentsComponentAction(Action.USER_ACTION, bundle));
        Logger.a(2, EntryType.UI_INPUT_END, 1432206657, a);
    }
}
