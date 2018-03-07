package com.facebook.feedplugins.fitness;

import com.facebook.feed.rows.core.FeedRowSupportDeclaration;
import com.facebook.feed.rows.core.ListItemRowController;
import javax.inject.Inject;

/* compiled from: disableContactImporter */
public class FitnessAttachmentDeclaration implements FeedRowSupportDeclaration {
    private final FitnessAttachmentUtils f7601a;

    @Inject
    public FitnessAttachmentDeclaration(FitnessAttachmentUtils fitnessAttachmentUtils) {
        this.f7601a = fitnessAttachmentUtils;
    }

    public final void m8826a(ListItemRowController listItemRowController) {
        if (this.f7601a.m8838a()) {
            listItemRowController.a(FitnessMapPartDefinition.f7621a);
        }
    }
}
