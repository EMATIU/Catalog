package ro.pao.exception;

public class WhosThisStudent extends Exception{
    public WhosThisStudent(String nume, String prenume){
        super("Studentul cu numele introdus nu se afla in aceasta clasa!");
    }
}
