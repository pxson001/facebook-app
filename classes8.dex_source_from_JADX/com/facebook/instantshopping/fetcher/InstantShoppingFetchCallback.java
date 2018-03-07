package com.facebook.instantshopping.fetcher;

import com.facebook.fbservice.ops.ResultFutureCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.graphql.executor.GraphQLResult;

/* compiled from: upload_photo_menu_upload_button_click */
public abstract class InstantShoppingFetchCallback<T> extends ResultFutureCallback<GraphQLResult<T>> {
    public abstract void mo23b(ServiceException serviceException);

    public abstract void mo24b(T t);

    protected final void m839a(Object obj) {
        mo24b(((GraphQLResult) obj).e);
    }

    protected final void m838a(ServiceException serviceException) {
        mo23b(serviceException);
    }
}
