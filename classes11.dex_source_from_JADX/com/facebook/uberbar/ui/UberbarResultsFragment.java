package com.facebook.uberbar.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.facebook.base.fragment.FbListFragment;
import com.facebook.common.android.InputMethodManagerMethodAutoProvider;
import com.facebook.common.android.LayoutInflaterMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.common.util.StringUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.controller.mutation.MutationCallback;
import com.facebook.controller.mutation.RawLikeHelper;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.friends.constants.FriendRequestMakeRef;
import com.facebook.friends.controllers.FriendingButtonController;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.search.api.GraphSearchQuery;
import com.facebook.search.api.SearchTypeaheadResult;
import com.facebook.search.api.SearchTypeaheadResult.Type;
import com.facebook.timeline.intent.ModelBundle;
import com.facebook.timeline.intent.ModelBundleGraphQLModels.ModelBundleProfileGraphQLModel.Builder;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.uberbar.analytics.UberbarResultsAnalyticHelper;
import com.facebook.uberbar.core.UberbarResultFetcher;
import com.facebook.uberbar.core.UberbarResultFetcherFactory;
import com.facebook.uberbar.ui.UberSearchResultsAdapter.FetchStatus;
import com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.List;

/* compiled from: nearby_places_get_location_task_key */
public class UberbarResultsFragment extends FbListFragment {
    public static final String al = UberbarResultsFragment.class.getSimpleName();
    private static final List<SearchTypeaheadResult> f5152i = Collections.emptyList();
    private final C06721 am = new C06721(this);
    public UberSearchResultsAdapter an;
    public InputMethodManager ao;
    private UberbarResultFetcherFactory ap;
    private FbUriIntentHandler aq;
    public AbstractFbErrorReporter ar;
    public UberbarResultsAnalyticHelper as;
    private SecureContextHelper at;
    public FriendingButtonController au;
    public RawLikeHelper av;
    public String aw;
    private UberbarResultFetcher ax;

    /* compiled from: nearby_places_get_location_task_key */
    public class C06721 {
        public final /* synthetic */ UberbarResultsFragment f5143a;

        C06721(UberbarResultsFragment uberbarResultsFragment) {
            this.f5143a = uberbarResultsFragment;
        }
    }

    /* compiled from: nearby_places_get_location_task_key */
    public class C06732 implements OnItemClickListener {
        final /* synthetic */ UberbarResultsFragment f5144a;

        public C06732(UberbarResultsFragment uberbarResultsFragment) {
            this.f5144a = uberbarResultsFragment;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            this.f5144a.ao.hideSoftInputFromWindow(this.f5144a.T.getWindowToken(), 0);
            Object item = this.f5144a.an.getItem(i);
            if (item instanceof SearchTypeaheadResult) {
                String str;
                SearchTypeaheadResult searchTypeaheadResult = (SearchTypeaheadResult) item;
                this.f5144a.as.a(searchTypeaheadResult, this.f5144a.aw, i, this.f5144a.an.f5101d);
                Bundle bundle = new Bundle();
                bundle.putString("search_identifier", searchTypeaheadResult.l.name());
                switch (C06797.f5151a[searchTypeaheadResult.l.ordinal()]) {
                    case 1:
                        String str2 = FBLinks.a("profile/") + searchTypeaheadResult.m;
                        bundle.putSerializable("timeline_friend_request_ref", FriendRequestMakeRef.SEARCH);
                        Builder builder = new Builder();
                        builder.d = searchTypeaheadResult.k;
                        DefaultImageFieldsModel.Builder builder2 = new DefaultImageFieldsModel.Builder();
                        builder2.b = searchTypeaheadResult.f.toString();
                        builder.e = builder2.a();
                        if (searchTypeaheadResult.c != null) {
                            builder.b = GraphQLFriendshipStatus.fromString(searchTypeaheadResult.c.name());
                        }
                        ModelBundle.a(bundle, builder.a());
                        str = str2;
                        break;
                    case 2:
                        str = FBLinks.a("group/") + searchTypeaheadResult.m;
                        break;
                    case 3:
                        if (searchTypeaheadResult.d == null) {
                            str = searchTypeaheadResult.e.toString();
                            break;
                        } else {
                            str = searchTypeaheadResult.d.toString();
                            break;
                        }
                    case 4:
                        str = FBLinks.a("page/") + searchTypeaheadResult.m;
                        break;
                    case 5:
                        str = FBLinks.a("event/") + searchTypeaheadResult.m;
                        break;
                    case 6:
                        str = searchTypeaheadResult.e.toString();
                        break;
                    default:
                        this.f5144a.ar.a(UberbarResultsFragment.al, "Unrecognized result type: " + searchTypeaheadResult.l);
                        return;
                }
                UberbarResultsFragment.m6401b(this.f5144a, this.f5144a.getContext(), str, bundle);
            }
        }
    }

    /* compiled from: nearby_places_get_location_task_key */
    public class C06743 implements OnScrollListener {
        final /* synthetic */ UberbarResultsFragment f5145a;

