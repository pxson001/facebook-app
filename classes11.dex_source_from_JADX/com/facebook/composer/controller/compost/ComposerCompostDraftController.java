package com.facebook.composer.controller.compost;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.common.i18n.StringLengthHelper;
import com.facebook.composer.activity.ComposerDataProviderImpl;
import com.facebook.composer.activity.ComposerFragment;
import com.facebook.composer.activity.ComposerFragment.AnonymousClass84;
import com.facebook.composer.attachments.ComposerAttachment.ProvidesAttachments;
import com.facebook.composer.minutiae.model.MinutiaeObject;
import com.facebook.composer.minutiae.model.MinutiaeObject.ProvidesMinutiae;
import com.facebook.composer.privacy.common.ComposerPrivacyData;
import com.facebook.composer.privacy.common.ComposerPrivacyData.ProvidesPrivacyData;
import com.facebook.composer.publish.compost.store.CompostDraftStoryStore;
import com.facebook.composer.publish.compost.story.CompostDraftStory;
import com.facebook.compost.abtest.ExperimentsForCompostAbTestModule;
import com.facebook.compost.controller.CompostAttachment;
import com.facebook.compost.controller.CompostDraftController;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsFeedOnlyPost;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesMarketplaceId;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesSessionId;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesTargetAlbum;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesTextWithEntities;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesTopics;
import com.facebook.ipc.composer.intent.ComposerConfigurationSpec.ProvidesConfiguration;
import com.facebook.ipc.composer.intent.ComposerShareParams.ProvidesShareParams;
import com.facebook.ipc.composer.intent.ComposerStickerData.ProvidesStickerData;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.ipc.composer.intent.ComposerTargetData.ProvidesTargetData;
import com.facebook.ipc.composer.model.ComposerFacecastInfo.ProvidesFacecastInfo;
import com.facebook.ipc.composer.model.ComposerLocationInfo.ProvidesLocationInfo;
import com.facebook.ipc.composer.model.ComposerSourceSurface;
import com.facebook.ipc.composer.model.ComposerSourceType;
import com.facebook.ipc.composer.model.ComposerTaggedUser.ProvidesTaggedUsers;
import com.facebook.ipc.composer.model.ProductItemAttachment.ProvidesProductItemAttachment;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.BooleanGetter;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.ProvidesPluginAllowsDraftSavingGetter;
import com.facebook.photos.upload.compost.analytics.CompostAnalyticsLogger;
import com.facebook.photos.upload.progresspage.CompostNotificationManager;
import com.facebook.photos.upload.progresspage.survey.CompostSurveyController;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.share.model.ComposerAppAttribution.ProvidesAppAttribution;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: has_editable_promotion */
public class ComposerCompostDraftController<DataProvider extends ProvidesAppAttribution & ProvidesAttachments & ProvidesIsFeedOnlyPost & ProvidesMarketplaceId & ProvidesSessionId & ProvidesTargetAlbum & ProvidesTextWithEntities & ProvidesTopics & ProvidesConfiguration & ProvidesFacecastInfo & ProvidesLocationInfo & ProvidesPluginAllowsDraftSavingGetter & ProvidesPrivacyData & ProvidesShareParams & ProvidesStickerData & ProvidesTaggedUsers & ProvidesTargetData & ProvidesProductItemAttachment & ProvidesMinutiae> {
    private final QeAccessor f6358a;
    private final CompostDraftStoryStore f6359b;
    public final CompostAnalyticsLogger f6360c;
    public final CompostNotificationManager f6361d;
    private final CompostDraftController f6362e;
    private final Context f6363f;
    private boolean f6364g = false;

