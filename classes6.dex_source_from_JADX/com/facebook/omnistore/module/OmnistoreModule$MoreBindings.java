package com.facebook.omnistore.module;

import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.bugreporter.BugReportExtraFileMapProvider;
import com.facebook.common.init.INeedInit;
import com.facebook.common.init.INeedInitForBroadcastReceiverRegistration;
import com.facebook.common.noncriticalinit.NeedsAfterUILoadedInitOnBackgroundThread;
import com.facebook.gk.Gatekeeper;
import com.facebook.inject.Bindings;
import com.facebook.inject.MultiBind;
import com.facebook.inject.ProviderMethod;
import com.facebook.omnistore.MqttProtocolProvider;
import com.facebook.omnistore.OmnistoreErrorReporter;
import com.facebook.omnistore.logger.FbOmnistoreErrorReporter;
import com.facebook.omnistore.module.OmnistoreComponentManager.OmnistoreComponentManagerBroadcastReceiverRegistration;
import com.facebook.reportaproblem.base.bugreport.file.BugReportFileProvider;

@Bindings
/* compiled from: tax */
interface OmnistoreModule$MoreBindings {
    @MultiBind
    BugReportExtraFileMapProvider addBugReportExtraFileMapProviders(OmnistoreExtraFileProvider omnistoreExtraFileProvider);

    @MultiBind
    BugReportFileProvider addBugReportFileProviders(OmnistoreExtraFileProvider omnistoreExtraFileProvider);

    @MultiBind
    IHaveUserData addIHaveUserData(OmnistoreComponentManager omnistoreComponentManager);

    @NeedsAfterUILoadedInitOnBackgroundThread
    @MultiBind
    INeedInit addINeedInit(OmnistoreComponentManager omnistoreComponentManager);

    @MultiBind
    INeedInitForBroadcastReceiverRegistration addINeedInitForBroadcastReceiverRegistration(OmnistoreComponentManagerBroadcastReceiverRegistration omnistoreComponentManagerBroadcastReceiverRegistration);

    @ProviderMethod
    @OverrideMqttProtocolProvider
    MqttProtocolProvider defaultMqttProtocolProvider(MqttProtocolProvider mqttProtocolProvider);

    @IsConnectMessageSubscriptions
    @Gatekeeper("android_messenger_omnistore_subscribe_with_connect")
    Boolean provideIsConnectMessageSubscriptions();

    @Gatekeeper("android_messenger_omnistore_integrity")
    @IsOmnistoreIntegrityEnabled
    Boolean provideIsOmnistoreIntegrityEnabled();

    @ProviderMethod
    OmnistoreErrorReporter provideOmnistoreErrorReporter(FbOmnistoreErrorReporter fbOmnistoreErrorReporter);

    @ProviderMethod
    DefaultOmnistoreOpener provideOmnistoreOpener(DefaultOmnistoreOpener defaultOmnistoreOpener);

    @Gatekeeper("android_omnistore_dont_delete_db_on_open_error")
    @OmnistoreDontDeleteDbOnOpenError
    Boolean providerOmnistoreDontDeleteDbOnOpenError();
}
