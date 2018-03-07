package com.facebook.messaging.sms.defaultapp;

import android.content.Context;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.send.SendError;
import com.facebook.messaging.model.send.SendErrorBuilder;
import com.facebook.messaging.model.send.SendErrorType;
import com.facebook.messaging.sms.common.Constants.MmsSmsErrorType;
import com.google.common.base.Preconditions;
import javax.inject.Inject;

/* compiled from: com.google.android.gms.auth.GOOGLE_SIGN_IN */
public class MmsSmsErrorHelper {
    private Context f17548a;

    public static MmsSmsErrorHelper m17537b(InjectorLike injectorLike) {
        return new MmsSmsErrorHelper((Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public MmsSmsErrorHelper(Context context) {
        this.f17548a = context;
    }

    public static MmsSmsErrorType m17534a(int i) {
        switch (i) {
            case -1:
                return MmsSmsErrorType.NO_ERROR;
            case 2:
                return MmsSmsErrorType.NO_CONNECTION;
            case 3:
                return MmsSmsErrorType.CONFIG_ERROR;
            case 4:
                return MmsSmsErrorType.CONNECTION_ERROR;
            default:
                return MmsSmsErrorType.GENERIC;
        }
    }

    public static MmsSmsErrorType m17536b(int i) {
        switch (i) {
            case -1:
                return MmsSmsErrorType.NO_ERROR;
            case 2:
                return MmsSmsErrorType.APN_FAILURE;
            case 3:
                return MmsSmsErrorType.CONNECTION_ERROR;
            case 4:
                return MmsSmsErrorType.SERVER_ERROR;
            case 5:
                return MmsSmsErrorType.IO_ERROR;
            case 7:
                return MmsSmsErrorType.CONFIG_ERROR;
            case 100:
                return MmsSmsErrorType.PROCESSING_ERROR;
            default:
                return MmsSmsErrorType.GENERIC;
        }
    }

    public static String m17535a(int i, int i2) {
        return "sms:" + i + (i2 == 0 ? "" : " errorCode:" + i2);
    }

    public static String m17538b(int i, int i2) {
        return "mms:" + i + (i2 == 0 ? "" : " http:" + i2);
    }

    public final SendError m17539a(MmsSmsErrorType mmsSmsErrorType) {
        Preconditions.checkArgument(mmsSmsErrorType != MmsSmsErrorType.NO_ERROR);
        SendErrorBuilder newBuilder = SendError.newBuilder();
        newBuilder.e = mmsSmsErrorType.ordinal();
        newBuilder = newBuilder;
        newBuilder.a = SendErrorType.SMS_SEND_FAILED;
        newBuilder = newBuilder;
        switch (mmsSmsErrorType) {
            case CONNECTION_ERROR:
                newBuilder.b = this.f17548a.getString(2131232374);
                break;
            case NO_CONNECTION:
                newBuilder.b = this.f17548a.getString(2131232373);
                break;
        }
        return newBuilder.f();
    }

    public final SendError m17540b(MmsSmsErrorType mmsSmsErrorType) {
        Preconditions.checkArgument(mmsSmsErrorType != MmsSmsErrorType.NO_ERROR);
        SendErrorBuilder newBuilder = SendError.newBuilder();
        newBuilder.e = mmsSmsErrorType.ordinal();
        newBuilder = newBuilder;
        newBuilder.a = SendErrorType.SMS_SEND_FAILED;
        newBuilder = newBuilder;
        switch (mmsSmsErrorType) {
            case CONNECTION_ERROR:
            case SERVER_ERROR:
                newBuilder.b = this.f17548a.getString(2131232375);
                break;
            case NO_CONNECTION:
                newBuilder.b = this.f17548a.getString(2131232376);
                break;
            case OVERSIZE:
                newBuilder.b = this.f17548a.getString(2131232377);
                break;
        }
        return newBuilder.f();
    }
}
