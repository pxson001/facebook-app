package com.facebook.events.tickets.modal.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.fbui.glyph.GlyphButton;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomLinearLayout;
import java.text.NumberFormat;
import javax.annotation.Nullable;

/* compiled from: appsite_url */
public class EventTicketingQuantityPicker extends CustomLinearLayout {
    private GlyphButton f19373a;
    private GlyphButton f19374b;
    private TextView f19375c;
    private int f19376d = 1;
    private int f19377e = 20;
    private int f19378f = this.f19376d;
    private NumberFormat f19379g;
    public OnQuantityChangedListener f19380h;

    /* compiled from: appsite_url */
    public interface OnQuantityChangedListener {
        void mo881g(int i);
    }

    /* compiled from: appsite_url */
    class C27451 implements OnClickListener {
        final /* synthetic */ EventTicketingQuantityPicker f19371a;

        C27451(EventTicketingQuantityPicker eventTicketingQuantityPicker) {
            this.f19371a = eventTicketingQuantityPicker;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -835695881);
            this.f19371a.m19522b();
            Logger.a(2, EntryType.UI_INPUT_END, 1259189226, a);
        }
    }

    /* compiled from: appsite_url */
    class C27462 implements OnClickListener {
        final /* synthetic */ EventTicketingQuantityPicker f19372a;

        C27462(EventTicketingQuantityPicker eventTicketingQuantityPicker) {
            this.f19372a = eventTicketingQuantityPicker;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1914628344);
            EventTicketingQuantityPicker.m19524c(this.f19372a);
            Logger.a(2, EntryType.UI_INPUT_END, -1915571231, a);
        }
    }

    public EventTicketingQuantityPicker(Context context) {
        super(context);
        m19520a();
    }

    public EventTicketingQuantityPicker(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m19520a();
    }

    public EventTicketingQuantityPicker(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m19520a();
    }

    @SuppressLint({"ConstructorMayLeakThis"})
    private void m19520a() {
        setContentView(2130903994);
        this.f19379g = NumberFormat.getIntegerInstance();
        this.f19373a = (GlyphButton) a(2131561207);
        this.f19374b = (GlyphButton) a(2131561205);
        this.f19375c = (TextView) a(2131561206);
        this.f19373a.setOnClickListener(new C27451(this));
        this.f19374b.setOnClickListener(new C27462(this));
    }

    private void m19522b() {
        if (this.f19378f < this.f19377e) {
            setCurrentQuantity(this.f19378f + 1);
            m19526e();
        }
    }

    public static void m19524c(EventTicketingQuantityPicker eventTicketingQuantityPicker) {
        if (eventTicketingQuantityPicker.f19378f > eventTicketingQuantityPicker.f19376d) {
            eventTicketingQuantityPicker.setCurrentQuantity(eventTicketingQuantityPicker.f19378f - 1);
            eventTicketingQuantityPicker.m19526e();
        }
    }

    private void m19525d() {
        boolean z;
        boolean z2 = true;
        this.f19375c.setText(this.f19379g.format((long) this.f19378f));
        GlyphButton glyphButton = this.f19374b;
        if (this.f19378f > this.f19376d) {
            z = true;
        } else {
            z = false;
        }
        glyphButton.setEnabled(z);
        GlyphButton glyphButton2 = this.f19373a;
        if (this.f19378f >= this.f19377e) {
            z2 = false;
        }
        glyphButton2.setEnabled(z2);
    }

    public void setMinimumQuantity(int i) {
        this.f19376d = i;
        if (this.f19378f < i) {
            this.f19378f = i;
            m19525d();
        }
    }

    public void setMaximumQuantity(int i) {
        this.f19377e = i;
        if (this.f19378f > i) {
            this.f19378f = i;
            m19525d();
        }
    }

    public void setCurrentQuantity(int i) {
        this.f19378f = i;
        m19525d();
    }

    public int getCurrentQuantity() {
        return this.f19378f;
    }

    public void setListener(OnQuantityChangedListener onQuantityChangedListener) {
        this.f19380h = onQuantityChangedListener;
    }

    private void m19526e() {
        if (this.f19380h != null) {
            this.f19380h.mo881g(this.f19378f);
        }
    }
}
