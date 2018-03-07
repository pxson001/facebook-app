package com.facebook.webrtc;

/* compiled from: serializeContact */
public interface IWebrtcConfigInterface {
    void allocateTurnServer(String str, String str2, TurnAllocatorCallback turnAllocatorCallback);

    int getAckTimeout();

    String getAppDataFolder();

    long getAppId();

    String getAppTempFolder();

    int[] getAudioOptionOverrides();

    int getAudioOutputRoute();

    boolean getBooleanExperimentParam(String str, String str2, boolean z);

    boolean getBooleanParam(String str, boolean z);

    int getCapability();

    String getConnectivityStatus();

    String getDeviceId();

    boolean getGateKeeper(String str, boolean z);

    int getIntExperimentParam(String str, String str2, int i);

    int getIntParam(String str, int i);

    int getIsacFramesPerPacketIspx();

    int getIsacInitialBitrate();

    int getIspxAggregationStabilizationMsIsac();

    boolean getIspxCodecSwitchEnabled();

    int getIspxInitialCodec();

    int getIspxMaxAggregationBweOffsetIsac();

    int getMinVersion();

    int getNumberOfRetriesOnError();

    int getOpispxInitialCodec();

    String getRadioTechnology();

    String getRecordFileDir();

    int getRecordSamplesPerSec();

    int getSpeexFramesPerPacketIspx();

    int getSpeexInitialBitrate();

    String getSslCertificate();

    String getSslPrivateKey();

    String getStringExperimentParam(String str, String str2, String str3);

    int getThreadPresenceCapability();

    int getUploadLogLevel();

    long getUserId();

    int getVoipCodecOverrideMode();

    int getVoipCodecOverrideRate();

    int getVoipIspxFecOverrideMode();

    int getVoipIspxImplementationOverride();

    boolean isInAnotherCall();

    void logExperimentObservation(String str);

    void setWebrtcEngine(WebrtcEngine webrtcEngine);

    boolean shouldEnableAutomatedTestSupport();

    boolean shouldEnableStarveSmoothing();

    boolean shouldEnableVideo();

    boolean shouldLoadSelfRawVideo();

    boolean shouldLoopVideoPlayback();

    boolean shouldPlaySampleInputFile();

    boolean shouldPreprocessVideoFrames();

    boolean shouldRecordRemoteRawVideo();

    boolean shouldRecordRemoteVideo();

    boolean shouldRecordSelfRawVideo();

    boolean shouldRecordSelfVideo();

    void webRTCControlRPC_UpdateTestAudioMode(int i);
}
