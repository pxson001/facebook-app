package com.facebook.messaging.emoji.service;

import com.facebook.messaging.emoji.storage.MessagingEmojiCache;
import com.facebook.messaging.emoji.storage.MessagingEmojiDbStorageImpl;
import javax.inject.Inject;

/* compiled from: m_id */
public class RecentEmojiHandler {
    public final MessagingEmojiCache f11003a;
    public final MessagingEmojiDbStorageImpl f11004b;

    @Inject
    public RecentEmojiHandler(MessagingEmojiCache messagingEmojiCache, MessagingEmojiDbStorageImpl messagingEmojiDbStorageImpl) {
        this.f11003a = messagingEmojiCache;
        this.f11004b = messagingEmojiDbStorageImpl;
    }
}
