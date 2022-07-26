package org.ripmc.announce.utils;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;

public class ComponentUtils {

    private static final LegacyComponentSerializer legacy = LegacyComponentSerializer.legacyAmpersand();

    public static Component toComponent(String string) { return legacy.deserialize(string); }

}
