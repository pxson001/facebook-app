package com.facebook.composer.feedattachment.minutiae;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.composer.activity.ComposerFragment;
import com.facebook.composer.activity.ComposerFragment.AnonymousClass32;
import com.facebook.composer.attachments.ComposerAttachment.ProvidesAttachments;
import com.facebook.composer.feedattachment.ComposerFeedAttachmentController;
import com.facebook.composer.minutiae.model.MinutiaeObject;
import com.facebook.composer.minutiae.model.MinutiaeObject.Builder;
import com.facebook.composer.minutiae.model.MinutiaeObject.ProvidesMinutiae;
import com.facebook.feedplugins.minutiae.MinutiaeAttachmentsAnalyticsLogger;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesSessionId;
import com.facebook.ipc.composer.intent.ComposerConfigurationSpec.ProvidesConfiguration;
import com.facebook.ipc.composer.model.ComposerContentType.ProvidesContentType;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.ref.WeakReference;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: get_token */
public class MinutiaeAttachmentController<DataProvider extends ProvidesAttachments & ProvidesSessionId & ProvidesConfiguration & ProvidesContentType & ProvidesMinutiae> implements ComposerFeedAttachmentController {
    private final WeakReference<DataProvider> f6523a;
    private final WeakReference<Callback> f6524b;
    private final MinutiaeAttachmentsAnalyticsLogger f6525c;
    private final MinutiaeAttachmentControllerMap f6526d;
    private final GatekeeperStoreImpl f6527e;

    /* compiled from: get_token */
    public interface SubController {
        View mo203a(GraphQLStoryAttachment graphQLStoryAttachment, ViewGroup viewGroup);

        ListenableFuture<GraphQLStoryAttachment> mo204a(MinutiaeObject minutiaeObject);
    }

    public final Optional<GraphQLStoryAttachment> mo193a(Throwable th) {
        return Absent.INSTANCE;
    }

    @Inject
    public MinutiaeAttachmentController(@Assisted DataProvider dataProvider, @Assisted Callback callback, MinutiaeAttachmentControllerMap minutiaeAttachmentControllerMap, MinutiaeAttachmentsAnalyticsLogger minutiaeAttachmentsAnalyticsLogger, GatekeeperStore gatekeeperStore) {
        this.f6526d = minutiaeAttachmentControllerMap;
        this.f6525c = minutiaeAttachmentsAnalyticsLogger;
        this.f6523a = new WeakReference(dataProvider);
        this.f6524b = new WeakReference(callback);
        this.f6527e = gatekeeperStore;
    }

    public final boolean mo196e() {
        return ((ProvidesAttachments) Preconditions.checkNotNull(this.f6523a.get())).m().isEmpty() && this.f6526d.m7987a(m7973b());
    }

    public final ListenableFuture<GraphQLStoryAttachment> mo195d() {
        ProvidesAttachments providesAttachments = (ProvidesAttachments) Preconditions.checkNotNull(this.f6523a.get());
        if (providesAttachments == null) {
            return Futures.a(new NullPointerException("Data Provider not found"));
        }
        SubController a = m7972a();
        if (a == null) {
            return Futures.a(new UnsupportedOperationException("Cannot find a controller that supports the current composition"));
        }
        return a.mo204a(((ProvidesMinutiae) providesAttachments).l());
    }

    public final List<GraphQLStoryAttachmentStyle> mo194c() {
        return this.f6526d.f6529b;
    }

    public final View mo192a(GraphQLStoryAttachment graphQLStoryAttachment, ViewGroup viewGroup) {
        SubController b = this.f6526d.m7988b(graphQLStoryAttachment.w());
        Preconditions.checkNotNull(b);
        return b.mo203a(graphQLStoryAttachment, viewGroup);
    }

    public final String mo198g() {
        return ((ProvidesMinutiae) ((ProvidesAttachments) Preconditions.checkNotNull(this.f6523a.get()))).l().object.k().d();
    }

    public final boolean mo197f() {
        if (this.f6527e.a(60, false)) {
            return true;
        }
        ProvidesAttachments providesAttachments = (ProvidesAttachments) Preconditions.checkNotNull(this.f6523a.get());
        return ((ProvidesConfiguration) providesAttachments).o().isEdit() && !((ProvidesConfiguration) providesAttachments).o().isEditTagEnabled();
    }

    public final void mo199h() {
        ProvidesAttachments providesAttachments = (ProvidesAttachments) Preconditions.checkNotNull(this.f6523a.get());
        this.f6525c.f7999a.a(MinutiaeAttachmentsAnalyticsLogger.m9070a("minutiae_preview_removed", ((ProvidesMinutiae) providesAttachments).l(), ((ProvidesSessionId) providesAttachments).ab()));
        if (((ProvidesMinutiae) providesAttachments).l() != null) {
            Builder a = Builder.a(((ProvidesMinutiae) providesAttachments).l());
            a.e = true;
            ComposerFragment.m7538a(((AnonymousClass32) Preconditions.checkNotNull(this.f6524b.get())).f6063a, a.a());
        }
    }

    public final void mo200i() {
        ProvidesAttachments providesAttachments = (ProvidesAttachments) Preconditions.checkNotNull(this.f6523a.get());
        this.f6525c.f7999a.a(MinutiaeAttachmentsAnalyticsLogger.m9070a("minutiae_preview_fetch_failed", ((ProvidesMinutiae) providesAttachments).l(), ((ProvidesSessionId) providesAttachments).ab()));
    }

    public final View mo201j() {
        return null;
    }

    public final boolean mo202k() {
        return false;
    }

    public final View mo191a(Context context, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(2130905288, viewGroup, false);
    }

    @Nullable
    private SubController m7972a() {
        return this.f6526d.m7988b(m7973b());
    }

    private ImmutableList<GraphQLStoryAttachmentStyle> m7973b() {
        ProvidesAttachments providesAttachments = (ProvidesAttachments) this.f6523a.get();
        if (providesAttachments == null) {
            return RegularImmutableList.a;
        }
        MinutiaeObject l = ((ProvidesMinutiae) providesAttachments).l();
        if (l == null || !l.h() || l.object == null || !l.object.l() || l.object.k() == null || l.object.k().l() == null) {
            return RegularImmutableList.a;
        }
        return l.object.k().l().a();
    }
}
