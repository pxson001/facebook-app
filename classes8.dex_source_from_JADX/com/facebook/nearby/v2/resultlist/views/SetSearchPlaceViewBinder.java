package com.facebook.nearby.v2.resultlist.views;

import android.location.Location;
import android.support.v4.util.Pair;
import android.text.TextUtils;
import com.facebook.common.util.CollectionUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.location.FbLocationCache;
import com.facebook.location.ImmutableLocation;
import com.facebook.maps.MapsLocationUtils;
import com.facebook.nearby.v2.model.NearbyPlacesPlaceModel;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLModels.BrowseNearbyPlacesFullImageFragmentModel;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLModels.NearbyPagePlaceInfoFragmentModel.AddressModel;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLModels.NearbyPagePlaceInfoFragmentModel.OverallStarRatingModel;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLModels.NearbyPlacesFriendsWhoVisitedFragmentModel.FriendsWhoVisitedModel;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLModels.NearbyPlacesFriendsWhoVisitedFragmentModel.FriendsWhoVisitedModel.SocialContextModel;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLModels.NearbyPlacesFriendsWhoVisitedFragmentModel.FriendsWhoVisitedModel.SocialContextModel.RangesModel;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLModels.Photo320FragmentModel;
import com.facebook.nearby.v2.resultlist.util.NearbyPlacesV2OpenNowStatusHelper;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: data1 LIKE ? AND mimetype = ? */
public class SetSearchPlaceViewBinder {
    private static volatile SetSearchPlaceViewBinder f15970c;
    private final FbLocationCache f15971a;
    private final MapsLocationUtils f15972b;

    public static com.facebook.nearby.v2.resultlist.views.SetSearchPlaceViewBinder m18783a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f15970c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.nearby.v2.resultlist.views.SetSearchPlaceViewBinder.class;
        monitor-enter(r1);
        r0 = f15970c;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m18785b(r0);	 Catch:{ all -> 0x0035 }
        f15970c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f15970c;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.nearby.v2.resultlist.views.SetSearchPlaceViewBinder.a(com.facebook.inject.InjectorLike):com.facebook.nearby.v2.resultlist.views.SetSearchPlaceViewBinder");
    }

    private static SetSearchPlaceViewBinder m18785b(InjectorLike injectorLike) {
        return new SetSearchPlaceViewBinder(FbLocationCache.b(injectorLike), MapsLocationUtils.b(injectorLike));
    }

    @Inject
    public SetSearchPlaceViewBinder(FbLocationCache fbLocationCache, MapsLocationUtils mapsLocationUtils) {
        this.f15971a = fbLocationCache;
        this.f15972b = mapsLocationUtils;
    }

    public final void m18787a(SetSearchPlaceView setSearchPlaceView, NearbyPlacesPlaceModel nearbyPlacesPlaceModel) {
        if (setSearchPlaceView != null) {
            String str;
            double d;
            int i;
            Boolean bool;
            CharSequence a = nearbyPlacesPlaceModel.m17737a();
            if (TextUtils.isEmpty(a)) {
                SetSearchPlaceView.m18770a(setSearchPlaceView.f15966w, false);
            } else {
                setSearchPlaceView.f15966w.setText(a);
                SetSearchPlaceView.m18770a(setSearchPlaceView.f15966w, true);
            }
            if (nearbyPlacesPlaceModel.m17740d() == null) {
                str = null;
            } else {
                str = nearbyPlacesPlaceModel.m17740d().m17807d();
            }
            setSearchPlaceView.setThumbnailUrl(str);
            OverallStarRatingModel n = nearbyPlacesPlaceModel.m17750n();
            if (n == null) {
                d = 0.0d;
                i = 0;
            } else {
                d = n.m17867c();
                i = n.m17862a();
            }
            ImmutableList k = nearbyPlacesPlaceModel.m17747k();
            String str2 = CollectionUtil.a(k) ? null : (String) k.get(0);
            if (!nearbyPlacesPlaceModel.m17754v() || TextUtils.isEmpty(nearbyPlacesPlaceModel.m17743g())) {
                bool = null;
            } else {
                bool = Boolean.valueOf(NearbyPlacesV2OpenNowStatusHelper.m18718a(nearbyPlacesPlaceModel.m17749m(), nearbyPlacesPlaceModel.m17743g()));
            }
            setSearchPlaceView.m18774a(d, i, str2, nearbyPlacesPlaceModel.m17744h(), bool);
            m18784a(setSearchPlaceView, nearbyPlacesPlaceModel, this.f15972b, this.f15971a.a());
            m18786e(setSearchPlaceView, nearbyPlacesPlaceModel);
        }
    }

    private static void m18784a(SetSearchPlaceView setSearchPlaceView, NearbyPlacesPlaceModel nearbyPlacesPlaceModel, MapsLocationUtils mapsLocationUtils, ImmutableLocation immutableLocation) {
        String str;
        String str2 = null;
        AddressModel c = nearbyPlacesPlaceModel.m17739c();
        Location f = nearbyPlacesPlaceModel.m17742f();
        if (immutableLocation == null || f == null) {
            str = null;
        } else {
            str = mapsLocationUtils.a(immutableLocation, ImmutableLocation.a(f), 80467.203125d, null);
        }
        if (c != null) {
            str2 = c.m17838b();
        }
        setSearchPlaceView.m18775a(str2, "", str);
    }

    private static void m18786e(SetSearchPlaceView setSearchPlaceView, NearbyPlacesPlaceModel nearbyPlacesPlaceModel) {
        List list;
        Builder builder;
        String str;
        List list2 = null;
        ImmutableList l = nearbyPlacesPlaceModel.m17748l();
        if (CollectionUtil.a(l)) {
            list = null;
        } else {
            builder = new Builder();
            int size = l.size();
            for (int i = 0; i < size; i++) {
                BrowseNearbyPlacesFullImageFragmentModel ke_ = ((Photo320FragmentModel) l.get(i)).ke_();
                Object d = (ke_ == null || ke_.m17807d() == null) ? "" : ke_.m17807d();
                builder.c(d);
            }
            list = builder.b();
        }
        setSearchPlaceView.setPhotoUrls(list);
        ImmutableList immutableList = null;
        if (3 >= null) {
            ImmutableList i2 = nearbyPlacesPlaceModel.m17745i();
            if (i2 != null) {
                immutableList = i2.subList(0, Math.min(i2.size(), 3));
            }
        }
        List list3 = immutableList;
        FriendsWhoVisitedModel e = nearbyPlacesPlaceModel.m17741e();
        if (e != null) {
            SocialContextModel c = e.m17969c();
            if (c != null) {
                String b = c.m17961b();
                builder = new Builder();
                ImmutableList a = c.m17960a();
                int size2 = a.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    RangesModel rangesModel = (RangesModel) a.get(i3);
                    builder.c(Pair.a(Integer.valueOf(rangesModel.m17955b()), Integer.valueOf(rangesModel.m17951a())));
                }
                list2 = builder.b();
                str = b;
                setSearchPlaceView.m18776a(list3, str, list2);
            }
        }
        str = null;
        setSearchPlaceView.m18776a(list3, str, list2);
    }
}
