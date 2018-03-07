package com.facebook.facecastdisplay;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.inject.FbInjector;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomLinearLayout;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: submessage */
public class LiveAnnouncementEventView extends CustomLinearLayout {
    private static final int f2829b = 2130840064;
    private static final Map<String, Integer> f2830c = ImmutableMap.a("bulb", Integer.valueOf(2130839743), "like", Integer.valueOf(2130839953), "eye", Integer.valueOf(2130839856), "comment", Integer.valueOf(2130839805));
    @Inject
    public GlyphColorizer f2831a;
    private final GlyphView f2832d;
    private final FbTextView f2833e;
    private final GradientDrawable f2834f;

    private static <T extends View> void m3129a(Class<T> cls, T t) {
        m3130a((Object) t, t.getContext());
    }

    private static void m3130a(Object obj, Context context) {
        ((LiveAnnouncementEventView) obj).f2831a = GlyphColorizer.a(FbInjector.get(context));
    }

    public LiveAnnouncementEventView(Context context) {
        this(context, null);
    }

    public LiveAnnouncementEventView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LiveAnnouncementEventView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m3129a(LiveAnnouncementEventView.class, (View) this);
        setContentView(2130905063);
        this.f2832d = (GlyphView) a(2131563457);
        this.f2833e = (FbTextView) a(2131563458);
        this.f2834f = (GradientDrawable) this.f2832d.getBackground().mutate();
    }

    public void setAnnouncementEvent(LiveAnnouncementEventModel liveAnnouncementEventModel) {
        int parseColor;
        int intValue = f2830c.containsKey(liveAnnouncementEventModel.f2826c) ? ((Integer) f2830c.get(liveAnnouncementEventModel.f2826c)).intValue() : f2829b;
        try {
            parseColor = Color.parseColor("#" + liveAnnouncementEventModel.f2827d);
        } catch (IllegalArgumentException e) {
            parseColor = -7235677;
        }
        this.f2834f.setColor(parseColor);
        this.f2834f.invalidateSelf();
        this.f2832d.setImageDrawable(this.f2831a.a(intValue, -1));
        this.f2833e.setText(liveAnnouncementEventModel.f2828e);
    }

    private void m3128a(GlyphColorizer glyphColorizer) {
        this.f2831a = glyphColorizer;
    }
}
