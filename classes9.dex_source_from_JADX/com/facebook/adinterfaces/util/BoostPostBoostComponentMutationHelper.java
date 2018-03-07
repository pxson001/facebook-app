package com.facebook.adinterfaces.util;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.facebook.adinterfaces.AdInterfacesContext;
import com.facebook.adinterfaces.model.AdInterfacesStatus;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostPostDataModel;
import com.facebook.adinterfaces.protocol.CreateBoostedComponentMethod;
import com.facebook.adinterfaces.protocol.DeleteBoostedComponentMethod;
import com.facebook.adinterfaces.protocol.EditBoostedComponentMethod;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import javax.inject.Inject;

@ContextScoped
/* compiled from: UnitPositionKey */
public class BoostPostBoostComponentMutationHelper implements BoostMutationHelper<AdInterfacesBoostPostDataModel> {
    private static BoostPostBoostComponentMutationHelper f23290d;
    private static final Object f23291e = new Object();
    public final DeleteBoostedComponentMethod f23292a;
    public final EditBoostedComponentMethod f23293b;
    public final CreateBoostedComponentMethod f23294c;

    /* compiled from: UnitPositionKey */
    public class C27676 implements OnClickListener {
        final /* synthetic */ AdInterfacesBoostPostDataModel f23286a;
        final /* synthetic */ View f23287b;
        final /* synthetic */ BoostPostBoostComponentMutationHelper f23288c;

        public C27676(BoostPostBoostComponentMutationHelper boostPostBoostComponentMutationHelper, AdInterfacesBoostPostDataModel adInterfacesBoostPostDataModel, View view) {
            this.f23288c = boostPostBoostComponentMutationHelper;
            this.f23286a = adInterfacesBoostPostDataModel;
            this.f23287b = view;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f23288c.f23292a.m24065a(BoostPostBoostComponentModelConversionUtil.m25253a(this.f23286a), this.f23287b.getContext());
        }
    }

    /* compiled from: UnitPositionKey */
    public class C27687 implements OnClickListener {
        final /* synthetic */ BoostPostBoostComponentMutationHelper f23289a;

        public C27687(BoostPostBoostComponentMutationHelper boostPostBoostComponentMutationHelper) {
            this.f23289a = boostPostBoostComponentMutationHelper;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    private static BoostPostBoostComponentMutationHelper m25255b(InjectorLike injectorLike) {
        return new BoostPostBoostComponentMutationHelper(DeleteBoostedComponentMethod.m24062a(injectorLike), EditBoostedComponentMethod.m24067a(injectorLike), CreateBoostedComponentMethod.m24054a(injectorLike));
    }

    @Inject
    public BoostPostBoostComponentMutationHelper(DeleteBoostedComponentMethod deleteBoostedComponentMethod, EditBoostedComponentMethod editBoostedComponentMethod, CreateBoostedComponentMethod createBoostedComponentMethod) {
        this.f23292a = deleteBoostedComponentMethod;
        this.f23293b = editBoostedComponentMethod;
        this.f23294c = createBoostedComponentMethod;
    }

    public final View.OnClickListener mo1052d(Context context, final AdInterfacesContext adInterfacesContext, final AdInterfacesBoostPostDataModel adInterfacesBoostPostDataModel) {
        return new View.OnClickListener(this) {
            final /* synthetic */ BoostPostBoostComponentMutationHelper f23277c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1312286940);
                this.f23277c.f23294c.m24057a(adInterfacesContext, BoostPostBoostComponentModelConversionUtil.m25253a(adInterfacesBoostPostDataModel), view.getContext());
                Logger.a(2, EntryType.UI_INPUT_END, 100090100, a);
            }
        };
    }

    public final View.OnClickListener mo1049a(AdInterfacesContext adInterfacesContext, final AdInterfacesBoostPostDataModel adInterfacesBoostPostDataModel) {
        return new View.OnClickListener(this) {
            final /* synthetic */ BoostPostBoostComponentMutationHelper f23279b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1301138081);
                BoostPostBoostComponentMutationHelper boostPostBoostComponentMutationHelper = this.f23279b;
                AdInterfacesBoostPostDataModel adInterfacesBoostPostDataModel = adInterfacesBoostPostDataModel;
                FbAlertDialogBuilder fbAlertDialogBuilder = new FbAlertDialogBuilder(view.getContext());
                fbAlertDialogBuilder.a(2131233998);
                fbAlertDialogBuilder.b(2131233999);
                fbAlertDialogBuilder.a(2131233989, new C27676(boostPostBoostComponentMutationHelper, adInterfacesBoostPostDataModel, view));
                fbAlertDialogBuilder.b(2131233976, new C27687(boostPostBoostComponentMutationHelper));
                fbAlertDialogBuilder.a().show();
                Logger.a(2, EntryType.UI_INPUT_END, 2053562348, a);
            }
        };
    }

    public static BoostPostBoostComponentMutationHelper m25254a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            BoostPostBoostComponentMutationHelper b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23291e) {
                BoostPostBoostComponentMutationHelper boostPostBoostComponentMutationHelper;
                if (a2 != null) {
                    boostPostBoostComponentMutationHelper = (BoostPostBoostComponentMutationHelper) a2.a(f23291e);
                } else {
                    boostPostBoostComponentMutationHelper = f23290d;
                }
                if (boostPostBoostComponentMutationHelper == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m25255b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23291e, b3);
                        } else {
                            f23290d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = boostPostBoostComponentMutationHelper;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final View.OnClickListener mo1051c(Context context, AdInterfacesContext adInterfacesContext, final AdInterfacesBoostPostDataModel adInterfacesBoostPostDataModel) {
        return new View.OnClickListener(this) {
            final /* synthetic */ BoostPostBoostComponentMutationHelper f23281b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -61493253);
                this.f23281b.f23293b.m24070a(BoostPostBoostComponentModelConversionUtil.m25253a(adInterfacesBoostPostDataModel), view.getContext());
                Logger.a(2, EntryType.UI_INPUT_END, -2012151469, a);
            }
        };
    }

    public final View.OnClickListener mo1050b(Context context, AdInterfacesContext adInterfacesContext, final AdInterfacesBoostPostDataModel adInterfacesBoostPostDataModel) {
        return new View.OnClickListener(this) {
            final /* synthetic */ BoostPostBoostComponentMutationHelper f23283b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 215905535);
                adInterfacesBoostPostDataModel.f21748d = AdInterfacesStatus.ACTIVE;
                this.f23283b.f23293b.m24070a(BoostPostBoostComponentModelConversionUtil.m25253a(adInterfacesBoostPostDataModel), view.getContext());
                Logger.a(2, EntryType.UI_INPUT_END, 61752320, a);
            }
        };
    }

    public final View.OnClickListener mo1048a(Context context, AdInterfacesContext adInterfacesContext, final AdInterfacesBoostPostDataModel adInterfacesBoostPostDataModel) {
        return new View.OnClickListener(this) {
            final /* synthetic */ BoostPostBoostComponentMutationHelper f23285b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1640232510);
                adInterfacesBoostPostDataModel.f21748d = AdInterfacesStatus.PAUSED;
                this.f23285b.f23293b.m24070a(BoostPostBoostComponentModelConversionUtil.m25253a(adInterfacesBoostPostDataModel), view.getContext());
                Logger.a(2, EntryType.UI_INPUT_END, 1701032112, a);
            }
        };
    }
}
