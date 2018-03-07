package com.facebook.proxygen;

import java.util.Arrays;
import javax.annotation.Nullable;

/* compiled from: ptr_scroll_without_ptr */
public class HTTPClient implements NativeHandle {
    private String[] mActiveDomains;
    private int mAdaptiveConfigInterval = 10;
    private AdaptiveIntegerParameters mAdaptiveConnTOParam;
    private boolean mAdaptivePing;
    private AdaptiveIntegerParameters mAdaptiveSessionTOParam;
    private boolean mAllowGradientWeight;
    private AnalyticsLogger mAnalyticsLogger;
    private int mBackupConnTimeout;
    private String mBypassProxyDomains;
    private boolean mCAresEnabled;
    private boolean mCircularLogSinkEnabled;
    private boolean mClosed;
    private double mConnSampleRate = 0.0d;
    private boolean mCrossDomainTCPConnsEnabled;
    private String[] mDNSServers;
    private boolean mDnsCacheEnabled;
    private int mDnsRequestsOutstanding;
    private int mDynamicLimitRatio;
    private boolean mEnableCachingPushManager = false;
    private boolean mEnableTransportCallbacks;
    private final EventBase mEventBase;
    private boolean mFlowControlSelectedTxnsOnly = false;
    private int mFlowControlWindow = 65535;
    private String mGatewayPingAddress = "";
    private boolean mGatewayPingEnabled;
    private int mGatewayPingIntervalMs = 0;
    private String mGradientWeights;
    private String mHTTPSessionCacheType;
    private int mIdleTimeoutForUnused;
    private int mIdleTimeoutForUsed;
    private boolean mInitialized;
    private boolean mIsHTTP2Enabled;
    private boolean mIsHTTPSEnforced;
    private boolean mIsHappyEyeballsV4Preferred;
    private boolean mIsNetworkEventLogEnabled;
    private boolean mIsPerDomainLimitEnabled;
    private boolean mIsPerDomainLimitEnabled2G;
    private boolean mIsRetryFilterEnabled;
    private boolean mIsSSLSessionCacheEnabled;
    private boolean mIsSandbox;
    private boolean mIsSchedulerEnabled;
    private boolean mIsZlibFilterEnabled;
    private boolean mLargerFlowControlWindow = false;
    private int mMaxConnectionRetryCount;
    private int mMaxConnectionRetryCount2G;
    private int mMaxIdleHTTPSessions;
    private int mMaxIdleHTTPSessions2G;
    private int mMaxIdleSPDYSessions;
    private int mMaxIdleSPDYSessions2G;
    private int mMaxPingRetries;
    private int mMaxPriorityLevelForSession = 0;
    private int mMinDomainRefreshInterval;
    private NetworkStatusMonitor mNetworkStatusMonitor;
    private long mNewConnTimeoutMillis = 30000;
    private PersistentSSLCacheSettings mPersistentDNSCacheSettings;
    private PersistentSSLCacheSettings mPersistentSSLCacheSettings;
    private int mPingRttThreshold;
    private int mPingTimeout;
    private String[] mPreConnects;
    private boolean mProxyFallbackEnabled;
    private String mProxyHost;
    private String mProxyPassword;
    private int mProxyPort;
    private String mProxyUsername;
    private PushCallbacks mPushCallbacks;
    private boolean mReInitToRefreshSettings;
    private String[] mRedirectTargetWhitelist;
    private String[] mRewriteExemptions;
    private RewriteRule[] mRewriteRules;
    private long mRewriteRulesHandle;
    private SchedulingParameters mSchedulerParam;
    private String mSecureProxyHost;
    private String mSecureProxyPassword;
    private int mSecureProxyPort;
    private String mSecureProxyUsername;
    private boolean mSendPingForTcpRetransmission;
    private long mSessionWriteTimeoutMillis = 60000;
    private long mSettings;
    private boolean mSocketBufferExperimentEnabled;
    private int mSocketSendBuffer;
    private boolean mStaleAnswersEnabled;
    private long mTransactionIdleTimeoutMillis = 60000;
    private boolean mUpdateDNSAfterTCPReuse;
    private boolean mUseLoadBalancing = false;
    private boolean mUseRequestWeight;
    private boolean mUseZRRedirectFilter = true;
    private String mUserAgent;
    private byte[][] mUserInstalledCertificates;
    private ZeroProtocolSettings mZeroProtocolSettings;

