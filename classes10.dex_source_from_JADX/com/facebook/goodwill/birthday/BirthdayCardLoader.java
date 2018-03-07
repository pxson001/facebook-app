package com.facebook.goodwill.birthday;

import android.net.Uri;
import android.view.animation.AnimationUtils;
import com.facebook.api.feed.data.FeedUnitCollection;
import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.goodwill.birthday.BirthdayCardFragment.C29894;
import com.facebook.goodwill.birthday.BirthdayCardHeaderView.C29921;
import com.facebook.goodwill.birthday.FetchBirthdayCardDataGraphQL.BirthdayCardDataQueryString;
import com.facebook.goodwill.birthday.FetchBirthdayCardDataGraphQL.BirthdayCardMoreStoriesQueryString;
import com.facebook.graphql.executor.GraphQLQueryFuture;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.model.GraphQLImageAtRange;
import com.facebook.graphql.model.ImageUtil;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import javax.inject.Inject;

/* compiled from: WEBVIEW_BANNER_LEGACY */
public class BirthdayCardLoader implements IHaveUserData {
    public final FeedUnitCollection f21030a;
    public final TasksManager f21031b;
    public BirthdayCardLoaderProtocol f21032c;
    public C29894 f21033d;
    public BirthdayCardResources f21034e;
    public boolean f21035f;

    /* compiled from: WEBVIEW_BANNER_LEGACY */
    public class C29931 implements Callable<ListenableFuture> {
        final /* synthetic */ BirthdayCardLoader f21028a;

        public C29931(BirthdayCardLoader birthdayCardLoader) {
            this.f21028a = birthdayCardLoader;
        }

        public Object call() {
            return this.f21028a.m22017a(false);
        }
    }

    /* compiled from: WEBVIEW_BANNER_LEGACY */
    public class LoadStoriesCallback extends AbstractDisposableFutureCallback<BirthdayCardStories> {
        final /* synthetic */ BirthdayCardLoader f21029a;

        public LoadStoriesCallback(BirthdayCardLoader birthdayCardLoader) {
            this.f21029a = birthdayCardLoader;
        }

        protected final void m22013a(Object obj) {
            BirthdayCardStories birthdayCardStories = (BirthdayCardStories) obj;
            BirthdayCardLoader.m22016b(this.f21029a, false);
            if (birthdayCardStories != null) {
                boolean z;
                this.f21029a.f21030a.a((ImmutableList) Preconditions.checkNotNull(birthdayCardStories.f21050a), birthdayCardStories.f21052c);
                BirthdayCardLoader birthdayCardLoader = this.f21029a;
                if (birthdayCardStories.f21052c.b()) {
                    z = false;
                } else {
                    z = true;
                }
                birthdayCardLoader.f21035f = z;
                this.f21029a.f21034e = birthdayCardStories.f21051b;
                C29894 c29894 = this.f21029a.f21033d;
                BirthdayCardHeaderView birthdayCardHeaderView = c29894.f21006a.ar;
                BirthdayCardResources birthdayCardResources = c29894.f21006a.f21009a.f21034e;
                if (birthdayCardResources != null) {
                    birthdayCardHeaderView.f21027i = birthdayCardResources;
                    birthdayCardHeaderView.f21022d.setText(birthdayCardHeaderView.f21027i.f21043a);
                    if (birthdayCardHeaderView.f21027i.f21044b != null) {
                        Uri uri;
                        CharSequence a = birthdayCardHeaderView.f21027i.f21044b.a();
                        ImmutableList d = birthdayCardHeaderView.f21027i.f21044b.d();
                        if (d == null || d.isEmpty() || ((GraphQLImageAtRange) d.get(0)).j() == null || ((GraphQLImageAtRange) d.get(0)).j().l() == null) {
                            uri = null;
                        } else {
                            uri = ImageUtil.a(((GraphQLImageAtRange) d.get(0)).j().l());
                        }
                        birthdayCardHeaderView.f21023e.setText(a);
                        birthdayCardHeaderView.f21025g.a(uri, BirthdayCardHeaderView.f21019b);
                    }
                    if (birthdayCardHeaderView.f21027i.f21045c != null) {
                        birthdayCardHeaderView.f21024f.a(Uri.parse(birthdayCardHeaderView.f21027i.f21045c), BirthdayCardHeaderView.f21019b);
                    }
                    birthdayCardHeaderView.f21026h.setText(birthdayCardHeaderView.f21027i.f21048f);
                    birthdayCardHeaderView.f21026h.setOnClickListener(new C29921(birthdayCardHeaderView));
                    birthdayCardHeaderView.startAnimation(AnimationUtils.loadAnimation(birthdayCardHeaderView.getContext(), 2130968635));
                    birthdayCardHeaderView.setVisibility(0);
                    birthdayCardHeaderView.requestLayout();
                }
                c29894.f21006a.am.a(BirthdayCardFragment.at(c29894.f21006a));
                BirthdayCardFragment.as(c29894.f21006a).notifyDataSetChanged();
                if (this.f21029a.f21035f) {
                    c29894 = this.f21029a.f21033d;
                    c29894.f21006a.aq.b(c29894.f21006a.at);
                    c29894.f21006a.aq.e(c29894.f21006a.as);
                }
            }
        }

