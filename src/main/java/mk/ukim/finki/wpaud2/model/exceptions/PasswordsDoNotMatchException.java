package mk.ukim.finki.wpaud2.model.exceptions;

public class PasswordsDoNotMatchException extends RuntimeException{
    public PasswordsDoNotMatchException()
    {
        super("Passwords do not match");
    }
}
