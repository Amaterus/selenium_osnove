package p28_09_2023;

import java.util.NoSuchElementException;

public class FakeDriver { // WebDriver driver


    public int findNextNumber(int n) throws ITBootcampException { // radi samo za pozitivne
        if (n < 0) {
            throw new ITBootcampException("Alo brate! Preterao si! Uneo si " + n );
        }


        return n + 1;
    }


}