        protected final void m22014a(Throwable th) {
            BirthdayCardLoader.m22016b(this.f21029a, false);
        }
    }

    /* compiled from: WEBVIEW_BANNER_LEGACY */
    public enum Task {
        LOAD_INITIAL_FEED,
        LOAD_NEXT_PAGE
    }

    public static BirthdayCardLoader m22015b(InjectorLike injectorLike) {
        return new BirthdayCardLoader(TasksManager.b(injectorLike), FeedUnitCollection.b(injectorLike));
    }

    @Inject
    public BirthdayCardLoader(TasksManager tasksManager, FeedUnitCollection feedUnitCollection) {
        this.f21031b = tasksManager;
        this.f21030a = feedUnitCollection;
    }

    public final ListenableFuture<BirthdayCardStories> m22017a(boolean z) {
        GraphQLRequest a;
        Function function;
        m22016b(this, true);
        BirthdayCardLoaderProtocol birthdayCardLoaderProtocol = this.f21032c;
        String r = z ? null : this.f21030a.r();
        Object obj = r == null ? 1 : null;
        GraphQlQueryString birthdayCardDataQueryString;
        if (obj != null) {
            birthdayCardDataQueryString = new BirthdayCardDataQueryString();
            birthdayCardDataQueryString.a("first", Integer.valueOf(birthdayCardLoaderProtocol.f21042e));
            birthdayCardDataQueryString.a("default_image_scale", GraphQlQueryDefaults.a());
            a = GraphQLRequest.a(birthdayCardDataQueryString);
        } else {
            birthdayCardDataQueryString = new BirthdayCardMoreStoriesQueryString();
            birthdayCardDataQueryString.a("after", r);
            birthdayCardDataQueryString.a("first", Integer.valueOf(birthdayCardLoaderProtocol.f21042e));
            a = GraphQLRequest.a(birthdayCardDataQueryString);
        }
        GraphQLQueryFuture a2 = birthdayCardLoaderProtocol.f21041d.a(a);
        if (obj != null) {
            function = birthdayCardLoaderProtocol.f21038a;
        } else {
            function = birthdayCardLoaderProtocol.f21039b;
        }
        return Futures.a(a2, function, birthdayCardLoaderProtocol.f21040c);
    }

    public static void m22016b(BirthdayCardLoader birthdayCardLoader, boolean z) {
        BirthdayCardFragment.m22005b(z, birthdayCardLoader.f21033d.f21006a.au);
    }

    public void clearUserData() {
        this.f21031b.c();
        this.f21030a.m();
        this.f21035f = false;
    }
}
