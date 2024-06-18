/*
 * Copyright (c) 2016, 2017, 2018, 2019 FabricMC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.forgeapi.forgemc.keybind;

import com.google.common.collect.Lists;
import it.unimi.dsi.fastutil.objects.ReferenceArrayList;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import org.jline.keymap.KeyMap;

import javax.swing.text.JTextComponent;
import java.util.List;
import java.util.Map;

public final class KeyBindingRegistryImpl {
    private static final List<KeyMapping> MODDED_KEY_BINDINGS = new ReferenceArrayList<>(); // ArrayList with identity based comparisons for contains/remove/indexOf etc., required for correctly handling duplicate keybinds

    private KeyBindingRegistryImpl() {
    }


    public static KeyMapping registerKeyBinding(KeyMapping binding) {
        for (KeyMapping existingKeyBindings : MODDED_KEY_BINDINGS) {
            if (existingKeyBindings == binding) {
                throw new IllegalArgumentException("Attempted to register a key binding twice: " + binding.getTranslatedKeyMessage());
            } else if (existingKeyBindings.getTranslatedKeyMessage().equals(binding.getTranslatedKeyMessage())) {
                throw new IllegalArgumentException("Attempted to register two key bindings with equal ID: " + binding.getTranslatedKeyMessage() + "!");
            }
        }

        MODDED_KEY_BINDINGS.add(binding);
        return binding;
    }

    /**
     * Processes the keybindings array for our modded ones by first removing existing modded keybindings and readding them,
     * we can make sure that there are no duplicates this way.
     */
    public static KeyMapping[] process(KeyMapping[] keysAll) {
        List<KeyMapping> newKeysAll = Lists.newArrayList(keysAll);
        newKeysAll.removeAll(MODDED_KEY_BINDINGS);
        newKeysAll.addAll(MODDED_KEY_BINDINGS);
        return newKeysAll.toArray(new KeyMapping[0]);
    }

    static void onRegisterKeyMappings(RegisterKeyMappingsEvent event) {
        MODDED_KEY_BINDINGS.forEach(event::register);
    }
}
