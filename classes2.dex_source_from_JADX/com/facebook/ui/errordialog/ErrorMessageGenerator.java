package com.facebook.ui.errordialog;

import android.content.Context;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.http.protocol.ApiErrorResult;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import javax.inject.Inject;

/* compiled from: plugged */
public class ErrorMessageGenerator {
    public static final String f9530a = ErrorMessageGenerator.class.getSimpleName();
    public final Context f9531b;
    public final AbstractFbErrorReporter f9532c;

    public static ErrorMessageGenerator m14518b(InjectorLike injectorLike) {
        return new ErrorMessageGenerator((Context) injectorLike.getInstance(Context.class), FbErrorReporterImpl.m2317a(injectorLike));
    }

    @Inject
    public ErrorMessageGenerator(Context context, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f9531b = context;
        this.f9532c = abstractFbErrorReporter;
    }

    public static ApiErrorResult m14519c(ServiceException serviceException) {
        boolean z;
        if (serviceException.errorCode == ErrorCode.API_ERROR) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "Non-API error code: " + serviceException.errorCode);
        return (ApiErrorResult) serviceException.result.m30133k();
    }

    public static ErrorMessageGenerator m14516a(InjectorLike injectorLike) {
        return m14518b(injectorLike);
    }

    public final String m14520a(ServiceException serviceException, boolean z, boolean z2) {
        String str = null;
        ErrorCode errorCode = serviceException.errorCode;
        if (errorCode == ErrorCode.API_ERROR) {
            ApiErrorResult c = m14519c(serviceException);
            boolean a = m14517a(c);
            if (z && !a) {
                String str2;
                int a2 = c.a();
                int a3 = m14515a(a2, -1);
                if (a3 == -1) {
                    this.f9532c.m2340a(f9530a, "No error message for error code " + a2);
                    str2 = null;
                } else {
                    str2 = this.f9531b.getString(a3);
                }
                str = str2;
            }
            if (str == null) {
                str = c.c();
            }
        } else if (errorCode == ErrorCode.CONNECTION_FAILURE) {
            str = this.f9531b.getResources().getString(2131230759);
        }
        if (str == null && z2) {
            return this.f9531b.getString(2131230758);
        }
        return str;
    }

    public final boolean m14521b(ServiceException serviceException) {
        if (serviceException.errorCode != ErrorCode.API_ERROR) {
            return false;
        }
        ApiErrorResult apiErrorResult = (ApiErrorResult) serviceException.result.m30133k();
        if (apiErrorResult == null || !m14517a(apiErrorResult)) {
            return false;
        }
        return true;
    }

    private static boolean m14517a(ApiErrorResult apiErrorResult) {
        return apiErrorResult.a() == 368 && !Strings.isNullOrEmpty(apiErrorResult.c());
    }

    public static int m14515a(int i, int i2) {
        switch (i) {
            case 100:
                return 2131230795;
            case 200:
                return 2131230796;
            case 321:
                return 2131230770;
            case 332:
                return 2131230771;
            case 368:
                return 2131230783;
            case 506:
                return 2131230772;
            case 520:
                return 2131230787;
            case 521:
                return 2131230788;
            case 522:
                return 2131230789;
            case 523:
                return 2131230790;
            case 524:
                return 2131230788;
            case 525:
                return 2131230790;
            case 526:
                return 2131230791;
            case 527:
                return 2131230792;
            case 528:
                return 2131230793;
            case 529:
                return 2131230788;
            case 530:
                return 2131230790;
            case 531:
                return 2131230790;
            case 532:
                return 2131230788;
            case 533:
                return 2131230788;
            case 535:
                return 2131230790;
            case 536:
                return 2131230794;
            case 803:
                return 2131230762;
            case 1610007:
                return 2131230786;
            default:
                return i2;
        }
    }
}
