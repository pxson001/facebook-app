package com.facebook.friending.jewel.entitycards.loader;

import android.os.Bundle;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.StringUtil;
import com.facebook.entitycards.collect.ImmutableOffsetArray;
import com.facebook.entitycards.collect.OffsetArray;
import com.facebook.entitycards.loader.AvailableIdsLoader;
import com.facebook.entitycards.model.EntityCardsScrollDirection;
import com.facebook.entitycards.service.EntityCardsIdsForPageLoader;
import com.facebook.friends.FriendingQueryExecutor;
import com.facebook.friends.constants.FriendingLocation;
import com.facebook.friends.model.FetchFriendRequestResult;
import com.facebook.friends.model.FetchPeopleYouMayKnowResult;
import com.facebook.friends.model.FriendRequest;
import com.facebook.friends.model.PersonYouMayKnow;
import com.facebook.graphql.model.GraphQLPageInfo;
import com.facebook.inject.Assisted;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Absent;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: filter_type_sets */
public class FriendRequestsIdsPageLoader implements EntityCardsIdsForPageLoader {
    public final FriendingQueryExecutor f13319a;
    public final ExecutorService f13320b;
    private final Optional<String> f13321c;
    private final Optional<FriendingLocation> f13322d;
    public final AvailableIdsLoader f13323e;
    @Nullable
    private final CallerContext f13324f;
    public Optional<String> f13325g;

    @Inject
    public FriendRequestsIdsPageLoader(FriendingQueryExecutor friendingQueryExecutor, ExecutorService executorService, @Assisted AvailableIdsLoader availableIdsLoader, @Assisted CallerContext callerContext, @Nullable @Assisted Bundle bundle) {
        CharSequence charSequence = null;
        this.f13319a = friendingQueryExecutor;
        this.f13320b = executorService;
        this.f13323e = availableIdsLoader;
        this.f13324f = callerContext;
        CharSequence string = bundle != null ? bundle.getString("section_type") : null;
        if (StringUtil.a(string)) {
            this.f13321c = Absent.INSTANCE;
        } else {
            boolean z = "friend_requests".equals(string) || "pymk".equals(string);
            Preconditions.checkArgument(z);
            this.f13321c = Optional.of(string);
        }
        if (bundle != null) {
            string = bundle.getString("end_cursor");
        } else {
            string = null;
        }
        if (StringUtil.a(string)) {
            this.f13325g = Absent.INSTANCE;
        } else {
            this.f13325g = Optional.of(string);
        }
        if (bundle != null) {
            charSequence = bundle.getString("friending_location");
        }
        if (StringUtil.a(charSequence)) {
            this.f13322d = Absent.INSTANCE;
        } else {
            this.f13322d = Optional.of(FriendingLocation.valueOf(bundle.getString("friending_location")));
        }
    }

    public final boolean mo774a(EntityCardsScrollDirection entityCardsScrollDirection) {
        if (entityCardsScrollDirection == EntityCardsScrollDirection.LEFT) {
            return this.f13323e.mo774a(entityCardsScrollDirection);
        }
        if (this.f13323e.mo774a(entityCardsScrollDirection)) {
            return true;
        }
        if (this.f13321c.isPresent() && this.f13322d.isPresent() && this.f13325g.isPresent()) {
            return true;
        }
        return false;
    }

    public final ListenableFuture<ImmutableOffsetArray<String>> mo773a(EntityCardsScrollDirection entityCardsScrollDirection, final int i) {
        if (entityCardsScrollDirection == EntityCardsScrollDirection.LEFT) {
            return this.f13323e.mo773a(entityCardsScrollDirection, i);
        }
        OffsetArray b = this.f13323e.m12952b(entityCardsScrollDirection, i);
        if (!b.m12840c() || !this.f13325g.isPresent()) {
            return Futures.a(b);
        }
        if (!m14968b()) {
            return m14967b(i, this.f13324f);
        }
        return Futures.a(this.f13319a.a((String) this.f13325g.get(), i, this.f13324f), new Function<FetchFriendRequestResult, ImmutableOffsetArray<String>>(this) {
            final /* synthetic */ FriendRequestsIdsPageLoader f13316b;

            public Object apply(@Nullable Object obj) {
                FetchFriendRequestResult fetchFriendRequestResult = (FetchFriendRequestResult) obj;
                Builder builder = ImmutableList.builder();
                ImmutableList immutableList = fetchFriendRequestResult.a;
                int size = immutableList.size();
                for (int i = 0; i < size; i++) {
                    String str = ((FriendRequest) immutableList.get(i)).b;
                    if (!this.f13316b.f13323e.m12951a(str)) {
                        builder.c(str);
                    }
                }
                this.f13316b.f13323e.m12949a(builder.b());
                FriendRequestsIdsPageLoader.m14966a(this.f13316b, fetchFriendRequestResult.b);
                return this.f13316b.f13323e.m12952b(EntityCardsScrollDirection.RIGHT, i);
            }
        }, this.f13320b);
    }

    public final Optional<Bundle> mo772a() {
        if (this.f13321c.isPresent() && this.f13322d.isPresent()) {
            return Optional.of(m14965a((String) this.f13321c.get(), (String) this.f13325g.orNull(), (FriendingLocation) this.f13322d.get()));
        }
        return Absent.INSTANCE;
    }

    public static Bundle m14965a(String str, String str2, FriendingLocation friendingLocation) {
        Bundle bundle = new Bundle();
        bundle.putString("section_type", str);
        bundle.putString("end_cursor", str2);
        bundle.putString("friending_location", friendingLocation.name());
        return bundle;
    }

    public static void m14966a(FriendRequestsIdsPageLoader friendRequestsIdsPageLoader, GraphQLPageInfo graphQLPageInfo) {
        if (graphQLPageInfo == null || !graphQLPageInfo.b() || StringUtil.a(graphQLPageInfo.a())) {
            friendRequestsIdsPageLoader.f13325g = Absent.INSTANCE;
        } else {
            friendRequestsIdsPageLoader.f13325g = Optional.of(graphQLPageInfo.a());
        }
    }

    @VisibleForTesting
    private boolean m14968b() {
        return "friend_requests".equals(this.f13321c.get());
    }

    private ListenableFuture<ImmutableOffsetArray<String>> m14967b(final int i, CallerContext callerContext) {
        return Futures.a(this.f13319a.a((String) this.f13325g.get(), i, null, ((FriendingLocation) this.f13322d.get()).peopleYouMayKnowLocation, callerContext), new Function<FetchPeopleYouMayKnowResult, ImmutableOffsetArray<String>>(this) {
            final /* synthetic */ FriendRequestsIdsPageLoader f13318b;

            public Object apply(@Nullable Object obj) {
                FetchPeopleYouMayKnowResult fetchPeopleYouMayKnowResult = (FetchPeopleYouMayKnowResult) obj;
                Builder builder = ImmutableList.builder();
                ImmutableList immutableList = fetchPeopleYouMayKnowResult.a;
                int size = immutableList.size();
                for (int i = 0; i < size; i++) {
                    String valueOf = String.valueOf(((PersonYouMayKnow) immutableList.get(i)).a());
                    if (!this.f13318b.f13323e.m12951a(valueOf)) {
                        builder.c(valueOf);
                    }
                }
                this.f13318b.f13323e.m12949a(builder.b());
                FriendRequestsIdsPageLoader.m14966a(this.f13318b, fetchPeopleYouMayKnowResult.b);
                return this.f13318b.f13323e.m12952b(EntityCardsScrollDirection.RIGHT, i);
            }
        }, this.f13320b);
    }
}
