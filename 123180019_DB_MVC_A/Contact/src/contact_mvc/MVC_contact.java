package contact_mvc;

public class MVC_contact {
    ViewMain viewmain = new ViewMain();
    ViewBuatCon viewbuat = new ViewBuatCon();
    ViewLihatCon viewlihat = new ViewLihatCon();
    ViewUpdateCon viewupdate = new ViewUpdateCon();
    Model model = new Model();
    Controller controller = new Controller(model, viewmain,viewbuat,viewlihat,viewupdate);
}
