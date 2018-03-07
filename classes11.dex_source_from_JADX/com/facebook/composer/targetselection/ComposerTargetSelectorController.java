package com.facebook.composer.targetselection;

import android.content.Intent;
import android.content.res.Resources;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.util.TriState;
import com.facebook.composer.activity.ComposerDataProviderImpl;
import com.facebook.composer.activity.ComposerFragment;
import com.facebook.composer.activity.ComposerFragment.AnonymousClass63;
import com.facebook.composer.analytics.ComposerAnalyticsLogger;
import com.facebook.composer.analytics.ComposerAnalyticsLogger.Events;
import com.facebook.composer.attachments.AttachmentUtils;
import com.facebook.composer.attachments.ComposerAttachment.ProvidesAttachments;
import com.facebook.composer.capability.ComposerAlbumCapability;
import com.facebook.composer.capability.ComposerCheckinCapability;
import com.facebook.composer.capability.ComposerMinutiaeCapability;
import com.facebook.composer.capability.ComposerMultimediaCapability;
import com.facebook.composer.capability.ComposerPhotoCapability;
import com.facebook.composer.capability.ComposerPhotoCapability.Capability;
import com.facebook.composer.capability.ComposerTagPeopleCapability;
import com.facebook.composer.controller.ComposerTitleGenerator;
import com.facebook.composer.minutiae.model.MinutiaeObject.ProvidesMinutiae;
import com.facebook.composer.viewerpageadminutil.CheckViewerPageAdminUtil;
import com.facebook.fbui.menu.MenuItemImpl;
import com.facebook.fbui.menu.PopoverMenu;
import com.facebook.graphql.model.GraphQLHelper;
import com.facebook.graphql.model.StoryActorHelper;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsInlineSproutsSupported;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsTargetMenuSupported;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsTransliterationSupported;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesSessionId;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesTargetAlbum;
import com.facebook.ipc.composer.intent.ComposerConfiguration;
import com.facebook.ipc.composer.intent.ComposerConfigurationSpec.ProvidesConfiguration;
import com.facebook.ipc.composer.intent.ComposerShareParams.ProvidesShareParams;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.ipc.composer.intent.ComposerTargetData.ProvidesTargetData;
import com.facebook.ipc.composer.model.ComposerFacecastInfo.ProvidesFacecastInfo;
import com.facebook.ipc.composer.model.ComposerLocationInfo.ProvidesLocationInfo;
import com.facebook.ipc.composer.model.ComposerTaggedUser.ProvidesTaggedUsers;
import com.facebook.ipc.composer.model.PublishMode;
import com.facebook.ipc.composer.model.PublishMode.ProvidesPublishMode;
import com.facebook.ipc.composer.model.RedSpaceValue;
import com.facebook.ipc.composer.model.RedSpaceValue.ProvidesRedSpaceValue;
import com.facebook.ipc.composer.model.TargetType;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.BooleanGetter;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.Getter;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.ProvidesPluginAllowsAttachingToAlbumsGetter;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.ProvidesPluginAllowsCheckinGetter;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.ProvidesPluginAllowsMinutiaeGetter;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.ProvidesPluginAllowsPhotoGetter;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.ProvidesPluginAllowsTaggingPeopleGetter;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.ProvidesPluginTitleGetter;
import com.facebook.story.GraphQLStoryHelper;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps.EntryTransformer;
import java.lang.ref.WeakReference;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: fetchLayoutAndTilesRequest */
public class ComposerTargetSelectorController<DataProvider extends ProvidesAttachments & ProvidesIsTargetMenuSupported & ProvidesSessionId & ProvidesTargetAlbum & ProvidesIsTransliterationSupported & ProvidesIsInlineSproutsSupported & ProvidesConfiguration & ProvidesFacecastInfo & ProvidesLocationInfo & ProvidesPluginAllowsAttachingToAlbumsGetter & ProvidesPluginAllowsCheckinGetter & ProvidesPluginAllowsMinutiaeGetter & ProvidesPluginAllowsPhotoGetter & ProvidesPluginAllowsTaggingPeopleGetter & ProvidesPluginTitleGetter & ProvidesShareParams & ProvidesTaggedUsers & ProvidesTargetData & ProvidesMinutiae & ProvidesPublishMode & ProvidesRedSpaceValue> {
    private static final ImmutableSet<DeactivateReason> f6960a = ImmutableSet.of(DeactivateReason.FRIEND_TAGGING_NOT_ALLOWED);
    private static final ImmutableSet<DeactivateReason> f6961b = ImmutableSet.of(DeactivateReason.LOCATION_TAGGING_NOT_ALLOWED);
    private static final ImmutableSet<DeactivateReason> f6962c = ImmutableSet.of(DeactivateReason.MINUTIAE_NOT_ALLOWED);
    private static final ImmutableSet<DeactivateReason> f6963d = ImmutableSet.of(DeactivateReason.FRIEND_TAGGING_NOT_ALLOWED, DeactivateReason.LOCATION_TAGGING_NOT_ALLOWED);
    private static final ImmutableSet<DeactivateReason> f6964e = ImmutableSet.of(DeactivateReason.FRIEND_TAGGING_NOT_ALLOWED, DeactivateReason.MINUTIAE_NOT_ALLOWED);
    private static final ImmutableSet<DeactivateReason> f6965f = ImmutableSet.of(DeactivateReason.LOCATION_TAGGING_NOT_ALLOWED, DeactivateReason.MINUTIAE_NOT_ALLOWED);
    private static final ImmutableSet<DeactivateReason> f6966g = ImmutableSet.of(DeactivateReason.FRIEND_TAGGING_NOT_ALLOWED, DeactivateReason.LOCATION_TAGGING_NOT_ALLOWED, DeactivateReason.MINUTIAE_NOT_ALLOWED);
    private final WeakReference<TargetSelectorClient> f6967h;
    private final WeakReference<DataProvider> f6968i;
    public final CheckViewerPageAdminUtil f6969j;
    private final ComposerPhotoCapability f6970k;
    public final ComposerMultimediaCapability f6971l;
    private final ComposerMinutiaeCapability f6972m;
    private final ComposerCheckinCapability f6973n;
    private final ComposerTagPeopleCapability f6974o;
    private final ComposerAlbumCapability f6975p;
    private final ComposerTitleGenerator f6976q;
    private final ComposerAnalyticsLogger f6977r;
    private final AbstractFbErrorReporter f6978s;
    private final Resources f6979t;
    public final DefaultComposerTargetTypesBuilder f6980u;
    public final ImmutableMap<TargetType, ComposerTargetSelectionInfo> f6981v;

