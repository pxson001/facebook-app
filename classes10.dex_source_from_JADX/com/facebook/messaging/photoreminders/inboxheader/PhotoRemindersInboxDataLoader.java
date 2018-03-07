package com.facebook.messaging.photoreminders.inboxheader;

import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.loader.AbstractListenableFutureFbLoader;
import com.facebook.common.loader.AbstractListenableFutureFbLoader.LoaderResult;
import com.facebook.common.util.CollectionUtil;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.photoreminders.PhotoRemindersGatingUtil;
import com.facebook.messaging.photoreminders.interfaces.PhotoSuggestion;
import com.facebook.messaging.photoreminders.interfaces.PhotoSuggestionManager;
import com.facebook.messaging.photoreminders.stub.PhotoSuggestionManagerMethodAutoProvider;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: registration_step_reject_terms */
public class PhotoRemindersInboxDataLoader extends AbstractListenableFutureFbLoader<Void, PhotoRemindersInboxData> {
    public static final String f3571a = PhotoRemindersInboxDataLoader.class.getSimpleName();
    @Nullable
    private final PhotoSuggestionManager f3572b;
    private final PhotoRemindersGatingUtil f3573c;
    public final PhotoRemindersInboxDataUtil f3574d;

    /* compiled from: registration_step_reject_terms */
    class C05561 implements Function<ImmutableList<PhotoSuggestion>, PhotoRemindersInboxData> {
        final /* synthetic */ PhotoRemindersInboxDataLoader f3570a;

        C05561(PhotoRemindersInboxDataLoader photoRemindersInboxDataLoader) {
            this.f3570a = photoRemindersInboxDataLoader;
        }

        @Nullable
        public Object apply(@Nullable Object obj) {
            ImmutableList immutableList = (ImmutableList) obj;
            if (CollectionUtil.a(immutableList)) {
                BLog.b(PhotoRemindersInboxDataLoader.f3571a, "Failed to fetch photo suggestions");
                return null;
            }
            String str = PhotoRemindersInboxDataLoader.f3571a;
            return this.f3570a.f3574d.m3405a(immutableList);
        }
    }

    public static PhotoRemindersInboxDataLoader m3402b(InjectorLike injectorLike) {
        return new PhotoRemindersInboxDataLoader(PhotoSuggestionManagerMethodAutoProvider.a(injectorLike), PhotoRemindersGatingUtil.b(injectorLike), new PhotoRemindersInboxDataUtil(), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike));
    }

    protected final ListenableFuture m3403a(Object obj, LoaderResult loaderResult) {
        if (this.f3572b == null || !this.f3573c.a() || this.f3572b.e()) {
            return Futures.a(null);
        }
        if (this.f3572b.d().isEmpty()) {
            return Futures.a(null);
        }
        return Futures.a(this.f3572b.c(), new C05561(this));
    }

    protected final LoaderResult m3404b(Object obj) {
        if (this.f3572b == null || !this.f3573c.a() || this.f3572b.e()) {
            return LoaderResult.b(null);
        }
        ImmutableList d = this.f3572b.d();
        if (d.isEmpty()) {
            return LoaderResult.b(null);
        }
        ImmutableList b = this.f3572b.b();
        PhotoRemindersInboxData a = this.f3574d.m3405a(b);
        if (d.size() != b.size()) {
            Integer.valueOf(b.size());
            Integer.valueOf(d.size());
            return LoaderResult.a(a);
        }
        Integer.valueOf(d.size());
        return LoaderResult.b(a);
    }

    @Inject
    public PhotoRemindersInboxDataLoader(PhotoSuggestionManager photoSuggestionManager, PhotoRemindersGatingUtil photoRemindersGatingUtil, PhotoRemindersInboxDataUtil photoRemindersInboxDataUtil, Executor executor) {
        super(executor);
        this.f3572b = photoSuggestionManager;
        this.f3573c = photoRemindersGatingUtil;
        this.f3574d = photoRemindersInboxDataUtil;
    }
}
