package com.facebook.messaging.location.sending;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.common.util.StringUtil;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.location.sending.LocationSendingDialogConfig.ButtonStyle;
import com.facebook.widget.CustomLinearLayout;
import javax.annotation.Nullable;

/* compiled from: mNeighborhood */
public class LocationSendingView extends CustomLinearLayout {
    @Nullable
    public ConfirmClickListener f11416a;
    private final ImageButton f11417b;
    private final TextView f11418c;
    private final ImageView f11419d;
    private final TextView f11420e;
    private final TextView f11421f;
    private ButtonStyle f11422g;

    /* compiled from: mNeighborhood */
    public interface ConfirmClickListener {
        void mo436a();
    }

    /* compiled from: mNeighborhood */
    class C12681 implements OnClickListener {
        final /* synthetic */ LocationSendingView f11413a;

        C12681(LocationSendingView locationSendingView) {
            this.f11413a = locationSendingView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1646710577);
            LocationSendingView.m12021e(this.f11413a);
            Logger.a(2, EntryType.UI_INPUT_END, -1141299411, a);
        }
    }

    /* compiled from: mNeighborhood */
    class C12692 implements OnClickListener {
        final /* synthetic */ LocationSendingView f11414a;

        C12692(LocationSendingView locationSendingView) {
            this.f11414a = locationSendingView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1756023248);
            LocationSendingView.m12021e(this.f11414a);
            Logger.a(2, EntryType.UI_INPUT_END, -832871836, a);
        }
    }

    public LocationSendingView(Context context) {
        this(context, null);
    }

    public LocationSendingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LocationSendingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11422g = ButtonStyle.SEND;
        setContentView(2130905131);
        setOrientation(0);
        this.f11417b = (ImageButton) a(2131562049);
        this.f11418c = (TextView) a(2131563594);
        this.f11419d = (ImageView) a(2131563591);
        this.f11420e = (TextView) a(2131563592);
        this.f11421f = (TextView) a(2131563593);
        m12020d();
    }

    public void setButtonStyle(ButtonStyle buttonStyle) {
        this.f11422g = buttonStyle;
        m12019c();
    }

    private void setConfirmEnabled(boolean z) {
        this.f11417b.setEnabled(z);
        this.f11418c.setEnabled(z);
    }

    private void m12019c() {
        this.f11417b.setVisibility(8);
        this.f11418c.setVisibility(8);
        switch (this.f11422g) {
            case SEND:
                this.f11417b.setVisibility(0);
                return;
            case SELECT:
                this.f11418c.setVisibility(0);
                return;
            default:
                throw new IllegalStateException("Unexpected button style: " + this.f11422g);
        }
    }

    private void m12020d() {
        setConfirmEnabled(false);
        this.f11417b.setOnClickListener(new C12681(this));
        this.f11418c.setOnClickListener(new C12692(this));
        m12019c();
    }

    public static void m12021e(LocationSendingView locationSendingView) {
        if (locationSendingView.f11416a != null) {
            locationSendingView.f11416a.mo436a();
        }
    }

    public void setConfirmClickListener(ConfirmClickListener confirmClickListener) {
        this.f11416a = confirmClickListener;
    }

    public final void m12022a() {
        setConfirmEnabled(true);
        this.f11419d.setImageResource(2130841970);
        this.f11420e.setText(2131241009);
        this.f11421f.setVisibility(8);
    }

    public final void m12023a(NearbyPlace nearbyPlace) {
        setConfirmEnabled(true);
        this.f11419d.setImageResource(2130841461);
        this.f11420e.setText(nearbyPlace.f11445b);
        if (StringUtil.a(nearbyPlace.f11449f)) {
            this.f11421f.setVisibility(8);
            return;
        }
        this.f11421f.setVisibility(0);
        this.f11421f.setText(nearbyPlace.f11449f);
    }

    public final void m12024b() {
        setConfirmEnabled(true);
        this.f11419d.setImageResource(2130841461);
        this.f11420e.setText(2131241016);
        this.f11421f.setVisibility(8);
    }
}
