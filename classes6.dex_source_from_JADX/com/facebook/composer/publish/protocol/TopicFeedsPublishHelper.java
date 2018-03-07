package com.facebook.composer.publish.protocol;

import com.facebook.common.util.JSONUtil;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.List;
import javax.annotation.Nullable;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: photo_picker_gallery_view_photo */
public class TopicFeedsPublishHelper {
    public static void m11664a(@Nullable ImmutableList<String> immutableList, List<NameValuePair> list) {
        if (immutableList != null) {
            list.add(new BasicNameValuePair("feed_topics", m11662a(immutableList)));
        }
    }

    public static void m11663a(@Nullable ImmutableList<String> immutableList, Builder<NameValuePair> builder) {
        if (immutableList != null) {
            builder.c(new BasicNameValuePair("feed_topics", m11662a(immutableList)));
        }
    }

    @Nullable
    public static String m11662a(@Nullable ImmutableList<String> immutableList) {
        if (immutableList == null) {
            return null;
        }
        return JSONUtil.b(immutableList).toString();
    }
}
