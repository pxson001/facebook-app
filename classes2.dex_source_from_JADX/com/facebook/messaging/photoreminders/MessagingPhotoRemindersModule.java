package com.facebook.messaging.photoreminders;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.ProviderMethod;
import com.facebook.messaging.photoreminders.omnistore.PhotoRemindersCollection;
import com.facebook.omnistore.Collection;
import com.facebook.omnistore.CollectionName;
import com.facebook.omnistore.Omnistore;
import com.facebook.user.model.User;
import javax.annotation.Nullable;

@InjectorModule
/* compiled from: toggle_save_place */
public class MessagingPhotoRemindersModule extends AbstractLibraryModule {

    /* compiled from: toggle_save_place */
    public final class C01691 {
        C01691() {
        }
    }

    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @PhotoReminderGK
    public static C01691 m4654a() {
        return new C01691();
    }

    @ProviderMethod
    @PhotoRemindersCollection
    @UserScoped
    @Nullable
    static CollectionName m4656a(AbstractFbErrorReporter abstractFbErrorReporter, Omnistore omnistore, String str, User user) {
        if (user == null) {
            return null;
        }
        if (omnistore == null) {
            abstractFbErrorReporter.m2340a("MessagingPhotoRemindersModule", "Omnistore was null even though logged-in user is present");
        }
        return omnistore.createCollectionNameBuilder("messenger_photo_reminders").addSegment(str).build();
    }

    @ProviderMethod
    @PhotoRemindersCollection
    @UserScoped
    @Nullable
    static Collection m4655a(Omnistore omnistore, CollectionName collectionName) {
        if (collectionName == null) {
            return null;
        }
        return omnistore.subscribeCollection(collectionName);
    }
}
