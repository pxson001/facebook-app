package com.facebook.timeline.header.data;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.facebook.common.util.StringUtil;
import com.facebook.contacts.graphql.Contact;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLSecondarySubscribeStatus;
import com.facebook.graphql.enums.GraphQLStructuredNamePart;
import com.facebook.graphql.enums.GraphQLSubscribeStatus;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.ipc.composer.intent.graphql.FetchComposerTargetDataPrivacyScopeInterfaces.ComposerTargetDataPrivacyScopeFields;
import com.facebook.ipc.composer.intent.graphql.FetchComposerTargetDataPrivacyScopeModels.ComposerTargetDataPrivacyScopeFieldsModel;
import com.facebook.ipc.profile.TimelineContext;
import com.facebook.timeline.header.data.TimelineHeaderData.InitializeState;
import com.facebook.timeline.logging.ImageResolutionQuality;
import com.facebook.timeline.profilevideo.playback.protocol.FetchProfileVideoGraphQLModels.ProfileVideoHeaderFieldsModel;
import com.facebook.timeline.profilevideo.playback.protocol.ProfileVideoHeaderData;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLInterfaces.ExternalLink;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLInterfaces.FavoritePhoto;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLInterfaces.SuggestedPhoto;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLInterfaces.TimelineContextListItemsConnectionFields;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLModels.TimelineHeaderFocusedCoverPhotoFieldsModel;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLModels.TimelineHeaderProfileIntroCardFieldsModel;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLModels.TimelineHeaderStructuredNameModel;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLModels.TimelineHeaderUserFieldsModel;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLModels.TimelineHeaderUserFieldsModel.Builder;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLModels.TimelineNuxFieldsModel.ProfileWizardNuxModel;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLModels.TimelineRefresherFieldsModel.ProfileWizardRefresherModel;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLModels.UserTimelineSelfQueryFieldsModel;
import com.facebook.timeline.widget.actionbar.protocol.TimelineHeaderActionFieldsGraphQLInterfaces.TimelineHeaderActionFields;
import com.facebook.timeline.widget.actionbar.protocol.TimelineHeaderActionFieldsGraphQLModels.TimelineHeaderActionFieldsModel;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: fb_share_external_package_selected */
public class TimelineHeaderUserData extends TimelineHeaderData implements ProfileVideoHeaderData {
    @Nullable
    public TimelineHeaderUserFieldsModel f14604a;
    @Nullable
    public TimelineHeaderProfileIntroCardFieldsModel f14605b;
    public boolean f14606c;
    @Nullable
    public TimelineHeaderActionFields f14607d;
    @Nullable
    private ProfileVideoHeaderFieldsModel f14608e;
    public final TimelineHeaderProfilePictureData f14609f = new TimelineHeaderProfilePictureData();
    public final TimelineHeaderCoverPhotoData f14610g = new TimelineHeaderCoverPhotoData();
    private Optional<TimelineContextListItemsConnectionFields> f14611h = Absent.INSTANCE;
    public ImageResolutionQuality f14612i = ImageResolutionQuality.NONE;
    public ImageResolutionQuality f14613j = ImageResolutionQuality.NONE;
    public boolean f14614k = false;
    @Nullable
    public ProfileWizardNuxModel f14615l = null;
    @Nullable
    public ProfileWizardRefresherModel f14616m;
    @Nullable
    private String f14617n = null;

    public final void m18507a(Contact contact) {
        if (this.f14592e != InitializeState.FINAL_DATA) {
            String q;
            boolean q2 = contact.q();
            GraphQLSubscribeStatus y = (this.f14607d == null || this.f14607d.n() == GraphQLSubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) ? contact.y() : this.f14607d.n();
            GraphQLFriendshipStatus x = (this.f14607d == null || this.f14607d.j() == GraphQLFriendshipStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) ? contact.x() : this.f14607d.j();
            if (this.f14592e == InitializeState.PRELIM_DATA) {
                q = this.f14604a.q();
            } else {
                q = contact.e().g();
            }
            Builder a = Builder.a((TimelineHeaderUserFieldsModel) this.f14607d);
            a.q = q;
            a = a;
            a.d = q2;
            a = a;
            a.A = y;
            a = a;
            a.j = x;
            m18487a(a.a());
            this.f14592e = InitializeState.PRELIM_DATA;
        }
    }

