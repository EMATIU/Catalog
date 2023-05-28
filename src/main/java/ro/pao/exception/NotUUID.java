package ro.pao.exception;

public class NotUUID extends Exception{
    public NotUUID(String message) {
        super(message);
    }
}//Această excepție este utilizată pentru a semnala că o valoare nu este un UUID valid