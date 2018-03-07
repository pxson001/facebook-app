package com.facebook.video.channelfeed;

import android.content.res.Resources;
import com.facebook.feed.rows.styling.DefaultPaddingStyleResolver;
import com.facebook.feed.widget.DownstateType;
import com.facebook.feedplugins.base.footer.FooterBackgroundStyleDefinition;
import com.facebook.feedplugins.base.footer.FooterLevel;
import com.facebook.feedplugins.base.footer.ui.Footer.DividerStyle;
import java.util.EnumMap;

/* compiled from: success_request_sms_code */
public class MultiShareChannelFeedFooterBackgroundStyleConfig extends ChannelFeedFooterBackgroundStyleConfig {
    public MultiShareChannelFeedFooterBackgroundStyleConfig(DefaultPaddingStyleResolver defaultPaddingStyleResolver, Resources resources) {
        super(defaultPaddingStyleResolver, resources);
    }

    public final EnumMap<FooterLevel, FooterBackgroundStyleDefinition> mo78d() {
        EnumMap<FooterLevel, FooterBackgroundStyleDefinition> enumMap = new EnumMap(FooterLevel.class);
        enumMap.put(FooterLevel.TOP, new FooterBackgroundStyleDefinition(0, 0, c(), 0, 0, DownstateType.NEWSFEED_SHADOW, DividerStyle.HIDDEN, DividerStyle.HIDDEN));
        return enumMap;
    }
}