    private native void close(EventBase eventBase);

    private native void connect(EventBase eventBase, String[] strArr);

    private native void init(EventBase eventBase, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, String str, String[] strArr, String[] strArr2, int i, boolean z6, int i2, int i3, int i4, int i5, boolean z7, int i6, int i7, int i8, int i9, int i10, int i11, boolean z8, SchedulingParameters schedulingParameters, boolean z9, boolean z10, String str2, int i12, String str3, String str4, String str5, int i13, String str6, String str7, String str8, boolean z11, PersistentSSLCacheSettings persistentSSLCacheSettings, ZeroProtocolSettings zeroProtocolSettings, byte[][] bArr, boolean z12, long j, long j2, long j3, String[] strArr3, PersistentSSLCacheSettings persistentSSLCacheSettings2, boolean z13, boolean z14, boolean z15, int i14, NetworkStatusMonitor networkStatusMonitor, boolean z16, int i15, int i16, int i17, boolean z17, RewriteRule[] rewriteRuleArr, String[] strArr4, String[] strArr5, AnalyticsLogger analyticsLogger, double d, boolean z18, int i18, boolean z19, boolean z20, String str9, int i19, String str10, boolean z21, int i20, AdaptiveIntegerParameters adaptiveIntegerParameters, boolean z22, boolean z23, boolean z24, int i21, boolean z25, int i22, boolean z26, boolean z27, String str11, boolean z28, PushCallbacks pushCallbacks, boolean z29, AdaptiveIntegerParameters adaptiveIntegerParameters2);

    private native void updateRewriteRules(RewriteRule[] rewriteRuleArr);

    public native synchronized void make(JniHandler jniHandler, NativeReadBuffer nativeReadBuffer, boolean z, TraceEventContext traceEventContext, boolean z2, NetworkStatusMonitor networkStatusMonitor, int i);

    public HTTPClient(EventBase eventBase) {
        this.mEventBase = eventBase;
        this.mIsNetworkEventLogEnabled = true;
        this.mIsZlibFilterEnabled = true;
        this.mIsRetryFilterEnabled = true;
        this.mIsSSLSessionCacheEnabled = true;
        this.mHTTPSessionCacheType = "simple";
        this.mIsPerDomainLimitEnabled = false;
        this.mMaxConnectionRetryCount = 0;
        this.mMaxIdleHTTPSessions = 6;
        this.mMaxIdleSPDYSessions = 2;
        this.mDynamicLimitRatio = 0;
        this.mIsPerDomainLimitEnabled2G = false;
        this.mMaxConnectionRetryCount2G = 0;
        this.mMaxIdleHTTPSessions2G = 6;
        this.mMaxIdleSPDYSessions2G = 2;
        this.mIdleTimeoutForUsed = 55000;
        this.mIdleTimeoutForUnused = 55000;
        this.mBackupConnTimeout = 0;
        this.mIsSchedulerEnabled = false;
        this.mIsHTTPSEnforced = false;
        this.mIsSandbox = false;
        this.mIsHappyEyeballsV4Preferred = false;
        this.mDnsCacheEnabled = false;
        this.mCAresEnabled = false;
        this.mStaleAnswersEnabled = true;
        this.mDnsRequestsOutstanding = 1;
        this.mCircularLogSinkEnabled = true;
        this.mSendPingForTcpRetransmission = false;
        this.mMaxPingRetries = 0;
        this.mPingTimeout = 100;
        this.mPingRttThreshold = 150;
        this.mAdaptivePing = false;
        this.mRewriteRulesHandle = 0;
        this.mRedirectTargetWhitelist = new String[]{"^https?://([a-z0-9\\.-]+)*facebook\\.com"};
        this.mSocketBufferExperimentEnabled = false;
        this.mSocketSendBuffer = 4525824;
        this.mIsHTTP2Enabled = false;
        this.mCrossDomainTCPConnsEnabled = false;
        this.mUpdateDNSAfterTCPReuse = false;
        this.mEnableTransportCallbacks = false;
    }

    public long getNativeHandle() {
        return this.mSettings;
    }

