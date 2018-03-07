package com.facebook.composer.controller;

import com.facebook.common.util.StringUtil;
import com.facebook.composer.activity.ComposerDataProviderImpl;
import com.facebook.composer.activity.ComposerFragment;
import com.facebook.composer.activity.ComposerFragment.AnonymousClass31;
import com.facebook.composer.attachments.ComposerAttachment;
import com.facebook.composer.attachments.ComposerAttachment.ProvidesAttachments;
import com.facebook.composer.minutiae.model.MinutiaeObject.ProvidesMinutiae;
import com.facebook.composer.privacy.common.ComposerPrivacyData.ProvidesPrivacyData;
import com.facebook.composer.tasks.ComposerTaskId.DependantAction;
import com.facebook.composer.util.ComposerTagComparator;
import com.facebook.composer.util.ComposerTagComparatorProvider;
import com.facebook.graphql.model.GraphQLExploreFeed;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesHasPrivacyChanged;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesTextWithEntities;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesTopics;
import com.facebook.ipc.composer.intent.ComposerConfigurationSpec.ProvidesConfiguration;
import com.facebook.ipc.composer.intent.ComposerShareParams.ProvidesShareParams;
import com.facebook.ipc.composer.intent.ComposerStickerData.ProvidesStickerData;
import com.facebook.ipc.composer.model.ComposerFacecastInfo.ProvidesFacecastInfo;
import com.facebook.ipc.composer.model.ComposerLocationInfo.ProvidesLocationInfo;
import com.facebook.ipc.composer.model.ComposerTaggedUser.ProvidesTaggedUsers;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.ProvidesPluginAllowsSubmitGetter;
import com.facebook.ipc.composer.plugin.ComposerPluginGetters.ProvidesPluginHasUserEditedContentGetter;
import com.facebook.tagging.graphql.utils.MentionsUtils;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.lang.ref.WeakReference;
import java.util.Comparator;
import java.util.TreeSet;
import javax.inject.Inject;

/* compiled from: heap */
public class ComposerSubmitEnabledController<DataProvider extends ProvidesAttachments & ProvidesHasPrivacyChanged & ProvidesTextWithEntities & ProvidesTopics & ProvidesConfiguration & ProvidesFacecastInfo & ProvidesLocationInfo & ProvidesPluginAllowsSubmitGetter & ProvidesPluginHasUserEditedContentGetter & ProvidesPrivacyData & ProvidesShareParams & ProvidesStickerData & ProvidesTaggedUsers & ProvidesMinutiae> {
    public final WeakReference<DataProvider> f6318a;
    private final WeakReference<NonModelDataProvider> f6319b;
    private final ComposerTagComparator f6320c;
    private final TreeSet<GraphQLExploreFeed> f6321d = new TreeSet(new C07911(this));

    /* compiled from: heap */
    class C07911 implements Comparator<GraphQLExploreFeed> {
        final /* synthetic */ ComposerSubmitEnabledController f6317a;

        C07911(ComposerSubmitEnabledController composerSubmitEnabledController) {
            this.f6317a = composerSubmitEnabledController;
        }

        public int compare(Object obj, Object obj2) {
            return ((GraphQLExploreFeed) obj).n().compareTo(((GraphQLExploreFeed) obj2).n());
        }
    }

    @Inject
    public ComposerSubmitEnabledController(@Assisted DataProvider dataProvider, @Assisted NonModelDataProvider nonModelDataProvider, ComposerTagComparatorProvider composerTagComparatorProvider) {
        this.f6318a = new WeakReference(Preconditions.checkNotNull(dataProvider));
        this.f6319b = new WeakReference(Preconditions.checkNotNull(nonModelDataProvider));
        this.f6320c = ComposerTagComparatorProvider.a(dataProvider);
    }

    public final boolean m7746a() {
        AnonymousClass31 anonymousClass31 = (AnonymousClass31) Preconditions.checkNotNull(this.f6319b.get());
        return m7747b() && anonymousClass31.f6062a.m7601e() && !ComposerFragment.m7554a(anonymousClass31.f6062a, DependantAction.SUBMISSION) && !((ProvidesPrivacyData) ((ProvidesAttachments) Preconditions.checkNotNull(this.f6318a.get(), "dataProvider was garbage collected"))).ag().e;
    }

    public final boolean m7747b() {
        ProvidesAttachments providesAttachments = (ProvidesAttachments) Preconditions.checkNotNull(this.f6318a.get(), "dataProvider was garbage collected");
        if (((ProvidesPluginAllowsSubmitGetter) providesAttachments).an() != null) {
            return ((ProvidesPluginAllowsSubmitGetter) providesAttachments).an().a();
        }
        return m7740a(providesAttachments);
    }

