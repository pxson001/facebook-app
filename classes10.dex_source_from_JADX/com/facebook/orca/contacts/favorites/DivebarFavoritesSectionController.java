package com.facebook.orca.contacts.favorites;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.contacts.picker.ContactPickerRow;
import com.facebook.contacts.picker.ContactPickerSectionSplitterRow;
import com.facebook.contacts.picker.ContactPickerUserRow.ContactRowSectionType;
import com.facebook.contacts.picker.FavoritesSectionHeaderRow;
import com.facebook.divebar.DivebarController.DivebarAnimationListener;
import com.facebook.divebar.DivebarController.DivebarState;
import com.facebook.divebar.DrawerBasedDivebarControllerImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.orca.contacts.divebar.SectionFragmentDrawerController;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.user.model.User;
import com.facebook.user.model.UserKey;
import com.google.common.collect.ImmutableList.Builder;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: onFetchThreadSucceededWithThreadSummary */
public class DivebarFavoritesSectionController {
    private static final Class<?> f5965a = DivebarFavoritesSectionController.class;
    private final Context f5966b;
    public final DrawerBasedDivebarControllerImpl f5967c;
    public final SectionFragmentDrawerController f5968d = new SectionFragmentDrawerController();

    /* compiled from: onFetchThreadSucceededWithThreadSummary */
    class C08871 implements OnClickListener {
        final /* synthetic */ DivebarFavoritesSectionController f5958a;

        C08871(DivebarFavoritesSectionController divebarFavoritesSectionController) {
            this.f5958a = divebarFavoritesSectionController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1917772876);
            DivebarFavoritesSectionController divebarFavoritesSectionController = this.f5958a;
            DivebarEditFavoritesFragment divebarEditFavoritesFragment = (DivebarEditFavoritesFragment) divebarFavoritesSectionController.f5968d.m5563a(DivebarEditFavoritesFragment.class, "editFavorites");
            if (divebarEditFavoritesFragment != null) {
                divebarFavoritesSectionController.f5967c.k = new C08882(divebarFavoritesSectionController, divebarEditFavoritesFragment);
            }
            Logger.a(2, EntryType.UI_INPUT_END, 1008981568, a);
        }
    }

    /* compiled from: onFetchThreadSucceededWithThreadSummary */
    public class C08882 implements DivebarAnimationListener {
        final /* synthetic */ DivebarEditFavoritesFragment f5959a;
        final /* synthetic */ DivebarFavoritesSectionController f5960b;

        public C08882(DivebarFavoritesSectionController divebarFavoritesSectionController, DivebarEditFavoritesFragment divebarEditFavoritesFragment) {
            this.f5960b = divebarFavoritesSectionController;
            this.f5959a = divebarEditFavoritesFragment;
        }

        public final void m5621a(DivebarState divebarState) {
            if (!this.f5959a.mx_() || !divebarState.equals(DivebarState.OPENED)) {
                return;
            }
            if (this.f5959a.am) {
                DivebarFavoritesSectionController divebarFavoritesSectionController = this.f5960b;
                DivebarEditFavoritesFragment divebarEditFavoritesFragment = this.f5959a;
                new FbAlertDialogBuilder(divebarEditFavoritesFragment.getContext()).b(2131231012).a(2131231013, new C08904(divebarFavoritesSectionController, divebarEditFavoritesFragment)).b(2131231014, new C08893(divebarFavoritesSectionController, divebarEditFavoritesFragment)).b();
                return;
            }
            this.f5959a.av();
        }

        public final void m5622b(DivebarState divebarState) {
        }
    }

    /* compiled from: onFetchThreadSucceededWithThreadSummary */
    public class C08893 implements DialogInterface.OnClickListener {
        final /* synthetic */ DivebarEditFavoritesFragment f5961a;
        final /* synthetic */ DivebarFavoritesSectionController f5962b;

        public C08893(DivebarFavoritesSectionController divebarFavoritesSectionController, DivebarEditFavoritesFragment divebarEditFavoritesFragment) {
            this.f5962b = divebarFavoritesSectionController;
            this.f5961a = divebarEditFavoritesFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f5961a.av();
        }
    }

    /* compiled from: onFetchThreadSucceededWithThreadSummary */
    public class C08904 implements DialogInterface.OnClickListener {
        final /* synthetic */ DivebarEditFavoritesFragment f5963a;
        final /* synthetic */ DivebarFavoritesSectionController f5964b;

        public C08904(DivebarFavoritesSectionController divebarFavoritesSectionController, DivebarEditFavoritesFragment divebarEditFavoritesFragment) {
            this.f5964b = divebarFavoritesSectionController;
            this.f5963a = divebarEditFavoritesFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f5963a.at();
        }
    }

    public static DivebarFavoritesSectionController m5624a(InjectorLike injectorLike) {
        return new DivebarFavoritesSectionController((Context) injectorLike.getInstance(Context.class), DrawerBasedDivebarControllerImpl.a(injectorLike));
    }

    @Inject
    public DivebarFavoritesSectionController(Context context, DrawerBasedDivebarControllerImpl drawerBasedDivebarControllerImpl) {
        this.f5966b = context;
        this.f5967c = drawerBasedDivebarControllerImpl;
    }

    private FavoritesSectionHeaderRow m5623a() {
        Resources resources = this.f5966b.getResources();
        return new FavoritesSectionHeaderRow(resources.getString(2131231215), resources.getString(2131231209), new C08871(this), null);
    }

    public final void m5625a(Builder<ContactPickerRow> builder, RowCreator rowCreator, List<User> list, List<User> list2, Set<UserKey> set) {
        int i = (list == null || list.isEmpty()) ? 0 : 1;
        int i2;
        if (list2.isEmpty()) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        if (!(i == 0 && r3 == 0)) {
            builder.c(m5623a());
            if (list != null) {
                for (User user : list) {
                    builder.c(rowCreator.m5490a(user, ContactRowSectionType.FAVORITES));
                    set.add(user.T);
                }
            }
        }
        if (!(i == 0 || r3 == 0)) {
            builder.c(new ContactPickerSectionSplitterRow());
        }
        for (User user2 : list2.subList(0, Math.min(15, list2.size()))) {
            if (!set.contains(user2.T)) {
                builder.c(rowCreator.m5490a(user2, ContactRowSectionType.TOP_FRIENDS));
                set.add(user2.T);
            }
        }
    }
}