    public void setNativeHandle(long j) {
        this.mSettings = j;
    }

    public HTTPClient setNetworkEventLogging(boolean z) {
        this.mIsNetworkEventLogEnabled = z;
        return this;
    }

    public HTTPClient setRetryFilter(boolean z) {
        this.mIsRetryFilterEnabled = z;
        return this;
    }

    public HTTPClient setZlibFilter(boolean z) {
        this.mIsZlibFilterEnabled = z;
        return this;
    }

    public HTTPClient setSSLSessionCache(boolean z) {
        this.mIsSSLSessionCacheEnabled = z;
        return this;
    }

    public HTTPClient setHTTPSessionCacheType(String str) {
        this.mHTTPSessionCacheType = str;
        return this;
    }

    public HTTPClient setPreConnects(String[] strArr) {
        this.mPreConnects = strArr;
        return this;
    }

    public HTTPClient setActiveDomains(String[] strArr) {
        this.mActiveDomains = strArr;
        return this;
    }

    public HTTPClient setMinDomainRefereshInterval(int i) {
        this.mMinDomainRefreshInterval = i;
        return this;
    }

    public HTTPClient setPerDomainLimitEnabled(boolean z) {
        this.mIsPerDomainLimitEnabled = z;
        return this;
    }

    public HTTPClient setMaxConnectionRetryCount(int i) {
        this.mMaxConnectionRetryCount = i;
        return this;
    }

    public HTTPClient setMaxIdleHTTPSessions(int i) {
        this.mMaxIdleHTTPSessions = i;
        return this;
    }

    public HTTPClient setMaxIdleSPDYSessions(int i) {
        this.mMaxIdleSPDYSessions = i;
        return this;
    }

    public HTTPClient setDynamicLimitRatio(int i) {
        this.mDynamicLimitRatio = i;
        return this;
    }

    public HTTPClient setPerDomainLimitEnabled2G(boolean z) {
        this.mIsPerDomainLimitEnabled2G = z;
        return this;
    }

    public HTTPClient setMaxConnectionRetryCount2G(int i) {
        this.mMaxConnectionRetryCount2G = i;
        return this;
    }

    public HTTPClient setMaxIdleHTTPSessions2G(int i) {
        this.mMaxIdleHTTPSessions2G = i;
        return this;
    }

    public HTTPClient setMaxIdleSPDYSessions2G(int i) {
        this.mMaxIdleSPDYSessions2G = i;
        return this;
    }

    public HTTPClient setIdleTimeoutForUsed(int i) {
        this.mIdleTimeoutForUsed = i;
        return this;
    }

    public HTTPClient setSendPingForTcpRetransmission(boolean z) {
        this.mSendPingForTcpRetransmission = z;
        return this;
    }

    public HTTPClient setMaxPingRetries(int i) {
        this.mMaxPingRetries = i;
        return this;
    }

    public HTTPClient setPingRttThreshold(int i) {
        this.mPingRttThreshold = i;
        return this;
    }

    public HTTPClient setAdaptivePing(boolean z) {
        this.mAdaptivePing = z;
        return this;
    }

    public HTTPClient setPingTimeout(int i) {
        this.mPingTimeout = i;
        return this;
    }

    public HTTPClient setIdleTimeoutForUnused(int i) {
        this.mIdleTimeoutForUnused = i;
        return this;
    }

    public HTTPClient setBackupConnTimeout(int i) {
        this.mBackupConnTimeout = i;
        return this;
    }

    public HTTPClient setRequestSchedulingEnabled(boolean z, SchedulingParameters schedulingParameters) {
        this.mIsSchedulerEnabled = z;
        this.mSchedulerParam = schedulingParameters;
        return this;
    }

    public HTTPClient setSocketBufferExperimentEnabled(boolean z, int i) {
        this.mSocketBufferExperimentEnabled = z;
        this.mSocketSendBuffer = i;
        return this;
    }

    public HTTPClient setHTTPSEnforced(boolean z) {
        this.mIsHTTPSEnforced = z;
        return this;
    }

    public HTTPClient setDNSServers(String[] strArr) {
        if (!Arrays.equals(this.mDNSServers, strArr)) {
            this.mDNSServers = strArr;
            this.mReInitToRefreshSettings = true;
        }
        return this;
    }

