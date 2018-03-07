package com.facebook.feed.environment.impl;

import com.facebook.controller.connectioncontroller.common.MutationControllerManager;
import com.facebook.feed.environment.HasMutationControllerManager;
import com.facebook.inject.Assisted;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: network_info_may_have_network */
public class HasMutationControllerManagerImpl implements HasMutationControllerManager {
    @Nullable
    private final MutationControllerManager f12554a;

    @Inject
    public HasMutationControllerManagerImpl(@Assisted MutationControllerManager mutationControllerManager) {
        this.f12554a = mutationControllerManager;
    }
}
