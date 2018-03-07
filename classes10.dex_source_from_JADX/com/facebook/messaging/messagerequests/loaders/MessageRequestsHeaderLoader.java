package com.facebook.messaging.messagerequests.loaders;

import com.facebook.common.appchoreographer.AppChoreographer.Priority;
import com.facebook.common.appchoreographer.AppChoreographer.ThreadType;
import com.facebook.common.appchoreographer.DefaultAppChoreographer;
import com.facebook.common.loader.AbstractListenableFutureFbLoader;
import com.facebook.common.loader.AbstractListenableFutureFbLoader.LoaderResult;
import com.facebook.messaging.messagerequests.snippet.MessageRequestsSnippet;
import com.facebook.messaging.messagerequests.snippet.MessageRequestsSnippetFetcher;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: saved_dashboard_undo_button_imp */
public class MessageRequestsHeaderLoader extends AbstractListenableFutureFbLoader<Void, MessageRequestsSnippet> {
    private final MessageRequestsSnippetFetcher f3225a;
    private final DefaultAppChoreographer f3226b;
    public boolean f3227c;

    /* compiled from: saved_dashboard_undo_button_imp */
    class C05211 implements Callable<ListenableFuture<MessageRequestsSnippet>> {
        final /* synthetic */ MessageRequestsHeaderLoader f3224a;

        C05211(MessageRequestsHeaderLoader messageRequestsHeaderLoader) {
            this.f3224a = messageRequestsHeaderLoader;
        }

        public Object call() {
            return MessageRequestsHeaderLoader.m3150h(this.f3224a);
        }
    }

    @Inject
    public MessageRequestsHeaderLoader(MessageRequestsSnippetFetcher messageRequestsSnippetFetcher, DefaultAppChoreographer defaultAppChoreographer, Executor executor) {
        super(executor);
        this.f3225a = messageRequestsSnippetFetcher;
        this.f3226b = defaultAppChoreographer;
    }

    protected final LoaderResult m3152b(Object obj) {
        MessageRequestsSnippet a = this.f3225a.m3180a();
        return a == null ? AbstractListenableFutureFbLoader.a : LoaderResult.b(a);
    }

    protected final ListenableFuture m3151a(Object obj, LoaderResult loaderResult) {
        return this.f3227c ? Futures.a(this.f3226b.a("updateMessageRequestsSnippet", new C05211(this), Priority.APPLICATION_LOADED_UI_IDLE, ThreadType.UI)) : m3150h(this);
    }

    public static ListenableFuture m3150h(MessageRequestsHeaderLoader messageRequestsHeaderLoader) {
        return messageRequestsHeaderLoader.f3225a.m3181b();
    }
}
