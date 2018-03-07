package com.facebook.composer.inlinesprouts;

import android.content.Context;
import android.view.View.OnClickListener;
import com.facebook.common.ui.keyboard.SoftInputDetector;
import com.facebook.composer.actionitem.ActionItemController$Delegate;
import com.facebook.composer.attachments.ComposerAttachment.ProvidesAttachments;
import com.facebook.composer.capability.ComposerPhotoCapability.ProvidesCapability;
import com.facebook.composer.inlinesprouts.InlineSproutsView.OnMeasuredListener;
import com.facebook.composer.inlinesprouts.model.InlineSproutsStateSpec.ProvidesInlineSproutsState;
import com.facebook.composer.inlinesprouts.model.InlineSproutsStateSpec.SetsInlineSproutsState;
import com.facebook.composer.location.LocationLightweightPickerSproutItem.Listener;
import com.facebook.composer.location.LocationLightweightPickerSproutItemProvider;
import com.facebook.composer.minutiae.model.MinutiaeObject.ProvidesMinutiae;
import com.facebook.feed.util.composer.sprout.SproutAdapterProvider;
import com.facebook.inject.AbstractAssistedProvider;
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
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;

/* compiled from: fundraiser_page_tapped_go_to_page */
public class InlineSproutsControllerProvider extends AbstractAssistedProvider<InlineSproutsController> {
    public final <DataProvider extends ProvidesAttachments & ProvidesIsCheckinSupported & ProvidesIsFacecastSupported & ProvidesIsInlineSproutsOpen & ProvidesIsMinutiaeSupported & ProvidesIsTagPeopleSupported & ProvidesSessionId & ProvidesLocationInfo & ProvidesCapability & ProvidesFacecastInfo & ProvidesTaggedUsers & ProvidesInlineSproutsState & ProvidesMinutiae, Transaction extends ComposerTransaction & SetsInlineSproutsState<Transaction>> InlineSproutsController<DataProvider, Transaction> m8043a(OnClickListener onClickListener, InlineSproutsView inlineSproutsView, OnMeasuredListener onMeasuredListener, DataProvider dataProvider, ComposerMutator<Transaction> composerMutator, ActionItemController$Delegate actionItemController$Delegate, ActionItemController$Delegate actionItemController$Delegate2, ActionItemController$Delegate actionItemController$Delegate3, ActionItemController$Delegate actionItemController$Delegate4, Listener listener, ActionItemController$Delegate actionItemController$Delegate5, ActionItemController$Delegate actionItemController$Delegate6) {
        return new InlineSproutsController(onClickListener, inlineSproutsView, onMeasuredListener, (ProvidesAttachments) dataProvider, composerMutator, actionItemController$Delegate, actionItemController$Delegate2, actionItemController$Delegate3, actionItemController$Delegate4, listener, actionItemController$Delegate5, actionItemController$Delegate6, (Context) getInstance(Context.class), (SproutAdapterProvider) getOnDemandAssistedProviderForStaticDi(SproutAdapterProvider.class), (GalleryInlineSproutItemProvider) getOnDemandAssistedProviderForStaticDi(GalleryInlineSproutItemProvider.class), (MinutiaeInlineSproutItemProvider) getOnDemandAssistedProviderForStaticDi(MinutiaeInlineSproutItemProvider.class), (LocationInlineSproutItemProvider) getOnDemandAssistedProviderForStaticDi(LocationInlineSproutItemProvider.class), (LocationLightweightPickerSproutItemProvider) getOnDemandAssistedProviderForStaticDi(LocationLightweightPickerSproutItemProvider.class), (TagPeopleInlineSproutItemProvider) getOnDemandAssistedProviderForStaticDi(TagPeopleInlineSproutItemProvider.class), (FacecastInlineSproutItemProvider) getOnDemandAssistedProviderForStaticDi(FacecastInlineSproutItemProvider.class), (WriteInlineSproutItemProvider) getOnDemandAssistedProviderForStaticDi(WriteInlineSproutItemProvider.class), (FacecastSproutNuxControllerProvider) getOnDemandAssistedProviderForStaticDi(FacecastSproutNuxControllerProvider.class), InlineSproutsQeWrapper.m8044a(this), InlineSproutsAnalyticsLogger.m8019a(this), CollapsedViewWithExpandedIconsBinder.m7992a(this), SoftInputDetector.a(this), (QeAccessor) QeInternalImplMethodAutoProvider.a(this));
    }
}
