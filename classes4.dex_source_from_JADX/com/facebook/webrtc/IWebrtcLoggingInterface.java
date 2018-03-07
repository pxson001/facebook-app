package com.facebook.webrtc;

/* compiled from: location_history_enabled */
public interface IWebrtcLoggingInterface {
    void discardCall(long j);

    void logCallAction(long j, long j2, String str, String str2);

    void logConnectionStatus(boolean z, String str, long j);

    void logEndCallSummary(long j, String str);

    void logEngineCreationEvent(boolean z);

    void logFbTraceReplyReceivedFailure(String str, long j, long j2, String str2);

    void logFbTraceReplyReceivedSuccess(String str, long j, long j2);

    void logFbTraceReplySentFailure(String str, long j, long j2, long j3, long j4, String str2);

    void logFbTraceReplySentSuccess(String str, String str2, long j, long j2, long j3, long j4);

    void logFbTraceRequestReceived(String str);

    String logFbTraceRequestSent(String str, long j, long j2, long j3, long j4, String str2, int i, String str3, String str4);

    void logIceConnectionState(long j, int i);

    void logInitialBatteryLevel();

    void logInternalError(String str, long j);

    void logInternalInfo(String str, String str2, long j);

    void logReceivedMessage(String str, long j, long j2, long j3, long j4, String str2);

    void logSentMessage(String str, long j, long j2, long j3, long j4, String str2, String str3);

    void logSentMessageFailure(long j, int i, String str, String str2, long j2);

    void logSentMessageSuccess(long j, long j2);

    void pauseLogUpload();

    void periodicLogging(long j, String str);

    void refreshLogUploadPause();

    void resumeLogUpload();

    void setLastCallId(long j);
}
