package com.facebook.orca.contacts.favorites;

import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.loader.FbLoader.Callback;
import com.facebook.common.util.CollectionUtil;
import com.facebook.contacts.cache.FavoriteContactsCache;
import com.facebook.contacts.picker.UserComparatorByRankingAndName;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.inject.Assisted;
import com.facebook.messaging.contacts.loader.ContactListsCache;
import com.facebook.messaging.contacts.loader.ContactsLoader;
import com.facebook.messaging.contacts.loader.ContactsLoader.Result;
import com.facebook.messaging.contacts.loader.ContactsLoaderFactory;
import com.facebook.user.model.User;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

/* compiled from: onLargeAssetSyncRequest not supported on live listener */
public class DivebarEditFavoritesDataSource {
    public final DivebarEditFavoritesFragment f5925a;
    public final FavoriteContactsCache f5926b;
    public final ContactListsCache f5927c;
    public final ContactsLoaderFactory f5928d;
    public final DefaultBlueServiceOperationFactory f5929e;
    public final DefaultAndroidThreadUtil f5930f;
    public ContactsLoader f5931g;
    public List<User> f5932h;
    public List<User> f5933i;
    public boolean f5934j;
    public boolean f5935k;

    /* compiled from: onLargeAssetSyncRequest not supported on live listener */
    public class C08741 implements Callback<Void, Result, Throwable> {
        final /* synthetic */ DivebarEditFavoritesDataSource f5923a;

        public C08741(DivebarEditFavoritesDataSource divebarEditFavoritesDataSource) {
            this.f5923a = divebarEditFavoritesDataSource;
        }

        public final void m5568b(Object obj, Object obj2) {
            Result result = (Result) obj2;
            DivebarEditFavoritesDataSource divebarEditFavoritesDataSource = this.f5923a;
            boolean z = true;
            if (result != null) {
                divebarEditFavoritesDataSource.f5935k = true;
                boolean z2 = false;
                if (result.b != null && divebarEditFavoritesDataSource.f5934j) {
                    divebarEditFavoritesDataSource.f5932h = new ArrayList(result.b);
                    z2 = true;
                }
                if (result.g != null) {
                    divebarEditFavoritesDataSource.f5933i = DivebarEditFavoritesDataSource.m5572a(result.g, result.m);
                } else {
                    z = z2;
                }
                if (z) {
                    DivebarEditFavoritesFragment.aF(divebarEditFavoritesDataSource.f5925a);
                }
            }
        }

        public final /* bridge */ /* synthetic */ void m5569c(Object obj, Object obj2) {
        }
    }

    /* compiled from: onLargeAssetSyncRequest not supported on live listener */
    public class C08752 extends OperationResultFutureCallback {
        final /* synthetic */ DivebarEditFavoritesDataSource f5924a;

        public C08752(DivebarEditFavoritesDataSource divebarEditFavoritesDataSource) {
            this.f5924a = divebarEditFavoritesDataSource;
        }

        public final void m5571a(Object obj) {
            this.f5924a.f5926b.a(ImmutableList.copyOf(this.f5924a.f5932h));
            this.f5924a.f5925a.m5608b();
        }

        protected final void m5570a(ServiceException serviceException) {
            this.f5924a.f5925a.m5607a((Throwable) serviceException);
        }
    }

    @Inject
    public DivebarEditFavoritesDataSource(@Assisted DivebarEditFavoritesFragment divebarEditFavoritesFragment, FavoriteContactsCache favoriteContactsCache, ContactListsCache contactListsCache, ContactsLoaderFactory contactsLoaderFactory, DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, DefaultAndroidThreadUtil defaultAndroidThreadUtil) {
        this.f5925a = divebarEditFavoritesFragment;
        this.f5926b = favoriteContactsCache;
        this.f5927c = contactListsCache;
        this.f5928d = contactsLoaderFactory;
        this.f5929e = defaultBlueServiceOperationFactory;
        this.f5930f = defaultAndroidThreadUtil;
    }

    public final ImmutableList<User> m5573b() {
        if (this.f5932h == null || this.f5932h.isEmpty()) {
            return RegularImmutableList.a;
        }
        return ImmutableList.copyOf(this.f5932h);
    }

    public final int m5574d() {
        return this.f5932h.size();
    }

    public static List<User> m5572a(List<User> list, List<User> list2) {
        if (CollectionUtil.a(list)) {
            return list2;
        }
        if (CollectionUtil.a(list2)) {
            return list;
        }
        List<User> arrayList = new ArrayList(list.size() + list2.size());
        arrayList.addAll(list);
        arrayList.addAll(list2);
        Collections.sort(arrayList, new UserComparatorByRankingAndName(arrayList));
        return arrayList;
    }
}
