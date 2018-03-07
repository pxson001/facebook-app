package com.facebook.localcontent.menus.admin.manager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.auth.viewercontext.ViewerContext;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.content.event.FbEvent;
import com.facebook.fbui.dialog.ProgressDialog;
import com.facebook.fbui.widget.contentview.CheckedContentView;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.Lazy;
import com.facebook.localcontent.analytics.LocalContentMenuLogger;
import com.facebook.localcontent.menus.admin.manager.PageMenuTypeHandler.MenuType;
import com.facebook.localcontent.protocol.graphql.MenuManagementQueryModels.AvailableMenusModel.AvailableMenuInfoModel;
import com.facebook.localcontent.protocol.graphql.MenuManagementQueryModels.MenuManagementInfoFieldsModel;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.upload.event.BaseMediaUploadEvent.Status;
import com.facebook.photos.upload.event.MediaUploadEventBus;
import com.facebook.photos.upload.event.MediaUploadEventSubscriber;
import com.facebook.photos.upload.event.MultiPhotoUploadProgressEvent;
import com.facebook.photos.upload.operation.UploadOperation.Type;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.titlebar.HasTitleBar;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: ec_activity_create */
public class PageMenuManagementFragment extends FbFragment {
    @Inject
    AbstractFbErrorReporter f15091a;
    public ViewerContext al;
    public ProgressDialog am;
    public boolean an;
    @Inject
    public MediaUploadEventBus f15092b;
    @Inject
    public LocalContentMenuLogger f15093c;
    @Inject
    PageMenuManagementLoader f15094d;
    @Inject
    Set<PageMenuTypeHandler> f15095e;
    @Inject
    public Lazy<Toaster> f15096f;
    private Map<MenuType, PageMenuTypeHandler> f15097g;
    public MediaUploadEventSubscriber<MultiPhotoUploadProgressEvent> f15098h;
    public String f15099i;

    /* compiled from: ec_activity_create */
    public class C16482 extends MediaUploadEventSubscriber<MultiPhotoUploadProgressEvent> {
        final /* synthetic */ PageMenuManagementFragment f15090a;

        public C16482(PageMenuManagementFragment pageMenuManagementFragment) {
            this.f15090a = pageMenuManagementFragment;
        }

        public final void m17521b(FbEvent fbEvent) {
            MultiPhotoUploadProgressEvent multiPhotoUploadProgressEvent = (MultiPhotoUploadProgressEvent) fbEvent;
            if (!Type.MENU_PHOTO.equals(multiPhotoUploadProgressEvent.a.r) || !Status.UPLOADING.equals(multiPhotoUploadProgressEvent.b)) {
                return;
            }
            if (this.f15090a.y) {
                this.f15090a.o().onBackPressed();
            } else {
                this.f15090a.an = true;
            }
        }

        public final Class<MultiPhotoUploadProgressEvent> m17520a() {
            return MultiPhotoUploadProgressEvent.class;
        }
    }

