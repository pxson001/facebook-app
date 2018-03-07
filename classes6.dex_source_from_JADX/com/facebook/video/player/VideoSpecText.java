package com.facebook.video.player;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.resources.ui.FbTextView;
import com.facebook.video.api.VideoMetadata;
import com.google.common.collect.Maps;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: composer_friend_tag_failure */
public class VideoSpecText extends FbTextView {
    private Map<VideoSpecParam, String> f19257a = Maps.c();

    public VideoSpecText(Context context) {
        super(context);
    }

    public VideoSpecText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VideoSpecText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void m28057a(boolean z) {
        setVisibility(z ? 0 : 8);
        this.f19257a.clear();
    }

    public final void m28056a(VideoSpecParam videoSpecParam, String str) {
        if (getVisibility() != 8) {
            this.f19257a.put(videoSpecParam, str);
            m28053a();
        }
    }

    public final void m28055a(@Nullable VideoMetadata videoMetadata) {
        if (videoMetadata != null) {
            m28056a(VideoSpecParam.VIDEO_MIME, videoMetadata.a());
            m28056a(VideoSpecParam.STREAMING_FORMAT, videoMetadata.f);
        }
    }

    public final void m28054a(float f) {
        m28056a(VideoSpecParam.NEW_START_TIME, StringFormatUtil.formatStrLocaleSafe("%.2f s", Double.valueOf(((double) f) * 0.001d)));
    }

    public void requestLayout() {
    }

    private void m28053a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(m28052a(VideoSpecParam.VIDEO_MIME)).append("  ").append(m28052a(VideoSpecParam.API_CONFIG)).append("\n");
        stringBuilder.append(m28052a(VideoSpecParam.NEW_START_TIME)).append("\n");
        stringBuilder.append(m28052a(VideoSpecParam.RELATED_VIDEO)).append("\n");
        stringBuilder.append(m28052a(VideoSpecParam.CURRENT_STATE)).append("  ").append(m28052a(VideoSpecParam.TARGET_STATE)).append("\n");
        stringBuilder.append(m28052a(VideoSpecParam.NEW_PLAYER)).append("  ").append(m28052a(VideoSpecParam.VIDEO_REUSE)).append("\n");
        stringBuilder.append(m28052a(VideoSpecParam.STREAMING_FORMAT)).append("\n");
        stringBuilder.append(m28052a(VideoSpecParam.DASH_STREAM)).append("\n");
        setText(stringBuilder.toString());
    }

    private String m28052a(VideoSpecParam videoSpecParam) {
        String str = (String) this.f19257a.get(videoSpecParam);
        StringBuilder append = new StringBuilder().append(videoSpecParam.value).append(": ");
        if (str == null) {
            str = "Unknown";
        }
        return append.append(str).toString();
    }
}
