package com.facebook.platform.composer.composer;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.i18n.StringLengthHelper;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.util.StringUtil;
import com.facebook.composer.abtest.ExperimentsForComposerAbTestModule;
import com.facebook.composer.minutiae.model.MinutiaeObject;
import com.facebook.composer.privacy.common.ComposerPrivacyData;
import com.facebook.compost.abtest.ExperimentsForCompostAbTestModule;
import com.facebook.compost.controller.CompostAttachment;
import com.facebook.compost.controller.CompostDraftController;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.funnellogger.FunnelRegistry;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.ipc.composer.model.ComposerSourceType;
import com.facebook.ipc.composer.model.ComposerTaggedUser;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.ipc.model.FacebookProfile;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.upload.compost.analytics.CompostAnalyticsLogger;
import com.facebook.photos.upload.progresspage.CompostNotificationManager;
import com.facebook.platform.analytics.PlatformAnalyticsLogger;
import com.facebook.platform.composer.composer.PlatformComposerFragment.AnonymousClass13;
import com.facebook.platform.composer.draftpost.DraftPostComposerCancelDialogFragment;
import com.facebook.platform.composer.model.PlatformComposerModel;
import com.facebook.platform.composer.model.PlatformComposerModel.Builder;
import com.facebook.platform.composer.model.PlatformComposition;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import javax.inject.Inject;

/* compiled from: rich_document_section */
public class PlatformComposerDraftPostController {
    public final PlatformAnalyticsLogger f4043a;
    private final FbNetworkManager f4044b;
    private final QeAccessor f4045c;
    private final CompostDraftController f4046d;
    public final CompostAnalyticsLogger f4047e;
    public final CompostNotificationManager f4048f;

