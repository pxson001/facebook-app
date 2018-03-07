package com.facebook.proxygen;

import javax.annotation.Nullable;

/* compiled from: ps_AF */
public class HTTPRequestError {
    public ProxygenError mErrCode;
    public String mErrMsg;
    private HTTPRequestStage mErrStage;

    /* compiled from: ps_AF */
    public enum HTTPRequestStage {
        ProcessRequest,
        DNSResolution,
        TCPConnection,
        TLSSetup,
        SendRequest,
        RecvResponse,
        Unknown,
        ZeroRttSent,
        Max
    }

    /* compiled from: ps_AF */
    public enum ProxygenError {
        None,
        Message,
        Connect,
        ConnectTimeout,
        Read,
        Write,
        Timeout,
        Handshake,
        NoServer,
        MaxRedirects,
        InvalidRedirect,
        ResponseAction,
        MaxConnects,
        Dropped,
        Connection,
        ConnectionReset,
        ParseHeader,
        ParseBody,
        EOF,
        ClientRenegotiation,
        Unknown,
        BadDecompress,
        SSL,
        StreamAbort,
        StreamUnacknowledged,
        WriteTimeout,
        AddressPrivate,
        AddressFamilyNotSupported,
        DNSNoResults,
        MalformedInput,
        UnsupportedExpectation,
        MethodNotSupported,
        UnsupportedScheme,
        Shutdown,
        IngressStateTransition,
        ClientSilent,
        Canceled,
        ParseResponse,
        ConnRefused,
        DNSOtherServer,
        DNSOtherClient,
        DNSOtherCancelled,
        DNSshutdown,
        DNSgetaddrinfo,
        DNSthreadpool,
        DNSunimplemented,
        Network,
        Max
    }

    public HTTPRequestError(String str, HTTPRequestStage hTTPRequestStage, ProxygenError proxygenError) {
        this.mErrMsg = str;
        this.mErrStage = hTTPRequestStage;
        this.mErrCode = proxygenError;
    }

    public String getErrMsg() {
        return this.mErrMsg;
    }

    @Nullable
    public HTTPRequestStage getErrStage() {
        return this.mErrStage;
    }

    @Nullable
    public ProxygenError getErrCode() {
        return this.mErrCode;
    }
}