    public HTTPClient setPersistentDNSCacheSettings(PersistentSSLCacheSettings persistentSSLCacheSettings) {
        this.mPersistentDNSCacheSettings = persistentSSLCacheSettings;
        return this;
    }

    public HTTPClient setZeroProtocolSettings(ZeroProtocolSettings zeroProtocolSettings) {
        this.mZeroProtocolSettings = zeroProtocolSettings;
        return this;
    }

    public HTTPClient setDNSCacheEnabled(boolean z) {
        this.mDnsCacheEnabled = z;
        return this;
    }

    public HTTPClient setCAresEnabled(boolean z) {
        this.mCAresEnabled = z;
        return this;
    }

    public HTTPClient setStaleAnswersEnabled(boolean z) {
        this.mStaleAnswersEnabled = z;
        return this;
    }

    public HTTPClient setDnsRequestsOutstanding(int i) {
        this.mDnsRequestsOutstanding = i;
        return this;
    }

    public HTTPClient setRewriteRules(RewriteRule[] rewriteRuleArr) {
        this.mRewriteRules = rewriteRuleArr;
        return this;
    }

    public HTTPClient setRewriteExemptions(String[] strArr) {
        this.mRewriteExemptions = strArr;
        return this;
    }

    public HTTPClient setRedirectTargetWhitelist(String[] strArr) {
        this.mRedirectTargetWhitelist = strArr;
        return this;
    }

    public HTTPClient setCircularLogSinkEnabled(boolean z) {
        this.mCircularLogSinkEnabled = z;
        return this;
    }

    public HTTPClient setEnableCachingPushManager(boolean z) {
        this.mEnableCachingPushManager = z;
        return this;
    }

    public HTTPClient setPushCallbacks(PushCallbacks pushCallbacks) {
        this.mPushCallbacks = pushCallbacks;
        return this;
    }

    public HTTPClient setProxy(@Nullable String str, int i, @Nullable String str2, @Nullable String str3) {
        if (!(stringEquals(str, this.mProxyHost) && i == this.mProxyPort && stringEquals(str2, this.mProxyUsername) && stringEquals(str3, this.mProxyPassword))) {
            this.mProxyHost = str;
            this.mProxyPort = i;
            this.mProxyUsername = str2;
            this.mProxyPassword = str3;
            this.mReInitToRefreshSettings = true;
        }
        return this;
    }

    public HTTPClient setSecureProxy(@Nullable String str, int i, @Nullable String str2, @Nullable String str3) {
        if (!(stringEquals(str, this.mSecureProxyHost) && i == this.mSecureProxyPort && stringEquals(str2, this.mSecureProxyUsername) && stringEquals(str3, this.mSecureProxyPassword))) {
            this.mSecureProxyHost = str;
            this.mSecureProxyPort = i;
            this.mSecureProxyUsername = str2;
            this.mSecureProxyPassword = str3;
            this.mReInitToRefreshSettings = true;
        }
        return this;
    }

    public HTTPClient setBypassProxyDomains(@Nullable String str) {
        if (!stringEquals(str, this.mBypassProxyDomains)) {
            this.mBypassProxyDomains = str;
            this.mReInitToRefreshSettings = true;
        }
        return this;
    }

    public HTTPClient setUserAgent(@Nullable String str) {
        this.mUserAgent = str;
        return this;
    }

    public HTTPClient setProxyFallbackEnabled(boolean z) {
        this.mProxyFallbackEnabled = z;
        return this;
    }

    public HTTPClient setGatewayPingEnabled(boolean z) {
        this.mGatewayPingEnabled = z;
        return this;
    }

    public HTTPClient setGatewayPingAddress(String str) {
        this.mGatewayPingAddress = str;
        return this;
    }

    public HTTPClient setGatewayPingIntervalMs(int i) {
        this.mGatewayPingIntervalMs = i;
        return this;
    }

    public boolean reInitializeIfNeeded() {
        if (this.mReInitToRefreshSettings && this.mInitialized) {
            reinit();
            this.mClosed = false;
            this.mReInitToRefreshSettings = false;
            return true;
        }
        this.mReInitToRefreshSettings = false;
        return false;
    }

