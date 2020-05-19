package Perpustakaan;

public class MVCSignIn {

    ViewSignIn viewLogin = new ViewSignIn();
    ViewSignUp viewDaftar = new ViewSignUp();
    ModelSignIn modelLogin = new ModelSignIn();
    CSignIn contLogin = new CSignIn(viewLogin, viewDaftar, modelLogin);
}
