package com.facebook.messaging.presence;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.facebook.R;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterTextView;
import com.google.common.collect.Maps;
import java.util.Map;

/* compiled from: destination_location_params */
public class PresenceIndicatorView extends CustomLinearLayout {
    private final BetterTextView f16383a;
    private final ImageView f16384b;
    private int f16385c;
    private PresenceType f16386d;
    private String f16387e;
    private Map<PresenceType, Integer> f16388f;
    private boolean f16389g;

    public PresenceIndicatorView(Context context) {
        this(context, null);
    }

    public PresenceIndicatorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16386d = PresenceType.NONE;
        this.f16388f = Maps.c();
        this.f16389g = true;
        setOrientation(0);
        setGravity(17);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PresenceIndicatorView);
        if (obtainStyledAttributes.getBoolean(2, false)) {
            m16456a(PresenceType.ONLINE, 2130842238);
            m16456a(PresenceType.PUSHABLE, 2130842123);
        }
        this.f16383a = new BetterTextView(context, null, 2130772871);
        this.f16383a.setVisibility(8);
        this.f16384b = new ImageView(context, null, obtainStyledAttributes.getResourceId(3, 2130773026));
        if (obtainStyledAttributes.getInteger(1, 0) == 1) {
            addView(this.f16383a);
            addView(this.f16384b);
        } else {
            addView(this.f16384b);
            addView(this.f16383a);
        }
        int color = obtainStyledAttributes.getColor(0, -1);
        if (color == -1) {
            color = getResources().getColor(2131362527);
        }
        setTextColor(color);
        obtainStyledAttributes.recycle();
    }

    public void setTextColor(int i) {
        this.f16385c = i;
        this.f16383a.setTextColor(i);
    }

    public int getTextColor() {
        return this.f16385c;
    }

    public void setShowIcon(boolean z) {
        this.f16389g = z;
        m16455a();
    }

    private void m16456a(PresenceType presenceType, int i) {
        this.f16388f.put(presenceType, Integer.valueOf(i));
    }

    public void setStatus(PresenceType presenceType) {
        m16457a(presenceType, null);
    }

    public final void m16457a(PresenceType presenceType, String str) {
        this.f16386d = presenceType;
        this.f16387e = str;
        m16455a();
    }

    private void m16455a() {
        this.f16384b.setImageResource(2130841786);
        if (this.f16386d == PresenceType.AVAILABLE_ON_MOBILE || this.f16386d == PresenceType.AVAILABLE_ON_WEB) {
            this.f16384b.setVisibility(0);
            this.f16383a.setVisibility(8);
        } else if (this.f16386d == PresenceType.ONLINE) {
            this.f16384b.setVisibility(0);
            this.f16383a.setVisibility(8);
        } else {
            this.f16384b.setVisibility(8);
            if (this.f16387e == null) {
                this.f16383a.setVisibility(8);
                return;
            }
            this.f16383a.setGravity(5);
            this.f16383a.setVisibility(0);
            this.f16383a.setText(this.f16387e);
        }
    }
}