    public static void m17524a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PageMenuManagementFragment) obj).m17522a((AbstractFbErrorReporter) FbErrorReporterImpl.a(fbInjector), MediaUploadEventBus.a(fbInjector), LocalContentMenuLogger.m17409b(fbInjector), new PageMenuManagementLoader(GraphQLQueryExecutor.a(fbInjector), TasksManager.b(fbInjector), IdBasedLazy.a(fbInjector, 9011)), STATICDI_MULTIBIND_PROVIDER$PageMenuTypeHandler.m17559a(fbInjector), IdBasedLazy.a(fbInjector, 3588));
    }

    public final void m17532c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = PageMenuManagementFragment.class;
        m17524a((Object) this, getContext());
        Builder builder = ImmutableMap.builder();
        for (PageMenuTypeHandler pageMenuTypeHandler : this.f15095e) {
            builder.b(pageMenuTypeHandler.mo897a(), pageMenuTypeHandler);
        }
        this.f15097g = builder.b();
        this.f15098h = new C16482(this);
        this.f15092b.a(this.f15098h);
    }

    public final View m17528a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1712695479);
        View inflate = layoutInflater.inflate(2130906066, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1937718889, a);
        return inflate;
    }

    public final void m17530a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        this.f15099i = (String) Preconditions.checkNotNull(this.s.getString("com.facebook.katana.profile.id"));
        this.al = (ViewerContext) this.s.getParcelable("com.facebook.orca.auth.OVERRIDDEN_VIEWER_CONTEXT");
        m17533e();
    }

    public final void m17527I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1274043157);
        this.f15094d.f15104b.c();
        if (this.am != null) {
            this.am.cancel();
        }
        super.I();
        if (this.f15098h != null) {
            this.f15092b.b(this.f15098h);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1220700869, a);
    }

    public final void m17531a(@Nullable MenuManagementInfoFieldsModel menuManagementInfoFieldsModel) {
        this.f15093c.f14941a.a(LocalContentMenuLogger.m17408b("page_menu_management", "menu_management_load_successful", this.f15099i));
        m17525b(menuManagementInfoFieldsModel);
        this.am.dismiss();
    }

    public final void m17529a(int i, int i2, Intent intent) {
        super.a(i, i2, intent);
        for (PageMenuTypeHandler pageMenuTypeHandler : this.f15095e) {
            if (pageMenuTypeHandler.mo900a(i)) {
                pageMenuTypeHandler.mo899a(this, this.f15099i, i, i2);
                return;
            }
        }
    }

    public final void m17526G() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -535503279);
        super.G();
        if (this.an) {
            o().onBackPressed();
        }
        HasTitleBar hasTitleBar = (HasTitleBar) a(HasTitleBar.class);
        if (hasTitleBar != null) {
            hasTitleBar.y_(2131239119);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1832230630, a);
    }

    public final void m17533e() {
        if (this.am != null) {
            this.am.show();
        } else {
            this.am = ProgressDialog.a(getContext(), null, jW_().getString(2131230739), true, false);
        }
        if (this.al != null) {
            this.f15094d.m17537a(this.f15099i, this);
        } else {
            this.f15094d.m17538b(this.f15099i, this);
        }
    }

    private void m17522a(FbErrorReporter fbErrorReporter, MediaUploadEventBus mediaUploadEventBus, LocalContentMenuLogger localContentMenuLogger, PageMenuManagementLoader pageMenuManagementLoader, Set<PageMenuTypeHandler> set, Lazy<Toaster> lazy) {
        this.f15091a = fbErrorReporter;
        this.f15092b = mediaUploadEventBus;
        this.f15093c = localContentMenuLogger;
        this.f15094d = pageMenuManagementLoader;
        this.f15095e = set;
        this.f15096f = lazy;
    }

    private void m17525b(@Nullable MenuManagementInfoFieldsModel menuManagementInfoFieldsModel) {
        m17523a((CheckedContentView) e(2131565618), MenuType.PHOTO_MENU, menuManagementInfoFieldsModel);
        m17523a((CheckedContentView) e(2131565619), MenuType.STRUCTURED_MENU, menuManagementInfoFieldsModel);
        m17523a((CheckedContentView) e(2131565620), MenuType.LINK_MENU, menuManagementInfoFieldsModel);
        m17523a((CheckedContentView) e(2131565621), MenuType.NONE, menuManagementInfoFieldsModel);
    }

    private void m17523a(CheckedContentView checkedContentView, final MenuType menuType, @Nullable final MenuManagementInfoFieldsModel menuManagementInfoFieldsModel) {
        final PageMenuTypeHandler pageMenuTypeHandler = (PageMenuTypeHandler) this.f15097g.get(menuType);
        if (pageMenuTypeHandler == null) {
            this.f15091a.a(PageMenuManagementFragment.class.getSimpleName(), "No handler available for menu type" + menuType.name());
            checkedContentView.setVisibility(8);
            return;
        }
        AvailableMenuInfoModel j = (menuManagementInfoFieldsModel == null || menuManagementInfoFieldsModel.a() == null) ? null : menuManagementInfoFieldsModel.a().j();
        if (pageMenuTypeHandler.mo901a(j)) {
            checkedContentView.setChecked(pageMenuTypeHandler.mo902a(menuManagementInfoFieldsModel.a()));
            checkedContentView.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ PageMenuManagementFragment f15089d;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -392124554);
                    LocalContentMenuLogger localContentMenuLogger = this.f15089d.f15093c;
                    String str = this.f15089d.f15099i;
                    String name = menuType.name();
                    HoneyClientEvent b = LocalContentMenuLogger.m17408b("page_menu_management", "menu_management_row_tap", str);
                    b.b("menu_type", name);
                    localContentMenuLogger.f14941a.a(b);
                    pageMenuTypeHandler.mo898a(this.f15089d, this.f15089d.al, this.f15089d.f15099i, menuManagementInfoFieldsModel);
                    Logger.a(2, EntryType.UI_INPUT_END, -627327217, a);
                }
            });
            return;
        }
        checkedContentView.setVisibility(8);
    }
}
