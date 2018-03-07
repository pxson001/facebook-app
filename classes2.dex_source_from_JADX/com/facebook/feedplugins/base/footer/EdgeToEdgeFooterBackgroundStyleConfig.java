package com.facebook.feedplugins.base.footer;

import android.content.res.Resources;
import com.facebook.common.util.SizeUtil;
import com.facebook.feed.rows.styling.DefaultPaddingStyleResolver;
import com.facebook.feed.rows.styling.EdgeToEdgePaddingStyleConfig;
import com.facebook.feed.widget.DownstateType;
import com.facebook.feedplugins.base.footer.DefaultFooterBackgroundPartDefinition.ViewPadding;
import com.facebook.feedplugins.base.footer.ui.Footer.DividerStyle;
import java.util.EnumMap;

/* compiled from: is_partial */
public class EdgeToEdgeFooterBackgroundStyleConfig {
    public static final ViewPadding f18963a = new ViewPadding(0.0f, 0.0f, 0.0f);
    public final DefaultPaddingStyleResolver f18964b;
    public final Resources f18965c;

    public EdgeToEdgeFooterBackgroundStyleConfig(DefaultPaddingStyleResolver defaultPaddingStyleResolver, Resources resources) {
        this.f18964b = defaultPaddingStyleResolver;
        this.f18965c = resources;
    }

    private float m26665e() {
        return this.f18964b.m19170d();
    }

    private float m26666f() {
        return this.f18964b.m19171e();
    }

    private float m26667h() {
        return (float) SizeUtil.m19196b(this.f18965c, this.f18965c.getDimension(2131427594));
    }

    private ViewPadding m26668i() {
        return new ViewPadding(12.0f, 1.0f + m26665e(), m26666f());
    }

    private ViewPadding m26669j() {
        return new ViewPadding(0.0f, m26665e(), m26666f());
    }

    private ViewPadding m26670k() {
        return new ViewPadding(0.0f, m26665e(), 0.0f);
    }

    private ViewPadding m26671l() {
        return new ViewPadding(0.0f, m26665e(), this.f18964b.m19169c());
    }

    private ViewPadding m26672m() {
        float f = 12.0f;
        float e = 1.0f + m26665e();
        EdgeToEdgePaddingStyleConfig edgeToEdgePaddingStyleConfig = this.f18964b.f13038j;
        return new ViewPadding(f, e, 10.0f);
    }

    private ViewPadding m26673n() {
        return new ViewPadding(12.0f, m26665e() + 1.0f, 1.0f);
    }

    private ViewPadding m26674p() {
        return new ViewPadding(0.0f, 0.0f, m26667h());
    }

    public ViewPadding m26676c() {
        return new ViewPadding(0.0f, m26665e(), m26667h());
    }

    public EnumMap<FooterLevel, FooterBackgroundStyleDefinition> m26677d() {
        return m26675q();
    }

    private EnumMap<FooterLevel, FooterBackgroundStyleDefinition> m26675q() {
        EnumMap<FooterLevel, FooterBackgroundStyleDefinition> enumMap = new EnumMap(FooterLevel.class);
        enumMap.put(FooterLevel.TOP, new FooterBackgroundStyleDefinition(2130840195, 2130843818, m26676c(), 0, 2130843820, DownstateType.NEWSFEED_SHADOW, DividerStyle.VISIBLE, DividerStyle.HIDDEN));
        enumMap.put(FooterLevel.SUB_STORY, new FooterBackgroundStyleDefinition(2130840203, 2130843820, m26668i(), 2130840208, -1, DownstateType.SUBSTORY_SHADOW, DividerStyle.HIDDEN, DividerStyle.HIDDEN));
        enumMap.put(FooterLevel.LAST_SUB_STORY, new FooterBackgroundStyleDefinition(2130840203, 2130843820, m26672m(), 2130840208, -1, DownstateType.SUBSTORY_SHADOW, DividerStyle.HIDDEN, DividerStyle.HIDDEN));
        enumMap.put(FooterLevel.PERMALINK, new FooterBackgroundStyleDefinition(2130840203, 2130843820, m26669j(), 0, 2130843820, DownstateType.NEWSFEED_SHADOW, DividerStyle.VISIBLE, DividerStyle.VISIBLE));
        enumMap.put(FooterLevel.HAS_INLINE_COMMENTS, new FooterBackgroundStyleDefinition(2130840203, 2130843820, m26670k(), 0, 2130843820, DownstateType.NEWSFEED_SHADOW, DividerStyle.VISIBLE, DividerStyle.VISIBLE));
        enumMap.put(FooterLevel.HAS_INLINE_SURVEY, new FooterBackgroundStyleDefinition(2130840203, 2130843820, m26670k(), 0, 2130843820, DownstateType.NEWSFEED_SHADOW, DividerStyle.HIDDEN, DividerStyle.HIDDEN));
        enumMap.put(FooterLevel.HAS_FOLLOWUP_SECTION, new FooterBackgroundStyleDefinition(2130840203, 2130843820, m26671l(), 0, 2130843820, DownstateType.NEWSFEED_SHADOW, DividerStyle.VISIBLE, DividerStyle.HIDDEN));
        enumMap.put(FooterLevel.PAGE, new FooterBackgroundStyleDefinition(0, -1, f18963a, 2130840203, -1, DownstateType.NEWSFEED_SHADOW, DividerStyle.VISIBLE, DividerStyle.HIDDEN));
        enumMap.put(FooterLevel.PHOTOS_FEED, new FooterBackgroundStyleDefinition(2130840195, 2130843818, m26674p(), 0, 2130843820, DownstateType.NEWSFEED_SHADOW, DividerStyle.VISIBLE, DividerStyle.HIDDEN));
        enumMap.put(FooterLevel.SUB_STORY_BOX_WITH_COMMENTS, new FooterBackgroundStyleDefinition(2130840197, 2130843820, m26673n(), 0, -1, DownstateType.SUBSTORY_SHADOW, DividerStyle.VISIBLE, DividerStyle.HIDDEN));
        enumMap.put(FooterLevel.SUB_STORY_BOX_WITHOUT_COMMENTS, new FooterBackgroundStyleDefinition(2130840198, 2130843820, m26672m(), 0, -1, DownstateType.SUBSTORY_SHADOW, DividerStyle.VISIBLE, DividerStyle.HIDDEN));
        return enumMap;
    }
}
