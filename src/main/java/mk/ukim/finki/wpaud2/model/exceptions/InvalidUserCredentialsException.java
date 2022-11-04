package mk.ukim.finki.wpaud2.model.exceptions;

public class InvalidUserCredentialsException extends RuntimeException{
    public InvalidUserCredentialsException()
    {
        super("Invalid user credentials!");
    }
}
