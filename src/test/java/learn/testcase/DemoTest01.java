package learn.testcase;

import com.google.gson.JsonObject;
import org.testng.annotations.Test;


public class DemoTest01 {
    private static final long DAY = 1000L * 60 * 60 * 24;

    @Test
    public void login() {

        System.out.println(System.currentTimeMillis() + DAY * 0);
        System.out.println(System.currentTimeMillis() + DAY * 1);
        System.out.println(System.currentTimeMillis() + DAY * 2);



        JsonObject object=new JsonObject();
        object.addProperty("key1","value1");
        object.addProperty("key2","value2");
        object.addProperty("key3","value3");
            JsonObject obj2=new JsonObject();
            obj2.addProperty("subKey1","value1");
            obj2.addProperty("subKey1","value1");
        object.addProperty("key4","obj2");



    }
}
