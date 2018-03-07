package com.facebook.messaging.send.client;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.analytics.reliability.AggregatedReliabilityLogger;
import com.facebook.messaging.cache.MessagesBroadcaster;
import com.facebook.messaging.cache.ThreadsCache;
import com.facebook.messaging.database.handlers.DbSendHandler;
import com.facebook.messaging.model.messages.MessageUtil;

/* compiled from: deleteMessagesParams */
public class PostSendMessageManagerProvider extends AbstractAssistedProvider<PostSendMessageManager> {
    public final PostSendMessageManager m16738a(ThreadsCache threadsCache) {
        return new PostSendMessageManager(DbSendHandler.m11027a((InjectorLike) this), threadsCache, MessagesBroadcaster.a(this), MessageUtil.a(this), (AbstractFbErrorReporter) FbErrorReporterImpl.a(this), SendLifeCycleManager.m16762a((InjectorLike) this), DefaultAndroidThreadUtil.b(this), AggregatedReliabilityLogger.a(this));
    }
}
