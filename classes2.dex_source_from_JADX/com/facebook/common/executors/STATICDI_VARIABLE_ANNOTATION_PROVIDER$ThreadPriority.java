package com.facebook.common.executors;

import com.facebook.config.application.ProductMethodAutoProvider;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.send.service.MessagingSendServiceModule;
import com.facebook.orca.server.module.MessagesServiceModule;
import java.lang.annotation.Annotation;
import javax.inject.Provider;

/* compiled from: findfriends */
public class STATICDI_VARIABLE_ANNOTATION_PROVIDER$ThreadPriority implements Provider<ThreadPriority> {
    public static ThreadPriority m32077a(InjectorLike injectorLike, Class<? extends Annotation> cls) {
        String name = cls.getName();
        switch (name.hashCode()) {
            case -2073336660:
                if (name.equals("com.facebook.messaging.send.service.PendingSendQueue")) {
                    return MessagingSendServiceModule.b(ProductMethodAutoProvider.m4524b(injectorLike), IdBasedProvider.m1811a(injectorLike, 4083));
                }
                break;
            case -1900853943:
                if (name.equals("com.facebook.feed.protocol.NewsFeedFetchQueue")) {
                    return ThreadPriority.URGENT;
                }
                break;
            case -1627854560:
                if (name.equals("com.facebook.fbservice.service.AuthQueue")) {
                    return ThreadPriority.URGENT;
                }
                break;
            case -1505300081:
                if (name.equals("com.facebook.messaging.send.service.SendQueue")) {
                    return MessagingSendServiceModule.a(ProductMethodAutoProvider.m4524b(injectorLike), IdBasedProvider.m1811a(injectorLike, 4083));
                }
                break;
            case -744478052:
                if (name.equals("com.facebook.messaging.media.upload.PhotoUploadQueue")) {
                    return ThreadPriority.NORMAL_NEW;
                }
                break;
            case -32458431:
                if (name.equals("com.facebook.feed.protocol.NewsFeedPostingQueue")) {
                    return ThreadPriority.URGENT;
                }
                break;
            case 900791765:
                if (name.equals("com.facebook.messaging.media.upload.PhotoUploadParallelQueue")) {
                    return ThreadPriority.NORMAL_NEW;
                }
                break;
            case 1327869382:
                if (name.equals("com.facebook.feed.protocol.NewsFeedMainQueue")) {
                    return ThreadPriority.FOREGROUND;
                }
                break;
            case 1784610938:
                if (name.equals("com.facebook.orca.server.module.MultiCacheThreadsQueue")) {
                    return MessagesServiceModule.a(ProductMethodAutoProvider.m4524b(injectorLike));
                }
                break;
        }
        FbInjector.m1082a(name);
        return null;
    }

    public static boolean m32078a(Class<? extends Annotation> cls) {
        String name = cls.getName();
        switch (name.hashCode()) {
            case -2073336660:
                if (name.equals("com.facebook.messaging.send.service.PendingSendQueue")) {
                    return true;
                }
                break;
            case -1900853943:
                if (name.equals("com.facebook.feed.protocol.NewsFeedFetchQueue")) {
                    return true;
                }
                break;
            case -1627854560:
                if (name.equals("com.facebook.fbservice.service.AuthQueue")) {
                    return true;
                }
                break;
            case -1505300081:
                if (name.equals("com.facebook.messaging.send.service.SendQueue")) {
                    return true;
                }
                break;
            case -744478052:
                if (name.equals("com.facebook.messaging.media.upload.PhotoUploadQueue")) {
                    return true;
                }
                break;
            case -32458431:
                if (name.equals("com.facebook.feed.protocol.NewsFeedPostingQueue")) {
                    return true;
                }
                break;
            case 900791765:
                if (name.equals("com.facebook.messaging.media.upload.PhotoUploadParallelQueue")) {
                    return true;
                }
                break;
            case 1327869382:
                if (name.equals("com.facebook.feed.protocol.NewsFeedMainQueue")) {
                    return true;
                }
                break;
            case 1784610938:
                if (name.equals("com.facebook.orca.server.module.MultiCacheThreadsQueue")) {
                    return true;
                }
                break;
        }
        return false;
    }
}
