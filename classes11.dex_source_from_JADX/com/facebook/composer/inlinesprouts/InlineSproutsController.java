package com.facebook.composer.inlinesprouts;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.ui.keyboard.SoftInputDetector;
import com.facebook.common.util.JSONUtil;
import com.facebook.composer.abtest.ExperimentsForComposerAbTestModule;
import com.facebook.composer.actionitem.ActionItemController$Delegate;
import com.facebook.composer.activity.ComposerDataProviderImpl;
import com.facebook.composer.activity.TransactionImpl;
import com.facebook.composer.attachments.ComposerAttachment;
import com.facebook.composer.attachments.ComposerAttachment.ProvidesAttachments;
import com.facebook.composer.capability.ComposerPhotoCapability.ProvidesCapability;
import com.facebook.composer.event.ComposerEvent;
import com.facebook.composer.event.ComposerEventHandler;
import com.facebook.composer.event.ComposerEventOriginator;
import com.facebook.composer.inlinesprouts.InlineSproutsView.ExpandAnimation;
import com.facebook.composer.inlinesprouts.InlineSproutsView.OnKeyboardStateChangeListener;
import com.facebook.composer.inlinesprouts.InlineSproutsView.OnMeasuredListener;
import com.facebook.composer.inlinesprouts.InlineSproutsView.StateChangeListener;
import com.facebook.composer.inlinesprouts.model.InlineSproutsState;
import com.facebook.composer.inlinesprouts.model.InlineSproutsState.Builder;
import com.facebook.composer.inlinesprouts.model.InlineSproutsStateSpec$SproutsMetadataFlow;
import com.facebook.composer.inlinesprouts.model.InlineSproutsStateSpec.ProvidesInlineSproutsState;
import com.facebook.composer.inlinesprouts.model.InlineSproutsStateSpec.SetsInlineSproutsState;
import com.facebook.composer.inlinesproutsinterfaces.InlineSproutItem;
import com.facebook.composer.location.LocationLightweightPickerSproutItem;
import com.facebook.composer.location.LocationLightweightPickerSproutItem.Listener;
import com.facebook.composer.location.LocationLightweightPickerSproutItemProvider;
import com.facebook.composer.minutiae.model.MinutiaeObject.ProvidesMinutiae;
import com.facebook.feed.util.composer.abtest.ExperimentsForFeedUtilComposerAbtestModule;
import com.facebook.feed.util.composer.sprout.SproutAdapter;
import com.facebook.feed.util.composer.sprout.SproutAdapterProvider;
import com.facebook.feed.util.composer.sprout.SproutSpec;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsCheckinSupported;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsFacecastSupported;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsInlineSproutsOpen;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsMinutiaeSupported;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsTagPeopleSupported;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesSessionId;
import com.facebook.ipc.composer.dataaccessor.ComposerMutator;
import com.facebook.ipc.composer.dataaccessor.ComposerTransaction;
import com.facebook.ipc.composer.model.ComposerFacecastInfo.ProvidesFacecastInfo;
import com.facebook.ipc.composer.model.ComposerLocationInfo.ProvidesLocationInfo;
import com.facebook.ipc.composer.model.ComposerTaggedUser.ProvidesTaggedUsers;
import com.facebook.qe.api.QeAccessor;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: fundraiser_page_tapped_invite */
public class InlineSproutsController<DataProvider extends ProvidesAttachments & ProvidesIsCheckinSupported & ProvidesIsFacecastSupported & ProvidesIsInlineSproutsOpen & ProvidesIsMinutiaeSupported & ProvidesIsTagPeopleSupported & ProvidesSessionId & ProvidesLocationInfo & ProvidesCapability & ProvidesFacecastInfo & ProvidesTaggedUsers & ProvidesInlineSproutsState & ProvidesMinutiae, Transaction extends ComposerTransaction & SetsInlineSproutsState<Transaction>> implements OnItemClickListener, ComposerEventHandler {
    public static final ComposerEventOriginator f6562a = ComposerEventOriginator.a(InlineSproutsController.class);
    public boolean f6563A = false;
    private String f6564B = "";
    public ExpandAnimation f6565C = ExpandAnimation.NO_ANIMATION;
    public InlineSproutsState f6566D;
    public QeAccessor f6567E;
    private final OnKeyboardStateChangeListener f6568F = new C08321(this);
    private final StateChangeListener f6569G = new C08332(this);
    private final Context f6570b;
    public final DataProvider f6571c;
    public final ComposerMutator<Transaction> f6572d;
    private final OnClickListener f6573e;
    public final InlineSproutsView f6574f;
    public final SproutAdapter f6575g;
    private final SproutAdapterProvider f6576h;
    private final InlineSproutsQeWrapper f6577i;
    private final InlineSproutsAnalyticsLogger f6578j;
    private final CollapsedViewBinder<View> f6579k;
    public final SoftInputDetector f6580l;
    public ImmutableList<InlineSproutItem> f6581m;
    public final GalleryInlineSproutItem f6582n;
    public TagPeopleInlineSproutItem f6583o;
    public MinutiaeInlineSproutItem f6584p;
    public LocationInlineSproutItem f6585q;
    private LocationLightweightPickerSproutItem f6586r;
    private final FacecastInlineSproutItem f6587s;
    public final WriteInlineSproutItem f6588t;
    private final TagPeopleInlineSproutItemProvider f6589u;
    private final MinutiaeInlineSproutItemProvider f6590v;
    private final LocationInlineSproutItemProvider f6591w;
    private final ActionItemController$Delegate f6592x;
    private final ActionItemController$Delegate f6593y;
    private final ActionItemController$Delegate f6594z;

