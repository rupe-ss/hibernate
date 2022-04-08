package jdbc;

import java.sql.DriverManager;

/*
We created this class to understand Class.forName()
Static block loads when creating a class not object.
 */
class DriverClassName{
    static{
        System.out.println("Loading static block.");
    }

    {
        System.out.println("In instance.");
    }
}

public class ClassForName {
    public static void main(String[] args) throws Exception {
        //DriverClassName driver = new DriverClassName();
        //This will load the static block first and instance block second.
        //We can load the static block using Class.forName() method

        /*//Below line of code will load the static block, we use Class.forName() method to lod a class.
        Class.forName("jdbc.DriverClassName");*/

        //Below line of code will load the instance block, when you do .newInstance it will create an Object.
        Class.forName("jdbc.DriverClassName").newInstance();

        //How we load a driver ? There is DriverManager with registerDriver() method.
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

        //Instead of doing above we can use below code, because it load the static block of class.
        Class.forName("com.mysql.cj.jdbc.Driver");
    }
}
