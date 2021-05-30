package modeloInfo;

public class InfoBoxDisponible implements Informable{
    private final int idOperacion = 1;
    private int box;

    @Override
    public int getIdOperacion() {
        return idOperacion;
    }

    public int getBox() {
        return box;
    }

    public void setBox(int box) {
        this.box = box;
    }
}
