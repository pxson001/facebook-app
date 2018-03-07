package com.facebook.saved.controller;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.Adapter;
import com.facebook.analytics.CurationMechanism;
import com.facebook.analytics.CurationSurface;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.graphql.enums.GraphQLSavedDashboardSectionType;
import com.facebook.graphql.enums.GraphQLSavedState;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ipc.feed.ViewPermalinkIntentFactory;
import com.facebook.saved.analytics.SaveAnalyticsLogger;
import com.facebook.saved.analytics.UndoAction;
import com.facebook.saved.common.data.SavedDashboardSection;
import com.facebook.saved.common.protocol.UpdateSavedStateUtils;
import com.facebook.saved.contextmenu.SavedContextMenuManager;
import com.facebook.saved.contextmenu.interfaces.SavableItemWrapper;
import com.facebook.saved.data.SavedDashboardItem;
import com.facebook.saved.data.SavedDashboardItemMutator;
import com.facebook.saved.data.SavedDashboardItemWrapper;
import com.facebook.saved.data.SavedDashboardItemWrapperProvider;
import com.facebook.saved.event.SavedEventBus;
import com.facebook.saved.event.SavedEvents.SavedItemMutatedEvent;
import com.facebook.saved.helper.SavedItemHelper;
import com.facebook.saved.helper.SavedSectionHelper;
import com.facebook.saved.views.SavedDashboardSavedItemView;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.video.activity.FullscreenVideoPlayerLauncher;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import javax.annotation.Nonnull;
import javax.inject.Inject;

@ContextScoped
/* compiled from: is_in_chat_head */
public class SavedDashboardListItemController {
    private static SavedDashboardListItemController f9002p;
    private static final Object f9003q = new Object();
    private final Context f9004a;
    private final SavedContextMenuManager f9005b;
    private final SavedDashboardItemWrapperProvider f9006c;
    private final FbUriIntentHandler f9007d;
    public final SavedItemHelper f9008e;
    public final SavedEventBus f9009f;
    public final SavedDashboardItemMutator f9010g;
    private final UpdateSavedStateUtils f9011h;
    public final SaveAnalyticsLogger f9012i;
    private final SavedSectionHelper f9013j;
    public final Resources f9014k;
    public final Toaster f9015l;
    private final ViewPermalinkIntentFactory f9016m;
    private final SecureContextHelper f9017n;
    private final FullscreenVideoPlayerLauncher f9018o;