    /* compiled from: fundraiser_page_tapped_invite */
    class C08321 implements OnKeyboardStateChangeListener {
        final /* synthetic */ InlineSproutsController f6559a;

        C08321(InlineSproutsController inlineSproutsController) {
            this.f6559a = inlineSproutsController;
        }

        public final void mo211a() {
            this.f6559a.m8041a();
        }

        public final void mo212b() {
            if (this.f6559a.f6563A) {
                InlineSproutsController.m8028a(this.f6559a, this.f6559a.f6565C);
            }
        }
    }

    /* compiled from: fundraiser_page_tapped_invite */
    class C08332 implements StateChangeListener {
        final /* synthetic */ InlineSproutsController f6560a;

        C08332(InlineSproutsController inlineSproutsController) {
            this.f6560a = inlineSproutsController;
        }

        public final void mo213a() {
            this.f6560a.f6566D = InlineSproutsState.m8093a(this.f6560a.f6566D).setIsInlineSproutsOpen(true).m8091a();
            ((TransactionImpl) this.f6560a.f6572d.m7626a(InlineSproutsController.f6562a).m7682a(this.f6560a.f6566D)).m7689a();
        }
    }

    /* compiled from: fundraiser_page_tapped_invite */
    class C08343 implements OnPreDrawListener {
        final /* synthetic */ InlineSproutsController f6561a;

        C08343(InlineSproutsController inlineSproutsController) {
            this.f6561a = inlineSproutsController;
        }

        public boolean onPreDraw() {
            this.f6561a.f6574f.bringToFront();
            this.f6561a.f6574f.getViewTreeObserver().removeOnPreDrawListener(this);
            return false;
        }
    }

