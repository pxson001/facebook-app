package com.facebook.richdocument.model.block.entity;

import android.content.Context;
import android.text.style.ClickableSpan;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectableComponentWithContext;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentTextModel.EntityRangesModel.EntityModel;
import javax.inject.Inject;

/* compiled from: picker_task_key */
public abstract class BaseEntity extends ClickableSpan implements InjectableComponentWithContext {
    public final EntityModel f5658a;
    @Inject
    public SecureContextHelper f5659b;
    private final Context f5660c;

    public static void m5455a(Object obj, Context context) {
        ((BaseEntity) obj).f5659b = (SecureContextHelper) DefaultSecureContextHelper.a(FbInjector.get(context));
    }

    public BaseEntity(EntityModel entityModel, Context context) {
        this.f5660c = context;
        this.f5658a = entityModel;
        Class cls = BaseEntity.class;
        m5455a(this, getContext());
    }

    public Context getContext() {
        return this.f5660c;
    }
}
