package com.facebook.video.downloadmanager;

/* compiled from: contactType */
public class DownloadException extends Exception {
    public final ExceptionCode mExceptionCode;

    /* compiled from: contactType */
    public enum ExceptionCode {
        INSUFFICIENT_SPACE_INTERNAL,
        INSUFFICIENT_SPACE_DEVICE,
        DOWNLOAD_ABORTED
    }

    public DownloadException(String str, ExceptionCode exceptionCode) {
        super(str);
        this.mExceptionCode = exceptionCode;
    }
}
