package com.facebook.messaging.audio.playback;

import android.content.Context;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.util.ContextUtils;
import com.facebook.widget.CustomLinearLayout;

/* compiled from: order_ride_deep_linking */
public class AudioPlayerBubbleView extends CustomLinearLayout {
    private final ImageView f8069a = ((ImageView) a(2131564451));
    private final View f8070b = a(2131564452);
    private final TextView f8071c = ((TextView) a(2131564453));
    private Drawable f8072d;
    private Drawable f8073e;
    private boolean f8074f = false;
    private boolean f8075g;

    /* compiled from: order_ride_deep_linking */
    public enum Type {
        SELF_NORMAL,
        SELF_HIGHLIGHTED,
        OTHER_NORMAL,
        OTHER_HIGHLIGHTED
    }

    public AudioPlayerBubbleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setContentView(2130905568);
    }

    public void setType(Type type) {
        int b;
        int b2;
        int b3;
        int b4;
        int b5;
        int i;
        Context context = getContext();
        int b6;
        switch (type) {
            case SELF_NORMAL:
                this.f8069a.setBackgroundResource(ContextUtils.b(context, 2130773189, 2130841839));
                b = ContextUtils.b(context, 2130773190, 2130842374);
                b2 = ContextUtils.b(context, 2130773194, 2130842384);
                b3 = ContextUtils.b(context, 2130773208, 2130842408);
                b4 = ContextUtils.b(context, 2130773212, 2130844069);
                b5 = ContextUtils.b(context, 2130773204, 2130842400);
                b6 = ContextUtils.b(context, 2130773200, 2130842392);
                i = b2;
                b2 = b3;
                b3 = b4;
                b4 = b5;
                b5 = b6;
                break;
            case OTHER_NORMAL:
                this.f8069a.setBackgroundResource(ContextUtils.b(context, 2130773188, 2130841837));
                b = ContextUtils.b(context, 2130773192, 2130842367);
                b2 = ContextUtils.b(context, 2130773196, 2130842380);
                b3 = ContextUtils.b(context, 2130773206, 2130842404);
                b4 = ContextUtils.b(context, 2130773210, 2130844067);
                b5 = ContextUtils.b(context, 2130773202, 2130842396);
                b6 = ContextUtils.b(context, 2130773198, 2130842388);
                i = b2;
                b2 = b3;
                b3 = b4;
                b4 = b5;
                b5 = b6;
                break;
            case SELF_HIGHLIGHTED:
                b = ContextUtils.b(context, 2130773191, 2130842377);
                b2 = ContextUtils.b(context, 2130773195, 2130842385);
                b3 = ContextUtils.b(context, 2130773209, 2130842409);
                b4 = ContextUtils.b(context, 2130773213, 2130844070);
                b5 = ContextUtils.b(context, 2130773205, 2130842401);
                b6 = ContextUtils.b(context, 2130773201, 2130842393);
                i = b2;
                b2 = b3;
                b3 = b4;
                b4 = b5;
                b5 = b6;
                break;
            case OTHER_HIGHLIGHTED:
                b = ContextUtils.b(context, 2130773193, 2130842370);
                b2 = ContextUtils.b(context, 2130773197, 2130842381);
                b3 = ContextUtils.b(context, 2130773207, 2130842405);
                b4 = ContextUtils.b(context, 2130773211, 2130844068);
                b5 = ContextUtils.b(context, 2130773203, 2130842397);
                b6 = ContextUtils.b(context, 2130773199, 2130842389);
                i = b2;
                b2 = b3;
                b3 = b4;
                b4 = b5;
                b5 = b6;
                break;
            default:
                return;
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131428583);
        setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        setBackgroundResource(b);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) getResources().getDrawable(i);
        bitmapDrawable.mutate();
        bitmapDrawable.setTileModeX(TileMode.REPEAT);
        this.f8070b.setBackgroundDrawable(bitmapDrawable);
        this.f8071c.setBackgroundDrawable(getResources().getDrawable(b2));
        this.f8071c.setTextColor(getResources().getColor(b3));
        this.f8072d = getResources().getDrawable(b4);
        this.f8073e = getResources().getDrawable(b5);
        m8329a();
        if (m8330a(type)) {
            this.f8071c.getBackground().mutate().setAlpha(51);
            this.f8070b.setAlpha(0.2f);
            this.f8069a.setAlpha(0.2f);
        }
    }

    public void setIsPlaying(boolean z) {
        this.f8074f = z;
        m8329a();
    }

    public void setIsLoading(boolean z) {
        this.f8075g = z;
        m8329a();
    }

    public void setTimerDuration(long j) {
        if (j == -1) {
            this.f8071c.setText(getResources().getString(2131231617));
            return;
        }
        int round = Math.round(((float) j) / 1000.0f);
        this.f8071c.setText(StringFormatUtil.formatStrLocaleSafe("%d:%02d", Integer.valueOf(round / 60), Integer.valueOf(round % 60)));
    }

    public void setColor(int i) {
        this.f8071c.setTextColor(i);
        setBackgroundColor(i);
    }

    private void m8329a() {
        Drawable background = this.f8069a.getBackground();
        if (this.f8075g && (background instanceof AnimationDrawable)) {
            this.f8069a.setImageDrawable(null);
            ((AnimationDrawable) background).start();
            return;
        }
        if (background instanceof AnimationDrawable) {
            ((AnimationDrawable) background).stop();
        }
        this.f8069a.setImageDrawable(this.f8074f ? this.f8073e : this.f8072d);
    }

    private static boolean m8330a(Type type) {
        return type == Type.OTHER_HIGHLIGHTED || type == Type.OTHER_NORMAL;
    }
}