    @Inject
    public InlineSproutsController(@Assisted OnClickListener onClickListener, @Assisted InlineSproutsView inlineSproutsView, @Assisted OnMeasuredListener onMeasuredListener, @Assisted DataProvider dataProvider, @Assisted ComposerMutator<Transaction> composerMutator, @Assisted ActionItemController$Delegate actionItemController$Delegate, @Assisted ActionItemController$Delegate actionItemController$Delegate2, @Assisted ActionItemController$Delegate actionItemController$Delegate3, @Assisted ActionItemController$Delegate actionItemController$Delegate4, @Assisted Listener listener, @Assisted ActionItemController$Delegate actionItemController$Delegate5, @Assisted ActionItemController$Delegate actionItemController$Delegate6, Context context, SproutAdapterProvider sproutAdapterProvider, GalleryInlineSproutItemProvider galleryInlineSproutItemProvider, MinutiaeInlineSproutItemProvider minutiaeInlineSproutItemProvider, LocationInlineSproutItemProvider locationInlineSproutItemProvider, LocationLightweightPickerSproutItemProvider locationLightweightPickerSproutItemProvider, TagPeopleInlineSproutItemProvider tagPeopleInlineSproutItemProvider, FacecastInlineSproutItemProvider facecastInlineSproutItemProvider, WriteInlineSproutItemProvider writeInlineSproutItemProvider, FacecastSproutNuxControllerProvider facecastSproutNuxControllerProvider, InlineSproutsQeWrapper inlineSproutsQeWrapper, InlineSproutsAnalyticsLogger inlineSproutsAnalyticsLogger, CollapsedViewWithExpandedIconsBinder collapsedViewWithExpandedIconsBinder, SoftInputDetector softInputDetector, QeAccessor qeAccessor) {
        this.f6570b = context;
        this.f6573e = onClickListener;
        this.f6574f = inlineSproutsView;
        this.f6571c = dataProvider;
        this.f6572d = composerMutator;
        this.f6576h = sproutAdapterProvider;
        this.f6577i = inlineSproutsQeWrapper;
        this.f6578j = inlineSproutsAnalyticsLogger;
        this.f6579k = collapsedViewWithExpandedIconsBinder;
        this.f6580l = softInputDetector;
        this.f6567E = qeAccessor;
        this.f6566D = ((ComposerDataProviderImpl) this.f6571c).aA() != null ? ((ComposerDataProviderImpl) this.f6571c).aA() : InlineSproutsState.newBuilder().m8091a();
        this.f6575g = this.f6576h.a(this.f6570b);
        this.f6589u = tagPeopleInlineSproutItemProvider;
        this.f6590v = minutiaeInlineSproutItemProvider;
        this.f6591w = locationInlineSproutItemProvider;
        this.f6592x = actionItemController$Delegate2;
        this.f6593y = actionItemController$Delegate3;
        this.f6594z = actionItemController$Delegate4;
        this.f6582n = galleryInlineSproutItemProvider.m8018a(dataProvider, actionItemController$Delegate);
        this.f6583o = tagPeopleInlineSproutItemProvider.m8083a(dataProvider, actionItemController$Delegate2, null);
        this.f6584p = minutiaeInlineSproutItemProvider.m8076a(dataProvider, actionItemController$Delegate3, null);
        this.f6585q = locationInlineSproutItemProvider.m8069a(dataProvider, actionItemController$Delegate4, null);
        this.f6586r = locationLightweightPickerSproutItemProvider.m8114a(dataProvider, listener);
        this.f6587s = facecastInlineSproutItemProvider.m8007a(dataProvider, actionItemController$Delegate5, facecastSproutNuxControllerProvider.m8011a((ComposerDataProviderImpl) this.f6571c, this.f6572d));
        this.f6588t = writeInlineSproutItemProvider.m8090a(actionItemController$Delegate6);
        this.f6581m = m8040n();
        this.f6574f.m8061a(this.f6579k.m7993a());
        this.f6574f.setSproutAdapter(this.f6575g);
        this.f6574f.setSproutItemClickListener(this);
        this.f6574f.setOnMeasuredListener(onMeasuredListener);
        this.f6574f.setCollapsedClickListener(this.f6573e);
        this.f6574f.setStateChangeListener(this.f6569G);
        this.f6574f.setOnKeyboardStateChangeListener(this.f6568F);
        this.f6574f.getViewTreeObserver().addOnPreDrawListener(new C08343(this));
        m8031c();
    }

    public final void m8041a() {
        this.f6563A = false;
        this.f6574f.m8060a();
        InlineSproutsAnalyticsLogger inlineSproutsAnalyticsLogger = this.f6578j;
        inlineSproutsAnalyticsLogger.f6558a.a(InlineSproutsAnalyticsLogger.m8021c("composer_collapse_inline_sprout_event", ((ProvidesSessionId) this.f6571c).ab()));
        this.f6566D = InlineSproutsState.m8093a(this.f6566D).setIsInlineSproutsOpen(false).m8091a();
        ((TransactionImpl) this.f6572d.m7626a(f6562a).m7682a(this.f6566D)).m7689a();
    }

