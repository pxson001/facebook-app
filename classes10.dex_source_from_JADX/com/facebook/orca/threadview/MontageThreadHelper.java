package com.facebook.orca.threadview;

import android.support.annotation.Nullable;
import com.facebook.common.loader.AbstractFbLoaderCallback;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessagesCollection;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.messaging.montage.MontageMessagesHelper;
import com.facebook.messaging.montage.model.MontageThreadInfo;
import com.facebook.orca.threadview.MontageStatusItemViewController.C10921;
import com.facebook.orca.threadview.ThreadViewLoader.Error;
import com.facebook.orca.threadview.ThreadViewLoader.Params;
import com.facebook.orca.threadview.ThreadViewLoader.Result;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

/* compiled from: messenger_context_banner */
public class MontageThreadHelper {
    private final MontageMessagesHelper f7302a;
    private final ThreadViewLoader f7303b;
    public C10921 f7304c;
    public MontageThreadInfo f7305d;
    private ThreadLoaderCallback f7306e;

    /* compiled from: messenger_context_banner */
    class ThreadLoaderCallback extends AbstractFbLoaderCallback<Params, Result, Error> {
        final /* synthetic */ MontageThreadHelper f7301a;

        public ThreadLoaderCallback(MontageThreadHelper montageThreadHelper) {
            this.f7301a = montageThreadHelper;
        }

        public final void m6954b(Object obj, Object obj2) {
            Result result = (Result) obj2;
            this.f7301a.f7305d = new MontageThreadInfo(result.f7611a, result.f7613c);
            if (this.f7301a.f7304c != null) {
                C10921 c10921 = this.f7301a.f7304c;
                if (c10921.f7279a.f7298o != null && c10921.f7279a.f7284a) {
                    MontageStatusItemViewController.m6947a(c10921.f7279a, c10921.f7279a.f7298o);
                }
            }
        }

        public final void m6955c(Object obj, Object obj2) {
            BLog.b(MontageThreadHelper.class, "Error loading montage thread", ((Error) obj2).f7602a);
        }
    }

    public static MontageThreadHelper m6956b(InjectorLike injectorLike) {
        return new MontageThreadHelper(MontageMessagesHelper.b(injectorLike), ThreadViewLoader.m7346b(injectorLike));
    }

    @Inject
    public MontageThreadHelper(MontageMessagesHelper montageMessagesHelper, ThreadViewLoader threadViewLoader) {
        this.f7302a = montageMessagesHelper;
        this.f7303b = threadViewLoader;
    }

    public final void m6957a(@Nullable ThreadKey threadKey) {
        if (threadKey == null) {
            if (this.f7303b != null) {
                this.f7303b.m7349a();
            }
            this.f7305d = null;
            return;
        }
        Preconditions.checkArgument(ThreadKey.j(threadKey));
        if (!(this.f7305d == null || this.f7305d.a.a.equals(threadKey))) {
            this.f7305d = null;
        }
        this.f7303b.m7351a(threadKey);
        if (this.f7306e == null) {
            this.f7306e = new ThreadLoaderCallback(this);
            this.f7303b.m7350a(this.f7306e);
        }
        this.f7303b.m7352a(Params.m7325a(false, false, true));
    }

    public final void m6958a(@Nullable C10921 c10921) {
        this.f7304c = c10921;
        if (this.f7304c == null) {
            this.f7303b.m7349a();
        }
    }

    public final boolean m6959a() {
        return this.f7305d != null && this.f7302a.b(this.f7305d.b);
    }

    public final boolean m6960b() {
        return this.f7305d != null && this.f7302a.b(this.f7305d.b, this.f7305d.a.l);
    }

    public final long m6961c() {
        if (this.f7305d == null) {
            return -1;
        }
        MontageMessagesHelper montageMessagesHelper = this.f7302a;
        MessagesCollection messagesCollection = this.f7305d.b;
        long j = -1;
        if (messagesCollection != null) {
            ImmutableList a = montageMessagesHelper.a(messagesCollection);
            if (a != null && a.size() > 0) {
                j = ((Message) a.get(0)).c;
            }
        }
        return j;
    }
}
