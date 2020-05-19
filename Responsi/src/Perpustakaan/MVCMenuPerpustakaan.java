package Perpustakaan;

public class MVCMenuPerpustakaan {

    ViewHome viewHome = new ViewHome();
    ViewPinjam viewPinjam = new ViewPinjam();
    ViewTampil viewTampil = new ViewTampil();
    ViewAboutUs viewAbout = new ViewAboutUs();
    ViewEdit viewEdit = new ViewEdit();
    ModelMenuPerpustakaan modelMenu = new ModelMenuPerpustakaan();
    CMenuPerpustakaan contMenu = new CMenuPerpustakaan(viewHome, viewPinjam, viewTampil, viewAbout, viewEdit, modelMenu);
}
