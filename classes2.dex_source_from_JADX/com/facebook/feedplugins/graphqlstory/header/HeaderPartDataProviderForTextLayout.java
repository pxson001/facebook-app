package com.facebook.feedplugins.graphqlstory.header;

import android.graphics.Paint;
import android.text.TextPaint;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;

/* compiled from: image_high_width */
public interface HeaderPartDataProviderForTextLayout {

    /* compiled from: image_high_width */
    public class HeaderSubtitleData {
        public static final HeaderSubtitleData f21926d = new HeaderSubtitleData(0, "", 0);
        public final int f21927a;
        public final CharSequence f21928b;
        public final int f21929c;

        public HeaderSubtitleData(int i, CharSequence charSequence, int i2) {
            this.f21927a = i;
            this.f21928b = charSequence;
            this.f21929c = i2;
        }
    }

    HeaderSubtitleData mo3137a(FeedProps<GraphQLStory> feedProps, TextPaint textPaint, Paint paint, int i);
}
