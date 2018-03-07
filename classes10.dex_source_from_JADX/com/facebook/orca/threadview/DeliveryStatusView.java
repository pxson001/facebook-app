package com.facebook.orca.threadview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.inject.FbInjector;
import com.facebook.messaging.threadview.rows.RowItemDeliveryState;
import javax.inject.Inject;

/* compiled from: montage_reply */
public class DeliveryStatusView extends View {
    @Inject
    Resources f6891a;
    @Inject
    GlyphColorizer f6892b;
    private RowItemDeliveryState f6893c;
    private int f6894d;

    private static <T extends View> void m6523a(Class<T> cls, T t) {
        m6524a((Object) t, t.getContext());
    }

    private static void m6524a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((DeliveryStatusView) obj).m6522a(ResourcesMethodAutoProvider.a(fbInjector), GlyphColorizer.a(fbInjector));
    }

    public DeliveryStatusView(Context context) {
        super(context);
        m6521a();
    }

    public DeliveryStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m6521a();
    }

    public DeliveryStatusView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m6521a();
    }

    private void m6521a() {
        m6523a(DeliveryStatusView.class, (View) this);
        this.f6894d = this.f6891a.getColor(2131362241);
    }

    public final void m6527a(RowItemDeliveryState rowItemDeliveryState) {
        if (rowItemDeliveryState != null && this.f6893c != rowItemDeliveryState) {
            this.f6893c = rowItemDeliveryState;
            m6525b();
        }
    }

    public void setTintColor(int i) {
        this.f6894d = i;
        m6526c();
    }

    private void m6525b() {
        switch (this.f6893c) {
            case SENT:
                setBackgroundDrawable(this.f6891a.getDrawable(2130842112));
                break;
            case SENDING:
                setBackgroundDrawable(this.f6891a.getDrawable(2130842102));
                break;
            case DELIVERED:
                setBackgroundDrawable(this.f6891a.getDrawable(2130842106));
                break;
            case FAILED_NON_RETRYABLE:
                setBackgroundDrawable(this.f6892b.a(2130841401, this.f6891a.getColor(2131362300)));
                break;
            case FAILED:
                setBackgroundDrawable(this.f6892b.a(2130841401, this.f6891a.getColor(2131362299)));
                break;
            case SENT_WITH_HIDDEN_SEND_RECEIPT:
            case READ:
            case HIDDEN:
                setBackgroundDrawable(null);
                break;
        }
        m6526c();
    }

    private void m6526c() {
        Drawable background = getBackground();
        if (background != null) {
            if (this.f6894d == 0) {
                background.mutate().setColorFilter(null);
            } else if (this.f6893c == RowItemDeliveryState.SENT || this.f6893c == RowItemDeliveryState.SENDING || this.f6893c == RowItemDeliveryState.DELIVERED) {
                background.mutate().setColorFilter(this.f6894d, Mode.SRC_ATOP);
            }
        }
    }

    private void m6522a(Resources resources, GlyphColorizer glyphColorizer) {
        this.f6891a = resources;
        this.f6892b = glyphColorizer;
    }
}
