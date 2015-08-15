import crud.crud;
import gui.GUIWindow;

public class test {
    public static void main(String[] args)  {

        GUIWindow guiWindow = new GUIWindow();
        guiWindow.mainFraime();

        crud.createDb();
        crud.updateDb();
        crud.deleteFromDb();
        crud.readFromDB();




    }
}
