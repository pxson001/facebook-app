package com.facebook.feed.inlinecomposer.inspiration.row;

import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.photos.creativeediting.model.FrameGraphQLInterfaces.FramePack;
import com.facebook.photos.creativeediting.model.FrameGraphQLModels.FramePackModel;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

/* compiled from: android_pages_ban_actions */
class InlineComposerCameraPartDefinition$3 extends AbstractDisposableFutureCallback<ImmutableList<FramePack>> {
    final /* synthetic */ InlineComposerCameraPartDefinition$State f19233a;
    final /* synthetic */ InlineComposerCameraPartDefinition f19234b;

    InlineComposerCameraPartDefinition$3(InlineComposerCameraPartDefinition inlineComposerCameraPartDefinition, InlineComposerCameraPartDefinition$State inlineComposerCameraPartDefinition$State) {
        this.f19234b = inlineComposerCameraPartDefinition;
        this.f19233a = inlineComposerCameraPartDefinition$State;
    }

    protected final void m22752a(Object obj) {
        ImmutableList immutableList = (ImmutableList) obj;
        Builder builder = new Builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            builder.b(((FramePackModel) immutableList.get(i)).c());
        }
        this.f19233a.f19236b = immutableList;
        this.f19233a.f19237c = builder.b();
        if (this.f19233a.f19235a != null && this.f19233a.f19235a.m11789k()) {
            InlineComposerCameraPartDefinition.b(this.f19233a);
        }
    }

    protected final void m22753a(Throwable th) {
    }
}