    private boolean m7740a(DataProvider dataProvider) {
        if (m7741b(dataProvider)) {
            return false;
        }
        if (((ProvidesConfiguration) dataProvider).o().isEdit()) {
            return m7748c();
        }
        if (((ComposerDataProviderImpl) dataProvider).m7429e().isFacecastReady || ((ComposerDataProviderImpl) dataProvider).m7429e().facecastCameraIndex == -1) {
            return m7748c() || !dataProvider.m().isEmpty() || ((ProvidesShareParams) dataProvider).q() != null || ((ComposerDataProviderImpl) dataProvider).m7429e().isFacecastReady;
        } else {
            return false;
        }
    }

    private static boolean m7741b(DataProvider dataProvider) {
        return StringUtil.c(((ProvidesTextWithEntities) dataProvider).ae().a()) && dataProvider.m().isEmpty() && ((ProvidesLocationInfo) dataProvider).g().a() == null && ((ProvidesLocationInfo) dataProvider).g().c() == null && ((ProvidesTaggedUsers) dataProvider).h().isEmpty() && ((ProvidesMinutiae) dataProvider).l() == null && ((ComposerDataProviderImpl) dataProvider).m7429e().facecastCameraIndex == -1 && ((ProvidesShareParams) dataProvider).q() == null;
    }

    public final boolean m7748c() {
        ProvidesAttachments providesAttachments = (ProvidesAttachments) Preconditions.checkNotNull(this.f6318a.get(), "dataProvider was garbage collected");
        if (m7742c(providesAttachments)) {
            return true;
        }
        if (((ProvidesPluginHasUserEditedContentGetter) providesAttachments).aq() != null) {
            return ((ProvidesPluginHasUserEditedContentGetter) providesAttachments).aq().a();
        }
        return false;
    }

    private boolean m7742c(DataProvider dataProvider) {
        Object obj;
        ProvidesAttachments providesAttachments = (ProvidesAttachments) Preconditions.checkNotNull(this.f6318a.get(), "dataProvider was garbage collected");
        if (StringUtil.c(((ProvidesConfiguration) providesAttachments).o().getInitialText().a())) {
            obj = !StringUtil.c(((ProvidesTextWithEntities) providesAttachments).ae().a()) ? 1 : null;
        } else if (MentionsUtils.a(((ProvidesConfiguration) providesAttachments).o().getInitialText()).trim().equals(MentionsUtils.a(((ProvidesTextWithEntities) providesAttachments).ae()).trim())) {
            obj = null;
        } else {
            int i = 1;
        }
        if (obj != null || ((ComposerDataProviderImpl) dataProvider).m7444u()) {
            return true;
        }
        if (((ProvidesConfiguration) dataProvider).o().isEdit()) {
            ComposerTagComparator composerTagComparator = this.f6320c;
            if (composerTagComparator.a() || composerTagComparator.b() || composerTagComparator.c()) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null || m7744e(dataProvider) || m7745f(dataProvider) || m7743d(dataProvider)) {
                return true;
            }
            return false;
        }
        boolean z = (dataProvider.m().isEmpty() || !((ProvidesConfiguration) dataProvider).o().getInitialAttachments().isEmpty() || ((ProvidesConfiguration) dataProvider).o().getPlatformConfiguration().b()) ? false : true;
        if (StringUtil.c(((ProvidesTextWithEntities) dataProvider).ae().a()) && dataProvider.m().isEmpty() && ((ProvidesLocationInfo) dataProvider).g().a() == null && ((ProvidesLocationInfo) dataProvider).g().c() == null && ((ProvidesTaggedUsers) dataProvider).h().isEmpty() && ((ProvidesMinutiae) dataProvider).l() == null && ((ProvidesShareParams) dataProvider).q() == null && ((ProvidesStickerData) dataProvider).r() == null && ((ComposerDataProviderImpl) dataProvider).m7429e().facecastCameraIndex == -1 && !z) {
            return false;
        }
        return true;
    }

    private static boolean m7743d(DataProvider dataProvider) {
        return ((ProvidesConfiguration) dataProvider).o().getInitialShareParams() != ((ProvidesShareParams) dataProvider).q();
    }

    private static boolean m7744e(DataProvider dataProvider) {
        ImmutableList initialAttachments = ((ProvidesConfiguration) dataProvider).o().getInitialAttachments();
        ImmutableList m = dataProvider.m();
        if (initialAttachments.size() != m.size()) {
            return true;
        }
        for (int i = 0; i < initialAttachments.size(); i++) {
            if (!((ComposerAttachment) initialAttachments.get(i)).a((ComposerAttachment) m.get(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean m7745f(DataProvider dataProvider) {
        ImmutableList topics = ((ProvidesConfiguration) dataProvider).o().getTopics();
        ImmutableList af = ((ProvidesTopics) dataProvider).af();
        if (topics.size() != af.size()) {
            return true;
        }
        int i;
        this.f6321d.clear();
        int size = topics.size();
        for (i = 0; i < size; i++) {
            this.f6321d.add((GraphQLExploreFeed) topics.get(i));
        }
        int size2 = af.size();
        for (i = 0; i < size2; i++) {
            if (!this.f6321d.contains((GraphQLExploreFeed) af.get(i))) {
                return true;
            }
        }
        return false;
    }
}