    public static PlatformComposerDraftPostController m3974a(InjectorLike injectorLike) {
        return new PlatformComposerDraftPostController(PlatformAnalyticsLogger.m3921a(injectorLike), FbNetworkManager.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), CompostDraftController.b(injectorLike), CompostAnalyticsLogger.b(injectorLike), CompostNotificationManager.b(injectorLike));
    }

    @Inject
    public PlatformComposerDraftPostController(PlatformAnalyticsLogger platformAnalyticsLogger, FbNetworkManager fbNetworkManager, QeAccessor qeAccessor, CompostDraftController compostDraftController, CompostAnalyticsLogger compostAnalyticsLogger, CompostNotificationManager compostNotificationManager) {
        this.f4043a = platformAnalyticsLogger;
        this.f4044b = fbNetworkManager;
        this.f4045c = qeAccessor;
        this.f4046d = compostDraftController;
        this.f4047e = compostAnalyticsLogger;
        this.f4048f = compostNotificationManager;
    }

    private boolean m3975a(PlatformComposerModel platformComposerModel) {
        boolean z = platformComposerModel.f4187b.getSourceType() == ComposerSourceType.EXTERNAL;
        boolean z2;
        if (platformComposerModel.f4187b.getInitialShareParams() == null || StringUtil.a(platformComposerModel.f4187b.getInitialShareParams().linkForShare)) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z && r3 && platformComposerModel.f4190e.targetType == TargetType.UNDIRECTED && this.f4044b.d() && this.f4045c.a(ExperimentsForComposerAbTestModule.a, false)) {
            return true;
        }
        return false;
    }

    private boolean m3977b(PlatformComposerModel platformComposerModel) {
        return this.f4046d.a() && this.f4045c.a(ExperimentsForCompostAbTestModule.e, false) && m3978c(platformComposerModel);
    }

    private boolean m3978c(PlatformComposerModel platformComposerModel) {
        if (!m3975a(platformComposerModel)) {
            return this.f4046d.a(platformComposerModel.f4186a, platformComposerModel.f4190e, platformComposerModel.f4188c.m4147B(), platformComposerModel.f4188c.m4157i(), platformComposerModel.f4188c.m4164p(), platformComposerModel.f4188c.m4165q(), platformComposerModel.f4188c.m4151c(), platformComposerModel.f4188c.m4172x(), platformComposerModel.f4188c.m4153e());
        }
        this.f4047e.b(platformComposerModel.f4186a, "server_draft");
        return false;
    }

    public final void m3980a(final AnonymousClass13 anonymousClass13, final PlatformComposerModel platformComposerModel) {
        if (m3977b(platformComposerModel)) {
            m3976b(anonymousClass13, platformComposerModel);
        } else if (m3975a(platformComposerModel)) {
            final DraftPostComposerCancelDialogFragment draftPostComposerCancelDialogFragment = new DraftPostComposerCancelDialogFragment();
            draftPostComposerCancelDialogFragment.am = new OnClickListener(this) {
                final /* synthetic */ PlatformComposerDraftPostController f4028d;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -1546099567);
                    this.f4028d.f4043a.m3927c(platformComposerModel.f4186a);
                    anonymousClass13.m4002c();
                    draftPostComposerCancelDialogFragment.a();
                    Logger.a(2, EntryType.UI_INPUT_END, 650624806, a);
                }
            };
            draftPostComposerCancelDialogFragment.an = new OnClickListener(this) {
                final /* synthetic */ PlatformComposerDraftPostController f4032d;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -658299714);
                    this.f4032d.f4043a.m3926b(platformComposerModel.f4186a);
                    AnonymousClass13 anonymousClass13 = anonymousClass13;
                    PlatformComposerFragment platformComposerFragment = anonymousClass13.f4066a;
                    Builder a2 = anonymousClass13.f4066a.aO.m4142a();
                    PlatformComposition.Builder C = anonymousClass13.f4066a.aO.f4188c.m4148C();
                    C.f4223v = true;
                    a2.f4174c = C.m4145b();
                    platformComposerFragment.aO = a2.m4141a();
                    PlatformComposerFragment.m4062a(anonymousClass13.f4066a, -1, PlatformComposerFragment.as(anonymousClass13.f4066a), false);
                    draftPostComposerCancelDialogFragment.a();
                    Logger.a(2, EntryType.UI_INPUT_END, -1716860342, a);
                }
            };
            draftPostComposerCancelDialogFragment.ao = new OnDismissListener(this) {
                final /* synthetic */ PlatformComposerDraftPostController f4034b;

                public void onDismiss(DialogInterface dialogInterface) {
                    anonymousClass13.m4001b();
                }
            };
            draftPostComposerCancelDialogFragment.ap = new OnCancelListener(this) {
                final /* synthetic */ PlatformComposerDraftPostController f4036b;

                public void onCancel(DialogInterface dialogInterface) {
                    this.f4036b.f4043a.m3928d(platformComposerModel.f4186a);
                }
            };
            this.f4043a.m3924a(platformComposerModel.f4186a);
            draftPostComposerCancelDialogFragment.a(anonymousClass13.f4066a.kO_(), "COMPOSER_CANCEL_DIALOG");
        } else {
            new AlertDialog.Builder(anonymousClass13.m4000a()).a(true).a(2131238381).a(2131238382, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ PlatformComposerDraftPostController f4042b;

                public void onClick(DialogInterface dialogInterface, int i) {
                    AnonymousClass13 anonymousClass13 = anonymousClass13;
                    anonymousClass13.f4066a.az.b(FunnelRegistry.l, "alert dialog discard button");
                    dialogInterface.dismiss();
                    PlatformComposerFragment.m4062a(anonymousClass13.f4066a, 0, null, false);
                    anonymousClass13.f4066a.bp.m4093b();
                }
            }).b(2131238383, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ PlatformComposerDraftPostController f4040b;

                public void onClick(DialogInterface dialogInterface, int i) {
                    anonymousClass13.f4066a.az.b(FunnelRegistry.l, "alert dialog cancel button");
                    dialogInterface.dismiss();
                }
            }).a(new OnCancelListener(this) {
                final /* synthetic */ PlatformComposerDraftPostController f4038b;

                public void onCancel(DialogInterface dialogInterface) {
                    anonymousClass13.m4001b();
                }
            }).a().show();
        }
    }

    private void m3976b(AnonymousClass13 anonymousClass13, PlatformComposerModel platformComposerModel) {
        final String str = platformComposerModel.f4186a;
        final int size = platformComposerModel.f4188c.m4153e().size();
        final int a = StringLengthHelper.a(platformComposerModel.f4188c.m4155g().a());
        this.f4047e.a(str, size, a);
        Context a2 = anonymousClass13.m4000a();
        AlertDialog.Builder builder = new AlertDialog.Builder(a2);
        builder.a(true);
        builder.a(a2.getString(2131238409));
        builder.b(a2.getString(2131238410));
        final AnonymousClass13 anonymousClass132 = anonymousClass13;
        DialogInterface.OnClickListener c05101 = new DialogInterface.OnClickListener(this) {
            final /* synthetic */ PlatformComposerDraftPostController f4018e;

            public void onClick(DialogInterface dialogInterface, int i) {
                this.f4018e.f4047e.b(str, size, a);
                anonymousClass132.m4002c();
            }
        };
        final String str2 = str;
        final int i = size;
        final int i2 = a;
        final PlatformComposerModel platformComposerModel2 = platformComposerModel;
        final AnonymousClass13 anonymousClass133 = anonymousClass13;
        DialogInterface.OnClickListener c05112 = new DialogInterface.OnClickListener(this) {
            final /* synthetic */ PlatformComposerDraftPostController f4024f;

            public void onClick(DialogInterface dialogInterface, int i) {
                this.f4024f.f4047e.c(str2, i, i2);
                PlatformComposerDraftPostController.m3979d(this.f4024f, platformComposerModel2);
                this.f4024f.f4048f.a();
                anonymousClass133.m4002c();
            }
        };
        CharSequence string = a2.getString(2131238382);
        CharSequence string2 = a2.getString(2131238408);
        builder.b(string, c05101);
        builder.a(string2, c05112);
        builder.a().show();
    }

    public static void m3979d(PlatformComposerDraftPostController platformComposerDraftPostController, PlatformComposerModel platformComposerModel) {
        Collection arrayList = new ArrayList();
        ImmutableList v = platformComposerModel.f4188c.m4170v();
        int size = v.size();
        for (int i = 0; i < size; i++) {
            FacebookProfile facebookProfile = (FacebookProfile) v.get(i);
            if (facebookProfile.mId != -1 && facebookProfile.a == 0) {
                ComposerTaggedUser.Builder a = ComposerTaggedUser.a(facebookProfile.mId);
                a.b = facebookProfile.mDisplayName;
                a = a;
                a.c = facebookProfile.mImageUrl;
                arrayList.add(a.a());
            }
        }
        CompostDraftController compostDraftController = platformComposerDraftPostController.f4046d;
        String str = platformComposerModel.f4186a;
        GraphQLTextWithEntities g = platformComposerModel.f4188c.m4155g();
        ImmutableList copyOf = ImmutableList.copyOf(arrayList);
        MinutiaeObject j = platformComposerModel.f4188c.m4158j();
        ComposerPrivacyData composerPrivacyData = platformComposerModel.f4189d;
        ComposerTargetData composerTargetData = platformComposerModel.f4190e;
        CompostAttachment.Builder builder = new CompostAttachment.Builder();
        builder.a = platformComposerModel.f4188c.m4165q();
        builder = builder;
        builder.b = platformComposerModel.f4188c.m4153e();
        compostDraftController.a(str, g, copyOf, j, composerPrivacyData, composerTargetData, builder.a());
    }
}
