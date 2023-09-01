package be.technifutur.spring.demo.exceptions;

public class InscriptionCloseException extends RuntimeException{
    public InscriptionCloseException() {
        super("Inscription closed");
    }

    public InscriptionCloseException(String message) {
        super(message);
    }
}
