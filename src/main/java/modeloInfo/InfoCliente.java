package modeloInfo;

public class InfoCliente implements Informable {
    private final int idOperacion = 1;
    private int dni;

    public InfoCliente(int dni){
        this.dni=dni;
    }

    @Override
    public int getIdOperacion() {
        return idOperacion;
    }

    public int getDni() {
        return dni;
    }
}
