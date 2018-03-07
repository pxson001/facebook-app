package com.facebook.messaging.emoji;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.futures.FutureAndCallbackHolder;
import com.facebook.common.gridlayoututils.GridSizingCalculator.Sizes;
import com.facebook.debug.log.BLog;
import com.facebook.fbservice.ops.BlueServiceOperationFactory.OperationFuture;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.emoji.EmojiPageAdapter.C12071;
import com.facebook.messaging.emoji.service.FetchRecentEmojiResult;
import com.facebook.messaging.emoji.storage.MessagingEmojiCache;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.ui.emoji.model.Emoji;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mailing_addresses */
public class RecentEmojiView extends RecyclerView {
    public static final Class f10992h = RecentEmojiView.class;
    @Inject
    public DefaultBlueServiceOperationFactory f10993i;
    @Inject
    public EmojiGridViewAdapterProvider f10994j;
    @Inject
    @ForUiThread
    public ExecutorService f10995k;
    @Inject
    public MessagingEmojiCache f10996l;
    @Nullable
    public EmojiGridViewAdapter f10997m;
    public FutureAndCallbackHolder<OperationResult> f10998n;
    public Sizes f10999o;
    @Nullable
    public C12071 f11000p;

    /* compiled from: mailing_addresses */
    class C12141 implements Listener {
        final /* synthetic */ RecentEmojiView f10990a;

        C12141(RecentEmojiView recentEmojiView) {
            this.f10990a = recentEmojiView;
        }

        public final void mo426a(Emoji emoji) {
            if (this.f10990a.f11000p != null) {
                C12071 c12071 = this.f10990a.f11000p;
                if (c12071.f10954a.f10962f != null) {
                    c12071.f10954a.f10962f.m11332a(emoji);
                }
            }
        }

        public final void mo425a() {
            if (this.f10990a.f11000p != null) {
                C12071 c12071 = this.f10990a.f11000p;
                if (c12071.f10954a.f10962f != null) {
                    c12071.f10954a.f10962f.m11331a();
                }
            }
        }
    }

    /* compiled from: mailing_addresses */
    public class C12152 extends AbstractDisposableFutureCallback<OperationResult> {
        final /* synthetic */ RecentEmojiView f10991a;

        public C12152(RecentEmojiView recentEmojiView) {
            this.f10991a = recentEmojiView;
        }

        public final void m11411a(Object obj) {
            RecentEmojiView.m11413a(this.f10991a, ((FetchRecentEmojiResult) ((OperationResult) obj).h()).f11001a);
            this.f10991a.f10998n = null;
        }

        public final void m11412a(Throwable th) {
            BLog.a(RecentEmojiView.f10992h, "Failed to load recent emoji", th);
            this.f10991a.f10998n = null;
        }
    }

    public static void m11414a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        RecentEmojiView recentEmojiView = (RecentEmojiView) obj;
        DefaultBlueServiceOperationFactory b = DefaultBlueServiceOperationFactory.b(injectorLike);
        EmojiGridViewAdapterProvider emojiGridViewAdapterProvider = (EmojiGridViewAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(EmojiGridViewAdapterProvider.class);
        ExecutorService executorService = (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike);
        MessagingEmojiCache a = MessagingEmojiCache.m11421a(injectorLike);
        recentEmojiView.f10993i = b;
        recentEmojiView.f10994j = emojiGridViewAdapterProvider;
        recentEmojiView.f10995k = executorService;
        recentEmojiView.f10996l = a;
    }

    public RecentEmojiView(Context context, Sizes sizes) {
        super(context);
        this.f10999o = sizes;
        Class cls = RecentEmojiView.class;
        m11414a((Object) this, getContext());
        setLayoutManager(new GridLayoutManager(getContext(), this.f10999o.a));
        ImmutableList immutableList = this.f10996l.f11009a;
        if (immutableList != null) {
            m11413a(this, immutableList);
            return;
        }
        OperationFuture a = BlueServiceOperationFactoryDetour.a(this.f10993i, "fetch_recent_emoji", new Bundle(), ErrorPropagation.BY_EXCEPTION, CallerContext.a(RecentEmojiView.class), -180889614).a();
        C12152 c12152 = new C12152(this);
        this.f10998n = FutureAndCallbackHolder.a(a, c12152);
        Futures.a(a, c12152, this.f10995k);
    }

    public static void m11413a(RecentEmojiView recentEmojiView, ImmutableList immutableList) {
        if (recentEmojiView.f10997m == null) {
            recentEmojiView.f10997m = recentEmojiView.f10994j.m11325a(recentEmojiView.f10999o);
            recentEmojiView.f10997m.f10919k = new C12141(recentEmojiView);
            recentEmojiView.setAdapter(recentEmojiView.f10997m);
        }
        recentEmojiView.f10997m.m11322a(immutableList);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 561603592);
        super.onDetachedFromWindow();
        if (this.f10998n != null) {
            this.f10998n.a(true);
            this.f10998n = null;
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -287521124, a);
    }
}
