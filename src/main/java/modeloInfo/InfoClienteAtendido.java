package modeloInfo;

public class InfoClienteAtendido implements Informable {
    private int dni;
    private int box;

    public int getBox() {
        return box;
    }

    public void setBox(int box) {
        this.box = box;
    }

    public InfoClienteAtendido(int dni, int box) {
        this.dni = dni;
        this.box = box;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    @Override
    public int getIdOperacion() {
        return 2;
    }

}