    private boolean stringEquals(@Nullable String str, @Nullable String str2) {
        if (str != null) {
            return str.equals(str2);
        }
        return str2 == null;
    }

    public HTTPClient setPersistentSSLCacheSettings(PersistentSSLCacheSettings persistentSSLCacheSettings) {
        this.mPersistentSSLCacheSettings = persistentSSLCacheSettings;
        return this;
    }

    public HTTPClient setUserInstalledCertificates(byte[][] bArr) {
        this.mUserInstalledCertificates = bArr;
        return this;
    }

    public HTTPClient setIsSandbox(boolean z) {
        if (this.mIsSandbox != z) {
            this.mReInitToRefreshSettings = true;
            this.mIsSandbox = z;
        }
        return this;
    }

    public HTTPClient setHappyEyeballsV4Preferred(boolean z) {
        this.mIsHappyEyeballsV4Preferred = z;
        return this;
    }

    public HTTPClient setNewConnectionTimeoutMillis(long j) {
        this.mNewConnTimeoutMillis = j;
        return this;
    }

    public HTTPClient setSessionWriteTimeoutMillis(long j) {
        this.mSessionWriteTimeoutMillis = j;
        return this;
    }

    public HTTPClient setTransactionIdleTimeoutMillis(long j) {
        this.mTransactionIdleTimeoutMillis = j;
        return this;
    }

    public HTTPClient setNetworkStatusMonitor(NetworkStatusMonitor networkStatusMonitor) {
        this.mNetworkStatusMonitor = networkStatusMonitor;
        return this;
    }

    public HTTPClient setAnalyticsLogger(AnalyticsLogger analyticsLogger, double d) {
        this.mAnalyticsLogger = analyticsLogger;
        this.mConnSampleRate = d;
        return this;
    }

    public HTTPClient setHTTP2Enabled(boolean z) {
        this.mIsHTTP2Enabled = z;
        return this;
    }

    public HTTPClient setTransportCallbackEnabled(boolean z) {
        this.mEnableTransportCallbacks = z;
        return this;
    }

    public HTTPClient setAdaptiveConfigInterval(int i) {
        this.mAdaptiveConfigInterval = i;
        return this;
    }

    public HTTPClient setAdaptiveConnTOParam(AdaptiveIntegerParameters adaptiveIntegerParameters) {
        this.mAdaptiveConnTOParam = adaptiveIntegerParameters;
        return this;
    }

    public HTTPClient setAdaptiveSessionTOParam(AdaptiveIntegerParameters adaptiveIntegerParameters) {
        this.mAdaptiveSessionTOParam = adaptiveIntegerParameters;
        return this;
    }

    public EventBase getEventBase() {
        return this.mEventBase;
    }

    public HTTPClient setCrossDomainTCPConnsEnabled(boolean z) {
        this.mCrossDomainTCPConnsEnabled = z;
        return this;
    }

    public HTTPClient setUpdateDNSAfterTCPReuse(boolean z) {
        this.mUpdateDNSAfterTCPReuse = z;
        return this;
    }

    public HTTPClient setUseZRRedirectFilter(boolean z) {
        this.mUseZRRedirectFilter = z;
        return this;
    }

    public HTTPClient setFlowControl(boolean z, int i, boolean z2) {
        this.mLargerFlowControlWindow = z;
        this.mFlowControlWindow = i;
        this.mFlowControlSelectedTxnsOnly = z2;
        return this;
    }

    public HTTPClient setMaxPriorityLevelForSession(int i) {
        this.mMaxPriorityLevelForSession = i;
        return this;
    }

    public HTTPClient setUseRequestWeight(boolean z) {
        this.mUseRequestWeight = z;
        return this;
    }

    public HTTPClient setAllowGradientWeight(boolean z) {
        this.mAllowGradientWeight = z;
        return this;
    }

    public HTTPClient setGradientWeights(String str) {
        this.mGradientWeights = str;
        return this;
    }

    public HTTPClient setLoadBalancing(boolean z) {
        this.mUseLoadBalancing = z;
        return this;
    }

    public void init() {
        callNativeInit(false);
    }

    public void reinit() {
        callNativeInit(true);
    }

