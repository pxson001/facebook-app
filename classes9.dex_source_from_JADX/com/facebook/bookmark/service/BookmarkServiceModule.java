package com.facebook.bookmark.service;

import com.facebook.bookmark.client.BookmarkSyncQueue;
import com.facebook.bookmark.db.BookmarkDatabaseHelper;
import com.facebook.bookmark.protocol.BookmarkSetFavoritesMethod;
import com.facebook.bookmark.protocol.BookmarkSyncMethod;
import com.facebook.bookmark.service.handler.BookmarkLoadFromDBServiceHandler;
import com.facebook.bookmark.service.handler.BookmarkSaveToDBServiceHandler;
import com.facebook.bookmark.service.handler.BookmarkSetFavoritesDBHandler;
import com.facebook.bookmark.service.handler.BookmarkUpdateUnreadCountDBHandler;
import com.facebook.bookmark.service.handler.BoomarkPerfMonitor;
import com.facebook.fbservice.handlers.ApiMethodServiceHandler;
import com.facebook.fbservice.handlers.ApiMethodServiceHandler.BaseParamGetter;
import com.facebook.fbservice.handlers.BlueServiceAggregateHandler;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.FilterChainLink;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.performancelogger.PerformanceLogger;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import java.util.Map;

@InjectorModule
/* compiled from: recent_outgoing_includes_oldest_transaction */
public class BookmarkServiceModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @BookmarkExpireTimeout
    static Integer m5906a() {
        return Integer.valueOf(1200000);
    }

    @BookmarkSyncQueue
    @ProviderMethod
    @ContextScoped
    static BlueServiceHandler m5905a(PerformanceLogger performanceLogger, BookmarkDatabaseHelper bookmarkDatabaseHelper, BroadcastSender broadcastSender, ObjectMapper objectMapper, AbstractSingleMethodRunner abstractSingleMethodRunner, BookmarkSyncMethod bookmarkSyncMethod, Integer num, BookmarkSetFavoritesMethod bookmarkSetFavoritesMethod) {
        return new FilterChainLink(new BoomarkPerfMonitor(performanceLogger), m5904a(bookmarkDatabaseHelper, broadcastSender, objectMapper, abstractSingleMethodRunner, bookmarkSyncMethod, num, bookmarkSetFavoritesMethod));
    }

    private static BlueServiceHandler m5904a(BookmarkDatabaseHelper bookmarkDatabaseHelper, BroadcastSender broadcastSender, ObjectMapper objectMapper, AbstractSingleMethodRunner abstractSingleMethodRunner, BookmarkSyncMethod bookmarkSyncMethod, Integer num, BookmarkSetFavoritesMethod bookmarkSetFavoritesMethod) {
        Map c = Maps.c();
        FilterChainLink filterChainLink = new FilterChainLink(new BookmarkSaveToDBServiceHandler(broadcastSender, bookmarkDatabaseHelper, objectMapper), new ApiMethodServiceHandler(abstractSingleMethodRunner, bookmarkSyncMethod, ApiMethodServiceHandler.f6719a, ApiMethodServiceHandler.f6721c));
        c.put("syncWithServer", filterChainLink);
        c.put("syncWithDB", new FilterChainLink(new BookmarkLoadFromDBServiceHandler(bookmarkDatabaseHelper, num.intValue()), filterChainLink));
        c.put("setFavoriteBookmarks", new FilterChainLink(new BookmarkSetFavoritesDBHandler(broadcastSender, bookmarkDatabaseHelper), new ApiMethodServiceHandler(abstractSingleMethodRunner, bookmarkSetFavoritesMethod, new BaseParamGetter("newFavoriteBookmarksGroup"), ApiMethodServiceHandler.f6720b)));
        c.put("updateUnreadCount", new BookmarkUpdateUnreadCountDBHandler(broadcastSender, bookmarkDatabaseHelper));
        return new BlueServiceAggregateHandler(c);
    }
}