    public TimelineHeaderUserData(TimelineContext timelineContext) {
        super(timelineContext);
    }

    public final void m18511a(Object obj) {
        if (obj instanceof UserTimelineSelfQueryFieldsModel) {
            UserTimelineSelfQueryFieldsModel userTimelineSelfQueryFieldsModel = (UserTimelineSelfQueryFieldsModel) obj;
            m18487a(userTimelineSelfQueryFieldsModel.a());
            this.f14615l = userTimelineSelfQueryFieldsModel.c();
            this.f14616m = userTimelineSelfQueryFieldsModel.d();
            this.f14617n = userTimelineSelfQueryFieldsModel.b();
        } else {
            m18487a((TimelineHeaderUserFieldsModel) obj);
            this.f14615l = null;
            this.f14617n = null;
        }
        m18480d();
    }

    public final void m18512a(String str, String str2, DefaultImageFields defaultImageFields, @Nullable TimelineHeaderFocusedCoverPhotoFieldsModel timelineHeaderFocusedCoverPhotoFieldsModel, GraphQLFriendshipStatus graphQLFriendshipStatus) {
        Builder builder = new Builder();
        builder.k = str;
        builder = builder;
        builder.q = str2;
        builder = builder;
        builder.u = DefaultImageFieldsModel.a(defaultImageFields);
        builder = builder;
        builder.h = TimelineHeaderFocusedCoverPhotoFieldsModel.a(timelineHeaderFocusedCoverPhotoFieldsModel);
        builder = builder;
        builder.j = graphQLFriendshipStatus;
        m18487a(builder.a());
        this.f14592e = InitializeState.PRELIM_DATA;
    }

    public final boolean m18515r() {
        if (this.f14604a == null) {
            return false;
        }
        return this.f14604a.w();
    }

    public final Optional<TimelineContextListItemsConnectionFields> m18516s() {
        if (this.f14611h.isPresent()) {
            return Optional.of(this.f14611h.get());
        }
        return Absent.INSTANCE;
    }

    private void m18487a(TimelineHeaderUserFieldsModel timelineHeaderUserFieldsModel) {
        Preconditions.checkNotNull(timelineHeaderUserFieldsModel);
        this.f14604a = timelineHeaderUserFieldsModel;
        this.f14605b = timelineHeaderUserFieldsModel.r();
        m18488b(timelineHeaderUserFieldsModel);
        if (timelineHeaderUserFieldsModel.u() != null) {
            this.f14608e = timelineHeaderUserFieldsModel.u().a();
        } else {
            this.f14608e = null;
        }
        TimelineHeaderProfilePictureData timelineHeaderProfilePictureData = this.f14609f;
        timelineHeaderProfilePictureData.f14601a = timelineHeaderUserFieldsModel;
        timelineHeaderProfilePictureData.f14602b = timelineHeaderUserFieldsModel.s();
        this.f14610g.f14583a = timelineHeaderUserFieldsModel.o();
        if (timelineHeaderUserFieldsModel instanceof TimelineHeaderUserFieldsModel) {
            this.f14611h = Optional.fromNullable(timelineHeaderUserFieldsModel.D());
        }
        TimelineHeaderCoverPhotoData timelineHeaderCoverPhotoData = this.f14610g;
        if (timelineHeaderUserFieldsModel != null) {
            if (timelineHeaderUserFieldsModel.o() == null || timelineHeaderUserFieldsModel.o().b() == null || timelineHeaderUserFieldsModel.o().b().b() == null) {
                timelineHeaderCoverPhotoData.f14586d = new String[]{timelineHeaderUserFieldsModel.q()};
            } else {
                timelineHeaderCoverPhotoData.f14586d = new String[]{timelineHeaderUserFieldsModel.q(), timelineHeaderUserFieldsModel.o().b().b()};
            }
        }
        m18483k();
        if (this.f14607d != null) {
            GraphQLFriendshipStatus j = this.f14607d.j();
            GraphQLSubscribeStatus n = this.f14607d.n();
            if ((j != null && j != GraphQLFriendshipStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) || (n != null && n != GraphQLSubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE)) {
                m18484l();
            }
        }
    }