    public static ComposerCompostDraftController m7773b(InjectorLike injectorLike) {
        return new ComposerCompostDraftController((QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), CompostDraftStoryStore.a(injectorLike), CompostAnalyticsLogger.b(injectorLike), CompostNotificationManager.b(injectorLike), CompostDraftController.b(injectorLike), (Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public ComposerCompostDraftController(QeAccessor qeAccessor, CompostDraftStoryStore compostDraftStoryStore, CompostAnalyticsLogger compostAnalyticsLogger, CompostNotificationManager compostNotificationManager, CompostDraftController compostDraftController, Context context) {
        this.f6358a = qeAccessor;
        this.f6359b = compostDraftStoryStore;
        this.f6360c = compostAnalyticsLogger;
        this.f6361d = compostNotificationManager;
        this.f6362e = compostDraftController;
        this.f6363f = context;
    }

    public final boolean m7779a(DataProvider dataProvider) {
        return m7776e(dataProvider);
    }

    public final void m7778a(DialogDataProviderAndCallback dialogDataProviderAndCallback, DataProvider dataProvider) {
        this.f6364g = false;
        if (this.f6362e.a(((ProvidesSessionId) dataProvider).ab()) || this.f6358a.a(ExperimentsForCompostAbTestModule.c, false)) {
            m7777f(this, dataProvider);
            this.f6364g = true;
            dialogDataProviderAndCallback.m7523a();
            return;
        }
        final String ab = ((ProvidesSessionId) dataProvider).ab();
        final int size = ((ProvidesAttachments) dataProvider).m().size();
        final int a = StringLengthHelper.a(((ProvidesTextWithEntities) dataProvider).ae().a());
        this.f6360c.a(ab, size, a);
        Context c = dialogDataProviderAndCallback.m7524c();
        Builder builder = new Builder(c);
        builder.a(true);
        builder.a(c.getString(2131234778));
        builder.b(c.getString(2131234779));
        final AnonymousClass84 anonymousClass84 = dialogDataProviderAndCallback;
        OnClickListener c07941 = new OnClickListener(this) {
            final /* synthetic */ ComposerCompostDraftController f6351e;

            public void onClick(DialogInterface dialogInterface, int i) {
                this.f6351e.f6360c.b(ab, size, a);
                ComposerFragment.m7585k(anonymousClass84.f6130a, false);
                dialogInterface.dismiss();
            }
        };
        final String str = ab;
        final int i = size;
        final int i2 = a;
        final DataProvider dataProvider2 = dataProvider;
        final AnonymousClass84 anonymousClass842 = dialogDataProviderAndCallback;
        OnClickListener c07952 = new OnClickListener(this) {
            final /* synthetic */ ComposerCompostDraftController f6357f;

            public void onClick(DialogInterface dialogInterface, int i) {
                this.f6357f.f6360c.c(str, i, i2);
                ComposerCompostDraftController.m7777f(this.f6357f, dataProvider2);
                this.f6357f.f6361d.a();
                anonymousClass842.m7523a();
                dialogInterface.dismiss();
            }
        };
        CharSequence string = c.getString(2131234776);
        CharSequence string2 = c.getString(2131234777);
        builder.b(string, c07941);
        builder.a(string2, c07952);
        builder.a().show();
    }

    @Nullable
    private CompostDraftStory m7774c(DataProvider dataProvider) {
        return (CompostDraftStory) this.f6359b.c(((ProvidesSessionId) dataProvider).ab());
    }

    private boolean m7775d(DataProvider dataProvider) {
        String ab = ((ProvidesSessionId) dataProvider).ab();
        this.f6360c.i(ab);
        BooleanGetter aj = ((ProvidesPluginAllowsDraftSavingGetter) dataProvider).aj();
        if (aj == null || aj.a()) {
            if (((ProvidesConfiguration) dataProvider).o().getSourceType() == ComposerSourceType.UNKNOWN) {
                ComposerSourceSurface sourceSurface = ((ProvidesConfiguration) dataProvider).o().getLaunchLoggingParams().getSourceSurface();
                if (!(sourceSurface == ComposerSourceSurface.NEWSFEED || sourceSurface == ComposerSourceSurface.GROUP_FEED || sourceSurface == ComposerSourceSurface.PAGE_FEED || sourceSurface == ComposerSourceSurface.EVENT || sourceSurface == ComposerSourceSurface.TIMELINE || sourceSurface == ComposerSourceSurface.COMPOST)) {
                    this.f6360c.c(ab, sourceSurface.toString());
                    return false;
                }
            } else if (!(((ProvidesConfiguration) dataProvider).o().getSourceType() == ComposerSourceType.FEED || ((ProvidesConfiguration) dataProvider).o().getSourceType() == ComposerSourceType.FEED_INLINE || ((ProvidesConfiguration) dataProvider).o().getSourceType() == ComposerSourceType.TIMELINE || ((ProvidesConfiguration) dataProvider).o().getSourceType() == ComposerSourceType.COMPOST)) {
                this.f6360c.c(ab, ((ProvidesConfiguration) dataProvider).o().getSourceType().toString());
                return false;
            }
            if (((ProvidesConfiguration) dataProvider).o().isEdit()) {
                this.f6360c.b(ab, "published_post");
                return false;
            } else if (((ProvidesTopics) dataProvider).af() != null && !((ProvidesTopics) dataProvider).af().isEmpty()) {
                this.f6360c.b(ab, "topic");
                return false;
            } else if (((ComposerDataProviderImpl) dataProvider).m7418U() != 0) {
                this.f6360c.b(ab, "market_place");
                return false;
            } else if (((ProvidesProductItemAttachment) dataProvider).i() != null) {
                this.f6360c.b(ab, "product_attachment");
                return false;
            } else if (((ProvidesConfiguration) dataProvider).o().isThrowbackPost()) {
                this.f6360c.b(ab, "throwback");
                return false;
            } else if (((ComposerDataProviderImpl) dataProvider).m7429e().facecastCameraIndex == -1) {
                return this.f6362e.a(ab, ((ProvidesTargetData) dataProvider).s(), ((ComposerDataProviderImpl) dataProvider).m7404E(), ((ProvidesLocationInfo) dataProvider).g(), ((ProvidesStickerData) dataProvider).r(), ((ProvidesShareParams) dataProvider).q(), ((ProvidesTargetAlbum) dataProvider).ad(), dataProvider.m7424a(), ((ProvidesAttachments) dataProvider).m());
            } else {
                this.f6360c.b(ab, "live");
                return false;
            }
        }
        this.f6360c.b(ab, "draft_others");
        return false;
    }

    private boolean m7776e(DataProvider dataProvider) {
        return this.f6362e.a() && m7775d(dataProvider);
    }

    public static void m7777f(ComposerCompostDraftController composerCompostDraftController, ComposerDataProviderImpl composerDataProviderImpl) {
        CompostDraftController compostDraftController = composerCompostDraftController.f6362e;
        String ab = ((ProvidesSessionId) composerDataProviderImpl).ab();
        GraphQLTextWithEntities ae = ((ProvidesTextWithEntities) composerDataProviderImpl).ae();
        ImmutableList h = ((ProvidesTaggedUsers) composerDataProviderImpl).h();
        MinutiaeObject l = ((ProvidesMinutiae) composerDataProviderImpl).l();
        ComposerPrivacyData ag = ((ProvidesPrivacyData) composerDataProviderImpl).ag();
        ComposerTargetData s = ((ProvidesTargetData) composerDataProviderImpl).s();
        CompostAttachment.Builder builder = new CompostAttachment.Builder();
        builder.a = ((ProvidesShareParams) composerDataProviderImpl).q();
        CompostAttachment.Builder builder2 = builder;
        builder2.b = ((ProvidesAttachments) composerDataProviderImpl).m();
        compostDraftController.a(ab, ae, h, l, ag, s, builder2.a());
    }

    public final Intent m7780b(DataProvider dataProvider) {
        if (!this.f6364g) {
            return new Intent();
        }
        CompostDraftStory c = m7774c(dataProvider);
        CompostDraftController compostDraftController = this.f6362e;
        Intent intent = new Intent();
        CompostSurveyController compostSurveyController = (CompostSurveyController) compostDraftController.d.get();
        Bundle bundle = new Bundle();
        bundle.putString("session_id", c.f());
        bundle.putString("photo_count", Integer.toString(c.b()));
        bundle.putString("post_age", Long.toString((compostSurveyController.c.a() - c.c()) / 1000));
        intent.putExtra("try_show_survey_on_result_extra_data", bundle);
        return intent;
    }
}
