package com.facebook.composer.publish.helpers;

import com.facebook.auth.annotations.LoggedInUser;
import com.facebook.composer.activity.ComposerDataProviderImpl;
import com.facebook.composer.attachments.AttachmentUtils;
import com.facebook.composer.attachments.ComposerTagUtil;
import com.facebook.composer.lifeevent.model.ComposerLifeEventModel;
import com.facebook.composer.lifeevent.protocol.ComposerLifeEventParam;
import com.facebook.graphql.enums.GraphQLLifeEventEducationExperienceType;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.model.ComposerDateInfo;
import com.facebook.photos.upload.manager.UploadManager;
import com.facebook.photos.upload.operation.UploadOperationFactory;
import com.facebook.photos.upload.protocol.PhotoUploadPrivacy;
import com.facebook.tagging.graphql.utils.MentionsUtils;
import com.facebook.ultralight.Inject;
import com.facebook.ultralight.UltralightRuntime;
import com.facebook.user.model.User;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Provider;

/* compiled from: content_listening */
public class PublishLifeEventHelper {
    @Inject
    @LoggedInUser
    public volatile Provider<User> f16853a = UltralightRuntime.a;
    private final ComposerDataProviderImpl f16854b;
    private final ComposerLifeEventModel f16855c;
    private final UploadOperationFactory f16856d;
    private final UploadManager f16857e;
    private final ComposerDateInfo f16858f;

    @Inject
    public PublishLifeEventHelper(@Assisted ComposerDataProviderImpl composerDataProviderImpl, @Assisted ComposerLifeEventModel composerLifeEventModel, @Assisted ComposerDateInfo composerDateInfo, UploadOperationFactory uploadOperationFactory, UploadManager uploadManager) {
        this.f16854b = composerDataProviderImpl;
        this.f16855c = composerLifeEventModel;
        this.f16858f = composerDateInfo;
        this.f16856d = uploadOperationFactory;
        this.f16857e = uploadManager;
    }

    public final ComposerLifeEventParam m20840a() {
        String cf_;
        String str = null;
        if (this.f16854b.g().a() != null) {
            cf_ = this.f16854b.g().a().cf_();
        } else {
            cf_ = null;
        }
        Builder builder = new Builder();
        if (this.f16855c.f != null) {
            builder.c(this.f16855c.f);
        } else if (!this.f16854b.h().isEmpty()) {
            ImmutableList a = ComposerTagUtil.a(this.f16854b.h());
            int size = a.size();
            for (int i = 0; i < size; i++) {
                builder.c(String.valueOf((Long) a.get(i)));
            }
        }
        User user = (User) this.f16853a.get();
        ComposerLifeEventParam.Builder builder2 = new ComposerLifeEventParam.Builder();
        builder2.a = this.f16854b.ab();
        builder2 = builder2;
        builder2.b = String.valueOf(user.a);
        ComposerLifeEventParam.Builder builder3 = builder2;
        builder3.c = this.f16855c.d;
        builder3 = builder3;
        builder3.d = this.f16855c.a;
        builder3 = builder3;
        builder3.e = MentionsUtils.a(this.f16854b.ae());
        builder3 = builder3;
        builder3.f = ComposerLifeEventParam.Builder.c(this.f16858f.a());
        builder3 = builder3;
        builder3.g = ComposerLifeEventParam.Builder.c(this.f16858f.b());
        builder3 = builder3;
        builder3.h = "fb4a_composer";
        builder3 = builder3;
        builder3.i = cf_;
        builder3 = builder3;
        builder3.j = this.f16854b.ag().m1946a();
        builder3 = builder3;
        builder3.k = builder.b();
        builder3 = builder3;
        builder3.m = this.f16855c.b;
        builder3 = builder3;
        builder3.n = this.f16855c.e;
        builder3 = builder3;
        builder3.o = this.f16855c.h;
        builder3 = builder3;
        if (this.f16855c.i != GraphQLLifeEventEducationExperienceType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) {
            str = this.f16855c.i.name();
        }
        builder3.p = str;
        builder3 = builder3;
        builder3.q = this.f16855c.j;
        builder3 = builder3;
        builder3.r = this.f16858f.c();
        builder3 = builder3;
        builder3.s = this.f16855c.k;
        return builder3.a();
    }

    public final boolean m20841a(ComposerLifeEventParam composerLifeEventParam) {
        Preconditions.checkArgument(composerLifeEventParam.composerSessionId.equals(this.f16854b.ab()));
        if (!AttachmentUtils.k(this.f16854b.m())) {
            return false;
        }
        this.f16857e.a(this.f16856d.a(AttachmentUtils.o(this.f16854b.m()), AttachmentUtils.p(this.f16854b.m()), new PhotoUploadPrivacy(this.f16854b.ag().m1946a()), composerLifeEventParam, this.f16854b.ab()));
        return true;
    }
}