        public C06743(UberbarResultsFragment uberbarResultsFragment) {
            this.f5145a = uberbarResultsFragment;
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i != 0) {
                this.f5145a.ao.hideSoftInputFromWindow(this.f5145a.T.getWindowToken(), 0);
            }
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    }

    /* compiled from: nearby_places_get_location_task_key */
    public class C06754 {
        public final /* synthetic */ UberbarResultsFragment f5146a;

        public C06754(UberbarResultsFragment uberbarResultsFragment) {
            this.f5146a = uberbarResultsFragment;
        }
    }

    /* compiled from: nearby_places_get_location_task_key */
    public class C06765 {
        public final /* synthetic */ UberbarResultsFragment f5147a;

        public C06765(UberbarResultsFragment uberbarResultsFragment) {
            this.f5147a = uberbarResultsFragment;
        }
    }

    /* compiled from: nearby_places_get_location_task_key */
    public class C06786 {
        final /* synthetic */ UberbarResultsFragment f5150a;

        public C06786(UberbarResultsFragment uberbarResultsFragment) {
            this.f5150a = uberbarResultsFragment;
        }

        public final void m6400a(final SearchTypeaheadResult searchTypeaheadResult, int i) {
            this.f5150a.as.c(searchTypeaheadResult, this.f5150a.aw, this.f5150a.an.f5101d, i);
            this.f5150a.av.a(String.valueOf(searchTypeaheadResult.m), true, null, "album_permalink", null, "search", null, false, new MutationCallback<String>(this) {
                final /* synthetic */ C06786 f5149b;

                public final /* bridge */ /* synthetic */ void m6398b(Object obj) {
                }

                public final /* bridge */ /* synthetic */ void m6399c(Object obj) {
                }

                public final void m6396a(Object obj) {
                    searchTypeaheadResult.x = true;
                    AdapterDetour.a(this.f5149b.f5150a.an, 616795409);
                }

                public final void m6397a(Object obj, ServiceException serviceException) {
                    searchTypeaheadResult.x = false;
                    AdapterDetour.a(this.f5149b.f5150a.an, 504904014);
                }
            });
        }
    }

    /* compiled from: nearby_places_get_location_task_key */
    /* synthetic */ class C06797 {
        static final /* synthetic */ int[] f5151a = new int[Type.values().length];

        static {
            try {
                f5151a[Type.USER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f5151a[Type.GROUP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f5151a[Type.APP.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f5151a[Type.PAGE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f5151a[Type.EVENT.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f5151a[Type.HASHTAG_EXACT.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    public final void m6405a(String str) {
        Preconditions.checkNotNull(str);
        this.aw = str;
        if (StringUtil.a(str)) {
            this.an.m6386a(f5152i, FetchStatus.NO_QUERY);
        }
        if (this.ax != null) {
            this.ax.b();
            this.ax.o = null;
        }
        this.ax = this.ap.a(500, GraphSearchQuery.a(str), this.as.a);
        this.ax.o = this.am;
        this.ax.a();
    }

    public final void m6404a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 332358288);
        super.a(bundle);
        FbInjector fbInjector = FbInjector.get(getContext());
        this.aq = FbUriIntentHandler.a(fbInjector);
        this.an = new UberSearchResultsAdapter(LayoutInflaterMethodAutoProvider.b(fbInjector), FbNetworkManager.a(fbInjector));
        this.an.f5104g = new C06754(this);
        this.an.f5103f = new C06765(this);
        this.an.f5105h = new C06786(this);
        this.ap = UberbarResultFetcherFactory.b(fbInjector);
        this.ao = InputMethodManagerMethodAutoProvider.b(fbInjector);
        this.ar = (AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector);
        this.at = (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector);
        this.au = FriendingButtonController.b(fbInjector);
        this.ax = null;
        this.av = RawLikeHelper.b(fbInjector);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1518504942, a);
    }

    public final View m6403a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -672307916);
        View inflate = layoutInflater.inflate(2130907586, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 194981563, a);
        return inflate;
    }

    public final void m6406d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -420022892);
        super.d(bundle);
        ListView a2 = a();
        a2.setAdapter(this.an);
        a2.setOnItemClickListener(new C06732(this));
        a2.setOnScrollListener(new C06743(this));
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1343080810, a);
    }

    public static void m6401b(UberbarResultsFragment uberbarResultsFragment, Context context, String str, Bundle bundle) {
        if (!uberbarResultsFragment.aq.a(context, str, bundle)) {
            try {
                uberbarResultsFragment.at.b(new Intent("android.intent.action.VIEW", Uri.parse(str)), context);
            } catch (Throwable e) {
                uberbarResultsFragment.ar.a(al, "Failed to launch activity.", e);
            }
        }
    }

    public final void m6402I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1969211299);
        super.I();
        if (this.ax != null) {
            this.ax.b();
            this.ax.o = null;
            this.ax = null;
        }
        this.an.f5103f = null;
        this.an.f5104g = null;
        this.an.f5105h = null;
        this.an = null;
        this.au.d = true;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -526117591, a);
    }
}
