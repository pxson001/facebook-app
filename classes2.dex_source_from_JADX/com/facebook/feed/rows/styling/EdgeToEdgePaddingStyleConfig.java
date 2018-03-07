package com.facebook.feed.rows.styling;

import android.content.res.Resources;
import com.facebook.common.util.SizeUtil;
import com.facebook.feed.rows.styling.BasePaddingStyleResolver.BaseStyle;
import com.facebook.feed.rows.styling.HorizontalPadder.ConstantHorizontalPadder;
import com.facebook.feed.rows.styling.PaddingStyle.PaddingValues;
import java.util.EnumMap;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: name= */
public class EdgeToEdgePaddingStyleConfig {
    protected static final HorizontalPadder f13048a = new ConstantHorizontalPadder(0.0f, 0.0f);
    public static final PaddingValues f13049b = new PaddingValues(0.0f, 0.0f, 0.0f, f13048a);
    private Resources f13050c;
    @GuardedBy("this")
    private EnumMap<BaseStyle, PaddingValues> f13051d;

    public EdgeToEdgePaddingStyleConfig(Resources resources) {
        this.f13050c = resources;
    }

    public final float m19187b() {
        return 6.0f;
    }

    private static float m19185i() {
        return 2.0f;
    }

    public final float m19188c() {
        return 6.0f;
    }

    private static float m19186j() {
        return 2.0f;
    }

    public final float m19189e() {
        return (float) SizeUtil.m19196b(this.f13050c, this.f13050c.getDimension(2131427594));
    }

    public final synchronized EnumMap<BaseStyle, PaddingValues> m19190h() {
        if (this.f13051d == null) {
            this.f13051d = new EnumMap(BaseStyle.class);
            this.f13051d.put(BaseStyle.LEGACY_DEFAULT, new PaddingValues(0.0f, 0.0f, 0.0f, new ConstantHorizontalPadder(12.0f, 12.0f)));
            this.f13051d.put(BaseStyle.STORY_EDGE, new PaddingValues(0.0f, 0.0f, 0.0f, new ConstantHorizontalPadder(0.0f, 0.0f)));
            this.f13051d.put(BaseStyle.LEGACY_ZERO, new PaddingValues(0.0f, 0.0f, 0.0f, f13048a));
            this.f13051d.put(BaseStyle.DEFAULT, new PaddingValues(m19187b(), m19188c(), 0.0f, new ConstantHorizontalPadder(12.0f, 12.0f)));
            this.f13051d.put(BaseStyle.DEFAULT_TEXT, new PaddingValues(m19187b(), m19186j(), 0.0f, new ConstantHorizontalPadder(12.0f, 12.0f)));
            this.f13051d.put(BaseStyle.ZERO, new PaddingValues(m19187b(), m19188c(), 0.0f, f13048a));
            this.f13051d.put(BaseStyle.DEFAULT_HEADER, new PaddingValues(m19185i(), m19186j(), 0.0f, f13048a));
            this.f13051d.put(BaseStyle.DEFAULT_TEXT_HEADER, new PaddingValues(0.0f, m19186j(), -12.0f, new ConstantHorizontalPadder(12.0f, 12.0f)));
            this.f13051d.put(BaseStyle.SUBSTORY_HEADER, new PaddingValues(m19187b(), m19186j(), 0.0f, new ConstantHorizontalPadder(12.0f, 0.0f)));
            this.f13051d.put(BaseStyle.ATTACHMENT_TOP, new PaddingValues(m19187b(), 0.0f, 0.0f, f13048a));
            this.f13051d.put(BaseStyle.ATTACHMENT_BOTTOM, new PaddingValues(0.0f, m19188c(), 0.0f, f13048a));
            this.f13051d.put(BaseStyle.SHARED_ATTACHMENT, new PaddingValues(m19187b(), m19188c(), 0.0f, f13048a));
        }
        return this.f13051d;
    }
}
