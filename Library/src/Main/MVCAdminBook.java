package Main;

import Controller.ControllerAdminBook;
import Model.ModelAdminBook;
import View.ViewAdminBook;

public class MVCAdminBook {
    public ViewAdminBook viewAdminBook = new ViewAdminBook();
    public ModelAdminBook modelAdminBook = new ModelAdminBook();
    public ControllerAdminBook controllerAdminBook = new ControllerAdminBook(viewAdminBook, modelAdminBook);
}