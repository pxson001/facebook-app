package com.facebook.growth.friendfinder.factory;

import com.facebook.contacts.upload.prefs.ContactUploadStatusHelper;
import com.facebook.gk.store.GatekeeperStoreImpl;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/* compiled from: parent_group_name */
public class FriendFinderStepsConfig {
    public final ContactUploadStatusHelper f7286a;
    public final GatekeeperStoreImpl f7287b;
    public final List<FriendFinderStep> f7288c = new ArrayList(FriendFinderStep.values().length);

    /* compiled from: parent_group_name */
    public enum FriendFinderStep {
        LEGAL_SCREEN,
        FRIENDABLE_CONTACTS,
        INVITABLE_CONTACTS
    }

    @Inject
    public FriendFinderStepsConfig(ContactUploadStatusHelper contactUploadStatusHelper, GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f7286a = contactUploadStatusHelper;
        this.f7287b = gatekeeperStoreImpl;
    }
}