    public final void m8042a(ComposerEvent composerEvent, @Nullable ComposerEventOriginator composerEventOriginator) {
        if (composerEvent == ComposerEvent.ON_DATASET_CHANGE) {
            if (((ComposerDataProviderImpl) this.f6571c).aA() != null) {
                this.f6566D = ((ComposerDataProviderImpl) this.f6571c).aA();
            }
            m8032d();
            m8031c();
        } else if (composerEvent == ComposerEvent.ON_SCROLL_CHANGED && ((ComposerDataProviderImpl) this.f6571c).m7407H()) {
            m8041a();
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        SproutSpec sproutSpec = (SproutSpec) this.f6575g.d.get(i);
        InlineSproutsAnalyticsLogger inlineSproutsAnalyticsLogger = this.f6578j;
        String ab = ((ProvidesSessionId) this.f6571c).ab();
        String str = sproutSpec.e;
        HoneyClientEvent c = InlineSproutsAnalyticsLogger.m8021c("composer_opened_inline_sprout_event", ab);
        c.b("composer_opened_inline_sprout_data", str);
        inlineSproutsAnalyticsLogger.f6558a.a(c);
        sproutSpec.f.run();
    }

    private void m8032d() {
        boolean z;
        InlineSproutsState inlineSproutsState = this.f6566D;
        Builder isTagPeopleAttached = InlineSproutsState.m8093a(this.f6566D).setIsMediaAttached(this.f6582n.mo207c()).setIsLocationAttached(this.f6585q.mo207c()).setIsMinutiaeAttached(this.f6584p.mo207c()).setIsTagPeopleAttached(this.f6583o.mo207c());
        if (this.f6571c == null || this.f6571c.m() == null || !this.f6567E.a(ExperimentsForComposerAbTestModule.z, false)) {
            z = false;
        } else {
            ImmutableList m = this.f6571c.m();
            int size = m.size();
            for (int i = 0; i < size; i++) {
                ComposerAttachment composerAttachment = (ComposerAttachment) m.get(i);
                if (composerAttachment.g() != null && composerAttachment.g().hasFaceboxes()) {
                    z = true;
                    break;
                }
            }
            z = false;
        }
        this.f6566D = isTagPeopleAttached.setIsVideoTaggingPromptShowing(z).m8091a();
        if (this.f6566D.isMediaAttached() != inlineSproutsState.isMediaAttached() || this.f6566D.isLocationAttached() != inlineSproutsState.isLocationAttached() || this.f6566D.isMinutiaeAttached() != inlineSproutsState.isMinutiaeAttached() || this.f6566D.isTagPeopleAttached() != inlineSproutsState.isTagPeopleAttached() || this.f6566D.isVideoTaggingPromptShowing() != inlineSproutsState.isVideoTaggingPromptShowing()) {
            if (this.f6566D.getSproutsMetadataFlowState() == InlineSproutsStateSpec$SproutsMetadataFlow.METADATA_FLOW_CANCELED) {
                m8039l();
            } else if (this.f6566D.getSproutsMetadataFlowState() != InlineSproutsStateSpec$SproutsMetadataFlow.NO_MEDIA_ATTACHED || this.f6566D.isMediaAttached()) {
                if (this.f6566D.isMediaAttached() != inlineSproutsState.isMediaAttached()) {
                    m8033e();
                } else if (this.f6566D.isLocationAttached() != inlineSproutsState.isLocationAttached()) {
                    m8034f();
                } else if (this.f6566D.isMinutiaeAttached() != inlineSproutsState.isMinutiaeAttached()) {
                    m8035g();
                } else if (this.f6566D.isTagPeopleAttached() != inlineSproutsState.isTagPeopleAttached()) {
                    m8036h();
                }
                m8039l();
                m8038j();
                this.f6581m = m8040n();
            } else {
                m8039l();
            }
        }
    }

    private void m8033e() {
        if (this.f6566D.isMediaAttached() && this.f6566D.getSproutsMetadataFlowState() == InlineSproutsStateSpec$SproutsMetadataFlow.NO_MEDIA_ATTACHED) {
            m8037i();
        } else {
            m8029a(InlineSproutsStateSpec$SproutsMetadataFlow.METADATA_FLOW_CANCELED);
        }
    }

    private void m8034f() {
        if (this.f6566D.isLocationAttached() && this.f6566D.getSproutsMetadataFlowState() == InlineSproutsStateSpec$SproutsMetadataFlow.LOCATION_METADATA) {
            m8037i();
        } else {
            m8029a(InlineSproutsStateSpec$SproutsMetadataFlow.METADATA_FLOW_CANCELED);
        }
    }

    private void m8035g() {
        if (this.f6566D.isMinutiaeAttached() && this.f6566D.getSproutsMetadataFlowState() == InlineSproutsStateSpec$SproutsMetadataFlow.MINUTIAE_METADATA) {
            m8037i();
        } else {
            m8029a(InlineSproutsStateSpec$SproutsMetadataFlow.METADATA_FLOW_CANCELED);
        }
    }

    private void m8036h() {
        if (this.f6566D.isTagPeopleAttached() && this.f6566D.getSproutsMetadataFlowState() == InlineSproutsStateSpec$SproutsMetadataFlow.PEOPLE_METADATA) {
            m8037i();
        } else {
            m8029a(InlineSproutsStateSpec$SproutsMetadataFlow.METADATA_FLOW_CANCELED);
        }
    }

    private void m8037i() {
        if (!this.f6585q.mo207c()) {
            m8029a(InlineSproutsStateSpec$SproutsMetadataFlow.LOCATION_METADATA);
        } else if (!this.f6584p.mo207c()) {
            m8029a(InlineSproutsStateSpec$SproutsMetadataFlow.MINUTIAE_METADATA);
        } else if (this.f6583o.mo207c()) {
            m8029a(InlineSproutsStateSpec$SproutsMetadataFlow.METADATA_FLOW_CANCELED);
        } else {
            m8029a(InlineSproutsStateSpec$SproutsMetadataFlow.PEOPLE_METADATA);
        }
    }

    private void m8029a(InlineSproutsStateSpec$SproutsMetadataFlow inlineSproutsStateSpec$SproutsMetadataFlow) {
        this.f6566D = InlineSproutsState.m8093a(this.f6566D).setSproutsMetadataFlowState(inlineSproutsStateSpec$SproutsMetadataFlow).m8091a();
    }

    private void m8038j() {
        String a;
        String str = null;
        TagPeopleInlineSproutItemProvider tagPeopleInlineSproutItemProvider = this.f6589u;
        ProvidesAttachments providesAttachments = this.f6571c;
        ActionItemController$Delegate actionItemController$Delegate = this.f6592x;
        if ((this.f6566D.getSproutsMetadataFlowState() == InlineSproutsStateSpec$SproutsMetadataFlow.PEOPLE_METADATA && this.f6577i.m8046q()) || this.f6566D.isVideoTaggingPromptShowing()) {
            InlineSproutsQeWrapper inlineSproutsQeWrapper = this.f6577i;
            a = inlineSproutsQeWrapper.f6600d.a(ExperimentsForFeedUtilComposerAbtestModule.C, 2131234167, inlineSproutsQeWrapper.f6599c);
        } else {
            a = null;
        }
        this.f6583o = tagPeopleInlineSproutItemProvider.m8083a(providesAttachments, actionItemController$Delegate, a);
        MinutiaeInlineSproutItemProvider minutiaeInlineSproutItemProvider = this.f6590v;
        providesAttachments = this.f6571c;
        actionItemController$Delegate = this.f6593y;
        if (this.f6566D.getSproutsMetadataFlowState() == InlineSproutsStateSpec$SproutsMetadataFlow.MINUTIAE_METADATA && this.f6577i.m8046q()) {
            inlineSproutsQeWrapper = this.f6577i;
            a = inlineSproutsQeWrapper.f6600d.a(ExperimentsForFeedUtilComposerAbtestModule.x, 2131234166, inlineSproutsQeWrapper.f6599c);
        } else {
            a = null;
        }
        this.f6584p = minutiaeInlineSproutItemProvider.m8076a(providesAttachments, actionItemController$Delegate, a);
        LocationInlineSproutItemProvider locationInlineSproutItemProvider = this.f6591w;
        ProvidesAttachments providesAttachments2 = this.f6571c;
        ActionItemController$Delegate actionItemController$Delegate2 = this.f6594z;
        if (this.f6566D.getSproutsMetadataFlowState() == InlineSproutsStateSpec$SproutsMetadataFlow.LOCATION_METADATA && this.f6577i.m8046q()) {
            InlineSproutsQeWrapper inlineSproutsQeWrapper2 = this.f6577i;
            str = inlineSproutsQeWrapper2.f6600d.a(ExperimentsForFeedUtilComposerAbtestModule.v, 2131234165, inlineSproutsQeWrapper2.f6599c);
        }
        this.f6585q = locationInlineSproutItemProvider.m8069a(providesAttachments2, actionItemController$Delegate2, str);
    }

    private void m8039l() {
        ((TransactionImpl) this.f6572d.m7626a(f6562a).m7682a(this.f6566D)).m7689a();
    }

    private void m8031c() {
        ImmutableList.Builder builder = ImmutableList.builder();
        for (int i = 0; i < this.f6581m.size(); i++) {
            InlineSproutItem inlineSproutItem = (InlineSproutItem) this.f6581m.get(i);
            if (inlineSproutItem.mo206b()) {
                builder.c(inlineSproutItem);
            }
        }
        ImmutableList b = builder.b();
        int i2 = 0;
        if (b.isEmpty() || (b.size() == 1 && b.get(0) == this.f6588t)) {
            i2 = 1;
        }
        if (i2 != 0) {
            this.f6574f.setVisibility(8);
            return;
        }
        this.f6574f.setVisibility(0);
        this.f6579k.m7994a(this.f6574f.f6610f, b);
        m8030b(b);
    }

    private void m8030b(ImmutableList<InlineSproutItem> immutableList) {
        Object obj = null;
        ImmutableList immutableList2 = this.f6575g.d;
        if (immutableList.size() != immutableList2.size()) {
            obj = 1;
        } else {
            for (int i = 0; i < immutableList.size(); i++) {
                if (!immutableList2.contains(((InlineSproutItem) immutableList.get(i)).mo205a())) {
                    int i2 = 1;
                    break;
                }
            }
        }
        if (obj != null) {
            List arrayList = new ArrayList(immutableList.size());
            ImmutableList.Builder builder = ImmutableList.builder();
            for (int i3 = 0; i3 < immutableList.size(); i3++) {
                SproutSpec a = ((InlineSproutItem) immutableList.get(i3)).mo205a();
                builder.c(a);
                arrayList.add(a.e);
            }
            this.f6564B = JSONUtil.b(arrayList).toString();
            this.f6575g.a(builder.b());
        }
    }

    public static void m8028a(InlineSproutsController inlineSproutsController, ExpandAnimation expandAnimation) {
        inlineSproutsController.f6574f.m8062a(expandAnimation);
        InlineSproutsAnalyticsLogger inlineSproutsAnalyticsLogger = inlineSproutsController.f6578j;
        String ab = ((ProvidesSessionId) inlineSproutsController.f6571c).ab();
        String str = inlineSproutsController.f6564B;
        HoneyClientEvent c = InlineSproutsAnalyticsLogger.m8021c("composer_tapped_collapsed_inline_sprout_event", ab);
        c.b("available_items", str);
        inlineSproutsAnalyticsLogger.f6558a.a(c);
        inlineSproutsController.f6563A = false;
    }

    private ImmutableList<InlineSproutItem> m8040n() {
        InlineSproutItem[] inlineSproutItemArr = new InlineSproutItem[]{this.f6588t, this.f6582n, this.f6583o, this.f6584p, this.f6585q, this.f6586r, this.f6587s};
        ImmutableList.Builder builder = ImmutableList.builder();
        ImmutableList immutableList = InlineSproutsQeWrapper.f6596b;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            String str = (String) immutableList.get(i);
            for (int i2 = 0; i2 < 7; i2++) {
                InlineSproutItem inlineSproutItem = inlineSproutItemArr[i2];
                if (inlineSproutItem.mo205a().e.equalsIgnoreCase(str)) {
                    builder.c(inlineSproutItem);
                    break;
                }
            }
        }
        return builder.b();
    }
}