    private void m18488b(TimelineHeaderUserFieldsModel timelineHeaderUserFieldsModel) {
        if (this.f14607d instanceof TimelineHeaderUserFieldsModel) {
            TimelineHeaderUserFieldsModel timelineHeaderUserFieldsModel2 = (TimelineHeaderUserFieldsModel) this.f14607d;
            if (!(timelineHeaderUserFieldsModel2.p() == null || timelineHeaderUserFieldsModel.p() == null || !timelineHeaderUserFieldsModel2.p().equals(timelineHeaderUserFieldsModel.p()) || timelineHeaderUserFieldsModel2.j() == GraphQLFriendshipStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE || !(timelineHeaderUserFieldsModel instanceof TimelineHeaderUserFieldsModel))) {
                Builder a = Builder.a(timelineHeaderUserFieldsModel);
                a.j = timelineHeaderUserFieldsModel2.j();
                this.f14607d = a.a();
                return;
            }
        }
        this.f14607d = timelineHeaderUserFieldsModel;
    }

    public final boolean m18517v() {
        TimelineHeaderProfilePictureData timelineHeaderProfilePictureData = this.f14609f;
        boolean z = false;
        if (timelineHeaderProfilePictureData.f14603c == null && timelineHeaderProfilePictureData.f14601a != null && timelineHeaderProfilePictureData.f14601a.C()) {
            z = true;
        }
        return z;
    }

    public final boolean m18518w() {
        TimelineHeaderProfilePictureData timelineHeaderProfilePictureData = this.f14609f;
        boolean z = false;
        if (!(timelineHeaderProfilePictureData.f14603c != null || timelineHeaderProfilePictureData.f14601a == null || timelineHeaderProfilePictureData.f14601a.B() == 0)) {
            z = true;
        }
        return z;
    }

    public final long m18519x() {
        Preconditions.checkState(m18518w(), "getProfilePictureExpirationTimeSeconds is meaningless for a non-expiring picture");
        TimelineHeaderProfilePictureData timelineHeaderProfilePictureData = this.f14609f;
        long j = 0;
        if (timelineHeaderProfilePictureData.f14603c == null && timelineHeaderProfilePictureData.f14601a != null) {
            j = timelineHeaderProfilePictureData.f14601a.B() * 1000;
        }
        return j;
    }

    @Nullable
    public final String m18520y() {
        TimelineHeaderStructuredNameModel timelineHeaderStructuredNameModel;
        if (this.f14604a == null) {
            timelineHeaderStructuredNameModel = null;
        } else {
            timelineHeaderStructuredNameModel = this.f14604a.A();
        }
        TimelineHeaderStructuredNameModel timelineHeaderStructuredNameModel2 = timelineHeaderStructuredNameModel;
        if (timelineHeaderStructuredNameModel2 == null) {
            return null;
        }
        return GraphQLHelper.a(GraphQLStructuredNamePart.FIRST, timelineHeaderStructuredNameModel2.a(), timelineHeaderStructuredNameModel2.b());
    }

    @Nonnull
    public final GraphQLFriendshipStatus m18489B() {
        if (this.f14607d == null || this.f14607d.j() == null || this.f14607d.j() == GraphQLFriendshipStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) {
            return GraphQLFriendshipStatus.CANNOT_REQUEST;
        }
        return this.f14607d.j();
    }

