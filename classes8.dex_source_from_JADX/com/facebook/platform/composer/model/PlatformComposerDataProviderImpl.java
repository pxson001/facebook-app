package com.facebook.platform.composer.model;

import com.facebook.composer.attachments.ComposerAttachment;
import com.facebook.composer.attachments.ComposerAttachment.ProvidesAttachments;
import com.facebook.composer.minutiae.model.MinutiaeObject;
import com.facebook.composer.minutiae.model.MinutiaeObject.ProvidesMinutiae;
import com.facebook.composer.privacy.common.ComposerPrivacyData;
import com.facebook.composer.privacy.common.ComposerPrivacyData.ProvidesPrivacyData;
import com.facebook.graphql.model.GraphQLAlbum;
import com.facebook.graphql.model.GraphQLExploreFeed;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsBackoutDraft;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsImplicitLocationSupported;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesSessionId;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesTargetAlbum;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesTextWithEntities;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesTopics;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.intent.ComposerConfigurationSpec.ProvidesConfiguration;
import com.facebook.ipc.composer.intent.ComposerShareParams;
import com.facebook.ipc.composer.intent.ComposerShareParams.ProvidesShareParams;
import com.facebook.ipc.composer.intent.ComposerStickerData;
import com.facebook.ipc.composer.intent.ComposerStickerData.ProvidesStickerData;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.ipc.composer.intent.ComposerTargetData.ProvidesTargetData;
import com.facebook.ipc.composer.model.ComposerContentType;
import com.facebook.ipc.composer.model.ComposerContentType.ProvidesContentType;
import com.facebook.ipc.composer.model.ComposerLocationInfo;
import com.facebook.ipc.composer.model.ComposerLocationInfo.ProvidesLocationInfo;
import com.facebook.ipc.composer.model.ComposerTaggedUser;
import com.facebook.ipc.composer.model.ComposerTaggedUser.ProvidesTaggedUsers;
import com.facebook.ipc.composer.model.ProductItemAttachment;
import com.facebook.ipc.composer.model.ProductItemAttachment.ProvidesProductItemAttachment;
import com.facebook.ipc.composer.model.PublishMode;
import com.facebook.ipc.composer.model.PublishMode.ProvidesPublishMode;
import com.facebook.ipc.composer.model.RedSpaceValue;
import com.facebook.ipc.composer.model.RedSpaceValue.ProvidesRedSpaceValue;
import com.facebook.platform.composer.composer.PlatformComposerFragment.AnonymousClass14;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: rich_document_author */
public class PlatformComposerDataProviderImpl implements ProvidesAttachments, ProvidesMinutiae, ProvidesPrivacyData, ProvidesIsBackoutDraft, ProvidesIsImplicitLocationSupported, ProvidesSessionId, ProvidesTargetAlbum, ProvidesTextWithEntities, ProvidesTopics, ProvidesConfiguration, ProvidesShareParams, ProvidesStickerData, ProvidesTargetData, ProvidesContentType, ProvidesLocationInfo, ProvidesTaggedUsers, ProvidesProductItemAttachment, ProvidesPublishMode, ProvidesRedSpaceValue {
    private final AnonymousClass14 f4171a;

    @Inject
    public PlatformComposerDataProviderImpl(@Assisted AnonymousClass14 anonymousClass14) {
        this.f4171a = (AnonymousClass14) Preconditions.checkNotNull(anonymousClass14);
    }

    public final ImmutableList<ComposerAttachment> m4133m() {
        return this.f4171a.m4003a().f4188c.m4153e();
    }

    public final ComposerConfiguration m4134o() {
        return this.f4171a.m4003a().f4187b;
    }

    public final ComposerContentType m4126c() {
        return ComposerContentType.SLIDESHOW;
    }

    public final boolean m4138z() {
        return this.f4171a.m4003a().f4188c.m4171w();
    }

    public final boolean m4125G() {
        return false;
    }

    public final ComposerLocationInfo m4127g() {
        return this.f4171a.m4003a().f4188c.m4157i();
    }

    @Nullable
    public final MinutiaeObject m4132l() {
        return this.f4171a.m4003a().f4188c.m4158j();
    }

    public final ComposerPrivacyData ag() {
        return this.f4171a.m4003a().f4189d;
    }

    public final ProductItemAttachment m4129i() {
        return this.f4171a.m4003a().f4188c.m4159k();
    }

    public final PublishMode m4130j() {
        return this.f4171a.m4003a().f4188c.m4161m();
    }

    public final RedSpaceValue m4131k() {
        return this.f4171a.m4003a().f4188c.m4154f();
    }

    public final String ab() {
        return this.f4171a.m4003a().f4186a;
    }

    public final ComposerShareParams m4135q() {
        return this.f4171a.m4003a().f4188c.m4165q();
    }

    public final ComposerStickerData m4136r() {
        return this.f4171a.m4003a().f4188c.m4164p();
    }

    public final ImmutableList<ComposerTaggedUser> m4128h() {
        Collection arrayList = new ArrayList();
        Iterator it = this.f4171a.m4003a().f4188c.m4169u().iterator();
        while (it.hasNext()) {
            arrayList.add(ComposerTaggedUser.a(((Long) it.next()).longValue()).a());
        }
        return ImmutableList.copyOf(arrayList);
    }

    public final GraphQLAlbum ad() {
        return this.f4171a.m4003a().f4188c.m4151c();
    }

    public final ComposerTargetData m4137s() {
        return this.f4171a.m4003a().f4190e;
    }

    public final GraphQLTextWithEntities ae() {
        return this.f4171a.m4003a().f4188c.m4155g();
    }

    public final ImmutableList<GraphQLExploreFeed> af() {
        return null;
    }
}
