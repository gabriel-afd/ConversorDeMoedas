import Exceps.ExceptionPersonalizado;

public class Principal {
    public static void main(String[] args) {
        ConversorMoedas conversor = new ConversorMoedas();

        try {
            conversor.executar();
        }catch (ExceptionPersonalizado e){
            System.out.println(e.getMessage());
        }



    }
}