    private TimelineHeaderActionFieldsModel.Builder ak() {
        Preconditions.checkNotNull(this.f14607d);
        TimelineHeaderActionFields timelineHeaderActionFields = this.f14607d;
        if (timelineHeaderActionFields instanceof TimelineHeaderActionFieldsModel) {
            TimelineHeaderActionFieldsModel timelineHeaderActionFieldsModel = (TimelineHeaderActionFieldsModel) timelineHeaderActionFields;
            TimelineHeaderActionFieldsModel.Builder builder = new TimelineHeaderActionFieldsModel.Builder();
            builder.a = timelineHeaderActionFieldsModel.b();
            builder.b = timelineHeaderActionFieldsModel.c();
            builder.c = timelineHeaderActionFieldsModel.d();
            builder.d = timelineHeaderActionFieldsModel.do_();
            builder.e = timelineHeaderActionFieldsModel.g();
            builder.f = timelineHeaderActionFieldsModel.dp_();
            builder.g = timelineHeaderActionFieldsModel.a();
            builder.h = timelineHeaderActionFieldsModel.j();
            builder.i = timelineHeaderActionFieldsModel.k();
            builder.j = timelineHeaderActionFieldsModel.o();
            builder.k = timelineHeaderActionFieldsModel.m();
            builder.l = timelineHeaderActionFieldsModel.n();
            return builder;
        }
        TimelineHeaderActionFieldsModel.Builder builder2 = new TimelineHeaderActionFieldsModel.Builder();
        builder2.c = timelineHeaderActionFields.d();
        builder2 = builder2;
        builder2.d = timelineHeaderActionFields.do_();
        builder2 = builder2;
        builder2.e = timelineHeaderActionFields.g();
        builder2 = builder2;
        builder2.h = timelineHeaderActionFields.j();
        builder2 = builder2;
        builder2.j = ComposerTargetDataPrivacyScopeFieldsModel.a(timelineHeaderActionFields.l());
        builder2 = builder2;
        builder2.l = timelineHeaderActionFields.n();
        return builder2;
    }

    public final void m18508a(GraphQLFriendshipStatus graphQLFriendshipStatus) {
        if (this.f14607d != null) {
            TimelineHeaderActionFieldsModel.Builder ak = ak();
            ak.h = graphQLFriendshipStatus;
            this.f14607d = ak.a();
            m18484l();
            m18483k();
        }
    }

    public final GraphQLSubscribeStatus m18490C() {
        if (this.f14607d == null || this.f14607d.n() == null || this.f14607d.n() == GraphQLSubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) {
            return GraphQLSubscribeStatus.CANNOT_SUBSCRIBE;
        }
        return this.f14607d.n();
    }

    public final void m18510a(GraphQLSubscribeStatus graphQLSubscribeStatus) {
        if (this.f14607d != null) {
            TimelineHeaderActionFieldsModel.Builder ak = ak();
            ak.l = graphQLSubscribeStatus;
            this.f14607d = ak.a();
            m18484l();
            m18483k();
        }
    }

    public final void m18509a(GraphQLSecondarySubscribeStatus graphQLSecondarySubscribeStatus) {
        if (this.f14607d != null) {
            TimelineHeaderActionFieldsModel.Builder ak = ak();
            ak.k = graphQLSecondarySubscribeStatus;
            this.f14607d = ak.a();
            m18484l();
            m18483k();
        }
    }

    public final GraphQLSecondarySubscribeStatus m18491D() {
        if (this.f14607d == null || this.f14607d.m() == null || this.f14607d.m() == GraphQLSecondarySubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) {
            return GraphQLSecondarySubscribeStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE;
        }
        return this.f14607d.m();
    }

    public final void mo1150p() {
        super.mo1150p();
        this.f14604a = null;
        this.f14607d = null;
        this.f14608e = null;
        this.f14611h = Absent.INSTANCE;
        TimelineHeaderProfilePictureData timelineHeaderProfilePictureData = this.f14609f;
        timelineHeaderProfilePictureData.f14601a = null;
        timelineHeaderProfilePictureData.f14602b = null;
        TimelineHeaderCoverPhotoData timelineHeaderCoverPhotoData = this.f14610g;
        timelineHeaderCoverPhotoData.f14583a = null;
        timelineHeaderCoverPhotoData.f14585c = null;
        timelineHeaderCoverPhotoData.f14586d = null;
    }

