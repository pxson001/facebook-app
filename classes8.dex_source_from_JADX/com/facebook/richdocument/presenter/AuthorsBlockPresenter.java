package com.facebook.richdocument.presenter;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.util.StringUtil;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.friends.FriendingClient;
import com.facebook.graphql.calls.ActorSubscribeInputData;
import com.facebook.graphql.calls.ActorUnsubscribeInputData.SubscribeLocation;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.richdocument.model.block.RichDocumentTextType;
import com.facebook.richdocument.model.block.RichText;
import com.facebook.richdocument.model.block.RichText.RichTextBuilder;
import com.facebook.richdocument.model.data.AuthorBlockData;
import com.facebook.richdocument.model.data.BlockData;
import com.facebook.richdocument.model.data.impl.AuthorBlockDataImpl;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlInterfaces.RichDocumentText;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentAuthorModel.ProfileModel;
import com.facebook.richdocument.view.block.AuthorsBlockView;
import com.facebook.richdocument.view.block.impl.AuthorsBlockViewImpl;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.futures.TasksManager;
import com.google.common.util.concurrent.ListenableFuture;
import javax.inject.Inject;

/* compiled from: photoId */
public class AuthorsBlockPresenter extends AbstractBlockPresenter<AuthorsBlockView, AuthorBlockData> {
    @Inject
    public TasksManager f6392d;
    @Inject
    public PageLikeActionHelper f6393e;
    @Inject
    public Lazy<FriendingClient> f6394f;
    private final String f6395g = "Page";
    private final String f6396h = "User";
    public boolean f6397i;
    private boolean f6398j;
    public GraphQLSubscribeStatus f6399k;

