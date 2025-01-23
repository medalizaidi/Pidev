package Test;

import Entite.Personne;
import Service.ServicePersonne;
import TestSingleton.A;
import TestSingleton.B;

import java.sql.SQLException;

public class Test {

    public static void main(String[] args) {
        A a1 = new A();

        A a2 = new A();

        B b1 = B.getInstance();

        B b2 = B.getInstance();

        System.out.println(a1);
        System.out.println(a2);
        System.out.println(b1);
        System.out.println(b2);


        ServicePersonne ser=new ServicePersonne();

        Personne p1=new Personne("nom1","prenom1",13);

        try {
            ser.ajouter(p1);
            System.out.println("personne ajoutée");
        } catch (SQLException e) {
            System.out.println(e);
        }

        try {
            ser.getAll().forEach(e-> System.out.println(e));
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
