package com.facebook.tagging.graphql.data;

import com.facebook.common.executors.ListeningScheduledExecutorService_ForNonUiThreadMethodAutoProvider;
import com.facebook.goodfriends.data.FriendData;
import com.facebook.goodfriends.data.FriendStateFetcher;
import com.facebook.goodfriends.data.FriendStateFetcher.Callback;
import com.facebook.goodfriends.data.GoodFriendsSearchEngine;
import com.facebook.inject.InjectorLike;
import com.facebook.tagging.data.TagTypeaheadDataSource;
import com.facebook.tagging.data.TagTypeaheadDataSource.SourceResultsListener;
import com.facebook.tagging.data.TagTypeaheadDataSource.TagTypeaheadDataType;
import com.facebook.tagging.data.TaggingProfiles;
import com.facebook.tagging.model.TaggingProfile.Type;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.user.model.Name;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: dest_name */
public class GoodFriendsTaggingTypeaheadDataSource extends TagTypeaheadDataSource {
    public final Executor f17416a;
    private final FriendStateFetcher f17417b;
    public final TaggingProfiles f17418c;
    public final GoodFriendsSearchEngine f17419d;

    public static GoodFriendsTaggingTypeaheadDataSource m25236b(InjectorLike injectorLike) {
        return new GoodFriendsTaggingTypeaheadDataSource((Executor) ListeningScheduledExecutorService_ForNonUiThreadMethodAutoProvider.a(injectorLike), FriendStateFetcher.m17453b(injectorLike), TaggingProfiles.m25203b(injectorLike), GoodFriendsSearchEngine.m17458b(injectorLike));
    }

    @Inject
    public GoodFriendsTaggingTypeaheadDataSource(Executor executor, FriendStateFetcher friendStateFetcher, TaggingProfiles taggingProfiles, GoodFriendsSearchEngine goodFriendsSearchEngine) {
        this.f17416a = executor;
        this.f17417b = friendStateFetcher;
        this.f17418c = taggingProfiles;
        this.f17419d = goodFriendsSearchEngine;
    }

    public final void mo1314a(final CharSequence charSequence, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, final SourceResultsListener sourceResultsListener) {
        if (charSequence != null) {
            this.f17417b.m17454a(false, new Callback(this) {
                final /* synthetic */ GoodFriendsTaggingTypeaheadDataSource f17415c;

                public final void mo1320a(final ImmutableList<FriendData> immutableList, int i, ImmutableList<FriendData> immutableList2) {
                    ExecutorDetour.a(this.f17415c.f17416a, new Runnable(this) {
                        final /* synthetic */ C12691 f17412b;

                        public void run() {
                            Builder builder = new Builder();
                            ImmutableList a = this.f17412b.f17415c.f17419d.m17459a(immutableList, charSequence.toString());
                            int size = a.size();
                            for (int i = 0; i < size; i++) {
                                FriendData friendData = (FriendData) a.get(i);
                                if (friendData.m17446b()) {
                                    builder.c(this.f17412b.f17415c.f17418c.m25206a(new Name(friendData.f10889b), Long.parseLong(friendData.f10888a), friendData.f10890c.toString(), Type.USER, "goodfriends_fetcher", TagTypeaheadDataType.GOOD_FRIENDS.toString()));
                                }
                            }
                            sourceResultsListener.mo1121a(charSequence, builder.b());
                        }
                    }, 96710357);
                }

                public final void mo1321a(Throwable th) {
                }
            });
        }
    }

    public final boolean mo1315a() {
        return true;
    }

    public final String mo1316b() {
        return "goodfriends_fetcher";
    }

    public final ImmutableList<String> mo1319d() {
        Builder builder = new Builder();
        builder.c(TagTypeaheadDataType.GOOD_FRIENDS.toString());
        return builder.b();
    }
}
