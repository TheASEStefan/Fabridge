package net.forgeapi.forgemc.example;

import net.forgeapi.forgemc.api.ModInitializer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author = ASEStefan
 */
public class ExamplePacket implements ModInitializer {
    /**
     *
     * This is an example class, it needs to be registered in your mod's main class.
     *
     */

    public static final List<Integer> numbers = new ArrayList<>();
    @Override
    public void onInitialize() {
        numbers.add(0);
        numbers.add(1);
        numbers.add(2);

        // ....

        /**

        for (int i = 3; i <= Integer.MAX_VALUE; i ++)
            numbers.add(i);

         */

    }
}
