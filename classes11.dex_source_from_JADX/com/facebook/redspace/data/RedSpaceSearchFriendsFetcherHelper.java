package com.facebook.redspace.data;

import android.text.TextUtils;
import com.facebook.debug.log.BLog;
import com.facebook.graphql.executor.GraphQLBatchRequest;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQLRefParam;
import com.facebook.inject.Assisted;
import com.facebook.redspace.fetcher.RedSpaceBatchFetcher;
import com.facebook.redspace.fetcher.RedSpaceBatchRequests;
import com.facebook.redspace.fetcher.RedSpaceBatchRequests.RedSpaceFriendsWithFriendsResult;
import com.facebook.redspace.fetcher.RedSpaceRequests;
import com.facebook.redspace.fetcher.RedSpaceRequests.ExportedParam;
import com.facebook.redspace.fragment.RedSpaceSearchFragment;
import com.facebook.redspace.fragment.RedSpaceSearchFragment.C14322;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ultralight.Inject;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FutureCallback;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;

/* compiled from: Preloading Page Activity tab */
public class RedSpaceSearchFriendsFetcherHelper {
    public static final String f11857a = RedSpaceSearchFriendsFetcherHelper.class.getSimpleName();
    @Inject
    public RedSpaceBatchFetcher f11858b;
    @Inject
    public RedSpaceBatchRequests f11859c;
    @Inject
    public RedSpaceRequests f11860d;
    public final RedSpaceFriendsSearchCollection f11861e;
    public final WeakReference<RedSpaceSearchFriendsFetchListener> f11862f;
    public boolean f11863g = false;

    @Inject
    public RedSpaceSearchFriendsFetcherHelper(@Assisted RedSpaceSearchFragment redSpaceSearchFragment, @Assisted RedSpaceFriendsSearchCollection redSpaceFriendsSearchCollection) {
        Preconditions.checkNotNull(redSpaceSearchFragment, "listener must not be null");
        this.f11861e = redSpaceFriendsSearchCollection;
        this.f11862f = new WeakReference(redSpaceSearchFragment);
    }

    public final void m12313a(String str) {
        if (!this.f11858b.b()) {
            m12314b(str);
        }
    }

    public final boolean m12314b(String str) {
        this.f11858b.a();
        if (!this.f11861e.m12239b(str)) {
            return false;
        }
        m12312c(str);
        return true;
    }

    private void m12312c(final String str) {
        C14091 c14091 = new FutureCallback<RedSpaceFriendsWithFriendsResult>(this) {
            final /* synthetic */ RedSpaceSearchFriendsFetcherHelper f11856b;

            public void onSuccess(@Nullable Object obj) {
                RedSpaceFriendsWithFriendsResult redSpaceFriendsWithFriendsResult = (RedSpaceFriendsWithFriendsResult) obj;
                RedSpaceSearchFriendsFetcherHelper redSpaceSearchFriendsFetcherHelper = this.f11856b;
                String str = str;
                redSpaceSearchFriendsFetcherHelper.f11861e.m12238a(str, redSpaceFriendsWithFriendsResult);
                RedSpaceSearchFragment redSpaceSearchFragment = (RedSpaceSearchFragment) redSpaceSearchFriendsFetcherHelper.f11862f.get();
                if (redSpaceSearchFragment != null) {
                    redSpaceSearchFragment.f11992i.b();
                    AdapterDetour.a(redSpaceSearchFragment.al, 66706947);
                    if (redSpaceSearchFragment.am.m12766a(redSpaceSearchFragment.an)) {
                        redSpaceSearchFragment.f11991h.m12313a(str);
                    }
                    redSpaceSearchFragment.ao.setShowProgress(false);
                }
            }

            public void onFailure(Throwable th) {
                RedSpaceSearchFriendsFetcherHelper redSpaceSearchFriendsFetcherHelper = this.f11856b;
                String str = str;
                BLog.b(RedSpaceSearchFriendsFetcherHelper.f11857a, "Error fetching friends", th);
                redSpaceSearchFriendsFetcherHelper.f11863g = true;
                redSpaceSearchFriendsFetcherHelper.f11861e.m12238a(str, null);
                RedSpaceSearchFragment redSpaceSearchFragment = (RedSpaceSearchFragment) redSpaceSearchFriendsFetcherHelper.f11862f.get();
                if (redSpaceSearchFragment != null) {
                    redSpaceSearchFragment.ao.setShowProgress(false);
                    if (redSpaceSearchFragment.o() != null) {
                        redSpaceSearchFragment.f11992i.a(redSpaceSearchFragment.b(2131230758), new C14322(redSpaceSearchFragment, str));
                        AdapterDetour.a(redSpaceSearchFragment.al, -1642020321);
                    }
                }
            }
        };
        this.f11863g = false;
        RedSpaceSearchFragment redSpaceSearchFragment = (RedSpaceSearchFragment) this.f11862f.get();
        if (redSpaceSearchFragment != null) {
            redSpaceSearchFragment.f11992i.a();
        }
        m12311a(str, c14091);
    }

    private void m12311a(String str, FutureCallback<RedSpaceFriendsWithFriendsResult> futureCallback) {
        String str2;
        ExportedParam exportedParam;
        GraphQLBatchRequest graphQLBatchRequest = new GraphQLBatchRequest("redspace_friends_search");
        RedSpaceRequests redSpaceRequests = this.f11860d;
        String str3 = "top";
        if (TextUtils.isEmpty(str)) {
            str2 = null;
        } else {
            str2 = str;
        }
        String a = this.f11861e.m12237a("top", str);
        if (this.f11861e.m12236a(str).equals("top")) {
            exportedParam = null;
        } else {
            exportedParam = new ExportedParam(Boolean.valueOf(true));
        }
        GraphQLRequest a2 = redSpaceRequests.a(str3, null, str2, a, null, exportedParam, Boolean.valueOf(true), Boolean.valueOf(true), Boolean.valueOf(true), Boolean.valueOf(true));
        GraphQLRefParam b = a2.b("has_more_friends");
        redSpaceRequests = this.f11860d;
        str3 = "others";
        if (TextUtils.isEmpty(str)) {
            str2 = null;
        } else {
            str2 = str;
        }
        a = this.f11861e.m12237a("others", str);
        if (this.f11861e.m12236a(str).equals("top")) {
            exportedParam = new ExportedParam(b);
        } else {
            exportedParam = null;
        }
        this.f11858b.a(graphQLBatchRequest, this.f11859c.a(graphQLBatchRequest, a2, redSpaceRequests.a(str3, null, str2, a, null, exportedParam, Boolean.valueOf(true), Boolean.valueOf(true), Boolean.valueOf(true), Boolean.valueOf(true))), futureCallback);
    }
}
