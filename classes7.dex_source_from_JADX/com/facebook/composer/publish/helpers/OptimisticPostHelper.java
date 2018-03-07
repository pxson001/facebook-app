package com.facebook.composer.publish.helpers;

import com.facebook.composer.abtest.ExperimentsForComposerAbTestModule;
import com.facebook.composer.attachments.AttachmentUtils;
import com.facebook.composer.attachments.ComposerAttachment.ProvidesAttachments;
import com.facebook.composer.minutiae.model.MinutiaeObject.ProvidesMinutiae;
import com.facebook.composer.privacy.common.ComposerPrivacyData.ProvidesPrivacyData;
import com.facebook.feed.util.composer.OptimisticPostStoryBuilder;
import com.facebook.feed.util.composer.OptimisticPostStoryBuilderProvider;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsBackoutDraft;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsImplicitLocationSupported;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesSessionId;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesTargetAlbum;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesTextWithEntities;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesTopics;
import com.facebook.ipc.composer.intent.ComposerConfigurationSpec.ProvidesConfiguration;
import com.facebook.ipc.composer.intent.ComposerShareParams.ProvidesShareParams;
import com.facebook.ipc.composer.intent.ComposerStickerData.ProvidesStickerData;
import com.facebook.ipc.composer.intent.ComposerTargetData.ProvidesTargetData;
import com.facebook.ipc.composer.model.ComposerContentType;
import com.facebook.ipc.composer.model.ComposerContentType.ProvidesContentType;
import com.facebook.ipc.composer.model.ComposerLocationInfo.ProvidesLocationInfo;
import com.facebook.ipc.composer.model.ComposerTaggedUser.ProvidesTaggedUsers;
import com.facebook.ipc.composer.model.ProductItemAttachment.ProvidesProductItemAttachment;
import com.facebook.ipc.composer.model.PublishMode;
import com.facebook.ipc.composer.model.PublishMode.ProvidesPublishMode;
import com.facebook.ipc.composer.model.RedSpaceValue.ProvidesRedSpaceValue;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters$BooleanGetter;
import com.facebook.ipc.katana.model.GeoRegion.ImplicitLocation;
import com.facebook.qe.api.QeAccessor;
import com.facebook.user.model.User;
import com.facebook.user.model.User.Type;
import com.facebook.user.model.UserBuilder;
import com.google.common.annotations.VisibleForTesting;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: context_item_add_prompt_impression */
public class OptimisticPostHelper<DataProvider extends ProvidesAttachments & ProvidesIsBackoutDraft & ProvidesIsImplicitLocationSupported & ProvidesSessionId & ProvidesTargetAlbum & ProvidesTextWithEntities & ProvidesTopics & ProvidesConfiguration & ProvidesContentType & ProvidesLocationInfo & ProvidesPrivacyData & ProvidesShareParams & ProvidesStickerData & ProvidesTaggedUsers & ProvidesTargetData & ProvidesMinutiae & ProvidesProductItemAttachment & ProvidesPublishMode & ProvidesRedSpaceValue> {
    public final DataProvider f16822a;
    private final Provider<User> f16823b;
    @Nullable
    private final ComposerPluginGetters$BooleanGetter f16824c;
    private final OptimisticPostStoryBuilderProvider f16825d;
    public final QeAccessor f16826e;

    @Inject
    @VisibleForTesting
    public OptimisticPostHelper(@Assisted DataProvider dataProvider, @Nullable @Assisted ComposerPluginGetters$BooleanGetter composerPluginGetters$BooleanGetter, Provider<User> provider, OptimisticPostStoryBuilderProvider optimisticPostStoryBuilderProvider, QeAccessor qeAccessor) {
        this.f16823b = provider;
        this.f16822a = dataProvider;
        this.f16824c = composerPluginGetters$BooleanGetter;
        this.f16825d = optimisticPostStoryBuilderProvider;
        this.f16826e = qeAccessor;
    }

    public final boolean m20822a() {
        if (((ProvidesIsBackoutDraft) this.f16822a).z()) {
            return false;
        }
        if (!((ProvidesConfiguration) this.f16822a).o().shouldUseOptimisticPosting()) {
            return false;
        }
        if (((ProvidesPublishMode) this.f16822a).j() != PublishMode.NORMAL) {
            return false;
        }
        if (AttachmentUtils.l(this.f16822a.m()) && !m20821e()) {
            return false;
        }
        if (((ProvidesMinutiae) this.f16822a).l() != null && !((ProvidesMinutiae) this.f16822a).l().f()) {
            return false;
        }
        if (this.f16824c == null || this.f16824c.mo1301a()) {
            return true;
        }
        return false;
    }

