package com.facebook.messaging.emoji.service;

import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.ui.emoji.model.Emoji;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.List;
import javax.inject.Inject;

/* compiled from: m_type */
public class MessagingEmojiLocalServiceHandler implements BlueServiceHandler {
    public final RecentEmojiHandler f11002a;

    @Inject
    public MessagingEmojiLocalServiceHandler(RecentEmojiHandler recentEmojiHandler) {
        this.f11002a = recentEmojiHandler;
    }

    public final OperationResult m11416a(OperationParams operationParams) {
        String str = operationParams.b;
        if ("fetch_recent_emoji".equals(str)) {
            RecentEmojiHandler recentEmojiHandler = this.f11002a;
            List list = recentEmojiHandler.f11003a.f11009a;
            if (list == null) {
                list = recentEmojiHandler.f11004b.m11428a();
                recentEmojiHandler.f11003a.m11423a(list);
            }
            return OperationResult.a(new FetchRecentEmojiResult(list));
        } else if ("update_recent_emoji".equals(str)) {
            return m11415b(operationParams);
        } else {
            throw new IllegalArgumentException("Unknown operation type: " + str);
        }
    }

    private OperationResult m11415b(OperationParams operationParams) {
        Emoji emoji = (Emoji) operationParams.c.getParcelable("emoji");
        RecentEmojiHandler recentEmojiHandler = this.f11002a;
        List<Emoji> a = recentEmojiHandler.f11004b.m11428a();
        if (a.isEmpty() || !((Emoji) a.get(0)).equals(emoji)) {
            List a2 = Lists.a(Math.min(a.size() + 1, 45));
            a2.add(emoji);
            for (Emoji emoji2 : a) {
                if (a2.size() >= 45) {
                    break;
                } else if (!emoji2.equals(emoji)) {
                    a2.add(emoji2);
                }
            }
            recentEmojiHandler.f11004b.m11429a(ImmutableList.copyOf(a2));
            recentEmojiHandler.f11003a.m11423a(a2);
        } else if (recentEmojiHandler.f11003a.f11009a == null) {
            recentEmojiHandler.f11003a.m11423a((List) a);
        }
        return OperationResult.a;
    }
}