    /* compiled from: is_in_chat_head */
    /* synthetic */ class C13722 {
        static final /* synthetic */ int[] f9001a = new int[GraphQLSavedState.values().length];

        static {
            try {
                f9001a[GraphQLSavedState.ARCHIVED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f9001a[GraphQLSavedState.SAVED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    private static SavedDashboardListItemController m9021b(InjectorLike injectorLike) {
        return new SavedDashboardListItemController((Context) injectorLike.getInstance(Context.class), SavedContextMenuManager.m8962a(injectorLike), (SavedDashboardItemWrapperProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(SavedDashboardItemWrapperProvider.class), FbUriIntentHandler.a(injectorLike), SavedItemHelper.m9171a(injectorLike), SavedEventBus.m9122a(injectorLike), SavedDashboardItemMutator.m9109a(injectorLike), UpdateSavedStateUtils.a(injectorLike), SaveAnalyticsLogger.a(injectorLike), SavedSectionHelper.m9180a(injectorLike), ResourcesMethodAutoProvider.a(injectorLike), Toaster.a(injectorLike), ViewPermalinkIntentFactory.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), FullscreenVideoPlayerLauncher.a(injectorLike));
    }

    public static SavedDashboardListItemController m9020a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            SavedDashboardListItemController b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9003q) {
                SavedDashboardListItemController savedDashboardListItemController;
                if (a2 != null) {
                    savedDashboardListItemController = (SavedDashboardListItemController) a2.a(f9003q);
                } else {
                    savedDashboardListItemController = f9002p;
                }
                if (savedDashboardListItemController == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9021b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9003q, b3);
                        } else {
                            f9002p = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = savedDashboardListItemController;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public SavedDashboardListItemController(Context context, SavedContextMenuManager savedContextMenuManager, SavedDashboardItemWrapperProvider savedDashboardItemWrapperProvider, FbUriIntentHandler fbUriIntentHandler, SavedItemHelper savedItemHelper, SavedEventBus savedEventBus, SavedDashboardItemMutator savedDashboardItemMutator, UpdateSavedStateUtils updateSavedStateUtils, SaveAnalyticsLogger saveAnalyticsLogger, SavedSectionHelper savedSectionHelper, Resources resources, Toaster toaster, ViewPermalinkIntentFactory viewPermalinkIntentFactory, SecureContextHelper secureContextHelper, FullscreenVideoPlayerLauncher fullscreenVideoPlayerLauncher) {
        this.f9004a = context;
        this.f9005b = savedContextMenuManager;
        this.f9006c = savedDashboardItemWrapperProvider;
        this.f9007d = fbUriIntentHandler;
        this.f9008e = savedItemHelper;
        this.f9009f = savedEventBus;
        this.f9010g = savedDashboardItemMutator;
        this.f9011h = updateSavedStateUtils;
        this.f9012i = saveAnalyticsLogger;
        this.f9013j = savedSectionHelper;
        this.f9014k = resources;
        this.f9015l = toaster;
        this.f9016m = viewPermalinkIntentFactory;
        this.f9017n = secureContextHelper;
        this.f9018o = fullscreenVideoPlayerLauncher;
    }

    public final void m9026a(Adapter adapter, int i, Optional<SavedDashboardSection> optional) {
        Object item = adapter.getItem(i);
        if ((item instanceof SavedDashboardItem) && !((SavedDashboardItem) item).f9115j) {
            String str;
            SavedDashboardItem savedDashboardItem = (SavedDashboardItem) item;
            if (savedDashboardItem.f9112g == null) {
                str = "";
            } else {
                str = savedDashboardItem.f9112g.m9318o();
            }
            this.f9012i.a(str, (GraphQLSavedDashboardSectionType) SavedSectionHelper.m9181a((Optional) optional).or(GraphQLSavedDashboardSectionType.ALL));
            m9022b(savedDashboardItem);
        }
    }

    public final boolean m9029a(@Nonnull Adapter adapter, View view, int i, Fragment fragment, CurationMechanism curationMechanism) {
        if (view instanceof SavedDashboardSavedItemView) {
            Object item = adapter.getItem(i);
            if ((item instanceof SavedDashboardItem) && !((SavedDashboardItem) item).f9115j) {
                m9028a((SavedDashboardItem) item, view, fragment, curationMechanism);
                return true;
            }
        }
        return false;
    }

    public final void m9028a(SavedDashboardItem savedDashboardItem, View view, Fragment fragment, CurationMechanism curationMechanism) {
        this.f9005b.m8965a((SavableItemWrapper) new SavedDashboardItemWrapper(savedDashboardItem, SavedItemHelper.m9171a(this.f9006c)), view, fragment, curationMechanism);
    }

    public final void m9027a(@Nonnull SavedDashboardItem savedDashboardItem) {
        boolean z;
        boolean z2 = true;
        if (savedDashboardItem.f9112g != null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "Saved item target is null.");
        if (Strings.isNullOrEmpty(savedDashboardItem.f9112g.m9318o())) {
            z2 = false;
        }
        Preconditions.checkArgument(z2, "Saved item ID is null or empty.");
        GraphQLSavedState d = SavedItemHelper.m9174d(savedDashboardItem);
        switch (C13722.f9001a[d.ordinal()]) {
            case 1:
                m9023c(savedDashboardItem);
                return;
            case 2:
                m9024d(savedDashboardItem);
                return;
            default:
                throw new IllegalArgumentException("Operation to update saved state to " + d + " cannot be undone.");
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m9022b(com.facebook.saved.data.SavedDashboardItem r10) {
        /*
        r9 = this;
        r0 = r10.m9107m();
        if (r0 == 0) goto L_0x008c;
    L_0x0006:
        r4 = r10.f9112g;
        r0 = r4;
        if (r0 == 0) goto L_0x008c;
    L_0x000b:
        r0 = new com.facebook.graphql.model.GraphQLVideo$Builder;
        r0.<init>();
        r4 = r10.f9112g;
        r1 = r4;
        r1 = r1.m9318o();
        r0.H = r1;
        r0 = r0;
        r4 = r10.f9112g;
        r1 = r4;
        r1 = r1.m9323t();
        r0.ak = r1;
        r0 = r0;
        r4 = r10.f9112g;
        r1 = r4;
        r1 = r1.m9303C();
        r0.bn = r1;
        r0 = r0;
        r4 = r10.f9112g;
        r1 = r4;
        r2 = r1.m9328y();
        r0.bi = r2;
        r0 = r0;
        r4 = r10.f9112g;
        r1 = r4;
        r1 = r1.m9302B();
        r0.bl = r1;
        r0 = r0;
        r4 = r10.f9112g;
        r1 = r4;
        r1 = r1.m9301A();
        r0.bk = r1;
        r0 = r0;
        r4 = r10.f9112g;
        r1 = r4;
        r2 = r1.m9329z();
        r0.bj = r2;
        r0 = r0;
        r4 = r10.f9112g;
        r1 = r4;
        r1 = r1.m9319p();
        r0.Y = r1;
        r0 = r0;
        r4 = r10.f9112g;
        r1 = r4;
        r1 = r1.m9320q();
        r0.Z = r1;
        r0 = r0;
        r4 = r10.f9112g;
        r1 = r4;
        r1 = r1.m9321r();
        r0.aa = r1;
        r0 = r0;
        r4 = r10.f9112g;
        r1 = r4;
        r1 = r1.m9325v();
        r0.aI = r1;
        r0 = r0;
        r1 = r9.f9018o;
        r0 = r0.a();
        r2 = r9.f9004a;
        r3 = com.facebook.video.analytics.VideoAnalytics.PlayerOrigin.SAVED_DASHBOARD;
        r1.a(r0, r2, r3);
    L_0x008b:
        return;
    L_0x008c:
        r4 = r10.f9116k;
        r0 = r4;
        if (r0 == 0) goto L_0x00da;
    L_0x0091:
        r1 = r0.m9363c();
        if (r1 == 0) goto L_0x00c8;
    L_0x0097:
        r1 = r0.m9362b();
        if (r1 == 0) goto L_0x00c8;
    L_0x009d:
        r1 = r0.m9362b();
        r1 = r1.g();
        r2 = 80218325; // 0x4c808d5 float:4.7027885E-36 double:3.96331185E-316;
        if (r1 != r2) goto L_0x00c8;
    L_0x00aa:
        r1 = new com.facebook.ipc.feed.PermalinkStoryIdParams$Builder;
        r1.<init>();
        r0 = r0.m9363c();
        r1.a = r0;
        r0 = r1;
        r0 = r0.a();
        r1 = r9.f9016m;
        r0 = r1.a(r0);
        r1 = r9.f9017n;
        r2 = r9.f9004a;
        r1.a(r0, r2);
        goto L_0x008b;
    L_0x00c8:
        r1 = r0.m9364d();
        if (r1 == 0) goto L_0x00da;
    L_0x00ce:
        r1 = r9.f9007d;
        r2 = r9.f9004a;
        r0 = r0.m9364d();
        r1.a(r2, r0);
        goto L_0x008b;
    L_0x00da:
        r0 = r9.f9008e;
        if (r10 != 0) goto L_0x00ee;
    L_0x00de:
        r4 = 0;
    L_0x00df:
        r0 = r4;
        r1 = com.facebook.common.util.StringUtil.a(r0);
        if (r1 != 0) goto L_0x008b;
    L_0x00e6:
        r1 = r9.f9007d;
        r2 = r9.f9004a;
        r1.a(r2, r0);
        goto L_0x008b;
    L_0x00ee:
        r8 = r10.f9117l;
        r4 = r8;
        if (r4 == 0) goto L_0x0130;
    L_0x00f3:
        r8 = r10.f9117l;
        r4 = r8;
        r4 = r4.m9354j();
        if (r4 == 0) goto L_0x0130;
    L_0x00fc:
        r8 = r10.f9117l;
        r4 = r8;
        r4 = r4.m9354j();
        r5 = r4.m9348k();
        if (r5 == 0) goto L_0x0125;
    L_0x0109:
        r5 = com.facebook.common.fblinks.FBLinks.ff;
        r6 = r4.m9347j();
        r4 = r4.m9348k();
        r4 = r4.m9342a();
        r4 = android.net.Uri.encode(r4);
        r7 = 1;
        r7 = java.lang.Boolean.valueOf(r7);
        r4 = com.facebook.common.stringformat.StringFormatUtil.formatStrLocaleSafe(r5, r6, r4, r7);
        goto L_0x00df;
    L_0x0125:
        r5 = com.facebook.common.fblinks.FBLinks.fd;
        r4 = r4.m9347j();
        r4 = com.facebook.common.stringformat.StringFormatUtil.formatStrLocaleSafe(r5, r4);
        goto L_0x00df;
    L_0x0130:
        r8 = r10.f9112g;
        r4 = r8;
        if (r4 == 0) goto L_0x0167;
    L_0x0135:
        r8 = r10.f9112g;
        r4 = r8;
        r5 = r10.m9107m();
        if (r5 == 0) goto L_0x0151;
    L_0x013e:
        r5 = com.facebook.common.fblinks.FBLinks.dJ;
        r6 = r4.m9318o();
        r4 = r4.m9325v();
        r4 = android.net.Uri.encode(r4);
        r4 = com.facebook.common.stringformat.StringFormatUtil.formatStrLocaleSafe(r5, r6, r4);
        goto L_0x00df;
    L_0x0151:
        r5 = r4.m9313j();
        if (r5 == 0) goto L_0x0167;
    L_0x0157:
        r5 = r0.f9170a;
        r6 = r4.m9313j();
        r4 = r4.m9318o();
        r4 = r5.a(r6, r4);
        if (r4 != 0) goto L_0x00df;
    L_0x0167:
        r8 = r10.f9111f;
        r4 = r8;
        goto L_0x00df;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.saved.controller.SavedDashboardListItemController.b(com.facebook.saved.data.SavedDashboardItem):void");
    }

    private void m9023c(SavedDashboardItem savedDashboardItem) {
        this.f9012i.a(savedDashboardItem.f9112g.m9318o(), UndoAction.UNDO_ARCHIVE);
        this.f9011h.b(savedDashboardItem.f9112g.m9318o(), CurationSurface.NATIVE_SAVED_DASHBOARD, CurationMechanism.UNDO_BUTTON, m9025e(savedDashboardItem));
        this.f9009f.a(new SavedItemMutatedEvent(this.f9010g.m9110a(savedDashboardItem, GraphQLSavedState.SAVED, false)));
    }

    private void m9024d(SavedDashboardItem savedDashboardItem) {
        this.f9012i.a(savedDashboardItem.f9112g.m9318o(), UndoAction.UNDO_UNARCHIVE);
        this.f9011h.a(savedDashboardItem.f9112g.m9318o(), CurationSurface.NATIVE_SAVED_DASHBOARD, CurationMechanism.UNDO_BUTTON, m9025e(savedDashboardItem));
        this.f9009f.a(new SavedItemMutatedEvent(this.f9010g.m9110a(savedDashboardItem, GraphQLSavedState.ARCHIVED, false)));
    }

    private OperationResultFutureCallback m9025e(final SavedDashboardItem savedDashboardItem) {
        return new OperationResultFutureCallback(this) {
            final /* synthetic */ SavedDashboardListItemController f9000b;

            protected final void m9018a(ServiceException serviceException) {
                this.f9000b.f9015l.b(new ToastBuilder(this.f9000b.f9014k.getString(2131238168)));
                SavedItemHelper savedItemHelper = this.f9000b.f9008e;
                this.f9000b.f9009f.a(new SavedItemMutatedEvent(this.f9000b.f9010g.m9110a(savedDashboardItem, SavedItemHelper.m9174d(savedDashboardItem), true)));
            }
        };
    }
}
