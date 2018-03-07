package com.facebook.composer.inlinesprouts;

import com.facebook.composer.actionitem.ActionItemController$Delegate;
import com.facebook.composer.activity.ComposerDataProviderImpl;
import com.facebook.facecastdisplay.FacecastUtil;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsFacecastSupported;
import com.facebook.ipc.composer.model.ComposerFacecastInfo.ProvidesFacecastInfo;

/* compiled from: fundraiser_send_invites */
public class FacecastInlineSproutItemProvider extends AbstractAssistedProvider<FacecastInlineSproutItem> {
    public final <DataProvider extends ProvidesIsFacecastSupported & ProvidesFacecastInfo> FacecastInlineSproutItem<DataProvider> m8007a(DataProvider dataProvider, ActionItemController$Delegate actionItemController$Delegate, FacecastSproutNuxController facecastSproutNuxController) {
        return new FacecastInlineSproutItem((ComposerDataProviderImpl) dataProvider, actionItemController$Delegate, facecastSproutNuxController, InlineSproutsQeWrapper.m8044a(this), FacecastUtil.b(this));
    }
}
