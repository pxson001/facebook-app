package com.facebook.instantarticles;

import android.content.Intent;
import android.os.Bundle;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.richdocument.RichDocumentDelegate;
import com.facebook.richdocument.RichDocumentFragment;
import java.util.HashMap;
import java.util.Map;

/* compiled from: viewPeopleDialog */
public class InstantArticlesFragment extends RichDocumentFragment {
    InstantArticlesDelegateImpl am;

    public final RichDocumentDelegate aq() {
        this.am = new InstantArticlesDelegateImpl();
        return this.am;
    }

    public final void m585a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 617030034);
        super.a(bundle);
        this.am.a(bundle);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1034674002, a);
    }

    public final void m584a(int i, int i2, Intent intent) {
        super.a(i, i2, intent);
        InstantArticlesDelegateImpl instantArticlesDelegateImpl = this.am;
        Map hashMap = new HashMap();
        switch (i) {
            case 1001:
                hashMap.put("block_media_type", "paragraph");
                hashMap.put("ia_source", "native_article_text_block");
                instantArticlesDelegateImpl.f466P.a(i2, "feed_share_action", hashMap);
                return;
            case 1002:
                hashMap.put("block_media_type", "article");
                hashMap.put("ia_source", "native_article_text_block");
                instantArticlesDelegateImpl.f466P.a(i2, "feed_share_action", hashMap);
                return;
            case 1003:
                hashMap.put("block_media_type", "article");
                hashMap.put("ia_source", "share_block");
                instantArticlesDelegateImpl.f466P.a(i2, "feed_share_action_bottom", hashMap);
                return;
            default:
                return;
        }
    }
}
