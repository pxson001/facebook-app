package com.facebook.http.protocol;

import android.os.Parcelable;
import com.facebook.fbservice.results.ExceptionWithExtraData;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.annotation.Nullable;

/* compiled from: input_indicator */
public class ApiException extends IOException implements ExceptionWithExtraData {
    private ApiErrorResult result;

    public /* synthetic */ Parcelable mo800a() {
        return m10826b();
    }

    public ApiException(ApiErrorResult apiErrorResult) {
        super("[code] " + apiErrorResult.m10832a() + " [message]: " + apiErrorResult.m10834c() + " [extra]: " + apiErrorResult.m10835d());
        this.result = apiErrorResult;
    }

    public ApiErrorResult m10826b() {
        return this.result;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeObject(this.result);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        this.result = (ApiErrorResult) objectInputStream.readObject();
    }

    @Nullable
    public final String m10827c() {
        return this.result.mErrorUserTitle;
    }

    @Nullable
    public final String m10828d() {
        return this.result.mErrorUserMessage;
    }
}
