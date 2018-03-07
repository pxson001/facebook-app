package com.facebook.video.channelfeed;

import android.content.res.Resources;
import com.facebook.common.util.SizeUtil;
import com.facebook.feed.rows.styling.DefaultPaddingStyleResolver;
import com.facebook.feed.widget.DownstateType;
import com.facebook.feedplugins.base.footer.DefaultFooterBackgroundPartDefinition.ViewPadding;
import com.facebook.feedplugins.base.footer.EdgeToEdgeFooterBackgroundStyleConfig;
import com.facebook.feedplugins.base.footer.FooterBackgroundStyleDefinition;
import com.facebook.feedplugins.base.footer.FooterLevel;
import com.facebook.feedplugins.base.footer.ui.Footer.DividerStyle;
import java.util.EnumMap;

/* compiled from: targeting_spec */
public class ChannelFeedFooterBackgroundStyleConfig extends EdgeToEdgeFooterBackgroundStyleConfig {
    public ChannelFeedFooterBackgroundStyleConfig(DefaultPaddingStyleResolver defaultPaddingStyleResolver, Resources resources) {
        super(defaultPaddingStyleResolver, resources);
    }

    public EnumMap<FooterLevel, FooterBackgroundStyleDefinition> mo78d() {
        EnumMap<FooterLevel, FooterBackgroundStyleDefinition> enumMap = new EnumMap(FooterLevel.class);
        enumMap.put(FooterLevel.TOP, new FooterBackgroundStyleDefinition(2130838020, 0, c(), 0, 0, DownstateType.NEWSFEED_SHADOW, DividerStyle.HIDDEN, DividerStyle.HIDDEN));
        return enumMap;
    }

    public final ViewPadding m2189c() {
        return new ViewPadding(0.0f, (float) SizeUtil.b(this.c, 2131431500), (float) SizeUtil.b(this.c, 2131431501));
    }
}