    public synchronized void callNativeInit(boolean z) {
        init(this.mEventBase, z, this.mIsNetworkEventLogEnabled, this.mIsZlibFilterEnabled, this.mIsRetryFilterEnabled, this.mIsSSLSessionCacheEnabled, this.mHTTPSessionCacheType, this.mPreConnects, this.mActiveDomains, this.mMinDomainRefreshInterval, this.mIsPerDomainLimitEnabled, this.mMaxConnectionRetryCount, this.mMaxIdleHTTPSessions, this.mMaxIdleSPDYSessions, this.mDynamicLimitRatio, this.mIsPerDomainLimitEnabled2G, this.mMaxConnectionRetryCount2G, this.mMaxIdleHTTPSessions2G, this.mMaxIdleSPDYSessions2G, this.mIdleTimeoutForUsed, this.mIdleTimeoutForUnused, this.mBackupConnTimeout, this.mIsSchedulerEnabled, this.mSchedulerParam, this.mIsHTTPSEnforced, this.mIsSandbox, this.mProxyHost, this.mProxyPort, this.mProxyUsername, this.mProxyPassword, this.mSecureProxyHost, this.mSecureProxyPort, this.mSecureProxyUsername, this.mSecureProxyPassword, this.mBypassProxyDomains, this.mProxyFallbackEnabled, this.mPersistentSSLCacheSettings, this.mZeroProtocolSettings, this.mUserInstalledCertificates, this.mIsHappyEyeballsV4Preferred, this.mNewConnTimeoutMillis, this.mSessionWriteTimeoutMillis, this.mTransactionIdleTimeoutMillis, this.mDNSServers, this.mPersistentDNSCacheSettings, this.mDnsCacheEnabled, this.mCAresEnabled, this.mStaleAnswersEnabled, this.mDnsRequestsOutstanding, this.mNetworkStatusMonitor, this.mSendPingForTcpRetransmission, this.mMaxPingRetries, this.mPingTimeout, this.mPingRttThreshold, this.mAdaptivePing, this.mRewriteRules, this.mRewriteExemptions, this.mRedirectTargetWhitelist, this.mAnalyticsLogger, this.mConnSampleRate, this.mSocketBufferExperimentEnabled, this.mSocketSendBuffer, this.mIsHTTP2Enabled, this.mGatewayPingEnabled, this.mGatewayPingAddress, this.mGatewayPingIntervalMs, this.mUserAgent, this.mCrossDomainTCPConnsEnabled, this.mAdaptiveConfigInterval, this.mAdaptiveConnTOParam, this.mUseZRRedirectFilter, this.mUpdateDNSAfterTCPReuse, this.mLargerFlowControlWindow, this.mFlowControlWindow, this.mFlowControlSelectedTxnsOnly, this.mMaxPriorityLevelForSession, this.mUseRequestWeight, this.mAllowGradientWeight, this.mGradientWeights, this.mEnableCachingPushManager, this.mPushCallbacks, this.mUseLoadBalancing, this.mAdaptiveSessionTOParam);
        this.mInitialized = true;
        this.mReInitToRefreshSettings = false;
    }

    public void make(JniHandler jniHandler, NativeReadBuffer nativeReadBuffer, TraceEventContext traceEventContext) {
        int i = 0;
        if (this.mEnableTransportCallbacks) {
            i = jniHandler.getEnabledCallbackFlag();
        }
        make(jniHandler, nativeReadBuffer, traceEventContext.needPublishEvent(), traceEventContext, this.mCircularLogSinkEnabled, this.mNetworkStatusMonitor, i);
    }

    public void updateUrlRewriteRules(RewriteRule[] rewriteRuleArr) {
        if (!Arrays.equals(this.mRewriteRules, rewriteRuleArr)) {
            this.mRewriteRules = rewriteRuleArr;
            updateRewriteRules(rewriteRuleArr);
        }
    }

    public void close() {
        if (this.mInitialized && !this.mClosed) {
            close(this.mEventBase);
            this.mClosed = true;
        }
    }

    public void connect(String[] strArr) {
        if (this.mInitialized && !this.mClosed) {
            connect(this.mEventBase, strArr);
        }
    }

    protected void finalize() {
        try {
            close();
        } finally {
            super.finalize();
        }
    }
}
