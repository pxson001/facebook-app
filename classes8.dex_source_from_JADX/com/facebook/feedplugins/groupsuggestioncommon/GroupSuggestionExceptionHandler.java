package com.facebook.feedplugins.groupsuggestioncommon;

import android.content.res.Resources;
import android.text.Html;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.error.GraphQLException;
import com.facebook.http.protocol.ApiErrorResult;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.errordialog.ErrorDialogParams;
import com.facebook.ui.errordialog.ErrorDialogParamsBuilder;
import com.facebook.ui.errordialog.ErrorDialogs;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import javax.inject.Inject;

/* compiled from: friendversary_card_data */
public class GroupSuggestionExceptionHandler {
    public final ErrorDialogs f12802a;
    public final Toaster f12803b;
    public final Resources f12804c;

    public static GroupSuggestionExceptionHandler m14584b(InjectorLike injectorLike) {
        return new GroupSuggestionExceptionHandler(ErrorDialogs.a(injectorLike), Toaster.b(injectorLike), ResourcesMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public GroupSuggestionExceptionHandler(ErrorDialogs errorDialogs, Toaster toaster, Resources resources) {
        this.f12802a = errorDialogs;
        this.f12803b = toaster;
        this.f12804c = resources;
    }

    public final void m14586a(Throwable th) {
        Object b = m14585b(th);
        if (StringUtil.a(b)) {
            this.f12803b.b(new ToastBuilder(2131230758));
            return;
        }
        ErrorDialogs errorDialogs = this.f12802a;
        ErrorDialogParamsBuilder a = ErrorDialogParams.a(this.f12804c);
        a.b = null;
        a = a;
        a.c = Html.fromHtml(b).toString();
        errorDialogs.a(a.l());
    }

    public static String m14585b(Throwable th) {
        if (!(th instanceof GraphQLException)) {
            return null;
        }
        ApiErrorResult apiErrorResult = ((GraphQLException) th).error;
        if (apiErrorResult != null) {
            return apiErrorResult.c();
        }
        return null;
    }
}