    public final OptimisticPostStoryBuilder m20823b() {
        User aa;
        boolean z;
        if (((ProvidesTargetData) this.f16822a).s().a()) {
            UserBuilder a = new UserBuilder().a(Type.FACEBOOK_OBJECT, String.valueOf(((ProvidesTargetData) this.f16822a).s().targetId));
            a.h = ((ProvidesTargetData) this.f16822a).s().targetName;
            a = a;
            a.n = ((ProvidesTargetData) this.f16822a).s().targetProfilePicUrl;
            aa = a.aa();
        } else {
            aa = (User) this.f16823b.get();
        }
        ImplicitLocation implicitLocation = null;
        if (((ProvidesIsImplicitLocationSupported) this.f16822a).G()) {
            implicitLocation = ((ProvidesLocationInfo) this.f16822a).g().f();
        }
        OptimisticPostStoryBuilder a2 = this.f16825d.m4479a(((ProvidesTextWithEntities) this.f16822a).ae(), ((ProvidesTaggedUsers) this.f16822a).h(), this.f16822a.m());
        a2.f3830s = ((ProvidesConfiguration) this.f16822a).o().getAttachedStory();
        a2 = a2;
        a2.f3826o = ((ProvidesSessionId) this.f16822a).ab();
        a2 = a2;
        a2.f3828q = ((ProvidesLocationInfo) this.f16822a).g().a();
        a2 = a2;
        a2.f3833v = ((ProvidesMinutiae) this.f16822a).l();
        a2 = a2;
        a2.f3831t = ((ProvidesProductItemAttachment) this.f16822a).i();
        a2 = a2;
        a2.f3827p = ((ProvidesTargetAlbum) this.f16822a).ad();
        a2 = a2;
        a2.f3832u = ((ProvidesTargetData) this.f16822a).s().targetId;
        OptimisticPostStoryBuilder optimisticPostStoryBuilder = a2;
        optimisticPostStoryBuilder.f3829r = implicitLocation;
        OptimisticPostStoryBuilder optimisticPostStoryBuilder2 = optimisticPostStoryBuilder;
        optimisticPostStoryBuilder2.f3834w = ((ProvidesPrivacyData) this.f16822a).ag().f2005f;
        optimisticPostStoryBuilder2 = optimisticPostStoryBuilder2;
        optimisticPostStoryBuilder2.f3835x = ((ProvidesTargetData) this.f16822a).s().targetName;
        optimisticPostStoryBuilder2 = optimisticPostStoryBuilder2;
        optimisticPostStoryBuilder2.f3836y = ((ProvidesTargetData) this.f16822a).s().targetProfilePicUrl;
        optimisticPostStoryBuilder = optimisticPostStoryBuilder2.m4477a(aa);
        String str = ((ProvidesStickerData) this.f16822a).r() == null ? null : ((ProvidesStickerData) this.f16822a).r().staticDiskUri != null ? ((ProvidesStickerData) this.f16822a).r().staticDiskUri : ((ProvidesStickerData) this.f16822a).r().staticWebUri;
        optimisticPostStoryBuilder.f3804D = str;
        OptimisticPostStoryBuilder optimisticPostStoryBuilder3 = optimisticPostStoryBuilder;
        optimisticPostStoryBuilder3.f3806F = ((ProvidesRedSpaceValue) this.f16822a).k();
        optimisticPostStoryBuilder3 = optimisticPostStoryBuilder3;
        optimisticPostStoryBuilder3.f3808H = ((ProvidesShareParams) this.f16822a).q();
        optimisticPostStoryBuilder = optimisticPostStoryBuilder3;
        optimisticPostStoryBuilder.f3809I = m20820d();
        optimisticPostStoryBuilder3 = optimisticPostStoryBuilder;
        optimisticPostStoryBuilder3.f3810J = ((ProvidesTopics) this.f16822a).af();
        optimisticPostStoryBuilder3 = optimisticPostStoryBuilder3;
        if (((ProvidesContentType) this.f16822a).c() == ComposerContentType.SLIDESHOW) {
            z = true;
        } else {
            z = false;
        }
        optimisticPostStoryBuilder3.f3811K = z;
        return optimisticPostStoryBuilder3;
    }

    @VisibleForTesting
    private boolean m20820d() {
        if (AttachmentUtils.l(this.f16822a.m())) {
            return m20821e();
        }
        return this.f16826e.a(ExperimentsForComposerAbTestModule.S, false);
    }

    private boolean m20821e() {
        return this.f16826e.a(ExperimentsForComposerAbTestModule.R, false);
    }
}
