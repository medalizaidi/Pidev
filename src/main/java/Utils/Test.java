package Utils;

import java.sql.Connection;

public class Test {

    public static void main(String[] args) {
        DataSource dat1=DataSource.getInstance();
        DataSource dat2=DataSource.getInstance();

        System.out.println(dat1);
        System.out.println(dat2);

        Connection con1=DataSource.getInstance().getCon();

        Connection con2=DataSource.getInstance().getCon();

        System.out.println(con1);
        System.out.println(con2);
    }
}
