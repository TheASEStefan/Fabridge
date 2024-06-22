package net.fabridge.fabricmc.example;

import net.fabridge.fabricmc.api.ClientModInitializer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author = ASEStefan
 */
public class ExampleClientPacket implements ClientModInitializer {

    /**
     *
     * This is an example class, it needs to be registered where your client setup event is fired.
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
