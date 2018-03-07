package com.facebook.messaging.xma;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.util.FindViewUtil;
import com.facebook.messaging.graphql.threads.ThreadQueriesInterfaces.XMA;
import com.facebook.messaging.graphql.threads.ThreadQueriesInterfaces.XMAAttachmentStoryFields.Subattachments;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.XMAAttachmentStoryFieldsModel.SubattachmentsModel;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.XMAModel;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;

/* compiled from: title_style */
public abstract class SimpleStyleRenderer<VH extends ViewHolder> {
    private final List<VH> f1556a = Lists.a();
    private final Map<View, VH> f1557b = Maps.c();

    /* compiled from: title_style */
    public class ViewHolder {
        public final View f1555a;

        public ViewHolder(View view) {
            this.f1555a = view;
        }

        protected final <T extends View> T m1728a(int i) {
            return FindViewUtil.b(this.f1555a, i);
        }
    }

    protected abstract void m1734a(VH vh, XMA xma);

    protected abstract VH m1735b(ViewGroup viewGroup);

    public final View m1730a(ViewGroup viewGroup, XMAModel xMAModel) {
        ViewHolder b = this.f1556a.isEmpty() ? m1735b(viewGroup) : (ViewHolder) this.f1556a.remove(0);
        m1734a(b, xMAModel);
        this.f1557b.put(b.f1555a, b);
        return b.f1555a;
    }

    public final View m1729a(ViewGroup viewGroup) {
        ViewHolder b = this.f1556a.isEmpty() ? m1735b(viewGroup) : (ViewHolder) this.f1556a.remove(0);
        this.f1557b.put(b.f1555a, b);
        return b.f1555a;
    }

    public final void m1732a(View view, SubattachmentsModel subattachmentsModel) {
        ViewHolder viewHolder = (ViewHolder) this.f1557b.get(view);
        Preconditions.checkNotNull(viewHolder);
        m1733a(viewHolder, subattachmentsModel);
    }

    public final void m1731a(View view) {
        this.f1556a.add((ViewHolder) Preconditions.checkNotNull(this.f1557b.remove(view), "Tried to return a view that was not lent out by this StyleRenderer"));
    }

    protected void m1733a(VH vh, Subattachments subattachments) {
    }
}