    /* compiled from: fetchLayoutAndTilesRequest */
    class C08752 implements EntryTransformer<TargetType, Builder, TargetState> {
        final /* synthetic */ ComposerTargetSelectorController f6954a;

        C08752(ComposerTargetSelectorController composerTargetSelectorController) {
            this.f6954a = composerTargetSelectorController;
        }

        public final Object m8269a(@Nullable Object obj, @Nullable Object obj2) {
            return new TargetState((Builder) obj2);
        }
    }

    /* compiled from: fetchLayoutAndTilesRequest */
    /* synthetic */ class C08763 {
        static final /* synthetic */ int[] f6955a = new int[TargetType.values().length];

        static {
            try {
                f6955a[TargetType.USER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f6955a[TargetType.GROUP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f6955a[TargetType.PAGE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* compiled from: fetchLayoutAndTilesRequest */
    public enum DeactivateReason {
        POST_NOT_PUBLIC,
        MULTI_PHOTOS_NOT_ALLOWED,
        FRIEND_TAGGING_NOT_ALLOWED,
        LOCATION_TAGGING_NOT_ALLOWED,
        MINUTIAE_NOT_ALLOWED,
        ATTACH_TO_ALBUM_NOT_ALLOWED,
        MULTIMEDIA_NOT_ALLOWED
    }

    /* compiled from: fetchLayoutAndTilesRequest */
    public class TargetState {
        public final boolean f6958a;
        public final ImmutableSet<DeactivateReason> f6959b;

        /* compiled from: fetchLayoutAndTilesRequest */
        public class Builder {
            public boolean f6956a = false;
            public final Set<DeactivateReason> f6957b = EnumSet.noneOf(DeactivateReason.class);

            public final Builder m8270a(DeactivateReason deactivateReason) {
                this.f6957b.add(deactivateReason);
                return this;
            }
        }

        public TargetState(Builder builder) {
            this.f6958a = builder.f6956a;
            this.f6959b = ImmutableSet.copyOf(builder.f6957b);
        }

        public String toString() {
            return "(isHidden=" + this.f6958a + ", deactivateReasons=" + this.f6959b + ")";
        }
    }

    @Inject
    public ComposerTargetSelectorController(ComposerTargetTypesBuilder composerTargetTypesBuilder, Set<ComposerTargetInfoProvider> set, CheckViewerPageAdminUtil checkViewerPageAdminUtil, ComposerPhotoCapability composerPhotoCapability, ComposerMultimediaCapability composerMultimediaCapability, ComposerMinutiaeCapability composerMinutiaeCapability, ComposerCheckinCapability composerCheckinCapability, ComposerTagPeopleCapability composerTagPeopleCapability, ComposerAlbumCapability composerAlbumCapability, ComposerTitleGenerator composerTitleGenerator, ComposerAnalyticsLogger composerAnalyticsLogger, FbErrorReporter fbErrorReporter, Resources resources, @Assisted TargetSelectorClient targetSelectorClient, @Assisted DataProvider dataProvider) {
        this.f6980u = composerTargetTypesBuilder;
        Builder builder = ImmutableMap.builder();
        for (ComposerTargetInfoProvider a : set) {
            for (ComposerTargetSelectionInfo composerTargetSelectionInfo : a.mo186a()) {
                builder.b(composerTargetSelectionInfo.f6946a, composerTargetSelectionInfo);
            }
        }
        this.f6981v = builder.b();
        this.f6969j = checkViewerPageAdminUtil;
        this.f6970k = composerPhotoCapability;
        this.f6971l = composerMultimediaCapability;
        this.f6972m = composerMinutiaeCapability;
        this.f6973n = composerCheckinCapability;
        this.f6974o = composerTagPeopleCapability;
        this.f6975p = composerAlbumCapability;
        this.f6976q = composerTitleGenerator;
        this.f6977r = composerAnalyticsLogger;
        this.f6978s = fbErrorReporter;
        this.f6979t = resources;
        this.f6967h = new WeakReference(Preconditions.checkNotNull(targetSelectorClient));
        this.f6968i = new WeakReference(Preconditions.checkNotNull(dataProvider));
    }

    public final void m8279a(PopoverMenu popoverMenu) {
        ProvidesAttachments providesAttachments = (ProvidesAttachments) Preconditions.checkNotNull(this.f6968i.get());
        this.f6977r.a(Events.COMPOSER_OPENED_TARGET_SELECTOR, ((ProvidesSessionId) providesAttachments).ab());
        ImmutableMap b = m8274b();
        final AnonymousClass63 anonymousClass63 = (AnonymousClass63) Preconditions.checkNotNull(this.f6967h.get(), "targetSelectorClient was garbage collected");
        popoverMenu.clear();
        Iterator it = b.keySet().iterator();
        while (it.hasNext()) {
            final TargetType targetType = (TargetType) it.next();
            TargetState targetState = (TargetState) b.get(targetType);
            if (!targetState.f6958a) {
                CharSequence a;
                ComposerTargetSelectionInfo composerTargetSelectionInfo = (ComposerTargetSelectionInfo) this.f6981v.get(targetType);
                if (targetType == TargetType.UNDIRECTED) {
                    ComposerTitleGenerator composerTitleGenerator = this.f6976q;
                    Getter aw = ((ProvidesPluginTitleGetter) providesAttachments).aw();
                    ComposerConfiguration o = ((ProvidesConfiguration) providesAttachments).o();
                    ComposerTargetData.Builder builder = new ComposerTargetData.Builder();
                    builder.b = TargetType.UNDIRECTED;
                    a = composerTitleGenerator.m7752a(aw, o, builder.a());
                } else {
                    a = this.f6979t.getString(composerTargetSelectionInfo.f6948c);
                }
                MenuItemImpl a2 = popoverMenu.a(0, composerTargetSelectionInfo.f6947b, a);
                a2.setIcon(composerTargetSelectionInfo.f6949d);
                a2.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                    final /* synthetic */ ComposerTargetSelectorController f6953c;

                    public boolean onMenuItemClick(MenuItem menuItem) {
                        AnonymousClass63 anonymousClass63 = anonymousClass63;
                        TargetType targetType = targetType;
                        Class cls = ((ComposerTargetSelectionInfo) this.f6953c.f6981v.get(targetType)).f6950e;
                        if (targetType != TargetType.PAGE) {
                            anonymousClass63.f6103a.aU.m7630b(ComposerFragment.cn).m7678a(PublishMode.NORMAL).m7681a(null).m7689a();
                        }
                        if (targetType == TargetType.UNDIRECTED) {
                            if (anonymousClass63.f6103a.aS.m7443s().targetType != TargetType.UNDIRECTED) {
                                ComposerFragment.m7540a(anonymousClass63.f6103a, new ComposerTargetData.Builder().a(), null);
                            }
                        } else if (cls == null) {
                            ((AbstractFbErrorReporter) anonymousClass63.f6103a.bO.get()).a("no_activity_for_composer_target_selection", "Couldn't find activity for target type: " + targetType);
                        } else {
                            anonymousClass63.f6103a.a(new Intent(anonymousClass63.f6103a.ao(), cls), 3);
                        }
                        return true;
                    }
                });
                if (!targetState.f6959b.isEmpty()) {
                    int a3 = m8271a(targetType, targetState.f6959b);
                    if (a3 != 0) {
                        a2.a(this.f6979t.getString(a3));
                    }
                    a2.setEnabled(false);
                }
            }
        }
    }

    public final boolean m8280a() {
        ProvidesAttachments providesAttachments = (ProvidesAttachments) Preconditions.checkNotNull(this.f6968i.get());
        ComposerDataProviderImpl composerDataProviderImpl = (ComposerDataProviderImpl) providesAttachments;
        composerDataProviderImpl.f6026j.get();
        ComposerConfiguration o = composerDataProviderImpl.m7439o();
        Object obj;
        if (composerDataProviderImpl.ad() != null) {
            obj = 1;
        } else {
            obj = null;
        }
        RedSpaceValue k = composerDataProviderImpl.m7435k();
        BooleanGetter at = composerDataProviderImpl.f6035s.m7482b().at();
        boolean z = false;
        if (!o.getPlatformConfiguration().b() && ((k != RedSpaceValue.POST_TO_REDSPACE || o.getAllowsRedSpaceToggle()) && r4 == null)) {
            if (at != null) {
                z = at.a();
            } else if (o.getInitialTargetData().targetType == TargetType.UNDIRECTED) {
                z = o.getAllowTargetSelection();
            }
        }
        if (!z) {
            return false;
        }
        return (((ProvidesTargetData) providesAttachments).s().targetType == TargetType.UNDIRECTED && ImmutableSet.of(TargetType.UNDIRECTED).equals(m8272a(m8274b()))) ? false : true;
    }

    private ImmutableMap<TargetType, TargetState> m8274b() {
        ProvidesAttachments providesAttachments = (ProvidesAttachments) Preconditions.checkNotNull(this.f6968i.get());
        Map c = Maps.c();
        for (TargetType put : this.f6980u.m8283a()) {
            c.put(put, new Builder());
        }
        if (c.containsKey(TargetType.PAGE) && this.f6969j.a() == TriState.NO) {
            ((Builder) c.get(TargetType.PAGE)).f6956a = true;
        }
        m8273a(providesAttachments, c);
        ImmutableMap copyOf = ImmutableMap.copyOf(Maps.a(c, new C08752(this)));
        Preconditions.checkState(!m8272a(copyOf).isEmpty(), "No active targets! Target states: " + copyOf);
        return copyOf;
    }

    private static ImmutableSet<TargetType> m8272a(ImmutableMap<TargetType, TargetState> immutableMap) {
        ImmutableSet.Builder builder = ImmutableSet.builder();
        Iterator it = immutableMap.keySet().iterator();
        while (it.hasNext()) {
            TargetType targetType = (TargetType) it.next();
            TargetState targetState = (TargetState) immutableMap.get(targetType);
            if (!targetState.f6958a && targetState.f6959b.isEmpty()) {
                builder.c(targetType);
            }
        }
        return builder.b();
    }

    private void m8273a(DataProvider dataProvider, Map<TargetType, Builder> map) {
        Object obj = (((ProvidesShareParams) dataProvider).q() == null || ((ProvidesShareParams) dataProvider).q().shareable == null || GraphQLHelper.a(((ProvidesShareParams) dataProvider).q().shareable) != 514783620) ? null : 1;
        if (!(!map.containsKey(TargetType.PAGE) || ((ProvidesConfiguration) dataProvider).o().getAttachedStory() == null || StoryActorHelper.a(((ProvidesConfiguration) dataProvider).o().getAttachedStory()) || GraphQLStoryHelper.c(((ProvidesConfiguration) dataProvider).o().getAttachedStory()) == null || "everyone".equals(GraphQLStoryHelper.c(((ProvidesConfiguration) dataProvider).o().getAttachedStory()).s()) || ((ProvidesTargetData) dataProvider).s().a() || obj != null)) {
            ((Builder) map.get(TargetType.PAGE)).m8270a(DeactivateReason.POST_NOT_PUBLIC);
        }
        if (dataProvider.m().size() > 1) {
            m8275c(dataProvider, map);
        }
        if (AttachmentUtils.l(dataProvider.m())) {
            for (TargetType targetType : this.f6980u.m8283a()) {
                if (!this.f6971l.a(targetType, ((ProvidesConfiguration) dataProvider).o().isEdit())) {
                    ((Builder) map.get(targetType)).m8270a(DeactivateReason.MULTIMEDIA_NOT_ALLOWED);
                }
            }
        }
        if (((ProvidesMinutiae) dataProvider).l() != null) {
            m8276d(dataProvider, map);
        }
        if (((ProvidesLocationInfo) dataProvider).g().a() != null) {
            for (TargetType targetType2 : this.f6980u.m8283a()) {
                if (!ComposerCheckinCapability.a(((ProvidesConfiguration) dataProvider).o().isEdit(), ((ProvidesConfiguration) dataProvider).o().isEditTagEnabled(), ((ProvidesPluginAllowsCheckinGetter) dataProvider).ai())) {
                    ((Builder) map.get(targetType2)).m8270a(DeactivateReason.LOCATION_TAGGING_NOT_ALLOWED);
                }
            }
        }
        if (!((ProvidesTaggedUsers) dataProvider).h().isEmpty()) {
            m8277f(dataProvider, map);
        }
        if (((ProvidesTargetAlbum) dataProvider).ad() != null) {
            m8278g(dataProvider, map);
        }
    }

    private void m8275c(DataProvider dataProvider, Map<TargetType, Builder> map) {
        for (TargetType targetType : this.f6980u.m8283a()) {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            boolean z5 = targetType == TargetType.PAGE || ((ProvidesTargetData) dataProvider).s().actsAsTarget;
            ComposerPhotoCapability composerPhotoCapability = this.f6970k;
            BooleanGetter am = ((ProvidesPluginAllowsPhotoGetter) dataProvider).am();
            if (((ProvidesConfiguration) dataProvider).o().getInitialStickerData() != null) {
                z = true;
            } else {
                z = false;
            }
            if (((ProvidesShareParams) dataProvider).q() == null || ((ProvidesShareParams) dataProvider).q().linkForShare == null) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (((ProvidesConfiguration) dataProvider).o().shouldDisablePhotos()) {
                z3 = false;
            } else {
                z3 = true;
            }
            boolean isEdit = ((ProvidesConfiguration) dataProvider).o().isEdit();
            boolean canViewerEditPostMedia = ((ProvidesConfiguration) dataProvider).o().canViewerEditPostMedia();
            if (((ComposerDataProviderImpl) dataProvider).m7429e().facecastCameraIndex != -1) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (composerPhotoCapability.a(am, z, targetType, z5, z2, z3, isEdit, canViewerEditPostMedia, z4, dataProvider.m()) == Capability.ALLOW_SINGLE_PHOTO_ONLY) {
                ((Builder) map.get(targetType)).m8270a(DeactivateReason.MULTI_PHOTOS_NOT_ALLOWED);
            }
        }
    }

    private void m8276d(DataProvider dataProvider, Map<TargetType, Builder> map) {
        for (TargetType targetType : this.f6980u.m8283a()) {
            if (!this.f6972m.a(targetType, ((ProvidesConfiguration) dataProvider).o().isEdit(), ((ProvidesConfiguration) dataProvider).o().isEditTagEnabled(), ((ProvidesTargetAlbum) dataProvider).ad() != null, ((ProvidesPluginAllowsMinutiaeGetter) dataProvider).al())) {
                ((Builder) map.get(targetType)).m8270a(DeactivateReason.MINUTIAE_NOT_ALLOWED);
            }
        }
    }

    private void m8277f(DataProvider dataProvider, Map<TargetType, Builder> map) {
        for (TargetType targetType : this.f6980u.m8283a()) {
            boolean z = targetType == TargetType.PAGE || ((ProvidesTargetData) dataProvider).s().actsAsTarget;
            if (!ComposerTagPeopleCapability.a(targetType, ((ProvidesConfiguration) dataProvider).o().isEdit(), ((ProvidesConfiguration) dataProvider).o().isEditTagEnabled(), z, ((ProvidesConfiguration) dataProvider).o().shouldDisableFriendTagging(), ((ProvidesPluginAllowsTaggingPeopleGetter) dataProvider).ao())) {
                ((Builder) map.get(targetType)).m8270a(DeactivateReason.FRIEND_TAGGING_NOT_ALLOWED);
            }
        }
    }

    private void m8278g(DataProvider dataProvider, Map<TargetType, Builder> map) {
        for (TargetType targetType : this.f6980u.m8283a()) {
            boolean z;
            ComposerAlbumCapability composerAlbumCapability = this.f6975p;
            BooleanGetter ah = ((ProvidesPluginAllowsAttachingToAlbumsGetter) dataProvider).ah();
            String valueOf = String.valueOf(((ProvidesTargetData) dataProvider).s().targetId);
            PublishMode j = ((ProvidesPublishMode) dataProvider).j();
            boolean isEdit = ((ProvidesConfiguration) dataProvider).o().isEdit();
            boolean shouldDisableAttachToAlbum = ((ProvidesConfiguration) dataProvider).o().shouldDisableAttachToAlbum();
            ImmutableList m = dataProvider.m();
            if (((ProvidesMinutiae) dataProvider).l() != null) {
                z = true;
            } else {
                z = false;
            }
            if (!composerAlbumCapability.a(ah, targetType, valueOf, j, isEdit, shouldDisableAttachToAlbum, m, z, ((ProvidesTargetData) dataProvider).s().actsAsTarget, ((ProvidesRedSpaceValue) dataProvider).k(), ((ComposerDataProviderImpl) dataProvider).m7416S(), ((ComposerDataProviderImpl) dataProvider).m7408I())) {
                ((Builder) map.get(targetType)).m8270a(DeactivateReason.ATTACH_TO_ALBUM_NOT_ALLOWED);
            }
        }
    }

    private int m8271a(TargetType targetType, Set<DeactivateReason> set) {
        switch (C08763.f6955a[targetType.ordinal()]) {
            case 1:
                if (set.contains(DeactivateReason.MULTI_PHOTOS_NOT_ALLOWED)) {
                    return 2131242398;
                }
                if (set.contains(DeactivateReason.MULTIMEDIA_NOT_ALLOWED)) {
                    return 2131242413;
                }
                break;
            case 2:
                if (set.contains(DeactivateReason.MULTIMEDIA_NOT_ALLOWED)) {
                    return 2131242414;
                }
                if (f6962c.equals(set)) {
                    return 2131242399;
                }
                if (f6961b.equals(set)) {
                    return 2131242401;
                }
                if (f6960a.equals(set)) {
                    return 2131242403;
                }
                if (f6964e.equals(set)) {
                    return 2131242405;
                }
                if (f6965f.equals(set)) {
                    return 2131242407;
                }
                if (f6963d.equals(set)) {
                    return 2131242409;
                }
                if (f6966g.equals(set)) {
                    return 2131242411;
                }
                break;
            case 3:
                if (set.contains(DeactivateReason.MULTIMEDIA_NOT_ALLOWED)) {
                    return 2131242415;
                }
                if (set.contains(DeactivateReason.POST_NOT_PUBLIC)) {
                    return 2131242397;
                }
                if (f6962c.equals(set)) {
                    return 2131242400;
                }
                if (f6961b.equals(set)) {
                    return 2131242402;
                }
                if (f6960a.equals(set)) {
                    return 2131242404;
                }
                if (f6964e.equals(set)) {
                    return 2131242406;
                }
                if (f6965f.equals(set)) {
                    return 2131242408;
                }
                if (f6963d.equals(set)) {
                    return 2131242410;
                }
                if (f6966g.equals(set)) {
                    return 2131242412;
                }
                break;
        }
        this.f6978s.b("composer_no_explanation_for_deactivated_target", "target: " + targetType + ", deactivation: " + set);
        return 0;
    }
}
