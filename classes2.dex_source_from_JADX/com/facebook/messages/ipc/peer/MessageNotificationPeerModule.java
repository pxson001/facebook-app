package com.facebook.messages.ipc.peer;

import com.facebook.base.broadcast.FbBroadcastManager;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.config.application.FbAppType;
import com.facebook.inject.AbstractLibraryModule;
import com.facebook.inject.BinderImpl;
import com.facebook.inject.InjectorModule;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProviderMethod;
import com.facebook.multiprocess.peer.PeerProcessManagerFactory;
import com.facebook.multiprocess.peer.state.PeerStateRoleFactory;
import com.facebook.multiprocess.peer.state.StatefulPeerManager;
import com.facebook.multiprocess.peer.state.StatefulPeerManagerImpl;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSet.Builder;
import javax.inject.Singleton;

@InjectorModule
/* compiled from: time_range.start */
public class MessageNotificationPeerModule extends AbstractLibraryModule {
    protected void configure() {
        BinderImpl binderImpl = this.mBinder;
    }

    @ProviderMethod
    @MessageNotificationPeer
    @Singleton
    public static StatefulPeerManager m4837a(PeerStateRoleFactory peerStateRoleFactory, MessagesNotificationProcessType messagesNotificationProcessType, FbAppType fbAppType, PeerProcessManagerFactory peerProcessManagerFactory, FbBroadcastManager fbBroadcastManager, Lazy<FbErrorReporter> lazy) {
        Builder builder = ImmutableSet.builder();
        if (messagesNotificationProcessType == MessagesNotificationProcessType.Dash) {
            builder.m4813c(peerStateRoleFactory.m4832a(MessageNotificationPeerContract.f2835a, 0));
        } else if (messagesNotificationProcessType == MessagesNotificationProcessType.Fscam) {
            builder.m4813c(peerStateRoleFactory.m4832a(MessageNotificationPeerContract.f2847m, 0));
        } else if (messagesNotificationProcessType == MessagesNotificationProcessType.Messenger) {
            builder.m4813c(peerStateRoleFactory.m4832a(MessageNotificationPeerContract.f2839e, 499));
            builder.m4813c(peerStateRoleFactory.m4832a(MessageNotificationPeerContract.f2847m, 0));
            builder.m4813c(peerStateRoleFactory.m4832a(MessageNotificationPeerContract.f2849o, 0));
        } else if (messagesNotificationProcessType == MessagesNotificationProcessType.Fb4a) {
            builder.m4813c(peerStateRoleFactory.m4832a(MessageNotificationPeerContract.f2847m, 1));
            builder.m4813c(peerStateRoleFactory.m4832a(MessageNotificationPeerContract.f2849o, 1));
        } else if (messagesNotificationProcessType == MessagesNotificationProcessType.PMA) {
            builder.m4813c(peerStateRoleFactory.m4832a(MessageNotificationPeerContract.f2847m, 2));
        }
        String str = "com.facebook.messages.ipc.peers." + fbAppType.k.name();
        return new StatefulPeerManagerImpl(peerStateRoleFactory, builder.m4812b(), peerProcessManagerFactory, str, fbBroadcastManager, MessageNotificationPeerModule.class.getClassLoader(), lazy, true);
    }
}
