package modeloInfo;

public class FactoryInfoClienteAtendido {
    public static InfoClienteAtendido getInfoClienteAtendido(int dni, int box){
        return new InfoClienteAtendido(dni,box);
    }
}