    /* compiled from: photoId */
    /* synthetic */ class C07233 {
        static final /* synthetic */ int[] f6391a = new int[GraphQLSubscribeStatus.values().length];

        static {
            try {
                f6391a[GraphQLSubscribeStatus.CAN_SUBSCRIBE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f6391a[GraphQLSubscribeStatus.IS_SUBSCRIBED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public static void m6780a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        AuthorsBlockPresenter authorsBlockPresenter = (AuthorsBlockPresenter) obj;
        TasksManager b = TasksManager.b(fbInjector);
        PageLikeActionHelper b2 = PageLikeActionHelper.m6819b(fbInjector);
        Lazy a = IdBasedLazy.a(fbInjector, 2073);
        authorsBlockPresenter.f6392d = b;
        authorsBlockPresenter.f6393e = b2;
        authorsBlockPresenter.f6394f = a;
    }

    public final void mo366a(BlockData blockData) {
        AuthorBlockDataImpl authorBlockDataImpl = (AuthorBlockDataImpl) blockData;
        Object obj = null;
        ((AuthorsBlockViewImpl) this.f6382d).mo374a(null);
        final ProfileModel e = authorBlockDataImpl.m5490e();
        AuthorsBlockViewImpl authorsBlockViewImpl = (AuthorsBlockViewImpl) this.f6382d;
        CharSequence a = authorBlockDataImpl.m5487a();
        Context context = getContext();
        RichDocumentText b = authorBlockDataImpl.f5674a.m5833b();
        RichText a2 = new RichTextBuilder(context).m5445a(b).m5444a(RichDocumentTextType.CREDITS).m5446a();
        if (!(e == null || e.mo313g() == null)) {
            obj = e.mo313g().d();
        }
        authorsBlockViewImpl.f6609d.setText(a);
        authorsBlockViewImpl.f6610e.f7393d.setText(a2);
        if (StringUtil.a(obj)) {
            authorsBlockViewImpl.f6611f.setController(null);
        } else {
            authorsBlockViewImpl.f6611f.a(Uri.parse(obj), AuthorsBlockViewImpl.f6606b);
        }
        if (e != null && e.hZ_() != null && e.hZ_().e() != null) {
            if (e.hZ_().e().equals("Page")) {
                this.f6398j = e.mo310b();
                this.f6397i = e.mo311c();
                ((AuthorsBlockViewImpl) this.f6382d).m6948a(this.f6398j, this.f6397i);
                authorsBlockViewImpl = (AuthorsBlockViewImpl) this.f6382d;
                authorsBlockViewImpl.f6613h.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ AuthorsBlockPresenter f6387b;

                    /* compiled from: photoId */
                    class C07191 extends OperationResultFutureCallback {
                        final /* synthetic */ C07201 f6385a;

                        C07191(C07201 c07201) {
                            this.f6385a = c07201;
                        }

                        protected final void m6776a(ServiceException serviceException) {
                            AuthorsBlockPresenter.m6781b(this.f6385a.f6387b);
                        }
                    }

                    public void onClick(View view) {
                        int a = Logger.a(2, EntryType.UI_INPUT_START, 1082663865);
                        AuthorsBlockPresenter.m6781b(this.f6387b);
                        this.f6387b.f6392d.a("instant_article_like_page", this.f6387b.f6393e.m6820a(this.f6387b.f6397i, e.mo312d()), new C07191(this));
                        Logger.a(2, EntryType.UI_INPUT_END, 735128395, a);
                    }
                });
            } else if (e.hZ_().e().equals("User")) {
                this.f6399k = e.ia_();
                ((AuthorsBlockViewImpl) this.f6382d).m6947a(this.f6399k);
                authorsBlockViewImpl = (AuthorsBlockViewImpl) this.f6382d;
                authorsBlockViewImpl.f6614i.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ AuthorsBlockPresenter f6390b;

                    /* compiled from: photoId */
                    class C07211 extends AbstractDisposableFutureCallback<Void> {
                        final /* synthetic */ C07222 f6388a;

                        C07211(C07222 c07222) {
                            this.f6388a = c07222;
                        }

                        protected final void m6779a(Throwable th) {
                            AuthorsBlockPresenter.m6782c(this.f6388a.f6390b);
                        }
                    }

                    public void onClick(View view) {
                        ListenableFuture a;
                        int a2 = Logger.a(2, EntryType.UI_INPUT_START, -1017827411);
                        Object obj = this.f6390b.f6399k == GraphQLSubscribeStatus.IS_SUBSCRIBED ? 1 : null;
                        AuthorsBlockPresenter.m6782c(this.f6390b);
                        TasksManager tasksManager = this.f6390b.f6392d;
                        String str = "instant_article_follow_profile";
                        if (obj != null) {
                            a = ((FriendingClient) this.f6390b.f6394f.get()).a(String.valueOf(e.mo312d()), SubscribeLocation.UNDEFINED);
                        } else {
                            a = ((FriendingClient) this.f6390b.f6394f.get()).a(String.valueOf(e.mo312d()), ActorSubscribeInputData.SubscribeLocation.UNDEFINED);
                        }
                        tasksManager.a(str, a, new C07211(this));
                        LogUtils.a(1861514403, a2);
                    }
                });
            }
        }
    }

    public AuthorsBlockPresenter(AuthorsBlockViewImpl authorsBlockViewImpl) {
        super(authorsBlockViewImpl);
        Class cls = AuthorsBlockPresenter.class;
        m6780a(this, getContext());
    }

    public static void m6781b(AuthorsBlockPresenter authorsBlockPresenter) {
        authorsBlockPresenter.f6397i = !authorsBlockPresenter.f6397i;
        ((AuthorsBlockViewImpl) authorsBlockPresenter.f6382d).m6948a(authorsBlockPresenter.f6398j, authorsBlockPresenter.f6397i);
    }

    public static void m6782c(AuthorsBlockPresenter authorsBlockPresenter) {
        switch (C07233.f6391a[authorsBlockPresenter.f6399k.ordinal()]) {
            case 1:
                authorsBlockPresenter.f6399k = GraphQLSubscribeStatus.IS_SUBSCRIBED;
                break;
            case 2:
                authorsBlockPresenter.f6399k = GraphQLSubscribeStatus.CAN_SUBSCRIBE;
                break;
        }
        ((AuthorsBlockViewImpl) authorsBlockPresenter.f6382d).m6947a(authorsBlockPresenter.f6399k);
    }
}
