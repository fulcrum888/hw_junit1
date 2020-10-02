import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestPersonBuilder {
    @Test
    public void testPersonBuilder_negativeAge_trowsException() {
            //given:
        final PersonBuilder original = new PersonBuilder();
        final int argument = -100;

            //expect:
        Assertions.assertThrows(IllegalArgumentException.class, () -> original
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(argument)
                .build());
    }

    @Test
    public void testPersonBuilder_nullName_throwsException() {
            //given:
        final PersonBuilder original = new PersonBuilder()
                .setSurname("Вольф")
                .setAge(31);

            //expect:
        Assertions.assertThrows(IllegalStateException.class, () -> original.build());
    }

    @Test
    public void testPersonBuilder_nullSurname_throwsException() {
            //given:
        final PersonBuilder original = new PersonBuilder()
                .setName("Анна")
                .setAge(31);

            //expect:
        Assertions.assertThrows(IllegalStateException.class, () -> original.build());
    }

    public void testPersonBuilder_nullAge_hasAge() {
            //given:
        final PersonBuilder original = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф");

            //when:
        final boolean result = original.build().hasAge();

            //then:
        Assertions.assertEquals(false, result);
    }
}
