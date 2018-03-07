package com.facebook.pages.common.photos;

import android.os.Bundle;
import android.os.ParcelUuid;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.base.fragment.FbFragment;
import com.facebook.inject.Lazy;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.ipc.composer.intent.ComposerTargetData.Builder;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.pages.adminedpages.AdminedPagesRamCache;
import com.facebook.pages.adminedpages.protocol.AdminedPagesPrefetchNode;
import com.facebook.photos.photoset.ui.photoset.PandoraCustomizedBackgroundConfig;
import com.facebook.qe.api.QeAccessor;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: setStyle() not called */
public class PagesPhotosFragmentUtils {
    private final ViewerContext f1743a;
    private final ViewerContextManager f1744b;
    private final Lazy<AdminedPagesRamCache> f1745c;
    private final QeAccessor f1746d;

    @Inject
    public PagesPhotosFragmentUtils(ViewerContext viewerContext, ViewerContextManager viewerContextManager, Lazy<AdminedPagesRamCache> lazy, QeAccessor qeAccessor) {
        this.f1743a = viewerContext;
        this.f1744b = viewerContextManager;
        this.f1745c = lazy;
        this.f1746d = qeAccessor;
    }

    public final Bundle m2560a(String str, ParcelUuid parcelUuid, @Nullable String str2, @Nullable ArrayList<String> arrayList, @Nullable String str3) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(parcelUuid);
        Bundle bundle = new Bundle();
        AdminedPagesPrefetchNode adminedPagesPrefetchNode = (AdminedPagesPrefetchNode) ((AdminedPagesRamCache) this.f1745c.get()).b(str);
        if (adminedPagesPrefetchNode != null && adminedPagesPrefetchNode.b.isPresent()) {
            if (arrayList == null) {
                arrayList = new ArrayList();
                ImmutableList g = adminedPagesPrefetchNode.a.g();
                int size = g.size();
                for (int i = 0; i < size; i++) {
                    arrayList.add((String) g.get(i));
                }
            }
            if (Strings.isNullOrEmpty(str3) && adminedPagesPrefetchNode.a.km_() != null) {
                str3 = adminedPagesPrefetchNode.a.km_().a();
            }
            if (Strings.isNullOrEmpty(str2) && adminedPagesPrefetchNode.a.d() != null) {
                str2 = adminedPagesPrefetchNode.a.d();
            }
        }
        Builder builder = new Builder(Long.parseLong(str), TargetType.PAGE);
        builder.f = true;
        builder = builder;
        builder.c = str2;
        builder = builder;
        builder.d = str3;
        ComposerTargetData a = builder.a();
        bundle.putLong("owner_id", Long.parseLong(str));
        if (arrayList != null) {
            bundle.putStringArrayList("extra_pages_admin_permissions", arrayList);
        }
        if (a != null) {
            bundle.putParcelable("extra_composer_target_data", a);
        }
        bundle.putParcelable("page_fragment_uuid", parcelUuid);
        return bundle;
    }

    public static FbFragment m2559a(Bundle bundle) {
        long j = bundle.getLong("owner_id", -1);
        if (j == -1) {
            throw new IllegalArgumentException("Invalid page id " + j);
        }
        String valueOf = String.valueOf(j);
        ArrayList stringArrayList = bundle.getStringArrayList("extra_pages_admin_permissions");
        ComposerTargetData composerTargetData = (ComposerTargetData) bundle.getParcelable("extra_composer_target_data");
        PagesPhotosFragment pagesPhotosFragment = new PagesPhotosFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putLong("owner_id", Long.parseLong(valueOf));
        bundle2.putBoolean("is_page", true);
        bundle2.putParcelable("customized_res", new PandoraCustomizedBackgroundConfig(0, -1));
        if (stringArrayList != null) {
            bundle2.putStringArrayList("extra_pages_admin_permissions", stringArrayList);
        }
        if (composerTargetData != null) {
            bundle2.putParcelable("extra_composer_target_data", composerTargetData);
        }
        pagesPhotosFragment.g(bundle2);
        return pagesPhotosFragment;
    }
}
