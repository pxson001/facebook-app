package com.facebook.pages.identity.fragments.photo;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.auth.module.ViewerContextManagerProvider;
import com.facebook.auth.module.ViewerContextMethodAutoProvider;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.auth.viewercontext.ViewerContext.ViewerContextBuilder;
import com.facebook.auth.viewercontext.ViewerContextManager;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.ipc.composer.intent.ComposerTargetData.Builder;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.adminedpages.AdminedPagesRamCache;
import com.facebook.pages.adminedpages.protocol.AdminedPagesPrefetchNode;
import com.facebook.pages.common.photos.PagesAlbumsListFragment;
import com.facebook.pages.fb4a.abtest.qe.ExperimentsForPagesFb4aAbTestModule;
import com.facebook.photos.photoset.ui.photoset.PandoraAlbumsFragment;
import com.facebook.qe.api.Liveness;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.titlebar.HasTitleBar;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import javax.inject.Inject;

/* compiled from: pages/edit/page/sections/{#%s} */
public class PageIdentityPhotosFragment extends FbFragment {
    public static final CallerContext f4052a = CallerContext.a(PageIdentityPhotosFragment.class, "pages_public_view");
    @Inject
    public Lazy<AdminedPagesRamCache> f4053b;
    @Inject
    public ViewerContext f4054c;
    @Inject
    public ViewerContextManager f4055d;
    @Inject
    public QeAccessor f4056e;

    public static void m4969a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        PageIdentityPhotosFragment pageIdentityPhotosFragment = (PageIdentityPhotosFragment) obj;
        Lazy b = IdBasedSingletonScopeProvider.b(fbInjector, 2928);
        ViewerContext b2 = ViewerContextMethodAutoProvider.b(fbInjector);
        ViewerContextManager b3 = ViewerContextManagerProvider.b(fbInjector);
        QeAccessor qeAccessor = (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector);
        pageIdentityPhotosFragment.f4053b = b;
        pageIdentityPhotosFragment.f4054c = b2;
        pageIdentityPhotosFragment.f4055d = b3;
        pageIdentityPhotosFragment.f4056e = qeAccessor;
    }

    public final void m4971c(Bundle bundle) {
        super.c(bundle);
        Class cls = PageIdentityPhotosFragment.class;
        m4969a(this, getContext());
    }

    public final View m4970a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1499800990);
        View inflate = layoutInflater.inflate(2130906029, viewGroup, false);
        Bundle bundle2 = this.s;
        String string = bundle2.getString("com.facebook.katana.profile.id");
        if (s().a("page_albums_fragment_tag") == null && string != null) {
            String str;
            ArrayList arrayList;
            String str2;
            Fragment a2;
            ArrayList stringArrayList = bundle2.getStringArrayList("extra_pages_admin_permissions");
            String string2 = bundle2.getString("page_admin_profile_pic_url_extra");
            String string3 = bundle2.getString("profile_name");
            AdminedPagesPrefetchNode adminedPagesPrefetchNode = (AdminedPagesPrefetchNode) ((AdminedPagesRamCache) this.f4053b.get()).b(string);
            if (adminedPagesPrefetchNode == null || !adminedPagesPrefetchNode.b().isPresent()) {
                str = string3;
                arrayList = stringArrayList;
                str2 = string2;
            } else {
                if (!this.f4054c.d()) {
                    ViewerContextBuilder newBuilder = ViewerContext.newBuilder();
                    newBuilder.d = true;
                    newBuilder = newBuilder;
                    newBuilder.c = this.f4054c.c();
                    newBuilder = newBuilder;
                    newBuilder.f = this.f4054c.f();
                    newBuilder = newBuilder;
                    newBuilder.e = this.f4054c.e();
                    newBuilder = newBuilder;
                    newBuilder.a = string;
                    ViewerContextBuilder viewerContextBuilder = newBuilder;
                    viewerContextBuilder.b = (String) adminedPagesPrefetchNode.b().get();
                    newBuilder = viewerContextBuilder;
                    newBuilder.g = adminedPagesPrefetchNode.a().d();
                    this.f4055d.a(newBuilder.h());
                }
                if (stringArrayList == null) {
                    stringArrayList = new ArrayList();
                    ImmutableList g = adminedPagesPrefetchNode.a().g();
                    int size = g.size();
                    for (int i = 0; i < size; i++) {
                        stringArrayList.add((String) g.get(i));
                    }
                    arrayList = stringArrayList;
                } else {
                    arrayList = stringArrayList;
                }
                if (!Strings.isNullOrEmpty(string2) || adminedPagesPrefetchNode.a().km_() == null) {
                    str2 = string2;
                } else {
                    str2 = adminedPagesPrefetchNode.a().km_().a();
                }
                str = (!Strings.isNullOrEmpty(string3) || adminedPagesPrefetchNode.a().d() == null) ? string3 : adminedPagesPrefetchNode.a().d();
            }
            Builder builder = new Builder(Long.parseLong(string), TargetType.PAGE);
            builder.f = true;
            builder = builder;
            builder.c = str;
            Builder builder2 = builder;
            builder2.d = str2;
            ComposerTargetData a3 = builder2.a();
            if (this.f4056e.a(Liveness.Live, ExperimentsForPagesFb4aAbTestModule.e, false)) {
                a2 = PagesAlbumsListFragment.m2536a(string, f4052a, arrayList, a3);
            } else {
                a2 = PandoraAlbumsFragment.a(null, string, true, arrayList, a3);
            }
            s().a().a(2131565519, a2, "page_albums_fragment_tag").b();
        }
        LogUtils.f(1537827452, a);
        return inflate;
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 33002299);
        super.mi_();
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            if (this.f4056e.a(Liveness.Live, ExperimentsForPagesFb4aAbTestModule.e, false)) {
                hasTitleBar.y_(2131236737);
                hasTitleBar.c(true);
            } else {
                hasTitleBar.y_(2131235458);
                hasTitleBar.kg_();
            }
        }
        LogUtils.f(-1756856624, a);
    }
}