    @Nullable
    public final String m18492E() {
        if (this.f14604a == null) {
            return null;
        }
        return this.f14604a.p();
    }

    @Nullable
    public final DefaultImageFields m18493K() {
        TimelineHeaderProfilePictureData timelineHeaderProfilePictureData = this.f14609f;
        return timelineHeaderProfilePictureData.f14601a != null ? timelineHeaderProfilePictureData.f14601a.t() : null;
    }

    @Nullable
    public final String m18494L() {
        String uri;
        TimelineHeaderProfilePictureData timelineHeaderProfilePictureData = this.f14609f;
        if (timelineHeaderProfilePictureData.f14603c != null) {
            uri = timelineHeaderProfilePictureData.f14603c.toString();
        } else if (timelineHeaderProfilePictureData.f14601a == null || timelineHeaderProfilePictureData.f14601a.t() == null) {
            uri = null;
        } else {
            uri = timelineHeaderProfilePictureData.f14601a.t().b();
        }
        return uri;
    }

    public final void m18506a(Uri uri) {
        this.f14609f.f14603c = uri;
        m18483k();
    }

    @Nullable
    public final ProfileVideoHeaderFieldsModel m18513b() {
        return this.f14608e;
    }

    @Nullable
    public final String m18495N() {
        if (this.f14604a == null) {
            return null;
        }
        return this.f14604a.q();
    }

    public final TimelineHeaderFocusedCoverPhotoFieldsModel m18496P() {
        return this.f14610g.f14583a;
    }

    public final String[] m18497Q() {
        return this.f14610g.f14586d;
    }

    @Nullable
    public final String m18498R() {
        String uri;
        TimelineHeaderCoverPhotoData timelineHeaderCoverPhotoData = this.f14610g;
        if (timelineHeaderCoverPhotoData.f14587e != null) {
            uri = timelineHeaderCoverPhotoData.f14587e.toString();
        } else if (timelineHeaderCoverPhotoData.f14583a == null || timelineHeaderCoverPhotoData.f14583a.b() == null || timelineHeaderCoverPhotoData.f14583a.b().du_() == null) {
            uri = null;
        } else {
            uri = timelineHeaderCoverPhotoData.f14583a.b().du_().b();
        }
        return uri;
    }

    public final boolean m18499T() {
        return this.f14607d != null && this.f14607d.g();
    }

    public final ComposerTargetDataPrivacyScopeFields m18500U() {
        if (this.f14607d == null) {
            return null;
        }
        return this.f14607d.l();
    }

    public final ListenableFuture<Drawable> m18501V() {
        return this.f14610g.f14585c;
    }

    public final boolean m18502W() {
        return (this.f14605b == null || this.f14605b.b() == null || StringUtil.a(this.f14605b.b().a())) ? false : true;
    }

    public final boolean m18503Y() {
        return (this.f14605b == null || this.f14605b.g() == null || this.f14605b.g().a().isEmpty()) ? false : true;
    }

    public final ImmutableList<? extends FavoritePhoto> m18504Z() {
        if (this.f14605b == null || this.f14605b.dx_() == null || this.f14605b.dx_().a().isEmpty()) {
            return RegularImmutableList.a;
        }
        return this.f14605b.dx_().a();
    }

    public final boolean aa() {
        return !ab().isEmpty();
    }

    public final ImmutableList<? extends SuggestedPhoto> ab() {
        if (this.f14605b == null || this.f14605b.m() == null || this.f14605b.m().a().isEmpty()) {
            return RegularImmutableList.a;
        }
        return this.f14605b.m().a();
    }

    public final ImmutableList<? extends ExternalLink> ac() {
        if (this.f14605b == null || this.f14605b.dw_().isEmpty()) {
            return RegularImmutableList.a;
        }
        return this.f14605b.dw_();
    }

    @Nullable
    public final String m18505a() {
        return this.f14617n;
    }
}
