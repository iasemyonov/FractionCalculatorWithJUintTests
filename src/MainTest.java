import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MainTest {
    @Test

    public void count1() {
        String stri = "1/2 + 1/3";
        String stro = "";
        System.out.println("Input: "+stri);
        stro = Main.prepear(stri);
        System.out.println(stro);
        assertEquals("Answer: 5/6",stro);
    }
    @Test
    public void count2() {
        String stri = "1/2 - 1/3";
        String stro = "";
        System.out.println("Input: "+stri);
        stro = Main.prepear(stri);
        System.out.println(stro);
        assertEquals("Answer: 1/6",stro);
    }
    @Test
    public void count3() {
        String stri = "1/2 * 1/3";
        String stro = "";
        System.out.println("Input: "+stri);
        stro = Main.prepear(stri);
        System.out.println(stro);
        assertEquals("Answer: 1/6",stro);
    }
    @Test
    public void count4() {
        String stri = "1/2 : 1/3";
        String stro = "";
        System.out.println("Input: "+stri);
        stro = Main.prepear(stri);
        System.out.println(stro);
        assertEquals("Answer: 3/2",stro);
    }
    @Test
    public void count5() {
        String stri = "1/2 + 1/3 * 3/4";
        String stro = "";
        System.out.println("Input: "+stri);
        stro = Main.prepear(stri);
        System.out.println(stro);
        assertEquals("Answer: 3/4",stro);
    }
    @Test
    public void count6() {
        String stri = "-1/-3 * 3/4 - 1/2";
        String stro = "";
        System.out.println("Input: "+stri);
        stro = Main.prepear(stri);
        System.out.println(stro);
        assertEquals("Answer: -1/4",stro);
    }
    @Test
    public void count7() {
        String stri = "1/2 + 1/3 + 1/6";
        String stro = "";
        System.out.println("Input: "+stri);
        stro = Main.prepear(stri);
        System.out.println(stro);
        assertEquals("Answer: 1/1",stro);
    }
    @Test
    public void count8() {
        String stri = "-1/0 * 3/4 - 1/2";
        String stro = "";
        System.out.println("Input: "+stri);
        stro = Main.prepear(stri);
        System.out.println(stro);
        assertEquals("Division by zero",stro);
    }
    @Test
    public void count9() {
        String stri = "--1/3 * 3/4 - 1/2 * 2/1";
        String stro = "";
        System.out.println("Input: "+stri);
        stro = Main.prepear(stri);
        System.out.println(stro);
        assertEquals("Incorrect input",stro);
    }
    @Test
    public void count10() {
        String stri = "(-1/3 * 3/4 - 1/2) * 2/1 + 5/2";
        String stro = "";
        System.out.println("Input: "+stri);
        stro = Main.prepear(stri);
        System.out.println(stro);
        assertEquals("Answer: 1/1",stro);
    }
    @Test
    public void count11() {
        String stri = "(-1/3 * 3/4 - 1/2) * 2/1";
        String stro = "";
        System.out.println("Input: "+stri);
        stro = Main.prepear(stri);
        System.out.println(stro);
        assertEquals("Answer: -3/2",stro);
    }
    @Test
    public void count12() {
        String stri = "(((-1/3 * 3/4 - 1/2) * 2/1))";
        String stro = "";
        System.out.println("Input: "+stri);
        stro = Main.prepear(stri);
        System.out.println(stro);
        assertEquals("Answer: -3/2",stro);
    }
    @Test
    public void count13() {
        String stri = "-1/3 * 3/4 - 1/2 * 2/1";
        String stro = "";
        System.out.println("Input: "+stri);
        stro = Main.prepear(stri);
        System.out.println(stro);
        assertEquals("Answer: -5/4",stro);
    }
    @Test
    public void count14() {
        String stri = "-1/3 * 3/4 - 1/2 * 2/1 + 3/4 * 6/2";
        String stro = "";
        System.out.println("Input: "+stri);
        stro = Main.prepear(stri);
        System.out.println(stro);
        assertEquals("Answer: 1/1",stro);
    }
    @Test
    public void count15() {
        String stri = "3/4 - 1/3 * 3/4 - 1/2 * 2/1 + 3/4 * 6/2";
        String stro = "";
        System.out.println("Input: "+stri);
        stro = Main.prepear(stri);
        System.out.println(stro);
        assertEquals("Answer: 7/4",stro);
    }
}