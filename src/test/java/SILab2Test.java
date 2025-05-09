import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {
    @Test
    void EveryStatementCriteria(){
        RuntimeException ex;

        ex = assertThrows(RuntimeException.class, () -> SILab2.checkCart(null,null));
        assertTrue(ex.getMessage().contains("allItems list can't be null!"));

        Item item1 = new Item(null,0,0,0);
        ex = assertThrows(RuntimeException.class, () -> SILab2.checkCart(Arrays.asList(item1),null));
        assertTrue(ex.getMessage().contains("Invalid item!"));

        Item item2 = new Item("N",11,0,0);
        ex = assertThrows(RuntimeException.class, () -> SILab2.checkCart(Arrays.asList(item2),null));
        assertTrue(ex.getMessage().contains("Invalid card number!"));

        Item item3 = new Item("N",11,0,0.3);
        ex = assertThrows(RuntimeException.class, () -> SILab2.checkCart(Arrays.asList(item3),null));
        assertTrue(ex.getMessage().contains("Invalid card number!"));

        ex = assertThrows(RuntimeException.class, () -> SILab2.checkCart(Arrays.asList(item3),"12*4123412341234"));
        assertTrue(ex.getMessage().contains("Invalid character in card number!"));

        Item item4 = new Item("N",10,20,0.3);
        assertEquals(110,SILab2.checkCart(Arrays.asList(item4),"1234123412341234"));
    }

    @Test
    void MultipleConditionCriteria(){
        RuntimeException ex;

        Item item1 = new Item("N",0,301,0);
        ex = assertThrows(RuntimeException.class, () -> SILab2.checkCart(Arrays.asList(item1),null));
        assertTrue(ex.getMessage().contains("Invalid card number!"));

        Item item2 = new Item("N",0,0,0.3);
        ex = assertThrows(RuntimeException.class, () -> SILab2.checkCart(Arrays.asList(item2),null));
        assertTrue(ex.getMessage().contains("Invalid card number!"));

        Item item3 = new Item("N",11,0,0);
        ex = assertThrows(RuntimeException.class, () -> SILab2.checkCart(Arrays.asList(item3),null));
        assertTrue(ex.getMessage().contains("Invalid card number!"));

        Item item4 = new Item("N",0,0,0);
        ex = assertThrows(RuntimeException.class, () -> SILab2.checkCart(Arrays.asList(item4),null));
        assertTrue(ex.getMessage().contains("Invalid card number!"));
    }
}