package com.facebook.feed.feedtype;

import android.content.Intent;
import com.facebook.api.feedtype.FeedType;
import com.facebook.api.feedtype.FeedType.Name;
import com.facebook.common.util.StringUtil;
import com.facebook.feed.protocol.FetchHashtagFeedMethod;
import com.facebook.inject.Lazy;
import javax.inject.Inject;

/* compiled from: selection */
public class HashTagFeedTypeDataItem extends AbstractFeedTypeDataItem {
    @Inject
    public HashTagFeedTypeDataItem(Lazy<FetchHashtagFeedMethod> lazy) {
        super(Name.f5051f, lazy);
    }

    public final String mo1401a(Intent intent, FeedType feedType) {
        CharSequence stringExtra = intent.getStringExtra("hashtag_feed_title");
        if (StringUtil.m3589a(stringExtra)) {
            return "#" + feedType.m8961a();
        }
        return stringExtra;
    }

    public final FeedType mo1400a(Intent intent) {
        return new FeedType(intent.getStringExtra("hashtag_feed_hashtag"), Name.f5051f);
    }
}
