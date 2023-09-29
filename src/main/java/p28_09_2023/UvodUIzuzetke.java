package p28_09_2023;

public class UvodUIzuzetke {
    public static void main(String[] args) {
//        driver.findElement()...

        FakeDriver driver = new FakeDriver();

        int p = 0;

        try {
            p = driver.findNextNumber(-5);
            System.out.println("TRY BLOK");
        } catch (Exception e) {
            System.out.println("Upali u catch");
        }

        System.out.println("FINALY");



        System.out.println("KRAJ");
        System.out.println(p);



    }

}
