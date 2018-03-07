package com.facebook.messaging.inbox2.sharing;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.messaging.inbox2.sharing.SuggestedUser.ShareState;
import com.facebook.messaging.send.common.SendResult;
import com.facebook.user.model.User;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mQrCode */
public class QuickShareSuggestionsAdapter extends Adapter<ViewHolder> {
    private final UserSelectionListener f11329a = new C12481(this);
    private final LayoutInflater f11330b;
    public ImmutableList<SuggestedUser> f11331c;
    public UserSelectionListener f11332d;

    /* compiled from: mQrCode */
    class C12481 implements UserSelectionListener {
        final /* synthetic */ QuickShareSuggestionsAdapter f11328a;

        C12481(QuickShareSuggestionsAdapter quickShareSuggestionsAdapter) {
            this.f11328a = quickShareSuggestionsAdapter;
        }

        public final void mo434a(final User user, FutureCallback<SendResult> futureCallback) {
            if (this.f11328a.f11332d != null) {
                this.f11328a.f11332d.mo434a(user, new FutureCallback<SendResult>(this) {
                    final /* synthetic */ C12481 f11327b;

                    public /* bridge */ /* synthetic */ void onSuccess(@Nullable Object obj) {
                    }

                    public void onFailure(Throwable th) {
                        QuickShareSuggestionsAdapter quickShareSuggestionsAdapter = this.f11327b.f11328a;
                        User user = user;
                        int i = 0;
                        while (i < quickShareSuggestionsAdapter.f11331c.size()) {
                            if (((SuggestedUser) quickShareSuggestionsAdapter.f11331c.get(i)).f11353a == user) {
                                break;
                            }
                            i++;
                        }
                        i = -1;
                        int i2 = i;
                        if (i2 != -1) {
                            SuggestedUser suggestedUser = (SuggestedUser) quickShareSuggestionsAdapter.f11331c.get(i2);
                            if (suggestedUser.f11354b == ShareState.SEND_CONFIRMED) {
                                suggestedUser.f11354b = ShareState.SEND_ERROR;
                                quickShareSuggestionsAdapter.j_(i2 + 1);
                            }
                        }
                    }
                });
            }
        }

        public final void mo433a() {
            if (this.f11328a.f11332d != null) {
                this.f11328a.f11332d.mo433a();
            }
        }
    }

    /* compiled from: mQrCode */
    class ViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder {
        public ViewHolder(View view) {
            super(view);
        }

        final QuickShareSuggestedUserView m11926w() {
            return (QuickShareSuggestedUserView) this.a;
        }
    }

    public final android.support.v7.widget.RecyclerView.ViewHolder m11927a(ViewGroup viewGroup, int i) {
        View inflate;
        switch (i) {
            case 1:
                inflate = this.f11330b.inflate(2130904870, viewGroup, false);
                break;
            case 2:
                inflate = this.f11330b.inflate(2130904872, viewGroup, false);
                break;
            case 3:
                inflate = this.f11330b.inflate(2130904868, viewGroup, false);
                break;
            default:
                throw new IllegalStateException();
        }
        return new ViewHolder(inflate);
    }

    public final void m11928a(android.support.v7.widget.RecyclerView.ViewHolder viewHolder) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        switch (viewHolder2.e) {
            case 2:
                viewHolder2.m11926w().m11921a();
                return;
            default:
                return;
        }
    }

    public final void m11929a(android.support.v7.widget.RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        switch (getItemViewType(i)) {
            case 1:
                ((QuickShareSearchView) viewHolder2.a).f11312c = this.f11329a;
                return;
            case 2:
                viewHolder2.m11926w().setUser((SuggestedUser) this.f11331c.get(i - 1));
                viewHolder2.m11926w().f11322h = this.f11329a;
                return;
            case 3:
                return;
            default:
                throw new IllegalStateException();
        }
    }

    @Inject
    public QuickShareSuggestionsAdapter(Context context) {
        this.f11330b = LayoutInflater.from(context);
    }

    public int getItemViewType(int i) {
        switch (i) {
            case 0:
                return 1;
            case 1:
                if (this.f11331c == null) {
                    return 3;
                }
                return 2;
            default:
                return 2;
        }
    }

    public final int aZ_() {
        return this.f11331c == null ? 2 : this.f11331c.size() + 1;
    }
}
