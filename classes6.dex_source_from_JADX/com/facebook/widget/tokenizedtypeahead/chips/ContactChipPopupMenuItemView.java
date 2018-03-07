package com.facebook.widget.tokenizedtypeahead.chips;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.resources.ui.FbFrameLayout;
import com.facebook.user.tiles.UserTileViewParams;
import com.facebook.widget.tokenizedtypeahead.chips.ContactChipMenuItem.C15061;

/* compiled from: com.facebook.push.mqtt.ACTION_MQTT_PUBLISH_ARRIVED */
public class ContactChipPopupMenuItemView extends FbFrameLayout {
    private final Rect f20071a;
    private View f20072b;
    private ImageView f20073c;
    private TextView f20074d;
    private TextView f20075e;
    private GlyphView f20076f;
    public boolean f20077g;

    public ContactChipPopupMenuItemView(Context context) {
        this(context, null);
    }

    public ContactChipPopupMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContactChipPopupMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f20071a = new Rect();
        View.inflate(context, 2130903758, this);
        this.f20072b = findViewById(2131560702);
        this.f20073c = (ImageView) findViewById(2131560703);
        this.f20074d = (TextView) findViewById(2131560704);
        this.f20075e = (TextView) findViewById(2131560705);
        this.f20076f = (GlyphView) findViewById(2131560706);
    }

    public final void m28746a(ContactChipMenuItem contactChipMenuItem, boolean z, boolean z2) {
        int i;
        int i2;
        int i3 = 0;
        ImageView imageView = this.f20073c;
        Context context = getContext();
        if (contactChipMenuItem.f20054e == null) {
            contactChipMenuItem.f20053d.a(context, null, 0);
            contactChipMenuItem.f20053d.a(true);
            contactChipMenuItem.f20053d.a(UserTileViewParams.a(contactChipMenuItem.f20050a));
            contactChipMenuItem.f20053d.c();
            contactChipMenuItem.f20054e = contactChipMenuItem.f20053d.m;
            contactChipMenuItem.f20053d.A = new C15061(contactChipMenuItem);
        }
        imageView.setImageDrawable(contactChipMenuItem.f20054e);
        this.f20074d.setVisibility(z ? 0 : 8);
        if (z) {
            this.f20074d.setText(contactChipMenuItem.f20051b);
        }
        String str = contactChipMenuItem.f20052c;
        if (str != null) {
            i = 1;
        } else {
            i = 0;
        }
        TextView textView = this.f20075e;
        if (i != 0) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        textView.setVisibility(i2);
        if (i != 0) {
            this.f20075e.setText(str);
        }
        GlyphView glyphView = this.f20076f;
        if (!(z2 && z)) {
            i3 = 8;
        }
        glyphView.setVisibility(i3);
        this.f20072b.setSelected(z);
    }

    public void setSelected(boolean z) {
        super.setSelected(z);
        this.f20072b.setSelected(z);
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        this.f20072b.setBackgroundResource(i);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.f20076f.getHitRect(this.f20071a);
        this.f20077g = this.f20071a.contains((int) motionEvent.getX(), (int) motionEvent.getY());
        return false;
    }

    public final boolean m28747a() {
        return this.f20077g;
    }
}
